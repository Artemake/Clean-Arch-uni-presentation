package com.learningwithmanos.uniexercise.heroes.source.local

import javax.inject.Inject

/**
 * Interface that wraps the local storage data framework that is used
 */
interface HeroLocalSource {

    // TODO: convert to wrap the suspend functions of the DBWrapper
}

class HeroLocalSourceImpl @Inject constructor(
    private val dbWrapper: DBWrapper,
): HeroLocalSource {

    // TODO

}