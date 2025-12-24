public class Tariffs {
    private String destinationCountry;
    private String originCountry;
    private int percentage;
    private String category;
    

    // Constructor for Part 1 
    public Tariffs(String country, int percentage, String category) {
        this.originCountry = country;
        this.destinationCountry = country; 
        this.percentage = percentage;
        this.category = category;
    }

    // Constructor for Part 2 
    public Tariffs(String destinationCountry, String originCountry, int percentage, String category) {
        this.destinationCountry = destinationCountry;
        this.originCountry = originCountry;
        this.percentage = percentage;
        this.category = category;
    }
    
    public Tariffs(Tariffs other) {
    	 this.destinationCountry = other.destinationCountry;
    	 this.originCountry = other.originCountry;
         this.percentage = other.percentage;
         this.category = other.category;
    }
    
    public Tariffs clone() {
        return new Tariffs(destinationCountry, originCountry, percentage, category);
    }


    public String getDestinationCountry() {
        return destinationCountry;
    }
    public String getOriginCountry() {
        return originCountry;
    }
    public double getPercentage() {
        return percentage;
    }
    public String getCategory() {
        return category;
    }
    
    
    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }
    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }
    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    
    // to string
    public String toString() {
    	return " \n Destination Country: " + this.destinationCountry + "\n Origin Country: " + this.originCountry 
    			+ "\n Category: " + this.category + "\n Tariff percentage: " + this.percentage;
    }
    
    // equals
    public boolean equals(Object other) {
    	if (other == null || this.getClass() != other.getClass()) {
    		return false;
    	}
    	Tariffs otherT = (Tariffs) other;
    	if (this.destinationCountry.equalsIgnoreCase(otherT.destinationCountry)
    		&& this.originCountry.equalsIgnoreCase(otherT.originCountry	)
    		&& this.category.equalsIgnoreCase(otherT.category)
    		&& this.percentage == otherT.percentage) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    
}


