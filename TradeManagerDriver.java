/*Purpose of the program: This program manages tariffs from tariffs text files, and allow users to search and modify the tariffs. 
 * It also allows to evaluate trade requests. It uses linked lists and file I/O.
 */
import java.io.*;
import java.util.*;

import part2_linkedlists.TariffList.TariffNode;
		public class TradeManagerDriver {
		    public static void main(String[] args) {
		    			    	
		        TariffList tariffList1 = new TariffList();
		        TariffList tariffList2 = new TariffList();
		        
		        System.out.println("Reading list 1 ... (origin -> destination)");
		        readAndParseTariffs(tariffList1, "TariffsList1.txt");
		       
		        System.out.println("\nReading list 2 ... (origin -> destination)");
		        readAndParseTariffs(tariffList2, "TariffsList2.txt");  
		      
		    Scanner scanner = new Scanner(System.in);
		    boolean choice2 = true;
		        while (choice2) {
		        	System.out.println("\n----- Main Menu -----");
			        System.out.println("What would you like to do ?");
			        System.out.println("  1. Search for a tariff.");
			        System.out.println("  2. Display trade requests.");
			        System.out.println("  3. Test the program.");
			        System.out.println("  4. Exit the program.");
			        System.out.print("Enter your choice here: ");
			        int choice = scanner.nextInt();
			        scanner.nextLine();
		        switch (choice) {
	        	case 1:
	        		// User searches for tariff
			        System.out.print("Enter the destination country to search for tariffs: ");
			        String destination = scanner.nextLine();
			        System.out.print("Enter the origin country to search for tariffs: ");
			        String origin = scanner.nextLine();
			        System.out.print("Enter the category to search for tariffs: ");
			        String category = scanner.nextLine();
			        TariffList.TariffNode foundNode = tariffList1.findTariff(destination, origin, category);
			        if (foundNode != null) {
			            System.out.println("Tariff(s) found: " + foundNode.getTariff() + "\n");
			        } else {
				        foundNode = tariffList2.findTariff(destination, origin, category);
				        if (foundNode != null) {
				            System.out.println("Tariff(s) found: " + foundNode.getTariff() + "\n");
				        } else {
			            System.out.println("No matching tariff found.");
			        }  	
			        }
			        break;
	        	case 2: 
	        		processTradeRequest("TradeRequests.txt", "TariffsList1.txt", "TariffsList2.txt");
	        		break;
	        	case 3: 
	        		System.out.println("Displaying all the list 1...");
	        		displayTariffList(tariffList1);
	        		//displayTariffList(tariffList2);
	        		System.out.println("\nWhat would you like to test ?");
	        			System.out.println("	1. Every method all at once.");
	        			System.out.println("	2. Test if the 2 tariffs lists are equal.");
	        			System.out.println("	3. Test the copy constructor and see if the 2 lists are equal.");
	        			System.out.println("	4. Insert at an index.");
	        			System.out.println("	5. Delete at an index.");
	        			System.out.println("	6. Add to start.");
	        			System.out.println("	7. Delete from start.");
	        			System.out.println("	8. Replace at an index.");
	        			System.out.println("	9. Leave testing.");
	        			System.out.print("Enter your choice here: ");
	        			int choice3 = scanner.nextInt();
	        			
	        			switch (choice3) {
	        			case 1:
	        				System.out.println("Testing all methods...");
	    			        // equals
	    			        System.out.println("Testing if the two lists are equal... \n" + tariffList1.equals(tariffList2));
	    			        // copy constructor
	    			        TariffList copyList = new TariffList(tariffList1);
	    			        // equals method (with the copy)
	    			        System.out.println("Are original and copied list equal? " + tariffList1.equals(copyList));

	    			        // insertAtIndex method
	    			        // 1 (at index 1)
	    			        try {
	    			            Tariffs listOfTariffs = new Tariffs("Spain", "Italy", 18, "Standard");
	    			            tariffList1.insertAtIndex(listOfTariffs, 1);
	    			            System.out.println("New tariff inserted.");
	    			        } catch (NoSuchElementException e) {
	    			            System.out.println(e.getMessage());
	    			            System.exit(1);
	    			        }
	    			        // 2 (at index 0)
	    			        try {
	    			        	Tariffs listOfTariffs = new Tariffs("Japan", "USA", 10, "Standard");
	    				        tariffList1.insertAtIndex(listOfTariffs, 0);
	    				        // In the method, if the index is 0, the add to start method is called.
	    				        System.out.println("Inserted at index 0 (head).");
	    			        } catch (NoSuchElementException e) {
	    			            System.out.println(e.getMessage());
	    			            System.exit(1);
	    			        }
	    			 
	    			        // deleteFromIndex() method
	    			        // 1 (index 1)
	    			        try {
	    			            tariffList1.deleteFromIndex(1);
	    			            System.out.println("Tariff deleted.");
	    			        } catch (NoSuchElementException e) {
	    			            System.out.println(e.getMessage());
	    			            System.exit(1);
	    			        }
	    			        // 2 (last element)
	    			        try {
	    			            tariffList1.deleteFromIndex(tariffList1.getSize() - 1);
	    			            System.out.println("Deleted last element.");
	    			        } catch (NoSuchElementException e) {
	    			            System.out.println("Failed to delete last element: " + e.getMessage());
	    			            System.exit(1);
	    			        }
	    			        
	    			        // replaceAtIndex() method
	    			        Tariffs replacementTariff = new Tariffs("France", "Germany", 22, "Standard");
	    			        tariffList1.replaceAtIndex(replacementTariff, 0);
	    			        System.out.println("Replaced tariff." + replacementTariff);
	        				break;
	        			case 2:
	    			        System.out.println("Testing if the two lists are equal... \n" + tariffList1.equals(tariffList2));
	        				break;
	        			case 3:
	        				// copy constructor
	    			        TariffList copyList1 = new TariffList(tariffList1);
	    			        // equals method (with the copy)
	    			        System.out.println("Are original and copied list equal? " + tariffList1.equals(copyList1));
	        				break;
	        			case 4:
	        				// insertAtIndex method
	    			        // 1 (at index 1)
	    			        try {
	    			            Tariffs listOfTariffs = new Tariffs("Spain", "Italy", 18, "Standard");
	    			            tariffList1.insertAtIndex(listOfTariffs, 1);
	    			            System.out.println("New tariff inserted. Displaying new list: ");
	    			            displayTariffList(tariffList1);
	    			        } catch (NoSuchElementException e) {
	    			            System.out.println(e.getMessage());
	    			            System.exit(1);
	    			        }
	        				break;
	        			case 5:
	        				// deleteFromIndex() method
	    			        // 1 (index 1)
	    			        try {
	    			            tariffList1.deleteFromIndex(1);
	    			            System.out.println("Tariff deleted. Displaying the new list: ");
	    			            displayTariffList(tariffList1);
	    			        } catch (NoSuchElementException e) {
	    			            System.out.println(e.getMessage());
	    			            System.exit(1);
	    			        }
	        				break;
	        			case 6:
	        				try {
	    			        	Tariffs listOfTariffs = new Tariffs("Japan", "USA", 10, "Standard");
	    				        tariffList1.insertAtIndex(listOfTariffs, 0);
	    				        // In the method, if the index is 0, the add to start method is called.
	    				        System.out.println("Inserted at index 0 (head). Displaying new list: ");
	    				        displayTariffList(tariffList1);
	    			        } catch (NoSuchElementException e) {
	    			            System.out.println(e.getMessage());
	    			            System.exit(1);
	    			        }
	        				break;
	        			case 7:
	        				try {
	    			            tariffList1.deleteFromStart();
	    			            System.out.println("Tariff deleted.");
		        				displayTariffList(tariffList1);
	    			        } catch (NoSuchElementException e) {
	    			            System.out.println(e.getMessage());
	    			            System.exit(1);
	    			        }
	        				break;
	        			case 8:
	        				// replaceAtIndex() method
	    			        Tariffs replacementTariff1 = new Tariffs("France", "Germany", 22, "Standard");
	    			        tariffList1.replaceAtIndex(replacementTariff1, 0);
	    			        System.out.println("Replaced tariff." + replacementTariff1);
	    			        System.out.println("Displaying new list:");
	    			        displayTariffList(tariffList1);
	        				break;
	        			case 9: 
	        				System.out.println("Back to main menu...");
	        				continue;
	        			}
			       break;
			       
	        	case 4: 
	        		System.out.println("Goodbye!");
	        		System.exit(0);
	        		break;
	        }}
		        
		        scanner.close(); 
		    }
		    
		    // end of main
			public static void readAndParseTariffs(TariffList tariffList, String fileName) {
		        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		            String line;
		            while ((line = br.readLine()) != null) {
		                String[] parts = line.split("\\s+");
		                if (parts.length == 4) {
		                		String origin = parts[1];
		                		String destination = parts[0];
		                		String category = parts[2];
		                		int percentage = Integer.parseInt(parts[3]);
		                    // create a new tariff object based on the file's content at each line
		                    Tariffs newTariff = new Tariffs(origin, destination, percentage, category);
		                    if (!tariffList.contains(origin, destination, category)) {
		                        tariffList.addToStart(newTariff); // add to the head if the list is empty
		                    } else {
		                    	tariffList.insertAtIndex(newTariff, tariffList.getSize());
		                    } 
		                } 
		            }
		        } catch (IOException e) {
		            System.out.println(e.getMessage());
		        }
		    }
			
			// Display all tariff 
			public static void displayTariffList(TariffList t) {
				if (t == null || t.contains(null, null, null)) {
			        System.out.println("Empty list, nothing to display.");
			        return;
			    }
				TariffNode current = t.getHead();
				int tariffNbr = 0;
			    while (current != null) {
			    	System.out.println();
			        Tariffs tariff = current.getTariff(); 
			        System.out.println("Tariff number: " + tariffNbr);
			        tariffNbr++;
			        System.out.println("Origin country: " + tariff.getOriginCountry() 
			        				+ "\nDestination country: " + tariff.getDestinationCountry() 
			        				+ "\nCategory: " + tariff.getCategory());
			        current = current.getNext();
		    }
			}
			// Requests
			/*
			  public static void displayTradeRequests(ArrayList<TradeRequest> tradeRequests) {
			        System.out.println("----- Trade Requests -----");
			        if (tradeRequests.isEmpty()) {
			            System.out.println("No trade requests found.");
			        } else {
			           for (TradeRequest request : tradeRequests) {
			                System.out.println(request);
			                System.out.println("--------------------------");
			            }
			        }
			    } */   
			
			  public static ArrayList<TradeRequest> readTradeRequests(String file) {
				  ArrayList<TradeRequest> requests = new ArrayList<TradeRequest>();
				    try (BufferedReader input = new BufferedReader(new FileReader(file))) {
				        String line;
				        while ((line = input.readLine()) != null) {
						  String[] requestLine = line.split("\\s+");
						  double tradeValue = Double.parseDouble(requestLine[4]);
						  double proposedTariff = Double.parseDouble(requestLine[5]);
						  requests.add(new TradeRequest(requestLine[0], requestLine[1], requestLine[2], requestLine[3],tradeValue, proposedTariff));
					  }
				} catch (IOException e) {
					System.out.println("File not found.");
				}
				return requests;
			  }

			public static void processTradeRequest(String file, String t1, String t2) {
			    ArrayList<TradeRequest> requests = readTradeRequests(file);
				TariffList mergedList = new TariffList();
				readAndParseTariffs(mergedList, t1);
				readAndParseTariffs(mergedList, t2);
			    for (TradeRequest request : requests) {
			        TariffList.TariffNode matchingNode = mergedList.findTradeRequest(request.getOrigin(), request.getDestination(), request.getCategory());
			        if (matchingNode == null) {
			            System.out.println(request.getRequestId() + " - Rejected \nNo tariff policy found for this trade.");
			            continue;
			        }
			        double minTariff = matchingNode.getTariff().getPercentage();
			        double proposedTariff = request.getProposedTariff();
			        double tradeValue = request.getTradeValue();
			        if (proposedTariff >= minTariff) {
			            System.out.printf("%s - Accepted.%nProposed tariff %.1f%% meets or exceeds minimum requirement %.1f%%%n",
			                request.getRequestId(), proposedTariff, minTariff);
			        } 
			        else if (proposedTariff >= minTariff * 0.8) {
			            double surcharge = tradeValue * ((minTariff - proposedTariff) / 100);
			            System.out.printf("%s - Conditionally Accepted.%n" +
			                "Proposed tariff %.1f%% is within 20%% of required minimum %.1f%%.%n" +
			                "A surcharge of $%.2f is applied.%n",
			                request.getRequestId(), proposedTariff, minTariff, surcharge);
			        } 
			        else {
			            System.out.printf("%s - Rejected.%n" +
			                "Proposed tariff %.1f%% is more than 20%% below required minimum %.1f%%.%n",
			                request.getRequestId(), proposedTariff, minTariff);
			        }
			    }
			}
			
		}
