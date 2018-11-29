/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fds;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author admin
 */

  

public class adminlogin extends JFrame {
    boolean flag=false;
    public String a;
    public adminlogin()
    {
                JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame jf=new JFrame("Admin Login Page");
        jf.setBounds(12,25,1900,1000);
        jf.setExtendedState( jf.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLayout(null);
        jf.getContentPane().setBackground(Color.DARK_GRAY);
        ImageIcon i = new ImageIcon(getClass().getResource("/images/bg_admin.jpg"));
        setIconImage(i.getImage());
        jf.setContentPane(new JLabel(new ImageIcon(i.getImage())));
        
        JPanel jpmain=new JPanel();
        
        
        JLabel jl=new JLabel("ADMIN LOGIN");
        jl.setFont(new Font("times new roman",Font.BOLD,70));
        jl.setBounds(750,75,500,75);
        jl.setForeground(new Color(0xed1c24));
        jf.add(jl);
        
        
       JLabel jl1=new JLabel("Admin ID: ");
        jl1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,40));
        jl1.setBounds(725,300,250,40);
        jl1.setBackground(new Color(0xed1c24));
        jl1.setOpaque(false);
        jl1.setHorizontalAlignment(SwingConstants.CENTER);
        jl1.setForeground(Color.BLACK);
        jf.add(jl1);
        
        JTextField jtf1= new JTextField();
        jtf1.setFont(new Font("times new roman",Font.PLAIN,35));
        jtf1.setBounds(1000,300,250,40);
        jf.add(jtf1);
                              
        JLabel jl2=new JLabel("Password: ");
        jl2.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,40));
        jl2.setBounds(725,400,250,40);
        jl2.setBackground(new Color(0xed1c24));
        jl2.setOpaque(false);
        jl2.setHorizontalAlignment(SwingConstants.CENTER);
        jl2.setForeground(Color.BLACK);
        jf.add(jl2);
        
        JPasswordField jpf2=new JPasswordField();
        jpf2.setFont(new Font("times new roman",Font.PLAIN,35));
        jpf2.setBounds(1000,400,250,40);
        jf.add(jpf2);
        
        JButton jb= new JButton("Login");
        jb.setOpaque(true);
        jb.setBackground(Color.BLACK);
        jb.setForeground(new Color(0xed1c24));
        jb.setFont(new Font ("TIMES NEW ROMAN",Font.BOLD,40));
        jf.getRootPane().setDefaultButton(jb);
        jb.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e)
        		{
                            
                            String username=jtf1.getText();
        			a=username;
        			@SuppressWarnings("deprication")
        			String password =jpf2.getText();
        			{
                                    try{
        					Class.forName("oracle.jdbc.driver.OracleDriver");
        					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
        					Statement stmt =con.createStatement();
 
        					String sql="select * from customers where (uname='"+username+"'and pswd='"+password+"')";
        					ResultSet rs=stmt.executeQuery(sql);
        					if(rs.next()&&username.contentEquals("admin")||username.contentEquals("shreyas")||username.contentEquals("richul"))
        					{
        						new adminhome();	
        						jf.setVisible(false);
        					}
        					else
        					{
        						JOptionPane.showMessageDialog(jf, "Incorrect Username/Password");
        					}
        					con.close();
 
        				}
        				catch (Exception ex)
        				{

        					System.out.println((ex));
        					JOptionPane.showMessageDialog(jf, "login Unsuccessfull");
                
        				}
        				
                                              
        			}
        		}
        });
        jb.setBounds(885,550,200,50);	
        jf.add(jb);
        
        
       /* JButton jb1= new JButton("Sign Up");
        jb1.setOpaque(true);
        jb1.setBackground(Color.BLACK);
        jb1.setForeground(new Color(0xed1c24));
        jb1.setFont(new Font ("TIMES NEW ROMAN",Font.BOLD,40));
        jb1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e)
        	{
        		Register ob=new Register();
        		jf.setVisible(false);
        	}
        });
        jb1.setBounds(1000,550,200,50);
        jf.add(jb1);
        */
        JButton jbadmin=new JButton();
        jbadmin.setBounds(1650,45,125,125);
        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/user.png"));
        setIconImage(i1.getImage());
        jbadmin.setIcon(new javax.swing.ImageIcon(i1.getImage()));
        jbadmin.setBackground(Color.BLACK);
        jbadmin.setBorderPainted(false);
        jbadmin.setOpaque(true);
        jf.add(jbadmin);
        jbadmin.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e)
        	{
                    jbadmin.setBackground(Color.WHITE);
                    new loginpage();
                    jf.setVisible(false);
        	}
        });
        
        /*JLabel logo=new JLabel();
        logo.setBounds(25,45,125,125);
        ImageIcon i3 = new ImageIcon(getClass().getResource("/images/logo.png"));
        setIconImage(i3.getImage());
        logo.setIcon(new javax.swing.ImageIcon(i1.getImage()));
        logo.setBackground(Color.BLACK);
        logo.setOpaque(true);
        jf.add(logo);*/
       
        
        
        

        jf.setVisible(true);
        //jf.setResizable(false);

    }
    
    
    
    }
  

