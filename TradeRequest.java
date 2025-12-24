public class TradeRequest {
    private String requestId;
    private String origin;
    private String destination;
    private String category;  
    private double tradeValue;
    private double proposedTariff;

    public TradeRequest(String requestId, String origin, String destination, String category, double tradeValue, double proposedTariff) {
        this.requestId = requestId;
        this.origin = origin;
        this.destination = destination;
        this.proposedTariff = proposedTariff;
        this.tradeValue = tradeValue;
        this.category = category;  
    }

    public String getRequestId() {
        return requestId;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public double getProposedTariff() {
        return proposedTariff;
    }

    public String getCategory() {  
        return category;
    }


	public double getTradeValue() {
		return this.tradeValue;
	}
	
    @Override
    public String toString() {
        return "RequestId: " + requestId + "\nOrigin: " + origin + "\nDestination: " + destination + 
               "\nCategory: " + category + "\nProposed Tariff: " + proposedTariff;
    }
}
