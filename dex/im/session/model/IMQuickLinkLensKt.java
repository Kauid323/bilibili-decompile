package im.session.model;

import com.bapis.bilibili.app.im.v1.KQuickLinkBubble;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import im.session.model.IMQuickLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMQuickLinkLens.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"0\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\",\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"*\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"F\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0016\u001a\u0004\b\f\u0010\u0017\"B\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017\"@\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00120\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017\"H\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u001b\"D\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0017\"B\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00120\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u001b\"F\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00188FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010 \u001a\u0004\b\f\u0010!\"B\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00188FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010 \u001a\u0004\b\u0010\u0010\"\"@\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00120\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00188FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010 \u001a\u0004\b\u0011\u0010!¨\u0006#"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/session/model/IMQuickLink;", "Lim/session/model/IMQuickLink$Companion;", "getLens$annotations", "(Lim/session/model/IMQuickLink$Companion;)V", "getLens", "(Lim/session/model/IMQuickLink$Companion;)Lcom/bilibili/blens/BSimpleLens;", "items", "", "Lim/session/model/IMQuickLinkItem;", "getItems$annotations", "getItems", "bubble", "Lcom/bapis/bilibili/app/im/v1/KQuickLinkBubble;", "getBubble$annotations", "getBubble", "isLegacyStyle", "", "isLegacyStyle$annotations", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "itemsNullable$annotations", "itemsNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "bubbleNullable$annotations", "bubbleNullable", "isLegacyStyleNullable$annotations", "isLegacyStyleNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMQuickLinkLensKt {
    public static /* synthetic */ void bubbleNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getBubble$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getBubble$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getBubble$annotations(IMQuickLink.Companion companion) {
    }

    public static /* synthetic */ void getItems$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getItems$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getItems$annotations(IMQuickLink.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(IMQuickLink.Companion companion) {
    }

    public static /* synthetic */ void isLegacyStyle$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isLegacyStyle$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isLegacyStyle$annotations(IMQuickLink.Companion companion) {
    }

    public static /* synthetic */ void isLegacyStyleNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void itemsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<IMQuickLink, IMQuickLink> getLens(IMQuickLink.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMQuickLink, IMQuickLink>() { // from class: im.session.model.IMQuickLinkLensKt$special$$inlined$invoke$1
            public IMQuickLink get(IMQuickLink iMQuickLink) {
                IMQuickLink it = iMQuickLink;
                return it;
            }

            public IMQuickLink set(IMQuickLink iMQuickLink, IMQuickLink iMQuickLink2) {
                IMQuickLink it = iMQuickLink2;
                return it;
            }

            public IMQuickLink modify(IMQuickLink iMQuickLink, Function1<? super IMQuickLink, ? extends IMQuickLink> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMQuickLink it = iMQuickLink;
                return (IMQuickLink) function1.invoke(it);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<IMQuickLink, List<IMQuickLinkItem>> getItems(IMQuickLink.Companion $this$items) {
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMQuickLink, List<? extends IMQuickLinkItem>>() { // from class: im.session.model.IMQuickLinkLensKt$special$$inlined$invoke$2
            public List<? extends IMQuickLinkItem> get(IMQuickLink iMQuickLink) {
                IMQuickLink it = iMQuickLink;
                return it.getItems();
            }

            public IMQuickLink set(IMQuickLink iMQuickLink, List<? extends IMQuickLinkItem> list) {
                List<? extends IMQuickLinkItem> items = list;
                IMQuickLink it = iMQuickLink;
                return IMQuickLink.copy$default(it, items, null, false, 6, null);
            }

            public IMQuickLink modify(IMQuickLink iMQuickLink, Function1<? super List<? extends IMQuickLinkItem>, ? extends List<? extends IMQuickLinkItem>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMQuickLink it = iMQuickLink;
                List items = (List) function1.invoke(it.getItems());
                IMQuickLink it2 = iMQuickLink;
                return IMQuickLink.copy$default(it2, items, null, false, 6, null);
            }
        };
    }

    public static final BSimpleLens<IMQuickLink, KQuickLinkBubble> getBubble(IMQuickLink.Companion $this$bubble) {
        Intrinsics.checkNotNullParameter($this$bubble, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMQuickLink, KQuickLinkBubble>() { // from class: im.session.model.IMQuickLinkLensKt$special$$inlined$invoke$3
            public KQuickLinkBubble get(IMQuickLink iMQuickLink) {
                IMQuickLink it = iMQuickLink;
                return it.getBubble();
            }

            public IMQuickLink set(IMQuickLink iMQuickLink, KQuickLinkBubble kQuickLinkBubble) {
                KQuickLinkBubble bubble = kQuickLinkBubble;
                IMQuickLink it = iMQuickLink;
                return IMQuickLink.copy$default(it, null, bubble, false, 5, null);
            }

            public IMQuickLink modify(IMQuickLink iMQuickLink, Function1<? super KQuickLinkBubble, ? extends KQuickLinkBubble> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMQuickLink it = iMQuickLink;
                KQuickLinkBubble bubble = (KQuickLinkBubble) function1.invoke(it.getBubble());
                IMQuickLink it2 = iMQuickLink;
                return IMQuickLink.copy$default(it2, null, bubble, false, 5, null);
            }
        };
    }

    public static final BSimpleLens<IMQuickLink, Boolean> isLegacyStyle(IMQuickLink.Companion $this$isLegacyStyle) {
        Intrinsics.checkNotNullParameter($this$isLegacyStyle, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMQuickLink, Boolean>() { // from class: im.session.model.IMQuickLinkLensKt$special$$inlined$invoke$4
            public Boolean get(IMQuickLink iMQuickLink) {
                IMQuickLink it = iMQuickLink;
                return Boolean.valueOf(it.isLegacyStyle());
            }

            public IMQuickLink set(IMQuickLink iMQuickLink, Boolean bool) {
                boolean isLegacyStyle = bool.booleanValue();
                IMQuickLink it = iMQuickLink;
                return IMQuickLink.copy$default(it, null, null, isLegacyStyle, 3, null);
            }

            public IMQuickLink modify(IMQuickLink iMQuickLink, Function1<? super Boolean, ? extends Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMQuickLink it = iMQuickLink;
                boolean isLegacyStyle = ((Boolean) function1.invoke(Boolean.valueOf(it.isLegacyStyle()))).booleanValue();
                IMQuickLink it2 = iMQuickLink;
                return IMQuickLink.copy$default(it2, null, null, isLegacyStyle, 3, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, List<IMQuickLinkItem>> getItems(BSimpleLens<T, IMQuickLink> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getItems(IMQuickLink.Companion));
    }

    public static final <T> BSimpleLens<T, KQuickLinkBubble> getBubble(BSimpleLens<T, IMQuickLink> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getBubble(IMQuickLink.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isLegacyStyle(BSimpleLens<T, IMQuickLink> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isLegacyStyle(IMQuickLink.Companion));
    }

    public static final <T> BNullableLens<T, List<IMQuickLinkItem>> itemsNullable(BSimpleLens<T, IMQuickLink> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getItems(IMQuickLink.Companion));
    }

    public static final <T> BSimpleLens<T, KQuickLinkBubble> bubbleNullable(BSimpleLens<T, IMQuickLink> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getBubble(IMQuickLink.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isLegacyStyleNullable(BSimpleLens<T, IMQuickLink> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isLegacyStyle(IMQuickLink.Companion));
    }

    public static final <T> BNullableLens<T, List<IMQuickLinkItem>> getItems(BNullableLens<T, IMQuickLink> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getItems(IMQuickLink.Companion));
    }

    public static final <T> BSimpleLens<T, KQuickLinkBubble> getBubble(BNullableLens<T, IMQuickLink> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getBubble(IMQuickLink.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isLegacyStyle(BNullableLens<T, IMQuickLink> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isLegacyStyle(IMQuickLink.Companion));
    }
}