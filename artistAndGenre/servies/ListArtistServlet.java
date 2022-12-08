package web.artistAndGenre.servies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="ListArtistServlet", urlPatterns = "/artist")

public class ListArtistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<html><h2>Get Scared<br>" +
                    "Metallica<br>" +
                    "Three Days Grace<br>" +
                    "Korol i Shut</h2></html>");
        }
    }
}
