package tv.danmaku.bili.push.innerpush.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: InnerPushReplayBody.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/push/innerpush/model/InnerPushReplayBody;", "", "msgs", "", "Ltv/danmaku/bili/push/innerpush/model/InnerPushReplayMessage;", "<init>", "(Ljava/util/List;)V", "getMsgs", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InnerPushReplayBody {
    public static final int $stable = 8;
    @SerializedName("msgs")
    private final List<InnerPushReplayMessage> msgs;

    public InnerPushReplayBody() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InnerPushReplayBody copy$default(InnerPushReplayBody innerPushReplayBody, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = innerPushReplayBody.msgs;
        }
        return innerPushReplayBody.copy(list);
    }

    public final List<InnerPushReplayMessage> component1() {
        return this.msgs;
    }

    public final InnerPushReplayBody copy(List<InnerPushReplayMessage> list) {
        return new InnerPushReplayBody(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InnerPushReplayBody) && Intrinsics.areEqual(this.msgs, ((InnerPushReplayBody) obj).msgs);
    }

    public int hashCode() {
        if (this.msgs == null) {
            return 0;
        }
        return this.msgs.hashCode();
    }

    public String toString() {
        return "InnerPushReplayBody(msgs=" + this.msgs + ")";
    }

    public InnerPushReplayBody(List<InnerPushReplayMessage> list) {
        this.msgs = list;
    }

    public /* synthetic */ InnerPushReplayBody(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<InnerPushReplayMessage> getMsgs() {
        return this.msgs;
    }
}