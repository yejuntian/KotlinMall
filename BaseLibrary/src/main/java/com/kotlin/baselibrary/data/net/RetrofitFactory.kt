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
    private val mRetrofit: Retrofit;
    private val mHeaderInterceptor: Interceptor;

    companion object {
        val mInstance: RetrofitFactory by lazy { RetrofitFactory() }
    }

    init {
        mHeaderInterceptor = Interceptor { chain ->
            val request = chain.request()
            request.newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("charset", "utf-8")
                    .build()
            chain.proceed(request)
        }
        mRetrofit = Retrofit.Builder()
                .baseUrl(BaseConstance.SERVER_ADDRESS)
                //支持RxJava2
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(initClient())
                .build()
    }

    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
                //Header拦截器
                .addInterceptor(mHeaderInterceptor)
                //日志拦截器
                .addInterceptor(initLogInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build()
    }

    //配置拦截器日志
    private fun initLogInterceptor(): Interceptor {
        val mInterceptor = HttpLoggingInterceptor()
        mInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return mInterceptor
    }

    fun <T> create(service: Class<T>): T {
        return mRetrofit.create(service)
    }
}
