package models;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "departament")
public class Departament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nameDepartament")
    private String nameDepartament;

    public Departament(){

    }

    public Departament(String nameDepartament){
        this.nameDepartament = nameDepartament;
    }

    public int getId(){
        return id;
    }

    public String getNameDepartament(){
        return nameDepartament;
    }

    public void setNameDepartament(String nameDepartament){
        this.nameDepartament = nameDepartament;
    }

    @OneToOne(mappedBy = "departament" , cascade = CascadeType.ALL, orphanRemoval = true)
    private Employee employee;

    public Employee getEmployee(){
        return employee;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }


    @Override
    public String toString(){
        return "models.Department{" +
                "id= " + id +
                ", nameDepartment='" + nameDepartament + '\'' +
                '}';
    }
}
