package kntr.app.tribee.publish;

import BottomSheetItemData$;
import com.bapis.bilibili.dynamic.common.KUpPermissionType;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishSettingItem.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B=\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0014\u0010\t\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011\u0082\u0001\u0002\u0014\u0015¨\u0006\u0016"}, d2 = {"Lkntr/app/tribee/publish/TribeePublishSettingItem;", "", "type", "Lcom/bapis/bilibili/dynamic/common/KUpPermissionType;", "title", "", "description", "isEnabled", "", "isVisible", "<init>", "(Lcom/bapis/bilibili/dynamic/common/KUpPermissionType;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getType", "()Lcom/bapis/bilibili/dynamic/common/KUpPermissionType;", "getTitle", "()Ljava/lang/String;", "getDescription", "()Z", "Switch", "Button", "Lkntr/app/tribee/publish/TribeePublishSettingItem$Button;", "Lkntr/app/tribee/publish/TribeePublishSettingItem$Switch;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class TribeePublishSettingItem {
    private final String description;
    private final boolean isEnabled;
    private final boolean isVisible;
    private final String title;
    private final KUpPermissionType type;

    public /* synthetic */ TribeePublishSettingItem(KUpPermissionType kUpPermissionType, String str, String str2, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kUpPermissionType, str, str2, z, z2);
    }

    private TribeePublishSettingItem(KUpPermissionType type, String title, String description, boolean isEnabled, boolean isVisible) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.isEnabled = isEnabled;
        this.isVisible = isVisible;
    }

    public /* synthetic */ TribeePublishSettingItem(KUpPermissionType kUpPermissionType, String str, String str2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? (KUpPermissionType) KUpPermissionType.UP_PERMISSION_TYPE_NONE.INSTANCE : kUpPermissionType, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? true : z, (i & 16) != 0 ? true : z2, null);
    }

    public KUpPermissionType getType() {
        return this.type;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* compiled from: TribeePublishSettingItem.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003JG\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u0014\u0010\t\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0012R\u0014\u0010\n\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0012¨\u0006 "}, d2 = {"Lkntr/app/tribee/publish/TribeePublishSettingItem$Switch;", "Lkntr/app/tribee/publish/TribeePublishSettingItem;", "type", "Lcom/bapis/bilibili/dynamic/common/KUpPermissionType;", "title", "", "description", "isChecked", "", "isEnabled", "isVisible", "<init>", "(Lcom/bapis/bilibili/dynamic/common/KUpPermissionType;Ljava/lang/String;Ljava/lang/String;ZZZ)V", "getType", "()Lcom/bapis/bilibili/dynamic/common/KUpPermissionType;", "getTitle", "()Ljava/lang/String;", "getDescription", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Switch extends TribeePublishSettingItem {
        private final String description;
        private final boolean isChecked;
        private final boolean isEnabled;
        private final boolean isVisible;
        private final String title;
        private final KUpPermissionType type;

        public static /* synthetic */ Switch copy$default(Switch r4, KUpPermissionType kUpPermissionType, String str, String str2, boolean z, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                kUpPermissionType = r4.type;
            }
            if ((i & 2) != 0) {
                str = r4.title;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                str2 = r4.description;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                z = r4.isChecked;
            }
            boolean z4 = z;
            if ((i & 16) != 0) {
                z2 = r4.isEnabled;
            }
            boolean z5 = z2;
            if ((i & 32) != 0) {
                z3 = r4.isVisible;
            }
            return r4.copy(kUpPermissionType, str3, str4, z4, z5, z3);
        }

        public final KUpPermissionType component1() {
            return this.type;
        }

        public final String component2() {
            return this.title;
        }

        public final String component3() {
            return this.description;
        }

        public final boolean component4() {
            return this.isChecked;
        }

        public final boolean component5() {
            return this.isEnabled;
        }

        public final boolean component6() {
            return this.isVisible;
        }

        public final Switch copy(KUpPermissionType kUpPermissionType, String str, String str2, boolean z, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(kUpPermissionType, "type");
            Intrinsics.checkNotNullParameter(str, "title");
            return new Switch(kUpPermissionType, str, str2, z, z2, z3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Switch) {
                Switch r1 = (Switch) obj;
                return Intrinsics.areEqual(this.type, r1.type) && Intrinsics.areEqual(this.title, r1.title) && Intrinsics.areEqual(this.description, r1.description) && this.isChecked == r1.isChecked && this.isEnabled == r1.isEnabled && this.isVisible == r1.isVisible;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((this.type.hashCode() * 31) + this.title.hashCode()) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isChecked)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isEnabled)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isVisible);
        }

        public String toString() {
            KUpPermissionType kUpPermissionType = this.type;
            String str = this.title;
            String str2 = this.description;
            boolean z = this.isChecked;
            boolean z2 = this.isEnabled;
            return "Switch(type=" + kUpPermissionType + ", title=" + str + ", description=" + str2 + ", isChecked=" + z + ", isEnabled=" + z2 + ", isVisible=" + this.isVisible + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Switch(KUpPermissionType type, String title, String description, boolean isChecked, boolean isEnabled, boolean isVisible) {
            super(null, null, null, false, false, 31, null);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            this.type = type;
            this.title = title;
            this.description = description;
            this.isChecked = isChecked;
            this.isEnabled = isEnabled;
            this.isVisible = isVisible;
        }

        public /* synthetic */ Switch(KUpPermissionType kUpPermissionType, String str, String str2, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(kUpPermissionType, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? true : z3);
        }

        @Override // kntr.app.tribee.publish.TribeePublishSettingItem
        public KUpPermissionType getType() {
            return this.type;
        }

        @Override // kntr.app.tribee.publish.TribeePublishSettingItem
        public String getTitle() {
            return this.title;
        }

        @Override // kntr.app.tribee.publish.TribeePublishSettingItem
        public String getDescription() {
            return this.description;
        }

        public final boolean isChecked() {
            return this.isChecked;
        }

        @Override // kntr.app.tribee.publish.TribeePublishSettingItem
        public boolean isEnabled() {
            return this.isEnabled;
        }

        @Override // kntr.app.tribee.publish.TribeePublishSettingItem
        public boolean isVisible() {
            return this.isVisible;
        }
    }

    /* compiled from: TribeePublishSettingItem.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0014\u0010\t\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011¨\u0006\u001e"}, d2 = {"Lkntr/app/tribee/publish/TribeePublishSettingItem$Button;", "Lkntr/app/tribee/publish/TribeePublishSettingItem;", "type", "Lcom/bapis/bilibili/dynamic/common/KUpPermissionType;", "title", "", "description", "isEnabled", "", "isVisible", "<init>", "(Lcom/bapis/bilibili/dynamic/common/KUpPermissionType;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getType", "()Lcom/bapis/bilibili/dynamic/common/KUpPermissionType;", "getTitle", "()Ljava/lang/String;", "getDescription", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Button extends TribeePublishSettingItem {
        private final String description;
        private final boolean isEnabled;
        private final boolean isVisible;
        private final String title;
        private final KUpPermissionType type;

        public static /* synthetic */ Button copy$default(Button button, KUpPermissionType kUpPermissionType, String str, String str2, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                kUpPermissionType = button.type;
            }
            if ((i & 2) != 0) {
                str = button.title;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                str2 = button.description;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                z = button.isEnabled;
            }
            boolean z3 = z;
            if ((i & 16) != 0) {
                z2 = button.isVisible;
            }
            return button.copy(kUpPermissionType, str3, str4, z3, z2);
        }

        public final KUpPermissionType component1() {
            return this.type;
        }

        public final String component2() {
            return this.title;
        }

        public final String component3() {
            return this.description;
        }

        public final boolean component4() {
            return this.isEnabled;
        }

        public final boolean component5() {
            return this.isVisible;
        }

        public final Button copy(KUpPermissionType kUpPermissionType, String str, String str2, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(kUpPermissionType, "type");
            Intrinsics.checkNotNullParameter(str, "title");
            return new Button(kUpPermissionType, str, str2, z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Button) {
                Button button = (Button) obj;
                return Intrinsics.areEqual(this.type, button.type) && Intrinsics.areEqual(this.title, button.title) && Intrinsics.areEqual(this.description, button.description) && this.isEnabled == button.isEnabled && this.isVisible == button.isVisible;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.type.hashCode() * 31) + this.title.hashCode()) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isEnabled)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isVisible);
        }

        public String toString() {
            KUpPermissionType kUpPermissionType = this.type;
            String str = this.title;
            String str2 = this.description;
            boolean z = this.isEnabled;
            return "Button(type=" + kUpPermissionType + ", title=" + str + ", description=" + str2 + ", isEnabled=" + z + ", isVisible=" + this.isVisible + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Button(KUpPermissionType type, String title, String description, boolean isEnabled, boolean isVisible) {
            super(null, null, null, false, false, 31, null);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            this.type = type;
            this.title = title;
            this.description = description;
            this.isEnabled = isEnabled;
            this.isVisible = isVisible;
        }

        public /* synthetic */ Button(KUpPermissionType kUpPermissionType, String str, String str2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(kUpPermissionType, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? true : z, (i & 16) != 0 ? true : z2);
        }

        @Override // kntr.app.tribee.publish.TribeePublishSettingItem
        public KUpPermissionType getType() {
            return this.type;
        }

        @Override // kntr.app.tribee.publish.TribeePublishSettingItem
        public String getTitle() {
            return this.title;
        }

        @Override // kntr.app.tribee.publish.TribeePublishSettingItem
        public String getDescription() {
            return this.description;
        }

        @Override // kntr.app.tribee.publish.TribeePublishSettingItem
        public boolean isEnabled() {
            return this.isEnabled;
        }

        @Override // kntr.app.tribee.publish.TribeePublishSettingItem
        public boolean isVisible() {
            return this.isVisible;
        }
    }
}