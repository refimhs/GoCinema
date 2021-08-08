package com.pens.gocinema.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class MovieDetail(
    var title:String = "",
    var poster_path:String = "",
    var vote_average:Double = 0.0,
    @PrimaryKey(autoGenerate = false)
    var id:Int = 0,
    var backdrop_path:String = "",
    var overview:String = "",
    var release_date: String = "",
    var vote_count:Int = 0,
    var status:String = "",
    var homepage:String = "",


)
