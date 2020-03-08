package com.kotlin.goods.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.baselibrary.ui.activity.BaseActivity
import com.kotlin.goodscenter.R
import com.kotlin.provider.CardProvider
import com.kotlin.provider.router.RouterPath
import kotlinx.android.synthetic.main.activity_goods.*

/*
    购物车Activity
    只是Fragment一个壳
 */
@Route(path = RouterPath.OrderCenter.PATH_ORDER_CONFIRM)
class CartActivity : BaseActivity(), View.OnClickListener {
    @Autowired(name = "name")
    @JvmField
    var path: String? = null
    @Autowired(name = "age")
    @JvmField
    var age: Int = 0

    @Autowired(name = RouterPath.UserCenter.PATH_USER_ID)
    @JvmField
    var mCardProvider: CardProvider? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods)
        ARouter.getInstance().inject(this)
        Log.e("test", "path = ${path} age = ${age}")

        btn_cardId.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_cardId -> {
                edit_cardID.setText(mCardProvider?.getUserId())
            }
        }
    }
}
