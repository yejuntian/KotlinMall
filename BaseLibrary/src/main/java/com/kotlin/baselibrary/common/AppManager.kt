package com.kotlin.baselibrary.common

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * <Activity管理器>
 *
 * @author  tianyejun
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:2020/3/7]
 */
class AppManager private constructor() {
    private val activityManager: Stack<Activity> = Stack<Activity>()

    companion object {
        val instance: AppManager by lazy {
            AppManager()
        }
    }

    /**
     * 入栈
     */
    fun addActivity(activity: Activity?) {
        activityManager.add(activity)
    }

    /**
     * 出栈
     */
    fun finishActivity(activity: Activity?) {
        activity?.finish()
        activityManager.remove(activity)
    }

    /**
     * 获取栈顶Activity
     */
    fun currentActivity(): Activity {
        return activityManager.lastElement()

    }

    /**
     * 清理栈
     */
    fun finishAllActivity() {
        for (activity in activityManager) {
            activity?.finish()
        }
        activityManager.clear()
    }

    @SuppressLint("MissingPermission")
    fun exitAcitivity(context: Context?) {
        finishAllActivity()
        (context?.getSystemService(Context.ACTIVITY_SERVICE)
                as ActivityManager).apply {
            killBackgroundProcesses(context.packageName)
        }
        System.exit(0)
    }
}