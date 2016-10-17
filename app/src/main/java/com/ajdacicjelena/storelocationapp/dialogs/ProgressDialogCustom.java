package com.ajdacicjelena.storelocationapp.dialogs;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressDialogCustom extends ProgressDialog {
    public ProgressDialogCustom(Context context) {
        super(context);
    }

    /*
    function to show dialog
    */
    public void showDialog(String msg) {
        if (!isShowing()) {
            setMessage(msg);
            show();
        }
    }

    /*
    function to hide dialog
     */
    public void hideDialog() {
        if (isShowing())
            dismiss();
    }
}