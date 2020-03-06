package com.kotlin.usercenter.data.protocol

/**
 * <类说明 必填>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2020/3/6]
 */
data class RegisterReq(val mobile: String, val pwd: String, val verifyCode: String) {
}