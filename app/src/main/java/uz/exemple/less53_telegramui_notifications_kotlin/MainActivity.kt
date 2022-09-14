package uz.exemple.less53_telegramui_notifications_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.less53_telegramui_notifications_kotlin.adapter.MainAdapter
import uz.exemple.less53_telegramui_notifications_kotlin.model.ItemModel
import uz.exemple.less53_telegramui_notifications_kotlin.model.MainModel

class MainActivity : AppCompatActivity() {

    private lateinit var list: ArrayList<ItemModel>
    private lateinit var list2: ArrayList<ItemModel>
    private lateinit var list3: ArrayList<ItemModel>
    private lateinit var list4: ArrayList<ItemModel>
    private lateinit var list5: ArrayList<ItemModel>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        list = ArrayList()
        list.add(ItemModel(R.drawable.ic_account, "Private Chats", null, true))
        list.add(ItemModel(R.drawable.ic_groups, "Group Chats", null, false))
        list.add(ItemModel(R.drawable.ic_sms, "Channels", null, true))
        list2 = ArrayList()
        list2.add(ItemModel(null, "In-App Sounds", null, true))
        list2.add(ItemModel(null, "In-App Vibrate", null, false))
        list2.add(ItemModel(null, "In-App Preview", null, true))
        list2.add(ItemModel(null, "In-Chat Sounds", null, true))
        list3 = ArrayList()
        list3.add(ItemModel(null, "Show Badge Icon", null, true))
        list3.add(ItemModel(null, "Include Muted Chats", null, false))
        list3.add(ItemModel(null, "Count Unread Messages", null, true))
        list4 = ArrayList()
        list4.add(ItemModel(null, "Contact joined Telegram", null, true))
        list4.add(ItemModel(null, "Pinned Message", null, false))

        val text1 = "Relaunch app when shut down.Enable for reliable notifications."
        val text2 =
            "Keep a low impact background connection to telegram for reliable notifications."
        val text3 = "Relaunch app when shut down.Enable for reliable for notifications."
        list5 = ArrayList()
        list5.add(ItemModel(null, "Keep-Alive Service", text1, true))
        list5.add(ItemModel(null, "Background Connection", text2, false))
        list5.add(ItemModel(null, "Repeat Notifications", null, true))


        val mList: ArrayList<MainModel> = ArrayList()

        mList.add(MainModel(list, "Message Notifications"))
        mList.add(MainModel(list2, "In-App Notifications"))
        mList.add(MainModel(list3, "Badge Counter"))
        mList.add(MainModel(list4, "Events"))
        mList.add(MainModel(list5, "Other"))
        adapter = MainAdapter(mList)
        recyclerView.adapter = adapter
    }
}