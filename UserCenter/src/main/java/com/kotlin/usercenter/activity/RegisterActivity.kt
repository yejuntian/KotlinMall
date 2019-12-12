package com.kotlin.usercenter.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import com.kotlin.baselibrary.ui.activity.BaseMvpActivity
import com.kotlin.usercenter.R
import com.kotlin.usercenter.presenter.RegisterPresenter
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_register.*

/**
 * <注册界面>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2019-12-11]
 */

class RegisterActivity : BaseMvpActivity<RegisterPresenter>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mRegisterBtn.setOnClickListener(View.OnClickListener {
            val just = Observable.just("1", "2", 3)
            Log.e("test", "just = $just")

        })

    }
}