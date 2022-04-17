package org.task.thred;

import org.task.model.Player;
import org.task.signature.HMAC;
import org.task.view.Menu;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;

public class Game implements Runnable {
    private List<String> list;
    @Override
    public void run() {
        if(list.size()%2==0){
            System.out.println("Invalid number of arguments!");
            System.exit(0);
        }
        while (true) {
            Player computer = new Player(list);
            try {
                System.out.println("HMAC: "+HMAC.getHMAC(list.get(computer.getMove())));
            } catch (NoSuchAlgorithmException | InvalidKeyException e) {
                e.printStackTrace();
            }
            Menu.showMenu(list);
            Integer userMove = Menu.getAnswer();
            Player player = new Player(userMove, list);
            Player winner = Player.winner(player, computer);
            if(winner!=null){
                System.out.println(winner.getName() + " win!");
            }else {
                System.out.println("Draw)");
            }
            System.out.println("Computer move: " + list.get(computer.getMove()));
            System.out.println("You move: " + list.get(player.getMove()));
            System.out.println("HMAC key: "+HMAC.getKey());
            System.out.println("_________________");
        }
    }

    public Game(String[] args){
        this.list = List.of(args);
    }
}
