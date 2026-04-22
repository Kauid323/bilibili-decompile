package kntr.app.deepsearch.base.model.biz;

import com.bapis.bilibili.broadcast.message.deepsearch.KThinking;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchThinkPopContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchThinkPopContentLens.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"*\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"*\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"*\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001f\u001a\u0004\b\u000b\u0010 \"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u001f\u001a\u0004\b\u000e\u0010 \"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00100\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u001f\u001a\u0004\b\u0012\u0010 \"@\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u001f\u001a\u0004\b\u0015\u0010 \"@\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u001f\u001a\u0004\b\u0018\u0010 \"@\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u001a0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u001f\u001a\u0004\b\u001c\u0010 \"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010$\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010$\"B\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00100!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010$\"B\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010$\"B\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010$\"B\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u001a0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010\u001f\u001a\u0004\b.\u0010$\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010/\u001a\u0004\b\u000b\u00100\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010/\u001a\u0004\b\u000e\u00100\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00100!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010/\u001a\u0004\b\u0012\u00100\"@\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010/\u001a\u0004\b\u0015\u00100\"@\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010/\u001a\u0004\b\u0018\u00100\"@\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u001a0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010/\u001a\u0004\b\u001c\u00100¨\u00061"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchThinkPopContent;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchThinkPopContent$Companion;", "getLens$annotations", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchThinkPopContent$Companion;)V", "getLens", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchThinkPopContent$Companion;)Lcom/bilibili/blens/BSimpleLens;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "getSessionId$annotations", "getSessionId", "queryId", "getQueryId$annotations", "getQueryId", "thinkStatus", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KThinking$KStatus;", "getThinkStatus$annotations", "getThinkStatus", "windowTitle", "getWindowTitle$annotations", "getWindowTitle", "content", "getContent$annotations", "getContent", "timestamp", RoomRecommendViewModel.EMPTY_CURSOR, "getTimestamp$annotations", "getTimestamp", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "sessionIdNullable$annotations", "sessionIdNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "queryIdNullable$annotations", "queryIdNullable", "thinkStatusNullable$annotations", "thinkStatusNullable", "windowTitleNullable$annotations", "windowTitleNullable", "contentNullable$annotations", "contentNullable", "timestampNullable$annotations", "timestampNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchThinkPopContentLensKt {
    public static /* synthetic */ void contentNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContent$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getContent$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContent$annotations(DeepSearchThinkPopContent.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(DeepSearchThinkPopContent.Companion companion) {
    }

    public static /* synthetic */ void getQueryId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getQueryId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getQueryId$annotations(DeepSearchThinkPopContent.Companion companion) {
    }

    public static /* synthetic */ void getSessionId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSessionId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSessionId$annotations(DeepSearchThinkPopContent.Companion companion) {
    }

    public static /* synthetic */ void getThinkStatus$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getThinkStatus$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getThinkStatus$annotations(DeepSearchThinkPopContent.Companion companion) {
    }

    public static /* synthetic */ void getTimestamp$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTimestamp$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTimestamp$annotations(DeepSearchThinkPopContent.Companion companion) {
    }

    public static /* synthetic */ void getWindowTitle$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getWindowTitle$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getWindowTitle$annotations(DeepSearchThinkPopContent.Companion companion) {
    }

    public static /* synthetic */ void queryIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sessionIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void thinkStatusNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void timestampNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void windowTitleNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<DeepSearchThinkPopContent, DeepSearchThinkPopContent> getLens(DeepSearchThinkPopContent.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchThinkPopContent, DeepSearchThinkPopContent>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchThinkPopContentLensKt$special$$inlined$invoke$1
            public DeepSearchThinkPopContent get(DeepSearchThinkPopContent deepSearchThinkPopContent) {
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                return it;
            }

            public DeepSearchThinkPopContent set(DeepSearchThinkPopContent deepSearchThinkPopContent, DeepSearchThinkPopContent deepSearchThinkPopContent2) {
                DeepSearchThinkPopContent it = deepSearchThinkPopContent2;
                return it;
            }

            public DeepSearchThinkPopContent modify(DeepSearchThinkPopContent deepSearchThinkPopContent, Function1<? super DeepSearchThinkPopContent, ? extends DeepSearchThinkPopContent> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                return (DeepSearchThinkPopContent) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<DeepSearchThinkPopContent, String> getSessionId(DeepSearchThinkPopContent.Companion $this$sessionId) {
        Intrinsics.checkNotNullParameter($this$sessionId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchThinkPopContent, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchThinkPopContentLensKt$special$$inlined$invoke$2
            public String get(DeepSearchThinkPopContent deepSearchThinkPopContent) {
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                return it.getSessionId();
            }

            public DeepSearchThinkPopContent set(DeepSearchThinkPopContent deepSearchThinkPopContent, String str) {
                String sessionId = str;
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                return DeepSearchThinkPopContent.copy$default(it, sessionId, null, null, null, null, 0L, 62, null);
            }

            public DeepSearchThinkPopContent modify(DeepSearchThinkPopContent deepSearchThinkPopContent, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                String sessionId = (String) function1.invoke(it.getSessionId());
                DeepSearchThinkPopContent it2 = deepSearchThinkPopContent;
                return DeepSearchThinkPopContent.copy$default(it2, sessionId, null, null, null, null, 0L, 62, null);
            }
        };
    }

    public static final BSimpleLens<DeepSearchThinkPopContent, String> getQueryId(DeepSearchThinkPopContent.Companion $this$queryId) {
        Intrinsics.checkNotNullParameter($this$queryId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchThinkPopContent, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchThinkPopContentLensKt$special$$inlined$invoke$3
            public String get(DeepSearchThinkPopContent deepSearchThinkPopContent) {
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                return it.getQueryId();
            }

            public DeepSearchThinkPopContent set(DeepSearchThinkPopContent deepSearchThinkPopContent, String str) {
                String queryId = str;
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                return DeepSearchThinkPopContent.copy$default(it, null, queryId, null, null, null, 0L, 61, null);
            }

            public DeepSearchThinkPopContent modify(DeepSearchThinkPopContent deepSearchThinkPopContent, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                String queryId = (String) function1.invoke(it.getQueryId());
                DeepSearchThinkPopContent it2 = deepSearchThinkPopContent;
                return DeepSearchThinkPopContent.copy$default(it2, null, queryId, null, null, null, 0L, 61, null);
            }
        };
    }

    public static final BSimpleLens<DeepSearchThinkPopContent, KThinking.KStatus> getThinkStatus(DeepSearchThinkPopContent.Companion $this$thinkStatus) {
        Intrinsics.checkNotNullParameter($this$thinkStatus, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchThinkPopContent, KThinking.KStatus>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchThinkPopContentLensKt$special$$inlined$invoke$4
            public KThinking.KStatus get(DeepSearchThinkPopContent deepSearchThinkPopContent) {
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                return it.getThinkStatus();
            }

            public DeepSearchThinkPopContent set(DeepSearchThinkPopContent deepSearchThinkPopContent, KThinking.KStatus kStatus) {
                KThinking.KStatus thinkStatus = kStatus;
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                return DeepSearchThinkPopContent.copy$default(it, null, null, thinkStatus, null, null, 0L, 59, null);
            }

            public DeepSearchThinkPopContent modify(DeepSearchThinkPopContent deepSearchThinkPopContent, Function1<? super KThinking.KStatus, ? extends KThinking.KStatus> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                KThinking.KStatus thinkStatus = (KThinking.KStatus) function1.invoke(it.getThinkStatus());
                DeepSearchThinkPopContent it2 = deepSearchThinkPopContent;
                return DeepSearchThinkPopContent.copy$default(it2, null, null, thinkStatus, null, null, 0L, 59, null);
            }
        };
    }

    public static final BSimpleLens<DeepSearchThinkPopContent, String> getWindowTitle(DeepSearchThinkPopContent.Companion $this$windowTitle) {
        Intrinsics.checkNotNullParameter($this$windowTitle, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchThinkPopContent, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchThinkPopContentLensKt$special$$inlined$invoke$5
            public String get(DeepSearchThinkPopContent deepSearchThinkPopContent) {
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                return it.getWindowTitle();
            }

            public DeepSearchThinkPopContent set(DeepSearchThinkPopContent deepSearchThinkPopContent, String str) {
                String windowTitle = str;
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                return DeepSearchThinkPopContent.copy$default(it, null, null, null, windowTitle, null, 0L, 55, null);
            }

            public DeepSearchThinkPopContent modify(DeepSearchThinkPopContent deepSearchThinkPopContent, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                String windowTitle = (String) function1.invoke(it.getWindowTitle());
                DeepSearchThinkPopContent it2 = deepSearchThinkPopContent;
                return DeepSearchThinkPopContent.copy$default(it2, null, null, null, windowTitle, null, 0L, 55, null);
            }
        };
    }

    public static final BSimpleLens<DeepSearchThinkPopContent, String> getContent(DeepSearchThinkPopContent.Companion $this$content) {
        Intrinsics.checkNotNullParameter($this$content, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchThinkPopContent, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchThinkPopContentLensKt$special$$inlined$invoke$6
            public String get(DeepSearchThinkPopContent deepSearchThinkPopContent) {
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                return it.getContent();
            }

            public DeepSearchThinkPopContent set(DeepSearchThinkPopContent deepSearchThinkPopContent, String str) {
                String content = str;
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                return DeepSearchThinkPopContent.copy$default(it, null, null, null, null, content, 0L, 47, null);
            }

            public DeepSearchThinkPopContent modify(DeepSearchThinkPopContent deepSearchThinkPopContent, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                String content = (String) function1.invoke(it.getContent());
                DeepSearchThinkPopContent it2 = deepSearchThinkPopContent;
                return DeepSearchThinkPopContent.copy$default(it2, null, null, null, null, content, 0L, 47, null);
            }
        };
    }

    public static final BSimpleLens<DeepSearchThinkPopContent, Long> getTimestamp(DeepSearchThinkPopContent.Companion $this$timestamp) {
        Intrinsics.checkNotNullParameter($this$timestamp, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchThinkPopContent, Long>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchThinkPopContentLensKt$special$$inlined$invoke$7
            public Long get(DeepSearchThinkPopContent deepSearchThinkPopContent) {
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                return Long.valueOf(it.getTimestamp());
            }

            public DeepSearchThinkPopContent set(DeepSearchThinkPopContent deepSearchThinkPopContent, Long l) {
                long timestamp = l.longValue();
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                return DeepSearchThinkPopContent.copy$default(it, null, null, null, null, null, timestamp, 31, null);
            }

            public DeepSearchThinkPopContent modify(DeepSearchThinkPopContent deepSearchThinkPopContent, Function1<? super Long, ? extends Long> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchThinkPopContent it = deepSearchThinkPopContent;
                long timestamp = ((Number) function1.invoke(Long.valueOf(it.getTimestamp()))).longValue();
                DeepSearchThinkPopContent it2 = deepSearchThinkPopContent;
                return DeepSearchThinkPopContent.copy$default(it2, null, null, null, null, null, timestamp, 31, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getSessionId(BSimpleLens<T, DeepSearchThinkPopContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSessionId(DeepSearchThinkPopContent.Companion));
    }

    public static final <T> BSimpleLens<T, String> getQueryId(BSimpleLens<T, DeepSearchThinkPopContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getQueryId(DeepSearchThinkPopContent.Companion));
    }

    public static final <T> BSimpleLens<T, KThinking.KStatus> getThinkStatus(BSimpleLens<T, DeepSearchThinkPopContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getThinkStatus(DeepSearchThinkPopContent.Companion));
    }

    public static final <T> BSimpleLens<T, String> getWindowTitle(BSimpleLens<T, DeepSearchThinkPopContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getWindowTitle(DeepSearchThinkPopContent.Companion));
    }

    public static final <T> BSimpleLens<T, String> getContent(BSimpleLens<T, DeepSearchThinkPopContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getContent(DeepSearchThinkPopContent.Companion));
    }

    public static final <T> BSimpleLens<T, Long> getTimestamp(BSimpleLens<T, DeepSearchThinkPopContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTimestamp(DeepSearchThinkPopContent.Companion));
    }

    public static final <T> BNullableLens<T, String> sessionIdNullable(BSimpleLens<T, DeepSearchThinkPopContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSessionId(DeepSearchThinkPopContent.Companion));
    }

    public static final <T> BNullableLens<T, String> queryIdNullable(BSimpleLens<T, DeepSearchThinkPopContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getQueryId(DeepSearchThinkPopContent.Companion));
    }

    public static final <T> BNullableLens<T, KThinking.KStatus> thinkStatusNullable(BSimpleLens<T, DeepSearchThinkPopContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getThinkStatus(DeepSearchThinkPopContent.Companion));
    }

    public static final <T> BNullableLens<T, String> windowTitleNullable(BSimpleLens<T, DeepSearchThinkPopContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getWindowTitle(DeepSearchThinkPopContent.Companion));
    }

    public static final <T> BNullableLens<T, String> contentNullable(BSimpleLens<T, DeepSearchThinkPopContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getContent(DeepSearchThinkPopContent.Companion));
    }

    public static final <T> BNullableLens<T, Long> timestampNullable(BSimpleLens<T, DeepSearchThinkPopContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTimestamp(DeepSearchThinkPopContent.Companion));
    }

    public static final <T> BNullableLens<T, String> getSessionId(BNullableLens<T, DeepSearchThinkPopContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSessionId(DeepSearchThinkPopContent.Companion));
    }

    public static final <T> BNullableLens<T, String> getQueryId(BNullableLens<T, DeepSearchThinkPopContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getQueryId(DeepSearchThinkPopContent.Companion));
    }

    public static final <T> BNullableLens<T, KThinking.KStatus> getThinkStatus(BNullableLens<T, DeepSearchThinkPopContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getThinkStatus(DeepSearchThinkPopContent.Companion));
    }

    public static final <T> BNullableLens<T, String> getWindowTitle(BNullableLens<T, DeepSearchThinkPopContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getWindowTitle(DeepSearchThinkPopContent.Companion));
    }

    public static final <T> BNullableLens<T, String> getContent(BNullableLens<T, DeepSearchThinkPopContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getContent(DeepSearchThinkPopContent.Companion));
    }

    public static final <T> BNullableLens<T, Long> getTimestamp(BNullableLens<T, DeepSearchThinkPopContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTimestamp(DeepSearchThinkPopContent.Companion));
    }
}