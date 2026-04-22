package tv.danmaku.biliplayer.preload.repository;

import com.bilibili.player.preload.BuildConfig;
import java.util.LinkedList;
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
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PreloadPoolImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl$addPreloadAction$1", f = "PreloadPoolImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PreloadPoolImpl$addPreloadAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PreloadAction $action;
    final /* synthetic */ String $id;
    final /* synthetic */ String $sceneIdentity;
    int label;
    final /* synthetic */ PreloadPoolImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadPoolImpl$addPreloadAction$1(PreloadPoolImpl preloadPoolImpl, String str, String str2, PreloadAction preloadAction, Continuation<? super PreloadPoolImpl$addPreloadAction$1> continuation) {
        super(2, continuation);
        this.this$0 = preloadPoolImpl;
        this.$id = str;
        this.$sceneIdentity = str2;
        this.$action = preloadAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreloadPoolImpl$addPreloadAction$1(this.this$0, this.$id, this.$sceneIdentity, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LinkedList linkedList;
        PreloadPoolImpl.LimitFiFoList limitFiFoList;
        LinkedList linkedList2;
        MutableSharedFlow<PreloadStreamNetwork> mutableSharedFlow;
        LinkedList linkedList3;
        LinkedList linkedList4;
        boolean reusableWhenIdMatching;
        LinkedList linkedList5;
        LinkedList linkedList6;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                CacheElement reusableElement = null;
                int index = 0;
                linkedList = this.this$0.preloadList;
                int size = linkedList.size();
                while (true) {
                    if (index < size) {
                        linkedList4 = this.this$0.preloadList;
                        Object obj2 = linkedList4.get(index);
                        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
                        CacheElement element = (CacheElement) obj2;
                        if (Intrinsics.areEqual(element.getId(), this.$id)) {
                            reusableWhenIdMatching = this.this$0.reusableWhenIdMatching(element.getIdentity(), this.$sceneIdentity, element, this.$action);
                            if (reusableWhenIdMatching) {
                                element.setIdentity(this.$sceneIdentity);
                                if (!PreloadPriority.m2149equalsimpl0(element.m2139getPriority3gV422k(), this.$action.m2144getPriority3gV422k())) {
                                    element.m2140setPriorityEJy1Qw(this.$action.m2144getPriority3gV422k());
                                    BuildersKt.launch$default(VideoCacheScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(element, null), 3, (Object) null);
                                }
                                linkedList6 = this.this$0.preloadList;
                                reusableElement = (CacheElement) linkedList6.remove(index);
                            } else {
                                BLog.e("PlayerPreload", "same element " + this.$id + ", but cant reuse");
                                element.release();
                                linkedList5 = this.this$0.preloadList;
                                Intrinsics.checkNotNull(linkedList5.remove(index));
                            }
                        } else {
                            index++;
                        }
                    }
                }
                limitFiFoList = this.this$0.sceneInfo;
                limitFiFoList.add(this.$sceneIdentity);
                this.this$0.clearExceededBeforeAdd(1, this.$sceneIdentity);
                this.this$0.resetIdleBufferBeforeAdd(this.$sceneIdentity);
                if (reusableElement != null) {
                    linkedList3 = this.this$0.preloadList;
                    linkedList3.add(0, reusableElement);
                } else {
                    CacheElement it = new CacheElement(this.$id, this.$sceneIdentity, this.$action);
                    PreloadPoolImpl preloadPoolImpl = this.this$0;
                    linkedList2 = preloadPoolImpl.preloadList;
                    linkedList2.add(0, it);
                    mutableSharedFlow = preloadPoolImpl._preloadNetworkFlow;
                    it.setStreamNetworkFlow(mutableSharedFlow);
                    it.start();
                }
                if (BuildConfig.DEBUG) {
                    String str = this.$sceneIdentity;
                    BLog.d("PlayerPreload", "addPreloadAction " + str + " " + this.$id);
                    this.this$0.printPreloads();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PreloadPoolImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl$addPreloadAction$1$1", f = "PreloadPoolImpl.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.biliplayer.preload.repository.PreloadPoolImpl$addPreloadAction$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CacheElement $element;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CacheElement cacheElement, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$element = cacheElement;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$element, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (this.$element.syncBufferInfo((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }
}