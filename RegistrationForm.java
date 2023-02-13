package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegistrationForm implements ActionListener{
	
	JFrame j;
	JLabel i, j1,j2,j3,j4,j5,j6,j7,j8,j9,j10;
	JTextField  t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	JButton b;
	JList l1;
	
	
	
	 public RegistrationForm()
	 {
		 j=new JFrame("                                Register");
		j.setVisible(true);
		j.setSize(550,600);
		j.setResizable(false);
		j.setLayout(null);
		
		
		i=new JLabel("ID :");
		j1=new JLabel("First Name :");
		j2=new JLabel("Last Name :");
		j3=new JLabel("Username");
		j4=new JLabel("Email");
		j5=new JLabel("Mobile Number");
		j6=new JLabel("City");
		j7=new JLabel("State");
		j8=new JLabel("zip");
		j9=new JLabel("Password");
		j10=new JLabel("Confirm-Password");
		

		t=new JTextField(20);
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(20);
		t6=new JTextField(20);
		t7=new JTextField(20);
		t8=new JTextField(20);
		t9=new JTextField(20);
		t10=new JTextField(20);
		
		b=new JButton("Register");
		j.add(i);
		j.add(j1);
		j.add(j2);
		j.add(j3);
		j.add(j4);
		j.add(j5);
		j.add(j6);
		j.add(j7);
		j.add(j8);
		j.add(j9);
		j.add(j10);
		
		j.add(t);
		j.add(t1);
		j.add(t2);
		j.add(t3);
		j.add(t4);
		j.add(t5);
		j.add(t6);
		j.add(t7);
		j.add(t8);
		j.add(t9);
		j.add(t10);
		
		j.add(b);
		i.setBounds(10,00,100,90);
		j1.setBounds(10, 50, 100, 90);
		j2.setBounds(250, 50,100, 90);
		j3.setBounds(10, 100,100, 90);
		j4.setBounds(10, 150, 100, 90);
		j5.setBounds(10,200,100,90);
		j6.setBounds(10,250,100,90);
		j7.setBounds(150, 250,100,90);
		j8.setBounds(350,250, 100,90);
		j9.setBounds(10, 300,100,90);
		j10.setBounds(10, 350,100,90);
		
		t.setBounds(20, 60, 100, 20);
		t1.setBounds(20,110,200,20);
		t2.setBounds(260,110,200,20);
		t3.setBounds(20,160, 440,20);
		t4.setBounds(20,210,440,20);
		t5.setBounds(20, 260,440,20);
		t6.setBounds(20,310,70,20);
		t7.setBounds(160,310,150,20);
		t8.setBounds(360,310,70,20);
		t9.setBounds(20,360,440,20);
		t10.setBounds(20,410,440,20);
		
		
		b.setBounds(200,460,100,30);
		
		b.addActionListener(this);
		
		
		
		
		
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new RegistrationForm();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b)
		{
			//System.out.println(" YOUR REGISTERATION SUCCESSFULL..");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/java12dec","root","");
				String sql="insert into user (fname,lname,uname,email,mobile,city,state,zip,password,con_pass)values(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setString(1,t1.getText());
				pst.setString(2,t2.getText());
				pst.setString(3,t3.getText());
				pst.setString(4,t4.getText());
				pst.setInt(5,Integer.parseInt(t5.getText()));
				pst.setString(6,t6.getText());
				pst.setString(7,t7.getText());
				pst.setString(8,t8.getText());
				pst.setString(9,t9.getText());
				pst.setString(10,t10.getText());
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(j,"Data Register Successfully.");
				
				t.setText("");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
				t9.setText("");
				t10.setText("");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		
		}
		
	}

}
