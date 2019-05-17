package com.example.functiontest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import permissions.dispatcher.RuntimePermissions
import permissions.dispatcher.NeedsPermission
import android.Manifest
import android.annotation.SuppressLint
import permissions.dispatcher.PermissionRequest
import permissions.dispatcher.OnShowRationale


class ToolBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tool_bar)
    }



}
