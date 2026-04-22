package tv.danmaku.bili.appwidget.guide;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bapis.bilibili.app.show.mixture.v1.GuideItem;
import com.bapis.bilibili.app.show.mixture.v1.WidgetGuideReply;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.moduleservice.appwidget.GuideScene;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.guide.function.FunctionWidgetGuideBottomSheetDialog;
import tv.danmaku.bili.appwidget.guide.utils.AutoAddWidgetSceneExtKt;
import tv.danmaku.bili.quick.LoginQualityMonitor;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: AddWidgetGuidePopupWindowManager.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015J\u0016\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000bJ\u001e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\rJ&\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Ltv/danmaku/bili/appwidget/guide/AddWidgetGuidePopupWindowManager;", "", "<init>", "()V", "TAG", "", "showGuideJob", "Lkotlinx/coroutines/Job;", "dialog", "Ltv/danmaku/bili/appwidget/guide/IWidgetGuideDialog;", "showGuide", "", "showWidgetGuide", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "reply", "Lcom/bapis/bilibili/app/show/mixture/v1/WidgetGuideReply;", "scene", "Lcom/bilibili/moduleservice/appwidget/GuideScene;", "onCancel", "Lkotlin/Function1;", "hideWidgetGuide", "visible", "tryToAddWidget", "guideItem", "Lcom/bapis/bilibili/app/show/mixture/v1/GuideItem;", "closeWidgetGuide", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;Lcom/bapis/bilibili/app/show/mixture/v1/GuideItem;Lcom/bilibili/moduleservice/appwidget/GuideScene;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkGuideItem", "delayTime", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AddWidgetGuidePopupWindowManager {
    private static final String TAG = "AddWidgetGuidePopupWindowManager";
    private static IWidgetGuideDialog dialog;
    private static boolean showGuide;
    private static Job showGuideJob;
    public static final AddWidgetGuidePopupWindowManager INSTANCE = new AddWidgetGuidePopupWindowManager();
    public static final int $stable = 8;

    private AddWidgetGuidePopupWindowManager() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showWidgetGuide$default(AddWidgetGuidePopupWindowManager addWidgetGuidePopupWindowManager, FragmentActivity fragmentActivity, WidgetGuideReply widgetGuideReply, GuideScene guideScene, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = null;
        }
        addWidgetGuidePopupWindowManager.showWidgetGuide(fragmentActivity, widgetGuideReply, guideScene, function1);
    }

    public final void showWidgetGuide(final FragmentActivity activity, final WidgetGuideReply reply, final GuideScene scene, final Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(scene, "scene");
        try {
            if (dialog != null) {
                IWidgetGuideDialog iWidgetGuideDialog = dialog;
                if (iWidgetGuideDialog != null) {
                    iWidgetGuideDialog.hideDialog();
                }
                dialog = null;
            }
            dialog = DialogFactory.INSTANCE.createWidgetGuideDialog(scene, new Function1() { // from class: tv.danmaku.bili.appwidget.guide.AddWidgetGuidePopupWindowManager$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit showWidgetGuide$lambda$0;
                    showWidgetGuide$lambda$0 = AddWidgetGuidePopupWindowManager.showWidgetGuide$lambda$0(scene, function1, ((Boolean) obj).booleanValue());
                    return showWidgetGuide$lambda$0;
                }
            }, new Function0() { // from class: tv.danmaku.bili.appwidget.guide.AddWidgetGuidePopupWindowManager$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit showWidgetGuide$lambda$1;
                    showWidgetGuide$lambda$1 = AddWidgetGuidePopupWindowManager.showWidgetGuide$lambda$1(scene, activity, reply);
                    return showWidgetGuide$lambda$1;
                }
            });
            IWidgetGuideDialog iWidgetGuideDialog2 = dialog;
            if (iWidgetGuideDialog2 != null) {
                iWidgetGuideDialog2.showDialog(activity, scene, reply);
            }
        } catch (Exception e) {
            BLog.e(TAG, "showWidgetGuide error: " + e);
        }
    }

    public static final Unit showWidgetGuide$lambda$0(GuideScene $scene, Function1 $onCancel, boolean it) {
        AutoAddWidgetSceneExtKt.reportClick($scene, 2);
        if ($onCancel != null) {
            $onCancel.invoke(Boolean.valueOf(it));
        }
        return Unit.INSTANCE;
    }

    public static final Unit showWidgetGuide$lambda$1(GuideScene $scene, FragmentActivity $activity, WidgetGuideReply $reply) {
        AutoAddWidgetSceneExtKt.reportClick($scene, 1);
        AddWidgetGuidePopupWindowManager addWidgetGuidePopupWindowManager = INSTANCE;
        GuideItem guideItem = $reply.getGuideItem();
        Intrinsics.checkNotNullExpressionValue(guideItem, "getGuideItem(...)");
        addWidgetGuidePopupWindowManager.tryToAddWidget($activity, $scene, guideItem);
        return Unit.INSTANCE;
    }

    public final void hideWidgetGuide(GuideScene scene, boolean visible) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        BLog.i(TAG, "hideWidgetGuide -> scene = " + scene + " ; visible = " + visible);
        if (scene instanceof GuideScene.DynamicHome) {
            if (!visible && dialog != null && (dialog instanceof UPCardWidgetGuideDialog)) {
                IWidgetGuideDialog iWidgetGuideDialog = dialog;
                if (iWidgetGuideDialog != null) {
                    iWidgetGuideDialog.hideDialog();
                }
                dialog = null;
            }
        } else if (scene instanceof GuideScene.Function) {
            if (dialog != null && (dialog instanceof FunctionWidgetGuideBottomSheetDialog)) {
                dialog = null;
            }
        } else {
            BLog.i(TAG, "hideWidgetGuide -> scene = " + scene + " ; visible = " + visible);
        }
    }

    public final void tryToAddWidget(FragmentActivity activity, GuideScene scene, GuideItem guideItem) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(guideItem, "guideItem");
        showGuideJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) activity), (CoroutineContext) null, (CoroutineStart) null, new AddWidgetGuidePopupWindowManager$tryToAddWidget$1(activity, scene, guideItem, null), 3, (Object) null);
    }

    public final void closeWidgetGuide() {
        showGuide = false;
    }

    public final Object showWidgetGuide(FragmentManager fragmentManager, GuideItem guideItem, GuideScene scene, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new AddWidgetGuidePopupWindowManager$showWidgetGuide$4(fragmentManager, guideItem, scene, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final boolean checkGuideItem(GuideItem guideItem) {
        String title = guideItem.getTitle();
        return ((title == null || StringsKt.isBlank(title)) || guideItem.getCardList().isEmpty()) ? false : true;
    }

    public final long delayTime() {
        Long longOrNull;
        String dd = DeviceDecision.INSTANCE.dd("dd.auto_add_widget_guide_show_delay_time", LoginQualityMonitor.CHECK_CODE_NET_UNICOM_NO);
        if (dd == null || (longOrNull = StringsKt.toLongOrNull(dd)) == null) {
            return 300L;
        }
        return longOrNull.longValue();
    }
}