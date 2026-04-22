package im.direct.notification.interactive;

import com.bapis.bilibili.im.gateway.interfaces.v1.KCursor;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgListLimit;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import com.tencent.smtt.sdk.TbsListener;
import im.direct.notification.interactive.INState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INStateLens.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"0\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\",\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"0\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\",\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007\",\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007\",\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\"0\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010%*\u00020&*\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010'\u001a\u0004\b\u000b\u0010(\"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001\"\b\b\u0000\u0010%*\u00020&*\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010'\u001a\u0004\b\u0010\u0010(\"B\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0001\"\b\b\u0000\u0010%*\u00020&*\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010'\u001a\u0004\b\u0014\u0010(\"F\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u0002H%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\r0\u0001\"\b\b\u0000\u0010%*\u00020&*\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010'\u001a\u0004\b\u0018\u0010(\"B\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u0010%*\u00020&*\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010'\u001a\u0004\b\u001c\u0010(\"B\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0001\"\b\b\u0000\u0010%*\u00020&*\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010'\u001a\u0004\b \u0010(\"B\u0010!\u001a\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\"0\u0001\"\b\b\u0000\u0010%*\u00020&*\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b#\u0010'\u001a\u0004\b$\u0010(\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\t0)\"\b\b\u0000\u0010%*\u00020&*\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010'\u001a\u0004\b+\u0010,\"H\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0)\"\b\b\u0000\u0010%*\u00020&*\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b-\u0010'\u001a\u0004\b.\u0010,\"D\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0001\"\b\b\u0000\u0010%*\u00020&*\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b/\u0010'\u001a\u0004\b0\u0010(\"H\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u0002H%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\r0)\"\b\b\u0000\u0010%*\u00020&*\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010'\u001a\u0004\b2\u0010,\"D\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u0010%*\u00020&*\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b3\u0010'\u001a\u0004\b4\u0010(\"D\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0001\"\b\b\u0000\u0010%*\u00020&*\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b5\u0010'\u001a\u0004\b6\u0010(\"D\u0010!\u001a\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\"0\u0001\"\b\b\u0000\u0010%*\u00020&*\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b7\u0010'\u001a\u0004\b8\u0010(\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\t0)\"\b\b\u0000\u0010%*\u00020&*\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00020)8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u00109\u001a\u0004\b\u000b\u0010:\"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0)\"\b\b\u0000\u0010%*\u00020&*\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00020)8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u000f\u00109\u001a\u0004\b\u0010\u0010:\"B\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0001\"\b\b\u0000\u0010%*\u00020&*\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00020)8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0013\u00109\u001a\u0004\b\u0014\u0010;\"F\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u0002H%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\r0)\"\b\b\u0000\u0010%*\u00020&*\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00020)8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u00109\u001a\u0004\b\u0018\u0010:\"B\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u0010%*\u00020&*\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00020)8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001b\u00109\u001a\u0004\b\u001c\u0010;\"B\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0001\"\b\b\u0000\u0010%*\u00020&*\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00020)8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001f\u00109\u001a\u0004\b \u0010;\"B\u0010!\u001a\u0010\u0012\u0004\u0012\u0002H%\u0012\u0006\u0012\u0004\u0018\u00010\"0\u0001\"\b\b\u0000\u0010%*\u00020&*\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00020)8@X\u0081\u0004¢\u0006\f\u0012\u0004\b#\u00109\u001a\u0004\b$\u0010;¨\u0006<"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/direct/notification/interactive/INState;", "Lim/direct/notification/interactive/INState$Companion;", "getLens$annotations", "(Lim/direct/notification/interactive/INState$Companion;)V", "getLens", "(Lim/direct/notification/interactive/INState$Companion;)Lcom/bilibili/blens/BSimpleLens;", "pageStatus", "Lim/direct/notification/interactive/INPageStatus;", "getPageStatus$annotations", "getPageStatus", "messageCards", "", "Lim/direct/notification/interactive/INMessageCard;", "getMessageCards$annotations", "getMessageCards", "limit", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgListLimit;", "getLimit$annotations", "getLimit", "filters", "Lim/direct/notification/interactive/INFilter;", "getFilters$annotations", "getFilters", "toast", "Lim/direct/notification/interactive/ToastMessage;", "getToast$annotations", "getToast", "cursor", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KCursor;", "getCursor$annotations", "getCursor", "requestID", "", "getRequestID$annotations", "getRequestID", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "pageStatusNullable$annotations", "pageStatusNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "messageCardsNullable$annotations", "messageCardsNullable", "limitNullable$annotations", "limitNullable", "filtersNullable$annotations", "filtersNullable", "toastNullable$annotations", "toastNullable", "cursorNullable$annotations", "cursorNullable", "requestIDNullable$annotations", "requestIDNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "interactive_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class INStateLensKt {
    public static /* synthetic */ void cursorNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void filtersNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCursor$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCursor$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCursor$annotations(INState.Companion companion) {
    }

    public static /* synthetic */ void getFilters$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getFilters$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getFilters$annotations(INState.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(INState.Companion companion) {
    }

    public static /* synthetic */ void getLimit$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getLimit$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getLimit$annotations(INState.Companion companion) {
    }

    public static /* synthetic */ void getMessageCards$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getMessageCards$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getMessageCards$annotations(INState.Companion companion) {
    }

    public static /* synthetic */ void getPageStatus$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPageStatus$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPageStatus$annotations(INState.Companion companion) {
    }

    public static /* synthetic */ void getRequestID$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getRequestID$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getRequestID$annotations(INState.Companion companion) {
    }

    public static /* synthetic */ void getToast$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getToast$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getToast$annotations(INState.Companion companion) {
    }

    public static /* synthetic */ void limitNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void messageCardsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void pageStatusNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void requestIDNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void toastNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<INState, INState> getLens(INState.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INState, INState>() { // from class: im.direct.notification.interactive.INStateLensKt$special$$inlined$invoke$1
            public INState get(INState iNState) {
                INState it = iNState;
                return it;
            }

            public INState set(INState iNState, INState iNState2) {
                INState it = iNState2;
                return it;
            }

            public INState modify(INState iNState, Function1<? super INState, ? extends INState> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                INState it = iNState;
                return (INState) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<INState, INPageStatus> getPageStatus(INState.Companion $this$pageStatus) {
        Intrinsics.checkNotNullParameter($this$pageStatus, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INState, INPageStatus>() { // from class: im.direct.notification.interactive.INStateLensKt$special$$inlined$invoke$2
            public INPageStatus get(INState iNState) {
                INState it = iNState;
                return it.getPageStatus();
            }

            public INState set(INState iNState, INPageStatus iNPageStatus) {
                INPageStatus pageStatus = iNPageStatus;
                INState it = iNState;
                return INState.copy$default(it, pageStatus, null, null, null, null, null, null, TbsListener.ErrorCode.PV_UPLOAD_ERROR, null);
            }

            public INState modify(INState iNState, Function1<? super INPageStatus, ? extends INPageStatus> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                INState it = iNState;
                INPageStatus pageStatus = (INPageStatus) function1.invoke(it.getPageStatus());
                INState it2 = iNState;
                return INState.copy$default(it2, pageStatus, null, null, null, null, null, null, TbsListener.ErrorCode.PV_UPLOAD_ERROR, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<INState, List<INMessageCard>> getMessageCards(INState.Companion $this$messageCards) {
        Intrinsics.checkNotNullParameter($this$messageCards, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INState, List<? extends INMessageCard>>() { // from class: im.direct.notification.interactive.INStateLensKt$special$$inlined$invoke$3
            public List<? extends INMessageCard> get(INState iNState) {
                INState it = iNState;
                return it.getMessageCards$interactive_debug();
            }

            public INState set(INState iNState, List<? extends INMessageCard> list) {
                List<? extends INMessageCard> messageCards = list;
                INState it = iNState;
                return INState.copy$default(it, null, messageCards, null, null, null, null, null, TbsListener.ErrorCode.DOWNLOAD_THROWABLE, null);
            }

            public INState modify(INState iNState, Function1<? super List<? extends INMessageCard>, ? extends List<? extends INMessageCard>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                INState it = iNState;
                List messageCards = (List) function1.invoke(it.getMessageCards$interactive_debug());
                INState it2 = iNState;
                return INState.copy$default(it2, null, messageCards, null, null, null, null, null, TbsListener.ErrorCode.DOWNLOAD_THROWABLE, null);
            }
        };
    }

    public static final BSimpleLens<INState, KMsgListLimit> getLimit(INState.Companion $this$limit) {
        Intrinsics.checkNotNullParameter($this$limit, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INState, KMsgListLimit>() { // from class: im.direct.notification.interactive.INStateLensKt$special$$inlined$invoke$4
            public KMsgListLimit get(INState iNState) {
                INState it = iNState;
                return it.getLimit$interactive_debug();
            }

            public INState set(INState iNState, KMsgListLimit kMsgListLimit) {
                KMsgListLimit limit = kMsgListLimit;
                INState it = iNState;
                return INState.copy$default(it, null, null, limit, null, null, null, null, TbsListener.ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED, null);
            }

            public INState modify(INState iNState, Function1<? super KMsgListLimit, ? extends KMsgListLimit> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                INState it = iNState;
                KMsgListLimit limit = (KMsgListLimit) function1.invoke(it.getLimit$interactive_debug());
                INState it2 = iNState;
                return INState.copy$default(it2, null, null, limit, null, null, null, null, TbsListener.ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<INState, List<INFilter>> getFilters(INState.Companion $this$filters) {
        Intrinsics.checkNotNullParameter($this$filters, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INState, List<? extends INFilter>>() { // from class: im.direct.notification.interactive.INStateLensKt$special$$inlined$invoke$5
            public List<? extends INFilter> get(INState iNState) {
                INState it = iNState;
                return it.getFilters();
            }

            public INState set(INState iNState, List<? extends INFilter> list) {
                List<? extends INFilter> filters = list;
                INState it = iNState;
                return INState.copy$default(it, null, null, null, filters, null, null, null, 119, null);
            }

            public INState modify(INState iNState, Function1<? super List<? extends INFilter>, ? extends List<? extends INFilter>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                INState it = iNState;
                List filters = (List) function1.invoke(it.getFilters());
                INState it2 = iNState;
                return INState.copy$default(it2, null, null, null, filters, null, null, null, 119, null);
            }
        };
    }

    public static final BSimpleLens<INState, ToastMessage> getToast(INState.Companion $this$toast) {
        Intrinsics.checkNotNullParameter($this$toast, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INState, ToastMessage>() { // from class: im.direct.notification.interactive.INStateLensKt$special$$inlined$invoke$6
            public ToastMessage get(INState iNState) {
                INState it = iNState;
                return it.getToast$interactive_debug();
            }

            public INState set(INState iNState, ToastMessage toastMessage) {
                ToastMessage toast = toastMessage;
                INState it = iNState;
                return INState.copy$default(it, null, null, null, null, toast, null, null, TbsListener.ErrorCode.NETWORK_NOT_WIFI_ERROR, null);
            }

            public INState modify(INState iNState, Function1<? super ToastMessage, ? extends ToastMessage> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                INState it = iNState;
                ToastMessage toast = (ToastMessage) function1.invoke(it.getToast$interactive_debug());
                INState it2 = iNState;
                return INState.copy$default(it2, null, null, null, null, toast, null, null, TbsListener.ErrorCode.NETWORK_NOT_WIFI_ERROR, null);
            }
        };
    }

    public static final BSimpleLens<INState, KCursor> getCursor(INState.Companion $this$cursor) {
        Intrinsics.checkNotNullParameter($this$cursor, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INState, KCursor>() { // from class: im.direct.notification.interactive.INStateLensKt$special$$inlined$invoke$7
            public KCursor get(INState iNState) {
                INState it = iNState;
                return it.getCursor$interactive_debug();
            }

            public INState set(INState iNState, KCursor kCursor) {
                KCursor cursor = kCursor;
                INState it = iNState;
                return INState.copy$default(it, null, null, null, null, null, cursor, null, 95, null);
            }

            public INState modify(INState iNState, Function1<? super KCursor, ? extends KCursor> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                INState it = iNState;
                KCursor cursor = (KCursor) function1.invoke(it.getCursor$interactive_debug());
                INState it2 = iNState;
                return INState.copy$default(it2, null, null, null, null, null, cursor, null, 95, null);
            }
        };
    }

    public static final BSimpleLens<INState, Long> getRequestID(INState.Companion $this$requestID) {
        Intrinsics.checkNotNullParameter($this$requestID, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<INState, Long>() { // from class: im.direct.notification.interactive.INStateLensKt$special$$inlined$invoke$8
            public Long get(INState iNState) {
                INState it = iNState;
                return it.getRequestID$interactive_debug();
            }

            public INState set(INState iNState, Long l) {
                Long requestID = l;
                INState it = iNState;
                return INState.copy$default(it, null, null, null, null, null, null, requestID, 63, null);
            }

            public INState modify(INState iNState, Function1<? super Long, ? extends Long> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                INState it = iNState;
                Long requestID = (Long) function1.invoke(it.getRequestID$interactive_debug());
                INState it2 = iNState;
                return INState.copy$default(it2, null, null, null, null, null, null, requestID, 63, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, INPageStatus> getPageStatus(BSimpleLens<T, INState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getPageStatus(INState.Companion));
    }

    public static final <T> BSimpleLens<T, List<INMessageCard>> getMessageCards(BSimpleLens<T, INState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getMessageCards(INState.Companion));
    }

    public static final <T> BSimpleLens<T, KMsgListLimit> getLimit(BSimpleLens<T, INState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getLimit(INState.Companion));
    }

    public static final <T> BSimpleLens<T, List<INFilter>> getFilters(BSimpleLens<T, INState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getFilters(INState.Companion));
    }

    public static final <T> BSimpleLens<T, ToastMessage> getToast(BSimpleLens<T, INState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getToast(INState.Companion));
    }

    public static final <T> BSimpleLens<T, KCursor> getCursor(BSimpleLens<T, INState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getCursor(INState.Companion));
    }

    public static final <T> BSimpleLens<T, Long> getRequestID(BSimpleLens<T, INState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getRequestID(INState.Companion));
    }

    public static final <T> BNullableLens<T, INPageStatus> pageStatusNullable(BSimpleLens<T, INState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getPageStatus(INState.Companion));
    }

    public static final <T> BNullableLens<T, List<INMessageCard>> messageCardsNullable(BSimpleLens<T, INState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getMessageCards(INState.Companion));
    }

    public static final <T> BSimpleLens<T, KMsgListLimit> limitNullable(BSimpleLens<T, INState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getLimit(INState.Companion));
    }

    public static final <T> BNullableLens<T, List<INFilter>> filtersNullable(BSimpleLens<T, INState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getFilters(INState.Companion));
    }

    public static final <T> BSimpleLens<T, ToastMessage> toastNullable(BSimpleLens<T, INState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getToast(INState.Companion));
    }

    public static final <T> BSimpleLens<T, KCursor> cursorNullable(BSimpleLens<T, INState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getCursor(INState.Companion));
    }

    public static final <T> BSimpleLens<T, Long> requestIDNullable(BSimpleLens<T, INState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getRequestID(INState.Companion));
    }

    public static final <T> BNullableLens<T, INPageStatus> getPageStatus(BNullableLens<T, INState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getPageStatus(INState.Companion));
    }

    public static final <T> BNullableLens<T, List<INMessageCard>> getMessageCards(BNullableLens<T, INState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getMessageCards(INState.Companion));
    }

    public static final <T> BSimpleLens<T, KMsgListLimit> getLimit(BNullableLens<T, INState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getLimit(INState.Companion));
    }

    public static final <T> BNullableLens<T, List<INFilter>> getFilters(BNullableLens<T, INState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getFilters(INState.Companion));
    }

    public static final <T> BSimpleLens<T, ToastMessage> getToast(BNullableLens<T, INState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getToast(INState.Companion));
    }

    public static final <T> BSimpleLens<T, KCursor> getCursor(BNullableLens<T, INState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getCursor(INState.Companion));
    }

    public static final <T> BSimpleLens<T, Long> getRequestID(BNullableLens<T, INState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getRequestID(INState.Companion));
    }
}