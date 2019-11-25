package com.rmc.mobileshop2.http.service;

import com.rmc.mobileshop2.http.entity.CategoryEntity;
import com.rmc.mobileshop2.http.entity.HttpResult;

import java.util.List;


import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface CategoryService {



    @GET("cat")
    Observable<HttpResult<List<CategoryEntity>>> getTopList();


    @GET("cat/parent/{parentId}")
    Observable<HttpResult<List<CategoryEntity>>> getSecondList(@Path("parentId") int parentId);

}
