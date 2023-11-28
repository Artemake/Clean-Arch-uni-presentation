package com.learningwithmanos.uniexercise.heroes.usecase

import com.learningwithmanos.uniexercise.heroes.data.Hero
import com.learningwithmanos.uniexercise.heroes.di.CustomRuntimeDI
import com.learningwithmanos.uniexercise.heroes.repo.HeroRepository

/**
 * UC used to retrieve a list of heroes sorted by the name of heroes
 */
interface GetHeroesSortedByHighestNumberOfComicsUC {
    fun execute(): List<Hero>
}

class GetHeroesSortedByHighestNumberOfComicsUCImpl (
    private val heroRepository: HeroRepository = CustomRuntimeDI.getDI().getHeroRepository(),
): GetHeroesSortedByHighestNumberOfComicsUC {
    override fun execute(): List<Hero> {
        return heroRepository.getHeroes().sortedByDescending { it.availableComics }
    }
}