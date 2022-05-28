package com.example.mychat

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            mockData1()
            mockData2()
            mockData3()
    }

    private fun mockData1(){
        val list = mutableListOf<Drawable>()
        val drawable1 = this.getDrawable(R.drawable.chat_user_icon_1)
        val drawable2 = getDrawable()
        drawable1?.let {
            list.add(it)
        }
        drawable2.let {
            list.add(it)
        }
        val chatMsg = ChatMessage(
            userName = "心爱的小摩托",
            userLabel = list,
            userContent = " ：当前文本是用户发的一段话，可以换行的一段话"
        )
        addChatView(chatMsg)
    }

    private fun mockData2(){
        val list = mutableListOf<Drawable>()
        val drawable1 = this.getDrawable(R.drawable.chat_user_icon_1)
        drawable1?.let {
            list.add(it)
        }
        val chatMsg = ChatMessage(
            userName = "心爱的小摩托",
            userLabel = list,
            userContent = " ：当前文本是用户发的一段话."
        )
        addChatView(chatMsg)
    }

    private fun mockData3(){
        val list = mutableListOf<Drawable>()
        val drawable1 = this.getDrawable(R.drawable.chat_user_icon_1)
        drawable1?.let {
            list.add(it)
        }
        val chatMsg = ChatMessage(
            userName = "心爱的小摩托",
            userLabel = list,
            userContent = " ：当前文本是用户发的一段话，可以换行的一段话,可以换行的一段话,，可以换行的一段话"
        )
        addChatView(chatMsg)
    }

    private  fun addChatView(chatMsg:ChatMessage){
        val contentView= ChatContentView(this);
        contentView.addText(chatMsg)
        findViewById<ViewGroup>(R.id.chatView).addView(contentView)
    }

    private  fun getDrawable():Drawable{
        val view =ViewGroup.inflate(this,R.layout.chat_icon_layout,null)
        val bitmap: Bitmap = createViewBitmap(view)
        return BitmapDrawable(resources, bitmap)
    }

    private fun createViewBitmap(v: View): Bitmap {

        v.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        v.layout(0, 0, v.measuredWidth, v.measuredHeight)

        val bitmap = Bitmap.createBitmap(v.width, v.height, Bitmap.Config.ARGB_8888); //创建一个和View大小一样的Bitmap
        val canvas = Canvas(bitmap);  //使用上面的Bitmap创建canvas
        v.draw(canvas);  //把View画到Bitmap上
        return bitmap;
    }

    private fun mockData4(){
        val list = mutableListOf<Drawable>()
        val chatMsg = ChatMessage(
            userName = "心爱的小摩托",
            userLabel = list,
            userContent = " ：当前文本是用户发的一段话."
        )
        addChatView(chatMsg)
    }

}