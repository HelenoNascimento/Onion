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
import javax.swing.table.TableModel;

import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Jogador;

// ********************************TELA COM HISTORICO DE JOGADORES *********************

public class Tela_Historico extends JFrame {

	private JPanel contentPane;
	JogadorDAO jgdao = new JogadorDAO();
	public static ArrayList  <Jogador> array= new ArrayList();
	Jogador jg = new Jogador();
	
	private String colunas[] = {"nome", "idade", "matricula", "admitido"};
    private ArrayList<Jogador> funcionarios;
    private final int COLUNA_NOME = 0;
    private final int COLUNA_IDADE = 1;
    private final int COLUNA_MATRICULA = 2;
    private final int COLUNA_ADMITIDO = 3;
	private ArrayList<Jogador> Jogador;
	private JTable table;
	// Here is to load the TableModel
	String[] columnName = {"Code", "Title", "Artist", "Price"};
	DefaultTableModel dtm = new DefaultTableModel(columnName, 0);
	//ArrayList<MusicEdit> musiclist= new  ArrayList<MusicEdit>();
    public void FuncionarioTableModel(ArrayList<Jogador> jogadores) {
        this.Jogador = jogadores;
    }

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
		renderizarTela();
		//jgdao.ListarJogadores();
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
		
		
		table.setBounds(44, 79, 377, 144);
		contentPane.add(table);
	}
	
private void renderizarTela() {
        
        //4 ojetos criados para popular a tabela
        Jogador j1 = new Jogador();
        Jogador j2 = new Jogador();
        Jogador j3 = new Jogador();
        Jogador j4 = new Jogador();
        j1.setCod_jogador(1);
        j1.setNome("pedro");
        j1.setEmail("aaaaaa");
        j1.setIdade("20");
        j1.setPontuacao(100);

        j2.setCod_jogador(1);
        j2.setNome("pedro");
        j2.setEmail("aaaaaa");
        j2.setIdade("20");
        j2.setPontuacao(100);
        
        j3.setCod_jogador(1);
        j3.setNome("pedro");
        j3.setEmail("aaaaaa");
        j3.setIdade("20");
        j3.setPontuacao(100);
        
        j4.setCod_jogador(1);
        j4.setNome("pedro");
        j4.setEmail("aaaaaa");
        j4.setIdade("20");
        j4.setPontuacao(100);
        ArrayList<Jogador> jogadores = new ArrayList<>();
        jogadores.add(j1);
        jogadores.add(j2);
        jogadores.add(j3);
        jogadores.add(j4);
       
   	 DefaultTableModel modelo  = (DefaultTableModel) table.getModel();
   	 table.getColumnModel().getColumn(0).setPreferredWidth(20);
   	 table.getColumnModel().getColumn(1).setPreferredWidth(80);
   	 table.getColumnModel().getColumn(2).setPreferredWidth(20);
   	 
        modelo.addColumn("teste");
        modelo.addColumn("aaa");
       // if (jogadores.isEmpty()) {
       // 	modelo.addRow(new String [] {"sem informacao"});
      //  }else {
        	//for (int i =0;i< jogadores.size(); i++) {
        		//modelo.addRow(new String [] {String.valueOf(i),jogadores.get(i)});
        	//	modelo.addRow(new Object[] {
        				//jogadores.get(i);
        		//});
        		
       	
        
        
        /*for (Object s : jogadores) {
        	dtm.addRow( (Object[]) s);
        	}

        	table.setModel(dtm);
        	}
*/
        	//public DisplayMusicCD() {

        	//initComponents();
        	//loadAll();
        
    	//table.setSelectionModel(jogadores);
        //cria um objeto do nosso model
        //
        //DefaultTableModel modelo = (DefaultTableModel)table.getModel();
        //instancia a tabela já com o model como argumento
        //this.table = new JTable(modelo);
       // this.scrollPainel = new JScrollPane(table);

     //   this.add(scrollPainel);
    //    this.pack();
     //  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
