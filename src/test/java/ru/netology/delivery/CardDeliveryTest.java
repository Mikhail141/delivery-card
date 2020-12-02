package ru.netology.delivery;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;


import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;




    public class CardDeliveryTest {

        @Test

        void shouldRequest(){
            LocalDate date = new LocalDate.now();
            open( "http://localhost:9999");
            $("[data-test-id=city] input").setValue("Хабаровск");
            $("[data-test-id=date] input").setValue("11.12.2020");
            $("[data-test-id=name] input").setValue("Олегов Олег");
            $("[data-test-id=phone] input").setValue("+79999992221");
            $("[data-test-id=agreement]").click();
            $$("button").find(exactText("Забронировать")).click();
            $(withText("Успешно!")).waitUntil(visible,15000);

        }
    }