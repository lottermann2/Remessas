package Remessa;


public class main 
{
	public static void main (String[] args)
	{
		int [] lista = {1, 2, 3, 4};						//lista que � possivel alterar
		
		Remessa remessa = new Remessa(1);					//� passado o modo desejado, 1 = apenas as infra��es e 2 = infra��es com valores.
		
		remessa.resolucao(lista);							// m�todo da classe p�blico utilizado.
		
	}
}
