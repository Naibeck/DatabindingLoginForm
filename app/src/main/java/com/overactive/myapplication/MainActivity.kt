package com.overactive.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.overactive.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).also { binding ->
            binding.observableFieldsButton.setOnClickListener { startActivity(Intent(this, ObservableFieldsActivity::class.java)) }
            binding.liveDataButton.setOnClickListener { startActivity(Intent(this, LiveDataActivity::class.java)) }
        }
    }
}
