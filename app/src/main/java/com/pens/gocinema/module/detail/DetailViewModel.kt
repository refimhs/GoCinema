package com.pens.gocinema.module.detail

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pens.gocinema.data.MovieRepository
import com.pens.gocinema.model.MovieDetail
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    private var repository: MovieRepository? = null

    val detailMovieResultLiveData = MutableLiveData<Result<MovieDetail>>()
    val detailMovieLiveData = MutableLiveData<MovieDetail>()
    val errorMessageLiveData = MutableLiveData<String>()

    fun setContext(context: Context){
        repository = MovieRepository(context)
    }

    fun getDetailMovie(movieId: Int){
        viewModelScope.launch {
            detailMovieResultLiveData.value = repository?.getDetailMovie(movieId)
        }

    }

    fun handleMovieDetailResponse(result: Result<MovieDetail>){
        if(result.isSuccess){
            detailMovieLiveData.value = result.getOrDefault(MovieDetail())
        }else{
            errorMessageLiveData.value = result.exceptionOrNull()?.message.orEmpty()
        }
    }
}