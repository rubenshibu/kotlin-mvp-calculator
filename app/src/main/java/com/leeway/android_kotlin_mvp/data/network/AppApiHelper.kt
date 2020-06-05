package com.leeway.android_kotlin_mvp.data.network

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Lee Lorz on 7/12/2017.
 */

@Singleton
class AppApiHelper @Inject constructor(val apiHeader: ApiHeader) : ApiHelper {

}