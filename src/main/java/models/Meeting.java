package models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "meetings", schema = "meetings")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmeetings")
    private Long id;

    @Column(name = "room")
    private String room;

    @Column(name = "startTime")
    private Timestamp startTime;

    @Column(name = "endTime")
    private Timestamp endTime;

    public Meeting(String room, Timestamp startTime, Timestamp endTime) {
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Meeting() {
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public void setEndTime(Timestamp startTime, int duration) {
        this.endTime = new Timestamp(startTime.getTime() + (duration * 1000));
    }

    public static Timestamp calculateEndTime(Timestamp startTime, int duration) {
        Timestamp endTime = new Timestamp(startTime.getTime() + (duration * 1000));
        return endTime;
    }

    public Long getId() {
        return id;
    }
}
