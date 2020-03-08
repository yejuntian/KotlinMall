package com.kotlin.usercenter.provider

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.kotlin.provider.CardProvider
import com.kotlin.provider.router.RouterPath

/**
 * <类说明 必填>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2020/3/8]
 */
@Route(path = RouterPath.UserCenter.PATH_USER_ID)
class CardProviderImpl : CardProvider {
    var context: Context? = null

    //这里实现网络请求
    override fun getUserId(): String {
        return "用户ID:12321321"
    }

    override fun init(context: Context?) {
        this.context = context
    }
}