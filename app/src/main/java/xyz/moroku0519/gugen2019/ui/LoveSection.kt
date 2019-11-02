package xyz.moroku0519.gugen2019.ui

import com.xwray.groupie.Section
import com.xwray.groupie.databinding.BindableItem
import xyz.moroku0519.gugen2019.R
import xyz.moroku0519.gugen2019.databinding.ViewLoveParameterBinding

class LoveSection : Section() {

    fun updateLove(loveCount: Int, isEffect: Boolean = false) {
        val itemList = mutableListOf<LoveItem>()
        repeat((0 until loveCount).count()) {
            when (it == loveCount - 1) {
                true -> itemList.add(LoveItem(it, isEffect))
                false -> itemList.add(LoveItem(it))
            }
        }
        update(itemList)
    }

    data class LoveItem(private val id: Int, private val isEffect: Boolean = false) : BindableItem<ViewLoveParameterBinding>(id.toLong()) {
        override fun getLayout(): Int = R.layout.view_love_parameter

        override fun bind(viewBinding: ViewLoveParameterBinding, position: Int) {
            with(viewBinding.love) {
                when (isEffect) {
                    true -> setMinAndMaxFrame("animate_on")
                    false -> setMinAndMaxFrame("on")
                }
                playAnimation()
            }
        }
    }
}