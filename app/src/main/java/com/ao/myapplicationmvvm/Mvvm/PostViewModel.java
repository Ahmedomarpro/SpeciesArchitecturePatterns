package com.ao.myapplicationmvvm.Mvvm;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ao.myapplicationmvvm.dataClinte.PostSeervese;
import com.ao.myapplicationmvvm.pojo.ResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class PostViewModel extends ViewModel {
	public  MutableLiveData <List<ResponseModel>> postModel = new MutableLiveData<>();
	public  MutableLiveData <String > error = new MutableLiveData<>();

	public void getPostModel() {
		PostSeervese.getGetInstance().getPost().enqueue(new Callback<List<ResponseModel>>() {
			@Override
			public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
				if (response.isSuccessful()) {
					postModel.postValue(response.body());
					error.setValue("");

				} else {
					Log.i("TAG", "onResponse: ");
				}
			}

			@Override
			public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

			}
		});
	}

}
