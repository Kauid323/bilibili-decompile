package im.keywordBlocking;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import im.base.IMToast;
import im.keywordBlocking.KBPageData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBPageDataLens.kt */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"0\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"*\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"*\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00160\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"*\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\",\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\",\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007\",\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010%0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010\u0007\",\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010)0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0005\u001a\u0004\b+\u0010\u0007\"*\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-0\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0005\u001a\u0004\b/\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u00102\u001a\u0004\b\u000b\u00103\"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H0\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u00102\u001a\u0004\b\u0010\u00103\"@\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u00120\u0001\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u00102\u001a\u0004\b\u0014\u00103\"@\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u00160\u0001\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u00102\u001a\u0004\b\u0018\u00103\"@\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u00120\u0001\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001a\u00102\u001a\u0004\b\u001b\u00103\"B\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0001\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001e\u00102\u001a\u0004\b\u001f\u00103\"B\u0010 \u001a\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u00102\u001a\u0004\b#\u00103\"B\u0010$\u001a\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010%0\u0001\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u00102\u001a\u0004\b'\u00103\"B\u0010(\u001a\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010)0\u0001\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u00102\u001a\u0004\b+\u00103\"@\u0010,\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020-0\u0001\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b.\u00102\u001a\u0004\b/\u00103\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\t04\"\b\b\u0000\u00100*\u000201*\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u00102\u001a\u0004\b6\u00107\"H\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H0\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r04\"\b\b\u0000\u00100*\u000201*\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u00102\u001a\u0004\b9\u00107\"B\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u001204\"\b\b\u0000\u00100*\u000201*\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b:\u00102\u001a\u0004\b;\u00107\"B\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u001604\"\b\b\u0000\u00100*\u000201*\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b<\u00102\u001a\u0004\b=\u00107\"B\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u001204\"\b\b\u0000\u00100*\u000201*\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b>\u00102\u001a\u0004\b?\u00107\"D\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0001\"\b\b\u0000\u00100*\u000201*\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b@\u00102\u001a\u0004\bA\u00103\"D\u0010 \u001a\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001\"\b\b\u0000\u00100*\u000201*\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u00102\u001a\u0004\bC\u00103\"D\u0010$\u001a\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010%0\u0001\"\b\b\u0000\u00100*\u000201*\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bD\u00102\u001a\u0004\bE\u00103\"D\u0010(\u001a\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010)0\u0001\"\b\b\u0000\u00100*\u000201*\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\bF\u00102\u001a\u0004\bG\u00103\"B\u0010,\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020-04\"\b\b\u0000\u00100*\u000201*\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\bH\u00102\u001a\u0004\bI\u00107\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\t04\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u0002048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010J\u001a\u0004\b\u000b\u0010K\"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H0\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r04\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u0002048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010J\u001a\u0004\b\u0010\u0010K\"@\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u001204\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u0002048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010J\u001a\u0004\b\u0014\u0010K\"@\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u001604\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u0002048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010J\u001a\u0004\b\u0018\u0010K\"@\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u001204\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u0002048@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010J\u001a\u0004\b\u001b\u0010K\"B\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0001\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u0002048@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010J\u001a\u0004\b\u001f\u0010L\"B\u0010 \u001a\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u0002048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010J\u001a\u0004\b#\u0010L\"B\u0010$\u001a\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010%0\u0001\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u0002048FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010J\u001a\u0004\b'\u0010L\"B\u0010(\u001a\u0010\u0012\u0004\u0012\u0002H0\u0012\u0006\u0012\u0004\u0018\u00010)0\u0001\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u0002048FX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010J\u001a\u0004\b+\u0010L\"@\u0010,\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020-04\"\b\b\u0000\u00100*\u000201*\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u0002048@X\u0081\u0004¢\u0006\f\u0012\u0004\b.\u0010J\u001a\u0004\b/\u0010K¨\u0006M"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/keywordBlocking/KBPageData;", "Lim/keywordBlocking/KBPageData$Companion;", "getLens$annotations", "(Lim/keywordBlocking/KBPageData$Companion;)V", "getLens", "(Lim/keywordBlocking/KBPageData$Companion;)Lcom/bilibili/blens/BSimpleLens;", "status", "Lim/keywordBlocking/KBPageStatus;", "getStatus$annotations", "getStatus", "items", "", "Lim/keywordBlocking/KBListItem;", "getItems$annotations", "getItems", "limit", "", "getLimit$annotations", "getLimit", "limitsHint", "", "getLimitsHint$annotations", "getLimitsHint", "charLimit", "getCharLimit$annotations", "getCharLimit", "toast", "Lim/base/IMToast;", "getToast$annotations", "getToast", "inputBox", "Lim/keywordBlocking/KBInputBox;", "getInputBox$annotations", "getInputBox", "dropList", "Lim/keywordBlocking/KBDropList;", "getDropList$annotations", "getDropList", "alert", "Lim/keywordBlocking/KBAlert;", "getAlert$annotations", "getAlert", "firstLoad", "", "getFirstLoad$annotations", "getFirstLoad", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "statusNullable$annotations", "statusNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "itemsNullable$annotations", "itemsNullable", "limitNullable$annotations", "limitNullable", "limitsHintNullable$annotations", "limitsHintNullable", "charLimitNullable$annotations", "charLimitNullable", "toastNullable$annotations", "toastNullable", "inputBoxNullable$annotations", "inputBoxNullable", "dropListNullable$annotations", "dropListNullable", "alertNullable$annotations", "alertNullable", "firstLoadNullable$annotations", "firstLoadNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "keyword-blocking_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KBPageDataLensKt {
    public static /* synthetic */ void alertNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void charLimitNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void dropListNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void firstLoadNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAlert$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getAlert$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAlert$annotations(KBPageData.Companion companion) {
    }

    public static /* synthetic */ void getCharLimit$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCharLimit$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCharLimit$annotations(KBPageData.Companion companion) {
    }

    public static /* synthetic */ void getDropList$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getDropList$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getDropList$annotations(KBPageData.Companion companion) {
    }

    public static /* synthetic */ void getFirstLoad$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getFirstLoad$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getFirstLoad$annotations(KBPageData.Companion companion) {
    }

    public static /* synthetic */ void getInputBox$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getInputBox$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getInputBox$annotations(KBPageData.Companion companion) {
    }

    public static /* synthetic */ void getItems$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getItems$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getItems$annotations(KBPageData.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(KBPageData.Companion companion) {
    }

    public static /* synthetic */ void getLimit$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getLimit$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getLimit$annotations(KBPageData.Companion companion) {
    }

    public static /* synthetic */ void getLimitsHint$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getLimitsHint$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getLimitsHint$annotations(KBPageData.Companion companion) {
    }

    public static /* synthetic */ void getStatus$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getStatus$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getStatus$annotations(KBPageData.Companion companion) {
    }

    public static /* synthetic */ void getToast$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getToast$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getToast$annotations(KBPageData.Companion companion) {
    }

    public static /* synthetic */ void inputBoxNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void itemsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void limitNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void limitsHintNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void statusNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void toastNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<KBPageData, KBPageData> getLens(KBPageData.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<KBPageData, KBPageData>() { // from class: im.keywordBlocking.KBPageDataLensKt$special$$inlined$invoke$1
            public KBPageData get(KBPageData kBPageData) {
                KBPageData it = kBPageData;
                return it;
            }

            public KBPageData set(KBPageData kBPageData, KBPageData kBPageData2) {
                KBPageData it = kBPageData2;
                return it;
            }

            public KBPageData modify(KBPageData kBPageData, Function1<? super KBPageData, ? extends KBPageData> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                KBPageData it = kBPageData;
                return (KBPageData) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<KBPageData, KBPageStatus> getStatus(KBPageData.Companion $this$status) {
        Intrinsics.checkNotNullParameter($this$status, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<KBPageData, KBPageStatus>() { // from class: im.keywordBlocking.KBPageDataLensKt$special$$inlined$invoke$2
            public KBPageStatus get(KBPageData kBPageData) {
                KBPageData it = kBPageData;
                return it.getStatus();
            }

            public KBPageData set(KBPageData kBPageData, KBPageStatus kBPageStatus) {
                KBPageData copy;
                KBPageStatus status = kBPageStatus;
                KBPageData it = kBPageData;
                copy = it.copy((r22 & 1) != 0 ? it.status : status, (r22 & 2) != 0 ? it.items : null, (r22 & 4) != 0 ? it.limit : 0, (r22 & 8) != 0 ? it.limitsHint : null, (r22 & 16) != 0 ? it.charLimit : 0, (r22 & 32) != 0 ? it.toast : null, (r22 & 64) != 0 ? it.inputBox : null, (r22 & 128) != 0 ? it.dropList : null, (r22 & 256) != 0 ? it.alert : null, (r22 & 512) != 0 ? it.firstLoad : false);
                return copy;
            }

            public KBPageData modify(KBPageData kBPageData, Function1<? super KBPageStatus, ? extends KBPageStatus> function1) {
                KBPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                KBPageData it = kBPageData;
                KBPageStatus status = (KBPageStatus) function1.invoke(it.getStatus());
                KBPageData it2 = kBPageData;
                copy = it2.copy((r22 & 1) != 0 ? it2.status : status, (r22 & 2) != 0 ? it2.items : null, (r22 & 4) != 0 ? it2.limit : 0, (r22 & 8) != 0 ? it2.limitsHint : null, (r22 & 16) != 0 ? it2.charLimit : 0, (r22 & 32) != 0 ? it2.toast : null, (r22 & 64) != 0 ? it2.inputBox : null, (r22 & 128) != 0 ? it2.dropList : null, (r22 & 256) != 0 ? it2.alert : null, (r22 & 512) != 0 ? it2.firstLoad : false);
                return copy;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<KBPageData, List<KBListItem>> getItems(KBPageData.Companion $this$items) {
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<KBPageData, List<? extends KBListItem>>() { // from class: im.keywordBlocking.KBPageDataLensKt$special$$inlined$invoke$3
            public List<? extends KBListItem> get(KBPageData kBPageData) {
                KBPageData it = kBPageData;
                return it.getItems();
            }

            public KBPageData set(KBPageData kBPageData, List<? extends KBListItem> list) {
                KBPageData copy;
                List<? extends KBListItem> items = list;
                KBPageData it = kBPageData;
                copy = it.copy((r22 & 1) != 0 ? it.status : null, (r22 & 2) != 0 ? it.items : items, (r22 & 4) != 0 ? it.limit : 0, (r22 & 8) != 0 ? it.limitsHint : null, (r22 & 16) != 0 ? it.charLimit : 0, (r22 & 32) != 0 ? it.toast : null, (r22 & 64) != 0 ? it.inputBox : null, (r22 & 128) != 0 ? it.dropList : null, (r22 & 256) != 0 ? it.alert : null, (r22 & 512) != 0 ? it.firstLoad : false);
                return copy;
            }

            public KBPageData modify(KBPageData kBPageData, Function1<? super List<? extends KBListItem>, ? extends List<? extends KBListItem>> function1) {
                KBPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                KBPageData it = kBPageData;
                List items = (List) function1.invoke(it.getItems());
                KBPageData it2 = kBPageData;
                copy = it2.copy((r22 & 1) != 0 ? it2.status : null, (r22 & 2) != 0 ? it2.items : items, (r22 & 4) != 0 ? it2.limit : 0, (r22 & 8) != 0 ? it2.limitsHint : null, (r22 & 16) != 0 ? it2.charLimit : 0, (r22 & 32) != 0 ? it2.toast : null, (r22 & 64) != 0 ? it2.inputBox : null, (r22 & 128) != 0 ? it2.dropList : null, (r22 & 256) != 0 ? it2.alert : null, (r22 & 512) != 0 ? it2.firstLoad : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<KBPageData, Integer> getLimit(KBPageData.Companion $this$limit) {
        Intrinsics.checkNotNullParameter($this$limit, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<KBPageData, Integer>() { // from class: im.keywordBlocking.KBPageDataLensKt$special$$inlined$invoke$4
            public Integer get(KBPageData kBPageData) {
                KBPageData it = kBPageData;
                return Integer.valueOf(it.getLimit());
            }

            public KBPageData set(KBPageData kBPageData, Integer num) {
                KBPageData copy;
                int limit = num.intValue();
                KBPageData it = kBPageData;
                copy = it.copy((r22 & 1) != 0 ? it.status : null, (r22 & 2) != 0 ? it.items : null, (r22 & 4) != 0 ? it.limit : limit, (r22 & 8) != 0 ? it.limitsHint : null, (r22 & 16) != 0 ? it.charLimit : 0, (r22 & 32) != 0 ? it.toast : null, (r22 & 64) != 0 ? it.inputBox : null, (r22 & 128) != 0 ? it.dropList : null, (r22 & 256) != 0 ? it.alert : null, (r22 & 512) != 0 ? it.firstLoad : false);
                return copy;
            }

            public KBPageData modify(KBPageData kBPageData, Function1<? super Integer, ? extends Integer> function1) {
                KBPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                KBPageData it = kBPageData;
                int limit = ((Number) function1.invoke(Integer.valueOf(it.getLimit()))).intValue();
                KBPageData it2 = kBPageData;
                copy = it2.copy((r22 & 1) != 0 ? it2.status : null, (r22 & 2) != 0 ? it2.items : null, (r22 & 4) != 0 ? it2.limit : limit, (r22 & 8) != 0 ? it2.limitsHint : null, (r22 & 16) != 0 ? it2.charLimit : 0, (r22 & 32) != 0 ? it2.toast : null, (r22 & 64) != 0 ? it2.inputBox : null, (r22 & 128) != 0 ? it2.dropList : null, (r22 & 256) != 0 ? it2.alert : null, (r22 & 512) != 0 ? it2.firstLoad : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<KBPageData, String> getLimitsHint(KBPageData.Companion $this$limitsHint) {
        Intrinsics.checkNotNullParameter($this$limitsHint, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<KBPageData, String>() { // from class: im.keywordBlocking.KBPageDataLensKt$special$$inlined$invoke$5
            public String get(KBPageData kBPageData) {
                KBPageData it = kBPageData;
                return it.getLimitsHint();
            }

            public KBPageData set(KBPageData kBPageData, String str) {
                KBPageData copy;
                String limitsHint = str;
                KBPageData it = kBPageData;
                copy = it.copy((r22 & 1) != 0 ? it.status : null, (r22 & 2) != 0 ? it.items : null, (r22 & 4) != 0 ? it.limit : 0, (r22 & 8) != 0 ? it.limitsHint : limitsHint, (r22 & 16) != 0 ? it.charLimit : 0, (r22 & 32) != 0 ? it.toast : null, (r22 & 64) != 0 ? it.inputBox : null, (r22 & 128) != 0 ? it.dropList : null, (r22 & 256) != 0 ? it.alert : null, (r22 & 512) != 0 ? it.firstLoad : false);
                return copy;
            }

            public KBPageData modify(KBPageData kBPageData, Function1<? super String, ? extends String> function1) {
                KBPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                KBPageData it = kBPageData;
                String limitsHint = (String) function1.invoke(it.getLimitsHint());
                KBPageData it2 = kBPageData;
                copy = it2.copy((r22 & 1) != 0 ? it2.status : null, (r22 & 2) != 0 ? it2.items : null, (r22 & 4) != 0 ? it2.limit : 0, (r22 & 8) != 0 ? it2.limitsHint : limitsHint, (r22 & 16) != 0 ? it2.charLimit : 0, (r22 & 32) != 0 ? it2.toast : null, (r22 & 64) != 0 ? it2.inputBox : null, (r22 & 128) != 0 ? it2.dropList : null, (r22 & 256) != 0 ? it2.alert : null, (r22 & 512) != 0 ? it2.firstLoad : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<KBPageData, Integer> getCharLimit(KBPageData.Companion $this$charLimit) {
        Intrinsics.checkNotNullParameter($this$charLimit, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<KBPageData, Integer>() { // from class: im.keywordBlocking.KBPageDataLensKt$special$$inlined$invoke$6
            public Integer get(KBPageData kBPageData) {
                KBPageData it = kBPageData;
                return Integer.valueOf(it.getCharLimit$keyword_blocking_debug());
            }

            public KBPageData set(KBPageData kBPageData, Integer num) {
                KBPageData copy;
                int charLimit = num.intValue();
                KBPageData it = kBPageData;
                copy = it.copy((r22 & 1) != 0 ? it.status : null, (r22 & 2) != 0 ? it.items : null, (r22 & 4) != 0 ? it.limit : 0, (r22 & 8) != 0 ? it.limitsHint : null, (r22 & 16) != 0 ? it.charLimit : charLimit, (r22 & 32) != 0 ? it.toast : null, (r22 & 64) != 0 ? it.inputBox : null, (r22 & 128) != 0 ? it.dropList : null, (r22 & 256) != 0 ? it.alert : null, (r22 & 512) != 0 ? it.firstLoad : false);
                return copy;
            }

            public KBPageData modify(KBPageData kBPageData, Function1<? super Integer, ? extends Integer> function1) {
                KBPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                KBPageData it = kBPageData;
                int charLimit = ((Number) function1.invoke(Integer.valueOf(it.getCharLimit$keyword_blocking_debug()))).intValue();
                KBPageData it2 = kBPageData;
                copy = it2.copy((r22 & 1) != 0 ? it2.status : null, (r22 & 2) != 0 ? it2.items : null, (r22 & 4) != 0 ? it2.limit : 0, (r22 & 8) != 0 ? it2.limitsHint : null, (r22 & 16) != 0 ? it2.charLimit : charLimit, (r22 & 32) != 0 ? it2.toast : null, (r22 & 64) != 0 ? it2.inputBox : null, (r22 & 128) != 0 ? it2.dropList : null, (r22 & 256) != 0 ? it2.alert : null, (r22 & 512) != 0 ? it2.firstLoad : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<KBPageData, IMToast> getToast(KBPageData.Companion $this$toast) {
        Intrinsics.checkNotNullParameter($this$toast, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<KBPageData, IMToast>() { // from class: im.keywordBlocking.KBPageDataLensKt$special$$inlined$invoke$7
            public IMToast get(KBPageData kBPageData) {
                KBPageData it = kBPageData;
                return it.getToast$keyword_blocking_debug();
            }

            public KBPageData set(KBPageData kBPageData, IMToast iMToast) {
                KBPageData copy;
                IMToast toast = iMToast;
                KBPageData it = kBPageData;
                copy = it.copy((r22 & 1) != 0 ? it.status : null, (r22 & 2) != 0 ? it.items : null, (r22 & 4) != 0 ? it.limit : 0, (r22 & 8) != 0 ? it.limitsHint : null, (r22 & 16) != 0 ? it.charLimit : 0, (r22 & 32) != 0 ? it.toast : toast, (r22 & 64) != 0 ? it.inputBox : null, (r22 & 128) != 0 ? it.dropList : null, (r22 & 256) != 0 ? it.alert : null, (r22 & 512) != 0 ? it.firstLoad : false);
                return copy;
            }

            public KBPageData modify(KBPageData kBPageData, Function1<? super IMToast, ? extends IMToast> function1) {
                KBPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                KBPageData it = kBPageData;
                IMToast toast = (IMToast) function1.invoke(it.getToast$keyword_blocking_debug());
                KBPageData it2 = kBPageData;
                copy = it2.copy((r22 & 1) != 0 ? it2.status : null, (r22 & 2) != 0 ? it2.items : null, (r22 & 4) != 0 ? it2.limit : 0, (r22 & 8) != 0 ? it2.limitsHint : null, (r22 & 16) != 0 ? it2.charLimit : 0, (r22 & 32) != 0 ? it2.toast : toast, (r22 & 64) != 0 ? it2.inputBox : null, (r22 & 128) != 0 ? it2.dropList : null, (r22 & 256) != 0 ? it2.alert : null, (r22 & 512) != 0 ? it2.firstLoad : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<KBPageData, KBInputBox> getInputBox(KBPageData.Companion $this$inputBox) {
        Intrinsics.checkNotNullParameter($this$inputBox, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<KBPageData, KBInputBox>() { // from class: im.keywordBlocking.KBPageDataLensKt$special$$inlined$invoke$8
            public KBInputBox get(KBPageData kBPageData) {
                KBPageData it = kBPageData;
                return it.getInputBox();
            }

            public KBPageData set(KBPageData kBPageData, KBInputBox kBInputBox) {
                KBPageData copy;
                KBInputBox inputBox = kBInputBox;
                KBPageData it = kBPageData;
                copy = it.copy((r22 & 1) != 0 ? it.status : null, (r22 & 2) != 0 ? it.items : null, (r22 & 4) != 0 ? it.limit : 0, (r22 & 8) != 0 ? it.limitsHint : null, (r22 & 16) != 0 ? it.charLimit : 0, (r22 & 32) != 0 ? it.toast : null, (r22 & 64) != 0 ? it.inputBox : inputBox, (r22 & 128) != 0 ? it.dropList : null, (r22 & 256) != 0 ? it.alert : null, (r22 & 512) != 0 ? it.firstLoad : false);
                return copy;
            }

            public KBPageData modify(KBPageData kBPageData, Function1<? super KBInputBox, ? extends KBInputBox> function1) {
                KBPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                KBPageData it = kBPageData;
                KBInputBox inputBox = (KBInputBox) function1.invoke(it.getInputBox());
                KBPageData it2 = kBPageData;
                copy = it2.copy((r22 & 1) != 0 ? it2.status : null, (r22 & 2) != 0 ? it2.items : null, (r22 & 4) != 0 ? it2.limit : 0, (r22 & 8) != 0 ? it2.limitsHint : null, (r22 & 16) != 0 ? it2.charLimit : 0, (r22 & 32) != 0 ? it2.toast : null, (r22 & 64) != 0 ? it2.inputBox : inputBox, (r22 & 128) != 0 ? it2.dropList : null, (r22 & 256) != 0 ? it2.alert : null, (r22 & 512) != 0 ? it2.firstLoad : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<KBPageData, KBDropList> getDropList(KBPageData.Companion $this$dropList) {
        Intrinsics.checkNotNullParameter($this$dropList, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<KBPageData, KBDropList>() { // from class: im.keywordBlocking.KBPageDataLensKt$special$$inlined$invoke$9
            public KBDropList get(KBPageData kBPageData) {
                KBPageData it = kBPageData;
                return it.getDropList();
            }

            public KBPageData set(KBPageData kBPageData, KBDropList kBDropList) {
                KBPageData copy;
                KBDropList dropList = kBDropList;
                KBPageData it = kBPageData;
                copy = it.copy((r22 & 1) != 0 ? it.status : null, (r22 & 2) != 0 ? it.items : null, (r22 & 4) != 0 ? it.limit : 0, (r22 & 8) != 0 ? it.limitsHint : null, (r22 & 16) != 0 ? it.charLimit : 0, (r22 & 32) != 0 ? it.toast : null, (r22 & 64) != 0 ? it.inputBox : null, (r22 & 128) != 0 ? it.dropList : dropList, (r22 & 256) != 0 ? it.alert : null, (r22 & 512) != 0 ? it.firstLoad : false);
                return copy;
            }

            public KBPageData modify(KBPageData kBPageData, Function1<? super KBDropList, ? extends KBDropList> function1) {
                KBPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                KBPageData it = kBPageData;
                KBDropList dropList = (KBDropList) function1.invoke(it.getDropList());
                KBPageData it2 = kBPageData;
                copy = it2.copy((r22 & 1) != 0 ? it2.status : null, (r22 & 2) != 0 ? it2.items : null, (r22 & 4) != 0 ? it2.limit : 0, (r22 & 8) != 0 ? it2.limitsHint : null, (r22 & 16) != 0 ? it2.charLimit : 0, (r22 & 32) != 0 ? it2.toast : null, (r22 & 64) != 0 ? it2.inputBox : null, (r22 & 128) != 0 ? it2.dropList : dropList, (r22 & 256) != 0 ? it2.alert : null, (r22 & 512) != 0 ? it2.firstLoad : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<KBPageData, KBAlert> getAlert(KBPageData.Companion $this$alert) {
        Intrinsics.checkNotNullParameter($this$alert, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<KBPageData, KBAlert>() { // from class: im.keywordBlocking.KBPageDataLensKt$special$$inlined$invoke$10
            public KBAlert get(KBPageData kBPageData) {
                KBPageData it = kBPageData;
                return it.getAlert();
            }

            public KBPageData set(KBPageData kBPageData, KBAlert kBAlert) {
                KBPageData copy;
                KBAlert alert = kBAlert;
                KBPageData it = kBPageData;
                copy = it.copy((r22 & 1) != 0 ? it.status : null, (r22 & 2) != 0 ? it.items : null, (r22 & 4) != 0 ? it.limit : 0, (r22 & 8) != 0 ? it.limitsHint : null, (r22 & 16) != 0 ? it.charLimit : 0, (r22 & 32) != 0 ? it.toast : null, (r22 & 64) != 0 ? it.inputBox : null, (r22 & 128) != 0 ? it.dropList : null, (r22 & 256) != 0 ? it.alert : alert, (r22 & 512) != 0 ? it.firstLoad : false);
                return copy;
            }

            public KBPageData modify(KBPageData kBPageData, Function1<? super KBAlert, ? extends KBAlert> function1) {
                KBPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                KBPageData it = kBPageData;
                KBAlert alert = (KBAlert) function1.invoke(it.getAlert());
                KBPageData it2 = kBPageData;
                copy = it2.copy((r22 & 1) != 0 ? it2.status : null, (r22 & 2) != 0 ? it2.items : null, (r22 & 4) != 0 ? it2.limit : 0, (r22 & 8) != 0 ? it2.limitsHint : null, (r22 & 16) != 0 ? it2.charLimit : 0, (r22 & 32) != 0 ? it2.toast : null, (r22 & 64) != 0 ? it2.inputBox : null, (r22 & 128) != 0 ? it2.dropList : null, (r22 & 256) != 0 ? it2.alert : alert, (r22 & 512) != 0 ? it2.firstLoad : false);
                return copy;
            }
        };
    }

    public static final BSimpleLens<KBPageData, Boolean> getFirstLoad(KBPageData.Companion $this$firstLoad) {
        Intrinsics.checkNotNullParameter($this$firstLoad, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<KBPageData, Boolean>() { // from class: im.keywordBlocking.KBPageDataLensKt$special$$inlined$invoke$11
            public Boolean get(KBPageData kBPageData) {
                KBPageData it = kBPageData;
                return Boolean.valueOf(it.getFirstLoad$keyword_blocking_debug());
            }

            public KBPageData set(KBPageData kBPageData, Boolean bool) {
                KBPageData copy;
                boolean firstLoad = bool.booleanValue();
                KBPageData it = kBPageData;
                copy = it.copy((r22 & 1) != 0 ? it.status : null, (r22 & 2) != 0 ? it.items : null, (r22 & 4) != 0 ? it.limit : 0, (r22 & 8) != 0 ? it.limitsHint : null, (r22 & 16) != 0 ? it.charLimit : 0, (r22 & 32) != 0 ? it.toast : null, (r22 & 64) != 0 ? it.inputBox : null, (r22 & 128) != 0 ? it.dropList : null, (r22 & 256) != 0 ? it.alert : null, (r22 & 512) != 0 ? it.firstLoad : firstLoad);
                return copy;
            }

            public KBPageData modify(KBPageData kBPageData, Function1<? super Boolean, ? extends Boolean> function1) {
                KBPageData copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                KBPageData it = kBPageData;
                boolean firstLoad = ((Boolean) function1.invoke(Boolean.valueOf(it.getFirstLoad$keyword_blocking_debug()))).booleanValue();
                KBPageData it2 = kBPageData;
                copy = it2.copy((r22 & 1) != 0 ? it2.status : null, (r22 & 2) != 0 ? it2.items : null, (r22 & 4) != 0 ? it2.limit : 0, (r22 & 8) != 0 ? it2.limitsHint : null, (r22 & 16) != 0 ? it2.charLimit : 0, (r22 & 32) != 0 ? it2.toast : null, (r22 & 64) != 0 ? it2.inputBox : null, (r22 & 128) != 0 ? it2.dropList : null, (r22 & 256) != 0 ? it2.alert : null, (r22 & 512) != 0 ? it2.firstLoad : firstLoad);
                return copy;
            }
        };
    }

    public static final <T> BSimpleLens<T, KBPageStatus> getStatus(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getStatus(KBPageData.Companion));
    }

    public static final <T> BSimpleLens<T, List<KBListItem>> getItems(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getItems(KBPageData.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getLimit(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getLimit(KBPageData.Companion));
    }

    public static final <T> BSimpleLens<T, String> getLimitsHint(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getLimitsHint(KBPageData.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getCharLimit(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCharLimit(KBPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMToast> getToast(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getToast(KBPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KBInputBox> getInputBox(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getInputBox(KBPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KBDropList> getDropList(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getDropList(KBPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KBAlert> getAlert(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getAlert(KBPageData.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getFirstLoad(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getFirstLoad(KBPageData.Companion));
    }

    public static final <T> BNullableLens<T, KBPageStatus> statusNullable(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getStatus(KBPageData.Companion));
    }

    public static final <T> BNullableLens<T, List<KBListItem>> itemsNullable(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getItems(KBPageData.Companion));
    }

    public static final <T> BNullableLens<T, Integer> limitNullable(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getLimit(KBPageData.Companion));
    }

    public static final <T> BNullableLens<T, String> limitsHintNullable(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getLimitsHint(KBPageData.Companion));
    }

    public static final <T> BNullableLens<T, Integer> charLimitNullable(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCharLimit(KBPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMToast> toastNullable(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getToast(KBPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KBInputBox> inputBoxNullable(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getInputBox(KBPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KBDropList> dropListNullable(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getDropList(KBPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KBAlert> alertNullable(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getAlert(KBPageData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> firstLoadNullable(BSimpleLens<T, KBPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getFirstLoad(KBPageData.Companion));
    }

    public static final <T> BNullableLens<T, KBPageStatus> getStatus(BNullableLens<T, KBPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getStatus(KBPageData.Companion));
    }

    public static final <T> BNullableLens<T, List<KBListItem>> getItems(BNullableLens<T, KBPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getItems(KBPageData.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getLimit(BNullableLens<T, KBPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getLimit(KBPageData.Companion));
    }

    public static final <T> BNullableLens<T, String> getLimitsHint(BNullableLens<T, KBPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getLimitsHint(KBPageData.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getCharLimit(BNullableLens<T, KBPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCharLimit(KBPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMToast> getToast(BNullableLens<T, KBPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getToast(KBPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KBInputBox> getInputBox(BNullableLens<T, KBPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getInputBox(KBPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KBDropList> getDropList(BNullableLens<T, KBPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getDropList(KBPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KBAlert> getAlert(BNullableLens<T, KBPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getAlert(KBPageData.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getFirstLoad(BNullableLens<T, KBPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getFirstLoad(KBPageData.Companion));
    }
}