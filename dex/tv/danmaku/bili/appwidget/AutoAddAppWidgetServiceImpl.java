package tv.danmaku.bili.appwidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bapis.bilibili.app.show.mixture.v1.WidgetGuideReply;
import com.bilibili.droid.DimenUtilsKt;
import com.bilibili.moduleservice.appwidget.AutoAddAppWidgetService;
import com.bilibili.moduleservice.appwidget.GuideScene;
import javax.inject.Singleton;
import kntr.app.appwidget.guide.AppWidgetGuideHolder;
import kntr.app.appwidget.guide.PlatformContext_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.guide.AddWidgetGuidePopupWindowManager;
import tv.danmaku.bili.appwidget.guide.WidgetGuideKt;
import tv.danmaku.bili.appwidget.guide.function.FunctionWidgetGuideManager;
import tv.danmaku.bili.appwidget.guide.utils.AutoAddWidgetSceneExtKt;
import tv.danmaku.bili.appwidget.upcard.UpCardAppWidget;
import tv.danmaku.bili.appwidget.utils.WidgetUtilsKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: AutoAddAppWidgetServiceImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J&\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\u001c¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/appwidget/AutoAddAppWidgetServiceImpl;", "Lcom/bilibili/moduleservice/appwidget/AutoAddAppWidgetService;", "<init>", "()V", "tryToAddUpCardWidget", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "scene", "Lcom/bilibili/moduleservice/appwidget/GuideScene;", "startFunctionWidgetGuide", "onVisibleChange", "visible", "", "closeWidgetGuide", "closeFunctionWidgetGuide", "tryToAddAppWidget", "(Landroidx/fragment/app/FragmentActivity;Lcom/bilibili/moduleservice/appwidget/GuideScene;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryToAddAppWidgetV2", "tryToAddAppWidgetFromMainSpace", "checkAutoAddAppWidgetRequest", "context", "Landroid/content/Context;", "appWidgetClz", "", "showAddAppWidgetGuide", "reply", "Lcom/bapis/bilibili/app/show/mixture/v1/WidgetGuideReply;", "(Landroidx/fragment/app/FragmentActivity;Lcom/bapis/bilibili/app/show/mixture/v1/WidgetGuideReply;Lcom/bilibili/moduleservice/appwidget/GuideScene;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AutoAddAppWidgetServiceImpl implements AutoAddAppWidgetService {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "AutoAddAppWidgetServiceImpl";

    public void tryToAddUpCardWidget(FragmentActivity activity, GuideScene scene) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(scene, "scene");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) activity), (CoroutineContext) null, (CoroutineStart) null, new AutoAddAppWidgetServiceImpl$tryToAddUpCardWidget$1(scene, this, activity, null), 3, (Object) null);
    }

    public void startFunctionWidgetGuide(FragmentActivity activity, GuideScene scene) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(scene, "scene");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) activity), (CoroutineContext) null, (CoroutineStart) null, new AutoAddAppWidgetServiceImpl$startFunctionWidgetGuide$1(this, activity, scene, null), 3, (Object) null);
    }

    public void onVisibleChange(GuideScene scene, boolean visible) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (scene instanceof GuideScene.DynamicHome) {
            AddWidgetGuidePopupWindowManager.INSTANCE.hideWidgetGuide(scene, visible);
        }
    }

    public void closeWidgetGuide(FragmentActivity activity, GuideScene scene) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(scene, "scene");
        try {
            PlatformContext_androidKt.closeGuidePopup(activity);
            if (!(scene instanceof GuideScene.DynamicHome)) {
                AddWidgetGuidePopupWindowManager.INSTANCE.closeWidgetGuide();
            }
        } catch (Exception e) {
            BLog.e(TAG, "closeWidgetGuide -> error " + e);
        }
    }

    public boolean closeFunctionWidgetGuide(FragmentActivity activity, GuideScene scene) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (scene instanceof GuideScene.Function) {
            return FunctionWidgetGuideManager.INSTANCE.unregisterFunctionGuide(activity, scene);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object tryToAddAppWidget(FragmentActivity activity, GuideScene scene, Continuation<? super Unit> continuation) {
        AutoAddAppWidgetServiceImpl$tryToAddAppWidget$1 autoAddAppWidgetServiceImpl$tryToAddAppWidget$1;
        Object suspendWidgetGuide;
        FragmentActivity activity2;
        AutoAddAppWidgetServiceImpl autoAddAppWidgetServiceImpl;
        WidgetGuideReply reply;
        if (continuation instanceof AutoAddAppWidgetServiceImpl$tryToAddAppWidget$1) {
            autoAddAppWidgetServiceImpl$tryToAddAppWidget$1 = (AutoAddAppWidgetServiceImpl$tryToAddAppWidget$1) continuation;
            if ((autoAddAppWidgetServiceImpl$tryToAddAppWidget$1.label & Integer.MIN_VALUE) != 0) {
                autoAddAppWidgetServiceImpl$tryToAddAppWidget$1.label -= Integer.MIN_VALUE;
                Object $result = autoAddAppWidgetServiceImpl$tryToAddAppWidget$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (autoAddAppWidgetServiceImpl$tryToAddAppWidget$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String name = UpCardAppWidget.class.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        if (!checkAutoAddAppWidgetRequest((Context) activity, name)) {
                            return Unit.INSTANCE;
                        }
                        autoAddAppWidgetServiceImpl$tryToAddAppWidget$1.L$0 = activity;
                        autoAddAppWidgetServiceImpl$tryToAddAppWidget$1.L$1 = scene;
                        autoAddAppWidgetServiceImpl$tryToAddAppWidget$1.label = 1;
                        suspendWidgetGuide = WidgetGuideKt.suspendWidgetGuide(scene, autoAddAppWidgetServiceImpl$tryToAddAppWidget$1);
                        if (suspendWidgetGuide == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        activity2 = activity;
                        autoAddAppWidgetServiceImpl = this;
                        reply = (WidgetGuideReply) suspendWidgetGuide;
                        if (reply != null) {
                            return Unit.INSTANCE;
                        }
                        if (!WidgetGuideKt.show(reply)) {
                            return Unit.INSTANCE;
                        }
                        autoAddAppWidgetServiceImpl$tryToAddAppWidget$1.L$0 = null;
                        autoAddAppWidgetServiceImpl$tryToAddAppWidget$1.L$1 = null;
                        autoAddAppWidgetServiceImpl$tryToAddAppWidget$1.label = 2;
                        if (autoAddAppWidgetServiceImpl.showAddAppWidgetGuide(activity2, reply, scene, autoAddAppWidgetServiceImpl$tryToAddAppWidget$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        autoAddAppWidgetServiceImpl = this;
                        scene = (GuideScene) autoAddAppWidgetServiceImpl$tryToAddAppWidget$1.L$1;
                        activity2 = (FragmentActivity) autoAddAppWidgetServiceImpl$tryToAddAppWidget$1.L$0;
                        ResultKt.throwOnFailure($result);
                        suspendWidgetGuide = $result;
                        reply = (WidgetGuideReply) suspendWidgetGuide;
                        if (reply != null) {
                        }
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        autoAddAppWidgetServiceImpl$tryToAddAppWidget$1 = new AutoAddAppWidgetServiceImpl$tryToAddAppWidget$1(this, continuation);
        Object $result2 = autoAddAppWidgetServiceImpl$tryToAddAppWidget$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (autoAddAppWidgetServiceImpl$tryToAddAppWidget$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|7|8|14|15))|50|6|7|8|14|15|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033 A[Catch: Exception -> 0x003c, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x003c, blocks: (B:12:0x0033, B:19:0x0091, B:22:0x0099, B:27:0x00bc, B:29:0x00c4), top: B:52:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object tryToAddAppWidgetV2(FragmentActivity activity, GuideScene scene, Continuation<? super Unit> continuation) {
        AutoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$1 autoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$1;
        AutoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$1 autoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$12;
        AppWidgetGuideHolder holder;
        String name;
        String spmid;
        long upperMid;
        int dpToPx;
        int number;
        long displayDurationMs;
        long aid;
        boolean z;
        if (continuation instanceof AutoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$1) {
            autoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$1 = (AutoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$1) continuation;
            if ((autoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$1.label & Integer.MIN_VALUE) != 0) {
                autoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$1.label -= Integer.MIN_VALUE;
                autoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$12 = autoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$1;
                Object $result = autoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (autoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            CoroutineContext coroutineContext = (CoroutineExceptionHandler) new AutoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
                            holder = new AppWidgetGuideHolder();
                            GuideScene.PlayerVideoDetail playerVideoDetail = null;
                            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) activity), coroutineContext, (CoroutineStart) null, new AutoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$2(holder, activity, scene, null), 2, (Object) null);
                            name = AutoAddWidgetSceneExtKt.component(scene).getName();
                            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                            spmid = AutoAddWidgetSceneExtKt.spmid(scene);
                            GuideScene.AuthorSpace authorSpace = scene instanceof GuideScene.AuthorSpace ? (GuideScene.AuthorSpace) scene : null;
                            upperMid = authorSpace != null ? authorSpace.getUpperMid() : 0L;
                            dpToPx = DimenUtilsKt.dpToPx(AutoAddWidgetSceneExtKt.offset(scene));
                            number = AutoAddWidgetSceneExtKt.guideType(scene).getNumber();
                            displayDurationMs = AutoAddWidgetSceneExtKt.displayDurationMs(scene);
                            boolean outsideTouchable = AutoAddWidgetSceneExtKt.outsideTouchable(scene);
                            if (scene instanceof GuideScene.PlayerVideoDetail) {
                                playerVideoDetail = (GuideScene.PlayerVideoDetail) scene;
                            }
                            aid = playerVideoDetail != null ? AutoAddWidgetSceneExtKt.aid(playerVideoDetail) : 0L;
                            z = outsideTouchable;
                            autoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$12.label = 1;
                        } catch (Exception e) {
                            e = e;
                        }
                        try {
                            if (holder.showGuide(activity, name, spmid, upperMid, number, dpToPx, displayDurationMs, z, aid, autoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            BLog.e(TAG, "tryToAddAppWidgetV2 error = " + e);
                            return Unit.INSTANCE;
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        autoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$1 = new AutoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$1(this, continuation);
        autoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$12 = autoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$1;
        Object $result2 = autoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (autoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$12.label) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|7|8|14|15))|42|6|7|8|14|15|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033 A[Catch: Exception -> 0x003c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x003c, blocks: (B:12:0x0033, B:19:0x007f, B:21:0x0084), top: B:41:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object tryToAddAppWidgetFromMainSpace(FragmentActivity activity, GuideScene scene, Continuation<? super Unit> continuation) {
        AutoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$1 autoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$1;
        AutoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$1 autoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$12;
        AppWidgetGuideHolder holder;
        String name;
        String spmid;
        long upperMid;
        int dpToPx;
        int number;
        boolean z;
        if (continuation instanceof AutoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$1) {
            autoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$1 = (AutoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$1) continuation;
            if ((autoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$1.label & Integer.MIN_VALUE) != 0) {
                autoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$1.label -= Integer.MIN_VALUE;
                autoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$12 = autoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$1;
                Object $result = autoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (autoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            holder = new AppWidgetGuideHolder();
                            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) activity), (CoroutineContext) null, (CoroutineStart) null, new AutoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$2(holder, activity, scene, null), 3, (Object) null);
                            name = AutoAddWidgetSceneExtKt.component(scene).getName();
                            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                            spmid = AutoAddWidgetSceneExtKt.spmid(scene);
                            GuideScene.AuthorSpace authorSpace = scene instanceof GuideScene.AuthorSpace ? (GuideScene.AuthorSpace) scene : null;
                            upperMid = authorSpace != null ? authorSpace.getUpperMid() : 0L;
                            dpToPx = DimenUtilsKt.dpToPx(AutoAddWidgetSceneExtKt.offset(scene));
                            number = AutoAddWidgetSceneExtKt.guideType(scene).getNumber();
                            z = AutoAddWidgetSceneExtKt.outsideTouchable(scene);
                            autoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$12.label = 1;
                        } catch (Exception e) {
                            e = e;
                        }
                        try {
                            if (AppWidgetGuideHolder.showGuide$default(holder, activity, name, spmid, upperMid, number, dpToPx, 0L, z, 0L, autoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$12, (int) BR.isFullScreen, (Object) null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            BLog.e(TAG, "tryToAddAppWidgetFromMainSpace error = " + e);
                            return Unit.INSTANCE;
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        autoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$1 = new AutoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$1(this, continuation);
        autoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$12 = autoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$1;
        Object $result2 = autoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (autoAddAppWidgetServiceImpl$tryToAddAppWidgetFromMainSpace$12.label) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkAutoAddAppWidgetRequest(Context context, String appWidgetClz) {
        if (Build.VERSION.SDK_INT < 26) {
            BLog.i(TAG, "checkAutoAddAppWidgetRequest -> unsupported version");
            return false;
        }
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        if (!appWidgetManager.isRequestPinAppWidgetSupported()) {
            BLog.i(TAG, "checkAutoAddAppWidgetRequest -> pin widget not supported");
            return false;
        } else if (WidgetUtilsKt.isWidgetAdded(context, appWidgetClz)) {
            BLog.i(TAG, "checkAutoAddAppWidgetRequest -> widget added");
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showAddAppWidgetGuide(FragmentActivity activity, WidgetGuideReply reply, GuideScene scene, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new AutoAddAppWidgetServiceImpl$showAddAppWidgetGuide$2(activity, reply, scene, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* compiled from: AutoAddAppWidgetServiceImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/appwidget/AutoAddAppWidgetServiceImpl$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}