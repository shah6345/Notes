package com.f20170565.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;

public class Main3Activity extends AppCompatActivity {

    EditText editText2;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        editText2 = (EditText) findViewById(R.id.putfilename);
        TextView tv = (TextView)findViewById(R.id.textView2);


        getUserFiles(tv);
    }

   private void getUserFiles(TextView tv){
        String path = getFilesDir().toString();
        String data = "";
        String temp;
        File f = new File(path);
        File files[] = f.listFiles();
        for(File x : files){
            temp = x.toString();
            temp = temp.replace(path+"/","");
            data = data + temp + "\n";
            //Log.d("file found",x.toString());
        }
        tv.setText(data);
    }

    public void open(View view){
        if (editText2.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Please enter a file name", Toast.LENGTH_SHORT).show();
        }

        else
        { int flag=0;
            str = editText2.getText().toString();
            String path = getFilesDir().toString();
            String temp;
            File f = new File(path);
            File files[] = f.listFiles();
            for(File x : files){
                temp = x.toString();
                temp = temp.replace(path+"/","");
                if(temp.equals(str)){
                    Intent intent = new Intent(this, ViewNote.class);
                    intent.putExtra("fileName", str);
                    startActivity(intent);
                    finish();
                    flag=1;
                }
                }
                if(flag==0)
            Toast.makeText(getApplicationContext(), "Invalid file name", Toast.LENGTH_SHORT).show();
        }

    }

}
