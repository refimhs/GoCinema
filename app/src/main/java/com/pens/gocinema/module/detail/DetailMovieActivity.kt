package com.pens.gocinema.module.detail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.pens.gocinema.R
import com.pens.gocinema.data.remote.ApiEndpoint
import com.pens.gocinema.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {

    lateinit var viewModel: DetailViewModel
    lateinit var binding: ActivityDetailMovieBinding

    private var movieId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        setupDataBinding()
        setupViewModel()
        processIntent()
        setupObserver()

        viewModel.getDetailMovie(movieId)

    }

    private fun setupDataBinding(){
        binding = DataBindingUtil.setContentView(this,R.layout.activity_detail_movie)
        binding.activity = this
    }

    private fun setupViewModel(){
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.setContext(this)
    }

    private fun setupObserver(){
        viewModel.detailMovieResultLiveData.observe(this){
            viewModel.handleMovieDetailResponse(it)
        }
        viewModel.detailMovieLiveData.observe(this){
            Glide.with(this).load(ApiEndpoint.BASE_IMAGE_URL + it.backdrop_path)
                .into(binding.detailMovieImageView)
            binding.movie = it
        }
        viewModel.errorMessageLiveData.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }

    private fun processIntent(){
        movieId = intent.getIntExtra("movieID", 0)
    }

    fun onLinkClicked(url:String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}