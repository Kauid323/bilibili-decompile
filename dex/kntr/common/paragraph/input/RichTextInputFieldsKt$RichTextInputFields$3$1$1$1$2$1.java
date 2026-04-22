package kntr.common.paragraph.input;

import androidx.compose.ui.focus.FocusRequester;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RichTextInputFields.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.paragraph.input.RichTextInputFieldsKt$RichTextInputFields$3$1$1$1$2$1", f = "RichTextInputFields.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RichTextInputFieldsKt$RichTextInputFields$3$1$1$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RichTextContent $contentState;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ int $index;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichTextInputFieldsKt$RichTextInputFields$3$1$1$1$2$1(RichTextContent richTextContent, int i, FocusRequester focusRequester, Continuation<? super RichTextInputFieldsKt$RichTextInputFields$3$1$1$1$2$1> continuation) {
        super(2, continuation);
        this.$contentState = richTextContent;
        this.$index = i;
        this.$focusRequester = focusRequester;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RichTextInputFieldsKt$RichTextInputFields$3$1$1$1$2$1(this.$contentState, this.$index, this.$focusRequester, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$contentState.getCurrentFocus() == this.$index && !this.$contentState.getFocusConsumed()) {
                    FocusRequester.requestFocus-3ESFkO8$default(this.$focusRequester, 0, 1, (Object) null);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}