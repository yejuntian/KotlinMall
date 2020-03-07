package com.kotlin.baselibrary.rx

import com.kotlin.baselibrary.data.protocol.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * <类说明 必填>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2020/3/7]
 */
class BaseFuctionBoolean<T> : Function<BaseResp<T>, Observable<T>> {
    override fun apply(t: BaseResp<T>): Observable<T> {
        return Observable.just(t.data)
    }
}