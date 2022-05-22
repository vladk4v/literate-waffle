public class PersonBuilder {

	private String name;
	private String surname;
	private Integer age;
	private String address;

	public PersonBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public PersonBuilder setSurname(String surname) {
		this.surname = surname;
		return this;
	}

	public PersonBuilder setAge(int age) {
		if ((this.age == null) && (age >= 0)) {
			this.age = age;
			return this;
		} else {
			throw new IllegalArgumentException("Недопустимый возраст");
		}
	}

	public PersonBuilder setAddress(String address) {
		this.address = address;
		return this;
	}

	public Person build() {
		Person person;
		if (this.name == null || this.surname == null) {
			throw new IllegalStateException("Не хватает обязательных полей (имени, фамилии)");
		} else if (this.age != null) {
			person = new Person(name, surname, age);
		} else {
			person = new Person(name, surname);
		}
		person.setAddress(address);
		return person;
	}
}
