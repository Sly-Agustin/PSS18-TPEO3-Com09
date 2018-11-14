package MenuPrincipal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Login.ExceptionHandlerWindow;

public class EscrituraDeComentarios {
	
	public static void escribirEnArchivo(String comentario, String usuario) {
		BufferedWriter escritorArchivo = null;
		try {
			escritorArchivo = new BufferedWriter(new FileWriter("src/Cuentas/comentarios", true));
			String usuarioEspacio = usuario.concat("  --  ");
			String comentarioFinal = usuarioEspacio.concat(comentario);
			System.out.println("Final: "+comentarioFinal);
			escritorArchivo.write(comentarioFinal);
			escritorArchivo.write(System.getProperty("line.separator"));
			escritorArchivo.flush();
			escritorArchivo.close();
		}
		catch(IOException e) {
			ExceptionHandlerWindow.showExceptionMessage("Error en la escritura del comentario en archivo");
		}
	}
}
