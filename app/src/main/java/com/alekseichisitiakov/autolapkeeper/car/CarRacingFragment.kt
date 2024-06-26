package com.alekseichisitiakov.autolapkeeper.car

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alekseichisitiakov.autolapkeeper.editrecord.EditRacingRecordActivity
import com.alekseichisitiakov.autolapkeeper.databinding.FragmentRacingCarBinding

class CarRacingFragment : Fragment() {

    private lateinit var binding: FragmentRacingCarBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentRacingCarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    override fun onResume() {
        super.onResume()
        displayRecords()
    }

    private fun displayRecords() {
        val racingPreferences = requireContext().getSharedPreferences("racing", Context.MODE_PRIVATE)

        binding.textViewClubValue.text = racingPreferences.getString("Club config record", null)
        binding.textViewClubDate.text = racingPreferences.getString("Club config date", null)
        binding.textViewInternationalValue.text = racingPreferences.getString("International config record", null)
        binding.textViewInternationalDate.text = racingPreferences.getString("International config date", null)
        binding.textViewNationalValue.text = racingPreferences.getString("National config record", null)
        binding.textViewNationalDate.text = racingPreferences.getString("National config date", null)
        binding.textViewGpValue.text = racingPreferences.getString("GP config record", null)
        binding.textViewGpDate.text = racingPreferences.getString("GP config date", null)
    }

    private fun setupClickListeners() {
        binding.containerClub.setOnClickListener { launchRacingRecordScreen("Club config") }
        binding.containerInternational.setOnClickListener { launchRacingRecordScreen("International config") }
        binding.containerNational.setOnClickListener { launchRacingRecordScreen("National config") }
        binding.containerGp.setOnClickListener { launchRacingRecordScreen("GP config") }

    }

    private fun launchRacingRecordScreen(config: String) {
        val intent = Intent(context, EditRacingRecordActivity::class.java)
        intent.putExtra("Config", config )
        startActivity(intent)
    }


}