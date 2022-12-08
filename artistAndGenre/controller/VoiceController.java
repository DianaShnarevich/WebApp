package web.artistAndGenre.controller;

import web.artistAndGenre.repository.IResultGenerate;
import web.artistAndGenre.repository.ResultGenerate;
import web.artistAndGenre.repository.IVoiceRepository;
import web.artistAndGenre.repository.VoiceRepository;

import javax.servlet.http.HttpServletRequest;

public class VoiceController implements IVoiceController {
    private static volatile VoiceController instance;
    private final IVoiceRepository voiceRepository;
    private final IResultGenerate resultGenerator;

    private VoiceController() {
        resultGenerator = new ResultGenerate();
        voiceRepository = new VoiceRepository();
    }

    public static VoiceController getInstance() {
        VoiceController result = instance;
        if (result != null) {
            return result;
        }
        synchronized (VoiceController.class) {
            if (instance == null) {
                instance = new VoiceController();
            }
            return instance;
        }
    }

    @Override
    public boolean vote(HttpServletRequest req) {
        return voiceRepository.vote(req);
    }

    @Override
    public String getResult(boolean isCorrectVoice) {
        return resultGenerator.generateResult(isCorrectVoice);
    }

    @Override
    public IVoiceRepository getVoiceRepository() {
        return voiceRepository;
    }
}
