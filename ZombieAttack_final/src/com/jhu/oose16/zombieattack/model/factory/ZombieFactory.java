package com.jhu.oose16.zombieattack.model.factory;

import java.util.HashMap; 
import com.jhu.oose16.zombieattack.model.entity.zombie.Zombie;
import com.jhu.oose16.zombieattack.model.entity.zombie.ZombieTypes;

import com.jhu.oose16.zombieattack.model.entity.zombie.KillerZombie;
import com.jhu.oose16.zombieattack.model.entity.zombie.CurseZombie;
import com.jhu.oose16.zombieattack.model.entity.zombie.FastZombie;
import com.jhu.oose16.zombieattack.model.entity.zombie.GiantZombie;
import com.jhu.oose16.zombieattack.model.entity.zombie.LeaderZombie;
import com.jhu.oose16.zombieattack.model.entity.zombie.NormalZombie;
import com.jhu.oose16.zombieattack.model.entity.zombie.SmartZombie;
import com.jhu.oose16.zombieattack.model.entity.zombie.StrongerZombie;

public class ZombieFactory implements EntityFactory<Zombie>{
	private HashMap<ZombieTypes, Zombie> zombieMap;
	
	public ZombieFactory() {
		zombieMap.put(ZombieTypes.KILLER, new KillerZombie());
		zombieMap.put(ZombieTypes.CURSE, new CurseZombie());
		zombieMap.put(ZombieTypes.FAST, new FastZombie());
		zombieMap.put(ZombieTypes.GIANT, new GiantZombie());
		zombieMap.put(ZombieTypes.LEADER, new LeaderZombie());
		zombieMap.put(ZombieTypes.NORMAL, new NormalZombie());
		zombieMap.put(ZombieTypes.SMART, new SmartZombie());
		zombieMap.put(ZombieTypes.STRONGER, new StrongerZombie());
	}
	
	public Zombie getNewZombie(ZombieTypes type) {
		Zombie zombie = null;
		if(type == ZombieTypes.KILLER)
			zombie = new KillerZombie();
		else if(type == ZombieTypes.CURSE)
			zombie = new CurseZombie();
		else if(type == ZombieTypes.FAST)
			zombie = new FastZombie();
		else if(type == ZombieTypes.GIANT)
			zombie = new GiantZombie();
		else if(type == ZombieTypes.LEADER)
			zombie = new LeaderZombie();
		else if(type == ZombieTypes.NORMAL)
			zombie = new NormalZombie();
		else if(type == ZombieTypes.SMART)
			zombie = new SmartZombie();
		else if(type == ZombieTypes.STRONGER)
			zombie = new StrongerZombie();
		return zombie;
	}

	@Override
	public Zombie newEntity(ZombieTypes type) {
		Zombie result = zombieMap.get(type);
		if(result == null) { 
			result = getNewZombie(type);
		}
		return result;
	}
}
