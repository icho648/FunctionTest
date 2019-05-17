package com.example.functiontest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import permissions.dispatcher.RuntimePermissions
import permissions.dispatcher.NeedsPermission
import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import kotlinx.android.synthetic.main.activity_permissions.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.makeCall
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton
import permissions.dispatcher.PermissionRequest
import permissions.dispatcher.OnShowRationale
import permissions.dispatcher.OnPermissionDenied
import permissions.dispatcher.OnNeverAskAgain
//该功能实现不成功，尝试用easyPermission实现
//原方案实现成功，记得在AndroidManifest里面添加所需功能
@RuntimePermissions
class PermissionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)
        call_button.setOnClickListener { callWithPermissionCheck()}
    }

    @NeedsPermission(Manifest.permission.CALL_PHONE)
    fun call() {
      /*  val intent= Intent(Intent.ACTION_CALL)
        val data= Uri.parse("tel:"+"10086")
        intent.data = data
        try {
            startActivity(intent)
        }catch(e:Exception){
            e.printStackTrace()
        }*/
        makeCall("10086")
    }

    @SuppressLint("NeedOnRequestPermissionsResult")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode, grantResults)
    }

    @OnShowRationale(Manifest.permission.CALL_PHONE)
     fun showWhy(request: PermissionRequest) {
        alert ("请求拨打电话"){ yesButton { request.proceed() } }.show()
    }

    @OnPermissionDenied(Manifest.permission.CALL_PHONE)
     fun showDenied() {
        toast("用户选择拒绝时的提示")
    }

    @OnNeverAskAgain(Manifest.permission.CALL_PHONE)
     fun showNotAsk() {
        alert("不在询问后的提示").show()
    }
}
