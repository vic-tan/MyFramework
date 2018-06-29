package com.vic.framework.common.library.rxhttp.observer;

import android.app.Dialog;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.vic.framework.common.library.rxhttp.RxHttpUtils;
import com.vic.framework.common.library.rxhttp.base.BaseStringObserver;
import com.vic.framework.common.library.rxhttp.utils.ToastUtils;

import io.reactivex.disposables.Disposable;


/**
 * Created by tanlifei 2017/10/31.
 *
 * @author tanlifei
 *         <p>
 *         自定义Observer 处理string回调
 */

public abstract class StringObserver extends BaseStringObserver {

    private KProgressHUD mProgressDialog;

    public StringObserver() {

    }

    public StringObserver(KProgressHUD progressDialog) {
        mProgressDialog = progressDialog;
    }

    /**
     * 失败回调
     *
     * @param errorMsg 错误信息
     */
    protected abstract void onError(String errorMsg);

    /**
     * 成功回调
     *
     * @param data 结果
     */
    protected abstract void onSuccess(String data);


    @Override
    public void doOnSubscribe(Disposable d) {
        RxHttpUtils.addDisposable(d);
    }

    @Override
    public void doOnError(String errorMsg) {
        dismissLoading();
        if (!isHideToast()) {
            ToastUtils.showToast(errorMsg);
        }
        onError(errorMsg);
    }

    @Override
    public void doOnNext(String string) {
        onSuccess(string);
    }


    @Override
    public void doOnCompleted() {
        dismissLoading();
    }

    /**
     * 隐藏loading对话框
     */
    private void dismissLoading() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }
}
