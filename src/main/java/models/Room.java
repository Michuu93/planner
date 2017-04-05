package models;

import javax.persistence.*;

@Entity
@Table(name = "rooms", schema = "meetings")
public class Room {
    @Id
    @Column(unique = true, name = "room")
    private String room;

    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
}
