package kntr.base.config;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: KPreferences.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.config.SharedPreferences$asFlow$1", f = "KPreferences.kt", i = {0, 0}, l = {174}, m = "invokeSuspend", n = {"$this$callbackFlow", "listener"}, s = {"L$0", "L$1"}, v = 1)
public final class SharedPreferences$asFlow$1<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ KClass<T> $type;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SharedPreferences this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferences$asFlow$1(SharedPreferences sharedPreferences, String str, KClass<T> kClass, Continuation<? super SharedPreferences$asFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = sharedPreferences;
        this.$key = str;
        this.$type = kClass;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> sharedPreferences$asFlow$1 = new SharedPreferences$asFlow$1<>(this.this$0, this.$key, this.$type, continuation);
        sharedPreferences$asFlow$1.L$0 = obj;
        return sharedPreferences$asFlow$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((ProducerScope) ((ProducerScope) obj), (Continuation) obj2);
    }

    public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kntr.base.config.SharedPreferences$asFlow$1$listener$1, java.lang.Object] */
    public final Object invokeSuspend(Object $result) {
        final ProducerScope $this$callbackFlow = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final KClass<T> kClass = this.$type;
                final ?? r2 = new PreferencesListener() { // from class: kntr.base.config.SharedPreferences$asFlow$1$listener$1
                    @Override // kntr.base.config.PreferencesListener
                    public void onChanged(PreferencesReadProxy dataHolder, String key) {
                        Intrinsics.checkNotNullParameter(dataHolder, "dataHolder");
                        Intrinsics.checkNotNullParameter(key, "key");
                        $this$callbackFlow.trySend-JP2dKIU(PreferencesReadProxy.get$default(dataHolder, key, kClass, null, 4, null));
                    }
                };
                this.this$0.getSp$preferences_debug().addListener(this.$key, (PreferencesListener) r2);
                final SharedPreferences sharedPreferences = this.this$0;
                final String str = this.$key;
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$callbackFlow);
                this.L$1 = SpillingKt.nullOutSpilledVariable((Object) r2);
                this.label = 1;
                if (ProduceKt.awaitClose($this$callbackFlow, new Function0() { // from class: kntr.base.config.SharedPreferences$asFlow$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = SharedPreferences$asFlow$1.invokeSuspend$lambda$0(SharedPreferences.this, str, r2);
                        return invokeSuspend$lambda$0;
                    }
                }, (Continuation) this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                SharedPreferences$asFlow$1$listener$1 sharedPreferences$asFlow$1$listener$1 = (SharedPreferences$asFlow$1$listener$1) this.L$1;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(SharedPreferences this$0, String $key, SharedPreferences$asFlow$1$listener$1 $listener) {
        this$0.getSp$preferences_debug().removeListener($key, $listener);
        return Unit.INSTANCE;
    }
}