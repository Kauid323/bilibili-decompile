package kotlinx.coroutines.reactive;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Await.kt */
@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\u00020\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0019"}, d2 = {"kotlinx/coroutines/reactive/AwaitKt$awaitOne$2$1", "Lorg/reactivestreams/Subscriber;", "inTerminalState", "", "seenValue", "subscription", "Lorg/reactivestreams/Subscription;", "value", "Ljava/lang/Object;", "onComplete", "", "onError", "e", "", "onNext", "t", "(Ljava/lang/Object;)V", "onSubscribe", "sub", "tryEnterTerminalState", "signalName", "", "withSubscriptionLock", "block", "Lkotlin/Function0;", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AwaitKt$awaitOne$2$1<T> implements Subscriber<T> {
    final /* synthetic */ CancellableContinuation<T> $cont;
    final /* synthetic */ T $default;
    final /* synthetic */ Mode $mode;
    private boolean inTerminalState;
    private boolean seenValue;
    private Subscription subscription;
    private T value;

    /* compiled from: Await.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.values().length];
            try {
                iArr[Mode.FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Mode.FIRST_OR_DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Mode.LAST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Mode.SINGLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Mode.SINGLE_OR_DEFAULT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public AwaitKt$awaitOne$2$1(CancellableContinuation<? super T> cancellableContinuation, Mode $mode, T t) {
        this.$cont = cancellableContinuation;
        this.$mode = $mode;
        this.$default = t;
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(final Subscription sub) {
        if (this.subscription != null) {
            withSubscriptionLock(new Function0<Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onSubscribe$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Subscription.this.cancel();
                }
            });
            return;
        }
        this.subscription = sub;
        this.$cont.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onSubscribe$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                AwaitKt$awaitOne$2$1 awaitKt$awaitOne$2$1 = AwaitKt$awaitOne$2$1.this;
                final Subscription subscription = sub;
                awaitKt$awaitOne$2$1.withSubscriptionLock(new Function0<Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onSubscribe$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Subscription.this.cancel();
                    }
                });
            }
        });
        final Mode mode = this.$mode;
        withSubscriptionLock(new Function0<Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onSubscribe$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Subscription.this.request((mode == Mode.FIRST || mode == Mode.FIRST_OR_DEFAULT) ? 1L : LongCompanionObject.MAX_VALUE);
            }
        });
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        final Subscription it = this.subscription;
        CancellableContinuation<T> cancellableContinuation = this.$cont;
        if (it == null) {
            CoroutineExceptionHandlerKt.handleCoroutineException(cancellableContinuation.getContext(), new IllegalStateException("'onNext' was called before 'onSubscribe'"));
        } else if (this.inTerminalState) {
            AwaitKt.gotSignalInTerminalStateException(this.$cont.getContext(), "onNext");
        } else {
            switch (WhenMappings.$EnumSwitchMapping$0[this.$mode.ordinal()]) {
                case 1:
                case 2:
                    if (this.seenValue) {
                        AwaitKt.moreThanOneValueProvidedException(this.$cont.getContext(), this.$mode);
                        return;
                    }
                    this.seenValue = true;
                    withSubscriptionLock(new Function0<Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onNext$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Subscription.this.cancel();
                        }
                    });
                    Result.Companion companion = Result.Companion;
                    this.$cont.resumeWith(Result.constructor-impl(t));
                    return;
                case 3:
                case 4:
                case 5:
                    if ((this.$mode == Mode.SINGLE || this.$mode == Mode.SINGLE_OR_DEFAULT) && this.seenValue) {
                        withSubscriptionLock(new Function0<Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onNext$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Subscription.this.cancel();
                            }
                        });
                        if (this.$cont.isActive()) {
                            Result.Companion companion2 = Result.Companion;
                            this.$cont.resumeWith(Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("More than one onNext value for " + this.$mode))));
                            return;
                        }
                        return;
                    }
                    this.value = t;
                    this.seenValue = true;
                    return;
                default:
                    return;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!tryEnterTerminalState("onComplete")) {
            return;
        }
        if (this.seenValue) {
            if (this.$mode != Mode.FIRST_OR_DEFAULT && this.$mode != Mode.FIRST && this.$cont.isActive()) {
                Result.Companion companion = Result.Companion;
                this.$cont.resumeWith(Result.constructor-impl(this.value));
            }
        } else if (this.$mode == Mode.FIRST_OR_DEFAULT || this.$mode == Mode.SINGLE_OR_DEFAULT) {
            Result.Companion companion2 = Result.Companion;
            this.$cont.resumeWith(Result.constructor-impl(this.$default));
        } else if (this.$cont.isActive()) {
            Result.Companion companion3 = Result.Companion;
            this.$cont.resumeWith(Result.constructor-impl(ResultKt.createFailure(new NoSuchElementException("No value received via onNext for " + this.$mode))));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable e) {
        if (tryEnterTerminalState("onError")) {
            Result.Companion companion = Result.Companion;
            this.$cont.resumeWith(Result.constructor-impl(ResultKt.createFailure(e)));
        }
    }

    private final boolean tryEnterTerminalState(String signalName) {
        if (this.inTerminalState) {
            AwaitKt.gotSignalInTerminalStateException(this.$cont.getContext(), signalName);
            return false;
        }
        this.inTerminalState = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void withSubscriptionLock(Function0<Unit> function0) {
        function0.invoke();
    }
}