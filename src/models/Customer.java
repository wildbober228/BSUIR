package models;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    private int discountId;

    public Discount getDiscount(){
        return discount;
    }

    public void setDiscount(Discount discount){
        this.discount = discount;
    }

    public void setDiscountId(int discountId){
        this.discountId = discountId;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discountId", unique = true, insertable = false, updatable = false)
    private Discount discount;


    public Customer(){

    }

    public Customer(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setsName(String name){
        this.name = name;
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
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", discountAmount=" + discount.getAmountDiscount() +
                '}';
    }

}
