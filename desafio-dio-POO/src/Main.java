import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {
		Curso curso1 = new Curso();
		curso1.setTitulo("curso java");
		curso1.setDescricao("descrição curso java");
		curso1.setCargaHoraria(8);

		Curso curso2 = new Curso();
		curso2.setTitulo("curso javaScript");
		curso2.setDescricao("descrição curso javaScript");
		curso2.setCargaHoraria(8);

		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("mentoria em java");
		mentoria.setDescricao("Descrição mentoria java");
		mentoria.setData(LocalDate.now());

		/*
		 * System.out.println(curso1); System.out.println(curso2);
		 * System.out.println(mentoria);
		 */

		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descrição Bootcamp Java Developer");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);

		Dev devEduarda = new Dev();
		devEduarda.setNome("Eduarda");
		devEduarda.inscreverBootcamp(bootcamp);
		System.out.println("Conteudo Inscritos" + devEduarda.getConteudosInscrios());

		Dev devjoao = new Dev();
		devjoao.setNome("joão");
		devjoao.inscreverBootcamp(bootcamp);
		System.out.println("Conteudo Inscritos" + devjoao.getConteudosInscrios());

	}

}
