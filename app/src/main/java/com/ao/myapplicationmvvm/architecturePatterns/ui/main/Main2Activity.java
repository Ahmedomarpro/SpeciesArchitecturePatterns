package com.ao.myapplicationmvvm.architecturePatterns.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.ao.myapplicationmvvm.architecturePatterns.database.Database;
import com.ao.myapplicationmvvm.architecturePatterns.pojo2.NumberModel;
import com.ao.myapplicationmvvm.R;
import com.ao.myapplicationmvvm.databinding.ActivityMain2Binding;

public class Main2Activity extends AppCompatActivity implements MainView {
	Database dataBase = new Database();

	//For MVP
	MainPresenter presenter;
	//For MVVM
	Main2ViewModel mainViewModel;

	ActivityMain2Binding binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main2);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
 		//For MVVM
		mainViewModel = ViewModelProviders.of(this).get(Main2ViewModel.class);
 		

		//setDataBinf In ViewModel
		binding.setViewModel(mainViewModel);
		//Set function
		binding.setData(getNumberModel());

		binding.setLifecycleOwner(this);


		//For MVP
		presenter = new MainPresenter(this);

		binding.plusButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				binding.plusResultTextView.setText(new StringBuilder().append(getSum()));
			}
		});
		binding.divButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				presenter.getDivNumber(dataBase.getNumbers().getFirstNum() , dataBase.getNumbers().getSecondNum());
			}
		});

	}

		//- 			MVC plus  
	private NumberModel getNumberModel() {
		return dataBase.getNumbers();
	}
	private int getSum(){return getNumberModel().getFirstNum() + getNumberModel().getSecondNum();}

	//					MVP
	@Override
	public void getDivNumber(int result) {
		binding.divResultTextView.setText(new StringBuilder().append(result));

	}
}
