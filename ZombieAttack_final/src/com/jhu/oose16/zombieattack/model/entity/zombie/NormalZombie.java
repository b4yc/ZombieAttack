package com.jhu.oose16.zombieattack.model.entity.zombie;

import com.jhu.oose16.zombieattack.model.ExpirableObjectType;

/**
 * Zombie can moving randomly and when it hits the barriers, it can choose
 * another randomly moving path.
 * 
 * @author Tom Prats: tprats108@gmail.com<br/>
 *         Jinqiu Deng: deng.jinqiu@gmail.com<br/>
 *         Yao Huang: yao.engineering@gmail.com<br/>
 *         Lavanya Sivakumar: lavany92@gmail.com
 */
public class NormalZombie extends Zombie {
	private static StatsStruct stats = new StatsStruct(33, 58, 22, 56, 10, 3, 1, 1, 1, 3);

	public NormalZombie() {
		super(stats.WIDTH_UP_DOWN, stats.HEIGHT_UP_DOWN, stats.WIDTH_LEFT_RIGHT,
				stats.HEIGHT_LEFT_RIGHT, stats.RUNNING_SPEED, stats.HEALTH_POINT, stats.ZOMBIE_DAMAGE,
				-1, -1, stats.DESTRUCTION_PEROID);
	}

	@Override
	public void initialObjectType() {
		super.initialObjectType();
		addExpirableObjectType(ExpirableObjectType.NormalZombie);
	}

	@Override
	public int score() {
		return stats.ZOMBIE_SCORE;
	}
}