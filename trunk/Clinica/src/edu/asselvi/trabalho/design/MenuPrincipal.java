/**
 * 
 */
package edu.asselvi.trabalho.design;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author TiLL
 *
 */
public class MenuPrincipal extends JFrame  
{  
  
    public MenuPrincipal()  
    {  
        JPanel panel = new JPanel();  
          
        JButton botao1 = new JButton("Botão 1");  
        JButton botao2 = new JButton("Botão 2");  
        JButton botao3 = new JButton("Botão 3");  
        JButton botao4 = new JButton("Botão 4");  
        JButton botao5 = new JButton("Botão 5");  
          
        panel.add(botao1);  
        panel.add(botao2);  
        panel.add(botao3);  
        panel.add(botao4);  
        panel.add(botao5);  
          
        getContentPane().add(panel);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
          
        pack();  
        setVisible(true);  
    }  
}  
