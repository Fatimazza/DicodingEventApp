package id.fatimazza.dicodingeventapp.ui.upcoming

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.fatimazza.dicodingeventapp.data.response.EventResponse
import id.fatimazza.dicodingeventapp.data.response.ListEventsItem
import id.fatimazza.dicodingeventapp.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpcomingViewModel : ViewModel() {

    companion object {
        private const val TAG = "UpcomingViewModel"
        private const val IS_EVENT_ACTIVE = 1
    }

    private val _listUpcoming = MutableLiveData<List<ListEventsItem>>()
    val listUpcoming: LiveData<List<ListEventsItem>> = _listUpcoming

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        getUpcomingEvents()
    }

    private fun getUpcomingEvents() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getEvents(IS_EVENT_ACTIVE)
        client.enqueue(object : Callback<EventResponse> {

            override fun onResponse(
                call: Call<EventResponse?>,
                response: Response<EventResponse?>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _listUpcoming.value = responseBody?.listEvents
                    } else {
                        Log.e(TAG, "onFailure: ${response.message()}")
                    }
                }
            }

            override fun onFailure(
                call: Call<EventResponse?>,
                t: Throwable
            ) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }
}
