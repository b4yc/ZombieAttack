package com.jhu.oose16.zombieattack.model.entity.zombie;

import java.util.List;
import java.util.Random;

import com.jhu.oose16.zombieattack.model.ExpirableObjectType;
import com.jhu.oose16.zombieattack.model.attached.DetectionContext;
import com.jhu.oose16.zombieattack.model.attached.Position;
import com.jhu.oose16.zombieattack.model.attached.Vector;
import com.jhu.oose16.zombieattack.model.entity.Entity;
import com.jhu.oose16.zombieattack.model.entity.Rectangle;
import com.jhu.oose16.zombieattack.model.entity.scientist.Scientist;
import com.jhu.oose16.zombieattack.model.objectstate.LifeState;

/**
 * It will chase a scientist, while the scientist is in the detection region.
 */
public class KillerZombie extends Zombie {
	
	private static StatsStruct stats = new StatsStruct(45, 49, 45, 49, 7, 3, 1, Integer.MAX_VALUE, 5, 3);


	private static final int RUNNING_SPEED_AFTER_DETECTION = 10;

	private static final int UNDETECTING_COUNT = 2;

	private boolean blockedByBarrier;

	public KillerZombie() {
		super(stats.WIDTH_UP_DOWN, stats.HEIGHT_UP_DOWN, stats.WIDTH_LEFT_RIGHT,
				stats.HEIGHT_LEFT_RIGHT, stats.RUNNING_SPEED, stats.HEALTH_POINT, stats.ZOMBIE_DAMAGE,
				-1, -1, stats.DESTRUCTION_PEROID);
		openDetectionRegion();
		blockedByBarrier = false;
	}

	@Override
	public void update() {
		super.update();
		setSpeed(stats.RUNNING_SPEED);
		if (blockedByBarrier && countToMarkedUpdateCount() > UNDETECTING_COUNT) {
			blockedByBarrier = false;
		}
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.KillerZombie);
	}

	@Override
	protected void detectScientist(Scientist scientist,
			DetectionContext detectionContext) {

		if (!scientist.isInvincible()
				&& scientist.getObjectState().getLifeState() == LifeState.NORMAL
				&& !blockedByBarrier) {
			Vector vector = new Vector(this.getCenter(), scientist.getCenter());
			Position end = new Position(getCenterX(), getCenterY());
			end.plus(vector);
			List<Entity> barriers = detectionContext.getBarriers();
			Random random = new Random();
			for (Entity barrier : barriers) {
				int temp = random.nextInt(4);
				if (temp == 0) {
					if (!barrier
							.isExpirableObjectType(ExpirableObjectType.ScreenBound)
							&& (((Rectangle) barrier).isIntersect(getTopLeft(),
									end))) {
						// the zombie cannot see the scientist
						return;
					}
				} else if (temp == 1) {
					if (!barrier
							.isExpirableObjectType(ExpirableObjectType.ScreenBound)
							&& (((Rectangle) barrier).isIntersect(
									getBottomRight(), end))) {
						// the zombie cannot see the scientist
						return;
					}
				} else if (temp == 2) {
					if (!barrier
							.isExpirableObjectType(ExpirableObjectType.ScreenBound)
							&& (((Rectangle) barrier).isIntersect(
									getTopRight(), end))) {
						// the zombie cannot see the scientist
						return;
					}
				} else if (temp == 3) {
					if (!barrier
							.isExpirableObjectType(ExpirableObjectType.ScreenBound)
							&& (((Rectangle) barrier).isIntersect(
									getBottomLeft(), end))) {
						// the zombie cannot see the scientist
						return;
					}
				}
			}
			setSpeed(RUNNING_SPEED_AFTER_DETECTION);
			runningPath = getCenter().linePosition(end);
			runningPositionIndex = 0;
		}
	}

	@Override
	public int score() {
		return stats.ZOMBIE_SCORE;
	}

}