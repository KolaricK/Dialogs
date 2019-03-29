package com.example.dialogs;

import android.app.ProgressDialog;
import android.widget.Toast;

public class SeperateThread extends Thread {
    private ProgressDialog progressDialog;
    private boolean hasProgress;

    public SeperateThread(ProgressDialog progressDialog, boolean hasProgress) {
        this.progressDialog = progressDialog;
        this.hasProgress = hasProgress;
    }

    @Override
    public void run() {
        if (hasProgress) {
            sleepWithProgress();
        } else {
            sleepWithNoProgress();
        }
        progressDialog.dismiss();
    }

    private void sleepWithProgress() {
        try {
            while (progressDialog.getProgress() < 100) {
                Thread.sleep(1000);
                progressDialog.incrementProgressBy(5);
            }
        } catch (InterruptedException e) {

        }
    }

    private void sleepWithNoProgress() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
    }
}
