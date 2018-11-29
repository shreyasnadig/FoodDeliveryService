
package fds;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class d_manager extends JFrame {
       boolean flag=false;
    public String a;
    public JFrame jf;
    public d_manager()
    {
                JFrame.setDefaultLookAndFeelDecorated(true);
        jf=new JFrame("Manage Drivers");
        jf.setBounds(12,25,1900,1000);
        jf.setExtendedState( jf.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLayout(null);
        jf.getContentPane().setBackground(Color.WHITE);
        ImageIcon i = new ImageIcon(getClass().getResource("/images/bg_admin.jpg"));
        setIconImage(i.getImage());
        jf.setContentPane(new JLabel(new ImageIcon(i.getImage())));
        
        JLabel jl=new JLabel("Manage Drivers");
        jl.setFont(new Font("times new roman",Font.BOLD,45));
        jl.setBounds(700,100,500,50);
        jl.setForeground(new Color(0xed1c24));
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jf.add(jl);

        //Combo Box starts
        String res[]= {"Choose a Driver"};
        JComboBox cb1=new JComboBox(res);
        cb1.setBounds(100, 250, 750, 50);
        cb1.setFont(new Font("times new roman",Font.PLAIN,50));
        
        try {
        		//step1 load the driver class
				Class.forName("oracle.jdbc.driver.OracleDriver");
					
				//step2 create connection object
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
 		
				//step3 create the statement object
				Statement stmt=con.createStatement();
				String sql="select d_name from drivers";
                    PreparedStatement pst = con.prepareStatement(sql);
        				ResultSet rs=pst.executeQuery(sql);
                                
				while(rs.next())
				{
                                    
                     
                                    String name=rs.getString("d_name");
					cb1.addItem(name);
				}
	
        
                                //step5 close the connection object
				con.close();
           }
			catch(Exception ex) { System.out.println(ex); }
              
        cb1.setBackground(Color.white);
        
        jf.add(cb1);
        //combo box ends
        
        //Add driver panel
        JPanel jp1=new JPanel();
        jp1.setBounds(100,350,1700,550);
        //jp1.setOpaque(false);
        jp1.setVisible(false);
        jp1.setLayout(null);
        
        JLabel jl3=new JLabel("Driver Name");
        jl3.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,30));
        jl3.setBounds(150,50,250,35);
        jl3.setBackground(new Color(0xed1c24));
        jl3.setOpaque(false);
        jl3.setHorizontalAlignment(SwingConstants.CENTER);
        jl3.setVerticalAlignment(SwingConstants.CENTER);
        jl3.setForeground(Color.BLACK);
        jp1.add(jl3);
        
        JTextField jtf3= new JTextField();
        jtf3.setFont(new Font("times new roman",Font.PLAIN,30));
        jtf3.setBounds(400,50,250,35);
        jp1.add(jtf3);
                              
        JLabel jl4=new JLabel("Phone Number:");
        jl4.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,30));
        jl4.setBounds(150,100,250,35);
        jl4.setBackground(new Color(0xed1c24));
        jl4.setOpaque(false);
        jl4.setHorizontalAlignment(SwingConstants.CENTER);
        jl4.setVerticalAlignment(SwingConstants.CENTER);
        jl4.setForeground(Color.BLACK);
        jp1.add(jl4);
        
        JTextField jtf4= new JTextField();
        jtf4.setFont(new Font("times new roman",Font.PLAIN,30));
        jtf4.setBounds(400,100,250,35);
        jp1.add(jtf4);
        
        JLabel jl5=new JLabel("Driver Zone:");
        jl5.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,30));
        jl5.setBounds(150,150,250,35);
        jl5.setBackground(new Color(0xed1c24));
        jl5.setOpaque(false);
        jl5.setHorizontalAlignment(SwingConstants.CENTER);
        jl5.setForeground(Color.BLACK);
        jp1.add(jl5);
        
        JTextField jtf5= new JTextField();
        jtf5.setFont(new Font("times new roman",Font.PLAIN,30));
        jtf5.setBounds(400,150,250,35);
        jp1.add(jtf5);
        
        
        JButton r_add1=new JButton("Save Changes");
        r_add1.setBounds(800,100, 250,35);
        r_add1.setFont(new Font("times new roman",Font.BOLD,30));
        r_add1.setBackground(Color.white);
        jp1.add(r_add1);
        r_add1.addActionListener((ActionEvent e) -> {
        {
            try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
        					Statement stmt =con.createStatement();
                                                String dname=jtf3.getText();
                                                long dphno=Long.parseLong(jtf4.getText());
                                                String dzone=jtf5.getText();
                                                if(dname.equals("")||Long.toString(dphno).length()!=10||dzone.equals(""))
                                                {
                                                    JOptionPane.showMessageDialog(jf,"Invalid Data Entered");
                                                }
                                                else{
        					String sql1="insert into drivers values(0,'"+dname+"',"+dphno+",0,'"+dzone+"')";
                                                int rs=stmt.executeUpdate(sql1); 
                                                JOptionPane.showMessageDialog(jf, "Driver: "+dname+" has been Added");
                                                }
                                                
                                                con.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            JOptionPane.showMessageDialog(jf, "An Error Has Occurred");
        }
            
           d_manager ob=new d_manager();
            jp1.setVisible(false);
            jf.setVisible(false);
            
        }});
//        JButton submit1=new JButton("Save Changes");
//        submit1.setBounds(1100,100, 250,35);
//        submit1.setFont(new Font("times new roman",Font.BOLD,30));
//        submit1.setBackground(Color.white);
//        jp1.add(submit1);
        
        
         jf.add(jp1);
        //end of restaurant panel
        
        
        //view driver panel
        JPanel jp2=new JPanel();
        jp2.setBounds(100,350,1700,550);
        //jp2.setOpaque(false);
        jp2.setVisible(false);
        jp2.setLayout(null);
        
        JLabel jl6=new JLabel("Driver Name");
        jl6.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,30));
        jl6.setBounds(150,50,250,35);
        jl6.setBackground(new Color(0xed1c24));
        jl6.setOpaque(false);
        jl6.setHorizontalAlignment(SwingConstants.CENTER);
        jl6.setVerticalAlignment(SwingConstants.CENTER);
        jl6.setForeground(Color.BLACK);
        jp2.add(jl6);
        
        JTextField jtf6= new JTextField();
        jtf6.setFont(new Font("times new roman",Font.PLAIN,30));
        jtf6.setBounds(400,50,250,35);
        jp2.add(jtf6);
                              
        JLabel jl7=new JLabel("Phone Number:");
        jl7.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,30));
        jl7.setBounds(150,100,250,35);
        jl7.setBackground(new Color(0xed1c24));
        jl7.setOpaque(false);
        jl7.setHorizontalAlignment(SwingConstants.CENTER);
        jl7.setVerticalAlignment(SwingConstants.CENTER);
        jl7.setForeground(Color.BLACK);
        jp2.add(jl7);
        
        JTextField jtf7= new JTextField();
        jtf7.setFont(new Font("times new roman",Font.PLAIN,30));
        jtf7.setBounds(400,100,250,35);
        jp2.add(jtf7);
        
        JLabel jl8=new JLabel("Driver Zone:");
        jl8.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,30));
        jl8.setBounds(150,150,250,35);
        jl8.setBackground(new Color(0xed1c24));
        jl8.setOpaque(false);
        jl8.setHorizontalAlignment(SwingConstants.CENTER);
        jl8.setForeground(Color.BLACK);
        jp2.add(jl8);
        
        JTextField jtf8= new JTextField();
        jtf8.setFont(new Font("times new roman",Font.PLAIN,30));
        jtf8.setBounds(400,150,250,35);
        jp2.add(jtf8);
        
        JButton update=new JButton("Update Details");
        update.setBounds(850,100,250,35);
        update.setFont(new Font("times new roman",Font.BOLD,30));
        update.setBackground(Color.white);
        update.addActionListener((ActionEvent e) -> {
        {
            String dnam=cb1.getSelectedItem().toString();
            try{
                                                Class.forName("oracle.jdbc.driver.OracleDriver");
        					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
        					Statement stmt =con.createStatement();
                                                String dname=jtf6.getText();
                                                long dphno=Long.parseLong(jtf7.getText());
                                                String dzone=jtf8.getText();
                                                long dphno1=dphno;
                                                if(dname.equals("")||Long.toString(dphno1).length()!=10||dzone.equals(""))
                                                {
                                                    JOptionPane.showMessageDialog(jf,"Invalid Data Entered");
                                                }
                                                else{
        					String sql1="update drivers set d_name='"+dname+"',d_phno="+dphno+",d_zone='"+dzone+"' where d_name='"+dnam+"'";
                                                int rs=stmt.executeUpdate(sql1); 
                                                JOptionPane.showMessageDialog(jf, "Driver: "+dnam+" details has been Updated");
                                                }
                                                
                                                con.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            JOptionPane.showMessageDialog(jf, "An Error Has Occurred");
        }
            
           d_manager ob=new d_manager();
            jp2.setVisible(false);
            jf.setVisible(false);
            
        }});
        jp2.add(update);
        
        JButton delete=new JButton("Delete Driver");
        delete.setBounds(1150,100,350,35);
        delete.setFont(new Font("times new roman",Font.BOLD,30));
        delete.setBackground(Color.white);
        jp2.add(delete);
        delete.addActionListener((ActionEvent e) -> {
        {String dname=cb1.getSelectedItem().toString();
             try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
        					Statement stmt =con.createStatement();
                                                 
        					String sql1="delete from drivers where d_name='"+dname+"'";
                                                int rs=stmt.executeUpdate(sql1); 
                                               
                                                
                                                con.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
            JOptionPane.showMessageDialog(jf, "Driver: "+dname+" has been deleted");
            d_manager ob=new d_manager();
            jp2.setVisible(false);
            jf.setVisible(false);
            
        }});
        
        
         jf.add(jp2);
        //end of view panel
        
        
         
        //add driver button
         JButton r_add=new JButton("Add Driver");
        r_add.setBounds(450, 950, 400, 75);
        r_add.setFont(new Font("times new roman",Font.BOLD,50));
        r_add.setBackground(Color.white);
        jf.add(r_add);
        r_add.addActionListener((ActionEvent e) -> {
        {
           
            jp1.setVisible(true);
        }});
        
                 
       //View driver Button
        JButton jb1=new JButton("View/Edit Details Details");
        jb1.setBounds(1100, 250, 600, 50);
        jb1.setFont(new Font("times new roman",Font.BOLD,40));
        jb1.setBackground(Color.white);
        jf.add(jb1);
        jb1.addActionListener((ActionEvent e) -> {
        {
            String dname=cb1.getSelectedItem().toString();
                                if(dname.equals("Choose a Driver"))
                                {JOptionPane.showMessageDialog(jf, "No Driver Selected");}
                                else{
                                    try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
        					Statement stmt =con.createStatement();
 
        					String sql1="select * from drivers where d_name='"+dname+"'";
                                                ResultSet rs=stmt.executeQuery(sql1); 
                                                rs.next();
                                                String rname1=rs.getString("d_name");
                                                long rphno=rs.getLong("d_phno");
                                                String rzone=rs.getString("d_zone");
                                                jtf6.setText(rname1);
                                                jtf7.setText(Long.toString(rphno));
                                                jtf8.setText(rzone);
                                                
                                                con.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
                                    
            jp2.setVisible(true);}
        }});
        
        JButton jb2=new JButton("Go Back");
        jb2.setBounds(1050, 950, 400, 75);
        jb2.setFont(new Font("times new roman",Font.BOLD,50));
        jb2.setBackground(Color.white);
        jf.add(jb2);
        jb2.addActionListener((ActionEvent e) -> {
        {
            new adminhome();
            jf.setVisible(false);
        }}); 
        
        
        jf.setVisible(true);
    }
    
    
    
}

