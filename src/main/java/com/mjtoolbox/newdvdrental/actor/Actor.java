package com.mjtoolbox.newdvdrental.actor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjtoolbox.newdvdrental.film.Film;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.*;

@Entity // declares this class is an entity
@Table(name="actor", schema="public")
public class Actor {

    @Id // declares that this column is an id
    @Column(name="actor_id") // the column name in the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tells the value is auto-generated
    private long actorId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @CreationTimestamp // type timestamp will be created
    @Column(name="last_update")
    private Date lastUpdate;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade =  {CascadeType.ALL}, mappedBy = "actors")

    @JsonIgnore
    private Set<Film> films = new HashSet<>();

    public long getActorId() {
        return actorId;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return actorId == actor.actorId &&
                Objects.equals(firstName, actor.firstName) &&
                Objects.equals(lastName, actor.lastName) &&
                Objects.equals(lastUpdate, actor.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, firstName, lastName, lastUpdate);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Collection<Film> getFilms() {
        return films;
    }
}
