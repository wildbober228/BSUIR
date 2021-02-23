package models;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "surname")
    private String surname;

    private int departamentId;
    private int positionId;

    @OneToOne()
    @JoinColumn(name = "departamentId", insertable = false, updatable = false)
    private Departament departament;

    public Departament getDepartament(){
        return departament;
    }

    public void setDepartament(Departament departament){
        this.departament = departament;
    }

    @Column(name = "FK_Department",nullable = false, insertable = false, unique = false)
    public int getDepartamentId(){
        return departamentId;
    }

    public void setDepartamentId(int departmentId){
        this.departamentId = departmentId;
    }

    @OneToOne()
    @JoinColumn(name = "positionId", insertable = false, updatable = false)
    private Position position;

    public Position getPosition(){
        return position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    @Column(name = "FK_Position",nullable = false, insertable = false, unique = false)
    public int getPositionId(){
        return positionId;
    }

    public void setPositionId(int positionId){
        this.positionId = positionId;
    }

    public Employee(){

    }

    public Employee(String surname){
        this.surname = surname;
    }

    public int getId(){
        return id;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    @Override
    public String toString(){
        return "models.Customer{" +
                "id= " + id +
                ", surname='" + surname + '\'' +
                ", departamentName=" + departament.getNameDepartament() + '\'' +
                ", positionName=" + position.getNamePosition() + '\'' +
                '}';
    }
}
