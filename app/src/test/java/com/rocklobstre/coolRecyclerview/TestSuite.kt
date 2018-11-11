package com.rocklobstre.coolRecyclerview

import com.rocklobstre.coolRecyclerview.repository.ColorRepositoryTesst
import com.rocklobstre.coolRecyclerview.repository.UserRepositoryTest
import com.rocklobstre.coolRecyclerview.viewmodel.ListColorsViewModelTest
import com.rocklobstre.coolRecyclerview.viewmodel.ListUsersViewModelTest
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses

/**
 * @author wellingtoncosta on 05/02/18.
 */
@RunWith(Suite::class)
@SuiteClasses(*[
    (ColorRepositoryTesst::class),
    (UserRepositoryTest::class),
    (ListColorsViewModelTest::class),
    (ListUsersViewModelTest::class)
])
class TestSuite