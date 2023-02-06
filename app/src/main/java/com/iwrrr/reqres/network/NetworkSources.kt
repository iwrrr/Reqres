package com.iwrrr.reqres.network

import com.iwrrr.reqres.data.Mapper
import com.iwrrr.reqres.data.User
import com.iwrrr.reqres.utils.FlowState
import com.iwrrr.reqres.utils.asFlowStateEvent
import com.iwrrr.reqres.utils.flatMap
import org.koin.core.annotation.Single

@Single
class NetworkSources(private val webServicesProvider: WebServicesProvider) {

    suspend fun getList(page: Int): FlowState<List<User>> {
        return webServicesProvider.get().getList(page).asFlowStateEvent {
            Mapper.mapUserResponses(it)
        }
    }

//    suspend fun getDetail(id: Int): FlowState<User> {
//        return webServicesProvider.get().getDetail(id).asFlowStateEvent {
//            Mapper.mapUserDetailResponse(it)
//        }
//    }
}