package com.pens.gocinema.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pens.gocinema.model.MovieDetail

@Database(entities = [MovieDetail::class], version = 1, exportSchema = false)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun movieDetailDao(): MovieDao

    companion object{
        fun provideDatabase(context: Context): MovieDatabase{
            return Room.databaseBuilder(
                context,
                MovieDatabase::class.java,
                "movieDB"
            ).allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}