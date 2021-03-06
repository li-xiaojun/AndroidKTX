package com.lxj.androidktxdemo.entity

import java.util.*

/**
 * Description:
 * Create by dance, at 2018/12/11
 */
data class User(
        var name: String,
        var age : Int,
        var date : Date? = null
)

data class HttpResult<T>(
        var status: String? = null,
        var errcode: String? = null,
        var errmsg: String? = null,
        var data: T? = null
){
    fun isSuccess() = status=="success" || errcode=="0"
}