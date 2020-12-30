package com.ekawafers.scorecounter_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*

class ScoreCounterViewModel : ViewModel() {

    private val ScoreA : MutableLiveData<Int>? = MutableLiveData()
    private val ScoreB : MutableLiveData<Int>? = MutableLiveData()

    fun addScoreA(){
        val result = getScoreA()?.value?.plus(1)
        ScoreA?.value = result
    }

    fun addScoreB(){
        val result = getScoreB()?.value?.plus(1)
        ScoreB?.value = result
    }

    fun minusScoreA(){
        val result = getScoreA()?.value?.minus(1)
        if(result !! < 0) {
            ScoreA?.value = 0
        }else {
            ScoreA?.value = result
        }
    }

    fun minusScoreB(){
        val result = getScoreB()?.value?.minus(1)
        if(result !! < 0) {
            ScoreB?.value = 0
        }else {
            ScoreB?.value  = result
        }

    }
    fun resetScore(){
        ScoreA?.value = 0
        ScoreB?.value = 0
    }

    fun getScoreA(): LiveData<Int>?{
        if(ScoreA?.value == null){
            ScoreA?.value =0
        }
        return ScoreA
    }

    fun getScoreB(): LiveData<Int>?{
        if(ScoreB?.value == null){
            ScoreB?.value =0
        }
        return ScoreB
    }

}