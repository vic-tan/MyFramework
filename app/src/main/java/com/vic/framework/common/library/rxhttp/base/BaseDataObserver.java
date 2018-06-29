package com.vic.framework.common.library.rxhttp.base;

import com.vic.framework.common.library.rxhttp.bean.BaseData;
import com.vic.framework.common.library.rxhttp.exception.ApiException;
import com.vic.framework.common.library.rxhttp.interfaces.IDataSubscriber;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by tanlifei 2017/10/27.
 *
 * @author tanlifei
 *         <p>
 *         基类BaseObserver使用BaseData
 */

public abstract class BaseDataObserver<T> implements Observer<BaseData<T>>, IDataSubscriber<T> {

    /**
     * 是否隐藏toast
     *
     * @return
     */
    protected boolean isHideToast() {
        return false;
    }

    @Override
    public void onSubscribe(Disposable d) {
        doOnSubscribe(d);
    }

    @Override
    public void onNext(BaseData<T> baseData) {
        doOnNext(baseData);
    }

    @Override
    public void onError(Throwable e) {
        String error = ApiException.handleException(e).getMessage();
        setError(error);
    }

    @Override
    public void onComplete() {
        doOnCompleted();
    }


    private void setError(String errorMsg) {
        doOnError(errorMsg);
    }

}
