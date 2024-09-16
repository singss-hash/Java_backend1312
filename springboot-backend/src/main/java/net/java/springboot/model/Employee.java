package net.java.springboot.model;


	import lombok.AllArgsConstructor;
	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;

	import jakarta.persistence.*;

	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Entity
	@Table(name = "employees")
	public class Employee {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    @Column(name = "first_name")
	    private String firstName;

	    @Column(name = "last_name") 
	    private String lastName;

	    @Column(name = "email_id")
	    private String emailId;
	    

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setFirstName(String string) {
			this.firstName=string;
			
		}

		public void setLastName(String string) {
			this.lastName=string;
			
		}

		public void setEmailId(String string) {
			this.emailId=string;
			
		}

					
		}
	