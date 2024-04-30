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

@WebServlet("/GetStationsController")
public class GetStationsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		PrintWriter pw = res.getWriter();
		GetStationsDAL obj = new GetStationsDAL();
		List<Stations> stations = obj.getStations();
		Gson gson = new Gson();
		String json = gson.toJson(stations);
		pw.println(json);
		pw.close();
	}
}
