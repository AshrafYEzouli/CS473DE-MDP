package ashraf.ezouli.tablelayout

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addBtn.setOnClickListener {
            if(versionCodeEt.text.toString().isNotEmpty() && codeNameEt.text.toString().isNotEmpty()) {
                addRow(versionCodeEt.text.toString(), codeNameEt.text.toString())
            } else {
                Toast.makeText(this@MainActivity, "Please fill out both texts", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun addRow(versionCodeTxt: String, codeNameTxt: String) {
        val tableRow = TableRow(ContextThemeWrapper(this@MainActivity, R.style.BodyTableRowStyle))

        val versionCodeTv = TextView(ContextThemeWrapper(this@MainActivity, R.style.TableRowTextViewStyle))
        versionCodeTv.text = versionCodeTxt
//        versionCodeTv.setTextAppearance(R.style.TableRowTextViewStyle)
//        versionCodeTv.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)

        val codeNameTv = TextView(ContextThemeWrapper(this@MainActivity, R.style.TableRowTextViewStyle) )
        codeNameTv.text = codeNameTxt
//        codeNameTv.setTextAppearance(R.style.TableRowTextViewStyle)
//        codeNameTv.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)

        tableRow.addView(versionCodeTv)
        tableRow.addView(codeNameTv)

        tableLayout.addView(tableRow)

        versionCodeEt.text.clear()
        codeNameEt.text.clear()

        Toast.makeText(this@MainActivity, "Your item has been added successfully", Toast.LENGTH_SHORT).show()
    }
}