package com.kotlin.baselibrary.data.net

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * <类说明 必填>
 *
 * @author tianyejun
 * @version [版本号]
 * @see [参考资料]
 *
 * @since [历史 创建日期:2019-12-13]
</类说明> */
class RetrofitFactory private constructor() {
    /*
      单例实现
   */
    companion object {
        val instance:RetrofitFactory by lazy { RetrofitFactory() }
    }

    private val interceptor:Interceptor
    private val retrofit:Retrofit

    //初始化
    init {
        //通用拦截
        interceptor = Interceptor {
            chain -> val request = chain.request()
                .newBuilder()
                .addHeader("Content_Type","application/json")
                .addHeader("charset","UTF-8")
//                .addHeader("token",AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN))
                .build()

            chain.proceed(request)
        }

        //Retrofit实例化
        retrofit = Retrofit.Builder()
                .baseUrl(BaseConstance.SERVER_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(initClient())
                .build()
    }

    /*
        OKHttp创建
     */
    private fun initClient():OkHttpClient{
        return OkHttpClient.Builder()
                .addInterceptor(initLogInterceptor())
                .addInterceptor(interceptor)
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .build()
    }

    /*
        日志拦截器
     */
    private fun initLogInterceptor():HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    /*
        具体服务实例化
     */
    fun <T> create(service:Class<T>):T{
        return retrofit.create(service)
    }
}
