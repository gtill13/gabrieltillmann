package edu.asselvi.trabalho.design;

import java.awt.event.ActionEvent;

public interface IDialog  {

	void showDialog(boolean mostrar);
	void actionPerformed(ActionEvent e);  
	String getNomeTela();
	
}
