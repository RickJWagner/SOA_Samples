package org.amq.utilities;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CFTest")
public class CFTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CFTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		sendMsg();
		out.println("<h1>" + "HELLO" + "</h1>");
	}

	private void sendMsg() {

		//String destinationName = "queue/***REMOVED***orks.KPI.service.in";
		String destinationName = "amq:/Queue/***REMOVED***orks.KPI.service.in";
		Context ic = null;
		ConnectionFactory cf = null;
		Connection connection = null;

		try {
			ic = new InitialContext();
			cf = (ConnectionFactory) ic.lookup("java:/jms/CF");
			Queue queue = (Queue) ic.lookup(destinationName);
			connection = cf.createConnection();
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			MessageProducer publisher = session.createProducer(queue);
			connection.start();

			TextMessage message = session.createTextMessage("TestMSG");
			publisher.send(message);
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
