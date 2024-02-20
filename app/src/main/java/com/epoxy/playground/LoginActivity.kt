package com.epoxy.playground

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.epoxy.playground.databinding.ActivityLoginBinding
import com.epoxy.playground.epoxymodel.button
import com.epoxy.playground.epoxymodel.passwordInputField
import com.epoxy.playground.epoxymodel.rememberMe
import com.epoxy.playground.epoxymodel.spacer
import com.epoxy.playground.epoxymodel.textInput
import timber.log.Timber

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding

    private var phoneNumber : String = ""
    private var password : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainViewRcv.withModels {
            textInput() {
                id("phone_number_et")
                inputText("")
                hint(R.string.hint_enter_phone)
                onTextChange {
                    Timber.e("current text is: $it")
                    phoneNumber = it
                }
            }

            spacer {
                id("divider_1")
                height(20)
            }

            passwordInputField {
                id("password_et")
                inputText("")
                hint(R.string.hint_enter_password)
                onTextChange {
                    Timber.e("current password is: $it")
                    password = it
                }
            }

            spacer {
                id("divider_1")
                height(25)
            }

            button {
                id("login_btn")
                buttonText(getString(R.string.action_login))
                onClickListener {
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                }
            }

            rememberMe {
                id("remember_me_view")
                onCheckedChange {
                    Toast.makeText(this@LoginActivity, "isChecked: $it",Toast.LENGTH_SHORT).show()
                }

                onButtonClick {
                    Toast.makeText(this@LoginActivity, "Forgot button clicked",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}