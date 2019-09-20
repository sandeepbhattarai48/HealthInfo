package com.example.healthinfo;

import android.app.NotificationManager;
import android.app.TimePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.healthinfo.AlarmParams;
import com.example.healthinfo.AlarmTime;
import com.example.healthinfo.R;
import com.example.healthinfo.SharedPreferencesHelper;
import com.example.healthinfo.TimerManager;
import com.example.healthinfo.IntervalDialogFragment;
import com.example.healthinfo.NumberOfAlarmsDialogFragment;
import com.example.healthinfo.TimePickerDialogFragment;
import com.example.healthinfo.AlarmsListHelper;
import com.example.healthinfo.NotificationIconHelper;

public class AlarmMainActivity extends AppCompatActivity implements IntervalDialogFragment.IntervalDialogListener,
        NumberOfAlarmsDialogFragment.NumberOfAlarmsDialogListener,
        TimePickerDialog.OnTimeSetListener {

    SwitchCompat onOffSwitch;
    ListView alarmsListView;
    TextView intervalBetweenAlarmsTextView;
    TextView numberOfAlarmsTextView;
    TextView firstAlarmTextView;
    TextView timeLeftTextView;
    LinearLayout firstAlarmLayout;
    LinearLayout intervalLayout;
    LinearLayout numberOfAlarmsLayout;
    NotificationIconHelper nIconHelper;
    AlarmsListHelper alarmsListHelper;
    SharedPreferencesHelper sharPrefHelper;
    TimerManager timerManager;
    AlarmParams alarmParams;
    BroadcastReceiver timeLeftReceiver;
    private final String LOG_TAG = AlarmMainActivity.class.getSimpleName();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_main);

        getSupportActionBar().setTitle("Medico Remainder");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        alarmsListView = (ListView) findViewById(R.id.listview_main_alarmslist);
        onOffSwitch = (SwitchCompat) findViewById(R.id.switch_main);
        intervalBetweenAlarmsTextView = (TextView) findViewById(R.id.textview_main_interval);
        numberOfAlarmsTextView = (TextView) findViewById(R.id.textview_main_numberofalarms);
        firstAlarmLayout = (LinearLayout) findViewById(R.id.layout_main_firstalarm);
        firstAlarmTextView = (TextView) findViewById(R.id.textview_main_firstalarm_time);
        timeLeftTextView = (TextView) findViewById(R.id.textview_main_timeleft);
        intervalLayout = (LinearLayout) findViewById(R.id.layout_main_interval);
        numberOfAlarmsLayout = (LinearLayout) findViewById(R.id.layout_main_numberofalarms);

        sharPrefHelper = new SharedPreferencesHelper(AlarmMainActivity.this);
        sharPrefHelper.printAll();

        alarmParams = sharPrefHelper.getParams();
        timerManager = new TimerManager(AlarmMainActivity.this);
//        nIconHelper = new NotificationIconHelper(MainActivity.this);
        alarmsListHelper = new AlarmsListHelper(AlarmMainActivity.this, alarmsListView);

        showFirstAlarmTime(alarmParams.firstAlarmTime.toString());
        showTimeLeft(alarmParams);

        showInterval(sharPrefHelper.getIntervalStr());
        showNumberOfAlarms(sharPrefHelper.getNumberOfAlarmsStr());
        onOffSwitch.setChecked(sharPrefHelper.isAlarmTurnedOn());
//        nIconHelper.setNotificationIcon(sharPrefHelper.isAlarmTurnedOn());

        alarmsListHelper.showList(alarmParams);

        onOffSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                alarmParams.turnedOn = isChecked;
                if (isChecked) {
                    checkNotificationPolicy();
//                    timerManager.startTimer(alarmParams);
                    timerManager.startSingleAlarmTimer(alarmParams.firstAlarmTime.toMillis());
//                    nIconHelper.showNotificationIcon();
                    showToast(getString(R.string.main_alarm_turned_on_toast));
                    sharPrefHelper.setNumberOfAlreadyRangAlarms(0);
                } else {
                    timerManager.cancelTimer();
//                    nIconHelper.hideNotificationIcon();
                    showToast(getString(R.string.main_alarm_turned_off_toast));
                }
                alarmsListHelper.showList(alarmParams);
                showTimeLeft(alarmParams);
                sharPrefHelper.setAlarmState(isChecked);
            }
        });

        intervalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntervalDialogFragment dialog = new IntervalDialogFragment();
                Bundle intervalBundle = new Bundle();
                intervalBundle.putString("interval", sharPrefHelper.getIntervalStr());
                dialog.setArguments(intervalBundle);
                dialog.show(getFragmentManager(), "intervalDialog");
            }
        });

        numberOfAlarmsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberOfAlarmsDialogFragment dialog = new NumberOfAlarmsDialogFragment();
                Bundle numberOfAlarmsBundle = new Bundle();
                numberOfAlarmsBundle.putString("number_of_alarms", sharPrefHelper.getNumberOfAlarmsStr());
                dialog.setArguments(numberOfAlarmsBundle);
                dialog.show(getFragmentManager(), "numberOfAlarmsDialog");
            }
        });

        firstAlarmLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle timePickerBundle = new Bundle();
                timePickerBundle.putInt("alarm_hour", sharPrefHelper.getHour());
                timePickerBundle.putInt("alarm_minute", sharPrefHelper.getMinute());

                TimePickerDialogFragment timePicker = new TimePickerDialogFragment();

                timePicker.setArguments(timePickerBundle);
                timePicker.show(getFragmentManager(), "time_picker");
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onResume() {
        super.onResume();
        showTimeLeft(alarmParams);
        timeLeftReceiver = new BroadcastReceiver() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onReceive(Context ctx, Intent intent) {
                if (intent.getAction().compareTo(Intent.ACTION_TIME_TICK) == 0) {  //i.e. every minute
                    showTimeLeft(alarmParams);
                }
            }
        };
        registerReceiver(timeLeftReceiver, new IntentFilter(Intent.ACTION_TIME_TICK));
    }



    @Override
    protected void onPause() {
        super.onPause();
        if (timeLeftReceiver != null) {
            unregisterReceiver(timeLeftReceiver);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case android.R.id.home:
                this.finish();
                return true;

            case R.id.action_settings: {
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
                break;

            }
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onIntervalChanged(String intervalStr) {
        showInterval(intervalStr);
        alarmParams.interval = Integer.parseInt(intervalStr);
        alarmsListHelper.showList(alarmParams);
        resetTimerIfTurnedOn();
        sharPrefHelper.setInterval(intervalStr);
    }

    @Override
    public void onNumberOfAlarmsChanged(String numberOfAlarmsStr) {
        showNumberOfAlarms(numberOfAlarmsStr);
        alarmParams.numberOfAlarms = Integer.parseInt(numberOfAlarmsStr);
        alarmsListHelper.showList(alarmParams);
        resetTimerIfTurnedOn();
        sharPrefHelper.setNumberOfAlarms(numberOfAlarmsStr);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onTimeSet(TimePicker view, int hour, int minute) {
        AlarmTime alarmTime = new AlarmTime(hour, minute);
        alarmParams.firstAlarmTime = alarmTime;
        showFirstAlarmTime(alarmTime.toString());
        alarmsListHelper.showList(alarmParams);
        showTimeLeft(alarmParams);
        sharPrefHelper.setNumberOfAlreadyRangAlarms(0);
        resetTimerIfTurnedOn();
        sharPrefHelper.setTime(alarmTime);
    }

    private void showToast(String message) {
        Toast.makeText(AlarmMainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    private void resetTimerIfTurnedOn() {
        if (onOffSwitch.isChecked()) {
//            timerManager.resetTimer(alarmParams);
            timerManager.resetSingleAlarmTimer(alarmParams.firstAlarmTime.toMillis());
            showToast(getString(R.string.main_alarm_reset_toast));
        }
    }

    private void showInterval(String interval) {
        String wholeTitle = getString(R.string.main_interval, interval);
        SpannableString wholeTitleSpan = new SpannableString(wholeTitle);
        wholeTitleSpan.setSpan(new RelativeSizeSpan(2f), wholeTitle.indexOf(interval), interval.length() + 1, 0);
        intervalBetweenAlarmsTextView.setText(wholeTitleSpan);
    }

    private void showNumberOfAlarms(String numberOfAlarms) {
        int numberOfAlarmsInt = Integer.parseInt(numberOfAlarms);
        String wholeTitle = this.getResources().getQuantityString(R.plurals.main_number_of_alarms, numberOfAlarmsInt, numberOfAlarmsInt);
        SpannableString wholeTitleSpan = new SpannableString(wholeTitle);
        wholeTitleSpan.setSpan(new RelativeSizeSpan(2f), wholeTitle.indexOf(numberOfAlarms),
                numberOfAlarms.length() + 1, 0);
        numberOfAlarmsTextView.setText(wholeTitleSpan);
    }

    private void showFirstAlarmTime(String firstAlarmTime) {
        String wholeTitle = getString(R.string.main_firstalarm_time, firstAlarmTime);
        SpannableString wholeTitleSpan = new SpannableString(wholeTitle);
        wholeTitleSpan.setSpan(new RelativeSizeSpan(2f), wholeTitle.indexOf(firstAlarmTime) - 1,
                wholeTitle.indexOf(firstAlarmTime) + firstAlarmTime.length(), 0);
        firstAlarmTextView.setText(wholeTitleSpan);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void showTimeLeft(AlarmParams alarmParams) {
        AlarmTime alarmTime = alarmParams.firstAlarmTime;
        timeLeftTextView.setText(getString(R.string.all_time_left, alarmTime.getHoursLeft(), alarmTime.getMinutesLeft()));
        if (alarmParams.turnedOn) {
            timeLeftTextView.setTextColor(getColor(R.color.primary));
        } else {
            timeLeftTextView.setTextColor(getColor(R.color.main_disabled_textcolor));
        }
        Log.d(LOG_TAG, "Time left: "+alarmTime.getHoursLeft() + ":" + alarmTime.getMinutesLeft());
    }

    private void checkNotificationPolicy() {
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && !notificationManager.isNotificationPolicyAccessGranted()) {
            Intent intent = new Intent(
                    android.provider.Settings
                            .ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
            startActivity(intent);
        }



    }



    }










