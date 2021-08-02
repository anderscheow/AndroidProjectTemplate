package com.example.common.util

import android.content.ContentUris
import android.content.Context
import android.content.res.AssetManager
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.ParcelFileDescriptor
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.webkit.MimeTypeMap
import androidx.exifinterface.media.ExifInterface
import java.io.*
import java.net.URLConnection
import java.util.*

object FileUtil {

    fun deleteDir(dir: File?): Boolean {
        if (dir == null) {
            return false
        }
        if (dir.isDirectory.not()) {
            return false
        }
        dir.listFiles()?.forEach { file ->
            if (file.isFile) {
                file.delete()
            } else if (file.isDirectory) {
                deleteDir(file)
            }
        }
        return true
    }

    fun copyAssets(assets: AssetManager, path: String, rootDir: String) {
        if (isAssetsDir(assets, path)) {
            assets.list(path)?.forEach { s ->
                copyAssets(assets, "$path/$s", rootDir)
            }
        } else {
            val input = assets.open(path)
            val dest = File(rootDir, path)
            copyToFileOrThrow(input, dest)
        }
    }

    fun getMimeTypeByFile(file: File): String {
        var result = getMimeTypeByUrl(file.absolutePath)
        if (result != null) {
            return result
        }
        val option = getPicsWHByFile(file.path)
        return if (option.outMimeType != null) {
            option.outMimeType
        } else {
            result = getMimeType(file.path)
            if (result.isNullOrEmpty()) {
                result = getMimeTypeByFileName(file.name)
            }
            result ?: "file/*"
        }
    }

    fun getMimeTypeByUrl(url: String?): String? {
        var extension = url ?: ""
        val lastDot = extension.lastIndexOf('.')
        if (lastDot != -1) {
            extension = extension.substring(lastDot + 1)
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)
    }

    fun getMimeType(filePath: String): String {
        val file = File(filePath)
        val suffix = getSuffix(file) ?: return "file/*"
        val type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(suffix)
        return if (type != null && type.isNotEmpty()) {
            type
        } else "file/*"
    }

    fun getPicsWHByFile(filePath: String?): BitmapFactory.Options {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeFile(filePath, options) // 此时返回的bitmap为null
        try {
            val exifInterface = ExifInterface(filePath!!)
            val orientation = exifInterface.getAttributeInt(
                ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_UNDEFINED
            )
            if (orientation == ExifInterface.ORIENTATION_ROTATE_90 ||
                orientation == ExifInterface.ORIENTATION_ROTATE_270
            ) {
                val h = options.outWidth
                options.outWidth = options.outHeight
                options.outHeight = h
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return options
    }

    fun getSuffix(file: File?): String? {
        if (file == null || file.exists().not() || file.isDirectory) {
            return null
        }
        val fileName = file.name
        if (fileName == "" || fileName.endsWith(".")) {
            return null
        }
        val index = fileName.lastIndexOf(".")
        return if (index != -1) {
            fileName.substring(index + 1).lowercase(Locale.US)
        } else {
            null
        }
    }

    fun getMimeTypeByFileName(fileName: String?): String? {
        return URLConnection.guessContentTypeFromName(fileName)
    }

    fun getAbsoluteFile(context: Context, path: String): File? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && path.contains("content:/")) {
            var descriptor: ParcelFileDescriptor? = null
            try {
                descriptor = context.contentResolver.openFile(Uri.parse(path), "r", null)
                if (descriptor != null) {
                    val inputStream = FileInputStream(descriptor.fileDescriptor)
                    val byteArray = readBinaryStream(inputStream, descriptor.statSize.toInt())
                    val split = path.split("/")
                    if (split.isNotEmpty()) {
                        val cachedFile = File(context.cacheDir, split[split.size - 1])
                        val fileSaved = writeFile(cachedFile, byteArray)
                        return if (fileSaved) {
                            cachedFile
                        } else {
                            null
                        }
                    }
                }
            } catch (e: FileNotFoundException) {
                return null
            } finally {
                if (descriptor != null) {
                    try {
                        descriptor.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        }

        return File(path)
    }

    fun saveBitmapToFile(context: Context, bitmap: Bitmap, name: String): String? {
        return saveBitmapToCacheFile(context, bitmap, name, false)
    }

    fun saveBitmapToCacheFile(
        context: Context,
        bitmap: Bitmap,
        name: String,
        isExternalCache: Boolean
    ): String? {
        val fileDir = getCacheFile(context, isExternalCache)?.absolutePath
        val file = File(fileDir, name)
        return try {
            val out = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
            out.close()
            file.absolutePath
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun getCacheFile(context: Context, isExternalCache: Boolean): File? {
        return if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED && isExternalCache) {
            var file = context.externalCacheDir
            if (file == null) {
                file = File(getCacheFilePath(context))
                if (file.exists().not()) {
                    file.mkdirs()
                }
            }
            file
        } else {
            context.cacheDir
        }
    }

    fun getCacheFilePath(context: Context): String {
        return "${context.getExternalFilesDir(null)?.path}${context.packageName}"
    }

    fun getPathFromUri(context: Context, uri: Uri): String? {
        // DocumentProvider
        if (DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                val docId = DocumentsContract.getDocumentId(uri)
                val split = docId.split(":".toRegex()).toTypedArray()
                val type = split[0]
                if ("primary".equals(type, ignoreCase = true)) {
                    return context.getExternalFilesDir(null).toString() + "/" + split[1]
                }
            } else if (isDownloadsDocument(uri)) {
                val id = DocumentsContract.getDocumentId(uri)
                val contentUri = ContentUris.withAppendedId(
                    Uri.parse("content://downloads/public_downloads"),
                    id.toLong()
                )
                return getDataColumn(
                    context,
                    contentUri,
                    null,
                    null
                )
            } else if (isMediaDocument(uri)) {
                val docId = DocumentsContract.getDocumentId(uri)
                val split = docId.split(":".toRegex()).toTypedArray()
                val type = split[0]
                var contentUri: Uri? = null
                when (type) {
                    "image" -> {
                        contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                    }
                    "video" -> {
                        contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
                    }
                    "audio" -> {
                        contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                    }
                }
                val selection = "_id=?"
                val selectionArgs = arrayOf(split[1])
                return getDataColumn(
                    context,
                    contentUri,
                    selection,
                    selectionArgs
                )
            }
        } else if ("content".equals(uri.scheme, ignoreCase = true)) {
            // Return the remote address
            return if (isGooglePhotosUri(uri)) uri.lastPathSegment else getDataColumn(
                context,
                uri,
                null,
                null
            )
        } else if ("file".equals(uri.scheme, ignoreCase = true)) {
            return uri.path
        }
        return null
    }

    fun getDataColumn(
        context: Context,
        uri: Uri?,
        selection: String?,
        selectionArgs: Array<String>?
    ): String? {
        if (uri == null) {
            return null
        }
        var cursor: Cursor? = null
        val column = "_data"
        val projection = arrayOf(column)
        try {
            cursor =
                context.contentResolver.query(uri, projection, selection, selectionArgs, null)
            if (cursor != null && cursor.moveToFirst()) {
                val index = cursor.getColumnIndexOrThrow(column)
                return cursor.getString(index)
            }
        } catch (ignored: Exception) {
            return null
        } finally {
            cursor?.close()
        }
        return null
    }

    fun isExternalStorageDocument(uri: Uri): Boolean {
        return "com.android.externalstorage.documents" == uri.authority
    }

    fun isDownloadsDocument(uri: Uri): Boolean {
        return "com.android.providers.downloads.documents" == uri.authority
    }

    fun isMediaDocument(uri: Uri): Boolean {
        return "com.android.providers.media.documents" == uri.authority
    }

    fun isGooglePhotosUri(uri: Uri): Boolean {
        return "com.google.android.apps.photos.content" == uri.authority
    }

    fun isGoogleNewPhotosUri(uri: Uri): Boolean {
        return "com.google.android.apps.photos.contentprovider" == uri.authority
    }

    fun writeStreamToFile(input: InputStream, file: File) {
        try {
            FileOutputStream(file).use { output ->
                val buffer = ByteArray(4 * 1024) // or other buffer size
                var read: Int
                while (input.read(buffer).also { read = it } != -1) {
                    output.write(buffer, 0, read)
                }
                output.flush()
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                input.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun isAssetsDir(assets: AssetManager, path: String): Boolean {
        try {
            val files = assets.list(path)
            return files != null && files.isNotEmpty()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return false
    }

    private fun copyToFileOrThrow(inputStream: InputStream, destFile: File) {
        if (destFile.exists()) {
            return
        }
        val file = destFile.parentFile
        if (file != null && file.exists().not()) {
            file.mkdirs()
        }
        val out = FileOutputStream(destFile)
        try {
            val buffer = ByteArray(4096)
            var bytesRead: Int
            while (inputStream.read(buffer).also { bytesRead = it } >= 0) {
                out.write(buffer, 0, bytesRead)
            }
        } finally {
            out.flush()
            try {
                out.fd.sync()
            } catch (e: IOException) {
            }
            out.close()
        }
    }

    private fun readBinaryStream(
        stream: InputStream,
        byteCount: Int
    ): ByteArray {
        val output = ByteArrayOutputStream()
        try {
            val buffer = ByteArray(if (byteCount > 0) byteCount else 4096)
            var read: Int
            while (stream.read(buffer).also { read = it } >= 0) {
                output.write(buffer, 0, read)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                stream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return output.toByteArray()
    }

    private fun writeFile(cachedFile: File, data: ByteArray): Boolean {
        return try {
            var output: BufferedOutputStream? = null
            try {
                output = BufferedOutputStream(FileOutputStream(cachedFile))
                output.write(data)
                output.flush()
                true
            } finally {
                output?.close()
            }
        } catch (ex: Exception) {
            false
        }
    }
}