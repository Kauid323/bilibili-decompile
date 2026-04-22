package kntr.common.ouro.ui.textField;

import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.OuroStore;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.OuroNodeStorageKt;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.ui.utils.AnnotatedStringBuilderContext;
import kntr.common.ouro.ui.utils.AnnotatedStringUtilsKt;
import kntr.common.ouro.ui.utils.OuroAnnotatedString;
import kntr.common.ouro.ui.utils.OuroCacheMap;
import kntr.common.ouro.ui.utils.TextRangeUtilsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroComposeTextField.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$OuroComposeTextField$1", f = "OuroComposeTextField.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OuroComposeTextFieldKt$OuroComposeTextField$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ThemeDayNight $dayNightTheme;
    final /* synthetic */ Density $density;
    final /* synthetic */ MutableState<OuroCacheMap<String, TextLayoutResult>> $listOrderLayoutCache$delegate;
    final /* synthetic */ MutableIntState $mainAxisLength$delegate;
    final /* synthetic */ MutableState<OuroAnnotatedString> $ouroAnnotatedString$delegate;
    final /* synthetic */ MutableState<OuroState> $ouroState$delegate;
    final /* synthetic */ FontFamily $placeholderFontFamily;
    final /* synthetic */ OuroStore $store;
    final /* synthetic */ Ref.ObjectRef<TextFieldState> $textFieldState;
    final /* synthetic */ TextMeasurer $textMeasurer;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroComposeTextFieldKt$OuroComposeTextField$1(OuroStore ouroStore, Density density, ThemeDayNight themeDayNight, FontFamily fontFamily, TextMeasurer textMeasurer, Ref.ObjectRef<TextFieldState> objectRef, MutableIntState mutableIntState, MutableState<OuroCacheMap<String, TextLayoutResult>> mutableState, MutableState<OuroAnnotatedString> mutableState2, MutableState<OuroState> mutableState3, Continuation<? super OuroComposeTextFieldKt$OuroComposeTextField$1> continuation) {
        super(2, continuation);
        this.$store = ouroStore;
        this.$density = density;
        this.$dayNightTheme = themeDayNight;
        this.$placeholderFontFamily = fontFamily;
        this.$textMeasurer = textMeasurer;
        this.$textFieldState = objectRef;
        this.$mainAxisLength$delegate = mutableIntState;
        this.$listOrderLayoutCache$delegate = mutableState;
        this.$ouroAnnotatedString$delegate = mutableState2;
        this.$ouroState$delegate = mutableState3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OuroComposeTextFieldKt$OuroComposeTextField$1(this.$store, this.$density, this.$dayNightTheme, this.$placeholderFontFamily, this.$textMeasurer, this.$textFieldState, this.$mainAxisLength$delegate, this.$listOrderLayoutCache$delegate, this.$ouroAnnotatedString$delegate, this.$ouroState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                StateFlow<OuroState> stateFlow = this.$store.getStateFlow();
                final Density density = this.$density;
                final ThemeDayNight themeDayNight = this.$dayNightTheme;
                final FontFamily fontFamily = this.$placeholderFontFamily;
                final TextMeasurer textMeasurer = this.$textMeasurer;
                final Ref.ObjectRef<TextFieldState> objectRef = this.$textFieldState;
                final MutableIntState mutableIntState = this.$mainAxisLength$delegate;
                final MutableState<OuroCacheMap<String, TextLayoutResult>> mutableState = this.$listOrderLayoutCache$delegate;
                final MutableState<OuroAnnotatedString> mutableState2 = this.$ouroAnnotatedString$delegate;
                final MutableState<OuroState> mutableState3 = this.$ouroState$delegate;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$OuroComposeTextField$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((OuroState) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(OuroState newState, Continuation<? super Unit> continuation) {
                        int OuroComposeTextField$lambda$4;
                        OuroCacheMap OuroComposeTextField$lambda$7;
                        OuroAnnotatedString OuroComposeTextField$lambda$9;
                        MutableState<OuroAnnotatedString> mutableState4 = mutableState2;
                        NodeStorage<OuroDocument> storage = newState.getStorage();
                        Density density2 = density;
                        ThemeDayNight themeDayNight2 = themeDayNight;
                        OuroComposeTextField$lambda$4 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$4(mutableIntState);
                        FontFamily fontFamily2 = fontFamily;
                        OuroComposeTextField$lambda$7 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$7(mutableState);
                        mutableState4.setValue(AnnotatedStringUtilsKt.buildAnnotatedString(storage, new AnnotatedStringBuilderContext(density2, themeDayNight2, OuroComposeTextField$lambda$4, fontFamily2, OuroComposeTextField$lambda$7, textMeasurer)));
                        TextFieldState this_$iv = (TextFieldState) objectRef.element;
                        MutableState<OuroAnnotatedString> mutableState5 = mutableState2;
                        TextFieldBuffer mutableValue$iv = this_$iv.startEdit();
                        try {
                            int length = mutableValue$iv.getLength();
                            OuroComposeTextField$lambda$9 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$9(mutableState5);
                            mutableValue$iv.replace(0, length, OuroComposeTextField$lambda$9.getAnnotatedString());
                            mutableValue$iv.setSelection-5zc-tL8(TextRangeUtilsKt.toTextRange(newState.getTextRange()));
                            this_$iv.commitEdit(mutableValue$iv);
                            this_$iv.finishEditing();
                            mutableState3.setValue(newState);
                            OuroNodeStorageKt.printTree$default(newState.getStorage(), null, null, false, 7, null);
                            return Unit.INSTANCE;
                        } catch (Throwable th) {
                            this_$iv.finishEditing();
                            throw th;
                        }
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}