/*
 * This file is part of packetevents - https://github.com/retrooper/packetevents
 * Copyright (C) 2021 retrooper and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.retrooper.packetevents.wrapper.play.server;

import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.player.InteractionHand;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;

public class WrapperPlayServerOpenBook extends PacketWrapper<WrapperPlayServerOpenBook> {
    InteractionHand hand;

    public WrapperPlayServerOpenBook(PacketSendEvent event) {
        super(event);
    }

    public WrapperPlayServerOpenBook(InteractionHand hand) {
        super(PacketType.Play.Server.OPEN_BOOK);
        this.hand = hand;
    }

    @Override
    public void read() {
        hand = InteractionHand.values()[readVarInt()];
    }

    @Override
    public void copy(WrapperPlayServerOpenBook wrapper) {
        hand = wrapper.hand;
    }

    @Override
    public void write() {
        writeVarInt(hand.ordinal());
    }

    public InteractionHand getHand() {
        return hand;
    }

    public void setHand(InteractionHand hand) {
        this.hand = hand;
    }
}
