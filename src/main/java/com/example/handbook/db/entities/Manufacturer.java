package com.example.handbook.db.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="manu_t")
public class Manufacturer {

    @OneToMany(mappedBy = "manu", cascade = CascadeType.PERSIST)
    private Set<Device> devices;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String manuName;                           // наименование

    @Column(nullable = false, length = 50)
    private String country;                            // страна

    @Column(nullable = false, length = 50)
    private String logo;                               // логотип

    @Column( length = 80)
    private String comment;                            // примечание

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManuName() {
        return manuName;
    }

    public void setManuName(String manuName) {
        this.manuName = manuName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }




}
