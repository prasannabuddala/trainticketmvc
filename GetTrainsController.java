package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetTrainsController
 */
@WebServlet("/GetTrainsController")
public class GetTrainsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		PrintWriter pw = res.getWriter();
		String from = req.getParameter("fromm");
		String to = req.getParameter("too");
		GetStationsDAL gsd = new GetStationsDAL();
		List<Trains> trainsList = gsd.getTrains(from, to);
		Gson gson = new Gson();
		String json = gson.toJson(trainsList);
		pw.println(json);
	}
}
