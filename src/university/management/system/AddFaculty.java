package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddFaculty extends JFrame implements ActionListener {

    JTextField textName,textfather,textAddress,textPhone,textemail,textm10,textm12,textaadhaar;

    JLabel empText;

    JDateChooser cdob;

    JComboBox courseBox,departmentBox;

    JButton submit, cancel;

    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong()%9000L)+1000L);

    AddFaculty(){

        getContentPane().setBackground(new Color(166,164,252));

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        //name

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        textName = new JTextField();
        textName.setBounds(200,150,150,30);
        add(textName);

        //father name

        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        textfather = new JTextField();
        textfather.setBounds(600,150,150,30);
        add(textfather);

        //empId

        JLabel empId = new JLabel("Employee ID : ");
        empId.setBounds(50,200,200,30);
        empId.setFont(new Font("serif",Font.BOLD,20));
        add(empId);

        empText = new JLabel(""+f4);
        empText.setBounds(200,200,150,30);
        empText.setFont(new Font("serif",Font.BOLD,20));
        add(empText);

        //dob

        JLabel dob = new JLabel("Date of Birth : ");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(600,200,150,30);
        add(cdob);

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

        textm10 = new JTextField();
        textm10.setBounds(600,300,150,30);
        add(textm10);

        //12th marks
        JLabel m12 = new JLabel("Class XII (%) : ");
        m12.setBounds(50,350,200,30);
        m12.setFont(new Font("serif",Font.BOLD,20));
        add(m12);

        textm12 = new JTextField();
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
        JLabel Qualification = new JLabel("Qualification : ");
        Qualification.setBounds(50,400,200,30);
        Qualification.setFont(new Font("serif",Font.BOLD,20));
        add(Qualification);

        String course[] = {"B.Tech","BBA","BCA","BSC","MSC","MBA","MCA","MCom","MA","BA"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(200,400,150,30);
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        //Department
        JLabel Department = new JLabel("Department : ");
        Department.setBounds(400,400,200,30);
        Department.setFont(new Font("serif",Font.BOLD,20));
        add(Department);

        String department[] = {"Computer Science","Electronics","Mechanical","Civil","IT"};
        departmentBox = new JComboBox(department);
        departmentBox.setBounds(600,400,150,30);
        departmentBox.setBackground(Color.WHITE);
        add(departmentBox);

        submit = new JButton("Submit");
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

        if(e.getSource() == submit) {
            String name = textName.getText();
            String fname = textfather.getText();
            String empid = empText.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textemail.getText();
            String x = textm10.getText();
            String xii = textm12.getText();
            String aadhaar = textaadhaar.getText();
            String course = (String) courseBox.getSelectedItem();
            String department = (String) departmentBox.getSelectedItem();

            try{
                String q = "insert into teacher values('"+name+"','"+fname+"','"+empid+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhaar+"','"+course+"','"+department+"')";
                Conn c = new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Inserted");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddFaculty();
    }
}
