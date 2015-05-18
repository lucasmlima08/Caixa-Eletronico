package caixaEletronico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ConexaoBancoDeDados {

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String servidor = "jdbc:mysql://localhost:1313/caixaeletronico";
	private static final String login = "root";
	private static final String senha = "root";
	
	public int ID;
	public int CPF;
	public String LOGIN;
	public String SENHA;
	public double SALDO;
	
	private Connection conexao;
	
	public int conectar(String loginCliente, String senhaCliente) {
	
		try {
		
			Class.forName(driver);
			conexao = DriverManager.getConnection(servidor, login, senha);
			Statement stmt = (Statement) conexao.createStatement();
			String select = "select ID, CPF, LOGIN, SENHA, SALDO from caixaeletronico where LOGIN='"+loginCliente+"' and SENHA='"+senhaCliente+"'";
			ResultSet rs = stmt.executeQuery(select);
			
			if (rs.next()) {
				ID = rs.getInt("ID");
				CPF = rs.getInt("CPF");
				LOGIN = rs.getString("LOGIN");
				SENHA = rs.getString("SENHA");
				SALDO = rs.getDouble("SALDO");
				return (1);
			
			} else {
			
				JOptionPane.showMessageDialog(null, "DADOS INCORRETOS!");
			}
			return (0);
			
		} catch (ClassNotFoundException e) {
		
			JOptionPane.showMessageDialog(null, "PROBLEMA NO DRIVER DE CONEXÃO!");
		
		} catch (SQLException e) {
		
			JOptionPane.showMessageDialog(null, "PROBLEMA NO SERVIDOR!");
		}
		return (0);
	}
	
	public void saldo() {
		try {
			String select = "select SALDO from caixaeletronico where CPF='"+CPF+"'";
			Statement stmt = (Statement) conexao.createStatement();
			ResultSet rs = stmt.executeQuery(select);
			
			if (rs.next()) {
			
				SALDO = rs.getDouble("SALDO");
			}
		
		} catch (Exception e) {}
	}
	
	public void sacar(double saque) {
	
		try {
		
			if (saque > SALDO) {
				
				JOptionPane.showMessageDialog(null, "SALDO INDISPONÍVEL!");
				
			} else {
				
				String update = "update caixaeletronico set SALDO = ? where CPF = ?";
				PreparedStatement pstmt = (PreparedStatement) conexao.prepareStatement(update);
				pstmt.setDouble(1, SALDO - saque);
				pstmt.setInt(2, CPF);
				pstmt.executeUpdate();
				saldo();
				pstmt.close();
			}
			
		} catch(Exception e) {}
	}
	
	public void depositar(double deposito) {
	
		try {

			String update = "update caixaeletronico set SALDO = ? where CPF = ?";
			PreparedStatement pstmt = (PreparedStatement) conexao.prepareStatement(update);
			pstmt.setDouble(1, SALDO + deposito);
			pstmt.setInt(2, CPF);
			pstmt.executeUpdate();
			saldo();
			pstmt.close();
			
		} catch(Exception e) {}
	}
	
	public void transferir(int cpf, double transferencia) {
	
		if (transferencia > SALDO) {
		
			JOptionPane.showMessageDialog(null, "SEU SALDO NÃO PERMITE ESSA TRANSFERÊNCIA!");
		
		} else {
			
			try {
			
				Statement stmt = (Statement) conexao.createStatement();
				ResultSet rs = stmt.executeQuery("select SALDO from caixaeletronico where CPF='" + cpf + "'");
				
				if (rs.next()) {
				
					PreparedStatement pstmt;
					String update;
					
					double saldoDoRecebedor = rs.getDouble("SALDO");
					update = "update caixaeletronico set SALDO = ? where CPF = ?";
					pstmt = (PreparedStatement) conexao.prepareStatement(update);
					pstmt.setDouble(1, saldoDoRecebedor + transferencia);
					pstmt.setInt(2, cpf);
					pstmt.executeUpdate();
					pstmt.close();
					
					update = "update caixaeletronico set SALDO = ? where CPF = ?";
					pstmt = (PreparedStatement) conexao.prepareStatement(update);
					pstmt.setDouble(1, SALDO - transferencia);
					pstmt.setInt(2, CPF);
					pstmt.executeUpdate();
					saldo();
					pstmt.close();

				} else {
				
					JOptionPane.showMessageDialog(null, "CPF NÃO CADASTRADO!");
				}
				
			} catch(Exception e) {
			
				JOptionPane.showMessageDialog(null, "ERRO NO SERVIDOR!");
			}
		}
	}
	
	public void desconectar() {
	
		try {
		
			conexao.close();
			
		} catch (Exception e) {}
	}
}
