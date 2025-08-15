package logic.utility;

import java.util.ArrayList;

import logic.card.BaseCard;
import logic.game.GameLogic;

public class GameLogicUtility {

    public static boolean drawRule() {
        for (BaseCard card : GameLogic.getInstance().getHand()) {
            if (card.ruleCheck())
                return false;
        }

        return true;
    }

}
