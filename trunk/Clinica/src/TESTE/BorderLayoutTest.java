/**
 * 
 */
package TESTE;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
  
public class BorderLayoutTest extends JFrame implements ActionListener  
{  
    JList lista;  
    JButton botaoAdicionar;  
    JTextField textField;  
    JPanel listPanel;  
    JPanel botaoPanel;  
    JScrollPane scroll;  
    DefaultListModel listModel;  
      
    public BorderLayoutTest()  
    {  
        super("GUJ - JList");  
          
        textField = new JTextField("Digite algo");  
        botaoAdicionar = new JButton("Adicionar");        
        listModel = new DefaultListModel();  
        listPanel = new JPanel();  
        botaoPanel = new JPanel();  
          
          
        // Adiciona um item inicial na lista  
        listModel.addElement("Item 1");  
        listModel.addElement("Item 2");  
        listModel.addElement("Item 3");  
          
        // Configura a lista e adiciona ao painel  
        lista = new JList(listModel);  
        lista.setVisibleRowCount(3);  
          
        scroll = new JScrollPane(lista);  
          
        listPanel.add(scroll);  
        getContentPane().add(listPanel, BorderLayout.CENTER);  
      
        // Adiciona o campo de texto e o botao ao painel  
        botaoAdicionar.addActionListener(this);  
        botaoPanel.add(textField);                        
        botaoPanel.add(botaoAdicionar);  
          
        getContentPane().add(botaoPanel, BorderLayout.SOUTH);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);               
          
        // Mostra a janela  
        pack();  
        setVisible(true);  
    }  
      
    public void actionPerformed(ActionEvent event)  
    {  
        if (textField.getText() != "") {  
            listModel.addElement(textField.getText());  
            getContentPane().invalidate();  
            getContentPane().validate();  
        }         
    }  
          
    public static void main(String args[])  
    {  
        BorderLayoutTest s = new BorderLayoutTest();        
    }  
}  
