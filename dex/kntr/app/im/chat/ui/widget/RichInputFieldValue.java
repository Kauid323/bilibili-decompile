package kntr.app.im.chat.ui.widget;

import androidx.compose.ui.text.input.TextFieldValue;
import java.util.List;
import kntr.app.im.chat.db.model.InlineContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RichInputField.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lkntr/app/im/chat/ui/widget/RichInputFieldValue;", RoomRecommendViewModel.EMPTY_CURSOR, "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "inlineContents", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/db/model/InlineContent;", "<init>", "(Landroidx/compose/ui/text/input/TextFieldValue;Ljava/util/List;)V", "getTextFieldValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "getInlineContents", "()Ljava/util/List;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RichInputFieldValue {
    public static final int $stable = 0;
    private final List<InlineContent> inlineContents;
    private final TextFieldValue textFieldValue;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RichInputFieldValue copy$default(RichInputFieldValue richInputFieldValue, TextFieldValue textFieldValue, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            textFieldValue = richInputFieldValue.textFieldValue;
        }
        if ((i & 2) != 0) {
            list = richInputFieldValue.inlineContents;
        }
        return richInputFieldValue.copy(textFieldValue, list);
    }

    public final TextFieldValue component1() {
        return this.textFieldValue;
    }

    public final List<InlineContent> component2() {
        return this.inlineContents;
    }

    public final RichInputFieldValue copy(TextFieldValue textFieldValue, List<InlineContent> list) {
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        Intrinsics.checkNotNullParameter(list, "inlineContents");
        return new RichInputFieldValue(textFieldValue, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RichInputFieldValue) {
            RichInputFieldValue richInputFieldValue = (RichInputFieldValue) obj;
            return Intrinsics.areEqual(this.textFieldValue, richInputFieldValue.textFieldValue) && Intrinsics.areEqual(this.inlineContents, richInputFieldValue.inlineContents);
        }
        return false;
    }

    public int hashCode() {
        return (this.textFieldValue.hashCode() * 31) + this.inlineContents.hashCode();
    }

    public String toString() {
        TextFieldValue textFieldValue = this.textFieldValue;
        return "RichInputFieldValue(textFieldValue=" + textFieldValue + ", inlineContents=" + this.inlineContents + ")";
    }

    public RichInputFieldValue(TextFieldValue textFieldValue, List<InlineContent> list) {
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        Intrinsics.checkNotNullParameter(list, "inlineContents");
        this.textFieldValue = textFieldValue;
        this.inlineContents = list;
    }

    public final TextFieldValue getTextFieldValue() {
        return this.textFieldValue;
    }

    public final List<InlineContent> getInlineContents() {
        return this.inlineContents;
    }
}