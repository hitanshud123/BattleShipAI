/**********************************************
 * Programmer:     Hitanshu
 * Course Code:    ICS3U-01
 * Date Submitted: 1/22/2019
 * 
 * Program Name:   BattleShip
 *
 * Description:  This program is the code for a player vs computer game called 
 *               "BattleShip". It is based on the popular board game version
 *               of battleship
 *********************************************/
import java.util.*;
class Main {

  /************
   * This method clears the screen
  ***************/
  public static void clear() {
    for(int i = 0; i < 50; i++){
      System.out.println(); //skips 40 lines to clear the screen
    }
  }

  /************
   * This method inputs an integer from the user
   * 
   * @param first
   *    The prompt  
   * @return
   *    the user's input
  ***************/
  public static int inputInt(String prompt) {
    Scanner scanInt = new Scanner(System.in); //Scanner object
    int input; //The integer that the user will input 
    System.out.print(prompt); //Prompts user
    input = scanInt.nextInt(); //inputs integer
    return input; //returns input
  }

  /************
   * This method inputs a string from the user
   * 
   * @param first
   *    the prompt  
   * @return
   *    The user's input
  ***************/
  public static String inputStr(String prompt) {
    Scanner scanStr = new Scanner(System.in); //Scanner object
    String input; //the String that the user will input
    System.out.print(prompt); //prompts user
    input = scanStr.next(); //inputs string
    return input; //returns input
  }

  /************
   * This method pauses the program
   * 
   * @param first
   *    How long to pause in seconds
  ***************/
  public static void pause(double timeInSeconds)
  throws InterruptedException {  
    Thread.sleep((int)(timeInSeconds * 1000)); //converts seconds into milliseconds
  }

  /************
   * This method checks if an integer is within a given range
   * 
   * @param first
   *    The number that will be checked
   * @param second
   *    The minimum number of the range
   * @param second
   *    The maximum number of the range
   * @ return
   *    a boolean that represents if the number is within the range
  ***************/
  public static boolean checkRange(int num, int minNum, int maxNum) {
    if (num < minNum || num > maxNum) {
      return false; //If the number is not within the range, returns false
    }
    else {
      return true; //If the number is within the range, returns true
    }
  }

  /************
   * This method outputs the main menu and inputs the user's choice
   * 
   * @ return
   *    the user's choice
  ***************/
  public static int mainMenu() {
    int choice; //the user's choice
    //Outputs main menu
    System.out.println("\nWELCOME TO BATTLESHIP");
    System.out.println("\n   Options:");
    System.out.println("      1 >> Play Game");
    System.out.println("      2 >> Shop");
    System.out.println("      3 >> Instrucions");
    System.out.println("      4 >> Quit");
    choice = inputInt("   Your choice: "); //inputs choice
    while (!checkRange(choice, 1, 4)) {
      //Checks if the choice is valid
      choice = inputInt("      Enter a valid choice: "); 
    }
    clear(); //clears screen
    return choice; //Returns choice
  }

  /************
   * This method outputs the instructions
   * 
   * @param first
   *    The map. this is used to print a demonstration map
   * @param second
   *    The symbols that will be printed in the map.
  ***************/
  public static void instrucions(int[][] map, String[] symbols) {
    //outputs instructions
    System.out.println("\nINSTRUCTIONS");
    System.out.println("Description:\n   > In this game, you will take the role of the\n     captain of a fleet and battle against your\n     enemies.");    
    inputStr("Enter any key to start your training: ");
    System.out.println("\nDeploying ships:\n   > Your first task as a captain will be to deploy\n     your ships on a 9x11 map like the one shown\n     below");
    printMap(map, symbols, "          Your ships");
    System.out.println("\n   > You may chose to deploy your ships mannually\n     or automatically by entering a or m when asked");
    System.out.println("   > If you choose automatically, your ships will\n     be randomly placed on the map");
    System.out.println("   > If you choose manually, you can deploy your\n     where ever you want\n   > To deploy your ships manually, first you must\n     enter the orientation by entering h for\n     horizontal or v for vertical\n   > Then you must enter the coordinates of the top\n     of the ship. The coordinates consist of a\n     letter and a number (e.g D6, a5, k8, or F4)\n   > Your ships may not overlap or go out of bounds");
    inputStr("Enter any key to continue: ");
    System.out.println("\nYour fleet will include:\n   > 1 Destroyer (2 pegs)\n   > 1 Submarine (3 pegs)\n   > 1 Cruiser (3 pegs)\n   > 1 Battleship (4 pegs)\n   > 1 Carrier (5 pegs)");
    System.out.println("\nOn the map, your ships will be represented by the\nfirst letter of their name\n(a cruiser is a lowercase c and a carrier is a\ncaptial C) ");
    System.out.println("\nOnce you deploy your ships, the enemy will deploy\ntheir ships on a separate map");
    inputStr("Enter any key to continue: ");
    System.out.println("\nAttacking:\n   > Once you deploy your ships, its time to attack\n   > You will be given 2 maps like shown below. The\n     map at the bottom is where your ships are\n     deployed and the map at the top is where the\n     enemy deployed their ships.");
    printMap(map, symbols, "        Attaking Panel");
    printMap(map, symbols, "          Your ships");
    inputStr("Enter any key to continue: ");
    System.out.println("\n   > In order to attack your enemy, you must guess\n     the coordinates of the enemy ships\n   > If you hit a ship the coordinate will be\n     marked by an X\n   > If you miss, the coodinate will be\n     marked by a -");
    System.out.println("\n   > You and the enemy will take turns attaking.\n     The player that destroys all of the enemy's\n     ships wins");
    inputStr("Enter any key to continue: ");
    System.out.println("\nPowerups:\n     You will also be able to buy powerups using\n     your points. Visit the shop for more\n     information");
    System.out.println("\nYour training is complete. You are all good to go!!");
    inputStr("Enter any key to start playing: ");
    clear();
  }

  /************
   * This method prints a map on the screen
   * 
   * @param first
   *    a 2D array that stores the information to print
   * @param second
   *    The symbols that will printed on the map
   * @param second
   *    The title of the map
  ***************/
  public static void printMap(int[][] map, String[] symbols, String title) {
    System.out.println("\n" + title);//prints title
    System.out.println("    A B C D E F G H I J K ");//Prints x cordinates at the top
    //The following for loops are used to iterate through the 2D array. 
    //The outer one iterates through the rows and the inner one iterates through the columns
    for (int i = 1; i < map.length; i++) {
      System.out.print((10 - i) + " | "); //Prints yCor at the beginning of each row      
      for (int j = 1; j < map[i].length; j++) {
        System.out.print(symbols[map[10 - i][j]]); //Prints the symbol located at that location
      }
      System.out.println( "| " + (10 - i)); //prints yCor at the end of the row
    }
    System.out.println("    A B C D E F G H I J K"); //prints x coordinates in the bottom
  }

  /************
   * This method checks if the coordinates entered are valid
   * 
   * @param first
   *    A string that represents the coordinates (c5, A8, k9 etc...)
   * @ return
   *    a boolean that represents if the coordinates are valid
  ***************/
  public static boolean validCoordinates(String coord) {
    boolean valid = false; // a boolean that represents if the coordinates are valid
    //the first if statement checks if the length of the coordinates is 2
    if(coord.length() == 2) {
      //The second if statement uses chars to check if the first index of the coord is from A to K or a to k
      if(checkRange(coord.charAt(0), 65, 75) || checkRange(coord.charAt(0), 97, 107)) {
        //The third if statement uses chars to check if the second index is from 1 to 9
        if(checkRange(coord.charAt(1), 49, 57)) {
          valid = true; //If the coords pass all 3 checks, valid is set to true
        }
      }
    }
    return valid; //returns valid
  }

  /************
   * This method checks if the orientation entered by the user is valid
   * 
   * @param first
   *    the orientation entered by the user
   * @ return
   *    a boolean that represents if the orientation entered is valid
  ***************/
  public static boolean validOrientation(char orientation) {
    if(orientation == 'h' || orientation == 'H' || orientation == 'v' ||orientation == 'V' ) {
      return true; 
    }
    else {
      return false;
    }
  }
  
  /************
   * This method checks if the ship that the user wants to enter overlaps with another ship
   * 
   * @param first
   *    The map that the user is deploying their ships in
   * @param second
   *    the orientation of the ship
   * @param third
   *    the x coord of the top of the ship
   * @param fourth
   *    the y coord of the top of the ship
   * @param fifth
   *    the length of the ship
   * @ return
   *    a boolean that represents if the ship overlaps with another ship
  ***************/
  public static boolean overlapShips(int[][] map, char orientation, int xCor, int yCor, int shipSize) {
    boolean overlap = false; //a boolean that represents if the ship overlaps with another ship
    //The following code iterates through all of the coordinates that ship will be placed
    //and checks if a ship is already present in the coordinates
    //It is branched into 2 possibilities. 
    //   > If the ship is horizontal The coordinates are to the right
    //   > If the ship is vertical, the coordinates are below 
    if(orientation == 'h' || orientation == 'H') {
      for (int i = 0; i < shipSize; i++) {
        if (checkRange(map[yCor][xCor + i], 1, 5)) {
          overlap = true; //overlap is set to true, if a ship is found
          i = shipSize; //i is set to the ship size so that the program leaves the loop
        } 
      } 
    } 
    else {
      for (int i = 0; i < shipSize; i++) {
        if (checkRange(map[yCor - i][xCor], 1, 5)) {
          overlap = true; //overlap is set to true, if a ship is found
          i = shipSize; //i is set to the ship size so that the program leaves the loop
        }
      } 
    }
    return overlap;
  }

  /************
   * This method checks if the ship that the user wants to enter is out of bounds
   * 
   * @param first
   *    the orientation of the ship
   * @param second
   *    the x coord of the ship
   * @param third
   *    the y coord of the ship
   * @param fourth
   *    the length of the ship
   * @ return
   *    a boolean that represents if the ship is out of bounds
  ***************/
  public static boolean outOfBounds(char orientation, int xCor, int yCor, int shipSize) {
    boolean outOfBounds = false; //a boolean that represents if the ship is out of bounds
    //The following code determines the last coordinate of the ship and checks if it is out of bounds
    if(orientation == 'h' || orientation == 'H') {
      if(xCor + shipSize - 1 > 11) {
        outOfBounds = true;
      }
    }
    else {
      if(yCor - shipSize + 1 < 1) {
        outOfBounds = true;
      }
    }
    return outOfBounds;
  }

  /************
   * This method deploys the ship onto the map, or stores its coordinates in a 2D array 
   * that represents the map
   * 
   * @param first
   *    the map where the ship will be deployed
   * @param second
   *    the orientation of the ship
   * @param third
   *    the x coord of the top of the ship
   * @param fourth
   *    the y coord of the top of the ship
   * @param fifth
   *    the length of the ship
   * @param sixth
   *    an integer that represents the type of ship (1 = destroyer, 2 = submarine, 3 = cruiser...)
  ***************/
  public static void storeShip(int[][] map, char orientation, int xCor, int yCor, int shipSize, int shipType) {
    //The following code sets the coordinates of the ship in the 2D array
    if(orientation == 'h' || orientation == 'H') {
      //If the orientation is horizontal, sets all of the coordinates to the right to the ship type
      for (int i = 0; i < shipSize; i++) {
        map[yCor][xCor + i] = shipType;
      } 
    } 
    else {
      //If the orientation is vertical, sets all of the coordinates under to the ship type
      for (int i = 0; i < shipSize; i++) {
        map[yCor - i][xCor] = shipType;
      } 
    }
  }

  /************
   * This method extracts the x coordinates from a string that represents the coordinates
   * and converts it to an integer (e.g. C5 = C = 3, k9 = k = 11, f5 = f = 6)
   * 
   * @param first
   *    a string that represents the coordinates
   * @return
   *    an integer that represents the x coordinates
  ***************/
  public static int getXCor (String coord) {
    int xCor; //the x coordinate
    //The following code uses chars to isolate the first index
    if (coord.charAt(0) > 75) {
      //If the letter is lowercase, 96 is subtracted from its ASCII value
      //This is done because an 'a' has an ASCII value of 97.  therefore, 97 - 96 = 1
      // similarly, 'b' =  98, 98 - 96 = 2
      xCor = coord.charAt(0) - 96;
    }
    else {
      //If the leter is uppercase, 64 is subtracted from it's ACSII value since an 'A' has a value of 65
      xCor = coord.charAt(0) - 64;
    }
    return xCor;
  }

  /************
   * This method isolates the y coordinate from a string that represents the coordinates
   * (e.g. C5 = 5, F8 = 8, K2 = 2)
   * 
   * @param first
   *    a string that represents the coordinates
   * @return
   *    an integer that represents the y coordinates
  ***************/
  public static int getYCor (String coord) {
    int yCor; //the y coordinate
    //Does the same as the method above. except, 48 is subtracted from the acsii value
    //sine a '1' has a value of 49
    yCor = coord.charAt(1) - 48;
    return yCor;
  }

  /************
   * This method calls the methods created above to deploy the user's ships
   * 
   * @param first
   *    the map where the user will deploy their ships
  ***************/
  public static void deployShipsUser(int[][] map)
  throws InterruptedException { 
    char orientation; //the orientation of the ship
    String coord; //the coordintates of the ship in string form
    int xCor; //The x coord of the top of the ship in integer form
    int yCor; //The y coord of the top of the ship in integer form
    //The following list contains the names of the names of the ships in order
    String[] shipNames = {"Destroyer", "Submarine", "Cruiser", "Battleship", "Carrier" };
    int[] shipSize = {2, 3, 3, 4, 5}; //This list stores the length of each ship in order
    char auto; // a char thet represents wether the user would like to deploy
               // their ships automatically or manually

    System.out.println("\nDEPLOY YOUR FLEET:");

    //Inputs wether the user would like to deploy their ships automatically or manually
    auto = inputStr("Would you like to deploy your ships automatically\nor manually (a or m): ").charAt(0);
    while (auto != 'a' && auto != 'A' && auto != 'm' && auto != 'M') {
      auto = inputStr("   Enter a valid answer (a or m): ").charAt(0);
    }

    if(auto == 'a' || auto == 'A') {
      System.out.println();
      //If the user chose automatically, the deployComp method is called since it deploys ships randomly
      deployComp(map, 'u');
    }
    else {
      //Otherwise, the user is asked where they would deploy their ships
      //The following loop repeats 5 times since there are 5 ships
      for(int i = 0; i < 5; i++) {
        //lets the user know which ship they are deploying
        System.out.println("\n  Deploy your " + shipNames[i] + " (" + shipSize[i] + " pegs) : ");
        
        //inputs the orientation of the ship
        orientation = inputStr("      Choose the orientation(h or v): ").charAt(0);
        while(!validOrientation(orientation)) {
          //checks if input is valid
          orientation = inputStr("         Enter a valid orientation: ").charAt(0);
        }
        
        //inputs the coords of the the top of the ship in string form
        coord = inputStr("      Enter the coordinates of the top of the ship: ");
        while(!validCoordinates(coord)) {
          //checks if the input is valid
          coord = inputStr("         Enter valid coordinates: ");
        }
        
        xCor = getXCor(coord); //gets integer value of x coord
        yCor = getYCor(coord); //gets integer value of y coord
        
        if (outOfBounds(orientation, xCor, yCor, shipSize[i])) {
          //This if statement checks if the ship is out of bounds
          System.out.println("\nYour ship is out of bounds\nPlease choose new coordinates");
          i--; //subtracts i by 1 so that the on the next time through the loop, the user is asked 
               //to re-enter the coordinates of the same ship
        }
        else if (overlapShips(map, orientation, xCor, yCor, shipSize[i])) {
          //This if statement checks if the ship overlaps another ship
          System.out.println("\nYou already have a ship on this spot\nPlease choose new coordinates");
          i--; 
        }
        else {
          //if the ship passes all of the checks, is is stored in the map
          storeShip(map, orientation, xCor, yCor, shipSize[i], i + 1);
        }
      }
    }
  }
  
  /************
   * This method deploys ships onto the map randomly. it is used by the computer. It is also 
   * used by the user when they want to deploy their ships automatically
   * 
   * @param first
   *    the map where the player will deploy their ships
   * @param second
   *    the player that is using this method
   ***************/
  public static void deployComp(int[][] map, char player)
  throws InterruptedException {  
    Random rand = new Random();
    int xCor; //the x coord of the top ship
    int yCor; //the y coord of the top of the ship
    char orientation; //the orientation of the ship
    //The following list contains the names of the names of the ships in order
    String[] shipNames = {"Destroyer", "Submarine", "Cruiser", "Battleship", "Carrier" };
    int[] shipSize = {2, 3, 3, 4, 5}; //This list stores the length of each ship in order
    
    if(player == 'c') {
      pause(1.5);
      //only outputs the title if the compluter is using the method
      System.out.println("\nCOMPUTER IS DEPLOYING ITS FLEET:\n");
    }
    
    //The following loop repeats 5 times since there are 5 ships
    for(int i = 0; i < 5; i++) {
      xCor = rand.nextInt(11) + 1; //generates random values for the coordinates
      yCor = rand.nextInt(9) + 1;

      //The following if statements genreate a random orientation
      if(rand.nextBoolean()) {
        orientation = 'h';
      }
      else {
        orientation = 'v';
      }

      if (outOfBounds(orientation, xCor, yCor, shipSize[i]) || overlapShips(map, orientation, xCor, yCor, shipSize[i])) {
        //This checks if the ship is out of bounds or overlaps with another ship
        i--; //subtracts i by 1 so that the on the next time through the loop, the computer
             //re-deploys the smae ship
      }
      else {
        storeShip(map, orientation, xCor, yCor, shipSize[i], i + 1); //stores ship onto map
        //The following lines are an animation that let the user know that the ship has been deployed
        System.out.print(shipNames[i] + ": ");
        pause(0.75);
        System.out.println("Deployed");
      }
    }

    if(player == 'c') {
      //Prints outro only if the computer is using this method
      pause(1);
      System.out.println("\n\nTime to Attack");
      pause(1.25);
    }
  }

  /************
   * This method checks if the user or computer hit a ship
   * 
   * @param first
   *    the map that stores where all of the ships are
   * @param second
   *    the x coord to attack
   * @param third
   *    the y coord to attack
   * @param fourth
   *    the livea of each of the player's ships
   * @param fifth
   *    The player that is using this method
   * @ return
   *    a boolean that represents ifa ship has been hit
  ***************/
  public static boolean shipHit(int[][] map, int xCor, int yCor, int[]shipLives, char player) {
    boolean hit;//a boolean that represents ifa ship has been hit

    if(checkRange(map[yCor][xCor], 1, 5)) {
      //If there is a ship present in the coordinates that the player attacked, they hit an enemy ship
      //The following if statements let the user know that the player hit a ship
      if (player == 'u') {
        System.out.println("   You hit an enemy ship!!");
      }
      else {
        System.out.println("   The computer hit your ship");
      }
      
      shipLives[map[yCor][xCor] - 1]--; //decreases life of the ship
      map[yCor][xCor] = 6; //stores a 6 (hit) in the map
      hit = true; //sets hit to true
    }
    else {
      //Lets the the player know that they missed
      if (player == 'u') {
        System.out.println("   You missed");
      }
      else {
        System.out.println("   The computer missed");
      }
      map[yCor][xCor] = 7; //stores a 7 (miss) in the array
      hit = false; //sets hit to false
    }
    return hit;
  }

   /************
   * This method checks the user or computer sunk a ship
   * 
   * @param first
   *    the lives of each of the player's ships
   * @param second
   *    The number of ships that the player has
   * @param third
   *    The player that is using this method
   * @ return
   *    the updated number of ships that the user has
  ***************/
  public static int shipSunk(int[] shipLives, int numShips, char player) 
  throws InterruptedException {  
    //The following array stores the names of the ships
    String[] shipNames = {"Destroyer", "Submarine", "Cruiser", "Battleship", "Carrier" };
    //The following loop iterates through the array that stores the lives of the ships
    for (int i = 0; i<shipLives.length; i++) {
      //If any of the ship's lives is 0, the ship is sunk  
      if(shipLives[i] == 0) {
        //Lets the player know that they sunk an enemy ship
        if (player == 'u') {
          System.out.println("\nYou Sunk the enemy's " + shipNames[i] + "!!!\n");
        }
        else {
          System.out.println("\nThe computer sunk your " + shipNames[i] + "\n");
        }
        shipLives[i] = -1; //The ship live is set to -1 to let the program know that it has already 
                           // checked this ship
        numShips--; //decreases number of ships
        pause(0.75);
      }
    }
    return numShips; //returns updated value of ships
  }

  /************
   * This method detemines if the user entered a coordinate or powerup
   * 
   * @param first
   *    the input that needs to be checked
   * @ return
   *    An int that represents which powerup the user picked
  ***************/
  public static int isPowerUp(String input) {
    int powerUp;//An int that represents which powerup the user picked
    if (input.equalsIgnoreCase("r")) {
      //If the user entered r, they would like to activate their radar
      powerUp = 0; //0 represents radar
    }
    else if(input.equalsIgnoreCase("a")) {
      //If the user entered a, they would like to activate their airstrike
      powerUp = 1; //1 represents airstrike
    }
    else {
      //otherwise, the user does not want to use a powerup
      powerUp = -1; //-1 represents none
    }
    return powerUp;
  }

  /************
   * This method inputs which coord the user would like to attack.
   * If the user would like to activate a powerup, this method also
   * allows them to activate a powerUp
   * 
   * @param first
   *    the map where the user will be attacking
   * @param second
   *    an array that stores how many powerups the user has
   * @ return
   *    A string that represents where the user would like to attack
  ***************/
  public static String getAtkCoord(int[][] map, int[] powerUps) {
    String coord; //A string that represents where the user would like to attack
    int powerUp; //the powerup that the user wants to use
    boolean valid; //a boolean that represents wether they entered a correct value
    
    System.out.println("\nYOUR TURN");
    //The following lines let the user know how many powerups they have
    System.out.println("   Radar: " + powerUps[0] + ", Enter r to activate");
    System.out.println("   AirStrike: " + powerUps[1] + ", Enter a to activate");
  
    valid = true; //initializes valid to true
    do {
      //inputs coordinates or powerup
      coord = inputStr("   Which coordinates would you like to attack?: ");
      powerUp = isPowerUp(coord); //checks if the user would like to use a powerup
      while(!validCoordinates(coord) && powerUp == -1) {
        //Checks for mispelled or illegal coordinates
        coord = inputStr("      Enter valid coordinates: ");
        powerUp = isPowerUp(coord);
      }

      if (powerUp != -1) {
        //Checks if the user has the powerup that they want to use
        if (powerUps[powerUp] == 0) {
          System.out.println("      You don't have this powerup\n");
          valid = false;
        }
        else {
          valid = true;
        }        
      }
      else if(checkRange(map[getYCor(coord)][getXCor(coord)], 6, 7)) {
        //Checks if the user already attacked this coord
        System.out.println("      You have already attacked this coordinate\n");
        valid = false;
      }
      else {
        valid = true;
      }
    } while(!valid); //repeats untill the user enters a valid value
   
    return coord;
  }

  /************
   * This method attack the coordinates that the user entered in the 
   * method above
   * 
   * @param first
   *    the map where the user will be attacking
   * @param second
   *    The coordinates that the user would like to attack
   * @param third
   *    an array that stores the lives of the computer's ships
   * @param fourth
   *    The number of ships that the computer has
   * @ return
   *    the updated number of ships that the user has after attacking
  ***************/
  public static int userAtk(int[][] map, String coord, int[] shipLives, int numShips) 
  throws InterruptedException {  
    int xCor; //the x coord to attack
    int yCor; //the y coord to attack

    boolean hit; //a boolean that represents wether the user hit a ship

    xCor = getXCor(coord); //isolates x coord 
    yCor = getYCor(coord); //isolates y coord
    
    pause(0.75);
    hit = shipHit(map, xCor, yCor, shipLives, 'u'); //checks if the user hit an enemy ship
    if(hit) {
      //If the user hit, checks if the user sunk an enemy ship
      numShips = shipSunk(shipLives, numShips, 'u');
    }
    pause(0.75);
    return numShips;
  }

  /************
   * Before continuing, read the description of this feature which is located at the 
   * end of the code to understand how this method works
   *
   * This method increments the pointer in SCD[1 and 2] to the next
   * direction
   * 
   * @param first
   *    the pointer to increment
   * @param third   
   *    the incremented pointer
   ***************/
  public static int incPointer (int pointer) {
    if (pointer == 10) {
      pointer = 7;//if the pointer has reached the end of the list, 
    }             //it is reset to the begining
    else {
      pointer++; //pointer is incremented
    }
    return pointer;
  }

  /************
   * Before continuing, read the description of this feature which is located at the 
   * end of the code to understand how this method works
   *
   * This method decides which coords the computer should attack while Smart computer 
   * Attack is on
   * 
   * @param first
   *    the map
   * @param second 
   *    Smart Computer Data
   * @param third   
   *    An array that stores the lives of the user's ships   
   ***************/
  public static void smartCompAtk(int[][] map, int[] scd, int[] shipLives) {
    boolean valid = false; // a boolean that represents wether the coords that the 
                           // computer wants to attack are valid 

    do {
      //The following if statements change the direction and coords to attack based 
       //on the phase
      if (scd[5] == 0) {
        //If the computer is in phase 1, the pointers are incremented to the next direction
        scd[1] = incPointer(scd[1]);
        scd[2] = incPointer(scd[2]);
      } 

      if (scd[5] == 2) {
        //If the computer is in phase 3, the pointers are incremented twice to the opposite direction
        scd[1] = incPointer(incPointer(scd[1]));
        scd[2] = incPointer(incPointer(scd[2]));
        //The following loops skips the coords that it already attacked in phase 1 
        do{
          scd[3] += scd[scd[1]];
          scd[4] += scd[scd[2]];
        }while (checkRange(map[scd[4]][scd[3]], 6, 7));
        scd[3] -= scd[scd[1]];
        scd[4] -= scd[scd[2]];
      }     

      //Updates the coords to attack
      scd[3] += scd[scd[1]];
      scd[4] += scd[scd[2]];

      //The following if statements check if the coordinates are valid
      if(!checkRange(scd[3], 1, 11) || !checkRange(scd[4], 1, 9)){
        //This if statement checks if the coords are out of bounds
        if (scd[5] == 1) {
          //If the previous phase was 2, the new phase is set to 3
          scd[5] = 2;
        }

        //resets the coords to what they were before since they are invalid
        scd[3] -= scd[scd[1]];
        scd[4] -= scd[scd[2]];
        valid = false; //Sets valid to false
      } 
      else if (checkRange(map[scd[4]][scd[3]], 6, 7) || (map[scd[4]][scd[3]] != scd[6] && map[scd[4]][scd[3]] != 0)) {
        //This if statement checks if the computer has already attacked the coords
        if (scd[5] != 0){
          //If the previous phase was 2, the new phase is set to 3
          scd[5] = 2;
        }

        //resets the coords to what they were before since they are invalid
        scd[3] -= scd[scd[1]];
        scd[4] -= scd[scd[2]];
        valid = false; //Sets valid to false
      }
      else {
        //If the coords pass both checks, valid is set to true
        valid = true;        
      } 
    } while(!valid); //This Loop repeats and generates coords to attack
                     // untill they are valid
    
    //There is no return value because the coords to attack are stored in an array
  }

  /************
   * Before continuing, read the description of this feature which is located at the 
   * end of the code to understand how this method works
   *
   * This method represents the computer's turn. It decides which coords the computer 
   * should attack, and checks if it hit or sunk an enemy ship
   * 
   * @param first
   *    the map
   * @param second 
   *    An array that stores the lives of the user's ships   
   * @param third
   *    the number of ships that the user has
   * @param fourth
   *    Smart Computer Data
   * @return
   *    The updated number of ships that the user has. The number of ships might
   *    decrease if the computer sinks one of the user's ships
   ***************/  
  public static int compAtk(int[][] map, int[] shipLives, int numShips, int[] scd) 
  throws InterruptedException {  
    Random rand = new Random(); //Random object

    int xCor; //the x coord that the computer will attack
    int yCor; //the y coord that the computer will attack
    boolean hit; //A boolean that represents wether the computer hit a ship

    System.out.println("\nCOMPUTER'S TURN");

    if(scd[0] == 1) {
      //If Smart Computer Attack is turned on, the coordinates to attack are decided
      //by invoking smartCompAtk
      smartCompAtk(map, scd, shipLives);
      xCor = scd[3];
      yCor = scd[4];
    }
    else {
      //Otherwise, the coords are chosen randomly
      do{
        xCor = rand.nextInt(11) + 1;
        yCor = rand.nextInt(9) + 1;
      } while(checkRange(map[yCor][xCor], 6, 7));
        scd[6] = map[yCor][xCor];
    }

    //Tells the user which coords the computer wants to attack
    System.out.print("   The computer is attacking: ");
    pause(0.5);
    System.out.println((char)(xCor + 64) + "" + yCor);
    pause(1);

    hit = shipHit(map, xCor, yCor, shipLives, 'c'); //invokes shipHit to check if the computer hit a ship
    pause(1);
    
    if (hit) {
      if(scd[0] == 0) {
        //If the computer hits a ship and smart computer attack was off, it is turned on
        scd[0] = 1;
        scd[3] = xCor; //initializes the coordinates to attack
        scd[4] = yCor;
        scd[5] = 0; //sets the phase to 1.
      }
      else {
        //If smart computer attack was turned on and the computer hits a ship, the phase is changed to 2
        scd[5] = 1; 
      }
    }
    else {
      if(scd[0] == 1) {
        if (scd[5] == 1){
          //If the computer misses, smart computer attack was turned, and it was in phase 2, 
          //The phase is set to 3
          scd[5] = 2;
        }
        else {
          //If the computer misses, smart computer attack was turned, and it was in phase 1 or 3, 
          //The phase is set to 1
          scd[5] = 0;
          //The coords to attack are reset to what the were before since the computer missed
          scd[3] -= scd[scd[1]];
          scd[4] -= scd[scd[2]];
        }
        
      }
    }
    
    int x = numShips; //Stores the number of ships in x for a future check
    numShips = shipSunk(shipLives, numShips, 'c'); //invokes shipSunk to check if the computer 
                                                   //sunk any ships and updates the number of ships
    if (x > numShips) {
      //If x is greater than the updated number of ships, the computer sunk one of the user's ships
      scd[0] = 0; //Turns Smart computer attack off
      scd[5] = 0; //resets to phase 1
    }
    return numShips; //returns the updated number of ships 
  }

  /************
   * This method activates a radar, which is a powerup. Radar gives the 
   * coordinates of a point near an enemy ship
   * 
   * @param first
   *    the map where the enemy ships are located
   * @param second
   *    The symbols that are used to print the map 
   ***************/  
  public static void useRadar(int[][] map, String[] symbols) 
  throws InterruptedException {  
    Random rand = new Random();
    //xCor and yCor store the coordinates of an enemy ship
    int xCor = 0; 
    int yCor = 0; 
    //since radar gives the coordinates near an enemy ship, the xCor and yCor 
    //need to be shifted by a bit. ShiftX and shiftY store where to shift the x and yCor 
    int shiftX; 
    int shiftY;

    String coord; //A string version of the coordinates with letters

    //The following for loop iterates through the map untill it finds a ship
    for(int i = 1; i < map.length; i++) {
      for(int j = 1; j < map[i].length; j++) {
        if (checkRange(map[i][j], 1, 5)) {
          xCor = j; //sets xCor and yCor to the coordinates of the ship
          yCor = i;
          j = map[i].length - 1; //This makes the program exit the loop 
          i = map.length - 1;
        }
      }
    }

    //The following loop randomly decides where to shift the xCor and yCor
    do {
      do {
        shiftX = rand.nextInt(3) - 1; //generates random number between -1 and 1
      } while(!checkRange(xCor + shiftX, 1, 11)); //checks if the coord will be out of bounds

      do {
        shiftY = rand.nextInt(3) - 1; //generates random number between -1 and 1
      } while(!checkRange(yCor + shiftY, 1, 9)); //checks if the coord will be out of bounds
    } while (checkRange(map[yCor + shiftY][xCor + shiftX], 1, 6)); //checks if the coordinates are on an enemy ship
    
    xCor += shiftX; //shifts the x and y coords
    yCor += shiftY;
    
    map[yCor][xCor] = 8; //stores an 8 which represents radar in the map
    //The following lines let the user know where the ship is
    coord = "" + (char)(xCor + 64) + "" + yCor;
    pause(0.75);
    System.out.println("An enemy ship has been spotted near " + coord);
    pause(0.5);
    printMap(map, symbols, "        Attaking Panel");
    pause(1.5);
  }

  /************
   * This method activates an airstrike, which is a powerup. Airstrike attacks
   * the whole column and row of a coordinate
   * 
   * @param first
   *    the map where the enemy ships are located
   * @param second
   *    an array that stores the lives of the ships
   * @param third
   *    the number of ships that the enemy has
   * @param fourth
   *    The symbols that are used to print the map 
   * @return
   *    the updated number of ships that the enemy has
   ***************/ 
  public static int useAirstrike(int[][] map, int[] shipLives, int numShips, String[] symbols) 
  throws InterruptedException {  
    String coord; //string version of coords
    int xCor; // x coord
    int yCor; // y coord

    //Inputs the coordinates to attack and checks validity
    coord = inputStr("To activate airstrike, \nenter a coordinate to attack: ");
    while(!validCoordinates(coord)) {
      coord = inputStr("      Enter valid coordinates: ");
    }
    
    xCor = getXCor(coord); //isolates x coord 
    yCor = getYCor(coord); //isolates y coord

    //The following loop iterates through the whole row and atacks each coord
    for(int i = 1; i < 12; i++) {
      if(checkRange(map[yCor][i], 1, 6)) {      
        if (map[yCor][i] != 6) {
          //if the user hit, decreases ship lives and stores a 6 (hit) in the map
          shipLives[map[yCor][i] - 1]--;
          map[yCor][i] = 6;
        }
      }
      else {
        map[yCor][i] = 7; //if the user misses, stores a 7 (miss) in the map

      }
    }

    //The following loop iterates through the whole column and atacks each coord
    for(int i = 1; i < 10; i++) {
      if(checkRange(map[i][xCor], 1, 6)) {      
        if (map[i][xCor] != 6) {
          //if the user hit, decreases ship lives and stores a 6 (hit) in the map
          shipLives[map[i][xCor] - 1]--;
          map[i][xCor] = 6;
        }
      }
      else {
        map[i][xCor] = 7; //if the user misses, stores a 7 (miss) in the map

      }
    }

    // a short animation
    System.out.print("3, ");
    pause(0.6);
    System.out.print("2, ");
    pause(0.6);
    System.out.println("1");
    pause(0.6);
    System.out.println("Destroy!!");
    pause(0.5);

    printMap(map, symbols, "        Attaking Panel"); //prints map
    numShips = shipSunk(shipLives, numShips, 'u'); //checks if the user sunk any ships
    pause(2);
    return numShips; 
  }

  /************
   * This method outputs the shop and allows the user to buy powerups with their points
   * 
   * @param first
   *    an array that stores how many powerups the user has
   * @param second
   *    the users points
   * @return
   *    the updated points
   ***************/ 
  public static int shop(int[] powerups, int points)
  throws InterruptedException {  
    int choice; // the users choice
    do {
      //Outputs menu
      System.out.println("\nSHOP");
      System.out.println("   Your points: " + points);
      System.out.println("\n   1 >> Radar : 30 points");
      System.out.println("        Description: A radar can detect the\n        position of enemy ships. When used, a radar\n        will tell you coordinates *near* an enemy\n        ship (The coordinates will not be exact).\n        This coordinate will be represented on the\n        map by an \"R\"");
      System.out.println("   2 >> Airstrike : 50 points");
      System.out.println("        Description: Destroy a whole row and column\n        using an airstrike");
      System.out.println("   3 >> Exit"); 
      choice = inputInt("Your Choice: ");//inputs choice
      while (!checkRange(choice, 1, 4)) {
        choice = inputInt("   Enter a valid choice: ");//checks choice
      }
      if (choice != 3) {
        switch(choice) {
          case 1: // case 1 = radar
            if (points < 30) {
              //checks if the user has enough money to buy a radar
              System.out.println("\nYou don't have enough points");
            }
            else {
              System.out.println("\nPurchase successful");
              powerups[0] += 1; //increases number of radars by 1
              points -= 30; //decreases points
            }
            break;
          case 2:
            if (points < 50) {
              //checks if the user has enough points to buy an airstrike
              System.out.println("\nYou don't have enough points");
            }
            else {
              System.out.println("\nPurchase successful");
              powerups[1] += 1; //increases number of airstrikes by 1
              points -= 50; //decreases points
            }
            break; 
        } 
      }
    pause(1.5);
    clear();
    } while(choice != 3);
    return points;
  }

  /************
   * This method determines who won
   * 
   * @param first
   *    the number of ships that the user has
   * @param second
   *    the number of ships that the computer has
   * @return
   *    a char that represents the winner
   ***************/ 
  public static char getWinner(int numShipsUser, int numShipsComp) {
    char winner; //a char that represents the winner
    if (numShipsUser == 0) {
      //if the user has 0 ships, the computer wins
      winner = 'c';
      System.out.println("\nThe enemy sunk all of your ships. You lost\n");
    }
    else {
      //if the computer has 0 ships, the user wins
      winner = 'u';
      System.out.println("\nYou sunk all of the enemy ships! You Win!!!\n");
    }
    inputStr("Enter any key to continue: ");
    return winner; //returns winner
  }
  
  /************
   * This method calculates the user's score
   * 
   * @param first
   *    an array thet stores the score, high score, total points, and turns taken
   * @param second
   *    the map where the user's ships are deployed
   * @param third
   *    the winner
   ***************/ 
  public static void calcScore(int[] score, int[][] map, char winner) {
    score[0] = 0;//initializes score to 0

    if (winner == 'u') { //Only calculates score if the player won. if they lose, the score is 0
      for(int i = 1; i < map.length; i++) {
        for(int j = 1; j < map[i].length; j++) {
          if (checkRange(map[i][j], 1, 5)) {
            score[0] ++; //increases the score for every ship that survived
          }
        }
      }
      
      //the following code uses the turns taken in that round aas a muliplier to increase the score
      score[0] = (int)Math.ceil((score[0] * (1 + (100 - score[3])/100.0)) * 10);
      
      score[1] += score[0]; //increases total points

      if (score[0] > score[2]) {
        score[2] = score[0]; //sets high score
      }
    }
    score[3] = 0; //resets turns taken
  }

  /************
   * This method outputs the scores
   * 
   * @param first
   *    the scores
   ***************/ 
  public static void outScores(int[] score) {
    //outputs scores
    System.out.println("\nSCORES");
    System.out.println("  Score: " + score[0]);
    System.out.println("  Total Score: " + score[1]);
    System.out.println("  High Score: " + score[2]);
    inputStr("Enter any key to continue: ");
  }

  /************
   * This method resets the variables every time a game ends
   *
   * @param first
   *    the 2D array that stores the map
   * @param second
   *    an array that stores the ship lives
   ***************/ 
  public static void reset(int[][] map, int[] shipLives)
  {
    for(int i = 1; i < map.length; i++) {
      for(int j = 1; j < map[i].length; j++) {
        map[i][j] = 0; //resets all values un the map to 0
      }
    }

    int counter = 2;
    for(int i = 0; i < 5; i++) {
      shipLives[i] = counter; //resets ship lives to 2,3,3,4,5
      if (i != 1) {
        counter++;
      }
    }
  }

  /*********************
  Outputs the outro
  *********************/
  public static void outro() {
    System.out.println("Thank you for playing Battleship");
  }
  public static void main(String[] args) 
  throws InterruptedException {
      
    //variables for User
    int[][] userMap = new int[10][12]; //This is a 2D array that stores where the user's ships are located
    String[] userSymbols = {". ", "D ", "S ", "c ", "B ", "C ", "X ", "- ", "R "}; //This array stores the symbols that are printed on the user's map
    int[] shipLivesUser = {2, 3, 3, 4, 5}; //This array stores the lives of the user's ships
    int numShipsUser; //The number of ships that the user has
    int[] powerUps = new int[2]; //the number of  each powerUp that the user has

    //variables for Computer
    int[][] compMap = new int[10][12]; //This is a 2D array that stores where the computer's ships are located
    String[] compSymbols = {". ", ". ", ". ", ". ", ". ", ". ", "X ", "- ", "R "}; //This array stores the symbols that are printed on the computer's map
    int[] shipLivesComp = {2, 3, 3, 4, 5}; //This array stores the lives of the computer's ships
    int numShipsComp; //The number of ships that the computer has
    int[] scd = {0, 7, 8, 0, 0, 0, 0, 1, 0, -1, 0}; //Smart Computer Data ***Read the explanation at the bottom of the code

    //Common variables for both
    int choice; //the user's choice
    String coord; //coordinates
    char winner; //the winner
    int[] score = new int[4]; //this array stores the user's score, high score, and total points
   
    //The following loop conrolls the game and is repeated untill the user exits
    do{
      choice = mainMenu(); //gets user's choice
      pause(0.5);
      if (choice != 4){
        switch(choice) {
          case 1: //case 1 = play game
            numShipsUser = 5; //initializes number of ships
            numShipsComp = 5;
            //prints map
            printMap(userMap, userSymbols, "       The Sea is Empty");
            deployShipsUser(userMap); //deploys the user's ships
            deployComp(compMap, 'c');//deploys the computer's ships
            
            //The following loop controlls each round. It is repeated untill someone wins
            do{
              //prints maps
              printMap(compMap, compSymbols, "        Attaking Panel");
              printMap(userMap, userSymbols, "          Your ships");
            
              do {
                coord = getAtkCoord(compMap, powerUps); //gets coords that the user would like to attack
                if (coord.equalsIgnoreCase("r")) {
                  useRadar(compMap, compSymbols); //activates radar if the user would like to use their radar
                  powerUps[0]--;
                }
                else if (coord.equalsIgnoreCase("a")) {
                  numShipsComp = useAirstrike(compMap, shipLivesComp, numShipsComp, compSymbols); //activates airstrike if the user would like to use their airstrike
                  powerUps[1]--;
                }
                else {
                  //if the user didn't want to use a powerup, the coords that they enteres are attacked
                  numShipsComp = userAtk(compMap, coord, shipLivesComp, numShipsComp);
                }
              } while(coord.equalsIgnoreCase("r"));
            
              //numShipsComp = compAtk(compMap, shipLivesComp, numShipsComp, scdA);
              score[3]++; //increments the number of turns taken

              if (numShipsComp > 0) {
                //The computer attacks
                numShipsUser = compAtk(userMap, shipLivesUser, numShipsUser, scd);
              }
            }while(numShipsUser != 0 && numShipsComp != 0); //repeats untill some one loses
            
            //After the game is finished, the maps are printed again to reveal where the enemy ships were
            printMap(compMap, userSymbols, "        Attaking Panel");
            printMap(userMap, userSymbols, "          Your ships");

            winner = getWinner(numShipsUser, numShipsComp); //determines winner

            calcScore(score, userMap, winner); //calculates score
            outScores(score); //outputs score

            reset(userMap, shipLivesUser); //resets arrays
            reset(compMap, shipLivesComp);
            scd[0] = 0;
            clear();
            break; 
          case 2: //case 2 = shop
            score[1] = shop(powerUps, score[1]);//outputs shop
            break;
          case 3: //case 3 = instruction
            instrucions(userMap, userSymbols); //outputs instruction
            break;
        }
      }
    } while(choice != 4);
    outro();
  }
}
/*************************************************
Smart Computer Attack
  * this block of commenting explains how the smart computer
    attack feature is used in this program

This feature allows the computer to attack the user's ships 
strategically rather than randomly to make the game more challenging
When a human plays battleship, fisrt they start off by attacking random
coordinates. Once they hit an enemy ship, instead of attacking random
coordinates, they attack adjacent coordinates untill the sink the whole 
ship. Smart computer atttack allows the computer to do this

There are 3 phases in SCA (Smart Computer Attack)
Phase 1:
  * During phase 1, the computer has just hit an enemy ship. The computer 
    then starts attacking adjacent coords (coordinates). 
    For example, first, the computer attacks the coord to the right. if it
    hits an enemy ship the computer moves on to the next phase. If the computer
    misses it attacks the coord under, then the coord to the left, and finally
    the coord above. The computer does this to find the direction of the ship
Phase 2:
  * Phase 2 starts when the computer finds the direction of the ship in phase 1.
    In this phase the computer continues to attack in the same direction untill 
    it sinks the ship or reaches the end of the ship. If the ship is sunk, the
    computer is finished and skips phase 3. Otherwise the computer moves on
    on to phase 3 when it reaches the end of the ship
phase 3:
  * Phase 3 starts when the computer reaches the end of the ship in phase 2. This 
    means that the rest of the ship is on the other side. In this phase the computer
    starts attacking the other side of the ship untill it sinks the ship. Once the
    ship is sunk, the computer starts attacking random coords again

Smart Computer Data
In order for this feature to work, the information about the computer's previous attack
must be stored somewhere. and array of length 11 called SCD (Smart Computer Data) is
used to store this data
SCD:
  * SCD[0] stores wether this feature should be turned on or off. It is turned on when
    the computer hits a ship and is turned off when the computer sinks the ship
  * SCD[1-2 and 7-10]:
    SCD[1] and SCD[2] are pointers that point to values that represent which direction 
    to attack. SCD[1] represents the x coord and SCD[2] represents the y coord. The 
    values that are pointed at are stored in SCD[7-10]. These values are always 1, 
    0, -1, and 0 respectively. For exapmle, if SCD[1] = 7 and SCD[2] = 8, the 
    direction to attack is right because the x coord is increased by 1 and the 
    y coord is unchanged. SCD[7-10] are arranged in such a way that if you increment
    the pointer, the direction will change to the next direction in a clockwise rotation.
    For example if SCD[1 and 2] are incremented to 8 and 9, the direction is down
  * SCD[3-4]: These indexes store where computer attacked previously. SCD[3] is the x
    coord and SCD[4] is the y coord
  * SCD[5]: SCD[5] is the current phase of SCA (refer to the explanation of the phases
    above). 0 = phase 1, 1 = phase 2, and 2 = phase 3.
**************************************************/
