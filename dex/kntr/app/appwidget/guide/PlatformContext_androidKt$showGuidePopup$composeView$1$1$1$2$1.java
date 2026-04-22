package kntr.app.appwidget.guide;

import androidx.fragment.app.FragmentActivity;
import kntr.app.appwidget.guide.model.WidgetGuidePopupParams;
import kntr.app.appwidget.guide.ui.AppWidgetGuidePopupState;
import kntr.app.appwidget.guide.ui.PopupResult;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlatformContext.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.appwidget.guide.PlatformContext_androidKt$showGuidePopup$composeView$1$1$1$2$1", f = "PlatformContext.android.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PlatformContext_androidKt$showGuidePopup$composeView$1$1$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $context;
    final /* synthetic */ AppWidgetGuidePopupState $hostState;
    final /* synthetic */ WidgetGuidePopupParams $params;
    int label;

    /* compiled from: PlatformContext.android.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PopupResult.values().length];
            try {
                iArr[PopupResult.Dismissed.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PopupResult.AutoDismissed.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PopupResult.ActionPerformed.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformContext_androidKt$showGuidePopup$composeView$1$1$1$2$1(AppWidgetGuidePopupState appWidgetGuidePopupState, WidgetGuidePopupParams widgetGuidePopupParams, FragmentActivity fragmentActivity, Continuation<? super PlatformContext_androidKt$showGuidePopup$composeView$1$1$1$2$1> continuation) {
        super(2, continuation);
        this.$hostState = appWidgetGuidePopupState;
        this.$params = widgetGuidePopupParams;
        this.$context = fragmentActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlatformContext_androidKt$showGuidePopup$composeView$1$1$1$2$1(this.$hostState, this.$params, this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object showPopup$guide_debug;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                showPopup$guide_debug = this.$hostState.showPopup$guide_debug(this.$params.getAvatar(), this.$params.getTitle(), this.$params.getSubtitle(), this.$params.getForceDark(), -this.$params.getOffset(), this.$params.getDuration(), this.$params.getOutsideTouchable(), this.$params.getStyle(), (Continuation) this);
                if (showPopup$guide_debug == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                showPopup$guide_debug = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PopupResult result = (PopupResult) showPopup$guide_debug;
        switch (WhenMappings.$EnumSwitchMapping$0[result.ordinal()]) {
            case 1:
                this.$params.getDismiss().invoke(Boxing.boxBoolean(true));
                PlatformContext_androidKt.closeGuidePopup(this.$context);
                break;
            case 2:
                this.$params.getDismiss().invoke(Boxing.boxBoolean(false));
                PlatformContext_androidKt.closeGuidePopup(this.$context);
                break;
            case 3:
                this.$params.getPerformAction().invoke();
                PlatformContext_androidKt.closeGuidePopup(this.$context);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }
}