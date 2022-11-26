import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    //initializing the world dimensions
    public static final int WORLD_WIDTH = 1100;
    public static final int WORLD_HEIGHT = 500;
    
    //declaring the piano keys
    private Key C1, Db1, D1, Eb1, E1, F1, Gb1, G1, Ab1, A1, Bb1, B1;
    private Key C2, Db2, D2, Eb2, E2, F2, Gb2, G2, Ab2, A2, Bb2, B2;
    private Key C3, Db3, D3, Eb3, E3, F3, Gb3, G3, Ab3, A3, Bb3, B3, C4;
    
    //declaring the title, sheet music, and tracker
    private Title title;
    private SheetMusic sheetMusic;
    private static Tracker tracker;
    //declaring the notes and locations arrays for each piece
    private static Key[] piece1Notes, piece2Notes, piece3Notes, piece4Notes, piece5Notes;
    private static int[] piece1Locations, piece2Locations, piece3Locations, piece4Locations, piece5Locations;
    //declaring the arrays for the notes and locations for the current piece
    private static Key[] notes;
    private static int[] locations;
    //declaring the index variables to track the current piece and note
    private static int currPiece, currNote;
    
    public GameWorld()
    {    
        // Create a new world with WORLD_WIDTH * WORLD_HEIGHT cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        
        //setting up the piano keys
        setupPiano();
        //initializing the notes and locations arrays for each piece
        piece1Notes = new Key[22];
        piece1Locations = new int[22];
        piece2Notes = new Key[24];
        piece2Locations = new int[24];
        piece3Notes = new Key[18];
        piece3Locations = new int[18];
        piece4Notes = new Key[20];
        piece4Locations = new int[20];
        piece5Notes = new Key[40];
        piece5Locations = new int[40];
        //setting up the notes and locations arrays for each piece
        setupPiece1();
        setupPiece2();
        setupPiece3();
        setupPiece4();
        setupPiece5();
        
        //setting the current piece and note
        currPiece = 0;
        currNote = 0;
        
        if(currPiece == 0){
            notes = piece1Notes;
            locations = piece1Locations;
        }
        else if(currPiece == 1) {
            notes = piece2Notes;
            locations = piece2Locations;
        }
        else if(currPiece == 2){
            notes = piece3Notes;
            locations = piece3Locations;
        }
        else if(currPiece == 3){
            notes = piece4Notes;
            locations = piece4Locations;
        }
        else if(currPiece == 4){
            notes = piece5Notes;
            locations = piece5Locations;
        }
        
        //adding the title, sheet music, and tracker to the world
        title = new Title();
        addObject(title, getWidth() / 2, getHeight() * 3 / 40);
        title.setTitle(currPiece);
        sheetMusic = new SheetMusic();
        addObject(sheetMusic, getWidth() / 2, getHeight() * 11 / 40);
        sheetMusic.setSheetMusic(currPiece);
        tracker = new Tracker();
        addObject(tracker, locations[0], getHeight() * 11 / 40);
    }
    
    public void act(){
        //changes the current piece to the next piece if the user presses the "tab" key
        if(Greenfoot.getKey() == "control"){
            //changing to the next piece
            currNote = 0;
            currPiece++;
            if(currPiece > 4) currPiece = 0;
            
            //setting up the next piece
            if(currPiece == 0){
                notes = piece1Notes;
                locations = piece1Locations;
            }
            else if(currPiece == 1) {
                notes = piece2Notes;
                locations = piece2Locations;
            }
            else if(currPiece == 2){
                notes = piece3Notes;
                locations = piece3Locations;
            }
            else if(currPiece == 3){
                notes = piece4Notes;
                locations = piece4Locations;
            }
            else if(currPiece == 4){
                notes = piece5Notes;
                locations = piece5Locations;
            }
            
            //changing the title, sheet music, and tracker to match the next piece
            title.setTitle(currPiece);
            sheetMusic.setSheetMusic(currPiece);
            tracker.setLocation(locations[currNote]);
        }
    }
    
    //method to check if the key the user pressed matches the current note of the song
    public static boolean checkKey(Key key){
        if(notes[currNote] == key){
            //moves to the next note
            currNote++;
            if(currNote == notes.length) currNote = 0;
            //moves tracker to the location of the next note
            tracker.setLocation(locations[currNote]);
            return true;
        }
        return false;
    }
    
    //method to setup the piano keys
    private void setupPiano(){
        C1 = new Key("C1");
        addObject(C1, getWidth() / 44, getHeight() * 7 / 10);
        D1 = new Key("D1");
        addObject(D1, getWidth() * 3 / 44, getHeight() * 7 / 10);
        E1 = new Key("E1");
        addObject(E1, getWidth() * 5 / 44, getHeight() * 7 / 10);
        F1 = new Key("F1");
        addObject(F1, getWidth() * 7 / 44, getHeight() * 7 / 10);
        G1 = new Key("G1");
        addObject(G1, getWidth() * 9 / 44, getHeight() * 7 / 10);
        A1 = new Key("A1");
        addObject(A1, getWidth() * 11 / 44, getHeight() * 7 / 10);
        B1 = new Key("B1");
        addObject(B1, getWidth() * 13 / 44, getHeight() * 7 / 10);
        C2 = new Key("C2");
        addObject(C2, getWidth() * 15 / 44, getHeight() * 7 / 10);
        D2 = new Key("D2");
        addObject(D2, getWidth() * 17 / 44, getHeight() * 7 / 10);
        E2 = new Key("E2");
        addObject(E2, getWidth() * 19 / 44, getHeight() * 7 / 10);
        F2 = new Key("F2");
        addObject(F2, getWidth() * 21 / 44, getHeight() * 7 / 10);
        G2 = new Key("G2");
        addObject(G2, getWidth() * 23 / 44, getHeight() * 7 / 10);
        A2 = new Key("A2");
        addObject(A2, getWidth() * 25 / 44, getHeight() * 7 / 10);
        B2 = new Key("B2");
        addObject(B2, getWidth() * 27 / 44, getHeight() * 7 / 10);
        C3 = new Key("C3");
        addObject(C3, getWidth() * 29 / 44, getHeight() * 7 / 10);
        D3 = new Key("D3");
        addObject(D3, getWidth() * 31 / 44, getHeight() * 7 / 10);
        E3 = new Key("E3");
        addObject(E3, getWidth() * 33 / 44, getHeight() * 7 / 10);
        F3 = new Key("F3");
        addObject(F3, getWidth() * 35 / 44, getHeight() * 7 / 10);
        G3 = new Key("G3");
        addObject(G3, getWidth() * 37 / 44, getHeight() * 7 / 10);
        A3 = new Key("A3");
        addObject(A3, getWidth() * 39 / 44, getHeight() * 7 / 10);
        B3 = new Key("B3");
        addObject(B3, getWidth() * 41 / 44, getHeight() * 7 / 10);
        C4 = new Key("C4");
        addObject(C4, getWidth() * 43 / 44, getHeight() * 7 / 10);
        Db1 = new Key("Db1");
        addObject(Db1, getWidth() / 22 - Db1.FLAT_WIDTH / 6, getHeight() * 47 / 80 + 1);
        Eb1 = new Key("Eb1");
        addObject(Eb1, getWidth() * 2 / 22 + Eb1.FLAT_WIDTH / 6, getHeight() * 47 / 80 + 1);
        Gb1 = new Key("Gb1");
        addObject(Gb1, getWidth() * 4 / 22 - Gb1.FLAT_WIDTH / 6, getHeight() * 47 / 80 + 1);
        Ab1 = new Key("Ab1");
        addObject(Ab1, getWidth() * 5 / 22, getHeight() * 47 / 80 + 1);
        Bb1 = new Key("Bb1");
        addObject(Bb1, getWidth() * 6 / 22 + Bb1.FLAT_WIDTH / 6, getHeight() * 47 / 80 + 1);
        Db2 = new Key("Db2");
        addObject(Db2, getWidth() * 8/ 22 - Db2.FLAT_WIDTH / 6, getHeight() * 47 / 80 + 1);
        Eb2 = new Key("Eb2");
        addObject(Eb2, getWidth() * 9 / 22 + Eb2.FLAT_WIDTH / 6, getHeight() * 47 / 80 + 1);
        Gb2 = new Key("Gb2");
        addObject(Gb2, getWidth() * 11 / 22 - Gb2.FLAT_WIDTH / 6, getHeight() * 47 / 80 + 1);
        Ab2 = new Key("Ab2");
        addObject(Ab2, getWidth() * 12 / 22, getHeight() * 47 / 80 + 1);
        Bb2 = new Key("Bb2");
        addObject(Bb2, getWidth() * 13 / 22 + Bb2.FLAT_WIDTH / 6, getHeight() * 47 / 80 + 1);
        Db3 = new Key("Db3");
        addObject(Db3, getWidth() * 15/ 22 - Db3.FLAT_WIDTH / 6, getHeight() * 47 / 80 + 1);
        Eb3 = new Key("Eb3");
        addObject(Eb3, getWidth() * 16 / 22 + Eb3.FLAT_WIDTH / 6, getHeight() * 47 / 80 + 1);
        Gb3 = new Key("Gb3");
        addObject(Gb3, getWidth() * 18 / 22 - Gb3.FLAT_WIDTH / 6, getHeight() * 47 / 80 + 1);
        Ab3 = new Key("Ab3");
        addObject(Ab3, getWidth() * 19 / 22, getHeight() * 47 / 80 + 1);
        Bb3 = new Key("Bb3");
        addObject(Bb3, getWidth() * 20 / 22 + Bb3.FLAT_WIDTH / 6, getHeight() * 47 / 80 + 1);
    }
    
    //method to setup the notes and note locations for piece 1
    private void setupPiece1(){
        piece1Notes[0] = F1;
        piece1Notes[1] = G1;
        piece1Notes[2] = E2;
        piece1Notes[3] = A1;
        piece1Notes[4] = F2;
        piece1Notes[5] = G2;
        piece1Notes[6] = F2;
        piece1Notes[7] = E2;
        piece1Notes[8] = D2;
        piece1Notes[9] = C2;
        piece1Notes[10] = A1;
        piece1Notes[11] = F1;
        piece1Notes[12] = G1;
        piece1Notes[13] = E2;
        piece1Notes[14] = A1;
        piece1Notes[15] = F2;
        piece1Notes[16] = G2;
        piece1Notes[17] = F2;
        piece1Notes[18] = E2;
        piece1Notes[19] = D2;
        piece1Notes[20] = C2;
        piece1Notes[21] = D2;
        
        piece1Locations[0] = 94;
        piece1Locations[1] = 117;
        piece1Locations[2] = 136;
        piece1Locations[3] = 178;
        piece1Locations[4] = 198;
        piece1Locations[5] = 217;
        piece1Locations[6] = 387;
        piece1Locations[7] = 418;
        piece1Locations[8] = 438;
        piece1Locations[9] = 477;
        piece1Locations[10] = 499;
        piece1Locations[11] = 604;
        piece1Locations[12] = 627;
        piece1Locations[13] = 646;
        piece1Locations[14] = 688;
        piece1Locations[15] = 708;
        piece1Locations[16] = 727;
        piece1Locations[17] = 897;
        piece1Locations[18] = 928;
        piece1Locations[19] = 948;
        piece1Locations[20] = 987;
        piece1Locations[21] = 1007;
    }
    
    //method to setup the notes and note locations for piece 2
    private void setupPiece2(){
        piece2Notes[0] = G1;
        piece2Notes[1] = D2;
        piece2Notes[2] = G2;
        piece2Notes[3] = E2;
        piece2Notes[4] = G1;
        piece2Notes[5] = D2;
        piece2Notes[6] = G2;
        piece2Notes[7] = E2;
        piece2Notes[8] = B2;
        piece2Notes[9] = C3;
        piece2Notes[10] = D3;
        piece2Notes[11] = C3;
        piece2Notes[12] = D3;
        piece2Notes[13] = Eb3;
        piece2Notes[14] = D3;
        piece2Notes[15] = C3;
        piece2Notes[16] = D3;
        piece2Notes[17] = C3;
        piece2Notes[18] = D3;
        piece2Notes[19] = Eb3;
        piece2Notes[20] = F3;
        piece2Notes[21] = C3;
        piece2Notes[22] = F3;
        piece2Notes[23] = G3;
        
        piece2Locations[0] = 120;
        piece2Locations[1] = 148;
        piece2Locations[2] = 183;
        piece2Locations[3] = 238;
        piece2Locations[4] = 338;
        piece2Locations[5] = 366;
        piece2Locations[6] = 402;
        piece2Locations[7] = 455;
        piece2Locations[8] = 477;
        piece2Locations[9] = 511;
        piece2Locations[10] = 554;
        piece2Locations[11] = 586;
        piece2Locations[12] = 617;
        piece2Locations[13] = 655;
        piece2Locations[14] = 698;
        piece2Locations[15] = 720;
        piece2Locations[16] = 798;
        piece2Locations[17] = 829;
        piece2Locations[18] = 860;
        piece2Locations[19] = 898;
        piece2Locations[20] = 941;
        piece2Locations[21] = 963;
        piece2Locations[22] = 997;
        piece2Locations[23] = 1042;
    }
    
    //method to setup the notes and note locations for piece 3
    private void setupPiece3(){
        piece3Notes[0] = D3;
        piece3Notes[1] = Db3;
        piece3Notes[2] = C3;
        piece3Notes[3] = B2;
        piece3Notes[4] = Bb2;
        piece3Notes[5] = A2;
        piece3Notes[6] = Ab2;
        piece3Notes[7] = D3;
        piece3Notes[8] = G2;
        piece3Notes[9] = Ab2;
        piece3Notes[10] = G2;
        piece3Notes[11] = Gb2;
        piece3Notes[12] = F2;
        piece3Notes[13] = E2;
        piece3Notes[14] = Eb2;
        piece3Notes[15] = D2;
        piece3Notes[16] = G2;
        piece3Notes[17] = C2;
        
        piece3Locations[0] = 178;
        piece3Locations[1] = 207;
        piece3Locations[2] = 230;
        piece3Locations[3] = 267;
        piece3Locations[4] = 304;
        piece3Locations[5] = 341;
        piece3Locations[6] = 400;
        piece3Locations[7] = 466;
        piece3Locations[8] = 502;
        piece3Locations[9] = 661;
        piece3Locations[10] = 688;
        piece3Locations[11] = 716;
        piece3Locations[12] = 759;
        piece3Locations[13] = 801;
        piece3Locations[14] = 846;
        piece3Locations[15] = 903;
        piece3Locations[16] = 975;
        piece3Locations[17] = 1011;
    }
    
    //method to setup the notes and note locations for piece 4
    private void setupPiece4(){
        piece4Notes[0] = G2;
        piece4Notes[1] = Ab3;
        piece4Notes[2] = G3;
        piece4Notes[3] = C3;
        piece4Notes[4] = D3;
        piece4Notes[5] = Eb3;
        piece4Notes[6] = D3;
        piece4Notes[7] = Eb3;
        piece4Notes[8] = D3;
        piece4Notes[9] = Ab2;
        piece4Notes[10] = G2;
        piece4Notes[11] = Ab3;
        piece4Notes[12] = G3;
        piece4Notes[13] = C3;
        piece4Notes[14] = D3;
        piece4Notes[15] = Db3;
        piece4Notes[16] = C3;
        piece4Notes[17] = B2;
        piece4Notes[18] = Bb2;
        piece4Notes[19] = A2;
        
        piece4Locations[0] = 103;
        piece4Locations[1] = 157;
        piece4Locations[2] = 211;
        piece4Locations[3] = 267;
        piece4Locations[4] = 336;
        piece4Locations[5] = 381;
        piece4Locations[6] = 408;
        piece4Locations[7] = 452;
        piece4Locations[8] = 479;
        piece4Locations[9] = 533;
        piece4Locations[10] = 602;
        piece4Locations[11] = 656;
        piece4Locations[12] = 710;
        piece4Locations[13] = 766;
        piece4Locations[14] = 835;
        piece4Locations[15] = 942;
        piece4Locations[16] = 973;
        piece4Locations[17] = 1003;
        piece4Locations[18] = 1034;
        piece4Locations[19] = 1063;
    }
    
    //method to setup the notes and note locations for piece 5
    private void setupPiece5(){
        piece5Notes[0] = A2;
        piece5Notes[1] = E2;
        piece5Notes[2] = A2;
        piece5Notes[3] = D3;
        piece5Notes[4] = A2;
        piece5Notes[5] = A2;
        piece5Notes[6] = D3;
        piece5Notes[7] = E3;
        piece5Notes[8] = D3;
        piece5Notes[9] = A2;
        piece5Notes[10] = F2;
        piece5Notes[11] = G2;
        piece5Notes[12] = G2;
        piece5Notes[13] = A2;
        piece5Notes[14] = Bb2;
        piece5Notes[15] = C3;
        piece5Notes[16] = D3;
        piece5Notes[17] = C3;
        piece5Notes[18] = Bb2;
        piece5Notes[19] = G2;
        piece5Notes[20] = A2;
        piece5Notes[21] = E2;
        piece5Notes[22] = A2;
        piece5Notes[23] = D3;
        piece5Notes[24] = A2;
        piece5Notes[25] = A2;
        piece5Notes[26] = D3;
        piece5Notes[27] = E3;
        piece5Notes[28] = D3;
        piece5Notes[29] = E3;
        piece5Notes[30] = F3;
        piece5Notes[31] = G3;
        piece5Notes[32] = G3;
        piece5Notes[33] = A3;
        piece5Notes[34] = Bb3;
        piece5Notes[35] = A3;
        piece5Notes[36] = G3;
        piece5Notes[37] = F3;
        piece5Notes[38] = Eb3;
        piece5Notes[39] = C3;
        
        piece5Locations[0] = 92;
        piece5Locations[1] = 110;
        piece5Locations[2] = 129;
        piece5Locations[3] = 148;
        piece5Locations[4] = 166;
        piece5Locations[5] = 212;
        piece5Locations[6] = 231;
        piece5Locations[7] = 250;
        piece5Locations[8] = 268;
        piece5Locations[9] = 286;
        piece5Locations[10] = 305;
        piece5Locations[11] = 349;
        piece5Locations[12] = 375;
        piece5Locations[13] = 390;
        piece5Locations[14] = 418;
        piece5Locations[15] = 449;
        piece5Locations[16] = 465;
        piece5Locations[17] = 491;
        piece5Locations[18] = 517;
        piece5Locations[19] = 543;
        piece5Locations[20] = 587;
        piece5Locations[21] = 604;
        piece5Locations[22] = 622;
        piece5Locations[23] = 639;
        piece5Locations[24] = 657;
        piece5Locations[25] = 700;
        piece5Locations[26] = 718;
        piece5Locations[27] = 736;
        piece5Locations[28] = 764;
        piece5Locations[29] = 782;
        piece5Locations[30] = 825;
        piece5Locations[31] = 854;
        piece5Locations[32] = 895;
        piece5Locations[33] = 914;
        piece5Locations[34] = 946;
        piece5Locations[35] = 969;
        piece5Locations[36] = 987;
        piece5Locations[37] = 1006;
        piece5Locations[38] = 1034;
        piece5Locations[39] = 1063;
    }
}