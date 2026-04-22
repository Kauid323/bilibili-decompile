package im.customer.settings;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import im.customer.settings.CustomerSettingItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomerSettingItemLens.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0016\u001a\u0004\b\u000b\u0010\u0017\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u000f\u0010\u0017\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00110\u0001\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0013\u0010\u0017\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\t0\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u001b\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\r0\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u001b\"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00110\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u0010\u0012\u0004\u0012\u0002H\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u001b\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\t0\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00188FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010 \u001a\u0004\b\u000b\u0010!\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\r0\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00188FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010 \u001a\u0004\b\u000f\u0010!\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00110\u0018\"\b\b\u0000\u0010\u0014*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00020\u00188FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010 \u001a\u0004\b\u0013\u0010!¨\u0006\""}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/customer/settings/CustomerSettingItem;", "Lim/customer/settings/CustomerSettingItem$Companion;", "getLens$annotations", "(Lim/customer/settings/CustomerSettingItem$Companion;)V", "getLens", "(Lim/customer/settings/CustomerSettingItem$Companion;)Lcom/bilibili/blens/BSimpleLens;", "groupId", "", "getGroupId$annotations", "getGroupId", "type", "Lim/customer/settings/CustomerSettingType;", "getType$annotations", "getType", "button", "Lim/customer/settings/ICustomerSettingButton;", "getButton$annotations", "getButton", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "groupIdNullable$annotations", "groupIdNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "typeNullable$annotations", "typeNullable", "buttonNullable$annotations", "buttonNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "customer_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CustomerSettingItemLensKt {
    public static /* synthetic */ void buttonNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getButton$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getButton$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getButton$annotations(CustomerSettingItem.Companion companion) {
    }

    public static /* synthetic */ void getGroupId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getGroupId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getGroupId$annotations(CustomerSettingItem.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(CustomerSettingItem.Companion companion) {
    }

    public static /* synthetic */ void getType$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getType$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getType$annotations(CustomerSettingItem.Companion companion) {
    }

    public static /* synthetic */ void groupIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void typeNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<CustomerSettingItem, CustomerSettingItem> getLens(CustomerSettingItem.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<CustomerSettingItem, CustomerSettingItem>() { // from class: im.customer.settings.CustomerSettingItemLensKt$special$$inlined$invoke$1
            public CustomerSettingItem get(CustomerSettingItem customerSettingItem) {
                CustomerSettingItem it = customerSettingItem;
                return it;
            }

            public CustomerSettingItem set(CustomerSettingItem customerSettingItem, CustomerSettingItem customerSettingItem2) {
                CustomerSettingItem it = customerSettingItem2;
                return it;
            }

            public CustomerSettingItem modify(CustomerSettingItem customerSettingItem, Function1<? super CustomerSettingItem, ? extends CustomerSettingItem> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                CustomerSettingItem it = customerSettingItem;
                return (CustomerSettingItem) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<CustomerSettingItem, Integer> getGroupId(CustomerSettingItem.Companion $this$groupId) {
        Intrinsics.checkNotNullParameter($this$groupId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<CustomerSettingItem, Integer>() { // from class: im.customer.settings.CustomerSettingItemLensKt$special$$inlined$invoke$2
            public Integer get(CustomerSettingItem customerSettingItem) {
                CustomerSettingItem it = customerSettingItem;
                return Integer.valueOf(it.getGroupId());
            }

            public CustomerSettingItem set(CustomerSettingItem customerSettingItem, Integer num) {
                int groupId = num.intValue();
                CustomerSettingItem it = customerSettingItem;
                return CustomerSettingItem.copy$default(it, groupId, null, null, 6, null);
            }

            public CustomerSettingItem modify(CustomerSettingItem customerSettingItem, Function1<? super Integer, ? extends Integer> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                CustomerSettingItem it = customerSettingItem;
                int groupId = ((Number) function1.invoke(Integer.valueOf(it.getGroupId()))).intValue();
                CustomerSettingItem it2 = customerSettingItem;
                return CustomerSettingItem.copy$default(it2, groupId, null, null, 6, null);
            }
        };
    }

    public static final BSimpleLens<CustomerSettingItem, CustomerSettingType> getType(CustomerSettingItem.Companion $this$type) {
        Intrinsics.checkNotNullParameter($this$type, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<CustomerSettingItem, CustomerSettingType>() { // from class: im.customer.settings.CustomerSettingItemLensKt$special$$inlined$invoke$3
            public CustomerSettingType get(CustomerSettingItem customerSettingItem) {
                CustomerSettingItem it = customerSettingItem;
                return it.getType();
            }

            public CustomerSettingItem set(CustomerSettingItem customerSettingItem, CustomerSettingType customerSettingType) {
                CustomerSettingType type = customerSettingType;
                CustomerSettingItem it = customerSettingItem;
                return CustomerSettingItem.copy$default(it, 0, type, null, 5, null);
            }

            public CustomerSettingItem modify(CustomerSettingItem customerSettingItem, Function1<? super CustomerSettingType, ? extends CustomerSettingType> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                CustomerSettingItem it = customerSettingItem;
                CustomerSettingType type = (CustomerSettingType) function1.invoke(it.getType());
                CustomerSettingItem it2 = customerSettingItem;
                return CustomerSettingItem.copy$default(it2, 0, type, null, 5, null);
            }
        };
    }

    public static final BSimpleLens<CustomerSettingItem, ICustomerSettingButton> getButton(CustomerSettingItem.Companion $this$button) {
        Intrinsics.checkNotNullParameter($this$button, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<CustomerSettingItem, ICustomerSettingButton>() { // from class: im.customer.settings.CustomerSettingItemLensKt$special$$inlined$invoke$4
            public ICustomerSettingButton get(CustomerSettingItem customerSettingItem) {
                CustomerSettingItem it = customerSettingItem;
                return it.getButton();
            }

            public CustomerSettingItem set(CustomerSettingItem customerSettingItem, ICustomerSettingButton iCustomerSettingButton) {
                ICustomerSettingButton button = iCustomerSettingButton;
                CustomerSettingItem it = customerSettingItem;
                return CustomerSettingItem.copy$default(it, 0, null, button, 3, null);
            }

            public CustomerSettingItem modify(CustomerSettingItem customerSettingItem, Function1<? super ICustomerSettingButton, ? extends ICustomerSettingButton> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                CustomerSettingItem it = customerSettingItem;
                ICustomerSettingButton button = (ICustomerSettingButton) function1.invoke(it.getButton());
                CustomerSettingItem it2 = customerSettingItem;
                return CustomerSettingItem.copy$default(it2, 0, null, button, 3, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, Integer> getGroupId(BSimpleLens<T, CustomerSettingItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getGroupId(CustomerSettingItem.Companion));
    }

    public static final <T> BSimpleLens<T, CustomerSettingType> getType(BSimpleLens<T, CustomerSettingItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getType(CustomerSettingItem.Companion));
    }

    public static final <T> BSimpleLens<T, ICustomerSettingButton> getButton(BSimpleLens<T, CustomerSettingItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getButton(CustomerSettingItem.Companion));
    }

    public static final <T> BNullableLens<T, Integer> groupIdNullable(BSimpleLens<T, CustomerSettingItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getGroupId(CustomerSettingItem.Companion));
    }

    public static final <T> BNullableLens<T, CustomerSettingType> typeNullable(BSimpleLens<T, CustomerSettingItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getType(CustomerSettingItem.Companion));
    }

    public static final <T> BNullableLens<T, ICustomerSettingButton> buttonNullable(BSimpleLens<T, CustomerSettingItem> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getButton(CustomerSettingItem.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getGroupId(BNullableLens<T, CustomerSettingItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getGroupId(CustomerSettingItem.Companion));
    }

    public static final <T> BNullableLens<T, CustomerSettingType> getType(BNullableLens<T, CustomerSettingItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getType(CustomerSettingItem.Companion));
    }

    public static final <T> BNullableLens<T, ICustomerSettingButton> getButton(BNullableLens<T, CustomerSettingItem> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getButton(CustomerSettingItem.Companion));
    }
}