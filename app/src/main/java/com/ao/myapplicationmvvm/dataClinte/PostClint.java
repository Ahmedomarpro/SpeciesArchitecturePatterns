package com.ao.myapplicationmvvm.dataClinte;

import com.ao.myapplicationmvvm.pojo.ResponseModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostClint  {
	@GET("posts")
	public Call <List<ResponseModel>> getPost ();
}
