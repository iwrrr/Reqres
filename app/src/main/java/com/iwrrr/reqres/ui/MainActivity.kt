package com.iwrrr.reqres.ui

import android.os.Bundle
import com.iwrrr.reqres.data.User
import com.iwrrr.reqres.databinding.ActivityMainBinding
import com.iwrrr.reqres.event.StateEventSubscriber
import org.koin.androidx.scope.ScopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ScopeActivity() {

    private val viewModel: MainViewModel by viewModel()

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.run {
            btnFetchUser.setOnClickListener {
                viewModel.getUsers(1)
            }
        }

        viewModel.subscribeUser(subscribeUser())
    }

    private fun subscribeUser() = object : StateEventSubscriber<List<User>> {
        override fun onIdle() {
            binding.resultUser.append("idle..\n")
        }

        override fun onLoading() {
            binding.resultUser.append("onLoading..\n")
        }

        override fun onFailure(throwable: Throwable) {
            binding.resultUser.append("${throwable.message}..\n")
        }

        override fun onSuccess(data: List<User>) {
            binding.resultUser.append("$data..\n")
        }
    }
}