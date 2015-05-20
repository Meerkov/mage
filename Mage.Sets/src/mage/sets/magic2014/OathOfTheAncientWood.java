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
package mage.sets.magic2014;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.common.EntersBattlefieldAllTriggeredAbility;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.counter.AddCountersTargetEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.constants.SetTargetPointer;
import mage.constants.TargetController;
import mage.constants.Zone;
import mage.counters.CounterType;
import mage.filter.common.FilterEnchantmentPermanent;
import mage.filter.predicate.permanent.ControllerPredicate;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author LevelX2
 */
public class OathOfTheAncientWood extends CardImpl {

    private static final FilterEnchantmentPermanent filter = new FilterEnchantmentPermanent("Oath of the Ancient Wood or another enchantment");
    static {
        filter.add(new ControllerPredicate(TargetController.YOU));
    }

    public OathOfTheAncientWood(UUID ownerId) {
        super(ownerId, 187, "Oath of the Ancient Wood", Rarity.RARE, new CardType[]{CardType.ENCHANTMENT}, "{2}{G}");
        this.expansionSetCode = "M14";


        // Whenever Oath of the Ancient Wood or another enchantment enters the battlefield under your control, you may put a +1/+1 counter on target creature.
        Effect effect = new AddCountersTargetEffect(CounterType.P1P1.createInstance());
        Ability ability = new EntersBattlefieldAllTriggeredAbility(Zone.BATTLEFIELD, effect, filter, true, SetTargetPointer.PERMANENT, null, true);
        ability.addTarget(new TargetCreaturePermanent());
        this.addAbility(ability);
    }

    public OathOfTheAncientWood(final OathOfTheAncientWood card) {
        super(card);
    }

    @Override
    public OathOfTheAncientWood copy() {
        return new OathOfTheAncientWood(this);
    }
}
