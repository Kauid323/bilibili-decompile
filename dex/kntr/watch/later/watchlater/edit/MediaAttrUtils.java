package kntr.watch.later.watchlater.edit;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: FavFolder.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005J\u0016\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005J\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010$\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010%\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010'\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0005J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lkntr/watch/later/watchlater/edit/MediaAttrUtils;", "", "<init>", "()V", "TYPE_VIDEO", "", "TYPE_AUDIO", "TYPE_MENU", "TYPE_SEASON", "TYPE_OGV", "TYPE_OGV_V2", "TYPE_PAY_SEASON", "TYPE_UNKNOWN", "MT_PLAYLIST_PRIVATE", "MT_PLAYLIST_DEFAULT", "MT_PLAYLIST_REVIEW", "MT_PLAYLIST_DELETED", "MT_PLAYLIST_TITLE_UPDATED", "MT_PLAYLIST_INTRO_UPDATED", "MT_PLAYLIST_COVER_UPDATED", "MT_MEDIA_INVALID", "MT_MEDIA_PAY", "MT_MEDIA_ONLY_LOGIN", "MT_INTERACTION", "PLAY_LIST_TYPE_DEFAULT", "", "PLAY_LIST_TYPE_NON_DEFAULT", "isInteractionMedia", "", "attr", "isMTMediaInvalid", "isMTMediaNeedPay", "isMTMediaNeedLogin", "isVideoFree", "type", "isMTPlaylistPublic", "isMTPlaylistDefault", "getMTPlaylistType", "canMTPlaylistShare", "isVideo", "isAudio", "isSeason", "isOGV", "isPaySeason", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MediaAttrUtils {
    public static final int $stable = 0;
    public static final MediaAttrUtils INSTANCE = new MediaAttrUtils();
    private static final int MT_INTERACTION = 16;
    private static final int MT_MEDIA_INVALID = 1;
    private static final int MT_MEDIA_ONLY_LOGIN = 4;
    private static final int MT_MEDIA_PAY = 2;
    public static final int MT_PLAYLIST_COVER_UPDATED = 64;
    private static final int MT_PLAYLIST_DEFAULT = 2;
    public static final int MT_PLAYLIST_DELETED = 8;
    public static final int MT_PLAYLIST_INTRO_UPDATED = 32;
    private static final int MT_PLAYLIST_PRIVATE = 1;
    public static final int MT_PLAYLIST_REVIEW = 4;
    public static final int MT_PLAYLIST_TITLE_UPDATED = 16;
    private static final String PLAY_LIST_TYPE_DEFAULT = "default";
    private static final String PLAY_LIST_TYPE_NON_DEFAULT = "non-default";
    public static final int TYPE_AUDIO = 12;
    public static final int TYPE_MENU = 11;
    public static final int TYPE_OGV = 24;
    public static final int TYPE_OGV_V2 = 42;
    public static final int TYPE_PAY_SEASON = 1000;
    public static final int TYPE_SEASON = 21;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_VIDEO = 2;

    private MediaAttrUtils() {
    }

    public final boolean isInteractionMedia(int attr) {
        return (attr & 16) != 0;
    }

    public final boolean isMTMediaInvalid(int attr) {
        return (attr & 1) != 0;
    }

    public final boolean isMTMediaNeedPay(int attr) {
        return (attr & 2) != 0;
    }

    public final boolean isMTMediaNeedLogin(int attr) {
        return (attr & 4) != 0;
    }

    public final boolean isVideoFree(int attr, int type) {
        return !isMTMediaNeedPay(attr) && isVideo(type);
    }

    public final boolean isMTPlaylistPublic(int attr) {
        return (attr & 1) == 0;
    }

    public final boolean isMTPlaylistDefault(int attr) {
        return (attr & 2) == 0;
    }

    public final String getMTPlaylistType(int attr) {
        return isMTPlaylistDefault(attr) ? PLAY_LIST_TYPE_DEFAULT : PLAY_LIST_TYPE_NON_DEFAULT;
    }

    public final boolean canMTPlaylistShare(int attr) {
        return isMTPlaylistPublic(attr) && !isMTPlaylistDefault(attr);
    }

    public final boolean isVideo(int type) {
        return type == 2;
    }

    public final boolean isAudio(int type) {
        return type == 12;
    }

    public final boolean isSeason(int type) {
        return type == 21;
    }

    public final boolean isOGV(int type) {
        return type == 24;
    }

    public final boolean isPaySeason(int type) {
        return type == 1000;
    }
}