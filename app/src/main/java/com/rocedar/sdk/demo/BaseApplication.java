package com.rocedar.sdk.demo;

import android.app.Application;

import com.rocedar.lib.base.manage.RCSDKManage;
import com.rocedar.lib.base.network.IRCDataErrorLister;

/**
 * 项目名称：瑰柏SDK-基础库
 * <p>
 * 作者：phj
 * 日期：2018/6/7 下午4:36
 * 版本：V1.0.00
 * 描述：瑰柏SDK-
 * <p>
 * CopyRight©北京瑰柏科技有限公司
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //（重要）初始化并设置token失效监听
        RCSDKManage.getInstance().init(this, new IRCDataErrorLister() {
            @Override
            public void error(int code, String msg) {
               //token失效后的处理
            }
        });
        //设置为测试服务器地址(非使用测试地址时去掉)
        RCSDKManage.setDebug(true);
    }
}
