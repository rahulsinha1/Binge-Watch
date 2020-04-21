package edu.northeastern.cs5200.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Critic extends Person{
    private String company;

    public Critic(int id, String firstName, String lastName, String username, String pass, String email, List<Phone> phone, Address address, Role role,String company) {
        super(firstName, lastName, username, pass, email, phone, address, role);
        this.company = company;
    }
    public Critic(){}

    @OneToMany(mappedBy = "critic",fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<CriticList> criticLists;

    public List<CriticList> getCriticList() {
        return criticLists;
    }

    public void setCriticList(List<CriticList> criticList) {
        this.criticLists = criticList;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<CriticList> getCriticLists() {
        return criticLists;
    }

    public void setCriticLists(List<CriticList> criticLists) {
        this.criticLists = criticLists;
    }
}

