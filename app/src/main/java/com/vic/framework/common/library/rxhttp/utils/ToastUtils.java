package com.vic.framework.common.library.rxhttp.utils;

import android.widget.Toast;

import com.vic.framework.common.library.rxhttp.RxHttpUtils;

/**
 * Created by tanlifei 2017/10/31.
 *
 * @author tanlifei
 *         Toast工具类
 */

public class ToastUtils {

    private static Toast mToast;

    /**
     * Toast提示
     *
     * @param msg 提示内容
     */
    public static void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(RxHttpUtils.getContext(), msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }
}
