package com.example.mvvm_withdatabinding.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_withdatabinding.pojo.MovieModel;

import java.util.ArrayList;

public class MovieViewModel extends ViewModel {

    public MutableLiveData<ArrayList<String>> mutableLiveData = new MutableLiveData<>();
    private MovieModel getDatafromDatabase (){
        return new MovieModel("cast a way", "sad movie");
    }

    public void getData(){
        ArrayList<String> list = new ArrayList<>();
        list.add(getDatafromDatabase().getName());
        list.add(getDatafromDatabase().getDescription());
        mutableLiveData.setValue(list);

    }
}
