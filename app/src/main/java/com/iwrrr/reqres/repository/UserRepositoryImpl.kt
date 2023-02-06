package com.iwrrr.reqres.repository

import com.iwrrr.reqres.data.User
import com.iwrrr.reqres.network.NetworkSources
import com.iwrrr.reqres.event.StateEventManager
import com.iwrrr.reqres.utils.default
import org.koin.core.annotation.Single

@Single
class UserRepositoryImpl(
    private val networkSources: NetworkSources
) : UserRepository {

    private val _userStateEventManager = default<List<User>>()

    override val userStateEventManager: StateEventManager<List<User>>
        get() = _userStateEventManager

    override suspend fun getUsers(page: Int) {
        networkSources.getList(page)
            .collect(_userStateEventManager)
    }
}