package ExampleHilo3;

public class Proceso extends Thread{
	
	
	public void run() {
		for(int i=0 ; i<=5 ; i++) {
			System.out.println(i);
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
