package com.kotlin.usercenter.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.baselibrary.ext.onClick
import com.kotlin.provider.CardProvider
import com.kotlin.provider.router.RouterPath
import com.kotlin.usercenter.R
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
class MeFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_me_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
    }

    private fun initListener() {
        btn_jump.onClick(View.OnClickListener {
            ARouter.getInstance().build(RouterPath.OrderCenter.PATH_ORDER_CONFIRM)
                    .withString("name", "MeFragment")
                    .withInt("age", 1)
                    .navigation()
        })


    }

    override fun onClick(v: View?) {

    }


}