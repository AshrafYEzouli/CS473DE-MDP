package ashraf.ezouli.quizapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val q1Answer = "AVD Manager"
        val q2Answer = "targetSdkVersion"

        var q1Choice: String? = null
        var q2Choice: String? = null
        var score = 0

        q1Rg.setOnCheckedChangeListener { _, checkedId ->
            val clicked: RadioButton = q1Rg.findViewById(checkedId) as RadioButton
            val checked = clicked.isChecked
            if (checked) {
                q1Choice = clicked.text.toString()
            }
        }

        choice1Cb.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked) {
                q2Choice = choice1Cb.text.toString()
                choice2Cb.isChecked = false
                choice3Cb.isChecked = false
            }
        }

        choice2Cb.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked) {
                q2Choice = choice2Cb.text.toString()
                choice1Cb.isChecked = false
                choice3Cb.isChecked = false
            }
        }

        choice3Cb.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked) {
                q2Choice = choice3Cb.text.toString()
                choice2Cb.isChecked = false
                choice1Cb.isChecked = false
            }
        }

        submitBtn.setOnClickListener {
            if(q1Choice == q1Answer) score += 50
            if(q2Choice == q2Answer) score += 50

            val c = Calendar.getInstance()

            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("${c.get(Calendar.MONTH)}-${c.get(Calendar.DAY_OF_MONTH)}-${c.get(Calendar.YEAR)}  " +
                    "${c.get(Calendar.HOUR_OF_DAY)}:${c.get(Calendar.MINUTE)}")
            builder.setMessage("Your Score: $score")
            builder.setNeutralButton("OK"){ dialogInterface, _ ->
                dialogInterface.dismiss()
                q1Choice = ""
                q2Choice = ""
                score = 0
            }
            val dialog: AlertDialog = builder.create()
            dialog.setCancelable(false)
            dialog.show()
        }

        resetBtn.setOnClickListener {
            if(q1Rg.checkedRadioButtonId != -1) {
                q1Choice = ""
                q2Choice = ""
                score = 0
                choice1Rb.isChecked = false
                choice2Rb.isChecked = false
                choice3Rb.isChecked = false
                choice1Cb.isChecked = false
                choice2Cb.isChecked = false
                choice3Cb.isChecked = false
            }
        }
    }
}