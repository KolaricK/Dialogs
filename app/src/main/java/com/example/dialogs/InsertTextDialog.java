package com.example.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class InsertTextDialog extends DialogFragment {
    private EditText etText;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.insert_text);
        LayoutInflater li = getActivity().getLayoutInflater();
        View v = li.inflate(R.layout.text_dialog, null);
        builder.setView(v);
        etText = v.findViewById(R.id.etText);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity ma = (MainActivity) getActivity();
                ma.setTextField(etText.getText().toString());
                dismiss();
            }
        });
        return  builder.create();
    }
}
