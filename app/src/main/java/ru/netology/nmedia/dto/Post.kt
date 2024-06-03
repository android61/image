package ru.netology.nmedia.dto

import android.net.Uri
import java.io.File

data class Post(
    val id: Long,
    val author: String,
    val authorAvatar: String,
    val content: String,
    val published: String,
    val likedByMe: Boolean,
    val likes: Int = 0,
    val attachment: Attachment?,
    val show: Boolean = true,
)

data class PhotoModel(val uri: Uri? = null, val file: File? = null)

data class Media(val id: String)
data class Attachment(
    val url: String,
    val description: String,
    val type: AttachmentType,
)

enum class AttachmentType {
    IMAGE
}