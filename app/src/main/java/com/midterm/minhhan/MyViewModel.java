package com.midterm.minhhan;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MyViewModel extends ViewModel {
    private MutableLiveData <Integer> number;
    private MutableLiveData<ArrayList<Integer>> arrayList;
    private MutableLiveData<Integer> selectedNumber;
    public LiveData<Integer> getNumber() {
        if(number == null) {
            number = new MutableLiveData<>();
            number.setValue(0);
        }
        return number;
    }
    public LiveData<ArrayList<Integer>> getListView() {
        if (arrayList == null) {
            arrayList = new MutableLiveData<>();
            arrayList.setValue(new ArrayList<>());
        }
        return arrayList;
    }
    public LiveData<Integer> getSelected() {
        if(selectedNumber == null) {
            selectedNumber = new MutableLiveData<>();
        }
        return selectedNumber;
    }
    public void setSelectedNumber(int value) {
        selectedNumber.setValue(value);
    }
    public void increaseNumber() {
        number.setValue(number.getValue() + 1);
        updateNumberList();
    }
    public void decreaseNumber() {
        number.setValue(number.getValue() - 1);
        updateNumberList();
    }
    public void updateNumberList() {
        ArrayList<Integer> newList = new ArrayList<>(arrayList.getValue());
        newList.add(number.getValue());
        arrayList.setValue(newList);
    }
}