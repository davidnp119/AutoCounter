package main.java;


public class Common {

	public static boolean SPAM_STARTED = false;
	private static int SPAM_NUMBER = 0;

	public static void type(int loops, int initial, final int delay){
		SPAM_NUMBER = 0;
		boolean infinite = false;
		if (loops == 0){
			loops = 100; 
			infinite = true;
		}
		try {
			typeT(loops, initial, delay, infinite);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void typeT(final int loops, int initial, final int delay, final boolean infinite) throws Exception{
    	final ManualTyper keyboard = new ManualTyper();
    	SPAM_STARTED = true; 
		ManualTyper.robot.delay(initial);
		Runnable r = new Runnable(){
			@Override
			public void run() {
				for(int X = 0; X < loops; X++){  
					if (infinite) X=0;
					SPAM_NUMBER++;
					if (SPAM_STARTED){
						keyboard.type(SPAM_NUMBER+"");
						ManualTyper.sendEnter();
					}else{
						break;
					}
					ManualTyper.robot.delay(delay);    		
				}
				SPAM_STARTED = false;
				CountingAutoTyper.updateVariable(false);
			}
		};	
		Thread d = new Thread(r);
		d.start();
    }
}
