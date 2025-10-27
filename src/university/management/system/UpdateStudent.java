package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame implements ActionListener {

    JTextField textbranch,textcourse,textAddress,textPhone,textemail,textaadhaar;

    JLabel empText;

    Choice cEMPID;

    JButton submit, cancel;

    UpdateStudent(){
        getContentPane().setBackground(new Color(230,210,252));

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,35));
        add(heading);

        JLabel empID = new JLabel("Select Roll Number");
        empID.setBounds(50,100,200,20);
        empID.setFont(new Font("serif",Font.BOLD,20));
        add(empID);

        cEMPID = new Choice();
        cEMPID.setBounds(250,100,200,20);
        add(cEMPID);

        try{
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from student");
            while (rs.next()){
                cEMPID.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //name

        JLabel name = new JLabel("Name : ");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        JLabel textName = new JLabel();
        textName.setBounds(200,150,150,30);
        add(textName);

        //father name

        JLabel fname = new JLabel("Father Name : ");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        JLabel textfather = new JLabel();
        textfather.setBounds(600,150,150,30);
        add(textfather);

        //empId

        JLabel EMPIDD = new JLabel("Roll Number : ");
        EMPIDD.setBounds(50,200,200,30);
        EMPIDD.setFont(new Font("serif",Font.BOLD,20));
        add(EMPIDD);

        empText = new JLabel();
        empText.setBounds(200,200,150,30);
        empText.setFont(new Font("serif",Font.BOLD,20));
        add(empText);

        //dob

        JLabel dob = new JLabel("Date of Birth : ");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        JLabel dodob = new JLabel();
        dodob.setBounds(600,200,150,30);
        add(dodob);

        //address
        JLabel address = new JLabel("Address : ");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200,250,150,30);
        add(textAddress);

        //phone number
        JLabel phone = new JLabel("Phone : ");
        phone.setBounds(400,250,200,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(600,250,150,30);
        add(textPhone);

        //email

        JLabel email = new JLabel("Email : ");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        textemail = new JTextField();
        textemail.setBounds(200,300,150,30);
        add(textemail);

        //10th marks

        JLabel m10 = new JLabel("Class X (%) : ");
        m10.setBounds(400,300,200,30);
        m10.setFont(new Font("serif",Font.BOLD,20));
        add(m10);

        JLabel textm10 = new JLabel();
        textm10.setBounds(600,300,150,30);
        add(textm10);

        //12th marks
        JLabel m12 = new JLabel("Class XII (%) : ");
        m12.setBounds(50,350,200,30);
        m12.setFont(new Font("serif",Font.BOLD,20));
        add(m12);

        JLabel textm12 = new JLabel();
        textm12.setBounds(200,350,150,30);
        add(textm12);

        //Aadhaar
        JLabel AadhaarNo = new JLabel("Aadhaar No : ");
        AadhaarNo.setBounds(400,350,200,30);
        AadhaarNo.setFont(new Font("serif",Font.BOLD,20));
        add(AadhaarNo);

        textaadhaar = new JTextField();
        textaadhaar.setBounds(600,350,150,30);
        add(textaadhaar);

        //Qualification
        JLabel Qualification = new JLabel("Course : ");
        Qualification.setBounds(50,400,200,30);
        Qualification.setFont(new Font("serif",Font.BOLD,20));
        add(Qualification);

        textcourse = new JTextField();
        textcourse.setBounds(200,400,150,30);
        add(textcourse);

        //Department
        JLabel Department = new JLabel("Branch : ");
        Department.setBounds(400,400,200,30);
        Department.setFont(new Font("serif",Font.BOLD,20));
        add(Department);

        textbranch = new JTextField();
        textbranch.setBounds(600,400,150,30);
        add(textbranch);

        try{
            Conn c = new Conn();
            String q = "select * from student where rollno = '"+cEMPID.getSelectedItem()+"'";
            ResultSet resultSet = c.statement.executeQuery(q);
            while (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textfather.setText(resultSet.getString("fname"));
                dodob.setText(resultSet.getString("dob"));
                textAddress.setText(resultSet.getString("address"));
                textPhone.setText(resultSet.getString("phone"));
                textemail.setText(resultSet.getString("email"));
                textm10.setText(resultSet.getString("class_x"));
                textm12.setText(resultSet.getString("class_xii"));
                textaadhaar.setText(resultSet.getString("aadhaar"));
                empText.setText(resultSet.getString("rollno"));
                textcourse.setText(resultSet.getString("course"));
                textbranch.setText(resultSet.getString("branch"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c = new Conn();
                    String q = "select * from student where rollno = '"+cEMPID.getSelectedItem()+"'";
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textfather.setText(resultSet.getString("fname"));
                        dodob.setText(resultSet.getString("dob"));
                        textAddress.setText(resultSet.getString("address"));
                        textPhone.setText(resultSet.getString("phone"));
                        textemail.setText(resultSet.getString("email"));
                        textm10.setText(resultSet.getString("class_x"));
                        textm12.setText(resultSet.getString("class_xii"));
                        textaadhaar.setText(resultSet.getString("aadhaar"));
                        empText.setText(resultSet.getString("rollno"));
                        textcourse.setText(resultSet.getString("course"));
                        textbranch.setText(resultSet.getString("branch"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String empid = empText.getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textemail.getText();
            String course = textcourse.getText();
            String branch = textbranch.getText();
            try{
                String q = "update student set address = '"+address+"', phone = '"+phone+"', email = '"+email+"', course = '"+course+"', branch = '"+branch+"' where rollno = '"+empid+"'";
                Conn c = new Conn();
                c.statement.executeUpdate(q);

                JOptionPane.showMessageDialog(null,"Details Updated");
                setVisible(false);

            } catch (Exception E) {
                E.printStackTrace();
            }

        } else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateStudent();
    }
}
