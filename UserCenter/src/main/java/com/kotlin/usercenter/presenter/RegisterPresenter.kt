package com.kotlin.usercenter.presenter

import com.kotlin.baselibrary.ext.execute
import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.baselibrary.rx.BaseSubscriber
import com.kotlin.usercenter.presenter.view.RegisterView
import com.kotlin.usercenter.service.UserService
import com.kotlin.usercenter.service.impl.UserServiceImpl

/**
 * <类说明 必填>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2019-12-12]
 */
class RegisterPresenter : BasePresenter<RegisterView>() {
    /**
     * 业务逻辑
     */
    val userService: UserService = UserServiceImpl()

    fun register(mobile: String, verifyCode: String, pwd: String) {
        userService.register(mobile, verifyCode, pwd).execute(object : BaseSubscriber<Boolean>() {
            override fun onNext(t: Boolean) {
                mView.onRegisterResult(t)
            }
        })

    }
}