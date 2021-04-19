package com.jhu.oose16.zombieattack.model.entity.zombie;

import com.jhu.oose16.zombieattack.listener.ZombieListener;
import com.jhu.oose16.zombieattack.model.ExpirableObjectType;
import com.jhu.oose16.zombieattack.model.GameModel;
import com.jhu.oose16.zombieattack.model.attached.CleanupContext;

/**
 * When it die, it return into a goo.
 */
public class LeaderZombie extends Zombie {
	
	private static StatsStruct stats = new StatsStruct(79, 90, 42, 89, 15, 3, Integer.MAX_VALUE, 1, 7, 3);

	private static final int LIFE_TIME = 5000 / GameModel.getUpdateFrequency();
	private static final int NEW_ADD_ZOMBIE_FRE = 800;

	public LeaderZombie() {
		super(stats.WIDTH_UP_DOWN, stats.HEIGHT_UP_DOWN, stats.WIDTH_LEFT_RIGHT,
				stats.HEIGHT_LEFT_RIGHT, stats.RUNNING_SPEED, stats.HEALTH_POINT, stats.ZOMBIE_DAMAGE,
				-1, LIFE_TIME, stats.DESTRUCTION_PEROID);
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.LeaderZombie);

	}

	@Override
	public void cleanup(CleanupContext cleanupContext) {
		for (int i = 0; i < zombieListeners.size(); i++) {
			zombieListeners.get(i).changeBackAddNewZombieFre();
		}
		cleanupContext.trackDeadZombieCount();
	}
	
	@Override
	public void addZombieListener(ZombieListener zombieListener) {
		super.addZombieListener(zombieListener);
	}
	
	@Override
	public void responseToCreation() {
		for (int i = 0; i < zombieListeners.size(); i++) {
			zombieListeners.get(i).changeAddNewZombieFre(NEW_ADD_ZOMBIE_FRE);
		}
	}
	
	@Override
	public int score() {
		return stats.ZOMBIE_SCORE;
	}
}