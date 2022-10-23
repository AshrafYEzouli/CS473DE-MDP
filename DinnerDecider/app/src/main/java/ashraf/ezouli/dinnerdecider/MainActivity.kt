package ashraf.ezouli.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodList = mutableListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

        decideBtn.setOnClickListener {
            foodTv.text = foodList.random()
        }

        addFoodBtn.setOnClickListener {
            if(addNewFodEt.text != null && addNewFodEt.text.isNotEmpty()) {
                foodList.add(addNewFodEt.text.toString())
                Toast.makeText(this@MainActivity, "${addNewFodEt.text} has added to your list", Toast.LENGTH_SHORT).show()
                addNewFodEt.text.clear()
            } else {
                Toast.makeText(this@MainActivity, "Please enter your food", Toast.LENGTH_SHORT).show()
            }
        }
    }
}