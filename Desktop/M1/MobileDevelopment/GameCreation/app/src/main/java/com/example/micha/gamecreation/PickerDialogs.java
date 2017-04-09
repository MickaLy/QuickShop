package com.example.micha.gamecreation;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by micha on 09/04/2017.
 */

public class PickerDialogs extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();

        int year = calendar.get(java.util.Calendar.YEAR);
        int month = calendar.get(java.util.Calendar.MONTH);
        int day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog;

        return super.onCreateDialog(savedInstanceState);
    }
}
