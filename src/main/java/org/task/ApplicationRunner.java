package org.task;

import org.task.thred.Game;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class ApplicationRunner {

    public static void main(String[] args) {
        String[] list={"Rock", "Paper", "Scissor"};

       Thread game=new Thread(new Game(list));
       game.start();
    }
}
