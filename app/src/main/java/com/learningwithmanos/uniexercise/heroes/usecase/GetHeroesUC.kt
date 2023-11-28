package com.learningwithmanos.uniexercise.heroes.usecase

import com.learningwithmanos.uniexercise.heroes.data.Hero
import com.learningwithmanos.uniexercise.heroes.di.CustomRuntimeDI
import com.learningwithmanos.uniexercise.heroes.repo.HeroRepository

/**
 * UC used to retrieve a list of heroes
 */
interface GetHeroesUC {
    fun execute(): List<Hero>
}

class GetHeroesUCImpl (
    private val heroRepository: HeroRepository = CustomRuntimeDI.getDI().getHeroRepository(),
) : GetHeroesUC {
    override fun execute(): List<Hero> {
        return heroRepository.getHeroes()
    }

}