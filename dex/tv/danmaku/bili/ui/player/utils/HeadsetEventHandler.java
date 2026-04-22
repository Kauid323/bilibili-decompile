package tv.danmaku.bili.ui.player.utils;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import tv.danmaku.android.log.BLog;

public final class HeadsetEventHandler {
    private static final int MEDIA_BUTTON_CLICK_ONCE = 1;
    private static final int MEDIA_BUTTON_CLICK_THRICE = 3;
    private static final int MEDIA_BUTTON_CLICK_TWICE = 2;
    private static final String TAG = "HeadsetEventHandler";
    private MediaSessionCompat.Callback mCallback;
    private MediaSessionCompat mMediaSession;
    private int mMediaButtonDownTimes = 0;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable mMediaButtonDownRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.player.utils.HeadsetEventHandler$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            HeadsetEventHandler.this.m1436lambda$new$0$tvdanmakubiliuiplayerutilsHeadsetEventHandler();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$tv-danmaku-bili-ui-player-utils-HeadsetEventHandler  reason: not valid java name */
    public /* synthetic */ void m1436lambda$new$0$tvdanmakubiliuiplayerutilsHeadsetEventHandler() {
        if (this.mMediaSession == null || this.mCallback == null || this.mMediaSession.getController() == null) {
            return;
        }
        int times = this.mMediaButtonDownTimes;
        this.mMediaButtonDownTimes = 0;
        PlaybackStateCompat state = this.mMediaSession.getController().getPlaybackState();
        long validActions = state == null ? 0L : state.getActions();
        BLog.i(TAG, "mMediaButtonDownRunnable, times: " + times + " validActions: " + validActions);
        if (times == 1) {
            handleMediaPlayPauseKeySingleTap();
        } else if (times == 2) {
            if ((32 & validActions) != 0) {
                this.mCallback.onSkipToNext();
            }
        } else if (times >= 3 && (16 & validActions) != 0) {
            this.mCallback.onSkipToPrevious();
        }
    }

    public HeadsetEventHandler(MediaSessionCompat mediaSession, MediaSessionCompat.Callback callback) {
        this.mMediaSession = mediaSession;
        this.mCallback = callback;
    }

    public boolean interceptHeadsetHookEvent(Intent mediaButtonEvent) {
        if (mediaButtonEvent == null) {
            return false;
        }
        KeyEvent keyEvent = (KeyEvent) mediaButtonEvent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        BLog.i(TAG, "intercept headset event message:" + keyEvent.toString());
        if (keyEvent == null || keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        switch (keyCode) {
            case 79:
            case 85:
                if (keyEvent.getRepeatCount() > 0) {
                    handleMediaPlayPauseKeySingleTap();
                    return true;
                }
                this.mMediaButtonDownTimes++;
                if (this.mMediaButtonDownTimes != 1) {
                    this.mHandler.removeCallbacks(this.mMediaButtonDownRunnable);
                }
                this.mHandler.postDelayed(this.mMediaButtonDownRunnable, ViewConfiguration.getDoubleTapTimeout());
                return true;
            default:
                return false;
        }
    }

    private void handleMediaPlayPauseKeySingleTap() {
        if (this.mMediaSession == null || this.mCallback == null || this.mMediaSession.getController() == null) {
            return;
        }
        PlaybackStateCompat state = this.mMediaSession.getController().getPlaybackState();
        long validActions = state == null ? 0L : state.getActions();
        boolean isPlaying = state != null && state.getState() == 3;
        boolean canPlay = (516 & validActions) != 0;
        boolean canPause = (514 & validActions) != 0;
        BLog.i(TAG, "handleMediaPlayPauseKeySingleTap, isPlaying: " + isPlaying + " canPause: " + canPause + " canPlay: " + canPlay);
        if (isPlaying && canPause) {
            this.mCallback.onPause();
        } else if (!isPlaying && canPlay) {
            this.mCallback.onPlay();
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.mMediaButtonDownRunnable);
    }
}