package Login;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExceptionHandlerWindow {
	
	ExceptionHandlerWindow() {}
	
	public static void showExceptionMessage(String message) {
		JOptionPane.showMessageDialog(new JFrame(),
				message,
				"Mensaje de error",
				JOptionPane.ERROR_MESSAGE);
	}
}
