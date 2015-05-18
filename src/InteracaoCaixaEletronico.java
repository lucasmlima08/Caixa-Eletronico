package caixaEletronico;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InteracaoCaixaEletronico extends JPanel {

	public String telaAtual = "login";
	
	CardLayout cards = new CardLayout();
	
	JTextField entradaLogin = new JTextField();
	JPasswordField entradaSenha = new JPasswordField();
	JTextField saqueValor = new JTextField();
	JTextField saldoValor = new JTextField();
	JTextField depositoValor = new JTextField();
	JTextField transferenciaConta = new JTextField();
	JTextField transferenciaValor = new JTextField();
	
	public InteracaoCaixaEletronico() {
	
		setLayout(cards);
		
		limparEntradas();
		add(login(), "login");
		add(menu(), "menu");
		add(saque(), "saque");
		add(saldo(), "saldo");
		add(cartoes(), "cartoes");
		add(deposito(), "deposito");
		add(emprestimos(), "emprestimos");
		add(transferencia(), "transferencia");
		cards.show(this, "login");
		setVisible(true);
	}
	
	public JPanel login() {
	
		JPanel login = new JPanel(null);
		login.setBackground(Color.WHITE);
		
		JLabel boasVindas = new JLabel();
		boasVindas.setIcon(new ImageIcon("bin\\imagens\\boasVindas.png"));
		boasVindas.setBounds(65, 5, 600, 100);
		login.add(boasVindas);
		
		entradaLogin.setBorder(BorderFactory.createTitledBorder("Login"));
		entradaLogin.setHorizontalAlignment(JTextField.CENTER);
		entradaLogin.setBounds(180,110,200,50);
		entradaLogin.setText("");
		login.add(entradaLogin);
		
		entradaSenha.setBorder(BorderFactory.createTitledBorder("Senha"));
		entradaSenha.setHorizontalAlignment(JTextField.CENTER);
		entradaSenha.setBounds(180,190,200,50);
		entradaSenha.setText("");
		login.add(entradaSenha);
		
		JLabel aceitar = new JLabel();
		aceitar.setIcon(new ImageIcon("bin\\imagens\\aceitar.png"));
		aceitar.setBounds(30,320,220,65);
		login.add(aceitar);
		
		JLabel sair = new JLabel();
		sair.setIcon(new ImageIcon("bin\\imagens\\cancelar.png"));
		sair.setBounds(330,320,220,65);
		login.add(sair);
		
		return (login);
	}
	
	public JPanel menu() {
	
		JPanel menu = new JPanel(null);
		menu.setBackground(Color.WHITE);
		
		JLabel saques = new JLabel();
		saques.setIcon(new ImageIcon("bin\\imagens\\saque.png"));
		saques.setBounds(30,45,220,65);
		menu.add(saques);
		
		JLabel saldo = new JLabel();
		saldo.setIcon(new ImageIcon("bin\\imagens\\saldo.png"));
		saldo.setBounds(30,140,220,65);
		menu.add(saldo);
		
		JLabel cartoes = new JLabel();
		cartoes.setIcon(new ImageIcon("bin\\imagens\\cartoes.png"));
		cartoes.setBounds(30,230,220,65);
		menu.add(cartoes);
		
		JLabel outros = new JLabel();
		outros.setIcon(new ImageIcon("bin\\imagens\\outros.png"));
		outros.setBounds(30,320,220,65);
		menu.add(outros);
		
		JLabel depositos = new JLabel();
		depositos.setIcon(new ImageIcon("bin\\imagens\\deposito.png"));
		depositos.setBounds(330,45,220,65);
		menu.add(depositos);
		
		JLabel emprestimos = new JLabel();
		emprestimos.setIcon(new ImageIcon("bin\\imagens\\emprestimos.png"));
		emprestimos.setBounds(330,140,220,65);
		menu.add(emprestimos);
		
		JLabel transferencias = new JLabel();
		transferencias.setIcon(new ImageIcon("bin\\imagens\\transferencia.png"));
		transferencias.setBounds(330,230,220,65);
		menu.add(transferencias);
		
		JLabel cancelar = new JLabel();
		cancelar.setIcon(new ImageIcon("bin\\imagens\\sair.png"));
		cancelar.setBounds(330,320,220,65);
		menu.add(cancelar);
		
		return (menu);
	}
	
	public JPanel saque() {
	
		JPanel saque = new JPanel(null);
		saque.setBackground(Color.WHITE);
		
		saqueValor.setBorder(BorderFactory.createTitledBorder("Valor do Saque"));
		saqueValor.setHorizontalAlignment(JTextField.CENTER);
		saqueValor.setBounds(180,110,200,50);
		saqueValor.setText("");
		saque.add(saqueValor);
		
		JLabel aceitar = new JLabel();
		aceitar.setIcon(new ImageIcon("bin\\imagens\\sacar.png"));
		aceitar.setBounds(30,320,220,65);
		saque.add(aceitar);
		
		JLabel cancelar = new JLabel();
		cancelar.setIcon(new ImageIcon("bin\\imagens\\voltar.png"));
		cancelar.setBounds(330,320,220,65);
		saque.add(cancelar);

		return (saque);
	}
	
	public JPanel saldo() {
	
		JPanel saldo = new JPanel(null);
		saldoValor.setEditable(false);
		saldo.setBackground(Color.WHITE);
		
		saldoValor.setBorder(BorderFactory.createTitledBorder("Saldo Disponível"));
		saldoValor.setHorizontalAlignment(JTextField.CENTER);
		saldoValor.setBounds(180,110,200,50);
		saldoValor.setText("");
		saldo.add(saldoValor);
		
		JLabel sacar = new JLabel();
		sacar.setIcon(new ImageIcon("bin\\imagens\\sacar.png"));
		sacar.setBounds(30,320,220,65);
		saldo.add(sacar);
		
		JLabel cancelar = new JLabel();
		cancelar.setIcon(new ImageIcon("bin\\imagens\\voltar.png"));
		cancelar.setBounds(330,320,220,65);
		saldo.add(cancelar);
		
		return (saldo);
	}
	
	public JPanel cartoes() {
	
		JPanel cartoes = new JPanel(null);
		cartoes.setBackground(Color.WHITE);
		return (cartoes);
	}
	
	public JPanel deposito() {
	
		JPanel deposito = new JPanel(null);
		deposito.setBackground(Color.WHITE);
		
		depositoValor.setBorder(BorderFactory.createTitledBorder("Valor do Depósito"));
		depositoValor.setHorizontalAlignment(JTextField.CENTER);
		depositoValor.setBounds(180,110,200,50);
		depositoValor.setText("");
		deposito.add(depositoValor);
		
		JLabel aceitar = new JLabel();
		aceitar.setIcon(new ImageIcon("bin\\imagens\\depositar.png"));
		aceitar.setBounds(30,320,220,65);
		deposito.add(aceitar);
		
		JLabel cancelar = new JLabel();
		cancelar.setIcon(new ImageIcon("bin\\imagens\\voltar.png"));
		cancelar.setBounds(330,320,220,65);
		deposito.add(cancelar);
		
		return (deposito);
	}
	
	public JPanel emprestimos() {
	
		JPanel emprestimos = new JPanel(null);
		emprestimos.setBackground(Color.WHITE);
		
		return (emprestimos);
	}
	
	public JPanel transferencia() {
	
		JPanel transferencia = new JPanel(null);
		transferencia.setBackground(Color.WHITE);
		
		transferenciaValor.setBorder(BorderFactory.createTitledBorder("Valor da Transferência"));
		transferenciaValor.setHorizontalAlignment(JTextField.CENTER);
		transferenciaValor.setBounds(180,110,200,50);
		transferenciaValor.setText("");
		transferencia.add(transferenciaValor);
		
		transferenciaConta.setBorder(BorderFactory.createTitledBorder("CPF do Receptor"));
		transferenciaConta.setHorizontalAlignment(JTextField.CENTER);
		transferenciaConta.setBounds(180,190,200,50);
		transferenciaConta.setText("");
		transferencia.add(transferenciaConta);
		
		JLabel aceitar = new JLabel();
		aceitar.setIcon(new ImageIcon("bin\\imagens\\transferir.png"));
		aceitar.setBounds(30,320,220,65);
		transferencia.add(aceitar);
		
		JLabel cancelar = new JLabel();
		cancelar.setIcon(new ImageIcon("bin\\imagens\\voltar.png"));
		cancelar.setBounds(330,320,220,65);
		transferencia.add(cancelar);
		
		return (transferencia);
	}
	
	public void limparEntradas() {
	
		entradaLogin.setText("");
		entradaSenha.setText("");
		saqueValor.setText("0.00");
		saldoValor.setText("0.0");
		depositoValor.setText("0.00");
		transferenciaConta.setText("0.00");
		transferenciaValor.setText("0");
	}
}
