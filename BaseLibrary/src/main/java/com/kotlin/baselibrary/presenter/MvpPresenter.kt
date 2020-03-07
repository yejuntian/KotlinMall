package com.kotlin.baselibrary.presenter

import com.kotlin.baselibrary.presenter.view.BaseView

/**
 * <类说明 必填>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2020/3/7]
 */
open interface MvpPresenter<V : BaseView?> {
    /**
     * 绑定视图
     *
     * @param view
     */
    fun attachView(view: V)

    /**
     * 解除绑定
     */
    fun dettachView()
}