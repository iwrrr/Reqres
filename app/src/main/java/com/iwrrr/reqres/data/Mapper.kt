package com.iwrrr.reqres.data

object Mapper {

    fun mapUserResponses(userResponses: UserResponses?): List<User> {
        val mapper: (UserResponses.Data?) -> User = {
            User(
                id = it?.id ?: 0,
                name = "${it?.firstName.orEmpty()} ${it?.lastName.orEmpty()}",
                email = it?.email.orEmpty(),
            )
        }

        return userResponses?.data?.map(mapper).orEmpty()
    }

    fun mapUserDetailResponse(userDetailResponse: UserDetailResponse?): User {
        return User(
            id = userDetailResponse?.data?.id ?: 0,
            name = "${userDetailResponse?.data?.firstName.orEmpty()} ${userDetailResponse?.data?.lastName.orEmpty()}",
            email = userDetailResponse?.data?.email.orEmpty(),
        )
    }
}