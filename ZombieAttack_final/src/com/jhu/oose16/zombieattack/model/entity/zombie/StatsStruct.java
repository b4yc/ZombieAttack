package com.jhu.oose16.zombieattack.model.entity.zombie;

public class StatsStruct {
	public static int WIDTH_UP_DOWN ;
	public static int HEIGHT_UP_DOWN ;
	public static int WIDTH_LEFT_RIGHT;
	public static int HEIGHT_LEFT_RIGHT;
	public static int DESTRUCTION_PEROID;
	public static int RUNNING_SPEED;
	public static int HEALTH_POINT;
	public static int ZOMBIE_DAMAGE;
	public static int ZOMBIE_SCORE;

	public static int RUNNING_SPEED_AFTER_DETECTION;
	
	public StatsStruct(int wud, int hud, int wlr, int hlr, int dp, int rs, int hp, int zd, int zs, int rsad) {
		WIDTH_UP_DOWN = wud;
		HEIGHT_UP_DOWN = hud;
		WIDTH_LEFT_RIGHT = wlr;
		HEIGHT_LEFT_RIGHT = hlr;
		DESTRUCTION_PEROID = dp;
		RUNNING_SPEED = rs;
		HEALTH_POINT = hp;
		ZOMBIE_DAMAGE = zd;
		ZOMBIE_SCORE = zs;
		RUNNING_SPEED_AFTER_DETECTION = rsad;
	}
}