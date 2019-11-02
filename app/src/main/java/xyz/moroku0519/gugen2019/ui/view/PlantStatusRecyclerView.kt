package xyz.moroku0519.gugen2019.ui.view

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import xyz.moroku0519.gugen2019.ui.LoveSection

class PlantStatusRecyclerView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleInt: Int = 0
) : RecyclerView(
    context,
    attributeSet,
    defStyleInt
) {
    private val loveSection: LoveSection = LoveSection()

    init {
        adapter = GroupAdapter<GroupieViewHolder>().apply {
            add(loveSection)
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter("love", "isEffect", requireAll = false)
        fun PlantStatusRecyclerView.setLove(love: Int, isEffect: Boolean = false) {
            loveSection.updateLove(love, isEffect)
        }
    }

}