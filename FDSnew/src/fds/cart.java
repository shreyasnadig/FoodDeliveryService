/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fds;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author admin
 */
public class cart extends JFrame{
    
    cart(String username,String name[],int price[],int quan[],int size,String selection)
    {
            long rid,cid;
            String dname="";
	JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame jf=new JFrame("Checkout");
    jf.setBounds(12,25,1900,1000);
    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    jf.setLayout(null);
    jf.setExtendedState( jf.getExtendedState()|JFrame.MAXIMIZED_BOTH );
    jf.getContentPane().setBackground(Color.LIGHT_GRAY);
    
    ImageIcon im = new ImageIcon(getClass().getResource("/images/bg2.jpg"));
        setIconImage(im.getImage());
        jf.setContentPane(new JLabel(new ImageIcon(im.getImage())));
    //jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\shrey\\Downloads\\resources\\bg2.jpg")));
  	
    JPanel jp1=new JPanel();
    jp1.setBounds(500, 810, 1100, 200);
    jp1.setOpaque(false);
    jp1.setBackground(new Color(0,0,0,0)); //un-comment this statement to make this transparent 
    /*JLabel jl1=new JLabel("Driver Name:");
    jl1.setFont(new Font("times new roman",Font.BOLD,35));
    jl1.setBounds(100,750,300,50);
    
    jp1.add(jl1);*/
    
    try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
                    Statement stmt =con.createStatement();
                    //update query goes here
                        String sql="select * from drivers d, restaurant r where d.d_zone=r.r_zone and r.r_name='"+selection+"' and d_status=0";
                        ResultSet rs1=stmt.executeQuery(sql);
                        rs1.next();
                       dname=rs1.getString("d_name");
                        Long dphno=rs1.getLong("d_phno");
                        
                        String sql1="update drivers set d_status=1 where d_name='"+dname+"'";
                        ResultSet rs2=stmt.executeQuery(sql1);
                        //rs2.next();
                             
                        jf.setVisible(false);
                    
                    con.close();
                
    String d= "Hold tight!! "+dname+" will be delivering your order ASAP!";
    String d1="Contact him at "+dphno.toString();
    JLabel jl2=new JLabel(d);
    jl2.setBounds(550,810,1000,35);
    jl2.setFont(new Font("times new roman",Font.BOLD,30));
    jp1.add(jl2);
    
    /*JLabel jl3=new JLabel("Driver Phone:");
    jl3.setBounds(800,850,300,50);
    jl3.setFont(new Font("times new roman",Font.BOLD,35));
    jp1.add(jl3);*/
    
    JLabel jl4=new JLabel(d1);
    jl4.setBounds(700,850,700,35);
    jl4.setFont(new Font("times new roman",Font.BOLD,30));
    jp1.add(jl4);
	
   jf.add(jp1);
    }

        	
        	catch (Exception ex)
            {
                System.out.println(ex);
            }
   JPanel jp2=new JPanel();
   jp2.setBounds(100, 200, 1700, 600);
   jp2.setBackground(new Color(0,0,0,0)); //un-comment this statement to make this transparent 
   
   JTable table=new JTable();
   JScrollPane js=new JScrollPane(table);
   table.setFont(new Font("times new roman", Font.PLAIN, 35));
   table.setOpaque(false);
   table.setShowGrid(false);
((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
js.setOpaque(false);
DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment( JLabel.CENTER );
table.setDefaultRenderer(String.class, centerRenderer);
    
js.getViewport().setOpaque(false);
   js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
   js.setBounds(100, 200, 1700, 600);
   js.setBackground(new Color(0,0,0,0));
   jf.getContentPane().add(js);
   DefaultTableModel model=new DefaultTableModel()
    {
      @Override
      public Class<?> getColumnClass(int column)
      {
        switch(column)
        {
        case 0:
          return String.class;
        case 1:
          return int.class;
        case 2:
          return int.class;
     
//        case 4:
//          return String.class;

          default:
            return String.class;
        }
      }
    };

    //ASSIGN THE MODEL TO TABLE
    table.setModel(model);

   
    model.addColumn("Name");
    model.addColumn("Quantity");
    model.addColumn("Price");
    JTableHeader header = table.getTableHeader();

  header.setFont(new Font("Bebas Neue", Font.PLAIN, 35));
  header.setBackground(new Color(0xed1c24));
    int j=0,totalPrice=0;
    
   for(int i=0;i<size;i++)
    {
        if(name[i]!=null)
        {
      model.addRow(new Object[0]);
      table.setRowHeight(50);

                
      model.setValueAt(name[i],j,0);
      model.setValueAt(quan[i], j, 1);
      model.setValueAt(price[i]*quan[i], j, 2);
      j++;
      totalPrice=totalPrice+(price[i]*quan[i]);
//      model.setValueAt("Our Column 3", i, 3);
//      model.setValueAt("Our Column 4", i, 4);
    }}
   model.addRow(new Object[0]);
    model.setValueAt(null,j,0);
      model.setValueAt(null, j, 1);
      model.setValueAt("Total Amount : "+totalPrice, j, 2);
   jf.add(jp2);
   String dname2=dname;
   JButton jb1=new JButton("Cancel Order");
   jb1.setFont(new Font ("TIMES NEW ROMAN",Font.BOLD,35));
    jb1.setBounds(500, 950, 400, 50);
    jb1.setBackground(Color.white);
    jf.add(jb1);
    jb1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e)
        		{
                           try{
        					Class.forName("oracle.jdbc.driver.OracleDriver");
        					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
        					Statement stmt =con.createStatement();
 
        					String sql="update drivers set d_status=0 where d_name='"+dname2+"'";
        					int rs=stmt.executeUpdate(sql);
        						Home ob=new Home(username);	
        						jf.setVisible(false);
        					
        					
        					con.close();
 
        				}
        				catch (Exception ex)
        				{

        					System.out.println((ex));
        					
                
        				}}
    });
    
    JButton jb2=new JButton("Checkout");
    jb2.setFont(new Font ("TIMES NEW ROMAN",Font.BOLD,35));
    jb2.setBounds(1050, 950, 400, 50);
    jb2.setBackground(new Color(0xed1c24));
    jf.add(jb2);
    int tprice=totalPrice;
    String dname1=dname;
    jb2.addActionListener(new ActionListener(){
        	 public void actionPerformed(ActionEvent e)
        		{
        			
        				try{
                                            
        					Class.forName("oracle.jdbc.driver.OracleDriver");
        					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
        					Statement stmt =con.createStatement();
 
        					String sql="select r_id,cid from customers,restaurant where r_name='"+selection+"' and uname='"+username+"'"; 					
        					ResultSet rs1=stmt.executeQuery(sql);
                                                rs1.next();
                                                //long rid,cid;
                                                long rid=rs1.getLong("r_id");
                                                long cid=rs1.getLong("cid");
                                               
                                                Statement stmt1 =con.createStatement();
                                                String sql1="insert into orders values(null,"+rid+","+cid+","+tprice+")"; 					    					
                                                int rs2=stmt1.executeUpdate(sql1);
                                                
        					con.close();
                                                
                                                thankyoupage ob=new thankyoupage(dname1,username);
                                                jf.setVisible(false);
 
        				}
        				catch (Exception ex)
        				{

        					System.out.println((ex));
        				
        				}
        			}
        		
        });
    
    jf.setVisible(true);
	}
	
}

       
    

