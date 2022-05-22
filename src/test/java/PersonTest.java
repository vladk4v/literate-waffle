import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PersonTest {
	static Stream<Arguments> input() {
		return Stream.of(
				arguments(new Person("Jane", "Smith", 25)),
				arguments(new Person("John", "Doe", 22)),
				arguments(new Person("Mike", "Coal", 26))
		);
	}

	@ParameterizedTest
	@MethodSource("input")
	void happyBirthdayTest(Person person) {
		int newAge = person.getAge() + 1;
		person.happyBirthday();
		assertEquals(newAge, person.getAge());
	}

	@ParameterizedTest
	@MethodSource("input")
	void newChildBuilderTest(Person person) {
		Person child = person.newChildBuilder()
				.setName("Kathy")
				.build();
		assertEquals(child.getSurname(), person.getSurname());
		assertEquals(0, child.getAge());
	}
}