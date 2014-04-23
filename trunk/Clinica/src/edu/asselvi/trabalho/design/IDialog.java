package edu.asselvi.trabalho.design;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public interface IDialog  {

	void showDialog(boolean mostrar);
	void actionPerformed(ActionEvent e);  
	String getNomeTela();
	
}
