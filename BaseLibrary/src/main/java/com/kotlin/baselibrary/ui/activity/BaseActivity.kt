package com.kotlin.baselibrary.ui.activity

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.View
import com.kotlin.baselibrary.common.AppManager

/**
 * <类说明 必填>
 *
 * @author tianyejun
 * @version [版本号]
 * @see [参考资料]
 *
 * @since [历史 创建日期:2020/3/7]
</类说明> */
open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }

}