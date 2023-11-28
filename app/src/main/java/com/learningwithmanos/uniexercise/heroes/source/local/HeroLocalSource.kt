package com.learningwithmanos.uniexercise.heroes.source.local

import com.learningwithmanos.uniexercise.heroes.data.Hero
import com.learningwithmanos.uniexercise.heroes.di.CustomRuntimeDI

/**
 * Interface that wraps the local storage data framework that is used
 */
interface HeroLocalSource {

    /**
     * @return true if heroes are stored locally else false
     */
    fun isHeroDataStored(): Boolean

    /**
     * Stores a list of heroes to the local data storage
     * @param heroes list of heroes to be stored
     */
    fun storeHeroes(heroes: List<Hero>)

    /**
     * @return the list of heroes stored at the local storage
     */
    fun getHeroes(): List<Hero>
}

class HeroLocalSourceImpl (
    private val dbWrapper: DBWrapper = CustomRuntimeDI.getDI().getDBWrapper(),
): HeroLocalSource {
    override fun isHeroDataStored(): Boolean {
        return dbWrapper.isHeroDataStored()
    }

    override fun storeHeroes(heroes: List<Hero>) {
        dbWrapper.storeHeroes(heroes = heroes)
    }

    override fun getHeroes(): List<Hero> {
        return dbWrapper.getHeroes()
    }

}