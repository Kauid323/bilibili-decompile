package tv.danmaku.biliplayerv2.widget;

import java.util.ArrayList;
import java.util.Iterator;
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
import kotlinx.coroutines.DelayKt;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.injection.PlayerServiceInjector;
import tv.danmaku.biliplayerv2.widget.AbsGroupWidget;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AbsGroupWidget.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.widget.AbsGroupWidget$onWidgetShow$1", f = "AbsGroupWidget.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AbsGroupWidget$onWidgetShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AbsGroupWidget this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsGroupWidget$onWidgetShow$1(AbsGroupWidget absGroupWidget, Continuation<? super AbsGroupWidget$onWidgetShow$1> continuation) {
        super(2, continuation);
        this.this$0 = absGroupWidget;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> absGroupWidget$onWidgetShow$1 = new AbsGroupWidget$onWidgetShow$1(this.this$0, continuation);
        absGroupWidget$onWidgetShow$1.L$0 = obj;
        return absGroupWidget$onWidgetShow$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ArrayList arrayList;
        PlayerContainer playerContainer;
        PlayerContainer playerContainer2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$launch = (CoroutineScope) this.L$0;
                    this.this$0.onChildWidgetShow(this.this$0.getView());
                    arrayList = this.this$0.widgetRecords;
                    Iterator it = arrayList.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        Object next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        AbsGroupWidget.ControlWidgetRecord record = (AbsGroupWidget.ControlWidgetRecord) next;
                        IControlWidget widget = record.getWidget();
                        if (widget.getMembersInjector()) {
                            playerContainer2 = this.this$0.playerContainer;
                            if (playerContainer2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
                                playerContainer2 = null;
                            }
                            playerContainer2.getPlayerServiceManager().getMembersInjector().injectMembers(widget);
                        } else {
                            PlayerServiceInjector serviceInjector = record.getServiceInjector();
                            playerContainer = this.this$0.playerContainer;
                            if (playerContainer == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
                                playerContainer = null;
                            }
                            serviceInjector.injectPlayerServices(widget, playerContainer);
                        }
                        record.setBindToViewJob(BuildersKt.launch$default($this$launch, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(widget, null), 1, (Object) null));
                    }
                    this.label = 1;
                    if (DelayKt.awaitCancellation((Continuation) this) == coroutine_suspended) {
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
        } catch (Throwable th) {
            this.this$0.onChildWidgetDismiss();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbsGroupWidget.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.biliplayerv2.widget.AbsGroupWidget$onWidgetShow$1$1", f = "AbsGroupWidget.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.biliplayerv2.widget.AbsGroupWidget$onWidgetShow$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IControlWidget $widget;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(IControlWidget iControlWidget, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$widget = iControlWidget;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$widget, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.$widget.onWidgetActive();
                    this.label = 1;
                    if (this.$widget.bindToView((Continuation) this) == coroutine_suspended) {
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