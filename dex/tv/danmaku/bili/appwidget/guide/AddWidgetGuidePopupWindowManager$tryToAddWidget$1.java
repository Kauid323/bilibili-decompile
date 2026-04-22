package tv.danmaku.bili.appwidget.guide;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import bili.resource.homepage.R;
import com.bapis.bilibili.app.show.mixture.v1.GuideItem;
import com.bilibili.app.comm.list.common.widget.PromoToast;
import com.bilibili.base.BiliContext;
import com.bilibili.moduleservice.appwidget.GuideScene;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.guide.utils.AppWidgetManagerUtil;
import tv.danmaku.bili.appwidget.guide.utils.AutoAddWidgetSceneExtKt;
import tv.danmaku.bili.appwidget.guide.utils.ReportHelperKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AddWidgetGuidePopupWindowManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.guide.AddWidgetGuidePopupWindowManager$tryToAddWidget$1", f = "AddWidgetGuidePopupWindowManager.kt", i = {0}, l = {BR.chatPlayerInputHint, BR.contentColor}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
public final class AddWidgetGuidePopupWindowManager$tryToAddWidget$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ GuideItem $guideItem;
    final /* synthetic */ GuideScene $scene;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddWidgetGuidePopupWindowManager$tryToAddWidget$1(FragmentActivity fragmentActivity, GuideScene guideScene, GuideItem guideItem, Continuation<? super AddWidgetGuidePopupWindowManager$tryToAddWidget$1> continuation) {
        super(2, continuation);
        this.$activity = fragmentActivity;
        this.$scene = guideScene;
        this.$guideItem = guideItem;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> addWidgetGuidePopupWindowManager$tryToAddWidget$1 = new AddWidgetGuidePopupWindowManager$tryToAddWidget$1(this.$activity, this.$scene, this.$guideItem, continuation);
        addWidgetGuidePopupWindowManager$tryToAddWidget$1.L$0 = obj;
        return addWidgetGuidePopupWindowManager$tryToAddWidget$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0124, code lost:
        if (r0 != null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0126, code lost:
        kotlinx.coroutines.Job.DefaultImpls.cancel$default(r0, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0129, code lost:
        r0 = tv.danmaku.bili.appwidget.guide.AddWidgetGuidePopupWindowManager.INSTANCE;
        tv.danmaku.bili.appwidget.guide.AddWidgetGuidePopupWindowManager.showGuideJob = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x013b, code lost:
        if (r0 == null) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068 A[Catch: all -> 0x0018, CancellationException -> 0x001b, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x001b, blocks: (B:6:0x0013, B:13:0x0022, B:20:0x005c, B:22:0x0068, B:28:0x0099, B:30:0x009f, B:36:0x00b0, B:38:0x00b6, B:44:0x00c7, B:46:0x00d9, B:48:0x00e3, B:52:0x0119, B:17:0x0043), top: B:68:0x0008, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099 A[Catch: all -> 0x0018, CancellationException -> 0x001b, TRY_ENTER, TryCatch #0 {CancellationException -> 0x001b, blocks: (B:6:0x0013, B:13:0x0022, B:20:0x005c, B:22:0x0068, B:28:0x0099, B:30:0x009f, B:36:0x00b0, B:38:0x00b6, B:44:0x00c7, B:46:0x00d9, B:48:0x00e3, B:52:0x0119, B:17:0x0043), top: B:68:0x0008, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Job job;
        Job job2;
        CoroutineScope $this$launch;
        long delayTime;
        boolean z;
        boolean checkGuideItem;
        Object showWidgetGuide;
        Job job3;
        Job job4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
            } catch (CancellationException e) {
                BLog.e("AddWidgetGuidePopupWindowManager", "tryToAddWidget guide task cancelled");
                job2 = AddWidgetGuidePopupWindowManager.showGuideJob;
            }
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$launch = (CoroutineScope) this.L$0;
                    AppWidgetManagerUtil appWidgetManagerUtil = AppWidgetManagerUtil.INSTANCE;
                    Context applicationContext = this.$activity.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    boolean result = appWidgetManagerUtil.requestPinAppWidget$core_apinkDebug(applicationContext, this.$scene, null);
                    if (result) {
                        AddWidgetGuidePopupWindowManager addWidgetGuidePopupWindowManager = AddWidgetGuidePopupWindowManager.INSTANCE;
                        AddWidgetGuidePopupWindowManager.showGuide = true;
                        delayTime = AddWidgetGuidePopupWindowManager.INSTANCE.delayTime();
                        this.L$0 = $this$launch;
                        this.label = 1;
                        if (DelayKt.delay(delayTime, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (!AutoAddWidgetSceneExtKt.widgetAdded(this.$scene, this.$activity)) {
                            ReportHelperKt.reportAutoAddSuccess(AutoAddWidgetSceneExtKt.spmid(this.$scene), AutoAddWidgetSceneExtKt.type(this.$scene), AutoAddWidgetSceneExtKt.contentId(this.$scene));
                            PromoToast.showMidToast(BiliContext.application(), R.string.homepage_global_string_381);
                            return Unit.INSTANCE;
                        } else if (!CoroutineScopeKt.isActive($this$launch)) {
                            Unit unit = Unit.INSTANCE;
                            job4 = AddWidgetGuidePopupWindowManager.showGuideJob;
                            if (job4 != null) {
                                Job.DefaultImpls.cancel$default(job4, (CancellationException) null, 1, (Object) null);
                            }
                            AddWidgetGuidePopupWindowManager addWidgetGuidePopupWindowManager2 = AddWidgetGuidePopupWindowManager.INSTANCE;
                            AddWidgetGuidePopupWindowManager.showGuideJob = null;
                            return unit;
                        } else {
                            z = AddWidgetGuidePopupWindowManager.showGuide;
                            if (!z) {
                                Unit unit2 = Unit.INSTANCE;
                                job3 = AddWidgetGuidePopupWindowManager.showGuideJob;
                                if (job3 != null) {
                                    Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
                                }
                                AddWidgetGuidePopupWindowManager addWidgetGuidePopupWindowManager3 = AddWidgetGuidePopupWindowManager.INSTANCE;
                                AddWidgetGuidePopupWindowManager.showGuideJob = null;
                                return unit2;
                            }
                            boolean isResumed = this.$activity.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED);
                            if (isResumed) {
                                checkGuideItem = AddWidgetGuidePopupWindowManager.INSTANCE.checkGuideItem(this.$guideItem);
                                if (checkGuideItem) {
                                    ReportHelperKt.reportGuideWindowShow(AutoAddWidgetSceneExtKt.spmid(this.$scene), AutoAddWidgetSceneExtKt.type(this.$scene), AutoAddWidgetSceneExtKt.contentId(this.$scene));
                                    AddWidgetGuidePopupWindowManager addWidgetGuidePopupWindowManager4 = AddWidgetGuidePopupWindowManager.INSTANCE;
                                    FragmentManager supportFragmentManager = this.$activity.getSupportFragmentManager();
                                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                                    this.L$0 = null;
                                    this.label = 2;
                                    showWidgetGuide = addWidgetGuidePopupWindowManager4.showWidgetGuide(supportFragmentManager, this.$guideItem, this.$scene, (Continuation) this);
                                    if (showWidgetGuide == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    job2 = AddWidgetGuidePopupWindowManager.showGuideJob;
                                    break;
                                }
                            }
                            AutoAddResultRegisterKt.registerAutoAddWidgetResult(this.$activity, this.$scene);
                            job2 = AddWidgetGuidePopupWindowManager.showGuideJob;
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    $this$launch = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    if (!AutoAddWidgetSceneExtKt.widgetAdded(this.$scene, this.$activity)) {
                    }
                    break;
                case 2:
                    ResultKt.throwOnFailure($result);
                    job2 = AddWidgetGuidePopupWindowManager.showGuideJob;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } finally {
            job = AddWidgetGuidePopupWindowManager.showGuideJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            AddWidgetGuidePopupWindowManager addWidgetGuidePopupWindowManager5 = AddWidgetGuidePopupWindowManager.INSTANCE;
            AddWidgetGuidePopupWindowManager.showGuideJob = null;
        }
    }
}