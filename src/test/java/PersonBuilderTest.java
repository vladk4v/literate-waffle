import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PersonBuilderTest {

	static Stream<Arguments> input() {
		return Stream.of(
				arguments("Jane", 20),
				arguments("John", 22),
				arguments("John", 26)
		);
	}

	@ParameterizedTest
	@ValueSource(ints = {-20, -100})
	void setAgeTest(int age) {
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> new PersonBuilder()
				.setAge(age)
				.build()
		);
		assertEquals("Недопустимый возраст", ex.getMessage());
	}

	@ParameterizedTest
	@MethodSource("input")
	void buildTest(String name, int age) {
		Throwable ex = assertThrows(IllegalStateException.class, () -> new PersonBuilder()
				.setName(name)
				.setAge(age)
				.build()
		);
		assertEquals("Не хватает обязательных полей (имени, фамилии)", ex.getMessage());
	}
}