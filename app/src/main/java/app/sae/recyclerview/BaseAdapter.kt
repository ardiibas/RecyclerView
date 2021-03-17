package app.sae.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {
    fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
        val safeClickListener = SafeClickListener {
            onSafeClick(it)
        }
        setOnClickListener(safeClickListener)
    }
}