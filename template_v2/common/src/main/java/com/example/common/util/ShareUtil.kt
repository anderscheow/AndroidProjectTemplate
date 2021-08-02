package com.example.common.util

import android.content.Context
import android.content.Intent
import android.net.Uri

object ShareUtil {

    fun shareAsText(context: Context, text: String, subject: String?) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            this.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            this.putExtra(Intent.EXTRA_TEXT, text)
            if (subject != null) {
                this.putExtra(Intent.EXTRA_SUBJECT, subject)
            }
        }

        startIntentChooser(context, intent)
    }

    fun shareAsMedia(
        context: Context,
        text: String?,
        subject: String?,
        uri: Uri,
        mimeType: String
    ) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            this.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            this.type = mimeType
            this.putExtra(Intent.EXTRA_STREAM, uri)
            if (text != null) {
                this.putExtra(Intent.EXTRA_TEXT, subject)
            }
            if (subject != null) {
                this.putExtra(Intent.EXTRA_SUBJECT, subject)
            }
        }.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

        startIntentChooser(context, intent)
    }

    private fun startIntentChooser(context: Context, intent: Intent) {
        context.startActivity(
            Intent.createChooser(
                intent,
                "Share"
            )
        )
    }
}