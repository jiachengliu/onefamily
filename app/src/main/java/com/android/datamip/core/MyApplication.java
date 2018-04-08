/*
 * Copyright (c) 2015, 张涛.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.datamip.core;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.support.multidex.MultiDex;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebStorage;

/**
 * 作者:liujiacheng.
 * 日期: 2016/5/31 0031 17:06.
 * 描述：
 */
public class MyApplication extends Application {
    public static final String TAG = MyApplication.class.getSimpleName();
    private static MyApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public static MyApplication getInstance() {
        return instance;
    }
    @Override
    public void onLowMemory() {
        android.os.Process.killProcess(android.os.Process.myPid());
        super.onLowMemory();
    }



    public static void clearCookieAndLocalStorage(Context cxt){
        clearCookie(cxt);
        clearLocalStorage();
    }
    public static void clearCookie(Context cxt) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                CookieManager.getInstance().removeAllCookies(null);
                CookieManager.getInstance().flush();
            } else if (cxt != null) {
                CookieSyncManager cookieSync = CookieSyncManager.createInstance(cxt);
                cookieSync.startSync();
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.removeAllCookie();
                cookieManager.removeSessionCookie();
                cookieSync.stopSync();
                cookieSync.sync();
            }
        } catch (Exception e) {
        }
    }

    /**
     * 清除LocalStorage
     */
    public static void clearLocalStorage() {
        try {
            WebStorage.getInstance().deleteAllData();
        } catch (Throwable e) {
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
