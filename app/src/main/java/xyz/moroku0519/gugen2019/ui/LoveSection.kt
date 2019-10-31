package xyz.moroku0519.gugen2019.ui

import com.xwray.groupie.Section
import com.xwray.groupie.databinding.BindableItem
import xyz.moroku0519.gugen2019.R
import xyz.moroku0519.gugen2019.databinding.ViewLoveParameterBinding

class LoveSection : Section() {

    fun updateLove(loveCount: Int) {
        val itemList = mutableListOf<LoveItem>()
        repeat((0 until loveCount).count()) {
            itemList.add(LoveItem())
        }
        update(itemList)
    }

    class LoveItem : BindableItem<ViewLoveParameterBinding>() {
        override fun getLayout(): Int = R.layout.view_love_parameter

        override fun bind(viewBinding: ViewLoveParameterBinding, position: Int) {
            with(viewBinding.love) {
                setMinAndMaxFrame("on")
                playAnimation()
            }
        }
    }
}