package com.example.common.util

import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.security.MessageDigest

object EncryptionUtil {

    private val lexDigits =
        charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')

    fun fileToMD5(file: File): String? {
        var inputStream: InputStream? = null
        return try {
            inputStream = FileInputStream(file)
            val buffer = ByteArray(1024)
            val digest = MessageDigest.getInstance("MD5")
            var numRead = 0
            while (numRead != -1) {
                numRead = inputStream.read(buffer)
                if (numRead > 0) digest.update(buffer, 0, numRead)
            }
            val md5Bytes = digest.digest()
            bytes2HexString(md5Bytes)
        } catch (e: Exception) {
            null
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close()
                } catch (e: Exception) {
                }
            }
        }
    }

    fun bytes2HexString(bytes: ByteArray): String {
        val len = bytes.size
        val ret = CharArray(len shl 1)
        var i = 0
        var j = 0
        while (i < len) {
            ret[j++] = lexDigits[bytes[i].toInt() ushr 4 and 0x0f]
            ret[j++] = lexDigits[bytes[i].toInt() and 0x0f]
            i++
        }
        return String(ret)
    }
}