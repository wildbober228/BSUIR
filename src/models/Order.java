package models;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("ALL")
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "createdAt")
    private Date createdAt;

    private int customerId;
    private int goodId;

    @OneToOne()
    @JoinColumn(name = "customerId", insertable = false, updatable = false)
    private Customer customer;

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    //@Column(name = "FK_Customers",nullable = false, insertable = false, unique = false)
    public int getCustomerId(){
        return customerId;
    }

    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }

    @OneToOne()
    @JoinColumn(name = "goodId", insertable = false, updatable = false)
    private Good good;

    public Good getGood(){
        return good;
    }

    public void setGood(Good good){
        this.good = good;
    }

    //@Column(name = "FK_Goods",nullable = false, insertable = false, unique = false)
    public int getGoodId(){
        return goodId;
    }

    public void setGoodId(int goodId){
        this.goodId = goodId;
    }

    public Order(){

    }

    public Order(Date createdAt){
        this.createdAt = createdAt;
    }

    public int getId(){
        return id;
    }

    public Date getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;
    }

    @Override
    public String toString(){
        return "models.Order{" +
                "id= " + id +
                ", createdAt='" + createdAt + '\'' +
                ", customerSurname=" + customer.getName() +" "+customer.getSurname() + '\'' +
                ", goodName=" + good.getName() + '\'' +
                ", goodCount=" + good.getGoodCount() + '\'' +
                ", goodPrice=" + good.getGoodPrice() + '\'' +
                '}';
    }
}
