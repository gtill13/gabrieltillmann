package edu.asselvi.trabalho.design;

public class DesignBase {

	public final static void clearConsole()
	{
	    /**try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        // nem vo faze nada ele soh nao limpou a tela.... is the life
	    }
	}**/
		for (int i = 0; i < 50; ++i) 
			System.out.println();	
		
	}
}
