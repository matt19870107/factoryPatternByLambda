package org.paumard.factory.registry;

import org.paumard.factory.factory.Factory;

public interface Builder<T> {

	void register(String label, Factory<T> factory);
}
