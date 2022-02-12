package com.nghiemtuananh.cuocduakythukpt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.core.view.isInvisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var soDiem = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DisableSeekBar()
        tv_diemso.text = soDiem.toString()
        var countDownTimer = object : CountDownTimer(60000, 300) {
            override fun onTick(millisUntilFinished: Long) {
                val number = 5
                var random = Random
                var one = random.nextInt(number)
                var two = random.nextInt(number)
                var three = random.nextInt(number)

                if (sb_1.progress >= sb_1.max) {
                    this.cancel()
                    Toast.makeText(this@MainActivity, "ONE WIN", Toast.LENGTH_SHORT).show()
                    btn_play.isInvisible = false
                    if (cb_1.isChecked) {
                        soDiem += 10
                        Toast.makeText(this@MainActivity, "Bạn đoán chính xác", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        soDiem -= 5
                        Toast.makeText(this@MainActivity, "Bạn đoán sai rồi", Toast.LENGTH_SHORT)
                            .show()
                    }
                    tv_diemso.text = soDiem.toString()
                    EnableCheckBox()
                }else if (sb_2.progress >= sb_2.max) {
                    this.cancel()
                    Toast.makeText(this@MainActivity, "TWO WIN", Toast.LENGTH_SHORT).show()
                    btn_play.isInvisible = false
                    if (cb_2.isChecked) {
                        soDiem += 10
                        Toast.makeText(this@MainActivity, "Bạn đoán chính xác", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        soDiem -= 5
                        Toast.makeText(this@MainActivity, "Bạn đoán sai rồi", Toast.LENGTH_SHORT)
                            .show()
                    }
                    tv_diemso.text = soDiem.toString()
                    EnableCheckBox()
                }else if (sb_3.progress >= sb_3.max) {
                    this.cancel()
                    Toast.makeText(this@MainActivity, "THREE WIN", Toast.LENGTH_SHORT).show()
                    btn_play.isInvisible = false
                    if (cb_3.isChecked) {
                        soDiem += 10
                        Toast.makeText(this@MainActivity, "Bạn đoán chính xác", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        soDiem -= 5
                        Toast.makeText(this@MainActivity, "Bạn đoán sai rồi", Toast.LENGTH_SHORT)
                            .show()
                    }
                    tv_diemso.text = soDiem.toString()
                    EnableCheckBox()
                }

                sb_1.setProgress(sb_1.progress + one)
                sb_2.setProgress(sb_2.progress + two)
                sb_3.setProgress(sb_3.progress + three)
            }

            override fun onFinish() {

            }
        }
        btn_play.setOnClickListener {
            if (cb_1.isChecked || cb_2.isChecked || cb_3.isChecked) {
                sb_1.setProgress(0)
                sb_2.setProgress(0)
                sb_3.setProgress(0)

                btn_play.isInvisible = true
                countDownTimer.start()
                DisableCheckBox()
            } else {
                Toast.makeText(this, "Vui lòng đặt cược trước khi chơi!", Toast.LENGTH_SHORT).show()
            }
        }
        cb_1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                cb_2.isChecked = false
                cb_3.isChecked = false
            }
        }
        cb_2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                cb_1.isChecked = false
                cb_3.isChecked = false
            }
        }
        cb_3.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                cb_2.isChecked = false
                cb_1.isChecked = false
            }
        }
    }

    private fun EnableCheckBox() {
        cb_1.isEnabled = true
        cb_2.isEnabled = true
        cb_3.isEnabled = true
    }

    private fun DisableCheckBox() {
        cb_1.isEnabled = false
        cb_2.isEnabled = false
        cb_3.isEnabled = false
    }

    private fun DisableSeekBar() {
        sb_1.isEnabled = false
        sb_2.isEnabled = false
        sb_3.isEnabled = false
    }
}