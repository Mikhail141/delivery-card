package ru.netology.delivery;
import org.junit.jupiter.api.Test;


import  java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
    LocalDate date = LocalDate.now();


    @Test
    void shouldRequest() {
        LocalDate date = LocalDate.now();
        date = date.plusDays(3);

        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Казань");
        $("[data-test-id=date] input").setValue(date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        $("[data-test-id=name] input").setValue("Олегов Олег");
        $("[data-test-id=phone] input").setValue("+79999992221");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).waitUntil(visible, 15000);

    }
}