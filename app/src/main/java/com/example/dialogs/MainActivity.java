package com.example.dialogs;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Button btnWarningDialog, btnExitDialog, btnListDialog, btnMultipleListDialog, btnInputText;
    private Button btnDialogCircle, btnDialogProgress;
    private ProgressDialog progressDialog;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        onClickButtonListener();
    }

    public void initWidgets() {
        tvResult = findViewById(R.id.tvResult);

        btnWarningDialog = findViewById(R.id.btnWarningDialog);
        btnExitDialog = findViewById(R.id.btnExitDialog);
        btnListDialog = findViewById(R.id.btnListDialog);
        btnMultipleListDialog = findViewById(R.id.btnMultipleListDialog);
        btnInputText = findViewById(R.id.btnInputText);
        btnDialogCircle = findViewById(R.id.btnDialogCircle);
        btnDialogProgress =findViewById(R.id.btnDialogProgress);
    }

    public void onClickButtonListener() {
        btnWarningDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WarningDialog wd = new WarningDialog();
                wd.show(getFragmentManager(), "Warning dialog");
            }
        });
        btnExitDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExitDialog ed = new ExitDialog();
                ed.show(getFragmentManager(), "Exit dialog");
            }
        });
        btnListDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListDialog ld = new ListDialog();
                ld.show(getFragmentManager(), "List dialog");
                tvResult.setText("");
            }
        });
        btnMultipleListDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MultipleChoiceListDialog mld = new MultipleChoiceListDialog();
                mld.show(getFragmentManager(), "Multiple list dialog");
                tvResult.setText("");
            }
        });
        btnInputText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertTextDialog itd = new InsertTextDialog();
                itd.show(getFragmentManager(), "Insert Text");
            }
        });
        btnDialogCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = ProgressDialog.show(MainActivity.this, "Loading", "Please wait");
                SeperateThread sp = new SeperateThread(progressDialog, false);
                sp.start();
            }
        });
        btnDialogProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Downloading");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.show();
                SeperateThread sp = new SeperateThread(progressDialog, true);
                sp.start();
            }
        });
    }

    public void setTextField(String item){
        tvResult.setText(item);
    }

    public String getTextField() {
        return tvResult.getText().toString();
    }
}
