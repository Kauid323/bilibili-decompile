package kntr.base.dd.impl.internal.property;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStore;
import kntr.base.dd.IDeviceDecisionProperty;
import kntr.base.dd.impl.internal.common.DDConst;
import kntr.base.utils.CoroutineExKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: DefaultProps.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/base/dd/impl/internal/property/DDMidProp;", "Lkntr/base/dd/IDeviceDecisionProperty$Node;", "account", "Lkntr/base/account/KAccountStore;", "property", "Lkntr/base/dd/IDeviceDecisionProperty;", "<init>", "(Lkntr/base/account/KAccountStore;Lkntr/base/dd/IDeviceDecisionProperty;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "name", "", "getName", "()Ljava/lang/String;", "userId", "value", "extra", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDMidProp implements IDeviceDecisionProperty.Node {
    private final KAccountStore account;
    private final String name;
    private final IDeviceDecisionProperty property;
    private final CoroutineScope scope;
    private String userId;

    public DDMidProp(KAccountStore account, IDeviceDecisionProperty property) {
        String mid;
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(property, "property");
        this.account = account;
        this.property = property;
        this.scope = CoroutineExKt.createIOScope();
        this.name = "mid";
        mid = DefaultPropsKt.getMid((AccountState) this.account.getState().getValue());
        this.userId = mid;
        DDConst.INSTANCE.logD("DDMidProp init with " + this.userId + ".");
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    @Override // kntr.base.dd.IDeviceDecisionProperty.Node
    public String getName() {
        return this.name;
    }

    @Override // kntr.base.dd.IDeviceDecisionProperty.Node
    public String value(String extra) {
        return this.userId;
    }

    /* compiled from: DefaultProps.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.base.dd.impl.internal.property.DDMidProp$1", f = "DefaultProps.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.base.dd.impl.internal.property.DDMidProp$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    StateFlow<AccountState> state = DDMidProp.this.account.getState();
                    final DDMidProp dDMidProp = DDMidProp.this;
                    this.label = 1;
                    if (state.collect(new FlowCollector() { // from class: kntr.base.dd.impl.internal.property.DDMidProp.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((AccountState) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(AccountState it, Continuation<? super Unit> continuation) {
                            String mid;
                            DDMidProp dDMidProp2 = DDMidProp.this;
                            mid = DefaultPropsKt.getMid(it);
                            dDMidProp2.userId = mid;
                            DDMidProp.this.property.onPropertyUpdated(DDMidProp.this.getName());
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        }
    }
}