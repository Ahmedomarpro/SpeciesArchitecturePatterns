package com.ao.myapplicationmvvm.architecturePatterns.database;

import com.ao.myapplicationmvvm.architecturePatterns.pojo2.NumberModel;

public class Database {
	public NumberModel getNumbers(){
		return new NumberModel( 8 , 4 );
	}
}
