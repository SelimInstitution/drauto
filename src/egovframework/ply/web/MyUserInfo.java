package egovframework.ply.web;

import com.jcraft.jsch.*;
import java.awt.*;
import javax.swing.*;

public class MyUserInfo implements UserInfo {
	public MyUserInfo () {
	}

	public MyUserInfo (String _passwd) {
		this.passwd = passwd;
	}
	
	public String getPassword() {
		return passwd;
	}
	
	public void setPasswd(String _passwd) {
		passwd = _passwd;
	}	

	public boolean promptYesNo(String str) {
		return false;
	}

	String passwd;
	JTextField passwordField = (JTextField) new JPasswordField(20);

	public String getPassphrase() {
		return null;
	}

	public boolean promptPassphrase(String message) {
		return true;
	}

	public boolean promptPassword(String message) {
		return true;
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	private Container panel;

}
