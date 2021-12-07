package com.kotlinbyte.infrastructure.datasource.remote

import com.kotlinbyte.domain.entity.ServerInfo
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

abstract class ServerInfoRemoteDatasource {
    abstract suspend fun fetch() : ServerInfo
}


class ServerInfoRemoteDatasourceImpl @Inject constructor() : ServerInfoRemoteDatasource() {

    override suspend fun fetch(): ServerInfo {
        TODO("Not yet implemented")
    }

}