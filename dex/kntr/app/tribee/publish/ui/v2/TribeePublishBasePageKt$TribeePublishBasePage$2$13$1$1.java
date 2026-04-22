package kntr.app.tribee.publish.ui.v2;

import kntr.app.tribee.publish.core.v2.TribeePublishAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.common.ui.toolPanel.AlbumPanelEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeePublishBasePage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$TribeePublishBasePage$2$13$1$1", f = "TribeePublishBasePage.kt", i = {}, l = {370}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeePublishBasePageKt$TribeePublishBasePage$2$13$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AlbumPanelEvent $it;
    final /* synthetic */ Function2<TribeePublishAction, Continuation<? super Unit>, Object> $onAction;
    int label;

    /* compiled from: TribeePublishBasePage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AlbumPanelEvent.values().length];
            try {
                iArr[AlbumPanelEvent.CONFIRM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[AlbumPanelEvent.SELECT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[AlbumPanelEvent.UNSELECT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeePublishBasePageKt$TribeePublishBasePage$2$13$1$1(Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, AlbumPanelEvent albumPanelEvent, Continuation<? super TribeePublishBasePageKt$TribeePublishBasePage$2$13$1$1> continuation) {
        super(2, continuation);
        this.$onAction = function2;
        this.$it = albumPanelEvent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeePublishBasePageKt$TribeePublishBasePage$2$13$1$1(this.$onAction, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function2<TribeePublishAction, Continuation<? super Unit>, Object> function2 = this.$onAction;
                switch (WhenMappings.$EnumSwitchMapping$0[this.$it.ordinal()]) {
                    case 1:
                        str = "sure";
                        break;
                    case 2:
                        str = "choose";
                        break;
                    case 3:
                        str = "cancel";
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                TribeePublishAction.TrackerAction.PhotoFloatLayerClick photoFloatLayerClick = new TribeePublishAction.TrackerAction.PhotoFloatLayerClick(str);
                this.label = 1;
                if (function2.invoke(photoFloatLayerClick, this) == coroutine_suspended) {
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
}