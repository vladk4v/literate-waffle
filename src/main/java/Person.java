import java.util.Objects;

public class Person {
	private final String name;
	private final String surname;
	private Integer age;
	private String address;

	public Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
		address = null;
	}

	public Person(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		address = null;
	}

	public boolean hasAge() {
		return age != null;
	}

	public boolean hasAddress() {
		return address != null;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Integer getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void happyBirthday() {
		if (this.hasAge()) {
			age++;
			System.out.println("Happy birthday!");
		}
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", surname='" + surname + '\'' +
				(this.hasAge() ? (", age=" + age) : ("")) +
				(this.hasAddress() ? (", address='" + address + '\'') : ("")) +
				'}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getSurname());
	}

	public PersonBuilder newChildBuilder() {
		return new PersonBuilder()
				.setSurname(this.surname)
				.setAge(0)
				.setAddress(this.address);
	}
}
