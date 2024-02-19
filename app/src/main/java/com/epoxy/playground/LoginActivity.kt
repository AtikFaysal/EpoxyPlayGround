package com.epoxy.playground

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.epoxy.epoxyView
import com.epoxy.playground.databinding.ActivityMainBinding
import com.epoxy.playground.epoxymodel.appTopBar
import com.epoxy.playground.epoxymodel.textInput
import timber.log.Timber

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private val topBarView by epoxyView(
        viewId = R.id.topBarStub,
        initializer = {},
        modelProvider = {
            appTopBar {
                greeting(getString(R.string.format_greeting, "Atik Faysal"))
                onClickListener {
                    Toast.makeText(this@LoginActivity, "Add money button clicked", Toast.LENGTH_SHORT).show()
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        topBarView.invalidate()
        binding.mainViewRcv.withModels {
            textInput {
                id("phone_number_et")
                text("")
                hint(R.string.hint_enter_phone)
                onTextChange {
                    Timber.e("current text is: $it")
                }
            }
        }
    }
}