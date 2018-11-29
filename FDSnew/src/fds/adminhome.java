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

  

public class adminhome extends JFrame {
    boolean flag=false;
    public String a;
    public adminhome()
    {
                JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame jf=new JFrame("Admin Home Page");
        jf.setBounds(12,25,1900,1000);
        jf.setExtendedState( jf.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLayout(null);
        jf.getContentPane().setBackground(Color.WHITE);
        ImageIcon i = new ImageIcon(getClass().getResource("/images/bg_admin.jpg"));
        setIconImage(i.getImage());
        jf.setContentPane(new JLabel(new ImageIcon(i.getImage())));
        
        
        JLabel jl=new JLabel("Welcome Administrator");
        jl.setFont(new Font("times new roman",Font.BOLD,45));
        jl.setBounds(700,100,500,50);
        jl.setForeground(new Color(0xed1c24));
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jf.add(jl);


        //Restaurant Management Button
        JButton jb=new JButton();
        jb.setBounds(600, 450, 256,256);
        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/order-food.png"));
        setIconImage(i1.getImage());
        jb.setIcon(new javax.swing.ImageIcon(i1.getImage()));
        jb.setBackground(Color.WHITE);
        jb.setBorderPainted(false);
        jb.setOpaque(false);
        jb.addActionListener((ActionEvent e) -> {
        {
            new r_manager();
            jf.setVisible(false);
        }});

    
        jf.add(jb);
        //end of restaurant button
        JLabel jl1=new JLabel("Restaurants");
        jl1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,40));
        jl1.setBounds(600,730,250,40);
        jl1.setBackground(new Color(0xed1c24));
        jl1.setOpaque(false);
        jl1.setHorizontalAlignment(SwingConstants.CENTER);
        jl1.setForeground(Color.BLACK);
        jf.add(jl1);
        
        
        //Driver Management Button
        JButton jb1=new JButton();
        jb1.setBounds(1050, 450, 256,256);
        ImageIcon i2 = new ImageIcon(getClass().getResource("/images/moped.png"));
        setIconImage(i2.getImage());
        jb1.setIcon(new javax.swing.ImageIcon(i2.getImage()));
        jb1.setBackground(Color.WHITE);
        jb1.setBorderPainted(false);
        jb1.setOpaque(false);
        jb1.addActionListener((ActionEvent e) -> {
        {
            new d_manager();
            jf.setVisible(false);
        }});

        
        
        jf.add(jb1);
        //end of driver button
        JLabel jl2=new JLabel("Drivers");
        jl2.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,40));
        jl2.setBounds(1050,730,250,40);
        jl2.setBackground(new Color(0xed1c24));
        jl2.setOpaque(false);
        jl2.setHorizontalAlignment(SwingConstants.CENTER);
        jl2.setForeground(Color.BLACK);
        jf.add(jl2);


        
                //Logout button
        JButton jb3=new JButton();
        jb3.setBounds(1650,45,125,125);
        jb3.setBackground(new Color(0xed1c24));
        /*jb3.setForeground(Color.WHITE);
        jb3.setOpaque(true);
        jb3.setFont(new Font("times new roman",Font.BOLD,40));*/
        ImageIcon i3 = new ImageIcon(getClass().getResource("/images/exit.png"));
        setIconImage(i3.getImage());
        jb3.setIcon(new javax.swing.ImageIcon(i3.getImage()));
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
        
        
        jf.setVisible(true);
    }

}
