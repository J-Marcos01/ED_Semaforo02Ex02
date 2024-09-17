package controller;
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

public class ThreadAeroporto extends Thread{
	
	private int idAviao;
	Semaphore semaforoNorte;
	Semaphore semaforoSul;
	private int pista; 
	
	public ThreadAeroporto(int idAviao,int pista,Semaphore semaforoNorte,Semaphore semaforoSul) {
		this.idAviao=idAviao;	
		this.pista=pista;
		this.semaforoNorte=semaforoNorte;
		this.semaforoSul=semaforoSul;
	}
	public void run()
	{
		if(pista==1)
		{
		try {
			
			semaforoSul.acquire();
			System.err.println("Avião :"+idAviao+" Decolara Pista sul");
			procdecolagem();	
			} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			semaforoSul.release();
		}
		}
		else
		{
		try {
			semaforoNorte.acquire();
			System.out.println("Avião :"+idAviao+" Decolara pista norte");
			procdecolagem();
			} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			semaforoNorte.release();
		}
		}
		
		}
	
	private void procdecolagem() {
		
		manobra();
		taxiar();
		decolar();
		afastamento();
		
		
		
	}		
		
	private void decolar() {
		int decolagem=(int)((Math.random()*201)+600);
		System.out.println("Avião : "+idAviao + " Decolou por :"+decolagem);
		try{
			sleep(decolagem);
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	private void afastamento() {
		int afastamento=(int)((Math.random()*501)+300);
		System.out.println("Avião : "+idAviao + " Afastou por :"+afastamento);
		try{
			sleep(afastamento);
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	private void taxiar() {
		int taxiar=(int)((Math.random()*501)+500);
		System.out.println("Avião : "+idAviao + " Taxiou por :"+taxiar);
		try{
			sleep(taxiar);
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	private void manobra() {

		int manobra=(int)((Math.random()*401)+300);
		System.out.println("Avião : "+idAviao + " Manobrou por :"+manobra);
		try{
			sleep(manobra);
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	}
	

