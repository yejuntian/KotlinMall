package com.kotlin.baselibrary.presenter.view

/**
 * <类说明 必填>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2019-12-12]
 */
open interface BaseView {
    fun showLoading();
    fun hideLoading();
    fun onError();
}