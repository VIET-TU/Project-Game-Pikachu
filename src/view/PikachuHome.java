package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import controller.ControllerHome;


public class PikachuHome extends JFrame  {

   
    public JRadioButton jRadioButton_de;
    public JRadioButton jRadioButton_trungbinh;
    public JRadioButton jRadioButton_kho;
    public int width = 1000;
    public int height = 700;
	public JRadioButton jRadioButton_1015;
	public JRadioButton jRadioButton_510;
	public JRadioButton jRadioButton_56;
	public JRadioButton jRadioButton_1010; 
	private ButtonGroup buttonGroup2;
	private URL backgroundImage;


    public PikachuHome() {
    	
        setTitle("Pikachu Game");
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        URL url_image = PikachuHome.class.getResource("..//imageBackground//pikachu-icon.png");
        Image image = Toolkit.getDefaultToolkit().createImage(url_image);
        this.setIconImage(image);
        
        
        backgroundImage = PikachuHome.class.getResource("..//imageBackground//backgroungPikachu.jpg");
		// Tạo ImageIcon từ đường dẫn file ảnh
		ImageIcon imageIcon = new ImageIcon(backgroundImage);
		// Lấy Image từ ImageIcon
		Image image1 = imageIcon.getImage();

		// Tạo JPanel với hình ảnh nền trong suốt
		JPanel panelMain = new JPanel(new BorderLayout()) {
		    @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        // Vẽ hình ảnh từ đường dẫn file ảnh
		        g.drawImage(image1, 0, 0, width, height, this);
		        // Đặt độ trong suốt cho nền của JPanel
		        setOpaque(false);
		    }
		};

        Color pikachuColor = new Color(255, 204, 51);
//        Color backgroundColor = new Color(247, 247, 247);

        JPanel backgroundPanel = new JPanel();
        Font font = new Font("Arial", Font.BOLD, 48);
        JLabel jLabel = new JLabel("PIKACHU GAME", SwingConstants.CENTER);
        jLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(PikachuHome.class.getResource("..//imageBackground//pikachu.png"))));
        jLabel.setFont(font);
        jLabel.setForeground(pikachuColor);
        jLabel.setBounds((getWidth() - 500) / 2, 50, 500, 50);
        backgroundPanel.setBackground(new Color(0,0,0,0));
        backgroundPanel.setOpaque(false);

        ActionListener ac = new ControllerHome(this);
        JButton jButton_start = new JButton("Bắt Đầu");
        jButton_start.addActionListener(ac);
        jButton_start.setBackground(pikachuColor);
        jButton_start.setForeground(Color.WHITE);
        Font font2 = new Font("Arial", Font.PLAIN, 24);
        jButton_start.setFont(font2);
        jButton_start.setBounds((getWidth() - 200) / 2, 350, 200, 50);


        JLabel mucdo = new JLabel("Mức Độ:");
        mucdo.setFont(font2);
        jRadioButton_de = new JRadioButton("Dễ");
        jRadioButton_de.setOpaque(false);
        jRadioButton_de.setFont(font2);
        jRadioButton_trungbinh = new JRadioButton("Trung Bình");
        jRadioButton_trungbinh.setOpaque(false);
        jRadioButton_trungbinh.setFont(font2);
        jRadioButton_kho = new JRadioButton("Khó");
        jRadioButton_kho.setOpaque(false);
        jRadioButton_kho.setFont(font2);
        jRadioButton_de.addActionListener(ac);
        jRadioButton_trungbinh.addActionListener(ac);
        jRadioButton_kho.addActionListener(ac);
        mucdo.setOpaque(false);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton_de);
        buttonGroup.add(jRadioButton_trungbinh);
        buttonGroup.add(jRadioButton_kho);
        JPanel radioPanel = new JPanel(new FlowLayout());
        radioPanel.add(mucdo);
        radioPanel.add(jRadioButton_de);
        radioPanel.add(jRadioButton_trungbinh);
        radioPanel.add(jRadioButton_kho);
        radioPanel.setOpaque(false);

        
        /////////
        
        JLabel col_row = new JLabel("Lưới:");
        col_row.setFont(font2);
      jRadioButton_1015 = new JRadioButton("10x15");
        jRadioButton_1015.setFont(font2);
        jRadioButton_1015.setOpaque(false);
        jRadioButton_1010 = new JRadioButton("10x10");
        jRadioButton_1010.setFont(font2);
        jRadioButton_1010.setOpaque(false);
        jRadioButton_510 = new JRadioButton("5x10");
        jRadioButton_510.setFont(font2);
        jRadioButton_510.setOpaque(false);
     jRadioButton_56 = new JRadioButton("5x6");
        jRadioButton_56.setFont(font2);
        jRadioButton_56.setOpaque(false);
        jRadioButton_1015.addActionListener(ac);
        jRadioButton_1010.addActionListener(ac);
        jRadioButton_510.addActionListener(ac);
        jRadioButton_56.addActionListener(ac);

         buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(jRadioButton_1015);
        buttonGroup2.add(jRadioButton_1010);
        buttonGroup2.add(jRadioButton_510);
        buttonGroup2.add(jRadioButton_56);
        JPanel radioPanel2 = new JPanel(new FlowLayout());
        radioPanel2.add(col_row);
        radioPanel2.add(jRadioButton_1015);
        radioPanel2.add(jRadioButton_1010);
        radioPanel2.add(jRadioButton_510);
        radioPanel2.add(jRadioButton_56);
        
        radioPanel2.setOpaque(false);
        
        
        ///////
        JPanel main_radio_btn = new JPanel(new BorderLayout());
        main_radio_btn.add(radioPanel, BorderLayout.NORTH);
        main_radio_btn.add(radioPanel2, BorderLayout.CENTER);
        main_radio_btn.setBorder(BorderFactory.createCompoundBorder(
        	    BorderFactory.createEmptyBorder(40, 0, 0, 0), 
        	    main_radio_btn.getBorder()));


        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());
        JButton jButton_huongdan = new JButton("Hướng Dẫn");
        jButton_huongdan.addActionListener(ac);
        jButton_huongdan.setFont(font2);
        jPanel_south.setOpaque(false);

        jPanel_south.add(jButton_huongdan);
        JButton jButton_thoat = new JButton("Thoát");
        jButton_thoat.addActionListener(ac);
        jButton_thoat.setFont(font2);

        jPanel_south.add(jButton_thoat);
        jPanel_south.setBounds((getWidth() - 200) / 2, 0, 250, 250);
        this.setLayout(new BorderLayout());
        panelMain.add(jLabel,BorderLayout.NORTH);
        jLabel.setOpaque(false);
        panelMain.add(jButton_start,BorderLayout.CENTER);
        jButton_start.setOpaque(false);
        panelMain.add(main_radio_btn,BorderLayout.CENTER);
        main_radio_btn.setOpaque(false);
        panelMain.add(jPanel_south, BorderLayout.SOUTH);
        jPanel_south.setOpaque(false);
        
//       this.add(jLabel,BorderLayout.NORTH);
//       this.add(jButton_start,BorderLayout.CENTER);
//       this.add(main_radio_btn,BorderLayout.CENTER);
       
       
       this.add(panelMain);
      

       
        setVisible(true);
    }
    
}