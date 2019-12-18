package com.ao.myapplicationmvvm.architecturePatterns.pojo2;

public class NumberModel {
	private int firstNum, secondNum;

	public NumberModel(int firstNum, int secondNum) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
	}

	public int getFirstNum() {
		return firstNum;
	}
	public int getSecondNum() {
		return secondNum;
	}
	//Not Using
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
}
