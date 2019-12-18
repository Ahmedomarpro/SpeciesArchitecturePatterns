package com.ao.myapplicationmvvm;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

	private MutableLiveData<String> data = new MutableLiveData<>();
	private MutableLiveData<Integer> progressData = new MutableLiveData<>();
	private MutableLiveData<String> message = new MutableLiveData<>();

	private MutableLiveData<Integer> showProgressBar = new MutableLiveData<>();

	public MutableLiveData<Integer> getProgressData() {
		return progressData;
	}

	public void setProgressData(Integer progressData) {
		this.progressData.setValue(progressData);
	}

	public LiveData<String> getMessage() {
		return message;
	}

	public void setMessage( String message) {
		this.message.setValue(message);
	}
}