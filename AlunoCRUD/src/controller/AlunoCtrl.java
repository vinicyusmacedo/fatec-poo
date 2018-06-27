package controller;

import java.util.List;

import javax.swing.JOptionPane;

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
		JOptionPane.showMessageDialog(
			null, "Aluno adicionado"
		);
	}
	
	public Aluno pesquisar(String ra) {
		for (Aluno a : alunoDao.pesquisarAluno(ra)) {
			if (a.getRa().equals(ra))
				return a;
		}
		JOptionPane.showMessageDialog(
			null, "Aluno não encontrado com esse RA"
		);
		return null;
	}
	
	public void remover(String ra) {
		alunoDao.removerAluno(ra);
		JOptionPane.showMessageDialog(
			null, "Aluno removido"
		);
	}
	
	public void atualizar(Aluno a) {
		alunoDao.atualizarAluno(a);
		JOptionPane.showMessageDialog(
			null, "Aluno atualizado"
		);
	}
}
