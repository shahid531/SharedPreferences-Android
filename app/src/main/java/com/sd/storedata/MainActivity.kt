package com.sd.storedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sd.storedata.databinding.ActivityMainBinding
import com.sd.storedata.sharedpref.SharedPref

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SharedPref.getName(this).also {
            binding.txtName.setText(it)
        }
        binding.lblSave.setOnClickListener {
            val name: String = binding.txtName.text.toString()
            SharedPref.saveName(this@MainActivity, name)
        }
        binding.lblGet.setOnClickListener {
            val name = SharedPref.getName(this@MainActivity)
            binding.txtName.setText(name)
        }
        binding.lblRemove.setOnClickListener {
            SharedPref.removeName(this@MainActivity)
        }
    }
}