package com.example.n551.intent2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText ET=(EditText)findViewById(R.id.phoneNum);
        final Button BT=(Button)findViewById(R.id.Button01);
        ET.setText("");
      BT.setOnClickListener(new Button.OnClickListener()
      {
          public void onClick(View b)
          {
              String phnum=ET.getText().toString();
              if(PhoneNumberUtils.isGlobalPhoneNumber(phnum)){
                  Intent I=new Intent();
                  I.setAction(Intent.ACTION_CALL);
                  I.setData(Uri.parse("tel://"+phnum));
                  startActivity(I);
              }
              else{
                  Toast.makeText(MainActivity.this,"输入号码错误", Toast.LENGTH_LONG).show();
              }
          }
      }
      );
    }
}
