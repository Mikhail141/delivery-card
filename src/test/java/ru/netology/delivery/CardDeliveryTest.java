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

        void shouldRequest(){
            open( "http://localhost:9999");
            $("[data-test-id=city] input").setValue("Хабаровск");
            $(date.format(DateTimeFormatter.ofPattern("19::20::2020")));
            $("[data-test-id=name] input").setValue("Олегов Олег");
            $("[data-test-id=phone] input").setValue("+79999992221");
            $("[data-test-id=agreement]").click();
            $$("button").find(exactText("Забронировать")).click();
            $(withText("Успешно!")).waitUntil(visible,15000);

        }
    }