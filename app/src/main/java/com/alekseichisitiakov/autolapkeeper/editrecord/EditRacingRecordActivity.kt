package com.alekseichisitiakov.autolapkeeper.editrecord

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.alekseichisitiakov.autolapkeeper.databinding.ActivityEditRacingRecordBinding

class EditRacingRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRacingRecordBinding
    private val racingPreferences by lazy { getSharedPreferences("racing", Context.MODE_PRIVATE) }
    private val config by lazy { intent.getStringExtra("Config") }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRacingRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUi()
        displayRecord()
    }

    private fun setupUi() {
        title = "$config Record"
        binding.buttonSave.setOnClickListener {
            saveRecord()
            finish()
        }
        binding.buttonDelete.setOnClickListener {
            clearRecord()
            finish()
        }
    }


    private fun displayRecord() {
        binding.editTextRecord.setText(racingPreferences.getString("$config record", null))
        binding.editTextDate.setText(racingPreferences.getString("$config date", null))
    }

    private fun saveRecord() {
        val record = binding.editTextRecord.text.toString()
        val date = binding.editTextDate.text.toString()

        val racingPreferences = getSharedPreferences("racing", Context.MODE_PRIVATE)

//        val editor = racingPreferences.edit()
//        editor.putString("record", record)
//        editor.putString("date", date)
//        editor.apply()  // Old way!!!!

        racingPreferences.edit {
            putString("$config record", record)
            putString("$config date", date)
        }

    }

    private fun clearRecord() {
        racingPreferences.edit {
            remove("$config record")
            remove("$config date")
        }
    }
}