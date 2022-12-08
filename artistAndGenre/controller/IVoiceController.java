package web.artistAndGenre.controller;

import web.artistAndGenre.repository.IVoiceRepository;

import javax.servlet.http.HttpServletRequest;

public interface IVoiceController {
    boolean vote(HttpServletRequest req);
    String getResult(boolean isCorrectVoice);
    IVoiceRepository getVoiceRepository();
}
