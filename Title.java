import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends Actor
{
    //declaring the image and initializing the title font, color, and background color
    private GreenfootImage image;
    public static final Font TITLE_FONT = new Font("Courier New", true, false, 18);
    public static final Color TITLE_COLOR = Color.BLUE;
    public static final Color BG_COLOR = Color.GREEN;
    //declaring the titles array and composer
    private String[] titles;
    private String composer;
    
    public Title(){
        //setting up the titles array
        titles = new String[5];
        titles[0] = "Echoes (2019) (2:45 - 2:58)";
        titles[1] = "She Dares, She Leaps (2022) (0:00 - 0:18)";
        titles[2] = "Mary Shelley Meets Frankenstein: A Modern Promethean Tango (2019) (2:36 - 2:43)";
        titles[3] = "Haunted Carousel (2014) (0:33 - 0:54)";
        titles[4] = "Category 4 (2021) (2:09 - 2:24)";
        //setting the composer
        composer = "Erika Svanoe";
    }
    
    //method to set the title to the title of the current piece
    public void setTitle(int currPiece){
        if(image != null) image.clear();
        image = new GreenfootImage(GameWorld.WORLD_WIDTH, GameWorld.WORLD_HEIGHT * 3 / 20);
        image.setFont(TITLE_FONT);
        image.setColor(BG_COLOR);
        image.fill();
        image.setColor(TITLE_COLOR);
        image.drawString(titles[currPiece], (image.getWidth() - (int)(titles[currPiece].length() * TITLE_FONT.getSize() * 0.58)) / 2, GameWorld.WORLD_HEIGHT / 16);
        image.drawString(composer, (image.getWidth() - (int)(composer.length() * TITLE_FONT.getSize() * 0.58)) / 2, GameWorld.WORLD_HEIGHT / 9);
        setImage(image);
    }
}