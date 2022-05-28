package com.example.mychat

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.spuntil.SimpleSpStringBuilder

/**
 * 直播间评论内容View
 */
class ChatContentView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : RelativeLayout(context, attrs, defStyle) {

    init {
        LayoutInflater.from(context).inflate(R.layout.chat_content_layout, this, true)
    }

    fun addText(chatMsg: ChatMessage) {
        val stringBuilder = SimpleSpStringBuilder(context)
            .create()
            .setText(text = chatMsg.userName, textColorStr = "#A4A9B3")
            .setText(text = chatMsg.userContent, textColorStr = "#181E25")
            .setImage(drawable = chatMsg.userLabel?.get(0),marginStart=6,marginTop=2, width = 20, height = 20)
            .builder()

        val textView = findViewById<TextView>(R.id.contentView)
        textView.text = stringBuilder
    }

//    fun addText(chatMsg: ChatMessage) {
//        val stringBuilder = SpannableStringBuilder()
//        var pos = 0
//        //添加用户名
//        var length =  chatMsg.userName?.length ?: 0
//        val nameColorSpan= ForegroundColorSpan(Color.parseColor("#A4A9B3"))
//        stringBuilder.append(chatMsg.userName)
//        stringBuilder.setSpan(nameColorSpan, pos, pos + length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//        pos+=length
//
//        ViewGroup.LayoutParams.MATCH_PARENT
//
//        //添加图片
//        chatMsg.userLabel?.forEach { d ->
//            val iconWidth = (d.intrinsicWidth / d.intrinsicHeight) * 12
//            d.setBounds(dp2px(4), 0, dp2px(iconWidth + 4), dp2px(12))
//            val imageSpan = ImageSpan(d, ImageSpan.ALIGN_BASELINE)
//            stringBuilder.append(" ")
//            stringBuilder.setSpan(imageSpan, pos, pos + 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
//            pos++
//        }
//
//        //添加内容
//        length =  chatMsg.userContent?.length ?: 0
//        val contentColorSpan= ForegroundColorSpan(Color.parseColor("#181E25"))
//        stringBuilder.append(chatMsg.userContent)
//        stringBuilder.setSpan(contentColorSpan,pos, pos+length,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//
//        val textView =findViewById<TextView>(R.id.contentView)
//        textView.text = stringBuilder
//    }
//
//    private fun dp2px(dp: Int): Int {
//        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), resources.displayMetrics).toInt()
//    }

}