package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DominioException;

public class Program {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do quarto: ");
			int num = sc.nextInt();
			System.out.print("Data de Check-in (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Data de Check-out (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());
			
			Reserva r = new Reserva(num,checkin,checkout);
			System.out.println(r);
			System.out.println();
			
			System.out.println("Adicione as data para atualizar a reserva:");
			System.out.print("Data de Check-in (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Data de Check-out (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			r.atualizarDatas(checkin, checkout);
			System.out.println(r);
		} catch (ParseException e) {
			System.out.println("Formato de data inválido !!!");
		} catch (DominioException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado!!!");
		}
		
		sc.close();
	}

}
