package com.learningwithmanos.uniexercise.heroes.usecase

import com.learningwithmanos.uniexercise.heroes.data.Hero
import com.learningwithmanos.uniexercise.heroes.di.CustomRuntimeDI
import com.learningwithmanos.uniexercise.heroes.repo.HeroRepository
import javax.inject.Inject

/**
 * UC used to retrieve a list of heroes
 */
interface GetHeroesUC {
    fun execute(): List<Hero>
}

// TODO: Adjust the to use Hilt-Dagger
class GetHeroesUCImpl @Inject constructor() : GetHeroesUC {

    private val heroRepository: HeroRepository = CustomRuntimeDI.getDI().getHeroRepository()

    override fun execute(): List<Hero> {
        return heroRepository.getHeroes()
    }

}