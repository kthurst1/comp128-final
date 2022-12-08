
import java.awt.Color;
import edu.macalester.graphics.*;

/**
 * 
 * Class that represents a piece of art.
 * 
 * @author Karley Thurston & Cecelia Kaufmann (12/10/21)
 * 
 */
public class ArtPiece {

    private static final int PICTURE_X = 0;
    private static final int PICTURE_Y = 5;
    private static final int PICTURE_WIDTH = 700;
    private static final int PICTURE_HEIGHT = (int) (700 * 0.98);
    private static final int FONT_SIZE = 25;
    private static final int IMAGE_Y = (int) (PICTURE_HEIGHT*0.05);
    private static final int MAX_IMAGE_WIDTH = (int) (PICTURE_WIDTH*0.9);
    private static final int MAX_IMAGE_HEIGHT = (int) (PICTURE_HEIGHT*0.65);
    private static final int PLAQUE_X = (int) ((int) PICTURE_X + (PICTURE_WIDTH * 0.1));
    private static final int PLAQUE_Y = (int) (PICTURE_HEIGHT * .71);
    private static final int TEXT_X = (int) (PLAQUE_X*1.2);
    private static final int ARTIST_Y = (int) (PICTURE_HEIGHT*0.77);
    private static final int TITLE_Y = (int) (PICTURE_HEIGHT*0.82);
    private static final int DATE_Y = (int) (PICTURE_HEIGHT*0.87);
    private static final int MEDIUM_Y = (int) (PICTURE_HEIGHT*0.92);
    
    private String artist;
    private String title;
    private int date;
    private String medium;
    private String jpgURL;
    private GraphicsGroup picture;

    /**
     * Creates an art piece, an object with a title, date, artist, and medium type.
     * @param jpgURL url of the .jpg of the art piece relative to res directory
     */
    public ArtPiece(String artist, String title, int date, String medium, String jpgURL){
        this.artist = artist;
        this.title = title;
        this.date = date;
        this.medium = medium;
        this.jpgURL = jpgURL;
        picture = new GraphicsGroup();
        frameArtwork();
    }

    /**
     * Method for framing art piece. Framed Artwork is a 
     * @return a framed piece of art for the collection
     */
    private GraphicsGroup frameArtwork(){
        Image image = new Image(jpgURL);
        image.setMaxWidth(MAX_IMAGE_WIDTH);
        image.setMaxHeight(MAX_IMAGE_HEIGHT);
        Rectangle frame = new Rectangle(PICTURE_X, PICTURE_Y, PICTURE_WIDTH, PICTURE_HEIGHT);
        Color frameColor = new Color(110, 76, 45);
        frame.setFillColor(frameColor);
        Rectangle plaque = new Rectangle(PLAQUE_X, PLAQUE_Y, PICTURE_WIDTH * .8, PICTURE_HEIGHT * .25);
        Color plaqueColor = new Color(194, 160, 37);
        plaque.setFillColor(plaqueColor);
        GraphicsText artistText = new GraphicsText(artist, TEXT_X, ARTIST_Y);
        artistText.setFontSize(FONT_SIZE);
        artistText.setFontStyle(FontStyle.BOLD);
        GraphicsText titleText = new GraphicsText(title, TEXT_X, TITLE_Y);
        titleText.setFontSize(FONT_SIZE);
        titleText.setFontStyle(FontStyle.ITALIC);
        GraphicsText dateText = new GraphicsText("c. " + date, TEXT_X, DATE_Y);
        dateText.setFontSize(FONT_SIZE);
        GraphicsText mediumText = new GraphicsText(medium, TEXT_X, MEDIUM_Y);
        mediumText.setFontSize(FONT_SIZE);
        picture.add(frame);
        picture.add(image, (PICTURE_WIDTH/2)-(image.getWidth()/2), IMAGE_Y);
        picture.add(plaque);
        picture.add(artistText);
        picture.add(titleText);
        picture.add(dateText);
        picture.add(mediumText);
        return picture;
    }

    /**
     * Returns artist name as a String.
     */
    public String getArtist() {
        return artist;
    }
    
    /**
     * Returns date of piece as an int.
     */
    public int getDate() {
        return date;
    }

    /**
     * Returns title of art piece as a String.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns medium type of art piece as a String.
     */
    public String getMedium() {
        return medium;
    }

    /**
     * Returns framed art piece, ready for an art gallery.
     */
    public GraphicsGroup getPicture() {
        return picture;
    }


    /**
     * Testing for art piece placement percentages, will use actual canvas which will be found in Art Gallery Class
     */
    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Practice Art Gallery", 1400, 700);
        ArtPiece testArtPiece = new ArtPiece("artist name","title", 1999, "medium", "The Migration Series-Panel 1.jpg");
        canvas.add(testArtPiece.getPicture());
    }
}
