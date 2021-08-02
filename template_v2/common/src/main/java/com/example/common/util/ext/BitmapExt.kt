package com.example.common.util.ext

import android.graphics.Bitmap
import android.graphics.Matrix
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.io.IOException

/**
 *  Convert bitmap into Base64 string.
 *
 *  @param quality Compress quality of the bitmap, value must between 0 and 100.
 *
 *  @return Bitmap in Base64 string format.
 */
fun Bitmap.toBase64(quality: Int = 80): String {
    if (quality < 0 || quality > 100) {
        throw IllegalArgumentException("quality must between 0 and 100")
    }
    var result = ""
    val baos = ByteArrayOutputStream()
    try {
        compress(Bitmap.CompressFormat.JPEG, quality, baos)
        baos.flush()
        baos.close()
        val bitmapBytes = baos.toByteArray()
        result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT)
    } catch (e: IOException) {
        e.printStackTrace()
    } finally {
        try {
            baos.flush()
            baos.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    return result
}

/**
 *  Resize bitmap into desire size.
 *
 *  @param w New width of bitmap.
 *  @param h New height of bitmap.
 *
 *  @return New bitmap with new size.
 */
fun Bitmap.resize(w: Number, h: Number): Bitmap {
    val width = this.width
    val height = this.height
    val scaleWidth = w.toFloat() / width
    val scaleHeight = h.toFloat() / height
    val matrix = Matrix()
    matrix.postScale(scaleWidth, scaleHeight)
    if (width > 0 && height > 0) {
        return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
    }
    return this
}