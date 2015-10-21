package br.com.monitorIP.monitor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Monitor {

	public static void main(String[] args) {
		
		String ip = "192.168.80.15";
		
		try {
			
			Monitor.execPing(ip, 5);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
		
	 public static void execPing(String ip) {
		 try {
			 String line = null;
 
			// (System.getenv("windir") = pega o diretório de instalacao do windows
			// Runtime executa um comando no windows (O mesmo utilizado no prompt do MSDOS)
			// metodo exec colocar o comando que deseja executar
			//Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe -v");
			 Process p = Runtime.getRuntime().exec("ping " + ip);
			InputStreamReader in = new InputStreamReader(p.getInputStream(), Charset.forName("ISO-8859-1"));
								
			// Coleta o retorno da execucao do comando
			BufferedReader input = new BufferedReader(in);
			 
			// Faz um loop para cada linha do retorno da execucao
			while ((line = input.readLine()) != null) {
				// Mostra o retorno do comando linha por linha, podendo
				// implementar alguma regra aqui
				System.out.println(line);
			}
 
			// Fecha stream
			input.close();
 	             
 	        } catch (Exception err) {
 	            err.printStackTrace();
 	        }
 	 
 	    }
 
	 public static void execPing(String ip, int qtd) throws InterruptedException {
		 
			 String line = null;
			 StringBuilder sb = null;
			 
			 for(int i = 0; i < qtd ;i++){
				 
				 try {
			 
					Process p = Runtime.getRuntime().exec("ping " + ip);
					InputStreamReader in = new InputStreamReader(p.getInputStream(), Charset.forName("ISO-8859-1"));
										
					BufferedReader input = new BufferedReader(in);
					
					sb = new StringBuilder("\n" + new java.util.Date());
					
					while ((line = input.readLine()) != null) {
						sb.append(line).append("\n");
					}
		 
					input.close();
					
					System.out.println("**************************************************");
					System.out.println(sb.toString());
					System.out.println("**************************************************");
	 	            
	 	        } catch (Exception err) {
	 	            err.printStackTrace();
	 	        }
				
				System.out.println(new java.util.Date());
				Thread.sleep(1_000);
		 	}
 	    }
	 
}
