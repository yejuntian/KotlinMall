package com.kotlin.baselibrary.ui.activity

import android.support.v7.app.AppCompatActivity
import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.baselibrary.presenter.view.BaseView

/**
 * <类说明 必填>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2019-12-12]
 */
open class BaseMvpActivity<T : BasePresenter<*>> : AppCompatActivity(), BaseView {
    protected lateinit var mPresenter: T;
    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError() {
    }

}