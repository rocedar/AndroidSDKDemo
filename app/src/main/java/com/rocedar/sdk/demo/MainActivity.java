package com.rocedar.sdk.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.rocedar.lib.base.config.RCBaseConfig;
import com.rocedar.lib.base.manage.RCBaseActivity;
import com.rocedar.lib.base.manage.RCSDKManage;
import com.rocedar.sdk.assessment.RCAssessmentListActivity;
import com.rocedar.sdk.demo.rocderconfig.FamilyDoctorConfig;
import com.rocedar.sdk.familydoctor.app.RCFDMainActivity;
import com.rocedar.sdk.familydoctor.config.RCFDConfigUtil;

import java.lang.reflect.Field;


public class MainActivity extends RCBaseActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    private RadioGroup groupColor;
    private RadioGroup groupTitleBg;
    private RadioGroup groupRaduis;

    private int colorChoose;
    private int titleBgChoose;
    private int raduisChoose;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRcHeadUtil.setTitle("Rocedar SDK DEMO").setLeftButtonGone();

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);


        //主题配置
        groupColor = findViewById(R.id.group_color);
        groupTitleBg = findViewById(R.id.group_title_bg);
        groupRaduis = findViewById(R.id.group_radius);
        groupColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                colorChoose = checkedId;
            }
        });
        groupTitleBg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                titleBgChoose = checkedId;
            }
        });
        groupRaduis.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                raduisChoose = checkedId;
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到家庭页面主页面
                //手机号（必填），头像地址（网络绝对地址），设备列表（多个设备逗号隔开，没有给""），版本号（0为仅有家庭医生版本，1为带名医的版本）
                RCFDMainActivity.goActivity(MainActivity.this, "这里是手机号",
                        "头像地址", "设备列表", 0);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到家庭页面主页面
                //手机号（必填），头像地址（网络绝对地址），设备列表（多个设备逗号隔开，没有给""），版本号（0为仅有家庭医生版本，1为带名医的版本）
                RCFDMainActivity.goActivity(MainActivity.this, "这里是手机号",
                        "头像地址", "设备列表", 1);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到健康测评页面主页面
                //手机号（可以给""），设备列表（多个设备逗号隔开，没有给""）
                RCAssessmentListActivity.goActivity(mContext, "这里是手机号", "");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RCSDKManage.getInstance().setToken("");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change();
            }
        });

        //设置图片配置项
        //家庭医生图片配置（具体可以参考文档）
        RCFDConfigUtil.setClassPath(FamilyDoctorConfig.class);
        //基础图片配置（具体可以参考文档）
        RCBaseConfig.setBaseConfigClassPath(FamilyDoctorConfig.class);
    }


    /**
     * 该方法仅提供demo中查看
     * 请在AndroidManifest.xml 中<application下android:theme的样式中添加对应的配置项（如果不添加，运行会报错）
     */
    public void change() {
        int themes = R.style.AppTheme_Blue_White_0;
        StringBuffer themeName = new StringBuffer();
        themeName.append("AppTheme_");
        switch (colorChoose) {
            case 1:
                themeName.append("Blue_");
                break;
            case 2:
                themeName.append("Purple_");
                break;
            case 3:
                themeName.append("Gray_");
                break;
        }
        switch (titleBgChoose) {
            case 4:
                themeName.append("White_");
                break;
            case 5:
                themeName.append("Black_");
                break;
        }
        switch (raduisChoose) {
            case 6:
                themeName.append("0");
                break;
            case 7:
                themeName.append("5");
                break;
        }
        RCBaseConfig.a = getResource(themeName.toString()) != 0 ? getResource(themeName.toString()) : themes;
    }


    public int getResource(String themeName) {
        Class mipmap = R.style.class;
        try {
            Field field = mipmap.getField(themeName);
            int resId = field.getInt(themeName);
            return resId;
        } catch (NoSuchFieldException e) {
            return 0;
        } catch (IllegalAccessException e) {
            return 0;
        }

    }


}
