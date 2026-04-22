package tv.danmaku.ijk.media.player;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.IPlayerManager;

public class IjkPlayerManager {
    private static final String TAG = IjkPlayerManager.class.getName();
    private final List<IPlayerManager.OnPlayerActivityChangeListener> listeners = new CopyOnWriteArrayList();
    private final Set<WeakReference<IjkMediaPlayer>> mPlayers = Collections.newSetFromMap(new ConcurrentHashMap());
    private boolean mIsActive = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Holder {
        static final IjkPlayerManager INSTANCE = new IjkPlayerManager();

        private Holder() {
        }
    }

    public static IjkPlayerManager getInstance() {
        return Holder.INSTANCE;
    }

    public void registerListener(IPlayerManager.OnPlayerActivityChangeListener listener) {
        if (!this.listeners.contains(listener)) {
            this.listeners.add(listener);
            BLog.i(TAG, "registerListener:" + listener + "listenersSize:" + this.listeners.size());
        }
    }

    public void unregisterListener(IPlayerManager.OnPlayerActivityChangeListener listener) {
        this.listeners.remove(listener);
        BLog.i(TAG, "unregisterListener:" + listener + "listenersSize:" + this.listeners.size());
    }

    public boolean hasActivePlayer() {
        if (AbrParamsInterface.IsEnableJavaExpOn2()) {
            synchronized (this) {
                for (WeakReference<IjkMediaPlayer> ref : this.mPlayers) {
                    IjkMediaPlayer player = ref.get();
                    if (player != null && player.mIsActivity) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerPlayer(IjkMediaPlayer player) {
        if (!AbrParamsInterface.IsEnableJavaExpOn2()) {
            return;
        }
        synchronized (this) {
            this.mPlayers.add(new WeakReference<>(player));
            BLog.i(TAG, "registerPlayer:" + player + "playersSize:" + this.mPlayers.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unregisterPlayer(IjkMediaPlayer player) {
        if (!AbrParamsInterface.IsEnableJavaExpOn2()) {
            return;
        }
        synchronized (this) {
            BLog.i(TAG, "unregisterPlayer:" + player + "playersSizeBeforeUnregister:" + this.mPlayers.size());
            Iterator<WeakReference<IjkMediaPlayer>> iterator = this.mPlayers.iterator();
            while (iterator.hasNext()) {
                IjkMediaPlayer p = iterator.next().get();
                if (p == null || p == player) {
                    iterator.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updatePlayerActivity() {
        boolean isActivity;
        if (AbrParamsInterface.IsEnableJavaExpOn2() && !this.listeners.isEmpty() && this.mIsActive != (isActivity = hasActivePlayer())) {
            this.mIsActive = isActivity;
            for (IPlayerManager.OnPlayerActivityChangeListener listener : this.listeners) {
                try {
                    listener.onPlayerActivityChange(isActivity);
                } catch (Exception e) {
                }
            }
        }
    }
}