package web.artistAndGenre.repository;

import web.artistAndGenre.controller.VoiceController;

import java.util.Map;

public class ResultGenerate implements IResultGenerate {

    @Override
    public String generateResult(boolean isCorrectVoice) {
        String INCORRECT_COUNT_GENRES = "<h1>Ваш голос не учтён, проверьте условия прохождения голосования</h1>";
        return isCorrectVoice ? createMessage() : INCORRECT_COUNT_GENRES;
    }

    private String createMessage() {
        StringBuilder builder = new StringBuilder();

        builder.append("<h2> Лучший исполнитель : </h2>");
        VoiceController.getInstance().getVoiceRepository().getArtist().entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> builder.append("<p>").append(entry).append("</p>"));
        builder.append("<h2>Любимые жанры: </h2>");

        VoiceController.getInstance().getVoiceRepository().getGenre().entrySet().stream().
                sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> builder.append("<p>").append(entry).append("</p>"));
        builder.append("<h2>Краткая информация о голосовании: </h2>");

        VoiceController.getInstance().getVoiceRepository().getText().entrySet().stream()
                .sorted(Map.Entry.<String, String>comparingByKey().reversed())
                .forEach(entry -> builder.append("<p>").append(entry).append("</p>"));
        return builder.toString();
    }
}
