package im.session.model;

import com.bapis.bilibili.app.im.v1.KGetQuickLinkUnreadReply;
import com.bilibili.blens.Lens;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMQuickLink.kt */
@Lens
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/session/model/KGetQuickLinkUnreadReplyEntrance;", "", "item", "Lcom/bapis/bilibili/app/im/v1/KGetQuickLinkUnreadReply;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KGetQuickLinkUnreadReply;)V", "getItem", "()Lcom/bapis/bilibili/app/im/v1/KGetQuickLinkUnreadReply;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KGetQuickLinkUnreadReplyEntrance {
    public static final Companion Companion = new Companion(null);
    private final KGetQuickLinkUnreadReply item;

    public static /* synthetic */ KGetQuickLinkUnreadReplyEntrance copy$default(KGetQuickLinkUnreadReplyEntrance kGetQuickLinkUnreadReplyEntrance, KGetQuickLinkUnreadReply kGetQuickLinkUnreadReply, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kGetQuickLinkUnreadReply = kGetQuickLinkUnreadReplyEntrance.item;
        }
        return kGetQuickLinkUnreadReplyEntrance.copy(kGetQuickLinkUnreadReply);
    }

    public final KGetQuickLinkUnreadReply component1() {
        return this.item;
    }

    public final KGetQuickLinkUnreadReplyEntrance copy(KGetQuickLinkUnreadReply kGetQuickLinkUnreadReply) {
        Intrinsics.checkNotNullParameter(kGetQuickLinkUnreadReply, "item");
        return new KGetQuickLinkUnreadReplyEntrance(kGetQuickLinkUnreadReply);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof KGetQuickLinkUnreadReplyEntrance) && Intrinsics.areEqual(this.item, ((KGetQuickLinkUnreadReplyEntrance) obj).item);
    }

    public int hashCode() {
        return this.item.hashCode();
    }

    public String toString() {
        return "KGetQuickLinkUnreadReplyEntrance(item=" + this.item + ")";
    }

    public KGetQuickLinkUnreadReplyEntrance(KGetQuickLinkUnreadReply item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
    }

    public final KGetQuickLinkUnreadReply getItem() {
        return this.item;
    }

    /* compiled from: IMQuickLink.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lim/session/model/KGetQuickLinkUnreadReplyEntrance$Companion;", "", "<init>", "()V", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}