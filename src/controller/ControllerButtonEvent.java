package controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import model.Music;
import view.PikachuBoard;

public class ControllerButtonEvent implements ActionListener, MouseListener {
	public boolean match = false;
	private Object p1;
	public PikachuBoard  btne;
	
	public ControllerButtonEvent(PikachuBoard btne) {
		this.btne = btne;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		 ((JButton)e.getSource()).setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(btne.p1 != null) {
			 btne.btn[btne.p1.x][btne.p1.y].setBorder(BorderFactory.createLineBorder(Color.RED, 4));
		} 
		((JButton)e.getSource()).setBorder(BorderFactory.createEmptyBorder());
		
	}

	@Override
    public void actionPerformed(ActionEvent e) {
		 match = false;
        String btnIndex = e.getActionCommand();
        int indexDot = btnIndex.lastIndexOf(",");
        int x = Integer.parseInt(btnIndex.substring(0, indexDot));
        int y = Integer.parseInt(btnIndex.substring(indexDot + 1,
                btnIndex.length()));
        
        
        if (btne.p1 == null) {
            btne.p1 = new Point(x, y);
            btne.btn[btne.p1.x][btne.p1.y].setBorder(BorderFactory.createLineBorder(Color.RED, 4));
        }
        else {
        	btne.p2 = new Point(x, y);
            System.out.println("(" + btne.p1.x + "," + btne.p1.y + ")" + " --> " + "("
                    + btne.p2.x + "," + btne.p2.y + ")");
            
            btne.line = btne.modelButton.checkTwoPoint(btne.p1, btne.p2);
            if (btne.line != null) {
                System.out.println("line != null");
                btne.modelButton.getMatrix()[btne.p1.x][btne.p1.y] = 0;
                btne.modelButton.getMatrix()[btne.p2.x][btne.p2.y] = 0;
                btne.modelButton.showMatrix();
                btne.execute(btne.p1, btne.p2);
                btne.line = null;
                btne.score += 10;
                btne.item--;
                btne.frame.time++;
                btne.frame.lbScore.setText(btne.score + "");
                
             // tạo một luồng mới để chơi nhạc
                Thread musicThread1 = new Thread(() -> {
                    // khởi tạo đối tượng Music
                    Music ms = new Music();
                    
                    match = true;
                    

                    	   ms.MatchButton();
                        
                });
                musicThread1.start();
                match = true;

            }
            
            btne.btn[btne.p1.x][btne.p1.y].setBorder(null);
            btne.p1 = null;
            btne.p2 = null;
            System.out.println("done");
            // tạo một luồng mới để chơi nhạc
            Thread musicThread2 = new Thread(() -> {
                // khởi tạo đối tượng Music
                Music ms = new Music();

                	   ms.NotMatchButton();
                    
            });
            if(!match) {            	
            	musicThread2.start();
            }
            match = false;
            System.out.println(match);
            
            if (btne.item == 0) {
//            	mst.interrupt();
                if (btne.frame.showDialogNewGame("You are winer!\nDo you want play again?", "Win", 1) == true) {
                };
            }
           
        }
    }


}



		
