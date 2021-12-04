package com.kotlinbyte.infrastructure.datasource.remote

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

abstract class ServerInfoRemoteDatasource {
}

@ViewModelScoped
class ServerInfoRemoteDatasourceImpl @Inject constructor() : ServerInfoRemoteDatasource() {

}