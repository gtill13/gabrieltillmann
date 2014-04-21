/**
 * 
 */
package TESTE;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author TiLL
 * 
 */

public class HelperPane extends JOptionPane {

	/*
	 * private List<JTextField> CriaCampos(List<String> listString) {
	 * 
	 * List<JTextField> listFields = new ArrayList<JTextField>();
	 * 
	 * for (String string : listString) {
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * return listFields; }
	 */

	public static int showImputMult() {
		
		JTextField campo1 = new JTextField();
		JTextField campo2 = new JTextField();

		Object[] campos = { "campo 1", campo1, "campo 2", campo2 };

		JOptionPane.showConfirmDialog(null, campos, "Teste",
				JOptionPane.OK_CANCEL_OPTION);

		System.out.println(campo1.getText());
		System.out.println(campo2.getText());

		return 0;
	}

}
