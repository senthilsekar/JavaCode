import sun.applet.Main;

class Account{
	int balance=0;
	
	public synchronized void deposit(int amount){
		balance+=amount;
		System.out.println("Amount Deposited : "+amount+"  New Balance : "+balance);
		notifyAll();
	}
	
	public synchronized void withdraw(int amount) throws InterruptedException {
		if(balance>amount){
			balance=balance-amount;
			System.out.println("Amount Withdrawn, New Balance : "+balance);
		}else{
			System.out.println("Waiting for Balance");
			wait();
			withdraw(amount);
		}
	}
}

public class AccountThreadExample {

	public static void main(String[] args) throws InterruptedException {
		final Account a1=new Account();
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				try {
					a1.withdraw(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		
		Thread t1=new Thread(r1);
		
		t1.start();
		
		Thread.sleep(2000);
		
		Runnable r2=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				a1.deposit(1000);
			}
		};
		
		Thread t2=new Thread(r2);
		
		t2.start();
	}
	
}
