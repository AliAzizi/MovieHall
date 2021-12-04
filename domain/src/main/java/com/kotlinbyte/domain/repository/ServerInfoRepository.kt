package com.kotlinbyte.domain.repository

import com.github.kittinunf.result.Result
import com.kotlinbyte.domain.entity.ServerInfo
import com.kotlinbyte.domain.exception.Failure

abstract class ServerInfoRepository : BaseRepository() {
    abstract suspend fun getInfo(): Result<ServerInfo, Failure>
}