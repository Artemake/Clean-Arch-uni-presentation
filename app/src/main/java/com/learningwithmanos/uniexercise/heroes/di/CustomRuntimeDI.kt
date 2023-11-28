package com.learningwithmanos.uniexercise.heroes.di

import com.learningwithmanos.uniexercise.heroes.repo.HeroRepository
import com.learningwithmanos.uniexercise.heroes.repo.HeroRepositoryImpl
import com.learningwithmanos.uniexercise.heroes.source.local.DBWrapper
import com.learningwithmanos.uniexercise.heroes.source.local.DummyDBWrapper
import com.learningwithmanos.uniexercise.heroes.source.local.HeroLocalSource
import com.learningwithmanos.uniexercise.heroes.source.local.HeroLocalSourceImpl
import com.learningwithmanos.uniexercise.heroes.source.remote.DummyRestFrameworkWrapper
import com.learningwithmanos.uniexercise.heroes.source.remote.HeroRemoteSource
import com.learningwithmanos.uniexercise.heroes.source.remote.HeroRemoteSourceImpl
import com.learningwithmanos.uniexercise.heroes.source.remote.RestFrameworkWrapper
import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesSortedByHighestNumberOfComicsUC
import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesSortedByHighestNumberOfComicsUCImpl
import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesSortedByNameUC
import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesSortedByNameUCImpl
import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesUC
import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesUCImpl

// TODO: Remove the custom runtime DI and replace it with the Hilt-Dagger DI
class CustomRuntimeDI private constructor() {

    companion object DIObject {

        private var customRuntimeDI: CustomRuntimeDI? = null
        fun getDI(): CustomRuntimeDI {
            return if (customRuntimeDI != null) {
                customRuntimeDI!!
            } else {
                customRuntimeDI = CustomRuntimeDI()
                customRuntimeDI!!
            }
        }

    }

    private var dbWrapper: DBWrapper? = null
    private var heroLocalSource: HeroLocalSource? = null

    fun getDBWrapper(): DBWrapper {
        if (dbWrapper == null) {
            dbWrapper = DummyDBWrapper()
        }
        return dbWrapper!!
    }

    fun getHeroLocalSource(): HeroLocalSource {
        if (heroLocalSource == null) {
            heroLocalSource = HeroLocalSourceImpl()
        }
        return heroLocalSource!!
    }

    private var restFrameworkWrapper: RestFrameworkWrapper? = null
    private var heroRemoteSource: HeroRemoteSource? = null

    fun getRestFrameworkWrapper(): RestFrameworkWrapper {
        if (restFrameworkWrapper == null) {
            restFrameworkWrapper = DummyRestFrameworkWrapper()
        }
        return restFrameworkWrapper!!
    }

    fun getHeroRemoteSource(): HeroRemoteSource {
        if (heroRemoteSource == null) {
            heroRemoteSource = HeroRemoteSourceImpl()
        }
        return heroRemoteSource!!
    }

    fun getHeroRepository(): HeroRepository {
        return HeroRepositoryImpl()
    }

    fun getHeroesUC(): GetHeroesUC {
        return GetHeroesUCImpl()
    }

    fun getHeroesSortedByNameUC(): GetHeroesSortedByNameUC {
        return GetHeroesSortedByNameUCImpl()
    }

    fun getHeroesSortedByHighestNumberOfComicsUC(): GetHeroesSortedByHighestNumberOfComicsUC {
        return GetHeroesSortedByHighestNumberOfComicsUCImpl()
    }
}