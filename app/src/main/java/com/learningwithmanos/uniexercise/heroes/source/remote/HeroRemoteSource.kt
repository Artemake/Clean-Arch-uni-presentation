package com.learningwithmanos.uniexercise.heroes.source.remote

import com.learningwithmanos.uniexercise.heroes.data.Hero
import com.learningwithmanos.uniexercise.heroes.di.CustomRuntimeDI
import javax.inject.Inject

/**
 * Interface that wraps the framework that is used for the Rest calls
 */
interface HeroRemoteSource {

    /**
     * @return retrieves the a list of heroes from a certain endpoint
     */
    fun getHeroes(): List<Hero>
}

// TODO: Adjust to have the dependencies to the constructor
class HeroRemoteSourceImpl @Inject constructor() : HeroRemoteSource {

    private val restFrameworkWrapper: RestFrameworkWrapper =
        CustomRuntimeDI.getDI().getRestFrameworkWrapper()

    override fun getHeroes(): List<Hero> {
        return restFrameworkWrapper.getHeroes()
    }

}

