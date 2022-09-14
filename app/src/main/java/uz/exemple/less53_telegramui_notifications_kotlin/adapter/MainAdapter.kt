package uz.exemple.less53_telegramui_notifications_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.less53_telegramui_notifications_kotlin.R
import uz.exemple.less53_telegramui_notifications_kotlin.model.MainModel

class MainAdapter(var mList:List<MainModel> ):RecyclerView.Adapter<MainAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.tv_item_view.setText(item.itemText)

        holder.item_rv.layoutManager = LinearLayoutManager(holder.itemView.context)
        val itemadapter = ItemAdapter(item.itemList)
        holder.item_rv.adapter = itemadapter
    }

    override fun getItemCount(): Int {
        return mList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var tv_item_view: TextView
        lateinit var item_rv: RecyclerView

        init {
            tv_item_view = itemView.findViewById(R.id.itemTv)
            item_rv = itemView.findViewById(R.id.item_RV)
        }
    }


}