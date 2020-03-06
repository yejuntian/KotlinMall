package com.kotlin.usercenter.service.impl

import com.kotlin.baselibrary.data.protocol.BaseResp
import com.kotlin.baselibrary.ext.BaseException
import com.kotlin.usercenter.data.repository.UserRepository
import com.kotlin.usercenter.service.UserService
import io.reactivex.Observable
import io.reactivex.functions.Function
import java.lang.Exception

/**
 * <具体实现调用细节>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2020/3/6]
 */
class UserServiceImpl : UserService {
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        val repository = UserRepository();
        return repository.register(mobile, pwd, verifyCode)
                .flatMap(object : Function<BaseResp<String>, Observable<Boolean>> {
                    override fun apply(t: BaseResp<String>): Observable<Boolean> {
                        return Observable.just(true)
                    }

                })
    }
}