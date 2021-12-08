package com.example.mvvm_withdatabinding.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.mvvm_withdatabinding.R;
import com.example.mvvm_withdatabinding.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         MovieViewModel movieViewModel;
         ActivityMainBinding binding;
         movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
         binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
         binding.setLifecycleOwner(this);

         binding.button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 movieViewModel.getData();
             }
         });

         movieViewModel.mutableLiveData.observe(this, new Observer<ArrayList<String>>() {
             @Override
             public void onChanged(ArrayList<String> strings) {
                 String s ="";

                 for (String i : strings){
                     s +=" - " + i;
                 }

                 binding.textView.setText(s);

             }
         });

    }
}