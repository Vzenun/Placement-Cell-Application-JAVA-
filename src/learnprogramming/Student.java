package learnprogramming;

import java.util.HashMap;
import java.util.Scanner;

public class Student{
    private String name;
    private int rollNumber;
    private double cgpa;
    private String branch;


    private int current_status;
    //Here value 0 indicates unoffered.
    //Here value 1 indicates offered.
    //Here value -1 indicates blocked.


    private double highest_ctc_held;// by default set to zero.

    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }

    private boolean placed;

    public HashMap<Company, Boolean> getCompany_stud_reg() {
        return company_stud_reg;
    }

    private HashMap<Company, Boolean> company_stud_reg= new HashMap<>();
    private HashMap<Double, Company> offer_by_comp= new HashMap<>();

    public HashMap<Double, Company> getOffer_by_comp() {
        return offer_by_comp;
    }

    public void setHighest_ctc_held(double highest_ctc_held) {// highest_ctc_held
        this.highest_ctc_held = highest_ctc_held;
    }

    public int getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(int current_status) {
        this.current_status = current_status;
    }

    public double getHighest_ctc_held() { // highest_ctc_held
        return highest_ctc_held;
    }


    public Student(String name, int rollNumber, double cgpa, String branch) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.cgpa = cgpa;
        this.branch = branch;
        this.current_status=0;
        this.highest_ctc_held=0; //by default student has no ctc by any company.
    }

    public String getName() {
        return this.name;
    }

    public int getRollNumber() {
        return this.rollNumber;
    }

    public double getCgpa() {
        return this.cgpa;
    }

    public String getBranch() {
        return this.branch;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    public boolean setDate() { //this is called when student is registering for the placement drive
        System.out.println("Enter the current time:");
        System.out.println("Enter the registration date and time in the format yyyy/MM/dd HH:mm");
        Scanner sc=new Scanner(System.in);
        String k=sc.nextLine();

        if(k.compareTo(Institute_Placement_Cell.op_stud_date)>=0 && k.compareTo(Institute_Placement_Cell.cl_stud_date)<=0){
            this.setTime(k);
            return true;
        }
        else{
            System.out.println("Sorry you cannot register!!");
            return false;
        }
    }
    public boolean reg_for_company(Company company){// Register For Company.
        if(company.is_eligible(this)){
            company.getStud_reg_for_company().put(this.getCgpa(),this);
            company_stud_reg.put(company,true);
            return true;//these are the companies that the student has actually applied for
        }
        else{
            return false;
        }
    }
    public void get_all_available_companies(){
        int i=1;
        for (HashMap.Entry<String,Company> entry : Institute_Placement_Cell.Reg_company_record.entrySet()){
            System.out.println(i+") "+entry.getKey());
            i++;
            System.out.println("Company role offering: "+entry.getValue().getRole());
            System.out.println("Company Package: "+entry.getValue().getPackage_offer()+" LPA");
            System.out.println("Company CGPA criteria: "+entry.getValue().getCgpa_req());
            if(entry.getValue().is_eligible(this)){
                System.out.println("Status: Available");
            }
            else{
                System.out.println("Status: Unavailable");
            }
            System.out.println();
        }
    }

}
