
import java.util.*;

/**
 * 
 * Class that represents a generic art collection.
 * 
 * @author Karley Thurston & Cecelia Kaufmann (12/10/21)
 * 
 */
public class ArtCollection implements Comparable<ArtCollection>{
    private int startDate;
    private int endDate;
    private LinkedList<ArtPiece> collection;
    
    /**
     * Creates an art collection structure, a list, holding picture objects
     */
    public ArtCollection(int startDate, int endDate){
        this.startDate = startDate;
        this.endDate = endDate;
        collection = new LinkedList<>();
    }

    /**
     * Returns start date as an int.
     */
    public int getStartDate() {
        return startDate;
    }

    /**
     * Returns end date as an int.
     */
    public int getEndDate() {
        return endDate;
    }

    /**
     * Orders the collections based on end dates, with older dates getting lower values.
     * @param data on art collection
     * @return int
     */
    public int compareTo(ArtCollection data) {
        if(endDate > data.getEndDate()){
            return 1;
        }
        if(endDate < data.getEndDate()){
            return -1;
        }
        else{
            return 0;
        }
    }

    /**
     * Adds art pieces to the collection list.
     * @param art Art piece object to add
     */
    public void addArtPiece(ArtPiece art){
        collection.add(art);
    }

    /**
     * Returns linked list of the ArtCollection's ArtPieces.
     */
    public LinkedList<ArtPiece> getCollection() {
        return collection;
    }
}
