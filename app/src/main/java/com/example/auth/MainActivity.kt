package com.example.auth

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

private lateinit var button: Button
private lateinit var email : EditText
private lateinit var password : EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        email = findViewById(R.id.editTextTextEmailAddress)
        password = findViewById(R.id.editTextTextPassword)

        button.setOnClickListener {
            val em = email.text.toString()
            val pass = password.text.toString()

            if(em.isEmpty() || pass.isEmpty()){
                Toast.makeText(this, "შეიყვანეთ მონაცემები", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(em, pass)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "წარმატებით დარეგისტრირდით!", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                    }
                 }
        }
    }
}