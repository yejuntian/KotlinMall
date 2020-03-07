package com.kotlin.usercenter.presenter.view

import com.kotlin.baselibrary.presenter.view.BaseView

/**
 * <类说明 必填>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2019-12-12]
 */
interface RegisterView : BaseView {
    fun onRegisterResult(result: String)
}