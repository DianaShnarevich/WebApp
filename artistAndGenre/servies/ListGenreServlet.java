package web.artistAndGenre.servies;

import web.artistAndGenre.dao.IDao;
import web.artistAndGenre.dao.Dao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="ListGenreServlet", urlPatterns = "/genre")

public class ListGenreServlet extends HttpServlet {
    private final IDao dao = new Dao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<html><h1>Rock<br>" +
                    "Pop<br>" +
                    "Jazz<br>" +
                    "Hip-hopz<br>" +
                    "Opera<br>" +
                    "Classical<br>" +
                    "Reggae<br>" +
                    "Rap<br>" +
                    "Folk<br>" +
                    "Alternative</h1></html>");
        }
    }
}
