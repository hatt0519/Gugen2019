package xyz.moroku0519.gugen2019.data

import xyz.moroku0519.gugen2019.data.entity.Girl

interface GirlsRepository {
    fun loadGirl(): Girl
    fun loadGirlLoveMeter(): Int
}