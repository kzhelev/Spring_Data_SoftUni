package firstexc.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="wizard_deposits")
public class WizardDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 60)
    private String lastName;

    @Column(name = "notes", length = 1000)
    private String notes;

    @Column(name = "age")
    private int age;

    @Column(name = "magic_wand_creator", length = 100)
    private String magicWandCreator;

    @Column(name = "magic_wand_size")
    private int wandSize;

    @Column(name = "deposit_group", length = 20)
    private String depositGroup;

    @Column(name = "deposit_start_date")
    private LocalDate depositStartAt;

    @Column(name = "deposit_amount")
    private double depositAmount;

    @Column(name = "deposit_interest")
    private double depositInterest;

    @Column(name = "deposit_charge")
    private double charge;

    @Column(name = "deposit_expiration_date")
    private LocalDate expireAt;

    @Column(name = "is_deposit_expired")
    private boolean isExpired;

    public WizardDeposit(){}

    public WizardDeposit(int id, String firstName, String lastName, String notes, int age, String magicWandCreator,
                         int wandSize, String depositGroup, LocalDate depositStartAt, double depositAmount,
                         double depositInterest, double charge, LocalDate expireAt, boolean isExpired) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.notes = notes;
        this.age = age;
        this.magicWandCreator = magicWandCreator;
        this.wandSize = wandSize;
        this.depositGroup = depositGroup;
        this.depositStartAt = depositStartAt;
        this.depositAmount = depositAmount;
        this.depositInterest = depositInterest;
        this.charge = charge;
        this.expireAt = expireAt;
        this.isExpired = isExpired;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    public int getWandSize() {
        return wandSize;
    }

    public void setWandSize(int wandSize) {
        this.wandSize = wandSize;
    }

    public String getDepositGroup() {
        return depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
    }

    public LocalDate getDepositStartAt() {
        return depositStartAt;
    }

    public void setDepositStartAt(LocalDate depositStartAt) {
        this.depositStartAt = depositStartAt;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getDepositInterest() {
        return depositInterest;
    }

    public void setDepositInterest(double depositInterest) {
        this.depositInterest = depositInterest;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public LocalDate getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalDate expireAt) {
        this.expireAt = expireAt;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }
}
