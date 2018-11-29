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

  

public class loginpage extends JFrame {
    boolean flag=false;
    public String a;
    public loginpage()
    {
                JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame jf=new JFrame("Login Page");
        jf.setBounds(12,25,1900,1000);
        jf.setExtendedState( jf.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLayout(null);
        jf.getContentPane().setBackground(Color.DARK_GRAY);
        ImageIcon i = new ImageIcon(getClass().getResource("/images/bg2.jpg"));
        setIconImage(i.getImage());
        jf.setContentPane(new JLabel(new ImageIcon(i.getImage())));
        //jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\shrey\\Downloads\\resources\\bg2.jpg")));
        
        JPanel jpmain=new JPanel();
        
        
        JLabel jl=new JLabel("LOGIN");
        jl.setFont(new Font("times new roman",Font.BOLD,70));
        jl.setBounds(875,75,300,75);
        jl.setForeground(new Color(0xed1c24));
        jf.add(jl);
        
        
       JLabel jl1=new JLabel("Username: ");
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
        
        JButton jb= new JButton("Sign In");
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
        					if(rs.next())
        					{
        						Home ob=new Home(username);	
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
        jb.setBounds(775,550,200,50);	
        jf.add(jb);
        
        
        JButton jb1= new JButton("Sign Up");
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
        
        JButton jbadmin=new JButton();
        jbadmin.setBounds(1650,45,125,125);
        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/admin.png"));
        setIconImage(i1.getImage());
        jbadmin.setIcon(new javax.swing.ImageIcon(i1.getImage()));
        jbadmin.setBackground(Color.BLACK);
        jbadmin.setBorderPainted(false);
        jbadmin.setOpaque(true);
       // jbadmin.setPressedIcon(new ImageIcon(getClass().getResource("/images/icon_notifications.gif")));
        
        jf.add(jbadmin);
        
        /*jbadmin.addMouseListener(new MouseAdapter (){
            public void mousePressed(MouseEvent e)
            {
                jbadmin.setBackground(Color.WHITE);
                jbadmin.setForeground(Color.WHITE);
                jbadmin.setOpaque(true);
            }
        });*/
        
        
        jbadmin.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e)
        	{
                    new adminlogin();
                    jf.setVisible(false);
        	}
        });
        
        
       
        
        
        

        jf.setVisible(true);
        //jf.setResizable(false);

    }
    
    
    
    }
  

