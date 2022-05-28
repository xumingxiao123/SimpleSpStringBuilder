package com.example.mychat

import android.graphics.drawable.Drawable

/**
 * 聊天信息
 */
data class ChatMessage(
    //用户名称
    var userName: String? = null,

    //用户标签
    var userLabel: List<Drawable>? = null,

    //用户评论
    var userContent: String? = null
)




