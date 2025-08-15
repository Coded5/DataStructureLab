package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

public class DrawTwoCard extends BaseCard {

    public DrawTwoCard(CardColor color) {
        super(color);
        setSymbol(CardSymbol.DRAW);
    }

	public void play() {
        GameLogic.getInstance().setTopCard(this);
        GameLogic.getInstance().draw(2);
	}

	public boolean ruleCheck() {
        return GameLogic.getInstance().getTopCard().getColor().equals(getColor());
	}

}
