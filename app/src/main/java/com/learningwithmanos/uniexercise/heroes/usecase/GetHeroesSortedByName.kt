package com.learningwithmanos.uniexercise.heroes.usecase

import com.learningwithmanos.uniexercise.heroes.data.Hero
import com.learningwithmanos.uniexercise.heroes.di.CustomRuntimeDI
import com.learningwithmanos.uniexercise.heroes.repo.HeroRepository

/**
 * UC used to retrieve a list of heroes sorted by the name of heroes
 */
interface GetHeroesSortedByNameUC {
    fun execute(): List<Hero>
}

class GetHeroesSortedByNameUCImpl(
    private val heroRepository: HeroRepository = CustomRuntimeDI.getDI().getHeroRepository(),
): GetHeroesSortedByNameUC {
    override fun execute(): List<Hero> {
        // TODO
        return listOf()
    }

}