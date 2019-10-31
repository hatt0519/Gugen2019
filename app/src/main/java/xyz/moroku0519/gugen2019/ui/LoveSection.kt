package xyz.moroku0519.gugen2019.ui

import com.xwray.groupie.Section
import com.xwray.groupie.databinding.BindableItem
import xyz.moroku0519.gugen2019.R
import xyz.moroku0519.gugen2019.databinding.ViewLoveParameterBinding

class LoveSection : Section() {

    init {
        // FIXME: ひとまず表示するところまで
        update(listOf(LoveItem(), LoveItem(), LoveItem()))
    }

    class LoveItem : BindableItem<ViewLoveParameterBinding>() {
        override fun getLayout(): Int = R.layout.view_love_parameter

        override fun bind(viewBinding: ViewLoveParameterBinding, position: Int) {
            viewBinding.love.playAnimation()
        }
    }
}