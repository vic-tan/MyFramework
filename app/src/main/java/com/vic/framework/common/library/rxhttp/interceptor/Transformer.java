package com.vic.framework.common.library.rxhttp.interceptor;



import com.kaopiz.kprogresshud.KProgressHUD;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by tanlifei 2016/12/20.
 * <p>
 *
 * @author tanlifei
 *         控制操作线程的辅助类
 */

public class Transformer {

    /**
     * 无参数
     *
     * @param <T> 泛型
     * @return 返回Observable
     */
    public static <T> ObservableTransformer<T, T> switchSchedulers() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(@NonNull Disposable disposable) throws Exception {

                            }
                        })
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 带参数  显示loading对话框
     *
     * @param dialog loading
     * @param <T>    泛型
     * @return 返回Observable
     */
    public static <T> ObservableTransformer<T, T> switchSchedulers(final KProgressHUD dialog) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(@NonNull Disposable disposable) throws Exception {
                                if (dialog != null) {
                                    dialog.show();
                                }
                            }
                        })
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
