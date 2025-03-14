package employee.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JTextField tfusername;
    JPasswordField pfpassword;
    JButton btnTogglePassword;
    boolean isPasswordVisible = false;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);

        pfpassword = new JPasswordField();
        pfpassword.setBounds(150, 70, 150, 30);
        add(pfpassword);

        // Toggle button for password visibility
        btnTogglePassword = new JButton(new ImageIcon(ClassLoader.getSystemResource("icons/eye.png")));
        btnTogglePassword.setBounds(310, 70, 30, 30);
        btnTogglePassword.setBackground(Color.WHITE);
        btnTogglePassword.setForeground(Color.BLACK);
        btnTogglePassword.addActionListener(this);
        add(btnTogglePassword);

        JButton login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTogglePassword) {
            // Toggle password visibility
            if (isPasswordVisible) {
                pfpassword.setEchoChar('•');
                btnTogglePassword.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/eye.png")));
            } else {
                pfpassword.setEchoChar((char) 0);
                btnTogglePassword.setIcon(new ImageIcon(ClassLoader.getSystemResource("icons/eye-off.png")));
            }
            isPasswordVisible = !isPasswordVisible;
        } else {
            try {
                String username = tfusername.getText();
                String password = new String(pfpassword.getPassword());

                Conn c = new Conn();
                String query = "SELECT * FROM login WHERE username = '" + username + "' AND password = '" + password + "'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Home();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}


/*

package employee.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

	JTextField tfusername,tfpassword;
	
	Login(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(40, 20, 100, 30);
		add(lblusername);
		
		tfusername = new JTextField();
		tfusername.setBounds(150,20,150,30);
		add(tfusername);
		
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(40, 70, 100, 30);
		add(lblpassword);
		
		tfpassword = new JTextField();
		tfpassword.setBounds(150,70,150,30);
		add(tfpassword);
		
		JButton login = new JButton("LOGIN");
		login.setBounds(150, 140, 150, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 0, 200, 200);
		add(image);
		
		
		setSize(600,300);
		setLocation(450,200);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			String username = tfusername.getText();
			String password = tfpassword.getText();
			
			Conn c = new Conn();
			String query = "select * from login where username = '"+username+"'and password = '"+password+"'";
			ResultSet rs = c.s.executeQuery(query);
			if(rs.next()) {
				setVisible(false);
				new Home();
			}else {
				JOptionPane.showMessageDialog(null, "invalid username or password");
				setVisible(false);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
*/