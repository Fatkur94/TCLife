package com.techcombank.tclife.dataService.model.entity;

import com.techcombank.tclife.common.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "leads")
public class Lead extends BaseEntity {

    @Id
    @Column(name = "lead_id")
    private String leadId;

    @Column(name = "ref_code")
    private String refCode;

    @Column(name = "referral_date")
    private Date referralDate;

    @Column(name = "bank_staff_id")
    private String bankStaffId;

    @Column(name = "bank_staff_name")
    private String bankStaffName;

    @Column(name = "branch_code")
    private String branchCode;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "identity_customer_info")
    private String identityCustomerInfo;

    @Column(name = "identity_type")
    private String identityType;

    @Column(name = "po_dob")
    private Date poDob;

    @Column(name = "po_gender")
    private String poGender;

    @Column(name = "po_identity_issue_date")
    private Date poidentityIssueDate;

    @Column(name = "po_identity_exp_date")
    private Date poidentityExpDate;

    @Column(name = "po_email")
    private String poEmail;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "i_OIS_code")
    private String iOISCode;

    @Column(name = "province_code")
    private String provinceCode;

    @Column(name = "district_code")
    private String districtCode;

    @Column(name = "ward_code")
    private String wardCode;

    @Column(name = "aml_inlist")
    private String amlInlist;

    @Column(name = "am_status")
    private String amStatus;

    @Column(name = "channel")
    private String channel;

    @Column(name = "ins_partner")
    private String insPartner;
}

