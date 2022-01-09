package com.example.tictac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var playerTurn: Int = 1
    var selectedBtnId = 0
    var winner = -1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun ChoiceBlock(view: View) {
        val selectedButton = view as Button

        when (selectedButton.id) {
            R.id.button1 -> selectedBtnId = 1
            R.id.button2 -> selectedBtnId = 2
            R.id.button3 -> selectedBtnId = 3
            R.id.button4 -> selectedBtnId = 4
            R.id.button5 -> selectedBtnId = 5
            R.id.button6 -> selectedBtnId = 6
            R.id.button7 -> selectedBtnId = 7
            R.id.button8 -> selectedBtnId = 8
            R.id.button9 -> selectedBtnId = 9


        }
        PlayGame(selectedBtnId, selectedButton)
        DecideWinner()

    }

    fun PlayGame(selectedBtnId: Int, selectedButton: Button) {

        if (playerTurn == 1) {
            selectedButton.text = "X"
            selectedButton.backgroundTintList = ContextCompat.getColorStateList(this, R.color.teal_700)
            player1.add(selectedBtnId)
            selectedButton.setTextColor(resources.getColor(R.color.white))
            playerTurn = 2

        } else if (playerTurn==2){
            selectedButton.text = "O"
            selectedButton.backgroundTintList = ContextCompat.getColorStateList(this, R.color.purple_700)
            selectedButton.setTextColor(resources.getColor(R.color.white))
            player2.add(selectedBtnId)
            playerTurn = 1
        }
        selectedButton.isEnabled = false

    }

    fun DecideWinner() {

        if (player1.contains(1) && player1.contains(4) && player1.contains(7) || player1.contains(2) && player1.contains(
                5
            ) && player1.contains(8) || player1.contains(3) && player1.contains(6) && player1.contains(
                9
            )
        ) {
            winner = 1
            Toast.makeText(this, "Player $winner is winner", Toast.LENGTH_LONG).show()
            timer.start()


        } else if (player2.contains(1) && player2.contains(4) && player2.contains(7) || player2.contains(
                2
            ) && player2.contains(5) && player2.contains(8) || player2.contains(3) && player2.contains(
                6
            ) && player2.contains(9)
        ) {
            winner = 2
            Toast.makeText(this, "Player $winner is winner", Toast.LENGTH_LONG).show()
            timer.start()

        }
        if (player1.contains(1) && player1.contains(2) && player1.contains(3) || player1.contains(4) && player1.contains(
                5
            ) && player1.contains(6) || player1.contains(7) && player1.contains(8) && player1.contains(
                9
            )
        ) {
            winner = 1
            Toast.makeText(this, "Player $winner is winner", Toast.LENGTH_LONG).show()
            timer.start()

        } else if (player2.contains(1) && player2.contains(2) && player2.contains(3) || player2.contains(
                4
            ) && player2.contains(5) && player2.contains(6) || player2.contains(7) && player2.contains(
                8
            ) && player2.contains(9)
        ) {
            winner = 2
            Toast.makeText(this, "Player $winner is winner", Toast.LENGTH_LONG).show()
            timer.start()
        }
        if (player1.contains(1) && player1.contains(5) && player1.contains(9) || player1.contains(3) && player1.contains(
                5
            ) && player1.contains(7)
        ) {
            winner = 1
            Toast.makeText(this, "Player $winner is winner", Toast.LENGTH_LONG).show()
            timer.start()


        } else if (player2.contains(1) && player2.contains(5) && player2.contains(9) || player2.contains(
                3
            ) && player2.contains(5) && player2.contains(7)
        ) {
            winner = 2
            Toast.makeText(this, "Player $winner is winner", Toast.LENGTH_LONG).show()
            timer.start()
        }


    }
    val timer = object : CountDownTimer(6000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            var seconds = millisUntilFinished / 1000
            timertxt.setTextColor(resources.getColor(R.color.red))
            timertxt.visibility=View.VISIBLE
            timertxt.text = seconds.toString()
        }

        override fun onFinish() {
            playerTurn = 1
            winner = -1
            player1.clear()
            player2.clear()
            timertxt.visibility=View.INVISIBLE
            button1.isEnabled=true
            button2.isEnabled=true
            button3.isEnabled=true
            button4.isEnabled=true
            button5.isEnabled=true
            button6.isEnabled=true
            button7.isEnabled=true
            button8.isEnabled=true
            button9.isEnabled=true
            button1.text =""
            button2.text =""
            button3.text =""
            button4.text =""
            button5.text =""
            button6.text =""
            button7.text =""
            button8.text =""
            button9.text =""
            button1.backgroundTintList = ContextCompat.getColorStateList(this@MainActivity,R.color.lightgray)
            button2.backgroundTintList = ContextCompat.getColorStateList(this@MainActivity,R.color.lightgray)
            button3.backgroundTintList = ContextCompat.getColorStateList(this@MainActivity,R.color.lightgray)
            button4.backgroundTintList = ContextCompat.getColorStateList(this@MainActivity,R.color.lightgray)
            button5.backgroundTintList = ContextCompat.getColorStateList(this@MainActivity,R.color.lightgray)
            button6.backgroundTintList = ContextCompat.getColorStateList(this@MainActivity,R.color.lightgray)
            button7.backgroundTintList = ContextCompat.getColorStateList(this@MainActivity,R.color.lightgray)
            button8.backgroundTintList = ContextCompat.getColorStateList(this@MainActivity,R.color.lightgray)
            button9.backgroundTintList = ContextCompat.getColorStateList(this@MainActivity,R.color.lightgray)

        }

    }




}