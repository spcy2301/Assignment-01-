package com.example.firebase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clear.setOnClickListener {
            first.setText("")
            last.setText("")
        }
        send.setOnClickListener {
            val firstn= first.text.toString()
            val lastn = last.text.toString()

            val firebase = FirebaseDatabase.getInstance()
            val ref = firebase.getReference("Employee")
            val id:String? = ref.push().key

            val Employee = Employee(id.toString(),firstn,lastn)
            ref.child(id.toString()).setValue(Employee).addOnCompleteListener {
                Toast.makeText(applicationContext,"Complete", Toast.LENGTH_LONG).show()
                first.setText("")
                last.setText("")
            }
        }

    }
}