package eclipselink.apachederby.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "players_photos")
public class Photos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "photo")
    private String photo;
    

    @ManyToOne
     @JoinColumn(name = "idplayer")
    private Players player_photos;

	public Photos(String photo, Players player_photos) {
		this.photo = photo;
		this.player_photos = player_photos;
	}

	public Photos() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Players getPlayer_photos() {
		return player_photos;
	}

	public void setPlayer_photos(Players player_photos) {
		this.player_photos = player_photos;
	}

    // Getters and setters

}