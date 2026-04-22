package kntr.base.dd.preview;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputDialog.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lkntr/base/dd/preview/InputDialogModel;", "", "title", "", "placeholders", "", "tips", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getPlaceholders", "()Ljava/util/List;", "getTips", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InputDialogModel {
    public static final int $stable = 8;
    private final List<String> placeholders;
    private final String tips;
    private final String title;

    public InputDialogModel() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InputDialogModel copy$default(InputDialogModel inputDialogModel, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inputDialogModel.title;
        }
        if ((i & 2) != 0) {
            list = inputDialogModel.placeholders;
        }
        if ((i & 4) != 0) {
            str2 = inputDialogModel.tips;
        }
        return inputDialogModel.copy(str, list, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final List<String> component2() {
        return this.placeholders;
    }

    public final String component3() {
        return this.tips;
    }

    public final InputDialogModel copy(String str, List<String> list, String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "placeholders");
        return new InputDialogModel(str, list, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InputDialogModel) {
            InputDialogModel inputDialogModel = (InputDialogModel) obj;
            return Intrinsics.areEqual(this.title, inputDialogModel.title) && Intrinsics.areEqual(this.placeholders, inputDialogModel.placeholders) && Intrinsics.areEqual(this.tips, inputDialogModel.tips);
        }
        return false;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.placeholders.hashCode()) * 31) + (this.tips == null ? 0 : this.tips.hashCode());
    }

    public String toString() {
        String str = this.title;
        List<String> list = this.placeholders;
        return "InputDialogModel(title=" + str + ", placeholders=" + list + ", tips=" + this.tips + ")";
    }

    public InputDialogModel(String title, List<String> list, String tips) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(list, "placeholders");
        this.title = title;
        this.placeholders = list;
        this.tips = tips;
    }

    public /* synthetic */ InputDialogModel(String str, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : str2);
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<String> getPlaceholders() {
        return this.placeholders;
    }

    public final String getTips() {
        return this.tips;
    }
}