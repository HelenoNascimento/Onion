package Tela_jogo;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controler.Pontuacao;
import java.awt.Color;

public class Tela_Pontos extends JFrame {
	Pontuacao pts = new Pontuacao();
	private JPanel contentPane;
	public static JLabel facil = new JLabel("");
	public static JLabel normal = new JLabel("");
	public static JLabel dificil = new JLabel("");
	public static JLabel hardcore = new JLabel("");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Pontos frame = new Tela_Pontos();
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
	public Tela_Pontos() {
		pts.SomaPonto("a", 1);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblpontos = new JLabel("PONTOS");
		lblpontos.setFont(new Font("Verdana", Font.PLAIN, 30));
		lblpontos.setBounds(89, 21, 191, 38);
		contentPane.add(lblpontos);
		
		JLabel lblpontofacil = new JLabel("Facil");
		lblpontofacil.setForeground(Color.GREEN);
		lblpontofacil.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblpontofacil.setBounds(41, 96, 75, 20);
		contentPane.add(lblpontofacil);
		
		JLabel lblpontonormla = new JLabel("Normal");
		lblpontonormla.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblpontonormla.setBounds(41, 127, 75, 20);
		contentPane.add(lblpontonormla);
		
		JLabel lblpontosdificil = new JLabel("Dificil");
		lblpontosdificil.setForeground(new Color(255, 140, 0));
		lblpontosdificil.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblpontosdificil.setBounds(41, 158, 75, 20);
		contentPane.add(lblpontosdificil);
		
		JLabel lblpontoshardcore = new JLabel("Hardcore");
		lblpontoshardcore.setForeground(new Color(255, 0, 0));
		lblpontoshardcore.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblpontoshardcore.setBounds(41, 189, 75, 20);
		contentPane.add(lblpontoshardcore);
		
		
		facil.setFont(new Font("Verdana", Font.PLAIN, 15));
		facil.setBounds(150, 101, 81, 15);
		contentPane.add(facil);
		
		
		normal.setFont(new Font("Verdana", Font.PLAIN, 15));
		normal.setBounds(150, 132, 81, 15);
		
		contentPane.add(normal);

		dificil.setFont(new Font("Verdana", Font.PLAIN, 15));
		dificil.setBounds(150, 163, 81, 15);
		contentPane.add(dificil);
		
		
		hardcore.setFont(new Font("Verdana", Font.PLAIN, 15));
		hardcore.setBounds(150, 194, 81, 15);
		contentPane.add(hardcore);
		
		JLabel descri = new JLabel("Cada acerto vale");
		descri.setFont(new Font("Verdana", Font.PLAIN, 13));
		descri.setBounds(41, 70, 133, 14);
		contentPane.add(descri);
	}
}
