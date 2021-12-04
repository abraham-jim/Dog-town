package com.example.dogtown

import androidx.lifecycle.*
import com.example.dogtown.database.DogImageDao
import com.example.dogtown.database.DogImageEntity
import com.example.dogtown.network.DogImage
import com.example.dogtown.network.DogImageApi
import kotlinx.coroutines.launch

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */


class MainViewModel(private val dogImageDao: DogImageDao) : ViewModel() {

    private val _currentlyDisplayedImage = MutableLiveData<DogImage>()
    val currentlyDisplayedImage: LiveData<DogImage> = _currentlyDisplayedImage


    init {
        getNewDog()
    }
    /**
     * Call getNewDog() on init so we can display status immediately.
     */
    fun getNewDog() {
        viewModelScope.launch {
            // are getting the first item in the list from the response.
            _currentlyDisplayedImage.value = DogImageApi.retrofitService.getRandomDogImage()
        }
    }

    fun addDog(dogImageEntity: DogImageEntity)
    {
        viewModelScope.launch {
            dogImageDao.addDogImage(dogImageEntity)
        }
    }

    fun deleteMostRecentDog(){
        viewModelScope.launch {
            dogImageDao.deleteDog()
        }
    }

    fun getAllDogs(): LiveData<List<DogImageEntity>>
    {
        return dogImageDao.getAllDogImages().asLiveData()
    }
}

class MainViewModelFactory(
    private val dogImageDao: DogImageDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(dogImageDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}

