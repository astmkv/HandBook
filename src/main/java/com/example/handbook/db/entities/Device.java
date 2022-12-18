package com.example.handbook.db.entities;


import javax.persistence.*;

@Entity
@Table(name="device_t")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String deviceName;                              // наименование

    @Column(nullable = false, length = 50)
    private String value;                                   // измеряемая величина

    @Column(nullable = false, length = 50)
    private String type;                                    // вид(род) измеряемой величины

    public Integer getRangeMeasuring() {
        return rangeMeasuring;
    }

    public void setRangeMeasuring(Integer rangeMeasuring) {
        this.rangeMeasuring = rangeMeasuring;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    @Column(nullable = false)
    private Integer rangeMeasuring;                         // диапазон измерений

    @Column(nullable = true)
    private Double accuracy;                                // точность

    @Column(nullable = true)
    private Integer price;                                  // цена

    @ManyToOne
    @JoinColumn(name="manu_id")
    private Manufacturer manu;                              // производитель

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

    public Manufacturer getManu() {
        return manu;
    }

    public void setManu(Manufacturer manu) {
        this.manu = manu;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }







}
