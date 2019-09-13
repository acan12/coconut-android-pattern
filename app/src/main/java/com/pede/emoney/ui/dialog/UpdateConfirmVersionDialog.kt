package com.pede.emoney.ui.dialog

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import app.beelabs.com.codebase.base.BaseDialog
import com.pede.emoney.R
import kotlinx.android.synthetic.main.dialog_update_confirm_version.*

class UpdateConfirmVersionDialog(context: Context, style: Int) : BaseDialog(context, style) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setWindowContentDialogLayout(R.layout.dialog_update_confirm_version)

        btnOk.setOnClickListener { gotoPlaystore() }
        btnClose.setOnClickListener { dismiss() }
    }

    private fun gotoPlaystore() {
        val appPackageName = context.packageName
        try {
            startActivity(
                context,
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=$appPackageName")
                ),
                null
            )
        } catch (ex: Exception) {
            startActivity(
                context,
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                ),
                null
            )
        }
        dismiss()
    }
}