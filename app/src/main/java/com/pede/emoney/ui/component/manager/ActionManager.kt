package com.pede.emoney.ui.component.manager

import android.content.Context
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.InstanceIdResult
import com.pede.emoney.ui.component.IAction

class ActionManager : IAction {
    override fun getFirebaseToken(context : Context): String {


        var token: String? = ""



        return token.toString()
    }

    override fun showLabelManager(label: String, labelTextView: TextView, context: Context) {
        labelTextView.text = label
    }

    override fun setupAction(context: Context) {
        Toast.makeText(context, "Show Event", Toast.LENGTH_SHORT).show()
    }
}