package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Reserva r = null;
		
		System.out.print("Número do quarto: ");
		int num = sc.nextInt();
		System.out.print("Data de Check-in (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Data de Check-out (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		if (!checkout.after(checkin)) {
			System.out.println("Data de CheckOut deve ser maior que a data de CheckIn.");
		} else {
			r = new Reserva(num,checkin,checkout);
			System.out.println(r);
			System.out.println();
			
			System.out.println("Adicione as data para atualizar a reserva:");
			System.out.print("Data de Check-in (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Data de Check-out (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			String erro = r.atualizarDatas(checkin, checkout);
			
			if (erro != null) {
				System.out.println("Erro na reserva: " + erro);
			} else {
				System.out.println(r);
			}
			
		}
		sc.close();
	}

}
