package com.kotlin.usercenter.service

import com.kotlin.goods.data.protocol.Category
import io.reactivex.Observable

/**
 * <类说明 必填>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2020/3/6]
 */
interface CategoryService {
    /*
       获取分类
    */
    fun getCategory(parentId:Int): Observable<MutableList<Category>?>
}