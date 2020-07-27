package Remessa;


public class main 
{
	public static void main (String[] args)
	{
		int [] lista = {1, 2, 3, 4};						//lista que é possivel alterar
		
		Remessa remessa = new Remessa(1);					//é passado o modo desejado, 1 = apenas as infrações e 2 = infrações com valores.
		
		remessa.resolucao(lista);							// método da classe público utilizado.
		
	}
}
