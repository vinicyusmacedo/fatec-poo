package controller;

import java.util.List;
import java.util.ArrayList;

import dao.AlunoDAO;
import model.Aluno;

public class AlunoCtrl {
	
	private AlunoDAO alunoDao;
	
	public AlunoCtrl () {
		alunoDao = new AlunoDAO();
	}

	public void adicionar(Aluno a) {
		alunoDao.adicionarAluno(a);
	}
	
	public Aluno pesquisar(String ra) {
		List<Aluno> alunoList = alunoDao.listarAlunos();
		for (Aluno a : alunoList) {
			if (a.getRa().equals(ra)) {
				return a;
			}
		}
		return new Aluno();
	}
	
	public void remover(String ra) {
		alunoDao.removeAluno(ra);
	}
	
	public void atualizar(Aluno a) {
		alunoDao.atualizarAluno(a);
	}
}
