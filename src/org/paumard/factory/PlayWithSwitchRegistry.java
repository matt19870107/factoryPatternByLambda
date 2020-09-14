package org.paumard.factory;

import org.paumard.factory.factory.Factory;
import org.paumard.factory.model.Rectangle;
import org.paumard.factory.registry.SwitchRegistry;

public class PlayWithSwitchRegistry {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		SwitchRegistry registry = new SwitchRegistry();
		
		Factory<Rectangle> rectangleFactory = 
				(Factory<Rectangle>)registry.buildShapeFactory("rectangle");
		System.out.println("Rectangle : " + rectangleFactory.newInstance());
	}
}
