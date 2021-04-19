package com.jhu.oose16.zombieattack.model.entity.zombie;

import com.jhu.oose16.zombieattack.model.ExpirableObjectType;
import com.jhu.oose16.zombieattack.model.attached.CleanupContext;
import com.jhu.oose16.zombieattack.model.attached.CollisionContext;
import com.jhu.oose16.zombieattack.model.entity.materials.Goo;

/**
 * When it die, it return into a goo.
 */
public class CurseZombie extends Zombie {
	
	private static StatsStruct stats = new StatsStruct(41, 59, 47, 57, 19, 3, 1, 1, 2, 3);

	public CurseZombie() {
		super(stats.WIDTH_UP_DOWN, stats.HEIGHT_UP_DOWN, stats.WIDTH_LEFT_RIGHT,
				stats.HEIGHT_LEFT_RIGHT, stats.RUNNING_SPEED, stats.HEALTH_POINT, stats.ZOMBIE_DAMAGE,
				-1, -1, stats.DESTRUCTION_PEROID);
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.CurseZombie);

	}

	/** change into a goo */
	@Override
	public void cleanup(CleanupContext cleanupContext) {
		super.cleanup(cleanupContext);
		Goo goo = new Goo(getCenter(), Math.max(getWidth(), getHeight()));
		cleanupContext.addEntity(goo);
	}
	
	@Override
	public void hitGoo(Goo goo, CollisionContext collisionContext) {
	}
	
	@Override
	public int score() {
		return stats.ZOMBIE_SCORE;
	}
	
}