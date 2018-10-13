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
		Integer s1 = this.getName().length();
		Integer s2 = that.getName().length();
		if(s1 != s2){
			return s1.compareTo(s2);
		}
		return that.getName().compareTo(that.getName());
	}
}