package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
	private String nome;
	private Set<Conteudo> conteudosInscrios = new LinkedHashSet<>();
	private Set<Conteudo> conteudoConcluidos = new LinkedHashSet<>();

	public void inscreverBootcamp(Bootcamp bootcamp) {
		this.conteudoConcluidos.addAll(bootcamp.getConteudos());
		bootcamp.getDevsInscritos().add(this);
	}

	public void progredir() {
		Optional<Conteudo> conteudo = this.conteudosInscrios.stream().findFirst();
		if (conteudo.isPresent()) {
			this.conteudoConcluidos.add(conteudo.get());
			this.conteudoConcluidos.remove(conteudo.get());

		} else {
			System.err.println("Você não está matriculado em nenhum conteudo!");
		}

	}

	public double calcularTotalXp() {
		return this.conteudoConcluidos.stream().mapToDouble(Conteudo::calcularXP).sum();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conteudo> getConteudosInscrios() {
		return conteudosInscrios;
	}

	public void setConteudosInscrios(Set<Conteudo> conteudosInscrios) {
		this.conteudosInscrios = conteudosInscrios;
	}

	public Set<Conteudo> getConteudoConcluido() {
		return getConteudoConcluido();
	}

	public void setConteudoConcluido(Set<Conteudo> conteudoConcluido) {
		this.conteudoConcluidos = conteudoConcluido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudoConcluidos, conteudosInscrios, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		return Objects.equals(conteudoConcluidos, other.conteudoConcluidos)
				&& Objects.equals(conteudosInscrios, other.conteudosInscrios) && Objects.equals(nome, other.nome);
	}

}
