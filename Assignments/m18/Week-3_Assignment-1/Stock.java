class Stock implements Comparable<Stock>{
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

	public int compareTo(Stock that){
		if(this.getChange() != that.getChange()){
			return this.getChange().compareTo(that.getChange());
		}
		return this.getName().compareTo(that.getName());
	}
}