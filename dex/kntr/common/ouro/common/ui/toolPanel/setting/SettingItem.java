package kntr.common.ouro.common.ui.toolPanel.setting;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: SettingSection.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/common/ui/toolPanel/setting/SettingItem;", "", "CheckBox", "Lkntr/common/ouro/common/ui/toolPanel/setting/SettingItem$CheckBox;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface SettingItem {

    /* compiled from: SettingSection.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lkntr/common/ouro/common/ui/toolPanel/setting/SettingItem$CheckBox;", "Lkntr/common/ouro/common/ui/toolPanel/setting/SettingItem;", "title", "Lorg/jetbrains/compose/resources/StringResource;", "subtitle", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "", "<init>", "(Lorg/jetbrains/compose/resources/StringResource;Lorg/jetbrains/compose/resources/StringResource;ZLkotlin/jvm/functions/Function1;)V", "getTitle", "()Lorg/jetbrains/compose/resources/StringResource;", "getSubtitle", "getChecked", "()Z", "getOnCheckedChange", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CheckBox implements SettingItem {
        public static final int $stable = 0;
        private final boolean checked;
        private final Function1<Boolean, Unit> onCheckedChange;
        private final StringResource subtitle;
        private final StringResource title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CheckBox copy$default(CheckBox checkBox, StringResource stringResource, StringResource stringResource2, boolean z, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                stringResource = checkBox.title;
            }
            if ((i & 2) != 0) {
                stringResource2 = checkBox.subtitle;
            }
            if ((i & 4) != 0) {
                z = checkBox.checked;
            }
            if ((i & 8) != 0) {
                function1 = checkBox.onCheckedChange;
            }
            return checkBox.copy(stringResource, stringResource2, z, function1);
        }

        public final StringResource component1() {
            return this.title;
        }

        public final StringResource component2() {
            return this.subtitle;
        }

        public final boolean component3() {
            return this.checked;
        }

        public final Function1<Boolean, Unit> component4() {
            return this.onCheckedChange;
        }

        public final CheckBox copy(StringResource stringResource, StringResource stringResource2, boolean z, Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(stringResource, "title");
            Intrinsics.checkNotNullParameter(stringResource2, "subtitle");
            Intrinsics.checkNotNullParameter(function1, "onCheckedChange");
            return new CheckBox(stringResource, stringResource2, z, function1);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) obj;
                return Intrinsics.areEqual(this.title, checkBox.title) && Intrinsics.areEqual(this.subtitle, checkBox.subtitle) && this.checked == checkBox.checked && Intrinsics.areEqual(this.onCheckedChange, checkBox.onCheckedChange);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.checked)) * 31) + this.onCheckedChange.hashCode();
        }

        public String toString() {
            StringResource stringResource = this.title;
            StringResource stringResource2 = this.subtitle;
            boolean z = this.checked;
            return "CheckBox(title=" + stringResource + ", subtitle=" + stringResource2 + ", checked=" + z + ", onCheckedChange=" + this.onCheckedChange + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CheckBox(StringResource title, StringResource subtitle, boolean checked, Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(subtitle, "subtitle");
            Intrinsics.checkNotNullParameter(function1, "onCheckedChange");
            this.title = title;
            this.subtitle = subtitle;
            this.checked = checked;
            this.onCheckedChange = function1;
        }

        public final StringResource getTitle() {
            return this.title;
        }

        public final StringResource getSubtitle() {
            return this.subtitle;
        }

        public final boolean getChecked() {
            return this.checked;
        }

        public final Function1<Boolean, Unit> getOnCheckedChange() {
            return this.onCheckedChange;
        }
    }
}