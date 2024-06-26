package com.alekseichisitiakov.autolapkeeper.kart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alekseichisitiakov.autolapkeeper.editrecord.EditRacingRecordActivity
import com.alekseichisitiakov.autolapkeeper.databinding.FragmentKartingBinding

class KartingFragment : Fragment() {

    private lateinit var binding : FragmentKartingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentKartingBinding.inflate(inflater, container, false)
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
        val racingPreferences =
            requireContext().getSharedPreferences("racing", Context.MODE_PRIVATE)

        binding.textViewDubaiKartdromeValue.text = racingPreferences.getString("Dubai Kartdrome record", null)
        binding.textViewDubaiKartdromeDate.text = racingPreferences.getString("Dubai Kartdrome date", null)
        binding.textViewKartingTownValue.text =
            racingPreferences.getString("Karting Town record", null)
        binding.textViewKartingTownDate.text =
            racingPreferences.getString("Karting Town date", null)
        binding.textViewRakTrackValue.text =
            racingPreferences.getString("Rak Track record", null)
        binding.textViewRakDate.text =
            racingPreferences.getString("Rak Track date", null)
        binding.textViewFirstKartRaceValue.text = racingPreferences.getString("Full race record", null)
        binding.textViewFirstRaceDate.text = racingPreferences.getString("Full race date", null)
    }

     private fun setupClickListeners() {
        binding.containerKartDubaiKartdrome.setOnClickListener { launchRacingRecordScreen("Dubai Kartdrome") }
        binding.containerKartingTown.setOnClickListener { launchRacingRecordScreen("Karting Town") }
        binding.containerRakTrack.setOnClickListener { launchRacingRecordScreen("Rack Track") }
        binding.containerKartFirstRace.setOnClickListener { launchRacingRecordScreen("Full race") }

    }

     private fun launchRacingRecordScreen(config: String) {
        val intent = Intent(context, EditRacingRecordActivity::class.java)
        intent.putExtra("Config", config )
        startActivity(intent)
    }


}