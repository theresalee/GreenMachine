package com.gogreen.greenmachine.fragments;

import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by tlee on 4/27/2015.
 */
public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    /*
    public EditText getTimeText(){
        return (EditText)getArguments().get("time");
    }*/

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        //Convert time from hourOfDay and minute to AM/PM time
        String suffix = "AM";
        if (hourOfDay == 00){
            hourOfDay = 12;
        }
        else if (hourOfDay > 12){
            hourOfDay = hourOfDay - 12;
            suffix = "PM";
        }
        String time = hourOfDay + ":";
        if (minute < 10){
            time = time + "0" + minute;
        }
        else {
            time = time + minute;
        }
        time = time + suffix;
        //getTimeText().setText(time);
    }
}
