package tv.danmaku.bili.ui.player.notification;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bilibili.droid.thread.HandlerThreads;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MediaSessionCompatWrapper.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/player/notification/MediaSessionCompatWrapper;", "Landroid/support/v4/media/session/MediaSessionCompat;", "context", "Landroid/content/Context;", "tag", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "mbrComponent", "Landroid/content/ComponentName;", "mbrIntent", "Landroid/app/PendingIntent;", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/ComponentName;Landroid/app/PendingIntent;)V", "mPendingPlaybackStateCompat", "Landroid/support/v4/media/session/PlaybackStateCompat;", "mUpdatePlaybackStateCompatRunnable", "Ljava/lang/Runnable;", "mPendingMetadataCompat", "Landroid/support/v4/media/MediaMetadataCompat;", "mUpdateMetadataCompatRunnable", "setMetadata", "", "metadata", "setPlaybackState", "state", "release", "Companion", "music-service_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MediaSessionCompatWrapper extends MediaSessionCompat {
    public static final Companion Companion = new Companion(null);
    private static final long PENDING_METADATA_DELAY_MILLIS = 200;
    private static final long PENDING_STATE_DELAY_MILLIS = 200;
    private static final String TAG = "MediaSessionCompatWrapper";
    private MediaMetadataCompat mPendingMetadataCompat;
    private PlaybackStateCompat mPendingPlaybackStateCompat;
    private final Runnable mUpdateMetadataCompatRunnable;
    private final Runnable mUpdatePlaybackStateCompatRunnable;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mUpdatePlaybackStateCompatRunnable$lambda$0(MediaSessionCompatWrapper this$0) {
        if (this$0.mPendingPlaybackStateCompat == null) {
            return;
        }
        super.setPlaybackState(this$0.mPendingPlaybackStateCompat);
        BLog.i(TAG, "update playbackState: " + this$0.mPendingPlaybackStateCompat);
        this$0.mPendingPlaybackStateCompat = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mUpdateMetadataCompatRunnable$lambda$0(MediaSessionCompatWrapper this$0) {
        if (this$0.mPendingMetadataCompat == null) {
            return;
        }
        super.setMetadata(this$0.mPendingMetadataCompat);
        BLog.i(TAG, "update metadata: " + this$0.mPendingMetadataCompat);
        this$0.mPendingMetadataCompat = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaSessionCompatWrapper(Context context, String tag) {
        super(context, tag);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.mUpdatePlaybackStateCompatRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.player.notification.MediaSessionCompatWrapper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionCompatWrapper.mUpdatePlaybackStateCompatRunnable$lambda$0(MediaSessionCompatWrapper.this);
            }
        };
        this.mUpdateMetadataCompatRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.player.notification.MediaSessionCompatWrapper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionCompatWrapper.mUpdateMetadataCompatRunnable$lambda$0(MediaSessionCompatWrapper.this);
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaSessionCompatWrapper(Context context, String tag, ComponentName mbrComponent, PendingIntent mbrIntent) {
        super(context, tag, mbrComponent, mbrIntent);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.mUpdatePlaybackStateCompatRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.player.notification.MediaSessionCompatWrapper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionCompatWrapper.mUpdatePlaybackStateCompatRunnable$lambda$0(MediaSessionCompatWrapper.this);
            }
        };
        this.mUpdateMetadataCompatRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.player.notification.MediaSessionCompatWrapper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionCompatWrapper.mUpdateMetadataCompatRunnable$lambda$0(MediaSessionCompatWrapper.this);
            }
        };
    }

    public void setMetadata(MediaMetadataCompat metadata) {
        if (metadata == null) {
            return;
        }
        if (this.mPendingMetadataCompat != null) {
            HandlerThreads.remove(0, this.mUpdateMetadataCompatRunnable);
        }
        this.mPendingMetadataCompat = metadata;
        HandlerThreads.postDelayed(0, this.mUpdateMetadataCompatRunnable, 200L);
    }

    public void setPlaybackState(PlaybackStateCompat state) {
        if (state == null) {
            return;
        }
        if (this.mPendingPlaybackStateCompat != null) {
            HandlerThreads.remove(0, this.mUpdatePlaybackStateCompatRunnable);
        }
        this.mPendingPlaybackStateCompat = state;
        HandlerThreads.postDelayed(0, this.mUpdatePlaybackStateCompatRunnable, 200L);
    }

    public void release() {
        this.mPendingMetadataCompat = null;
        this.mPendingPlaybackStateCompat = null;
        HandlerThreads.remove(0, this.mUpdatePlaybackStateCompatRunnable);
        HandlerThreads.remove(0, this.mUpdateMetadataCompatRunnable);
        super.release();
    }

    /* compiled from: MediaSessionCompatWrapper.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/player/notification/MediaSessionCompatWrapper$Companion;", "", "<init>", "()V", "TAG", "", "PENDING_STATE_DELAY_MILLIS", "", "PENDING_METADATA_DELAY_MILLIS", "music-service_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}