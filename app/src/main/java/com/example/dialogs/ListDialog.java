package com.example.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class ListDialog extends DialogFragment {
    private String[] languagesList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        languagesList = getResources().getStringArray(R.array.languages_list);
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.chose_language);
        builder.setItems(languagesList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String lang = languagesList[which];
                ((MainActivity)getActivity()).setTextField(lang);
                dismiss();
            }
        });
        return builder.create();
    }
}
