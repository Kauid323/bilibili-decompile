package im.session.model;

import com.bapis.bilibili.app.im.v1.KQuickLinkItemType;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgTabType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMQuickLink.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"mapToOldType", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgTabType;", "Lcom/bapis/bilibili/app/im/v1/KQuickLinkItemType;", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMQuickLinkKt {
    public static final KMsgTabType mapToOldType(KQuickLinkItemType $this$mapToOldType) {
        Intrinsics.checkNotNullParameter($this$mapToOldType, "<this>");
        return Intrinsics.areEqual($this$mapToOldType, KQuickLinkItemType.QUICK_LINK_ITEM_TYPE_AT.INSTANCE) ? KMsgTabType.AT_ME.INSTANCE : Intrinsics.areEqual($this$mapToOldType, KQuickLinkItemType.QUICK_LINK_ITEM_TYPE_FOLLOW.INSTANCE) ? KMsgTabType.NEW_FOLLOW.INSTANCE : Intrinsics.areEqual($this$mapToOldType, KQuickLinkItemType.QUICK_LINK_ITEM_TYPE_HUA_HUO.INSTANCE) ? KMsgTabType.HUA_HUO.INSTANCE : Intrinsics.areEqual($this$mapToOldType, KQuickLinkItemType.QUICK_LINK_ITEM_TYPE_LIKE.INSTANCE) ? KMsgTabType.RECEIVE_LIKE.INSTANCE : Intrinsics.areEqual($this$mapToOldType, KQuickLinkItemType.QUICK_LINK_ITEM_TYPE_OLD_LIKE.INSTANCE) ? KMsgTabType.LIKE_ME.INSTANCE : Intrinsics.areEqual($this$mapToOldType, KQuickLinkItemType.QUICK_LINK_ITEM_TYPE_OLD_REPLY.INSTANCE) ? KMsgTabType.REPLY_ME.INSTANCE : Intrinsics.areEqual($this$mapToOldType, KQuickLinkItemType.QUICK_LINK_ITEM_TYPE_REPLY.INSTANCE) ? KMsgTabType.RECEIVE_REPLY.INSTANCE : Intrinsics.areEqual($this$mapToOldType, KQuickLinkItemType.QUICK_LINK_ITEM_TYPE_SYSTEM.INSTANCE) ? KMsgTabType.SYSTEM_MSG.INSTANCE : Intrinsics.areEqual($this$mapToOldType, KQuickLinkItemType.QUICK_LINK_ITEM_TYPE_UNKNOWN.INSTANCE) ? null : null;
    }
}