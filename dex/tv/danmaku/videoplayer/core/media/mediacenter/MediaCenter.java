package tv.danmaku.videoplayer.core.media.mediacenter;

import android.content.Context;
import android.os.Looper;
import com.bilibili.lib.blconfig.ConfigManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.mediacenter.BuildConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.player.plugin.mod.X86IjkRequest;
import tv.danmaku.videoplayer.core.media.mediacenter.config.MediaPlayerConfig;
import tv.danmaku.videoplayer.core.media.mediacenter.creator.MediaPlayerCreator;
import tv.danmaku.videoplayer.core.media.mediacenter.listener.IMediaPlayerLifeCycleListener;
import tv.danmaku.videoplayer.core.media.mediacenter.record.MediaPlayerRecord;
import tv.danmaku.videoplayer.core.media.mediacenter.record.PlayerType;
import tv.danmaku.videoplayer.core.media.mediacenter.utils.IjkEventThread;
import tv.danmaku.videoplayer.core.media.mediacenter.utils.LruActionCallback;
import tv.danmaku.videoplayer.core.media.mediacenter.utils.LruCacheMap;

/* compiled from: MediaCenter.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!J\u0018\u0010\u001f\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#J\u001a\u0010$\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010\u00102\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)H\u0007J \u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0007J\u001a\u0010,\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010\u00132\u0006\u0010(\u001a\u00020)H\u0007J\u001a\u0010-\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010)H\u0007J\"\u0010-\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010.\u001a\u00020\u001dH\u0007J\b\u0010/\u001a\u00020\u001dH\u0007J\b\u00100\u001a\u00020\u001dH\u0002J\u0018\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u0013H\u0002J\u001a\u00103\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010\u00132\u0006\u0010(\u001a\u00020)H\u0002J\"\u00104\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010.\u001a\u00020\u001dH\u0002J\u0010\u00105\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0013H\u0007J\u0018\u00106\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+H\u0007J\b\u00107\u001a\u00020\u0018H\u0002J\b\u00108\u001a\u00020\u0018H\u0002J\u0010\u00109\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+H\u0002J\u0012\u0010:\u001a\u0004\u0018\u00010\f2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010;\u001a\u00020\u0007H\u0002J\b\u0010<\u001a\u00020\u0007H\u0002J\b\u0010=\u001a\u00020\u0007H\u0002J\b\u0010>\u001a\u0004\u0018\u00010?J\u0006\u0010@\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0012j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Ltv/danmaku/videoplayer/core/media/mediacenter/MediaCenter;", "", "<init>", "()V", "TAG", "", "MAX_COUNT_PLAYER_INSTANCE", "", "MAX_COUNT_EXCLUSIVE_PLAYER_INSTANCE", "MAX_COUNT_NORMAL_PLAYER_INSTANCE", "mActivePlayerRecords", "Ljava/util/LinkedList;", "Ltv/danmaku/videoplayer/core/media/mediacenter/record/MediaPlayerRecord;", "mPlayerCache", "Ltv/danmaku/videoplayer/core/media/mediacenter/utils/LruCacheMap;", "Ltv/danmaku/videoplayer/core/media/mediacenter/MediaType;", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "mExclusivePlayerMap", "Ljava/util/HashMap;", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "Lkotlin/collections/HashMap;", "mIjkEventThread", "Ltv/danmaku/videoplayer/core/media/mediacenter/utils/IjkEventThread;", "startEventThread", "", "quitEventThread", "mPendingActions", "Ljava/lang/Runnable;", "isActionRunning", "", "mPendingActionExecRunnable", "obtainMediaPlayer", "context", "Landroid/content/Context;", "config", "Ltv/danmaku/videoplayer/core/media/mediacenter/config/MediaPlayerConfig;", "createNewPlayer", "tryFindCachePlayer", "registerPlayer", X86IjkRequest.POOL, "listener", "Ltv/danmaku/videoplayer/core/media/mediacenter/listener/IMediaPlayerLifeCycleListener;", "playerType", "Ltv/danmaku/videoplayer/core/media/mediacenter/record/PlayerType;", "activePlayer", "unregisterPlayer", "clearCache", "reuseMediaPlayer", "autoStartIjkService", "createRegisterRunnable", "record", "createActiveRunnable", "createUnregisterRunnable", "markPlayerAsExclusive", "removePlayerExclusiveMark", "checkMainThread", "execPendingActions", "needReleaseFirst", "findFirstPlayer", "getPlayerCount", "getSinglePlayerCount", "getExclusivePlayerCount", "getIjkEventThreadLooper", "Landroid/os/Looper;", "release", "mediacenter_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MediaCenter {
    private static final int MAX_COUNT_EXCLUSIVE_PLAYER_INSTANCE = 1;
    private static final int MAX_COUNT_NORMAL_PLAYER_INSTANCE = 1;
    private static final int MAX_COUNT_PLAYER_INSTANCE = 4;
    private static final String TAG = "MediaCenter";
    private static boolean isActionRunning;
    private static IjkEventThread mIjkEventThread;
    private static Runnable mPendingActionExecRunnable;
    private static LinkedList<Runnable> mPendingActions;
    public static final MediaCenter INSTANCE = new MediaCenter();
    private static LinkedList<MediaPlayerRecord> mActivePlayerRecords = new LinkedList<>();
    private static final LruCacheMap<MediaType, IjkMediaPlayer> mPlayerCache = new LruCacheMap<>(4);
    private static final HashMap<IMediaPlayer, MediaType> mExclusivePlayerMap = new HashMap<>();

    /* compiled from: MediaCenter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerType.values().length];
            try {
                iArr[PlayerType.Single.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PlayerType.Exclusive.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MediaCenter() {
    }

    static {
        mPlayerCache.setLruActionCallback(new LruActionCallback<IjkMediaPlayer>() { // from class: tv.danmaku.videoplayer.core.media.mediacenter.MediaCenter.1
            @Override // tv.danmaku.videoplayer.core.media.mediacenter.utils.LruActionCallback
            public void onValueRemoved(IjkMediaPlayer value) {
                Intrinsics.checkNotNullParameter(value, "value");
                BLog.i(MediaCenter.TAG, "onLruValueRemoved: old value= " + value);
                value.release();
            }
        });
        INSTANCE.startEventThread();
        mPendingActions = new LinkedList<>();
        mPendingActionExecRunnable = new Runnable() { // from class: tv.danmaku.videoplayer.core.media.mediacenter.MediaCenter$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                MediaCenter.mPendingActionExecRunnable$lambda$0();
            }
        };
    }

    private final void startEventThread() {
        if (mIjkEventThread == null) {
            mIjkEventThread = new IjkEventThread();
        }
        IjkEventThread ijkEventThread = mIjkEventThread;
        boolean z = false;
        if (ijkEventThread != null && ijkEventThread.isAlive()) {
            z = true;
        }
        if (!z) {
            try {
                IjkEventThread ijkEventThread2 = mIjkEventThread;
                if (ijkEventThread2 != null) {
                    ijkEventThread2.start();
                }
            } catch (Exception e) {
                BLog.e("new player thread e:" + e);
            }
        }
    }

    private final void quitEventThread() {
        IjkEventThread ijkEventThread = mIjkEventThread;
        if (ijkEventThread != null) {
            ijkEventThread.quit();
        }
        mIjkEventThread = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPendingActionExecRunnable$lambda$0() {
        while (mPendingActions.size() > 0) {
            LinkedList tmpList = new LinkedList(mPendingActions);
            while (tmpList.size() > 0) {
                ((Runnable) tmpList.removeFirst()).run();
            }
            mPendingActions.clear();
        }
        isActionRunning = false;
    }

    public final IjkMediaPlayer obtainMediaPlayer(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BLog.d(TAG, "obtainMediaPlayer: DEFAULT");
        return obtainMediaPlayer(context, new MediaPlayerConfig.Builder().forceCreate().build());
    }

    public final IjkMediaPlayer obtainMediaPlayer(Context context, MediaPlayerConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        boolean z = true;
        if (!reuseMediaPlayer()) {
            BLog.d(TAG, "abtest hit: key= ff_player_ijk_reuse");
            config.setForceCreate(true);
        }
        config.setStartPlayerService(autoStartIjkService());
        IjkMediaPlayer cachedPlayer = tryFindCachePlayer(config);
        if (config.getForceCreate()) {
            return createNewPlayer(context, config);
        }
        if (cachedPlayer == null || cachedPlayer.isReleased()) {
            z = false;
        }
        if (!z) {
            mPlayerCache.removeValue(cachedPlayer);
            return createNewPlayer(context, config);
        }
        BLog.i(TAG, "obtainMediaPlayer: find cache, type= " + config.getMediaType());
        if (config.getUseExternalRender()) {
            BiliRenderContext.init(context);
            cachedPlayer.enableExternalRender();
        } else {
            cachedPlayer.disableExternalRender();
        }
        return cachedPlayer;
    }

    private final IjkMediaPlayer createNewPlayer(Context context, MediaPlayerConfig config) {
        IjkMediaPlayer $this$createNewPlayer_u24lambda_u240 = MediaPlayerCreator.INSTANCE.createMediaPlayer(context, config);
        BLog.i(TAG, "obtainMediaPlayer: create new,force= " + config.getForceCreate() + ", type= " + config.getMediaType());
        if (mPlayerCache.isEmpty()) {
            HashMap<IMediaPlayer, MediaType> hashMap = mExclusivePlayerMap;
            if (hashMap == null || hashMap.isEmpty()) {
                INSTANCE.startEventThread();
            }
        }
        if (!config.getForceCreate()) {
            mPlayerCache.put(config.getMediaType(), $this$createNewPlayer_u24lambda_u240);
        }
        return $this$createNewPlayer_u24lambda_u240;
    }

    private final IjkMediaPlayer tryFindCachePlayer(MediaPlayerConfig config) {
        if (mPlayerCache.containsKey(config.getMediaType())) {
            return mPlayerCache.get(config.getMediaType());
        }
        return null;
    }

    public final void registerPlayer(IMediaPlayer player, IMediaPlayerLifeCycleListener listener) {
        Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
        Intrinsics.checkNotNullParameter(listener, "listener");
        registerPlayer(player, listener, PlayerType.Single);
    }

    public final void registerPlayer(IMediaPlayer player, IMediaPlayerLifeCycleListener listener, PlayerType playerType) {
        Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(playerType, "playerType");
        BLog.i(TAG, "registerPlayer: player=" + player);
        checkMainThread();
        MediaPlayerRecord record = new MediaPlayerRecord(player, listener, playerType);
        if (mActivePlayerRecords.contains(record)) {
            return;
        }
        mPendingActions.add(createRegisterRunnable(record, player));
        execPendingActions();
    }

    public final void activePlayer(IMediaPlayer player, IMediaPlayerLifeCycleListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        BLog.d(TAG, "activePlayer: player=" + player);
        checkMainThread();
        mPendingActions.add(createActiveRunnable(player, listener));
        execPendingActions();
    }

    public final void unregisterPlayer(IMediaPlayer player, IMediaPlayerLifeCycleListener listener) {
        Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
        unregisterPlayer(player, listener, false);
    }

    public final void unregisterPlayer(IMediaPlayer player, IMediaPlayerLifeCycleListener listener, boolean clearCache) {
        Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
        BLog.i(TAG, "unregisterPlayer: player=" + player);
        checkMainThread();
        mPendingActions.add(createUnregisterRunnable(player, listener, clearCache));
        execPendingActions();
    }

    public final boolean reuseMediaPlayer() {
        return ConfigManager.Companion.isHitFF("ff_player_ijk_reuse");
    }

    private final boolean autoStartIjkService() {
        return ConfigManager.Companion.ab2().getWithDefault("ff_player_auto_start_service", false);
    }

    private final Runnable createRegisterRunnable(final MediaPlayerRecord record, final IMediaPlayer player) {
        return new Runnable() { // from class: tv.danmaku.videoplayer.core.media.mediacenter.MediaCenter$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                MediaCenter.createRegisterRunnable$lambda$0(MediaPlayerRecord.this, player);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createRegisterRunnable$lambda$0(MediaPlayerRecord $record, IMediaPlayer $player) {
        MediaPlayerRecord first;
        if (INSTANCE.needReleaseFirst($record.getPlayerType()) && (first = INSTANCE.findFirstPlayer($record.getPlayerType())) != null) {
            PlayerType playerType = $record.getPlayerType();
            BLog.i(TAG, "[" + playerType + "]shut other player:" + first.getPlayerType() + ", " + first.getPlayer());
            IMediaPlayerLifeCycleListener listener = first.getListener();
            if (listener != null) {
                listener.onMediaPlayerWillResignActive(first.getPlayer());
            }
            IMediaPlayerLifeCycleListener listener2 = first.getListener();
            if (listener2 != null) {
                listener2.onMediaPlayerWillShutDownByOthers(first.getPlayer());
            }
            mActivePlayerRecords.remove(first);
        }
        mActivePlayerRecords.add($record);
        IMediaPlayerLifeCycleListener listener3 = $record.getListener();
        if (listener3 != null) {
            listener3.onMediaPlayerDidPrepareToPlay($player);
        }
    }

    private final Runnable createActiveRunnable(final IMediaPlayer player, final IMediaPlayerLifeCycleListener listener) {
        return new Runnable() { // from class: tv.danmaku.videoplayer.core.media.mediacenter.MediaCenter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MediaCenter.createActiveRunnable$lambda$0(IMediaPlayer.this, listener);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createActiveRunnable$lambda$0(IMediaPlayer $player, IMediaPlayerLifeCycleListener $listener) {
        Iterable $this$forEach$iv = mActivePlayerRecords;
        for (Object element$iv : $this$forEach$iv) {
            MediaPlayerRecord it = (MediaPlayerRecord) element$iv;
            if (Intrinsics.areEqual(it.getPlayer(), $player) && Intrinsics.areEqual(it.getListener(), $listener)) {
                IMediaPlayerLifeCycleListener listener = it.getListener();
                if (listener != null) {
                    listener.onMediaPlayerDidBecomeActive(it.getPlayer());
                }
            } else {
                IMediaPlayerLifeCycleListener listener2 = it.getListener();
                if (listener2 != null) {
                    listener2.onMediaPlayerWillResignActive(it.getPlayer());
                }
            }
        }
    }

    private final Runnable createUnregisterRunnable(final IMediaPlayer player, final IMediaPlayerLifeCycleListener listener, final boolean clearCache) {
        return new Runnable() { // from class: tv.danmaku.videoplayer.core.media.mediacenter.MediaCenter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MediaCenter.createUnregisterRunnable$lambda$0(clearCache, player, listener);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createUnregisterRunnable$lambda$0(boolean $clearCache, IMediaPlayer $player, IMediaPlayerLifeCycleListener $listener) {
        Object registeredPlayer = null;
        Iterable $this$forEach$iv = mActivePlayerRecords;
        for (Object element$iv : $this$forEach$iv) {
            MediaPlayerRecord it = (MediaPlayerRecord) element$iv;
            if (Intrinsics.areEqual(it.getPlayer(), $player) && Intrinsics.areEqual(it.getListener(), $listener)) {
                registeredPlayer = it;
            }
        }
        if (registeredPlayer == null) {
            return;
        }
        mActivePlayerRecords.remove(registeredPlayer);
        if ($clearCache && ($player instanceof IjkMediaPlayer)) {
            mPlayerCache.removeValue($player);
        }
        LinkedList<MediaPlayerRecord> linkedList = mActivePlayerRecords;
        if (linkedList == null || linkedList.isEmpty()) {
            INSTANCE.release();
        }
        BLog.i(TAG, "unregisterPlayer: player=" + $player + " :" + mPlayerCache.size());
    }

    public final void markPlayerAsExclusive(final IMediaPlayer player) {
        Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
        BLog.i(TAG, "markPlayerAsExclusive: player=" + player);
        checkMainThread();
        mPendingActions.add(new Runnable() { // from class: tv.danmaku.videoplayer.core.media.mediacenter.MediaCenter$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                MediaCenter.markPlayerAsExclusive$lambda$0(IMediaPlayer.this);
            }
        });
        execPendingActions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void markPlayerAsExclusive$lambda$0(IMediaPlayer $player) {
        Iterable $this$forEach$iv = mActivePlayerRecords;
        for (Object element$iv : $this$forEach$iv) {
            MediaPlayerRecord it = (MediaPlayerRecord) element$iv;
            if (Intrinsics.areEqual(it.getPlayer(), $player)) {
                if (it.getPlayer() instanceof IjkMediaPlayer) {
                    MediaType mediaType = (MediaType) mPlayerCache.removeValue(it.getPlayer());
                    mExclusivePlayerMap.put(it.getPlayer(), mediaType);
                }
                it.setPlayerType(PlayerType.Exclusive);
                return;
            }
        }
    }

    public final void removePlayerExclusiveMark(final IMediaPlayer player, final PlayerType playerType) {
        Intrinsics.checkNotNullParameter(player, X86IjkRequest.POOL);
        Intrinsics.checkNotNullParameter(playerType, "playerType");
        BLog.i(TAG, "removePlayerExclusiveMark: player=" + player);
        checkMainThread();
        mPendingActions.add(new Runnable() { // from class: tv.danmaku.videoplayer.core.media.mediacenter.MediaCenter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MediaCenter.removePlayerExclusiveMark$lambda$0(IMediaPlayer.this, playerType);
            }
        });
        execPendingActions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void removePlayerExclusiveMark$lambda$0(IMediaPlayer $player, PlayerType $playerType) {
        Iterable $this$forEach$iv = mActivePlayerRecords;
        for (Object element$iv : $this$forEach$iv) {
            MediaPlayerRecord it = (MediaPlayerRecord) element$iv;
            if (Intrinsics.areEqual(it.getPlayer(), $player)) {
                if (it.getPlayer() instanceof IjkMediaPlayer) {
                    MediaType mediaType = mExclusivePlayerMap.get(it.getPlayer());
                    if (mediaType == null) {
                        mediaType = MediaType.IJK;
                    }
                    mPlayerCache.put(mediaType, it.getPlayer());
                    mExclusivePlayerMap.remove(it.getPlayer());
                }
                it.setPlayerType($playerType);
                return;
            }
        }
    }

    private final void checkMainThread() {
        if (BuildConfig.DEBUG && !Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalArgumentException("register player must be called in main thread");
        }
    }

    private final void execPendingActions() {
        if (isActionRunning) {
            return;
        }
        isActionRunning = true;
        mPendingActionExecRunnable.run();
    }

    private final boolean needReleaseFirst(PlayerType playerType) {
        switch (WhenMappings.$EnumSwitchMapping$0[playerType.ordinal()]) {
            case 1:
                return getSinglePlayerCount() >= 1;
            case 2:
                return getExclusivePlayerCount() >= 1;
            default:
                return getPlayerCount() >= 4;
        }
    }

    private final MediaPlayerRecord findFirstPlayer(PlayerType playerType) {
        Iterable $this$forEach$iv = mActivePlayerRecords;
        for (Object element$iv : $this$forEach$iv) {
            MediaPlayerRecord it = (MediaPlayerRecord) element$iv;
            if (it.getPlayerType() == playerType) {
                return it;
            }
        }
        return null;
    }

    private final int getPlayerCount() {
        return mActivePlayerRecords.size();
    }

    private final int getSinglePlayerCount() {
        int count = 0;
        Iterable $this$forEach$iv = mActivePlayerRecords;
        for (Object element$iv : $this$forEach$iv) {
            MediaPlayerRecord it = (MediaPlayerRecord) element$iv;
            if (it.getPlayerType() == PlayerType.Single) {
                count++;
            }
        }
        return count;
    }

    private final int getExclusivePlayerCount() {
        Iterable $this$count$iv = mActivePlayerRecords;
        if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
            return 0;
        }
        int count$iv = 0;
        for (Object element$iv : $this$count$iv) {
            MediaPlayerRecord it = (MediaPlayerRecord) element$iv;
            if ((it.getPlayerType() == PlayerType.Exclusive) && (count$iv = count$iv + 1) < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return count$iv;
    }

    public final Looper getIjkEventThreadLooper() {
        IjkEventThread ijkEventThread = mIjkEventThread;
        if (ijkEventThread != null) {
            return ijkEventThread.getLooper();
        }
        return null;
    }

    public final void release() {
        BLog.i(TAG, "release");
        quitEventThread();
        mActivePlayerRecords.clear();
        mPendingActions.clear();
        mPlayerCache.clear();
        Iterable keySet = mExclusivePlayerMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
        Iterable $this$forEach$iv = keySet;
        for (Object element$iv : $this$forEach$iv) {
            IMediaPlayer it = (IMediaPlayer) element$iv;
            BLog.i(TAG, "release exclusive player: " + it + ", type= " + mExclusivePlayerMap.get(it));
            it.release();
        }
        mExclusivePlayerMap.clear();
    }
}