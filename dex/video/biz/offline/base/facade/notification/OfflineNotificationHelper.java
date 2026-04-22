package video.biz.offline.base.facade.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.core.app.ServiceCompat;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.infra.base.aop.PendingIntentCreateHook;
import com.bilibili.lib.foundation.FoundationAlias;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.AppBuildConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import video.base.log.LogKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: OfflineNotificationHelper.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010.\u001a\u00020/2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020*\u0018\u0001012\u0006\u00102\u001a\u00020\tJ\u0006\u00103\u001a\u00020/J\u000e\u00104\u001a\u00020/H\u0082@¢\u0006\u0002\u00105J\u0014\u00106\u001a\u00020/2\f\u00107\u001a\b\u0012\u0004\u0012\u00020801J\u0016\u00109\u001a\u00020/2\u0006\u0010:\u001a\u000208H\u0086@¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020\"H\u0002J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J\u0018\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020+2\u0006\u0010D\u001a\u00020EH\u0002J\u0006\u0010F\u001a\u00020/J.\u0010G\u001a\u00020/2\u001e\u0010H\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)\u0012\u0004\u0012\u00020/0\u0007H\u0082@¢\u0006\u0002\u0010IJ\u0010\u0010J\u001a\u00020*2\u0006\u0010@\u001a\u00020AH\u0002J\u0018\u0010K\u001a\u00020/2\u0006\u0010L\u001a\u00020*2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010M\u001a\u00020*2\u0006\u0010L\u001a\u00020*H\u0002J\u0010\u0010N\u001a\u00020*2\u0006\u0010L\u001a\u00020*H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR)\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0019\u001a\u00070\u001a¢\u0006\u0002\b\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\u0004\u0018\u00010\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lvideo/biz/offline/base/facade/notification/OfflineNotificationHelper;", "", "service", "Landroid/app/Service;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "serviceIdle", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "<init>", "(Landroid/app/Service;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "getService", "()Landroid/app/Service;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getServiceIdle", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "()Landroid/app/NotificationManager;", "notificationManager$delegate", "Lkotlin/Lazy;", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "Lorg/jspecify/annotations/NonNull;", "getBuilder", "()Landroidx/core/app/NotificationCompat$Builder;", "builder$delegate", "serviceForeground", "downloadingStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lvideo/biz/offline/base/facade/notification/OfflineNotificationState;", "downloadingNotificationState", "getDownloadingNotificationState", "()Lvideo/biz/offline/base/facade/notification/OfflineNotificationState;", "completedNotificationId", "Ljava/util/concurrent/atomic/AtomicInteger;", "completedNotificationMap", "Landroidx/collection/ArrayMap;", "", "", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "notifyStopDownload", "", "keys", "", "removeCompletedNotification", "notifyStopAll", "cancelDownloadingNotification", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotifications", "entities", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "updateNotification", "entity", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notify", "state", "getPendingIntent", "Landroid/app/PendingIntent;", "context", "Landroid/content/Context;", "startForeground", "notificationId", "notification", "Landroid/app/Notification;", "release", "safeAccessCompletedNotificationMap", "action", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDefaultChannelId", "registerChannelId", "channelId", "getChannelName", "getChannelDescription", "facade_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineNotificationHelper {
    public static final int $stable = 8;
    private final Lazy builder$delegate;
    private final AtomicInteger completedNotificationId;
    private final ArrayMap<String, Integer> completedNotificationMap;
    private final MutableStateFlow<OfflineNotificationState> downloadingStateFlow;
    private final Mutex mutex;
    private final Lazy notificationManager$delegate;
    private final CoroutineScope scope;
    private final Service service;
    private boolean serviceForeground;
    private final Function1<Continuation<? super Boolean>, Object> serviceIdle;

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

    private static void __Ghost$Insertion$com_bilibili_infra_base_aop_StartForegroundHook_startForeground(Object service, int id, Notification notification) {
        if (Build.VERSION.SDK_INT >= 31) {
            try {
                ((Service) service).startForeground(Integer.valueOf(id).intValue(), notification);
                return;
            } catch (Exception e) {
                BLog.w("StartForegroundHook", "startForeground fail", e);
                return;
            }
        }
        ((Service) service).startForeground(Integer.valueOf(id).intValue(), notification);
    }

    public OfflineNotificationHelper(Service service, CoroutineScope scope, Function1<? super Continuation<? super Boolean>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(function1, "serviceIdle");
        this.service = service;
        this.scope = scope;
        this.serviceIdle = function1;
        this.notificationManager$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.facade.notification.OfflineNotificationHelper$$ExternalSyntheticLambda1
            public final Object invoke() {
                NotificationManager notificationManager_delegate$lambda$0;
                notificationManager_delegate$lambda$0 = OfflineNotificationHelper.notificationManager_delegate$lambda$0(OfflineNotificationHelper.this);
                return notificationManager_delegate$lambda$0;
            }
        });
        this.builder$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.facade.notification.OfflineNotificationHelper$$ExternalSyntheticLambda2
            public final Object invoke() {
                NotificationCompat.Builder builder_delegate$lambda$0;
                builder_delegate$lambda$0 = OfflineNotificationHelper.builder_delegate$lambda$0(OfflineNotificationHelper.this);
                return builder_delegate$lambda$0;
            }
        });
        this.downloadingStateFlow = StateFlowKt.MutableStateFlow((Object) null);
        this.completedNotificationId = new AtomicInteger(OfflineNotificationHelperKt.ID_NOTIFICATION_DOWNLOADING);
        this.completedNotificationMap = new ArrayMap<>();
        this.mutex = MutexKt.Mutex$default(false, 1, (Object) null);
        BuildersKt.launch$default(this.scope, Dispatchers.getDefault(), (CoroutineStart) null, new AnonymousClass1(null), 2, (Object) null);
    }

    public final Service getService() {
        return this.service;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final Function1<Continuation<? super Boolean>, Object> getServiceIdle() {
        return this.serviceIdle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationManager getNotificationManager() {
        return (NotificationManager) this.notificationManager$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationManager notificationManager_delegate$lambda$0(OfflineNotificationHelper this$0) {
        Object systemService = this$0.service.getSystemService("notification");
        if (systemService instanceof NotificationManager) {
            return (NotificationManager) systemService;
        }
        return null;
    }

    private final NotificationCompat.Builder getBuilder() {
        return (NotificationCompat.Builder) this.builder$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationCompat.Builder builder_delegate$lambda$0(OfflineNotificationHelper this$0) {
        return new NotificationCompat.Builder(this$0.service, this$0.getDefaultChannelId(this$0.service)).setSmallIcon(R.drawable.ic_notify_msg);
    }

    private final OfflineNotificationState getDownloadingNotificationState() {
        return (OfflineNotificationState) this.downloadingStateFlow.getValue();
    }

    /* compiled from: OfflineNotificationHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "video.biz.offline.base.facade.notification.OfflineNotificationHelper$1", f = "OfflineNotificationHelper.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: video.biz.offline.base.facade.notification.OfflineNotificationHelper$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (FlowKt.collectLatest(FlowKt.debounce(OfflineNotificationHelper.this.downloadingStateFlow, 300L), new C00101(OfflineNotificationHelper.this, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OfflineNotificationHelper.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lvideo/biz/offline/base/facade/notification/OfflineNotificationState;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        @DebugMetadata(c = "video.biz.offline.base.facade.notification.OfflineNotificationHelper$1$1", f = "OfflineNotificationHelper.kt", i = {0}, l = {61}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
        /* renamed from: video.biz.offline.base.facade.notification.OfflineNotificationHelper$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class C00101 extends SuspendLambda implements Function2<OfflineNotificationState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ OfflineNotificationHelper this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00101(OfflineNotificationHelper offlineNotificationHelper, Continuation<? super C00101> continuation) {
                super(2, continuation);
                this.this$0 = offlineNotificationHelper;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00101 = new C00101(this.this$0, continuation);
                c00101.L$0 = obj;
                return c00101;
            }

            public final Object invoke(OfflineNotificationState offlineNotificationState, Continuation<? super Unit> continuation) {
                return create(offlineNotificationState, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                OfflineNotificationState state = (OfflineNotificationState) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (state == null) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(state);
                            this.label = 1;
                            if (this.this$0.cancelDownloadingNotification((Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            this.this$0.notify(state);
                            return Unit.INSTANCE;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
    }

    public final void notifyStopDownload(List<String> list, boolean removeCompletedNotification) {
        if (list == null) {
            return;
        }
        List<String> list2 = list;
        OfflineNotificationState downloadingNotificationState = getDownloadingNotificationState();
        if (CollectionsKt.contains(list2, downloadingNotificationState != null ? downloadingNotificationState.getKey() : null)) {
            this.downloadingStateFlow.setValue((Object) null);
        }
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineNotificationHelper$notifyStopDownload$1(removeCompletedNotification, this, list, null), 3, (Object) null);
    }

    public final void notifyStopAll() {
        LogKt.getVBLog().info("OfflineNotificationHelper stop all downloading, cancel ongoing notification");
        this.downloadingStateFlow.setValue((Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0093 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object cancelDownloadingNotification(Continuation<? super Unit> continuation) {
        OfflineNotificationHelper$cancelDownloadingNotification$1 offlineNotificationHelper$cancelDownloadingNotification$1;
        Object invoke;
        if (continuation instanceof OfflineNotificationHelper$cancelDownloadingNotification$1) {
            offlineNotificationHelper$cancelDownloadingNotification$1 = (OfflineNotificationHelper$cancelDownloadingNotification$1) continuation;
            if ((offlineNotificationHelper$cancelDownloadingNotification$1.label & Integer.MIN_VALUE) != 0) {
                offlineNotificationHelper$cancelDownloadingNotification$1.label -= Integer.MIN_VALUE;
                Object $result = offlineNotificationHelper$cancelDownloadingNotification$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineNotificationHelper$cancelDownloadingNotification$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        LogKt.getVBLog().info("OfflineNotificationHelper cancelDownloadingNotification");
                        NotificationManager notificationManager = getNotificationManager();
                        if (notificationManager != null) {
                            notificationManager.cancel(OfflineNotificationHelperKt.ID_NOTIFICATION_DOWNLOADING);
                        }
                        offlineNotificationHelper$cancelDownloadingNotification$1.label = 1;
                        if (YieldKt.yield(offlineNotificationHelper$cancelDownloadingNotification$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Function1<Continuation<? super Boolean>, Object> function1 = this.serviceIdle;
                        offlineNotificationHelper$cancelDownloadingNotification$1.label = 2;
                        invoke = function1.invoke(offlineNotificationHelper$cancelDownloadingNotification$1);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        boolean isServiceIdle = ((Boolean) invoke).booleanValue();
                        LogKt.getVBLog().info("OfflineNotificationHelper checkStopForeground: " + this.serviceForeground + " isServiceIdle=" + isServiceIdle);
                        if (this.serviceForeground && isServiceIdle) {
                            ServiceCompat.stopForeground(this.service, 1);
                            this.serviceForeground = false;
                            LogKt.getVBLog().info("OfflineNotificationHelper service stopForeground.");
                        }
                        return Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        Function1<Continuation<? super Boolean>, Object> function12 = this.serviceIdle;
                        offlineNotificationHelper$cancelDownloadingNotification$1.label = 2;
                        invoke = function12.invoke(offlineNotificationHelper$cancelDownloadingNotification$1);
                        if (invoke == coroutine_suspended) {
                        }
                        boolean isServiceIdle2 = ((Boolean) invoke).booleanValue();
                        LogKt.getVBLog().info("OfflineNotificationHelper checkStopForeground: " + this.serviceForeground + " isServiceIdle=" + isServiceIdle2);
                        if (this.serviceForeground) {
                            ServiceCompat.stopForeground(this.service, 1);
                            this.serviceForeground = false;
                            LogKt.getVBLog().info("OfflineNotificationHelper service stopForeground.");
                        }
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        invoke = $result;
                        boolean isServiceIdle22 = ((Boolean) invoke).booleanValue();
                        LogKt.getVBLog().info("OfflineNotificationHelper checkStopForeground: " + this.serviceForeground + " isServiceIdle=" + isServiceIdle22);
                        if (this.serviceForeground) {
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        offlineNotificationHelper$cancelDownloadingNotification$1 = new OfflineNotificationHelper$cancelDownloadingNotification$1(this, continuation);
        Object $result2 = offlineNotificationHelper$cancelDownloadingNotification$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineNotificationHelper$cancelDownloadingNotification$1.label) {
        }
    }

    public final void updateNotifications(List<OfflineVideoEntity> list) {
        Intrinsics.checkNotNullParameter(list, "entities");
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineNotificationHelper$updateNotifications$1(list, this, null), 3, (Object) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x007e, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5, r6 != null ? r6.getKey() : null) != false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateNotification(final OfflineVideoEntity entity, Continuation<? super Unit> continuation) {
        OfflineNotificationHelper$updateNotification$1 offlineNotificationHelper$updateNotification$1;
        Ref.ObjectRef completed;
        OfflineNotificationState it;
        if (continuation instanceof OfflineNotificationHelper$updateNotification$1) {
            offlineNotificationHelper$updateNotification$1 = (OfflineNotificationHelper$updateNotification$1) continuation;
            if ((offlineNotificationHelper$updateNotification$1.label & Integer.MIN_VALUE) != 0) {
                offlineNotificationHelper$updateNotification$1.label -= Integer.MIN_VALUE;
                Object $result = offlineNotificationHelper$updateNotification$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (offlineNotificationHelper$updateNotification$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        LogKt.getVBLog().info("OfflineNotificationHelper updateNotification: " + entity);
                        if (entity.isDownloading()) {
                            if (getDownloadingNotificationState() != null) {
                                String key = entity.getKey();
                                OfflineNotificationState downloadingNotificationState = getDownloadingNotificationState();
                                break;
                            }
                            this.downloadingStateFlow.setValue(new OfflineNotificationState(OfflineNotificationHelperKt.ID_NOTIFICATION_DOWNLOADING, entity.getKey(), !entity.isDownloading(), entity.isDownloading(), entity.getNotifyBody(), entity.getProgressDesc(), entity.isDownloading(), entity.getProgressPercentage(), 0, Intrinsics.areEqual(entity.getState(), OfflineVideoEntity.State.RESOLVING.INSTANCE), IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN, null));
                            break;
                        } else if (entity.getDownloaded() && entity.getErrorCode() == 0) {
                            String key2 = entity.getKey();
                            OfflineNotificationState downloadingNotificationState2 = getDownloadingNotificationState();
                            if (Intrinsics.areEqual(key2, downloadingNotificationState2 != null ? downloadingNotificationState2.getKey() : null)) {
                                this.downloadingStateFlow.setValue((Object) null);
                            }
                            final Ref.ObjectRef completed2 = new Ref.ObjectRef();
                            Function1<? super ArrayMap<String, Integer>, Unit> function1 = new Function1() { // from class: video.biz.offline.base.facade.notification.OfflineNotificationHelper$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    Unit updateNotification$lambda$0;
                                    updateNotification$lambda$0 = OfflineNotificationHelper.updateNotification$lambda$0(OfflineVideoEntity.this, this, completed2, (ArrayMap) obj);
                                    return updateNotification$lambda$0;
                                }
                            };
                            offlineNotificationHelper$updateNotification$1.L$0 = SpillingKt.nullOutSpilledVariable(entity);
                            offlineNotificationHelper$updateNotification$1.L$1 = completed2;
                            offlineNotificationHelper$updateNotification$1.label = 1;
                            if (safeAccessCompletedNotificationMap(function1, offlineNotificationHelper$updateNotification$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            completed = completed2;
                            it = (OfflineNotificationState) completed.element;
                            if (it != null) {
                                notify(it);
                                break;
                            }
                        } else {
                            String key3 = entity.getKey();
                            OfflineNotificationState downloadingNotificationState3 = getDownloadingNotificationState();
                            if (Intrinsics.areEqual(key3, downloadingNotificationState3 != null ? downloadingNotificationState3.getKey() : null)) {
                                this.downloadingStateFlow.setValue((Object) null);
                                break;
                            }
                        }
                        break;
                    case 1:
                        completed = (Ref.ObjectRef) offlineNotificationHelper$updateNotification$1.L$1;
                        OfflineVideoEntity offlineVideoEntity = (OfflineVideoEntity) offlineNotificationHelper$updateNotification$1.L$0;
                        ResultKt.throwOnFailure($result);
                        it = (OfflineNotificationState) completed.element;
                        if (it != null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        offlineNotificationHelper$updateNotification$1 = new OfflineNotificationHelper$updateNotification$1(this, continuation);
        Object $result2 = offlineNotificationHelper$updateNotification$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineNotificationHelper$updateNotification$1.label) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateNotification$lambda$0(OfflineVideoEntity $entity, OfflineNotificationHelper this$0, Ref.ObjectRef $completed, ArrayMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        if (!((Map) map).containsKey($entity.getKey())) {
            int id = this$0.completedNotificationId.incrementAndGet();
            String key = $entity.getKey();
            String string = FoundationAlias.getFapp().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_1842);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            $completed.element = new OfflineNotificationState(id, key, true, false, string, $entity.getNotifyBody(), false, 0, 0, false);
            ((Map) map).put($entity.getKey(), Integer.valueOf(id));
            LogKt.getVBLog().info("OfflineNotificationHelper save completed notification: key" + $entity.getKey() + " id=" + id);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notify(OfflineNotificationState state) {
        LogKt.getVBLog().info("OfflineNotificationHelper notify: " + state);
        try {
            Notification notification = getBuilder().setAutoCancel(state.getAutoCancel()).setOngoing(state.getOngoing()).setContentTitle(state.getContentTitle()).setContentText(state.getContentText()).setTicker(state.getContentTitle()).setWhen(System.currentTimeMillis()).setProgress(state.getMax(), state.getProgress(), state.getIndeterminate()).setContentIntent(getPendingIntent(this.service)).build();
            Intrinsics.checkNotNullExpressionValue(notification, "build(...)");
            if (state.getOngoing() && !this.serviceForeground) {
                startForeground(state.getNotificationId(), notification);
            } else {
                NotificationManager notificationManager = getNotificationManager();
                if (notificationManager != null) {
                    notificationManager.notify(state.getNotificationId(), notification);
                }
            }
        } catch (Exception e) {
            LogKt.getVBLog().error("OfflineNotificationHelper notify error", e);
        }
    }

    private final PendingIntent getPendingIntent(Context context) {
        Uri uri;
        Intent intent = new Intent();
        intent.setClassName(context, OfflineNotificationHelperKt.INTENT_HANDLER_ACTIVITY);
        intent.addFlags(335544320);
        if (AppBuildConfig.Companion.isHDApp(FoundationAlias.getFapp())) {
            uri = Uri.parse(OfflineNotificationHelperKt.MINE_URI);
        } else {
            uri = Uri.parse(OfflineNotificationHelperKt.ROUTE_URI_DOWNLOAD_LIST);
        }
        intent.setData(uri);
        PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity(context, 0, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity, "getActivity(...)");
        return __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity;
    }

    private final void startForeground(int notificationId, Notification notification) {
        int type;
        if (Build.VERSION.SDK_INT >= 29) {
            if (Build.VERSION.SDK_INT >= 35) {
                type = 8193;
            } else {
                type = 1;
            }
            ServiceCompat.startForeground(this.service, notificationId, notification, type);
        } else {
            __Ghost$Insertion$com_bilibili_infra_base_aop_StartForegroundHook_startForeground(this.service, notificationId, notification);
        }
        this.serviceForeground = true;
        LogKt.getVBLog().info("OfflineNotificationHelper service startForeground id=" + notificationId);
    }

    public final void release() {
        LogKt.getVBLog().info("OfflineNotificationHelper release serviceForeground: " + this.serviceForeground);
        if (this.serviceForeground) {
            ServiceCompat.stopForeground(this.service, 1);
            this.serviceForeground = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object safeAccessCompletedNotificationMap(Function1<? super ArrayMap<String, Integer>, Unit> function1, Continuation<? super Unit> continuation) {
        OfflineNotificationHelper$safeAccessCompletedNotificationMap$1 offlineNotificationHelper$safeAccessCompletedNotificationMap$1;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        try {
            if (continuation instanceof OfflineNotificationHelper$safeAccessCompletedNotificationMap$1) {
                offlineNotificationHelper$safeAccessCompletedNotificationMap$1 = (OfflineNotificationHelper$safeAccessCompletedNotificationMap$1) continuation;
                if ((offlineNotificationHelper$safeAccessCompletedNotificationMap$1.label & Integer.MIN_VALUE) != 0) {
                    offlineNotificationHelper$safeAccessCompletedNotificationMap$1.label -= Integer.MIN_VALUE;
                    Object $result = offlineNotificationHelper$safeAccessCompletedNotificationMap$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (offlineNotificationHelper$safeAccessCompletedNotificationMap$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            $this$withLock_u24default$iv = this.mutex;
                            owner$iv = null;
                            offlineNotificationHelper$safeAccessCompletedNotificationMap$1.L$0 = function1;
                            offlineNotificationHelper$safeAccessCompletedNotificationMap$1.L$1 = $this$withLock_u24default$iv;
                            offlineNotificationHelper$safeAccessCompletedNotificationMap$1.I$0 = 0;
                            offlineNotificationHelper$safeAccessCompletedNotificationMap$1.label = 1;
                            if ($this$withLock_u24default$iv.lock((Object) null, offlineNotificationHelper$safeAccessCompletedNotificationMap$1) != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 1:
                            int i = offlineNotificationHelper$safeAccessCompletedNotificationMap$1.I$0;
                            owner$iv = null;
                            $this$withLock_u24default$iv = (Mutex) offlineNotificationHelper$safeAccessCompletedNotificationMap$1.L$1;
                            function1 = (Function1) offlineNotificationHelper$safeAccessCompletedNotificationMap$1.L$0;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1.invoke(this.completedNotificationMap);
                    Unit unit = Unit.INSTANCE;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    return Unit.INSTANCE;
                }
            }
            function1.invoke(this.completedNotificationMap);
            Unit unit2 = Unit.INSTANCE;
            $this$withLock_u24default$iv.unlock(owner$iv);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            $this$withLock_u24default$iv.unlock(owner$iv);
            throw th;
        }
        offlineNotificationHelper$safeAccessCompletedNotificationMap$1 = new OfflineNotificationHelper$safeAccessCompletedNotificationMap$1(this, continuation);
        Object $result2 = offlineNotificationHelper$safeAccessCompletedNotificationMap$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (offlineNotificationHelper$safeAccessCompletedNotificationMap$1.label) {
        }
    }

    private final String getDefaultChannelId(Context context) {
        String channelId;
        if (AppBuildConfig.Companion.isHDApp(FoundationAlias.getFapp())) {
            channelId = OfflineNotificationHelperKt.CHANNEL_HD_ID_DEFAULT;
        } else {
            channelId = OfflineNotificationHelperKt.CHANNEL_ID_DEFAULT;
        }
        registerChannelId(channelId, context);
        return channelId;
    }

    private final void registerChannelId(String channelId, Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        Object systemService = context.getSystemService("notification");
        NotificationManager nm = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        if (nm == null) {
            return;
        }
        NotificationChannel channel = new NotificationChannel(channelId, getChannelName(channelId), 3);
        channel.setDescription(getChannelDescription(channelId));
        channel.setSound(null, null);
        nm.createNotificationChannel(channel);
    }

    private final String getChannelName(String channelId) {
        if (!Intrinsics.areEqual(channelId, OfflineNotificationHelperKt.CHANNEL_HD_ID_DEFAULT)) {
            String string = FoundationAlias.getFapp().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_2207);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        String string2 = FoundationAlias.getFapp().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_2214);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    private final String getChannelDescription(String channelId) {
        if (!Intrinsics.areEqual(channelId, OfflineNotificationHelperKt.CHANNEL_HD_ID_DEFAULT)) {
            String string = FoundationAlias.getFapp().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_2202);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        String string2 = FoundationAlias.getFapp().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_2185);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }
}