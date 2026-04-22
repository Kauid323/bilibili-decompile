package home.sidecenter.settings;

import com.bapis.bilibili.app.home.v1.KTab;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SideCenterSettings.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lhome/sidecenter/settings/SideCenterSettingType;", "", "isGroup", "", "<init>", "(Ljava/lang/String;IZ)V", "()Z", "Recent", "Story", "Listen", "Mine", "Companion", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum SideCenterSettingType {
    Recent(true),
    Story(false),
    Listen(false),
    Mine(true);
    
    private final boolean isGroup;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    public static EnumEntries<SideCenterSettingType> getEntries() {
        return $ENTRIES;
    }

    SideCenterSettingType(boolean isGroup) {
        this.isGroup = isGroup;
    }

    public final boolean isGroup() {
        return this.isGroup;
    }

    /* compiled from: SideCenterSettings.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lhome/sidecenter/settings/SideCenterSettingType$Companion;", "", "<init>", "()V", "fromKTab", "Lhome/sidecenter/settings/SideCenterSettingType;", "tab", "Lcom/bapis/bilibili/app/home/v1/KTab;", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SideCenterSettingType fromKTab(KTab tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            return Intrinsics.areEqual(tab, KTab.TAB_LISTEN.INSTANCE) ? SideCenterSettingType.Listen : Intrinsics.areEqual(tab, KTab.TAB_STORY.INSTANCE) ? SideCenterSettingType.Story : Intrinsics.areEqual(tab, KTab.TAB_RECENT.INSTANCE) ? SideCenterSettingType.Recent : SideCenterSettingType.Mine;
        }
    }
}