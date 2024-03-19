package com.thexcoders.mypasswordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.thexcoders.mypasswordgenerator.models.database.DatabaseHelper;
import com.thexcoders.mypasswordgenerator.models.database.SavePassword;
import com.thexcoders.mypasswordgenerator.models.generators.LowerCaseGenerator;
import com.thexcoders.mypasswordgenerator.models.generators.NumericGenerator;
import com.thexcoders.mypasswordgenerator.models.generators.PasswordGenerator;
import com.thexcoders.mypasswordgenerator.models.generators.SpecialCharGenerator;
import com.thexcoders.mypasswordgenerator.models.generators.UpperCaseGenerator;
import com.thexcoders.mypasswordgenerator.models.password.Password;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editPasswordSize;
    private TextView textPasswordGenerated,textErrorMessage;
    private CheckBox checkLower, checkUpper,checkSpecialChar, checkNumeric;
    private Button btnGenerate, btnCopy,btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        clickListeners();

        displaySavedPasswords(); //TODO : to be removed later
    }

    private void displaySavedPasswords() {
        DatabaseHelper db = new DatabaseHelper(MainActivity.this);
        List<Password> passwordList = db.getPasswordList();
        Log.e("PWD_LIST",passwordList.toString());
    }

    private void clickListeners() {
        btnGenerate.setOnClickListener(view -> {
            int passwordSize = Integer.parseInt(editPasswordSize.getText().toString());

            textErrorMessage.setText("");

            if(passwordSize<6){
                textErrorMessage.setText("Password Size must be greater than 6");
                return;
            }

            PasswordGenerator.clear();
            if(checkLower.isChecked()) PasswordGenerator.add(new LowerCaseGenerator());
            if(checkNumeric.isChecked()) PasswordGenerator.add(new NumericGenerator());
            if(checkUpper.isChecked()) PasswordGenerator.add(new UpperCaseGenerator());
            if(checkSpecialChar.isChecked()) PasswordGenerator.add(new SpecialCharGenerator());


            if(PasswordGenerator.isEmpty()){
                textErrorMessage.setText("Please select at least one password content type");
                return;
            }

            String passwrd = PasswordGenerator.generatePassword(passwordSize);
            textPasswordGenerated.setText(passwrd);

            btnSave.setEnabled(true);
        });

        btnCopy.setOnClickListener(view ->{
            ClipboardManager manager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            manager.setPrimaryClip(ClipData.newPlainText("password",textPasswordGenerated.getText().toString()));
            Toast.makeText(this, "Password Copied", Toast.LENGTH_SHORT).show();
        });

        btnSave.setOnClickListener(view -> {
            String genPwd = textPasswordGenerated.getText().toString();
            Intent intent = new Intent(MainActivity.this, SavePassword.class);
            intent.putExtra("pwd",genPwd);
            startActivity(intent);
        });
    }

    private void initViews() {
        editPasswordSize = findViewById(R.id.edit_pwd_size);
        textPasswordGenerated = findViewById(R.id.text_password_result);
        textErrorMessage = findViewById(R.id.text_error);
        checkLower = findViewById(R.id.check_lower);
        checkUpper = findViewById(R.id.check_upper);
        checkSpecialChar = findViewById(R.id.check_special_char);
        checkNumeric = findViewById(R.id.check_numeric);
        btnGenerate = findViewById(R.id.btn_generate);
        btnCopy = findViewById(R.id.btn_copy);
        btnSave = findViewById(R.id.btn_save);

        btnSave.setEnabled(false);
    }
}