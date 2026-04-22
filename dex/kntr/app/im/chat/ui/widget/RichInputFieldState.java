package kntr.app.im.chat.ui.widget;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RichInputField.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR/\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lkntr/app/im/chat/ui/widget/RichInputFieldState;", RoomRecommendViewModel.EMPTY_CURSOR, "font", "Landroidx/compose/ui/text/font/FontFamily;", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/unit/Density;)V", "getFont", "()Landroidx/compose/ui/text/font/FontFamily;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "<set-?>", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutResult", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setTextLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "textLayoutResult$delegate", "Landroidx/compose/runtime/MutableState;", "Companion", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RichInputFieldState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    public static final String INLINE_CONTENT_TAG = "INLINE_CONTENT_TAG";
    public static final char REPLACE_CHAR = 65533;
    private final Density density;
    private final FontFamily font;
    private final MutableState textLayoutResult$delegate;

    public RichInputFieldState(FontFamily font, Density density) {
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(density, "density");
        this.font = font;
        this.density = density;
        this.textLayoutResult$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final FontFamily getFont() {
        return this.font;
    }

    public final Density getDensity() {
        return this.density;
    }

    /* compiled from: RichInputField.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkntr/app/im/chat/ui/widget/RichInputFieldState$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "REPLACE_CHAR", RoomRecommendViewModel.EMPTY_CURSOR, RichInputFieldState.INLINE_CONTENT_TAG, RoomRecommendViewModel.EMPTY_CURSOR, "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final TextLayoutResult getTextLayoutResult() {
        State $this$getValue$iv = this.textLayoutResult$delegate;
        return (TextLayoutResult) $this$getValue$iv.getValue();
    }

    public final void setTextLayoutResult(TextLayoutResult textLayoutResult) {
        MutableState $this$setValue$iv = this.textLayoutResult$delegate;
        $this$setValue$iv.setValue(textLayoutResult);
    }
}