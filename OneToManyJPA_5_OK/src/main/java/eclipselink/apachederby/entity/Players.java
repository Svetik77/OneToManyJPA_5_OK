package eclipselink.apachederby.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

// Imports

@Entity
@Table(name = "atp_players")
public class Players implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "player_name")
    private String name;

    @Column(name = "player_surname")
    private String surname;

    @Column(name = "player_age")
    private int age;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "player_birth")
    private Date birth;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player_photos", orphanRemoval = true)
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "player_photos" )
    private Collection<Photos> photos;

  public Players() {
	// TODO Auto-generated constructor stub
}  
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Collection<Photos> getPhotos() {
		return photos;
	}

	public void setPhotos(Collection<Photos> photos) {
		this.photos = photos;
	}

	public Players(String name, String surname, int age, Date birth, Collection<Photos> photos) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.birth = birth;
		this.photos = photos;
	}

    // Getters and setters

}