/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fds;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public class Register extends JFrame {
   String uname;
    public Register()
    {
                JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame jf=new JFrame("Registration Page");
        jf.setBounds(12,25,1900,1000);
        jf.setExtendedState( jf.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);
    ImageIcon i = new ImageIcon(getClass().getResource("/images/bg2.jpg"));
        setIconImage(i.getImage());
        jf.setContentPane(new JLabel(new ImageIcon(i.getImage())));    
  //jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\shrey\\Downloads\\resources\\bg2.jpg")));
       
        
        JLabel jl=new JLabel("REGISTER NEW USER");
        jl.setFont(new Font("times new roman",Font.BOLD,45));
        jl.setBounds(700,100,500,50);
        jl.setForeground(new Color(0xed1c24));
        jf.add(jl);
        
        JLabel jl1=new JLabel("First Name:");
        jl1.setFont(new Font("times new roman",Font.BOLD,40));
        jl1.setBounds(270,250,300,50);
        jl1.setForeground(Color.BLACK);
        jf.add(jl1);
        
        JTextField jtf1= new JTextField();
        jtf1.setFont(new Font("times new roman",Font.PLAIN,40));
        jtf1.setBounds(500,250,400,50);
        jf.add(jtf1);
        
        JLabel jlln=new JLabel("Last Name:");
        jlln.setFont(new Font("times new roman",Font.BOLD,40));
        jlln.setBounds(950,250,300,50);
        jlln.setForeground(Color.BLACK);
        jf.add(jlln);
        
        JTextField jtf2= new JTextField();
        jtf2.setFont(new Font("times new roman",Font.PLAIN,40));
        jtf2.setBounds(1180,250,400,50);
        jf.add(jtf2);
        
        JLabel jl2=new JLabel("Phone No.:");
        jl2.setFont(new Font("times new roman",Font.BOLD,40));
        jl2.setBounds(270,350,300,50);
        jl2.setForeground(Color.BLACK);
        jf.add(jl2);
        
        JTextField jtf3= new JTextField();
        jtf3.setFont(new Font("times new roman",Font.PLAIN,40));
        jtf3.setBounds(500,350,400,50);
        jf.add(jtf3);
        
        JLabel jlem=new JLabel("E-Mail ID:");
        jlem.setFont(new Font("times new roman",Font.BOLD,40));
        jlem.setBounds(950,350,300,50);
        jlem.setForeground(Color.BLACK);
        jf.add(jlem);
        
        JTextField jtf4= new JTextField();
        jtf4.setFont(new Font("times new roman",Font.PLAIN,40));
        jtf4.setBounds(1180,350,400,50);
        jf.add(jtf4);
        
        /*JLabel jl3=new JLabel("Address:");
        jl3.setFont(new Font("times new roman",Font.BOLD,40));
        jl3.setBounds(270,350,300,50);
        jl3.setForeground(Color.BLACK);
        jf.add(jl3);
        */
        JLabel jl4=new JLabel("Door No.:");
        jl4.setFont(new Font("times new roman",Font.BOLD,40));
        jl4.setBounds(270,450,300,50);
        jl4.setForeground(Color.BLACK);
        jf.add(jl4);
        
        JTextField jtf5= new JTextField();
        jtf5.setFont(new Font("times new roman",Font.PLAIN,40));
        jtf5.setBounds(500,450,400,50);
        jf.add(jtf5);
        
        JLabel jl5=new JLabel("Lane:");
        jl5.setFont(new Font("times new roman",Font.BOLD,40));
        jl5.setBounds(950,450,300,50);
        jl5.setForeground(Color.BLACK);
        jf.add(jl5);
        
        JTextField jtf6= new JTextField();
        jtf6.setFont(new Font("times new roman",Font.PLAIN,40));
        jtf6.setBounds(1180,450,400,50);
        jf.add(jtf6);
        
        JLabel jl6=new JLabel("Area:");
        jl6.setFont(new Font("times new roman",Font.BOLD,40));
        jl6.setBounds(270,550,300,50);
        jl6.setForeground(Color.BLACK);
        jf.add(jl6);
        
        JTextField jtf7= new JTextField();
        jtf7.setFont(new Font("times new roman",Font.PLAIN,40));
        jtf7.setBounds(500,550,400,50);
        jf.add(jtf7);
        
        JLabel jl7=new JLabel("Pin Code:");
        jl7.setFont(new Font("times new roman",Font.BOLD,40));
        jl7.setBounds(950,550,300,50);
        jl7.setForeground(Color.BLACK);
        jf.add(jl7);
        
        JTextField jtf8= new JTextField();
        jtf8.setFont(new Font("times new roman",Font.PLAIN,40));
        jtf8.setBounds(1180,550,400,50);
        jf.add(jtf8);
        
        /*JLabel jllc=new JLabel("Login Credentials:");
        jllc.setFont(new Font("times new roman",Font.BOLD,40));
        jllc.setBounds(270,650,500,50);
        jllc.setForeground(Color.BLACK);
        jf.add(jllc);
        */
        JLabel jl8=new JLabel("UserName:");
        jl8.setFont(new Font("times new roman",Font.BOLD,40));
        jl8.setBounds(270,650,300,50);
        jl8.setForeground(Color.BLACK);
        jf.add(jl8);
        
        JTextField jtf9= new JTextField();
        jtf9.setFont(new Font("times new roman",Font.PLAIN,40));
        jtf9.setBounds(500,650,400,50);
        jf.add(jtf9); 
        
         JLabel jl9=new JLabel("Password:");
        jl9.setFont(new Font("times new roman",Font.BOLD,40));
        jl9.setBounds(950,650,300,50);
        jl9.setForeground(Color.BLACK);
        jf.add(jl9);
        
        JPasswordField jpf1=new JPasswordField();
        jpf1.setFont(new Font("times new roman",Font.PLAIN,40));
        jpf1.setBounds(1180,650,400,50);
        jf.add(jpf1);
        
        JLabel jl10=new JLabel("Confirm Password:");
        jl10.setFont(new Font("times new roman",Font.BOLD,40));
        jl10.setBounds(795,750,350,50);
        jl10.setForeground(Color.BLACK);
        jf.add(jl10);
        
        JPasswordField jpf2=new JPasswordField();
        jpf2.setFont(new Font("times new roman",Font.PLAIN,40));
        jpf2.setBounds(1180,750,400,50);
        jf.add(jpf2);

        
        JButton jb= new JButton("SUBMIT");
jb.setFont(new Font ("TIMES NEW ROMAN",Font.BOLD,40));
jb.addActionListener((ActionEvent e) -> {
    String fname=jtf1.getText();
    String lname=jtf2.getText();
    @SuppressWarnings("deprication")
            String cphno=jtf3.getText();
   // long pno=Long.ParseLong(cphno);
    String email=jtf4.getText();
    String door=jtf5.getText();
    String lane=jtf6.getText();
    String area=jtf7.getText();
    String pin=jtf8.getText();
    uname=jtf9.getText();
        
    
    if(fname.equals("")||lname.equals("")||email.equals("")||door.equals("")||lane.equals("")||area.equals(""))
    {
        JOptionPane.showMessageDialog(jf, "All The Fields Are Not Entered");
    }
            else if(cphno.length()!=10)
    {
                        JOptionPane.showMessageDialog(jf, "Invlid Phone Number ");
     //Register ob=new Register();
     //jf.setVisible(false);
     
    }
           else if(pin.length()!=6)
    {
                        JOptionPane.showMessageDialog(jf, "Invlid Pin Number ");
     //Register ob=new Register();
     //jf.setVisible(false);
     
    }
    
           else 
{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
        					
            Statement stmt =con.createStatement();
                String sql1="select uname from customers where uname='"+uname+"'";
                ResultSet n1=stmt.executeQuery(sql1);
                if(n1.next())
{
JOptionPane.showMessageDialog(jf, "Username not Available");
 }
               con.close();
            
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
        
    String pswd=jpf1.getText();
    String cpswd=jpf2.getText();
    
    int cid=1000;
    //String status="N";
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
        					
            Statement stmt =con.createStatement();
            if(pswd.equals(cpswd))
            {
                String sql="insert into customers values(null,"+Long.parseLong(cphno)+",'"+door+"','"+lane+"','"+area+"',"+Integer.parseInt(pin)+",'"+uname+"','"+pswd+"','"+fname+"','"+lname+"','"+email+"')";
                int n=stmt.executeUpdate(sql);
                
                
                loginpage ob=new loginpage();
                jf.setVisible(false);
            }
            else{
                                JOptionPane.showMessageDialog(jf, "Password Not Matching");
     
            }
            con.close();
            
        }catch (Exception ex)
        {
            System.out.println(ex);
                                            JOptionPane.showMessageDialog(this, ex);

        }
    }
}});

jb.setBounds(500,952,400,50);
jb.setBackground(new Color(0xed1c24));
jb.setForeground(Color.BLACK);
jb.setOpaque(true);
jf.add(jb);

JButton jb1= new JButton("GO BACK");
jb1.setFont(new Font ("TIMES NEW ROMAN",Font.BOLD,40));

jb1.addActionListener((ActionEvent e) -> {
    {
        try{
                
                loginpage ob=new loginpage();
                jf.setVisible(false);
            
        }catch (Exception ex)
        {
            System.out.println("error");
        }
    }
    });

jb1.setBounds(1050,952,400,50);
jb1.setBackground(Color.WHITE);
jb1.setOpaque(false);
jf.add(jb1);

        
        jf.setVisible(true);
}   
}