
package model;

import javax.sound.sampled.Clip;

import view.PikachuGUI;

public class MainGame {
	int time;
	int col;
	int row;
	int size;
	public MusicThread mst;

    PikachuGUI frame;
    Music ms = new Music();
	private Clip musicClip;


    public MainGame(int time, int row, int col, int size) {
    	this.time = time;
    	this.col = col;
    	this.row = row;
    	this.size = size;
    	MusicThread mst = new MusicThread();
    	mst.start();
        frame = new PikachuGUI(time,row,col,size,mst);
        MyTimeCount timeCount = new MyTimeCount();
        timeCount.start();
        new Thread(frame).start();
    }
    


	public class MusicThread extends Thread {
        public  Music ms;
        public Clip musicClip;

        public void run() {
            // khởi tạo đối tượng Music
            ms = new Music();

            // chơi nhạc và lặp lại khi nhạc kết thúc
            while (true) {
                musicClip = ms.startMusic();
                while (musicClip.isRunning()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }







	public static void main(String[] args) {
		new MainGame(5,10,10,50);
	}

    	class MyTimeCount extends Thread {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (frame.isPause()) {
                        if (frame.isResume()) {
                            frame.time--;
                        }
                    } else {
                        frame.time--;
                    }
                    if (frame.time == 10) {

                    }
                    if (frame.time == 0) {
//
                        frame.showDialogNewGame(
                                "Full time\nDo you want play again?", "Lose", 1);

                        
                    }
                }
            }
        }
    
}