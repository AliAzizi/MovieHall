package com.kotlinbyte.domain_android_overlay.networking.dto

import com.kotlinbyte.domain.entity.ServerInfo

data class ServerInfoDTO(val isAvailable: Boolean) {
}


fun ServerInfoDTO.toEntity() = ServerInfo(isAvailable)