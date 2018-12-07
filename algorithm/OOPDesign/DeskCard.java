// 1. Design the data structures for a generic deck of cards. Explain how you would subclass it to implement particular card games.
public enum Suit {
	CLUBS(0), SPADES(1), HEARTS(2), DIAMOND(3);
	private int value;
	private static final Map<Integer, Suit> MY_MAP = new HashMap<Integer, Suit>();
  	static {
    	for (Suit myEnum : values()) {
      		MY_MAP.put(myEnum.getValue(), myEnum);
    	}
  	}
	public Suit(int value) {
		this.value = value;
	}
}
public class Card {
	public Suit color;
	public int value
	public Card(Suit color, int value) {
		this.color = color;
		this.value = value;
	}
}

public class Player {
	public String playerName;
	public HashSet<Card> playerCards;
	public boolean quit;
	public Player(String name) {
		playerName = name;
		playerCards = new HashSet<Card>();
	}
	public boolean addCard(Card newCard) {
		playerCards.add(newCard);
	}
	public Player() {
		playerName = "";
		playerCards = new HashSet<Card>();
		quit = false;
	}
}

public abstract class DeskCard {
	public HashSet<Card> cardSet;
	public String deskCardName;
	public HashSet<Player> players; 
	public boolean iniGame(String name, HashSet<Card> set) {
		this.cardSet = set;
		deskCardName = name;
	}
	public abstract Player checkWin();
	public abstract boolean startGame();
	public abstract boolean addPlayer(Player newPlayer);
	public abstract boolean removePlayer(Player existPlayer)
}


public class BlackJack extends DeskCard {
	public BlackJack() {
		HashSet<Card> cardSet = new HashSet<Card>();
		for(Suit color : Suit.values()) {
			for(int i = 1; i <= 13; i++) {
				Card currentcard = new Card(color, i);
				cardSet.add(currentcard);
			}
		}
		players = new HashSet<Player>();
		super.iniGame("BlackJack", cardSet)
	}
	@Override
	public boolean addPlayer(Player newPlayer) {
		players.add(newPlayer);
	}
	@Override
	public boolean removePlayer(Player existPlayer) {
		players.remove(existPlayer);
	}
	@Override
	public Player checkWin() {
		Player winner;
		int total = 0;
		for(Player item : players) {
			int currentTotal = 0;
			for (Card carditem : item.playerCards) {
				currentTotal += carditem.value;
			}
			if (currentTotal <= 21 && currentTotal > total) {
				total = currentTotal;
				winner = item;
			}
		}
		return winner;
	}
	private Card generateRandom() {
		int randomSuit = (int)(Math.random() * 3);
		int randomValue = (int)(Math.random() * 13);
		return 
	}
	@Override
	public boolean processGame(int roundNum) {
		switch(roundNum) {
			case 1:
			case 2:
				for(Player itemP : players) {
					Card current = generateRandom();
					itemP.addCard(current);
					cardSet.remove(current);
				}
				break;
			case 3:
				for(Player itemP : players) {
					if (!itemP.quit) {
						// give cards until meet 21 points
						
					}
					else {
						removePlayer(itemP);
					}
				}
				break;
		}
	}
 }

public class Test {
	public static void main(String[] args) {
		BlackJack newGame = new BlackJack();
		Player player1 = new Player();
		newGame.addPlayer("dealer");
		newGame.addPlayer("Player 1");
		newGame.addPlayer("Player 2");
		newGame.addPlayer("Player 3");
		newGame.addPlayer("Player 4");
		if (newGame.processGame(1) && newGame.processGame(2)) {
			// set quit for individual player
			for(Player itemP : newGame.players) {
				itemP.quit = true;
			}
			System.out.println(newGame.checkWin().name);
		}
	}
}
