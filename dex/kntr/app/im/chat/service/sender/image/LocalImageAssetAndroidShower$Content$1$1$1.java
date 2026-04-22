package kntr.app.im.chat.service.sender.image;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.Constraints;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.ImageSource;
import kntr.common.photonic.Resolution;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalImageAsset.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.sender.image.LocalImageAssetAndroidShower$Content$1$1$1", f = "LocalImageAsset.android.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LocalImageAssetAndroidShower$Content$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $animated;
    final /* synthetic */ LocalImageAsset $asset;
    final /* synthetic */ MutableState<ImageSource> $imageSource;
    final /* synthetic */ BoxWithConstraintsScope $this_BoxWithConstraints;
    Object L$0;
    int label;
    final /* synthetic */ LocalImageAssetAndroidShower this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalImageAssetAndroidShower$Content$1$1$1(MutableState<ImageSource> mutableState, LocalImageAssetAndroidShower localImageAssetAndroidShower, LocalImageAsset localImageAsset, BoxWithConstraintsScope boxWithConstraintsScope, boolean z, Continuation<? super LocalImageAssetAndroidShower$Content$1$1$1> continuation) {
        super(2, continuation);
        this.$imageSource = mutableState;
        this.this$0 = localImageAssetAndroidShower;
        this.$asset = localImageAsset;
        this.$this_BoxWithConstraints = boxWithConstraintsScope;
        this.$animated = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalImageAssetAndroidShower$Content$1$1$1(this.$imageSource, this.this$0, this.$asset, this.$this_BoxWithConstraints, this.$animated, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Resolution resolution;
        Object imageSource;
        MutableState<ImageSource> mutableState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MutableState<ImageSource> mutableState2 = this.$imageSource;
                LocalImageAssetAndroidShower localImageAssetAndroidShower = this.this$0;
                LocalImageAsset localImageAsset = this.$asset;
                if (Constraints.getHasBoundedHeight-impl(this.$this_BoxWithConstraints.getConstraints-msEJaDk()) && Constraints.getHasBoundedWidth-impl(this.$this_BoxWithConstraints.getConstraints-msEJaDk())) {
                    resolution = new Resolution(Constraints.getMaxWidth-impl(this.$this_BoxWithConstraints.getConstraints-msEJaDk()), Constraints.getMaxHeight-impl(this.$this_BoxWithConstraints.getConstraints-msEJaDk()));
                } else {
                    resolution = null;
                }
                this.L$0 = mutableState2;
                this.label = 1;
                imageSource = localImageAssetAndroidShower.getImageSource(localImageAsset, resolution, this.$animated, (Continuation) this);
                if (imageSource == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableState = mutableState2;
                break;
            case 1:
                mutableState = (MutableState) this.L$0;
                ResultKt.throwOnFailure($result);
                imageSource = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableState.setValue(imageSource);
        return Unit.INSTANCE;
    }
}