class Sorting{
	public Teams[] sort(Teams[] teams, int size){
		int min =0;
		for(int i=0;i<size;i++){
			System.out.println("Its for i: "+i);
			min = i;
			//int j =i+1;
			for(int j=i+1;j<size;j++){
				if(teams[i].compareTo(teams[j])){
					min = j;
				}
			}
			teams = exchange(teams, i, min);

		}
		return teams;
	}


	public Teams[] exchange(Teams[] teams, int i, int j){
		Teams temp = teams[i];
		teams[i] = teams[j];
		teams[j] = temp;
		return teams;
	}
}