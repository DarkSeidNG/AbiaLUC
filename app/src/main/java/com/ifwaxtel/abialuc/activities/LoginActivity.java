package com.ifwaxtel.abialuc.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ifwaxtel.abialuc.R;
import com.ifwaxtel.abialuc.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityLoginBinding binding;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        progressDialog = new ProgressDialog(this);
        setupViews();
    }

    private void setupViews(){
        binding.loginBtn.setOnClickListener(this);
    }

    private void validateInput(){
        String username = binding.usernameEditText.getText().toString().trim();
        String password = binding.passwordEditText.getText().toString().trim();

        if (username.length() < 6){
            progressDialog.dismiss();
            binding.usernameInputLayout.setError("The username you entered is invalid (must be over over 6 characters long)");
        }
        else if (password.length() < 6){
            progressDialog.dismiss();
            binding.usernameInputLayout.setError("The password you entered is invalid (must be over over 6 characters long)");
        }
        else{
            progressDialog.dismiss();
            openMainActivity();
        }

    }

    private void openMainActivity(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginBtn:
                progressDialog.setMessage("Processing...");
                progressDialog.show();
                validateInput();
                break;
        }
    }
}
