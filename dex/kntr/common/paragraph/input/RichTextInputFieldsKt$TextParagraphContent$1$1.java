package kntr.common.paragraph.input;

import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.ui.text.TextRange;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.input.content.TextContent;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RichTextInputFields.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.paragraph.input.RichTextInputFieldsKt$TextParagraphContent$1$1", f = "RichTextInputFields.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RichTextInputFieldsKt$TextParagraphContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextContent $paragraphContent;
    final /* synthetic */ TextFieldState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichTextInputFieldsKt$TextParagraphContent$1$1(TextContent textContent, TextFieldState textFieldState, Continuation<? super RichTextInputFieldsKt$TextParagraphContent$1$1> continuation) {
        super(2, continuation);
        this.$paragraphContent = textContent;
        this.$state = textFieldState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RichTextInputFieldsKt$TextParagraphContent$1$1(this.$paragraphContent, this.$state, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        long composeRange;
        long composeRange2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                boolean textChanged = !Intrinsics.areEqual(this.$paragraphContent.getContent(), this.$state.getText());
                composeRange = RichTextInputFieldsKt.composeRange(this.$paragraphContent.getSelection());
                boolean selectionChanged = !TextRange.equals-impl0(composeRange, this.$state.getSelection-d9O1mEE());
                if (textChanged || selectionChanged) {
                    TextFieldState this_$iv = this.$state;
                    TextContent textContent = this.$paragraphContent;
                    TextFieldBuffer mutableValue$iv = this_$iv.startEdit();
                    if (textChanged) {
                        try {
                            mutableValue$iv.replace(0, mutableValue$iv.getLength(), textContent.getContent());
                        } catch (Throwable th) {
                            this_$iv.finishEditing();
                            throw th;
                        }
                    }
                    if (selectionChanged) {
                        composeRange2 = RichTextInputFieldsKt.composeRange(textContent.getSelection());
                        mutableValue$iv.setSelection-5zc-tL8(composeRange2);
                    }
                    this_$iv.commitEdit(mutableValue$iv);
                    this_$iv.finishEditing();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}