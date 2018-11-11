package com.rocklobstre.coolRecyclerview.repository

import com.rocklobstre.coolRecyclerview.data.remote.Api
import com.rocklobstre.coolRecyclerview.data.remote.response.ApiListResponse
import com.rocklobstre.coolRecyclerview.domain.repository.UserRepository
import com.rocklobstre.coolRecyclerview.mock.Mocks.createUsers
import io.reactivex.Observable.just
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * @author wellingtoncosta on 05/02/18.
 */
@RunWith(JUnit4::class)
class UserRepositoryTest {

    @Mock
    private lateinit var api: Api

    @InjectMocks
    private lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        `when`(userRepository.getUsers()).thenReturn(just(ApiListResponse(
                0,
                0,
                0,
                0,
                createUsers()
        )))
    }

    @Test
    fun getUsersWithSuccess() {
        userRepository.getUsers()
        verify<Api>(api).fetchUsers()
    }

}