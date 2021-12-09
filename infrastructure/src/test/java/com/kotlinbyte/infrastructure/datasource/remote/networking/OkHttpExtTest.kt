package com.kotlinbyte.infrastructure.datasource.remote.networking

import com.kotlinbyte.domain.vobject.AuthResult
import com.kotlinbyte.infrastructure.datasource.local.UserCredentialsLocalDataSource
import io.mockk.*
import junit.framework.Assert.assertEquals
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import org.junit.After
import org.junit.Before
import org.junit.Test

class OkHttpExtTest {

    companion object {
        const val FAKE_TOKEN = "MINEIONINCEINCONEC"
    }

    private lateinit var requestSlot: CapturingSlot<Request>
    private lateinit var mockedUserCredentialsProvider: UserCredentialsLocalDataSource
    private lateinit var interceptor: Interceptor
    private lateinit var mockedChain: Interceptor.Chain

    @Before
    fun setup() {
        mockedUserCredentialsProvider = mockk()
        mockedChain = mockk()
        interceptor = OkHttpInterceptor(mockedUserCredentialsProvider)
        requestSlot = slot()

        val request = Request.Builder().url(EndPoints.BASE_URL).build()
        coEvery { mockedUserCredentialsProvider.getAuth() } returns AuthResult(FAKE_TOKEN)
        every { mockedChain.proceed(capture(requestSlot)) } answers {
            with(Response.Builder()) {
                protocol(Protocol.HTTP_2)
                request(request)
                code(300)
                message("")
                build()
            }
        }
    }

    @Test
    fun `should contain auth header`() {

        val endpoints =
            EndPoints.authRequiredEndpointsList.filter { EndPoints.authenticationRequired(it) }

        endpoints.forEach {
            val request = with(Request.Builder()) {
                url("${EndPoints.BASE_URL}${it}")
                build()
            }

            val expectedRequest = with(request.newBuilder()) {
                addHeader(HttpHeaders.AUTHORIZATION, FAKE_TOKEN)
                build()
            }

            every { mockedChain.request() } returns request

            interceptor.intercept(mockedChain)

            assertEquals(
                expectedRequest.headers(),
                requestSlot.captured.headers()
            )
        }

    }


    @After
    fun tearDown() {
        clearAllMocks()
    }


}