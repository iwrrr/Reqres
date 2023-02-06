package com.iwrrr.reqres.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iwrrr.reqres.data.User
import com.iwrrr.reqres.event.StateEventSubscriber
import com.iwrrr.reqres.repository.UserRepository
import com.iwrrr.reqres.utils.convertEventToSubscriber
import kotlinx.coroutines.launch
import org.koin.core.annotation.Scope

@Scope(MainActivity::class)
class MainViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    private val userManager = userRepository.userStateEventManager

    private val userScope = userManager.createScope(viewModelScope)

    fun subscribeUser(subscriber: StateEventSubscriber<List<User>>) {
        convertEventToSubscriber(userManager, subscriber)
    }

    fun getUsers(page: Int) = userScope.launch {
        userRepository.getUsers(page)
    }
}