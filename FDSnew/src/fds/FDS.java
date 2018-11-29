/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fds;

/**
 *
 * @author admin
 */
import javax.swing.JFrame;
import javax.swing.*;
@SuppressWarnings("serial")
public class FDS extends JFrame{
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                loginpage ob=new loginpage();
                
                
            }
        
    });
    
}
}

