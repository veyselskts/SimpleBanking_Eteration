/*
 * Author: Veysel Işıktaş
 * Created for: Eteration Simple Banking Assignment
 * Purpose: This class represents the response structure for account transactions, including status and an approval code.
 */

 package com.eteration.simplebanking.controller;

 public class TransactionStatus {
 
     private String status;
     private String approvalCode;
 
     public TransactionStatus() {
     }
 
     public TransactionStatus(String status, String approvalCode) {
         this.status = status;
         this.approvalCode = approvalCode;
     }
 
     public String getStatus() {
         return status;
     }
 
     public String getApprovalCode() {
         return approvalCode;
     }
 
     public void setStatus(String status) {
         this.status = status;
     }
 
     public void setApprovalCode(String approvalCode) {
         this.approvalCode = approvalCode;
     }
 }
 