package com.vic.framework;


import android.view.MenuItem;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.vic.framework.common.base.ui.activity.base.BaseActivity;
import com.vic.framework.main.test.http.HttpActivity;

public class MainActivity extends BaseActivity {


    public void rxJava_Retrofit(View v) {
        ActivityUtils.startActivity(this, HttpActivity.class);
    }

    @Override
    protected int setContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        setToolbarTitleTv("首页");
    }

    @Override
    protected int getMenuLayoutId() {
        return R.menu.menu_main;
    }

    @Override
    public boolean callbackOnMenuAction(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_test:
                ToastUtils.showShort("测试");
                return true;
            case R.id.menu_search:
                ToastUtils.showShort("搜索");
                return true;
            case R.id.menu_settings:
                ToastUtils.showShort("设置");
                return true;
            case R.id.menu_check_update:
                ToastUtils.showShort("检查更新");
                return true;
            case R.id.menu_about:
                ToastUtils.showShort("关于");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
