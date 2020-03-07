package com.kotlin.usercenter.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import com.kotlin.baselibrary.ext.OnClick
import com.kotlin.baselibrary.ui.activity.BaseMvpActivity
import com.kotlin.usercenter.R
import com.kotlin.usercenter.presenter.RegisterPresenter
import com.kotlin.usercenter.presenter.view.RegisterView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_register.*
import kotlin.math.log

/**
 * <注册界面>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2019-12-11]
 */

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mPresenter = RegisterPresenter()
        mPresenter.mView = this
        mRegisterBtn.OnClick(object :View.OnClickListener{
            override fun onClick(v: View?) {
                mPresenter.register(mMobileEt.text.toString()
                        , mVerifyCodeEt.text.toString()
                        , mPwdEt.text.toString())
            }
        })

    }

    override fun onRegisterResult(result: Boolean) {
    }
}