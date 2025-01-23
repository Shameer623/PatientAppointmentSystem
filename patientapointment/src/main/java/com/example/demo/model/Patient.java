package com.example.demo.model;
//
//
//import java.util.List;
//
import jakarta.persistence.CascadeType;
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

//@Data
//@Entity
//@Table(name="patient")
//public class Patient {
//
//@Id
//@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
//	private String firstname;
//	private String lastname;
//	private String email;
//	private String contact;
//	
//	@OneToMany(mappedBy="patient", cascade=CascadeType.ALL,orphanRemoval=true)
////	 @OneToOne(mappedBy = "patient")
//	private List<Appointment> appointments;
//	public Patient(Long id, String firstname, String lastname, String email, String contact) {
//		super();
//		this.id = id;
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.email = email;
//		this.contact = contact;
//	}
//	
//	public Patient() {
//		
//	}
//	
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getFirstname() {
//		return firstname;
//	}
//
//	public void setFirstname(String firstname) {
//		this.firstname = firstname;
//	}
//
//	public String getLastname() {
//		return lastname;
//	}
//
//	public void setLastname(String lastname) {
//		this.lastname = lastname;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getContact() {
//		return contact;
//	}
//
//	public void setContact(String contact) {
//		this.contact = contact;
//	}
//
//	public List<Appointment> getAppointments() {
//		return appointments;
//	}
//
//	public void setAppointments(List<Appointment> appointments) {
//		this.appointments = appointments;
//	}
//	@Override
//	public String toString() {
//
//		return "Patient [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
//				+ ", contact=" + contact + ", appointments=" + appointments + "]";
//	}
//	
//}
//
//
//
//package com.example.demo.model;

//import javax.persistence.*;
//package com.example.demo.model;
//
//import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    generating the id as primary and auto incremented 
    private Long id;
    private String firstname;
    private String lastname;
    private String contact;
//one patient can book the multimple appointments
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

//   getter and setter for the get and set the values
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
	this.contact = contact;
}


    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Patient [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", appointments=" + appointments + "]";
    }
}
