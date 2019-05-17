package com.example.functiontest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        card_view_button.setOnClickListener { startActivity<CardViewActivity>() }
        notification_button.setOnClickListener { startActivity<NotificationActivity>() }
        tool_bar_button.setOnClickListener { startActivity<ToolBarActivity>() }
        permissions_button.setOnClickListener { startActivity<PermissionsActivity>() }
        easy_button.setOnClickListener { startActivity<EasyActivity>() }
    }
}
