package com.chernybro.wb22

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment


class BaseDialogFragment : DialogFragment() {

    companion object {
        fun newInstance(title: String?): BaseDialogFragment {
            val frag = BaseDialogFragment()
            val args = Bundle()
            args.putString("title", title)
            frag.arguments = args
            return frag
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = requireArguments().getString("title")
        val alertDialogBuilder = AlertDialog.Builder(activity)
        alertDialogBuilder.setTitle(title)
        alertDialogBuilder.setMessage(R.string.dialog_about_message)
        alertDialogBuilder.setPositiveButton("OK") { _, _ -> }
        alertDialogBuilder.setNegativeButton("Cancel") { dialog, _ ->
            dialog?.dismiss()
        }
        return alertDialogBuilder.create()
    }


}