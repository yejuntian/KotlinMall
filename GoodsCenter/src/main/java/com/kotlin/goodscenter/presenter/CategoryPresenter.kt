package com.kotlin.usercenter.presenter

import android.content.Context
import com.kotlin.baselibrary.ext.execute
import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.baselibrary.rx.BaseSubscriber
import com.kotlin.goods.data.protocol.Category
import com.kotlin.usercenter.presenter.view.CategoryView
import com.kotlin.usercenter.service.CategoryService
import com.kotlin.usercenter.service.impl.CategoryServiceImpl

/**
 * <类说明 必填>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2019-12-12]
 */
class CategoryPresenter(context: Context, view: CategoryView) : BasePresenter<CategoryView>(context, view) {
//    constructor(context: Context, view: RegisterView?) : super(context, view) {}
    /**
     * 业务逻辑
     */
    val categoryService: CategoryService = CategoryServiceImpl()

    fun getCategory(parentId: Int) {
        categoryService.getCategory(parentId).execute(object : BaseSubscriber<MutableList<Category>?>() {
            override fun onNext(t: MutableList<Category>?) {

            }
        })

    }
}