/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.sound.sampled.Clip;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;
//import sun.audio.ContinuousAudioDataStream;

import controller.ControllerHome;
import controller.ControllerOption;
import model.Music;
//import model.MusicThread;
import model.MainGame.MusicThread;


/**
 *
 * @author DuyDL2
 */
public class PikachuGUI extends JFrame implements  Runnable {

    private int maxTime;
    public int time = maxTime;
    private JProgressBar progressTime;
    public JLabel lbScore;
    public JButton btnNewGame;
    private PikachuBoard graphicsPanel;
    private JPanel mainPanel;
    public JPopupMenu jPopupMenu;
    public long currentPosition;
    private int row = 10;
    private int col = 15;
    private int width = 1000;
    private int height = 700;
    public boolean isMusic = true;
    public int size;


    
    
    private URL imagePath = PikachuGUI.class.getResource("..//imageBackground//backgroungPikachu.jpg");

    private boolean pause = false;
    private boolean resume = false;

	private MusicThread mst;


    public PikachuGUI(int time, int row, int col,int size, MusicThread mst) {
    	
    	this.maxTime = time;
    	this.time = time;
    	this.row = row;
    	this.col = col;
    	this.size = size;
    	this.mst = mst;
    	

    	this.setJMenuBar(createMenuBar());
        this.add(mainPanel = createMainPanel());
        
        
        
        setTitle("Pokemon Game");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        
        
        setVisible(true);
    }
    

    public JPanel createMainPanel() {

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createGraphicsPanel(), BorderLayout.CENTER);
        panel.add(createControlPanel(), BorderLayout.NORTH);
        panel.add(createStatusPanel(), BorderLayout.PAGE_END);
        return panel;
    }

    
    public JPanel createGraphicsPanel() {

        
        graphicsPanel = new PikachuBoard(this, row, col, size, mst);

        // Tạo ImageIcon từ đường dẫn file ảnh
        ImageIcon imageIcon = new ImageIcon(imagePath);
        // Lấy Image từ ImageIcon
        Image image = imageIcon.getImage();

        // Tạo JPanel với hình ảnh nền trong suốt
        JPanel panel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Vẽ hình ảnh từ đường dẫn file ảnh
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                // Đặt độ trong suốt cho nền của JPanel
                setOpaque(false);
            }
        };
//        graphicsPanel.
        panel.add(graphicsPanel);
        return panel;
    }

    private JPanel createControlPanel() {
        lbScore = new JLabel("0");
        progressTime = new JProgressBar(0, 100);
        progressTime.setValue(100);

        // create panel container score and time
        JPanel panelLeft = new JPanel(new GridLayout(1, 2, 5, 5));
        panelLeft.add(new JLabel("Score:"));
        panelLeft.add(lbScore);

        JPanel panelCenter = new JPanel(new GridLayout(1, 2, 5, 5));
        panelCenter.add(progressTime);
        JPanel panelScoreAndTime = new JPanel(new BorderLayout(10,10));
        panelScoreAndTime.add(panelLeft, BorderLayout.WEST);
        panelScoreAndTime.add(panelCenter, BorderLayout.CENTER);

        // create panel container panelScoreAndTime 
        JPanel panelControl = new JPanel(new BorderLayout(10, 10));
        panelControl.setBorder(new EmptyBorder(10, 3, 5, 3));
        panelControl.add(panelScoreAndTime, BorderLayout.CENTER);

      
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("Status"));
        panel.add(panelControl, BorderLayout.PAGE_START);

        return panel;
    }

    // create status panel container author
    private JPanel createStatusPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.setBackground(Color.lightGray);

        return panel;
    }

    // create a button
    private JButton createButton(String buttonName) {
    	ActionListener acg = new ControllerOption(this);
        JButton btn = new JButton(buttonName);
        btn.addActionListener(acg);
        return btn;
    }
    
    // create menu
    private JMenuBar createMenuBar() {
    	// Tạo thanh menu
    			JMenuBar jMenuBar = new JMenuBar();
    			ActionListener acg = new ControllerOption(this);
    			
    			// Tạo 1 menu
    			JMenu jMenu_file = new JMenu("Option");
    			jMenu_file.setMnemonic(KeyEvent.VK_F);
    			jMenu_file.setDisplayedMnemonicIndex(0);
    			
    			// Tạo các menu con
    			JMenuItem jMenuItem_new = new JMenuItem("New Game", KeyEvent.VK_N);
    			jMenuItem_new.addActionListener(acg);
    			jMenuItem_new.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
    		
    			JMenuItem jMenuItem_save = new JMenuItem("MUsic", KeyEvent.VK_S);
    			jMenuItem_save.addActionListener(acg);
    			jMenuItem_save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
    			
    			JMenuItem jMenuItem_home = new JMenuItem("Go Home", KeyEvent.VK_H);
    			jMenuItem_home.addActionListener(acg);
    			jMenuItem_home.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
    			
    			JMenuItem jMenuItem_exit = new JMenuItem("Exit", KeyEvent.VK_X);
    			jMenuItem_exit.addActionListener(acg);
    			jMenuItem_exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));
    			
    			
    			jMenu_file.add(jMenuItem_new);
    			jMenu_file.add(jMenuItem_save);
    			jMenu_file.add(jMenuItem_home);
    			jMenu_file.addSeparator();
    			jMenu_file.add(jMenuItem_exit);
    			
    			
    			JMenu jMenu_help = new JMenu("Help");
    			jMenu_help.setMnemonic(KeyEvent.VK_L);
    			jMenu_help.setDisplayedMnemonicIndex(0);
    			
    			JMenuItem jMenuItem_welcome = new JMenuItem("Welcome");
    			jMenu_help.add(jMenuItem_welcome);
    			
    			jMenuBar.add(jMenu_file);
    			jMenuBar.add(jMenu_help);
    			
    			return jMenuBar;
    			
    }
    


    public void newGame() {
        time = maxTime;
        graphicsPanel.removeAll();
        mainPanel.add(createGraphicsPanel(), BorderLayout.CENTER);
        mainPanel.validate();
        mainPanel.setVisible(true);
        lbScore.setText("0");
    }
    
    
    
//    public Image getBackgroundImage() {
//        // Tạo ImageIcon từ đường dẫn file ảnh
//        ImageIcon imageIcon = new ImageIcon("..//imageBackground//pngegg.png");
//        // Lấy Image từ ImageIcon
//        Image image = imageIcon.getImage();
//        return image;
//    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progressTime.setValue((int) ((double) time / maxTime * 100));
        }
    }

    public JProgressBar getProgressTime() {
        return progressTime;
    }

    public void setProgressTime(JProgressBar progressTime) {
        this.progressTime = progressTime;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public boolean isResume() {
        return resume;
    }

    public void setResume(boolean resume) {
        this.resume = resume;
    }

    public boolean showDialogNewGame(String message, String title, int t) {
        pause = true;
        resume = false;
       
        mst.ms.pauseMusic();
        long currentPosition = mst.ms.getMicrosecondPosition();
        mst.ms.setMicrosecondPosition(currentPosition); 
        
        
        if(t == 1 && title.equals("Win")) {
        	mst.ms.stopMusic(); 
        	 Thread musicThread2 = new Thread(() -> {
                 // khởi tạo đối tượng Music
                 Music ms = new Music();  
                 	   ms.winnerGame();           
             });
        	 musicThread2.start();
        }
        if(t == 1 && title.equals("Lose")) {
        	mst.ms.stopMusic(); 
        	 Thread musicThread2 = new Thread(() -> {
                 // khởi tạo đối tượng Music
                 Music ms = new Music();
                	   ms.lostGame();    
             });
        	 musicThread2.start();
        }  
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                null, null);
        if (select == 0 ) {
            pause = false;
            mst.interrupt();
            newGame();
            return true;
        } else {
            if (t == 1) {
                System.exit(0);
//                mst.ms.stopMusic();
                return false;
            } else {

            	mst.ms.resumeMusic();
                resume = true;
                return true;
            }
        }
    }
    
    
    public boolean showDialogHome(String message, String title) {
        pause = true;
        resume = false;
        mst.ms.pauseMusic();
        long currentPosition = mst.ms.getMicrosecondPosition();
        mst.ms.setMicrosecondPosition(currentPosition);
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                null, null);
        if (select == 0 ) {
            pause = true;
            resume = false;
            mst.ms.stopMusic();
            this.setVisible(false);
        	new PikachuHome();
            return true;
        } else {
           
            	mst.ms.resumeMusic();
                resume = true;
                return true;
            
        }
    }
    
    public boolean showDialogExit(String message, String title) {
        pause = true;
        resume = false;
//        ap.stop(as);
        mst.ms.pauseMusic();
        long currentPosition = mst.ms.getMicrosecondPosition();
        mst.ms.setMicrosecondPosition(currentPosition);
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                null, null);
        if (select == 0 ) {
            pause = false;
            mst.ms.stopMusic();
            System.exit(0);
        	 return false;
        } else {
           
            	mst.ms.resumeMusic();
                resume = true;
                return true;
            
        }
    }
    
    public boolean showDialogSaveGame(String message, String title) {
        pause = true;
        resume = false;
        mst.ms.pauseMusic();
        long currentPosition = mst.ms.getMicrosecondPosition();
        mst.ms.setMicrosecondPosition(currentPosition);
        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                null, null);
        if (select == 0 ) {
        	 resume = true;
           if(isMusic) {
//        	   mst.ms.pauseMusic();
//                currentPosition = mst.ms.getMicrosecondPosition();
//               mst.ms.setMicrosecondPosition(currentPosition);
               isMusic = false;
           } else {
        	   mst.ms.resumeMusic();
        	   isMusic = true;
           }
        	 return false;
        } else {
           
                resume = true;
                return true;
            
        }
    }
    
   
}


    

