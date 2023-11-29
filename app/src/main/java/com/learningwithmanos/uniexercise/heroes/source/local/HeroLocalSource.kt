package com.learningwithmanos.uniexercise.heroes.source.local

import com.learningwithmanos.uniexercise.heroes.data.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

/**
 * Interface that wraps the local storage data framework that is used
 */
interface HeroLocalSource {

    fun isHeroDataStored(): Flow<Boolean>
    fun storeHeroes(heroes: List<Hero>)
    fun getHeroes(): Flow<List<Hero>>
}

class HeroLocalSourceImpl @Inject constructor(
    private val dbWrapper: DBWrapper,
): HeroLocalSource {

    override fun isHeroDataStored(): Flow<Boolean> {
        return flowOf(false)
    }

    override fun storeHeroes(heroes: List<Hero>) {
        // TODO
    }

    override fun getHeroes(): Flow<List<Hero>> {
        // TODO
        return flowOf(listOf())
    }

}