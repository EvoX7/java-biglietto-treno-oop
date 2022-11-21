package org.ticket.buy;

import java.time.LocalDate;
import java.util.Scanner;

public class Ticket_office {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			while (true) {

				System.out.print("Your desired distance (in km): ");
				int km = sc.nextInt();

				System.out.print("Your Age: ");
				int age = sc.nextInt();

				System.out.println("--------------------------");

//		Generate new Ticket
				System.out.println("\nYour Ticket");
				System.out.println("--------------------------");
				
				
				Ticket ticket1 = new Ticket(km, age);
				System.out.println(ticket1);
				break;

			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		;

	}

}