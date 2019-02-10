package org.edu.eci;

import java.util.*;
import java.io.*;

public class Calculate {
	public ArrayList<Float> Numbers;

	public Calculate(ArrayList<Float> Numbers) {
		// TODO Auto-generated constructor stub
		this.Numbers = Numbers;

	}

	public String devolverListaDeNumeros() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (float num : Numbers) {
			sb.append(num);
			sb.append(",");

		}
		sb.append("]");
		return sb.toString();

	}

	public String devolverElMaximo() {
		float MAX = Float.MIN_VALUE;
		for (float num : Numbers)
			MAX = MAX < num ? num : MAX;

		return Float.toString(MAX);

	}

	public String devolverElMinimo() {
		float MIN = Float.MAX_VALUE;
		for (float num : Numbers)
			MIN = MIN > num ? num : MIN;

		return Float.toString(MIN);

	}

	public String devolverLaMultiplicatoria() {
		double resp = 1;
		for (float num : Numbers)
			resp *= num;

		return String.format("%2f", resp);

	}

	public String devolverLaSumatoria() {
		double resp = 0;
		for (float num : Numbers)
			resp += num;

		return String.format("%2f", resp);

	}

}
