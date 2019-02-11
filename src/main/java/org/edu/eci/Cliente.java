package org.edu.eci;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;
import java.io.*;

//URL https://spark-simulacro.herokuapp.com/ la IP es 34.203.183.13
public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket clienteSocket = null;
		final int PORT = SparkWeb.getPort();
		final String HOST = "34.203.183.13";
		BufferedReader in;
		PrintWriter out;
		try {
			clienteSocket = new Socket(HOST, PORT);
			in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
			out = new PrintWriter(clienteSocket.getOutputStream());
			

			String mensaje;
			while ((mensaje = in.readLine()) != null) {

				System.out.println(mensaje);
				if (!in.ready())
					break;

			}
			

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
