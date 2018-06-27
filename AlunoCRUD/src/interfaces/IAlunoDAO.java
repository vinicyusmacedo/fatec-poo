package interfaces;

import model.Aluno;

public interface IAlunoDAO {
	
	public void adicionarAluno(Aluno a);
	public void atualizarAluno(Aluno a);
	public void pesquisarAluno(String ra);
	public void removerAluno(String ra);
	
}
