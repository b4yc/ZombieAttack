package com.jhu.oose16.zombieattack.model.entity.zombie;

import com.jhu.oose16.zombieattack.model.ExpirableObjectType;

/**
 * Zombie can moving randomly and when it hits the barriers, it can choose
 * another randomly moving path.
 */
public class FastZombie extends Zombie {
	
	private static StatsStruct stats = new StatsStruct(45, 60, 26, 60, 10, 6, 2, 1, 2, 6);

	public FastZombie() {
		super(stats.WIDTH_UP_DOWN, stats.HEIGHT_UP_DOWN, stats.WIDTH_LEFT_RIGHT,
				stats.HEIGHT_LEFT_RIGHT, stats.RUNNING_SPEED, stats.HEALTH_POINT, stats.ZOMBIE_DAMAGE,
				-1, -1, stats.DESTRUCTION_PEROID);
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.FastZombie);

	}

	@Override
	public int score() {
		return stats.ZOMBIE_SCORE;
	}
}