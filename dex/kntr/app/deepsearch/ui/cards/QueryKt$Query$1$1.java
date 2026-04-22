package kntr.app.deepsearch.ui.cards;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Query.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class QueryKt$Query$1$1 implements PointerInputEventHandler {
    final /* synthetic */ ClipboardManager $clipboardManager;
    final /* synthetic */ String $query;
    final /* synthetic */ String $successToast;
    final /* synthetic */ Toaster $toaster;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryKt$Query$1$1(ClipboardManager clipboardManager, String str, Toaster toaster, String str2) {
        this.$clipboardManager = clipboardManager;
        this.$query = str;
        this.$toaster = toaster;
        this.$successToast = str2;
    }

    public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
        final ClipboardManager clipboardManager = this.$clipboardManager;
        final String str = this.$query;
        final Toaster toaster = this.$toaster;
        final String str2 = this.$successToast;
        Object detectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default($this$pointerInput, (Function1) null, new Function1() { // from class: kntr.app.deepsearch.ui.cards.QueryKt$Query$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invoke$lambda$0;
                invoke$lambda$0 = QueryKt$Query$1$1.invoke$lambda$0(clipboardManager, str, toaster, str2, (Offset) obj);
                return invoke$lambda$0;
            }
        }, (Function3) null, (Function1) null, continuation, 13, (Object) null);
        return detectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(ClipboardManager $clipboardManager, String $query, Toaster $toaster, String $successToast, Offset it) {
        $clipboardManager.setText(new AnnotatedString($query, (List) null, 2, (DefaultConstructorMarker) null));
        AnnotatedString text = $clipboardManager.getText();
        if (Intrinsics.areEqual(text != null ? text.getText() : null, $query)) {
            $toaster.showToast($successToast, ToastDuration.Short);
        }
        return Unit.INSTANCE;
    }
}