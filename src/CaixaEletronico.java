package caixaEletronico;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;

public class CaixaEletronico extends JFrame implements ActionListener {

	InteracaoCaixaEletronico telaInterativa = new InteracaoCaixaEletronico();
	ConexaoBancoDeDados conexao = new ConexaoBancoDeDados();
	
	JButton botao1 = new JButton("");
	JButton botao2 = new JButton("");
	JButton botao3 = new JButton("");
	JButton botao4 = new JButton("");
	JButton botao5 = new JButton("");
	JButton botao6 = new JButton("");
	JButton botao7 = new JButton("");
	JButton botao8 = new JButton("");
	
	public double SALDO;
	
	public static void main(String[] args) {
	
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		caixaEletronico.setTitle("Caixa Eletrônico");
		caixaEletronico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		caixaEletronico.setLocationRelativeTo(null);
		caixaEletronico.setResizable(false);
		caixaEletronico.setVisible(true);
	}

	public CaixaEletronico() {
	
		setSize(900,600);
		setLayout(null);
		
		telaInterativa.setBackground(Color.WHITE);
		telaInterativa.setLocation(155, 141);
		telaInterativa.setSize(585, 429);
		
		add(telaInterativa);
		add(titulo());
		add(painelDaEsquerda());
		add(painelDaDireita());
	}
	
	public JPanel titulo() {
	
		JPanel titulo = new JPanel(null);
		titulo.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 0, 0)));
		
		JLabel tituloBackground = new JLabel();
		tituloBackground.setIcon(new ImageIcon("bin\\imagens\\titulo.png"));
		tituloBackground.setHorizontalAlignment(SwingConstants.CENTER);
		tituloBackground.setOpaque(true);
		tituloBackground.setBounds(0, 0, 585, 141);
		titulo.setLocation(155, 0);
		titulo.setSize(585, 141);
		
		titulo.add(tituloBackground);
		return (titulo);
	}
	
	public JPanel painelDaEsquerda() {
	
		JPanel botoesEsquerda = new JPanel(null);
		botoesEsquerda.setBackground(SystemColor.activeCaption);
		botoesEsquerda.setLocation(0, 0);
		botoesEsquerda.setSize(156, 570);
		
		botao1.setBounds(33, 180, 90, 62);
		botao1.addActionListener(this);
		botoesEsquerda.add(botao1);
		
		botao2.setBounds(33, 275, 90, 62);
		botao2.addActionListener(this);
		botoesEsquerda.add(botao2);
		
		botao3.setBounds(33, 370, 90, 62);
		botao3.addActionListener(this);
		botoesEsquerda.add(botao3);
		
		botao4.setBounds(33, 465, 90, 62);
		botao4.addActionListener(this);
		botoesEsquerda.add(botao4);
		return (botoesEsquerda);
	}
	
	public JPanel painelDaDireita() {
	
		JPanel botoesDireita = new JPanel(null);
		botoesDireita.setBackground(SystemColor.activeCaption);
		botoesDireita.setLocation(739, 0);
		botoesDireita.setSize(156, 570);
		
		botao5.setBounds(33, 180, 90, 62);
		botao5.addActionListener(this);
		botoesDireita.add(botao5);
		
		botao6.setBounds(33, 275, 90, 62);
		botao6.addActionListener(this);
		botoesDireita.add(botao6);
		
		botao7.setBounds(33, 370, 90, 62);
		botao7.addActionListener(this);
		botoesDireita.add(botao7);
		
		botao8.setBounds(33, 465, 90, 62);
		botao8.addActionListener(this);
		botoesDireita.add(botao8);
		return (botoesDireita);
	}
	
	public void actionPerformed(ActionEvent e) {
	
		Object clicou = e.getSource();
		
		if (clicou.equals(botao1)) {
		
			if (telaInterativa.telaAtual.equals("menu")) {
			
				telaInterativa.cards.show(telaInterativa, "saque");
				telaInterativa.telaAtual = "saque";
			}
			
		} else if (clicou.equals(botao2)) {
		
			if (telaInterativa.telaAtual.equals("menu")) {
				
				SALDO = conexao.SALDO;
				DecimalFormat df = new DecimalFormat("#,###.00");
				telaInterativa.saldoValor.setText("" + df.format(SALDO));
				telaInterativa.cards.show(telaInterativa, "saldo");
				telaInterativa.telaAtual = "saldo";
			}
			
		} else if (clicou.equals(botao4)) {
		
			if (telaInterativa.telaAtual.equals("login")) {
			
				String login = telaInterativa.entradaLogin.getText();
				String senha = String.valueOf(telaInterativa.entradaSenha.getPassword());
				
				if (conexao.conectar(login, senha) == 1) {
				
					SALDO = conexao.SALDO;
					telaInterativa.cards.show(telaInterativa, "menu");
					telaInterativa.telaAtual = "menu";
				}
				telaInterativa.limparEntradas();
				
			} else if (telaInterativa.telaAtual.equals("saque")) {
				
				double valorDoSaque = Double.parseDouble(telaInterativa.saqueValor.getText());
				conexao.sacar(valorDoSaque);
				SALDO = conexao.SALDO;
				
				telaInterativa.cards.show(telaInterativa, "menu");
				telaInterativa.telaAtual = "menu";
				telaInterativa.limparEntradas();
				
			} else if (telaInterativa.telaAtual.equals("saldo")) {
			
				telaInterativa.cards.show(telaInterativa, "saque");
				telaInterativa.telaAtual = "saque";
				
			} else if (telaInterativa.telaAtual.equals("deposito")) {
				
				double deposito = Double.parseDouble(telaInterativa.depositoValor.getText());
				conexao.depositar(deposito);
				SALDO = conexao.SALDO;
			
				telaInterativa.cards.show(telaInterativa, "menu");
				telaInterativa.telaAtual = "menu";
				telaInterativa.limparEntradas();
				
			} else if (telaInterativa.telaAtual.equals("transferencia")) {
			
				double transferencia = Double.parseDouble(telaInterativa.transferenciaValor.getText());
				int cpf = Integer.parseInt(telaInterativa.transferenciaConta.getText());
				
				conexao.transferir(cpf, transferencia);
				
				telaInterativa.cards.show(telaInterativa, "menu");
				telaInterativa.telaAtual = "menu";
				telaInterativa.limparEntradas();
			}
			
		} else if (clicou.equals(botao5)) {
		
			if (telaInterativa.telaAtual.equals("menu")) {
			
				telaInterativa.cards.show(telaInterativa, "deposito");
				telaInterativa.telaAtual = "deposito";
			}
			
		} else if (clicou.equals(botao7)) {
		
			if (telaInterativa.telaAtual.equals("menu")) {
			
				telaInterativa.cards.show(telaInterativa, "transferencia");
				telaInterativa.telaAtual = "transferencia";
			}
			
		} else if (clicou.equals(botao8)) {
		
			if (telaInterativa.telaAtual.equals("login")) {
			
				telaInterativa.cards.show(telaInterativa, "menu");
				telaInterativa.telaAtual = "menu";
				System.exit(1);
				
			} else if (telaInterativa.telaAtual.equals("menu")) {
			
				telaInterativa.cards.show(telaInterativa, "login");
				telaInterativa.telaAtual = "login";
				ConexaoBancoDeDados conexao = new ConexaoBancoDeDados();
				conexao.desconectar();
				
			} else if (telaInterativa.telaAtual.equals("saque")) {
			
				telaInterativa.cards.show(telaInterativa, "menu");
				telaInterativa.telaAtual = "menu";
				telaInterativa.limparEntradas();
				
			} else if (telaInterativa.telaAtual.equals("saldo")) {
			
				telaInterativa.cards.show(telaInterativa, "menu");
				telaInterativa.telaAtual = "menu";
				telaInterativa.limparEntradas();
				
			} else if (telaInterativa.telaAtual.equals("deposito")) {
			
				telaInterativa.cards.show(telaInterativa, "menu");
				telaInterativa.telaAtual = "menu";
				telaInterativa.limparEntradas();
				
			} else if (telaInterativa.telaAtual.equals("transferencia")) {
			
				telaInterativa.cards.show(telaInterativa, "menu");
				telaInterativa.telaAtual = "menu";
				telaInterativa.limparEntradas();
			}
		}
	}
}
