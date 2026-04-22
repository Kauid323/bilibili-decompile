package kntr.app.im.chat.ui.widget;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import im.base.IMLog;
import java.util.List;
import kntr.app.im.chat.db.model.InputBoxContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RichInputField.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.widget.RichInputFieldKt$RichInputField$1$1", f = "RichInputField.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RichInputFieldKt$RichInputField$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $contentVersion;
    final /* synthetic */ InputBoxContent $inputBoxContent;
    final /* synthetic */ MutableState<RichInputFieldValue> $richInputFieldValue$delegate;
    final /* synthetic */ RichInputFieldState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichInputFieldKt$RichInputField$1$1(Integer num, RichInputFieldState richInputFieldState, InputBoxContent inputBoxContent, MutableState<RichInputFieldValue> mutableState, Continuation<? super RichInputFieldKt$RichInputField$1$1> continuation) {
        super(2, continuation);
        this.$contentVersion = num;
        this.$state = richInputFieldState;
        this.$inputBoxContent = inputBoxContent;
        this.$richInputFieldValue$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RichInputFieldKt$RichInputField$1$1(this.$contentVersion, this.$state, this.$inputBoxContent, this.$richInputFieldValue$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        RichInputFieldValue RichInputField_1esR5Hs$lambda$5;
        RichInputFieldValue RichInputField_1esR5Hs$lambda$52;
        AnnotatedString buildNewAnnotatedString;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$contentVersion != null && this.$contentVersion.intValue() > 0) {
                    IMLog.Companion.d("RichInputField", "InputBoxContent version changed: " + this.$contentVersion);
                    MutableState<RichInputFieldValue> mutableState = this.$richInputFieldValue$delegate;
                    RichInputField_1esR5Hs$lambda$5 = RichInputFieldKt.RichInputField_1esR5Hs$lambda$5(this.$richInputFieldValue$delegate);
                    RichInputField_1esR5Hs$lambda$52 = RichInputFieldKt.RichInputField_1esR5Hs$lambda$5(this.$richInputFieldValue$delegate);
                    TextFieldValue textFieldValue = RichInputField_1esR5Hs$lambda$52.getTextFieldValue();
                    buildNewAnnotatedString = RichInputFieldKt.buildNewAnnotatedString(this.$state, new AnnotatedString(this.$inputBoxContent.getText(), (List) null, 2, (DefaultConstructorMarker) null), this.$inputBoxContent.getInlineContents());
                    mutableState.setValue(RichInputField_1esR5Hs$lambda$5.copy(TextFieldValue.copy-3r_uNRQ$default(textFieldValue, buildNewAnnotatedString, TextRangeKt.TextRange(this.$inputBoxContent.getCursorStart(), this.$inputBoxContent.getCursorEnd()), (TextRange) null, 4, (Object) null), this.$inputBoxContent.getInlineContents()));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}