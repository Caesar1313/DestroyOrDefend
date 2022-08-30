package com.company;

public class Soldier extends Units {

	Soldier()
	{
		health = 300;
		attack_value = 5;
		AttackSpeed = 3;
		Range = 5;
		PlayerType = 1;
		cost = 50;
		armor =0;
		type = 5;
		strategy = new HighestDamage(this);
		//unit_type[1]=true;
		//unit_type[6]=true;
		//unit_type[5]=true;
	}

	@Override
	public void run() {

		int mode = -1;
		while(Game.state == Game.GameState.RunningGame){

			try {
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			strategy.InRangeEnemies();
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

