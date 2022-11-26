import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SheetMusic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SheetMusic extends Actor
{
    //declaring the image and initializing the dimensions of the sheet music
    private GreenfootImage image;
    public static final int SHEET_MUSIC_WIDTH = GameWorld.WORLD_WIDTH;
    public static final int SHEET_MUSIC_HEIGHT = GameWorld.WORLD_HEIGHT * 61 / 250;
    //declaring the sheet music array
    private GreenfootImage[] sheetMusic;
    
    public SheetMusic(){
        //setting up the sheet music array
        sheetMusic = new GreenfootImage[5];
        sheetMusic[0] = new GreenfootImage("Echoes.png");
        sheetMusic[1] = new GreenfootImage("SheDaresSheLeaps.png");
        sheetMusic[2] = new GreenfootImage("Frankenstein.png");
        sheetMusic[3] = new GreenfootImage("TheHauntedCarousel.png");
        sheetMusic[4] = new GreenfootImage("Category4.png");
    }
    
    //method to set the sheet music to the sheet music of the current piece
    public void setSheetMusic(int currPiece){
        image = sheetMusic[currPiece];
        image.scale(SHEET_MUSIC_WIDTH, SHEET_MUSIC_HEIGHT);
        setImage(image);
    }
}