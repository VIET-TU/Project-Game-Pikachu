package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.MainGame;
import view.PikachuHome;

public class ControllerHome implements ActionListener{
   private PikachuHome pkc;
   public int time ;
   public int row;
   public int col ;
   public int size ;
	public ControllerHome(PikachuHome pkc) {
	this.pkc = pkc;
}

	@Override
	public void actionPerformed(ActionEvent e) {
    	String ac=e.getActionCommand();
    	if (ac.equals("Bắt Đầu")) {
    		
            String dokho = "";
            if (this.pkc.jRadioButton_de.isSelected()) {
            	time = 300;
                dokho = "Dễ";
            } else if (this.pkc.jRadioButton_trungbinh.isSelected()) {
            	time = 200;
            	dokho = "Trung Bình";
            } else if (this.pkc.jRadioButton_kho.isSelected()) {
            	time = 100;
            	dokho = "Khó";
            } else {
                JOptionPane.showMessageDialog(this.pkc, "Vui lòng chọn một mức độ khó khăn.");
                return;
            }
            
            if (this.pkc.jRadioButton_1015.isSelected()) {
            	row = 10;
            	col = 15;
            	size = 50;
            	
            }else if (this.pkc.jRadioButton_1010.isSelected()) {
            	row = 10;
            	col = 10;
            	size = 50;
            } else if (this.pkc.jRadioButton_510.isSelected()) {
            	row = 5;
            	col = 10;
            	size = 60;
            	
            } else if (this.pkc.jRadioButton_56.isSelected()) {
            	row = 5;
            	col = 6;
            	size = 70;
            } else {
                JOptionPane.showMessageDialog(this.pkc, "Vui lòng chọn  Lưới.");
                return;
            }
            
            
            JOptionPane.showMessageDialog(this.pkc, "Bắt đầu trò chơi với mức độ khó: " + dokho + " và có " + row + " hàng "+ col + " cột");
            pkc.setVisible(false);
            new MainGame(time, row, col,size);
        }
    	
    	else if (ac.equals("Hướng Dẫn")) {
            // Show game guide
            JOptionPane.showMessageDialog(this.pkc, "Chào mừng bạn đến với Trò chơi Pikachu!"
            		+ "\nĐể chơi trò chơi, hãy nhấp vào hai ô giống hệt nhau để xóa chúng khỏi bảng. Mục tiêu là xóa tất cả các ô trước khi hết thời gian. "
            		+ "\nChúc bạn may mắn và vui vẻ!");
        } else if (ac.equals("Thoát")) {
            // Quit the game
            int option = JOptionPane.showConfirmDialog(this.pkc, 
            		"Bạn có chắc chắn muốn thoát khỏi trò chơi không?", "Thoát khỏi trò chơi", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

}
