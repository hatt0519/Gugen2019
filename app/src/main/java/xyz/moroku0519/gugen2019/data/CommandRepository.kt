package xyz.moroku0519.gugen2019.data

import xyz.moroku0519.gugen2019.data.entity.Care

interface CommandRepository {
    fun send(care: Care)
}