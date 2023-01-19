package learnprogramming;

import java.util.HashMap;
import java.util.Scanner;

public class Institute_Placement_Cell {
    public static String op_com_date;
    public static String cl_com_date;
    public static String op_stud_date;
    public static String cl_stud_date;
    public static void update_cgpa(Student student,double new_cgpa,double old_cgpa){ //updating the student's cgpa
        student.setCgpa(new_cgpa);
        System.out.println(student.getName()+" your cgpa has been updated from "+old_cgpa+" to "+new_cgpa);
    }
    // Initialization of a HashMap using Generics of the student record with student name as the key and Student object as the value of that key.
    //This will contain all the added students, but they may or may not have registered for the placement drive.
    public static HashMap<String, Student> Add_student_record = new HashMap<>();
    // Initialization of a HashMap using Generics of the company record with company name as the key and Company object as the value of that key.
    //This will contain all the added companies, but they may or may not have registered for the placement drive.
    public static HashMap<String, Company> Add_company_record = new HashMap<>();

    //This will contain all the added companies those who have registered for the placement drive.
    public static HashMap<String, Company> Reg_company_record = new HashMap<>();
    //This will contain all the added students those who have registered for the placement drive.
    public static HashMap<String, Student> Reg_student_record = new HashMap<>();

    //function to add company
    public static void add_company(Company company){
        Add_company_record.put(company.getName(),company);
    }
    //function to add student
    public static void add_student(Student student){
        Add_student_record.put(student.getName(),student);
    }
    //function to reg company
    public static void reg_company(Company company){
        Reg_company_record.put(company.getName(),company);
    }
    //function to reg student
    public static void reg_student(Student student){
        Reg_student_record.put(student.getName(),student);
    }

    public static int number_stud_register(){
        return Reg_student_record.size();
    }
    public static int number_comp_register(){
        return Reg_company_record.size();
    }
    public static int number_stud_add(){
        return Add_student_record.size();
    }
    public static int number_comp_add(){
        return Add_company_record.size();
    }
    public static void open_company_reg(Scanner sc){
        System.out.println("Institute is is open for company-registrations for the placement.");
        System.out.println("Fill in the details:-");
        System.out.println("Set the Opening time for company registrations:");
        System.out.println("Enter the registration date and time in the format yyyy/MM/dd HH:mm");
        Institute_Placement_Cell.op_com_date=sc.nextLine();
        System.out.println("Set the Closing time for company registrations:");
        System.out.println("Format:(Date Month Year Hour Minutes Seconds)(24-hr System):");
        Institute_Placement_Cell.cl_com_date=sc.nextLine();
    }

    public static boolean open_student_reg(Scanner sc){
        System.out.println("Institute is is open for student-registrations for the placement.");
        System.out.println("Fill in the details:-");
        System.out.println("Set the Opening time for student registrations:");
        System.out.println("Enter the registration date and time in the format yyyy/MM/dd HH:mm");
        String k=sc.nextLine();
        if(k.compareTo(Institute_Placement_Cell.cl_com_date)>=0){
            Institute_Placement_Cell.op_stud_date=k;
            System.out.println("Set the Closing time for student registrations:");
            System.out.println("Format:(Date Month Year Hour Minutes Seconds)(24-hr System):");
            Institute_Placement_Cell.cl_stud_date=sc.nextLine();
            return true;
        }
        else{
            System.out.println("Student registrations can't start before the company registrations end.");
            System.out.println("Enter the valid date and time.");
            System.out.println();
            return false;
        }
    }
    public static void getStudentDetails(String name,int roll_num){
        System.out.println("Details of "+name+" are:");
        System.out.println("Name: "+name);
        System.out.println("Roll number: "+roll_num);
        System.out.println("CGPA: "+Institute_Placement_Cell.Reg_student_record.get(name).getCgpa());
        System.out.println("Branch: "+Institute_Placement_Cell.Reg_student_record.get(name).getBranch());
    }

    public static void get_company_process_results(Company company){

        System.out.println("Following are the students selected-");
        double max=0;
        for (HashMap.Entry<Double,Student> entry : company.getStud_reg_for_company().entrySet()) {
            if(max< entry.getKey()){
                max= entry.getKey();
            }
        }
        company.getStud_reg_for_company().get(max).getOffer_by_comp().put(company.getPackage_offer(), company);
        company.getStud_reg_for_company().get(max).setCurrent_status(1);
        System.out.println("Name: "+company.getStud_reg_for_company().get(max).getName());
        System.out.println("Roll number: "+company.getStud_reg_for_company().get(max).getRollNumber());
        System.out.println("CGPA: "+company.getStud_reg_for_company().get(max).getCgpa());
        System.out.println("Branch: "+company.getStud_reg_for_company().get(max).getBranch());
        System.out.println();
    }

    public static void getCompanyDetails(String name){
        System.out.println("Details of "+name+" are:");
        System.out.println("Name: "+name);
        System.out.println("Role: "+Institute_Placement_Cell.Reg_company_record.get(name).getRole());
        System.out.println("Package offered: "+Institute_Placement_Cell.Reg_company_record.get(name).getPackage_offer());
        System.out.println("CGPA criterion: "+Institute_Placement_Cell.Reg_company_record.get(name).getCgpa_req());
        System.out.println("Students who are offered jobs by "+name+" are:");
//        double max=0;
//        for (HashMap.Entry<Double,Student> entry : Reg_company_record.get(name).getStud_reg_for_company().entrySet()){
//            if(entry.getKey()>max){
//                max= entry.getKey();
//            }
//        }
//        System.out.println("Name: "+Reg_company_record.get(name).getStud_reg_for_company().get(max).getName());
//        System.out.println("Roll number: "+Reg_company_record.get(name).getStud_reg_for_company().get(max).getRollNumber());
//        System.out.println("CGPA: "+Reg_company_record.get(name).getStud_reg_for_company().get(max).getCgpa());
//        System.out.println("Branch: "+Reg_company_record.get(name).getStud_reg_for_company().get(max).getBranch());
//        System.out.println("Package offered: "+Reg_company_record.get(name).getPackage_offer());
    }
}
