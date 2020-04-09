package dkh.demo.service2.repository.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String surname;
	private Integer age;
	
	public Person() {}
	
	public Person(Integer id, String name, String surname, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public static class PersonBuilder {
		private Integer id;
		private String name;
		private String surname;
		private Integer age;
		
		public PersonBuilder(Integer id) {
			this.id=id;
		}
		
		public PersonBuilder withName(String name) {
			this.name = name;
			return this;
		}
		
		public PersonBuilder withSurname(String surname) {
			this.surname = surname;
			return this;
		}
		
		public PersonBuilder withAge(Integer age) {
			this.age = age;
			return this;
		}
		
		public Person build() {
			return new Person(id, name, surname, age);
		}
	}
}
