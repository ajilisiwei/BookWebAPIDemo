package com.wei.common

/**
 * Created by WEI on 2017/5/14.
 */
class MsgBody {
    String result
    String error

    MsgBody(){}

    MsgBody(String result, String error) {
        this.result = result
        this.error = error
    }
}
