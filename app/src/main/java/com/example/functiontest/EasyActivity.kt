package com.example.functiontest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_easy.*
import org.jetbrains.anko.toast
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.PermissionRequest

//没写完
class EasyActivity : AppCompatActivity(),EasyPermissions.PermissionCallbacks {
    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {


    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        when(requestCode){

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy)
        get_permissions.setOnClickListener {

        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults,this)
    }
}
