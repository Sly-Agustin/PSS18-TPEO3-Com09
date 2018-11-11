package Login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VerificadorUsuario {
	
	VerificadorUsuario() {}
	
	public boolean login(String usuario, String contrasenia) {
		boolean login = false;
		
		BufferedReader lectorArchivo = null;
		try {
			lectorArchivo = new BufferedReader(new FileReader("bin/Cuentas/cuentas"));
			
			String linea;
			while (login == false  &&  (linea=lectorArchivo.readLine()) != null) {
				linea = linea.substring(0, linea.length()-1);	// GetText añade un espacio vacio que no deja usar equals, aca se saca
				if (linea.equals(usuario)) {
					if ((linea=lectorArchivo.readLine()).equals(contrasenia)) {
						login = true;
					}
				}
				else {
					lectorArchivo.readLine();
				}
			}
		}
		catch(IOException e) {
			ExceptionHandlerWindow.showExceptionMessage("Error en la lectura de archivos con usuario y contraseña");
		}
		
		return login;
	}
}
