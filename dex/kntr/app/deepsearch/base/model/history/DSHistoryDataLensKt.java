package kntr.app.deepsearch.base.model.history;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import java.util.List;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.deepsearch.base.model.history.DSHistoryData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DSHistoryDataLens.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"0\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"0\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"*\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\"*\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\"\u001a\u0004\b\u000b\u0010#\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\"\u001a\u0004\b\u000f\u0010#\"F\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u0002H \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0001\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\"\u001a\u0004\b\u0014\u0010#\"F\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u0002H \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00110\u0001\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\"\u001a\u0004\b\u0018\u0010#\"@\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\"\u001a\u0004\b\u001b\u0010#\"@\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u001d0\u0001\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\"\u001a\u0004\b\u001f\u0010#\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\t0$\"\b\b\u0000\u0010 *\u00020!*\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\"\u001a\u0004\b&\u0010'\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\r0$\"\b\b\u0000\u0010 *\u00020!*\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\"\u001a\u0004\b)\u0010'\"H\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u0002H \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110$\"\b\b\u0000\u0010 *\u00020!*\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010\"\u001a\u0004\b+\u0010'\"H\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u0002H \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00110$\"\b\b\u0000\u0010 *\u00020!*\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010\"\u001a\u0004\b-\u0010'\"B\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\t0$\"\b\b\u0000\u0010 *\u00020!*\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\"\u001a\u0004\b/\u0010'\"B\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u001d0$\"\b\b\u0000\u0010 *\u00020!*\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\"\u001a\u0004\b1\u0010'\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\t0$\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020$8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u00102\u001a\u0004\b\u000b\u00103\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\r0$\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020$8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u00102\u001a\u0004\b\u000f\u00103\"F\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u0002H \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110$\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020$8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u00102\u001a\u0004\b\u0014\u00103\"F\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u0002H \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00110$\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020$8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u00102\u001a\u0004\b\u0018\u00103\"@\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\t0$\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020$8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u00102\u001a\u0004\b\u001b\u00103\"@\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u001d0$\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020$8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u00102\u001a\u0004\b\u001f\u00103¨\u00064"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/deepsearch/base/model/history/DSHistoryData;", "Lkntr/app/deepsearch/base/model/history/DSHistoryData$Companion;", "getLens$annotations", "(Lkntr/app/deepsearch/base/model/history/DSHistoryData$Companion;)V", "getLens", "(Lkntr/app/deepsearch/base/model/history/DSHistoryData$Companion;)Lcom/bilibili/blens/BSimpleLens;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "getSessionId$annotations", "getSessionId", AdAlarmExtraKey.STATUS, "Lkntr/app/deepsearch/base/model/history/DSHistoryPageStatus;", "getStatus$annotations", "getStatus", "list", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/deepsearch/base/model/history/DSConversationItem;", "getList$annotations", "getList", "groups", "Lkntr/app/deepsearch/base/model/history/DSConversationSection;", "getGroups$annotations", "getGroups", "cursor", "getCursor$annotations", "getCursor", "loadActionType", "Lkntr/app/deepsearch/base/model/history/LoadActionType;", "getLoadActionType$annotations", "getLoadActionType", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "sessionIdNullable$annotations", "sessionIdNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "statusNullable$annotations", "statusNullable", "listNullable$annotations", "listNullable", "groupsNullable$annotations", "groupsNullable", "cursorNullable$annotations", "cursorNullable", "loadActionTypeNullable$annotations", "loadActionTypeNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DSHistoryDataLensKt {
    public static /* synthetic */ void cursorNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCursor$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCursor$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCursor$annotations(DSHistoryData.Companion companion) {
    }

    public static /* synthetic */ void getGroups$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getGroups$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getGroups$annotations(DSHistoryData.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(DSHistoryData.Companion companion) {
    }

    public static /* synthetic */ void getList$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getList$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getList$annotations(DSHistoryData.Companion companion) {
    }

    public static /* synthetic */ void getLoadActionType$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getLoadActionType$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getLoadActionType$annotations(DSHistoryData.Companion companion) {
    }

    public static /* synthetic */ void getSessionId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSessionId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSessionId$annotations(DSHistoryData.Companion companion) {
    }

    public static /* synthetic */ void getStatus$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getStatus$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getStatus$annotations(DSHistoryData.Companion companion) {
    }

    public static /* synthetic */ void groupsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void listNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void loadActionTypeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sessionIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void statusNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<DSHistoryData, DSHistoryData> getLens(DSHistoryData.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DSHistoryData, DSHistoryData>() { // from class: kntr.app.deepsearch.base.model.history.DSHistoryDataLensKt$special$$inlined$invoke$1
            public DSHistoryData get(DSHistoryData dSHistoryData) {
                DSHistoryData it = dSHistoryData;
                return it;
            }

            public DSHistoryData set(DSHistoryData dSHistoryData, DSHistoryData dSHistoryData2) {
                DSHistoryData it = dSHistoryData2;
                return it;
            }

            public DSHistoryData modify(DSHistoryData dSHistoryData, Function1<? super DSHistoryData, ? extends DSHistoryData> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DSHistoryData it = dSHistoryData;
                return (DSHistoryData) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<DSHistoryData, String> getSessionId(DSHistoryData.Companion $this$sessionId) {
        Intrinsics.checkNotNullParameter($this$sessionId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DSHistoryData, String>() { // from class: kntr.app.deepsearch.base.model.history.DSHistoryDataLensKt$special$$inlined$invoke$2
            public String get(DSHistoryData dSHistoryData) {
                DSHistoryData it = dSHistoryData;
                return it.getSessionId();
            }

            public DSHistoryData set(DSHistoryData dSHistoryData, String str) {
                String sessionId = str;
                DSHistoryData it = dSHistoryData;
                return DSHistoryData.copy$default(it, sessionId, null, null, null, null, null, 62, null);
            }

            public DSHistoryData modify(DSHistoryData dSHistoryData, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DSHistoryData it = dSHistoryData;
                String sessionId = (String) function1.invoke(it.getSessionId());
                DSHistoryData it2 = dSHistoryData;
                return DSHistoryData.copy$default(it2, sessionId, null, null, null, null, null, 62, null);
            }
        };
    }

    public static final BSimpleLens<DSHistoryData, DSHistoryPageStatus> getStatus(DSHistoryData.Companion $this$status) {
        Intrinsics.checkNotNullParameter($this$status, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DSHistoryData, DSHistoryPageStatus>() { // from class: kntr.app.deepsearch.base.model.history.DSHistoryDataLensKt$special$$inlined$invoke$3
            public DSHistoryPageStatus get(DSHistoryData dSHistoryData) {
                DSHistoryData it = dSHistoryData;
                return it.getStatus();
            }

            public DSHistoryData set(DSHistoryData dSHistoryData, DSHistoryPageStatus dSHistoryPageStatus) {
                DSHistoryPageStatus status = dSHistoryPageStatus;
                DSHistoryData it = dSHistoryData;
                return DSHistoryData.copy$default(it, null, status, null, null, null, null, 61, null);
            }

            public DSHistoryData modify(DSHistoryData dSHistoryData, Function1<? super DSHistoryPageStatus, ? extends DSHistoryPageStatus> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DSHistoryData it = dSHistoryData;
                DSHistoryPageStatus status = (DSHistoryPageStatus) function1.invoke(it.getStatus());
                DSHistoryData it2 = dSHistoryData;
                return DSHistoryData.copy$default(it2, null, status, null, null, null, null, 61, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<DSHistoryData, List<DSConversationItem>> getList(DSHistoryData.Companion $this$list) {
        Intrinsics.checkNotNullParameter($this$list, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DSHistoryData, List<? extends DSConversationItem>>() { // from class: kntr.app.deepsearch.base.model.history.DSHistoryDataLensKt$special$$inlined$invoke$4
            public List<? extends DSConversationItem> get(DSHistoryData dSHistoryData) {
                DSHistoryData it = dSHistoryData;
                return it.getList();
            }

            public DSHistoryData set(DSHistoryData dSHistoryData, List<? extends DSConversationItem> list) {
                List<? extends DSConversationItem> list2 = list;
                DSHistoryData it = dSHistoryData;
                return DSHistoryData.copy$default(it, null, null, list2, null, null, null, 59, null);
            }

            public DSHistoryData modify(DSHistoryData dSHistoryData, Function1<? super List<? extends DSConversationItem>, ? extends List<? extends DSConversationItem>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DSHistoryData it = dSHistoryData;
                List list = (List) function1.invoke(it.getList());
                DSHistoryData it2 = dSHistoryData;
                return DSHistoryData.copy$default(it2, null, null, list, null, null, null, 59, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<DSHistoryData, List<DSConversationSection>> getGroups(DSHistoryData.Companion $this$groups) {
        Intrinsics.checkNotNullParameter($this$groups, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DSHistoryData, List<? extends DSConversationSection>>() { // from class: kntr.app.deepsearch.base.model.history.DSHistoryDataLensKt$special$$inlined$invoke$5
            public List<? extends DSConversationSection> get(DSHistoryData dSHistoryData) {
                DSHistoryData it = dSHistoryData;
                return it.getGroups();
            }

            public DSHistoryData set(DSHistoryData dSHistoryData, List<? extends DSConversationSection> list) {
                List<? extends DSConversationSection> groups = list;
                DSHistoryData it = dSHistoryData;
                return DSHistoryData.copy$default(it, null, null, null, groups, null, null, 55, null);
            }

            public DSHistoryData modify(DSHistoryData dSHistoryData, Function1<? super List<? extends DSConversationSection>, ? extends List<? extends DSConversationSection>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DSHistoryData it = dSHistoryData;
                List groups = (List) function1.invoke(it.getGroups());
                DSHistoryData it2 = dSHistoryData;
                return DSHistoryData.copy$default(it2, null, null, null, groups, null, null, 55, null);
            }
        };
    }

    public static final BSimpleLens<DSHistoryData, String> getCursor(DSHistoryData.Companion $this$cursor) {
        Intrinsics.checkNotNullParameter($this$cursor, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DSHistoryData, String>() { // from class: kntr.app.deepsearch.base.model.history.DSHistoryDataLensKt$special$$inlined$invoke$6
            public String get(DSHistoryData dSHistoryData) {
                DSHistoryData it = dSHistoryData;
                return it.getCursor();
            }

            public DSHistoryData set(DSHistoryData dSHistoryData, String str) {
                String cursor = str;
                DSHistoryData it = dSHistoryData;
                return DSHistoryData.copy$default(it, null, null, null, null, cursor, null, 47, null);
            }

            public DSHistoryData modify(DSHistoryData dSHistoryData, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DSHistoryData it = dSHistoryData;
                String cursor = (String) function1.invoke(it.getCursor());
                DSHistoryData it2 = dSHistoryData;
                return DSHistoryData.copy$default(it2, null, null, null, null, cursor, null, 47, null);
            }
        };
    }

    public static final BSimpleLens<DSHistoryData, LoadActionType> getLoadActionType(DSHistoryData.Companion $this$loadActionType) {
        Intrinsics.checkNotNullParameter($this$loadActionType, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<DSHistoryData, LoadActionType>() { // from class: kntr.app.deepsearch.base.model.history.DSHistoryDataLensKt$special$$inlined$invoke$7
            public LoadActionType get(DSHistoryData dSHistoryData) {
                DSHistoryData it = dSHistoryData;
                return it.getLoadActionType();
            }

            public DSHistoryData set(DSHistoryData dSHistoryData, LoadActionType loadActionType) {
                LoadActionType loadActionType2 = loadActionType;
                DSHistoryData it = dSHistoryData;
                return DSHistoryData.copy$default(it, null, null, null, null, null, loadActionType2, 31, null);
            }

            public DSHistoryData modify(DSHistoryData dSHistoryData, Function1<? super LoadActionType, ? extends LoadActionType> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                DSHistoryData it = dSHistoryData;
                LoadActionType loadActionType = (LoadActionType) function1.invoke(it.getLoadActionType());
                DSHistoryData it2 = dSHistoryData;
                return DSHistoryData.copy$default(it2, null, null, null, null, null, loadActionType, 31, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getSessionId(BSimpleLens<T, DSHistoryData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSessionId(DSHistoryData.Companion));
    }

    public static final <T> BSimpleLens<T, DSHistoryPageStatus> getStatus(BSimpleLens<T, DSHistoryData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getStatus(DSHistoryData.Companion));
    }

    public static final <T> BSimpleLens<T, List<DSConversationItem>> getList(BSimpleLens<T, DSHistoryData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getList(DSHistoryData.Companion));
    }

    public static final <T> BSimpleLens<T, List<DSConversationSection>> getGroups(BSimpleLens<T, DSHistoryData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getGroups(DSHistoryData.Companion));
    }

    public static final <T> BSimpleLens<T, String> getCursor(BSimpleLens<T, DSHistoryData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCursor(DSHistoryData.Companion));
    }

    public static final <T> BSimpleLens<T, LoadActionType> getLoadActionType(BSimpleLens<T, DSHistoryData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getLoadActionType(DSHistoryData.Companion));
    }

    public static final <T> BNullableLens<T, String> sessionIdNullable(BSimpleLens<T, DSHistoryData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSessionId(DSHistoryData.Companion));
    }

    public static final <T> BNullableLens<T, DSHistoryPageStatus> statusNullable(BSimpleLens<T, DSHistoryData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getStatus(DSHistoryData.Companion));
    }

    public static final <T> BNullableLens<T, List<DSConversationItem>> listNullable(BSimpleLens<T, DSHistoryData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getList(DSHistoryData.Companion));
    }

    public static final <T> BNullableLens<T, List<DSConversationSection>> groupsNullable(BSimpleLens<T, DSHistoryData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getGroups(DSHistoryData.Companion));
    }

    public static final <T> BNullableLens<T, String> cursorNullable(BSimpleLens<T, DSHistoryData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCursor(DSHistoryData.Companion));
    }

    public static final <T> BNullableLens<T, LoadActionType> loadActionTypeNullable(BSimpleLens<T, DSHistoryData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getLoadActionType(DSHistoryData.Companion));
    }

    public static final <T> BNullableLens<T, String> getSessionId(BNullableLens<T, DSHistoryData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSessionId(DSHistoryData.Companion));
    }

    public static final <T> BNullableLens<T, DSHistoryPageStatus> getStatus(BNullableLens<T, DSHistoryData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getStatus(DSHistoryData.Companion));
    }

    public static final <T> BNullableLens<T, List<DSConversationItem>> getList(BNullableLens<T, DSHistoryData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getList(DSHistoryData.Companion));
    }

    public static final <T> BNullableLens<T, List<DSConversationSection>> getGroups(BNullableLens<T, DSHistoryData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getGroups(DSHistoryData.Companion));
    }

    public static final <T> BNullableLens<T, String> getCursor(BNullableLens<T, DSHistoryData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCursor(DSHistoryData.Companion));
    }

    public static final <T> BNullableLens<T, LoadActionType> getLoadActionType(BNullableLens<T, DSHistoryData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getLoadActionType(DSHistoryData.Companion));
    }
}