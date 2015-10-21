package br.com.monito.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.monitorIP.monitor.Monitor;

public class MonitorPingTest {

	@Test
	public void executaPing() {
		String ip = "200.221.2.45";
		try {
			Monitor.execPing(ip, 2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 
}
