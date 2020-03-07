package com.kotlin.baselibrary.rx

import com.kotlin.baselibrary.data.protocol.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
/* 通用数据类型转换封装
*/
 * @since [历史 创建日期:2020/3/7]
</类说明> */
class BaseFunc<T> : Function<BaseResp<T>, Observable<Boolean>> {
    override fun apply(t: BaseResp<T>): Observable<Boolean> {
        if (t.status != 0) {
            return Observable.error(BaseException(t.status, t.message))
        }
        return Observable.just(true)
    }

}