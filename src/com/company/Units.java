package com.company;

import java.util.Random;

public abstract class Units extends Forces{

	public boolean [] unit_type = new boolean[6];


	public int move(){

		if(this.PlayerType == 1){

			if(this.strategy.EnemiesInRange.isEmpty()){

				if(this.isBaseInRange()){
					return 1;
				}

				else{

					if(this.Position.x < Game.base.BasePosition.x){
						for(int i=0;i<Game.unitsInArena.size();i++){
							if(this.Position.x+1 == Game.unitsInArena.get(i).Position.x&&this.Position.y == Game.unitsInArena.get(i).Position.y)
							{
								return 0;
							}
						}

						this.Position.x++;
					}
					else if(this.Position.y < Game.base.BasePosition.y)
					{
						for(int i=0;i<Game.unitsInArena.size();i++){
							if(this.Position.x == Game.unitsInArena.get(i).Position.x&&this.Position.y+1 == Game.unitsInArena.get(i).Position.y)
							{
								return 0;
							}
						}

						this.Position.y++;
					}
					else if(this.Position.x > Game.base.BasePosition.x)
					{
						for(int i=0;i<Game.unitsInArena.size();i++){
							if(this.Position.x-1 == Game.unitsInArena.get(i).Position.x&&this.Position.y == Game.unitsInArena.get(i).Position.y)
							{
								return 0;
							}
						}

						this.Position.x--;
					}
					else if(this.Position.y > Game.base.BasePosition.y)
					{
						for(int i=0;i<Game.unitsInArena.size();i++){
							if(this.Position.x == Game.unitsInArena.get(i).Position.x&&this.Position.y-1 == Game.unitsInArena.get(i).Position.y)
							{
								return 0;
							}
						}

						this.Position.y--;
					}

					return 0;



				}



			}

			return 2;


		}
		else if (this.PlayerType==2){


			if(this.strategy.EnemiesInRange.isEmpty()){

				if(this.isBaseInRange()){
					Random rand = new Random();
					int r = rand.nextInt(4);
					if(r==0){
						for(int i=0;i<Game.unitsInArena.size();i++){
							if(this.Position.x+1 == Game.unitsInArena.get(i).Position.x&&this.Position.y == Game.unitsInArena.get(i).Position.y)
							{
								r=1;
							}
						}

					if (r==0)
					this.Position.x++;}

					if(r==1&&this.Position.x>0){
						for(int i=0;i<Game.unitsInArena.size();i++){
							if(this.Position.x-1 == Game.unitsInArena.get(i).Position.x&&this.Position.y == Game.unitsInArena.get(i).Position.y)
							{
								r = 2;
							}
						}

					if(r==1)
					this.Position.x--;}

					if(r==2){
						for(int i=0;i<Game.unitsInArena.size();i++){
							if(this.Position.x == Game.unitsInArena.get(i).Position.x&&this.Position.y+1 == Game.unitsInArena.get(i).Position.y)
							{
								r = 3;
							}
						}

                    if(r==2)
					this.Position.y++;}

					if(r==3&&this.Position.y>0){

						for(int i=0;i<Game.unitsInArena.size();i++){
							if(this.Position.x == Game.unitsInArena.get(i).Position.x&&this.Position.y-1 == Game.unitsInArena.get(i).Position.y)
							{
								return -1;
							}
						}

					this.Position.y--;}

					return -1;


				}else{



					if(this.Position.x < Game.base.BasePosition.x){
						for(int i=0;i<Game.unitsInArena.size();i++){
							if(this.Position.x+1 == Game.unitsInArena.get(i).Position.x&&this.Position.y == Game.unitsInArena.get(i).Position.y)
							{
								return 0;
							}
						}

						this.Position.x++;
					}
					else if(this.Position.y < Game.base.BasePosition.y)
					{
						for(int i=0;i<Game.unitsInArena.size();i++){
							if(this.Position.x == Game.unitsInArena.get(i).Position.x&&this.Position.y+1 == Game.unitsInArena.get(i).Position.y)
							{
								return 0;
							}
						}

						this.Position.y++;
					}
					else if(this.Position.x > Game.base.BasePosition.x)
					{
						for(int i=0;i<Game.unitsInArena.size();i++){
							if(this.Position.x-1 == Game.unitsInArena.get(i).Position.x&&this.Position.y == Game.unitsInArena.get(i).Position.y)
							{
								return 0;
							}
						}

						this.Position.x--;
					}
					else if(this.Position.y > Game.base.BasePosition.y)
					{
						for(int i=0;i<Game.unitsInArena.size();i++){
							if(this.Position.x == Game.unitsInArena.get(i).Position.x&&this.Position.y-1 == Game.unitsInArena.get(i).Position.y)
							{
								return 0;
							}
						}

						this.Position.y--;
					}

					return 0;



				}



			}

			return 2;


		}
		return Integer.parseInt(null);
	}


	}


