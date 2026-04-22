package kntr.app.im.chat.core.model;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.im.chat.core.RequestStatus;
import kntr.app.im.chat.core.model.PageStatus;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PageStatusLens.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"*\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0018\u001a\u0004\b\u000b\u0010\u0019\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u000f\u0010\u0019\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0012\u0010\u0019\"@\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0015\u0010\u0019\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\t0\u001a\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u0010\u0012\u0004\u0012\u0002H\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001d\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u001a\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u0010\u0012\u0004\u0012\u0002H\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001d\"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u001a\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u0010\u0012\u0004\u0012\u0002H\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001d\"B\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u001a\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u0010\u0012\u0004\u0012\u0002H\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u001d\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\t0\u001a\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u001a8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010$\u001a\u0004\b\u000b\u0010%\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u001a\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u001a8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010$\u001a\u0004\b\u000f\u0010%\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u001a\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u001a8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010$\u001a\u0004\b\u0012\u0010%\"@\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\r0\u001a\"\b\b\u0000\u0010\u0016*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00020\u001a8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010$\u001a\u0004\b\u0015\u0010%¨\u0006&"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/im/chat/core/model/PageStatus;", "Lkntr/app/im/chat/core/model/PageStatus$Companion;", "getLens$annotations", "(Lkntr/app/im/chat/core/model/PageStatus$Companion;)V", "getLens", "(Lkntr/app/im/chat/core/model/PageStatus$Companion;)Lcom/bilibili/blens/BSimpleLens;", "initialized", RoomRecommendViewModel.EMPTY_CURSOR, "getInitialized$annotations", "getInitialized", "chatInfo", "Lkntr/app/im/chat/core/RequestStatus;", "getChatInfo$annotations", "getChatInfo", "earlierMessages", "getEarlierMessages$annotations", "getEarlierMessages", "laterMessages", "getLaterMessages$annotations", "getLaterMessages", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "initializedNullable$annotations", "initializedNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "chatInfoNullable$annotations", "chatInfoNullable", "earlierMessagesNullable$annotations", "earlierMessagesNullable", "laterMessagesNullable$annotations", "laterMessagesNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PageStatusLensKt {
    public static /* synthetic */ void chatInfoNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void earlierMessagesNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getChatInfo$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getChatInfo$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getChatInfo$annotations(PageStatus.Companion companion) {
    }

    public static /* synthetic */ void getEarlierMessages$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getEarlierMessages$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getEarlierMessages$annotations(PageStatus.Companion companion) {
    }

    public static /* synthetic */ void getInitialized$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getInitialized$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getInitialized$annotations(PageStatus.Companion companion) {
    }

    public static /* synthetic */ void getLaterMessages$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getLaterMessages$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getLaterMessages$annotations(PageStatus.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(PageStatus.Companion companion) {
    }

    public static /* synthetic */ void initializedNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void laterMessagesNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<PageStatus, PageStatus> getLens(PageStatus.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<PageStatus, PageStatus>() { // from class: kntr.app.im.chat.core.model.PageStatusLensKt$special$$inlined$invoke$1
            public PageStatus get(PageStatus pageStatus) {
                PageStatus it = pageStatus;
                return it;
            }

            public PageStatus set(PageStatus pageStatus, PageStatus pageStatus2) {
                PageStatus it = pageStatus2;
                return it;
            }

            public PageStatus modify(PageStatus pageStatus, Function1<? super PageStatus, ? extends PageStatus> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                PageStatus it = pageStatus;
                return (PageStatus) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<PageStatus, Boolean> getInitialized(PageStatus.Companion $this$initialized) {
        Intrinsics.checkNotNullParameter($this$initialized, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<PageStatus, Boolean>() { // from class: kntr.app.im.chat.core.model.PageStatusLensKt$special$$inlined$invoke$2
            public Boolean get(PageStatus pageStatus) {
                PageStatus it = pageStatus;
                return Boolean.valueOf(it.getInitialized());
            }

            public PageStatus set(PageStatus pageStatus, Boolean bool) {
                boolean initialized = bool.booleanValue();
                PageStatus it = pageStatus;
                return PageStatus.copy$default(it, initialized, null, null, null, 14, null);
            }

            public PageStatus modify(PageStatus pageStatus, Function1<? super Boolean, ? extends Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                PageStatus it = pageStatus;
                boolean initialized = ((Boolean) function1.invoke(Boolean.valueOf(it.getInitialized()))).booleanValue();
                PageStatus it2 = pageStatus;
                return PageStatus.copy$default(it2, initialized, null, null, null, 14, null);
            }
        };
    }

    public static final BSimpleLens<PageStatus, RequestStatus> getChatInfo(PageStatus.Companion $this$chatInfo) {
        Intrinsics.checkNotNullParameter($this$chatInfo, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<PageStatus, RequestStatus>() { // from class: kntr.app.im.chat.core.model.PageStatusLensKt$special$$inlined$invoke$3
            public RequestStatus get(PageStatus pageStatus) {
                PageStatus it = pageStatus;
                return it.getChatInfo();
            }

            public PageStatus set(PageStatus pageStatus, RequestStatus requestStatus) {
                RequestStatus chatInfo = requestStatus;
                PageStatus it = pageStatus;
                return PageStatus.copy$default(it, false, chatInfo, null, null, 13, null);
            }

            public PageStatus modify(PageStatus pageStatus, Function1<? super RequestStatus, ? extends RequestStatus> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                PageStatus it = pageStatus;
                RequestStatus chatInfo = (RequestStatus) function1.invoke(it.getChatInfo());
                PageStatus it2 = pageStatus;
                return PageStatus.copy$default(it2, false, chatInfo, null, null, 13, null);
            }
        };
    }

    public static final BSimpleLens<PageStatus, RequestStatus> getEarlierMessages(PageStatus.Companion $this$earlierMessages) {
        Intrinsics.checkNotNullParameter($this$earlierMessages, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<PageStatus, RequestStatus>() { // from class: kntr.app.im.chat.core.model.PageStatusLensKt$special$$inlined$invoke$4
            public RequestStatus get(PageStatus pageStatus) {
                PageStatus it = pageStatus;
                return it.getEarlierMessages();
            }

            public PageStatus set(PageStatus pageStatus, RequestStatus requestStatus) {
                RequestStatus earlierMessages = requestStatus;
                PageStatus it = pageStatus;
                return PageStatus.copy$default(it, false, null, earlierMessages, null, 11, null);
            }

            public PageStatus modify(PageStatus pageStatus, Function1<? super RequestStatus, ? extends RequestStatus> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                PageStatus it = pageStatus;
                RequestStatus earlierMessages = (RequestStatus) function1.invoke(it.getEarlierMessages());
                PageStatus it2 = pageStatus;
                return PageStatus.copy$default(it2, false, null, earlierMessages, null, 11, null);
            }
        };
    }

    public static final BSimpleLens<PageStatus, RequestStatus> getLaterMessages(PageStatus.Companion $this$laterMessages) {
        Intrinsics.checkNotNullParameter($this$laterMessages, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<PageStatus, RequestStatus>() { // from class: kntr.app.im.chat.core.model.PageStatusLensKt$special$$inlined$invoke$5
            public RequestStatus get(PageStatus pageStatus) {
                PageStatus it = pageStatus;
                return it.getLaterMessages();
            }

            public PageStatus set(PageStatus pageStatus, RequestStatus requestStatus) {
                RequestStatus laterMessages = requestStatus;
                PageStatus it = pageStatus;
                return PageStatus.copy$default(it, false, null, null, laterMessages, 7, null);
            }

            public PageStatus modify(PageStatus pageStatus, Function1<? super RequestStatus, ? extends RequestStatus> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                PageStatus it = pageStatus;
                RequestStatus laterMessages = (RequestStatus) function1.invoke(it.getLaterMessages());
                PageStatus it2 = pageStatus;
                return PageStatus.copy$default(it2, false, null, null, laterMessages, 7, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, Boolean> getInitialized(BSimpleLens<T, PageStatus> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getInitialized(PageStatus.Companion));
    }

    public static final <T> BSimpleLens<T, RequestStatus> getChatInfo(BSimpleLens<T, PageStatus> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getChatInfo(PageStatus.Companion));
    }

    public static final <T> BSimpleLens<T, RequestStatus> getEarlierMessages(BSimpleLens<T, PageStatus> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getEarlierMessages(PageStatus.Companion));
    }

    public static final <T> BSimpleLens<T, RequestStatus> getLaterMessages(BSimpleLens<T, PageStatus> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getLaterMessages(PageStatus.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> initializedNullable(BSimpleLens<T, PageStatus> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getInitialized(PageStatus.Companion));
    }

    public static final <T> BNullableLens<T, RequestStatus> chatInfoNullable(BSimpleLens<T, PageStatus> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getChatInfo(PageStatus.Companion));
    }

    public static final <T> BNullableLens<T, RequestStatus> earlierMessagesNullable(BSimpleLens<T, PageStatus> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getEarlierMessages(PageStatus.Companion));
    }

    public static final <T> BNullableLens<T, RequestStatus> laterMessagesNullable(BSimpleLens<T, PageStatus> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getLaterMessages(PageStatus.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getInitialized(BNullableLens<T, PageStatus> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getInitialized(PageStatus.Companion));
    }

    public static final <T> BNullableLens<T, RequestStatus> getChatInfo(BNullableLens<T, PageStatus> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getChatInfo(PageStatus.Companion));
    }

    public static final <T> BNullableLens<T, RequestStatus> getEarlierMessages(BNullableLens<T, PageStatus> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getEarlierMessages(PageStatus.Companion));
    }

    public static final <T> BNullableLens<T, RequestStatus> getLaterMessages(BNullableLens<T, PageStatus> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getLaterMessages(PageStatus.Companion));
    }
}