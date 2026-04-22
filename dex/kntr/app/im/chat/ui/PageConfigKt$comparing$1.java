package kntr.app.im.chat.ui;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: PageConfig.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.PageConfigKt$comparing$1", f = "PageConfig.kt", i = {0}, l = {84}, m = "invokeSuspend", n = {"$this$channelFlow"}, s = {"L$0"}, v = 1)
final class PageConfigKt$comparing$1<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<T> $last;
    final /* synthetic */ Function3<T, T, Continuation<? super R>, Object> $operator;
    final /* synthetic */ Flow<T> $this_comparing;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PageConfigKt$comparing$1(Flow<? extends T> flow, Ref.ObjectRef<T> objectRef, Function3<? super T, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super PageConfigKt$comparing$1> continuation) {
        super(2, continuation);
        this.$this_comparing = flow;
        this.$last = objectRef;
        this.$operator = function3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> pageConfigKt$comparing$1 = new PageConfigKt$comparing$1<>(this.$this_comparing, this.$last, this.$operator, continuation);
        pageConfigKt$comparing$1.L$0 = obj;
        return pageConfigKt$comparing$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((ProducerScope) ((ProducerScope) obj), (Continuation) obj2);
    }

    public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PageConfig.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kntr.app.im.chat.ui.PageConfigKt$comparing$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ ProducerScope<R> $$this$channelFlow;
        final /* synthetic */ Ref.ObjectRef<T> $last;
        final /* synthetic */ Function3<T, T, Continuation<? super R>, Object> $operator;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Ref.ObjectRef<T> objectRef, ProducerScope<? super R> producerScope, Function3<? super T, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
            this.$last = objectRef;
            this.$$this$channelFlow = producerScope;
            this.$operator = function3;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x006d A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            PageConfigKt$comparing$1$1$emit$1 pageConfigKt$comparing$1$1$emit$1;
            ProducerScope<R> producerScope;
            Object invoke;
            if (continuation instanceof PageConfigKt$comparing$1$1$emit$1) {
                pageConfigKt$comparing$1$1$emit$1 = (PageConfigKt$comparing$1$1$emit$1) continuation;
                if ((pageConfigKt$comparing$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    pageConfigKt$comparing$1$1$emit$1.label -= Integer.MIN_VALUE;
                    Object $result = pageConfigKt$comparing$1$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (pageConfigKt$comparing$1$1$emit$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            if (this.$last.element != null) {
                                producerScope = this.$$this$channelFlow;
                                Function3<T, T, Continuation<? super R>, Object> function3 = this.$operator;
                                Object obj = this.$last.element;
                                Intrinsics.checkNotNull(obj);
                                pageConfigKt$comparing$1$1$emit$1.L$0 = t;
                                pageConfigKt$comparing$1$1$emit$1.L$1 = producerScope;
                                pageConfigKt$comparing$1$1$emit$1.label = 1;
                                invoke = function3.invoke(obj, t, pageConfigKt$comparing$1$1$emit$1);
                                if (invoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                T it = t;
                                pageConfigKt$comparing$1$1$emit$1.L$0 = it;
                                pageConfigKt$comparing$1$1$emit$1.L$1 = null;
                                pageConfigKt$comparing$1$1$emit$1.label = 2;
                                if (producerScope.send(invoke, pageConfigKt$comparing$1$1$emit$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            this.$last.element = t;
                            return Unit.INSTANCE;
                        case 1:
                            producerScope = (ProducerScope) pageConfigKt$comparing$1$1$emit$1.L$1;
                            Object it2 = pageConfigKt$comparing$1$1$emit$1.L$0;
                            t = (T) it2;
                            ResultKt.throwOnFailure($result);
                            invoke = $result;
                            T it3 = t;
                            pageConfigKt$comparing$1$1$emit$1.L$0 = it3;
                            pageConfigKt$comparing$1$1$emit$1.L$1 = null;
                            pageConfigKt$comparing$1$1$emit$1.label = 2;
                            if (producerScope.send(invoke, pageConfigKt$comparing$1$1$emit$1) == coroutine_suspended) {
                            }
                            this.$last.element = t;
                            return Unit.INSTANCE;
                        case 2:
                            Object it4 = pageConfigKt$comparing$1$1$emit$1.L$0;
                            t = (T) it4;
                            ResultKt.throwOnFailure($result);
                            this.$last.element = t;
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            pageConfigKt$comparing$1$1$emit$1 = new PageConfigKt$comparing$1$1$emit$1(this, continuation);
            Object $result2 = pageConfigKt$comparing$1$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (pageConfigKt$comparing$1$1$emit$1.label) {
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        SendChannel sendChannel = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = sendChannel;
                this.label = 1;
                if (this.$this_comparing.collect(new AnonymousClass1(this.$last, sendChannel, this.$operator), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SendChannel.DefaultImpls.close$default(sendChannel, (Throwable) null, 1, (Object) null);
        return Unit.INSTANCE;
    }
}