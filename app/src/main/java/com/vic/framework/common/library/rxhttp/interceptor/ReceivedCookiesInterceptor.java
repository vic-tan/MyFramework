package com.vic.framework.common.library.rxhttp.interceptor;


import com.vic.framework.common.library.rxhttp.constant.SPKeys;
import com.vic.framework.common.library.rxhttp.utils.SPUtils;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by tanlifei 2017/5/11.
 * <p>
 *
 * @author tanlifei
 * 接受服务器发的cookie   并保存到本地
 */

public class ReceivedCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        //这里获取请求返回的cookie
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();

            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }
            SPUtils.put(SPKeys.COOKIE, cookies);
        }

        return originalResponse;
    }
}
