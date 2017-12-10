package com.w2a.architectbatch1.testCases;

public class Rough {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str= "abcd1234abcd";
		String str1=null;
		str1=str.replaceAll("[^0-9]", "");
		System.out.println(str1);
		
	}
}
