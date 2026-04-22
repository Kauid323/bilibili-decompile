package im.session.service;

import com.bapis.bilibili.app.im.v1.KMsgSummaryPrefixType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMMessageSummaryService.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0087\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lim/session/service/SummaryPrefixType;", "", "priority", "", "color", "Lim/session/service/SummaryPrefixColor;", "<init>", "(Ljava/lang/String;IILim/session/service/SummaryPrefixColor;)V", "getPriority", "()I", "getColor", "()Lim/session/service/SummaryPrefixColor;", "None", "MessageCount", "Notification", "Mentioned", "Draft", "GroupBlocked", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum SummaryPrefixType {
    None(0, SummaryPrefixColor.Gray),
    MessageCount(1, SummaryPrefixColor.Gray),
    Notification(2, SummaryPrefixColor.Gray),
    Mentioned(3, SummaryPrefixColor.Gray),
    Draft(4, SummaryPrefixColor.Red),
    GroupBlocked(5, SummaryPrefixColor.Gray);
    
    private final SummaryPrefixColor color;
    private final int priority;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    public static EnumEntries<SummaryPrefixType> getEntries() {
        return $ENTRIES;
    }

    SummaryPrefixType(int priority, SummaryPrefixColor color) {
        this.priority = priority;
        this.color = color;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final SummaryPrefixColor getColor() {
        return this.color;
    }

    /* compiled from: IMMessageSummaryService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lim/session/service/SummaryPrefixType$Companion;", "", "<init>", "()V", "fromKType", "Lim/session/service/SummaryPrefixType;", "type", "Lcom/bapis/bilibili/app/im/v1/KMsgSummaryPrefixType;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SummaryPrefixType fromKType(KMsgSummaryPrefixType type) {
            return Intrinsics.areEqual(type, KMsgSummaryPrefixType.MSG_SUMMARY_PREFIX_TYPE_NOTIFICATION.INSTANCE) ? SummaryPrefixType.Notification : Intrinsics.areEqual(type, KMsgSummaryPrefixType.MSG_SUMMARY_PREFIX_TYPE_GROUP_BLOCKED.INSTANCE) ? SummaryPrefixType.GroupBlocked : Intrinsics.areEqual(type, KMsgSummaryPrefixType.MSG_SUMMARY_PREFIX_TYPE_MENTIONED.INSTANCE) ? SummaryPrefixType.Mentioned : Intrinsics.areEqual(type, KMsgSummaryPrefixType.MSG_SUMMARY_PREFIX_TYPE_UNREAD.INSTANCE) ? SummaryPrefixType.MessageCount : SummaryPrefixType.None;
        }
    }
}