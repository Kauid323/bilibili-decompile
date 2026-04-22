package tv.danmaku.bili.appwidget.hotword.work;

import android.app.Application;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.bilibili.base.BiliContext;
import com.bilibili.base.util.DelayTaskController;
import com.bilibili.droid.ToastHelper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.BuildConfig;
import tv.danmaku.bili.appwidget.hotword.HotWordAppWidget;
import tv.danmaku.bili.appwidget.hotword.HotWordAppWidgetUpdater;
import tv.danmaku.bili.appwidget.hotword.api.AppWidgetHelperKt;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: BiliWidgetWork.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/appwidget/hotword/work/BiliWidgetWorkManager;", "", "<init>", "()V", "Companion", "BiliWidgetWork", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliWidgetWorkManager {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    /* compiled from: BiliWidgetWork.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/appwidget/hotword/work/BiliWidgetWorkManager$Companion;", "", "<init>", "()V", ReportUtilKt.POS_UPDATE, "", "context", "Landroid/content/Context;", "cancelWork", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean update(Context context) {
            if (context == null) {
                return false;
            }
            if (DelayTaskController.shouldBlock()) {
                if (BuildConfig.DEBUG) {
                    ToastHelper.showToast(context, "DEBUG: WIDGET未同意隐私协议", 0);
                }
                return false;
            }
            AppWidgetManager manager = AppWidgetManager.getInstance(context);
            if (manager == null) {
                return false;
            }
            int[] appWidgetIds = manager.getAppWidgetIds(new ComponentName(context, HotWordAppWidget.class));
            if (appWidgetIds != null) {
                if (!(appWidgetIds.length == 0)) {
                    HotWordAppWidgetUpdater hotWordAppWidgetUpdater = HotWordAppWidgetUpdater.INSTANCE;
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    hotWordAppWidgetUpdater.updateAppWidget(applicationContext, manager, appWidgetIds);
                    long interval = AppWidgetHelperKt.getWidgetRefreshIntervalSecond();
                    BLog.i(BiliWidgetWorkKt.WIDGET_UPDATE_TAG, "update BiliWidgetWork " + interval);
                    Application $this$update_u24lambda_u240 = BiliContext.application();
                    if ($this$update_u24lambda_u240 != null) {
                        Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).setRequiresBatteryNotLow(true).build();
                        Intrinsics.checkNotNullExpressionValue(constraints, "build(...)");
                        PeriodicWorkRequest build = new PeriodicWorkRequest.Builder(BiliWidgetWork.class, interval, TimeUnit.SECONDS).setInitialDelay(interval, TimeUnit.SECONDS).setConstraints(constraints).addTag(BiliWidgetWorkKt.WIDGET_UPDATE_TAG).build();
                        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                        PeriodicWorkRequest request = build;
                        WorkManager instance = WorkManager.getInstance($this$update_u24lambda_u240);
                        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
                        instance.enqueueUniquePeriodicWork(BiliWidgetWorkKt.WIDGET_UPDATE_TAG, ExistingPeriodicWorkPolicy.REPLACE, request);
                    }
                    return true;
                }
            }
            cancelWork(context);
            return false;
        }

        public final void cancelWork(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            BLog.i(BiliWidgetWorkKt.WIDGET_UPDATE_TAG, "cancel all work");
            WorkManager instance = WorkManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
            instance.cancelUniqueWork(BiliWidgetWorkKt.WIDGET_UPDATE_TAG);
        }
    }

    /* compiled from: BiliWidgetWork.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/appwidget/hotword/work/BiliWidgetWorkManager$BiliWidgetWork;", "Landroidx/work/Worker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "getContext", "()Landroid/content/Context;", "doWork", "Landroidx/work/ListenableWorker$Result;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class BiliWidgetWork extends Worker {
        public static final int $stable = 8;
        private final Context context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BiliWidgetWork(Context context, WorkerParameters workerParams) {
            super(context, workerParams);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(workerParams, "workerParams");
            this.context = context;
        }

        public final Context getContext() {
            return this.context;
        }

        public ListenableWorker.Result doWork() {
            long start = SystemClock.elapsedRealtime();
            BLog.i(BiliWidgetWorkKt.WIDGET_UPDATE_TAG, "start doWork " + Thread.currentThread());
            AppWidgetManager widgetManager = AppWidgetManager.getInstance(this.context);
            int[] appWidgetIds = widgetManager.getAppWidgetIds(new ComponentName(this.context, HotWordAppWidget.class));
            if (appWidgetIds != null) {
                if (!(appWidgetIds.length == 0)) {
                    CountDownLatch lock = new CountDownLatch(1);
                    BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())), (CoroutineContext) null, (CoroutineStart) null, new BiliWidgetWorkManager$BiliWidgetWork$doWork$1(this, widgetManager, appWidgetIds, lock, null), 3, (Object) null);
                    lock.await();
                    BLog.i(BiliWidgetWorkKt.WIDGET_UPDATE_TAG, "end doWork coast " + (SystemClock.elapsedRealtime() - start));
                    ListenableWorker.Result success = ListenableWorker.Result.success();
                    Intrinsics.checkNotNullExpressionValue(success, "success(...)");
                    return success;
                }
            }
            BiliWidgetWorkManager.Companion.cancelWork(this.context);
            ListenableWorker.Result success2 = ListenableWorker.Result.success();
            Intrinsics.checkNotNullExpressionValue(success2, "success(...)");
            return success2;
        }
    }
}