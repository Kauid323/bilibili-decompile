package tv.danmaku.biliplayerimpl.clock;

import com.bilibili.droid.thread.HandlerThreads;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2;
import tv.danmaku.biliplayerv2.clock.PlayerProgressRangeObserver;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.service.PlayerProgressObserver;
import tv.danmaku.biliplayerv2.service.PlayerSeekObserver;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerTimer.kt */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0015\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001fJ\u0006\u0010 \u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\u001cJ\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\fJ\u000e\u0010'\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\fJ\u001e\u0010(\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*J\u000e\u0010,\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u0010R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R2\u0010\n\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\u000e\u001aB\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00100\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00110\u0011 \r* \u0012\f\u0012\n \r*\u0004\u0018\u00010\u00100\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Ltv/danmaku/biliplayerimpl/clock/PlayerTimer;", "", "mPlayerCoreServiceWeakReference", "Ljava/lang/ref/WeakReference;", "Ltv/danmaku/biliplayerimpl/core/PlayerCoreServiceV2;", "<init>", "(Ljava/lang/ref/WeakReference;)V", "getMPlayerCoreServiceWeakReference", "()Ljava/lang/ref/WeakReference;", "setMPlayerCoreServiceWeakReference", "mPlayerProgressObservers", "Ltv/danmaku/biliplayerv2/collection/Collections$SafeIteratorList;", "Ltv/danmaku/biliplayerv2/service/PlayerProgressObserver;", "kotlin.jvm.PlatformType", "mPlayerProgressRangeObservers", "Ltv/danmaku/biliplayerv2/collection/Collections$SafeIteratorMap;", "Ltv/danmaku/biliplayerv2/clock/PlayerProgressRangeObserver;", "Ltv/danmaku/biliplayerimpl/clock/ProgressRange;", "mPlayerClockWorking", "", "mClockRunnable", "tv/danmaku/biliplayerimpl/clock/PlayerTimer$mClockRunnable$1", "Ltv/danmaku/biliplayerimpl/clock/PlayerTimer$mClockRunnable$1;", "mPlayerStateObserver", "Ltv/danmaku/biliplayerv2/service/PlayerStateObserver;", "mPlayerSeekObserver", "Ltv/danmaku/biliplayerv2/service/PlayerSeekObserver;", "init", "", "init$biliplayerimpl_debug", "release", "release$biliplayerimpl_debug", "start", "stop", "dispatchProgressChange", "ensurePlayerClockState", "clockEnable", "registerPlayerProgressObserver", "observer", "unregisterPlayerProgressObserver", "registerPlayerProgressRangeObserver", "startPosition", "", "endPosition", "unregisterPlayerProgressRangeObserver", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerTimer {
    public static final Companion Companion = new Companion(null);
    private static final long DEFAULT_CLOCK_INTERVAL = 1000;
    private static final String TAG = "PlayerTimer";
    private final PlayerTimer$mClockRunnable$1 mClockRunnable;
    private boolean mPlayerClockWorking;
    private WeakReference<PlayerCoreServiceV2> mPlayerCoreServiceWeakReference;
    private final Collections.SafeIteratorList<PlayerProgressObserver> mPlayerProgressObservers;
    private final Collections.SafeIteratorMap<PlayerProgressRangeObserver, ProgressRange> mPlayerProgressRangeObservers;
    private final PlayerSeekObserver mPlayerSeekObserver;
    private final PlayerStateObserver mPlayerStateObserver;

    /* JADX WARN: Type inference failed for: r0v7, types: [tv.danmaku.biliplayerimpl.clock.PlayerTimer$mClockRunnable$1] */
    public PlayerTimer(WeakReference<PlayerCoreServiceV2> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "mPlayerCoreServiceWeakReference");
        this.mPlayerCoreServiceWeakReference = weakReference;
        this.mPlayerProgressObservers = Collections.safeIteratorList(new LinkedList());
        this.mPlayerProgressRangeObservers = Collections.safeIteratorMap(new LinkedHashMap());
        this.mClockRunnable = new Runnable() { // from class: tv.danmaku.biliplayerimpl.clock.PlayerTimer$mClockRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                HandlerThreads.postDelayed(0, this, 1000L);
                PlayerTimer.this.dispatchProgressChange();
                PlayerTimer.this.ensurePlayerClockState();
            }
        };
        this.mPlayerStateObserver = new PlayerStateObserver() { // from class: tv.danmaku.biliplayerimpl.clock.PlayerTimer$mPlayerStateObserver$1
            @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
            public void onPlayerStateChanged(int state) {
                switch (state) {
                    case 4:
                        PlayerTimer.this.start();
                        return;
                    case 5:
                        PlayerTimer.this.dispatchProgressChange();
                        PlayerTimer.this.stop();
                        return;
                    case 6:
                        PlayerTimer.this.dispatchProgressChange();
                        PlayerTimer.this.stop();
                        return;
                    default:
                        PlayerTimer.this.stop();
                        return;
                }
            }
        };
        this.mPlayerSeekObserver = new PlayerSeekObserver() { // from class: tv.danmaku.biliplayerimpl.clock.PlayerTimer$mPlayerSeekObserver$1
            @Override // tv.danmaku.biliplayerv2.service.PlayerSeekObserver
            public /* synthetic */ void onSeekStart(long j) {
                PlayerSeekObserver.CC.$default$onSeekStart(this, j);
            }

            @Override // tv.danmaku.biliplayerv2.service.PlayerSeekObserver
            public void onSeekComplete(long position) {
                PlayerTimer.this.dispatchProgressChange();
            }
        };
    }

    public final WeakReference<PlayerCoreServiceV2> getMPlayerCoreServiceWeakReference() {
        return this.mPlayerCoreServiceWeakReference;
    }

    public final void setMPlayerCoreServiceWeakReference(WeakReference<PlayerCoreServiceV2> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.mPlayerCoreServiceWeakReference = weakReference;
    }

    public final void init$biliplayerimpl_debug() {
        PlayerCoreServiceV2 playerCoreServiceV2 = this.mPlayerCoreServiceWeakReference.get();
        if (playerCoreServiceV2 != null) {
            playerCoreServiceV2.registerSeekObserver(this.mPlayerSeekObserver);
        }
        PlayerCoreServiceV2 playerCoreServiceV22 = this.mPlayerCoreServiceWeakReference.get();
        if (playerCoreServiceV22 != null) {
            playerCoreServiceV22.registerState(this.mPlayerStateObserver, 4, 5, 6, 7, 8);
        }
    }

    public final void release$biliplayerimpl_debug() {
        stop();
        this.mPlayerProgressObservers.clear();
        this.mPlayerProgressRangeObservers.clear();
        PlayerCoreServiceV2 playerCoreServiceV2 = this.mPlayerCoreServiceWeakReference.get();
        if (playerCoreServiceV2 != null) {
            playerCoreServiceV2.unregisterSeekObserver(this.mPlayerSeekObserver);
        }
        PlayerCoreServiceV2 playerCoreServiceV22 = this.mPlayerCoreServiceWeakReference.get();
        if (playerCoreServiceV22 != null) {
            playerCoreServiceV22.unregisterState(this.mPlayerStateObserver);
        }
    }

    public final void start() {
        if (this.mPlayerClockWorking || !clockEnable()) {
            return;
        }
        this.mPlayerClockWorking = true;
        HandlerThreads.post(0, this.mClockRunnable);
        BLog.i(TAG, "Timer start.");
    }

    public final void stop() {
        if (!this.mPlayerClockWorking) {
            return;
        }
        HandlerThreads.remove(0, this.mClockRunnable);
        this.mPlayerClockWorking = false;
        BLog.i(TAG, "Timer stop.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchProgressChange() {
        PlayerCoreServiceV2 service = this.mPlayerCoreServiceWeakReference.get();
        final int progress = service != null ? service.getCurrentPosition() : 0;
        final int duration = service != null ? service.getDuration() : 0;
        Collections.SafeIteratorMap playerProgressRangeObservers = this.mPlayerProgressRangeObservers;
        playerProgressRangeObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.clock.PlayerTimer$$ExternalSyntheticLambda0
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                PlayerTimer.dispatchProgressChange$lambda$0(progress, (Map.Entry) obj);
            }
        });
        playerProgressRangeObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.clock.PlayerTimer$$ExternalSyntheticLambda1
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                PlayerTimer.dispatchProgressChange$lambda$1(progress, (Map.Entry) obj);
            }
        });
        this.mPlayerProgressObservers.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.clock.PlayerTimer$$ExternalSyntheticLambda2
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((PlayerProgressObserver) obj).onPlayerProgressChange(progress, duration);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchProgressChange$lambda$0(int $progress, Map.Entry it) {
        if (($progress <= ((ProgressRange) it.getValue()).getStartPosition() || ((ProgressRange) it.getValue()).getEndPosition() < $progress) && ((ProgressRange) it.getValue()).isActive()) {
            ((PlayerProgressRangeObserver) it.getKey()).onRangeStateChanged(false, $progress);
            ((ProgressRange) it.getValue()).setActive(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchProgressChange$lambda$1(int $progress, Map.Entry it) {
        if (!((ProgressRange) it.getValue()).isActive() && ((ProgressRange) it.getValue()).getStartPosition() < $progress && $progress <= ((ProgressRange) it.getValue()).getEndPosition()) {
            ((ProgressRange) it.getValue()).setActive(true);
            ((PlayerProgressRangeObserver) it.getKey()).onRangeStateChanged(true, $progress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensurePlayerClockState() {
        if (clockEnable()) {
            start();
        } else {
            stop();
        }
    }

    private final boolean clockEnable() {
        Collections.SafeIteratorMap<PlayerProgressRangeObserver, ProgressRange> safeIteratorMap = this.mPlayerProgressRangeObservers;
        Intrinsics.checkNotNullExpressionValue(safeIteratorMap, "mPlayerProgressRangeObservers");
        if (safeIteratorMap.isEmpty()) {
            Collections.SafeIteratorList<PlayerProgressObserver> safeIteratorList = this.mPlayerProgressObservers;
            Intrinsics.checkNotNullExpressionValue(safeIteratorList, "mPlayerProgressObservers");
            if (safeIteratorList.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final void registerPlayerProgressObserver(PlayerProgressObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mPlayerProgressObservers.contains(observer)) {
            this.mPlayerProgressObservers.add(observer);
        }
        ensurePlayerClockState();
    }

    public final void unregisterPlayerProgressObserver(PlayerProgressObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayerProgressObservers.remove(observer);
        ensurePlayerClockState();
    }

    public final void registerPlayerProgressRangeObserver(PlayerProgressRangeObserver observer, long startPosition, long endPosition) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayerProgressRangeObservers.put(observer, new ProgressRange(startPosition, endPosition, false));
        ensurePlayerClockState();
    }

    public final void unregisterPlayerProgressRangeObserver(PlayerProgressRangeObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPlayerProgressRangeObservers.remove(observer);
        ensurePlayerClockState();
    }

    /* compiled from: PlayerTimer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerimpl/clock/PlayerTimer$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_CLOCK_INTERVAL", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}