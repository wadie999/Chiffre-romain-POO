package com.uca;

public class Start{
	
	//Start class
	public static void main(String[] args){
		
		RomanNumber numberA = new RomanNumber(6);
		numberA.setRoman("IV");
        numberA.setRoman("XV");
		numberA.setRoman("XXXI");
		System.out.println(numberA.getValue());
		System.out.println(numberA.getRoman());
		
		//TODO
		//Aide pour démarrer : https://git.artheriom.fr/l3-informatique-2020-2021/site-l3/-/tree/master/Genie_Logiciel/HelperTP3
		//Aussi : https://www.youtube.com/watch?v=567_hWQJYak
	}
	
}