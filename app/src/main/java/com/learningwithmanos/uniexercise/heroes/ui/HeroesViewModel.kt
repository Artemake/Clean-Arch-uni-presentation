package com.learningwithmanos.uniexercise.heroes.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learningwithmanos.uniexercise.heroes.data.Hero
import com.learningwithmanos.uniexercise.heroes.data.Tab
import com.learningwithmanos.uniexercise.heroes.di.CustomRuntimeDI
import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesSortedByHighestNumberOfComicsUC
import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesSortedByNameUC
import com.learningwithmanos.uniexercise.heroes.usecase.GetHeroesUC
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class HeroesViewModel(
    private val getHeroesUC: GetHeroesUC = CustomRuntimeDI.getDI().getHeroesUC(),
    private val getHeroesSortedByNameUC: GetHeroesSortedByNameUC = CustomRuntimeDI.getDI()
        .getHeroesSortedByNameUC(),
    private val getHeroesSortedByHighestNumberOfComicsUC: GetHeroesSortedByHighestNumberOfComicsUC = CustomRuntimeDI.getDI()
        .getHeroesSortedByHighestNumberOfComicsUC(),
) : ViewModel() {

    private var _selectedTabStateFlow: MutableStateFlow<Tab> = MutableStateFlow(Tab.Heroes)

    val selectedTabStateFlow: StateFlow<Tab> = _selectedTabStateFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = _selectedTabStateFlow.value
    )

    /**
     * Utilises corresponding UC to retrieve data based on the selectedTab.
     * @param selectedTab
     */
    fun getHeroes(selectedTab: Tab): List<HeroTileModel> {
        return when (selectedTab) {
            Tab.Heroes -> getHeroesUC.execute().map { it.mapHeroToHeroTileModel() }
            Tab.SortedByNameHeroes -> getHeroesSortedByNameUC.execute()
                .map { it.mapHeroToHeroTileModel() }

            Tab.SortedByComicHeroes -> getHeroesSortedByHighestNumberOfComicsUC.execute()
                .map { it.mapHeroToHeroTileModel() }
        }
    }

    /**
     * Utilises corresponding UC to retrieve data based on the selectedTab.
     * @param selectedTab
     */
    fun getSelectedIndex(selectedTab: Tab): Int {
        return when (selectedTab) {
            Tab.Heroes -> 0
            Tab.SortedByNameHeroes -> 1
            Tab.SortedByComicHeroes -> 2
        }
    }

    /**
     * Sets the selected tab
     */
    fun selectTab(tab: Tab) {
        _selectedTabStateFlow.value = tab
    }

}

data class HeroTileModel(
    val title: String,
    val imageUrl: String,
)

fun Hero.mapHeroToHeroTileModel(): HeroTileModel {
    return HeroTileModel(
        title = "$name, comics - $availableComics",
        imageUrl = imageUrl
    )
}