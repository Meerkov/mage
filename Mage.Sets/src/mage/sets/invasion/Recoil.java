/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.invasion;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.target.TargetPermanent;

/**
 *
 * @author LevelX2
 */
public class Recoil extends CardImpl {

    public Recoil(UUID ownerId) {
        super(ownerId, 264, "Recoil", Rarity.COMMON, new CardType[]{CardType.INSTANT}, "{1}{U}{B}");
        this.expansionSetCode = "INV";


        // Return target permanent to its owner's hand. Then that player discards a card.
        this.getSpellAbility().addEffect(new RecoilEffect());
        this.getSpellAbility().addTarget(new TargetPermanent());        
        
    }

    public Recoil(final Recoil card) {
        super(card);
    }

    @Override
    public Recoil copy() {
        return new Recoil(this);
    }
}

class RecoilEffect extends OneShotEffect {

    public RecoilEffect() {
        super(Outcome.Detriment);
        this.staticText = "return target permanent to its owner's hand. Then that player discards a card";
    }

    public RecoilEffect(final RecoilEffect effect) {
        super(effect);
    }

    @Override
    public RecoilEffect copy() {
        return new RecoilEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Permanent target = game.getPermanent(source.getFirstTarget());
        if (target != null) {
            Player controller = game.getPlayer(target.getControllerId());
            if (controller != null) {
                controller.moveCardToHandWithInfo(target, source.getSourceId(), game, Zone.BATTLEFIELD);
                controller.discard(1, source, game);
                return true;
            }
        }
        return false;
    }
}
