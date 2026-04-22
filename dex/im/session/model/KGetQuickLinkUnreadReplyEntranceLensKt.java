package im.session.model;

import com.bapis.bilibili.app.im.v1.KGetQuickLinkUnreadReply;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import im.session.model.KGetQuickLinkUnreadReplyEntrance;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KGetQuickLinkUnreadReplyEntranceLens.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\f*\u00020\r*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000e\u001a\u0004\b\u000b\u0010\u000f\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0010\"\b\b\u0000\u0010\f*\u00020\r*\u0010\u0012\u0004\u0012\u0002H\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0010\"\b\b\u0000\u0010\f*\u00020\r*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0014\u001a\u0004\b\u000b\u0010\u0015¨\u0006\u0016"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/session/model/KGetQuickLinkUnreadReplyEntrance;", "Lim/session/model/KGetQuickLinkUnreadReplyEntrance$Companion;", "getLens$annotations", "(Lim/session/model/KGetQuickLinkUnreadReplyEntrance$Companion;)V", "getLens", "(Lim/session/model/KGetQuickLinkUnreadReplyEntrance$Companion;)Lcom/bilibili/blens/BSimpleLens;", "item", "Lcom/bapis/bilibili/app/im/v1/KGetQuickLinkUnreadReply;", "getItem$annotations", "getItem", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "itemNullable$annotations", "itemNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KGetQuickLinkUnreadReplyEntranceLensKt {
    public static /* synthetic */ void getItem$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getItem$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getItem$annotations(KGetQuickLinkUnreadReplyEntrance.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(KGetQuickLinkUnreadReplyEntrance.Companion companion) {
    }

    public static /* synthetic */ void itemNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<KGetQuickLinkUnreadReplyEntrance, KGetQuickLinkUnreadReplyEntrance> getLens(KGetQuickLinkUnreadReplyEntrance.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<KGetQuickLinkUnreadReplyEntrance, KGetQuickLinkUnreadReplyEntrance>() { // from class: im.session.model.KGetQuickLinkUnreadReplyEntranceLensKt$special$$inlined$invoke$1
            public KGetQuickLinkUnreadReplyEntrance get(KGetQuickLinkUnreadReplyEntrance kGetQuickLinkUnreadReplyEntrance) {
                KGetQuickLinkUnreadReplyEntrance it = kGetQuickLinkUnreadReplyEntrance;
                return it;
            }

            public KGetQuickLinkUnreadReplyEntrance set(KGetQuickLinkUnreadReplyEntrance kGetQuickLinkUnreadReplyEntrance, KGetQuickLinkUnreadReplyEntrance kGetQuickLinkUnreadReplyEntrance2) {
                KGetQuickLinkUnreadReplyEntrance it = kGetQuickLinkUnreadReplyEntrance2;
                return it;
            }

            public KGetQuickLinkUnreadReplyEntrance modify(KGetQuickLinkUnreadReplyEntrance kGetQuickLinkUnreadReplyEntrance, Function1<? super KGetQuickLinkUnreadReplyEntrance, ? extends KGetQuickLinkUnreadReplyEntrance> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                KGetQuickLinkUnreadReplyEntrance it = kGetQuickLinkUnreadReplyEntrance;
                return (KGetQuickLinkUnreadReplyEntrance) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<KGetQuickLinkUnreadReplyEntrance, KGetQuickLinkUnreadReply> getItem(KGetQuickLinkUnreadReplyEntrance.Companion $this$item) {
        Intrinsics.checkNotNullParameter($this$item, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<KGetQuickLinkUnreadReplyEntrance, KGetQuickLinkUnreadReply>() { // from class: im.session.model.KGetQuickLinkUnreadReplyEntranceLensKt$special$$inlined$invoke$2
            public KGetQuickLinkUnreadReply get(KGetQuickLinkUnreadReplyEntrance kGetQuickLinkUnreadReplyEntrance) {
                KGetQuickLinkUnreadReplyEntrance it = kGetQuickLinkUnreadReplyEntrance;
                return it.getItem();
            }

            public KGetQuickLinkUnreadReplyEntrance set(KGetQuickLinkUnreadReplyEntrance kGetQuickLinkUnreadReplyEntrance, KGetQuickLinkUnreadReply kGetQuickLinkUnreadReply) {
                KGetQuickLinkUnreadReply item = kGetQuickLinkUnreadReply;
                KGetQuickLinkUnreadReplyEntrance it = kGetQuickLinkUnreadReplyEntrance;
                return it.copy(item);
            }

            public KGetQuickLinkUnreadReplyEntrance modify(KGetQuickLinkUnreadReplyEntrance kGetQuickLinkUnreadReplyEntrance, Function1<? super KGetQuickLinkUnreadReply, ? extends KGetQuickLinkUnreadReply> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                KGetQuickLinkUnreadReplyEntrance it = kGetQuickLinkUnreadReplyEntrance;
                KGetQuickLinkUnreadReply item = (KGetQuickLinkUnreadReply) function1.invoke(it.getItem());
                KGetQuickLinkUnreadReplyEntrance it2 = kGetQuickLinkUnreadReplyEntrance;
                return it2.copy(item);
            }
        };
    }

    public static final <T> BSimpleLens<T, KGetQuickLinkUnreadReply> getItem(BSimpleLens<T, KGetQuickLinkUnreadReplyEntrance> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getItem(KGetQuickLinkUnreadReplyEntrance.Companion));
    }

    public static final <T> BNullableLens<T, KGetQuickLinkUnreadReply> itemNullable(BSimpleLens<T, KGetQuickLinkUnreadReplyEntrance> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getItem(KGetQuickLinkUnreadReplyEntrance.Companion));
    }

    public static final <T> BNullableLens<T, KGetQuickLinkUnreadReply> getItem(BNullableLens<T, KGetQuickLinkUnreadReplyEntrance> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getItem(KGetQuickLinkUnreadReplyEntrance.Companion));
    }
}