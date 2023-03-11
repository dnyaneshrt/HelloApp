package com.itp.helloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_hi,btn_paytm;
    EditText et_name;
    TextView txt_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       btn_hi= findViewById(R.id.btn_hi);
       btn_paytm=findViewById(R.id.btn_paytm);
       et_name= findViewById(R.id.et_name);
       txt_name=findViewById(R.id.txt_name);


    /*   btn_hi.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(MainActivity.this, "HI "+et_name.getText().toString(), Toast.LENGTH_LONG).show();
               txt_name.setText(et_name.getText().toString());
           }
       });*/
        btn_hi.setOnClickListener((n)-> {
                Toast.makeText(MainActivity.this, "HI "+et_name.getText().toString(), Toast.LENGTH_LONG).show();
                txt_name.setText(et_name.getText().toString());
            });

        btn_paytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            /*  try {
                  Intent intent=getPackageManager().getLaunchIntentForPackage("net.one97.paytm");
                  startActivity(intent);

              }catch(Exception e)
              {
                  Toast.makeText(MainActivity.this, "not avaialable "+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
              }
*/
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                Intent intent= getPackageManager().getLaunchIntentForPackage("com.linkedin.android");
                if(intent!=null) {
                    startActivity(intent);
                }else
                {
                    Intent intent1=new Intent();
                    intent1.setAction(Intent.ACTION_VIEW);
                    intent1.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.linkedin.android"));
                    startActivity(intent1);
                }
            }
        });

    }
}