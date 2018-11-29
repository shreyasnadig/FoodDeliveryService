package fds;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Edit extends JFrame{
	Edit(String username)
	{
	JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame jf=new JFrame("Edit Credentials");
    jf.setBounds(12,25,1900,1000);    
    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    jf.setExtendedState( jf.getExtendedState()|JFrame.MAXIMIZED_BOTH );
    jf.setLayout(null);
    
    ImageIcon i = new ImageIcon(getClass().getResource("/images/bg2.jpg"));
        setIconImage(i.getImage());
        jf.setContentPane(new JLabel(new ImageIcon(i.getImage())));
    
    //jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\shrey\\Downloads\\resources\\bg2.jpg")));
  
    
    JLabel jl1=new JLabel("First Name:");
    jl1.setFont(new Font("times new roman",Font.BOLD,40));
    jl1.setBounds(270,250,300,50);
    jl1.setForeground(Color.BLACK);
    jf.add(jl1);
    
    JTextField jtf1= new JTextField();
    jtf1.setText(retText("fname",username));
    jtf1.setFont(new Font("times new roman",Font.PLAIN,40));
    jtf1.setBounds(500,250,400,50);
    jf.add(jtf1);
    
    JLabel jl2=new JLabel("Last Name:");
    jl2.setFont(new Font("times new roman",Font.BOLD,40));
    jl2.setBounds(950,250,300,50);
    jl2.setForeground(Color.BLACK);
    jf.add(jl2);
    
    JTextField jtf2= new JTextField();
    jtf2.setText(retText("lname",username));
    jtf2.setFont(new Font("times new roman",Font.PLAIN,40));
    jtf2.setBounds(1180,250,400,50);
    jf.add(jtf2);
    
    JLabel jl3=new JLabel("Phone No.:");
    jl3.setFont(new Font("times new roman",Font.BOLD,40));
        jl3.setBounds(270,350,300,50);
    jl3.setForeground(Color.BLACK);
    jf.add(jl3);
    
    JTextField jtf3= new JTextField();
    jtf3.setText(retText("cphno",username));
    jtf3.setFont(new Font("times new roman",Font.PLAIN,40));
    jtf3.setBounds(500,350,400,50);
    jf.add(jtf3);
    
    JLabel jl4=new JLabel("E-Mail ID:");
    jl4.setFont(new Font("times new roman",Font.BOLD,40));
        jl4.setBounds(950,350,300,50);
    jl4.setForeground(Color.BLACK);
    jf.add(jl4);
    
    JTextField jtf4= new JTextField();
    jtf4.setText(retText("email",username));
    jtf4.setFont(new Font("times new roman",Font.PLAIN,40));
        jtf4.setBounds(1180,350,400,50);
    jf.add(jtf4);
    
    JLabel jl5=new JLabel("Address:");
    jl5.setFont(new Font("times new roman",Font.BOLD,40));
        jl5.setBounds(270,450,300,50);
    jl5.setForeground(Color.BLACK);
    jf.add(jl5);
    
    JLabel jl6=new JLabel("Door No.:");
    jl6.setFont(new Font("times new roman",Font.BOLD,40));
    jl6.setBounds(270,550,300,50);
    jl6.setForeground(Color.BLACK);
    jf.add(jl6);
    
    JTextField jtf5= new JTextField();
    jtf5.setText(retText("door",username));
    jtf5.setFont(new Font("times new roman",Font.PLAIN,40));
    jtf5.setBounds(500,550,400,50);
    jf.add(jtf5);
    
    JLabel jl7=new JLabel("Lane:");
    jl7.setFont(new Font("times new roman",Font.BOLD,40));
    jl7.setBounds(950,550,300,50);
    jl7.setForeground(Color.BLACK);
    jf.add(jl7);
    
    JTextField jtf6= new JTextField();
    jtf6.setText(retText("lane",username));
    jtf6.setFont(new Font("times new roman",Font.PLAIN,40));
    jtf6.setBounds(1180,550,400,50);
    jf.add(jtf6);
    
    JLabel jl8=new JLabel("Area:");
    jl8.setFont(new Font("times new roman",Font.BOLD,40));
    jl8.setBounds(270,650,300,50);
    jl8.setForeground(Color.BLACK);
    jf.add(jl8);
    
    JTextField jtf7= new JTextField();
    jtf7.setText(retText("area",username));
    jtf7.setFont(new Font("times new roman",Font.PLAIN,40));
    jtf7.setBounds(500,650,400,50);
    jf.add(jtf7);
    
    JLabel jl9=new JLabel("Pin Code:");
    jl9.setFont(new Font("times new roman",Font.BOLD,40));
    jl9.setBounds(950,650,300,50);
    jl9.setForeground(Color.BLACK);
    jf.add(jl9);
    
    JTextField jtf8= new JTextField();
    jtf8.setText(retText("pin",username));
    jtf8.setFont(new Font("times new roman",Font.PLAIN,40));
    jtf8.setBounds(1180,650,400,50);
    jf.add(jtf8);
    
    JButton jb= new JButton("SUBMIT");
    jb.setFont(new Font ("TIMES NEW ROMAN",Font.BOLD,35));

    jb.addActionListener((ActionEvent e) -> {
        {
        	@SuppressWarnings("deprication")
            
        	String cfname=jtf1.getText();
            String clname=jtf2.getText();
            String cphno=jtf3.getText();
            
            String email=jtf4.getText();
            String door=jtf5.getText();
            String lane=jtf6.getText();
            String area=jtf7.getText();
            String pin=jtf8.getText();
            if(cfname.equals("")||clname.equals("")||cphno.equals("")||email.equals("")||door.equals("")||lane.equals("")||area.equals(""))
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
            else{
                try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
                    Statement stmt =con.createStatement();
                    //update query goes here
                        String sql1="update customers set fname='"+cfname+"',lname='"+clname+"',cphno='"+Long.parseLong(cphno)+"',email='"+email+"',door='"+door+"',lane='"+lane+"',area='"+area+"',pin='"+Integer.parseInt(pin)+"', uname='"+username+"' where uname='"+username+"'";
                        int n=stmt.executeUpdate(sql1);
                        Home ob=new Home(username);
                        jf.setVisible(false);
                    
                    con.close();
                }

        	
        	catch (Exception ex)
            {
                System.out.println(ex);
            }
            }
        }
        });

    jb.setBounds(1050,850,400,50);
    jb.setBackground(new Color(0xed1c24));
    jf.add(jb);
    
    
    
    JButton jb1= new JButton("GO BACK");
    jb1.setFont(new Font ("TIMES NEW ROMAN",Font.BOLD,35));

    jb1.addActionListener((ActionEvent e) -> {
        {
            try{
                    
                    Home ob=new Home(username);
                    jf.setVisible(false);
                
            }catch (Exception ex)
            {
                System.out.println("error");
            }
        }
        });

    jb1.setBounds(500,850,400,50);
jb1.setBackground(new Color(0xed1c24));
    jf.add(jb1);

    jf.setVisible(true);
}
	

public String retText(String attr,String username)
{
	String text=""; 
	try{
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
         Statement stmt =con.createStatement();
         String sql="select "+attr+" from customers where uname='"+username+"'";//+uid; //remove comment, add uid variable
         //PreparedStatement ps=con.prepareStatement(sql);
         ResultSet rs=stmt.executeQuery(sql);
         while(rs.next())
         {
         text=rs.getString(attr);
         
         }
         con.close();
         
     }

	
	catch (Exception ex)
 {
     System.out.println(ex);
 }
return text;
	
}
}
