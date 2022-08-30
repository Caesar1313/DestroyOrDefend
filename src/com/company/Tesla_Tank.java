package com.company;

public class Tesla_Tank extends Units {

	Tesla_Tank()
	{
	  health = 2000;
	  armor = 0;
	  cost = 500;
	  attack_value = 500;
	  type = 4;
	  Range = 15;
	  for(int i=0;i<unit_type.length;i++)
	  {
		  unit_type[i]=true;
	  }
	}


	@Override
	public void run() {

		int mode = -1;
		while(Game.state == Game.GameState.RunningGame){

		try {
			Thread.currentThread().sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mode = move();

		if(mode == 1){
			try {
				attack(Game.base);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if(mode == 2){

			try {
				attack(strategy.ReturnFirstElement());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


		}
	}

}
}

