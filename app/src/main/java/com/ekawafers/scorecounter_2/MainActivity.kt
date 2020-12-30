package com.ekawafers.scorecounter_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var counterViewModel: ScoreCounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterViewModel = ViewModelProvider(this)
            .get(ScoreCounterViewModel::class.java)

        initView()

        btnPlusScoreTeamA.setOnClickListener(this)
        btnMinusScoreTeamA.setOnClickListener(this)
        btnPlusScoreTeamB.setOnClickListener(this)
        btnMinusScoreTeamB.setOnClickListener(this)
        btnReset.setOnClickListener(this)
    }

    private fun initView() {
        counterViewModel.getScoreA()?.observe(this, Observer {
            if (it != null){
                tvScoreTeamA.text = it.toString()
            }
        })

        counterViewModel.getScoreB()?.observe(this, Observer {
            if (it != null){
                tvScoreTeamB.text = it.toString()
            }
        })
    }

    override  fun onClick(v: View?){
            when(v?.id){
                R.id.btnPlusScoreTeamA -> {
                    counterViewModel.addScoreA()
                }
                R.id.btnMinusScoreTeamA -> {
                    counterViewModel.minusScoreA()
                }
                R.id.btnPlusScoreTeamB -> {
                    counterViewModel.addScoreB()
                }
                R.id.btnMinusScoreTeamB -> {
                    counterViewModel.minusScoreB()
                }
                R.id.btnReset -> {
                    counterViewModel.resetScore()
                }
            }
        }




}
