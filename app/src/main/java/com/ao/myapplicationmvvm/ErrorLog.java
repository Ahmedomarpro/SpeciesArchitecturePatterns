package com.ao.myapplicationmvvm;


import android.util.Log;

public class ErrorLog {


	public static void setError (String LOG_ID_MAIN, String msg) {


		Log.i(LOG_ID_MAIN,msg) ;
		Log.e(LOG_ID_MAIN,msg) ;
		Log.d(LOG_ID_MAIN,msg) ;

	}









}
