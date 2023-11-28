package com.learningwithmanos.uniexercise.heroes.source.remote

import com.learningwithmanos.uniexercise.heroes.data.Hero
import com.learningwithmanos.uniexercise.heroes.DummyData

interface RestFrameworkWrapper{
    fun getHeroes(): List<Hero>
}

class DummyRestFrameworkWrapper(): RestFrameworkWrapper {
    override fun getHeroes(): List<Hero> {
        return DummyData.dummyHeroList
    }
}