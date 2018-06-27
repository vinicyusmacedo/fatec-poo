package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import exceptions.EmptyRAException;
import interfaces.IAlunoDAO;
import model.Aluno;

public class AlunoDAO implements IAlunoDAO {

	private final Connection dbConnection = DatabaseConnection.getConnection();

	@Override
	public void adicionarAluno(Aluno a) {
		String sql = "INSERT INTO aluno (ra, nome, nascimento) "
				+ "VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = dbConnection.prepareStatement(sql);
			stmt.setString(1, a.getRa());
			stmt.setString(2, a.getNome());
			System.out.println(a.getNascimento());
			System.out.println(new java.sql.Date(a.getNascimento().getTime()));
			stmt.setDate(
				3, new java.sql.Date(
					a.getNascimento().getDate()
				)	
			);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizarAluno(Aluno a) {
		String sql = "UPDATE aluno SET ra = ?, nome = ?, nascimento = ? "
				+ "WHERE ra = ?";
		try {
			PreparedStatement stmt = dbConnection.prepareStatement(sql);
			stmt.setString(1, a.getRa());
			stmt.setString(2, a.getNome());
			stmt.setDate(
				3, new java.sql.Date(
					a.getNascimento().getDate()
				)
			);
			stmt.setString(4, a.getRa());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Aluno> pesquisarAluno(String ra) {
		String sql = "SELECT * FROM aluno WHERE ra = ?";
		List<Aluno> alunoList = null;
		try {
			PreparedStatement stmt = dbConnection.prepareStatement(sql);
			stmt.setString(1, ra);
			ResultSet rs = stmt.executeQuery();
			alunoList = new ArrayList<>();
	
			while (rs.next()) {
				try {
					alunoList.add(
						new Aluno(
							rs.getString("ra"),
							rs.getString("nome"),
							rs.getDate("nascimento")
						)
					);
				} catch (EmptyRAException e) {
					System.out.println("[ERROR] AlunoDAO.pesquisarAluno - found user without RA on database!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunoList;
	}

	@Override
	public void removerAluno(String ra) {
		String sql = "DELETE FROM aluno WHERE ra = ? ";
		try {
			PreparedStatement stmt = dbConnection.prepareStatement(sql);
			stmt.setString(1, ra);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
