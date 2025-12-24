import java.util.NoSuchElementException;

public class TariffList implements TariffPolicy {
    
    private TariffNode head;
    private int size;

    // Inner class TariffNode
    class TariffNode {
        private Tariffs tariff;
        private TariffNode next;
        
        public TariffNode() {
        	setHead(null);
        	setSize(0);
        }

        public TariffNode(Tariffs tariff, TariffNode next) {
            this.tariff = tariff;
            this.next = next;
        }

        public TariffNode(TariffNode other) {
            this.tariff = other.tariff.clone();
            this.next = null;
        }

        public TariffNode clone() {
            return new TariffNode(this);
        }

        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) return false;
            TariffNode other = (TariffNode) obj;
            return this.tariff.equals(other.tariff);
        }

        public Tariffs getTariff() {
            return tariff;
        }

        public TariffNode getNext() {
            return next;
        }

        public void setTariff(Tariffs tariff) {
            this.tariff = tariff;
        }

        public void setNext(TariffNode next) {
            this.next = next;
        }
    } // end of inner

    // TariffList default constructor
    public TariffList() {
        setHead(null);
        setSize(0);
    }

    // Copy constructor
    public TariffList(TariffList other) {
        if (other.getHead() == null) {
            setHead(null);
        } else {
            setHead(new TariffNode(other.getHead()));
            TariffNode current = getHead();
            TariffNode otherCurrent = other.getHead().next;
            while (otherCurrent != null) {
                current.next = new TariffNode(otherCurrent);
                current = current.next;
                otherCurrent = otherCurrent.next;
            }
        }
        setSize(other.getSize());
    }
    
    public void addToStart(Tariffs t) {
        // check if the tariff is already in the list
        if (!contains(t.getOriginCountry(), t.getDestinationCountry(), t.getCategory())) {
            setHead(new TariffNode(t, getHead()));
            setSize(getSize() + 1);
            System.out.println("Added Tariff: " + t.getOriginCountry() + " -> " + t.getDestinationCountry());
        } else {
            System.out.println("Tariff already exists: " + t.getOriginCountry() + " -> " + t.getDestinationCountry());
        }
       
    }


    public void insertAtIndex(Tariffs t, int index) {
        if (index < 0 || index > getSize()) {
        	throw new NoSuchElementException("The index is invalid.");
        }
        if (index == 0) {
            addToStart(t);
            return;
        }
        TariffNode temp = getHead();
        for (int i = 0; i < index - 1; i++) 
        		temp = temp.next;
        		temp.next = new TariffNode(t, temp.next);
        setSize(getSize() + 1);
    }

    public void deleteFromStart() {
    	    if (head == null) {
    	        throw new NoSuchElementException("Cannot delete from an empty list.");
    	    }
    	    head = head.next; 
    	    size--;
    	    if (head == null) {
    	        size = 0; 
    	    }
    }

    public void deleteFromIndex(int index) {
        if (index < 0 || index >= getSize()) {
        	throw new NoSuchElementException("The index is not valid.");
        }
        if (index == 0) {
            deleteFromStart();
            return;
        }
        TariffNode temp = getHead();
        for (int i = 0; i < index - 1; i++) temp = temp.next;
        temp.next = temp.next.next;
        setSize(getSize() - 1);
    }

    public void replaceAtIndex(Tariffs t, int index) {
        if (index < 0 || index >= getSize()) return;
        TariffNode temp = getHead();
        for (int i = 0; i < index; i++) {
        	temp = temp.next;
        }
        temp.tariff = t;
    }
 
    
public TariffNode findTariff(String destination, String origin, String category) {
        TariffNode current = getHead();
        int iterations = 0;
        while (current != null) {
        	iterations++;
            Tariffs t = current.tariff;
            if (t.getOriginCountry().equalsIgnoreCase(origin) &&
                t.getDestinationCountry().equalsIgnoreCase(destination) &&
                t.getCategory().equalsIgnoreCase(category)) {
            	System.out.println("\nIterations: " + iterations);
                return current.clone();
            }
            current = current.next; 
        }
        return null;
    }

public TariffNode findTradeRequest(String origin, String destination, String category) {
    TariffNode current = getHead();
    int iterations = 0;
    while (current != null) {
    	iterations++;
        Tariffs t = current.tariff;
        if (t.getOriginCountry().equalsIgnoreCase(origin) &&
            t.getDestinationCountry().equalsIgnoreCase(destination) &&
            t.getCategory().equalsIgnoreCase(category)) {
        	System.out.println("Iterations: " + iterations);
            return current.clone();
        }
        current = current.next;
    }
    return null;
}

    public boolean contains(String origin, String destination, String category) {
        TariffNode current = getHead();
        while (current != null) {
            Tariffs t = current.tariff;
            if (t.getOriginCountry().equalsIgnoreCase(origin) &&
                t.getDestinationCountry().equalsIgnoreCase(destination) &&
                t.getCategory().equalsIgnoreCase(category)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean equals(TariffList other) {
        if (this.getSize() != other.getSize()) {
        	return false;
        }
        TariffNode current1 = this.getHead();
        TariffNode current2 = other.getHead();
        while (current1 != null) {
            if (!current1.tariff.equals(current2.tariff)) 
            	return false;
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
    }

    public String evaluateTrade(double proposedTariff, double minimumTariff) {
        if (proposedTariff >= minimumTariff) return "Trade Approved";
        return "Trade Rejected";
    }

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public TariffNode getHead() {
		return head;
	}

	public void setHead(TariffNode head) {
		this.head = head;
	}

}

