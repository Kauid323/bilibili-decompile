package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaDescription;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class MediaBrowserCompat {
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    private final MediaBrowserImpl mImpl;
    static final String TAG = "MediaBrowserCompat";
    static final boolean DEBUG = Log.isLoggable(TAG, 3);

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    interface MediaBrowserImpl {
        void connect();

        void disconnect();

        Bundle getExtras();

        void getItem(String str, ItemCallback itemCallback);

        Bundle getNotifyChildrenChangedOptions();

        String getRoot();

        ComponentName getServiceComponent();

        MediaSessionCompat.Token getSessionToken();

        boolean isConnected();

        void search(String str, Bundle bundle, SearchCallback searchCallback);

        void sendCustomAction(String str, Bundle bundle, CustomActionCallback customActionCallback);

        void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback);

        void unsubscribe(String str, SubscriptionCallback subscriptionCallback);
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger messenger);

        void onLoadChildren(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2);

        void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);
    }

    public MediaBrowserCompat(Context context, ComponentName serviceComponent, ConnectionCallback callback, Bundle rootHints) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mImpl = new MediaBrowserImplApi26(context, serviceComponent, callback, rootHints);
        } else {
            this.mImpl = new MediaBrowserImplApi23(context, serviceComponent, callback, rootHints);
        }
    }

    public void connect() {
        Log.d(TAG, "Connecting to a MediaBrowserService.");
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    public String getRoot() {
        return this.mImpl.getRoot();
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public void subscribe(String parentId, SubscriptionCallback callback) {
        if (TextUtils.isEmpty(parentId)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (callback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        this.mImpl.subscribe(parentId, null, callback);
    }

    public void subscribe(String parentId, Bundle options, SubscriptionCallback callback) {
        if (TextUtils.isEmpty(parentId)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (callback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        if (options == null) {
            throw new IllegalArgumentException("options are null");
        }
        this.mImpl.subscribe(parentId, options, callback);
    }

    public void unsubscribe(String parentId) {
        if (TextUtils.isEmpty(parentId)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        this.mImpl.unsubscribe(parentId, null);
    }

    public void unsubscribe(String parentId, SubscriptionCallback callback) {
        if (TextUtils.isEmpty(parentId)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (callback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        this.mImpl.unsubscribe(parentId, callback);
    }

    public void getItem(String mediaId, ItemCallback cb) {
        this.mImpl.getItem(mediaId, cb);
    }

    public void search(String query, Bundle extras, SearchCallback callback) {
        if (TextUtils.isEmpty(query)) {
            throw new IllegalArgumentException("query cannot be empty");
        }
        if (callback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        this.mImpl.search(query, extras, callback);
    }

    public void sendCustomAction(String action, Bundle extras, CustomActionCallback callback) {
        if (TextUtils.isEmpty(action)) {
            throw new IllegalArgumentException("action cannot be empty");
        }
        this.mImpl.sendCustomAction(action, extras, callback);
    }

    public Bundle getNotifyChildrenChangedOptions() {
        return this.mImpl.getNotifyChildrenChangedOptions();
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() { // from class: android.support.v4.media.MediaBrowserCompat.MediaItem.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaItem createFromParcel(Parcel in) {
                return new MediaItem(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaItem[] newArray(int size) {
                return new MediaItem[size];
            }
        };
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        public static MediaItem fromMediaItem(Object itemObj) {
            if (itemObj == null) {
                return null;
            }
            MediaBrowser.MediaItem itemFwk = (MediaBrowser.MediaItem) itemObj;
            int flags = Api21Impl.getFlags(itemFwk);
            MediaDescriptionCompat descriptionCompat = MediaDescriptionCompat.fromMediaDescription(Api21Impl.getDescription(itemFwk));
            return new MediaItem(descriptionCompat, flags);
        }

        public static List<MediaItem> fromMediaItemList(List<?> itemList) {
            if (itemList == null) {
                return null;
            }
            List<MediaItem> items = new ArrayList<>(itemList.size());
            for (Object itemObj : itemList) {
                items.add(fromMediaItem(itemObj));
            }
            return items;
        }

        public MediaItem(MediaDescriptionCompat description, int flags) {
            if (description == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if (TextUtils.isEmpty(description.getMediaId())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.mFlags = flags;
            this.mDescription = description;
        }

        MediaItem(Parcel in) {
            this.mFlags = in.readInt();
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(in);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            out.writeInt(this.mFlags);
            this.mDescription.writeToParcel(out, flags);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MediaItem{");
            sb.append("mFlags=").append(this.mFlags);
            sb.append(", mDescription=").append(this.mDescription);
            sb.append('}');
            return sb.toString();
        }

        public int getFlags() {
            return this.mFlags;
        }

        public boolean isBrowsable() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.mFlags & 2) != 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public String getMediaId() {
            return this.mDescription.getMediaId();
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static class ConnectionCallback {
        final MediaBrowser.ConnectionCallback mConnectionCallbackFwk = new ConnectionCallbackApi21();
        ConnectionCallbackInternal mConnectionCallbackInternal;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
        public interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        public void onConnected() {
        }

        public void onConnectionSuspended() {
        }

        public void onConnectionFailed() {
        }

        void setInternalConnectionCallback(ConnectionCallbackInternal connectionCallbackInternal) {
            this.mConnectionCallbackInternal = connectionCallbackInternal;
        }

        /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
        private class ConnectionCallbackApi21 extends MediaBrowser.ConnectionCallback {
            ConnectionCallbackApi21() {
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnected() {
                if (ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    ConnectionCallback.this.mConnectionCallbackInternal.onConnected();
                }
                ConnectionCallback.this.onConnected();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionSuspended() {
                if (ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    ConnectionCallback.this.mConnectionCallbackInternal.onConnectionSuspended();
                }
                ConnectionCallback.this.onConnectionSuspended();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionFailed() {
                if (ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    ConnectionCallback.this.mConnectionCallbackInternal.onConnectionFailed();
                }
                ConnectionCallback.this.onConnectionFailed();
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static abstract class SubscriptionCallback {
        final MediaBrowser.SubscriptionCallback mSubscriptionCallbackFwk;
        WeakReference<Subscription> mSubscriptionRef;
        final IBinder mToken = new Binder();

        public SubscriptionCallback() {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mSubscriptionCallbackFwk = new SubscriptionCallbackApi26();
            } else {
                this.mSubscriptionCallbackFwk = new SubscriptionCallbackApi21();
            }
        }

        public void onChildrenLoaded(String parentId, List<MediaItem> children) {
        }

        public void onChildrenLoaded(String parentId, List<MediaItem> children, Bundle options) {
        }

        public void onError(String parentId) {
        }

        public void onError(String parentId, Bundle options) {
        }

        void setSubscription(Subscription subscription) {
            this.mSubscriptionRef = new WeakReference<>(subscription);
        }

        /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
        private class SubscriptionCallbackApi21 extends MediaBrowser.SubscriptionCallback {
            SubscriptionCallbackApi21() {
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(String parentId, List<MediaBrowser.MediaItem> children) {
                Subscription sub = SubscriptionCallback.this.mSubscriptionRef == null ? null : SubscriptionCallback.this.mSubscriptionRef.get();
                if (sub == null) {
                    SubscriptionCallback.this.onChildrenLoaded(parentId, MediaItem.fromMediaItemList(children));
                    return;
                }
                List<MediaItem> itemList = MediaItem.fromMediaItemList(children);
                List<SubscriptionCallback> callbacks = sub.getCallbacks();
                List<Bundle> optionsList = sub.getOptionsList();
                for (int i = 0; i < callbacks.size(); i++) {
                    Bundle options = optionsList.get(i);
                    if (options == null) {
                        SubscriptionCallback.this.onChildrenLoaded(parentId, itemList);
                    } else {
                        SubscriptionCallback.this.onChildrenLoaded(parentId, applyOptions(itemList, options), options);
                    }
                }
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(String parentId) {
                SubscriptionCallback.this.onError(parentId);
            }

            List<MediaItem> applyOptions(List<MediaItem> list, Bundle options) {
                if (list == null) {
                    return null;
                }
                int page = options.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                int pageSize = options.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                if (page == -1 && pageSize == -1) {
                    return list;
                }
                int fromIndex = pageSize * page;
                int toIndex = fromIndex + pageSize;
                if (page < 0 || pageSize < 1 || fromIndex >= list.size()) {
                    return Collections.emptyList();
                }
                if (toIndex > list.size()) {
                    toIndex = list.size();
                }
                return list.subList(fromIndex, toIndex);
            }
        }

        /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
        private class SubscriptionCallbackApi26 extends SubscriptionCallbackApi21 {
            SubscriptionCallbackApi26() {
                super();
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(String parentId, List<MediaBrowser.MediaItem> children, Bundle options) {
                MediaSessionCompat.ensureClassLoader(options);
                SubscriptionCallback.this.onChildrenLoaded(parentId, MediaItem.fromMediaItemList(children), options);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(String parentId, Bundle options) {
                MediaSessionCompat.ensureClassLoader(options);
                SubscriptionCallback.this.onError(parentId, options);
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static abstract class ItemCallback {
        final MediaBrowser.ItemCallback mItemCallbackFwk = new ItemCallbackApi23();

        public void onItemLoaded(MediaItem item) {
        }

        public void onError(String itemId) {
        }

        /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
        private class ItemCallbackApi23 extends MediaBrowser.ItemCallback {
            ItemCallbackApi23() {
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onItemLoaded(MediaBrowser.MediaItem item) {
                ItemCallback.this.onItemLoaded(MediaItem.fromMediaItem(item));
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onError(String itemId) {
                ItemCallback.this.onError(itemId);
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static abstract class SearchCallback {
        public void onSearchResult(String query, Bundle extras, List<MediaItem> items) {
        }

        public void onError(String query, Bundle extras) {
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static abstract class CustomActionCallback {
        public void onProgressUpdate(String action, Bundle extras, Bundle data) {
        }

        public void onResult(String action, Bundle extras, Bundle resultData) {
        }

        public void onError(String action, Bundle extras, Bundle data) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        static final int CONNECT_STATE_CONNECTED = 3;
        static final int CONNECT_STATE_CONNECTING = 2;
        static final int CONNECT_STATE_DISCONNECTED = 1;
        static final int CONNECT_STATE_DISCONNECTING = 0;
        static final int CONNECT_STATE_SUSPENDED = 4;
        final ConnectionCallback mCallback;
        Messenger mCallbacksMessenger;
        final Context mContext;
        private Bundle mExtras;
        private MediaSessionCompat.Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        final Bundle mRootHints;
        private String mRootId;
        ServiceBinderWrapper mServiceBinderWrapper;
        final ComponentName mServiceComponent;
        MediaServiceConnection mServiceConnection;
        final CallbackHandler mHandler = new CallbackHandler(this);
        private final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap<>();
        int mState = 1;

        public MediaBrowserImplBase(Context context, ComponentName serviceComponent, ConnectionCallback callback, Bundle rootHints) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            }
            if (serviceComponent == null) {
                throw new IllegalArgumentException("service component must not be null");
            }
            if (callback == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            }
            this.mContext = context;
            this.mServiceComponent = serviceComponent;
            this.mCallback = callback;
            this.mRootHints = rootHints == null ? null : new Bundle(rootHints);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            if (this.mState != 0 && this.mState != 1) {
                throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + getStateLabel(this.mState) + ")");
            }
            this.mState = 2;
            this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MediaBrowserImplBase.this.mState == 0) {
                        return;
                    }
                    MediaBrowserImplBase.this.mState = 2;
                    if (MediaBrowserCompat.DEBUG && MediaBrowserImplBase.this.mServiceConnection != null) {
                        throw new RuntimeException("mServiceConnection should be null. Instead it is " + MediaBrowserImplBase.this.mServiceConnection);
                    }
                    if (MediaBrowserImplBase.this.mServiceBinderWrapper != null) {
                        throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + MediaBrowserImplBase.this.mServiceBinderWrapper);
                    }
                    if (MediaBrowserImplBase.this.mCallbacksMessenger != null) {
                        throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + MediaBrowserImplBase.this.mCallbacksMessenger);
                    }
                    Intent intent = new Intent("android.media.browse.MediaBrowserService");
                    intent.setComponent(MediaBrowserImplBase.this.mServiceComponent);
                    MediaBrowserImplBase.this.mServiceConnection = new MediaServiceConnection();
                    boolean bound = false;
                    try {
                        bound = MediaBrowserImplBase.this.mContext.bindService(intent, MediaBrowserImplBase.this.mServiceConnection, 1);
                    } catch (Exception e) {
                        Log.e(MediaBrowserCompat.TAG, "Failed binding to service " + MediaBrowserImplBase.this.mServiceComponent);
                    }
                    if (!bound) {
                        MediaBrowserImplBase.this.forceCloseConnection();
                        MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                    }
                    if (MediaBrowserCompat.DEBUG) {
                        Log.d(MediaBrowserCompat.TAG, "connect...");
                        MediaBrowserImplBase.this.dump();
                    }
                }
            });
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            this.mState = 0;
            this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.2
                @Override // java.lang.Runnable
                public void run() {
                    if (MediaBrowserImplBase.this.mCallbacksMessenger != null) {
                        try {
                            MediaBrowserImplBase.this.mServiceBinderWrapper.disconnect(MediaBrowserImplBase.this.mCallbacksMessenger);
                        } catch (RemoteException e) {
                            Log.w(MediaBrowserCompat.TAG, "RemoteException during connect for " + MediaBrowserImplBase.this.mServiceComponent);
                        }
                    }
                    int state = MediaBrowserImplBase.this.mState;
                    MediaBrowserImplBase.this.forceCloseConnection();
                    if (state != 0) {
                        MediaBrowserImplBase.this.mState = state;
                    }
                    if (MediaBrowserCompat.DEBUG) {
                        Log.d(MediaBrowserCompat.TAG, "disconnect...");
                        MediaBrowserImplBase.this.dump();
                    }
                }
            });
        }

        void forceCloseConnection() {
            if (this.mServiceConnection != null) {
                this.mContext.unbindService(this.mServiceConnection);
            }
            this.mState = 1;
            this.mServiceConnection = null;
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger(null);
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return this.mState == 3;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public ComponentName getServiceComponent() {
            if (!isConnected()) {
                throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
            }
            return this.mServiceComponent;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public String getRoot() {
            if (!isConnected()) {
                throw new IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(this.mState) + ")");
            }
            return this.mRootId;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getExtras() {
            if (!isConnected()) {
                throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
            }
            return this.mExtras;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public MediaSessionCompat.Token getSessionToken() {
            if (!isConnected()) {
                throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
            }
            return this.mMediaSessionToken;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(String parentId, Bundle options, SubscriptionCallback callback) {
            Subscription sub = this.mSubscriptions.get(parentId);
            if (sub == null) {
                sub = new Subscription();
                this.mSubscriptions.put(parentId, sub);
            }
            Bundle copiedOptions = options == null ? null : new Bundle(options);
            sub.putCallback(copiedOptions, callback);
            if (isConnected()) {
                try {
                    this.mServiceBinderWrapper.addSubscription(parentId, callback.mToken, copiedOptions, this.mCallbacksMessenger);
                } catch (RemoteException e) {
                    Log.d(MediaBrowserCompat.TAG, "addSubscription failed with RemoteException parentId=" + parentId);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(String parentId, SubscriptionCallback callback) {
            Subscription sub = this.mSubscriptions.get(parentId);
            if (sub == null) {
                return;
            }
            try {
                if (callback == null) {
                    if (isConnected()) {
                        this.mServiceBinderWrapper.removeSubscription(parentId, null, this.mCallbacksMessenger);
                    }
                } else {
                    List<SubscriptionCallback> callbacks = sub.getCallbacks();
                    List<Bundle> optionsList = sub.getOptionsList();
                    for (int i = callbacks.size() - 1; i >= 0; i--) {
                        if (callbacks.get(i) == callback) {
                            if (isConnected()) {
                                this.mServiceBinderWrapper.removeSubscription(parentId, callback.mToken, this.mCallbacksMessenger);
                            }
                            callbacks.remove(i);
                            optionsList.remove(i);
                        }
                    }
                }
            } catch (RemoteException e) {
                Log.d(MediaBrowserCompat.TAG, "removeSubscription failed with RemoteException parentId=" + parentId);
            }
            if (sub.isEmpty() || callback == null) {
                this.mSubscriptions.remove(parentId);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(final String mediaId, final ItemCallback cb) {
            if (TextUtils.isEmpty(mediaId)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (cb == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if (!isConnected()) {
                Log.i(MediaBrowserCompat.TAG, "Not connected, unable to retrieve the MediaItem.");
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.3
                    @Override // java.lang.Runnable
                    public void run() {
                        cb.onError(mediaId);
                    }
                });
                return;
            }
            ResultReceiver receiver = new ItemReceiver(mediaId, cb, this.mHandler);
            try {
                this.mServiceBinderWrapper.getMediaItem(mediaId, receiver, this.mCallbacksMessenger);
            } catch (RemoteException e) {
                Log.i(MediaBrowserCompat.TAG, "Remote error getting media item: " + mediaId);
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.4
                    @Override // java.lang.Runnable
                    public void run() {
                        cb.onError(mediaId);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(final String query, final Bundle extras, final SearchCallback callback) {
            if (!isConnected()) {
                throw new IllegalStateException("search() called while not connected (state=" + getStateLabel(this.mState) + ")");
            }
            ResultReceiver receiver = new SearchResultReceiver(query, extras, callback, this.mHandler);
            try {
                this.mServiceBinderWrapper.search(query, extras, receiver, this.mCallbacksMessenger);
            } catch (RemoteException e) {
                Log.i(MediaBrowserCompat.TAG, "Remote error searching items with query: " + query, e);
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onError(query, extras);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(final String action, final Bundle extras, final CustomActionCallback callback) {
            if (!isConnected()) {
                throw new IllegalStateException("Cannot send a custom action (" + action + ") with extras " + extras + " because the browser is not connected to the service.");
            }
            ResultReceiver receiver = new CustomActionResultReceiver(action, extras, callback, this.mHandler);
            try {
                this.mServiceBinderWrapper.sendCustomAction(action, extras, receiver, this.mCallbacksMessenger);
            } catch (RemoteException e) {
                Log.i(MediaBrowserCompat.TAG, "Remote error sending a custom action: action=" + action + ", extras=" + extras, e);
                if (callback != null) {
                    this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.6
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.onError(action, extras, null);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger callback, String root, MediaSessionCompat.Token session, Bundle extra) {
            if (!isCurrent(callback, "onConnect")) {
                return;
            }
            if (this.mState != 2) {
                Log.w(MediaBrowserCompat.TAG, "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
                return;
            }
            this.mRootId = root;
            this.mMediaSessionToken = session;
            this.mExtras = extra;
            this.mState = 3;
            if (MediaBrowserCompat.DEBUG) {
                Log.d(MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                dump();
            }
            this.mCallback.onConnected();
            try {
                Iterator<Map.Entry<String, Subscription>> it = this.mSubscriptions.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, Subscription> subscriptionEntry = it.next();
                    String id = subscriptionEntry.getKey();
                    Subscription sub = subscriptionEntry.getValue();
                    List<SubscriptionCallback> callbackList = sub.getCallbacks();
                    List<Bundle> optionsList = sub.getOptionsList();
                    int i = 0;
                    while (i < callbackList.size()) {
                        Iterator<Map.Entry<String, Subscription>> it2 = it;
                        this.mServiceBinderWrapper.addSubscription(id, callbackList.get(i).mToken, optionsList.get(i), this.mCallbacksMessenger);
                        i++;
                        it = it2;
                    }
                }
            } catch (RemoteException e) {
                Log.d(MediaBrowserCompat.TAG, "addSubscription failed with RemoteException.");
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger callback) {
            Log.e(MediaBrowserCompat.TAG, "onConnectFailed for " + this.mServiceComponent);
            if (!isCurrent(callback, "onConnectFailed")) {
                return;
            }
            if (this.mState != 2) {
                Log.w(MediaBrowserCompat.TAG, "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
                return;
            }
            forceCloseConnection();
            this.mCallback.onConnectionFailed();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger callback, String parentId, List<MediaItem> list, Bundle options, Bundle notifyChildrenChangedOptions) {
            if (!isCurrent(callback, "onLoadChildren")) {
                return;
            }
            if (MediaBrowserCompat.DEBUG) {
                Log.d(MediaBrowserCompat.TAG, "onLoadChildren for " + this.mServiceComponent + " id=" + parentId);
            }
            Subscription subscription = this.mSubscriptions.get(parentId);
            if (subscription == null) {
                if (MediaBrowserCompat.DEBUG) {
                    Log.d(MediaBrowserCompat.TAG, "onLoadChildren for id that isn't subscribed id=" + parentId);
                    return;
                }
                return;
            }
            SubscriptionCallback subscriptionCallback = subscription.getCallback(options);
            if (subscriptionCallback != null) {
                if (options == null) {
                    if (list == null) {
                        subscriptionCallback.onError(parentId);
                        return;
                    }
                    this.mNotifyChildrenChangedOptions = notifyChildrenChangedOptions;
                    subscriptionCallback.onChildrenLoaded(parentId, list);
                    this.mNotifyChildrenChangedOptions = null;
                } else if (list == null) {
                    subscriptionCallback.onError(parentId, options);
                } else {
                    this.mNotifyChildrenChangedOptions = notifyChildrenChangedOptions;
                    subscriptionCallback.onChildrenLoaded(parentId, list, options);
                    this.mNotifyChildrenChangedOptions = null;
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        private static String getStateLabel(int state) {
            switch (state) {
                case 0:
                    return "CONNECT_STATE_DISCONNECTING";
                case 1:
                    return "CONNECT_STATE_DISCONNECTED";
                case 2:
                    return "CONNECT_STATE_CONNECTING";
                case 3:
                    return "CONNECT_STATE_CONNECTED";
                case 4:
                    return "CONNECT_STATE_SUSPENDED";
                default:
                    return "UNKNOWN/" + state;
            }
        }

        private boolean isCurrent(Messenger callback, String funcName) {
            if (this.mCallbacksMessenger != callback || this.mState == 0 || this.mState == 1) {
                if (this.mState != 0 && this.mState != 1) {
                    Log.i(MediaBrowserCompat.TAG, funcName + " for " + this.mServiceComponent + " with mCallbacksMessenger=" + this.mCallbacksMessenger + " this=" + this);
                    return false;
                }
                return false;
            }
            return true;
        }

        void dump() {
            Log.d(MediaBrowserCompat.TAG, "MediaBrowserCompat...");
            Log.d(MediaBrowserCompat.TAG, "  mServiceComponent=" + this.mServiceComponent);
            Log.d(MediaBrowserCompat.TAG, "  mCallback=" + this.mCallback);
            Log.d(MediaBrowserCompat.TAG, "  mRootHints=" + this.mRootHints);
            Log.d(MediaBrowserCompat.TAG, "  mState=" + getStateLabel(this.mState));
            Log.d(MediaBrowserCompat.TAG, "  mServiceConnection=" + this.mServiceConnection);
            Log.d(MediaBrowserCompat.TAG, "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
            Log.d(MediaBrowserCompat.TAG, "  mCallbacksMessenger=" + this.mCallbacksMessenger);
            Log.d(MediaBrowserCompat.TAG, "  mRootId=" + this.mRootId);
            Log.d(MediaBrowserCompat.TAG, "  mMediaSessionToken=" + this.mMediaSessionToken);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
        public class MediaServiceConnection implements ServiceConnection {
            MediaServiceConnection() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final ComponentName name, final IBinder binder) {
                postOrRun(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            Log.d(MediaBrowserCompat.TAG, "MediaServiceConnection.onServiceConnected name=" + name + " binder=" + binder);
                            MediaBrowserImplBase.this.dump();
                        }
                        if (!MediaServiceConnection.this.isCurrent("onServiceConnected")) {
                            return;
                        }
                        MediaBrowserImplBase.this.mServiceBinderWrapper = new ServiceBinderWrapper(binder, MediaBrowserImplBase.this.mRootHints);
                        MediaBrowserImplBase.this.mCallbacksMessenger = new Messenger(MediaBrowserImplBase.this.mHandler);
                        MediaBrowserImplBase.this.mHandler.setCallbacksMessenger(MediaBrowserImplBase.this.mCallbacksMessenger);
                        MediaBrowserImplBase.this.mState = 2;
                        try {
                            if (MediaBrowserCompat.DEBUG) {
                                Log.d(MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                                MediaBrowserImplBase.this.dump();
                            }
                            MediaBrowserImplBase.this.mServiceBinderWrapper.connect(MediaBrowserImplBase.this.mContext, MediaBrowserImplBase.this.mCallbacksMessenger);
                        } catch (RemoteException e) {
                            Log.w(MediaBrowserCompat.TAG, "RemoteException during connect for " + MediaBrowserImplBase.this.mServiceComponent);
                            if (MediaBrowserCompat.DEBUG) {
                                Log.d(MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                                MediaBrowserImplBase.this.dump();
                            }
                        }
                    }
                });
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final ComponentName name) {
                postOrRun(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            Log.d(MediaBrowserCompat.TAG, "MediaServiceConnection.onServiceDisconnected name=" + name + " this=" + this + " mServiceConnection=" + MediaBrowserImplBase.this.mServiceConnection);
                            MediaBrowserImplBase.this.dump();
                        }
                        if (!MediaServiceConnection.this.isCurrent("onServiceDisconnected")) {
                            return;
                        }
                        MediaBrowserImplBase.this.mServiceBinderWrapper = null;
                        MediaBrowserImplBase.this.mCallbacksMessenger = null;
                        MediaBrowserImplBase.this.mHandler.setCallbacksMessenger(null);
                        MediaBrowserImplBase.this.mState = 4;
                        MediaBrowserImplBase.this.mCallback.onConnectionSuspended();
                    }
                });
            }

            private void postOrRun(Runnable r) {
                if (Thread.currentThread() == MediaBrowserImplBase.this.mHandler.getLooper().getThread()) {
                    r.run();
                } else {
                    MediaBrowserImplBase.this.mHandler.post(r);
                }
            }

            boolean isCurrent(String funcName) {
                if (MediaBrowserImplBase.this.mServiceConnection != this || MediaBrowserImplBase.this.mState == 0 || MediaBrowserImplBase.this.mState == 1) {
                    if (MediaBrowserImplBase.this.mState != 0 && MediaBrowserImplBase.this.mState != 1) {
                        Log.i(MediaBrowserCompat.TAG, funcName + " for " + MediaBrowserImplBase.this.mServiceComponent + " with mServiceConnection=" + MediaBrowserImplBase.this.mServiceConnection + " this=" + this);
                        return false;
                    }
                    return false;
                }
                return true;
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallback.ConnectionCallbackInternal {
        protected final MediaBrowser mBrowserFwk;
        protected Messenger mCallbacksMessenger;
        final Context mContext;
        private MediaSessionCompat.Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        protected final Bundle mRootHints;
        protected ServiceBinderWrapper mServiceBinderWrapper;
        protected int mServiceVersion;
        protected final CallbackHandler mHandler = new CallbackHandler(this);
        private final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap<>();

        MediaBrowserImplApi21(Context context, ComponentName serviceComponent, ConnectionCallback callback, Bundle rootHints) {
            this.mContext = context;
            this.mRootHints = rootHints != null ? new Bundle(rootHints) : new Bundle();
            this.mRootHints.putInt("extra_client_version", 1);
            this.mRootHints.putInt("extra_calling_pid", Process.myPid());
            callback.setInternalConnectionCallback(this);
            this.mBrowserFwk = new MediaBrowser(context, serviceComponent, callback.mConnectionCallbackFwk, this.mRootHints);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            this.mBrowserFwk.connect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            if (this.mServiceBinderWrapper != null && this.mCallbacksMessenger != null) {
                try {
                    this.mServiceBinderWrapper.unregisterCallbackMessenger(this.mCallbacksMessenger);
                } catch (RemoteException e) {
                    Log.i(MediaBrowserCompat.TAG, "Remote error unregistering client messenger.");
                }
            }
            this.mBrowserFwk.disconnect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return this.mBrowserFwk.isConnected();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public ComponentName getServiceComponent() {
            return this.mBrowserFwk.getServiceComponent();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public String getRoot() {
            return this.mBrowserFwk.getRoot();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getExtras() {
            return this.mBrowserFwk.getExtras();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public MediaSessionCompat.Token getSessionToken() {
            if (this.mMediaSessionToken == null) {
                this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(this.mBrowserFwk.getSessionToken());
            }
            return this.mMediaSessionToken;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(String parentId, Bundle options, SubscriptionCallback callback) {
            Subscription sub = this.mSubscriptions.get(parentId);
            if (sub == null) {
                sub = new Subscription();
                this.mSubscriptions.put(parentId, sub);
            }
            callback.setSubscription(sub);
            Bundle copiedOptions = options == null ? null : new Bundle(options);
            sub.putCallback(copiedOptions, callback);
            if (this.mServiceBinderWrapper == null) {
                this.mBrowserFwk.subscribe(parentId, callback.mSubscriptionCallbackFwk);
                return;
            }
            try {
                this.mServiceBinderWrapper.addSubscription(parentId, callback.mToken, copiedOptions, this.mCallbacksMessenger);
            } catch (RemoteException e) {
                Log.i(MediaBrowserCompat.TAG, "Remote error subscribing media item: " + parentId);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(String parentId, SubscriptionCallback callback) {
            Subscription sub = this.mSubscriptions.get(parentId);
            if (sub == null) {
                return;
            }
            if (this.mServiceBinderWrapper == null) {
                if (callback == null) {
                    this.mBrowserFwk.unsubscribe(parentId);
                } else {
                    List<SubscriptionCallback> callbacks = sub.getCallbacks();
                    List<Bundle> optionsList = sub.getOptionsList();
                    for (int i = callbacks.size() - 1; i >= 0; i--) {
                        if (callbacks.get(i) == callback) {
                            callbacks.remove(i);
                            optionsList.remove(i);
                        }
                    }
                    int i2 = callbacks.size();
                    if (i2 == 0) {
                        this.mBrowserFwk.unsubscribe(parentId);
                    }
                }
            } else {
                try {
                    if (callback == null) {
                        this.mServiceBinderWrapper.removeSubscription(parentId, null, this.mCallbacksMessenger);
                    } else {
                        List<SubscriptionCallback> callbacks2 = sub.getCallbacks();
                        List<Bundle> optionsList2 = sub.getOptionsList();
                        for (int i3 = callbacks2.size() - 1; i3 >= 0; i3--) {
                            if (callbacks2.get(i3) == callback) {
                                this.mServiceBinderWrapper.removeSubscription(parentId, callback.mToken, this.mCallbacksMessenger);
                                callbacks2.remove(i3);
                                optionsList2.remove(i3);
                            }
                        }
                    }
                } catch (RemoteException e) {
                    Log.d(MediaBrowserCompat.TAG, "removeSubscription failed with RemoteException parentId=" + parentId);
                }
            }
            if (sub.isEmpty() || callback == null) {
                this.mSubscriptions.remove(parentId);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(final String mediaId, final ItemCallback cb) {
            if (TextUtils.isEmpty(mediaId)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (cb == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if (!this.mBrowserFwk.isConnected()) {
                Log.i(MediaBrowserCompat.TAG, "Not connected, unable to retrieve the MediaItem.");
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        cb.onError(mediaId);
                    }
                });
            } else if (this.mServiceBinderWrapper == null) {
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.2
                    @Override // java.lang.Runnable
                    public void run() {
                        cb.onError(mediaId);
                    }
                });
            } else {
                ResultReceiver receiver = new ItemReceiver(mediaId, cb, this.mHandler);
                try {
                    this.mServiceBinderWrapper.getMediaItem(mediaId, receiver, this.mCallbacksMessenger);
                } catch (RemoteException e) {
                    Log.i(MediaBrowserCompat.TAG, "Remote error getting media item: " + mediaId);
                    this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.3
                        @Override // java.lang.Runnable
                        public void run() {
                            cb.onError(mediaId);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(final String query, final Bundle extras, final SearchCallback callback) {
            if (!isConnected()) {
                throw new IllegalStateException("search() called while not connected");
            }
            if (this.mServiceBinderWrapper == null) {
                Log.i(MediaBrowserCompat.TAG, "The connected service doesn't support search.");
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.4
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onError(query, extras);
                    }
                });
                return;
            }
            ResultReceiver receiver = new SearchResultReceiver(query, extras, callback, this.mHandler);
            try {
                this.mServiceBinderWrapper.search(query, extras, receiver, this.mCallbacksMessenger);
            } catch (RemoteException e) {
                Log.i(MediaBrowserCompat.TAG, "Remote error searching items with query: " + query, e);
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.5
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onError(query, extras);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(final String action, final Bundle extras, final CustomActionCallback callback) {
            if (!isConnected()) {
                throw new IllegalStateException("Cannot send a custom action (" + action + ") with extras " + extras + " because the browser is not connected to the service.");
            }
            if (this.mServiceBinderWrapper == null) {
                Log.i(MediaBrowserCompat.TAG, "The connected service doesn't support sendCustomAction.");
                if (callback != null) {
                    this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.6
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.onError(action, extras, null);
                        }
                    });
                }
            }
            ResultReceiver receiver = new CustomActionResultReceiver(action, extras, callback, this.mHandler);
            try {
                this.mServiceBinderWrapper.sendCustomAction(action, extras, receiver, this.mCallbacksMessenger);
            } catch (RemoteException e) {
                Log.i(MediaBrowserCompat.TAG, "Remote error sending a custom action: action=" + action + ", extras=" + extras, e);
                if (callback != null) {
                    this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.7
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.onError(action, extras, null);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnected() {
            try {
                Bundle extras = this.mBrowserFwk.getExtras();
                if (extras == null) {
                    return;
                }
                this.mServiceVersion = extras.getInt("extra_service_version", 0);
                IBinder serviceBinder = BundleCompat.getBinder(extras, "extra_messenger");
                if (serviceBinder != null) {
                    this.mServiceBinderWrapper = new ServiceBinderWrapper(serviceBinder, this.mRootHints);
                    this.mCallbacksMessenger = new Messenger(this.mHandler);
                    this.mHandler.setCallbacksMessenger(this.mCallbacksMessenger);
                    try {
                        this.mServiceBinderWrapper.registerCallbackMessenger(this.mContext, this.mCallbacksMessenger);
                    } catch (RemoteException e) {
                        Log.i(MediaBrowserCompat.TAG, "Remote error registering client messenger.");
                    }
                }
                IMediaSession sessionToken = IMediaSession.Stub.asInterface(BundleCompat.getBinder(extras, "extra_session_binder"));
                if (sessionToken != null) {
                    this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(this.mBrowserFwk.getSessionToken(), sessionToken);
                }
            } catch (IllegalStateException e2) {
                Log.e(MediaBrowserCompat.TAG, "Unexpected IllegalStateException", e2);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mMediaSessionToken = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionFailed() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger callback, String root, MediaSessionCompat.Token session, Bundle extra) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger callback) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger callback, String parentId, List<MediaItem> list, Bundle options, Bundle notifyChildrenChangedOptions) {
            if (this.mCallbacksMessenger != callback) {
                return;
            }
            Subscription subscription = this.mSubscriptions.get(parentId);
            if (subscription == null) {
                if (MediaBrowserCompat.DEBUG) {
                    Log.d(MediaBrowserCompat.TAG, "onLoadChildren for id that isn't subscribed id=" + parentId);
                    return;
                }
                return;
            }
            SubscriptionCallback subscriptionCallback = subscription.getCallback(options);
            if (subscriptionCallback != null) {
                if (options == null) {
                    if (list == null) {
                        subscriptionCallback.onError(parentId);
                        return;
                    }
                    this.mNotifyChildrenChangedOptions = notifyChildrenChangedOptions;
                    subscriptionCallback.onChildrenLoaded(parentId, list);
                    this.mNotifyChildrenChangedOptions = null;
                } else if (list == null) {
                    subscriptionCallback.onError(parentId, options);
                } else {
                    this.mNotifyChildrenChangedOptions = notifyChildrenChangedOptions;
                    subscriptionCallback.onChildrenLoaded(parentId, list, options);
                    this.mNotifyChildrenChangedOptions = null;
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        MediaBrowserImplApi23(Context context, ComponentName serviceComponent, ConnectionCallback callback, Bundle rootHints) {
            super(context, serviceComponent, callback, rootHints);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(String mediaId, ItemCallback cb) {
            if (this.mServiceBinderWrapper == null) {
                this.mBrowserFwk.getItem(mediaId, cb.mItemCallbackFwk);
            } else {
                super.getItem(mediaId, cb);
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        MediaBrowserImplApi26(Context context, ComponentName serviceComponent, ConnectionCallback callback, Bundle rootHints) {
            super(context, serviceComponent, callback, rootHints);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(String parentId, Bundle options, SubscriptionCallback callback) {
            if (this.mServiceBinderWrapper == null || this.mServiceVersion < 2) {
                if (options == null) {
                    this.mBrowserFwk.subscribe(parentId, callback.mSubscriptionCallbackFwk);
                    return;
                } else {
                    this.mBrowserFwk.subscribe(parentId, options, callback.mSubscriptionCallbackFwk);
                    return;
                }
            }
            super.subscribe(parentId, options, callback);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(String parentId, SubscriptionCallback callback) {
            if (this.mServiceBinderWrapper == null || this.mServiceVersion < 2) {
                if (callback == null) {
                    this.mBrowserFwk.unsubscribe(parentId);
                    return;
                } else {
                    this.mBrowserFwk.unsubscribe(parentId, callback.mSubscriptionCallbackFwk);
                    return;
                }
            }
            super.unsubscribe(parentId, callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static class Subscription {
        private final List<SubscriptionCallback> mCallbacks = new ArrayList();
        private final List<Bundle> mOptionsList = new ArrayList();

        public boolean isEmpty() {
            return this.mCallbacks.isEmpty();
        }

        public List<Bundle> getOptionsList() {
            return this.mOptionsList;
        }

        public List<SubscriptionCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public SubscriptionCallback getCallback(Bundle options) {
            for (int i = 0; i < this.mOptionsList.size(); i++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(i), options)) {
                    return this.mCallbacks.get(i);
                }
            }
            return null;
        }

        public void putCallback(Bundle options, SubscriptionCallback callback) {
            for (int i = 0; i < this.mOptionsList.size(); i++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(i), options)) {
                    this.mCallbacks.set(i, callback);
                    return;
                }
            }
            this.mCallbacks.add(callback);
            this.mOptionsList.add(options);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static class CallbackHandler extends Handler {
        private final WeakReference<MediaBrowserServiceCallbackImpl> mCallbackImplRef;
        private WeakReference<Messenger> mCallbacksMessengerRef;

        CallbackHandler(MediaBrowserServiceCallbackImpl callbackImpl) {
            this.mCallbackImplRef = new WeakReference<>(callbackImpl);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (this.mCallbacksMessengerRef == null || this.mCallbacksMessengerRef.get() == null || this.mCallbackImplRef.get() == null) {
                return;
            }
            Bundle data = msg.getData();
            MediaSessionCompat.ensureClassLoader(data);
            MediaBrowserServiceCallbackImpl serviceCallback = this.mCallbackImplRef.get();
            Messenger callbacksMessenger = this.mCallbacksMessengerRef.get();
            try {
                switch (msg.what) {
                    case 1:
                        Bundle rootHints = data.getBundle("data_root_hints");
                        MediaSessionCompat.ensureClassLoader(rootHints);
                        serviceCallback.onServiceConnected(callbacksMessenger, data.getString("data_media_item_id"), (MediaSessionCompat.Token) data.getParcelable("data_media_session_token"), rootHints);
                        break;
                    case 2:
                        serviceCallback.onConnectionFailed(callbacksMessenger);
                        break;
                    case 3:
                        Bundle options = data.getBundle("data_options");
                        MediaSessionCompat.ensureClassLoader(options);
                        Bundle notifyChildrenChangedOptions = data.getBundle("data_notify_children_changed_options");
                        MediaSessionCompat.ensureClassLoader(notifyChildrenChangedOptions);
                        serviceCallback.onLoadChildren(callbacksMessenger, data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), options, notifyChildrenChangedOptions);
                        break;
                    default:
                        Log.w(MediaBrowserCompat.TAG, "Unhandled message: " + msg + "\n  Client version: 1\n  Service version: " + msg.arg1);
                        break;
                }
            } catch (BadParcelableException e) {
                Log.e(MediaBrowserCompat.TAG, "Could not unparcel the data.");
                if (msg.what == 1) {
                    serviceCallback.onConnectionFailed(callbacksMessenger);
                }
            }
        }

        void setCallbacksMessenger(Messenger callbacksMessenger) {
            this.mCallbacksMessengerRef = new WeakReference<>(callbacksMessenger);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static class ServiceBinderWrapper {
        private Messenger mMessenger;
        private Bundle mRootHints;

        public ServiceBinderWrapper(IBinder target, Bundle rootHints) {
            this.mMessenger = new Messenger(target);
            this.mRootHints = rootHints;
        }

        void connect(Context context, Messenger callbacksMessenger) throws RemoteException {
            Bundle data = new Bundle();
            data.putString("data_package_name", context.getPackageName());
            data.putInt("data_calling_pid", Process.myPid());
            data.putBundle("data_root_hints", this.mRootHints);
            sendRequest(1, data, callbacksMessenger);
        }

        void disconnect(Messenger callbacksMessenger) throws RemoteException {
            sendRequest(2, null, callbacksMessenger);
        }

        void addSubscription(String parentId, IBinder callbackToken, Bundle options, Messenger callbacksMessenger) throws RemoteException {
            Bundle data = new Bundle();
            data.putString("data_media_item_id", parentId);
            BundleCompat.putBinder(data, "data_callback_token", callbackToken);
            data.putBundle("data_options", options);
            sendRequest(3, data, callbacksMessenger);
        }

        void removeSubscription(String parentId, IBinder callbackToken, Messenger callbacksMessenger) throws RemoteException {
            Bundle data = new Bundle();
            data.putString("data_media_item_id", parentId);
            BundleCompat.putBinder(data, "data_callback_token", callbackToken);
            sendRequest(4, data, callbacksMessenger);
        }

        void getMediaItem(String mediaId, ResultReceiver receiver, Messenger callbacksMessenger) throws RemoteException {
            Bundle data = new Bundle();
            data.putString("data_media_item_id", mediaId);
            data.putParcelable("data_result_receiver", receiver);
            sendRequest(5, data, callbacksMessenger);
        }

        void registerCallbackMessenger(Context context, Messenger callbackMessenger) throws RemoteException {
            Bundle data = new Bundle();
            data.putString("data_package_name", context.getPackageName());
            data.putInt("data_calling_pid", Process.myPid());
            data.putBundle("data_root_hints", this.mRootHints);
            sendRequest(6, data, callbackMessenger);
        }

        void unregisterCallbackMessenger(Messenger callbackMessenger) throws RemoteException {
            sendRequest(7, null, callbackMessenger);
        }

        void search(String query, Bundle extras, ResultReceiver receiver, Messenger callbacksMessenger) throws RemoteException {
            Bundle data = new Bundle();
            data.putString("data_search_query", query);
            data.putBundle("data_search_extras", extras);
            data.putParcelable("data_result_receiver", receiver);
            sendRequest(8, data, callbacksMessenger);
        }

        void sendCustomAction(String action, Bundle extras, ResultReceiver receiver, Messenger callbacksMessenger) throws RemoteException {
            Bundle data = new Bundle();
            data.putString("data_custom_action", action);
            data.putBundle("data_custom_action_extras", extras);
            data.putParcelable("data_result_receiver", receiver);
            sendRequest(9, data, callbacksMessenger);
        }

        private void sendRequest(int what, Bundle data, Messenger cbMessenger) throws RemoteException {
            Message msg = Message.obtain();
            msg.what = what;
            msg.arg1 = 1;
            msg.setData(data);
            msg.replyTo = cbMessenger;
            this.mMessenger.send(msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static class ItemReceiver extends ResultReceiver {
        private final ItemCallback mCallback;
        private final String mMediaId;

        ItemReceiver(String mediaId, ItemCallback callback, Handler handler) {
            super(handler);
            this.mMediaId = mediaId;
            this.mCallback = callback;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            if (resultData != null) {
                resultData = MediaSessionCompat.unparcelWithClassLoader(resultData);
            }
            if (resultCode != 0 || resultData == null || !resultData.containsKey("media_item")) {
                this.mCallback.onError(this.mMediaId);
                return;
            }
            Parcelable item = resultData.getParcelable("media_item");
            if (item == null || (item instanceof MediaItem)) {
                this.mCallback.onItemLoaded((MediaItem) item);
            } else {
                this.mCallback.onError(this.mMediaId);
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    private static class SearchResultReceiver extends ResultReceiver {
        private final SearchCallback mCallback;
        private final Bundle mExtras;
        private final String mQuery;

        SearchResultReceiver(String query, Bundle extras, SearchCallback callback, Handler handler) {
            super(handler);
            this.mQuery = query;
            this.mExtras = extras;
            this.mCallback = callback;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            if (resultData != null) {
                resultData = MediaSessionCompat.unparcelWithClassLoader(resultData);
            }
            if (resultCode != 0 || resultData == null || !resultData.containsKey("search_results")) {
                this.mCallback.onError(this.mQuery, this.mExtras);
                return;
            }
            Parcelable[] items = resultData.getParcelableArray("search_results");
            if (items != null) {
                List<MediaItem> results = new ArrayList<>(items.length);
                for (Parcelable item : items) {
                    results.add((MediaItem) item);
                }
                this.mCallback.onSearchResult(this.mQuery, this.mExtras, results);
                return;
            }
            this.mCallback.onError(this.mQuery, this.mExtras);
        }
    }

    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    private static class CustomActionResultReceiver extends ResultReceiver {
        private final String mAction;
        private final CustomActionCallback mCallback;
        private final Bundle mExtras;

        CustomActionResultReceiver(String action, Bundle extras, CustomActionCallback callback, Handler handler) {
            super(handler);
            this.mAction = action;
            this.mExtras = extras;
            this.mCallback = callback;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            if (this.mCallback == null) {
                return;
            }
            MediaSessionCompat.ensureClassLoader(resultData);
            switch (resultCode) {
                case -1:
                    this.mCallback.onError(this.mAction, this.mExtras, resultData);
                    return;
                case 0:
                    this.mCallback.onResult(this.mAction, this.mExtras, resultData);
                    return;
                case 1:
                    this.mCallback.onProgressUpdate(this.mAction, this.mExtras, resultData);
                    return;
                default:
                    Log.w(MediaBrowserCompat.TAG, "Unknown result code: " + resultCode + " (extras=" + this.mExtras + ", resultData=" + resultData + ")");
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static MediaDescription getDescription(MediaBrowser.MediaItem item) {
            return item.getDescription();
        }

        static int getFlags(MediaBrowser.MediaItem item) {
            return item.getFlags();
        }
    }
}