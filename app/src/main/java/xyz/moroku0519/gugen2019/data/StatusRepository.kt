package xyz.moroku0519.gugen2019.data

interface StatusRepository {
    fun loadGirlStatus(): GirlStatus
    fun loadGirlLoveMeter(): Int

}