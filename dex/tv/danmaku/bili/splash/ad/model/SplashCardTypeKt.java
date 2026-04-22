package tv.danmaku.bili.splash.ad.model;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: SplashCardType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"CARD_TYPE_FULL_IMAGE", "", "CARD_TYPE_HALF_IMAGE", "CARD_TYPE_VIDEO_PORT", "CARD_TYPE_VIDEO_FULLSCREEN", "CARD_TYPE_STORY", "CARD_TYPE_BANNER", "isSupportedSplashCardType", "", "type", "isVideoSplashCardType", "isOnlyVideoSplash", "isImageSplashCardType", "isFullScreenCardType", "isImageWithVideoCardType", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashCardTypeKt {
    public static final int CARD_TYPE_BANNER = 152;
    public static final int CARD_TYPE_FULL_IMAGE = 14;
    public static final int CARD_TYPE_HALF_IMAGE = 15;
    public static final int CARD_TYPE_STORY = 109;
    public static final int CARD_TYPE_VIDEO_FULLSCREEN = 39;
    public static final int CARD_TYPE_VIDEO_PORT = 16;

    public static final boolean isSupportedSplashCardType(int type) {
        return isVideoSplashCardType(type) || isImageSplashCardType(type);
    }

    public static final boolean isVideoSplashCardType(int type) {
        switch (type) {
            case 16:
            case 39:
            case 109:
            case 152:
                return true;
            default:
                return false;
        }
    }

    public static final boolean isOnlyVideoSplash(int type) {
        switch (type) {
            case 16:
            case 39:
            case 109:
                return true;
            default:
                return false;
        }
    }

    public static final boolean isImageSplashCardType(int type) {
        switch (type) {
            case 14:
            case 15:
                return true;
            default:
                return false;
        }
    }

    public static final boolean isFullScreenCardType(int type) {
        switch (type) {
            case 14:
            case 39:
            case 109:
            case 152:
                return true;
            default:
                return false;
        }
    }

    public static final boolean isImageWithVideoCardType(int type) {
        return type == 152;
    }
}