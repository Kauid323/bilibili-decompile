package kntr.app.deepsearch.ui.paragraph.text;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRangeKt;
import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bilibili.common.paragraph.action.ParagraphClickListener;
import com.bilibili.common.paragraph.impl.text.TextNodeBuildResult;
import com.bilibili.common.paragraph.impl.text.TextNodeClickInfo;
import com.bilibili.common.paragraph.impl.text.TextParagraphClickListener;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchTextParagraphBuilder.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class TextParagraphContent$Content$4$1$1 implements PointerInputEventHandler {
    final /* synthetic */ SoftwareKeyboardController $soft;
    final /* synthetic */ TextParagraphContent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextParagraphContent$Content$4$1$1(SoftwareKeyboardController softwareKeyboardController, TextParagraphContent textParagraphContent) {
        this.$soft = softwareKeyboardController;
        this.this$0 = textParagraphContent;
    }

    public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
        final SoftwareKeyboardController softwareKeyboardController = this.$soft;
        final TextParagraphContent textParagraphContent = this.this$0;
        Object detectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default($this$pointerInput, (Function1) null, (Function1) null, (Function3) null, new Function1() { // from class: kntr.app.deepsearch.ui.paragraph.text.TextParagraphContent$Content$4$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invoke$lambda$0;
                invoke$lambda$0 = TextParagraphContent$Content$4$1$1.invoke$lambda$0(softwareKeyboardController, textParagraphContent, (Offset) obj);
                return invoke$lambda$0;
            }
        }, continuation, 7, (Object) null);
        return detectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
        r2 = kntr.app.deepsearch.ui.paragraph.text.DeepSearchTextParagraphBuilderKt.asTextClickListener(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit invoke$lambda$0(SoftwareKeyboardController $soft, TextParagraphContent this$0, Offset offset) {
        Pair findTextNodeOfIndex;
        TextParagraphClickListener asTextClickListener;
        if ($soft != null) {
            $soft.hide();
        }
        TextLayoutResult result = (TextLayoutResult) this$0.getTextLayoutResultState().getValue();
        if (result == null) {
            return Unit.INSTANCE;
        }
        int textIndex = result.getOffsetForPosition-k-4lQ0M(offset.unbox-impl());
        findTextNodeOfIndex = this$0.findTextNodeOfIndex(textIndex);
        if (findTextNodeOfIndex != null) {
            int startIndex = ((Number) findTextNodeOfIndex.component1()).intValue();
            TextNodeBuildResult node = (TextNodeBuildResult) findTextNodeOfIndex.component2();
            KTextNode.IText text = node.getNode();
            if (text == null) {
                return Unit.INSTANCE;
            }
            TextNodeClickInfo info = new TextNodeClickInfo(text, TextRangeKt.TextRange(startIndex, node.getString().length() + startIndex), offset.unbox-impl(), result, (DefaultConstructorMarker) null);
            ParagraphClickListener clickListener = this$0.getClickListener();
            if (clickListener != null && asTextClickListener != null) {
                asTextClickListener.onTextNodeClick(text, info);
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}