package home.sidecenter.tabs;

import com.bapis.bilibili.app.home.v1.KTab;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SideCenterTabs.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lhome/sidecenter/tabs/SideCenterTab;", "", "value", "", "priority", "<init>", "(Ljava/lang/String;III)V", "getValue", "()I", "getPriority", "UNKNOWN", "LISTEN", "STORY", "RECENT", "Companion", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum SideCenterTab {
    UNKNOWN(KTab.TAB_UNKNOWN.INSTANCE.getValue(), 0),
    LISTEN(KTab.TAB_LISTEN.INSTANCE.getValue(), 2),
    STORY(KTab.TAB_STORY.INSTANCE.getValue(), 3),
    RECENT(KTab.TAB_RECENT.INSTANCE.getValue(), 4);
    
    private final int priority;
    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    public static EnumEntries<SideCenterTab> getEntries() {
        return $ENTRIES;
    }

    SideCenterTab(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public final int getValue() {
        return this.value;
    }

    public final int getPriority() {
        return this.priority;
    }

    /* compiled from: SideCenterTabs.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lhome/sidecenter/tabs/SideCenterTab$Companion;", "", "<init>", "()V", "fromKTab", "Lhome/sidecenter/tabs/SideCenterTab;", "tab", "Lcom/bapis/bilibili/app/home/v1/KTab;", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SideCenterTab fromKTab(KTab tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            return Intrinsics.areEqual(tab, KTab.TAB_LISTEN.INSTANCE) ? SideCenterTab.LISTEN : Intrinsics.areEqual(tab, KTab.TAB_STORY.INSTANCE) ? SideCenterTab.STORY : Intrinsics.areEqual(tab, KTab.TAB_RECENT.INSTANCE) ? SideCenterTab.RECENT : SideCenterTab.UNKNOWN;
        }
    }
}