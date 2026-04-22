package kntr.app.tribee.publish.internal;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Rect;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.input.RichTextContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeInputFields.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.internal.TribeeInputFieldsKt$TribeeInputFields$3$3$1$5$1", f = "TribeeInputFields.kt", i = {}, l = {179, 180}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeInputFieldsKt$TribeeInputFields$3$3$1$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
    final /* synthetic */ MutableState<Rect> $cursorRect$delegate;
    final /* synthetic */ boolean $imeVisible;
    final /* synthetic */ int $index;
    final /* synthetic */ RichTextContent $paragraphContent;
    final /* synthetic */ MutableState<Boolean> $titleFocused$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeInputFieldsKt$TribeeInputFields$3$3$1$5$1(boolean z, RichTextContent richTextContent, int i, BringIntoViewRequester bringIntoViewRequester, MutableState<Boolean> mutableState, MutableState<Rect> mutableState2, Continuation<? super TribeeInputFieldsKt$TribeeInputFields$3$3$1$5$1> continuation) {
        super(2, continuation);
        this.$imeVisible = z;
        this.$paragraphContent = richTextContent;
        this.$index = i;
        this.$bringIntoViewRequester = bringIntoViewRequester;
        this.$titleFocused$delegate = mutableState;
        this.$cursorRect$delegate = mutableState2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeInputFieldsKt$TribeeInputFields$3$3$1$5$1(this.$imeVisible, this.$paragraphContent, this.$index, this.$bringIntoViewRequester, this.$titleFocused$delegate, this.$cursorRect$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        boolean TribeeInputFields$lambda$5;
        BringIntoViewRequester bringIntoViewRequester;
        Rect TribeeInputFields$lambda$9$2$3$3;
        Rect translate;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$imeVisible && this.$paragraphContent.getCurrentFocus() == this.$index) {
                    TribeeInputFields$lambda$5 = TribeeInputFieldsKt.TribeeInputFields$lambda$5(this.$titleFocused$delegate);
                    if (!TribeeInputFields$lambda$5) {
                        Duration.Companion companion = Duration.Companion;
                        this.label = 1;
                        if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration(300, DurationUnit.MILLISECONDS), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        bringIntoViewRequester = this.$bringIntoViewRequester;
                        TribeeInputFields$lambda$9$2$3$3 = TribeeInputFieldsKt.TribeeInputFields$lambda$9$2$3$3(this.$cursorRect$delegate);
                        translate = TribeeInputFields$lambda$9$2$3$3 == null ? TribeeInputFields$lambda$9$2$3$3.translate(0.0f, 200.0f) : null;
                        this.label = 2;
                        if (bringIntoViewRequester.bringIntoView(translate, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                bringIntoViewRequester = this.$bringIntoViewRequester;
                TribeeInputFields$lambda$9$2$3$3 = TribeeInputFieldsKt.TribeeInputFields$lambda$9$2$3$3(this.$cursorRect$delegate);
                if (TribeeInputFields$lambda$9$2$3$3 == null) {
                }
                this.label = 2;
                if (bringIntoViewRequester.bringIntoView(translate, (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}