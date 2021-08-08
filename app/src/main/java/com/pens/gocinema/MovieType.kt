package com.pens.gocinema

enum class MovieType(val value:String, val id: Int) {
    NOW_PLAYING("Now Playing", id=1),
    UPCOMING("Upcoming", id=2),
    LATEST("Latest", id=3),
    POPULAR("Popular", id=4),
    TOP_RATED("Top Rated", id=5)
}