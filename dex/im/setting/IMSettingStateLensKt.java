package im.setting;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import im.base.IMRouteHolder;
import im.base.IMToast;
import im.setting.IMSettingState;
import im.setting.model.IMSettingPageData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSettingStateLens.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\",\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\",\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\",\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\",\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\"\u001a\u0004\b\u000b\u0010#\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\"\u001a\u0004\b\u000f\u0010#\"B\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\"\u001a\u0004\b\u0013\u0010#\"B\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\"\u001a\u0004\b\u0017\u0010#\"B\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0001\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\"\u001a\u0004\b\u001b\u0010#\"B\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0001\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\"\u001a\u0004\b\u001f\u0010#\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\t0$\"\b\b\u0000\u0010 *\u00020!*\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\"\u001a\u0004\b&\u0010'\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\r0$\"\b\b\u0000\u0010 *\u00020!*\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\"\u001a\u0004\b)\u0010'\"D\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u0010 *\u00020!*\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b*\u0010\"\u001a\u0004\b+\u0010#\"D\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u0010 *\u00020!*\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b,\u0010\"\u001a\u0004\b-\u0010#\"D\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0001\"\b\b\u0000\u0010 *\u00020!*\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\"\u001a\u0004\b/\u0010#\"D\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0001\"\b\b\u0000\u0010 *\u00020!*\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\"\u001a\u0004\b1\u0010#\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\t0$\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020$8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u00102\u001a\u0004\b\u000b\u00103\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\r0$\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020$8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u00102\u001a\u0004\b\u000f\u00103\"B\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020$8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0012\u00102\u001a\u0004\b\u0013\u00104\"B\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020$8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0016\u00102\u001a\u0004\b\u0017\u00104\"B\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0001\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020$8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u00102\u001a\u0004\b\u001b\u00104\"B\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u0002H \u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0001\"\b\b\u0000\u0010 *\u00020!*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u00020$8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u00102\u001a\u0004\b\u001f\u00104¨\u00065"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/setting/IMSettingState;", "Lim/setting/IMSettingState$Companion;", "getLens$annotations", "(Lim/setting/IMSettingState$Companion;)V", "getLens", "(Lim/setting/IMSettingState$Companion;)Lcom/bilibili/blens/BSimpleLens;", "type", "Lim/setting/IMSettingStateType;", "getType$annotations", "getType", UtilsKt.DATA_KEY, "Lim/setting/model/IMSettingPageData;", "getData$annotations", "getData", "toast", "Lim/base/IMToast;", "getToast$annotations", "getToast", "redirect", "Lim/base/IMRouteHolder;", "getRedirect$annotations", "getRedirect", "windowSelect", "Lim/setting/IMSettingWindowSelect;", "getWindowSelect$annotations", "getWindowSelect", "dialog", "Lim/setting/IMSettingDialog;", "getDialog$annotations", "getDialog", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "typeNullable$annotations", "typeNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "dataNullable$annotations", "dataNullable", "toastNullable$annotations", "toastNullable", "redirectNullable$annotations", "redirectNullable", "windowSelectNullable$annotations", "windowSelectNullable", "dialogNullable$annotations", "dialogNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSettingStateLensKt {
    public static /* synthetic */ void dataNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void dialogNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getData$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getData$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getData$annotations(IMSettingState.Companion companion) {
    }

    public static /* synthetic */ void getDialog$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getDialog$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getDialog$annotations(IMSettingState.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(IMSettingState.Companion companion) {
    }

    public static /* synthetic */ void getRedirect$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getRedirect$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getRedirect$annotations(IMSettingState.Companion companion) {
    }

    public static /* synthetic */ void getToast$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getToast$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getToast$annotations(IMSettingState.Companion companion) {
    }

    public static /* synthetic */ void getType$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getType$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getType$annotations(IMSettingState.Companion companion) {
    }

    public static /* synthetic */ void getWindowSelect$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getWindowSelect$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getWindowSelect$annotations(IMSettingState.Companion companion) {
    }

    public static /* synthetic */ void redirectNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void toastNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void typeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void windowSelectNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<IMSettingState, IMSettingState> getLens(IMSettingState.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSettingState, IMSettingState>() { // from class: im.setting.IMSettingStateLensKt$special$$inlined$invoke$1
            public IMSettingState get(IMSettingState iMSettingState) {
                IMSettingState it = iMSettingState;
                return it;
            }

            public IMSettingState set(IMSettingState iMSettingState, IMSettingState iMSettingState2) {
                IMSettingState it = iMSettingState2;
                return it;
            }

            public IMSettingState modify(IMSettingState iMSettingState, Function1<? super IMSettingState, ? extends IMSettingState> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSettingState it = iMSettingState;
                return (IMSettingState) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<IMSettingState, IMSettingStateType> getType(IMSettingState.Companion $this$type) {
        Intrinsics.checkNotNullParameter($this$type, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSettingState, IMSettingStateType>() { // from class: im.setting.IMSettingStateLensKt$special$$inlined$invoke$2
            public IMSettingStateType get(IMSettingState iMSettingState) {
                IMSettingState it = iMSettingState;
                return it.getType();
            }

            public IMSettingState set(IMSettingState iMSettingState, IMSettingStateType iMSettingStateType) {
                IMSettingStateType type = iMSettingStateType;
                IMSettingState it = iMSettingState;
                return IMSettingState.copy$default(it, type, null, null, null, null, null, 62, null);
            }

            public IMSettingState modify(IMSettingState iMSettingState, Function1<? super IMSettingStateType, ? extends IMSettingStateType> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSettingState it = iMSettingState;
                IMSettingStateType type = (IMSettingStateType) function1.invoke(it.getType());
                IMSettingState it2 = iMSettingState;
                return IMSettingState.copy$default(it2, type, null, null, null, null, null, 62, null);
            }
        };
    }

    public static final BSimpleLens<IMSettingState, IMSettingPageData> getData(IMSettingState.Companion $this$data) {
        Intrinsics.checkNotNullParameter($this$data, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSettingState, IMSettingPageData>() { // from class: im.setting.IMSettingStateLensKt$special$$inlined$invoke$3
            public IMSettingPageData get(IMSettingState iMSettingState) {
                IMSettingState it = iMSettingState;
                return it.getData();
            }

            public IMSettingState set(IMSettingState iMSettingState, IMSettingPageData iMSettingPageData) {
                IMSettingPageData data = iMSettingPageData;
                IMSettingState it = iMSettingState;
                return IMSettingState.copy$default(it, null, data, null, null, null, null, 61, null);
            }

            public IMSettingState modify(IMSettingState iMSettingState, Function1<? super IMSettingPageData, ? extends IMSettingPageData> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSettingState it = iMSettingState;
                IMSettingPageData data = (IMSettingPageData) function1.invoke(it.getData());
                IMSettingState it2 = iMSettingState;
                return IMSettingState.copy$default(it2, null, data, null, null, null, null, 61, null);
            }
        };
    }

    public static final BSimpleLens<IMSettingState, IMToast> getToast(IMSettingState.Companion $this$toast) {
        Intrinsics.checkNotNullParameter($this$toast, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSettingState, IMToast>() { // from class: im.setting.IMSettingStateLensKt$special$$inlined$invoke$4
            public IMToast get(IMSettingState iMSettingState) {
                IMSettingState it = iMSettingState;
                return it.getToast$logic_debug();
            }

            public IMSettingState set(IMSettingState iMSettingState, IMToast iMToast) {
                IMToast toast = iMToast;
                IMSettingState it = iMSettingState;
                return IMSettingState.copy$default(it, null, null, toast, null, null, null, 59, null);
            }

            public IMSettingState modify(IMSettingState iMSettingState, Function1<? super IMToast, ? extends IMToast> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSettingState it = iMSettingState;
                IMToast toast = (IMToast) function1.invoke(it.getToast$logic_debug());
                IMSettingState it2 = iMSettingState;
                return IMSettingState.copy$default(it2, null, null, toast, null, null, null, 59, null);
            }
        };
    }

    public static final BSimpleLens<IMSettingState, IMRouteHolder> getRedirect(IMSettingState.Companion $this$redirect) {
        Intrinsics.checkNotNullParameter($this$redirect, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSettingState, IMRouteHolder>() { // from class: im.setting.IMSettingStateLensKt$special$$inlined$invoke$5
            public IMRouteHolder get(IMSettingState iMSettingState) {
                IMSettingState it = iMSettingState;
                return it.getRedirect$logic_debug();
            }

            public IMSettingState set(IMSettingState iMSettingState, IMRouteHolder iMRouteHolder) {
                IMRouteHolder redirect = iMRouteHolder;
                IMSettingState it = iMSettingState;
                return IMSettingState.copy$default(it, null, null, null, redirect, null, null, 55, null);
            }

            public IMSettingState modify(IMSettingState iMSettingState, Function1<? super IMRouteHolder, ? extends IMRouteHolder> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSettingState it = iMSettingState;
                IMRouteHolder redirect = (IMRouteHolder) function1.invoke(it.getRedirect$logic_debug());
                IMSettingState it2 = iMSettingState;
                return IMSettingState.copy$default(it2, null, null, null, redirect, null, null, 55, null);
            }
        };
    }

    public static final BSimpleLens<IMSettingState, IMSettingWindowSelect> getWindowSelect(IMSettingState.Companion $this$windowSelect) {
        Intrinsics.checkNotNullParameter($this$windowSelect, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSettingState, IMSettingWindowSelect>() { // from class: im.setting.IMSettingStateLensKt$special$$inlined$invoke$6
            public IMSettingWindowSelect get(IMSettingState iMSettingState) {
                IMSettingState it = iMSettingState;
                return it.getWindowSelect();
            }

            public IMSettingState set(IMSettingState iMSettingState, IMSettingWindowSelect iMSettingWindowSelect) {
                IMSettingWindowSelect windowSelect = iMSettingWindowSelect;
                IMSettingState it = iMSettingState;
                return IMSettingState.copy$default(it, null, null, null, null, windowSelect, null, 47, null);
            }

            public IMSettingState modify(IMSettingState iMSettingState, Function1<? super IMSettingWindowSelect, ? extends IMSettingWindowSelect> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSettingState it = iMSettingState;
                IMSettingWindowSelect windowSelect = (IMSettingWindowSelect) function1.invoke(it.getWindowSelect());
                IMSettingState it2 = iMSettingState;
                return IMSettingState.copy$default(it2, null, null, null, null, windowSelect, null, 47, null);
            }
        };
    }

    public static final BSimpleLens<IMSettingState, IMSettingDialog> getDialog(IMSettingState.Companion $this$dialog) {
        Intrinsics.checkNotNullParameter($this$dialog, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMSettingState, IMSettingDialog>() { // from class: im.setting.IMSettingStateLensKt$special$$inlined$invoke$7
            public IMSettingDialog get(IMSettingState iMSettingState) {
                IMSettingState it = iMSettingState;
                return it.getDialog();
            }

            public IMSettingState set(IMSettingState iMSettingState, IMSettingDialog iMSettingDialog) {
                IMSettingDialog dialog = iMSettingDialog;
                IMSettingState it = iMSettingState;
                return IMSettingState.copy$default(it, null, null, null, null, null, dialog, 31, null);
            }

            public IMSettingState modify(IMSettingState iMSettingState, Function1<? super IMSettingDialog, ? extends IMSettingDialog> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMSettingState it = iMSettingState;
                IMSettingDialog dialog = (IMSettingDialog) function1.invoke(it.getDialog());
                IMSettingState it2 = iMSettingState;
                return IMSettingState.copy$default(it2, null, null, null, null, null, dialog, 31, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, IMSettingStateType> getType(BSimpleLens<T, IMSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getType(IMSettingState.Companion));
    }

    public static final <T> BSimpleLens<T, IMSettingPageData> getData(BSimpleLens<T, IMSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getData(IMSettingState.Companion));
    }

    public static final <T> BSimpleLens<T, IMToast> getToast(BSimpleLens<T, IMSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getToast(IMSettingState.Companion));
    }

    public static final <T> BSimpleLens<T, IMRouteHolder> getRedirect(BSimpleLens<T, IMSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getRedirect(IMSettingState.Companion));
    }

    public static final <T> BSimpleLens<T, IMSettingWindowSelect> getWindowSelect(BSimpleLens<T, IMSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getWindowSelect(IMSettingState.Companion));
    }

    public static final <T> BSimpleLens<T, IMSettingDialog> getDialog(BSimpleLens<T, IMSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getDialog(IMSettingState.Companion));
    }

    public static final <T> BNullableLens<T, IMSettingStateType> typeNullable(BSimpleLens<T, IMSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getType(IMSettingState.Companion));
    }

    public static final <T> BNullableLens<T, IMSettingPageData> dataNullable(BSimpleLens<T, IMSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getData(IMSettingState.Companion));
    }

    public static final <T> BSimpleLens<T, IMToast> toastNullable(BSimpleLens<T, IMSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getToast(IMSettingState.Companion));
    }

    public static final <T> BSimpleLens<T, IMRouteHolder> redirectNullable(BSimpleLens<T, IMSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getRedirect(IMSettingState.Companion));
    }

    public static final <T> BSimpleLens<T, IMSettingWindowSelect> windowSelectNullable(BSimpleLens<T, IMSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getWindowSelect(IMSettingState.Companion));
    }

    public static final <T> BSimpleLens<T, IMSettingDialog> dialogNullable(BSimpleLens<T, IMSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getDialog(IMSettingState.Companion));
    }

    public static final <T> BNullableLens<T, IMSettingStateType> getType(BNullableLens<T, IMSettingState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getType(IMSettingState.Companion));
    }

    public static final <T> BNullableLens<T, IMSettingPageData> getData(BNullableLens<T, IMSettingState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getData(IMSettingState.Companion));
    }

    public static final <T> BSimpleLens<T, IMToast> getToast(BNullableLens<T, IMSettingState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getToast(IMSettingState.Companion));
    }

    public static final <T> BSimpleLens<T, IMRouteHolder> getRedirect(BNullableLens<T, IMSettingState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getRedirect(IMSettingState.Companion));
    }

    public static final <T> BSimpleLens<T, IMSettingWindowSelect> getWindowSelect(BNullableLens<T, IMSettingState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getWindowSelect(IMSettingState.Companion));
    }

    public static final <T> BSimpleLens<T, IMSettingDialog> getDialog(BNullableLens<T, IMSettingState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getDialog(IMSettingState.Companion));
    }
}