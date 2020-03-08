package com.kotlin.provider.router

/*
    模块路由 一级路径每个模块不能相同  二级路径可以相同
 */
object RouterPath {
    //用户模块
    class UserCenter {
        companion object {
            const val PATH_LOGIN = "/userCenter/login"
            const val PATH_USER_ID = "/userCenter/userID"
        }
    }

    //订单模块
    class OrderCenter {
        companion object {
            const val PATH_ORDER_CONFIRM = "/orderCenter/confirm"
        }
    }

    //用户ID模块
    class UserID {
        companion object {
            const val PATH_USER_ID = "/paySDK/user_ID"
        }
    }

}
