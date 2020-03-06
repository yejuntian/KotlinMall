package com.kotlin.baselibrary.ext

/**
 * <类说明 必填>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2020/3/6]
 */
class BaseException(val code: Int, val msg: String) : Throwable() {
}