package com.anish.so.q0003;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestStreams {

	public static void main(final String[] args) {
		final Set<Integer> seen = Collections.synchronizedSet(new HashSet<>());
		seen.add(1);
		seen.add(8);
		seen.add(10);

		final Set<Integer> bag = new HashSet<>();
		bag.add(1);
		bag.add(3);
		bag.add(5);
		bag.add(10);
		bag.add(12);

		final List<Integer> seenBefore = bag
			.stream()
			.parallel()
			.map(e -> {
				if (seen.add(e))
					return 0;
				else
					return e;
			})
			.collect(Collectors.toList());

		seenBefore.stream().forEach(e -> System.out.println(e));

	}

}
