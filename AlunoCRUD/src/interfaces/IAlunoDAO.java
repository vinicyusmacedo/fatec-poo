package interfaces;

import java.util.List;

import model.Aluno;

public interface IAlunoDAO {
	
	public void adicionarAluno(Aluno a);
	public void atualizarAluno(Aluno a);
	public List<Aluno> pesquisarAluno(String ra);
	public void removerAluno(String ra);
	
}
