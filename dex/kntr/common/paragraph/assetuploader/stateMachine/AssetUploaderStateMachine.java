package kntr.common.paragraph.assetuploader.stateMachine;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kntr.common.paragraph.assetuploader.base.OriginAssetUploadState;
import kntr.common.paragraph.assetuploader.base.UploadingAssetUploadState;
import kntr.common.paragraph.watermark.WaterMarkConfigProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

/* compiled from: AssetUploaderStateMachine.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/common/paragraph/assetuploader/base/AssetUploadState;", "", "originAssetUploadState", "Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;", "uploader", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "paramProvider", "Lkntr/common/paragraph/watermark/WaterMarkConfigProvider;", "<init>", "(Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;Lkntr/common/paragraph/assetuploader/AssetUploader;Lkntr/common/paragraph/watermark/WaterMarkConfigProvider;)V", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetUploaderStateMachine extends FlowReduxStateMachine {
    private final WaterMarkConfigProvider paramProvider;
    private final AssetUploader uploader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @AssistedInject
    public AssetUploaderStateMachine(@Assisted("") OriginAssetUploadState originAssetUploadState, AssetUploader uploader, WaterMarkConfigProvider paramProvider) {
        super(originAssetUploadState);
        Intrinsics.checkNotNullParameter(originAssetUploadState, "originAssetUploadState");
        Intrinsics.checkNotNullParameter(uploader, "uploader");
        Intrinsics.checkNotNullParameter(paramProvider, "paramProvider");
        this.uploader = uploader;
        this.paramProvider = paramProvider;
        spec(new Function1() { // from class: kntr.common.paragraph.assetuploader.stateMachine.AssetUploaderStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = AssetUploaderStateMachine._init_$lambda$0(AssetUploaderStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final AssetUploaderStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: kntr.common.paragraph.assetuploader.stateMachine.AssetUploaderStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return AssetUploaderStateMachine.lambda$0$0(AssetUploaderStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(OriginAssetUploadState.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: kntr.common.paragraph.assetuploader.stateMachine.AssetUploaderStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return AssetUploaderStateMachine.lambda$0$1((InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(UploadingAssetUploadState.class), block$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(AssetUploaderStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new AssetUploaderStateMachine$1$1$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new AssetUploaderStateMachine$1$2$1(null));
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$inState, new Function1() { // from class: kntr.common.paragraph.assetuploader.stateMachine.AssetUploaderStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return AssetUploaderStateMachine.lambda$0$1$0((UploadingAssetUploadState) obj);
            }
        }, (ExecutionPolicy) null, new AssetUploaderStateMachine$1$2$3(null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Flow lambda$0$1$0(UploadingAssetUploadState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getTask$assetuploader_debug().getProgress();
    }
}