package kntr.app.tribee.publish.ui.v2.internal;

import kntr.app.tribee.publish.core.v2.TribeePublishAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.preview.component.ToolbarTrackEvent;
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
/* compiled from: TribeeToolbar.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.ui.v2.internal.TribeeToolbarKt$TribeeToolbar$1$1$1$1", f = "TribeeToolbar.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeToolbarKt$TribeeToolbar$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ToolbarTrackEvent $it;
    final /* synthetic */ Function2<TribeePublishAction, Continuation<? super Unit>, Object> $onTribeeAction;
    int label;

    /* compiled from: TribeeToolbar.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToolbarTrackEvent.values().length];
            try {
                iArr[ToolbarTrackEvent.TEXT_STYLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ToolbarTrackEvent.PARAGRAPH_STYLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ToolbarTrackEvent.STICKER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ToolbarTrackEvent.ALBUM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ToolbarTrackEvent.REDO.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[ToolbarTrackEvent.UNDO.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeToolbarKt$TribeeToolbar$1$1$1$1(Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, ToolbarTrackEvent toolbarTrackEvent, Continuation<? super TribeeToolbarKt$TribeeToolbar$1$1$1$1> continuation) {
        super(2, continuation);
        this.$onTribeeAction = function2;
        this.$it = toolbarTrackEvent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeToolbarKt$TribeeToolbar$1$1$1$1(this.$onTribeeAction, this.$it, continuation);
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
                Function2<TribeePublishAction, Continuation<? super Unit>, Object> function2 = this.$onTribeeAction;
                switch (WhenMappings.$EnumSwitchMapping$0[this.$it.ordinal()]) {
                    case 1:
                        str = "font";
                        break;
                    case 2:
                        str = "paragraph";
                        break;
                    case 3:
                        str = "emoji";
                        break;
                    case 4:
                        str = "picture";
                        break;
                    case 5:
                        str = "redo";
                        break;
                    case 6:
                        str = "undo";
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                TribeePublishAction.TrackerAction.ToolbarButtonClick toolbarButtonClick = new TribeePublishAction.TrackerAction.ToolbarButtonClick(str);
                this.label = 1;
                if (function2.invoke(toolbarButtonClick, this) == coroutine_suspended) {
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