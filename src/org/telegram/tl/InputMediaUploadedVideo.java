/*
 *     This file is part of Telegram Server
 *     Copyright (C) 2015  Aykut Alparslan KOÇ
 *
 *     Telegram Server is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Telegram Server is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.telegram.tl;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.*;

public class InputMediaUploadedVideo extends TLInputMedia {

    public static final int ID = 322623222;

    public TLInputFile file;
    public int duration;
    public int w;
    public int h;
    public String mime_type;

    public InputMediaUploadedVideo() {
    }

    public InputMediaUploadedVideo(TLInputFile file, int duration, int w, int h, String mime_type){
        this.file = file;
        this.duration = duration;
        this.w = w;
        this.h = h;
        this.mime_type = mime_type;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        file = (TLInputFile) buffer.readTLObject(APIContext.getInstance());
        duration = buffer.readInt();
        w = buffer.readInt();
        h = buffer.readInt();
        mime_type = buffer.readString();
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(32);
        serializeTo(buffer);
        return buffer;
    }

    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeTLObject(file);
        buff.writeInt(duration);
        buff.writeInt(w);
        buff.writeInt(h);
        buff.writeString(mime_type);
    }

    public int getConstructor() {
        return ID;
    }
}