package dkh.demo.cronjob.providers.apimodel;

public class PersonResponse{

	private String name;
	private String surname;
	
	public PersonResponse() {}
	
	public PersonResponse(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
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
	
	public static PersonResponse notFound() {
		return new PersonResponse("Desconocido", "");
	}

	@Override
	public String toString() {
		return "PersonResponse [name=" + name + ", surname=" + surname + "]";
	}
}
