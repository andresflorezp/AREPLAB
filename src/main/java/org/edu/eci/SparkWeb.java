package org.edu.eci;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import java.util.*;
/**
 * @author Andres
 * Esta clase permite crear la aplicacion con spark
 */
public class SparkWeb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		port(getPort());
		get("/",(req,resp)->pageIndex(req,resp));
		get("/calculo",(req,resp)->Calculo(req,resp));
		get("/results",(req,resp)->answer(req, resp));
		
	}
	

	public static String pageIndex(Request req,Response resp){
		String respuesta="<!doctype html>\n" +
				"<html lang=\"en\">\n" +
				"<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <meta name=\"viewport\"\n" +
				"          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
				"    <title>AREP-Lab 2</title>\n" +
				"</head>\n" +
				"<body>\n" +
				"    <h1>AREP-PARCIAL</h1>\n" +
				"    <p>Este es un programa que calcula  la lista de números, el máximo, el mínimo, la sumatoria y la multiplicatoria. para iniciar de click en el siguiente\n" +
				"        vinculo <a href=\"\\calculo\">Oprime</a>\n" +
				"    </p>\n" +
				"</body>\n" +
				"</html>";
		return respuesta;
	}
	public static String Calculo(Request req,Response resp){
		String respuesta="<!doctype html>\n" +
				"<html lang=\"en\">\n" +
				"<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <meta name=\"viewport\"\n" +
				"          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
				"    <title>Document</title>\n" +
				"</head>\n" +
				"<body>\n" +
				"    <h1>AREP-PARCIAL</h1>\n" +
				"    <br/>\n" +
				"    <h2>Digita el conjunto de datos de la siguiente forma</h2>\n" +
				"    <p>Ej:\n" +
				"        4;5.2;6;2.3;........;..\n" +
				"    </p>\n" +
				"    <form action=\"/results\">\n" +
				"        <h3>Conjunto de datos numero 1</h3>\n" +
				"        <input type=\"text\" placeholder=\"Numeros espaciados con ';'\" name=\"DataOne\">\n" +
				"        <input type=\"submit\" value=\"Calcular\">\n" +
				"\n" +
				"    </form>\n" +
				"\n" +
				"</body>\n" +
				"</html>";
		return respuesta;
	}

	public static String answer(Request req,Response resp){
		String set1 = req.queryParams("DataOne");
		String[] particion1=set1.split(";");
		ArrayList<Float> Data1=new ArrayList();
		for(String num:particion1) {
			Data1.add(Float.parseFloat(num));
		}
		
		int N1 = Data1.size();
		//Calculo de desvicacion estandar
		Calculate cal = new Calculate(Data1);
		
		String list = cal.devolverListaDeNumeros();
		String max = cal.devolverElMaximo();
		String min = cal.devolverElMinimo();
		String sum = cal.devolverLaSumatoria();
		String mult = cal.devolverLaMultiplicatoria();
		
		String respuesta="<!doctype html>\n" +
				"<html lang=\"en\">\n" +
				"<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <meta name=\"viewport\"\n" +
				"          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
				"    <title>Document</title>\n" +
				"</head>\n" +
				"<body>\n" +
				"    <h1>AREP-PARCIAL</h1>\n" +
				"\n" +
				"    <h2>Los resultados se presentan a continuacion</h2>\n" +
				"\n" +
				"La lista de numeros es: "+list+"\n"+"<br>"+
				"El numero maximo es: "+max+"\n"+"<br>"+
				"El numero minimo es: "+min+"\n"+"<br>"+
				"La sumatoria es: "+sum+"\n"+"<br>"+
				"La multiplicatoria es: "+mult+"\n"+"<br>"+
				"\n" +
				"\n" +
				"\n" +
				"</body>\n" +
				"</html>";
		
		String respuesta2= "<!doctype html>\n" +
				"<html lang=\"en\">\n" +
				"<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <meta name=\"viewport\"\n" +
				"          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
				"    <title>Document</title>\n" +
				"</head>\n" +
				"<body>\n" +
				"[{\"maximo\":"+max+"," + "\"minimo\":"+min+","+ "\"sumatoria\":"+sum+","
                + "\"listaNumeros\":"+Data1.toString()+","
                + "\"multiplicatoria\":"+mult+"}]"+
				"</body>\n" +
				"</html>";
		return respuesta2;
	}

	
	/**
	 * Este metodo permite tener el puerto por defecto de heroku o asignarle uno
	 * 
	 * @return
	 */
	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; // returns default port if heroku-port isn't set (i.e. on localhost)
	}


}