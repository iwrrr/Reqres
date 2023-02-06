package com.iwrrr.reqres.network

import org.koin.core.annotation.Single

@Single
class WebServicesProvider {

    fun get(): WebServices {
        return WebServices.build()
    }
}