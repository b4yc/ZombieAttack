package com.jhu.oose16.zombieattack.model.entity.zombie;

import com.jhu.oose16.zombieattack.model.ExpirableObjectType;

public class GiantZombie extends Zombie {
	
	private static StatsStruct stats = new StatsStruct(90, 90, 67, 90, 10, 2, 5, 2, 7, 2);

	public GiantZombie() {
		super(stats.WIDTH_UP_DOWN, stats.HEIGHT_UP_DOWN, stats.WIDTH_LEFT_RIGHT,
				stats.HEIGHT_LEFT_RIGHT, stats.RUNNING_SPEED, stats.HEALTH_POINT, stats.ZOMBIE_DAMAGE,
				-1, -1, stats.DESTRUCTION_PEROID);
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.GiantZombie);
	}
	
	@Override
	public int score() {
		return stats.ZOMBIE_SCORE;
	}
}
