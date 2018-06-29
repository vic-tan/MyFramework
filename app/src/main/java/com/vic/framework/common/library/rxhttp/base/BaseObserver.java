package com.vic.framework.common.library.rxhttp.base;


import com.vic.framework.common.library.rxhttp.exception.ApiException;
import com.vic.framework.common.library.rxhttp.interfaces.ISubscriber;


import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;


/**
 * Created by tanlifei 2017/5/3.
 *
 * @author tanlifei
 *         <p>
 *         基类BaseObserver
 */

public abstract class BaseObserver<T> implements Observer<T>, ISubscriber<T> {

    /**
     * 是否隐藏toast
     *
     * @return
     */
    protected boolean isHideToast() {
        return false;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        doOnSubscribe(d);
    }

    @Override
    public void onNext(@NonNull T t) {
        doOnNext(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
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
