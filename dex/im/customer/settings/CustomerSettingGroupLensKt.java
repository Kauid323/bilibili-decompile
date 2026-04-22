package im.customer.settings;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import im.customer.settings.CustomerSettingGroup;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomerSettingGroupLens.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"0\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0013\u001a\u0004\b\u000b\u0010\u0014\"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\t0\u0015\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u0010\u0012\u0004\u0012\u0002H\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018\"H\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0015\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u0010\u0012\u0004\u0012\u0002H\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0018\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\t0\u0015\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001b\u001a\u0004\b\u000b\u0010\u001c\"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0015\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u0010\u0010\u001c¨\u0006\u001d"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/customer/settings/CustomerSettingGroup;", "Lim/customer/settings/CustomerSettingGroup$Companion;", "getLens$annotations", "(Lim/customer/settings/CustomerSettingGroup$Companion;)V", "getLens", "(Lim/customer/settings/CustomerSettingGroup$Companion;)Lcom/bilibili/blens/BSimpleLens;", "groupId", "", "getGroupId$annotations", "getGroupId", "items", "", "Lim/customer/settings/CustomerSettingItem;", "getItems$annotations", "getItems", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "groupIdNullable$annotations", "groupIdNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "itemsNullable$annotations", "itemsNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "customer_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CustomerSettingGroupLensKt {
    public static /* synthetic */ void getGroupId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getGroupId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getGroupId$annotations(CustomerSettingGroup.Companion companion) {
    }

    public static /* synthetic */ void getItems$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getItems$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getItems$annotations(CustomerSettingGroup.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(CustomerSettingGroup.Companion companion) {
    }

    public static /* synthetic */ void groupIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void itemsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<CustomerSettingGroup, CustomerSettingGroup> getLens(CustomerSettingGroup.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<CustomerSettingGroup, CustomerSettingGroup>() { // from class: im.customer.settings.CustomerSettingGroupLensKt$special$$inlined$invoke$1
            public CustomerSettingGroup get(CustomerSettingGroup customerSettingGroup) {
                CustomerSettingGroup it = customerSettingGroup;
                return it;
            }

            public CustomerSettingGroup set(CustomerSettingGroup customerSettingGroup, CustomerSettingGroup customerSettingGroup2) {
                CustomerSettingGroup it = customerSettingGroup2;
                return it;
            }

            public CustomerSettingGroup modify(CustomerSettingGroup customerSettingGroup, Function1<? super CustomerSettingGroup, ? extends CustomerSettingGroup> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                CustomerSettingGroup it = customerSettingGroup;
                return (CustomerSettingGroup) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<CustomerSettingGroup, Integer> getGroupId(CustomerSettingGroup.Companion $this$groupId) {
        Intrinsics.checkNotNullParameter($this$groupId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<CustomerSettingGroup, Integer>() { // from class: im.customer.settings.CustomerSettingGroupLensKt$special$$inlined$invoke$2
            public Integer get(CustomerSettingGroup customerSettingGroup) {
                CustomerSettingGroup it = customerSettingGroup;
                return Integer.valueOf(it.getGroupId());
            }

            public CustomerSettingGroup set(CustomerSettingGroup customerSettingGroup, Integer num) {
                int groupId = num.intValue();
                CustomerSettingGroup it = customerSettingGroup;
                return CustomerSettingGroup.copy$default(it, groupId, null, 2, null);
            }

            public CustomerSettingGroup modify(CustomerSettingGroup customerSettingGroup, Function1<? super Integer, ? extends Integer> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                CustomerSettingGroup it = customerSettingGroup;
                int groupId = ((Number) function1.invoke(Integer.valueOf(it.getGroupId()))).intValue();
                CustomerSettingGroup it2 = customerSettingGroup;
                return CustomerSettingGroup.copy$default(it2, groupId, null, 2, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<CustomerSettingGroup, List<CustomerSettingItem>> getItems(CustomerSettingGroup.Companion $this$items) {
        Intrinsics.checkNotNullParameter($this$items, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<CustomerSettingGroup, List<? extends CustomerSettingItem>>() { // from class: im.customer.settings.CustomerSettingGroupLensKt$special$$inlined$invoke$3
            public List<? extends CustomerSettingItem> get(CustomerSettingGroup customerSettingGroup) {
                CustomerSettingGroup it = customerSettingGroup;
                return it.getItems();
            }

            public CustomerSettingGroup set(CustomerSettingGroup customerSettingGroup, List<? extends CustomerSettingItem> list) {
                List<? extends CustomerSettingItem> items = list;
                CustomerSettingGroup it = customerSettingGroup;
                return CustomerSettingGroup.copy$default(it, 0, items, 1, null);
            }

            public CustomerSettingGroup modify(CustomerSettingGroup customerSettingGroup, Function1<? super List<? extends CustomerSettingItem>, ? extends List<? extends CustomerSettingItem>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                CustomerSettingGroup it = customerSettingGroup;
                List items = (List) function1.invoke(it.getItems());
                CustomerSettingGroup it2 = customerSettingGroup;
                return CustomerSettingGroup.copy$default(it2, 0, items, 1, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, Integer> getGroupId(BSimpleLens<T, CustomerSettingGroup> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getGroupId(CustomerSettingGroup.Companion));
    }

    public static final <T> BSimpleLens<T, List<CustomerSettingItem>> getItems(BSimpleLens<T, CustomerSettingGroup> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getItems(CustomerSettingGroup.Companion));
    }

    public static final <T> BNullableLens<T, Integer> groupIdNullable(BSimpleLens<T, CustomerSettingGroup> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getGroupId(CustomerSettingGroup.Companion));
    }

    public static final <T> BNullableLens<T, List<CustomerSettingItem>> itemsNullable(BSimpleLens<T, CustomerSettingGroup> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getItems(CustomerSettingGroup.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getGroupId(BNullableLens<T, CustomerSettingGroup> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getGroupId(CustomerSettingGroup.Companion));
    }

    public static final <T> BNullableLens<T, List<CustomerSettingItem>> getItems(BNullableLens<T, CustomerSettingGroup> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getItems(CustomerSettingGroup.Companion));
    }
}