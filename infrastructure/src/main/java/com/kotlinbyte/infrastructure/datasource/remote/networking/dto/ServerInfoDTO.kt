package com.kotlinbyte.infrastructure.datasource.remote.networking.dto

import com.kotlinbyte.domain.entity.ServerInfo

data class ServerInfoDTO(val isAvailable: Boolean) {
}


fun ServerInfoDTO.toEntity() = ServerInfo(isAvailable)