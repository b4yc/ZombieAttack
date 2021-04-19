package com.jhu.oose16.zombieattack.model.entity.zombie;

import java.util.List;

import com.jhu.oose16.zombieattack.model.ExpirableObjectType;
import com.jhu.oose16.zombieattack.model.GameModel;
import com.jhu.oose16.zombieattack.model.attached.DetectionContext;
import com.jhu.oose16.zombieattack.model.attached.Position;
import com.jhu.oose16.zombieattack.model.attached.Vector;
import com.jhu.oose16.zombieattack.model.entity.Entity;
import com.jhu.oose16.zombieattack.model.entity.Rectangle;
import com.jhu.oose16.zombieattack.model.entity.boulder.Boulder;

import com.jhu.oose16.zombieattack.model.entity.zombie.StatsStruct;

public class SmartZombie extends Zombie {
	
	private static StatsStruct stats = new StatsStruct(31, 60, 23, 58, 11, 3, 2, 1, 5, 10);

	public SmartZombie() {
		super(stats.WIDTH_UP_DOWN, stats.HEIGHT_UP_DOWN, stats.WIDTH_LEFT_RIGHT,
				stats.HEIGHT_LEFT_RIGHT, stats.RUNNING_SPEED, stats.HEALTH_POINT, stats.ZOMBIE_DAMAGE,
				-1, -1, stats.DESTRUCTION_PEROID);
		openDetectionRegion();
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.SmartZombie);
	}

	@Override
	public void update() {
		super.update();
		setSpeed(stats.RUNNING_SPEED);
	}

	@Override
	protected void detectBoulder(Boulder boulder,
			DetectionContext detectionContext) {
		setSpeed(stats.RUNNING_SPEED_AFTER_DETECTION);

		Vector vector = new Vector(boulder.getCenter(), this.getCenter());
		Position end = new Position(getCenterX(), getCenterY());
		end.plus(vector);
		runningPath = getCenter().linePosition(end, stats.HEIGHT_UP_DOWN);

		Position nextPosition = runningPath.get(runningPath.size() - 1);

		List<Entity> barriers = detectionContext.getBarriers();

		for (int i = 0; i < barriers.size(); i++) {
			if (((Rectangle) barriers.get(i)).isInside(nextPosition)) {
				int temp = barriers.get(i).onWhichSide(getCenter());
				if (temp == 0 || temp == 2) {
					if (boulder.getCenterX() > GameModel.getGameFrameWidth() / 2) {
						end = new Position(0, getCenterY());
					} else {
						end = new Position(GameModel.getGameFrameWidth(),
								getCenterY());
					}
				} else {
					if (boulder.getCenterY() > GameModel.getGameFrameHeight() / 2) {
						end = new Position(getCenterX(), 0);
					} else {
						end = new Position(getCenterX(),
								GameModel.getGameFrameHeight());
					}
				}
				runningPath = getCenter().linePosition(end);
				break;
			}
		}

		runningPositionIndex = 0;
	}

	@Override
	public int score() {
		return stats.ZOMBIE_SCORE;
	}

}
