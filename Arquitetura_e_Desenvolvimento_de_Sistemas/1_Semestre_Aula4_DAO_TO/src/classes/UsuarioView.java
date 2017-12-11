package classes;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UsuarioView extends JFrame{
	Container cont;
	String usuarioConsultaAtual[] = new String[3];
	String id;
	ArrayList<Usuario_TO> usuarios = new ArrayList<>();
	int linha = 0;
	
	public UsuarioView(){
		super("Cadastrar Usuario");
		cont = getContentPane();
		Tela();
	}
	
	public void Tela() {
		linha = 0;
		cont.removeAll();
		cont.setLayout(new BorderLayout());
		JLabel lmensagemItem = new JLabel("Cadastrar Usuário", SwingConstants.CENTER);
		lmensagemItem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lnome = new JLabel("Nome:");
		JLabel lsenha = new JLabel("Senha:");
		JTextField tnome = new JTextField();
		JTextField tsenha = new JTextField();
		
		JButton criar = new JButton("Criar");
		criar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			if(tnome.getText().isEmpty() || tnome.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "O campo nome não pode ficar vazio");
			
			}else if(tsenha.getText().isEmpty() || tsenha.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "O campo senha não pode ficar vazio");
								
			}else {
				Usuario_Negocio n = new Usuario_Negocio();
				String a = n.criar(tnome.getText(), tsenha.getText());
				if(a.equals("-1") == false) { 
					JOptionPane.showMessageDialog(null, "Usuário "+tnome.getText()+" criado com sucesso!\n Id do usuário: "+a);
					tnome.setText("");
					tsenha.setText("");
				}
			}
		}
		});
		
		JButton alterar = new JButton ("Realizar Alteração");
		JButton excluir = new JButton ("Excluir");
		JButton voltar = new JButton ("Voltar");
		JButton proximo = new JButton (">");
		JButton anterior = new JButton ("<");
		
		excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				Usuario_Negocio u = new Usuario_Negocio();
				
				if(u.excluir(id) == true) { 
					JOptionPane.showMessageDialog(null, "Usuário "+tnome.getText()+" deletado com sucesso!");
					Tela();
					repaint();
				}
			}
		});
		
		alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			if(tnome.getText().isEmpty() || tnome.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "O campo nome não pode ficar vazio");
			
			}else if(tsenha.getText().isEmpty() || tsenha.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "O campo senha não pode ficar vazio");
								
			}else {
				Usuario_Negocio u = new Usuario_Negocio();
				
				if(u.alterar(id, tnome.getText(), tsenha.getText()) == true) { 
					JOptionPane.showMessageDialog(null, "Usuário "+tnome.getText()+" alterado com sucesso!");
					Tela();
					repaint();
				}
			}
			}
		});
		
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Tela();
				repaint();
			}
		});
		
		anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(linha-1 < 0) {
					
					JOptionPane.showMessageDialog(null, "Não existem usuários anteriores a este.");
			
				}else {
					linha--;
					id = usuarios.get(linha).getId();
					tnome.setText(usuarios.get(linha).getNome());
					tsenha.setText(usuarios.get(linha).getSenha());
					repaint();
				
				}
			}
		});
		
		proximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				if(linha+1 == usuarios.size()) {
					
					JOptionPane.showMessageDialog(null, "Não existem outros usuários após este.");
			
				}else {
					linha++;
					id = usuarios.get(linha).getId();
					tnome.setText(usuarios.get(linha).getNome());
					tsenha.setText(usuarios.get(linha).getSenha());
					repaint();
				
				}
		
			}
		});
		
		JPanel panel = new JPanel(new GridLayout(2,2,2,2));
		panel.add(lnome);
		panel.add(lsenha);
		panel.add(tnome);
		panel.add(tsenha);
		
		JButton consultar = new JButton("Consultar");
		consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				Usuario_DAO usuario = new Usuario_DAO();
				usuarios = usuario.consultar();
				if(usuarios.size()<1) {
					JOptionPane.showMessageDialog(null, "Não existe nenhum usuário cadastrado");
				}else {
					
					id = usuarios.get(linha).getId();
					tnome.setText(usuarios.get(linha).getNome());
					tsenha.setText(usuarios.get(linha).getSenha());
					
					cont.removeAll();
					cont.setLayout(new BorderLayout());
					cont.add(lmensagemItem, BorderLayout.NORTH);
					cont.add(panel, BorderLayout.CENTER);
					
					JPanel botoes = new JPanel(new GridLayout(1,2,2,2)); 
					botoes.add(alterar);
					botoes.add(excluir);
					botoes.add(voltar);
					
					JPanel jproximo = new JPanel(new GridLayout(2,1,2,2));
					JLabel fachadaproximo = new JLabel(" ");
					jproximo.add(fachadaproximo);
					jproximo.add(proximo);
					
					JPanel janterior = new JPanel(new GridLayout(2,1,2,2));
					JLabel fachadaanterior = new JLabel(" ");
					janterior.add(fachadaanterior);
					janterior.add(anterior);
					
					cont.add(botoes, BorderLayout.SOUTH);
					cont.add(jproximo, BorderLayout.EAST);
					cont.add(janterior, BorderLayout.WEST);
					
					setSize(700,170);
					setLocation(300,300);	
					setVisible(true);
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					repaint();
					
				}
			}
		});
		
				
		
		
		JPanel panelBotoes = new JPanel(new GridLayout(1,2,2,2));
		panelBotoes.add(criar);
		panelBotoes.add(consultar);
		
		cont.add(lmensagemItem, BorderLayout.NORTH);
		cont.add(panel, BorderLayout.CENTER);
		cont.add(panelBotoes, BorderLayout.SOUTH);
		setSize(700,170);
		setLocation(300,300);	
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		repaint();
	}
}
