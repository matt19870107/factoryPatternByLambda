package org.paumard.factory.registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import org.paumard.factory.factory.Factory;

public interface Registry<T> {

	Factory<? extends T> buildShapeFactory(String shape);
	
	public static <T> Registry<T> createRegistry(
			Consumer<Builder<T>> consumer, Function<String, Factory<T>> errorFunction) {
		
		Map<String, Factory<T>> map = new HashMap<>();
		Builder<T> builder = (label, factory) -> map.put(label, factory);
		consumer.accept(builder);
		
		return shape -> map.computeIfAbsent(shape, errorFunction);
	}
}
