package com.vic.framework.common.library.rxhttp.interfaces;


import com.vic.framework.common.library.rxhttp.bean.BaseData;

import io.reactivex.disposables.Disposable;

/**
 * Created by tanlifei 2016/12/21.
 * <p>
 *
 * @author tanlifei
 *         定义请求结果处理接口
 */

public interface IDataSubscriber<T> {

    /**
     * doOnSubscribe 回调
     *
     * @param d Disposable
     */
    void doOnSubscribe(Disposable d);

    /**
     * 错误回调
     *
     * @param errorMsg 错误信息
     */
    void doOnError(String errorMsg);

    /**
     * 成功回调
     *
     * @param baseData 基础泛型
     */
    void doOnNext(BaseData<T> baseData);

    /**
     * 请求完成回调
     */
    void doOnCompleted();
}
