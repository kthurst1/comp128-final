
/**
 * 
 * Class that represents a generic exhibit room.
 * 
 * @author Karley Thurston & Cecelia Kaufmann (12/10/21)
 * 
 */
public class Exhibit{
    
    private ArtCollection art;
    public Exhibit left;
    public Exhibit right;
    public Exhibit parent;

    /**
     * 
     * Creates an exhibit, complete with an associated art collection. 
     * 
     * @author Karley Thurston & Cecelia Kaufmann (12/10/21)
     * 
     */
    public Exhibit(ArtCollection art){
        this.art = art;
        left = null;
        right = null;
        parent = null;
    }

    public ArtCollection getArt(){
        return art;
    }
}
