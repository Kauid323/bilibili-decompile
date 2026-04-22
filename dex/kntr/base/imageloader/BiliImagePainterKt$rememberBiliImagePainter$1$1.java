package kntr.base.imageloader;

import androidx.compose.runtime.MutableState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliImagePainter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.imageloader.BiliImagePainterKt$rememberBiliImagePainter$1$1", f = "BiliImagePainter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BiliImagePainterKt$rememberBiliImagePainter$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<ImageSource> $imageSource$delegate;
    final /* synthetic */ ImmutableImageRequest $request;
    final /* synthetic */ CoroutineScope $scope;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliImagePainterKt$rememberBiliImagePainter$1$1(CoroutineScope coroutineScope, ImmutableImageRequest immutableImageRequest, MutableState<ImageSource> mutableState, Continuation<? super BiliImagePainterKt$rememberBiliImagePainter$1$1> continuation) {
        super(2, continuation);
        this.$scope = coroutineScope;
        this.$request = immutableImageRequest;
        this.$imageSource$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiliImagePainterKt$rememberBiliImagePainter$1$1(this.$scope, this.$request, this.$imageSource$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BiliImagePainter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.base.imageloader.BiliImagePainterKt$rememberBiliImagePainter$1$1$1", f = "BiliImagePainter.kt", i = {}, l = {ConstantsKt.PLAYING_ICON_UNIT_COUNT}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.base.imageloader.BiliImagePainterKt$rememberBiliImagePainter$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<ImageSource> $imageSource$delegate;
        final /* synthetic */ ImmutableImageRequest $request;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ImmutableImageRequest immutableImageRequest, MutableState<ImageSource> mutableState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$request = immutableImageRequest;
            this.$imageSource$delegate = mutableState;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$request, this.$imageSource$delegate, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public final Object invokeSuspend(Object $result) {
            MutableState<ImageSource> mutableState;
            Object loadImage$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r1 = this.label;
            ImageSource imageSource = null;
            try {
                switch (r1) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        MutableState<ImageSource> mutableState2 = this.$imageSource$delegate;
                        this.L$0 = mutableState2;
                        this.L$1 = mutableState2;
                        this.label = 1;
                        loadImage$default = BiliImage_androidKt.loadImage$default(this.$request, null, (Continuation) this, 2, null);
                        if (loadImage$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutableState = mutableState2;
                        r1 = mutableState2;
                        break;
                    case 1:
                        mutableState = (MutableState) this.L$1;
                        MutableState mutableState3 = (MutableState) this.L$0;
                        ResultKt.throwOnFailure($result);
                        loadImage$default = $result;
                        r1 = mutableState3;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                imageSource = (ImageSource) loadImage$default;
            } catch (Exception e) {
                mutableState = r1;
            }
            mutableState.setValue(imageSource);
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BuildersKt.launch$default(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$request, this.$imageSource$delegate, null), 3, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}