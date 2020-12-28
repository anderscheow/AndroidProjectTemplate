package com.easipos.template.models

import androidx.annotation.NonNull
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.github.anderscheow.library.paging.remoteWithLocal.PagingModel
import java.util.*

@Entity
data class Notification(
    @PrimaryKey
    @NonNull
    val id: Long,
    val type: Int,
    val title: String,
    val body: String,
    val additionalInfo: String,
    val isRead: Boolean,
    val createdAt: String
) : PagingModel() {

    companion object {

        var DIFF_CALLBACK: DiffUtil.ItemCallback<Notification> = object : DiffUtil.ItemCallback<Notification>() {
            override fun areItemsTheSame(oldItem: Notification, newItem: Notification): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Notification, newItem: Notification): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        (other as? Notification)?.let {
            return id == other.id &&
                    type == other.type &&
                    title == other.title &&
                    body == other.body &&
                    additionalInfo == other.additionalInfo &&
                    isRead == other.isRead &&
                    createdAt == other.createdAt
        }
        return false
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

//    fun formatCreatedAt(context: Context): String {
//        val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(createdAt)
//        val current = Calendar.getInstance().timeInMillis
//        val difference = current - date.time
//
//        return when {
//            difference <= 900000 -> {
//                // Within 15 mins
//                context.getString(R.string.label_just_now)
//            }
//
//            difference <= 1800000 -> {
//                // Within 30 mins
//                context.getString(R.string.label_minutes_ago, 30)
//            }
//
//            difference <= 2700000 -> {
//                // Within 45 mins
//                context.getString(R.string.label_minutes_ago, 45)
//            }
//
//            difference <= 3600000 -> {
//                // Within 60 mins
//                context.getString(R.string.label_hour_ago, 1)
//            }
//
//            difference > 3600000 && checkWithinSameDay(date.time) -> {
//                return date.time.formatDate("h:mm a")
//            }
//
//            else -> {
//                date.time.formatDate("dd . MM . yyyy")
//            }
//        }
//    }

    private fun checkWithinSameDay(createdDate: Long): Boolean {
        val created = Calendar.getInstance().apply {
            this.timeInMillis = createdDate
        }

        val current = Calendar.getInstance()

        return created.get(Calendar.YEAR) == current.get(Calendar.YEAR) &&
                created.get(Calendar.DAY_OF_YEAR) == current.get(Calendar.DAY_OF_YEAR)
    }
}