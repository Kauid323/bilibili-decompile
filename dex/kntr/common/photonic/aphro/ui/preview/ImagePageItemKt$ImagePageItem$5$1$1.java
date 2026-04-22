package kntr.common.photonic.aphro.ui.preview;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.unit.IntSize;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageSource;
import kntr.base.log.KLog_androidKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.Resolution;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewItemState;
import kntr.common.photonic.aphro.ui.preview.state.ImagePreviewState;
import kntr.common.photonic.shower.AssetShower;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImagePageItem.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$ImagePageItem$5$1$1", f = "ImagePageItem.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ImagePageItemKt$ImagePageItem$5$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PreviewableAsset $asset;
    final /* synthetic */ MutableState<Result<ImageSource>> $imageSource$delegate;
    final /* synthetic */ ImagePreviewItemState $item;
    final /* synthetic */ MutableState<IntSize> $pictureSize$delegate;
    final /* synthetic */ AssetShower<Asset> $shower;
    final /* synthetic */ ImagePreviewState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePageItemKt$ImagePageItem$5$1$1(ImagePreviewItemState imagePreviewItemState, MutableState<IntSize> mutableState, ImagePreviewState imagePreviewState, AssetShower<Asset> assetShower, PreviewableAsset previewableAsset, MutableState<Result<ImageSource>> mutableState2, Continuation<? super ImagePageItemKt$ImagePageItem$5$1$1> continuation) {
        super(2, continuation);
        this.$item = imagePreviewItemState;
        this.$pictureSize$delegate = mutableState;
        this.$state = imagePreviewState;
        this.$shower = assetShower;
        this.$asset = previewableAsset;
        this.$imageSource$delegate = mutableState2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImagePageItemKt$ImagePageItem$5$1$1(this.$item, this.$pictureSize$delegate, this.$state, this.$shower, this.$asset, this.$imageSource$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final ImagePreviewItemState imagePreviewItemState = this.$item;
                Flow $this$flatMapLatest$iv = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$ImagePageItem$5$1$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        int invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = ImagePageItemKt$ImagePageItem$5$1$1.invokeSuspend$lambda$0(ImagePreviewItemState.this);
                        return Integer.valueOf(invokeSuspend$lambda$0);
                    }
                });
                final Flow $this$flatMapLatest$iv2 = FlowKt.transformLatest($this$flatMapLatest$iv, new ImagePageItemKt$ImagePageItem$5$1$1$invokeSuspend$$inlined$flatMapLatest$1(null, this.$item));
                final MutableState<IntSize> mutableState = this.$pictureSize$delegate;
                this.label = 1;
                if (FlowKt.collectLatest(new Flow<Resolution>() { // from class: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$ImagePageItem$5$1$1$invokeSuspend$$inlined$map$1
                    public Object collect(FlowCollector collector, Continuation $completion) {
                        Object collect = $this$flatMapLatest$iv2.collect(new AnonymousClass2(collector, mutableState), $completion);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* renamed from: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$ImagePageItem$5$1$1$invokeSuspend$$inlined$map$1$2  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ MutableState $pictureSize$delegate$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        @DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$ImagePageItem$5$1$1$invokeSuspend$$inlined$map$1$2", f = "ImagePageItem.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                        /* renamed from: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$ImagePageItem$5$1$1$invokeSuspend$$inlined$map$1$2$1  reason: invalid class name */
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

                        public AnonymousClass2(FlowCollector flowCollector, MutableState mutableState) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$pictureSize$delegate$inlined = mutableState;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                        /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                        /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object emit(Object value, Continuation $completion) {
                            Continuation $continuation;
                            Resolution resolution;
                            long ImagePageItem$lambda$4;
                            long ImagePageItem$lambda$42;
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
                                            boolean it = ((Boolean) value).booleanValue();
                                            if (!it) {
                                                ImagePageItem$lambda$4 = ImagePageItemKt.ImagePageItem$lambda$4(this.$pictureSize$delegate$inlined);
                                                ImagePageItem$lambda$42 = ImagePageItemKt.ImagePageItem$lambda$4(this.$pictureSize$delegate$inlined);
                                                resolution = new Resolution(((int) (ImagePageItem$lambda$4 >> 32)) * 3, ((int) (ImagePageItem$lambda$42 & 4294967295L)) * 3);
                                            } else {
                                                resolution = null;
                                            }
                                            $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                            $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                            $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                            $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                            $continuation.I$0 = 0;
                                            $continuation.label = 1;
                                            if ($this$map_u24lambda_u245.emit(resolution, $continuation) != coroutine_suspended) {
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
                }, new AnonymousClass4(this.$state, this.$shower, this.$item, this.$asset, this.$imageSource$delegate, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final int invokeSuspend$lambda$0(ImagePreviewItemState $item) {
        return $item.getRetryCount().getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImagePageItem.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "expectResolution", "Lkntr/common/photonic/Resolution;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$ImagePageItem$5$1$1$4", f = "ImagePageItem.kt", i = {0, 0, 0}, l = {228}, m = "invokeSuspend", n = {"expectResolution", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-ImagePageItemKt$ImagePageItem$5$1$1$4$1"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    /* renamed from: kntr.common.photonic.aphro.ui.preview.ImagePageItemKt$ImagePageItem$5$1$1$4  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<Resolution, Continuation<? super Unit>, Object> {
        final /* synthetic */ PreviewableAsset $asset;
        final /* synthetic */ MutableState<Result<ImageSource>> $imageSource$delegate;
        final /* synthetic */ ImagePreviewItemState $item;
        final /* synthetic */ AssetShower<Asset> $shower;
        final /* synthetic */ ImagePreviewState $state;
        int I$0;
        int I$1;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(ImagePreviewState imagePreviewState, AssetShower<Asset> assetShower, ImagePreviewItemState imagePreviewItemState, PreviewableAsset previewableAsset, MutableState<Result<ImageSource>> mutableState, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$state = imagePreviewState;
            this.$shower = assetShower;
            this.$item = imagePreviewItemState;
            this.$asset = previewableAsset;
            this.$imageSource$delegate = mutableState;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass4 = new AnonymousClass4(this.$state, this.$shower, this.$item, this.$asset, this.$imageSource$delegate, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        public final Object invoke(Resolution resolution, Continuation<? super Unit> continuation) {
            return create(resolution, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            MutableState<Result<ImageSource>> mutableState;
            int $i$f$runSuspendCatching;
            ImageSource imageSource;
            Object imageSource2;
            int i;
            int $i$f$runSuspendCatching2;
            Throwable th;
            Object m2636constructorimpl;
            Throwable e;
            Resolution expectResolution = (Resolution) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.$state.getCurrentResolution().setValue(expectResolution);
                    mutableState = this.$imageSource$delegate;
                    AssetShower<Asset> assetShower = this.$shower;
                    ImagePreviewItemState imagePreviewItemState = this.$item;
                    $i$f$runSuspendCatching = 0;
                    try {
                        Result.Companion companion = Result.Companion;
                    } catch (Throwable th2) {
                        th = th2;
                        $i$f$runSuspendCatching2 = $i$f$runSuspendCatching;
                        Result.Companion companion2 = Result.Companion;
                        m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                        JobKt.ensureActive(getContext());
                        PreviewableAsset previewableAsset = this.$asset;
                        e = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                        if (e != null) {
                        }
                        ImagePageItemKt.ImagePageItem$lambda$11(mutableState, m2636constructorimpl);
                        return Unit.INSTANCE;
                    }
                    if (assetShower == null) {
                        imageSource = null;
                        m2636constructorimpl = Result.m2636constructorimpl(imageSource);
                        JobKt.ensureActive(getContext());
                        PreviewableAsset previewableAsset2 = this.$asset;
                        e = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                        if (e != null) {
                        }
                        ImagePageItemKt.ImagePageItem$lambda$11(mutableState, m2636constructorimpl);
                        return Unit.INSTANCE;
                    }
                    this.L$0 = expectResolution;
                    this.L$1 = mutableState;
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    imageSource2 = assetShower.getImageSource(imagePreviewItemState.getAsset(), expectResolution, true, this);
                    if (imageSource2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i = 0;
                    imageSource = (ImageSource) imageSource2;
                    m2636constructorimpl = Result.m2636constructorimpl(imageSource);
                    JobKt.ensureActive(getContext());
                    PreviewableAsset previewableAsset22 = this.$asset;
                    e = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                    if (e != null) {
                        KLog_androidKt.getKLog().e("ImagePreview", "Fail to load image source of " + previewableAsset22.getIdentifier() + " with resolution " + expectResolution, e);
                    }
                    ImagePageItemKt.ImagePageItem$lambda$11(mutableState, m2636constructorimpl);
                    return Unit.INSTANCE;
                case 1:
                    i = this.I$1;
                    $i$f$runSuspendCatching2 = this.I$0;
                    mutableState = (MutableState) this.L$1;
                    try {
                        ResultKt.throwOnFailure($result);
                        $i$f$runSuspendCatching = $i$f$runSuspendCatching2;
                        imageSource2 = $result;
                        imageSource = (ImageSource) imageSource2;
                        m2636constructorimpl = Result.m2636constructorimpl(imageSource);
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion22 = Result.Companion;
                        m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                        JobKt.ensureActive(getContext());
                        PreviewableAsset previewableAsset222 = this.$asset;
                        e = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                        if (e != null) {
                        }
                        ImagePageItemKt.ImagePageItem$lambda$11(mutableState, m2636constructorimpl);
                        return Unit.INSTANCE;
                    }
                    JobKt.ensureActive(getContext());
                    PreviewableAsset previewableAsset2222 = this.$asset;
                    e = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                    if (e != null) {
                    }
                    ImagePageItemKt.ImagePageItem$lambda$11(mutableState, m2636constructorimpl);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}