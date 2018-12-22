/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */
class Document
{
    private final int userID ;  
    private final String documentName ;  
    private final int    numberOfPages ;


    public Document( int UID, String name, int length )
    {
        this.userID        = UID ;
        this.documentName  = name ;
        this.numberOfPages = length ;
    }

    Document() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUserID( )        { return ""+userID; }

    public String getDocumentName( )  { return documentName ; }

    public int    getNumberOfPages( ) { return numberOfPages ; }


    public String toString( )
    {
       return new String( "Document[ "  +
                                     "UserID: " + userID        + ", " + 
                                     "Name: "   + documentName  + ", " + 
                                     "Pages: "  + numberOfPages + 
                                  "]"  ) ;
    }

} // Document