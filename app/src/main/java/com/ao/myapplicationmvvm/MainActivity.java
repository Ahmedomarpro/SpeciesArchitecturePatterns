package com.ao.myapplicationmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.ao.myapplicationmvvm.Mvvm.PostViewModel;
import com.ao.myapplicationmvvm.adapter.RecyclerAdapter;
import com.ao.myapplicationmvvm.databinding.MainBinder;
import com.ao.myapplicationmvvm.pojo.ResponseModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission_group.STORAGE;

public class MainActivity extends AppCompatActivity {

	
	private MainBinder binding;
	private MainViewModel viewModel;
	private PostViewModel postViewModel;
	RecyclerAdapter adapter;
	ErrorLog errorLog = null;

 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);

		binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
		postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
		binding.setViewModel(viewModel);

		postViewModel.getPostModel();
 
		adapter = new RecyclerAdapter();
		RecyclerView recyclerView = findViewById(R.id.recycler);
		          recyclerView.setLayoutManager(new LinearLayoutManager(this));
		          recyclerView.setAdapter(adapter);

		setLiveDta();
		setEventListeners();


	}



	private void setLiveDta() {
		postViewModel.error.observe(this, new Observer<String>() {
			@Override
			public void onChanged(String s) {
				adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListenerView() {
					@Override
					public void onItemClick(int position) {

						Toast.makeText(MainActivity.this, "jjj"+s+position, Toast.LENGTH_SHORT).show();
					}
				});
			}
		});
	 postViewModel.postModel.observe(this, new Observer<List<ResponseModel>>() {
		 @Override
		 public void onChanged(List<ResponseModel> responseModels) {
			 adapter.setListDta(responseModels);

		 }
	 });


		viewModel.getMessage().observe(this, new Observer<String>() {
			@Override
			public void onChanged(String s) {
				viewModel.setMessage(s);
			}
		});
	}

	private void setEventListeners() {

		binding.buttonSendData.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				binding.getViewModel().getMessage();
				Toast.makeText(MainActivity.this, "ww8888888888888888wwww", Toast.LENGTH_SHORT).show();

			}
		});

		binding.btnA.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				binding.getViewModel().getMessage();
				Toast.makeText(MainActivity.this, "ececececececeececec", Toast.LENGTH_SHORT).show();

 			ErrorLog.setError("aaaa","ssssssssssss");
			}
		});


	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		 viewModel.getMessage().observe(this,null);
		 binding.getViewModel().getMessage().observe(this,null);
		 binding.buttonSendData.setOnClickListener(null);
		 binding.btnA.setOnClickListener(null);



	}

}
