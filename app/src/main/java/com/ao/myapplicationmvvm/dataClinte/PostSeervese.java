package com.ao.myapplicationmvvm.dataClinte;

import com.ao.myapplicationmvvm.pojo.ResponseModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostSeervese {
	private static final String BASE_URL ="https://jsonplaceholder.typicode.com";

	private PostClint postClint;

	private static PostSeervese getInstance;

	public PostSeervese() {

		Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		postClint = retrofit.create(PostClint.class);
		
	}

	public static PostSeervese getGetInstance() {
		if (getInstance == null){
			getInstance = new PostSeervese();
		}
		return getInstance;
	}
	public Call <List<ResponseModel>>getPost(){
		return postClint.getPost();
	}
}
