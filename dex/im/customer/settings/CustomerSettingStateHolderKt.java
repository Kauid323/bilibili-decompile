package im.customer.settings;

import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.CollectionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomerSettingStateHolder.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"TAG", "", "triggerSettingStatus", "Lim/customer/settings/CustomerSettingState;", "input", "Lim/customer/settings/CustomerSettingItem;", "customer_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CustomerSettingStateHolderKt {
    private static final String TAG = "CustomerSettingStateHolder";

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomerSettingState triggerSettingStatus(CustomerSettingState $this$triggerSettingStatus, final CustomerSettingItem input) {
        BNullableLens itemLens = CustomerSettingItemLensKt.getButton(CollectionsKt.nullableSingle(CustomerSettingGroupLensKt.getItems(CollectionsKt.single(CustomerSettingStateLensKt.getGroups(CustomerSettingState.Companion), new Function1() { // from class: im.customer.settings.CustomerSettingStateHolderKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                int triggerSettingStatus$lambda$0;
                triggerSettingStatus$lambda$0 = CustomerSettingStateHolderKt.triggerSettingStatus$lambda$0(CustomerSettingItem.this, (List) obj);
                return Integer.valueOf(triggerSettingStatus$lambda$0);
            }
        })), new Function1() { // from class: im.customer.settings.CustomerSettingStateHolderKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                int triggerSettingStatus$lambda$1;
                triggerSettingStatus$lambda$1 = CustomerSettingStateHolderKt.triggerSettingStatus$lambda$1(CustomerSettingItem.this, (List) obj);
                return Integer.valueOf(triggerSettingStatus$lambda$1);
            }
        }));
        return (CustomerSettingState) itemLens.modify($this$triggerSettingStatus, new Function1() { // from class: im.customer.settings.CustomerSettingStateHolderKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                ICustomerSettingButton triggerSettingStatus$lambda$2;
                triggerSettingStatus$lambda$2 = CustomerSettingStateHolderKt.triggerSettingStatus$lambda$2((ICustomerSettingButton) obj);
                return triggerSettingStatus$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int triggerSettingStatus$lambda$0(CustomerSettingItem $input, List $this$single) {
        Intrinsics.checkNotNullParameter($this$single, "$this$single");
        int index$iv = 0;
        for (Object item$iv : $this$single) {
            CustomerSettingGroup group = (CustomerSettingGroup) item$iv;
            if (group.getGroupId() == $input.getGroupId()) {
                return index$iv;
            }
            index$iv++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int triggerSettingStatus$lambda$1(CustomerSettingItem $input, List $this$single) {
        Intrinsics.checkNotNullParameter($this$single, "$this$single");
        int index$iv = 0;
        for (Object item$iv : $this$single) {
            CustomerSettingItem item = (CustomerSettingItem) item$iv;
            if (item.getType() == $input.getType()) {
                return index$iv;
            }
            index$iv++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ICustomerSettingButton triggerSettingStatus$lambda$2(ICustomerSettingButton it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof CustomerSettingSwitchButton) {
            return ((CustomerSettingSwitchButton) it).copy(!((CustomerSettingSwitchButton) it).getCurrentEnabled());
        }
        return it;
    }
}