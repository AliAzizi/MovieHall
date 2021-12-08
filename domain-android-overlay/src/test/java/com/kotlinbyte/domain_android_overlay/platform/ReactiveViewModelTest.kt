package com.kotlinbyte.domain_android_overlay.platform


import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kotlinbyte.domain.interactor.UseCase
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.runner.RunWith
import kotlin.time.ExperimentalTime
import com.github.kittinunf.result.Result
import com.kotlinbyte.domain.exception.Failure
import com.kotlinbyte.domain_android_overlay.utils.UiState
import io.mockk.clearMocks
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Test

@ExperimentalTime
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class ReactiveViewModelTest {

    private data class FakeEntity(val data: String)
    private data class Param(val data: String)

    private lateinit var testDispatcher: TestCoroutineDispatcher
    private lateinit var fakeUseCase: UseCase<FakeEntity, Param>
    private lateinit var fakeViewModel: FakeViewModel
    private lateinit var param: Param
    private lateinit var secondParam: Param
    private lateinit var fakeEntity: FakeEntity

    private inner class FakeViewModel : ReactiveViewModel<FakeEntity>() {
        fun fetchData(param: Param) {

            rememberableCall { asyncCallOnViewModelScope { fakeUseCase.run(param) } }

        }


    }

    @Before
    fun setup() {
        testDispatcher = TestCoroutineDispatcher()
        Dispatchers.setMain(testDispatcher)

        fakeUseCase = mockk()
        fakeViewModel = FakeViewModel()
        param = Param("Test param")
        secondParam = Param("Second Test Params")
        fakeEntity = FakeEntity("fake entity response")

        every { fakeUseCase.invoke(any(), any(), any()) } answers { callOriginal() }
        coEvery { fakeUseCase.run(param) } returns Result.failure(Failure.NetworkConnection)
        coEvery { fakeUseCase.run(secondParam) } returns Result.success(fakeEntity)
    }


    @Test
    fun `Should return error ui state`() {
        runBlockingTest {
            fakeViewModel.fetchData(param)
        }
        Thread.sleep(1000)

        assertEquals(UiState.Error(null), fakeViewModel.uiState.value)
    }

    @Test
    fun `Should return success ui state`() {
        runBlockingTest {
            fakeViewModel.fetchData(secondParam)

        }
        Thread.sleep(1000)

        assertEquals(UiState.Loaded(fakeEntity), fakeViewModel.uiState.value)
    }

    @After
    fun tearDown() {
        clearMocks(fakeUseCase)
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}