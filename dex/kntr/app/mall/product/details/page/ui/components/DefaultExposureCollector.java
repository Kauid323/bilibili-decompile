package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.ui.geometry.Rect;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: Exposer.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkntr/app/mall/product/details/page/ui/components/DefaultExposureCollector;", "Lkntr/app/mall/product/details/page/ui/components/IExposureCollector;", RedirectImpKt.REDIRECT_KV_CONFIG, "Lkntr/app/mall/product/details/page/ui/components/ExposureConfig;", "<init>", "(Lkntr/app/mall/product/details/page/ui/components/ExposureConfig;)V", "mVisibleLayoutInfo", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkntr/app/mall/product/details/page/ui/components/VisibleLayoutInfo;", "mExposed", "", "mVisible", "start", "", "onExpose", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCollect", "layoutInfo", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DefaultExposureCollector implements IExposureCollector {
    public static final int $stable = 8;
    private final ExposureConfig config;
    private boolean mExposed;
    private boolean mVisible;
    private final MutableStateFlow<VisibleLayoutInfo> mVisibleLayoutInfo;

    public DefaultExposureCollector(ExposureConfig config) {
        Intrinsics.checkNotNullParameter(config, RedirectImpKt.REDIRECT_KV_CONFIG);
        this.config = config;
        this.mVisibleLayoutInfo = StateFlowKt.MutableStateFlow((Object) null);
    }

    @Override // kntr.app.mall.product.details.page.ui.components.IExposureCollector
    public Object start(final Function0<Unit> function0, Continuation<? super Unit> continuation) {
        this.mVisible = false;
        final Flow $this$map$iv = this.mVisibleLayoutInfo;
        Object collect = FlowKt.filterNotNull(FlowKt.mapLatest(new Flow<Boolean>() { // from class: kntr.app.mall.product.details.page.ui.components.DefaultExposureCollector$start$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* renamed from: kntr.app.mall.product.details.page.ui.components.DefaultExposureCollector$start$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ DefaultExposureCollector this$0;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.DefaultExposureCollector$start$$inlined$map$1$2", f = "Exposer.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: kntr.app.mall.product.details.page.ui.components.DefaultExposureCollector$start$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, DefaultExposureCollector defaultExposureCollector) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = defaultExposureCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    ExposureConfig exposureConfig;
                    ExposureConfig exposureConfig2;
                    ExposureConfig exposureConfig3;
                    ExposureConfig exposureConfig4;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    AnonymousClass1 anonymousClass1 = $continuation;
                                    VisibleLayoutInfo layoutInfo = (VisibleLayoutInfo) value;
                                    boolean z = false;
                                    if (layoutInfo != null) {
                                        exposureConfig = this.this$0.config;
                                        if (exposureConfig.getVisibleProportion() > 0.0f) {
                                            float visibleProportion = layoutInfo.getVisibleProportion();
                                            exposureConfig4 = this.this$0.config;
                                            if (visibleProportion >= exposureConfig4.getVisibleProportion()) {
                                                z = true;
                                            }
                                        } else {
                                            Rect this_$iv = layoutInfo.getVisibleRect();
                                            exposureConfig2 = this.this$0.config;
                                            if (this_$iv.getRight() - this_$iv.getLeft() >= exposureConfig2.getVisiblePixelAbsolute()) {
                                                Rect this_$iv2 = layoutInfo.getVisibleRect();
                                                exposureConfig3 = this.this$0.config;
                                                if (this_$iv2.getBottom() - this_$iv2.getTop() >= exposureConfig3.getVisiblePixelAbsolute()) {
                                                    z = true;
                                                }
                                            }
                                        }
                                    }
                                    Boolean boxBoolean = Boxing.boxBoolean(z);
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit(boxBoolean, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                    Object obj2 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect2 = $this$map$iv.collect(new AnonymousClass2(collector, this), $completion);
                return collect2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect2 : Unit.INSTANCE;
            }
        }, new DefaultExposureCollector$start$3(this, null))).collect(new FlowCollector() { // from class: kntr.app.mall.product.details.page.ui.components.DefaultExposureCollector$start$4
            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                return emit((Unit) value, (Continuation<? super Unit>) $completion);
            }

            /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
                if (r0.getRepeatable() != false) goto L12;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(Unit it, Continuation<? super Unit> continuation2) {
                boolean z;
                boolean z2;
                ExposureConfig exposureConfig;
                z = DefaultExposureCollector.this.mVisible;
                if (z) {
                    return Unit.INSTANCE;
                }
                DefaultExposureCollector.this.mVisible = true;
                z2 = DefaultExposureCollector.this.mExposed;
                if (z2) {
                    exposureConfig = DefaultExposureCollector.this.config;
                }
                DefaultExposureCollector.this.mExposed = true;
                function0.invoke();
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    @Override // kntr.app.mall.product.details.page.ui.components.IExposureCollector
    public void onCollect(VisibleLayoutInfo layoutInfo) {
        this.mVisibleLayoutInfo.setValue(layoutInfo);
    }
}