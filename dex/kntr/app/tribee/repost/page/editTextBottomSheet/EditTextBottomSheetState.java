package kntr.app.tribee.repost.page.editTextBottomSheet;

import androidx.compose.ui.unit.Dp;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EditTextBottomSheetState.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b \u0010\u0017JX\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\bHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\n\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2 = {"Lkntr/app/tribee/repost/page/editTextBottomSheet/EditTextBottomSheetState;", "", "title", "", "subtitle", "text", "placeholder", "maxLength", "", "buttonText", "textFieldHeight", "Landroidx/compose/ui/unit/Dp;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getSubtitle", "getText", "getPlaceholder", "getMaxLength", "()I", "getButtonText", "getTextFieldHeight-D9Ej5fM", "()F", "F", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component7-D9Ej5fM", "copy", "copy-6ZxE2Lo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;F)Lkntr/app/tribee/repost/page/editTextBottomSheet/EditTextBottomSheetState;", "equals", "", "other", "hashCode", "toString", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class EditTextBottomSheetState {
    public static final int $stable = 0;
    private final String buttonText;
    private final int maxLength;
    private final String placeholder;
    private final String subtitle;
    private final String text;
    private final float textFieldHeight;
    private final String title;

    public /* synthetic */ EditTextBottomSheetState(String str, String str2, String str3, String str4, int i, String str5, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, i, str5, f);
    }

    /* renamed from: copy-6ZxE2Lo$default  reason: not valid java name */
    public static /* synthetic */ EditTextBottomSheetState m1010copy6ZxE2Lo$default(EditTextBottomSheetState editTextBottomSheetState, String str, String str2, String str3, String str4, int i, String str5, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = editTextBottomSheetState.title;
        }
        if ((i2 & 2) != 0) {
            str2 = editTextBottomSheetState.subtitle;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = editTextBottomSheetState.text;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = editTextBottomSheetState.placeholder;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            i = editTextBottomSheetState.maxLength;
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            str5 = editTextBottomSheetState.buttonText;
        }
        String str9 = str5;
        if ((i2 & 64) != 0) {
            f = editTextBottomSheetState.textFieldHeight;
        }
        return editTextBottomSheetState.m1012copy6ZxE2Lo(str, str6, str7, str8, i3, str9, f);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subtitle;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.placeholder;
    }

    public final int component5() {
        return this.maxLength;
    }

    public final String component6() {
        return this.buttonText;
    }

    /* renamed from: component7-D9Ej5fM  reason: not valid java name */
    public final float m1011component7D9Ej5fM() {
        return this.textFieldHeight;
    }

    /* renamed from: copy-6ZxE2Lo  reason: not valid java name */
    public final EditTextBottomSheetState m1012copy6ZxE2Lo(String str, String str2, String str3, String str4, int i, String str5, float f) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str3, "text");
        Intrinsics.checkNotNullParameter(str4, "placeholder");
        Intrinsics.checkNotNullParameter(str5, "buttonText");
        return new EditTextBottomSheetState(str, str2, str3, str4, i, str5, f, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EditTextBottomSheetState) {
            EditTextBottomSheetState editTextBottomSheetState = (EditTextBottomSheetState) obj;
            return Intrinsics.areEqual(this.title, editTextBottomSheetState.title) && Intrinsics.areEqual(this.subtitle, editTextBottomSheetState.subtitle) && Intrinsics.areEqual(this.text, editTextBottomSheetState.text) && Intrinsics.areEqual(this.placeholder, editTextBottomSheetState.placeholder) && this.maxLength == editTextBottomSheetState.maxLength && Intrinsics.areEqual(this.buttonText, editTextBottomSheetState.buttonText) && Dp.equals-impl0(this.textFieldHeight, editTextBottomSheetState.textFieldHeight);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.title.hashCode() * 31) + (this.subtitle == null ? 0 : this.subtitle.hashCode())) * 31) + this.text.hashCode()) * 31) + this.placeholder.hashCode()) * 31) + this.maxLength) * 31) + this.buttonText.hashCode()) * 31) + Dp.hashCode-impl(this.textFieldHeight);
    }

    public String toString() {
        String str = this.title;
        String str2 = this.subtitle;
        String str3 = this.text;
        String str4 = this.placeholder;
        int i = this.maxLength;
        String str5 = this.buttonText;
        return "EditTextBottomSheetState(title=" + str + ", subtitle=" + str2 + ", text=" + str3 + ", placeholder=" + str4 + ", maxLength=" + i + ", buttonText=" + str5 + ", textFieldHeight=" + Dp.toString-impl(this.textFieldHeight) + ")";
    }

    private EditTextBottomSheetState(String title, String subtitle, String text, String placeholder, int maxLength, String buttonText, float textFieldHeight) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        this.title = title;
        this.subtitle = subtitle;
        this.text = text;
        this.placeholder = placeholder;
        this.maxLength = maxLength;
        this.buttonText = buttonText;
        this.textFieldHeight = textFieldHeight;
    }

    public /* synthetic */ EditTextBottomSheetState(String str, String str2, String str3, String str4, int i, String str5, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? 0 : i, str5, f, null);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getText() {
        return this.text;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final int getMaxLength() {
        return this.maxLength;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    /* renamed from: getTextFieldHeight-D9Ej5fM  reason: not valid java name */
    public final float m1013getTextFieldHeightD9Ej5fM() {
        return this.textFieldHeight;
    }
}