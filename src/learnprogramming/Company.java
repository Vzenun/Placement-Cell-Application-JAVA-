package learnprogramming;

import java.util.HashMap;

public class Company {
    private String name;
    private String role;
    private double package_offer;
    private double cgpa_req;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;

    private HashMap<Double ,Student> stud_reg_for_company= new HashMap<>();


    public Company(String name, String role, double package_offer, double cgpa_req) {
        this.name = name;
        this.role = role;
        this.package_offer = package_offer;
        this.cgpa_req = cgpa_req;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPackage_offer(double package_offer) {
        this.package_offer = package_offer;
    }

    public void setCgpa_req(double cgpa_req) {
        this.cgpa_req = cgpa_req;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double getPackage_offer() {
        return package_offer;
    }

    public double getCgpa_req() {
        return cgpa_req;
    }

    public HashMap<Double,Student> getStud_reg_for_company() {
        return stud_reg_for_company;
    }

    public boolean is_eligible(Student student){
        if(student.getCurrent_status()==-1){
            return false;
        }
        else{
            if(student.getCgpa()>=this.getCgpa_req()&& this.package_offer>=3* student.getHighest_ctc_held()){
                return true;
            }
            else{
                return false;
            }
        }
    }
}
