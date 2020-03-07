package com.kotlin.usercenter.service

import com.kotlin.user.data.protocol.UserInfo
import io.reactivex.Observable

/**
 * <类说明 必填>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2020/3/6]
 */
interface UserService {
    //用户注册
    fun register(mobile:String,pwd:String,verifyCode:String):Observable<String>

    //用户登录
    fun login(mobile:String,pwd:String,pushId:String):Observable<UserInfo>

    //忘记密码
    fun forgetPwd(mobile:String,verifyCode:String):Observable<Boolean>

    //重置密码
    fun resetPwd(mobile:String,pwd:String):Observable<Boolean>

    //编辑用户资料
    fun editUser(userIcon:String,userName:String,userGender:String,userSign:String):Observable<UserInfo>
}