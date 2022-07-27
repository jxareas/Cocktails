package com.jxareas.cocktails.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jxareas.cocktails.domain.repository.CocktailRepository
import com.jxareas.cocktails.domain.model.Cocktail
import com.jxareas.cocktails.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchCocktailsViewModel @Inject constructor(
    private val repository: CocktailRepository
) : ViewModel() {

    private var _cocktails = MutableLiveData<Resource<List<Cocktail>>>()
    val cocktails: LiveData<Resource<List<Cocktail>>> get() = _cocktails


    init {
        fetchCocktails()
    }

    internal fun fetchCocktails(name: String = "Margarita") {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCocktailByName(name).collectLatest { cocktails ->
                _cocktails.postValue(cocktails)
            }
        }
    }

}
