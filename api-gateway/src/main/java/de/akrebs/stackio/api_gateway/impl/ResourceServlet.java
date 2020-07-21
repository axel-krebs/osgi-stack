package de.akrebs.stackio.api_gateway.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

public class ResourceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private String ID;

    public ResourceServlet(String iD) {
	super();
	ID = iD;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	AsyncContext asyncCtx = req.startAsync();
	PrintWriter writer = asyncCtx.getResponse().getWriter();
	writer.write("Hallo from ResourceServlet, ID: " + ID);
	writer.flush();
	asyncCtx.addListener(new AsyncListener() {

	    @Override
	    public void onTimeout(AsyncEvent event) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Timeout!");
	    }

	    @Override
	    public void onStartAsync(AsyncEvent event) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Starting async!");
	    }

	    @Override
	    public void onError(AsyncEvent event) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Error!");
	    }

	    @Override
	    public void onComplete(AsyncEvent event) throws IOException {
		System.out.println("COMPLETE!");
	    }
	}, req, resp);
	asyncCtx.complete();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	AsyncContext asyncCtx = req.startAsync();
	PrintWriter writer = asyncCtx.getResponse().getWriter();
	asyncCtx.addListener(new AsyncListener() {

	    @Override
	    public void onTimeout(AsyncEvent event) throws IOException {
		writer.write("Timeout!");
		writer.flush();
	    }

	    @Override
	    public void onStartAsync(AsyncEvent event) throws IOException {
		// TODO Auto-generated method stub
		writer.write("Starting async..");
		writer.flush();
	    }

	    @Override
	    public void onError(AsyncEvent event) throws IOException {
		writer.write("ERROR!");
		writer.flush();
	    }

	    @Override
	    public void onComplete(AsyncEvent event) throws IOException {
		writer.write("COMPLETE!");
		writer.flush();
	    }
	});
	writer.write("Hallo from ResourceServlet, ID: " + ID);
	StringBuffer sb = new StringBuffer();
	sb.append("\nContent-Type:" + req.getContentType());
	sb.append("\nThe input: " + String.valueOf(req.getParameterValues("the_input")));
	writer.write(sb.toString());
	writer.flush();
	asyncCtx.complete();
    }

}
