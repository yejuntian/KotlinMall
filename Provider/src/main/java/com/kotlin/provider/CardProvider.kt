package com.kotlin.provider

import com.alibaba.android.arouter.facade.template.IProvider

/*
    跨模块接口调用 接口定义
 */
interface CardProvider : IProvider {
    fun getUserId(): String
}
