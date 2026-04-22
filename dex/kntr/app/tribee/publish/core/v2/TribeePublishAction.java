package kntr.app.tribee.publish.core.v2;

import BottomSheetItemData$;
import com.bapis.bilibili.dynamic.common.KTribeeCategory;
import com.bapis.bilibili.dynamic.common.KUpPermissionType;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishAction.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u000b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\u0082\u0001\u000b\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "", "TitleChanged", "SwitchSendToFollowing", "SwitchSettingItem", "ToggleSelectedCategory", "Publish", "DismissConfirmDialog", "SaveDraft", "ClearDraft", "Close", "ConsumeToast", "TrackerAction", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$ClearDraft;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$Close;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$ConsumeToast;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$DismissConfirmDialog;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$Publish;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$SaveDraft;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$SwitchSendToFollowing;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$SwitchSettingItem;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TitleChanged;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$ToggleSelectedCategory;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeePublishAction {

    /* compiled from: TribeePublishAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TitleChanged;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "string", "", "<init>", "(Ljava/lang/String;)V", "getString", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TitleChanged implements TribeePublishAction {
        private final String string;

        public static /* synthetic */ TitleChanged copy$default(TitleChanged titleChanged, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = titleChanged.string;
            }
            return titleChanged.copy(str);
        }

        public final String component1() {
            return this.string;
        }

        public final TitleChanged copy(String str) {
            Intrinsics.checkNotNullParameter(str, "string");
            return new TitleChanged(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TitleChanged) && Intrinsics.areEqual(this.string, ((TitleChanged) obj).string);
        }

        public int hashCode() {
            return this.string.hashCode();
        }

        public String toString() {
            return "TitleChanged(string=" + this.string + ")";
        }

        public TitleChanged(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            this.string = string;
        }

        public final String getString() {
            return this.string;
        }
    }

    /* compiled from: TribeePublishAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$SwitchSendToFollowing;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "enabled", "", "<init>", "(Z)V", "getEnabled", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SwitchSendToFollowing implements TribeePublishAction {
        private final boolean enabled;

        public static /* synthetic */ SwitchSendToFollowing copy$default(SwitchSendToFollowing switchSendToFollowing, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = switchSendToFollowing.enabled;
            }
            return switchSendToFollowing.copy(z);
        }

        public final boolean component1() {
            return this.enabled;
        }

        public final SwitchSendToFollowing copy(boolean z) {
            return new SwitchSendToFollowing(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SwitchSendToFollowing) && this.enabled == ((SwitchSendToFollowing) obj).enabled;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enabled);
        }

        public String toString() {
            return "SwitchSendToFollowing(enabled=" + this.enabled + ")";
        }

        public SwitchSendToFollowing(boolean enabled) {
            this.enabled = enabled;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }
    }

    /* compiled from: TribeePublishAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0015"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$SwitchSettingItem;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "type", "Lcom/bapis/bilibili/dynamic/common/KUpPermissionType;", "isChecked", "", "<init>", "(Lcom/bapis/bilibili/dynamic/common/KUpPermissionType;Z)V", "getType", "()Lcom/bapis/bilibili/dynamic/common/KUpPermissionType;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SwitchSettingItem implements TribeePublishAction {
        private final boolean isChecked;
        private final KUpPermissionType type;

        public static /* synthetic */ SwitchSettingItem copy$default(SwitchSettingItem switchSettingItem, KUpPermissionType kUpPermissionType, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                kUpPermissionType = switchSettingItem.type;
            }
            if ((i & 2) != 0) {
                z = switchSettingItem.isChecked;
            }
            return switchSettingItem.copy(kUpPermissionType, z);
        }

        public final KUpPermissionType component1() {
            return this.type;
        }

        public final boolean component2() {
            return this.isChecked;
        }

        public final SwitchSettingItem copy(KUpPermissionType kUpPermissionType, boolean z) {
            Intrinsics.checkNotNullParameter(kUpPermissionType, "type");
            return new SwitchSettingItem(kUpPermissionType, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SwitchSettingItem) {
                SwitchSettingItem switchSettingItem = (SwitchSettingItem) obj;
                return Intrinsics.areEqual(this.type, switchSettingItem.type) && this.isChecked == switchSettingItem.isChecked;
            }
            return false;
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isChecked);
        }

        public String toString() {
            KUpPermissionType kUpPermissionType = this.type;
            return "SwitchSettingItem(type=" + kUpPermissionType + ", isChecked=" + this.isChecked + ")";
        }

        public SwitchSettingItem(KUpPermissionType type, boolean isChecked) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.isChecked = isChecked;
        }

        public final KUpPermissionType getType() {
            return this.type;
        }

        public final boolean isChecked() {
            return this.isChecked;
        }
    }

    /* compiled from: TribeePublishAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$ToggleSelectedCategory;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "category", "Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "<init>", "(Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;)V", "getCategory", "()Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ToggleSelectedCategory implements TribeePublishAction {
        private final KTribeeCategory category;

        public ToggleSelectedCategory() {
            this(null, 1, null);
        }

        public static /* synthetic */ ToggleSelectedCategory copy$default(ToggleSelectedCategory toggleSelectedCategory, KTribeeCategory kTribeeCategory, int i, Object obj) {
            if ((i & 1) != 0) {
                kTribeeCategory = toggleSelectedCategory.category;
            }
            return toggleSelectedCategory.copy(kTribeeCategory);
        }

        public final KTribeeCategory component1() {
            return this.category;
        }

        public final ToggleSelectedCategory copy(KTribeeCategory kTribeeCategory) {
            return new ToggleSelectedCategory(kTribeeCategory);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ToggleSelectedCategory) && Intrinsics.areEqual(this.category, ((ToggleSelectedCategory) obj).category);
        }

        public int hashCode() {
            if (this.category == null) {
                return 0;
            }
            return this.category.hashCode();
        }

        public String toString() {
            return "ToggleSelectedCategory(category=" + this.category + ")";
        }

        public ToggleSelectedCategory(KTribeeCategory category) {
            this.category = category;
        }

        public /* synthetic */ ToggleSelectedCategory(KTribeeCategory kTribeeCategory, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : kTribeeCategory);
        }

        public final KTribeeCategory getCategory() {
            return this.category;
        }
    }

    /* compiled from: TribeePublishAction.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$Publish;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "toastOnTitleOverflow", "", "toastOnContentOverflow", "strongPublish", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getToastOnTitleOverflow", "()Ljava/lang/String;", "getToastOnContentOverflow", "getStrongPublish", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Publish implements TribeePublishAction {
        private final boolean strongPublish;
        private final String toastOnContentOverflow;
        private final String toastOnTitleOverflow;

        public Publish() {
            this(null, null, false, 7, null);
        }

        public static /* synthetic */ Publish copy$default(Publish publish, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = publish.toastOnTitleOverflow;
            }
            if ((i & 2) != 0) {
                str2 = publish.toastOnContentOverflow;
            }
            if ((i & 4) != 0) {
                z = publish.strongPublish;
            }
            return publish.copy(str, str2, z);
        }

        public final String component1() {
            return this.toastOnTitleOverflow;
        }

        public final String component2() {
            return this.toastOnContentOverflow;
        }

        public final boolean component3() {
            return this.strongPublish;
        }

        public final Publish copy(String str, String str2, boolean z) {
            return new Publish(str, str2, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Publish) {
                Publish publish = (Publish) obj;
                return Intrinsics.areEqual(this.toastOnTitleOverflow, publish.toastOnTitleOverflow) && Intrinsics.areEqual(this.toastOnContentOverflow, publish.toastOnContentOverflow) && this.strongPublish == publish.strongPublish;
            }
            return false;
        }

        public int hashCode() {
            return ((((this.toastOnTitleOverflow == null ? 0 : this.toastOnTitleOverflow.hashCode()) * 31) + (this.toastOnContentOverflow != null ? this.toastOnContentOverflow.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.strongPublish);
        }

        public String toString() {
            String str = this.toastOnTitleOverflow;
            String str2 = this.toastOnContentOverflow;
            return "Publish(toastOnTitleOverflow=" + str + ", toastOnContentOverflow=" + str2 + ", strongPublish=" + this.strongPublish + ")";
        }

        public Publish(String toastOnTitleOverflow, String toastOnContentOverflow, boolean strongPublish) {
            this.toastOnTitleOverflow = toastOnTitleOverflow;
            this.toastOnContentOverflow = toastOnContentOverflow;
            this.strongPublish = strongPublish;
        }

        public /* synthetic */ Publish(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z);
        }

        public final String getToastOnTitleOverflow() {
            return this.toastOnTitleOverflow;
        }

        public final String getToastOnContentOverflow() {
            return this.toastOnContentOverflow;
        }

        public final boolean getStrongPublish() {
            return this.strongPublish;
        }
    }

    /* compiled from: TribeePublishAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$DismissConfirmDialog;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DismissConfirmDialog implements TribeePublishAction {
        public static final DismissConfirmDialog INSTANCE = new DismissConfirmDialog();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DismissConfirmDialog) {
                DismissConfirmDialog dismissConfirmDialog = (DismissConfirmDialog) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 2088047325;
        }

        public String toString() {
            return "DismissConfirmDialog";
        }

        private DismissConfirmDialog() {
        }
    }

    /* compiled from: TribeePublishAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$SaveDraft;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SaveDraft implements TribeePublishAction {
        public static final SaveDraft INSTANCE = new SaveDraft();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SaveDraft) {
                SaveDraft saveDraft = (SaveDraft) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1838564965;
        }

        public String toString() {
            return "SaveDraft";
        }

        private SaveDraft() {
        }
    }

    /* compiled from: TribeePublishAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$ClearDraft;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ClearDraft implements TribeePublishAction {
        public static final ClearDraft INSTANCE = new ClearDraft();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ClearDraft) {
                ClearDraft clearDraft = (ClearDraft) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -235033805;
        }

        public String toString() {
            return "ClearDraft";
        }

        private ClearDraft() {
        }
    }

    /* compiled from: TribeePublishAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$Close;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Close implements TribeePublishAction {
        public static final Close INSTANCE = new Close();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Close) {
                Close close = (Close) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -78627143;
        }

        public String toString() {
            return "Close";
        }

        private Close() {
        }
    }

    /* compiled from: TribeePublishAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$ConsumeToast;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ConsumeToast implements TribeePublishAction {
        public static final ConsumeToast INSTANCE = new ConsumeToast();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ConsumeToast) {
                ConsumeToast consumeToast = (ConsumeToast) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -990692438;
        }

        public String toString() {
            return "ConsumeToast";
        }

        private ConsumeToast() {
        }
    }

    /* compiled from: TribeePublishAction.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\n\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\u0082\u0001\n\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "PublishButtonClick", "PublishSuccessClick", "PhotoFloatLayerExposure", "PhotoFloatLayerClick", "SyncToDynClick", "SettingsClick", "ToolbarButtonClick", "ToolPanelButtonClick", "CategorySelected", "CategoryExposure", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$CategoryExposure;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$CategorySelected;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$PhotoFloatLayerClick;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$PhotoFloatLayerExposure;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$PublishButtonClick;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$PublishSuccessClick;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$SettingsClick;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$SyncToDynClick;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$ToolPanelButtonClick;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$ToolbarButtonClick;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface TrackerAction extends TribeePublishAction {

        /* compiled from: TribeePublishAction.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$PublishButtonClick;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class PublishButtonClick implements TrackerAction {
            public static final PublishButtonClick INSTANCE = new PublishButtonClick();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof PublishButtonClick) {
                    PublishButtonClick publishButtonClick = (PublishButtonClick) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 1253115398;
            }

            public String toString() {
                return "PublishButtonClick";
            }

            private PublishButtonClick() {
            }
        }

        /* compiled from: TribeePublishAction.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$PublishSuccessClick;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class PublishSuccessClick implements TrackerAction {
            public static final PublishSuccessClick INSTANCE = new PublishSuccessClick();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof PublishSuccessClick) {
                    PublishSuccessClick publishSuccessClick = (PublishSuccessClick) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -970225483;
            }

            public String toString() {
                return "PublishSuccessClick";
            }

            private PublishSuccessClick() {
            }
        }

        /* compiled from: TribeePublishAction.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$PhotoFloatLayerExposure;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class PhotoFloatLayerExposure implements TrackerAction {
            public static final PhotoFloatLayerExposure INSTANCE = new PhotoFloatLayerExposure();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof PhotoFloatLayerExposure) {
                    PhotoFloatLayerExposure photoFloatLayerExposure = (PhotoFloatLayerExposure) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -1562675057;
            }

            public String toString() {
                return "PhotoFloatLayerExposure";
            }

            private PhotoFloatLayerExposure() {
            }
        }

        /* compiled from: TribeePublishAction.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$PhotoFloatLayerClick;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction;", "actionType", "", "<init>", "(Ljava/lang/String;)V", "getActionType", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class PhotoFloatLayerClick implements TrackerAction {
            private final String actionType;

            public static /* synthetic */ PhotoFloatLayerClick copy$default(PhotoFloatLayerClick photoFloatLayerClick, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = photoFloatLayerClick.actionType;
                }
                return photoFloatLayerClick.copy(str);
            }

            public final String component1() {
                return this.actionType;
            }

            public final PhotoFloatLayerClick copy(String str) {
                Intrinsics.checkNotNullParameter(str, "actionType");
                return new PhotoFloatLayerClick(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof PhotoFloatLayerClick) && Intrinsics.areEqual(this.actionType, ((PhotoFloatLayerClick) obj).actionType);
            }

            public int hashCode() {
                return this.actionType.hashCode();
            }

            public String toString() {
                return "PhotoFloatLayerClick(actionType=" + this.actionType + ")";
            }

            public PhotoFloatLayerClick(String actionType) {
                Intrinsics.checkNotNullParameter(actionType, "actionType");
                this.actionType = actionType;
            }

            public final String getActionType() {
                return this.actionType;
            }
        }

        /* compiled from: TribeePublishAction.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$SyncToDynClick;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class SyncToDynClick implements TrackerAction {
            public static final SyncToDynClick INSTANCE = new SyncToDynClick();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof SyncToDynClick) {
                    SyncToDynClick syncToDynClick = (SyncToDynClick) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 491151300;
            }

            public String toString() {
                return "SyncToDynClick";
            }

            private SyncToDynClick() {
            }
        }

        /* compiled from: TribeePublishAction.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$SettingsClick;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class SettingsClick implements TrackerAction {
            public static final SettingsClick INSTANCE = new SettingsClick();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof SettingsClick) {
                    SettingsClick settingsClick = (SettingsClick) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 373109414;
            }

            public String toString() {
                return "SettingsClick";
            }

            private SettingsClick() {
            }
        }

        /* compiled from: TribeePublishAction.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$ToolbarButtonClick;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction;", "button", "", "<init>", "(Ljava/lang/String;)V", "getButton", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class ToolbarButtonClick implements TrackerAction {
            private final String button;

            public static /* synthetic */ ToolbarButtonClick copy$default(ToolbarButtonClick toolbarButtonClick, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = toolbarButtonClick.button;
                }
                return toolbarButtonClick.copy(str);
            }

            public final String component1() {
                return this.button;
            }

            public final ToolbarButtonClick copy(String str) {
                Intrinsics.checkNotNullParameter(str, "button");
                return new ToolbarButtonClick(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ToolbarButtonClick) && Intrinsics.areEqual(this.button, ((ToolbarButtonClick) obj).button);
            }

            public int hashCode() {
                return this.button.hashCode();
            }

            public String toString() {
                return "ToolbarButtonClick(button=" + this.button + ")";
            }

            public ToolbarButtonClick(String button) {
                Intrinsics.checkNotNullParameter(button, "button");
                this.button = button;
            }

            public final String getButton() {
                return this.button;
            }
        }

        /* compiled from: TribeePublishAction.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$ToolPanelButtonClick;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction;", "button", "", "isSelected", "", "<init>", "(Ljava/lang/String;Z)V", "getButton", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class ToolPanelButtonClick implements TrackerAction {
            private final String button;
            private final boolean isSelected;

            public static /* synthetic */ ToolPanelButtonClick copy$default(ToolPanelButtonClick toolPanelButtonClick, String str, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = toolPanelButtonClick.button;
                }
                if ((i & 2) != 0) {
                    z = toolPanelButtonClick.isSelected;
                }
                return toolPanelButtonClick.copy(str, z);
            }

            public final String component1() {
                return this.button;
            }

            public final boolean component2() {
                return this.isSelected;
            }

            public final ToolPanelButtonClick copy(String str, boolean z) {
                Intrinsics.checkNotNullParameter(str, "button");
                return new ToolPanelButtonClick(str, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ToolPanelButtonClick) {
                    ToolPanelButtonClick toolPanelButtonClick = (ToolPanelButtonClick) obj;
                    return Intrinsics.areEqual(this.button, toolPanelButtonClick.button) && this.isSelected == toolPanelButtonClick.isSelected;
                }
                return false;
            }

            public int hashCode() {
                return (this.button.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isSelected);
            }

            public String toString() {
                String str = this.button;
                return "ToolPanelButtonClick(button=" + str + ", isSelected=" + this.isSelected + ")";
            }

            public ToolPanelButtonClick(String button, boolean isSelected) {
                Intrinsics.checkNotNullParameter(button, "button");
                this.button = button;
                this.isSelected = isSelected;
            }

            public final String getButton() {
                return this.button;
            }

            public final boolean isSelected() {
                return this.isSelected;
            }
        }

        /* compiled from: TribeePublishAction.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$CategorySelected;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction;", "tribeeId", "", "category", "Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "<init>", "(Ljava/lang/String;Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;)V", "getTribeeId", "()Ljava/lang/String;", "getCategory", "()Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class CategorySelected implements TrackerAction {
            private final KTribeeCategory category;
            private final String tribeeId;

            public static /* synthetic */ CategorySelected copy$default(CategorySelected categorySelected, String str, KTribeeCategory kTribeeCategory, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = categorySelected.tribeeId;
                }
                if ((i & 2) != 0) {
                    kTribeeCategory = categorySelected.category;
                }
                return categorySelected.copy(str, kTribeeCategory);
            }

            public final String component1() {
                return this.tribeeId;
            }

            public final KTribeeCategory component2() {
                return this.category;
            }

            public final CategorySelected copy(String str, KTribeeCategory kTribeeCategory) {
                Intrinsics.checkNotNullParameter(str, "tribeeId");
                Intrinsics.checkNotNullParameter(kTribeeCategory, "category");
                return new CategorySelected(str, kTribeeCategory);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof CategorySelected) {
                    CategorySelected categorySelected = (CategorySelected) obj;
                    return Intrinsics.areEqual(this.tribeeId, categorySelected.tribeeId) && Intrinsics.areEqual(this.category, categorySelected.category);
                }
                return false;
            }

            public int hashCode() {
                return (this.tribeeId.hashCode() * 31) + this.category.hashCode();
            }

            public String toString() {
                String str = this.tribeeId;
                return "CategorySelected(tribeeId=" + str + ", category=" + this.category + ")";
            }

            public CategorySelected(String tribeeId, KTribeeCategory category) {
                Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
                Intrinsics.checkNotNullParameter(category, "category");
                this.tribeeId = tribeeId;
                this.category = category;
            }

            public final String getTribeeId() {
                return this.tribeeId;
            }

            public final KTribeeCategory getCategory() {
                return this.category;
            }
        }

        /* compiled from: TribeePublishAction.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction$CategoryExposure;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$TrackerAction;", "tribeeId", "", "category", "Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "<init>", "(Ljava/lang/String;Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;)V", "getTribeeId", "()Ljava/lang/String;", "getCategory", "()Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class CategoryExposure implements TrackerAction {
            private final KTribeeCategory category;
            private final String tribeeId;

            public static /* synthetic */ CategoryExposure copy$default(CategoryExposure categoryExposure, String str, KTribeeCategory kTribeeCategory, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = categoryExposure.tribeeId;
                }
                if ((i & 2) != 0) {
                    kTribeeCategory = categoryExposure.category;
                }
                return categoryExposure.copy(str, kTribeeCategory);
            }

            public final String component1() {
                return this.tribeeId;
            }

            public final KTribeeCategory component2() {
                return this.category;
            }

            public final CategoryExposure copy(String str, KTribeeCategory kTribeeCategory) {
                Intrinsics.checkNotNullParameter(str, "tribeeId");
                Intrinsics.checkNotNullParameter(kTribeeCategory, "category");
                return new CategoryExposure(str, kTribeeCategory);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof CategoryExposure) {
                    CategoryExposure categoryExposure = (CategoryExposure) obj;
                    return Intrinsics.areEqual(this.tribeeId, categoryExposure.tribeeId) && Intrinsics.areEqual(this.category, categoryExposure.category);
                }
                return false;
            }

            public int hashCode() {
                return (this.tribeeId.hashCode() * 31) + this.category.hashCode();
            }

            public String toString() {
                String str = this.tribeeId;
                return "CategoryExposure(tribeeId=" + str + ", category=" + this.category + ")";
            }

            public CategoryExposure(String tribeeId, KTribeeCategory category) {
                Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
                Intrinsics.checkNotNullParameter(category, "category");
                this.tribeeId = tribeeId;
                this.category = category;
            }

            public final String getTribeeId() {
                return this.tribeeId;
            }

            public final KTribeeCategory getCategory() {
                return this.category;
            }
        }
    }
}