package com.kotlin.usercenter.service.impl

import com.kotlin.baselibrary.ext.convert
import com.kotlin.baselibrary.ext.convertBoolean
import com.kotlin.baselibrary.rx.BaseFuctionBoolean
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.usercenter.data.repository.UserRepository
import com.kotlin.usercenter.service.UserService
import io.reactivex.Observable

/**
 * <具体实现调用细节>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2020/3/6]
 */
class UserServiceImpl : UserService {
    private val repository by lazy {
        UserRepository()
    }

    /*
      注册
   */
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<String> {
        return repository.register(mobile, pwd, verifyCode)
                .flatMap(BaseFuctionBoolean<String>())
    }

    /*
        登录
     */
    override fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo> {
        return repository.login(mobile, pwd, pushId).convert()
    }

    /*
        忘记密码
     */
    override fun forgetPwd(mobile: String, verifyCode: String): Observable<Boolean> {
        return repository.forgetPwd(mobile, verifyCode).convertBoolean()
    }

    /*
        重置密码
     */
    override fun resetPwd(mobile: String, pwd: String): Observable<Boolean> {
        return repository.resetPwd(mobile, pwd).convertBoolean()
    }

    /*
        修改用户资料
     */
    override fun editUser(userIcon: String, userName: String, userGender: String, userSign: String): Observable<UserInfo> {
        return repository.editUser(userIcon, userName, userGender, userSign).convert()
    }
}