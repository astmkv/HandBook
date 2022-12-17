package com.example.handbook.db.entities;


import javax.persistence.*;

@Entity
@Table(name="device_t")
public class Device1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String deviceName;                              // наименование

    @Column(nullable = false, length = 50)
    private String value;                               // измеряемая величина

    @Column(nullable = false, length = 50)
    private String type;                              // вид(род) измеряемой величины

    @Column(nullable = false, name = "range")
    private Integer range;                              // диапазон

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }



    public Device1() {
    }

//    @Column(nullable = false)
//    private String range;

//    @Column()
//    private float accuracy;                            // точность
//
//    @Column()
//    private Integer price;                              // цена
//

//    public Manufacturer getManu() {
//        return manu;
//    }
//
//    public void setManu(Manufacturer manu) {
//        this.manu = manu;
//    }
//
//    public Integer getPrice() {
//        return price;
//    }
//
//    public void setPrice(Integer price) {
//        this.price = price;
//    }



//    @ManyToOne
//    @JoinColumn(name="manu_id")
//    private Manufacturer manu;                          // производитель



}
