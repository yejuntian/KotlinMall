package com.kotlin.usercenter.service.impl

import com.kotlin.baselibrary.ext.convert
import com.kotlin.goods.data.protocol.Category
import com.kotlin.usercenter.data.repository.CategoryRepository
import com.kotlin.usercenter.service.CategoryService
import io.reactivex.Observable

/**
 * <具体实现调用细节>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2020/3/6]
 */
class CategoryServiceImpl : CategoryService {
    private val repository by lazy {
        CategoryRepository()
    }

    override fun getCategory(parentId: Int): Observable<MutableList<Category>?> {
        return repository.getCategory(parentId).convert()
    }


}