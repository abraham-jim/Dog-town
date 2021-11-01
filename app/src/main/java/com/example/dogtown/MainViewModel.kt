package com.example.dogtown

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogtown.network.DogApi
import com.example.dogtown.network.RandomDogApiResponse
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _lastApiResponse = MutableLiveData<RandomDogApiResponse>()
    val lastApiResponse: LiveData<RandomDogApiResponse> = _lastApiResponse

    init {
        getNewDog()
    }

    fun getNewDog() {
        viewModelScope.launch {
            // The response from https://zenquotes.io/api/random is a list of 1 quote, so we
            // are getting the first item in the list from the response.
            _lastApiResponse.value = DogApi.retrofitService.getRandomDogImage()
        }
    }
}

//   public class UserModel extends ViewModel {
//       private final MutableLiveData<User> userLiveData = new MutableLiveData<>();
//
//       public LiveData<User> getUser() {
//           return userLiveData;
//       }
//
//       public UserModel() {
//           // trigger user load.
//       }
//
//       void doAction() {
//           // depending on the action, do necessary business logic calls and update the
//           // userLiveData.
//       }
//   }