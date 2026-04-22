package kntr.app.im.chat.ui.module.localPicture;

import androidx.compose.runtime.MutableState;
import kntr.app.im.chat.service.sender.image.LocalImageAsset;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.ImageSource;
import kntr.common.photonic.Resolution;
import kntr.common.photonic.shower.AssetShower;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalPictureModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.module.localPicture.LocalPictureModuleKt$LocalImage$1$1", f = "LocalPictureModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LocalPictureModuleKt$LocalImage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LocalImageAsset $asset;
    final /* synthetic */ Resolution $expectResolution;
    final /* synthetic */ MutableState<ImageSource> $imageSource$delegate;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ AssetShower<LocalImageAsset> $shower;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalPictureModuleKt$LocalImage$1$1(CoroutineScope coroutineScope, LocalImageAsset localImageAsset, AssetShower<LocalImageAsset> assetShower, Resolution resolution, MutableState<ImageSource> mutableState, Continuation<? super LocalPictureModuleKt$LocalImage$1$1> continuation) {
        super(2, continuation);
        this.$scope = coroutineScope;
        this.$asset = localImageAsset;
        this.$shower = assetShower;
        this.$expectResolution = resolution;
        this.$imageSource$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalPictureModuleKt$LocalImage$1$1(this.$scope, this.$asset, this.$shower, this.$expectResolution, this.$imageSource$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LocalPictureModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.im.chat.ui.module.localPicture.LocalPictureModuleKt$LocalImage$1$1$1", f = "LocalPictureModule.kt", i = {0, 0}, l = {143}, m = "invokeSuspend", n = {"it", "$i$a$-let-LocalPictureModuleKt$LocalImage$1$1$1$1"}, s = {"L$0", "I$0"}, v = 1)
    /* renamed from: kntr.app.im.chat.ui.module.localPicture.LocalPictureModuleKt$LocalImage$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LocalImageAsset $asset;
        final /* synthetic */ Resolution $expectResolution;
        final /* synthetic */ MutableState<ImageSource> $imageSource$delegate;
        final /* synthetic */ AssetShower<LocalImageAsset> $shower;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LocalImageAsset localImageAsset, AssetShower<LocalImageAsset> assetShower, Resolution resolution, MutableState<ImageSource> mutableState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$asset = localImageAsset;
            this.$shower = assetShower;
            this.$expectResolution = resolution;
            this.$imageSource$delegate = mutableState;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$asset, this.$shower, this.$expectResolution, this.$imageSource$delegate, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MutableState<ImageSource> mutableState;
            ImageSource imageSource;
            Object imageSource2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    mutableState = this.$imageSource$delegate;
                    LocalImageAsset it = this.$asset;
                    AssetShower<LocalImageAsset> assetShower = this.$shower;
                    Resolution resolution = this.$expectResolution;
                    if (assetShower == null) {
                        imageSource = null;
                        break;
                    } else {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = mutableState;
                        this.I$0 = 0;
                        this.label = 1;
                        imageSource2 = assetShower.getImageSource(it, resolution, true, this);
                        if (imageSource2 != coroutine_suspended) {
                            imageSource = (ImageSource) imageSource2;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    }
                case 1:
                    int i = this.I$0;
                    mutableState = (MutableState) this.L$1;
                    LocalImageAsset localImageAsset = (LocalImageAsset) this.L$0;
                    ResultKt.throwOnFailure($result);
                    imageSource2 = $result;
                    imageSource = (ImageSource) imageSource2;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
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
                BuildersKt.launch$default(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$asset, this.$shower, this.$expectResolution, this.$imageSource$delegate, null), 3, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}