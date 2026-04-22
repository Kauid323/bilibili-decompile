package im.session.model;

import com.bapis.bilibili.app.im.v1.KGetQuickLinkUnreadReply;
import com.bapis.bilibili.app.im.v1.KQuickLinkUnreadItem;
import com.bapis.bilibili.app.im.v1.KUnread;
import com.bapis.bilibili.app.im.v1.KUnreadStyle;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionPageData.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t¨\u0006\n"}, d2 = {"updateUnread", "Lim/session/model/IMQuickLink;", "response", "Lcom/bapis/bilibili/app/im/v1/KGetQuickLinkUnreadReply;", "uniqueAndSort", "", "Lim/session/model/IMSessionCard;", "none", "Lcom/bapis/bilibili/app/im/v1/KUnread;", "Lcom/bapis/bilibili/app/im/v1/KUnread$Companion;", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSessionPageDataKt {
    public static final IMQuickLink updateUnread(IMQuickLink $this$updateUnread, final KGetQuickLinkUnreadReply response) {
        return (IMQuickLink) CopyScopeKt.copy($this$updateUnread, new Function1() { // from class: im.session.model.IMSessionPageDataKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit updateUnread$lambda$0;
                updateUnread$lambda$0 = IMSessionPageDataKt.updateUnread$lambda$0(response, (CopyScope) obj);
                return updateUnread$lambda$0;
            }
        });
    }

    public static final Unit updateUnread$lambda$0(final KGetQuickLinkUnreadReply $response, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.transform(IMQuickLinkLensKt.getItems(IMQuickLink.Companion), new Function1() { // from class: im.session.model.IMSessionPageDataKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                List updateUnread$lambda$0$0;
                updateUnread$lambda$0$0 = IMSessionPageDataKt.updateUnread$lambda$0$0($response, (List) obj);
                return updateUnread$lambda$0$0;
            }
        });
        return Unit.INSTANCE;
    }

    public static final List updateUnread$lambda$0$0(KGetQuickLinkUnreadReply $response, List it) {
        Object obj;
        Intrinsics.checkNotNullParameter(it, "it");
        List $this$map$iv = it;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            IMQuickLinkItem source = (IMQuickLinkItem) item$iv$iv;
            BSimpleLens<IMQuickLinkItem, KUnread> unread = IMQuickLinkItemLensKt.getUnread(IMQuickLinkItem.Companion);
            Iterator it2 = $response.getItems().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (Intrinsics.areEqual(((KQuickLinkUnreadItem) obj).getItemType(), source.getType())) {
                    break;
                }
            }
            KQuickLinkUnreadItem kQuickLinkUnreadItem = (KQuickLinkUnreadItem) obj;
            destination$iv$iv.add((IMQuickLinkItem) unread.set(source, kQuickLinkUnreadItem != null ? kQuickLinkUnreadItem.getUnread() : null));
        }
        return (List) destination$iv$iv;
    }

    public static final List<IMSessionCard> uniqueAndSort(List<IMSessionCard> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<IMSessionCard> $this$distinctBy$iv = list;
        HashSet set$iv = new HashSet();
        ArrayList list$iv = new ArrayList();
        for (Object e$iv : $this$distinctBy$iv) {
            IMSessionCard it = (IMSessionCard) e$iv;
            if (set$iv.add(it.getId())) {
                list$iv.add(e$iv);
            }
        }
        ArrayList $this$distinctBy$iv2 = list$iv;
        return CollectionsKt.sortedWith($this$distinctBy$iv2, IMSessionCard.Companion.getCOMPARATOR());
    }

    public static final KUnread none(KUnread.Companion $this$none) {
        Intrinsics.checkNotNullParameter($this$none, "<this>");
        return new KUnread(KUnreadStyle.UNREAD_STYLE_NONE.INSTANCE, 0L, "");
    }
}