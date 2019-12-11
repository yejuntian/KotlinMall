package com.kotlin.usercenter.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.kotlin.usercenter.R
import kotlinx.android.synthetic.main.activity_register.*

/**
 * <注册界面>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2019-12-11]
 */

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mRegisterBtn.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show();
        })
    }
}