package tv.danmaku.bili.appwidget.guide.function;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bapis.bilibili.app.show.mixture.v1.WidgetGuideReply;
import com.bilibili.base.BiliContext;
import com.bilibili.moduleservice.appwidget.GuideScene;
import com.bilibili.moduleservice.appwidget.IFunctionWidgetGuide;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.guide.AddWidgetGuidePopupWindowManager;
import tv.danmaku.bili.appwidget.guide.WidgetGuideKt;
import tv.danmaku.bili.appwidget.hotword.HotWordAppWidget;
import tv.danmaku.bili.appwidget.utils.WidgetUtilsKt;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: FunctionWidgetGuideManager.kt */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\r\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0019H\u0002J\u001e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006!"}, d2 = {"Ltv/danmaku/bili/appwidget/guide/function/FunctionWidgetGuideManager;", "", "<init>", "()V", "TAG", "", "routeTraceManager", "Ltv/danmaku/bili/appwidget/guide/function/RouteTraceManager;", "showGuide", "", "reply", "Lcom/bapis/bilibili/app/show/mixture/v1/WidgetGuideReply;", AuthResultCbHelper.ARGS_CALLBACK, "tv/danmaku/bili/appwidget/guide/function/FunctionWidgetGuideManager$callback$1", "Ltv/danmaku/bili/appwidget/guide/function/FunctionWidgetGuideManager$callback$1;", "registerFunctionGuide", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "scene", "Lcom/bilibili/moduleservice/appwidget/GuideScene;", "unregisterFunctionGuide", "initialRouteWhiteList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkBackToTarget", "Landroid/app/Activity;", "inFunctionPage", "showWidgetGuide", "(Landroidx/fragment/app/FragmentActivity;Lcom/bilibili/moduleservice/appwidget/GuideScene;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkAutoAddAppWidgetRequest", "context", "Landroid/content/Context;", "destroy", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FunctionWidgetGuideManager {
    private static final String TAG = "FunctionWidgetGuideManager";
    private static WidgetGuideReply reply;
    private static boolean showGuide;
    public static final FunctionWidgetGuideManager INSTANCE = new FunctionWidgetGuideManager();
    private static final RouteTraceManager routeTraceManager = new RouteTraceManager();
    private static final FunctionWidgetGuideManager$callback$1 callback = new BiliContext.ActivityStateCallback() { // from class: tv.danmaku.bili.appwidget.guide.function.FunctionWidgetGuideManager$callback$1
        public void onActivityResumed(Activity activity) {
            RouteTraceManager routeTraceManager2;
            Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            super.onActivityResumed(activity);
            if (RouteFilterKt.validRouteFilter(activity)) {
                FunctionWidgetGuideManager.INSTANCE.checkBackToTarget(activity);
                routeTraceManager2 = FunctionWidgetGuideManager.routeTraceManager;
                routeTraceManager2.push(activity);
            }
        }
    };
    public static final int $stable = 8;

    private FunctionWidgetGuideManager() {
    }

    public final void registerFunctionGuide(FragmentActivity activity, GuideScene scene) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(scene, "scene");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) activity), (CoroutineContext) null, (CoroutineStart) null, new FunctionWidgetGuideManager$registerFunctionGuide$1(activity, scene, null), 3, (Object) null);
    }

    public final boolean unregisterFunctionGuide(final FragmentActivity activity, final GuideScene scene) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (routeTraceManager.size() > 1) {
            routeTraceManager.destroy();
            BiliContext.unregisterActivityStateCallback(callback);
            showGuide = false;
            reply = null;
            return false;
        }
        BiliContext.unregisterActivityStateCallback(callback);
        routeTraceManager.destroy();
        if (showGuide) {
            WidgetGuideReply widgetGuideReply = reply;
            if (widgetGuideReply != null && WidgetGuideKt.show(widgetGuideReply)) {
                AddWidgetGuidePopupWindowManager addWidgetGuidePopupWindowManager = AddWidgetGuidePopupWindowManager.INSTANCE;
                WidgetGuideReply widgetGuideReply2 = reply;
                Intrinsics.checkNotNull(widgetGuideReply2);
                addWidgetGuidePopupWindowManager.showWidgetGuide(activity, widgetGuideReply2, scene, new Function1() { // from class: tv.danmaku.bili.appwidget.guide.function.FunctionWidgetGuideManager$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit unregisterFunctionGuide$lambda$0;
                        unregisterFunctionGuide$lambda$0 = FunctionWidgetGuideManager.unregisterFunctionGuide$lambda$0(activity, scene, ((Boolean) obj).booleanValue());
                        return unregisterFunctionGuide$lambda$0;
                    }
                });
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) activity), (CoroutineContext) null, (CoroutineStart) null, new FunctionWidgetGuideManager$unregisterFunctionGuide$2(scene, null), 3, (Object) null);
                showGuide = false;
                reply = null;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit unregisterFunctionGuide$lambda$0(FragmentActivity $activity, GuideScene $scene, boolean exitPage) {
        if (exitPage) {
            $activity.finish();
        }
        AddWidgetGuidePopupWindowManager.INSTANCE.hideWidgetGuide($scene, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object initialRouteWhiteList(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new FunctionWidgetGuideManager$initialRouteWhiteList$2(null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkBackToTarget(Activity activity) {
        GuideScene scene;
        if (routeTraceManager.size() < 2) {
            return;
        }
        RouteNode node = routeTraceManager.pop(activity);
        if (node == null) {
            return;
        }
        RouteNode currNode = routeTraceManager.peek(activity);
        boolean z = false;
        if (currNode != null && currNode.isFunction()) {
            z = true;
        }
        if (z && (scene = currNode.getScene()) != null && inFunctionPage(activity)) {
            FragmentActivity it = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
            if (it != null) {
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) it), (CoroutineContext) null, (CoroutineStart) null, new FunctionWidgetGuideManager$checkBackToTarget$1$1(it, scene, null), 3, (Object) null);
            }
        }
    }

    private final boolean inFunctionPage(Activity activity) {
        if (activity instanceof IFunctionWidgetGuide) {
            return true;
        }
        FragmentActivity it = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        if (it != null) {
            Fragment fragment = it.getSupportFragmentManager().findFragmentById(16908290);
            return fragment instanceof IFunctionWidgetGuide;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object showWidgetGuide(FragmentActivity activity, GuideScene scene, Continuation<? super Unit> continuation) {
        FunctionWidgetGuideManager$showWidgetGuide$1 functionWidgetGuideManager$showWidgetGuide$1;
        Object suspendWidgetGuide;
        WidgetGuideReply widgetGuideReply;
        if (continuation instanceof FunctionWidgetGuideManager$showWidgetGuide$1) {
            functionWidgetGuideManager$showWidgetGuide$1 = (FunctionWidgetGuideManager$showWidgetGuide$1) continuation;
            if ((functionWidgetGuideManager$showWidgetGuide$1.label & Integer.MIN_VALUE) != 0) {
                functionWidgetGuideManager$showWidgetGuide$1.label -= Integer.MIN_VALUE;
                Object $result = functionWidgetGuideManager$showWidgetGuide$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (functionWidgetGuideManager$showWidgetGuide$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!checkAutoAddAppWidgetRequest((Context) activity)) {
                            return Unit.INSTANCE;
                        }
                        functionWidgetGuideManager$showWidgetGuide$1.label = 1;
                        suspendWidgetGuide = WidgetGuideKt.suspendWidgetGuide(scene, functionWidgetGuideManager$showWidgetGuide$1);
                        if (suspendWidgetGuide == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        suspendWidgetGuide = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                widgetGuideReply = (WidgetGuideReply) suspendWidgetGuide;
                if (widgetGuideReply != null) {
                    return Unit.INSTANCE;
                }
                reply = widgetGuideReply;
                if (!WidgetGuideKt.show(reply)) {
                    showGuide = false;
                    return Unit.INSTANCE;
                }
                showGuide = true;
                return Unit.INSTANCE;
            }
        }
        functionWidgetGuideManager$showWidgetGuide$1 = new FunctionWidgetGuideManager$showWidgetGuide$1(this, continuation);
        Object $result2 = functionWidgetGuideManager$showWidgetGuide$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (functionWidgetGuideManager$showWidgetGuide$1.label) {
        }
        widgetGuideReply = (WidgetGuideReply) suspendWidgetGuide;
        if (widgetGuideReply != null) {
        }
    }

    private final boolean checkAutoAddAppWidgetRequest(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            BLog.i(TAG, "checkAutoAddAppWidgetRequest -> unsupported version");
            return false;
        }
        try {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            if (!appWidgetManager.isRequestPinAppWidgetSupported()) {
                BLog.i(TAG, "checkAutoAddAppWidgetRequest -> pin widget not supported");
                return false;
            }
            String name = HotWordAppWidget.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (WidgetUtilsKt.isWidgetAdded(context, name)) {
                BLog.i(TAG, "checkAutoAddAppWidgetRequest -> widget added");
                return false;
            } else if (!FunctionWidgetUtilsKt.enableFunctionGuideWidget()) {
                BLog.i(TAG, "checkAutoAddAppWidgetRequest -> Not Hit");
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            BLog.e(TAG, "checkAutoAddAppWidgetRequest error = " + e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void destroy(Activity activity, GuideScene scene) {
        if (routeTraceManager.size() < 2) {
            RouteNode it = routeTraceManager.peek(activity);
            if (it != null && !Intrinsics.areEqual(it.getScene(), scene)) {
                return;
            }
            routeTraceManager.destroy();
        }
    }
}