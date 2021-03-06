package com.kotlin.baselibrary.ext

import android.view.View
import android.widget.Button
import android.widget.EditText
import com.kotlin.base.widgets.DefaultTextWatcher
import com.kotlin.baselibrary.data.protocol.BaseResp
import com.kotlin.baselibrary.rx.BaseFuctionBoolean
import com.kotlin.baselibrary.rx.BaseFunc
import com.kotlin.baselibrary.rx.BaseSubscriber
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>) {
    try {
        return this.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(subscriber)
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

/**
 * 转换数据拓展函数
 * 一共有三个T
 * 1.第一个T：声明泛型T
 * 2.第二个T:泛型输入类型BaseResp<T>
 * 3.第三个T:输出类型T
 */
fun <T> Observable<BaseResp<T>>.convert(): Observable<T> {
    return this.flatMap(BaseFuctionBoolean<T>())
}

/**
 * 支持特定函数
 */
fun <T> Observable<BaseResp<T>>.convertBoolean(): Observable<Boolean> {
    return this.flatMap(BaseFunc())
}

//
/**
 * 使用lamada表达式拓展函数
 *有返回数值的用小括号()，无返回值的用大括号{}
 */
fun View.OnClickListener(method: () -> Unit) {
    setOnClickListener { method() }
}

/*
    扩展点击事件
 */
fun View.onClick(listener: View.OnClickListener): View {
    setOnClickListener(listener)
    return this
}


/*
  *扩展Button可用性
  * 第一个参数：传入数值
  * 第二个参数：方法计算数值
 */
fun Button.enable(et: EditText, method: () -> Boolean) {
    val btn = this
    et.addTextChangedListener(object : DefaultTextWatcher() {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })
}




