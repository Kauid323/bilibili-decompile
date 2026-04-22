package tv.danmaku.bili.ui.player.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.media.app.NotificationCompat;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.RomUtils;
import com.bilibili.infra.base.aop.PendingIntentCreateHook;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.notification.NotificationChannelHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.ui.player.R;
import tv.danmaku.bili.ui.player.data.NotificationStyle;
import tv.danmaku.bili.ui.player.notification.MusicCoverImageCache;
import tv.danmaku.bili.ui.player.utils.BitmapUtil;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.log.PlayerLogModule;

/* compiled from: BgmscNotificatioBuilderHelper.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 >2\u00020\u0001:\u0001>B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0014\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0003J\u0014\u0010$\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0014\u0010%\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010&\u001a\u00020'H\u0002J\n\u0010(\u001a\u0004\u0018\u00010\rH\u0002J\n\u0010)\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u0012\u0010.\u001a\u00020+2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\n\u00101\u001a\u0004\u0018\u000102H\u0002J\n\u00103\u001a\u0004\u0018\u000104H\u0002J\b\u00105\u001a\u00020'H\u0002J\b\u00106\u001a\u000207H\u0002J,\u00108\u001a\u00020+2\f\u00109\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\f\u0010:\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\b\u0010;\u001a\u0004\u0018\u00010\u001bJ\f\u0010<\u001a\u000207*\u000204H\u0002J\f\u0010=\u001a\u000207*\u000204H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Ltv/danmaku/bili/ui/player/notification/BgmscNotificatioBuilderHelper;", "", "context", "Landroid/content/Context;", "session", "Landroid/support/v4/media/session/MediaSessionCompat;", "callback", "Ltv/danmaku/bili/ui/player/notification/MusicNotificationCallback;", "musicNotificationManager", "Ltv/danmaku/bili/ui/player/notification/MusicNotificationManager;", "<init>", "(Landroid/content/Context;Landroid/support/v4/media/session/MediaSessionCompat;Ltv/danmaku/bili/ui/player/notification/MusicNotificationCallback;Ltv/danmaku/bili/ui/player/notification/MusicNotificationManager;)V", "mPauseIntent", "Landroid/app/PendingIntent;", "mPlayIntent", "mPrevIntent", "mNextIntent", "mStopIntent", "mModeIntent", "mFastForwardIntent", "mRewindIntent", "mLikeIntent", "mUnlikeIntent", "mDeleteIntent", "mBindedActivityClass", "Ljava/lang/Class;", "mBindedIntent", "Landroid/content/Intent;", "mMainActivityClass", "notificationStyle", "Ltv/danmaku/bili/ui/player/data/NotificationStyle;", "buildNotification", "Landroid/app/Notification;", "bmp", "Landroid/graphics/Bitmap;", "buildJBNotification", "buildMediaStyleNotification", "buildNewJBNotification", "createModeIcon", "", "createContentIntent", "getCoverBitmap", "setNotificationPlaybackState", "", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "fetchBitmapFromURLAsync", "imageUri", "", "getMetadata", "Landroid/support/v4/media/MediaMetadataCompat;", "getPlaybackState", "Landroid/support/v4/media/session/PlaybackStateCompat;", "getPlayMode", "isModeEnable", "", "bindData", "clazz", "mainActivityClass", "intent", "supportFastForward", "supportRewind", "Companion", "music-service_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BgmscNotificatioBuilderHelper {
    private final MusicNotificationCallback callback;
    private final Context context;
    private Class<?> mBindedActivityClass;
    private Intent mBindedIntent;
    private final PendingIntent mDeleteIntent;
    private final PendingIntent mFastForwardIntent;
    private final PendingIntent mLikeIntent;
    private Class<?> mMainActivityClass;
    private final PendingIntent mModeIntent;
    private final PendingIntent mNextIntent;
    private final PendingIntent mPauseIntent;
    private final PendingIntent mPlayIntent;
    private final PendingIntent mPrevIntent;
    private final PendingIntent mRewindIntent;
    private final PendingIntent mStopIntent;
    private final PendingIntent mUnlikeIntent;
    private final MusicNotificationManager musicNotificationManager;
    private NotificationStyle notificationStyle;
    private final MediaSessionCompat session;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<Boolean> hitSystemMediaControl$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.player.notification.BgmscNotificatioBuilderHelper$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean hitSystemMediaControl_delegate$lambda$0;
            hitSystemMediaControl_delegate$lambda$0 = BgmscNotificatioBuilderHelper.hitSystemMediaControl_delegate$lambda$0();
            return Boolean.valueOf(hitSystemMediaControl_delegate$lambda$0);
        }
    });
    private static final Lazy<Boolean> disableSystemMediaControlOnHarmony$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.player.notification.BgmscNotificatioBuilderHelper$$ExternalSyntheticLambda1
        public final Object invoke() {
            boolean disableSystemMediaControlOnHarmony_delegate$lambda$0;
            disableSystemMediaControlOnHarmony_delegate$lambda$0 = BgmscNotificatioBuilderHelper.disableSystemMediaControlOnHarmony_delegate$lambda$0();
            return Boolean.valueOf(disableSystemMediaControlOnHarmony_delegate$lambda$0);
        }
    });
    private static final Lazy<Boolean> keepNotificationWhilePlaying$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.player.notification.BgmscNotificatioBuilderHelper$$ExternalSyntheticLambda2
        public final Object invoke() {
            boolean keepNotificationWhilePlaying_delegate$lambda$0;
            keepNotificationWhilePlaying_delegate$lambda$0 = BgmscNotificatioBuilderHelper.keepNotificationWhilePlaying_delegate$lambda$0();
            return Boolean.valueOf(keepNotificationWhilePlaying_delegate$lambda$0);
        }
    });

    private static PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity(Context context, int requestCode, Intent intent, int flags) {
        PendingIntentCreateHook.setPackageIfAbsent(context, intent, flags);
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
            } catch (IllegalArgumentException e) {
                return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(33554432 | flags).intValue());
            }
        }
        return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
    }

    public BgmscNotificatioBuilderHelper(Context context, MediaSessionCompat session, MusicNotificationCallback callback, MusicNotificationManager musicNotificationManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(musicNotificationManager, "musicNotificationManager");
        this.context = context;
        this.session = session;
        this.callback = callback;
        this.musicNotificationManager = musicNotificationManager;
        String pkg = this.context.getPackageName();
        PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(this.context, MusicNotificationManager.REQUEST_CODE, new Intent(MusicNotificationManager.ACTION_PAUSE).setPackage(pkg), 335544320);
        Intrinsics.checkNotNullExpressionValue(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast, "getBroadcast(...)");
        this.mPauseIntent = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast;
        PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast2 = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(this.context, MusicNotificationManager.REQUEST_CODE, new Intent(MusicNotificationManager.ACTION_PLAY).setPackage(pkg), 335544320);
        Intrinsics.checkNotNullExpressionValue(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast2, "getBroadcast(...)");
        this.mPlayIntent = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast2;
        PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast3 = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(this.context, MusicNotificationManager.REQUEST_CODE, new Intent(MusicNotificationManager.ACTION_PREV).setPackage(pkg), 335544320);
        Intrinsics.checkNotNullExpressionValue(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast3, "getBroadcast(...)");
        this.mPrevIntent = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast3;
        PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast4 = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(this.context, MusicNotificationManager.REQUEST_CODE, new Intent(MusicNotificationManager.ACTION_NEXT).setPackage(pkg), 335544320);
        Intrinsics.checkNotNullExpressionValue(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast4, "getBroadcast(...)");
        this.mNextIntent = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast4;
        PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast5 = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(this.context, MusicNotificationManager.REQUEST_CODE, new Intent(MusicNotificationManager.ACTION_STOP).setPackage(pkg), 335544320);
        Intrinsics.checkNotNullExpressionValue(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast5, "getBroadcast(...)");
        this.mStopIntent = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast5;
        PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast6 = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(this.context, MusicNotificationManager.REQUEST_CODE, new Intent(MusicNotificationManager.ACTION_TOGGLE_MODE).setPackage(pkg), 335544320);
        Intrinsics.checkNotNullExpressionValue(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast6, "getBroadcast(...)");
        this.mModeIntent = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast6;
        PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast7 = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(this.context, MusicNotificationManager.REQUEST_CODE, new Intent(MusicNotificationManager.ACTION_FAST_FORWARD).setPackage(pkg), 335544320);
        Intrinsics.checkNotNullExpressionValue(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast7, "getBroadcast(...)");
        this.mFastForwardIntent = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast7;
        PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast8 = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(this.context, MusicNotificationManager.REQUEST_CODE, new Intent(MusicNotificationManager.ACTION_REWIND).setPackage(pkg), 335544320);
        Intrinsics.checkNotNullExpressionValue(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast8, "getBroadcast(...)");
        this.mRewindIntent = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast8;
        PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast9 = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(this.context, MusicNotificationManager.REQUEST_CODE, new Intent(MusicNotificationManager.ACTION_LIKE).setPackage(pkg), 335544320);
        Intrinsics.checkNotNullExpressionValue(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast9, "getBroadcast(...)");
        this.mLikeIntent = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast9;
        PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast10 = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(this.context, MusicNotificationManager.REQUEST_CODE, new Intent(MusicNotificationManager.ACTION_UNLIKE).setPackage(pkg), 335544320);
        Intrinsics.checkNotNullExpressionValue(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast10, "getBroadcast(...)");
        this.mUnlikeIntent = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast10;
        PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast11 = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(this.context, MusicNotificationManager.REQUEST_CODE, new Intent(MusicNotificationManager.ACTION_DELETE).setPackage(pkg), 335544320);
        Intrinsics.checkNotNullExpressionValue(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast11, "getBroadcast(...)");
        this.mDeleteIntent = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast11;
    }

    private static PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivities(Context context, int requestCode, Intent[] intents, int flags) {
        for (Intent intent : intents) {
            PendingIntentCreateHook.setPackageIfAbsent(context, intent, flags);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                return PendingIntent.getActivities(context, Integer.valueOf(requestCode).intValue(), intents, Integer.valueOf(flags).intValue());
            } catch (IllegalArgumentException e) {
                return PendingIntent.getActivities(context, Integer.valueOf(requestCode).intValue(), intents, Integer.valueOf(33554432 | flags).intValue());
            }
        }
        return PendingIntent.getActivities(context, Integer.valueOf(requestCode).intValue(), intents, Integer.valueOf(flags).intValue());
    }

    public final Notification buildNotification() {
        return buildNotification(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Notification buildNotification(Bitmap bmp) {
        this.notificationStyle = this.callback.getNotificationStyle();
        NotificationStyle notificationStyle = this.notificationStyle;
        Integer notificationType = notificationStyle != null ? Integer.valueOf(notificationStyle.notificationType) : null;
        if (notificationType == null || notificationType.intValue() != 1) {
            PlayerLog.i(PlayerLogModule.BackgroundPlay, "build notification JB");
            return buildJBNotification(bmp);
        } else if (Companion.enableMediaControls()) {
            PlayerLog.i(PlayerLogModule.BackgroundPlay, "build notification media controls");
            return buildMediaStyleNotification(bmp);
        } else {
            PlayerLog.i(PlayerLogModule.BackgroundPlay, "build notification new JB");
            return buildNewJBNotification(bmp);
        }
    }

    private final Notification buildJBNotification(Bitmap bmp) {
        int icon;
        PendingIntent intent;
        PlaybackStateCompat playbackState = getPlaybackState();
        MediaMetadataCompat metadata = getMetadata();
        if (metadata == null || playbackState == null || this.notificationStyle == null) {
            return null;
        }
        try {
            MediaDescriptionCompat desc = metadata.getDescription();
            Intrinsics.checkNotNull(desc);
            RemoteViews collapseRv = new RemoteViews(this.context.getPackageName(), R.layout.notification_custom_collapse_layout);
            RemoteViews expRv = new RemoteViews(this.context.getPackageName(), R.layout.notification_custom_expanded_layout);
            NotificationStyle notificationStyle = this.notificationStyle;
            Intrinsics.checkNotNull(notificationStyle);
            int mNotificationColor = notificationStyle.backgroundColor;
            Bitmap themeColorBmp = BitmapUtil.createBitmapFromColor(5, 5, mNotificationColor);
            collapseRv.setImageViewBitmap(R.id.notification_background, themeColorBmp);
            expRv.setImageViewBitmap(R.id.notification_background, themeColorBmp);
            expRv.setTextViewText(R.id.notification_text1, desc.getTitle());
            expRv.setTextViewText(R.id.notification_text2, desc.getSubtitle());
            collapseRv.setTextViewText(R.id.notification_text1, desc.getTitle());
            collapseRv.setTextViewText(R.id.notification_text2, desc.getSubtitle());
            if (isModeEnable()) {
                expRv.setViewVisibility(R.id.notification_action1, 0);
                expRv.setImageViewResource(R.id.notification_action1, createModeIcon());
                NotificationStyle notificationStyle2 = this.notificationStyle;
                Intrinsics.checkNotNull(notificationStyle2);
                if (!notificationStyle2.isFixedPlayMode) {
                    expRv.setOnClickPendingIntent(R.id.notification_action1, this.mModeIntent);
                }
            }
            if ((playbackState.getActions() & 16) != 0) {
                expRv.setViewVisibility(R.id.notification_action2, 0);
                expRv.setImageViewResource(R.id.notification_action2, R.drawable.ic_notification_action_skip_previous);
                expRv.setOnClickPendingIntent(R.id.notification_action2, this.mPrevIntent);
            }
            NotificationStyle notificationStyle3 = this.notificationStyle;
            Intrinsics.checkNotNull(notificationStyle3);
            if (!notificationStyle3.forbiddenPlayerAction) {
                if (playbackState.getState() == 3) {
                    icon = R.drawable.ic_notification_action_pause;
                    intent = this.mPauseIntent;
                } else {
                    icon = R.drawable.ic_notification_action_play;
                    intent = this.mPlayIntent;
                }
                collapseRv.setViewVisibility(R.id.notification_action2, 0);
                collapseRv.setImageViewResource(R.id.notification_action2, icon);
                collapseRv.setOnClickPendingIntent(R.id.notification_action2, intent);
                expRv.setViewVisibility(R.id.notification_action3, 0);
                expRv.setImageViewResource(R.id.notification_action3, icon);
                expRv.setOnClickPendingIntent(R.id.notification_action3, intent);
            }
            int icon2 = R.id.notification_action4;
            expRv.setViewVisibility(icon2, 4);
            collapseRv.setViewVisibility(R.id.notification_action3, 4);
            expRv.setOnClickPendingIntent(R.id.notification_stop, this.mStopIntent);
            collapseRv.setOnClickPendingIntent(R.id.notification_stop, this.mStopIntent);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this.context, Companion.getChannelId$music_service_debug(this.context));
            builder.setColor(mNotificationColor).setSmallIcon(R.drawable.ic_notification_background_music).setUsesChronometer(false).setWhen(0L).setContentIntent(createContentIntent()).setSilent(true);
            builder.setVisibility(1);
            setNotificationPlaybackState(builder);
            if (bmp != null && !bmp.isRecycled()) {
                expRv.setImageViewBitmap(R.id.notification_icon, bmp);
                collapseRv.setImageViewBitmap(R.id.notification_icon, bmp);
            } else {
                Bitmap coverBmp = getCoverBitmap();
                String albumUri = desc.getIconUri() != null ? String.valueOf(desc.getIconUri()) : null;
                if (coverBmp == null || coverBmp.isRecycled()) {
                    coverBmp = null;
                } else {
                    expRv.setImageViewBitmap(R.id.notification_icon, coverBmp);
                    collapseRv.setImageViewBitmap(R.id.notification_icon, coverBmp);
                }
                if (coverBmp == null) {
                    expRv.setImageViewResource(R.id.notification_icon, R.drawable.bg_default_music_notification_album);
                    collapseRv.setImageViewResource(R.id.notification_icon, R.drawable.bg_default_music_notification_album);
                }
                if (!TextUtils.isEmpty(albumUri) && coverBmp == null) {
                    fetchBitmapFromURLAsync(albumUri);
                }
            }
            builder.setContent(collapseRv);
            builder.setVisibility(1);
            builder.setCustomBigContentView(expRv);
            return builder.build();
        } catch (RuntimeException e) {
            PlayerLog.e(PlayerLogModule.BackgroundPlay, "buildJBNotification() get description has err=" + e);
            return null;
        }
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

    private final Notification buildMediaStyleNotification(Bitmap bmp) {
        int preActionIndex;
        int playActionIndex;
        int nextActionIndex;
        int preActionIndex2;
        int playActionIndex2;
        int nextActionIndex2;
        PlaybackStateCompat playbackState = getPlaybackState();
        MediaMetadataCompat metadata = getMetadata();
        if (metadata != null && playbackState != null) {
            try {
                MediaDescriptionCompat desc = metadata.getDescription();
                Intrinsics.checkNotNullExpressionValue(desc, "getDescription(...)");
                int actionCount = 0;
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this.context, Companion.getChannelId$music_service_debug(this.context)).setUsesChronometer(false).setWhen(0L).setContentIntent(createContentIntent()).setVisibility(1).setOngoing(true).setContentTitle(desc.getTitle()).setDeleteIntent(this.mDeleteIntent).setSilent(true);
                String string = metadata.getString("android.media.metadata.ARTIST");
                String author = (string == null || (author = StringsKt.trim(string).toString()) == null) ? "" : "";
                if (!TextUtils.isEmpty(author)) {
                    builder.setContentText(author);
                }
                boolean enableLike = this.callback.enableLike();
                if (!enableLike) {
                    if (!isModeEnable() || (playbackState.getActions() & 32) == 0) {
                        preActionIndex = -1;
                        playActionIndex = -1;
                        nextActionIndex = -1;
                    } else {
                        NotificationStyle notificationStyle = this.notificationStyle;
                        Intrinsics.checkNotNull(notificationStyle);
                        if (!notificationStyle.isFixedPlayMode) {
                            Companion companion = Companion;
                            preActionIndex = -1;
                            int preActionIndex3 = getPlayMode();
                            playActionIndex = -1;
                            nextActionIndex = -1;
                            NotificationCompat.Action modeAction = new NotificationCompat.Action(Companion.createNewModeIcon$default(companion, preActionIndex3, false, 2, null), "mode", this.mModeIntent);
                            builder.addAction(modeAction);
                            actionCount = 0 + 1;
                        } else {
                            preActionIndex = -1;
                            playActionIndex = -1;
                            nextActionIndex = -1;
                            NotificationCompat.Action modeAction2 = new NotificationCompat.Action(Companion.createNewModeIcon(getPlayMode(), true), "mode", (PendingIntent) null);
                            builder.addAction(modeAction2);
                            actionCount = 0 + 1;
                        }
                    }
                } else {
                    NotificationCompat.Action likeAction = new NotificationCompat.Action(this.callback.getLikeState() ? R.drawable.ic_notification_action_liked_ga7 : R.drawable.ic_notification_action_like_ga7, "like", this.callback.getLikeState() ? this.mUnlikeIntent : this.mLikeIntent);
                    builder.addAction(likeAction);
                    actionCount = 0 + 1;
                    preActionIndex = -1;
                    playActionIndex = -1;
                    nextActionIndex = -1;
                }
                if (supportRewind(playbackState)) {
                    NotificationCompat.Action rewindAction = new NotificationCompat.Action(R.drawable.ic_notification_action_rewind_10s_ga7, "rewind", this.mRewindIntent);
                    builder.addAction(rewindAction);
                    preActionIndex2 = actionCount;
                    actionCount++;
                } else if ((playbackState.getActions() & 16) == 0) {
                    preActionIndex2 = preActionIndex;
                } else {
                    NotificationCompat.Action previousAction = new NotificationCompat.Action(R.drawable.ic_notification_action_skip_previous_ga7, "previous", this.mPrevIntent);
                    builder.addAction(previousAction);
                    preActionIndex2 = actionCount;
                    actionCount++;
                }
                NotificationStyle notificationStyle2 = this.notificationStyle;
                Intrinsics.checkNotNull(notificationStyle2);
                if (notificationStyle2.forbiddenPlayerAction) {
                    playActionIndex2 = playActionIndex;
                } else if (playbackState.getState() == 3) {
                    NotificationCompat.Action pauseAction = new NotificationCompat.Action(R.drawable.ic_notification_action_pause_ga7, "pause", this.mPauseIntent);
                    builder.addAction(pauseAction);
                    playActionIndex2 = actionCount;
                    actionCount++;
                } else {
                    NotificationCompat.Action playAction = new NotificationCompat.Action(R.drawable.ic_notification_action_play_ga7, "play", this.mPlayIntent);
                    builder.addAction(playAction);
                    playActionIndex2 = actionCount;
                    actionCount++;
                }
                if (!supportFastForward(playbackState)) {
                    if ((playbackState.getActions() & 32) == 0) {
                        nextActionIndex2 = nextActionIndex;
                    } else {
                        NotificationCompat.Action nextAction = new NotificationCompat.Action(R.drawable.ic_notification_action_skip_next_ga7, "next", this.mNextIntent);
                        builder.addAction(nextAction);
                        nextActionIndex2 = actionCount;
                        actionCount++;
                    }
                } else {
                    NotificationCompat.Action forwardAction = new NotificationCompat.Action(R.drawable.ic_notification_action_fast_forward_10s_ga7, "forward", this.mFastForwardIntent);
                    builder.addAction(forwardAction);
                    nextActionIndex2 = actionCount;
                    actionCount++;
                }
                NotificationCompat.Action closeAction = new NotificationCompat.Action(R.drawable.ic_notification_action_close, "close", this.mDeleteIntent);
                builder.addAction(closeAction);
                int actionCount2 = actionCount + 1;
                if (bmp != null && !bmp.isRecycled()) {
                    builder.setLargeIcon(bmp);
                } else {
                    Bitmap coverBmp = getCoverBitmap();
                    String albumUri = desc.getIconUri() != null ? String.valueOf(desc.getIconUri()) : null;
                    if (coverBmp == null || coverBmp.isRecycled()) {
                        builder.setLargeIcon(BitmapFactory.decodeResource(this.context.getResources(), R.drawable.bg_default_music_notification_album_new));
                        if (!TextUtils.isEmpty(albumUri)) {
                            fetchBitmapFromURLAsync(albumUri);
                        }
                        Unit unit = Unit.INSTANCE;
                    } else {
                        builder.setLargeIcon(coverBmp);
                    }
                }
                NotificationCompat.Style mediaSession = new NotificationCompat.MediaStyle().setMediaSession(this.session.getSessionToken());
                if (preActionIndex2 >= 0 && playActionIndex2 >= 0 && nextActionIndex2 >= 0 && actionCount2 > nextActionIndex2) {
                    mediaSession.setShowActionsInCompactView(new int[]{preActionIndex2, playActionIndex2, nextActionIndex2});
                } else {
                    PlayerLog.e(PlayerLogModule.BackgroundPlay, "no enough base action, preActionIndex: " + preActionIndex2 + ", playActionIndex: " + playActionIndex2 + ", nextActionIndex: " + nextActionIndex2 + ", actionCount: " + actionCount2 + ", do nothing");
                }
                builder.setStyle(mediaSession);
                builder.setSmallIcon(R.drawable.ic_notification_background_music);
                return builder.build();
            } catch (RuntimeException e) {
                PlayerLog.e(PlayerLogModule.BackgroundPlay, "buildMediaStyleNotification() get description has err=" + e);
                return null;
            }
        }
        return null;
    }

    private final Notification buildNewJBNotification(Bitmap bmp) {
        int icon;
        PendingIntent intent;
        PlaybackStateCompat playbackState = getPlaybackState();
        MediaMetadataCompat metadata = getMetadata();
        if (metadata != null && playbackState != null) {
            try {
                MediaDescriptionCompat desc = metadata.getDescription();
                Intrinsics.checkNotNullExpressionValue(desc, "getDescription(...)");
                RemoteViews collapseRv = new RemoteViews(this.context.getPackageName(), R.layout.notification_custom_new_collapse_layout);
                RemoteViews expRv = new RemoteViews(this.context.getPackageName(), R.layout.notification_custom_new_expanded_layout);
                expRv.setTextViewText(R.id.notification_text1, desc.getTitle());
                String string = metadata.getString("android.media.metadata.ARTIST");
                String author = (string == null || (r0 = StringsKt.trim(string).toString()) == null) ? "" : "";
                if (TextUtils.isEmpty(author)) {
                    expRv.setViewVisibility(R.id.notification_up_linear_layout, 8);
                } else {
                    expRv.setViewVisibility(R.id.notification_up_linear_layout, 0);
                }
                expRv.setTextViewText(R.id.notification_text2, author);
                CharSequence subtitle = desc.getSubtitle();
                String logText = this.context.getString(bili.resource.common.R.string.common_global_string_45);
                Intrinsics.checkNotNullExpressionValue(logText, "getString(...)");
                expRv.setTextViewText(R.id.notification_text3, subtitle == null || StringsKt.isBlank(subtitle) ? logText : logText + " · " + ((Object) desc.getSubtitle()));
                collapseRv.setTextViewText(R.id.notification_text1, desc.getTitle());
                collapseRv.setImageViewResource(R.id.notification_close, R.drawable.ic_notification_action_collapse_close_ga7);
                collapseRv.setOnClickPendingIntent(R.id.notification_close, this.mStopIntent);
                boolean enableLike = this.callback.enableLike();
                if (enableLike) {
                    expRv.setViewVisibility(R.id.notification_action_like, 0);
                    if (this.callback.getLikeState()) {
                        expRv.setImageViewResource(R.id.notification_action_like, R.drawable.ic_notification_action_liked_ga7);
                        expRv.setOnClickPendingIntent(R.id.notification_action_like, this.mUnlikeIntent);
                    } else {
                        expRv.setImageViewResource(R.id.notification_action_like, R.drawable.ic_notification_action_like_ga7);
                        expRv.setOnClickPendingIntent(R.id.notification_action_like, this.mLikeIntent);
                    }
                } else {
                    expRv.setViewVisibility(R.id.notification_action_like, 8);
                    expRv.setViewVisibility(R.id.gap_end_of_like, 8);
                }
                if (isModeEnable()) {
                    expRv.setViewVisibility(R.id.notification_action1, 0);
                    expRv.setImageViewResource(R.id.notification_action1, Companion.createNewModeIcon$default(Companion, getPlayMode(), false, 2, null));
                    NotificationStyle notificationStyle = this.notificationStyle;
                    Intrinsics.checkNotNull(notificationStyle);
                    if (!notificationStyle.isFixedPlayMode) {
                        expRv.setOnClickPendingIntent(R.id.notification_action1, this.mModeIntent);
                    } else {
                        try {
                            expRv.setInt(R.id.notification_action1, "setImageAlpha", 66);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                if ((playbackState.getActions() & 8) != 0) {
                    expRv.setViewVisibility(R.id.notification_action2, 0);
                    expRv.setImageViewResource(R.id.notification_action2, R.drawable.ic_notification_action_rewind_10s_ga7);
                    expRv.setOnClickPendingIntent(R.id.notification_action2, this.mRewindIntent);
                    collapseRv.setViewVisibility(R.id.notification_action1, 0);
                    if (!enableLike) {
                        collapseRv.setImageViewResource(R.id.notification_action1, R.drawable.ic_notification_action_rewind_10s_ga7);
                        collapseRv.setOnClickPendingIntent(R.id.notification_action1, this.mRewindIntent);
                    }
                } else if ((playbackState.getActions() & 16) != 0) {
                    expRv.setViewVisibility(R.id.notification_action2, 0);
                    expRv.setImageViewResource(R.id.notification_action2, R.drawable.ic_notification_action_skip_previous_ga7);
                    expRv.setOnClickPendingIntent(R.id.notification_action2, this.mPrevIntent);
                    collapseRv.setViewVisibility(R.id.notification_action1, 0);
                    if (!enableLike) {
                        collapseRv.setImageViewResource(R.id.notification_action1, R.drawable.ic_notification_action_skip_previous_ga7);
                        collapseRv.setOnClickPendingIntent(R.id.notification_action1, this.mPrevIntent);
                    }
                }
                if (enableLike) {
                    if (this.callback.getLikeState()) {
                        collapseRv.setImageViewResource(R.id.notification_action1, R.drawable.ic_notification_action_liked_ga7);
                        collapseRv.setOnClickPendingIntent(R.id.notification_action1, this.mUnlikeIntent);
                    } else {
                        collapseRv.setImageViewResource(R.id.notification_action1, R.drawable.ic_notification_action_like_ga7);
                        collapseRv.setOnClickPendingIntent(R.id.notification_action1, this.mLikeIntent);
                    }
                }
                NotificationStyle notificationStyle2 = this.notificationStyle;
                Intrinsics.checkNotNull(notificationStyle2);
                if (!notificationStyle2.forbiddenPlayerAction) {
                    if (playbackState.getState() == 3) {
                        icon = R.drawable.ic_notification_action_pause_ga7;
                        intent = this.mPauseIntent;
                    } else {
                        icon = R.drawable.ic_notification_action_play_ga7;
                        intent = this.mPlayIntent;
                    }
                    collapseRv.setViewVisibility(R.id.notification_action2, 0);
                    collapseRv.setImageViewResource(R.id.notification_action2, icon);
                    collapseRv.setOnClickPendingIntent(R.id.notification_action2, intent);
                    expRv.setViewVisibility(R.id.notification_action3, 0);
                    expRv.setImageViewResource(R.id.notification_action3, icon);
                    expRv.setOnClickPendingIntent(R.id.notification_action3, intent);
                }
                if ((playbackState.getActions() & 64) != 0) {
                    expRv.setViewVisibility(R.id.notification_action4, 0);
                    expRv.setImageViewResource(R.id.notification_action4, R.drawable.ic_notification_action_fast_forward_10s_ga7);
                    expRv.setOnClickPendingIntent(R.id.notification_action4, this.mFastForwardIntent);
                    collapseRv.setViewVisibility(R.id.notification_action3, 0);
                    collapseRv.setImageViewResource(R.id.notification_action3, R.drawable.ic_notification_action_fast_forward_10s_ga7);
                    collapseRv.setOnClickPendingIntent(R.id.notification_action3, this.mFastForwardIntent);
                } else if ((playbackState.getActions() & 32) != 0) {
                    expRv.setViewVisibility(R.id.notification_action4, 0);
                    expRv.setImageViewResource(R.id.notification_action4, R.drawable.ic_notification_action_skip_next_ga7);
                    expRv.setOnClickPendingIntent(R.id.notification_action4, this.mNextIntent);
                    collapseRv.setViewVisibility(R.id.notification_action3, 0);
                    collapseRv.setImageViewResource(R.id.notification_action3, R.drawable.ic_notification_action_skip_next_ga7);
                    collapseRv.setOnClickPendingIntent(R.id.notification_action3, this.mNextIntent);
                }
                expRv.setOnClickPendingIntent(R.id.notification_stop, this.mStopIntent);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this.context, Companion.getChannelId$music_service_debug(this.context));
                builder.setSmallIcon(R.drawable.ic_notification_background_music).setUsesChronometer(false).setWhen(0L).setContentIntent(createContentIntent()).setSilent(true);
                builder.setVisibility(1);
                setNotificationPlaybackState(builder);
                if (bmp != null && !bmp.isRecycled()) {
                    expRv.setImageViewBitmap(R.id.notification_icon, bmp);
                } else {
                    Bitmap coverBmp = getCoverBitmap();
                    String albumUri = desc.getIconUri() != null ? String.valueOf(desc.getIconUri()) : null;
                    if (coverBmp == null || coverBmp.isRecycled()) {
                        coverBmp = null;
                    } else {
                        expRv.setImageViewBitmap(R.id.notification_icon, coverBmp);
                    }
                    if (coverBmp == null) {
                        expRv.setImageViewResource(R.id.notification_icon, R.drawable.bg_default_music_notification_album_new);
                    }
                    if (!TextUtils.isEmpty(albumUri) && coverBmp == null) {
                        fetchBitmapFromURLAsync(albumUri);
                    }
                }
                builder.setContent(collapseRv);
                builder.setVisibility(1);
                builder.setCustomBigContentView(expRv);
                return builder.build();
            } catch (RuntimeException e2) {
                PlayerLog.e(PlayerLogModule.BackgroundPlay, "buildNewJBNotification() get description has err=" + e2);
                return null;
            }
        }
        return null;
    }

    private final int createModeIcon() {
        switch (getPlayMode()) {
            case 0:
                return R.drawable.ic_notification_mode_auto;
            case 1:
                return R.drawable.ic_notification_mode_pause;
            case 2:
                return R.drawable.ic_notification_mode_single;
            case 3:
            case 5:
            case 7:
            default:
                return R.drawable.ic_notification_mode_auto;
            case 4:
                return R.drawable.ic_notification_mode_loop;
            case 6:
                return R.drawable.ic_notification_mode_random;
            case 8:
                return R.drawable.ic_notification_mode_reverse;
        }
    }

    private final PendingIntent createContentIntent() {
        Intent openUI;
        List pendingIntents = new ArrayList();
        if (this.mBindedActivityClass != null) {
            if (this.mBindedIntent != null) {
                openUI = new Intent(this.mBindedIntent);
                Context context = this.context;
                Class<?> cls = this.mBindedActivityClass;
                Intrinsics.checkNotNull(cls);
                Intrinsics.checkNotNull(openUI.setClass(context, cls));
            } else {
                openUI = new Intent(this.context, this.mBindedActivityClass);
            }
            openUI.addFlags(608174080);
            pendingIntents.add(openUI);
        } else if (this.mMainActivityClass != null) {
            Intent mainIntent = new Intent("android.intent.action.MAIN");
            mainIntent.addCategory("android.intent.category.LAUNCHER");
            Context context2 = this.context;
            Class<?> cls2 = this.mMainActivityClass;
            mainIntent.setComponent(new ComponentName(context2, (cls2 == null || (r6 = cls2.getCanonicalName()) == null) ? "" : ""));
            mainIntent.setFlags(270532608);
            return __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity(this.context.getApplicationContext(), MusicNotificationManager.REQUEST_CODE, mainIntent, 167772160);
        } else {
            Activity topActivity = BiliContext.topActivity();
            Intent intent = new Intent(topActivity, topActivity != null ? topActivity.getClass() : null);
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(608174080);
            pendingIntents.add(intent);
        }
        List $this$toTypedArray$iv = pendingIntents;
        return __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivities(this.context.getApplicationContext(), MusicNotificationManager.REQUEST_CODE, (Intent[]) $this$toTypedArray$iv.toArray(new Intent[0]), 167772160);
    }

    private final Bitmap getCoverBitmap() {
        MediaMetadataCompat metadata = getMetadata();
        if (metadata == null) {
            return null;
        }
        try {
            MediaDescriptionCompat desc = metadata.getDescription();
            Intrinsics.checkNotNull(desc);
            String albumUri = desc.getIconUri() != null ? String.valueOf(desc.getIconUri()) : null;
            Bitmap iconBmp = MusicCoverImageCache.getInstance().getIconImage(albumUri);
            if (iconBmp == null || iconBmp.isRecycled()) {
                return null;
            }
            return iconBmp;
        } catch (RuntimeException e) {
            PlayerLog.e(PlayerLogModule.BackgroundPlay, "getCoverBitmap() get description has err=" + e);
            return null;
        }
    }

    private final void setNotificationPlaybackState(NotificationCompat.Builder builder) {
        PlaybackStateCompat playbackState = getPlaybackState();
        if (playbackState == null) {
            return;
        }
        PlayerLog.i(PlayerLogModule.BackgroundPlay, "background player ongoing:" + (playbackState.getState() == 3));
        builder.setOngoing(playbackState.getState() == 3);
    }

    private final void fetchBitmapFromURLAsync(String imageUri) {
        MusicCoverImageCache.getInstance().fetch(this.context.getApplicationContext(), imageUri, new MusicCoverImageCache.FetchListener() { // from class: tv.danmaku.bili.ui.player.notification.BgmscNotificatioBuilderHelper$fetchBitmapFromURLAsync$1
            /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
                r0 = r2.this$0.buildNotification(r5);
             */
            @Override // tv.danmaku.bili.ui.player.notification.MusicCoverImageCache.FetchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onFetched(String artUrl, Bitmap bigImage, Bitmap iconImage) {
                Notification notification;
                MusicNotificationManager musicNotificationManager;
                if (iconImage != null && !iconImage.isRecycled() && notification != null) {
                    musicNotificationManager = BgmscNotificatioBuilderHelper.this.musicNotificationManager;
                    musicNotificationManager.startOrUpdateNotification(notification);
                }
            }
        });
    }

    private final MediaMetadataCompat getMetadata() {
        MediaControllerCompat controller = this.session.getController();
        if (controller != null) {
            return controller.getMetadata();
        }
        return null;
    }

    private final PlaybackStateCompat getPlaybackState() {
        MediaControllerCompat controller = this.session.getController();
        if (controller != null) {
            return controller.getPlaybackState();
        }
        return null;
    }

    private final int getPlayMode() {
        return this.callback.getPlayMode();
    }

    private final boolean isModeEnable() {
        NotificationStyle notificationStyle = this.notificationStyle;
        return !(notificationStyle != null && notificationStyle.forbiddenPlayerAction) && getPlayMode() >= 0;
    }

    public final void bindData(Class<?> cls, Class<?> cls2, Intent intent) {
        this.mBindedActivityClass = cls;
        this.mMainActivityClass = cls2;
        this.mBindedIntent = intent;
    }

    private final boolean supportFastForward(PlaybackStateCompat $this$supportFastForward) {
        Iterable $this$any$iv;
        if (($this$supportFastForward.getActions() & 64) == 0) {
            Iterable customActions = $this$supportFastForward.getCustomActions();
            Intrinsics.checkNotNullExpressionValue(customActions, "getCustomActions(...)");
            Iterable $this$any$iv2 = customActions;
            if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                Iterator it = $this$any$iv2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        PlaybackStateCompat.CustomAction it2 = (PlaybackStateCompat.CustomAction) element$iv;
                        if (Intrinsics.areEqual(it2.getAction(), MusicNotificationManager.ACTION_FAST_FORWARD)) {
                            $this$any$iv = 1;
                            break;
                        }
                    } else {
                        $this$any$iv = null;
                        break;
                    }
                }
            } else {
                $this$any$iv = null;
            }
            return $this$any$iv != null;
        }
        return true;
    }

    private final boolean supportRewind(PlaybackStateCompat $this$supportRewind) {
        Iterable $this$any$iv;
        if (($this$supportRewind.getActions() & 8) == 0) {
            Iterable customActions = $this$supportRewind.getCustomActions();
            Intrinsics.checkNotNullExpressionValue(customActions, "getCustomActions(...)");
            Iterable $this$any$iv2 = customActions;
            if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                Iterator it = $this$any$iv2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        PlaybackStateCompat.CustomAction it2 = (PlaybackStateCompat.CustomAction) element$iv;
                        if (Intrinsics.areEqual(it2.getAction(), MusicNotificationManager.ACTION_REWIND)) {
                            $this$any$iv = 1;
                            break;
                        }
                    } else {
                        $this$any$iv = null;
                        break;
                    }
                }
            } else {
                $this$any$iv = null;
            }
            return $this$any$iv != null;
        }
        return true;
    }

    /* compiled from: BgmscNotificatioBuilderHelper.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\bJ\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\nJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\nR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u0012\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0013\u0010\f¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/player/notification/BgmscNotificatioBuilderHelper$Companion;", "", "<init>", "()V", "getChannelId", "", "context", "Landroid/content/Context;", "getChannelId$music_service_debug", "hitSystemMediaControl", "", "getHitSystemMediaControl", "()Z", "hitSystemMediaControl$delegate", "Lkotlin/Lazy;", "disableSystemMediaControlOnHarmony", "getDisableSystemMediaControlOnHarmony", "disableSystemMediaControlOnHarmony$delegate", "keepNotificationWhilePlaying", "getKeepNotificationWhilePlaying", "keepNotificationWhilePlaying$delegate", "enableMediaControls", "createNewModeIcon", "", "playMode", "useAlpha", "music-service_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String getChannelId$music_service_debug(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String defaultChannelId = NotificationChannelHelper.getDefaultChannelId(context);
            Intrinsics.checkNotNullExpressionValue(defaultChannelId, "getDefaultChannelId(...)");
            return defaultChannelId;
        }

        private final boolean getHitSystemMediaControl() {
            return ((Boolean) BgmscNotificatioBuilderHelper.hitSystemMediaControl$delegate.getValue()).booleanValue();
        }

        public final boolean getDisableSystemMediaControlOnHarmony() {
            return ((Boolean) BgmscNotificatioBuilderHelper.disableSystemMediaControlOnHarmony$delegate.getValue()).booleanValue();
        }

        private final boolean getKeepNotificationWhilePlaying() {
            return ((Boolean) BgmscNotificatioBuilderHelper.keepNotificationWhilePlaying$delegate.getValue()).booleanValue();
        }

        public final boolean enableMediaControls() {
            if (Build.VERSION.SDK_INT < 30) {
                return false;
            }
            if (RomUtils.isHarmony() && getDisableSystemMediaControlOnHarmony()) {
                return false;
            }
            return getHitSystemMediaControl();
        }

        public final boolean keepNotificationWhilePlaying() {
            return enableMediaControls() && getKeepNotificationWhilePlaying();
        }

        public static /* synthetic */ int createNewModeIcon$default(Companion companion, int i, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return companion.createNewModeIcon(i, z);
        }

        public final int createNewModeIcon(int playMode, boolean useAlpha) {
            switch (playMode) {
                case 0:
                    if (useAlpha) {
                        return R.drawable.ic_notification_mode_auto_ga7_alpha25;
                    }
                    return R.drawable.ic_notification_mode_auto_ga7;
                case 1:
                    if (useAlpha) {
                        return R.drawable.ic_notification_mode_pause_ga7_alpha25;
                    }
                    return R.drawable.ic_notification_mode_pause_ga7;
                case 2:
                    if (useAlpha) {
                        return R.drawable.ic_notification_mode_single_ga7_alpha25;
                    }
                    return R.drawable.ic_notification_mode_single_ga7;
                case 3:
                case 5:
                case 7:
                default:
                    return R.drawable.ic_notification_mode_auto_ga7;
                case 4:
                    if (useAlpha) {
                        return R.drawable.ic_notification_mode_loop_ga7_alpha25;
                    }
                    return R.drawable.ic_notification_mode_loop_ga7;
                case 6:
                    if (useAlpha) {
                        return R.drawable.ic_notification_mode_random_ga7_alpha25;
                    }
                    return R.drawable.ic_notification_mode_random_ga7;
                case 8:
                    if (useAlpha) {
                        return R.drawable.ic_notification_mode_reverse_ga7_alpha25;
                    }
                    return R.drawable.ic_notification_mode_reverse_ga7;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hitSystemMediaControl_delegate$lambda$0() {
        boolean it = DeviceDecision.INSTANCE.getBoolean("dd_enable_system_media_control", false);
        PlayerLog.i(PlayerLogModule.BackgroundPlay, "hitSystemMediaControl=" + it);
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean disableSystemMediaControlOnHarmony_delegate$lambda$0() {
        boolean it = DeviceDecision.INSTANCE.getBoolean("dd_system_media_control_disable_harmony", false);
        PlayerLog.i(PlayerLogModule.BackgroundPlay, "disableOnHarmony=" + it);
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean keepNotificationWhilePlaying_delegate$lambda$0() {
        boolean it = DeviceDecision.INSTANCE.getBoolean("dd_keep_notification_while_playing", false);
        PlayerLog.i(PlayerLogModule.BackgroundPlay, "keepNotificationWhilePlaying=" + it);
        return it;
    }
}