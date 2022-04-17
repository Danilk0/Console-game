package org.task.view;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void showMenu(List<String> moves){
        for (int i=0;i<moves.size();i++){
            System.out.println((i+1)+": "+moves.get(i));
        }
        System.out.println("0: exit");
    }
    public static Integer getAnswer(){
        Scanner scanner=new Scanner(System.in);
        int move = scanner.nextInt();
        if(move==0){
            System.exit(0);
        }else {
            return move-1;
        }
        return -1;
    }
}
