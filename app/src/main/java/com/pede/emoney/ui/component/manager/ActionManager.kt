package com.pede.emoney.ui.component.manager

import android.content.Context
import android.util.Log
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

        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w("", "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }
                val token = task.result?.token
                Toast.makeText(context, token, Toast.LENGTH_SHORT).show()
            })

        return token.toString()
    }

    override fun isLatestVersion(currentVersion: String, latestVersion: String): Boolean {
        val currentVersionSplit =
            currentVersion.split("[\\.]".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val latestVersionSplit =
            latestVersion.split("[\\.]".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        for (i in currentVersionSplit.indices) {
            if (Integer.valueOf(currentVersionSplit[i]) < Integer.valueOf(latestVersionSplit[i])) {
                return false
            }
        }

        return true
    }

    override fun showLabelManager(label: String, labelTextView: TextView, context: Context) {
        labelTextView.text = label
    }

    override fun setupAction(context: Context) {
        Toast.makeText(context, "Show Event", Toast.LENGTH_SHORT).show()
    }
}