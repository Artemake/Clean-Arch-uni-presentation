package com.learningwithmanos.uniexercise.heroes.ui

import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesSortedByHighestNumberOfComicsUC
import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesSortedByNameUC
import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesUC
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock


class HeroesViewModelTest {

    private lateinit var heroesViewModel: HeroesViewModel

    private val getHeroesUCMock: GetHeroesUC = mock()
    private val getHeroesSortedByNameUCMock: GetHeroesSortedByNameUC = mock()
    private val getHeroesSortedByHighestNumberOfComicsUCMock: GetHeroesSortedByHighestNumberOfComicsUC = mock()

    @Before
    fun setUp() {
        heroesViewModel = HeroesViewModel(
            getHeroesUCMock,
            getHeroesSortedByNameUCMock,
            getHeroesSortedByHighestNumberOfComicsUCMock
        )
    }

    @Test
    fun `when getSelectedIndex is invoked with parameter then verify results`() {
        // TODO
    }

    @Test
    fun `when getHeroes is invoked with parameter then verify results`() {
        // TODO
    }

}
