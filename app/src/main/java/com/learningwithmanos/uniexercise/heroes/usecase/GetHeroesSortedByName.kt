package com.learningwithmanos.uniexercise.heroes.usecase

import com.learningwithmanos.uniexercise.heroes.data.Hero
import com.learningwithmanos.uniexercise.heroes.repo.HeroRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * UC used to retrieve a list of heroes sorted by the name of heroes
 */
interface GetHeroesSortedByNameUC {
    suspend fun execute(): Flow<List<Hero>>
}

class GetHeroesSortedByNameUCImpl @Inject constructor(
    private val heroRepository: HeroRepository
): GetHeroesSortedByNameUC {
    // TODO
}