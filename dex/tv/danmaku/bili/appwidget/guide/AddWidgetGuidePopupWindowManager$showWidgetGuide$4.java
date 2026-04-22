package tv.danmaku.bili.appwidget.guide;

import androidx.fragment.app.FragmentManager;
import com.bapis.bilibili.app.show.mixture.v1.GuideItem;
import com.bilibili.moduleservice.appwidget.GuideScene;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AddWidgetGuidePopupWindowManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.guide.AddWidgetGuidePopupWindowManager$showWidgetGuide$4", f = "AddWidgetGuidePopupWindowManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AddWidgetGuidePopupWindowManager$showWidgetGuide$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentManager $fragmentManager;
    final /* synthetic */ GuideItem $guideItem;
    final /* synthetic */ GuideScene $scene;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddWidgetGuidePopupWindowManager$showWidgetGuide$4(FragmentManager fragmentManager, GuideItem guideItem, GuideScene guideScene, Continuation<? super AddWidgetGuidePopupWindowManager$showWidgetGuide$4> continuation) {
        super(2, continuation);
        this.$fragmentManager = fragmentManager;
        this.$guideItem = guideItem;
        this.$scene = guideScene;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddWidgetGuidePopupWindowManager$showWidgetGuide$4(this.$fragmentManager, this.$guideItem, this.$scene, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                WidgetGuideBottomSheetDialog.Companion.newInstance().showWidgetGuide(this.$fragmentManager, this.$guideItem, this.$scene);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}