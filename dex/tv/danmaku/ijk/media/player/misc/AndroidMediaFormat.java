package tv.danmaku.ijk.media.player.misc;

import android.media.MediaFormat;
import tv.danmaku.bili.update.utils.StringsKt;

public class AndroidMediaFormat implements IMediaFormat {
    private final MediaFormat mMediaFormat;

    public AndroidMediaFormat(MediaFormat mediaFormat) {
        this.mMediaFormat = mediaFormat;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaFormat
    public int getInteger(String name) {
        if (this.mMediaFormat == null) {
            return 0;
        }
        return this.mMediaFormat.getInteger(name);
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaFormat
    public String getString(String name) {
        if (this.mMediaFormat == null) {
            return null;
        }
        return this.mMediaFormat.getString(name);
    }

    public String toString() {
        StringBuilder out = new StringBuilder(128);
        out.append(getClass().getName());
        out.append('{');
        if (this.mMediaFormat != null) {
            out.append(this.mMediaFormat.toString());
        } else {
            out.append(StringsKt.NULL_STRING);
        }
        out.append('}');
        return out.toString();
    }
}