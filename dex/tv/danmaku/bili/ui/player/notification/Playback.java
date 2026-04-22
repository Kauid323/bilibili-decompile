package tv.danmaku.bili.ui.player.notification;

import android.support.v4.media.MediaMetadataCompat;

public interface Playback {

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface Callback {
        void onError(String str);

        void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat);

        void onPlaybackStatusChanged(int i);
    }

    boolean enableLike();

    void fastForward(int i);

    int getCurrentStreamPosition();

    int getState();

    void init();

    boolean isPlaying();

    void like(boolean z);

    void pause();

    void play(MediaMetadataCompat mediaMetadataCompat);

    void playPause();

    void release();

    void rewind(int i);

    void setCallback(Callback callback);

    void setState(int i);

    void skipToNext();

    void skipToPrevious();

    void start();

    void stop(boolean z);

    void toggleMode();

    void updateMetadata();

    /* renamed from: tv.danmaku.bili.ui.player.notification.Playback$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static void $default$fastForward(Playback _this, int milliseconds) {
        }

        public static void $default$rewind(Playback _this, int milliseconds) {
        }

        public static boolean $default$enableLike(Playback _this) {
            return false;
        }

        public static void $default$like(Playback _this, boolean isLike) {
        }

        public static void $default$updateMetadata(Playback _this) {
        }
    }
}