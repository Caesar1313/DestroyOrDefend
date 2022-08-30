package com.company;

public class Sniper extends Units {



	Sniper()
	{
		health = 90;
		attack_value = 1;
		AttackSpeed = 10;
		PlayerType = 2;
		strategy = new HighestDamage(this);
		cost = 300;
		armor =0;
		type = 6;
		Range = 10;
		//unit_type[5]=true;
		//unit_type[1]=true;
		//unit_type[6]=true;
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

