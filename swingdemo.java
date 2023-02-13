package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class swingdemo implements ActionListener {
	
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton b1,b2,b3,b4;
	
	public swingdemo()
	{
		f=new JFrame("Employee Registration");
		f.setVisible(true);
		f.setSize(450, 500);
		f.setResizable(false);
		f.setLayout(null);
		
		l1=new JLabel("ID :");
		l2=new JLabel("First Name :");
		l3=new JLabel("Last Name :");
		l4=new JLabel("Email :");
		l5=new JLabel("Mobile No :");
		l6=new JLabel("PASSWORD :");
		
		
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(20);
		t6=new JTextField(20);
		
		b1=new JButton("INSERT");
		b2=new JButton("SEARCH");
		b3=new JButton("UPDATE");
		b4=new JButton("DELETE");
		
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(l6);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(t4);
		f.add(t5);
		f.add(t6);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		
		l1.setBounds(50,50,100,50);
		l2.setBounds(50,100,100,50);
		l3.setBounds(50,150,100,50);
		l4.setBounds(50,200,100,50);
		l5.setBounds(50,250,100,50);
		l6.setBounds(50,300,100,50);
		
		t1.setBounds(150,60,200,30);
		t2.setBounds(150,110,200,30);
		t3.setBounds(150,160,200,30);
		t4.setBounds(150,210,200,30);
		t5.setBounds(150,260,200,30);
		t6.setBounds(150,310,200,30);
		
		
		
		b1.setBounds(50,370,100,30);
		b3.setBounds(50,420,100,30);
		//b2.setBounds(50,420,100,30);
		b2.setBounds(250,370,100,30);
		b4.setBounds(250,420,100,30);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new swingdemo();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1)
		{
		
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java12dec","root","");
				
				String sql="insert into student(fname,lname,email,mobile,password)values(?,?,?,?,?)";
				
				PreparedStatement pst=conn.prepareStatement(sql);
				
				pst.setString(1,t2.getText());
				pst.setString(2,t3.getText());
				pst.setString(3,t4.getText());
				pst.setLong(4,Long.parseLong(t5.getText()));
				pst.setString(5,t6.getText());
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(f,"Data Insert Successfully.");
				
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
		else if(ae.getSource()==b2)
		{
			//System.out.println("Search clicked");
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java12dec","root","");
				String sql="select * from student where id=? ";
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setInt(1, Integer.parseInt(t1.getText()));
				ResultSet re=pst.executeQuery();
				if(re.next())
				{
					t2.setText(re.getString("fname"));
					t3.setText(re.getString("lname"));
					t4.setText(re.getString("email"));
					t5.setText(re.getString("mobile"));
					t6.setText(re.getString("password"));
				}
				else
				{
					JOptionPane.showMessageDialog(f, "Id Not Found.");
				}
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		
		else if(ae.getSource()==b3)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java12dec","root","");
				String str="update student set fname=?,lname=?,email=?,mobile=?,password=? where id=?";
				
				PreparedStatement pst=conn.prepareStatement(str);
				pst.setString(1,t2.getText());
				pst.setString(2,t3.getText());
				pst.setString(3,t4.getText());
				pst.setLong(4,Long.parseLong(t5.getText()));
				pst.setString(5,t6.getText());
				pst.setInt(6,Integer.parseInt(t1.getText()));
				//pst.setString(5, t6.getText());
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(f, "Data Inserted Successfullly.");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(ae.getSource()==b4)
		{
//			System.out.println("Delete clicked");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java12dec","root","");
				String sql="delete from student where id=?";
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setInt(1,Integer.parseInt(t1.getText()));
				pst.executeUpdate();
				JOptionPane.showMessageDialog(f,"Data Deleted Successfully.");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}

}
