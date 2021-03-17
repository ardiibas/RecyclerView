package app.sae.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.sae.recyclerview.model.DataParent
import kotlinx.android.synthetic.main.rv_item_menu.view.*

class ListAdapter(
    private val listener: (DataParent) -> Unit
) : BaseAdapter<ListAdapter.Holder>() {

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(dataParent: DataParent) {
            with(itemView) {
                tvTitleMenu.text = dataParent.nama

                llMain.setSafeOnClickListener { listener(dataParent) }
            }
        }
    }

    var list: MutableList<DataParent> = arrayListOf()

    fun updateList(listDalem: MutableList<DataParent>) {
        list = listDalem
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_item_menu, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindView(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}