package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.AlunoCtrl;
import exceptions.EmptyRAException;
import model.Aluno;

public class AlunoView extends JFrame implements ActionListener {
	
	private JPanel painel;
	private JPanel painelCampos;
	private JPanel painelBotoes;
	
	private JButton btnAdicionar;
	private JButton btnPesquisar;
	private JButton btnAtualizar;
	private JButton btnRemover;
	private final String addString = "Adicionar";
	private final String pesqString = "Pesquisar";
	private final String remString = "Remover";
	private final String attString = "Atualizar";
	
	private JTextField txtRa;
	private JTextField txtNome;
	private JFormattedTextField txtNascimento;
	
	private AlunoCtrl alunoCtrl;
	
	private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public AlunoView() {
		setLayout();
		
		alunoCtrl = new AlunoCtrl();
		
		txtRa = new JTextField();
		txtNome = new JTextField();
		txtNascimento = new JFormattedTextField(this.dateFormat);
		
		btnAdicionar = new JButton(addString);
		btnAdicionar.addActionListener(this);
		btnPesquisar = new JButton(pesqString);
		btnPesquisar.addActionListener(this);
		btnAtualizar = new JButton(remString);
		btnAtualizar.addActionListener(this);
		btnRemover = new JButton(attString);
		btnRemover.addActionListener(this);
		
		painelCampos.add(new JLabel("RA: "));
		painelCampos.add(txtRa);
		painelCampos.add(new JLabel("Nome: "));
		painelCampos.add(txtNome);
		painelCampos.add(new JLabel("Nascimento: "));
		painelCampos.add(txtNascimento);
	}
	
	public void setLayout() {
		this.setContentPane(painel);
	}
	
	public void alunoToView(Aluno a) {
		txtRa.setText(a.getRa());
		txtNome.setText(a.getNome());
		txtNascimento.setText(
			dateFormat.format(a.getNascimento())
		);
	}
	
	public Aluno viewToAluno() throws EmptyRAException {
		Aluno a = new Aluno();
		if (txtRa.getText().isEmpty()) {
			throw new EmptyRAException(); 
		} 
		a.setRa(txtRa.getText());
		a.setNome(txtNome.getText());
		try {
			a.setNascimento(
				dateFormat.parse(txtNascimento.getText())
			);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	@Override
	public void actionPerformed (ActionEvent e ) {
		String cmd = e.getActionCommand();
		Aluno a;
		
		try {
			switch(cmd) {
			case addString:
				a = viewToAluno();
				alunoCtrl.adicionar(a);
				break;
			case pesqString:
				a = viewToAluno();
				a = alunoCtrl.pesquisar(a.getRa());
				alunoToView(a);
				break;
			case remString:
				a = viewToAluno();
				alunoCtrl.remover(a.getRa());
				break;
			case attString:
				a = viewToAluno();
				alunoCtrl.atualizar(a);
				break;
			}
		} catch (EmptyRAException e1) {
			JOptionPane.showMessageDialog(
				null, "Insira o RA."
			);
		}
	}
	
	public static void main(String[] args) {
		new AlunoView();
	}
}
