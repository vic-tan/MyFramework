package com.vic.framework.common.library.rxhttp.download;

import com.vic.framework.common.library.rxhttp.exception.ApiException;
import com.vic.framework.common.library.rxhttp.utils.ToastUtils;


import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import okhttp3.ResponseBody;


/**
 * Created by tanlifei 2017/6/13.
 *
 * @author tanlifei
 */

public abstract class BaseDownloadObserver implements Observer<ResponseBody> {

    /**
     * 失败回调
     *
     * @param errorMsg 错误信息
     */
    protected abstract void doOnError(String errorMsg);


    @Override
    public void onError(@NonNull Throwable e) {
        String error = ApiException.handleException(e).getMessage();
        setError(error);
    }

    private void setError(String errorMsg) {
        ToastUtils.showToast(errorMsg);
        doOnError(errorMsg);
    }

}
