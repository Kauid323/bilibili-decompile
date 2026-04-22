package kntr.base.dd.impl.internal.property;

import com.bilibili.lib.gripper.api.PreTrigger;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStore;
import kntr.base.dd.IDeviceDecisionProperty;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultProps.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0002¨\u0006\t"}, d2 = {"provideDefaultProps", "", "account", "Lkntr/base/account/KAccountStore;", "property", "Lkntr/base/dd/IDeviceDecisionProperty;", "getMid", "", "Lkntr/base/account/AccountState;", "impl_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DefaultPropsKt {
    @PreTrigger(awaitComplete = true, trigger = "OnCreate")
    public static final void provideDefaultProps(KAccountStore account, IDeviceDecisionProperty property) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(property, "property");
        property.addPropNodes(CollectionsKt.listOf(new DDMidProp(account, property)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getMid(AccountState $this$getMid) {
        return $this$getMid instanceof AccountState.Logged ? String.valueOf(((AccountState.Logged) $this$getMid).getUserInfo().getMid()) : "0";
    }
}