package com.example.jsondemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    val TAG = "Main_Activity_Screen"
    var employeeModel:EmployeeModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val employeeDetails = "{\n" +
                "  \"emp_name\": \"shobhakar tiwari\",\n" +
                "  \"emp_id\": \"67068\",\n" +
                "  \"emp_location\": \"noida\",\n" +
                "  \"emp_profile_image\":\"https://www.10wallpaper.com/wallpaper/1366x768/1203/after_rain-Fresh_nature_green_plants_wallpaper_1366x768.jpg\"\n" +
                "}"
        val gson = Gson()

        employeeModel = gson.fromJson(employeeDetails, EmployeeModel::class.java)

        //Print
        Log.d(TAG,employeeModel?.emp_profile_image)
        Log.d(TAG,employeeModel?.emp_name)
        val jsonArray = JSONArray(employeeModel)
        val list = ArrayList<EmployeeModel>()
        var i = 0
        while (i<jsonArray.length())
        {
            val jsonObject = jsonArray.getJSONObject(i)
            list.add(
                EmployeeModel(
                    jsonObject.getString("emp_id"),
                    jsonObject.getString("emp_name"),
                    jsonObject.getString("emp_location"),
                    jsonObject.getString("emp_profile_image")

                )
            )
            i++
        }
        val adapter= EmpAdapter(this, list)
        listView.adapter= adapter
    }

        }




