package com.learningwithmanos.uniexercise.heroes.source.local

import com.learningwithmanos.uniexercise.heroes.data.Hero

interface DBWrapper {
    fun isHeroDataStored(): Boolean
    fun storeHeroes(heroes: List<Hero>)
    fun getHeroes(): List<Hero>
}

class DummyDBWrapper(): DBWrapper {
    override fun isHeroDataStored(): Boolean {
        return false
    }

    override fun storeHeroes(heroes: List<Hero>) {
        // do nothing
    }

    override fun getHeroes(): List<Hero> {
        return listOf()
    }
}