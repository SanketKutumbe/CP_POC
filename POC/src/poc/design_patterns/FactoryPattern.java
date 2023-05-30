package poc.design_patterns;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.Optional;

public class FactoryPattern {
}

abstract class Game{
    public int players;

    public abstract void playersRequired();
}

class RON extends Game{

    RON(int players){
        this.players = players;
    }

    @Override
    public void playersRequired() {
        System.out.println("Total players required for RON "+this.players);
    }
}

class Limbo extends Game{


    Limbo(int players){
        this.players = players;
    }


    @Override
    public void playersRequired() {
        System.out.println("Total players required for Limbo "+this.players);
    }
}

class CsGo extends Game{

    CsGo(int players){
        this.players = players;
    }

    @Override
    public void playersRequired() {
        System.out.println("Total players required for CsGo "+this.players);
    }
}

class Gamer{
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();
            Game game = null;
            switch (str){
                case "RON": game = new RON(4); break;
                case "Limbo": game = new Limbo(1); break;
                case "CsGo": game = new CsGo(2); break;
                default:
                    System.out.println("Lets play rummy");
            }
            Optional<Game> optionalGame = Optional.ofNullable(game);
            if( optionalGame.isPresent() )
                game.playersRequired();

        }catch (Exception e){
            e.printStackTrace();
        }finally {


        }


    }
}