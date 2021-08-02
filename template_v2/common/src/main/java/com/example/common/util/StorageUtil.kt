package com.example.common.util

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.*

object StorageUtil {

    private const val SAVE_FILENAME_PREFIX = "Yippi_"

    fun storeImage(
        context: Context,
        bitmap: Bitmap,
        isSaveToCache: Boolean,
        onSuccess: ((Uri) -> Unit)?,
        onError: ((String) -> Unit)?
    ) {
        val imageName = "$SAVE_FILENAME_PREFIX${createFileName()}.png"
        if (isSDCARDMounted().not()) {
            throw Exception("Failed to save")
        }

        val fos: OutputStream?
        var imageFile: File? = null
        var imageUri: Uri? = null

        try {
            when {
                isSaveToCache -> {
                    imageFile = File(
                        context.cacheDir,
                        imageName
                    )

                    fos = FileOutputStream(imageFile)
                }

                Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q -> {
                    val contentValues = ContentValues(3).apply {
                        this.put(MediaStore.MediaColumns.DISPLAY_NAME, imageName)
                        this.put(MediaStore.MediaColumns.MIME_TYPE, "image/png")
                        this.put(
                            MediaStore.MediaColumns.RELATIVE_PATH,
                            Environment.DIRECTORY_PICTURES + File.separator + "Images"
                        )
                    }

                    imageUri = context.contentResolver.insert(
                        MediaStore.Images.Media.getContentUri(
                            MediaStore.VOLUME_EXTERNAL
                        ),
                        contentValues
                    )

                    if (imageUri == null) {
                        throw Exception("Failed to save")
                    }

                    fos = context.contentResolver.openOutputStream(imageUri)
                }

                else -> {
                    val imagesDir = File(
                        context.getExternalFilesDir(
                            Environment.DIRECTORY_PICTURES
                        ).toString() + File.separator + "Yippi Images"
                    )

                    if (imagesDir.exists().not()) {
                        imagesDir.mkdir()
                    }

                    imageFile = File(imagesDir, imageName)

                    fos = FileOutputStream(imageFile)
                }
            }

            if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos).not()) {
                throw Exception("Failed to save")
            }

            fos?.flush()
            fos?.close()

            if (imageFile != null) {
                MediaScannerConnection.scanFile(context, arrayOf(imageFile.toString()), null, null)
                imageUri = FileProvider.getUriForFile(context, context.packageName, imageFile)
            }

            if (imageUri != null) {
                onSuccess?.invoke(imageUri)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            if (imageUri != null) {
                context.contentResolver.delete(imageUri, null, null)
            }
            onError?.invoke(e.message ?: "")
        }
    }

    fun createFileName(): String {
        val date = Date(System.currentTimeMillis())
        val format = SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault())
        return format.format(date)
    }

    fun getFilePath(context: Context): String {
        return "${context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)}" +
                File.separator +
                "Yippi" +
                File.separator +
                "Yippi Images" +
                File.separator
    }

    private fun isSDCARDMounted(): Boolean {
        val status = Environment.getExternalStorageState()
        return status == Environment.MEDIA_MOUNTED
    }
}