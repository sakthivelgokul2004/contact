package com.example.to_prove;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.to_prove.databinding.ActivityMain2Binding;
import com.example.to_prove.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    ActivityMainBinding binding;
    ActivityMain2Binding binding2;
    dbmanger dbmanger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


       binding.save.setOnClickListener(this::onClick);
        binding.removeFous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.ed1.clearFocus();
                binding.ed2.clearFocus();

            }
        });
        dbmanger=new dbmanger(getApplicationContext());
        dbmanger.open();

        grand();
    }

    public void grand(){
        if (ContextCompat.checkSelfPermission(
                MainActivity.this,READ_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED) {
            // You can use the API that requires the permission.

        } else {
            // You can directly ask for the permission.
            // The registered ActivityResultCallback gets the result of this request.

            requestPermissions(new String[] {READ_EXTERNAL_STORAGE },
                    1);
        }
    }
    @Override
    public void onClick(View view) {
        if (binding.ed1.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this,"Please enter name",Toast.LENGTH_SHORT).show();
        }
        else  if (binding.ed2.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this,"Please enter number",Toast.LENGTH_SHORT).show();
        }
        else  if (binding.ed2.getText().toString().length()!=10){
            Toast.makeText(MainActivity.this,"Please enter valid number",Toast.LENGTH_SHORT).show();
        }
        else {
            String str1=binding.ed1.getText().toString();
            String str2=binding.ed2.getText().toString();
            dbmanger.insert(str1,str2);
            binding.ed1.setText("");
            binding.ed2.setText("");
            Toast.makeText(MainActivity.this,"Student detail added sucessfully",Toast.LENGTH_SHORT).show();
            binding.ed1.clearFocus();
            binding.ed2.clearFocus();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbmanger.close();
    }

    public void display(View view) {
        Intent i=new Intent(getApplicationContext(),MainActivity2.class);
        startActivity(i);
    }
}
