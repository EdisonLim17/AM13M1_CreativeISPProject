import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Key here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Key extends Actor
{
    //declaring the image and initializing the dimensions, label font, and colors of the keys
    private GreenfootImage image;
    public static final int NATURAL_WIDTH = GameWorld.WORLD_WIDTH / 22;
    public static final int NATURAL_HEIGHT = GameWorld.WORLD_HEIGHT * 3 / 5;
    public static final int FLAT_WIDTH = GameWorld.WORLD_WIDTH / 50;
    public static final int FLAT_HEIGHT = GameWorld.WORLD_HEIGHT * 3 / 8;
    public static final Color NATURAL_COLOR = Color.WHITE;
    public static final Color FLAT_COLOR = Color.BLACK;
    public static final Color NATURAL_LABEL_COLOR = Color.BLACK;
    public static final Color FLAT_LABEL_COLOR = Color.WHITE;
    public static final Color CORRECT_COLOR = Color.GREEN;
    public static final Color WRONG_COLOR = Color.RED;
    public static final Font LABEL_FONT = new Font("Courier New", true, false, 15);
    
    //declaring the instance variables
    private int width, height;
    private String type, note;
    private GreenfootSound tone;
    private String keybind;
    private boolean correct, keyReleased, spaceReleased, labels;
    
    public Key(String note){
        //determines whether the key type is natural or flat
        if(note.length() == 2){
            type = "natural";
            width = NATURAL_WIDTH;
            height = NATURAL_HEIGHT;
        }
        else{
            type = "flat";
            width = FLAT_WIDTH;
            height = FLAT_HEIGHT;
        }
        //setting up the key
        this.note = note;
        setKeybinds();
        keyReleased = true;
        spaceReleased = true;
        labels = true;
        image = new GreenfootImage(width + 1, height + 1);
        drawKey(false, false, labels);
    }
    
    public void act()
    {
        //checks if the user pressed this key with their mouse or pressed the keybind for this key
        if(Greenfoot.mousePressed(this) || (Greenfoot.isKeyDown(keybind) && keyReleased)){
            //plays the tone of the key
            setTone();
            tone.play();
            if(Greenfoot.isKeyDown(keybind)) keyReleased = false;
            //changes the image of the key depending on whether or not is matches the current note of the piece
            drawKey(GameWorld.checkKey(this), true, labels);
        }
        //checks if the user let go of the key with their mouse
        if(Greenfoot.mouseClicked(null) && keyReleased) drawKey(false, !keyReleased, labels);
        //checks if the let go of the keybind of the key
        if(!keyReleased && !Greenfoot.isKeyDown(keybind)){
            keyReleased = true;
            drawKey(false, !keyReleased, labels);
        }
        //checks if the user pressed the spacebar and toggles the labels if they did
        if(Greenfoot.isKeyDown("space") && spaceReleased){
            labels = !labels;
            drawKey(false, false, labels);
            spaceReleased = false;
        }
        if(!spaceReleased && !Greenfoot.isKeyDown("space")) spaceReleased = true; 
    }
    
    //method to set the tone of the key
    private void setTone(){
        if(note.equals("C1")) tone = new GreenfootSound("C3.mp3");
        else if(note.equals("Db1")) tone = new GreenfootSound("Db3.mp3");
        else if(note.equals("D1")) tone = new GreenfootSound("D3.mp3");
        else if(note.equals("Eb1")) tone = new GreenfootSound("Eb3.mp3");
        else if(note.equals("E1")) tone = new GreenfootSound("E3.mp3");
        else if(note.equals("F1")) tone = new GreenfootSound("F3.mp3");
        else if(note.equals("Gb1")) tone = new GreenfootSound("Gb3.mp3");
        else if(note.equals("G1")) tone = new GreenfootSound("G3.mp3");
        else if(note.equals("Ab1")) tone = new GreenfootSound("Ab3.mp3");
        else if(note.equals("A1")) tone = new GreenfootSound("A3.mp3");
        else if(note.equals("Bb1")) tone = new GreenfootSound("Bb3.mp3");
        else if(note.equals("B1")) tone = new GreenfootSound("B3.mp3");
        else if(note.equals("C2")) tone = new GreenfootSound("C4.mp3");
        else if(note.equals("Db2")) tone = new GreenfootSound("Db4.mp3");
        else if(note.equals("D2")) tone = new GreenfootSound("D4.mp3");
        else if(note.equals("Eb2")) tone = new GreenfootSound("Eb4.mp3");
        else if(note.equals("E2")) tone = new GreenfootSound("E4.mp3");
        else if(note.equals("F2")) tone = new GreenfootSound("F4.mp3");
        else if(note.equals("Gb2")) tone = new GreenfootSound("Gb4.mp3");
        else if(note.equals("G2")) tone = new GreenfootSound("G4.mp3");
        else if(note.equals("Ab2")) tone = new GreenfootSound("Ab4.mp3");
        else if(note.equals("A2")) tone = new GreenfootSound("A4.mp3");
        else if(note.equals("Bb2")) tone = new GreenfootSound("Bb4.mp3");
        else if(note.equals("B2")) tone = new GreenfootSound("B4.mp3");
        else if(note.equals("C3")) tone = new GreenfootSound("C5.mp3");
        else if(note.equals("Db3")) tone = new GreenfootSound("Db5.mp3");
        else if(note.equals("D3")) tone = new GreenfootSound("D5.mp3");
        else if(note.equals("Eb3")) tone = new GreenfootSound("Eb5.mp3");
        else if(note.equals("E3")) tone = new GreenfootSound("E5.mp3");
        else if(note.equals("F3")) tone = new GreenfootSound("F5.mp3");
        else if(note.equals("Gb3")) tone = new GreenfootSound("Gb5.mp3");
        else if(note.equals("G3")) tone = new GreenfootSound("G5.mp3");
        else if(note.equals("Ab3")) tone = new GreenfootSound("Ab5.mp3");
        else if(note.equals("A3")) tone = new GreenfootSound("A5.mp3");
        else if(note.equals("Bb3")) tone = new GreenfootSound("Bb5.mp3");
        else if(note.equals("B3")) tone = new GreenfootSound("B5.mp3");
        else if(note.equals("C4")) tone = new GreenfootSound("C6.mp3");
    }
    
    //method to set the keybind of the key
    private void setKeybinds(){
        if(note.equals("C1")) keybind = "q";
        else if(note.equals("Db1")) keybind = "2";
        else if(note.equals("D1")) keybind = "w";
        else if(note.equals("Eb1")) keybind = "3";
        else if(note.equals("E1")) keybind = "e";
        else if(note.equals("F1")) keybind = "r";
        else if(note.equals("Gb1")) keybind = "5";
        else if(note.equals("G1")) keybind = "t";
        else if(note.equals("Ab1")) keybind = "6";
        else if(note.equals("A1")) keybind = "y";
        else if(note.equals("Bb1")) keybind = "7";
        else if(note.equals("B1")) keybind = "u";
        else if(note.equals("C2")) keybind = "i";
        else if(note.equals("Db2")) keybind = "9";
        else if(note.equals("D2")) keybind = "o";
        else if(note.equals("Eb2")) keybind = "0";
        else if(note.equals("E2")) keybind = "p";
        else if(note.equals("F2")) keybind = "z";
        else if(note.equals("Gb2")) keybind = "s";
        else if(note.equals("G2")) keybind = "x";
        else if(note.equals("Ab2")) keybind = "d";
        else if(note.equals("A2")) keybind = "c";
        else if(note.equals("Bb2")) keybind = "f";
        else if(note.equals("B2")) keybind = "v";
        else if(note.equals("C3")) keybind = "b";
        else if(note.equals("Db3")) keybind = "h";
        else if(note.equals("D3")) keybind = "n";
        else if(note.equals("Eb3")) keybind = "j";
        else if(note.equals("E3")) keybind = "m";
        else if(note.equals("F3")) keybind = ",";
        else if(note.equals("Gb3")) keybind = "l";
        else if(note.equals("G3")) keybind = ".";
        else if(note.equals("Ab3")) keybind = ";";
        else if(note.equals("A3")) keybind = "/";
        else if(note.equals("Bb3")) keybind = "'";
        else if(note.equals("B3")) keybind = "shift";
        else if(note.equals("C4")) keybind = "enter";
    }
    
    //method to draw the key depending on its current status
    private void drawKey(boolean correct, boolean keyPressed, boolean labels){
        //clears the current image
        if(image != null) image.clear();
        //draws the new image
        if(type.equals("natural")) image.setColor(NATURAL_COLOR);
        else image.setColor(FLAT_COLOR);
        if(keyPressed){
            if(correct) image.setColor(CORRECT_COLOR);
            else image.setColor(WRONG_COLOR);
        }
        image.fill();
        image.setColor(Color.BLACK);
        image.drawRect(0, 0, width, height);
        //adds the label if labels are on
        if(labels){
            image.setFont(LABEL_FONT);
            if(type.equals("natural")) image.setColor(NATURAL_LABEL_COLOR);
            else image.setColor(FLAT_LABEL_COLOR);
            image.drawString(keybind, (image.getWidth() - (int)(keybind.length() * LABEL_FONT.getSize() * 0.58)) / 2, image.getHeight() * 9 / 10);
        }
        setImage(image);
    }
}