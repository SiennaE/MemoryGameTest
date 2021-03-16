
/**
 * Remember the locations of symbols on a grid and pair them to win.
 *
 * @author (Sienna)
 * @version (1.0)
 */

import java.util.Scanner;
import java.util.Random;

public class Match_Game
{
    static boolean ynBoolean(String ynAnswer, boolean tOrF)
    {
        if (ynAnswer.equals("yes") || ynAnswer.equals("Yes") || ynAnswer.equals("YES") || ynAnswer.equals("Y") || ynAnswer.equals("y"))
            {
                tOrF = true;
            }
            else if (ynAnswer.equals("no") || ynAnswer.equals("No") || ynAnswer.equals("NO") || ynAnswer.equals("N") || ynAnswer.equals("n"))
            {
                tOrF = false;
            }
            else
            {
                System.out.println("Input not recognized; playing tutorial");
                System.out.println(" ");
            }
        return tOrF;
    }
    static void tutorial(boolean tOrF)
    {
        if (tOrF)
        {
            System.out.println("Displaying: Tutorial");
            System.out.println(" ");
            System.out.println("The goal of Memory Match is to correctly pair corresponding");
            System.out.println("symbols. In this game, you will be shown a 5x4 board, with");
            System.out.println("a total of 10 different symbols. In order to guess corresponding");
            System.out.println("symbols, you will guess two grid positions, whose symbols will be");
            System.out.println("temporarily revealed to you. Can you memorize the positions of the");
            System.out.println("symbols so you can correctly match them?");
            System.out.println(" ");
            System.out.println("Good luck! Enjoy Memory Match!");
            System.out.println(" ");
        }
    }
    //create board
    //REMEMBER TO PRINT GRIDWHOLE BY COMBINING W/ CARDGRID
    static void print(String[][] cardGrid, String[][] gridWhole, String[] horizontalCoords, String[] verticalCoords)
    {
        for (int j = 1; j < 6; j++)
        {
            gridWhole[0][j] = horizontalCoords[j];
        }
        
        for (int s = 1; s < 5; s++)
        {
            gridWhole[s][0] = verticalCoords[s];
        }
        
        for (int a = 1; a < 5; a++)
        {
            for (int b = 1; b < 6; b++)
            {
                gridWhole[a][b] = cardGrid[a-1][b-1];
            }
        }
        
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                System.out.print(gridWhole[i][j] + "     ");
            }
            System.out.println(" ");
            System.out.println(" ");
        }
    }
    static void printSymbols(String[][] cardGrid, String[][] gridWhole, String[] horizontalCoords, String[] verticalCoords, String letterGuess1, String letterGuess2, int numberGuess1, int numberGuess2, int letter1, int letter2, String[][] gridSymbols)
    {
        for (int j = 1; j < 6; j++)
        {
            gridWhole[0][j] = horizontalCoords[j];
        }
        
        for (int s = 1; s < 5; s++)
        {
            gridWhole[s][0] = verticalCoords[s];
        }
        
        for (int a = 1; a < 5; a++)
        {
            for (int b = 1; b < 6; b++)
            {
                gridWhole[a][b] = cardGrid[a-1][b-1];
            }
        }
        
        gridWhole[letter1][numberGuess1] = gridSymbols[letter1-1][numberGuess1-1];
        gridWhole[letter2][numberGuess2] = gridSymbols[letter2-1][numberGuess2-1];
        
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                System.out.print(gridWhole[i][j] + "     ");
            }
            System.out.println(" ");
            System.out.println(" ");
        }
        
        
    }
    //change so if grid symbols !" " then repeat the random number generator
    static String[][] randomSpace(String[] symbols, String[] verticalCoords, String[][] gridSymbols, String[][] duplicate)
    {
        int counter = 0;
        
        String lettersString;
        int letterCoords;
        String numbersString;
        int numberCoords;
        String symbolSpace;
        String[] noNoSpaces = {"0","0","0"};
        int v = 0;
        
        while (counter < 10)
        {
            int x = 0;
            while (x < 2)
            {
                do
                {
                    letterCoords = (int)(Math.random()*((3-0))+0);
                    //lettersString = verticalCoords[letterCoords];
                    
                    numberCoords = (int)(Math.random()*((4-0))+0);
                    //numbersString = String.valueOf(numberCoords);
                    
                } while (gridSymbols[letterCoords][numberCoords].equals(symbols[0]) || gridSymbols[letterCoords][numberCoords].equals(symbols[1]) || gridSymbols[letterCoords][numberCoords].equals(symbols[2]) || gridSymbols[letterCoords][numberCoords].equals(symbols[3]) || gridSymbols[letterCoords][numberCoords].equals(symbols[4]) || gridSymbols[letterCoords][numberCoords].equals(symbols[5]) || gridSymbols[letterCoords][numberCoords].equals(symbols[6]) || gridSymbols[letterCoords][numberCoords].equals(symbols[7]) || gridSymbols[letterCoords][numberCoords].equals(symbols[8]) || gridSymbols[letterCoords][numberCoords].equals(symbols[9]));
                gridSymbols[letterCoords][numberCoords] = symbols[v];
                
                //System.out.println(gridSymbols[letterCoords][numberCoords]);
                
                x++;
            }
            
            v++;
                
            counter++;
        }
        
        for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    System.out.print(gridSymbols[i][j] + "     ");
                }
                System.out.println(" ");
                System.out.println(" ");
            }
        
        return gridSymbols;
    }
    //ask user
    static void revealSymbols(String ready, Scanner input, String letterGuess1, String letterGuess2, int numberGuess1, int numberGuess2, int letter1, int letter2, String[][] gridSymbols, String[] verticalCoords, String[] horizontalCoords, String[][] gridWhole, String[][] cardGrid)
    {
        if (letterGuess1.equals("A"))
        {
            letter1 = 1;
        }
        else if (letterGuess1.equals("B"))
        {
            letter1 = 2;
        }
        else if (letterGuess1.equals("C"))
        {
            letter1 = 3;
        }
        else if (letterGuess1.equals("D"))
        {
            letter1 = 4;
        }
        if (letterGuess2.equals("A"))
        {
            letter2 = 1;
        }
        else if (letterGuess2.equals("B"))
        {
            letter2 = 2;
        }
        else if (letterGuess2.equals("C"))
        {
            letter2 = 3;
        }
        else if (letterGuess2.equals("D"))
        {
            letter2 = 4;
        }
        
        printSymbols(cardGrid, gridWhole, horizontalCoords, verticalCoords, letterGuess1, letterGuess2, numberGuess1, numberGuess2, letter1, letter2, gridSymbols);
        
        if (gridSymbols[letter1-1][numberGuess1-1].equals(gridSymbols[letter2][numberGuess2]))
        {
            System.out.println("Congrats! You found a pair.");
        }
        
        System.out.println("Type anything when you are ready to continue");
        ready = input.next();
    }
    static void matched()
    {
        
    }
    //main code
    public static void main(String[] args)
    {
        boolean play = true;
    
        
            Scanner input = new Scanner(System.in);
            
            String ynAnswer;
            boolean tOrF = false;
            String letterGuess1 = " ";
            int letter1 = 0;
            int numberGuess1 = 0;
            String letterGuess2 = " ";
            int letter2 = 0;
            int numberGuess2 = 0;
            String ready = " ";
            int countMatch = 0;
            
            String[] horizontalCoords = {" ", "1 ", "2 ", "3 ", "4 ", "5"};
            String[] verticalCoords = {" ", "A", "B", "C", "D"};
            //hidden board containing the locations of the symbols
            String[][] gridSymbols = {{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "}};
            //just for show
            String[][] cardGrid = {{"☐","☐","☐","☐","☐"},{"☐","☐","☐","☐","☐"},{"☐","☐","☐","☐","☐"},{"☐","☐","☐","☐","☐"},{"☐","☐","☐","☐","☐"}};
            //print the coordinates and boxes
            String[][] gridWhole = {{" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}};
            //make sure no repeating spaces (maybe delete later)
            String[][] duplicate = {{" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " "}};
            
            String[] symbols = {"♕", "♫", "★", "☀", "▲", "☾", "♣", "♦", "♥", "♠"};
            
            System.out.println("Welcome to Memory Match!");
            System.out.println(" ");
            System.out.println("Would you like a tutorial of how to play? (Type \"yes\" or \"no\")");
            ynAnswer = input.next();
            
            if (ynAnswer.equals("yes") || ynAnswer.equals("Yes") || ynAnswer.equals("YES") || ynAnswer.equals("Y") || ynAnswer.equals("y"))
            {
                tOrF = true;
            }
            else if (ynAnswer.equals("no") || ynAnswer.equals("No") || ynAnswer.equals("NO") || ynAnswer.equals("N") || ynAnswer.equals("n"))
            {
                tOrF = false;
            }
            else
            {
                System.out.println("Input not recognized; playing tutorial");
                System.out.println(" ");
            }
            
            tutorial(tOrF);
            
            
            //print board
            print(cardGrid, gridWhole, horizontalCoords, verticalCoords);
            
            //assign symbols to grid spaces
            randomSpace(symbols,verticalCoords,gridSymbols,duplicate);
            
            
            
            //LOOP ask user to pick two grid spaces
            //      reveal what is under the spaces
            
            revealSymbols(ready,input,letterGuess1,letterGuess2,numberGuess1,numberGuess2,letter1,letter2,gridSymbols,verticalCoords,horizontalCoords,gridWhole,cardGrid);
    
            
        
    }
    
}