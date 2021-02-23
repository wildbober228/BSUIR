package models;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "namePosition")
    private String namePosition;

    public Position(){

    }

    public Position(String namePosition){
        this.namePosition = namePosition;
    }

    public int getId(){
        return id;
    }

    public String getNamePosition(){
        return namePosition;
    }

    public void setNamePosition(String namePosition){
        this.namePosition = namePosition;
    }

    @Override
    public String toString(){
        return "models.Position{" +
                "id= " + id +
                ", namePosition='" + namePosition + '\'' +
                '}';
    }
}
