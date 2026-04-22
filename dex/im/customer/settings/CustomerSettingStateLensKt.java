package im.customer.settings;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import im.customer.settings.CustomerSettingState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomerSettingStateLens.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"0\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"*\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"*\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00160\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001b\u001a\u0004\b\u000b\u0010\u001c\"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u0010\u0010\u001c\"@\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00120\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u0014\u0010\u001c\"@\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00160\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u0018\u0010\u001c\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010 \"H\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010 \"B\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00120\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010 \"B\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00160\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010 \"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010'\u001a\u0004\b\u000b\u0010(\"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010'\u001a\u0004\b\u0010\u0010(\"@\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00120\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010'\u001a\u0004\b\u0014\u0010(\"@\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00160\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010'\u001a\u0004\b\u0018\u0010(¨\u0006)"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/customer/settings/CustomerSettingState;", "Lim/customer/settings/CustomerSettingState$Companion;", "getLens$annotations", "(Lim/customer/settings/CustomerSettingState$Companion;)V", "getLens", "(Lim/customer/settings/CustomerSettingState$Companion;)Lcom/bilibili/blens/BSimpleLens;", "shopId", "Lim/customer/settings/CustomerShopId;", "getShopId$annotations", "getShopId", "groups", "", "Lim/customer/settings/CustomerSettingGroup;", "getGroups$annotations", "getGroups", "status", "Lim/customer/settings/CustomerSettingPageStatus;", "getStatus$annotations", "getStatus", "toast", "Lim/customer/settings/ToastHolder;", "getToast$annotations", "getToast", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "shopIdNullable$annotations", "shopIdNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "groupsNullable$annotations", "groupsNullable", "statusNullable$annotations", "statusNullable", "toastNullable$annotations", "toastNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "customer_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CustomerSettingStateLensKt {
    public static /* synthetic */ void getGroups$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getGroups$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getGroups$annotations(CustomerSettingState.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(CustomerSettingState.Companion companion) {
    }

    public static /* synthetic */ void getShopId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getShopId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getShopId$annotations(CustomerSettingState.Companion companion) {
    }

    public static /* synthetic */ void getStatus$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getStatus$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getStatus$annotations(CustomerSettingState.Companion companion) {
    }

    public static /* synthetic */ void getToast$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getToast$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getToast$annotations(CustomerSettingState.Companion companion) {
    }

    public static /* synthetic */ void groupsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void shopIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void statusNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void toastNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<CustomerSettingState, CustomerSettingState> getLens(CustomerSettingState.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<CustomerSettingState, CustomerSettingState>() { // from class: im.customer.settings.CustomerSettingStateLensKt$special$$inlined$invoke$1
            public CustomerSettingState get(CustomerSettingState customerSettingState) {
                CustomerSettingState it = customerSettingState;
                return it;
            }

            public CustomerSettingState set(CustomerSettingState customerSettingState, CustomerSettingState customerSettingState2) {
                CustomerSettingState it = customerSettingState2;
                return it;
            }

            public CustomerSettingState modify(CustomerSettingState customerSettingState, Function1<? super CustomerSettingState, ? extends CustomerSettingState> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                CustomerSettingState it = customerSettingState;
                return (CustomerSettingState) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<CustomerSettingState, CustomerShopId> getShopId(CustomerSettingState.Companion $this$shopId) {
        Intrinsics.checkNotNullParameter($this$shopId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<CustomerSettingState, CustomerShopId>() { // from class: im.customer.settings.CustomerSettingStateLensKt$special$$inlined$invoke$2
            public CustomerShopId get(CustomerSettingState customerSettingState) {
                CustomerSettingState it = customerSettingState;
                return it.getShopId();
            }

            public CustomerSettingState set(CustomerSettingState customerSettingState, CustomerShopId customerShopId) {
                CustomerShopId shopId = customerShopId;
                CustomerSettingState it = customerSettingState;
                return CustomerSettingState.copy$default(it, shopId, null, null, null, 14, null);
            }

            public CustomerSettingState modify(CustomerSettingState customerSettingState, Function1<? super CustomerShopId, ? extends CustomerShopId> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                CustomerSettingState it = customerSettingState;
                CustomerShopId shopId = (CustomerShopId) function1.invoke(it.getShopId());
                CustomerSettingState it2 = customerSettingState;
                return CustomerSettingState.copy$default(it2, shopId, null, null, null, 14, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<CustomerSettingState, List<CustomerSettingGroup>> getGroups(CustomerSettingState.Companion $this$groups) {
        Intrinsics.checkNotNullParameter($this$groups, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<CustomerSettingState, List<? extends CustomerSettingGroup>>() { // from class: im.customer.settings.CustomerSettingStateLensKt$special$$inlined$invoke$3
            public List<? extends CustomerSettingGroup> get(CustomerSettingState customerSettingState) {
                CustomerSettingState it = customerSettingState;
                return it.getGroups();
            }

            public CustomerSettingState set(CustomerSettingState customerSettingState, List<? extends CustomerSettingGroup> list) {
                List<? extends CustomerSettingGroup> groups = list;
                CustomerSettingState it = customerSettingState;
                return CustomerSettingState.copy$default(it, null, groups, null, null, 13, null);
            }

            public CustomerSettingState modify(CustomerSettingState customerSettingState, Function1<? super List<? extends CustomerSettingGroup>, ? extends List<? extends CustomerSettingGroup>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                CustomerSettingState it = customerSettingState;
                List groups = (List) function1.invoke(it.getGroups());
                CustomerSettingState it2 = customerSettingState;
                return CustomerSettingState.copy$default(it2, null, groups, null, null, 13, null);
            }
        };
    }

    public static final BSimpleLens<CustomerSettingState, CustomerSettingPageStatus> getStatus(CustomerSettingState.Companion $this$status) {
        Intrinsics.checkNotNullParameter($this$status, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<CustomerSettingState, CustomerSettingPageStatus>() { // from class: im.customer.settings.CustomerSettingStateLensKt$special$$inlined$invoke$4
            public CustomerSettingPageStatus get(CustomerSettingState customerSettingState) {
                CustomerSettingState it = customerSettingState;
                return it.getStatus();
            }

            public CustomerSettingState set(CustomerSettingState customerSettingState, CustomerSettingPageStatus customerSettingPageStatus) {
                CustomerSettingPageStatus status = customerSettingPageStatus;
                CustomerSettingState it = customerSettingState;
                return CustomerSettingState.copy$default(it, null, null, status, null, 11, null);
            }

            public CustomerSettingState modify(CustomerSettingState customerSettingState, Function1<? super CustomerSettingPageStatus, ? extends CustomerSettingPageStatus> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                CustomerSettingState it = customerSettingState;
                CustomerSettingPageStatus status = (CustomerSettingPageStatus) function1.invoke(it.getStatus());
                CustomerSettingState it2 = customerSettingState;
                return CustomerSettingState.copy$default(it2, null, null, status, null, 11, null);
            }
        };
    }

    public static final BSimpleLens<CustomerSettingState, ToastHolder> getToast(CustomerSettingState.Companion $this$toast) {
        Intrinsics.checkNotNullParameter($this$toast, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<CustomerSettingState, ToastHolder>() { // from class: im.customer.settings.CustomerSettingStateLensKt$special$$inlined$invoke$5
            public ToastHolder get(CustomerSettingState customerSettingState) {
                CustomerSettingState it = customerSettingState;
                return it.getToast();
            }

            public CustomerSettingState set(CustomerSettingState customerSettingState, ToastHolder toastHolder) {
                ToastHolder toast = toastHolder;
                CustomerSettingState it = customerSettingState;
                return CustomerSettingState.copy$default(it, null, null, null, toast, 7, null);
            }

            public CustomerSettingState modify(CustomerSettingState customerSettingState, Function1<? super ToastHolder, ? extends ToastHolder> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                CustomerSettingState it = customerSettingState;
                ToastHolder toast = (ToastHolder) function1.invoke(it.getToast());
                CustomerSettingState it2 = customerSettingState;
                return CustomerSettingState.copy$default(it2, null, null, null, toast, 7, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, CustomerShopId> getShopId(BSimpleLens<T, CustomerSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getShopId(CustomerSettingState.Companion));
    }

    public static final <T> BSimpleLens<T, List<CustomerSettingGroup>> getGroups(BSimpleLens<T, CustomerSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getGroups(CustomerSettingState.Companion));
    }

    public static final <T> BSimpleLens<T, CustomerSettingPageStatus> getStatus(BSimpleLens<T, CustomerSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getStatus(CustomerSettingState.Companion));
    }

    public static final <T> BSimpleLens<T, ToastHolder> getToast(BSimpleLens<T, CustomerSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getToast(CustomerSettingState.Companion));
    }

    public static final <T> BNullableLens<T, CustomerShopId> shopIdNullable(BSimpleLens<T, CustomerSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getShopId(CustomerSettingState.Companion));
    }

    public static final <T> BNullableLens<T, List<CustomerSettingGroup>> groupsNullable(BSimpleLens<T, CustomerSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getGroups(CustomerSettingState.Companion));
    }

    public static final <T> BNullableLens<T, CustomerSettingPageStatus> statusNullable(BSimpleLens<T, CustomerSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getStatus(CustomerSettingState.Companion));
    }

    public static final <T> BNullableLens<T, ToastHolder> toastNullable(BSimpleLens<T, CustomerSettingState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getToast(CustomerSettingState.Companion));
    }

    public static final <T> BNullableLens<T, CustomerShopId> getShopId(BNullableLens<T, CustomerSettingState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getShopId(CustomerSettingState.Companion));
    }

    public static final <T> BNullableLens<T, List<CustomerSettingGroup>> getGroups(BNullableLens<T, CustomerSettingState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getGroups(CustomerSettingState.Companion));
    }

    public static final <T> BNullableLens<T, CustomerSettingPageStatus> getStatus(BNullableLens<T, CustomerSettingState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getStatus(CustomerSettingState.Companion));
    }

    public static final <T> BNullableLens<T, ToastHolder> getToast(BNullableLens<T, CustomerSettingState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getToast(CustomerSettingState.Companion));
    }
}