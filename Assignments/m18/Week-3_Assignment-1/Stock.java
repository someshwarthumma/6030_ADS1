class Stock{
	String name;
	Float change;
	Stock(String s, Float c){
		this.name = s;
		this.change = c;
	}

	public String getName(){
		return this.name;
	}
	public Float getChange(){
		return this.change;
	}
}