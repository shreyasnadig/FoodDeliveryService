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

  

public class thankyoupage extends JFrame {
    boolean flag=false;
    public String a;
    public thankyoupage(String dname,String username)
    {
                JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame jf=new JFrame("Thank You!");
        jf.setBounds(12,25,1900,1000);
        jf.setExtendedState( jf.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLayout(null);
        jf.getContentPane().setBackground(Color.DARK_GRAY);
     
        jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\shrey\\Downloads\\resources\\bg_ty.jpg")));
        
        JPanel jp=new JPanel();
        jp.setBounds(800, 400, 400, 300);
        JLabel jl=new JLabel();
        jl.setBounds(1400,700,400,300);
        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/tenor.gif"));
        setIconImage(i1.getImage());
        jl.setIcon(new javax.swing.ImageIcon(i1.getImage()));
        jf.add(jl);    
    
        JButton jb=new JButton();
        jb.setBounds(900, 450, 176,176);
        ImageIcon i2 = new ImageIcon(getClass().getResource("/images/icon_notifications.gif"));
        setIconImage(i2.getImage());
        jb.setIcon(new javax.swing.ImageIcon(i2.getImage()));
         jb.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e)
        		{
        			
        			
        				try{
        					Class.forName("oracle.jdbc.driver.OracleDriver");
        					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
        					//Statement stmt =con.createStatement();
 
//        					String sql="update drivers set d_status=0 where d_name='"+dname+"'";
//        					int rs=stmt.executeUpdate(sql);
                                                       CallableStatement stmt=(CallableStatement) con.prepareCall("{call freedriver('"+dname+"')}");
                                                       stmt.execute();
        						Home ob=new Home(username);	
        						jf.setVisible(false);
        					
        					
        					con.close();
 
        				}
        				catch (Exception ex)
        				{

        					System.out.println((ex));
        					
                
        				}
        			
        		}
        });

        jf.add(jb);
    
        jf.setVisible(true);
    }
}