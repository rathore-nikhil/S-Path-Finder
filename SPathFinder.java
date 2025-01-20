import java.util.*;

class DelhiMetro {
	private int V;
	private List<List<iPair>> adj;

	DelhiMetro(int V) {
		this.V = V;
		adj = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			adj.add(new ArrayList<>());
		}
	}

	//Funtion to add edges
	void addEdge(int u, int v, int w) {
		adj.get(u).add(new iPair(v, w));
		adj.get(v).add(new iPair(u, w));
	}

	//Using Dijkstra's algorithm to find shortest path
	void shortestPath(int src, int dest) {
		PriorityQueue<iPair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.first));
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);

		pq.add(new iPair(0, src));
		dist[src] = 0;

		while (!pq.isEmpty()) {
			int u = pq.poll().second;

			for (iPair v : adj.get(u)) {
				if (dist[v.first] > dist[u] + v.second) {
					dist[v.first] = dist[u] + v.second;
					pq.add(new iPair(dist[v.first], v.first));
				}
			}
		}

		for (int i = 0; i < dest; i++) {
		}
		System.out.println("Minimum distance is " + dist[dest] + " KM");
	}

	static class iPair {
		int first, second;

		iPair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}


	//Main
	public static void main(String[] args) {
		int V = 21;
		DelhiMetro g = new DelhiMetro(V);

		g.addEdge(7, 15, 8);
		g.addEdge(15, 3, 10);
		g.addEdge(3, 8, 8);
		g.addEdge(3, 18, 6);
		g.addEdge(18, 19, 9);
		g.addEdge(19, 13, 7);
		g.addEdge(13, 4, 6);
		g.addEdge(14, 16, 15);
		g.addEdge(16, 10, 6);
		g.addEdge(10, 18, 7);
		g.addEdge(18, 1, 1);
		g.addEdge(1, 9, 2);
		g.addEdge(9, 11, 5);
		g.addEdge(1, 17, 2);
		g.addEdge(17, 5, 7);
		g.addEdge(5, 20, 8);
		g.addEdge(19, 6, 2);
		g.addEdge(12, 6, 2);
		g.addEdge(12, 2, 3);

		Scanner s = new Scanner(System.in);

		System.out.println("WELCOME TO DELHI METRO SHORTEST PATH");
		System.out.println("1. LIST OF ALL STATIONS");
		System.out.println("2. SHOW THE METRO MAP");
		System.out.println("3. GET SHORTEST PATH FROM SOURCE TO DESTINATION");

		int choice = s.nextInt();

		if(choice == 1){
			System.out.println("1. New Delhi\r\n"
					+ "2. Netaji Subhash Place\r\n"
					+ "3. Yamuna Bank\r\n"
					+ "4. Dwarka Sector 21\r\n"
					+ "5. DDS Campus\r\n"
					+ "6. Rajouri Garden\r\n"
					+ "7. Noida Sector 62\r\n"
					+ "8. Vaishali\r\n"
					+ "9. Chandni Chowk\r\n"
					+ "10. AIIMS\r\n"
					+ "11. Vishwavidyalaya\r\n"
					+ "12. Punjabi Bagh West\r\n"
					+ "13. Janak Puri West\r\n"
					+ "14. Huda City Center\r\n"
					+ "15. Botanical Garden\r\n"
					+ "16. Saket\r\n"
					+ "17. Shivaji Stadium\r\n"
					+ "18. Rajiv Chowk\r\n"
					+ "19. Moti Nagar\r\n"
					+ "20. IGI Airport\r\n"
					);

		}
		else if(choice == 2)
			System.out.println("New Delhi =>\r\n"
					+ "	Shivaji Stadium		2 KM\r\n"
					+ "	Rajiv Chowk		1 KM\r\n"
					+ "	Chandni Chowk		2 KM\r\n"
					+ "\r\n"
					+ "Netaji Subhash Place =>\r\n"
					+ "	Punjabi Bagh West	3 KM\r\n"
					+ "\r\n"
					+ "Yamuna Bank =>\r\n"
					+ "	Botanical Garden	10 KM\r\n"
					+ "	Rajiv Chowk		6 KM\r\n"
					+ "	Vaishali		8 KM\r\n"
					+ "\r\n"
					+ "Dwarka Sector 21 =>\r\n"
					+ "	Janak Puri West		6 KM\r\n"
					+ "\r\n"
					+ "DDS Campus =>\r\n"
					+ "	Shivaji Stadium		7 KM\r\n"
					+ "	IGI Airport		8 KM\r\n"
					+ "\r\n"
					+ "Rajouri Garden =>\r\n"
					+ "	Punjabi Bagh West	2 KM\r\n"
					+ "	Moti Nagar		2 KM\r\n"
					+ "\r\n"
					+ "Noida Sector 62 =>\r\n"
					+ "	Botanical Garden	8 KM\r\n"
					+ "\r\n"
					+ "Vaishali =>\r\n"
					+ "	Yamuna Bank		8 KM\r\n"
					+ "\r\n"
					+ "Chandni Chowk =>\r\n"
					+ "	New Delhi		2 KM\r\n"
					+ "	Vishwavidyalaya		5 KM\r\n"
					+ "\r\n"
					+ "AIIMS =>\r\n"
					+ "	Saket			6 KM\r\n"
					+ "	Rajiv Chowk		7 KM\r\n"
					+ "\r\n"
					+ "Vishwavidyalaya =>\r\n"
					+ "	Chandni Chowk		5 KM\r\n"
					+ "\r\n"
					+ "Punjabi Bagh West =>\r\n"
					+ "	Netaji Subhash Place	3 KM\r\n"
					+ "	Rajouri Garden		2 KM\r\n"
					+ "\r\n"
					+ "Janak Puri West =>\r\n"
					+ "	Dwarka Sector 21	6 KM\r\n"
					+ "	Moti Nagar		7\r\n"
					+ "\r\n"
					+ "Huda City Center =>\r\n"
					+ "	Saket			15 KM\r\n"
					+ "\r\n"
					+ "Botanical Garden =>\r\n"
					+ "	Yamuna Bank		10 KM\r\n"
					+ "	Noida Sector 62		8 KM\r\n"
					+ "\r\n"
					+ "Saket =>\r\n"
					+ "	Huda City Center	15 KM\r\n"
					+ "	AIIMS			6 KM\r\n"
					+ "\r\n"
					+ "Shivaji Stadium =>\r\n"
					+ "	New Delhi		2 KM\r\n"
					+ "	DDS Campus		7 KM\r\n"
					+ "\r\n"
					+ "Rajiv Chowk~BY =>\r\n"
					+ "	New Delhi		1 KM\r\n"
					+ "	Yamuna Bank		6 KM\r\n"
					+ "	Moti Nagar		9 KM\r\n"
					+ "	AIIMS			7 KM\r\n"
					+ "\r\n"
					+ "Moti Nagar =>\r\n"
					+ "	Janak Puri West		7 KM\r\n"
					+ "	Rajouri Garden		2 KM\r\n"
					+ "	Rajiv Chowk		9 KM\r\n"
					+ "\r\n"
					+ "IGI Airport =>\r\n"
					+ "	DDS Campus		8 KM\r\n"
					);
		else if(choice == 3) {
			System.out.println("Enter source : ");
			int source = s.nextInt();
			System.out.println("Enter destination : ");
			int dest = s.nextInt();

			g.shortestPath(source, dest);

		}
	}
}
