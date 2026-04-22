package tv.danmaku.bili.ui.splash.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventSplashFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.event.EventSplashFragment$displayDelayElement$1", f = "EventSplashFragment.kt", i = {}, l = {303}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class EventSplashFragment$displayDelayElement$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Element> $willAddedElement;
    final /* synthetic */ List<Element> $willRemovedElements;
    int label;
    final /* synthetic */ EventSplashFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventSplashFragment$displayDelayElement$1(List<Element> list, List<Element> list2, EventSplashFragment eventSplashFragment, Continuation<? super EventSplashFragment$displayDelayElement$1> continuation) {
        super(2, continuation);
        this.$willAddedElement = list;
        this.$willRemovedElements = list2;
        this.this$0 = eventSplashFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventSplashFragment$displayDelayElement$1(this.$willAddedElement, this.$willRemovedElements, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        EventSplashFragment$displayDelayElement$1 eventSplashFragment$displayDelayElement$1;
        long currentPosition;
        ElementFactory elementFactory;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                eventSplashFragment$displayDelayElement$1 = this;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                eventSplashFragment$displayDelayElement$1 = this;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        do {
            if (!eventSplashFragment$displayDelayElement$1.$willAddedElement.isEmpty() || !eventSplashFragment$displayDelayElement$1.$willRemovedElements.isEmpty()) {
                currentPosition = eventSplashFragment$displayDelayElement$1.this$0.getElementRelativePosition();
                BLog.i("[EventSplash]EventSplashFragment", "displayDelayElement LOOP :" + currentPosition + " willAdd:" + eventSplashFragment$displayDelayElement$1.$willAddedElement + " willRemove:" + eventSplashFragment$displayDelayElement$1.$willRemovedElements);
                Iterable $this$forEach$iv = CollectionsKt.toList(eventSplashFragment$displayDelayElement$1.$willRemovedElements);
                EventSplashFragment eventSplashFragment = eventSplashFragment$displayDelayElement$1.this$0;
                List<Element> list = eventSplashFragment$displayDelayElement$1.$willRemovedElements;
                for (Object element$iv : $this$forEach$iv) {
                    Element it = (Element) element$iv;
                    if (it.getHideDuration() <= currentPosition) {
                        eventSplashFragment.removeElementView(it);
                        list.remove(it);
                    }
                }
                Iterable $this$filterTo$iv$iv = eventSplashFragment$displayDelayElement$1.$willAddedElement;
                Collection destination$iv$iv = new ArrayList();
                Iterator<T> it2 = $this$filterTo$iv$iv.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        Iterable $this$invokeSuspend_u24lambda_u242 = (List) destination$iv$iv;
                        EventSplashFragment eventSplashFragment2 = eventSplashFragment$displayDelayElement$1.this$0;
                        List<Element> list2 = eventSplashFragment$displayDelayElement$1.$willAddedElement;
                        elementFactory = eventSplashFragment2.mElementFactory;
                        if (elementFactory != null) {
                            elementFactory.generateAndDisplayElements(CollectionsKt.toList($this$invokeSuspend_u24lambda_u242));
                        }
                        list2.removeAll((Collection) $this$invokeSuspend_u24lambda_u242);
                        Iterable $this$filterTo$iv$iv2 = $this$invokeSuspend_u24lambda_u242;
                        Collection destination$iv$iv2 = new ArrayList();
                        for (Object element$iv$iv : $this$filterTo$iv$iv2) {
                            Element it3 = (Element) element$iv$iv;
                            Element it4 = it3.getHideDuration() > 0 ? 1 : null;
                            if (it4 != null) {
                                destination$iv$iv2.add(element$iv$iv);
                            }
                        }
                        List $this$invokeSuspend_u24lambda_u244 = (List) destination$iv$iv2;
                        eventSplashFragment$displayDelayElement$1.$willRemovedElements.addAll($this$invokeSuspend_u24lambda_u244);
                        eventSplashFragment$displayDelayElement$1.label = 1;
                    } else {
                        Object element$iv$iv2 = it2.next();
                        Element it5 = (Element) element$iv$iv2;
                        if (it5.getShowDuration() <= currentPosition) {
                            destination$iv$iv.add(element$iv$iv2);
                        }
                    }
                }
            } else {
                return Unit.INSTANCE;
            }
        } while (DelayKt.delay(100L, (Continuation) eventSplashFragment$displayDelayElement$1) != coroutine_suspended);
        return coroutine_suspended;
    }
}