package br.com.bankfacil.androidjsonapi;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by broto on 17/02/16.
 */
public class ApplicationModel {

    @SerializedName("amortization-system")
    public String amortizationSystem;

    @SerializedName("cars-quantity")
    public Object carsQuantity;

    @SerializedName("cars-total-value")
    public Object carsTotalValue;

    @SerializedName("extra-purpose")
    public Object extraPurpose;

    @SerializedName("finance-appraisal-report")
    public Object financeAppraisalReport;

    @SerializedName("finance-broker-expenditures")
    public Object financeBrokerExpenditures;

    @SerializedName("finance-legal-analysis")
    public Object financeLegalAnalysis;

    @SerializedName("finance-real-estate-transmission-tax")
    public Object financeRealEstateTransmissionTax;

    @SerializedName("finance-registration-expenditures")
    public Object financeRegistrationExpenditures;

    @SerializedName("financing-time-months")
    public int financingTimeMonths;

    @SerializedName("intended-credit")
    public String intendedCredit;

    @SerializedName("kinship-to-additional-requester")
    public Object kinshipToAdditionalRequester;

    @SerializedName("kinship-to-other-additional-requester")
    public Object kinshipToOtherAdditionalRequester;

    @SerializedName("other-assets-quantity")
    public Object otherAssetsQuantity;

    @SerializedName("other-assets-total-value")
    public Object otherAssetsTotalValue;

    @SerializedName("other-real-estates-quantity")
    public Object otherRealEstatesQuantity;

    @SerializedName("other-real-estates-total-value")
    public Object otherRealEstatesTotalValue;

    @SerializedName("preference-expiration-day")
    public Object preferenceExpirationDay;

    @SerializedName("purpose")
    public String purpose;

    @SerializedName("real-estate-condition")
    public String realEstateCondition;

    @SerializedName("real-estate-contact-inspection-name")
    public String realEstateContactInspectionName;

    @SerializedName("real-estate-contact-inspection-phone")
    public String realEstateContactInspectionPhone;

    @SerializedName("real-estate-contact-inspection-phone-code")
    public String realEstateContactInspectionPhoneCode;

    @SerializedName("real-estate-debts-total-value")
    public String realEstateDebtsTotalValue;

    @SerializedName("real-estate-estimated-value")
    public String realEstateEstimatedValue;

    @SerializedName("real-estate-has-debts")
    public boolean realEstateHasDebts;

    @SerializedName("real-estate-keys-in-place")
    public boolean realEstateKeysInPlace;

    @SerializedName("real-estate-number-of-garages")
    public int realEstateNumberOfGarages;

    @SerializedName("real-estate-owner-cnpj")
    public Object realEstateOwnerCnpj;

    @SerializedName("real-estate-owner-cpf")
    public String realEstateOwnerCpf;

    @SerializedName("real-estate-owner-has-employees")
    public Object realEstateOwnerHasEmployees;

    @SerializedName("real-estate-owner-name")
    public String realEstateOwnerName;

    @SerializedName("real-estate-owner-represented-by-power-of-attorney")
    public Object realEstateOwnerRepresentedByPowerOfAttorney;

    @SerializedName("real-estate-type")
    public String realEstateType;

    @SerializedName("residence-price")
    public String residencePrice;

    @SerializedName("step-states")
    public List<String> stepStates = new ArrayList<String>();

//    @SerializedName("additional-requester")
//    public Relationship additionalRequester;

    public String getAmortizationSystem() {
        return amortizationSystem;
    }

    public void setAmortizationSystem(String amortizationSystem) {
        this.amortizationSystem = amortizationSystem;
    }

    public Object getCarsQuantity() {
        return carsQuantity;
    }

    public void setCarsQuantity(Object carsQuantity) {
        this.carsQuantity = carsQuantity;
    }

    public Object getCarsTotalValue() {
        return carsTotalValue;
    }

    public void setCarsTotalValue(Object carsTotalValue) {
        this.carsTotalValue = carsTotalValue;
    }

    public Object getExtraPurpose() {
        return extraPurpose;
    }

    public void setExtraPurpose(Object extraPurpose) {
        this.extraPurpose = extraPurpose;
    }

    public Object getFinanceAppraisalReport() {
        return financeAppraisalReport;
    }

    public void setFinanceAppraisalReport(Object financeAppraisalReport) {
        this.financeAppraisalReport = financeAppraisalReport;
    }

    public Object getFinanceBrokerExpenditures() {
        return financeBrokerExpenditures;
    }

    public void setFinanceBrokerExpenditures(Object financeBrokerExpenditures) {
        this.financeBrokerExpenditures = financeBrokerExpenditures;
    }

    public Object getFinanceLegalAnalysis() {
        return financeLegalAnalysis;
    }

    public void setFinanceLegalAnalysis(Object financeLegalAnalysis) {
        this.financeLegalAnalysis = financeLegalAnalysis;
    }

    public Object getFinanceRealEstateTransmissionTax() {
        return financeRealEstateTransmissionTax;
    }

    public void setFinanceRealEstateTransmissionTax(Object financeRealEstateTransmissionTax) {
        this.financeRealEstateTransmissionTax = financeRealEstateTransmissionTax;
    }

    public Object getFinanceRegistrationExpenditures() {
        return financeRegistrationExpenditures;
    }

    public void setFinanceRegistrationExpenditures(Object financeRegistrationExpenditures) {
        this.financeRegistrationExpenditures = financeRegistrationExpenditures;
    }

    public int getFinancingTimeMonths() {
        return financingTimeMonths;
    }

    public void setFinancingTimeMonths(int financingTimeMonths) {
        this.financingTimeMonths = financingTimeMonths;
    }

    public String getIntendedCredit() {
        return intendedCredit;
    }

    public void setIntendedCredit(String intendedCredit) {
        this.intendedCredit = intendedCredit;
    }

    public Object getKinshipToAdditionalRequester() {
        return kinshipToAdditionalRequester;
    }

    public void setKinshipToAdditionalRequester(Object kinshipToAdditionalRequester) {
        this.kinshipToAdditionalRequester = kinshipToAdditionalRequester;
    }

    public Object getKinshipToOtherAdditionalRequester() {
        return kinshipToOtherAdditionalRequester;
    }

    public void setKinshipToOtherAdditionalRequester(Object kinshipToOtherAdditionalRequester) {
        this.kinshipToOtherAdditionalRequester = kinshipToOtherAdditionalRequester;
    }

    public Object getOtherAssetsQuantity() {
        return otherAssetsQuantity;
    }

    public void setOtherAssetsQuantity(Object otherAssetsQuantity) {
        this.otherAssetsQuantity = otherAssetsQuantity;
    }

    public Object getOtherAssetsTotalValue() {
        return otherAssetsTotalValue;
    }

    public void setOtherAssetsTotalValue(Object otherAssetsTotalValue) {
        this.otherAssetsTotalValue = otherAssetsTotalValue;
    }

    public Object getOtherRealEstatesQuantity() {
        return otherRealEstatesQuantity;
    }

    public void setOtherRealEstatesQuantity(Object otherRealEstatesQuantity) {
        this.otherRealEstatesQuantity = otherRealEstatesQuantity;
    }

    public Object getOtherRealEstatesTotalValue() {
        return otherRealEstatesTotalValue;
    }

    public void setOtherRealEstatesTotalValue(Object otherRealEstatesTotalValue) {
        this.otherRealEstatesTotalValue = otherRealEstatesTotalValue;
    }

    public Object getPreferenceExpirationDay() {
        return preferenceExpirationDay;
    }

    public void setPreferenceExpirationDay(Object preferenceExpirationDay) {
        this.preferenceExpirationDay = preferenceExpirationDay;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getRealEstateCondition() {
        return realEstateCondition;
    }

    public void setRealEstateCondition(String realEstateCondition) {
        this.realEstateCondition = realEstateCondition;
    }

    public String getRealEstateContactInspectionName() {
        return realEstateContactInspectionName;
    }

    public void setRealEstateContactInspectionName(String realEstateContactInspectionName) {
        this.realEstateContactInspectionName = realEstateContactInspectionName;
    }

    public String getRealEstateContactInspectionPhone() {
        return realEstateContactInspectionPhone;
    }

    public void setRealEstateContactInspectionPhone(String realEstateContactInspectionPhone) {
        this.realEstateContactInspectionPhone = realEstateContactInspectionPhone;
    }

    public String getRealEstateContactInspectionPhoneCode() {
        return realEstateContactInspectionPhoneCode;
    }

    public void setRealEstateContactInspectionPhoneCode(String realEstateContactInspectionPhoneCode) {
        this.realEstateContactInspectionPhoneCode = realEstateContactInspectionPhoneCode;
    }

    public String getRealEstateDebtsTotalValue() {
        return realEstateDebtsTotalValue;
    }

    public void setRealEstateDebtsTotalValue(String realEstateDebtsTotalValue) {
        this.realEstateDebtsTotalValue = realEstateDebtsTotalValue;
    }

    public String getRealEstateEstimatedValue() {
        return realEstateEstimatedValue;
    }

    public void setRealEstateEstimatedValue(String realEstateEstimatedValue) {
        this.realEstateEstimatedValue = realEstateEstimatedValue;
    }

    public boolean isRealEstateHasDebts() {
        return realEstateHasDebts;
    }

    public void setRealEstateHasDebts(boolean realEstateHasDebts) {
        this.realEstateHasDebts = realEstateHasDebts;
    }

    public boolean isRealEstateKeysInPlace() {
        return realEstateKeysInPlace;
    }

    public void setRealEstateKeysInPlace(boolean realEstateKeysInPlace) {
        this.realEstateKeysInPlace = realEstateKeysInPlace;
    }

    public int getRealEstateNumberOfGarages() {
        return realEstateNumberOfGarages;
    }

    public void setRealEstateNumberOfGarages(int realEstateNumberOfGarages) {
        this.realEstateNumberOfGarages = realEstateNumberOfGarages;
    }

    public Object getRealEstateOwnerCnpj() {
        return realEstateOwnerCnpj;
    }

    public void setRealEstateOwnerCnpj(Object realEstateOwnerCnpj) {
        this.realEstateOwnerCnpj = realEstateOwnerCnpj;
    }

    public String getRealEstateOwnerCpf() {
        return realEstateOwnerCpf;
    }

    public void setRealEstateOwnerCpf(String realEstateOwnerCpf) {
        this.realEstateOwnerCpf = realEstateOwnerCpf;
    }

    public Object getRealEstateOwnerHasEmployees() {
        return realEstateOwnerHasEmployees;
    }

    public void setRealEstateOwnerHasEmployees(Object realEstateOwnerHasEmployees) {
        this.realEstateOwnerHasEmployees = realEstateOwnerHasEmployees;
    }

    public String getRealEstateOwnerName() {
        return realEstateOwnerName;
    }

    public void setRealEstateOwnerName(String realEstateOwnerName) {
        this.realEstateOwnerName = realEstateOwnerName;
    }

    public Object getRealEstateOwnerRepresentedByPowerOfAttorney() {
        return realEstateOwnerRepresentedByPowerOfAttorney;
    }

    public void setRealEstateOwnerRepresentedByPowerOfAttorney(Object realEstateOwnerRepresentedByPowerOfAttorney) {
        this.realEstateOwnerRepresentedByPowerOfAttorney = realEstateOwnerRepresentedByPowerOfAttorney;
    }

    public String getRealEstateType() {
        return realEstateType;
    }

    public void setRealEstateType(String realEstateType) {
        this.realEstateType = realEstateType;
    }

    public String getResidencePrice() {
        return residencePrice;
    }

    public void setResidencePrice(String residencePrice) {
        this.residencePrice = residencePrice;
    }

    public List<String> getStepStates() {
        return stepStates;
    }

    public void setStepStates(List<String> stepStates) {
        this.stepStates = stepStates;
    }

//    public Relationship getAdditionalRequester() {
//        return additionalRequester;
//    }
//
//    public void setAdditionalRequester(Relationship additionalRequester) {
//        this.additionalRequester = additionalRequester;
//    }

    @Override
    public String toString() {
        return "ApplicationModel{" +
                "amortizationSystem='" + amortizationSystem + '\'' +
                ", carsQuantity=" + carsQuantity +
                ", carsTotalValue=" + carsTotalValue +
                ", extraPurpose=" + extraPurpose +
                ", financeAppraisalReport=" + financeAppraisalReport +
                ", financeBrokerExpenditures=" + financeBrokerExpenditures +
                ", financeLegalAnalysis=" + financeLegalAnalysis +
                ", financeRealEstateTransmissionTax=" + financeRealEstateTransmissionTax +
                ", financeRegistrationExpenditures=" + financeRegistrationExpenditures +
                ", financingTimeMonths=" + financingTimeMonths +
                ", intendedCredit='" + intendedCredit + '\'' +
                ", kinshipToAdditionalRequester=" + kinshipToAdditionalRequester +
                ", kinshipToOtherAdditionalRequester=" + kinshipToOtherAdditionalRequester +
                ", otherAssetsQuantity=" + otherAssetsQuantity +
                ", otherAssetsTotalValue=" + otherAssetsTotalValue +
                ", otherRealEstatesQuantity=" + otherRealEstatesQuantity +
                ", otherRealEstatesTotalValue=" + otherRealEstatesTotalValue +
                ", preferenceExpirationDay=" + preferenceExpirationDay +
                ", purpose='" + purpose + '\'' +
                ", realEstateCondition='" + realEstateCondition + '\'' +
                ", realEstateContactInspectionName='" + realEstateContactInspectionName + '\'' +
                ", realEstateContactInspectionPhone='" + realEstateContactInspectionPhone + '\'' +
                ", realEstateContactInspectionPhoneCode='" + realEstateContactInspectionPhoneCode + '\'' +
                ", realEstateDebtsTotalValue='" + realEstateDebtsTotalValue + '\'' +
                ", realEstateEstimatedValue='" + realEstateEstimatedValue + '\'' +
                ", realEstateHasDebts=" + realEstateHasDebts +
                ", realEstateKeysInPlace=" + realEstateKeysInPlace +
                ", realEstateNumberOfGarages=" + realEstateNumberOfGarages +
                ", realEstateOwnerCnpj=" + realEstateOwnerCnpj +
                ", realEstateOwnerCpf='" + realEstateOwnerCpf + '\'' +
                ", realEstateOwnerHasEmployees=" + realEstateOwnerHasEmployees +
                ", realEstateOwnerName='" + realEstateOwnerName + '\'' +
                ", realEstateOwnerRepresentedByPowerOfAttorney=" + realEstateOwnerRepresentedByPowerOfAttorney +
                ", realEstateType='" + realEstateType + '\'' +
                ", residencePrice='" + residencePrice + '\'' +
                ", stepStates=" + stepStates +
                '}';
    }
}
