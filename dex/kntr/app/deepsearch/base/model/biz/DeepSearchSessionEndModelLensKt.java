package kntr.app.deepsearch.base.model.biz;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchSessionEndModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchSessionEndModelLens.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"*\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"*\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001b\u001a\u0004\b\u000b\u0010\u001c\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u001b\u001a\u0004\b\u000e\u0010\u001c\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u0011\u0010\u001c\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00130\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u001b\u001a\u0004\b\u0015\u0010\u001c\"@\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u0018\u0010\u001c\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010 \"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010 \"B\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010 \"B\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00130\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010 \"B\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010 \"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010)\u001a\u0004\b\u000b\u0010*\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010)\u001a\u0004\b\u000e\u0010*\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010)\u001a\u0004\b\u0011\u0010*\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00130\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010)\u001a\u0004\b\u0015\u0010*\"@\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010)\u001a\u0004\b\u0018\u0010*¨\u0006+"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel$Companion;", "getLens$annotations", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel$Companion;)V", "getLens", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel$Companion;)Lcom/bilibili/blens/BSimpleLens;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "getSessionId$annotations", "getSessionId", "query", "getQuery$annotations", "getQuery", "queryId", "getQueryId$annotations", "getQueryId", "timestamp", RoomRecommendViewModel.EMPTY_CURSOR, "getTimestamp$annotations", "getTimestamp", "timeString", "getTimeString$annotations", "getTimeString", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "sessionIdNullable$annotations", "sessionIdNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "queryNullable$annotations", "queryNullable", "queryIdNullable$annotations", "queryIdNullable", "timestampNullable$annotations", "timestampNullable", "timeStringNullable$annotations", "timeStringNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchSessionEndModelLensKt {
    public static /* synthetic */ void getLens$annotations(DeepSearchSessionEndModel.Companion companion) {
    }

    public static /* synthetic */ void getQuery$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getQuery$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getQuery$annotations(DeepSearchSessionEndModel.Companion companion) {
    }

    public static /* synthetic */ void getQueryId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getQueryId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getQueryId$annotations(DeepSearchSessionEndModel.Companion companion) {
    }

    public static /* synthetic */ void getSessionId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSessionId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSessionId$annotations(DeepSearchSessionEndModel.Companion companion) {
    }

    public static /* synthetic */ void getTimeString$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTimeString$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTimeString$annotations(DeepSearchSessionEndModel.Companion companion) {
    }

    public static /* synthetic */ void getTimestamp$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTimestamp$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTimestamp$annotations(DeepSearchSessionEndModel.Companion companion) {
    }

    public static /* synthetic */ void queryIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void queryNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sessionIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void timeStringNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void timestampNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<DeepSearchSessionEndModel, DeepSearchSessionEndModel> getLens(DeepSearchSessionEndModel.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchSessionEndModel, DeepSearchSessionEndModel>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchSessionEndModelLensKt$special$$inlined$invoke$1
            public DeepSearchSessionEndModel get(DeepSearchSessionEndModel deepSearchSessionEndModel) {
                DeepSearchSessionEndModel it = deepSearchSessionEndModel;
                return it;
            }

            public DeepSearchSessionEndModel set(DeepSearchSessionEndModel deepSearchSessionEndModel, DeepSearchSessionEndModel deepSearchSessionEndModel2) {
                DeepSearchSessionEndModel it = deepSearchSessionEndModel2;
                return it;
            }

            public DeepSearchSessionEndModel modify(DeepSearchSessionEndModel deepSearchSessionEndModel, Function1<? super DeepSearchSessionEndModel, ? extends DeepSearchSessionEndModel> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchSessionEndModel it = deepSearchSessionEndModel;
                return (DeepSearchSessionEndModel) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<DeepSearchSessionEndModel, String> getSessionId(DeepSearchSessionEndModel.Companion $this$sessionId) {
        Intrinsics.checkNotNullParameter($this$sessionId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchSessionEndModel, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchSessionEndModelLensKt$special$$inlined$invoke$2
            public String get(DeepSearchSessionEndModel deepSearchSessionEndModel) {
                DeepSearchSessionEndModel it = deepSearchSessionEndModel;
                return it.getSessionId();
            }

            public DeepSearchSessionEndModel set(DeepSearchSessionEndModel deepSearchSessionEndModel, String str) {
                String sessionId = str;
                DeepSearchSessionEndModel it = deepSearchSessionEndModel;
                return DeepSearchSessionEndModel.copy$default(it, sessionId, null, null, 0L, null, 30, null);
            }

            public DeepSearchSessionEndModel modify(DeepSearchSessionEndModel deepSearchSessionEndModel, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchSessionEndModel it = deepSearchSessionEndModel;
                String sessionId = (String) function1.invoke(it.getSessionId());
                DeepSearchSessionEndModel it2 = deepSearchSessionEndModel;
                return DeepSearchSessionEndModel.copy$default(it2, sessionId, null, null, 0L, null, 30, null);
            }
        };
    }

    public static final BSimpleLens<DeepSearchSessionEndModel, String> getQuery(DeepSearchSessionEndModel.Companion $this$query) {
        Intrinsics.checkNotNullParameter($this$query, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchSessionEndModel, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchSessionEndModelLensKt$special$$inlined$invoke$3
            public String get(DeepSearchSessionEndModel deepSearchSessionEndModel) {
                DeepSearchSessionEndModel it = deepSearchSessionEndModel;
                return it.getQuery();
            }

            public DeepSearchSessionEndModel set(DeepSearchSessionEndModel deepSearchSessionEndModel, String str) {
                String query = str;
                DeepSearchSessionEndModel it = deepSearchSessionEndModel;
                return DeepSearchSessionEndModel.copy$default(it, null, query, null, 0L, null, 29, null);
            }

            public DeepSearchSessionEndModel modify(DeepSearchSessionEndModel deepSearchSessionEndModel, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchSessionEndModel it = deepSearchSessionEndModel;
                String query = (String) function1.invoke(it.getQuery());
                DeepSearchSessionEndModel it2 = deepSearchSessionEndModel;
                return DeepSearchSessionEndModel.copy$default(it2, null, query, null, 0L, null, 29, null);
            }
        };
    }

    public static final BSimpleLens<DeepSearchSessionEndModel, String> getQueryId(DeepSearchSessionEndModel.Companion $this$queryId) {
        Intrinsics.checkNotNullParameter($this$queryId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchSessionEndModel, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchSessionEndModelLensKt$special$$inlined$invoke$4
            public String get(DeepSearchSessionEndModel deepSearchSessionEndModel) {
                DeepSearchSessionEndModel it = deepSearchSessionEndModel;
                return it.getQueryId();
            }

            public DeepSearchSessionEndModel set(DeepSearchSessionEndModel deepSearchSessionEndModel, String str) {
                String queryId = str;
                DeepSearchSessionEndModel it = deepSearchSessionEndModel;
                return DeepSearchSessionEndModel.copy$default(it, null, null, queryId, 0L, null, 27, null);
            }

            public DeepSearchSessionEndModel modify(DeepSearchSessionEndModel deepSearchSessionEndModel, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchSessionEndModel it = deepSearchSessionEndModel;
                String queryId = (String) function1.invoke(it.getQueryId());
                DeepSearchSessionEndModel it2 = deepSearchSessionEndModel;
                return DeepSearchSessionEndModel.copy$default(it2, null, null, queryId, 0L, null, 27, null);
            }
        };
    }

    public static final BSimpleLens<DeepSearchSessionEndModel, Long> getTimestamp(DeepSearchSessionEndModel.Companion $this$timestamp) {
        Intrinsics.checkNotNullParameter($this$timestamp, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchSessionEndModel, Long>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchSessionEndModelLensKt$special$$inlined$invoke$5
            public Long get(DeepSearchSessionEndModel deepSearchSessionEndModel) {
                DeepSearchSessionEndModel it = deepSearchSessionEndModel;
                return Long.valueOf(it.getTimestamp());
            }

            public DeepSearchSessionEndModel set(DeepSearchSessionEndModel deepSearchSessionEndModel, Long l) {
                long timestamp = l.longValue();
                DeepSearchSessionEndModel it = deepSearchSessionEndModel;
                return DeepSearchSessionEndModel.copy$default(it, null, null, null, timestamp, null, 23, null);
            }

            public DeepSearchSessionEndModel modify(DeepSearchSessionEndModel deepSearchSessionEndModel, Function1<? super Long, ? extends Long> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchSessionEndModel it = deepSearchSessionEndModel;
                long timestamp = ((Number) function1.invoke(Long.valueOf(it.getTimestamp()))).longValue();
                DeepSearchSessionEndModel it2 = deepSearchSessionEndModel;
                return DeepSearchSessionEndModel.copy$default(it2, null, null, null, timestamp, null, 23, null);
            }
        };
    }

    public static final BSimpleLens<DeepSearchSessionEndModel, String> getTimeString(DeepSearchSessionEndModel.Companion $this$timeString) {
        Intrinsics.checkNotNullParameter($this$timeString, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DeepSearchSessionEndModel, String>() { // from class: kntr.app.deepsearch.base.model.biz.DeepSearchSessionEndModelLensKt$special$$inlined$invoke$6
            public String get(DeepSearchSessionEndModel deepSearchSessionEndModel) {
                DeepSearchSessionEndModel it = deepSearchSessionEndModel;
                return it.getTimeString();
            }

            public DeepSearchSessionEndModel set(DeepSearchSessionEndModel deepSearchSessionEndModel, String str) {
                String timeString = str;
                DeepSearchSessionEndModel it = deepSearchSessionEndModel;
                return DeepSearchSessionEndModel.copy$default(it, null, null, null, 0L, timeString, 15, null);
            }

            public DeepSearchSessionEndModel modify(DeepSearchSessionEndModel deepSearchSessionEndModel, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DeepSearchSessionEndModel it = deepSearchSessionEndModel;
                String timeString = (String) function1.invoke(it.getTimeString());
                DeepSearchSessionEndModel it2 = deepSearchSessionEndModel;
                return DeepSearchSessionEndModel.copy$default(it2, null, null, null, 0L, timeString, 15, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getSessionId(BSimpleLens<T, DeepSearchSessionEndModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSessionId(DeepSearchSessionEndModel.Companion));
    }

    public static final <T> BSimpleLens<T, String> getQuery(BSimpleLens<T, DeepSearchSessionEndModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getQuery(DeepSearchSessionEndModel.Companion));
    }

    public static final <T> BSimpleLens<T, String> getQueryId(BSimpleLens<T, DeepSearchSessionEndModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getQueryId(DeepSearchSessionEndModel.Companion));
    }

    public static final <T> BSimpleLens<T, Long> getTimestamp(BSimpleLens<T, DeepSearchSessionEndModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTimestamp(DeepSearchSessionEndModel.Companion));
    }

    public static final <T> BSimpleLens<T, String> getTimeString(BSimpleLens<T, DeepSearchSessionEndModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTimeString(DeepSearchSessionEndModel.Companion));
    }

    public static final <T> BNullableLens<T, String> sessionIdNullable(BSimpleLens<T, DeepSearchSessionEndModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSessionId(DeepSearchSessionEndModel.Companion));
    }

    public static final <T> BNullableLens<T, String> queryNullable(BSimpleLens<T, DeepSearchSessionEndModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getQuery(DeepSearchSessionEndModel.Companion));
    }

    public static final <T> BNullableLens<T, String> queryIdNullable(BSimpleLens<T, DeepSearchSessionEndModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getQueryId(DeepSearchSessionEndModel.Companion));
    }

    public static final <T> BNullableLens<T, Long> timestampNullable(BSimpleLens<T, DeepSearchSessionEndModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTimestamp(DeepSearchSessionEndModel.Companion));
    }

    public static final <T> BNullableLens<T, String> timeStringNullable(BSimpleLens<T, DeepSearchSessionEndModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTimeString(DeepSearchSessionEndModel.Companion));
    }

    public static final <T> BNullableLens<T, String> getSessionId(BNullableLens<T, DeepSearchSessionEndModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSessionId(DeepSearchSessionEndModel.Companion));
    }

    public static final <T> BNullableLens<T, String> getQuery(BNullableLens<T, DeepSearchSessionEndModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getQuery(DeepSearchSessionEndModel.Companion));
    }

    public static final <T> BNullableLens<T, String> getQueryId(BNullableLens<T, DeepSearchSessionEndModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getQueryId(DeepSearchSessionEndModel.Companion));
    }

    public static final <T> BNullableLens<T, Long> getTimestamp(BNullableLens<T, DeepSearchSessionEndModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTimestamp(DeepSearchSessionEndModel.Companion));
    }

    public static final <T> BNullableLens<T, String> getTimeString(BNullableLens<T, DeepSearchSessionEndModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTimeString(DeepSearchSessionEndModel.Companion));
    }
}