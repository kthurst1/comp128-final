
import java.util.*;
import edu.macalester.graphics.*;
import edu.macalester.graphics.ui.Button;


/**
 *
 * Class that represents an interactive art gallery.
 * 
 * @author Karley Thurston & Cecelia Kaufmann (12/10/21)
 * 
 */

public class ArtGallery{
    private Exhibit root;
    private boolean addReturn;
    private Exhibit currentExhibit;
    private ArtPiece piece;
    private GraphicsGroup piecePic;

    /**
     * Creates an art gallery, complete with exhibits and art collections.
     */
    public ArtGallery(){
        root = null;
    }

    /**
     * Construct a BinaryTree with a specified root.
     * Should only be used by subclasses.
     *
     * @param root The node that is the root of the tree.
     */
    protected ArtGallery(Exhibit root) {
        this.root = root;
    }

    /**
     * Constructs a new binary tree with data in its root, leftTree
     * as its left subtree and rightTree as its right subtree.
     */
    public ArtGallery(ArtCollection data, ArtGallery leftTree,
                      ArtGallery rightTree) {
        root = new Exhibit(data);
        if (leftTree != null) {
            root.left = leftTree.root;
            leftTree.root.parent = root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
            rightTree.root.parent = root;
        } else {
            root.right = null;
        }
    }

    /**
     * Starter method add.
     *
     * @param item The object being inserted
     * @return true if the object is inserted, false
     * if the object already exists in the tree
     * @pre The object to insert must implement the
     * Comparable interface.
     */
    public boolean add(ArtCollection item) {
        root = add(root, null, item);
        return addReturn;
    }

    /**
     * Recursive add method.
     *
     * @param localRoot The local root of the subtree
     * @param item      The object to be inserted
     * @return The new local root that now contains the
     * inserted item
     * @post The data field addReturn is set true if the item is added to
     * the tree, false if the item is already in the tree.
     */
    private Exhibit add(Exhibit localRoot, Exhibit parent, ArtCollection item) {
        if (localRoot == null) {
            addReturn = true;
            Exhibit newNode = new Exhibit(item);
            newNode.parent = parent;
            return newNode;
        } else if (item.compareTo(localRoot.getArt()) == 0) {
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.getArt()) < 0) {
            localRoot.left = add(localRoot.left, localRoot, item);
            return localRoot;
        } else {
            localRoot.right = add(localRoot.right, localRoot, item);
            return localRoot;
        }
    }

    /**
     * Return the data field of the root
     *
     * @return the data field of the root
     * or null if the root is null
     */
    public ArtCollection getData() {
        if (root != null) {
            return root.getArt();
        } else {
            return null;
        }
    }

    /**
     * Creates an exhibit room with a list of framed artwork objects with art from 1920 to 1940. 
     * Artwork contains the image, artist's name, title of the piece, date created, and the medium of the artwork.
     * @return exhibit room with art from 1920 to 1940
     */
    private Exhibit create1920Exhibit(){ 
        ArtPiece untitled = new ArtPiece("Hannah Höch", "Untitled (Large Hand Over Woman's Head)", 1930, "photomontage", "hannah-hoch-dada-art-1.jpg");
        ArtPiece theUprising = new ArtPiece("Diego Rivera", "The Uprising", 1931, "Fresco on reinforced cement in steel", "The Uprising.jpg");
        ArtPiece repAuto = new ArtPiece("George Grosz", "Republican Automatons", 1920, "Watercolor, pen, and india ink on paper", "Republican Automation.jpg");
        ArtPiece migrating = new ArtPiece("Jacob Lawrence", "Migration Series No. 1", 1940, "Casein tempera on hardboard", "The Migration Series-Panel 1.jpg");
        ArtCollection art1920to1940 = new ArtCollection(1920, 1940);
        art1920to1940.addArtPiece(untitled);
        art1920to1940.addArtPiece(theUprising);
        art1920to1940.addArtPiece(repAuto);
        art1920to1940.addArtPiece(migrating);
        Exhibit ex1920to1940 = new Exhibit(art1920to1940);
        return ex1920to1940;
    }

    /**
     * Creates an exhibit room with a list of framed artwork objects with art from 1920 to 1940. 
     * Artwork contains the image, artist's name, title of the piece, date created, and the medium of the artwork.
     * @return exhibit room with art from 1940 to 1960
     */
    private Exhibit create1940Exhibit(){
        ArtPiece struggle = new ArtPiece("Jacob Lawrence", "Struggle... the History of the American People", 1955, "Casein tempera on hardboard", "Struggle.jpg");
        ArtPiece beatnik = new ArtPiece("Larry Fink", "Beatniks: Turk and Mary", 1958, " gelatin silver print", "Beatniks.jpg");
        ArtPiece fannieLou = new ArtPiece("Louis H. Draper", "Fannie Lou Hamer, Mississippi", 1960, "gelatin silver print", "Fannie Lou Hamer.jpg");
        ArtPiece hideAndSeek = new ArtPiece("Pavel Tchelitchew", "Hide-and-Seek", 1942, "oil on canvas", "Hide and Seek.jpg");
        ArtCollection art1940to1960 = new ArtCollection(1940, 1960);
        art1940to1960.addArtPiece(struggle);
        art1940to1960.addArtPiece(beatnik);
        art1940to1960.addArtPiece(fannieLou);
        art1940to1960.addArtPiece(hideAndSeek);
        Exhibit ex1940to1960 = new Exhibit(art1940to1960);
        return ex1940to1960;
    }

    /**
     * Creates an exhibit room with a list of framed artwork objects with art from 1920 to 1940. 
     * Artwork contains the image, artist's name, title of the piece, date created, and the medium of the artwork.
     * @return exhibit room with art from 1960 to 1980
     */
    private Exhibit create1960Exhibit(){
        ArtPiece protestRally = new ArtPiece("Jacob Lawrence", "Protest Rally", 1965, "Gouache on paper", "Protest Rally.jpg");
        ArtPiece nixon = new ArtPiece("Unknown Artist", "Richard M. Nixon", 1970, "political sticker", "Nixon Art.jpg");
        ArtPiece threeMen = new ArtPiece("Romare Bearden", "Three Men", 1967, "printed papers, graphite, watercolor on canvas", "Three Men.jpg");
        ArtPiece judgement = new ArtPiece("Amal Ghosh", "Judgement", 1979, "Painting", "Judgement.jpg");
        ArtCollection art1960to1980 = new ArtCollection(1960, 1980);
        art1960to1980.addArtPiece(protestRally);
        art1960to1980.addArtPiece(nixon);
        art1960to1980.addArtPiece(threeMen);
        art1960to1980.addArtPiece(judgement);
        Exhibit ex1960to1980 = new Exhibit(art1960to1980);
        return ex1960to1980;
    }

    /**
     * Creates an exhibit room with a list of framed artwork objects with art from 1920 to 1940. 
     * Artwork contains the image, artist's name, title of the piece, date created, and the medium of the artwork.
     * @return exhibit room with art from 1980 to 2000
     */
    private Exhibit create1980Exhibit(){
        ArtPiece stain = new ArtPiece("Colum Leith", "Stain", 1992, "Silkscreen on fabric/collage", "Stain (1980-2000).jpg" );
        ArtPiece theLastShift = new ArtPiece("Unknown Artist", "The Last Shift", 1991, "butterfly brick and common mortar", "The Last Shift.jpg");
        ArtPiece restrainingCoat = new ArtPiece("Julie Robers", "Restraining Coat", 1995, "oil on acrylic on canvas", "Restraining Coat.jpg");
        ArtPiece ideaDe = new ArtPiece("Guillermo Kuitica", "Idea de una pasión", 1984, "oil on canvas", "Idea de una pasión.jpg");
        ArtCollection art1980to2000 = new ArtCollection(1980, 2000);
        art1980to2000.addArtPiece(stain);
        art1980to2000.addArtPiece(theLastShift);
        art1980to2000.addArtPiece(restrainingCoat);
        art1980to2000.addArtPiece(ideaDe);
        Exhibit ex1980to2000 = new Exhibit(art1980to2000);
        return ex1980to2000;
    }

    /**
     * Creates entire exhibit framework comprised of the four rooms created in the previous
     * methods. Then, it adds the exhibits to the gallery. 
     */
    private void createExhibits(ArtGallery gallery){
        Exhibit ex1 = create1920Exhibit();
        Exhibit ex2 = create1940Exhibit();
        Exhibit ex3 = create1960Exhibit();
        Exhibit ex4 = create1980Exhibit();
        gallery.add(ex3.getArt());
        gallery.add(ex4.getArt());
        gallery.add(ex2.getArt());
        gallery.add(ex1.getArt());
    }

    /**
     *  Creates a button so the user can go to the exhibit on the right.
     */
    private void addRightButton(CanvasWindow canvas){
        Button rightButton = new Button("Right: " + currentExhibit.right.getArt().getStartDate() + " to " + currentExhibit.right.getArt().getEndDate());
        rightButton.setPosition(720, 600);
        canvas.add(rightButton);
        rightButton.onClick(() -> {
            currentExhibit = step(currentExhibit, currentExhibit.right);
            newRoomView(canvas);
        });
    }

     /**
     * Creates a button so the user can go to the left room. 
     */
    private void addLeftButton(CanvasWindow canvas){
        Button leftButton = new Button("Left: " + currentExhibit.left.getArt().getStartDate() + " to " + currentExhibit.left.getArt().getEndDate());
        leftButton.setPosition(504, 600);
        canvas.add(leftButton);
        leftButton.onClick(() -> {
            currentExhibit = step(currentExhibit, currentExhibit.left);
            newRoomView(canvas);
        });
    }

     /**
     * Creates a button so that the user can return to previous room. 
     */
    private void addPrevButton(CanvasWindow canvas, String side){
        Button prevButton = new Button("Back: " + currentExhibit.parent.getArt().getStartDate() + " to " + currentExhibit.parent.getArt().getEndDate());
        if(side == "right"){
            prevButton.setPosition(720, 600);
        }
        else {
            prevButton.setPosition(504, 600);
        }
        canvas.add(prevButton);
        prevButton.onClick(() -> {
            currentExhibit = step(currentExhibit, currentExhibit.parent);
            newRoomView(canvas);
        });
    }

    /**
     * Creates, sets position for, and enacts the click function so the 
     * user can view artwork.
     */
    private void addViewButton(CanvasWindow canvas){
        Button viewButton = new Button("View");
        viewButton.setPosition(650, 600);
        canvas.add(viewButton);
        viewButton.onClick(() -> view(canvas));
    }

    /**
     * Resets screen to show art pieces in a larger format. Buttons allow for the user to see the next art piece. 
     */
    private void view(CanvasWindow canvas) {
        canvas.removeAll();
        LinkedList<ArtPiece> artPieces = currentExhibit.getArt().getCollection();
        Iterator<ArtPiece> iter1 = artPieces.iterator();
        piece = iter1.next();
        piecePic = piece.getPicture();
        piecePic.setScale(.9);
        canvas.add(piecePic, canvas.getWidth()/4, 0);
        Button nextButton = new Button("Next Art Piece");
        nextButton.setPosition(750, 664);
        canvas.add(nextButton);
        nextButton.onClick(() -> {
            if(iter1.hasNext()){
                canvas.remove(piecePic);
                piece = iter1.next();
                piecePic = piece.getPicture();
                piecePic.setScale(.9);
                canvas.add(piecePic, canvas.getWidth()/4, 0);
                if(!iter1.hasNext()){
                    canvas.remove(nextButton);
                }
            }
        });
        
        Button exitButton = new Button("Return to Room");
        exitButton.setPosition(620, 664);
        canvas.add(exitButton);
        exitButton.onClick(() -> {
            newRoomView(canvas);
        });
    }

    /**
     * Resets screen to look like a new Exhibit room. Shows all art pieces in a smaller format and gives 3 buttons for
     * for iteration.
     */
    private void newRoomView(CanvasWindow canvas) {
        canvas.removeAll();
        if(currentExhibit.left != null){
            addLeftButton(canvas);
        }
        if(currentExhibit.right != null){
            addRightButton(canvas);
        }
        if(currentExhibit.left == null && currentExhibit.parent != null){
            addPrevButton(canvas, "left");
        }
        else if(currentExhibit.right == null && currentExhibit.parent != null){
            addPrevButton(canvas, "right");
        }
        addViewButton(canvas);
        GraphicsText roomTitle = new GraphicsText(currentExhibit.getArt().getStartDate() + " to " + currentExhibit.getArt().getEndDate());
        roomTitle.setFont(FontStyle.BOLD, 75);
        roomTitle.setPosition((canvas.getWidth()/2) - (roomTitle.getWidth()/2), 150);
        canvas.add(roomTitle);
        LinkedList<ArtPiece> artPieces = currentExhibit.getArt().getCollection();
        Iterator<ArtPiece> iter = artPieces.iterator();
        int miniArtX = -50; 
        while(iter.hasNext()){
            ArtPiece currentArtPiece = iter.next();
            GraphicsGroup resizedArt = currentArtPiece.getPicture();
            resizedArt.setScale(0.35);
            canvas.add(resizedArt, miniArtX, 1);
            miniArtX = miniArtX + 250;
        }
    }


    /**
     * This method reads the tree by getting the root and then adding the new room view
     * to canvas
     */
    public void readTree(ArtGallery gallery, CanvasWindow canvas){
        currentExhibit = gallery.root;
        newRoomView(canvas);
    }

    /**
     * Method "iterates" over the tree in a step-like way, starting at the root 
     * and moving down. This method moves from left to right through the tree
     * @param currentRoom the current room landed on
     * @param direction left, right, or parent
     * @return 
     */

    public Exhibit step(Exhibit currentRoom, Exhibit direction){
        if(direction != null){
            Exhibit newRoom = new Exhibit(direction.getArt());
            newRoom.parent = currentRoom;
            newRoom.left = direction.left;
            newRoom.right = direction.right;
            currentRoom = direction;
            return newRoom;
        }
        return null;
    }


    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Our Amazing Art Gallery!", 1400, 700);
        ArtGallery gallery = new ArtGallery();
        gallery.createExhibits(gallery);
        gallery.readTree(gallery, canvas);
    }

}
