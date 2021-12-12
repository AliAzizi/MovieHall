package com.kotlinbyte.infrastructure.datasource.local

import android.content.SharedPreferences
import com.kotlinbyte.domain.exception.AuthenticationRequiredException
import com.kotlinbyte.domain.utils.KeyConstants
import com.kotlinbyte.domain.vobject.AuthResult
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.*

class SPUserCredentialsLocalDataSourceTest {
    private val sp: SharedPreferences = mockk()
    private val dataSource: SPUserCredentialsLocalDataSource =
        SPUserCredentialsLocalDataSource(sp)

    companion object {
        private const val DUMMY_TOKEN = "DOMMMYTOKEN"

    }

    @Test
    fun `AuthenticationRequiredException should thrown`() {

        every { sp.getString(KeyConstants.TOKEN, any()) } returns null

        Assert.assertThrows(
            AuthenticationRequiredException::class.java
        ) {
            runBlocking {
                dataSource.getAuth()
            }

        }

    }

    @Test
    fun `getAuth should return AuthResult`() {
        every { sp.getString(KeyConstants.TOKEN, any()) } returns DUMMY_TOKEN
        runBlocking {
            Assert.assertEquals(dataSource.getAuth(), AuthResult(DUMMY_TOKEN))
        }
    }

    @Before
    fun setup() {

    }

    @After
    fun tearDown() {

    }

}