package tv.danmaku.bili.appwidget.guide;

import com.bilibili.moduleservice.appwidget.GuideScene;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.guide.function.FunctionWidgetGuideBottomSheetDialog;

/* compiled from: DialogFactory.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/appwidget/guide/DialogFactory;", "", "<init>", "()V", "createWidgetGuideDialog", "Ltv/danmaku/bili/appwidget/guide/IWidgetGuideDialog;", "scene", "Lcom/bilibili/moduleservice/appwidget/GuideScene;", "onCancel", "Lkotlin/Function1;", "", "", "onConfirm", "Lkotlin/Function0;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DialogFactory {
    public static final int $stable = 0;
    public static final DialogFactory INSTANCE = new DialogFactory();

    private DialogFactory() {
    }

    public final IWidgetGuideDialog createWidgetGuideDialog(GuideScene scene, final Function1<? super Boolean, Unit> function1, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(function1, "onCancel");
        Intrinsics.checkNotNullParameter(function0, "onConfirm");
        if ((scene instanceof GuideScene.DynamicHome) || (scene instanceof GuideScene.PlayerVideoDetail)) {
            return new UPCardWidgetGuideDialog(new Function0() { // from class: tv.danmaku.bili.appwidget.guide.DialogFactory$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit createWidgetGuideDialog$lambda$0;
                    createWidgetGuideDialog$lambda$0 = DialogFactory.createWidgetGuideDialog$lambda$0(function0);
                    return createWidgetGuideDialog$lambda$0;
                }
            }, new Function0() { // from class: tv.danmaku.bili.appwidget.guide.DialogFactory$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit createWidgetGuideDialog$lambda$1;
                    createWidgetGuideDialog$lambda$1 = DialogFactory.createWidgetGuideDialog$lambda$1(function1);
                    return createWidgetGuideDialog$lambda$1;
                }
            });
        }
        if (scene instanceof GuideScene.Function) {
            FunctionWidgetGuideBottomSheetDialog $this$createWidgetGuideDialog_u24lambda_u242 = FunctionWidgetGuideBottomSheetDialog.Companion.newInstance();
            $this$createWidgetGuideDialog_u24lambda_u242.setAction(new Function0() { // from class: tv.danmaku.bili.appwidget.guide.DialogFactory$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit createWidgetGuideDialog$lambda$2$0;
                    createWidgetGuideDialog$lambda$2$0 = DialogFactory.createWidgetGuideDialog$lambda$2$0(function0);
                    return createWidgetGuideDialog$lambda$2$0;
                }
            }, new Function1() { // from class: tv.danmaku.bili.appwidget.guide.DialogFactory$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit createWidgetGuideDialog$lambda$2$1;
                    createWidgetGuideDialog$lambda$2$1 = DialogFactory.createWidgetGuideDialog$lambda$2$1(function1, ((Boolean) obj).booleanValue());
                    return createWidgetGuideDialog$lambda$2$1;
                }
            });
            return $this$createWidgetGuideDialog_u24lambda_u242;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createWidgetGuideDialog$lambda$1(Function1 $onCancel) {
        $onCancel.invoke(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createWidgetGuideDialog$lambda$0(Function0 $onConfirm) {
        $onConfirm.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createWidgetGuideDialog$lambda$2$0(Function0 $onConfirm) {
        $onConfirm.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createWidgetGuideDialog$lambda$2$1(Function1 $onCancel, boolean it) {
        $onCancel.invoke(Boolean.valueOf(it));
        return Unit.INSTANCE;
    }
}