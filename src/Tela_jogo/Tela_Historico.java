package Tela_jogo;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Jogador;

// ********************************TELA COM HISTORICO DE JOGADORES *********************

public class Tela_Historico extends JFrame {

	private JPanel contentPane;
	public static JTable table;
	JogadorDAO jgdao = new JogadorDAO();
	public static ArrayList  <Jogador> array= new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Tela_Historico frame = new Tela_Historico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_Historico() {
		jgdao.ListarJogadores();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltitulo = new JLabel("Historico");
		lbltitulo.setFont(new Font("Verdana", Font.PLAIN, 19));
		lbltitulo.setBounds(117, 21, 109, 43);
		contentPane.add(lbltitulo);
		
		table = new JTable();
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		Jogador jg = new Jogador();
		table.setModel(modelo);
		//table.setValueAt(array.get(4).getCod_jogador(), 4, 0);  
		// table.setValueAt(array.get(4).getNome(), 4, 1);
	    //   array.add(jgdao.ListarJogadores());
		
		table.setBounds(48, 85, 395, 149);
		contentPane.add(table);
	}
}
