package com.ykhatab;


public class MainApp
{
    public static void main(String[] args)
    {
        if(args.length!=1){
            throw new IllegalArgumentException("Invalid number of input arguments. Exactly one game sequence is expected as argument !");
        }
        String gameInputSequence = args[0].toUpperCase();

        sanitizeGameInputArg(gameInputSequence);
        GameLauncher gameLauncher = new GameLauncher(gameInputSequence);
        gameLauncher.start();
    }
    private static void sanitizeGameInputArg(String gameInputSequence){
        for(char playerName : gameInputSequence.toCharArray()){
            if(playerName!='A' && playerName!='B'){
                throw new IllegalArgumentException("Invalid character in game sequence: " + playerName + ". Player names must be 'A' or 'B' !");
            }
        }
    }
}
