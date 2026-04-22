package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.compose.material3.MenuKt;
import androidx.core.app.BundleCompat;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import androidx.media.session.MediaButtonReceiver;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import com.bilibili.infra.base.aop.PendingIntentCreateHook;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MediaSessionCompat {
    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    public static final String ACTION_ARGUMENT_PLAYBACK_SPEED = "android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED";
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    public static final String ACTION_SET_PLAYBACK_SPEED = "android.support.v4.media.session.action.SET_PLAYBACK_SPEED";
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    private static final String DATA_CALLING_PACKAGE = "data_calling_pkg";
    private static final String DATA_CALLING_PID = "data_calling_pid";
    private static final String DATA_CALLING_UID = "data_calling_uid";
    private static final String DATA_EXTRAS = "data_extras";
    @Deprecated
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    @Deprecated
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    public static final String KEY_SESSION2_TOKEN = "android.support.v4.media.session.SESSION_TOKEN2";
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    private static final int MAX_BITMAP_SIZE_IN_DP = 320;
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    static final String TAG = "MediaSessionCompat";
    static int sMaxBitmapSize;
    private final ArrayList<OnActiveChangeListener> mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public interface MediaSessionImpl {
        Callback getCallback();

        String getCallingPackage();

        MediaSessionManager.RemoteUserInfo getCurrentControllerInfo();

        Object getMediaSession();

        PlaybackStateCompat getPlaybackState();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String str, Bundle bundle);

        void setActive(boolean z);

        void setCallback(Callback callback, Handler handler);

        void setCaptioningEnabled(boolean z);

        void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo);

        void setExtras(Bundle bundle);

        void setFlags(int i);

        void setMediaButtonReceiver(PendingIntent pendingIntent);

        void setMetadata(MediaMetadataCompat mediaMetadataCompat);

        void setPlaybackState(PlaybackStateCompat playbackStateCompat);

        void setPlaybackToLocal(int i);

        void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat);

        void setQueue(List<QueueItem> list);

        void setQueueTitle(CharSequence charSequence);

        void setRatingType(int i);

        void setRegistrationCallback(RegistrationCallback registrationCallback, Handler handler);

        void setRepeatMode(int i);

        void setSessionActivity(PendingIntent pendingIntent);

        void setShuffleMode(int i);
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public interface RegistrationCallback {
        void onCallbackRegistered(int i, int i2);

        void onCallbackUnregistered(int i, int i2);
    }

    private static PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(Context context, int requestCode, Intent intent, int flags) {
        PendingIntentCreateHook.setPackageIfAbsent(context, intent, flags);
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                return PendingIntent.getBroadcast(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
            } catch (IllegalArgumentException e) {
                return PendingIntent.getBroadcast(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(33554432 | flags).intValue());
            }
        }
        return PendingIntent.getBroadcast(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
    }

    public MediaSessionCompat(Context context, String tag) {
        this(context, tag, null, null);
    }

    public MediaSessionCompat(Context context, String tag, ComponentName mbrComponent, PendingIntent mbrIntent) {
        this(context, tag, mbrComponent, mbrIntent, null);
    }

    public MediaSessionCompat(Context context, String tag, ComponentName mbrComponent, PendingIntent mbrIntent, Bundle sessionInfo) {
        this(context, tag, mbrComponent, mbrIntent, sessionInfo, null);
    }

    public MediaSessionCompat(Context context, String tag, ComponentName mbrComponent, PendingIntent mbrIntent, Bundle sessionInfo, VersionedParcelable session2Token) {
        this.mActiveListeners = new ArrayList<>();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if (TextUtils.isEmpty(tag)) {
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        if (mbrComponent == null && (mbrComponent = MediaButtonReceiver.getMediaButtonReceiverComponent(context)) == null) {
            Log.w(TAG, "Couldn't find a unique registered media button receiver in the given context.");
        }
        if (mbrComponent != null && mbrIntent == null) {
            Intent mediaButtonIntent = new Intent("android.intent.action.MEDIA_BUTTON");
            mediaButtonIntent.setComponent(mbrComponent);
            mbrIntent = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(context, 0, mediaButtonIntent, Build.VERSION.SDK_INT >= 31 ? 33554432 : 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.mImpl = new MediaSessionImplApi29(context, tag, session2Token, sessionInfo);
        } else if (Build.VERSION.SDK_INT >= 28) {
            this.mImpl = new MediaSessionImplApi28(context, tag, session2Token, sessionInfo);
        } else {
            this.mImpl = new MediaSessionImplApi22(context, tag, session2Token, sessionInfo);
        }
        Handler handler = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        setCallback(new Callback() { // from class: android.support.v4.media.session.MediaSessionCompat.1
        }, handler);
        this.mImpl.setMediaButtonReceiver(mbrIntent);
        this.mController = new MediaControllerCompat(context, this);
        if (sMaxBitmapSize == 0) {
            sMaxBitmapSize = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
        }
    }

    private MediaSessionCompat(Context context, MediaSessionImpl impl) {
        this.mActiveListeners = new ArrayList<>();
        this.mImpl = impl;
        this.mController = new MediaControllerCompat(context, this);
    }

    public void setCallback(Callback callback) {
        setCallback(callback, null);
    }

    public void setCallback(Callback callback, Handler handler) {
        if (callback == null) {
            this.mImpl.setCallback(null, null);
        } else {
            this.mImpl.setCallback(callback, handler != null ? handler : new Handler());
        }
    }

    public void setRegistrationCallback(RegistrationCallback callback, Handler handler) {
        this.mImpl.setRegistrationCallback(callback, handler);
    }

    public void setSessionActivity(PendingIntent pi) {
        this.mImpl.setSessionActivity(pi);
    }

    public void setMediaButtonReceiver(PendingIntent mbr) {
        this.mImpl.setMediaButtonReceiver(mbr);
    }

    public void setFlags(int flags) {
        this.mImpl.setFlags(flags);
    }

    public void setPlaybackToLocal(int stream) {
        this.mImpl.setPlaybackToLocal(stream);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProvider) {
        if (volumeProvider == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
        this.mImpl.setPlaybackToRemote(volumeProvider);
    }

    public void setActive(boolean active) {
        this.mImpl.setActive(active);
        Iterator<OnActiveChangeListener> it = this.mActiveListeners.iterator();
        while (it.hasNext()) {
            OnActiveChangeListener listener = it.next();
            listener.onActiveChanged();
        }
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void sendSessionEvent(String event, Bundle extras) {
        if (TextUtils.isEmpty(event)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        this.mImpl.sendSessionEvent(event, extras);
    }

    public void release() {
        this.mImpl.release();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    public void setPlaybackState(PlaybackStateCompat state) {
        this.mImpl.setPlaybackState(state);
    }

    public void setMetadata(MediaMetadataCompat metadata) {
        this.mImpl.setMetadata(metadata);
    }

    public void setQueue(List<QueueItem> queue) {
        if (queue != null) {
            Set<Long> set = new HashSet<>();
            for (QueueItem item : queue) {
                if (item == null) {
                    throw new IllegalArgumentException("queue shouldn't have null items");
                }
                if (set.contains(Long.valueOf(item.getQueueId()))) {
                    Log.e(TAG, "Found duplicate queue id: " + item.getQueueId(), new IllegalArgumentException("id of each queue item should be unique"));
                }
                set.add(Long.valueOf(item.getQueueId()));
            }
        }
        this.mImpl.setQueue(queue);
    }

    public void setQueueTitle(CharSequence title) {
        this.mImpl.setQueueTitle(title);
    }

    public void setRatingType(int type) {
        this.mImpl.setRatingType(type);
    }

    public void setCaptioningEnabled(boolean enabled) {
        this.mImpl.setCaptioningEnabled(enabled);
    }

    public void setRepeatMode(int repeatMode) {
        this.mImpl.setRepeatMode(repeatMode);
    }

    public void setShuffleMode(int shuffleMode) {
        this.mImpl.setShuffleMode(shuffleMode);
    }

    public void setExtras(Bundle extras) {
        this.mImpl.setExtras(extras);
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
        return this.mImpl.getCurrentControllerInfo();
    }

    public String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public void addOnActiveChangeListener(OnActiveChangeListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.mActiveListeners.add(listener);
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.mActiveListeners.remove(listener);
    }

    public static MediaSessionCompat fromMediaSession(Context context, Object mediaSession) {
        MediaSessionImpl impl;
        if (context == null || mediaSession == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            impl = new MediaSessionImplApi29(mediaSession);
        } else if (Build.VERSION.SDK_INT >= 28) {
            impl = new MediaSessionImplApi28(mediaSession);
        } else {
            impl = new MediaSessionImplApi21(mediaSession);
        }
        return new MediaSessionCompat(context, impl);
    }

    public static void ensureClassLoader(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static Bundle unparcelWithClassLoader(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ensureClassLoader(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException e) {
            Log.e(TAG, "Could not unparcel the data.");
            return null;
        }
    }

    static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat state, MediaMetadataCompat metadata) {
        long duration;
        long position;
        if (state == null || state.getPosition() == -1) {
            return state;
        }
        if (state.getState() == 3 || state.getState() == 4 || state.getState() == 5) {
            long updateTime = state.getLastPositionUpdateTime();
            if (updateTime > 0) {
                long currentTime = SystemClock.elapsedRealtime();
                long position2 = (state.getPlaybackSpeed() * ((float) (currentTime - updateTime))) + state.getPosition();
                if (metadata != null && metadata.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
                    long duration2 = metadata.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
                    duration = duration2;
                } else {
                    duration = -1;
                }
                if (duration >= 0 && position2 > duration) {
                    position = duration;
                } else if (position2 >= 0) {
                    position = position2;
                } else {
                    position = 0;
                }
                return new PlaybackStateCompat.Builder(state).setState(state.getState(), position, state.getPlaybackSpeed(), currentTime).build();
            }
        }
        return state;
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static abstract class Callback {
        CallbackHandler mCallbackHandler;
        private boolean mMediaPlayPausePendingOnHandler;
        final Object mLock = new Object();
        final MediaSession.Callback mCallbackFwk = new MediaSessionCallbackApi21();
        WeakReference<MediaSessionImpl> mSessionImpl = new WeakReference<>(null);

        void setSessionImpl(MediaSessionImpl impl, Handler handler) {
            synchronized (this.mLock) {
                this.mSessionImpl = new WeakReference<>(impl);
                CallbackHandler callbackHandler = null;
                if (this.mCallbackHandler != null) {
                    this.mCallbackHandler.removeCallbacksAndMessages(null);
                }
                if (impl != null && handler != null) {
                    callbackHandler = new CallbackHandler(handler.getLooper());
                }
                this.mCallbackHandler = callbackHandler;
            }
        }

        public void onCommand(String command, Bundle extras, ResultReceiver cb) {
        }

        public boolean onMediaButtonEvent(Intent mediaButtonEvent) {
            MediaSessionImpl impl;
            Handler callbackHandler;
            KeyEvent keyEvent;
            if (Build.VERSION.SDK_INT >= 27) {
                return false;
            }
            synchronized (this.mLock) {
                impl = this.mSessionImpl.get();
                callbackHandler = this.mCallbackHandler;
            }
            if (impl == null || callbackHandler == null || (keyEvent = (KeyEvent) mediaButtonEvent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            MediaSessionManager.RemoteUserInfo remoteUserInfo = impl.getCurrentControllerInfo();
            int keyCode = keyEvent.getKeyCode();
            switch (keyCode) {
                case 79:
                case 85:
                    if (keyEvent.getRepeatCount() == 0) {
                        if (this.mMediaPlayPausePendingOnHandler) {
                            callbackHandler.removeMessages(1);
                            this.mMediaPlayPausePendingOnHandler = false;
                            PlaybackStateCompat state = impl.getPlaybackState();
                            long validActions = state == null ? 0L : state.getActions();
                            if ((32 & validActions) != 0) {
                                onSkipToNext();
                            }
                        } else {
                            this.mMediaPlayPausePendingOnHandler = true;
                            callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(1, remoteUserInfo), ViewConfiguration.getDoubleTapTimeout());
                        }
                    } else {
                        handleMediaPlayPauseIfPendingOnHandler(impl, callbackHandler);
                    }
                    return true;
                default:
                    handleMediaPlayPauseIfPendingOnHandler(impl, callbackHandler);
                    return false;
            }
        }

        void handleMediaPlayPauseIfPendingOnHandler(MediaSessionImpl impl, Handler callbackHandler) {
            boolean isPlaying;
            boolean canPlay;
            if (!this.mMediaPlayPausePendingOnHandler) {
                return;
            }
            boolean canPause = false;
            this.mMediaPlayPausePendingOnHandler = false;
            callbackHandler.removeMessages(1);
            PlaybackStateCompat state = impl.getPlaybackState();
            long validActions = state == null ? 0L : state.getActions();
            if (state == null || state.getState() != 3) {
                isPlaying = false;
            } else {
                isPlaying = true;
            }
            if ((516 & validActions) == 0) {
                canPlay = false;
            } else {
                canPlay = true;
            }
            if ((514 & validActions) != 0) {
                canPause = true;
            }
            if (isPlaying && canPause) {
                onPause();
            } else if (!isPlaying && canPlay) {
                onPlay();
            }
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String mediaId, Bundle extras) {
        }

        public void onPrepareFromSearch(String query, Bundle extras) {
        }

        public void onPrepareFromUri(Uri uri, Bundle extras) {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String mediaId, Bundle extras) {
        }

        public void onPlayFromSearch(String query, Bundle extras) {
        }

        public void onPlayFromUri(Uri uri, Bundle extras) {
        }

        public void onSkipToQueueItem(long id) {
        }

        public void onPause() {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onFastForward() {
        }

        public void onRewind() {
        }

        public void onStop() {
        }

        public void onSeekTo(long pos) {
        }

        public void onSetRating(RatingCompat rating) {
        }

        public void onSetRating(RatingCompat rating, Bundle extras) {
        }

        public void onSetPlaybackSpeed(float speed) {
        }

        public void onSetCaptioningEnabled(boolean enabled) {
        }

        public void onSetRepeatMode(int repeatMode) {
        }

        public void onSetShuffleMode(int shuffleMode) {
        }

        public void onCustomAction(String action, Bundle extras) {
        }

        public void onAddQueueItem(MediaDescriptionCompat description) {
        }

        public void onAddQueueItem(MediaDescriptionCompat description, int index) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat description) {
        }

        @Deprecated
        public void onRemoveQueueItemAt(int index) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
        public class CallbackHandler extends Handler {
            private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;

            CallbackHandler(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                MediaSessionImpl impl;
                Handler callbackHandler;
                if (msg.what == 1) {
                    synchronized (Callback.this.mLock) {
                        impl = Callback.this.mSessionImpl.get();
                        callbackHandler = Callback.this.mCallbackHandler;
                    }
                    if (impl == null || Callback.this != impl.getCallback() || callbackHandler == null) {
                        return;
                    }
                    MediaSessionManager.RemoteUserInfo info = (MediaSessionManager.RemoteUserInfo) msg.obj;
                    impl.setCurrentControllerInfo(info);
                    Callback.this.handleMediaPlayPauseIfPendingOnHandler(impl, callbackHandler);
                    impl.setCurrentControllerInfo(null);
                }
            }
        }

        /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
        private class MediaSessionCallbackApi21 extends MediaSession.Callback {
            MediaSessionCallbackApi21() {
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCommand(String command, Bundle extras, ResultReceiver cb) {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(extras);
                setCurrentControllerInfo(sessionImpl);
                try {
                    QueueItem item = null;
                    IBinder asBinder = null;
                    item = null;
                    if (command.equals(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER)) {
                        Bundle result = new Bundle();
                        Token token = sessionImpl.getSessionToken();
                        IMediaSession extraBinder = token.getExtraBinder();
                        if (extraBinder != null) {
                            asBinder = extraBinder.asBinder();
                        }
                        BundleCompat.putBinder(result, MediaSessionCompat.KEY_EXTRA_BINDER, asBinder);
                        ParcelUtils.putVersionedParcelable(result, MediaSessionCompat.KEY_SESSION2_TOKEN, token.getSession2Token());
                        cb.send(0, result);
                    } else if (command.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM)) {
                        Callback.this.onAddQueueItem((MediaDescriptionCompat) extras.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));
                    } else if (command.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT)) {
                        Callback.this.onAddQueueItem((MediaDescriptionCompat) extras.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION), extras.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX));
                    } else if (command.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM)) {
                        Callback.this.onRemoveQueueItem((MediaDescriptionCompat) extras.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));
                    } else if (command.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM_AT)) {
                        if (sessionImpl.mQueue != null) {
                            int index = extras.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, -1);
                            if (index >= 0 && index < sessionImpl.mQueue.size()) {
                                item = sessionImpl.mQueue.get(index);
                            }
                            if (item != null) {
                                Callback.this.onRemoveQueueItem(item.getDescription());
                            }
                        }
                    } else {
                        Callback.this.onCommand(command, extras, cb);
                    }
                } catch (BadParcelableException e) {
                    Log.e(MediaSessionCompat.TAG, "Could not unparcel the extra data.");
                }
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public boolean onMediaButtonEvent(Intent mediaButtonIntent) {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return false;
                }
                setCurrentControllerInfo(sessionImpl);
                boolean result = Callback.this.onMediaButtonEvent(mediaButtonIntent);
                clearCurrentControllerInfo(sessionImpl);
                return result || super.onMediaButtonEvent(mediaButtonIntent);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlay() {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onPlay();
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromMediaId(String mediaId, Bundle extras) {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(extras);
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onPlayFromMediaId(mediaId, extras);
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromSearch(String search, Bundle extras) {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(extras);
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onPlayFromSearch(search, extras);
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromUri(Uri uri, Bundle extras) {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(extras);
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onPlayFromUri(uri, extras);
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToQueueItem(long id) {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onSkipToQueueItem(id);
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPause() {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onPause();
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToNext() {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onSkipToNext();
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToPrevious() {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onSkipToPrevious();
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onFastForward() {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onFastForward();
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onRewind() {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onRewind();
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onStop() {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onStop();
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSeekTo(long pos) {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onSeekTo(pos);
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetRating(Rating ratingFwk) {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onSetRating(RatingCompat.fromRating(ratingFwk));
                clearCurrentControllerInfo(sessionImpl);
            }

            public void onSetRating(Rating ratingFwk, Bundle extras) {
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCustomAction(String action, Bundle extras) {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(extras);
                setCurrentControllerInfo(sessionImpl);
                try {
                    if (action.equals(MediaSessionCompat.ACTION_PLAY_FROM_URI)) {
                        Uri uri = (Uri) extras.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI);
                        Bundle bundle = extras.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                        MediaSessionCompat.ensureClassLoader(bundle);
                        Callback.this.onPlayFromUri(uri, bundle);
                    } else if (action.equals(MediaSessionCompat.ACTION_PREPARE)) {
                        Callback.this.onPrepare();
                    } else if (action.equals(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
                        String mediaId = extras.getString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID);
                        Bundle bundle2 = extras.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                        MediaSessionCompat.ensureClassLoader(bundle2);
                        Callback.this.onPrepareFromMediaId(mediaId, bundle2);
                    } else if (action.equals(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH)) {
                        String query = extras.getString(MediaSessionCompat.ACTION_ARGUMENT_QUERY);
                        Bundle bundle3 = extras.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                        MediaSessionCompat.ensureClassLoader(bundle3);
                        Callback.this.onPrepareFromSearch(query, bundle3);
                    } else if (action.equals(MediaSessionCompat.ACTION_PREPARE_FROM_URI)) {
                        Uri uri2 = (Uri) extras.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI);
                        Bundle bundle4 = extras.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                        MediaSessionCompat.ensureClassLoader(bundle4);
                        Callback.this.onPrepareFromUri(uri2, bundle4);
                    } else if (action.equals(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                        boolean enabled = extras.getBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED);
                        Callback.this.onSetCaptioningEnabled(enabled);
                    } else if (action.equals(MediaSessionCompat.ACTION_SET_REPEAT_MODE)) {
                        int repeatMode = extras.getInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE);
                        Callback.this.onSetRepeatMode(repeatMode);
                    } else if (action.equals(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE)) {
                        int shuffleMode = extras.getInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE);
                        Callback.this.onSetShuffleMode(shuffleMode);
                    } else if (action.equals(MediaSessionCompat.ACTION_SET_RATING)) {
                        RatingCompat rating = (RatingCompat) extras.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING);
                        Bundle bundle5 = extras.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                        MediaSessionCompat.ensureClassLoader(bundle5);
                        Callback.this.onSetRating(rating, bundle5);
                    } else if (action.equals(MediaSessionCompat.ACTION_SET_PLAYBACK_SPEED)) {
                        float speed = extras.getFloat(MediaSessionCompat.ACTION_ARGUMENT_PLAYBACK_SPEED, 1.0f);
                        Callback.this.onSetPlaybackSpeed(speed);
                    } else {
                        Callback.this.onCustomAction(action, extras);
                    }
                } catch (BadParcelableException e) {
                    Log.e(MediaSessionCompat.TAG, "Could not unparcel the data.");
                }
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepare() {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onPrepare();
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromMediaId(String mediaId, Bundle extras) {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(extras);
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onPrepareFromMediaId(mediaId, extras);
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromSearch(String query, Bundle extras) {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(extras);
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onPrepareFromSearch(query, extras);
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromUri(Uri uri, Bundle extras) {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(extras);
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onPrepareFromUri(uri, extras);
                clearCurrentControllerInfo(sessionImpl);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetPlaybackSpeed(float speed) {
                MediaSessionImplApi21 sessionImpl = getSessionImplIfCallbackIsSet();
                if (sessionImpl == null) {
                    return;
                }
                setCurrentControllerInfo(sessionImpl);
                Callback.this.onSetPlaybackSpeed(speed);
                clearCurrentControllerInfo(sessionImpl);
            }

            private void setCurrentControllerInfo(MediaSessionImpl sessionImpl) {
                if (Build.VERSION.SDK_INT >= 28) {
                    return;
                }
                String packageName = sessionImpl.getCallingPackage();
                if (TextUtils.isEmpty(packageName)) {
                    packageName = "android.media.session.MediaController";
                }
                sessionImpl.setCurrentControllerInfo(new MediaSessionManager.RemoteUserInfo(packageName, -1, -1));
            }

            private void clearCurrentControllerInfo(MediaSessionImpl sessionImpl) {
                sessionImpl.setCurrentControllerInfo(null);
            }

            private MediaSessionImplApi21 getSessionImplIfCallbackIsSet() {
                MediaSessionImplApi21 sessionImpl;
                synchronized (Callback.this.mLock) {
                    sessionImpl = (MediaSessionImplApi21) Callback.this.mSessionImpl.get();
                }
                if (sessionImpl == null || Callback.this != sessionImpl.getCallback()) {
                    return null;
                }
                return sessionImpl;
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() { // from class: android.support.v4.media.session.MediaSessionCompat.Token.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Token createFromParcel(Parcel in) {
                Object inner = in.readParcelable(null);
                return new Token(inner);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Token[] newArray(int size) {
                return new Token[size];
            }
        };
        private IMediaSession mExtraBinder;
        private final Object mInner;
        private final Object mLock;
        private VersionedParcelable mSession2Token;

        Token(Object inner) {
            this(inner, null, null);
        }

        Token(Object inner, IMediaSession extraBinder) {
            this(inner, extraBinder, null);
        }

        Token(Object inner, IMediaSession extraBinder, VersionedParcelable session2Token) {
            this.mLock = new Object();
            this.mInner = inner;
            this.mExtraBinder = extraBinder;
            this.mSession2Token = session2Token;
        }

        public static Token fromToken(Object token) {
            return fromToken(token, null);
        }

        public static Token fromToken(Object token, IMediaSession extraBinder) {
            if (token != null) {
                if (!(token instanceof MediaSession.Token)) {
                    throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
                }
                return new Token(token, extraBinder);
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable((Parcelable) this.mInner, flags);
        }

        public int hashCode() {
            if (this.mInner == null) {
                return 0;
            }
            return this.mInner.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Token) {
                Token other = (Token) obj;
                if (this.mInner == null) {
                    return other.mInner == null;
                } else if (other.mInner == null) {
                    return false;
                } else {
                    return this.mInner.equals(other.mInner);
                }
            }
            return false;
        }

        public Object getToken() {
            return this.mInner;
        }

        public IMediaSession getExtraBinder() {
            IMediaSession iMediaSession;
            synchronized (this.mLock) {
                iMediaSession = this.mExtraBinder;
            }
            return iMediaSession;
        }

        public void setExtraBinder(IMediaSession extraBinder) {
            synchronized (this.mLock) {
                this.mExtraBinder = extraBinder;
            }
        }

        public VersionedParcelable getSession2Token() {
            VersionedParcelable versionedParcelable;
            synchronized (this.mLock) {
                versionedParcelable = this.mSession2Token;
            }
            return versionedParcelable;
        }

        public void setSession2Token(VersionedParcelable session2Token) {
            synchronized (this.mLock) {
                this.mSession2Token = session2Token;
            }
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaSessionCompat.KEY_TOKEN, this);
            synchronized (this.mLock) {
                if (this.mExtraBinder != null) {
                    BundleCompat.putBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER, this.mExtraBinder.asBinder());
                }
                if (this.mSession2Token != null) {
                    ParcelUtils.putVersionedParcelable(bundle, MediaSessionCompat.KEY_SESSION2_TOKEN, this.mSession2Token);
                }
            }
            return bundle;
        }

        public static Token fromBundle(Bundle tokenBundle) {
            if (tokenBundle == null) {
                return null;
            }
            tokenBundle.setClassLoader(Token.class.getClassLoader());
            IMediaSession extraSession = IMediaSession.Stub.asInterface(BundleCompat.getBinder(tokenBundle, MediaSessionCompat.KEY_EXTRA_BINDER));
            VersionedParcelable session2Token = ParcelUtils.getVersionedParcelable(tokenBundle, MediaSessionCompat.KEY_SESSION2_TOKEN);
            Token token = (Token) tokenBundle.getParcelable(MediaSessionCompat.KEY_TOKEN);
            if (token == null) {
                return null;
            }
            return new Token(token.mInner, extraSession, session2Token);
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() { // from class: android.support.v4.media.session.MediaSessionCompat.QueueItem.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public QueueItem createFromParcel(Parcel p) {
                return new QueueItem(p);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public QueueItem[] newArray(int size) {
                return new QueueItem[size];
            }
        };
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private MediaSession.QueueItem mItemFwk;

        public QueueItem(MediaDescriptionCompat description, long id) {
            this(null, description, id);
        }

        private QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat description, long id) {
            if (description == null) {
                throw new IllegalArgumentException("Description cannot be null");
            }
            if (id == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.mDescription = description;
            this.mId = id;
            this.mItemFwk = queueItem;
        }

        QueueItem(Parcel in) {
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(in);
            this.mId = in.readLong();
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            this.mDescription.writeToParcel(dest, flags);
            dest.writeLong(this.mId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Object getQueueItem() {
            if (this.mItemFwk != null) {
                return this.mItemFwk;
            }
            this.mItemFwk = Api21Impl.createQueueItem((MediaDescription) this.mDescription.getMediaDescription(), this.mId);
            return this.mItemFwk;
        }

        public static QueueItem fromQueueItem(Object queueItem) {
            if (queueItem == null) {
                return null;
            }
            MediaSession.QueueItem queueItemObj = (MediaSession.QueueItem) queueItem;
            Object descriptionObj = Api21Impl.getDescription(queueItemObj);
            MediaDescriptionCompat description = MediaDescriptionCompat.fromMediaDescription(descriptionObj);
            long id = Api21Impl.getQueueId(queueItemObj);
            return new QueueItem(queueItemObj, description, id);
        }

        public static List<QueueItem> fromQueueItemList(List<?> itemList) {
            if (itemList == null) {
                return null;
            }
            List<QueueItem> items = new ArrayList<>(itemList.size());
            for (Object itemObj : itemList) {
                items.add(fromQueueItem(itemObj));
            }
            return items;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
        public static class Api21Impl {
            private Api21Impl() {
            }

            static MediaSession.QueueItem createQueueItem(MediaDescription description, long id) {
                return new MediaSession.QueueItem(description, id);
            }

            static MediaDescription getDescription(MediaSession.QueueItem queueItem) {
                return queueItem.getDescription();
            }

            static long getQueueId(MediaSession.QueueItem queueItem) {
                return queueItem.getQueueId();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() { // from class: android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ResultReceiverWrapper createFromParcel(Parcel p) {
                return new ResultReceiverWrapper(p);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ResultReceiverWrapper[] newArray(int size) {
                return new ResultReceiverWrapper[size];
            }
        };
        ResultReceiver mResultReceiver;

        public ResultReceiverWrapper(ResultReceiver resultReceiver) {
            this.mResultReceiver = resultReceiver;
        }

        ResultReceiverWrapper(Parcel in) {
            this.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(in);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            this.mResultReceiver.writeToParcel(dest, flags);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static class MediaSessionImplBase implements MediaSessionImpl {
        static final int RCC_PLAYSTATE_NONE = 0;
        final AudioManager mAudioManager;
        volatile Callback mCallback;
        boolean mCaptioningEnabled;
        private final Context mContext;
        Bundle mExtras;
        private MessageHandler mHandler;
        int mLocalStream;
        private final ComponentName mMediaButtonReceiverComponentName;
        private final PendingIntent mMediaButtonReceiverIntent;
        MediaMetadataCompat mMetadata;
        final String mPackageName;
        List<QueueItem> mQueue;
        CharSequence mQueueTitle;
        int mRatingType;
        final RemoteControlClient mRcc;
        RegistrationCallbackHandler mRegistrationCallbackHandler;
        private MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
        int mRepeatMode;
        PendingIntent mSessionActivity;
        final Bundle mSessionInfo;
        int mShuffleMode;
        PlaybackStateCompat mState;
        private final MediaSessionStub mStub;
        final String mTag;
        private final Token mToken;
        VolumeProviderCompat mVolumeProvider;
        int mVolumeType;
        final Object mLock = new Object();
        final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks = new RemoteCallbackList<>();
        boolean mDestroyed = false;
        boolean mIsActive = false;
        int mFlags = 3;
        private VolumeProviderCompat.Callback mVolumeCallback = new VolumeProviderCompat.Callback() { // from class: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.1
            public void onVolumeChanged(VolumeProviderCompat volumeProvider) {
                if (MediaSessionImplBase.this.mVolumeProvider != volumeProvider) {
                    return;
                }
                ParcelableVolumeInfo info = new ParcelableVolumeInfo(MediaSessionImplBase.this.mVolumeType, MediaSessionImplBase.this.mLocalStream, volumeProvider.getVolumeControl(), volumeProvider.getMaxVolume(), volumeProvider.getCurrentVolume());
                MediaSessionImplBase.this.sendVolumeInfoChanged(info);
            }
        };

        public MediaSessionImplBase(Context context, String tag, ComponentName mbrComponent, PendingIntent mbrIntent, VersionedParcelable session2Token, Bundle sessionInfo) {
            if (mbrComponent == null) {
                throw new IllegalArgumentException("MediaButtonReceiver component may not be null");
            }
            this.mContext = context;
            this.mPackageName = context.getPackageName();
            this.mSessionInfo = sessionInfo;
            this.mAudioManager = (AudioManager) context.getSystemService("audio");
            this.mTag = tag;
            this.mMediaButtonReceiverComponentName = mbrComponent;
            this.mMediaButtonReceiverIntent = mbrIntent;
            this.mStub = new MediaSessionStub();
            this.mToken = new Token(this.mStub, null, session2Token);
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = 3;
            this.mRcc = new RemoteControlClient(mbrIntent);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0032 A[Catch: all -> 0x0039, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:10:0x0012, B:12:0x001d, B:14:0x0023, B:16:0x0027, B:17:0x002c, B:19:0x0032, B:20:0x0037), top: B:25:0x0003 }] */
        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void setCallback(Callback callback, Handler handler) {
            MessageHandler messageHandler;
            synchronized (this.mLock) {
                if (this.mHandler != null) {
                    this.mHandler.removeCallbacksAndMessages(null);
                }
                if (callback != null && handler != null) {
                    messageHandler = new MessageHandler(handler.getLooper());
                    this.mHandler = messageHandler;
                    if (this.mCallback != callback && this.mCallback != null) {
                        this.mCallback.setSessionImpl(null, null);
                    }
                    this.mCallback = callback;
                    if (this.mCallback != null) {
                        this.mCallback.setSessionImpl(this, handler);
                    }
                }
                messageHandler = null;
                this.mHandler = messageHandler;
                if (this.mCallback != callback) {
                    this.mCallback.setSessionImpl(null, null);
                }
                this.mCallback = callback;
                if (this.mCallback != null) {
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRegistrationCallback(RegistrationCallback callback, Handler handler) {
            synchronized (this.mLock) {
                if (this.mRegistrationCallbackHandler != null) {
                    this.mRegistrationCallbackHandler.removeCallbacksAndMessages(null);
                }
                if (callback != null) {
                    this.mRegistrationCallbackHandler = new RegistrationCallbackHandler(handler.getLooper(), callback);
                } else {
                    this.mRegistrationCallbackHandler = null;
                }
            }
        }

        void postToHandler(int what, int arg1, int arg2, Object obj, Bundle extras) {
            synchronized (this.mLock) {
                if (this.mHandler != null) {
                    Message msg = this.mHandler.obtainMessage(what, arg1, arg2, obj);
                    Bundle data = new Bundle();
                    int uid = Binder.getCallingUid();
                    data.putInt(MediaSessionCompat.DATA_CALLING_UID, uid);
                    data.putString(MediaSessionCompat.DATA_CALLING_PACKAGE, getPackageNameForUid(uid));
                    int pid = Binder.getCallingPid();
                    if (pid > 0) {
                        data.putInt(MediaSessionCompat.DATA_CALLING_PID, pid);
                    } else {
                        data.putInt(MediaSessionCompat.DATA_CALLING_PID, -1);
                    }
                    if (extras != null) {
                        data.putBundle(MediaSessionCompat.DATA_EXTRAS, extras);
                    }
                    msg.setData(data);
                    msg.sendToTarget();
                }
            }
        }

        String getPackageNameForUid(int uid) {
            String result = this.mContext.getPackageManager().getNameForUid(uid);
            if (TextUtils.isEmpty(result)) {
                return "android.media.session.MediaController";
            }
            return result;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int flags) {
            synchronized (this.mLock) {
                this.mFlags = flags | 1 | 2;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int stream) {
            if (this.mVolumeProvider != null) {
                this.mVolumeProvider.setCallback((VolumeProviderCompat.Callback) null);
            }
            this.mLocalStream = stream;
            this.mVolumeType = 1;
            ParcelableVolumeInfo info = new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, 2, this.mAudioManager.getStreamMaxVolume(this.mLocalStream), this.mAudioManager.getStreamVolume(this.mLocalStream));
            sendVolumeInfoChanged(info);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat volumeProvider) {
            if (volumeProvider == null) {
                throw new IllegalArgumentException("volumeProvider may not be null");
            }
            if (this.mVolumeProvider != null) {
                this.mVolumeProvider.setCallback((VolumeProviderCompat.Callback) null);
            }
            this.mVolumeType = 2;
            this.mVolumeProvider = volumeProvider;
            ParcelableVolumeInfo info = new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume());
            sendVolumeInfoChanged(info);
            volumeProvider.setCallback(this.mVolumeCallback);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean active) {
            if (active == this.mIsActive) {
                return;
            }
            this.mIsActive = active;
            updateMbrAndRcc();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            return this.mIsActive;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(String event, Bundle extras) {
            sendEvent(event, extras);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            updateMbrAndRcc();
            sendSessionDestroyed();
            setCallback(null, null);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Token getSessionToken() {
            return this.mToken;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat state) {
            synchronized (this.mLock) {
                this.mState = state;
            }
            sendState(state);
            if (!this.mIsActive) {
                return;
            }
            if (state == null) {
                this.mRcc.setPlaybackState(0);
                this.mRcc.setTransportControlFlags(0);
                return;
            }
            setRccState(state);
            this.mRcc.setTransportControlFlags(getRccTransportControlFlagsFromActions(state.getActions()));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public PlaybackStateCompat getPlaybackState() {
            PlaybackStateCompat playbackStateCompat;
            synchronized (this.mLock) {
                playbackStateCompat = this.mState;
            }
            return playbackStateCompat;
        }

        void setRccState(PlaybackStateCompat state) {
            this.mRcc.setPlaybackState(getRccStateFromState(state.getState()));
        }

        int getRccStateFromState(int state) {
            switch (state) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                case 8:
                    return 8;
                case 7:
                    return 9;
                case 9:
                    return 7;
                case 10:
                case 11:
                    return 6;
                default:
                    return -1;
            }
        }

        int getRccTransportControlFlagsFromActions(long actions) {
            int transportControlFlags = 0;
            if ((1 & actions) != 0) {
                transportControlFlags = 0 | 32;
            }
            if ((2 & actions) != 0) {
                transportControlFlags |= 16;
            }
            if ((4 & actions) != 0) {
                transportControlFlags |= 4;
            }
            if ((8 & actions) != 0) {
                transportControlFlags |= 2;
            }
            if ((16 & actions) != 0) {
                transportControlFlags |= 1;
            }
            if ((32 & actions) != 0) {
                transportControlFlags |= 128;
            }
            if ((64 & actions) != 0) {
                transportControlFlags |= 64;
            }
            if ((512 & actions) != 0) {
                return transportControlFlags | 8;
            }
            return transportControlFlags;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(MediaMetadataCompat metadata) {
            if (metadata != null) {
                metadata = new MediaMetadataCompat.Builder(metadata, MediaSessionCompat.sMaxBitmapSize).build();
            }
            synchronized (this.mLock) {
                this.mMetadata = metadata;
            }
            sendMetadata(metadata);
            if (!this.mIsActive) {
                return;
            }
            RemoteControlClient.MetadataEditor editor = buildRccMetadata(metadata == null ? null : metadata.getBundle());
            editor.apply();
        }

        RemoteControlClient.MetadataEditor buildRccMetadata(Bundle metadata) {
            RemoteControlClient.MetadataEditor editor = this.mRcc.editMetadata(true);
            if (metadata == null) {
                return editor;
            }
            if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_ART)) {
                Bitmap art = (Bitmap) metadata.getParcelable(MediaMetadataCompat.METADATA_KEY_ART);
                if (art != null) {
                    art = art.copy(art.getConfig(), false);
                }
                editor.putBitmap(100, art);
            } else if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ART)) {
                Bitmap art2 = (Bitmap) metadata.getParcelable(MediaMetadataCompat.METADATA_KEY_ALBUM_ART);
                if (art2 != null) {
                    art2 = art2.copy(art2.getConfig(), false);
                }
                editor.putBitmap(100, art2);
            }
            if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM)) {
                editor.putString(1, metadata.getString(MediaMetadataCompat.METADATA_KEY_ALBUM));
            }
            if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST)) {
                editor.putString(13, metadata.getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST));
            }
            if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_ARTIST)) {
                editor.putString(2, metadata.getString(MediaMetadataCompat.METADATA_KEY_ARTIST));
            }
            if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_AUTHOR)) {
                editor.putString(3, metadata.getString(MediaMetadataCompat.METADATA_KEY_AUTHOR));
            }
            if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_COMPILATION)) {
                editor.putString(15, metadata.getString(MediaMetadataCompat.METADATA_KEY_COMPILATION));
            }
            if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_COMPOSER)) {
                editor.putString(4, metadata.getString(MediaMetadataCompat.METADATA_KEY_COMPOSER));
            }
            if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_DATE)) {
                editor.putString(5, metadata.getString(MediaMetadataCompat.METADATA_KEY_DATE));
            }
            if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER)) {
                editor.putLong(14, metadata.getLong(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER));
            }
            if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
                editor.putLong(9, metadata.getLong(MediaMetadataCompat.METADATA_KEY_DURATION));
            }
            if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_GENRE)) {
                editor.putString(6, metadata.getString(MediaMetadataCompat.METADATA_KEY_GENRE));
            }
            if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_TITLE)) {
                editor.putString(7, metadata.getString(MediaMetadataCompat.METADATA_KEY_TITLE));
            }
            if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER)) {
                editor.putLong(0, metadata.getLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER));
            }
            if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_WRITER)) {
                editor.putString(11, metadata.getString(MediaMetadataCompat.METADATA_KEY_WRITER));
            }
            return editor;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(PendingIntent pi) {
            synchronized (this.mLock) {
                this.mSessionActivity = pi;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent mbr) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(List<QueueItem> queue) {
            this.mQueue = queue;
            sendQueue(queue);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(CharSequence title) {
            this.mQueueTitle = title;
            sendQueueTitle(title);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getMediaSession() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getRemoteControlClient() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public String getCallingPackage() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int type) {
            this.mRatingType = type;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean enabled) {
            if (this.mCaptioningEnabled != enabled) {
                this.mCaptioningEnabled = enabled;
                sendCaptioningEnabled(enabled);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int repeatMode) {
            if (this.mRepeatMode != repeatMode) {
                this.mRepeatMode = repeatMode;
                sendRepeatMode(repeatMode);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int shuffleMode) {
            if (this.mShuffleMode != shuffleMode) {
                this.mShuffleMode = shuffleMode;
                sendShuffleMode(shuffleMode);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(Bundle extras) {
            this.mExtras = extras;
            sendExtras(extras);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            MediaSessionManager.RemoteUserInfo remoteUserInfo;
            synchronized (this.mLock) {
                remoteUserInfo = this.mRemoteUserInfo;
            }
            return remoteUserInfo;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            synchronized (this.mLock) {
                this.mRemoteUserInfo = remoteUserInfo;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Callback getCallback() {
            Callback callback;
            synchronized (this.mLock) {
                callback = this.mCallback;
            }
            return callback;
        }

        void updateMbrAndRcc() {
            if (this.mIsActive) {
                registerMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                this.mAudioManager.registerRemoteControlClient(this.mRcc);
                setMetadata(this.mMetadata);
                setPlaybackState(this.mState);
                return;
            }
            unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
            this.mRcc.setPlaybackState(0);
            this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
        }

        void registerMediaButtonEventReceiver(PendingIntent mbrIntent, ComponentName mbrComponent) {
            this.mAudioManager.registerMediaButtonEventReceiver(mbrComponent);
        }

        void unregisterMediaButtonEventReceiver(PendingIntent mbrIntent, ComponentName mbrComponent) {
            this.mAudioManager.unregisterMediaButtonEventReceiver(mbrComponent);
        }

        void adjustVolume(int direction, int flags) {
            if (this.mVolumeType == 2) {
                if (this.mVolumeProvider != null) {
                    this.mVolumeProvider.onAdjustVolume(direction);
                    return;
                }
                return;
            }
            this.mAudioManager.adjustStreamVolume(this.mLocalStream, direction, flags);
        }

        void setVolumeTo(int value, int flags) {
            if (this.mVolumeType == 2) {
                if (this.mVolumeProvider != null) {
                    this.mVolumeProvider.onSetVolumeTo(value);
                    return;
                }
                return;
            }
            this.mAudioManager.setStreamVolume(this.mLocalStream, value, flags);
        }

        void sendVolumeInfoChanged(ParcelableVolumeInfo info) {
            synchronized (this.mLock) {
                int size = this.mControllerCallbacks.beginBroadcast();
                for (int i = size - 1; i >= 0; i--) {
                    IMediaControllerCallback cb = this.mControllerCallbacks.getBroadcastItem(i);
                    try {
                        cb.onVolumeInfoChanged(info);
                    } catch (RemoteException e) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendSessionDestroyed() {
            synchronized (this.mLock) {
                int size = this.mControllerCallbacks.beginBroadcast();
                for (int i = size - 1; i >= 0; i--) {
                    IMediaControllerCallback cb = this.mControllerCallbacks.getBroadcastItem(i);
                    try {
                        cb.onSessionDestroyed();
                    } catch (RemoteException e) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
                this.mControllerCallbacks.kill();
            }
        }

        private void sendEvent(String event, Bundle extras) {
            synchronized (this.mLock) {
                int size = this.mControllerCallbacks.beginBroadcast();
                for (int i = size - 1; i >= 0; i--) {
                    IMediaControllerCallback cb = this.mControllerCallbacks.getBroadcastItem(i);
                    try {
                        cb.onEvent(event, extras);
                    } catch (RemoteException e) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendState(PlaybackStateCompat state) {
            synchronized (this.mLock) {
                int size = this.mControllerCallbacks.beginBroadcast();
                for (int i = size - 1; i >= 0; i--) {
                    IMediaControllerCallback cb = this.mControllerCallbacks.getBroadcastItem(i);
                    try {
                        cb.onPlaybackStateChanged(state);
                    } catch (RemoteException e) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendMetadata(MediaMetadataCompat metadata) {
            synchronized (this.mLock) {
                int size = this.mControllerCallbacks.beginBroadcast();
                for (int i = size - 1; i >= 0; i--) {
                    IMediaControllerCallback cb = this.mControllerCallbacks.getBroadcastItem(i);
                    try {
                        cb.onMetadataChanged(metadata);
                    } catch (RemoteException e) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendQueue(List<QueueItem> queue) {
            synchronized (this.mLock) {
                int size = this.mControllerCallbacks.beginBroadcast();
                for (int i = size - 1; i >= 0; i--) {
                    IMediaControllerCallback cb = this.mControllerCallbacks.getBroadcastItem(i);
                    try {
                        cb.onQueueChanged(queue);
                    } catch (RemoteException e) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendQueueTitle(CharSequence queueTitle) {
            synchronized (this.mLock) {
                int size = this.mControllerCallbacks.beginBroadcast();
                for (int i = size - 1; i >= 0; i--) {
                    IMediaControllerCallback cb = this.mControllerCallbacks.getBroadcastItem(i);
                    try {
                        cb.onQueueTitleChanged(queueTitle);
                    } catch (RemoteException e) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendCaptioningEnabled(boolean enabled) {
            synchronized (this.mLock) {
                int size = this.mControllerCallbacks.beginBroadcast();
                for (int i = size - 1; i >= 0; i--) {
                    IMediaControllerCallback cb = this.mControllerCallbacks.getBroadcastItem(i);
                    try {
                        cb.onCaptioningEnabledChanged(enabled);
                    } catch (RemoteException e) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendRepeatMode(int repeatMode) {
            synchronized (this.mLock) {
                int size = this.mControllerCallbacks.beginBroadcast();
                for (int i = size - 1; i >= 0; i--) {
                    IMediaControllerCallback cb = this.mControllerCallbacks.getBroadcastItem(i);
                    try {
                        cb.onRepeatModeChanged(repeatMode);
                    } catch (RemoteException e) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendShuffleMode(int shuffleMode) {
            synchronized (this.mLock) {
                int size = this.mControllerCallbacks.beginBroadcast();
                for (int i = size - 1; i >= 0; i--) {
                    IMediaControllerCallback cb = this.mControllerCallbacks.getBroadcastItem(i);
                    try {
                        cb.onShuffleModeChanged(shuffleMode);
                    } catch (RemoteException e) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendExtras(Bundle extras) {
            synchronized (this.mLock) {
                int size = this.mControllerCallbacks.beginBroadcast();
                for (int i = size - 1; i >= 0; i--) {
                    IMediaControllerCallback cb = this.mControllerCallbacks.getBroadcastItem(i);
                    try {
                        cb.onExtrasChanged(extras);
                    } catch (RemoteException e) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
        class MediaSessionStub extends IMediaSession.Stub {
            MediaSessionStub() {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String command, Bundle args, ResultReceiverWrapper cb) {
                postToHandler(1, new Command(command, args, cb == null ? null : cb.mResultReceiver));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent mediaButton) {
                postToHandler(21, mediaButton);
                return true;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback cb) {
                if (MediaSessionImplBase.this.mDestroyed) {
                    try {
                        cb.onSessionDestroyed();
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                int callingPid = Binder.getCallingPid();
                int callingUid = Binder.getCallingUid();
                MediaSessionManager.RemoteUserInfo info = new MediaSessionManager.RemoteUserInfo(MediaSessionImplBase.this.getPackageNameForUid(callingUid), callingPid, callingUid);
                MediaSessionImplBase.this.mControllerCallbacks.register(cb, info);
                synchronized (MediaSessionImplBase.this.mLock) {
                    if (MediaSessionImplBase.this.mRegistrationCallbackHandler != null) {
                        MediaSessionImplBase.this.mRegistrationCallbackHandler.postCallbackRegistered(callingPid, callingUid);
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback cb) {
                MediaSessionImplBase.this.mControllerCallbacks.unregister(cb);
                int callingPid = Binder.getCallingPid();
                int callingUid = Binder.getCallingUid();
                synchronized (MediaSessionImplBase.this.mLock) {
                    if (MediaSessionImplBase.this.mRegistrationCallbackHandler != null) {
                        MediaSessionImplBase.this.mRegistrationCallbackHandler.postCallbackUnregistered(callingPid, callingUid);
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                return MediaSessionImplBase.this.mPackageName;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getSessionInfo() {
                if (MediaSessionImplBase.this.mSessionInfo == null) {
                    return null;
                }
                return new Bundle(MediaSessionImplBase.this.mSessionInfo);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                return MediaSessionImplBase.this.mTag;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                PendingIntent pendingIntent;
                synchronized (MediaSessionImplBase.this.mLock) {
                    pendingIntent = MediaSessionImplBase.this.mSessionActivity;
                }
                return pendingIntent;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                long j;
                synchronized (MediaSessionImplBase.this.mLock) {
                    j = MediaSessionImplBase.this.mFlags;
                }
                return j;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                int volumeType;
                int stream;
                int controlType;
                int max;
                int current;
                synchronized (MediaSessionImplBase.this.mLock) {
                    volumeType = MediaSessionImplBase.this.mVolumeType;
                    stream = MediaSessionImplBase.this.mLocalStream;
                    VolumeProviderCompat vp = MediaSessionImplBase.this.mVolumeProvider;
                    if (volumeType == 2) {
                        int controlType2 = vp.getVolumeControl();
                        int max2 = vp.getMaxVolume();
                        controlType = controlType2;
                        max = max2;
                        current = vp.getCurrentVolume();
                    } else {
                        int max3 = MediaSessionImplBase.this.mAudioManager.getStreamMaxVolume(stream);
                        controlType = 2;
                        max = max3;
                        current = MediaSessionImplBase.this.mAudioManager.getStreamVolume(stream);
                    }
                }
                return new ParcelableVolumeInfo(volumeType, stream, controlType, max, current);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int direction, int flags, String packageName) {
                MediaSessionImplBase.this.adjustVolume(direction, flags);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int value, int flags, String packageName) {
                MediaSessionImplBase.this.setVolumeTo(value, flags);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                postToHandler(3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String mediaId, Bundle extras) throws RemoteException {
                postToHandler(4, mediaId, extras);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String query, Bundle extras) throws RemoteException {
                postToHandler(5, query, extras);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri uri, Bundle extras) throws RemoteException {
                postToHandler(6, uri, extras);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                postToHandler(7);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String mediaId, Bundle extras) throws RemoteException {
                postToHandler(8, mediaId, extras);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String query, Bundle extras) throws RemoteException {
                postToHandler(9, query, extras);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri uri, Bundle extras) throws RemoteException {
                postToHandler(10, uri, extras);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long id) {
                postToHandler(11, Long.valueOf(id));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                postToHandler(12);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                postToHandler(13);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                postToHandler(14);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                postToHandler(15);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                postToHandler(16);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                postToHandler(17);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long pos) throws RemoteException {
                postToHandler(18, Long.valueOf(pos));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat rating) throws RemoteException {
                postToHandler(19, rating);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat rating, Bundle extras) throws RemoteException {
                postToHandler(31, rating, extras);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setPlaybackSpeed(float speed) throws RemoteException {
                postToHandler(32, Float.valueOf(speed));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean enabled) throws RemoteException {
                postToHandler(29, Boolean.valueOf(enabled));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int repeatMode) throws RemoteException {
                postToHandler(23, repeatMode);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean enabled) throws RemoteException {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int shuffleMode) throws RemoteException {
                postToHandler(30, shuffleMode);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String action, Bundle args) throws RemoteException {
                postToHandler(20, action, args);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                return MediaSessionImplBase.this.mMetadata;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                PlaybackStateCompat state;
                MediaMetadataCompat metadata;
                synchronized (MediaSessionImplBase.this.mLock) {
                    state = MediaSessionImplBase.this.mState;
                    metadata = MediaSessionImplBase.this.mMetadata;
                }
                return MediaSessionCompat.getStateWithUpdatedPosition(state, metadata);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                List<QueueItem> list;
                synchronized (MediaSessionImplBase.this.mLock) {
                    list = MediaSessionImplBase.this.mQueue;
                }
                return list;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat description) {
                postToHandler(25, description);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat description, int index) {
                postToHandler(26, description, index);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat description) {
                postToHandler(27, description);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int index) {
                postToHandler(28, index);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                return MediaSessionImplBase.this.mQueueTitle;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                Bundle bundle;
                synchronized (MediaSessionImplBase.this.mLock) {
                    bundle = MediaSessionImplBase.this.mExtras;
                }
                return bundle;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return MediaSessionImplBase.this.mRatingType;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return MediaSessionImplBase.this.mCaptioningEnabled;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                return MediaSessionImplBase.this.mRepeatMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                return MediaSessionImplBase.this.mShuffleMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                return true;
            }

            void postToHandler(int what) {
                MediaSessionImplBase.this.postToHandler(what, 0, 0, null, null);
            }

            void postToHandler(int what, int arg1) {
                MediaSessionImplBase.this.postToHandler(what, arg1, 0, null, null);
            }

            void postToHandler(int what, int arg1, int arg2) {
                MediaSessionImplBase.this.postToHandler(what, arg1, arg2, null, null);
            }

            void postToHandler(int what, Object obj) {
                MediaSessionImplBase.this.postToHandler(what, 0, 0, obj, null);
            }

            void postToHandler(int what, Object obj, int arg1) {
                MediaSessionImplBase.this.postToHandler(what, arg1, 0, obj, null);
            }

            void postToHandler(int what, Object obj, Bundle extras) {
                MediaSessionImplBase.this.postToHandler(what, 0, 0, obj, extras);
            }
        }

        /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
        private static final class Command {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;

            public Command(String command, Bundle extras, ResultReceiver stub) {
                this.command = command;
                this.extras = extras;
                this.stub = stub;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
        public class MessageHandler extends Handler {
            private static final int KEYCODE_MEDIA_PAUSE = 127;
            private static final int KEYCODE_MEDIA_PLAY = 126;
            private static final int MSG_ADD_QUEUE_ITEM = 25;
            private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
            private static final int MSG_ADJUST_VOLUME = 2;
            private static final int MSG_COMMAND = 1;
            private static final int MSG_CUSTOM_ACTION = 20;
            private static final int MSG_FAST_FORWARD = 16;
            private static final int MSG_MEDIA_BUTTON = 21;
            private static final int MSG_NEXT = 14;
            private static final int MSG_PAUSE = 12;
            private static final int MSG_PLAY = 7;
            private static final int MSG_PLAY_MEDIA_ID = 8;
            private static final int MSG_PLAY_SEARCH = 9;
            private static final int MSG_PLAY_URI = 10;
            private static final int MSG_PREPARE = 3;
            private static final int MSG_PREPARE_MEDIA_ID = 4;
            private static final int MSG_PREPARE_SEARCH = 5;
            private static final int MSG_PREPARE_URI = 6;
            private static final int MSG_PREVIOUS = 15;
            private static final int MSG_RATE = 19;
            private static final int MSG_RATE_EXTRA = 31;
            private static final int MSG_REMOVE_QUEUE_ITEM = 27;
            private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
            private static final int MSG_REWIND = 17;
            private static final int MSG_SEEK_TO = 18;
            private static final int MSG_SET_CAPTIONING_ENABLED = 29;
            private static final int MSG_SET_PLAYBACK_SPEED = 32;
            private static final int MSG_SET_REPEAT_MODE = 23;
            private static final int MSG_SET_SHUFFLE_MODE = 30;
            private static final int MSG_SET_VOLUME = 22;
            private static final int MSG_SKIP_TO_ITEM = 11;
            private static final int MSG_STOP = 13;

            public MessageHandler(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                QueueItem item;
                Callback cb = MediaSessionImplBase.this.mCallback;
                if (cb == null) {
                    return;
                }
                Bundle data = msg.getData();
                MediaSessionCompat.ensureClassLoader(data);
                MediaSessionImplBase.this.setCurrentControllerInfo(new MediaSessionManager.RemoteUserInfo(data.getString(MediaSessionCompat.DATA_CALLING_PACKAGE), data.getInt(MediaSessionCompat.DATA_CALLING_PID), data.getInt(MediaSessionCompat.DATA_CALLING_UID)));
                Bundle extras = data.getBundle(MediaSessionCompat.DATA_EXTRAS);
                MediaSessionCompat.ensureClassLoader(extras);
                try {
                    switch (msg.what) {
                        case 1:
                            Command cmd = (Command) msg.obj;
                            cb.onCommand(cmd.command, cmd.extras, cmd.stub);
                            break;
                        case 2:
                            MediaSessionImplBase.this.adjustVolume(msg.arg1, 0);
                            break;
                        case 3:
                            cb.onPrepare();
                            break;
                        case 4:
                            cb.onPrepareFromMediaId((String) msg.obj, extras);
                            break;
                        case 5:
                            cb.onPrepareFromSearch((String) msg.obj, extras);
                            break;
                        case 6:
                            cb.onPrepareFromUri((Uri) msg.obj, extras);
                            break;
                        case 7:
                            cb.onPlay();
                            break;
                        case 8:
                            cb.onPlayFromMediaId((String) msg.obj, extras);
                            break;
                        case 9:
                            cb.onPlayFromSearch((String) msg.obj, extras);
                            break;
                        case 10:
                            cb.onPlayFromUri((Uri) msg.obj, extras);
                            break;
                        case 11:
                            cb.onSkipToQueueItem(((Long) msg.obj).longValue());
                            break;
                        case MSG_PAUSE /* 12 */:
                            cb.onPause();
                            break;
                        case MSG_STOP /* 13 */:
                            cb.onStop();
                            break;
                        case MSG_NEXT /* 14 */:
                            cb.onSkipToNext();
                            break;
                        case MSG_PREVIOUS /* 15 */:
                            cb.onSkipToPrevious();
                            break;
                        case 16:
                            cb.onFastForward();
                            break;
                        case MSG_REWIND /* 17 */:
                            cb.onRewind();
                            break;
                        case MSG_SEEK_TO /* 18 */:
                            cb.onSeekTo(((Long) msg.obj).longValue());
                            break;
                        case MSG_RATE /* 19 */:
                            cb.onSetRating((RatingCompat) msg.obj);
                            break;
                        case 20:
                            cb.onCustomAction((String) msg.obj, extras);
                            break;
                        case MSG_MEDIA_BUTTON /* 21 */:
                            KeyEvent keyEvent = (KeyEvent) msg.obj;
                            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!cb.onMediaButtonEvent(intent)) {
                                onMediaButtonEvent(keyEvent, cb);
                                break;
                            }
                            break;
                        case MSG_SET_VOLUME /* 22 */:
                            MediaSessionImplBase.this.setVolumeTo(msg.arg1, 0);
                            break;
                        case MSG_SET_REPEAT_MODE /* 23 */:
                            cb.onSetRepeatMode(msg.arg1);
                            break;
                        case MSG_ADD_QUEUE_ITEM /* 25 */:
                            cb.onAddQueueItem((MediaDescriptionCompat) msg.obj);
                            break;
                        case MSG_ADD_QUEUE_ITEM_AT /* 26 */:
                            cb.onAddQueueItem((MediaDescriptionCompat) msg.obj, msg.arg1);
                            break;
                        case MSG_REMOVE_QUEUE_ITEM /* 27 */:
                            cb.onRemoveQueueItem((MediaDescriptionCompat) msg.obj);
                            break;
                        case MSG_REMOVE_QUEUE_ITEM_AT /* 28 */:
                            if (MediaSessionImplBase.this.mQueue != null) {
                                if (msg.arg1 < 0 || msg.arg1 >= MediaSessionImplBase.this.mQueue.size()) {
                                    item = null;
                                } else {
                                    item = MediaSessionImplBase.this.mQueue.get(msg.arg1);
                                }
                                if (item != null) {
                                    cb.onRemoveQueueItem(item.getDescription());
                                }
                                break;
                            }
                            break;
                        case MSG_SET_CAPTIONING_ENABLED /* 29 */:
                            cb.onSetCaptioningEnabled(((Boolean) msg.obj).booleanValue());
                            break;
                        case 30:
                            cb.onSetShuffleMode(msg.arg1);
                            break;
                        case MSG_RATE_EXTRA /* 31 */:
                            cb.onSetRating((RatingCompat) msg.obj, extras);
                            break;
                        case MSG_SET_PLAYBACK_SPEED /* 32 */:
                            cb.onSetPlaybackSpeed(((Float) msg.obj).floatValue());
                            break;
                    }
                } finally {
                    MediaSessionImplBase.this.setCurrentControllerInfo(null);
                }
            }

            private void onMediaButtonEvent(KeyEvent ke, Callback cb) {
                if (ke == null || ke.getAction() != 0) {
                    return;
                }
                long validActions = MediaSessionImplBase.this.mState == null ? 0L : MediaSessionImplBase.this.mState.getActions();
                switch (ke.getKeyCode()) {
                    case 79:
                    case 85:
                        Log.w(MediaSessionCompat.TAG, "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
                        return;
                    case 86:
                        if ((1 & validActions) != 0) {
                            cb.onStop();
                            return;
                        }
                        return;
                    case 87:
                        if ((32 & validActions) != 0) {
                            cb.onSkipToNext();
                            return;
                        }
                        return;
                    case 88:
                        if ((16 & validActions) != 0) {
                            cb.onSkipToPrevious();
                            return;
                        }
                        return;
                    case 89:
                        if ((8 & validActions) != 0) {
                            cb.onRewind();
                            return;
                        }
                        return;
                    case 90:
                        if ((64 & validActions) != 0) {
                            cb.onFastForward();
                            return;
                        }
                        return;
                    case KEYCODE_MEDIA_PLAY /* 126 */:
                        if ((4 & validActions) != 0) {
                            cb.onPlay();
                            return;
                        }
                        return;
                    case KEYCODE_MEDIA_PAUSE /* 127 */:
                        if ((2 & validActions) != 0) {
                            cb.onPause();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    static class MediaSessionImplApi18 extends MediaSessionImplBase {
        private static boolean sIsMbrPendingIntentSupported = true;

        MediaSessionImplApi18(Context context, String tag, ComponentName mbrComponent, PendingIntent mbrIntent, VersionedParcelable session2Token, Bundle sessionInfo) {
            super(context, tag, mbrComponent, mbrIntent, session2Token, sessionInfo);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback callback, Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setPlaybackPositionUpdateListener(null);
                return;
            }
            RemoteControlClient.OnPlaybackPositionUpdateListener listener = new RemoteControlClient.OnPlaybackPositionUpdateListener() { // from class: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18.1
                @Override // android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
                public void onPlaybackPositionUpdate(long newPositionMs) {
                    MediaSessionImplApi18.this.postToHandler(18, -1, -1, Long.valueOf(newPositionMs), null);
                }
            };
            this.mRcc.setPlaybackPositionUpdateListener(listener);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        void setRccState(PlaybackStateCompat state) {
            long position = state.getPosition();
            float speed = state.getPlaybackSpeed();
            long updateTime = state.getLastPositionUpdateTime();
            long currTime = SystemClock.elapsedRealtime();
            if (state.getState() == 3 && position > 0) {
                long diff = 0;
                if (updateTime > 0) {
                    diff = currTime - updateTime;
                    if (speed > MenuKt.ClosedAlphaTarget && speed != 1.0f) {
                        diff = ((float) diff) * speed;
                    }
                }
                position += diff;
            }
            this.mRcc.setPlaybackState(getRccStateFromState(state.getState()), position, speed);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        int getRccTransportControlFlagsFromActions(long actions) {
            int transportControlFlags = super.getRccTransportControlFlagsFromActions(actions);
            if ((256 & actions) != 0) {
                return transportControlFlags | 256;
            }
            return transportControlFlags;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        void registerMediaButtonEventReceiver(PendingIntent mbrIntent, ComponentName mbrComponent) {
            if (sIsMbrPendingIntentSupported) {
                try {
                    this.mAudioManager.registerMediaButtonEventReceiver(mbrIntent);
                } catch (NullPointerException e) {
                    Log.w(MediaSessionCompat.TAG, "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                    sIsMbrPendingIntentSupported = false;
                }
            }
            if (!sIsMbrPendingIntentSupported) {
                super.registerMediaButtonEventReceiver(mbrIntent, mbrComponent);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        void unregisterMediaButtonEventReceiver(PendingIntent mbrIntent, ComponentName mbrComponent) {
            if (sIsMbrPendingIntentSupported) {
                this.mAudioManager.unregisterMediaButtonEventReceiver(mbrIntent);
            } else {
                super.unregisterMediaButtonEventReceiver(mbrIntent, mbrComponent);
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    static class MediaSessionImplApi19 extends MediaSessionImplApi18 {
        MediaSessionImplApi19(Context context, String tag, ComponentName mbrComponent, PendingIntent mbrIntent, VersionedParcelable session2Token, Bundle sessionInfo) {
            super(context, tag, mbrComponent, mbrIntent, session2Token, sessionInfo);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback callback, Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setMetadataUpdateListener(null);
                return;
            }
            RemoteControlClient.OnMetadataUpdateListener listener = new RemoteControlClient.OnMetadataUpdateListener() { // from class: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi19.1
                @Override // android.media.RemoteControlClient.OnMetadataUpdateListener
                public void onMetadataUpdate(int key, Object newValue) {
                    if (key == 268435457 && (newValue instanceof Rating)) {
                        MediaSessionImplApi19.this.postToHandler(19, -1, -1, RatingCompat.fromRating(newValue), null);
                    }
                }
            };
            this.mRcc.setMetadataUpdateListener(listener);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        int getRccTransportControlFlagsFromActions(long actions) {
            int transportControlFlags = super.getRccTransportControlFlagsFromActions(actions);
            if ((128 & actions) != 0) {
                return transportControlFlags | 512;
            }
            return transportControlFlags;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        RemoteControlClient.MetadataEditor buildRccMetadata(Bundle metadata) {
            RemoteControlClient.MetadataEditor editor = super.buildRccMetadata(metadata);
            long actions = this.mState == null ? 0L : this.mState.getActions();
            if ((128 & actions) != 0) {
                editor.addEditableKey(268435457);
            }
            if (metadata == null) {
                return editor;
            }
            if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_YEAR)) {
                editor.putLong(8, metadata.getLong(MediaMetadataCompat.METADATA_KEY_YEAR));
            }
            if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_RATING)) {
                editor.putObject(101, (Object) metadata.getParcelable(MediaMetadataCompat.METADATA_KEY_RATING));
            }
            if (metadata.containsKey(MediaMetadataCompat.METADATA_KEY_USER_RATING)) {
                editor.putObject(268435457, (Object) metadata.getParcelable(MediaMetadataCompat.METADATA_KEY_USER_RATING));
            }
            return editor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static class MediaSessionImplApi21 implements MediaSessionImpl {
        Callback mCallback;
        boolean mCaptioningEnabled;
        MediaMetadataCompat mMetadata;
        PlaybackStateCompat mPlaybackState;
        List<QueueItem> mQueue;
        int mRatingType;
        RegistrationCallbackHandler mRegistrationCallbackHandler;
        MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
        int mRepeatMode;
        final MediaSession mSessionFwk;
        Bundle mSessionInfo;
        int mShuffleMode;
        final Token mToken;
        final Object mLock = new Object();
        boolean mDestroyed = false;
        final RemoteCallbackList<IMediaControllerCallback> mExtraControllerCallbacks = new RemoteCallbackList<>();

        MediaSessionImplApi21(Context context, String tag, VersionedParcelable session2Token, Bundle sessionInfo) {
            this.mSessionFwk = createFwkMediaSession(context, tag, sessionInfo);
            this.mToken = new Token(this.mSessionFwk.getSessionToken(), new ExtraSession(), session2Token);
            this.mSessionInfo = sessionInfo;
            setFlags(3);
        }

        MediaSessionImplApi21(Object mediaSession) {
            if (!(mediaSession instanceof MediaSession)) {
                throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
            }
            this.mSessionFwk = (MediaSession) mediaSession;
            this.mToken = new Token(this.mSessionFwk.getSessionToken(), new ExtraSession());
            this.mSessionInfo = null;
            setFlags(3);
        }

        public MediaSession createFwkMediaSession(Context context, String tag, Bundle sessionInfo) {
            return new MediaSession(context, tag);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback callback, Handler handler) {
            synchronized (this.mLock) {
                this.mCallback = callback;
                this.mSessionFwk.setCallback(callback == null ? null : callback.mCallbackFwk, handler);
                if (callback != null) {
                    callback.setSessionImpl(this, handler);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRegistrationCallback(RegistrationCallback callback, Handler handler) {
            synchronized (this.mLock) {
                if (this.mRegistrationCallbackHandler != null) {
                    this.mRegistrationCallbackHandler.removeCallbacksAndMessages(null);
                }
                if (callback != null) {
                    this.mRegistrationCallbackHandler = new RegistrationCallbackHandler(handler.getLooper(), callback);
                } else {
                    this.mRegistrationCallbackHandler = null;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int flags) {
            this.mSessionFwk.setFlags(flags | 1 | 2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int stream) {
            AudioAttributes.Builder bob = new AudioAttributes.Builder();
            bob.setLegacyStreamType(stream);
            this.mSessionFwk.setPlaybackToLocal(bob.build());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat volumeProvider) {
            this.mSessionFwk.setPlaybackToRemote((VolumeProvider) volumeProvider.getVolumeProvider());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean active) {
            this.mSessionFwk.setActive(active);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            return this.mSessionFwk.isActive();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(String event, Bundle extras) {
            this.mSessionFwk.sendSessionEvent(event, extras);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            this.mDestroyed = true;
            this.mExtraControllerCallbacks.kill();
            if (Build.VERSION.SDK_INT == 27) {
                try {
                    Field callback = this.mSessionFwk.getClass().getDeclaredField("mCallback");
                    callback.setAccessible(true);
                    Handler handler = (Handler) callback.get(this.mSessionFwk);
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                } catch (Exception e) {
                    Log.w(MediaSessionCompat.TAG, "Exception happened while accessing MediaSession.mCallback.", e);
                }
            }
            this.mSessionFwk.setCallback(null);
            this.mSessionFwk.release();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Token getSessionToken() {
            return this.mToken;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat state) {
            this.mPlaybackState = state;
            synchronized (this.mLock) {
                int size = this.mExtraControllerCallbacks.beginBroadcast();
                for (int i = size - 1; i >= 0; i--) {
                    IMediaControllerCallback cb = this.mExtraControllerCallbacks.getBroadcastItem(i);
                    try {
                        cb.onPlaybackStateChanged(state);
                    } catch (RemoteException e) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
            this.mSessionFwk.setPlaybackState(state == null ? null : (PlaybackState) state.getPlaybackState());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public PlaybackStateCompat getPlaybackState() {
            return this.mPlaybackState;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(MediaMetadataCompat metadata) {
            this.mMetadata = metadata;
            this.mSessionFwk.setMetadata(metadata == null ? null : (MediaMetadata) metadata.getMediaMetadata());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(PendingIntent pi) {
            this.mSessionFwk.setSessionActivity(pi);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent mbr) {
            this.mSessionFwk.setMediaButtonReceiver(mbr);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(List<QueueItem> queue) {
            this.mQueue = queue;
            if (queue == null) {
                this.mSessionFwk.setQueue(null);
                return;
            }
            ArrayList<MediaSession.QueueItem> queueItemFwks = new ArrayList<>(queue.size());
            for (QueueItem item : queue) {
                queueItemFwks.add((MediaSession.QueueItem) item.getQueueItem());
            }
            this.mSessionFwk.setQueue(queueItemFwks);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(CharSequence title) {
            this.mSessionFwk.setQueueTitle(title);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int type) {
            this.mRatingType = type;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean enabled) {
            if (this.mCaptioningEnabled != enabled) {
                this.mCaptioningEnabled = enabled;
                synchronized (this.mLock) {
                    int size = this.mExtraControllerCallbacks.beginBroadcast();
                    for (int i = size - 1; i >= 0; i--) {
                        IMediaControllerCallback cb = this.mExtraControllerCallbacks.getBroadcastItem(i);
                        try {
                            cb.onCaptioningEnabledChanged(enabled);
                        } catch (RemoteException e) {
                        }
                    }
                    this.mExtraControllerCallbacks.finishBroadcast();
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int repeatMode) {
            if (this.mRepeatMode != repeatMode) {
                this.mRepeatMode = repeatMode;
                synchronized (this.mLock) {
                    int size = this.mExtraControllerCallbacks.beginBroadcast();
                    for (int i = size - 1; i >= 0; i--) {
                        IMediaControllerCallback cb = this.mExtraControllerCallbacks.getBroadcastItem(i);
                        try {
                            cb.onRepeatModeChanged(repeatMode);
                        } catch (RemoteException e) {
                        }
                    }
                    this.mExtraControllerCallbacks.finishBroadcast();
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int shuffleMode) {
            if (this.mShuffleMode != shuffleMode) {
                this.mShuffleMode = shuffleMode;
                synchronized (this.mLock) {
                    int size = this.mExtraControllerCallbacks.beginBroadcast();
                    for (int i = size - 1; i >= 0; i--) {
                        IMediaControllerCallback cb = this.mExtraControllerCallbacks.getBroadcastItem(i);
                        try {
                            cb.onShuffleModeChanged(shuffleMode);
                        } catch (RemoteException e) {
                        }
                    }
                    this.mExtraControllerCallbacks.finishBroadcast();
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(Bundle extras) {
            this.mSessionFwk.setExtras(extras);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getMediaSession() {
            return this.mSessionFwk;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getRemoteControlClient() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            synchronized (this.mLock) {
                this.mRemoteUserInfo = remoteUserInfo;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public String getCallingPackage() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            try {
                Method getCallingPackageMethod = this.mSessionFwk.getClass().getMethod("getCallingPackage", new Class[0]);
                return (String) getCallingPackageMethod.invoke(this.mSessionFwk, new Object[0]);
            } catch (Exception e) {
                Log.e(MediaSessionCompat.TAG, "Cannot execute MediaSession.getCallingPackage()", e);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            MediaSessionManager.RemoteUserInfo remoteUserInfo;
            synchronized (this.mLock) {
                remoteUserInfo = this.mRemoteUserInfo;
            }
            return remoteUserInfo;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Callback getCallback() {
            Callback callback;
            synchronized (this.mLock) {
                callback = this.mCallback;
            }
            return callback;
        }

        /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
        class ExtraSession extends IMediaSession.Stub {
            ExtraSession() {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String command, Bundle args, ResultReceiverWrapper cb) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent mediaButton) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback cb) {
                if (MediaSessionImplApi21.this.mDestroyed) {
                    return;
                }
                int callingPid = Binder.getCallingPid();
                int callingUid = Binder.getCallingUid();
                MediaSessionManager.RemoteUserInfo info = new MediaSessionManager.RemoteUserInfo("android.media.session.MediaController", callingPid, callingUid);
                MediaSessionImplApi21.this.mExtraControllerCallbacks.register(cb, info);
                synchronized (MediaSessionImplApi21.this.mLock) {
                    if (MediaSessionImplApi21.this.mRegistrationCallbackHandler != null) {
                        MediaSessionImplApi21.this.mRegistrationCallbackHandler.postCallbackRegistered(callingPid, callingUid);
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback cb) {
                MediaSessionImplApi21.this.mExtraControllerCallbacks.unregister(cb);
                int callingPid = Binder.getCallingPid();
                int callingUid = Binder.getCallingUid();
                synchronized (MediaSessionImplApi21.this.mLock) {
                    if (MediaSessionImplApi21.this.mRegistrationCallbackHandler != null) {
                        MediaSessionImplApi21.this.mRegistrationCallbackHandler.postCallbackUnregistered(callingPid, callingUid);
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getSessionInfo() {
                if (MediaSessionImplApi21.this.mSessionInfo == null) {
                    return null;
                }
                return new Bundle(MediaSessionImplApi21.this.mSessionInfo);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int direction, int flags, String packageName) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int value, int flags, String packageName) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String mediaId, Bundle extras) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String query, Bundle extras) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri uri, Bundle extras) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String mediaId, Bundle extras) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String query, Bundle extras) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri uri, Bundle extras) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long id) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long pos) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat rating) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat rating, Bundle extras) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setPlaybackSpeed(float speed) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean enabled) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int repeatMode) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean enabled) throws RemoteException {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int shuffleMode) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String action, Bundle args) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                return MediaSessionCompat.getStateWithUpdatedPosition(MediaSessionImplApi21.this.mPlaybackState, MediaSessionImplApi21.this.mMetadata);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                return null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat descriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat descriptionCompat, int index) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat description) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int index) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return MediaSessionImplApi21.this.mRatingType;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return MediaSessionImplApi21.this.mCaptioningEnabled;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                return MediaSessionImplApi21.this.mRepeatMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                return MediaSessionImplApi21.this.mShuffleMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    static class MediaSessionImplApi22 extends MediaSessionImplApi21 {
        MediaSessionImplApi22(Context context, String tag, VersionedParcelable session2Token, Bundle sessionInfo) {
            super(context, tag, session2Token, sessionInfo);
        }

        MediaSessionImplApi22(Object mediaSession) {
            super(mediaSession);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int type) {
            this.mSessionFwk.setRatingType(type);
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    static class MediaSessionImplApi28 extends MediaSessionImplApi22 {
        MediaSessionImplApi28(Context context, String tag, VersionedParcelable session2Token, Bundle sessionInfo) {
            super(context, tag, session2Token, sessionInfo);
        }

        MediaSessionImplApi28(Object mediaSession) {
            super(mediaSession);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            MediaSessionManager.RemoteUserInfo info = this.mSessionFwk.getCurrentControllerInfo();
            return new MediaSessionManager.RemoteUserInfo(info);
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    static class MediaSessionImplApi29 extends MediaSessionImplApi28 {
        MediaSessionImplApi29(Context context, String tag, VersionedParcelable session2Token, Bundle sessionInfo) {
            super(context, tag, session2Token, sessionInfo);
        }

        MediaSessionImplApi29(Object mediaSession) {
            super(mediaSession);
            this.mSessionInfo = ((MediaSession) mediaSession).getController().getSessionInfo();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21
        public MediaSession createFwkMediaSession(Context context, String tag, Bundle sessionInfo) {
            return new MediaSession(context, tag, sessionInfo);
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    static final class RegistrationCallbackHandler extends Handler {
        private static final int MSG_CALLBACK_REGISTERED = 1001;
        private static final int MSG_CALLBACK_UNREGISTERED = 1002;
        private final RegistrationCallback mCallback;

        RegistrationCallbackHandler(Looper looper, RegistrationCallback callback) {
            super(looper);
            this.mCallback = callback;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_CALLBACK_REGISTERED /* 1001 */:
                    this.mCallback.onCallbackRegistered(msg.arg1, msg.arg2);
                    return;
                case MSG_CALLBACK_UNREGISTERED /* 1002 */:
                    this.mCallback.onCallbackUnregistered(msg.arg1, msg.arg2);
                    return;
                default:
                    return;
            }
        }

        public void postCallbackRegistered(int callingPid, int callingUid) {
            obtainMessage(MSG_CALLBACK_REGISTERED, callingPid, callingUid).sendToTarget();
        }

        public void postCallbackUnregistered(int callingPid, int callingUid) {
            obtainMessage(MSG_CALLBACK_UNREGISTERED, callingPid, callingUid).sendToTarget();
        }
    }
}