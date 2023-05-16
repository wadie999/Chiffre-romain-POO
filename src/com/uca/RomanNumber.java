package com.uca;

public class RomanNumber extends Number{
	
	private String roman;
	
	private int value;
	

	// definition des constructeurs : public nomdelaclasse(type valeur)
	public RomanNumber(String roman){
		this.roman = roman; // enregistrer la valeur passe en parametre dans l'objet
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	
	public RomanNumber(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	
	public RomanNumber(int value, String roman){
		this.value = value;
		this.roman = roman;
	}
	// on aurra besoin d'acceder aux champs de l'objet value et roman pour les mettres ajour,
	// mais ces derniers sont prives, c'est pour cela on definit un geter pour acceder a la valeur 
	// un seter pour la mettre ajour

	public String getRoman(){
		return this.roman;
	}
	
	public int getValue(){
		return this.value;
	}
	// elle ne va rien retourner , donc void 
	public void setRoman(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	public void setValue(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	
	
	
	
	/**
	* @{inheritDoc}
	*/
	@Override
	public double doubleValue() {
		return (double) value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public float floatValue() {
		return (float) value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public int intValue() {
		return value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public long longValue() {
		return (long) value;
	}

	@Override
	public String toString() {
		return roman;
	}


	public int compareTo(RomanNumber other) {
    	return Integer.compare(this.value, other.value);
}
}