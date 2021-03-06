package com.vic.framework.common.library.rxhttp.http;

import okhttp3.OkHttpClient;

/**
 * Created by tanlifei 2017/5/31.
 * <p>
 *
 * @author tanlifei
 *         okHttp client
 */

public class HttpClient {

    private static HttpClient instance;

    private OkHttpClient.Builder builder;

    public HttpClient() {
        builder = new OkHttpClient.Builder();
    }

    public static HttpClient getInstance() {

        if (instance == null) {
            synchronized (HttpClient.class) {
                if (instance == null) {
                    instance = new HttpClient();
                }
            }

        }
        return instance;
    }


    public OkHttpClient.Builder getBuilder() {
        return builder;
    }

}
