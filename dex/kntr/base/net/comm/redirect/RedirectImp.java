package kntr.base.net.comm.redirect;

import java.util.HashMap;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStore;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.base.config.SharedPreferences;
import kntr.base.net.comm.GRedirect;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;

/* compiled from: RedirectImp.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lkntr/base/net/comm/redirect/RedirectImp;", "Lkntr/base/net/comm/GRedirect;", "accountStore", "Lkntr/base/account/KAccountStore;", "<init>", "(Lkntr/base/account/KAccountStore;)V", "redirectKv", "Lkntr/base/config/SharedPreferences;", "redirectRule", "Lkntr/base/net/comm/redirect/Rules;", "enable", "", "getEnable", "()Z", "redirect", "Lkntr/base/net/comm/GRedirect$Redirect;", "host", "", "path", "setRedirect", "", "rule", "resetRule", "redirect_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RedirectImp implements GRedirect {
    private final SharedPreferences redirectKv;
    private Rules redirectRule;

    /* JADX WARN: Code restructure failed: missing block: B:5:0x003c, code lost:
        if (r2 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RedirectImp(KAccountStore accountStore) {
        Rules rules;
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        this.redirectKv = new SharedPreferences(RedirectImpKt.REDIRECT_KV_STORE, false, 2, null);
        String it = SharedPreferences.getString$default(this.redirectKv, RedirectImpKt.REDIRECT_KV_CONFIG, null, 2, null);
        if (it != null) {
            Json this_$iv = Json.Default;
            this_$iv.getSerializersModule();
            rules = (Rules) this_$iv.decodeFromString(BuiltinSerializersKt.getNullable(Rules.Companion.serializer()), it);
        }
        rules = new Rules(-1L, new HashMap());
        this.redirectRule = rules;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(accountStore, this, null), 3, (Object) null);
    }

    /* compiled from: RedirectImp.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.base.net.comm.redirect.RedirectImp$1", f = "RedirectImp.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.base.net.comm.redirect.RedirectImp$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ KAccountStore $accountStore;
        int label;
        final /* synthetic */ RedirectImp this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(KAccountStore kAccountStore, RedirectImp redirectImp, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$accountStore = kAccountStore;
            this.this$0 = redirectImp;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$accountStore, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    StateFlow<AccountState> state = this.$accountStore.getState();
                    final RedirectImp redirectImp = this.this$0;
                    this.label = 1;
                    if (state.collect(new FlowCollector() { // from class: kntr.base.net.comm.redirect.RedirectImp.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((AccountState) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(AccountState it, Continuation<? super Unit> continuation) {
                            if (it instanceof AccountState.Logged) {
                                if (RedirectImp.this.redirectRule.getMid() != ((AccountState.Logged) it).getUserInfo().getMid()) {
                                    RedirectImp.this.resetRule();
                                    RedirectImp.this.redirectRule = new Rules(((AccountState.Logged) it).getUserInfo().getMid(), new HashMap(100));
                                }
                            } else if (it instanceof AccountState.Idle) {
                                RedirectImp.this.resetRule();
                            }
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

    @Override // kntr.base.net.comm.GRedirect
    public boolean getEnable() {
        return IPlatformConfig.CC.ff$default(KConfig.INSTANCE, "net.redirect", false, 2, null);
    }

    @Override // kntr.base.net.comm.GRedirect
    public GRedirect.Redirect redirect(String host, String path) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        if (this.redirectRule.getMid() == -1) {
            return null;
        }
        String it = this.redirectRule.getRule().get(host + "/" + StringsKt.removePrefix(path, "/"));
        if (it != null) {
            return GRedirect.Redirect.Companion.create(it);
        }
        return null;
    }

    @Override // kntr.base.net.comm.GRedirect
    public void setRedirect(String host, String path, GRedirect.Redirect rule) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        if (this.redirectRule.getMid() == -1) {
            return;
        }
        Rules ruleConfig = this.redirectRule;
        String k = host + "/" + StringsKt.removePrefix(path, "/");
        if (rule == null) {
            ruleConfig.getRule().remove(k);
        } else {
            String v = rule.getHost() + "/" + StringsKt.removePrefix(rule.getPath(), "/");
            ruleConfig.getRule().values().remove(v);
            ruleConfig.getRule().put(k, v);
        }
        SharedPreferences sharedPreferences = this.redirectKv;
        StringFormat $this$encodeToString$iv = Json.Default;
        $this$encodeToString$iv.getSerializersModule();
        sharedPreferences.setString(RedirectImpKt.REDIRECT_KV_CONFIG, $this$encodeToString$iv.encodeToString(Rules.Companion.serializer(), ruleConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetRule() {
        this.redirectRule = new Rules(-1L, new HashMap());
        SharedPreferences sharedPreferences = this.redirectKv;
        StringFormat $this$encodeToString$iv = Json.Default;
        Object value$iv = this.redirectRule;
        $this$encodeToString$iv.getSerializersModule();
        sharedPreferences.setString(RedirectImpKt.REDIRECT_KV_CONFIG, $this$encodeToString$iv.encodeToString(Rules.Companion.serializer(), value$iv));
    }
}