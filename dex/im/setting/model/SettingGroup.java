package im.setting.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingGroup.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lim/setting/model/SettingGroup;", "", "titleEnum", "Lim/setting/model/SettingGroupTitleEnum;", "items", "", "Lim/setting/model/SettingItem;", "<init>", "(Lim/setting/model/SettingGroupTitleEnum;Ljava/util/List;)V", "getTitleEnum", "()Lim/setting/model/SettingGroupTitleEnum;", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SettingGroup {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final List<SettingItem> items;
    private final SettingGroupTitleEnum titleEnum;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingGroup copy$default(SettingGroup settingGroup, SettingGroupTitleEnum settingGroupTitleEnum, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            settingGroupTitleEnum = settingGroup.titleEnum;
        }
        if ((i2 & 2) != 0) {
            list = settingGroup.items;
        }
        return settingGroup.copy(settingGroupTitleEnum, list);
    }

    public final SettingGroupTitleEnum component1() {
        return this.titleEnum;
    }

    public final List<SettingItem> component2() {
        return this.items;
    }

    public final SettingGroup copy(SettingGroupTitleEnum settingGroupTitleEnum, List<? extends SettingItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        return new SettingGroup(settingGroupTitleEnum, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingGroup) {
            SettingGroup settingGroup = (SettingGroup) obj;
            return this.titleEnum == settingGroup.titleEnum && Intrinsics.areEqual(this.items, settingGroup.items);
        }
        return false;
    }

    public int hashCode() {
        return ((this.titleEnum == null ? 0 : this.titleEnum.hashCode()) * 31) + this.items.hashCode();
    }

    public String toString() {
        SettingGroupTitleEnum settingGroupTitleEnum = this.titleEnum;
        return "SettingGroup(titleEnum=" + settingGroupTitleEnum + ", items=" + this.items + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SettingGroup(SettingGroupTitleEnum titleEnum, List<? extends SettingItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.titleEnum = titleEnum;
        this.items = list;
    }

    public final SettingGroupTitleEnum getTitleEnum() {
        return this.titleEnum;
    }

    public final List<SettingItem> getItems() {
        return this.items;
    }

    /* compiled from: SettingGroup.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lim/setting/model/SettingGroup$Companion;", "", "<init>", "()V", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}