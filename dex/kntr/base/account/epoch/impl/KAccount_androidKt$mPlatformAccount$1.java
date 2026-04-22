package kntr.base.account.epoch.impl;

import com.bilibili.gripper.api.account.GAccount;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.ProducerContainer;
import com.bilibili.lib.gripper.api.SuspendProducer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.AccountState;
import kntr.base.account.adapter.AccountAdapterEvent;
import kntr.base.account.adapter.AccountStateNotifier;
import kntr.base.account.model.UserAnswerStatus;
import kntr.base.account.model.UserInfo;
import kntr.base.account.model.Vip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: KAccount.android.kt */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"kntr/base/account/epoch/impl/KAccount_androidKt$mPlatformAccount$1", "Lkntr/base/account/adapter/AccountStateNotifier;", "gAccount", "Lcom/bilibili/gripper/api/account/GAccount;", "getGAccount", "()Lcom/bilibili/gripper/api/account/GAccount;", "eventFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/base/account/adapter/AccountAdapterEvent;", "getEventFlow", "()Lkotlinx/coroutines/flow/Flow;", "currentState", "Lkntr/base/account/AccountState;", "getCurrentState", "()Lkntr/base/account/AccountState;", "account_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KAccount_androidKt$mPlatformAccount$1 implements AccountStateNotifier {
    private final Flow<AccountAdapterEvent> eventFlow;
    private final GAccount gAccount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KAccount_androidKt$mPlatformAccount$1() {
        SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(FoundationAlias.getFapp()).getContainer(), GAccount.class, (String) null, 2, (Object) null);
        Intrinsics.checkNotNull(suspendProducer);
        Object orNull = suspendProducer.getOrNull();
        Intrinsics.checkNotNull(orNull);
        this.gAccount = (GAccount) orNull;
        this.eventFlow = FlowKt.callbackFlow(new KAccount_androidKt$mPlatformAccount$1$eventFlow$1(this, null));
    }

    public final GAccount getGAccount() {
        return this.gAccount;
    }

    @Override // kntr.base.account.adapter.AccountStateNotifier
    public Flow<AccountAdapterEvent> getEventFlow() {
        return this.eventFlow;
    }

    @Override // kntr.base.account.adapter.AccountStateNotifier
    public AccountState getCurrentState() {
        String accessKey = this.gAccount.getAccessKey();
        if (accessKey == null) {
            return AccountState.Idle.INSTANCE;
        }
        long mid = this.gAccount.getMid();
        String name = this.gAccount.getName();
        if (name == null) {
            name = "";
        }
        return new AccountState.Logged(new UserInfo(mid, name, new Vip(this.gAccount.getVipStatus(), this.gAccount.getVipType(), this.gAccount.getVipEndTimestamp()), accessKey, this.gAccount.getLevel(), UserAnswerStatus.Companion.fromInt(this.gAccount.getAnswerStatus())));
    }
}