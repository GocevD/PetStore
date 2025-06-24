package com.gocevd.petstore.model;

import com.gocevd.petstore.model.enumerations.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pets")
public abstract class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Column
    private String description;

    @Embedded
    private Money price;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate birthDate;

    public Pet() {}

    public Pet(String name, String description, LocalDate birthDate) {
        this.name = name;
        this.description = description;
        this.birthDate = birthDate;
    }

    public int getAge() {
        return java.time.Period.between(birthDate, LocalDate.now()).getYears();
    }

    public void setOwner(User owner){
        this.owner = owner;
        successfulPurchaseMessage();
    }

    public boolean canBePurchased(){
        return this.owner == null;
    }

    public abstract String successfulPurchaseMessage();
    public abstract double calculatePrice();
}
