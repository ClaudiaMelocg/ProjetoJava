package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Departamento;
import entities.Funcionario;
import entities.HoraContrato;
import entities.enums.NivelFuncionario;

public class Main {

	public static void main(String[] args)throws ParseException {
		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o nome do departamento: ");
		String nomeDepartamento = teclado.nextLine();
		System.out.print("Nome Funcionario: ");
		String nomeFuncionario = teclado.nextLine();
		System.out.print("Nivel: ");
		String nivelFuncionario = teclado.nextLine();
		System.out.print("Base salarial: ");
		double baseSalario = teclado.nextDouble();
		Funcionario funcionario = new Funcionario(nomeFuncionario, NivelFuncionario.valueOf(nivelFuncionario), baseSalario, new Departamento(nomeDepartamento));
		
		System.out.print("Quantos contratos para o funcionario? ");
		int n = teclado.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Digitar contrato #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contratoDate = sdf.parse(teclado.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = teclado.nextDouble();
			System.out.print("Duracao (horas): ");
			int horas = teclado.nextInt();
			HoraContrato contrato = new HoraContrato(contratoDate, valorPorHora, horas);
			funcionario.addContrato(contrato);
		}
		
		System.out.println();
		System.out.print("Digitar mes e ano para realização do calculo: ");
		String mesEAno = teclado.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("Departamento: " + funcionario.getDepartamento().getNome());
		System.out.println("Salario Total " + mesEAno + ": " + String.format("%.2f", funcionario.valor(ano, mes)));
		
		teclado.close();
		

	}

}
