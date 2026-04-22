package im.session.model;

import com.bapis.bilibili.app.im.v1.KQuickLinkItemType;
import com.bapis.bilibili.app.im.v1.KUnread;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import im.session.model.IMQuickLinkItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMQuickLinkItemLens.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"*\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\",\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"*\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001f\u001a\u0004\b\u000b\u0010 \"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u001f\u001a\u0004\b\u000e\u0010 \"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u001f\u001a\u0004\b\u0011\u0010 \"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u001f\u001a\u0004\b\u0014\u0010 \"B\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u001f\u001a\u0004\b\u0018\u0010 \"@\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u001a0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u001f\u001a\u0004\b\u001c\u0010 \"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010$\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010$\"B\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010$\"B\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010$\"D\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010 \"B\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u001a0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010\u001f\u001a\u0004\b.\u0010$\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010/\u001a\u0004\b\u000b\u00100\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010/\u001a\u0004\b\u000e\u00100\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010/\u001a\u0004\b\u0011\u00100\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010/\u001a\u0004\b\u0014\u00100\"B\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010/\u001a\u0004\b\u0018\u00101\"@\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u001a0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010/\u001a\u0004\b\u001c\u00100¨\u00062"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/session/model/IMQuickLinkItem;", "Lim/session/model/IMQuickLinkItem$Companion;", "getLens$annotations", "(Lim/session/model/IMQuickLinkItem$Companion;)V", "getLens", "(Lim/session/model/IMQuickLinkItem$Companion;)Lcom/bilibili/blens/BSimpleLens;", "title", "", "getTitle$annotations", "getTitle", "url", "getUrl$annotations", "getUrl", "icon", "getIcon$annotations", "getIcon", "iconForNight", "getIconForNight$annotations", "getIconForNight", "unread", "Lcom/bapis/bilibili/app/im/v1/KUnread;", "getUnread$annotations", "getUnread", "type", "Lcom/bapis/bilibili/app/im/v1/KQuickLinkItemType;", "getType$annotations", "getType", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "titleNullable$annotations", "titleNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "urlNullable$annotations", "urlNullable", "iconNullable$annotations", "iconNullable", "iconForNightNullable$annotations", "iconForNightNullable", "unreadNullable$annotations", "unreadNullable", "typeNullable$annotations", "typeNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMQuickLinkItemLensKt {
    public static /* synthetic */ void getIcon$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getIcon$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getIcon$annotations(IMQuickLinkItem.Companion companion) {
    }

    public static /* synthetic */ void getIconForNight$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getIconForNight$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getIconForNight$annotations(IMQuickLinkItem.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(IMQuickLinkItem.Companion companion) {
    }

    public static /* synthetic */ void getTitle$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTitle$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTitle$annotations(IMQuickLinkItem.Companion companion) {
    }

    public static /* synthetic */ void getType$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getType$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getType$annotations(IMQuickLinkItem.Companion companion) {
    }

    public static /* synthetic */ void getUnread$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getUnread$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getUnread$annotations(IMQuickLinkItem.Companion companion) {
    }

    public static /* synthetic */ void getUrl$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getUrl$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getUrl$annotations(IMQuickLinkItem.Companion companion) {
    }

    public static /* synthetic */ void iconForNightNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void iconNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void titleNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void typeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void unreadNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void urlNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<IMQuickLinkItem, IMQuickLinkItem> getLens(IMQuickLinkItem.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMQuickLinkItem, IMQuickLinkItem>() { // from class: im.session.model.IMQuickLinkItemLensKt$special$$inlined$invoke$1
            public IMQuickLinkItem get(IMQuickLinkItem iMQuickLinkItem) {
                IMQuickLinkItem it = iMQuickLinkItem;
                return it;
            }

            public IMQuickLinkItem set(IMQuickLinkItem iMQuickLinkItem, IMQuickLinkItem iMQuickLinkItem2) {
                IMQuickLinkItem it = iMQuickLinkItem2;
                return it;
            }

            public IMQuickLinkItem modify(IMQuickLinkItem iMQuickLinkItem, Function1<? super IMQuickLinkItem, ? extends IMQuickLinkItem> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMQuickLinkItem it = iMQuickLinkItem;
                return (IMQuickLinkItem) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<IMQuickLinkItem, String> getTitle(IMQuickLinkItem.Companion $this$title) {
        Intrinsics.checkNotNullParameter($this$title, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMQuickLinkItem, String>() { // from class: im.session.model.IMQuickLinkItemLensKt$special$$inlined$invoke$2
            public String get(IMQuickLinkItem iMQuickLinkItem) {
                IMQuickLinkItem it = iMQuickLinkItem;
                return it.getTitle();
            }

            public IMQuickLinkItem set(IMQuickLinkItem iMQuickLinkItem, String str) {
                String title = str;
                IMQuickLinkItem it = iMQuickLinkItem;
                return IMQuickLinkItem.copy$default(it, title, null, null, null, null, null, 62, null);
            }

            public IMQuickLinkItem modify(IMQuickLinkItem iMQuickLinkItem, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMQuickLinkItem it = iMQuickLinkItem;
                String title = (String) function1.invoke(it.getTitle());
                IMQuickLinkItem it2 = iMQuickLinkItem;
                return IMQuickLinkItem.copy$default(it2, title, null, null, null, null, null, 62, null);
            }
        };
    }

    public static final BSimpleLens<IMQuickLinkItem, String> getUrl(IMQuickLinkItem.Companion $this$url) {
        Intrinsics.checkNotNullParameter($this$url, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMQuickLinkItem, String>() { // from class: im.session.model.IMQuickLinkItemLensKt$special$$inlined$invoke$3
            public String get(IMQuickLinkItem iMQuickLinkItem) {
                IMQuickLinkItem it = iMQuickLinkItem;
                return it.getUrl();
            }

            public IMQuickLinkItem set(IMQuickLinkItem iMQuickLinkItem, String str) {
                String url = str;
                IMQuickLinkItem it = iMQuickLinkItem;
                return IMQuickLinkItem.copy$default(it, null, url, null, null, null, null, 61, null);
            }

            public IMQuickLinkItem modify(IMQuickLinkItem iMQuickLinkItem, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMQuickLinkItem it = iMQuickLinkItem;
                String url = (String) function1.invoke(it.getUrl());
                IMQuickLinkItem it2 = iMQuickLinkItem;
                return IMQuickLinkItem.copy$default(it2, null, url, null, null, null, null, 61, null);
            }
        };
    }

    public static final BSimpleLens<IMQuickLinkItem, String> getIcon(IMQuickLinkItem.Companion $this$icon) {
        Intrinsics.checkNotNullParameter($this$icon, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMQuickLinkItem, String>() { // from class: im.session.model.IMQuickLinkItemLensKt$special$$inlined$invoke$4
            public String get(IMQuickLinkItem iMQuickLinkItem) {
                IMQuickLinkItem it = iMQuickLinkItem;
                return it.getIcon();
            }

            public IMQuickLinkItem set(IMQuickLinkItem iMQuickLinkItem, String str) {
                String icon = str;
                IMQuickLinkItem it = iMQuickLinkItem;
                return IMQuickLinkItem.copy$default(it, null, null, icon, null, null, null, 59, null);
            }

            public IMQuickLinkItem modify(IMQuickLinkItem iMQuickLinkItem, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMQuickLinkItem it = iMQuickLinkItem;
                String icon = (String) function1.invoke(it.getIcon());
                IMQuickLinkItem it2 = iMQuickLinkItem;
                return IMQuickLinkItem.copy$default(it2, null, null, icon, null, null, null, 59, null);
            }
        };
    }

    public static final BSimpleLens<IMQuickLinkItem, String> getIconForNight(IMQuickLinkItem.Companion $this$iconForNight) {
        Intrinsics.checkNotNullParameter($this$iconForNight, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMQuickLinkItem, String>() { // from class: im.session.model.IMQuickLinkItemLensKt$special$$inlined$invoke$5
            public String get(IMQuickLinkItem iMQuickLinkItem) {
                IMQuickLinkItem it = iMQuickLinkItem;
                return it.getIconForNight();
            }

            public IMQuickLinkItem set(IMQuickLinkItem iMQuickLinkItem, String str) {
                String iconForNight = str;
                IMQuickLinkItem it = iMQuickLinkItem;
                return IMQuickLinkItem.copy$default(it, null, null, null, iconForNight, null, null, 55, null);
            }

            public IMQuickLinkItem modify(IMQuickLinkItem iMQuickLinkItem, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMQuickLinkItem it = iMQuickLinkItem;
                String iconForNight = (String) function1.invoke(it.getIconForNight());
                IMQuickLinkItem it2 = iMQuickLinkItem;
                return IMQuickLinkItem.copy$default(it2, null, null, null, iconForNight, null, null, 55, null);
            }
        };
    }

    public static final BSimpleLens<IMQuickLinkItem, KUnread> getUnread(IMQuickLinkItem.Companion $this$unread) {
        Intrinsics.checkNotNullParameter($this$unread, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMQuickLinkItem, KUnread>() { // from class: im.session.model.IMQuickLinkItemLensKt$special$$inlined$invoke$6
            public KUnread get(IMQuickLinkItem iMQuickLinkItem) {
                IMQuickLinkItem it = iMQuickLinkItem;
                return it.getUnread();
            }

            public IMQuickLinkItem set(IMQuickLinkItem iMQuickLinkItem, KUnread kUnread) {
                KUnread unread = kUnread;
                IMQuickLinkItem it = iMQuickLinkItem;
                return IMQuickLinkItem.copy$default(it, null, null, null, null, unread, null, 47, null);
            }

            public IMQuickLinkItem modify(IMQuickLinkItem iMQuickLinkItem, Function1<? super KUnread, ? extends KUnread> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMQuickLinkItem it = iMQuickLinkItem;
                KUnread unread = (KUnread) function1.invoke(it.getUnread());
                IMQuickLinkItem it2 = iMQuickLinkItem;
                return IMQuickLinkItem.copy$default(it2, null, null, null, null, unread, null, 47, null);
            }
        };
    }

    public static final BSimpleLens<IMQuickLinkItem, KQuickLinkItemType> getType(IMQuickLinkItem.Companion $this$type) {
        Intrinsics.checkNotNullParameter($this$type, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMQuickLinkItem, KQuickLinkItemType>() { // from class: im.session.model.IMQuickLinkItemLensKt$special$$inlined$invoke$7
            public KQuickLinkItemType get(IMQuickLinkItem iMQuickLinkItem) {
                IMQuickLinkItem it = iMQuickLinkItem;
                return it.getType();
            }

            public IMQuickLinkItem set(IMQuickLinkItem iMQuickLinkItem, KQuickLinkItemType kQuickLinkItemType) {
                KQuickLinkItemType type = kQuickLinkItemType;
                IMQuickLinkItem it = iMQuickLinkItem;
                return IMQuickLinkItem.copy$default(it, null, null, null, null, null, type, 31, null);
            }

            public IMQuickLinkItem modify(IMQuickLinkItem iMQuickLinkItem, Function1<? super KQuickLinkItemType, ? extends KQuickLinkItemType> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMQuickLinkItem it = iMQuickLinkItem;
                KQuickLinkItemType type = (KQuickLinkItemType) function1.invoke(it.getType());
                IMQuickLinkItem it2 = iMQuickLinkItem;
                return IMQuickLinkItem.copy$default(it2, null, null, null, null, null, type, 31, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getTitle(BSimpleLens<T, IMQuickLinkItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTitle(IMQuickLinkItem.Companion));
    }

    public static final <T> BSimpleLens<T, String> getUrl(BSimpleLens<T, IMQuickLinkItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getUrl(IMQuickLinkItem.Companion));
    }

    public static final <T> BSimpleLens<T, String> getIcon(BSimpleLens<T, IMQuickLinkItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getIcon(IMQuickLinkItem.Companion));
    }

    public static final <T> BSimpleLens<T, String> getIconForNight(BSimpleLens<T, IMQuickLinkItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getIconForNight(IMQuickLinkItem.Companion));
    }

    public static final <T> BSimpleLens<T, KUnread> getUnread(BSimpleLens<T, IMQuickLinkItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getUnread(IMQuickLinkItem.Companion));
    }

    public static final <T> BSimpleLens<T, KQuickLinkItemType> getType(BSimpleLens<T, IMQuickLinkItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getType(IMQuickLinkItem.Companion));
    }

    public static final <T> BNullableLens<T, String> titleNullable(BSimpleLens<T, IMQuickLinkItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTitle(IMQuickLinkItem.Companion));
    }

    public static final <T> BNullableLens<T, String> urlNullable(BSimpleLens<T, IMQuickLinkItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getUrl(IMQuickLinkItem.Companion));
    }

    public static final <T> BNullableLens<T, String> iconNullable(BSimpleLens<T, IMQuickLinkItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getIcon(IMQuickLinkItem.Companion));
    }

    public static final <T> BNullableLens<T, String> iconForNightNullable(BSimpleLens<T, IMQuickLinkItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getIconForNight(IMQuickLinkItem.Companion));
    }

    public static final <T> BSimpleLens<T, KUnread> unreadNullable(BSimpleLens<T, IMQuickLinkItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getUnread(IMQuickLinkItem.Companion));
    }

    public static final <T> BNullableLens<T, KQuickLinkItemType> typeNullable(BSimpleLens<T, IMQuickLinkItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getType(IMQuickLinkItem.Companion));
    }

    public static final <T> BNullableLens<T, String> getTitle(BNullableLens<T, IMQuickLinkItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTitle(IMQuickLinkItem.Companion));
    }

    public static final <T> BNullableLens<T, String> getUrl(BNullableLens<T, IMQuickLinkItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getUrl(IMQuickLinkItem.Companion));
    }

    public static final <T> BNullableLens<T, String> getIcon(BNullableLens<T, IMQuickLinkItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getIcon(IMQuickLinkItem.Companion));
    }

    public static final <T> BNullableLens<T, String> getIconForNight(BNullableLens<T, IMQuickLinkItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getIconForNight(IMQuickLinkItem.Companion));
    }

    public static final <T> BSimpleLens<T, KUnread> getUnread(BNullableLens<T, IMQuickLinkItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getUnread(IMQuickLinkItem.Companion));
    }

    public static final <T> BNullableLens<T, KQuickLinkItemType> getType(BNullableLens<T, IMQuickLinkItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getType(IMQuickLinkItem.Companion));
    }
}