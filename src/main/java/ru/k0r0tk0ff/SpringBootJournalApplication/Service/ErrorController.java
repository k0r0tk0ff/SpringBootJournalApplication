package ru.k0r0tk0ff.SpringBootJournalApplication.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.k0r0tk0ff.SpringBootJournalApplication.Models.ErrorInfo;

/**
 * Created by k0r0tk0ff on 10/1/2017.
 *
 * Добавляем обработку ошибок
 * Класс необходим для отображения информации об ошибках программ
 * в web интерфейсе
 */


@ControllerAdvice
public class ErrorController {

    private Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorInfo processException(Exception e) {
        logger.error("Unexpected error", e);
        return new ErrorInfo(e.getMessage());
    }
}
