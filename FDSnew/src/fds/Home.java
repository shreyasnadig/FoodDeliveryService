
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fds;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class Home extends JFrame
{
    long phno;
    String name,adr;
	Home(String username)
	{
                        
	JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame jf=new JFrame("Home");
        jf.setBounds(12,25,1900,1000);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setExtendedState( jf.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        //jf.setResizable(false);
        jf.setLayout(null);
        
        ImageIcon i = new ImageIcon(getClass().getResource("/images/bg2.jpg"));
        setIconImage(i.getImage());
        jf.setContentPane(new JLabel(new ImageIcon(i.getImage())));
        
        //jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\shrey\\Downloads\\resources\\bg2.jpg")));
  try{
             Class.forName("oracle.jdbc.driver.OracleDriver");
 Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
 Statement stmt =conn.createStatement();
 
 String sql="select * from customers where uname='"+username+"'";

 ResultSet rs=stmt.executeQuery(sql);
  while(rs.next())
          {
              phno=rs.getLong("cphno");
              name=rs.getString("fname")+" "+rs.getString("lname");              
              adr=rs.getString("Door")+" , "+rs.getString("Lane")+" , "+rs.getString("area")+" , "+rs.getLong("pin");
           
          }
  }
	  
  catch(Exception e)
  {
      System.out.println(e);
  }
        //Logout button
        JButton jb3=new JButton();
        jb3.setBounds(1650,45,125,125);
        jb3.setBackground(new Color(0xed1c24));
        /*jb3.setForeground(Color.WHITE);
        jb3.setOpaque(true);
        jb3.setFont(new Font("times new roman",Font.BOLD,40));*/
        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/exit.png"));
        setIconImage(i1.getImage());
        jb3.setIcon(new javax.swing.ImageIcon(i1.getImage()));
        jb3.setBackground(new Color(0xed1c24));
        jb3.setBorderPainted(false);
        jb3.setOpaque(true);
        

        jf.add(jb3);
        jb3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
      loginpage ob=new loginpage();
        jf.setVisible(false);
                }
        });
        //end of logout button
        
        JLabel jl1=new JLabel("Welcome,");
        jl1.setFont(new Font("times new roman",Font.BOLD,30));
        jl1.setBounds(100,250,200,35);
        
        jf.add(jl1);
        
       
        JLabel jl2=new JLabel(name.toUpperCase());
        
        jl2.setBounds(270,250,300,35);
        jl2.setFont(new Font("times new roman",Font.PLAIN,30));
        jf.add(jl2);
        
        JLabel jl3=new JLabel("Phone No.:");
        jl3.setBounds(1450,250,200,35);
        jl3.setFont(new Font("times new roman",Font.BOLD,30));
        jf.add(jl3);
        
        JLabel jl4=new JLabel(""+phno);
        jl4.setBounds(1650,250,200,35);
        jl4.setFont(new Font("times new roman",Font.PLAIN,30));
        jf.add(jl4);
        
       // JPanel jp2=new JPanel();
        JLabel jl5=new JLabel("<html>"+adr.toUpperCase()+"</html>");
        
        jl5.setBounds(100,250,1700,400);
        jl5.setFont(new Font("times new roman",Font.PLAIN,30));
        
        //jp2.add(jl5);
        //jp2.setOpaque(false);
        //jp2.setBackground(Color.yellow);//change parameters to (0,0,0,0) to make it transparent
        //jp2.setBounds(50, 200, 600, 150);
            
        jf.add(jl5);
        
        JButton jb2=new JButton("Update Info");
        jb2.setBounds(1600,500,200,50);
        jb2.setFont(new Font("times new roman",Font.BOLD,30));

        jb2.setBackground(Color.white);
        jb2.setOpaque(false);
        jf.add(jb2);
        jb2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
      Edit ob=new Edit(username);
      jf.setVisible(false);
                }});
                
        /*String zone[]= {"Select Zone Here"};
        JComboBox cb=new JComboBox(zone);
        cb.setBounds(100, 850, 450, 75);
        cb.addItem("North");
        cb.addItem("South");
        cb.addItem("East");
        cb.addItem("West");
        cb.setBackground(Color.white);
        cb.setFont(new Font("times new roman",Font.PLAIN,50));
        jf.add(cb);
        */
        String res[]= {"Select Restaurants Here"};
        JComboBox cb1=new JComboBox(res);
        cb1.setBounds(600, 850, 750, 65);
        cb1.setFont(new Font("times new roman",Font.PLAIN,50));
        
        try {
        		//step1 load the driver class
				Class.forName("oracle.jdbc.driver.OracleDriver");
					
				//step2 create connection object
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
 		
				//step3 create the statement object
				Statement stmt=con.createStatement();
				String sql="select r_name from restaurant";
                    PreparedStatement pst = con.prepareStatement(sql);
        				ResultSet rs=pst.executeQuery(sql);
                                
				while(rs.next())
				{
                                    
                     
                                    String name=rs.getString("r_name");
					cb1.addItem(name);
				}
	cb1.addItem("More coming soon");
        
                                //step5 close the connection object
				con.close();
           }
			catch(Exception ex) { System.out.println(ex); }
              
        cb1.setBackground(Color.white);
        
        jf.add(cb1);

        
               
        JButton jb1=new JButton("Submit");
        jb1.setBounds(1500, 850, 300, 65);
        jb1.setFont(new Font("times new roman",Font.BOLD,50));

        jb1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		try {
                            String selection=(String) cb1.getSelectedItem();
                            if(selection.equals("Select Restaurants Here")||selection.equals("More coming soon"))
                                {
                                    JOptionPane.showMessageDialog(jf, "Please Select A Valid Restaurant");
                                }
                            else{   
                                items ob=new items(username,selection);
                                jf.setVisible(false);
                                }
                            }
    			catch(Exception ex) { System.out.println(ex); }
       		
        	}
        });
        
        jb1.setBackground(new Color(0xed1c24));
        jb1.setForeground(Color.BLACK);
        jb1.setOpaque(true);
        jf.add(jb1);
        jf.setVisible(true);
	}
}

