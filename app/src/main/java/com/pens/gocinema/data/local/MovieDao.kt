package com.pens.gocinema.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pens.gocinema.model.MovieDetail

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetail(movie: MovieDetail)

    @Query("SELECT * FROM moviedetail WHERE id = :movieId")
    fun getDetailMovie(movieId: Int): MovieDetail
}