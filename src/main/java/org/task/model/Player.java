package org.task.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Player {
    private Integer move;
    private final List<String> moves;
    private String name;

    public Player(List<String> moves){
        this.moves=moves;
        Random random =new Random();
        this.move= random.nextInt(moves.size());
        this.name="Computer";
    }

    public Player(Integer move, List<String> moves) {
        this.move = move;
        this.moves = moves;
        this.name="You";
    }

    public static Player winner(Player player,Player player1){
        List<Integer> winnerList = getWinnerList((player.moves.size()) / 2, (player.moves.size()) / 2 + player.move, player.moves.size());
        if (player1.move.equals(player.move)){
            return null;
        }
        else if(winnerList.contains(player1.move)){
            return player1;
        }else {
            return player;
        }
    }

    private static List<Integer> getWinnerList(Integer first, Integer last,Integer size){
        List<Integer> winnersAnswers=new ArrayList<>();
        while (!Objects.equals(first, last)){
            if(Objects.equals(first, size) && last<first){
                winnersAnswers.add(first);
                first=0;
            }else {
                winnersAnswers.add(first);
                first++;
            }

        }
        return winnersAnswers;
    }

    public Integer getMove() {
        return move;
    }

    public List<String> getMoves() {
        return moves;
    }

    public String getName() {
        return name;
    }
}
