package com.Bean;

/**
 * 陪玩申请列表实现
 */
public class Applicant {
    private int id;
    private String applicant;
    private int role;
    //private int result;


    public Applicant(int id, String applicant, int role) {
        this.id = id;
        this.applicant = applicant;
        this.role = role;
    }

    public Applicant() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    /*public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }*/

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", applicant='" + applicant + '\'' +
                ", role=" + role +
                /*", result=" + result +*/
                '}';
    }
}
