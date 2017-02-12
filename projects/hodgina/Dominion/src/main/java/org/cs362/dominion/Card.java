package org.cs362.dominion;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public final class Card implements Comparable<Card>, Cloneable{
	public static enum Type {
		ACTION, TREASURE, VICTORY;
	}

	public static enum CardName {
		/** The Treasure cards */
		Gold, Silver, Copper,
		/** The Victory cards */
		Province,Duchy,Estate,Curse,
		/** The Kingdom cards */
		Adventurer, Ambassador, Baron, Council_room, Cutpurse, Embargo, Feast, Gardends, Great_hall, Mine, Smithy, Village;
	}
	/**
	 * @param enum CardName the name of the card (GOLD, SILVER, COPPER,
	 * @param enum Type the type of the card (Victory, Treasure, or Kingdom
	 * @param int cost the cost of the card
	 * @param int score the score of the card, when the game is finished
	 * @param treasureValue  the treasure value of the treasure cards (Copper, silver, and gold cards)
	 */
	private final Type realType;
	private final CardName cardName;
	private final int cost, score, treasureValue;

	private Card(CardName cardName, Type type, int cost, int score, int treasureValue) {
		this.cost = cost;
		this.score = score;
		this.treasureValue = treasureValue;
		this.realType = type;
		this.cardName = cardName;
	}

	/**
	 * Returns the type
	 */
	public Type getType() {
		return realType;
	}

	/**
	 * Returns the cardName
	 */
	public CardName getCardName() {
		return cardName;
	}
	/**
	 * Returns the cost
	 */
	public int getCost() {
		return cost;
	}


	/**
	 * Returns the treasureValue
	 */
	public int getTreasureValue() {
		return treasureValue;
	}
	public int score() {
			return score;
		}

	public static List<Card> createCards() {
		List<Card> ret = new LinkedList<Card>();

		//CardName cardName, Type type, int cost, int score, int treasureValue)

		/** The Treasure cards  */
		Card o = new Card(CardName.Gold, Type.TREASURE, 6, 0, 3);
		ret.add(o);
		o = new Card(CardName.Silver, Type.TREASURE, 3, 0, 2);
		ret.add(o);
		o = new Card(CardName.Copper, Type.TREASURE, 0, 0, 1);
		ret.add(o);

		/** The Victory cards  */
		o = new Card(CardName.Province,Type.VICTORY, 	8, 6, 0);
		ret.add(o);
		o = new Card(CardName.Duchy,Type.VICTORY,		5, 1, 0);
		ret.add(o);
		o = new Card(CardName.Estate,Type.VICTORY,		2, 3, 0);
		ret.add(o);
		o = new Card(CardName.Curse,Type.VICTORY,		0, -1, 0);
		ret.add(o);
		/** The Kingdom cards , it should more than 10 cards*/

		o = new Card(CardName.Adventurer,Type.ACTION,6,0,0);
		ret.add(o);
		o = new Card(CardName.Ambassador,Type.ACTION,3,0,0);
		ret.add(o);
		o = new Card(CardName.Baron,Type.ACTION,4,0,0);
		ret.add(o);
		o = new Card(CardName.Council_room,Type.ACTION,5,0,0);
		ret.add(o);
		o = new Card(CardName.Cutpurse,Type.ACTION,4,0,0);
		ret.add(o);
		o = new Card(CardName.Embargo,Type.ACTION,2,0,0);
		ret.add(o);
		o = new Card(CardName.Feast,Type.ACTION,4,0,0);
		ret.add(o);
		o = new Card(CardName.Gardends,Type.ACTION,4,0,0);
		ret.add(o);
		o = new Card(CardName.Great_hall,Type.ACTION,3,0,0);
		ret.add(o);
		o = new Card(CardName.Mine,Type.ACTION,5,0,0);
		ret.add(o);
		o = new Card(CardName.Smithy,Type.ACTION,4,0,0);
		ret.add(o);
		o = new Card(CardName.Village,Type.ACTION,3,0,0);
		ret.add(o);
		return ret;
	}

	public void play(Player player, GameState state) {

		switch(this.cardName) {
		case Adventurer:
	    	  //Reveal cards from your deck until you reveal 2 Treasure cards. Put those Treasure cards into your hand and discard the other revealed cards.
	    	  System.out.println("TODO Adventurer Code******************************************");
	    	  System.out.println("Reveal cards from the player deck until player reveal 2 Treasure cards. " +
	    	  		"Put those Treasure cards into player hand and discard the other revealed cards.");

							int num_treasures = 0;

							for(int i = 0; i < player.deck.size(); i++){
								if(num_treasures == 2){
									break;
								}else{
									System.out.println(player.deck.get(i));
									if(player.deck.get(i).getTreasureValue() > 0){
										num_treasures++;
										player.hand.add(player.deck.get(i));
										player.deck.remove(player.deck.get(i));
									}else{
										player.discard(player.deck.get(i));
									}

								}
							}




			return;
		case Ambassador:
					//Reveal a card from your hand. Return up to 2 copies of it
					// from your hand to the Supply. Then each other player gains a copy of it.


			return;

		case Baron:
		//You may discard an Estate card. If you do, +$4. Otherwise, gain an Estate card.
			for(int i = 0; i < player.hand.size(); i++){
				if(player.hand.get(i) == getCard(cards,Card.CardName.Estate){

					player.hand.get(i).

				}
			}


			return;

		case Council_room:
		//+4 Cards; +1 Buy
		//Each other player draws a card.
			player.drawCard();
			player.drawCard();
			player.drawCard();
			player.drawCard();
			player.numBuys = player.numBuys + 1;

			return;


		case Cutpurse:
		//+$2
		//Each other player discards a Copper card (or reveals a hand with no Copper).


			return;

		case Embargo:
		//+$2
		//Trash this card. Put an Embargo token on top of a Supply pile.
		//When a player buys a card, he gains a Curse card per Embargo token on that pile.


			return;

		case Feast:
		//Trash this card. Gain a card costing up to $5.


			return;

		case Gardends:
		//Worth 1 Victory for every 10 cards in your deck (rounded down).


			return;

		case Great_hall:
		//1 Victory Point
		//+1 Card; +1 Action.


			return;

		case Mine:
		//Trash a Treasure card from your hand. Gain a Treasure card costing up to $3 more; put it into your hand.

			return;
		case Smithy:
	         player.drawCard();
	         player.drawCard();
	         player.drawCard();
			return;

		case Village:
	    	  //System.out.println("TODO Village Code******************************************");
	    	  System.out.println("The player draw +1 Card.");
					player.drawCard();
	    	  System.out.println("The player gets +2 play Actions.");
					player.numActions = player.numActions + 2;
			return;


		default: return;
		}
	}

	public static Card getCard(List<Card> cards,CardName cardName) {
		for(int i=0; cards.size() >= i;i++){
			if(!cards.get(i).cardName.equals(cardName)) {
                    } else {
                            return 	cards.get(i);
                    }
		}

		return null;



	}

	   public static List<Card> filter(Iterable<Card> cards, Type target) {
		      List<Card> out = new ArrayList<Card>();
		      for (Card c : cards)
		         if (c.getType() == target)
		            out.add(c);
		      return out;
		   }
	// this method will print out all the constant cards ENUM
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(" \n\t" + this.getCardName());
//		sb.append("-" + this.getType() + " ");
//		sb.append("\t\t Cost: " + this.cost + " ");
//		sb.append("\t\t Score: " + this.score + " ");
//		sb.append("\tTreasure Value: " + this.treasureValue);

		return sb.toString();

	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!super.equals(obj)) return false;
		if(!(obj instanceof Card)) return false;

		return cardName.equals(((Card) obj).cardName);
	}

	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		return cardName.compareTo(o.cardName);
	}
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}