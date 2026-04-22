package tv.danmaku.ijk.media.player.misc;

import android.media.MediaFormat;
import android.media.MediaPlayer;
import tv.danmaku.bili.update.utils.StringsKt;

public class AndroidTrackInfo implements ITrackInfo {
    private final MediaPlayer.TrackInfo mTrackInfo;

    public static AndroidTrackInfo[] fromMediaPlayer(MediaPlayer mp) {
        return fromTrackInfo(mp.getTrackInfo());
    }

    private static AndroidTrackInfo[] fromTrackInfo(MediaPlayer.TrackInfo[] trackInfos) {
        if (trackInfos == null) {
            return null;
        }
        AndroidTrackInfo[] androidTrackInfo = new AndroidTrackInfo[trackInfos.length];
        for (int i = 0; i < trackInfos.length; i++) {
            androidTrackInfo[i] = new AndroidTrackInfo(trackInfos[i]);
        }
        return androidTrackInfo;
    }

    private AndroidTrackInfo(MediaPlayer.TrackInfo trackInfo) {
        this.mTrackInfo = trackInfo;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public IMediaFormat getFormat() {
        MediaFormat mediaFormat;
        if (this.mTrackInfo == null || (mediaFormat = this.mTrackInfo.getFormat()) == null) {
            return null;
        }
        return new AndroidMediaFormat(mediaFormat);
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public String getLanguage() {
        if (this.mTrackInfo == null) {
            return "und";
        }
        return this.mTrackInfo.getLanguage();
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public int getTrackType() {
        if (this.mTrackInfo == null) {
            return 0;
        }
        return this.mTrackInfo.getTrackType();
    }

    public String toString() {
        StringBuilder out = new StringBuilder(128);
        out.append(getClass().getSimpleName());
        out.append('{');
        if (this.mTrackInfo != null) {
            out.append(this.mTrackInfo.toString());
        } else {
            out.append(StringsKt.NULL_STRING);
        }
        out.append('}');
        return out.toString();
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public String getInfoInline() {
        if (this.mTrackInfo != null) {
            return this.mTrackInfo.toString();
        }
        return StringsKt.NULL_STRING;
    }
}