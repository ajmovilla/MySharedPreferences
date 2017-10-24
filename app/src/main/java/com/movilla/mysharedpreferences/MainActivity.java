package com.movilla.mysharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText et_user, et_pass;
    Button btn_save, btn_dis;
    TextView t_display;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_user = (EditText) findViewById(R.id.etuser);
        et_pass = (EditText) findViewById(R.id.etpass);
        btn_save = (Button) findViewById(R.id.btnsave);
        btn_dis = (Button) findViewById(R.id.btndis);
        t_display = (TextView) findViewById(R.id.tdisplay);
        preferences = getPreferences(Context.MODE_PRIVATE);
    }
    public void saveInfo (View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", et_user.getText().toString());
        editor.putString("password", et_pass.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();

    }
    public void loadInfo (View view){
        String user = preferences.getString("username", "");
        String pwd = preferences.getString("password", "");
        t_display.setText("the password of " + user + " is " + pwd);
    }
}
