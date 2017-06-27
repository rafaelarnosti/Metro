package com.rafaelarnosti.metro.api;

/**
 * Created by logonrm on 26/06/2017.
 */

public class APIUtils {
    public static final String BASE_URL = "http://10.3.1.18:3000";

    public static AndroidAPI getAndroidAPIVersion(){
        return RetrofitClient.getClient(BASE_URL).create(AndroidAPI.class);
    }
}
