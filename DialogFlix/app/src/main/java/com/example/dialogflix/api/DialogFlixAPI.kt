package com.example.dialogflix.api

import com.example.dialogflix.models.DialogListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface DialogFlixAPI {

    @GET("/v3/b/67b771bbe41b4d34e495c90d?meta=false")
                           //dynamic header
    suspend fun getDialogs(@Header("X-JSON-Path") category: String) : Response<List<DialogListItem>>

    @GET("/v3/b/67b771bbe41b4d34e495c90d?meta=false")
    @Headers("X-JSON-Path : dialogues..category") //static header
    suspend fun getCategories() : Response<List<String>>

}