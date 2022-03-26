package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();
    private Player player1 = new Player(1, "Karl", 10);
    private Player player2 = new Player(2, "Klara", 20);
    private Player player3 = new Player(3, "Felix", 30);
    private Player player4 = new Player(4, "Rosa", 20);

    @BeforeEach
    void shouldRegisterAllPlayers() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
    }

    @Test
    void shouldShowResultIfPlayer1Won() {
        assertEquals(1, game.round("Klara", "Karl"));
    }

    @Test
    void shouldShowResultIfPlayer2Won() {
        assertEquals(2, game.round("Klara", "Felix"));
    }

    @Test
    void shouldShowResultWhenDraw() {
        assertEquals(0, game.round("Klara", "Rosa"));
    }

    @Test
    void shouldThrowExceptionWhenPlayer1Unregistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Sveta", "Rosa"));
    }

    @Test
    void shouldThrowExceptionWhenPlayer2Unregistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Karl", "Vitalik"));
    }

    @Test
    void shouldThrowExceptionWhenBothPlayersUnregistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Cat", "Dog"));
    }
}