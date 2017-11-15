package org.example;


import java.net.URISyntaxException;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class RunBoth {

	private static String PRODUCE = "produce";
	private static String CONSUME = "consume";
		
	public static void main(String[] args) throws URISyntaxException, Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"ApplicationContext.xml");
		
		RunBoth runboth = new RunBoth();
		System.out.println("About to start producer, consumer");		
		Runner producer = runboth.new Runner(context, PRODUCE);
		Runner consumer = runboth.new Runner(context, CONSUME);
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		producerThread.start();
		consumerThread.start();
		producerThread.join();
		consumerThread.join();
		System.out.println("Main exits");		
	}
	

	
	class Runner implements Runnable{
		
		private String task;
		private ClassPathXmlApplicationContext context = null;
		
		Runner(ClassPathXmlApplicationContext context, String task){
			this.context = context;
			this.task = task;
		}

		public void run() {
			try {
				if (PRODUCE == task) {
					SpringJmsProducer springJmsProducer = 
							(SpringJmsProducer) context.getBean("springJmsProducer");
					long kount = 0;
					System.out.println("About to start produce loop");
					while (true) {
						System.out.println("Produce loop about to send.");
						String msg = ("SomeTask " + kount++);
						springJmsProducer.sendMessage(msg);
						System.out.println("Just sent " + msg);
						Thread.sleep(2000);
					}
				}else if (CONSUME == task) {
					SpringJmsConsumer springJmsConsumer = 
							(SpringJmsConsumer) context.getBean("springJmsConsumer");
							System.out.println("About to start consume loop");
					while (true) {
						System.out.println("Consumer just recieved:" + springJmsConsumer.receiveMessage());	
					}

				}
				System.out.println("Done!");
		}catch(Exception e) {
			System.out.println("Exception! " + e.getMessage());
		}
		
		}
	}

	
	
}