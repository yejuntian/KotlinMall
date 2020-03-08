package com.kotlin.goods.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.kotlin.baselibrary.ui.activity.BaseActivity
import com.kotlin.goodscenter.R

/*
    购物车Activity
    只是Fragment一个壳
 */
@Route(path = "/goods/cart_activity")
class CartActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods)

    }
}
