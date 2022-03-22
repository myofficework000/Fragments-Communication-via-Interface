package com.example.communicationbetweenfragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


class SenderFragment : Fragment() {

    private lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sender, container, false)

        communicator = activity as Communicator

        Log.i("tag", "Sender Frag onCreateView")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edtMessage = view.findViewById<EditText>(R.id.edt_message)
        val buttonSend = view.findViewById<Button>(R.id.submit)

        buttonSend.setOnClickListener {
            communicator.passData(edtMessage.text.toString())
        }
    }
}