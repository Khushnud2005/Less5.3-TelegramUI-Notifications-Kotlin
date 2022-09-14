package uz.exemple.less53_telegramui_notifications_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.switchmaterial.SwitchMaterial
import uz.exemple.less53_telegramui_notifications_kotlin.R
import uz.exemple.less53_telegramui_notifications_kotlin.model.ItemModel

class ItemAdapter(var itemList: ArrayList<ItemModel>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_child, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        if (item.icon != null) {
            holder.iv_childIcon.setImageResource(item.icon!!)
            holder.switch1.visibility = View.GONE
            holder.iv_childRight.visibility = View.VISIBLE
        } else {
            holder.iv_childIcon.visibility = View.GONE
            holder.tv_onOff.visibility = View.GONE
        }

        holder.tv_childTitle.setText(item.title)
        if (item.btnOnOff == true) {
            holder.tv_onOff.text = "On"
            holder.switch1.isChecked = true
        } else {
            holder.tv_onOff.text = "Off"
            holder.switch1.isChecked = false
        }
        if (item.desc != null) {
            holder.tv_childDesc.setText(item.desc)
            holder.tv_childDesc.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
       return itemList.size
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var iv_childIcon: ImageView
        lateinit var iv_childRight: ImageView
        lateinit var tv_childTitle: TextView
        lateinit var tv_onOff: TextView
        lateinit var tv_childDesc: TextView
        lateinit var switch1: SwitchMaterial

        init {
            iv_childIcon = itemView.findViewById(R.id.iv_childIcon)
            iv_childRight = itemView.findViewById(R.id.iv_childRight)
            tv_childTitle = itemView.findViewById(R.id.tv_childTitle)
            tv_onOff = itemView.findViewById(R.id.tv_onOff)
            tv_childDesc = itemView.findViewById(R.id.tv_childDesc)
            switch1 = itemView.findViewById(R.id.switch1)
        }
    }




}