package com.nucleus.charge.model;


import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Table(name="charges")
public class NewCharge {

    @NotEmpty(message = "Charge code cannot be empty.")
    @Id
    @Column(name="ChargeCode", nullable = false, length = 10)
    private String chargeCode;

    @NotEmpty(message = "Charge Code Name cannot be empty.")
    @Pattern(regexp="^[a-zA-Z]+$", message="Only Alphabets are allowed")
    @Column(name = "ChargeCodeName", unique = true, nullable = false, length = 20)
    private String chargeCodeName;

    @Column(name = "ChargePolicyDesc", length = 200)
    private String chargeDescription;

    @NotEmpty(message = "Please select a Transaction Event")
    @Column(name = "TransactionEvent", length = 40)
    private String transactionEvent;

    @NotEmpty(message = "Please select charge payment type")
    @Column(name = "ChargePaymentType", nullable = false, length = 20)
    private String chargePaymentType;

    @NotEmpty(message = "Please select a charge type")
    @Column(name = "ChargeType", nullable = false, length = 20)
    private String chargeType;

    @Digits(integer = 10, fraction = 2, message = "Charge Amount should be of 0000000000.00")
    @Column(name = "ChargeAmount")
    private double chargeAmount;

    @Column
    private LocalDate createDate;

    @Column(length = 30)
    private String createdBy;

    @Column
    private LocalDate modifiedDate;

    @Column(length = 30)
    private String modifiedBy;

    @Column
    private LocalDate authorizedDate;

    @Column(length = 30)
    private String authorizedBy;

    @Column(length = 50)
    private String status;

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public String getChargeCodeName() {
        return chargeCodeName;
    }

    public void setChargeCodeName(String chargecodeName) {
        this.chargeCodeName = chargecodeName;
    }

    public String getChargeDescription() {
        return chargeDescription;
    }

    public void setChargeDescription(String chargeDescription) {
        this.chargeDescription = chargeDescription;
    }

    public String getTransactionEvent() {
        return transactionEvent;
    }

    public void setTransactionEvent(String transactionEvent) {
        this.transactionEvent = transactionEvent;
    }

    public String getChargePaymentType() {
        return chargePaymentType;
    }

    public void setChargePaymentType(String chargePaymentType) {
        this.chargePaymentType = chargePaymentType;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public double getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(double chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDate getAuthorizedDate() {
        return authorizedDate;
    }

    public void setAuthorizedDate(LocalDate authorizedDate) {
        this.authorizedDate = authorizedDate;
    }

    public String getAuthorizedBy() {
        return authorizedBy;
    }

    public void setAuthorizedBy(String authorizedBy) {
        this.authorizedBy = authorizedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
