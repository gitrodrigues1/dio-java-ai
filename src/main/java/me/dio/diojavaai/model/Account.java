package me.dio.diojavaai.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_account")
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;

    private String agency;

    private BigDecimal balance;
    
    // 9.999.999.999.999,99
    @Column( name = "additional_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getAgency() {
        return agency;
    }
    public void setAgency(String agency) {
        this.agency = agency;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public BigDecimal getLimit() {
        return limit;
    }
    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }


    
}
