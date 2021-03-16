
/**
 * Write a description of class testing here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

//import java.util.Random;
public class testing
{
    public static void main(String[] args)
    {
        String[][] gridSymbols = {{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "}};
        String[] symbols = {"♕", "♫", "★", "☀", "▲", "☾", "♣", "♦", "♥", "♠"};
        
        int counter = 0;
        
        String lettersString;
        int letterCoords;
        String numbersString;
        int numberCoords;
        String symbolSpace;
        String[] noNoSpaces = {"0","0","0"};
        int v = 0;
        //Random rand = new Random();
        
        while (counter < 10)
        {
            int x = 0;
            while (x < 2)
            {
                do
                {
                    letterCoords = (int)(Math.random()*((3-0) +1)) + 0;
                    //lettersString = verticalCoords[letterCoords];
                    
                    numberCoords = (int)(Math.random()*((4-0)+1))+0;
                    //numbersString = String.valueOf(numberCoords);
                    
                } while (gridSymbols[letterCoords][numberCoords].equals(symbols[0]) || gridSymbols[letterCoords][numberCoords].equals(symbols[1]) || gridSymbols[letterCoords][numberCoords].equals(symbols[2]) || gridSymbols[letterCoords][numberCoords].equals(symbols[3]) || gridSymbols[letterCoords][numberCoords].equals(symbols[4]) || gridSymbols[letterCoords][numberCoords].equals(symbols[5]) || gridSymbols[letterCoords][numberCoords].equals(symbols[6]) || gridSymbols[letterCoords][numberCoords].equals(symbols[7]) || gridSymbols[letterCoords][numberCoords].equals(symbols[8]) || gridSymbols[letterCoords][numberCoords].equals(symbols[9]));
                gridSymbols[letterCoords][numberCoords] = symbols[v];
                
                System.out.println(gridSymbols[letterCoords][numberCoords]);
                
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
        
    }
    }

