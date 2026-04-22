package kntr.base.account;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* compiled from: KAccountStore.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"AccountHolder", "Lkntr/base/account/KAccountStore;", "getAccountHolder", "()Lkntr/base/account/KAccountStore;", "AccountHolder$delegate", "Lkotlin/Lazy;", "account_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KAccountStoreKt {
    private static final Lazy AccountHolder$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: kntr.base.account.KAccountStoreKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            KAccountStore AccountHolder_delegate$lambda$0;
            AccountHolder_delegate$lambda$0 = KAccountStoreKt.AccountHolder_delegate$lambda$0();
            return AccountHolder_delegate$lambda$0;
        }
    });

    public static final KAccountStore getAccountHolder() {
        return (KAccountStore) AccountHolder$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KAccountStore AccountHolder_delegate$lambda$0() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((AccountEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(AccountEntryPoint.class))).getAccount();
    }
}