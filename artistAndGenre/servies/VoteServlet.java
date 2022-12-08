package web.artistAndGenre.servies;

import web.artistAndGenre.controller.VoiceController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "VoteServlet", urlPatterns = "/vote")

public class VoteServlet extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        VoiceController voiceController = VoiceController.getInstance();
        boolean isCorrectVoice = voiceController.vote(req);
        String message = voiceController.getResult(isCorrectVoice);

        try (PrintWriter writer = resp.getWriter()) {
            writer.write(message);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        doGet(req, resp);
    }
}
