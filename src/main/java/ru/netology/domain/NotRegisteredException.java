package ru.netology.domain;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Игрок с именем " + name + " не зарегистрирован. Он не сможет участвовать в турнире.");
    }
}
