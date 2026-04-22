package im.session;

import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import im.base.IMToast;
import im.session.IMState;
import im.session.model.IMSessionCard;
import im.session.model.IMSessionPageData;
import im.session.track.IMSessionLoadTimeTrack;
import im.setting.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMStateLens.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\",\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"*\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"*\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00180\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007\",\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007\"*\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007\"*\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#0\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010&*\u00020'*\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010(\u001a\u0004\b\u000b\u0010)\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010&*\u00020'*\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010(\u001a\u0004\b\u000f\u0010)\"B\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H&\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u0010&*\u00020'*\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010(\u001a\u0004\b\u0013\u0010)\"@\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00150\u0001\"\b\b\u0000\u0010&*\u00020'*\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010(\u001a\u0004\b\u0014\u0010)\"@\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00180\u0001\"\b\b\u0000\u0010&*\u00020'*\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010(\u001a\u0004\b\u001a\u0010)\"B\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u0002H&\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0001\"\b\b\u0000\u0010&*\u00020'*\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010(\u001a\u0004\b\u001e\u0010)\"@\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00150\u0001\"\b\b\u0000\u0010&*\u00020'*\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b \u0010(\u001a\u0004\b!\u0010)\"@\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020#0\u0001\"\b\b\u0000\u0010&*\u00020'*\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b$\u0010(\u001a\u0004\b%\u0010)\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\t0*\"\b\b\u0000\u0010&*\u00020'*\u0010\u0012\u0004\u0012\u0002H&\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010(\u001a\u0004\b,\u0010-\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\r0*\"\b\b\u0000\u0010&*\u00020'*\u0010\u0012\u0004\u0012\u0002H&\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010(\u001a\u0004\b/\u0010-\"D\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H&\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u0010&*\u00020'*\u0010\u0012\u0004\u0012\u0002H&\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010(\u001a\u0004\b1\u0010)\"B\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00150*\"\b\b\u0000\u0010&*\u00020'*\u0010\u0012\u0004\u0012\u0002H&\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010(\u001a\u0004\b3\u0010-\"B\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00180*\"\b\b\u0000\u0010&*\u00020'*\u0010\u0012\u0004\u0012\u0002H&\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b4\u0010(\u001a\u0004\b5\u0010-\"D\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u0002H&\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0001\"\b\b\u0000\u0010&*\u00020'*\u0010\u0012\u0004\u0012\u0002H&\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b6\u0010(\u001a\u0004\b7\u0010)\"B\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00150*\"\b\b\u0000\u0010&*\u00020'*\u0010\u0012\u0004\u0012\u0002H&\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b8\u0010(\u001a\u0004\b9\u0010-\"B\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020#0*\"\b\b\u0000\u0010&*\u00020'*\u0010\u0012\u0004\u0012\u0002H&\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b:\u0010(\u001a\u0004\b;\u0010-\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\t0*\"\b\b\u0000\u0010&*\u00020'*\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00020*8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010<\u001a\u0004\b\u000b\u0010=\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\r0*\"\b\b\u0000\u0010&*\u00020'*\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00020*8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010<\u001a\u0004\b\u000f\u0010=\"B\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H&\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u0010&*\u00020'*\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00020*8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010<\u001a\u0004\b\u0013\u0010>\"@\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00150*\"\b\b\u0000\u0010&*\u00020'*\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00020*8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010<\u001a\u0004\b\u0014\u0010=\"@\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00180*\"\b\b\u0000\u0010&*\u00020'*\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00020*8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010<\u001a\u0004\b\u001a\u0010=\"B\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u0002H&\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0001\"\b\b\u0000\u0010&*\u00020'*\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00020*8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010<\u001a\u0004\b\u001e\u0010>\"@\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00150*\"\b\b\u0000\u0010&*\u00020'*\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00020*8@X\u0081\u0004¢\u0006\f\u0012\u0004\b \u0010<\u001a\u0004\b!\u0010=\"@\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020#0*\"\b\b\u0000\u0010&*\u00020'*\u000e\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00020*8@X\u0081\u0004¢\u0006\f\u0012\u0004\b$\u0010<\u001a\u0004\b%\u0010=¨\u0006?"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/session/IMState;", "Lim/session/IMState$Companion;", "getLens$annotations", "(Lim/session/IMState$Companion;)V", "getLens", "(Lim/session/IMState$Companion;)Lcom/bilibili/blens/BSimpleLens;", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "getPageType$annotations", "getPageType", UtilsKt.DATA_KEY, "Lim/session/model/IMSessionPageData;", "getData$annotations", "getData", "toast", "Lim/base/IMToast;", "getToast$annotations", "getToast", "isLoggedIn", "", "isLoggedIn$annotations", "type", "Lim/session/RequestStatus;", "getType$annotations", "getType", "clickedSession", "Lim/session/model/IMSessionCard;", "getClickedSession$annotations", "getClickedSession", "firstLoad", "getFirstLoad$annotations", "getFirstLoad", "techTrack", "Lim/session/track/IMSessionLoadTimeTrack;", "getTechTrack$annotations", "getTechTrack", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "pageTypeNullable$annotations", "pageTypeNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "dataNullable$annotations", "dataNullable", "toastNullable$annotations", "toastNullable", "isLoggedInNullable$annotations", "isLoggedInNullable", "typeNullable$annotations", "typeNullable", "clickedSessionNullable$annotations", "clickedSessionNullable", "firstLoadNullable$annotations", "firstLoadNullable", "techTrackNullable$annotations", "techTrackNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMStateLensKt {
    public static /* synthetic */ void clickedSessionNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void dataNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void firstLoadNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getClickedSession$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getClickedSession$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getClickedSession$annotations(IMState.Companion companion) {
    }

    public static /* synthetic */ void getData$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getData$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getData$annotations(IMState.Companion companion) {
    }

    public static /* synthetic */ void getFirstLoad$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getFirstLoad$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getFirstLoad$annotations(IMState.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(IMState.Companion companion) {
    }

    public static /* synthetic */ void getPageType$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPageType$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPageType$annotations(IMState.Companion companion) {
    }

    public static /* synthetic */ void getTechTrack$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTechTrack$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTechTrack$annotations(IMState.Companion companion) {
    }

    public static /* synthetic */ void getToast$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getToast$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getToast$annotations(IMState.Companion companion) {
    }

    public static /* synthetic */ void getType$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getType$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getType$annotations(IMState.Companion companion) {
    }

    public static /* synthetic */ void isLoggedIn$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void isLoggedIn$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void isLoggedIn$annotations(IMState.Companion companion) {
    }

    public static /* synthetic */ void isLoggedInNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void pageTypeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void techTrackNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void toastNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void typeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<IMState, IMState> getLens(IMState.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMState, IMState>() { // from class: im.session.IMStateLensKt$special$$inlined$invoke$1
            public IMState get(IMState iMState) {
                IMState it = iMState;
                return it;
            }

            public IMState set(IMState iMState, IMState iMState2) {
                IMState it = iMState2;
                return it;
            }

            public IMState modify(IMState iMState, Function1<? super IMState, ? extends IMState> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMState it = iMState;
                return (IMState) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<IMState, KSessionPageType> getPageType(IMState.Companion $this$pageType) {
        Intrinsics.checkNotNullParameter($this$pageType, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMState, KSessionPageType>() { // from class: im.session.IMStateLensKt$special$$inlined$invoke$2
            public KSessionPageType get(IMState iMState) {
                IMState it = iMState;
                return it.getPageType();
            }

            public IMState set(IMState iMState, KSessionPageType kSessionPageType) {
                IMState copy;
                KSessionPageType pageType = kSessionPageType;
                IMState it = iMState;
                copy = it.copy((r18 & 1) != 0 ? it.pageType : pageType, (r18 & 2) != 0 ? it.data : null, (r18 & 4) != 0 ? it.toast : null, (r18 & 8) != 0 ? it.isLoggedIn : false, (r18 & 16) != 0 ? it.type : null, (r18 & 32) != 0 ? it.clickedSession : null, (r18 & 64) != 0 ? it.firstLoad : false, (r18 & 128) != 0 ? it.techTrack : null);
                return copy;
            }

            public IMState modify(IMState iMState, Function1<? super KSessionPageType, ? extends KSessionPageType> function1) {
                IMState copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                IMState it = iMState;
                KSessionPageType pageType = (KSessionPageType) function1.invoke(it.getPageType());
                IMState it2 = iMState;
                copy = it2.copy((r18 & 1) != 0 ? it2.pageType : pageType, (r18 & 2) != 0 ? it2.data : null, (r18 & 4) != 0 ? it2.toast : null, (r18 & 8) != 0 ? it2.isLoggedIn : false, (r18 & 16) != 0 ? it2.type : null, (r18 & 32) != 0 ? it2.clickedSession : null, (r18 & 64) != 0 ? it2.firstLoad : false, (r18 & 128) != 0 ? it2.techTrack : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<IMState, IMSessionPageData> getData(IMState.Companion $this$data) {
        Intrinsics.checkNotNullParameter($this$data, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMState, IMSessionPageData>() { // from class: im.session.IMStateLensKt$special$$inlined$invoke$3
            public IMSessionPageData get(IMState iMState) {
                IMState it = iMState;
                return it.getData();
            }

            public IMState set(IMState iMState, IMSessionPageData iMSessionPageData) {
                IMState copy;
                IMSessionPageData data = iMSessionPageData;
                IMState it = iMState;
                copy = it.copy((r18 & 1) != 0 ? it.pageType : null, (r18 & 2) != 0 ? it.data : data, (r18 & 4) != 0 ? it.toast : null, (r18 & 8) != 0 ? it.isLoggedIn : false, (r18 & 16) != 0 ? it.type : null, (r18 & 32) != 0 ? it.clickedSession : null, (r18 & 64) != 0 ? it.firstLoad : false, (r18 & 128) != 0 ? it.techTrack : null);
                return copy;
            }

            public IMState modify(IMState iMState, Function1<? super IMSessionPageData, ? extends IMSessionPageData> function1) {
                IMState copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                IMState it = iMState;
                IMSessionPageData data = (IMSessionPageData) function1.invoke(it.getData());
                IMState it2 = iMState;
                copy = it2.copy((r18 & 1) != 0 ? it2.pageType : null, (r18 & 2) != 0 ? it2.data : data, (r18 & 4) != 0 ? it2.toast : null, (r18 & 8) != 0 ? it2.isLoggedIn : false, (r18 & 16) != 0 ? it2.type : null, (r18 & 32) != 0 ? it2.clickedSession : null, (r18 & 64) != 0 ? it2.firstLoad : false, (r18 & 128) != 0 ? it2.techTrack : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<IMState, IMToast> getToast(IMState.Companion $this$toast) {
        Intrinsics.checkNotNullParameter($this$toast, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMState, IMToast>() { // from class: im.session.IMStateLensKt$special$$inlined$invoke$4
            public IMToast get(IMState iMState) {
                IMState it = iMState;
                return it.getToast();
            }

            public IMState set(IMState iMState, IMToast iMToast) {
                IMState copy;
                IMToast toast = iMToast;
                IMState it = iMState;
                copy = it.copy((r18 & 1) != 0 ? it.pageType : null, (r18 & 2) != 0 ? it.data : null, (r18 & 4) != 0 ? it.toast : toast, (r18 & 8) != 0 ? it.isLoggedIn : false, (r18 & 16) != 0 ? it.type : null, (r18 & 32) != 0 ? it.clickedSession : null, (r18 & 64) != 0 ? it.firstLoad : false, (r18 & 128) != 0 ? it.techTrack : null);
                return copy;
            }

            public IMState modify(IMState iMState, Function1<? super IMToast, ? extends IMToast> function1) {
                IMState copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                IMState it = iMState;
                IMToast toast = (IMToast) function1.invoke(it.getToast());
                IMState it2 = iMState;
                copy = it2.copy((r18 & 1) != 0 ? it2.pageType : null, (r18 & 2) != 0 ? it2.data : null, (r18 & 4) != 0 ? it2.toast : toast, (r18 & 8) != 0 ? it2.isLoggedIn : false, (r18 & 16) != 0 ? it2.type : null, (r18 & 32) != 0 ? it2.clickedSession : null, (r18 & 64) != 0 ? it2.firstLoad : false, (r18 & 128) != 0 ? it2.techTrack : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<IMState, Boolean> isLoggedIn(IMState.Companion $this$isLoggedIn) {
        Intrinsics.checkNotNullParameter($this$isLoggedIn, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMState, Boolean>() { // from class: im.session.IMStateLensKt$special$$inlined$invoke$5
            public Boolean get(IMState iMState) {
                IMState it = iMState;
                return Boolean.valueOf(it.isLoggedIn());
            }

            public IMState set(IMState iMState, Boolean bool) {
                IMState copy;
                boolean isLoggedIn = bool.booleanValue();
                IMState it = iMState;
                copy = it.copy((r18 & 1) != 0 ? it.pageType : null, (r18 & 2) != 0 ? it.data : null, (r18 & 4) != 0 ? it.toast : null, (r18 & 8) != 0 ? it.isLoggedIn : isLoggedIn, (r18 & 16) != 0 ? it.type : null, (r18 & 32) != 0 ? it.clickedSession : null, (r18 & 64) != 0 ? it.firstLoad : false, (r18 & 128) != 0 ? it.techTrack : null);
                return copy;
            }

            public IMState modify(IMState iMState, Function1<? super Boolean, ? extends Boolean> function1) {
                IMState copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                IMState it = iMState;
                boolean isLoggedIn = ((Boolean) function1.invoke(Boolean.valueOf(it.isLoggedIn()))).booleanValue();
                IMState it2 = iMState;
                copy = it2.copy((r18 & 1) != 0 ? it2.pageType : null, (r18 & 2) != 0 ? it2.data : null, (r18 & 4) != 0 ? it2.toast : null, (r18 & 8) != 0 ? it2.isLoggedIn : isLoggedIn, (r18 & 16) != 0 ? it2.type : null, (r18 & 32) != 0 ? it2.clickedSession : null, (r18 & 64) != 0 ? it2.firstLoad : false, (r18 & 128) != 0 ? it2.techTrack : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<IMState, RequestStatus> getType(IMState.Companion $this$type) {
        Intrinsics.checkNotNullParameter($this$type, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMState, RequestStatus>() { // from class: im.session.IMStateLensKt$special$$inlined$invoke$6
            public RequestStatus get(IMState iMState) {
                IMState it = iMState;
                return it.getType$session_debug();
            }

            public IMState set(IMState iMState, RequestStatus requestStatus) {
                IMState copy;
                RequestStatus type = requestStatus;
                IMState it = iMState;
                copy = it.copy((r18 & 1) != 0 ? it.pageType : null, (r18 & 2) != 0 ? it.data : null, (r18 & 4) != 0 ? it.toast : null, (r18 & 8) != 0 ? it.isLoggedIn : false, (r18 & 16) != 0 ? it.type : type, (r18 & 32) != 0 ? it.clickedSession : null, (r18 & 64) != 0 ? it.firstLoad : false, (r18 & 128) != 0 ? it.techTrack : null);
                return copy;
            }

            public IMState modify(IMState iMState, Function1<? super RequestStatus, ? extends RequestStatus> function1) {
                IMState copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                IMState it = iMState;
                RequestStatus type = (RequestStatus) function1.invoke(it.getType$session_debug());
                IMState it2 = iMState;
                copy = it2.copy((r18 & 1) != 0 ? it2.pageType : null, (r18 & 2) != 0 ? it2.data : null, (r18 & 4) != 0 ? it2.toast : null, (r18 & 8) != 0 ? it2.isLoggedIn : false, (r18 & 16) != 0 ? it2.type : type, (r18 & 32) != 0 ? it2.clickedSession : null, (r18 & 64) != 0 ? it2.firstLoad : false, (r18 & 128) != 0 ? it2.techTrack : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<IMState, IMSessionCard> getClickedSession(IMState.Companion $this$clickedSession) {
        Intrinsics.checkNotNullParameter($this$clickedSession, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMState, IMSessionCard>() { // from class: im.session.IMStateLensKt$special$$inlined$invoke$7
            public IMSessionCard get(IMState iMState) {
                IMState it = iMState;
                return it.getClickedSession();
            }

            public IMState set(IMState iMState, IMSessionCard iMSessionCard) {
                IMState copy;
                IMSessionCard clickedSession = iMSessionCard;
                IMState it = iMState;
                copy = it.copy((r18 & 1) != 0 ? it.pageType : null, (r18 & 2) != 0 ? it.data : null, (r18 & 4) != 0 ? it.toast : null, (r18 & 8) != 0 ? it.isLoggedIn : false, (r18 & 16) != 0 ? it.type : null, (r18 & 32) != 0 ? it.clickedSession : clickedSession, (r18 & 64) != 0 ? it.firstLoad : false, (r18 & 128) != 0 ? it.techTrack : null);
                return copy;
            }

            public IMState modify(IMState iMState, Function1<? super IMSessionCard, ? extends IMSessionCard> function1) {
                IMState copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                IMState it = iMState;
                IMSessionCard clickedSession = (IMSessionCard) function1.invoke(it.getClickedSession());
                IMState it2 = iMState;
                copy = it2.copy((r18 & 1) != 0 ? it2.pageType : null, (r18 & 2) != 0 ? it2.data : null, (r18 & 4) != 0 ? it2.toast : null, (r18 & 8) != 0 ? it2.isLoggedIn : false, (r18 & 16) != 0 ? it2.type : null, (r18 & 32) != 0 ? it2.clickedSession : clickedSession, (r18 & 64) != 0 ? it2.firstLoad : false, (r18 & 128) != 0 ? it2.techTrack : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<IMState, Boolean> getFirstLoad(IMState.Companion $this$firstLoad) {
        Intrinsics.checkNotNullParameter($this$firstLoad, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMState, Boolean>() { // from class: im.session.IMStateLensKt$special$$inlined$invoke$8
            public Boolean get(IMState iMState) {
                IMState it = iMState;
                return Boolean.valueOf(it.getFirstLoad$session_debug());
            }

            public IMState set(IMState iMState, Boolean bool) {
                IMState copy;
                boolean firstLoad = bool.booleanValue();
                IMState it = iMState;
                copy = it.copy((r18 & 1) != 0 ? it.pageType : null, (r18 & 2) != 0 ? it.data : null, (r18 & 4) != 0 ? it.toast : null, (r18 & 8) != 0 ? it.isLoggedIn : false, (r18 & 16) != 0 ? it.type : null, (r18 & 32) != 0 ? it.clickedSession : null, (r18 & 64) != 0 ? it.firstLoad : firstLoad, (r18 & 128) != 0 ? it.techTrack : null);
                return copy;
            }

            public IMState modify(IMState iMState, Function1<? super Boolean, ? extends Boolean> function1) {
                IMState copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                IMState it = iMState;
                boolean firstLoad = ((Boolean) function1.invoke(Boolean.valueOf(it.getFirstLoad$session_debug()))).booleanValue();
                IMState it2 = iMState;
                copy = it2.copy((r18 & 1) != 0 ? it2.pageType : null, (r18 & 2) != 0 ? it2.data : null, (r18 & 4) != 0 ? it2.toast : null, (r18 & 8) != 0 ? it2.isLoggedIn : false, (r18 & 16) != 0 ? it2.type : null, (r18 & 32) != 0 ? it2.clickedSession : null, (r18 & 64) != 0 ? it2.firstLoad : firstLoad, (r18 & 128) != 0 ? it2.techTrack : null);
                return copy;
            }
        };
    }

    public static final BSimpleLens<IMState, IMSessionLoadTimeTrack> getTechTrack(IMState.Companion $this$techTrack) {
        Intrinsics.checkNotNullParameter($this$techTrack, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMState, IMSessionLoadTimeTrack>() { // from class: im.session.IMStateLensKt$special$$inlined$invoke$9
            public IMSessionLoadTimeTrack get(IMState iMState) {
                IMState it = iMState;
                return it.getTechTrack$session_debug();
            }

            public IMState set(IMState iMState, IMSessionLoadTimeTrack iMSessionLoadTimeTrack) {
                IMState copy;
                IMSessionLoadTimeTrack techTrack = iMSessionLoadTimeTrack;
                IMState it = iMState;
                copy = it.copy((r18 & 1) != 0 ? it.pageType : null, (r18 & 2) != 0 ? it.data : null, (r18 & 4) != 0 ? it.toast : null, (r18 & 8) != 0 ? it.isLoggedIn : false, (r18 & 16) != 0 ? it.type : null, (r18 & 32) != 0 ? it.clickedSession : null, (r18 & 64) != 0 ? it.firstLoad : false, (r18 & 128) != 0 ? it.techTrack : techTrack);
                return copy;
            }

            public IMState modify(IMState iMState, Function1<? super IMSessionLoadTimeTrack, ? extends IMSessionLoadTimeTrack> function1) {
                IMState copy;
                Intrinsics.checkNotNullParameter(function1, "map");
                IMState it = iMState;
                IMSessionLoadTimeTrack techTrack = (IMSessionLoadTimeTrack) function1.invoke(it.getTechTrack$session_debug());
                IMState it2 = iMState;
                copy = it2.copy((r18 & 1) != 0 ? it2.pageType : null, (r18 & 2) != 0 ? it2.data : null, (r18 & 4) != 0 ? it2.toast : null, (r18 & 8) != 0 ? it2.isLoggedIn : false, (r18 & 16) != 0 ? it2.type : null, (r18 & 32) != 0 ? it2.clickedSession : null, (r18 & 64) != 0 ? it2.firstLoad : false, (r18 & 128) != 0 ? it2.techTrack : techTrack);
                return copy;
            }
        };
    }

    public static final <T> BSimpleLens<T, KSessionPageType> getPageType(BSimpleLens<T, IMState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getPageType(IMState.Companion));
    }

    public static final <T> BSimpleLens<T, IMSessionPageData> getData(BSimpleLens<T, IMState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getData(IMState.Companion));
    }

    public static final <T> BSimpleLens<T, IMToast> getToast(BSimpleLens<T, IMState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getToast(IMState.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> isLoggedIn(BSimpleLens<T, IMState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, isLoggedIn(IMState.Companion));
    }

    public static final <T> BSimpleLens<T, RequestStatus> getType(BSimpleLens<T, IMState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getType(IMState.Companion));
    }

    public static final <T> BSimpleLens<T, IMSessionCard> getClickedSession(BSimpleLens<T, IMState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getClickedSession(IMState.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getFirstLoad(BSimpleLens<T, IMState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getFirstLoad(IMState.Companion));
    }

    public static final <T> BSimpleLens<T, IMSessionLoadTimeTrack> getTechTrack(BSimpleLens<T, IMState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTechTrack(IMState.Companion));
    }

    public static final <T> BNullableLens<T, KSessionPageType> pageTypeNullable(BSimpleLens<T, IMState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getPageType(IMState.Companion));
    }

    public static final <T> BNullableLens<T, IMSessionPageData> dataNullable(BSimpleLens<T, IMState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getData(IMState.Companion));
    }

    public static final <T> BSimpleLens<T, IMToast> toastNullable(BSimpleLens<T, IMState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getToast(IMState.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isLoggedInNullable(BSimpleLens<T, IMState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, isLoggedIn(IMState.Companion));
    }

    public static final <T> BNullableLens<T, RequestStatus> typeNullable(BSimpleLens<T, IMState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getType(IMState.Companion));
    }

    public static final <T> BSimpleLens<T, IMSessionCard> clickedSessionNullable(BSimpleLens<T, IMState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getClickedSession(IMState.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> firstLoadNullable(BSimpleLens<T, IMState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getFirstLoad(IMState.Companion));
    }

    public static final <T> BNullableLens<T, IMSessionLoadTimeTrack> techTrackNullable(BSimpleLens<T, IMState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTechTrack(IMState.Companion));
    }

    public static final <T> BNullableLens<T, KSessionPageType> getPageType(BNullableLens<T, IMState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getPageType(IMState.Companion));
    }

    public static final <T> BNullableLens<T, IMSessionPageData> getData(BNullableLens<T, IMState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getData(IMState.Companion));
    }

    public static final <T> BSimpleLens<T, IMToast> getToast(BNullableLens<T, IMState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getToast(IMState.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> isLoggedIn(BNullableLens<T, IMState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, isLoggedIn(IMState.Companion));
    }

    public static final <T> BNullableLens<T, RequestStatus> getType(BNullableLens<T, IMState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getType(IMState.Companion));
    }

    public static final <T> BSimpleLens<T, IMSessionCard> getClickedSession(BNullableLens<T, IMState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getClickedSession(IMState.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getFirstLoad(BNullableLens<T, IMState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getFirstLoad(IMState.Companion));
    }

    public static final <T> BNullableLens<T, IMSessionLoadTimeTrack> getTechTrack(BNullableLens<T, IMState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTechTrack(IMState.Companion));
    }
}