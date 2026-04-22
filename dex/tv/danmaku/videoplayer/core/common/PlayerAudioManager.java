package tv.danmaku.videoplayer.core.common;

import android.app.Application;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.bilibili.base.BiliContext;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerAudioManager.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\bJ\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0018\u001a\u00020\u0012H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/videoplayer/core/common/PlayerAudioManager;", "", "<init>", "()V", "mAudioManager", "Landroid/media/AudioManager;", "mMonopolyListenerRef", "Ljava/lang/ref/WeakReference;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "mLastRequestListenerRef", "mFocusRequestsByListener", "Ljava/util/WeakHashMap;", "Landroid/media/AudioFocusRequest;", "requestMonopolyFocus", "", "l", "force", "abandonMonopolyFocus", "", "requestAudioFocus", "", "streamType", "durationHint", "abandonAudioFocus", "makeSureManager", "Companion", "mediacenter_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerAudioManager {
    public static final int AUDIOFOCUS_ABANDON_MONOPOLY = 101;
    public static final int AUDIOFOCUS_REQUEST_MONOPOLY = 100;
    public static final Companion Companion = new Companion(null);
    private static String TAG = "PlayerAudioManager";
    private static final Lazy<PlayerAudioManager> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: tv.danmaku.videoplayer.core.common.PlayerAudioManager$$ExternalSyntheticLambda0
        public final Object invoke() {
            PlayerAudioManager instance_delegate$lambda$0;
            instance_delegate$lambda$0 = PlayerAudioManager.instance_delegate$lambda$0();
            return instance_delegate$lambda$0;
        }
    });
    private AudioManager mAudioManager;
    private final WeakHashMap<AudioManager.OnAudioFocusChangeListener, AudioFocusRequest> mFocusRequestsByListener = new WeakHashMap<>();
    private WeakReference<AudioManager.OnAudioFocusChangeListener> mLastRequestListenerRef;
    private WeakReference<AudioManager.OnAudioFocusChangeListener> mMonopolyListenerRef;

    /* compiled from: PlayerAudioManager.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\u00020\u00078FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/videoplayer/core/common/PlayerAudioManager$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Ltv/danmaku/videoplayer/core/common/PlayerAudioManager;", "getInstance$annotations", "getInstance", "()Ltv/danmaku/videoplayer/core/common/PlayerAudioManager;", "instance$delegate", "Lkotlin/Lazy;", "AUDIOFOCUS_REQUEST_MONOPOLY", "", "AUDIOFOCUS_ABANDON_MONOPOLY", "mediacenter_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        private Companion() {
        }

        public final PlayerAudioManager getInstance() {
            return (PlayerAudioManager) PlayerAudioManager.instance$delegate.getValue();
        }
    }

    private PlayerAudioManager() {
    }

    public static final PlayerAudioManager getInstance() {
        return Companion.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerAudioManager instance_delegate$lambda$0() {
        return new PlayerAudioManager();
    }

    public final boolean requestMonopolyFocus(AudioManager.OnAudioFocusChangeListener l, boolean force) {
        Intrinsics.checkNotNullParameter(l, "l");
        WeakReference<AudioManager.OnAudioFocusChangeListener> weakReference = this.mMonopolyListenerRef;
        AudioManager.OnAudioFocusChangeListener listener = weakReference != null ? weakReference.get() : null;
        if (listener == null) {
            this.mMonopolyListenerRef = new WeakReference<>(l);
            return true;
        } else if (!force) {
            BLog.e(TAG, "requestMonopolyFocus failed, has be monopoly by:" + listener + ":" + listener.hashCode());
            return false;
        } else {
            this.mMonopolyListenerRef = new WeakReference<>(l);
            BLog.i(TAG, "force requestMonopolyFocus, old owner:" + listener + ":" + listener.hashCode() + " new owner:" + l + ":" + l.hashCode());
            return true;
        }
    }

    public final void abandonMonopolyFocus(AudioManager.OnAudioFocusChangeListener l) {
        Intrinsics.checkNotNullParameter(l, "l");
        WeakReference<AudioManager.OnAudioFocusChangeListener> weakReference = this.mMonopolyListenerRef;
        AudioManager.OnAudioFocusChangeListener listener = weakReference != null ? weakReference.get() : null;
        if (Intrinsics.areEqual(listener, l)) {
            this.mMonopolyListenerRef = null;
            WeakReference<AudioManager.OnAudioFocusChangeListener> weakReference2 = this.mLastRequestListenerRef;
            AudioManager.OnAudioFocusChangeListener lastRequestListener = weakReference2 != null ? weakReference2.get() : null;
            this.mLastRequestListenerRef = null;
            if (lastRequestListener != null) {
                lastRequestListener.onAudioFocusChange(101);
            }
            BLog.i(TAG, "abandon monopoly focus");
        }
    }

    public final int requestAudioFocus(AudioManager.OnAudioFocusChangeListener l, int streamType, int durationHint) {
        Intrinsics.checkNotNullParameter(l, "l");
        WeakReference<AudioManager.OnAudioFocusChangeListener> weakReference = this.mMonopolyListenerRef;
        AudioManager.OnAudioFocusChangeListener listener = weakReference != null ? weakReference.get() : null;
        if (listener != null && !Intrinsics.areEqual(listener, l)) {
            BLog.i(TAG, "requestAudioFocus failed, has be monopoly by:" + listener + ":" + listener.hashCode());
            this.mLastRequestListenerRef = new WeakReference<>(l);
            return 100;
        }
        makeSureManager();
        if (Build.VERSION.SDK_INT >= 26) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(1).setContentType(3).build();
            AudioFocusRequest focusRequest = new AudioFocusRequest.Builder(durationHint).setAudioAttributes(audioAttributes).setWillPauseWhenDucked(true).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(l).build();
            this.mFocusRequestsByListener.put(l, focusRequest);
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null) {
                return audioManager.requestAudioFocus(focusRequest);
            }
            return 0;
        }
        AudioManager audioManager2 = this.mAudioManager;
        int result = audioManager2 != null ? audioManager2.requestAudioFocus(l, streamType, durationHint) : 0;
        BLog.i(TAG, "request audio focus : " + result);
        return result;
    }

    public final int abandonAudioFocus(AudioManager.OnAudioFocusChangeListener l) {
        AudioFocusRequest focusRequest;
        Intrinsics.checkNotNullParameter(l, "l");
        WeakReference<AudioManager.OnAudioFocusChangeListener> weakReference = this.mLastRequestListenerRef;
        AudioManager.OnAudioFocusChangeListener lastListener = weakReference != null ? weakReference.get() : null;
        if (Intrinsics.areEqual(lastListener, l)) {
            this.mLastRequestListenerRef = null;
        }
        makeSureManager();
        if (Build.VERSION.SDK_INT >= 26 && (focusRequest = this.mFocusRequestsByListener.remove(l)) != null) {
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null) {
                return audioManager.abandonAudioFocusRequest(focusRequest);
            }
            return 0;
        }
        AudioManager audioManager2 = this.mAudioManager;
        int result = audioManager2 != null ? audioManager2.abandonAudioFocus(l) : 0;
        BLog.i(TAG, "abandon audio focus : " + result);
        return result;
    }

    private final void makeSureManager() {
        if (this.mAudioManager == null) {
            Application application = BiliContext.application();
            Object systemService = application != null ? application.getSystemService("audio") : null;
            this.mAudioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        }
    }
}