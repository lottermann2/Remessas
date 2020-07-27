package Remessa;

import java.util.Random;
import java.util.stream.IntStream;

public class Remessa {

	private int modo;

	public Remessa(int modo) {
		super();
		this.modo = modo;
	}

	
	public void resolucao (int[] lista)
	{
		
		StringBuilder texto = new StringBuilder();
		String resposta = "";
		if (lista.length == 1)
		{
			texto.append("Remessa emitida com a seguinte infra��o: ");
		}
		else
		{
			texto.append("Remessa emitida com as seguintess infra��es: ");
		}
		
		if (this.getModo() == 1)
		{
			this.resultaModo1(lista, resposta, texto);
			System.out.println(texto);
		}
		else if (this.getModo() == 2)
		{
			this.resultaModo2(lista, resposta, texto);
			System.out.println(texto);
		}
		else
		{
			System.out.println("Modo inv�lido");
		}
	}
	
	
	
	
	
	
	private void resultaModo1(int[] lista, String resposta, StringBuilder texto)
	{
		for (int i=0; i < lista.length; i++)
		{
			
			if (i == lista.length-2)						//caso chegue no penultimo numero, ele para de colocar a "," e adiciona o "e" e em seguida o ".".
			{												//assim, n�o impede se o vetor tiver apenas uma posi��o.
				resposta = IntStream.of(lista[i]).mapToObj(String::valueOf).reduce("", String::concat);
				texto.append(resposta + " e ");
				i++;
				resposta = IntStream.of(lista[i]).mapToObj(String::valueOf).reduce("", String::concat);		//utilizo o IntStream para transformar uma parte do vetor em String
				texto.append(resposta + ".\n");				//e adiciono essa parte do vetor numa String principal com o append do StringBuilder
				i++;
			}
			else
			{
				if (lista.length == 1)
				{
					resposta = IntStream.of(lista[i]).mapToObj(String::valueOf).reduce("", String::concat);		//caso tiver apenas uma posi��o, ele s� adiciona o ponto ao final
					texto.append(resposta + ".");
				}
				else
				{
					resposta = IntStream.of(lista[i]).mapToObj(String::valueOf).reduce("", String::concat);
					texto.append(resposta + ", ");							//adiciona a posi��o do vetor e mais uma virgula na String final.
				}
			}
		
		}
	}
	
	private void resultaModo2(int[] lista, String resposta, StringBuilder texto)			//Este m�todo � muito semelhante ao modo 1
	{
		float total = 0, teste;
		Random r = new Random();
		String aux;
		for (int i=0; i < lista.length; i++)
		{
			
			if (i == lista.length-2)						
			{											
				resposta = IntStream.of(lista[i]).mapToObj(String::valueOf).reduce("", String::concat);
				teste = r.nextFloat()*1000;						//unica diferen�a � que utilizo um Random para gerar um valor para a infra��o, guardando numa variavel
				total += teste;									//Para que eu consiga armazenar o valor total
				aux = String.format("%.2f", teste);				//E formato o valor para ficar apenas com duas casa decimais no texto.
				texto.append(resposta + " cujo valor � R$ " + aux + " e ");
				i++;
				resposta = IntStream.of(lista[i]).mapToObj(String::valueOf).reduce("", String::concat);		
				teste = r.nextFloat()*1000;
				total += teste;
				aux = String.format("%.2f", teste);
				texto.append(resposta + " cujo valor � R$ " + aux +  ".\n");			
				i++;
			}
			else
			{
				if (lista.length == 1)
				{
					
					resposta = IntStream.of(lista[i]).mapToObj(String::valueOf).reduce("", String::concat);	
					teste = r.nextFloat()*1000;
					total += teste;
					aux = String.format("%.2f", teste);
					texto.append(resposta + " cujo valor � R$ " + aux  + ".");
				}
				else
				{
					resposta = IntStream.of(lista[i]).mapToObj(String::valueOf).reduce("", String::concat);
					teste = r.nextFloat()*1000;
					total += teste;
					aux = String.format("%.2f", teste);
					texto.append(resposta + " cujo valor � R$ " + aux + ", ");							
				}
			}
		
		}
		aux = String.format("%.2f", total);						//e no final, apenas adiciono o total, formatando ele para apenas duas casas decimais tamb�m
		texto.append("Total = R$ " + aux);
	}
	
	public int getModo() {
		return modo;
	}

	public void setModo(int modo) {
		this.modo = modo;
	}
	
	
	
}
