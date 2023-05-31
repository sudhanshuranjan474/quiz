package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quiz.databinding.ActivityLoginBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        binding.button.setOnClickListener{
            Firebase.auth.createUserWithEmailAndPassword(binding.email.editText?.text.toString(),
            binding.password.editText?.text.toString()).addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(this, "User Created !!! ",Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this, "User not Created !!! ",Toast.LENGTH_LONG).show()


                }
            }
        }

    }
}