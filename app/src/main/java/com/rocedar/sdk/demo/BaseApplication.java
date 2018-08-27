package com.rocedar.sdk.demo;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.rocedar.lib.base.config.RCBaseConfig;
import com.rocedar.lib.base.manage.RCSDKManage;
import com.rocedar.lib.base.network.IRCDataErrorLister;
import com.rocedar.lib.base.network.IRCRequestCode;
import com.rocedar.sdk.demo.rocderconfig.ImageShowConfig;

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
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        //（重要）初始化并设置token失效监听
        RCSDKManage.getInstance().init(this, new IRCDataErrorLister() {
            @Override
            public void error(Context context, int code, String s) {
                if (code == IRCRequestCode.STATUS_APP_CODE_TOKEN_OVERDUE) {
                    //token失效
                    TestLoginActivity.goActivity(context);
//                    RCSDKManage.getInstance().setToken("3a827729bd79d25e36b2582c45c8f3ff");
                } else if (code == IRCRequestCode.STATUS_APP_CODE_NO_PHONE_NUMBER) {
                    //该用户没有绑定手机号
//                    RCToast.Center(context, "没有手机号或手机号格式不正确");
                    //给用户设置手机号方法，如果设置的手机号有问题会继续抛这个错误
//                    RCFDConfigUtil.setPhoneNumber(context, "有效的手机号");//
                } else if (code == IRCRequestCode.STATUS_APP_CODE_PHONE_NUMBER_INVALID) {
                    //该用户已经绑定手机号
                }
            }
        });
        //设置为测试服务器地址(非使用测试地址时去掉)
        RCSDKManage.setDebug(true);
        //图片加载器
        RCBaseConfig.setImageManagerBase(new ImageShowConfig());
    }
}
