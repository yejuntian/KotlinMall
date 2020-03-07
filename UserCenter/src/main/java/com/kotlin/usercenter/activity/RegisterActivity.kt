package com.kotlin.usercenter.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kotlin.baselibrary.common.AppManager
import com.kotlin.baselibrary.ext.OnClick
import com.kotlin.baselibrary.ext.enable
import com.kotlin.baselibrary.ui.activity.BaseMvpActivity
import com.kotlin.usercenter.R
import com.kotlin.usercenter.presenter.RegisterPresenter
import com.kotlin.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*

/**
 * <注册界面>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2019-12-11]
 */

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {
    private var pressTime: Long = System.currentTimeMillis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mPresenter = RegisterPresenter(this, this)
        mRegisterBtn.OnClick(object : View.OnClickListener {
            override fun onClick(v: View?) {
                mPresenter.register(mMobileEt.text.toString()
                        , mVerifyCodeEt.text.toString()
                        , mPwdEt.text.toString())
            }
        })

        //使用拓展的Btn表达式
        mRegisterBtn.enable(mVerifyCodeEt, { isBtnEnable() })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val currentTimeMillis = System.currentTimeMillis()
        if (currentTimeMillis - pressTime > 2000) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_LONG).show()
            pressTime = currentTimeMillis
        } else {
            AppManager.instance.exitAcitivity(this)
        }
    }

    override fun onRegisterResult(result: String) {

    }

    /*
       判断按钮是否可用
    */
    private fun isBtnEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()&&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }
}