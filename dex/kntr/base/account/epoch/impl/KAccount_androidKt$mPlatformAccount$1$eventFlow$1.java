package kntr.base.account.epoch.impl;

import com.bilibili.gripper.api.account.GAccount;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.adapter.AccountAdapterEvent;
import kntr.base.account.model.UserAnswerStatus;
import kntr.base.account.model.UserInfo;
import kntr.base.account.model.Vip;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KAccount.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkntr/base/account/adapter/AccountAdapterEvent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.account.epoch.impl.KAccount_androidKt$mPlatformAccount$1$eventFlow$1", f = "KAccount.android.kt", i = {0, 0}, l = {76}, m = "invokeSuspend", n = {"$this$callbackFlow", "subscribe"}, s = {"L$0", "L$1"}, v = 1)
public final class KAccount_androidKt$mPlatformAccount$1$eventFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super AccountAdapterEvent>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ KAccount_androidKt$mPlatformAccount$1 this$0;

    /* compiled from: KAccount.android.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GAccount.Topic.values().length];
            try {
                iArr[GAccount.Topic.SIGN_IN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[GAccount.Topic.SIGN_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[GAccount.Topic.ACCOUNT_INFO_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[GAccount.Topic.ACCOUNT_SWITCH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KAccount_androidKt$mPlatformAccount$1$eventFlow$1(KAccount_androidKt$mPlatformAccount$1 kAccount_androidKt$mPlatformAccount$1, Continuation<? super KAccount_androidKt$mPlatformAccount$1$eventFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = kAccount_androidKt$mPlatformAccount$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kAccount_androidKt$mPlatformAccount$1$eventFlow$1 = new KAccount_androidKt$mPlatformAccount$1$eventFlow$1(this.this$0, continuation);
        kAccount_androidKt$mPlatformAccount$1$eventFlow$1.L$0 = obj;
        return kAccount_androidKt$mPlatformAccount$1$eventFlow$1;
    }

    public final Object invoke(ProducerScope<? super AccountAdapterEvent> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final ProducerScope $this$callbackFlow = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final KAccount_androidKt$mPlatformAccount$1 kAccount_androidKt$mPlatformAccount$1 = this.this$0;
                final Function1 subscribe = new Function1() { // from class: kntr.base.account.epoch.impl.KAccount_androidKt$mPlatformAccount$1$eventFlow$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = KAccount_androidKt$mPlatformAccount$1$eventFlow$1.invokeSuspend$lambda$0(KAccount_androidKt$mPlatformAccount$1.this, $this$callbackFlow, (GAccount.Topic) obj);
                        return invokeSuspend$lambda$0;
                    }
                };
                this.this$0.getGAccount().subscribe(new GAccount.Topic[]{GAccount.Topic.SIGN_IN, GAccount.Topic.SIGN_OUT, GAccount.Topic.ACCOUNT_INFO_UPDATE, GAccount.Topic.ACCOUNT_SWITCH}, subscribe);
                final KAccount_androidKt$mPlatformAccount$1 kAccount_androidKt$mPlatformAccount$12 = this.this$0;
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$callbackFlow);
                this.L$1 = SpillingKt.nullOutSpilledVariable(subscribe);
                this.label = 1;
                if (ProduceKt.awaitClose($this$callbackFlow, new Function0() { // from class: kntr.base.account.epoch.impl.KAccount_androidKt$mPlatformAccount$1$eventFlow$1$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = KAccount_androidKt$mPlatformAccount$1$eventFlow$1.invokeSuspend$lambda$1(KAccount_androidKt$mPlatformAccount$1.this, subscribe);
                        return invokeSuspend$lambda$1;
                    }
                }, (Continuation) this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                Function1 function1 = (Function1) this.L$1;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(KAccount_androidKt$mPlatformAccount$1 this$0, ProducerScope $$this$callbackFlow, GAccount.Topic topic) {
        AccountAdapterEvent result;
        switch (WhenMappings.$EnumSwitchMapping$0[topic.ordinal()]) {
            case 1:
                long mid = this$0.getGAccount().getMid();
                String name = this$0.getGAccount().getName();
                String str = name == null ? "" : name;
                Vip vip = new Vip(this$0.getGAccount().getVipStatus(), this$0.getGAccount().getVipType(), this$0.getGAccount().getVipEndTimestamp());
                String accessKey = this$0.getGAccount().getAccessKey();
                result = new AccountAdapterEvent.OnLogin(new UserInfo(mid, str, vip, accessKey == null ? "" : accessKey, this$0.getGAccount().getLevel(), UserAnswerStatus.Companion.fromInt(this$0.getGAccount().getAnswerStatus())));
                break;
            case 2:
                result = AccountAdapterEvent.OnLogout.INSTANCE;
                break;
            case 3:
            case 4:
                long mid2 = this$0.getGAccount().getMid();
                String name2 = this$0.getGAccount().getName();
                String str2 = name2 == null ? "" : name2;
                Vip vip2 = new Vip(this$0.getGAccount().getVipStatus(), this$0.getGAccount().getVipType(), this$0.getGAccount().getVipEndTimestamp());
                String accessKey2 = this$0.getGAccount().getAccessKey();
                result = new AccountAdapterEvent.OnUpdate(new UserInfo(mid2, str2, vip2, accessKey2 == null ? "" : accessKey2, this$0.getGAccount().getLevel(), UserAnswerStatus.Companion.fromInt(this$0.getGAccount().getAnswerStatus())));
                break;
            default:
                throw new IllegalArgumentException("Unknown topic: " + topic);
        }
        ChannelsKt.trySendBlocking((SendChannel) $$this$callbackFlow, result);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(KAccount_androidKt$mPlatformAccount$1 this$0, Function1 $subscribe) {
        this$0.getGAccount().subscribe(new GAccount.Topic[]{GAccount.Topic.SIGN_IN, GAccount.Topic.SIGN_OUT, GAccount.Topic.ACCOUNT_INFO_UPDATE, GAccount.Topic.ACCOUNT_SWITCH}, $subscribe);
        return Unit.INSTANCE;
    }
}