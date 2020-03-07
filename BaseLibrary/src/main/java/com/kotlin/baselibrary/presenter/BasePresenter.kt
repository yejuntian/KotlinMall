package com.kotlin.baselibrary.presenter

import android.content.Context
import com.kotlin.baselibrary.presenter.view.BaseView
import java.lang.ref.WeakReference

/**
 * <类说明 必填>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2019-12-12]
 */
open class BasePresenter<T : BaseView> : MvpPresenter<T> {
    private var weakContext: WeakReference<Context>? = null
    private lateinit var weakView: WeakReference<T>

    constructor(context: Context) {
        weakContext = WeakReference(context)
    }

    constructor(context: Context, view: T?) {
        weakContext = WeakReference(context)
        weakView = WeakReference<T>(view)
    }

    open fun getContext(): Context? {
        return weakContext?.get()
    }

    open fun getView(): T? {
        return if (weakView != null && weakView!!.get() != null) {
            weakView!!.get()
        } else null
    }

    /**
     * 用于检查View是否为空对象
     *
     * @return
     */
    open fun isAttachView(): Boolean {
        return weakView != null && weakView!!.get() != null
    }

    override fun attachView(view: T) {
        weakView = WeakReference<T>(view)
    }

    override fun dettachView() {
        if (weakView != null) {
            weakView.clear()
        }
    }


}