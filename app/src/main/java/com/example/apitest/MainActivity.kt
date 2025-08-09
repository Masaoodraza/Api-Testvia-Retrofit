package com.example.apitest

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apitest.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()

    }

    private fun getData() {
        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<ResponseDataClass>{
            override fun onResponse(
                call: Call<ResponseDataClass?>,
                response: Response<ResponseDataClass?>,
            ) {
                if (response.isSuccessful && response.body()!=null)
                {
                    val todo =response.body()
                    binding.Txtvw1.text="Title: ${todo?.title}"
                    binding.Txtvw2.text="Completed: ${todo?.completed}"
                    binding.Txtvw3.text="User id : ${todo?.userId}"
                    binding.Txtvw4.text="ID : ${todo?.id}"

                }
                else{
                    Toast.makeText(this@MainActivity,"No Data Received", Toast.LENGTH_SHORT).show()

                }

            }

            override fun onFailure(
                call: Call<ResponseDataClass?>,
                t: Throwable,
            ) {
                Toast.makeText(this@MainActivity,"Eroorr:${t.localizedMessage}", Toast.LENGTH_SHORT).show()


            }

        })

    }
}