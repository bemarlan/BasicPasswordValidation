package pkg;

import javax.swing.JOptionPane;

public class ValidatePassword {

	public static void main(String[] args) {
		// get password
		getPassword();
	} // end main
	
	public static void getPassword() {
		// prompt user for password
		String password;
		boolean invalid = true; // assume password is not valid until proven otherwise
		
		do {
			password = JOptionPane.showInputDialog(null, "Enter a password", "Create Password", JOptionPane.QUESTION_MESSAGE);
			
			// cast string password to stringbuilder and pass over for validation
			StringBuilder validPass = new StringBuilder(password);
			invalid = validatePassword(validPass);
		} while(invalid);
		
		// once password passes validation, let user know
		JOptionPane.showMessageDialog(null, "Password is valid.");
	} // end getPassword
	
	public static boolean validatePassword(StringBuilder password) {
		// password requiremnts:
		//	- a password consists of only letters and digits.
		// 	- a password must have at least 8 characters.
		// 	- a password must contain at least 2 digits.
		
		// again, assume password is invalid unless proven otherwise
		boolean isInvalid = true;
		
		// declare count vars
		int digits = 0;
		int total = 0;
		int otherChars = 0;
		
		// evaulate and count each charcter
		for (int i = 0; i < password.length(); i++) {
			if (Character.isLetter(password.charAt(i))) {
				total++;
			}
			else if (Character.isDigit(password.charAt(i))) {
				digits++;
				total++;
			}
			else {
				otherChars++;
			}
		}
		
		// perform actual validation based on above evaulation
		if (otherChars != 0) {
			JOptionPane.showMessageDialog(null, "Your password " + password + " is not valid.\n"
											+ "It must be ONLY characters and digits.");
		}
		else {
			if (password.length() < 8) {
				JOptionPane.showMessageDialog(null, "Your password " + password + " is not valid.\n"
						+ "It must be at least 8 characters");
			}
			else {
				if (digits < 2) {
					JOptionPane.showMessageDialog(null, "Your password " + password + " is not valid.\n"
							+ "It must have at least 2 digits.");
				}
				else {
					isInvalid = false;
				}
			}
		}
		
		return isInvalid;
	}

} // end class
