/**
 * 
 */
package edu.asselvi.trabalho.design;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author TiLL
 *
 */
public class MenuPrincipal extends JFrame implements IDialog, ActionListener
{  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuPrincipal()  
    {  
        JPanel panel = new JPanel();  
 
        JButton botaoPaciente = new JButton("Paciente");  
        botaoPaciente.addActionListener(this);
        botaoPaciente.setActionCommand("P"); 
               
        JButton botaoMedico = new JButton("Medico");
        botaoMedico.addActionListener(this);
        botaoMedico.setActionCommand("M"); 
        
        JButton botaoContrato = new JButton("Contrato");
        botaoContrato.addActionListener(this);
        botaoContrato .setActionCommand("C"); 
        
        JButton botaoAuditor = new JButton("Auditor");
        botaoAuditor.addActionListener(this);
        botaoAuditor .setActionCommand("A"); 
        
        JButton botaoProcedimento = new JButton("Procedimento");
        botaoProcedimento.addActionListener(this);
        botaoProcedimento .setActionCommand("Pr"); 
          
        panel.add(botaoPaciente);  
        panel.add(botaoMedico);  
        panel.add(botaoContrato);  
        panel.add(botaoAuditor);  
        panel.add(botaoProcedimento);  
        
        setTitle(getNomeTela());
        getContentPane().add(panel);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        pack(); 
    }
 
	@Override
	public void showDialog(boolean mostrar) {
		setVisible(mostrar); 
	}
    
	@Override
	public void actionPerformed(ActionEvent e) {

		switch(e.getActionCommand())
		{
		case "P" : JOptionPane.showInputDialog("Paciente"); break;
		case "M" : JOptionPane.showInputDialog("Medico"); break;
		case "C" : JOptionPane.showInputDialog("Contrato"); break;
		case "A" : JOptionPane.showInputDialog("Auditor"); break;
		case "Pr": JOptionPane.showInputDialog("Procedimento"); break;
		default  : JOptionPane.showInputDialog("ERRO"); break;
		}

	}

	@Override
	public String getNomeTela() {
		return "Menu Principal";
	}
}  
