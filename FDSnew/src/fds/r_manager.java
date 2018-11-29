
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


public class r_manager extends JFrame {
       boolean flag=false;
    public String a;
    public JFrame jf;
    public r_manager()
    {
                JFrame.setDefaultLookAndFeelDecorated(true);
        jf=new JFrame("Manage Restaurants");
        jf.setBounds(12,25,1900,1000);
        jf.setExtendedState( jf.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLayout(null);
        jf.getContentPane().setBackground(Color.WHITE);
        ImageIcon i = new ImageIcon(getClass().getResource("/images/bg_admin.jpg"));
        setIconImage(i.getImage());
        jf.setContentPane(new JLabel(new ImageIcon(i.getImage())));
        
        
        JLabel jl=new JLabel("Manage Restaurants");
        jl.setFont(new Font("times new roman",Font.BOLD,45));
        jl.setBounds(700,100,500,50);
        jl.setForeground(new Color(0xed1c24));
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jf.add(jl);

        //combo box start
        String res[]= {"Choose the Restaurant"};
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
				String sql="select r_name from restaurant";
                    PreparedStatement pst = con.prepareStatement(sql);
        				ResultSet rs=pst.executeQuery(sql);
                                
				while(rs.next())
				{
                                    
                     
                                    String name=rs.getString("r_name");
					cb1.addItem(name);
				}
	
        
                                //step5 close the connection object
				con.close();
           }
			catch(Exception ex) { System.out.println(ex); }
              
        cb1.setBackground(Color.white);
        
        jf.add(cb1);
        //combo box end
      

        //Add item Panel
        JPanel jp=new JPanel();
        jp.setBounds(100,350,1700,550);
        //jp.setOpaque(false);
        jp.setVisible(false);
        jp.setLayout(null);
        
        
        JLabel jl1=new JLabel("Item Name:");
        jl1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,30));
        jl1.setBounds(150,50,250,35);
        jl1.setBackground(new Color(0xed1c24));
        jl1.setOpaque(false);
        jl1.setHorizontalAlignment(SwingConstants.CENTER);
        jl1.setVerticalAlignment(SwingConstants.CENTER);
        jl1.setForeground(Color.BLACK);
        jp.add(jl1);
        
        JTextField jtf1= new JTextField();
        jtf1.setFont(new Font("times new roman",Font.PLAIN,30));
        jtf1.setBounds(400,50,250,35);
        jp.add(jtf1);
                              
        JLabel jl2=new JLabel("Item Price:");
        jl2.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,30));
        jl2.setBounds(150,100,250,35);
        jl2.setBackground(new Color(0xed1c24));
        jl2.setOpaque(false);
        jl2.setHorizontalAlignment(SwingConstants.CENTER);
        jl2.setVerticalAlignment(SwingConstants.CENTER);
        jl2.setForeground(Color.BLACK);
        jp.add(jl2);
        
        JTextField jtf2= new JTextField();
        jtf2.setFont(new Font("times new roman",Font.PLAIN,30));
        jtf2.setBounds(400,100,250,35);
        jp.add(jtf2);
        
//        JButton jb_add=new JButton("Add");
//        jb_add.setBounds(1100,50, 250,35);
//        jb_add.setFont(new Font("times new roman",Font.BOLD,30));
//        jb_add.setBackground(Color.white);
//        jp.add(jb_add);

        JButton submit=new JButton("Add Item");
        submit.setBounds(800,100, 250,35);
        submit.setFont(new Font("times new roman",Font.BOLD,30));
        submit.setBackground(Color.white);
        jp.add(submit);
         submit.addActionListener((ActionEvent e) -> {
        {
            jp.setVisible(false);
            
            String iname=jtf1.getText();
        			
        			@SuppressWarnings("deprication")
        			int iprice =Integer.parseInt(jtf2.getText());
                                String rname=cb1.getSelectedItem().toString();
                                
        			{
        				try{
        					Class.forName("oracle.jdbc.driver.OracleDriver");
        					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
        					Statement stmt =con.createStatement();
 
        					String sql="select r_id from restaurant where r_name='"+rname+"'";
                                                ResultSet rs=stmt.executeQuery(sql); 
                                                rs.next();
                                                long rid=rs.getLong("r_id");       					
                                                
                                               
                                                
                                                String sql1="insert into items values(0,'"+iname+"')";
                                                int rs1=stmt.executeUpdate(sql1);

                                                String sql2="select i_id from items where i_name='"+iname+"'";
                                                ResultSet rs2=stmt.executeQuery(sql2); 
                                                rs2.next();
                                                long iid=rs2.getLong("i_id");  

                                                String sql3="insert into rest_has_items values("+rid+","+iid+","+iprice+")";
                                                int rs3=stmt.executeUpdate(sql3);
        			
                                                
        					con.close();
                                                JOptionPane.showMessageDialog(jf, "Item Added Successfully!");
                                                       
        				}
        				catch (Exception ex)
        				{

        					System.out.println((ex));
        					JOptionPane.showMessageDialog(jf, "An Error Has Occurred");
                
        				}
        			}
            
            
        }});
        jp.setOpaque(true);
        jf.add(jp);
        //end of items panel
        

        //Add restaurant panel
        JPanel jp1=new JPanel();
        jp1.setBounds(100,350,1700,550);
        jp1.setOpaque(true);
        jp1.setVisible(false);
        jp1.setLayout(null);
        
        JLabel jl3=new JLabel("Restaurant Name");
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
        
        JLabel jl5=new JLabel("Restaurant Zone:");
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
                                                String rname=jtf3.getText();
                                                long rphno=Long.parseLong(jtf4.getText());
                                                String rzone=jtf5.getText();
                                                if(rname.equals("")||Long.toString(rphno).length()!=10||rzone.equals(""))
                                                {
                                                    JOptionPane.showMessageDialog(jf,"Invalid Data Entered");
                                                }
                                                else{
        					String sql1="insert into restaurant values(0,'"+rname+"','"+rphno+"','"+rzone+"')";
                                                int rs=stmt.executeUpdate(sql1); 
                                                }
                                                
                                                con.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
            
           r_manager ob=new r_manager();
            jp1.setVisible(false);
            jf.setVisible(false);
            
        }});
//        JButton submit1=new JButton("Save Changes");
//        submit1.setBounds(1100,100, 250,35);
//        submit1.setFont(new Font("times new roman",Font.BOLD,30));
//        submit1.setBackground(Color.white);
//        jp1.add(submit1);
        
        jp1.setOpaque(true);
         jf.add(jp1);
        //end of restaurant panel
        
        
        //view restairant panel
        JPanel jp2=new JPanel();
        jp2.setBounds(100,350,1700,550);
        jp2.setOpaque(true);
        jp2.setVisible(false);
        jp2.setLayout(null);
        
        JLabel jl6=new JLabel("Restaurant Name");
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
        
        JLabel jl8=new JLabel("Restaurant Zone:");
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
        
        JButton delete=new JButton("Delete Restaurant");
        delete.setBounds(850,100,350,35);
        delete.setFont(new Font("times new roman",Font.BOLD,30));
        delete.setBackground(Color.white);
        jp2.add(delete);
        delete.addActionListener((ActionEvent e) -> {
        {String rname=cb1.getSelectedItem().toString();
             try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
        					Statement stmt =con.createStatement();
                                                 String sql0="delete from rest_has_items where r_id in (select r_id from restaurant where r_name='"+rname+"')";
                                                 int rs0=stmt.executeUpdate(sql0); 
        					String sql1="delete from restaurant where r_name='"+rname+"'";
                                                int rs=stmt.executeUpdate(sql1); 
                                               
                                                
                                                con.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
            JOptionPane.showMessageDialog(jf, "Restaurant: "+rname+" has been deleted");
            r_manager ob=new r_manager();
            jp2.setVisible(false);
            jf.setVisible(false);
            
        }});
        
         jf.add(jp2);
        //end of view panel
        
        
         //Add items Button
        JButton jb=new JButton("Add Items");
        jb.setBounds(950, 250, 300, 50);
        jb.setFont(new Font("times new roman",Font.BOLD,45));
        jb.setBackground(Color.white);
        jf.add(jb);
       
        			
         jb.addActionListener((ActionEvent e) -> {
        {                       
             if(jp1.isVisible()||jp2.isVisible())
            {
                jp1.setVisible(false);
                jp2.setVisible(false);
            }
            String rname=cb1.getSelectedItem().toString();
                                if(rname.equals("Choose the Restaurant"))
                                {JOptionPane.showMessageDialog(jf, "No Restaurant Selected");}
                                else{
            jp.setVisible(true);}
            
        }});
         
        //View Details Button 
        JButton jb1=new JButton("View Details");
        jb1.setBounds(1350, 250, 400, 50);
        jb1.setFont(new Font("times new roman",Font.BOLD,45));
        jb1.setBackground(Color.white);
        jf.add(jb1);
        jb1.addActionListener((ActionEvent e) -> {
        {
             if(jp.isVisible()||jp1.isVisible())
            {
                jp.setVisible(false);
                jp1.setVisible(false);
            }
            
            String rname=cb1.getSelectedItem().toString();
                                if(rname.equals("Choose the Restaurant"))
                                {JOptionPane.showMessageDialog(jf, "No Restaurant Selected");}
                                else{
                                    try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
        					Statement stmt =con.createStatement();
 
        					String sql1="select * from restaurant where r_name='"+rname+"'";
                                                ResultSet rs=stmt.executeQuery(sql1); 
                                                rs.next();
                                                String rname1=rs.getString("r_name");
                                                long rphno=rs.getLong("r_phno");
                                                String rzone=rs.getString("r_zone");
                                                jtf6.setText(rname1);
                                                jtf7.setText(Long.toString(rphno));
                                                jtf8.setText(rzone);
                                                
                                                con.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
                                   
            jp2.setVisible(true);
                                }
        }});
         
        //add restaurant button
         JButton r_add=new JButton("Add Restaurant");
        r_add.setBounds(450, 950, 400, 75);
        r_add.setFont(new Font("times new roman",Font.BOLD,50));
        r_add.setBackground(Color.white);
        jf.add(r_add);
        r_add.addActionListener((ActionEvent e) -> {
        {
            
            if(jp.isVisible()||jp2.isVisible())
            {
                jp.setVisible(false);
                jp2.setVisible(false);
            }
            jp1.setVisible(true);
            
        }});
        
                 
       //View Restaurant Button
        
        
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

