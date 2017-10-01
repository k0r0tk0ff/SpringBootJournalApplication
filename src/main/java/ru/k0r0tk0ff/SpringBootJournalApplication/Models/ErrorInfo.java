package ru.k0r0tk0ff.SpringBootJournalApplication.Models;

/**
 * Created by user on 10/1/2017.
 * модель, необходимая для правильного построения сообщения об ошибке
 */
public class ErrorInfo {

    private String message;

    public ErrorInfo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
