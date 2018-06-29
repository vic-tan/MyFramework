package com.vic.framework.main.test.http.api;



import com.vic.framework.main.test.http.bean.BookBean;
import com.vic.framework.main.test.http.bean.Top250Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by allen on 2016/12/26.
 */

public interface ApiService {

    @GET("v2/book/1220562")
    Observable<BookBean> getBook();

    @GET("v2/movie/top250")
    Observable<Top250Bean> getTop250(@Query("count") int count);

    @GET("v2/book/1220562")
    Observable<String> getBookString();

}
