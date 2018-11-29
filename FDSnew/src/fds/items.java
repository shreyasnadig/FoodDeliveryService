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
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class items extends JFrame{

  //MAIN METHOD
    
 items(String username,String selection)
  {
      String name;
      int price;

      
JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame jf=new JFrame("Menu");
    jf.setBounds(12,25,1900,1000);
    jf.setExtendedState( jf.getExtendedState()|JFrame.MAXIMIZED_BOTH );
    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //jf.setResizable(false);
    jf.setLayout(null);
    
    ImageIcon im = new ImageIcon(getClass().getResource("/images/bg2.jpg"));
        setIconImage(im.getImage());
        jf.setContentPane(new JLabel(new ImageIcon(im.getImage())));
   // jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\shrey\\Downloads\\resources\\bg2.jpg")));
  jf.setVisible(true);
           
       
JLabel jl=new JLabel("Welcome To "+selection+"!");
  jl.setBounds(200,100,500,40);
  jl.setFont(new Font("times new roman",Font.BOLD,35));
  jl.setForeground(Color.WHITE);
  
  jf.add(jl);
  
    //the form
      

    //ADD SCROLLPANE
    JScrollPane scroll=new JScrollPane();
    scroll.setBounds(100,200,1700,600);
    scroll.setBackground(Color.white);
    scroll.setOpaque(false);
    jf.getContentPane().add(scroll);

    //THE TABLE
    final JTable table=new JTable();
    table.setBackground(Color.white);
    table.setOpaque(false);
       table.setFont(new Font("times new roman", Font.PLAIN, 25));
JTableHeader header = table.getTableHeader();
header.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
  header.setBackground(new Color(0xed1c24));
    scroll.setViewportView(table);
    table.setBounds(10,80,780,400);
    table.setOpaque(true);
    table.setShowGrid(false);
    table.setRowHeight(50);
    
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment( JLabel.CENTER );
table.setDefaultRenderer(String.class, centerRenderer);
    
    
    String a[]={"0","1","2","3","4","5"};

     table.setOpaque(false);
((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
scroll.setOpaque(false);
scroll.getViewport().setOpaque(false);
JComboBox qty;
      qty = new JComboBox<String>(a);

    //THE MODEL OF OUR TABLE
    DefaultTableModel model=new DefaultTableModel()
    {
      @Override
      public Class<?> getColumnClass(int column)
      {
        switch(column)
        {
        case 0:
          return Boolean.class;
        case 1:
          return String.class;
        case 2:
          return String.class;
     case 3:
          return JComboBox.class;
//        case 4:
//          return String.class;

          default:
            return String.class;
        }
      }
    };

    //ASSIGN THE MODEL TO TABLE
    table.setModel(model);

    model.addColumn("Select");
    model.addColumn("Name");
    model.addColumn("Price");
    model.addColumn("Quantity");
//    model.addColumn("Manager");

    //THE ROW
//    for(int i=0;i<=2;i++)
//    {
//      model.addRow(new Object[0]);
//      model.setValueAt(false,i,0);
//      model.setValueAt("biryani"+(i+1), i, 1);
//      model.setValueAt("300", i, 2);
////      model.setValueAt("Our Column 3", i, 3);
////      model.setValueAt("Our Column 4", i, 4);
//    }
    try{
             Class.forName("oracle.jdbc.driver.OracleDriver");
 Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","richul","richuln6");
 Statement stmt =conn.createStatement();
 
 String sql="select i_name,price from items i,rest_has_items ri,restaurant r where i.i_id=ri.i_id and r.r_id=ri.r_id and r.r_name='"+selection+"' " ; 

 ResultSet rs=stmt.executeQuery(sql);
 int i=0;
table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(qty));
table.setColumnSelectionAllowed(true); 
 while(rs.next())
          {
            
              name=rs.getString("i_name");
              price=rs.getInt("price");
          
              model.addRow(new Object[0]);
      model.setValueAt(false,i,0);
      model.setValueAt(name, i, 1);
      model.setValueAt(price, i, 2);
     
      model.setValueAt(0,i,3);
      i++;
          }
  }
  catch(Exception e)
  {
      System.out.println(e);
  }

    //OBTAIN SELECTED ROW
    //JButton btn=new JButton("Get Selected");
    
    //ADD BUTTON TO FORM
//    btn.setBounds(20,30,130,30);
//    jf.getContentPane().add(btn);
    JButton jb1=new JButton("Go Back");
        jb1.setBounds(500, 950, 400, 75);
        jb1.setFont(new Font("times new roman",Font.BOLD,50));
        jb1.setBackground(Color.white);
        jf.add(jb1);
        jb1.addActionListener((ActionEvent e) -> {
        {
            Home ob=new Home(username);
            jf.setVisible(false);
        }});
//        JLabel jl=new JLabel("Number Of Items:");
//        jl.setBounds(300,450,200,30);
//        jf.add(jl);
//        
        
        JButton jb2=new JButton("Place Order");
        jb2.setBounds(1070, 950, 400, 75);
        jb2.setFont(new Font("times new roman",Font.BOLD,50));
        jb2.setBackground(new Color(0xed1c24));
        jf.add(jb2);
jb2.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

        //GET SELECTED ROW
        int size=table.getRowCount();
        String[] name=new String[size];
          int[] price=new int[size];
                  int[] quan=new int[size];
                  int count=0;
                  int quancount=0;
        for(int i=0;i<size;i++)
        {
          Boolean checked=Boolean.valueOf(table.getValueAt(i, 0).toString());
          
          //DISPLAY
          if(checked)
          {
              count++;
          name[i]=table.getValueAt(i, 1).toString();
          price[i]=Integer.parseInt(table.getValueAt(i, 2).toString());
          quan[i]=Integer.parseInt(table.getValueAt(i, 3).toString());
         if(quan[i]==0){          
            JOptionPane.showMessageDialog(null,"Enter the right Quantity");
            quancount++;}
                   
          }
          else{
              int q=Integer.parseInt(table.getValueAt(i, 3).toString());
                if(q!=0){
               quancount++;
               //JOptionPane.showMessageDialog(null,quancount);
                
                }
         
        }
        }
        if(count==0){
            JOptionPane.showMessageDialog(null,"Select Any Item");}
        else if(quancount==0){
            cart ob1=new cart(username,name,price,quan,size,selection);
      jf.setVisible(false);
             
        }
        else
            JOptionPane.showMessageDialog(null,"Invalid Selection ");
      }
    });

  }

}