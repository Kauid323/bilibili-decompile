package kntr.common.ouro.ui.span;

import android.view.View;
import com.bilibili.lib.image2.bean.ImageDataSource;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.ouro.core.model.node.renderable.OuroLocalImage;
import kntr.common.photonic.gallery.asset.AndroidGalleryImageFinder;
import kntr.common.photonic.gallery.entity.AndroidImage;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroDrawableSpan.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.ui.span.OuroDrawableSpan$loadLocalImage$1", f = "OuroDrawableSpan.kt", i = {}, l = {346}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OuroDrawableSpan$loadLocalImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ MockLifecycle $lifecycle;
    final /* synthetic */ OuroLocalImage $node;
    final /* synthetic */ View $view;
    int label;
    final /* synthetic */ OuroDrawableSpan this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroDrawableSpan$loadLocalImage$1(OuroLocalImage ouroLocalImage, OuroDrawableSpan ouroDrawableSpan, View view, MockLifecycle mockLifecycle, Continuation<? super OuroDrawableSpan$loadLocalImage$1> continuation) {
        super(2, continuation);
        this.$node = ouroLocalImage;
        this.this$0 = ouroDrawableSpan;
        this.$view = view;
        this.$lifecycle = mockLifecycle;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OuroDrawableSpan$loadLocalImage$1(this.$node, this.this$0, this.$view, this.$lifecycle, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        ImageDataSource obtainImageDataSource;
        ImageDataSource imageDataSource;
        OuroDrawableSpan$createImageDataSubscriber$1 createImageDataSubscriber;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    Object mo2332findAssetByIdentifiergIAlus = new AndroidGalleryImageFinder().mo2332findAssetByIdentifiergIAlus(this.$node.getAsset().getIdentifier(), (Continuation) this);
                    if (mo2332findAssetByIdentifiergIAlus == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = mo2332findAssetByIdentifiergIAlus;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    obj = ((Result) $result).m2645unboximpl();
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            OuroDrawableSpan ouroDrawableSpan = this.this$0;
            View view = this.$view;
            MockLifecycle mockLifecycle = this.$lifecycle;
            if (Result.m2643isSuccessimpl(obj)) {
                AndroidImage image = (AndroidImage) obj;
                obtainImageDataSource = ouroDrawableSpan.obtainImageDataSource(view, mockLifecycle, image.getUri());
                ouroDrawableSpan.dataSource = obtainImageDataSource;
                imageDataSource = ouroDrawableSpan.dataSource;
                if (imageDataSource != null) {
                    createImageDataSubscriber = ouroDrawableSpan.createImageDataSubscriber();
                    imageDataSource.subscribe(createImageDataSubscriber);
                }
            }
            OuroLocalImage ouroLocalImage = this.$node;
            if (Result.m2639exceptionOrNullimpl(obj) != null) {
                KLog_androidKt.getKLog().w("OuroDrawableSpan", "Failed to find asset " + ouroLocalImage.getAsset());
            }
            return Result.m2635boximpl(obj);
        } catch (Exception e) {
            KLog_androidKt.getKLog().w("OuroDrawableSpan", "OuroImageDrawable Failed to load local image: " + e.getMessage());
            return Unit.INSTANCE;
        }
    }
}