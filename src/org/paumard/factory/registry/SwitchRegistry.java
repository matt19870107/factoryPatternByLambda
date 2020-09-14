package org.paumard.factory.registry;

import org.paumard.factory.factory.Factory;
import org.paumard.factory.model.Rectangle;
import org.paumard.factory.model.Shape;
import org.paumard.factory.model.Square;
import org.paumard.factory.model.Triangle;

public class SwitchRegistry {

	public Factory<? extends Shape> buildShapeFactory(String shape) {
		
		switch(shape) {
			case "square" : return () -> new Square();
			case "triangle" : return () -> new Triangle();
			case "rectangle" : return () -> new Rectangle();
			default:
				throw new IllegalArgumentException("Unknown shape: " + shape);
		}
	}
}
