package kntr.common.ouro.common.ui.toolPanel.setting;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: SettingSection.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lkntr/common/ouro/common/ui/toolPanel/setting/SettingSectionItem;", "", "title", "Lorg/jetbrains/compose/resources/StringResource;", "items", "", "Lkntr/common/ouro/common/ui/toolPanel/setting/SettingItem;", "<init>", "(Lorg/jetbrains/compose/resources/StringResource;Ljava/util/List;)V", "getTitle", "()Lorg/jetbrains/compose/resources/StringResource;", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SettingSectionItem {
    public static final int $stable = 8;
    private final List<SettingItem> items;
    private final StringResource title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingSectionItem copy$default(SettingSectionItem settingSectionItem, StringResource stringResource, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            stringResource = settingSectionItem.title;
        }
        if ((i & 2) != 0) {
            list = settingSectionItem.items;
        }
        return settingSectionItem.copy(stringResource, list);
    }

    public final StringResource component1() {
        return this.title;
    }

    public final List<SettingItem> component2() {
        return this.items;
    }

    public final SettingSectionItem copy(StringResource stringResource, List<? extends SettingItem> list) {
        Intrinsics.checkNotNullParameter(stringResource, "title");
        Intrinsics.checkNotNullParameter(list, "items");
        return new SettingSectionItem(stringResource, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingSectionItem) {
            SettingSectionItem settingSectionItem = (SettingSectionItem) obj;
            return Intrinsics.areEqual(this.title, settingSectionItem.title) && Intrinsics.areEqual(this.items, settingSectionItem.items);
        }
        return false;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.items.hashCode();
    }

    public String toString() {
        StringResource stringResource = this.title;
        return "SettingSectionItem(title=" + stringResource + ", items=" + this.items + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SettingSectionItem(StringResource title, List<? extends SettingItem> list) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(list, "items");
        this.title = title;
        this.items = list;
    }

    public final StringResource getTitle() {
        return this.title;
    }

    public final List<SettingItem> getItems() {
        return this.items;
    }
}