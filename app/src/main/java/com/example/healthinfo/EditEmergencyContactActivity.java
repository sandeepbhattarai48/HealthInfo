package com.example.healthinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class EditEmergencyContactActivity extends AppCompatActivity {
    EditText etFullName, etMobile, etEmail;
    Spinner spCountryCode;
    TextView tvErrFullName, tvErrMobile, tvErrEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_emergency_contact);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        TextView toolbarTitle = findViewById(R.id.custom_toolbar_title);
        toolbarTitle.setText("Edit EmergencyActivity Contact");

        etFullName = findViewById(R.id.edt_full_name);
        etMobile = findViewById(R.id.edt_mobile);
        etEmail = findViewById(R.id.edt_email);
        tvErrFullName = findViewById(R.id.error_full_name);
        tvErrMobile = findViewById(R.id.error_mobile);
        tvErrEmail = findViewById(R.id.error_email);

        Button btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validation()) {

                }
            }
        });

    }

    private void editEmergencyContactTask() {
        Toast.makeText(this, "TODO", Toast.LENGTH_SHORT).show();
    }

    private boolean validation() {
        boolean isValid = true;

        if (TextUtils.isEmpty(etFullName.getText())) {
            isValid = false;
            tvErrFullName.setVisibility(View.VISIBLE);
            tvErrFullName.setText("Field Required");
        } else {
            tvErrMobile.setVisibility(View.GONE);
        }

        if (TextUtils.isEmpty(etMobile.getText())) {
            isValid = false;
            tvErrMobile.setVisibility(View.VISIBLE);
            tvErrMobile.setText("Field Required");
        } else {
            if (!Patterns.PHONE.matcher(etMobile.getText().toString().trim()).matches()) {
                isValid = false;
                tvErrMobile.setVisibility(View.VISIBLE);
                tvErrMobile.setText("Invalid Mobile Number");
            } else {
                tvErrMobile.setVisibility(View.GONE);
            }
        }

        if (TextUtils.isEmpty(etEmail.getText().toString().trim())) {
            isValid = false;
            tvErrEmail.setVisibility(View.VISIBLE);
            tvErrEmail.setText("Field Required");
        } else {
            if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString().trim()).matches()) {
                isValid = false;
                tvErrEmail.setVisibility(View.VISIBLE);
                tvErrEmail.setText("Invalid Email");
            } else {
                tvErrEmail.setVisibility(View.GONE);
            }
        }


        return isValid;
    }
}
