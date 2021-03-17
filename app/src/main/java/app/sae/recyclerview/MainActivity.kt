package app.sae.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.sae.recyclerview.model.DataParent
import app.sae.recyclerview.model.ResponseData
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private var listAdapter: ListAdapter? = null
    private var listDataParent: MutableList<DataParent>? = arrayListOf()

    private var responseData = ResponseData()
    private val gson = Gson()
    private var jsonObject = JSONObject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jsonObject = JSONObject(Utils.loadJSONFromAsset(this, R.raw.list_value))

        responseData = gson.fromJson(jsonObject.toString(), ResponseData::class.java)

        listDataParent = responseData.data as MutableList<DataParent>?

        listAdapter = ListAdapter {
            onListClick(it)
        }

        rvHomeMenu.adapter = listAdapter

        listAdapter!!.updateList(listDataParent!!)

        /*Cara lain*/
        /*rvHomeMenu.apply {
            layoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
            adapter = listAdapter
        }*/
    }

    private fun onListClick(dataParent: DataParent) {
        Toast.makeText(this, dataParent.nama, Toast.LENGTH_SHORT).show()
    }
}