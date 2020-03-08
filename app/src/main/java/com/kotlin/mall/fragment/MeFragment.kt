package com.kotlin.mall.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.baselibrary.ext.onClick
import com.kotlin.mall.R
import kotlinx.android.synthetic.main.fragment_me_layout.*

/**
 * <类说明 必填>
 *
 * @author tianyejun
 * @version [版本号]
 * @see [参考资料]
 *
 * @since [历史 创建日期:2020/3/8]
</类说明> */
class MeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_me_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener();
    }

    private fun initListener() {
        btn_jump.onClick(View.OnClickListener {
            ARouter.getInstance().build("/goods/cart_activity")
                    .withString("name", "MeFragment")
                    .withInt("age", 1)
                    .navigation()
        })
    }


}