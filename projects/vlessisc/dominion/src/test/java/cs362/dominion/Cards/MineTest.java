package cs362.dominion.Cards;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cs362.dominion.Exceptions.ConfiguationException;
import cs362.dominion.Resources.Game;

public class MineTest {

	private Class<? extends Card> cardType = Mine.class;
	private Game game;
	
	@Before
	public void setUp() throws Exception {
		ArrayList<Class<? extends Card>> kingdomCards = new ArrayList<Class<? extends Card>>();	
		kingdomCards.add(Adventurer.class);
		kingdomCards.add(Ambassador.class);
		kingdomCards.add(Baron.class);
		kingdomCards.add(CouncilRoom.class);
		kingdomCards.add(Cutpurse.class);
		kingdomCards.add(Embargo.class);
		kingdomCards.add(Feast.class);
		//kingdomCards.add(Gardens.class);
		//kingdomCards.add(GreatHall.class);
		kingdomCards.add(Mine.class);
		/** 3 extra card types **/
		//kingdomCards.add(Smithy.class);
		kingdomCards.add(Bazaar.class);
		kingdomCards.add(Village.class);
		// Create a new game
		
		try {
			this.game = new Game(2, kingdomCards);
		} catch (ConfiguationException e) {
			fail("Could not initialize game");
		}
	}
	
	
	/**
	 * Card is trashed, and one card is gained
	 */
	@Test
	public void testCards() {
		game.getCurrentPlayer().deck.hand.addCard(game.supply.drawCard(Mine.class));
		game.getCurrentPlayer().deck.hand.addCard(game.supply.drawCard(Copper.class));
		// Total change should be zero. 
		// -1 : plays action cards
		// -1 : discards copper
		// +1 : gains treasure
		Helpers.Cards.testCards(game, cardType, 0);
	}

	/**
	 * Card gained should cost more
	 */
	@Test
	public void testCoins() {
		Helpers.Cards.testCoinsGT(game, cardType);
	}
	
	@Test
	public void testDescription() {
		Helpers.Cards.testDescription(game, cardType);
	}

}