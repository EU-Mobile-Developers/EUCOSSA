package com.kerberos.eucossa

import android.app.Application

/**
 * Created with Android Studio
 * @Author: kerberos
 * @Date: 26/12/2022
 * @Project: Eucossa
 */
class Eucossa : Application() {

    companion object{
        @get: Synchronized
        lateinit var initialize: Eucossa
        private set
    }

    override fun onCreate() {
        super.onCreate()
        initialize = this

    }
}