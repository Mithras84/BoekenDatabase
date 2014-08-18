/**
 * 
 */
package nl.pczeeuw.boeken.model.beans;

/**
 * Class description
 * Bean/Transfer object. Als schakel tussen DB en GUI.
 * Bevat alle informatie van een boek.
 * @version		1.00 28 jul. 2014
 * @author 		Pieter
 */
public class Boek {
    //Primaire attributen
    private long isbn;
    private String titel;
    private String auteur;
    private double prijs;
    private String genre;
    private int paginas;
    
    /*
    //Secundaire attributen
    private String genre;
    private String omschrijving;
    private int paginas;
    */
    
    public Boek () {	
    }
    
    /**
     * For testing.
     * @param isbn
     * @param titel
     * @param auteur
     * @param prijs
     * @param genre
     * @param paginas
     */
    public Boek (long isbn, String titel, String auteur, double prijs, String genre, int paginas) {
	this.isbn = isbn;
	this.titel = titel;
	this.auteur = auteur;
	this.prijs = prijs;
	this.genre = genre;
	this.paginas = paginas;
    }


    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @return the paginas
     */
    public int getPaginas() {
        return paginas;
    }

    /**
     * @return the isbn
     */
    public long getIsbn() {
        return isbn;
    }

    /**
     * @return the titel
     */
    public String getTitel() {
        return titel;
    }

    /**
     * @return the auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * @return the prijs
     */
    public double getPrijs() {
        return prijs;
    }
    
    
    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }


    /**
     * @param titel the titel to set
     */
    public void setTitel(String titel) {
        this.titel = titel;
    }


    /**
     * @param auteur the auteur to set
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }


    /**
     * @param prijs the prijs to set
     */
    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }


    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }


    /**
     * @param paginas the paginas to set
     */
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    
    public String toString () {
	return getTitel () + ", " + getAuteur() + " $" + getPrijs();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
	result = prime * result + ((genre == null) ? 0 : genre.hashCode());
	result = prime * result + (int) (isbn ^ (isbn >>> 32));
	result = prime * result + paginas;
	long temp;
	temp = Double.doubleToLongBits(prijs);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((titel == null) ? 0 : titel.hashCode());
	return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof Boek))
	    return false;
	Boek other = (Boek) obj;
	if (auteur == null) {
	    if (other.auteur != null)
		return false;
	} else if (!auteur.equals(other.auteur))
	    return false;
	if (genre == null) {
	    if (other.genre != null)
		return false;
	} else if (!genre.equals(other.genre))
	    return false;
	if (isbn != other.isbn)
	    return false;
	if (paginas != other.paginas)
	    return false;
	if (Double.doubleToLongBits(prijs) != Double
		.doubleToLongBits(other.prijs))
	    return false;
	if (titel == null) {
	    if (other.titel != null)
		return false;
	} else if (!titel.equals(other.titel))
	    return false;
	return true;
    }

    

}
