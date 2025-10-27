package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    main_class(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        JMenuBar mb = new JMenuBar();
        // new information

        JMenu newInfo = new JMenu("New Information");
        newInfo.setForeground(Color.BLACK);
        mb.add(newInfo);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);

        // Details

        JMenu details = new JMenu("View Details");
        details.setForeground(Color.BLACK);
        details.addActionListener(this);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        // Leave

        JMenu leaves = new JMenu("Apply Leave");
        leaves.setForeground(Color.BLACK);
        leaves.addActionListener(this);
        mb.add(leaves);

        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leaves.add(facultyleave);

        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        leaves.add(studentleave);

        // Leave Details

        JMenu leaveDetails = new JMenu("Leave");
        leaveDetails.setForeground(Color.BLACK);
        leaveDetails.addActionListener(this);
        mb.add(leaveDetails);

        JMenuItem facultyleaveDetails = new JMenuItem("Faculty Leave Details");
        facultyleaveDetails.setBackground(Color.WHITE);
        facultyleaveDetails.addActionListener(this);
        leaveDetails.add(facultyleaveDetails);

        JMenuItem studentleaveDetails = new JMenuItem("Student Leave Details");
        studentleaveDetails.setBackground(Color.WHITE);
        studentleaveDetails.addActionListener(this);
        leaveDetails.add(studentleaveDetails);

        //Exam

        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLACK);
        exam.addActionListener(this);
        mb.add(exam);

        JMenuItem ExaminationDetails = new JMenuItem("Examination Details");
        ExaminationDetails.setBackground(Color.WHITE);
        ExaminationDetails.addActionListener(this);
        exam.add(ExaminationDetails);

        JMenuItem EnterMarks = new JMenuItem("Enter Marks");
        EnterMarks.setBackground(Color.WHITE);
        EnterMarks.addActionListener(this);
        exam.add(EnterMarks);

        // update info

        JMenu UpdateInfo = new JMenu("Update Details");
        UpdateInfo.setForeground(Color.BLACK);
        UpdateInfo.addActionListener(this);
        mb.add(UpdateInfo);

        JMenuItem Updatefacultyinfo = new JMenuItem("Update Faculty Details");
        Updatefacultyinfo.setBackground(Color.WHITE);
        Updatefacultyinfo.addActionListener(this);
        UpdateInfo.add(Updatefacultyinfo);

        JMenuItem Updatestudentinfo = new JMenuItem("Update Student Details");
        Updatestudentinfo.setBackground(Color.WHITE);
        Updatestudentinfo.addActionListener(this);
        UpdateInfo.add(Updatestudentinfo);

        // fee

        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLACK);
        fee.addActionListener(this);
        mb.add(fee);

        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        fee.add(feestructure);

        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.WHITE);
        feeForm.addActionListener(this);
        fee.add(feeForm);

        // utility

        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLACK);
        mb.add(utility);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        // about

        JMenu about = new JMenu("About");
        about.setForeground(Color.BLACK);
        mb.add(about);

        JMenuItem About = new JMenuItem("About");
        About.setBackground(Color.WHITE);
        About.addActionListener(this);
        about.add(About);

        // exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLACK);
        mb.add(exit);

        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setBackground(Color.WHITE);
        Exit.addActionListener(this);
        exit.add(Exit);





        setJMenuBar(mb);


        setSize(1540,850);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm = e.getActionCommand();
        if(sm.equals("Exit")){
            System.exit(15);
        } else if (sm.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (sm.equals("Notepad")) {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception E) {
                E.printStackTrace();
            }

        } else if (sm.equals("New Faculty Information")) {
            new AddFaculty();
        }else if (sm.equals("New Student Information")){
            new AddStudent();
        } else if (sm.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (sm.equals("View Student Details")) {
            new StudentDetails();
        } else if (sm.equals("Faculty Leave")) {
            new TeacherLeave();
        } else if (sm.equals("Student Leave")) {
            new StudentLeave();
        } else if (sm.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (sm.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        } else if (sm.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (sm.equals("Update Student Details")) {
            new UpdateStudent();
        } else if (sm.equals("Enter Marks")) {
            new EnterMarks();
        } else if (sm.equals("Examination Details")) {
            new ExaminationDetails();
        } else if (sm.equals("Fee Structure")) {
            new FeeStructure();
        }else if (sm.equals("Student Fee Form")){
            new StudentFeeForm();
        } else if (sm.equals("About")) {
            new About();
        }
    }

    public static void main(String[] args) {
        new main_class();
    }
}
