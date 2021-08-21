package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reservas;
import modelo.excecoes.ExcecoesDeDominio;

public class Programa {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Numero do quarto: ");
			int numero = scanner.nextInt();
			System.out.println("Check-in date (dd/MM/yyyy)");
			Date checkIn = sdf.parse(scanner.next());

			System.out.println("Check-out date (dd/MM/yyyy)");
			Date checkOut = sdf.parse(scanner.next());

			Reservas reserva = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reservas: " + reserva);
			System.out.println("Coloque os dados atualizados da reserva: ");
			System.out.println("Check-in date (dd/MM/yyyy)");
			checkIn = sdf.parse(scanner.next());
			System.out.println("Check-out date (dd/MM/yyyy)");
			checkOut = sdf.parse(scanner.next());

			reserva.datasAtualizadas(checkIn, checkOut);
			System.out.println("Reservas: " + reserva);
		} 
		catch (ParseException e) {
			System.out.println("Data invalida. ");
		} 
		catch (ExcecoesDeDominio e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		scanner.close();
	}

}
