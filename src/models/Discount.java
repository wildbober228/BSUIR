package models;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "amountDiscount")
    private int amountDiscount;

    public Discount(){

    }

    public Discount(int amountDiscount){
        this.amountDiscount = amountDiscount;
    }

    public int getId(){
        return id;
    }

    public int getAmountDiscount(){
        return amountDiscount;
    }

    public void setAmountDiscount(int amountDiscount){
        this.amountDiscount = amountDiscount;
    }

    @Override
    public String toString(){
        return "models.Position{" +
                "id= " + id +
                ", amountDiscount='" + amountDiscount + '\'' +
                '}';
    }
}
