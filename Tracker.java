import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tracker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tracker extends Actor
{
    //declaring the image and initializing the dimensions, color, and transparency of the tracker
    private GreenfootImage image;
    public static final int TRACKER_WIDTH = GameWorld.WORLD_WIDTH / 50;
    public static final int TRACKER_HEIGHT = SheetMusic.SHEET_MUSIC_HEIGHT;
    public static final Color TRACKER_COLOR = Color.YELLOW;
    public static final int TRACKER_TRANSPARENCY = 150;
    
    public Tracker(){
        drawImage();
    }
    
    //method to set the location of the tracker
    public void setLocation(int x){
        setLocation(x, GameWorld.WORLD_HEIGHT * 11 / 40);
    }
    
    //method to draw the tracker
    private void drawImage(){
        image = new GreenfootImage(TRACKER_WIDTH, TRACKER_HEIGHT);
        image.setColor(TRACKER_COLOR);
        image.setTransparency(TRACKER_TRANSPARENCY);
        image.fill();
        setImage(image);
    }
}