package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PikachuGUI;

public class ControllerOption implements ActionListener {
	
	public PikachuGUI pg;
	
	public ControllerOption(PikachuGUI pg) {
		this.pg = pg;
	}
	

	   @Override
	    public void actionPerformed(ActionEvent e) {
	    	String button = e.getActionCommand();
	        if (e.getSource() == pg.btnNewGame || button.equals("New Game")) {
	            pg.showDialogNewGame("Your game hasn't done. Do you want to create a new game?", "Warning", 0);
	        }
	        
	        else if(button.equals("MUsic")) {
	        	String s = (pg.isMusic ? "pause music" : "resume music "+ "?");
	        	pg.showDialogSaveGame("Do you want " + s + "?", "Warning");
	        } else if(button.equals("Exit")) {
	        	
	        	pg.showDialogExit("Do you want exit game ?","Warning");
	        } else if(button.equals("Go Home")) {
	        	
	        	pg.showDialogHome("Do you want Go HOme","Warnning");
	        
	        }
	    }
}
