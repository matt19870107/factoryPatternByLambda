package org.paumard.factory;

import java.util.function.Consumer;

import org.paumard.factory.factory.Factory;
import org.paumard.factory.model.Rectangle;
import org.paumard.factory.model.Shape;
import org.paumard.factory.model.Square;
import org.paumard.factory.model.Triangle;
import org.paumard.factory.registry.Builder;
import org.paumard.factory.registry.Registry;

public class PlayWithRegistryBuilder {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Consumer<Builder<Shape>> consumer1 = 
				builder -> builder.register("rectangle",  Rectangle::new);
		Consumer<Builder<Shape>> consumer2 = 
				builder -> builder.register("triangle",  Triangle::new);
		
		Consumer<Builder<Shape>> initializer = consumer1.andThen(consumer2);
				
		Registry<Shape> registry = Registry.createRegistry(
				initializer, s -> { throw new IllegalArgumentException("Unknown shape: " + s);});
		
		Factory<Rectangle> buildRectangleFactory = 
				(Factory<Rectangle>)registry.buildShapeFactory("rectangle");
		
		Rectangle rectangle = buildRectangleFactory.newInstance();
		System.out.println("Rectangle = " + rectangle);
		
		Factory<Triangle> buildTriangleFactory = 
				(Factory<Triangle>)registry.buildShapeFactory("triangle");
		
		Triangle triangle = buildTriangleFactory.newInstance();
		System.out.println("Triangle = " + triangle);
		
		Factory<Square> buildSquareFactory = 
				(Factory<Square>)registry.buildShapeFactory("square");
		Square square = buildSquareFactory.newInstance();
	}
}
