package com.example.communicationbetweenfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container,SenderFragment()).commit()
    }

    override fun passData(message: String) {
        val bundle = Bundle()
        bundle.putString("message", message)
        val fragment = ReceiverFragment()
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}