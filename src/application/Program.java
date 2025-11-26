
package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a file path: ");
		String strPath = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(strPath))){
			String fileLine = br.readLine();
			
			while (fileLine != null) {
				String[] fields = fileLine.split(",");
				list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
				
				fileLine = br.readLine();
			}
			Collections.sort(list);
			for (Employee employee : list) {
				System.out.println(employee.getName() + "," + employee.getSalary());
			}
		}catch(IOException e){
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
			
		}

}

