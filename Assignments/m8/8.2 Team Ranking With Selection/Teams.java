class Teams{
	String teamName;
	int  wins;
	int lose;
	int draw;
	Teams(String s, int w, int l, int d){
		this.teamName = s;
		this.wins = w;
		this.lose = l;
		this.draw = d;
	}

	public String getTeamName(){
		return this.teamName;
	}

	public int getWins(){
		return this.wins;
	}

	public int  getLose(){
		return this.lose;
	}

	public int getDraw(){
		return this.draw;
	}

	public boolean compareTo(Teams that){
		//System.out.println(this.teamName+"->"+this.wins+":-:"+that.teamName+"->"+that.wins);
		if(this.wins < that.wins){
			return true;
		} else if (this.wins > that.wins){
			return false;
		} else {
			if(this.lose < that.lose){
				return false;
			} else if( this.lose > that.lose){
				return true;
			} else {
				if(this.draw >= that.draw){
					return false;
				} else {
					return true;
				}
			}
		}
	}
}