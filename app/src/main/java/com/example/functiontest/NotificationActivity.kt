package com.example.functiontest

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.widget.RemoteViews
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bing.com"))
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("001", "my_channel", NotificationManager.IMPORTANCE_DEFAULT)
            channel.enableLights(true)//是否在桌面icon右上角展示小红点
            channel.lightColor = Color.GREEN//小红点颜色
            channel.setShowBadge(true)//是否在久按桌面图标时显示此渠道的通知
            notificationManager.createNotificationChannel(channel)
        }


        notification_1.setOnClickListener {
            val builder = NotificationCompat.Builder(this, "default")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setAutoCancel(true)
                .setContentTitle("普通通知")
                .setChannelId("001")
            val notification = builder.build()
            notificationManager.notify(1, notification)
        }

        notification_2.setOnClickListener {
            val remoteViews = RemoteViews(packageName, R.layout.view_fold)
            val builder = NotificationCompat.Builder(this, "default")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setAutoCancel(true)
                .setContentTitle("折叠通知")
                .setCustomBigContentView(remoteViews)
                .setChannelId("001")
            val notification = builder.build()
            notificationManager.notify(2, notification)
        }

        //该功能实现不成功
        notification_3.setOnClickListener {
            //设置点击跳转
            val hangIntent = Intent()
            hangIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            hangIntent.setClass(this, NotificationActivity::class.java)
            val hangPendingIntent =
                PendingIntent.getActivity(this, 0, hangIntent, PendingIntent.FLAG_CANCEL_CURRENT)

            val builder = NotificationCompat.Builder(this, "default")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setAutoCancel(true)
                .setContentTitle("悬挂通知")
                .setChannelId("001")
                .setFullScreenIntent(hangPendingIntent, true)
            val notification = builder.build()

            notificationManager.notify(3, notification)
        }


    }
}
