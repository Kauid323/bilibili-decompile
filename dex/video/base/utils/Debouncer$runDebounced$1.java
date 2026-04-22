package video.base.utils;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Debouncer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.base.utils.Debouncer$runDebounced$1", f = "Debouncer.kt", i = {0, 0}, l = {42}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, s = {"L$0", "I$0"}, v = 1)
final class Debouncer$runDebounced$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ String $key;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ Debouncer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Debouncer$runDebounced$1(Debouncer debouncer, String str, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Debouncer$runDebounced$1> continuation) {
        super(2, continuation);
        this.this$0 = debouncer;
        this.$key = str;
        this.$block = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Debouncer$runDebounced$1(this.this$0, this.$key, this.$block, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Map map;
        Mutex $this$withLock_u24default$iv;
        Debouncer debouncer;
        String str;
        Object owner$iv;
        Map map2;
        Map map3;
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                map = this.this$0.jobMap;
                Job job = (Job) map.get(this.$key);
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                $this$withLock_u24default$iv = this.this$0.mutex;
                Debouncer debouncer2 = this.this$0;
                String str2 = this.$key;
                this.L$0 = $this$withLock_u24default$iv;
                this.L$1 = debouncer2;
                this.L$2 = str2;
                this.I$0 = 0;
                this.label = 1;
                if ($this$withLock_u24default$iv.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                debouncer = debouncer2;
                str = str2;
                owner$iv = null;
                break;
            case 1:
                int i = this.I$0;
                str = (String) this.L$2;
                debouncer = (Debouncer) this.L$1;
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            map2 = debouncer.jobMap;
            Job job2 = (Job) map2.remove(str);
            $this$withLock_u24default$iv.unlock(owner$iv);
            map3 = this.this$0.jobMap;
            String str3 = this.$key;
            coroutineScope = this.this$0.scope;
            map3.put(str3, BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this.this$0, this.$block, this.$key, null), 3, (Object) null));
            return Unit.INSTANCE;
        } catch (Throwable th) {
            $this$withLock_u24default$iv.unlock(owner$iv);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Debouncer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "video.base.utils.Debouncer$runDebounced$1$2", f = "Debouncer.kt", i = {2, 2}, l = {DynModuleType.module_button_VALUE, DynModuleType.module_notice_VALUE, 42}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, s = {"L$0", "I$0"}, v = 1)
    /* renamed from: video.base.utils.Debouncer$runDebounced$1$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        final /* synthetic */ String $key;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ Debouncer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Debouncer debouncer, Function1<? super Continuation<? super Unit>, ? extends Object> function1, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = debouncer;
            this.$block = function1;
            this.$key = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$block, this.$key, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x004d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x006f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            long j;
            Function1<Continuation<? super Unit>, Object> function1;
            Mutex $this$withLock_u24default$iv;
            Debouncer debouncer;
            String str;
            Object owner$iv;
            Map map;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    j = this.this$0.timeout;
                    this.label = 1;
                    if (DelayKt.delay(j, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function1 = this.$block;
                    this.label = 2;
                    if (function1.invoke(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withLock_u24default$iv = this.this$0.mutex;
                    debouncer = this.this$0;
                    str = this.$key;
                    owner$iv = null;
                    this.L$0 = $this$withLock_u24default$iv;
                    this.L$1 = debouncer;
                    this.L$2 = str;
                    this.I$0 = 0;
                    this.label = 3;
                    if ($this$withLock_u24default$iv.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    try {
                        map = debouncer.jobMap;
                        map.remove(str);
                        Unit unit = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        throw th;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    function1 = this.$block;
                    this.label = 2;
                    if (function1.invoke(this) == coroutine_suspended) {
                    }
                    $this$withLock_u24default$iv = this.this$0.mutex;
                    debouncer = this.this$0;
                    str = this.$key;
                    owner$iv = null;
                    this.L$0 = $this$withLock_u24default$iv;
                    this.L$1 = debouncer;
                    this.L$2 = str;
                    this.I$0 = 0;
                    this.label = 3;
                    if ($this$withLock_u24default$iv.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                    }
                    break;
                case 2:
                    ResultKt.throwOnFailure($result);
                    $this$withLock_u24default$iv = this.this$0.mutex;
                    debouncer = this.this$0;
                    str = this.$key;
                    owner$iv = null;
                    this.L$0 = $this$withLock_u24default$iv;
                    this.L$1 = debouncer;
                    this.L$2 = str;
                    this.I$0 = 0;
                    this.label = 3;
                    if ($this$withLock_u24default$iv.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                    }
                    break;
                case 3:
                    int i = this.I$0;
                    str = (String) this.L$2;
                    debouncer = (Debouncer) this.L$1;
                    owner$iv = null;
                    $this$withLock_u24default$iv = (Mutex) this.L$0;
                    ResultKt.throwOnFailure($result);
                    map = debouncer.jobMap;
                    map.remove(str);
                    Unit unit2 = Unit.INSTANCE;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}