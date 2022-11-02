package de.uni.koeln.se;

public class Elevator{
	
	public static int current_Floor=5;
	int dest_Floor;
	
	private Elv_States State = new Elv_States();
	
	public Elevator (int dest_floor)
	{
		this.dest_Floor=dest_floor;
	System.out.println("*** Destination floor is: "+ dest_Floor);
	arrive_atFloor();
	}

	private void arrive_atFloor() {
		State.Current_State = State.Idle;
		
		if(current_Floor < dest_Floor) {
			go_up();
		}else if(current_Floor == dest_Floor){
			exit();
		}	else if(current_Floor > dest_Floor){
			go_down();
		}
		
	}
	
	private void exit() {
		System.out.println("Am Ziel angekommen");
		//termination
	}
	private void go_up() {
		
		State.Current_State = State.Moving_up;
		current_Floor++;
		System.out.println("Derzeitige Etage: " + current_Floor);
		
		if(current_Floor < dest_Floor) {
			go_up();
		}else if(current_Floor == dest_Floor){
			arrive_atFloor();
		}
	}

	private void go_down() {
		
		State.Current_State = State.Moving_down;
		current_Floor--;
		System.out.println("Derzeitige Etage: " + current_Floor);
		
		if(current_Floor > dest_Floor) {
			go_down();
		}else if (current_Floor == dest_Floor) {
			arrive_atFloor();
			
		}
	}
	
}
