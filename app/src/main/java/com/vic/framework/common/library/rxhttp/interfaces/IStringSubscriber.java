package com.vic.framework.common.library.rxhttp.interfaces;

import io.reactivex.disposables.Disposable;

/**
 * Created by tanlifei 2017/10/31.
 * <p>
 *
 * @author tanlifei
 *         定义请求结果处理接口
 */

public interface IStringSubscriber {

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
     * @param string data
     */
    void doOnNext(String string);

    /**
     * 请求完成回调
     */
    void doOnCompleted();
}
