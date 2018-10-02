import java.util.Arrays;
class Leaderboard{
	private Teams[] teamsObj;
	private int size;
	Sorting sortObj;
	Leaderboard(){
		teamsObj = new Teams[10];
		size = 0;
		sortObj = new Sorting();
	}

	public void add(Teams item){
		if(size == teamsObj.length){
			resize();
		}
		teamsObj[size++] = item;
	}

	private void resize(){
		teamsObj = Arrays.copyOf(teamsObj, 2*teamsObj.length);
	}

	public int getSize(){
		return this.size;
	}

	public Teams[] getLeaderboad(){
		return teamsObj;
	}

	public void print(){
		teamsObj = sortObj.sort(teamsObj);
		for(int i=0; i<teamsObj.length-1;i++){
			System.out.print(teamsObj[i].getTeamName()+",");
		}
		System.out.println(teamsObj[teamsObj.length-1].getTeamName());
	}
}