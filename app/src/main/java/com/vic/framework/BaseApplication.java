package com.vic.framework;


import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.tencent.bugly.crashreport.CrashReport;
import com.vic.framework.common.library.rxhttp.RxHttpUtils;



/**
 * Created by allen on 2016/12/21.
 * <p>
 *
 * @author Allen
 */

public class BaseApplication extends Application {
    public static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        initRxHttpUtils();
        CrashReport.initCrashReport(getApplicationContext(), BuildConfig.BUGLY_ID, false);
    }


    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        appContext = this;
        MultiDex.install(this); // Enable MultiDex.
    }


    /**
     * 快速上手，默认配置
     */
    private void initRxHttpUtils() {
        RxHttpUtils
                .getInstance()
                .init(this)
                .config()
                //配置全局baseUrl
                .setBaseUrl(BuildConfig.BASE_URL);


    }


}
