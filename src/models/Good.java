package models;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "goods")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "goodName")
    private String name;
    @Column(name = "goodCount")
    private int goodCount;
    @Column(name = "goodPrice")
    private float goodPrice;

    public Good(){

    }

    public Good(String name, int goodCount, float goodPrice){
        this.name = name;
        this.goodCount = goodCount;
        this.goodPrice = goodPrice;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getGoodCount(){
        return goodCount;
    }

    public void setGoodCount(int goodCount){
        this.goodCount = goodCount;
    }

    public Float getGoodPrice(){
        return goodPrice;
    }

    public void setGoodPrice(float goodPrice){
        this.goodPrice = goodPrice;
    }

    @Override
    public String toString(){
        return "models.Good{" +
                "id= " + id +
                ", name='" + name + '\'' +
                ", goodCount='" + goodCount + '\'' +
                ", goodPrice=" + goodPrice +
                '}';
    }


}
