package tv.danmaku.bili.ui.splash.ad.util;

import android.app.Application;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.bilibili.base.BiliContext;
import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashAudioManager.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/util/SplashAudioManager;", "", "<init>", "()V", "mAudioManager", "Landroid/media/AudioManager;", "mOnAudioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "requestFocus", "", "releaseFocus", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashAudioManager {
    public static final int $stable = 8;
    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: tv.danmaku.bili.ui.splash.ad.util.SplashAudioManager$$ExternalSyntheticLambda0
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i) {
            SplashAudioManager.mOnAudioFocusChangeListener$lambda$0(i);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnAudioFocusChangeListener$lambda$0(int focusChange) {
        if (focusChange == 1) {
            BLog.i("[Splash]SplashAudioManager", "OnAudioFocusChangeListener, forceState = " + focusChange);
        }
    }

    public final void requestFocus() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager == null) {
            Application application = BiliContext.application();
            Object systemService = application != null ? application.getSystemService("audio") : null;
            audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        }
        this.mAudioManager = audioManager;
        if (Build.VERSION.SDK_INT >= 26) {
            AudioManager audioManager2 = this.mAudioManager;
            if (audioManager2 != null) {
                audioManager2.requestAudioFocus(new AudioFocusRequest.Builder(1).setOnAudioFocusChangeListener(this.mOnAudioFocusChangeListener).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).build()).build());
                return;
            }
            return;
        }
        AudioManager audioManager3 = this.mAudioManager;
        if (audioManager3 != null) {
            audioManager3.requestAudioFocus(this.mOnAudioFocusChangeListener, 3, 1);
        }
    }

    public final void releaseFocus() {
        if (Build.VERSION.SDK_INT >= 26) {
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null) {
                audioManager.abandonAudioFocusRequest(new AudioFocusRequest.Builder(1).setOnAudioFocusChangeListener(this.mOnAudioFocusChangeListener).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).build()).build());
                return;
            }
            return;
        }
        AudioManager audioManager2 = this.mAudioManager;
        if (audioManager2 != null) {
            audioManager2.abandonAudioFocus(this.mOnAudioFocusChangeListener);
        }
    }
}