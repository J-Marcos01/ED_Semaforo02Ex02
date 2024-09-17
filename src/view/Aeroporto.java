package view;
/*
 * 2. Um aeroporto tem 2 pistas (norte e sul) e, em cada pista, apenas um avião pode fazer a
decolagem. O procedimento de decolagem tem 4 fases ( taxiar, decolagem e afastamento da área).
A fase de manobra pode durar de 300 a 700 milissegundos A fase de taxiar, de 500 a 1000
milissegundos. A fase de decolagem, de 600 a 800 milissegundos. A fase de afastamento, de 300 a
800 milissegundos. O aeroporto reúne, por ciclo, 12 aeronaves que podem decolar pela pista norte
ou pela pista sul (decisão aleatória) mas, apenas 2 aviões podem circular pela área de decolagem
ao mesmo tempo. Fazer uma aplicação em Java que resolva o problema.
*/
import java.util.concurrent.Semaphore;

import controller.ThreadAeroporto;

public class Aeroporto {

	public static void main(String[] args) {
		
		int perm=1;
		Semaphore semaforo = new Semaphore(perm);
		//Semaphore semaforo2=new Semaphore(perm);
		for(int i=0;i<12;i++)
		{
			int pista=(int)((Math.random()*2)+1);
			Thread t = new ThreadAeroporto(i + 1,pista,semaforo,semaforo);
			t.start();
		}
	}

}
