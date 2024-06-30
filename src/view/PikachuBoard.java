/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Date;

import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ControllerButtonEvent;
import model.MainGame.MusicThread;
import model.ModelButton;
import model.Music;
import model.PointLine;

/**
 *
 * @author DuyDL2
 */
public class PikachuBoard extends JPanel  {

    public static final long serialVersionUID = 1L;
    public int row;
    public int col;
    public int bound = 4;
    public int size = 50;
    public JButton[][] btn;
    public int score = 0;
    public Point p1 = null;
    public Point p2 = null;
    public int item;
    public PointLine line;
    public ModelButton modelButton;
    public PikachuGUI frame;
    public Color backGroundColor = Color.lightGray;
    public MusicThread mst;
    public ControllerButtonEvent ac = null;


    public PikachuBoard(PikachuGUI frame, int row, int col, int size, MusicThread mst) {
        this.frame = frame;
        this.row = row + 2;
        this.col = col + 2;
        this.size = size;
        this.mst = mst;
        item = row * col / 2;

        
        ac = new ControllerButtonEvent(this);
        
        
        setLayout(new GridLayout(row, col, bound, bound));
        setBackground(new Color(0, 0, 0, 0));
        setPreferredSize(new Dimension((size + bound) * col, (size + bound)
                * row));
        setBorder(new EmptyBorder(10, 10, 10, 10));

//        setAlignmentY(JPanel.CENTER_ALIGNMENT);
        
        newGame();

    }

    public void newGame() {
        modelButton = new ModelButton(this.frame, this.row, this.col);
        addArrayButton();

    }

    private void addArrayButton() {
        btn = new JButton[row][col];
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                btn[i][j] = createButton(i + "," + j);
                Icon icon = getIcon(modelButton.getMatrix()[i][j]);
                btn[i][j].setIcon(icon);
                add(btn[i][j]);
            }
        }
    }
    

    private Icon getIcon(int index) {
    	
        Image image = new ImageIcon(getClass().getResource(
                "/icon/" + index + ".png")).getImage();
        
        Icon icon = new ImageIcon(image.getScaledInstance(size, size,
                image.SCALE_SMOOTH));      
        return icon;

    }

    private JButton createButton(String action) {
        JButton btn = new JButton();
        btn.setActionCommand(action);
        btn.setBorder(null);
        btn.addActionListener(ac);
        btn.addMouseListener(ac);
        return btn;
    }

    public void execute(Point p1, Point p2) {
        System.out.println("delete");
        setDisable(btn[p1.x][p1.y]);
        setDisable(btn[p2.x][p2.y]);
    }

//    private void setDisable(JButton btn) {
//    	btn.setIcon(null);
//    	 btn.setBackground(new Color(0, 0, 0, 0));
//        btn.setOpaque(false);
//        btn.setEnabled(false);
//    }
//    
    
    public void setDisable(JButton btn) {
    	 ImageIcon imageIcon = new ImageIcon("..//imageBackground//pngegg.png");
         // Lấy Image từ ImageIcon
      
    	 btn.setOpaque(false);
         btn.setContentAreaFilled(false);
         btn.setBorderPainted(false);
         // Đặt màu chữ của JButton là trắng
         btn.setForeground(Color.WHITE);
         btn.setOpaque(false);
       btn.setEnabled(false);
    }


    
}



