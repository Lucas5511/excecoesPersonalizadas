package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reservas;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Numero do quarto: ");
		int numero = scanner.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy)");
		Date checkIn = sdf.parse(scanner.next());

		System.out.println("Check-out date (dd/MM/yyyy)");
		Date checkOut = sdf.parse(scanner.next());
		if (!checkOut.after(checkIn)) {
			System.out
					.println("Error na reserva: A data do Check-out precisa ser colocada depois da data de Check-in ");
		} else {
			Reservas reserva = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reservas: " + reserva);
			System.out.println("Coloque os dados atualizados da reserva: ");
			System.out.println("Check-in date (dd/MM/yyyy)");
			checkIn = sdf.parse(scanner.next());
			System.out.println("Check-out date (dd/MM/yyyy)");
			checkOut = sdf.parse(scanner.next());

			Date agora = new Date();
			if (checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Erro na reserva: As datas de reserva precisam ser futuras");
			} else if (!checkOut.after(checkIn)) {
				System.out.println(
						"Error na reserva: A data do Check-out precisa ser colocada depois da data de Check-in ");
			} else {
				reserva.datasAtualizadas(checkIn, checkOut);
				System.out.println("Reservas: " + reserva);
			}
		}

		scanner.close();
	}

}
