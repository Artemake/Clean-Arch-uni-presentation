package com.learningwithmanos.uniexercise.heroes.source.remote

import com.learningwithmanos.uniexercise.heroes.data.Hero
import com.learningwithmanos.uniexercise.heroes.di.CustomRuntimeDI

/**
 * Interface that wraps the framework that is used for the Rest calls
 */
interface HeroRemoteSource {

    /**
     * @return retrieves the a list of heroes from a certain endpoint
     */
    fun getHeroes(): List<Hero>
}

class HeroRemoteSourceImpl (
    private val restFrameworkWrapper: RestFrameworkWrapper = CustomRuntimeDI.getDI().getRestFrameworkWrapper(),
): HeroRemoteSource {

    override fun getHeroes(): List<Hero> {
        // TODO
        return listOf()
    }

}

