package com.example.functiontest

import com.chad.library.adapter.base.BaseQuickAdapter

import com.chad.library.adapter.base.BaseViewHolder

data class HomeItem(var text:String)

class HomeAdapter(layoutResId: Int, data: List<HomeItem>) :
    BaseQuickAdapter<HomeItem, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder?, item: HomeItem?) {
        helper?.setText(R.id.text, item?.text)
    }
}