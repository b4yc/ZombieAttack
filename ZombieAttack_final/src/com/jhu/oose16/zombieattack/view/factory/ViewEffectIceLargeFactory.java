package com.jhu.oose16.zombieattack.view.factory;

import android.graphics.PointF;

import com.jhu.oose16.zombieattack.model.ExpirableObject;
import com.jhu.oose16.zombieattack.view.component.object.ViewExpirableObject;
import com.jhu.oose16.zombieattack.view.component.object.ViewMovingExpirableObject;
import com.jhu.oose16.zombieattack.view.component.object.cycleplay.EffectIceLargeCyclePlay;

public class ViewEffectIceLargeFactory implements ViewExpirableObjectFactory {

	@Override
	public ViewExpirableObject getViewExpirableObject(
			ExpirableObject expirableObject) {

		return new ViewMovingExpirableObject(expirableObject,
				new EffectIceLargeCyclePlay(expirableObject.getObjectState()),
				new PointF(expirableObject.getCenterX(),
						expirableObject.getCenterY()));
	}

}
