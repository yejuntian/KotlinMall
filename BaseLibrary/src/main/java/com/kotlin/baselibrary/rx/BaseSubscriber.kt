package com.kotlin.baselibrary.rx

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * <类说明 必填>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2019-12-12]
 */
open class BaseSubscriber<T> : Observer<T> {
    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable) {
    }

}