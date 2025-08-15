package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

public class NumberCard extends BaseCard {

    public NumberCard(CardColor color, CardSymbol symbol) {
        super(color);
        setSymbol(symbol);
    }

	public void play() {
        GameLogic.getInstance().setTopCard(this);
	}

	public boolean ruleCheck() {
        BaseCard topCard = GameLogic.getInstance().getTopCard();
        return topCard.getColor().equals(getColor()) || topCard.getSymbol().equals(getSymbol());
	}

}
