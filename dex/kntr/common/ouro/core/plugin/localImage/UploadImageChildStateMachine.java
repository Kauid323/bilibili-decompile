package kntr.common.ouro.core.plugin.localImage;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.renderable.UploadTaskState;
import kntr.common.ouro.core.plugin.localImage.UploadImageChildAction;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kntr.common.photonic.Asset;
import kntr.common.photonic.ContentSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

/* compiled from: UploadImageChildStateMachine.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lkntr/common/ouro/core/plugin/localImage/UploadImageChildStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState;", "Lkntr/common/ouro/core/plugin/localImage/UploadImageChildAction;", "asset", "Lkntr/common/photonic/Asset;", "useOriginalImage", "", "uploader", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "initialState", "<init>", "(Lkntr/common/photonic/Asset;ZLkntr/common/paragraph/assetuploader/AssetUploader;Lkntr/common/ouro/core/model/node/renderable/UploadTaskState;)V", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UploadImageChildStateMachine extends FlowReduxStateMachine<UploadTaskState, UploadImageChildAction> {
    public static final Companion Companion = new Companion(null);
    private static final Semaphore semaphore = SemaphoreKt.Semaphore$default(1, 0, 2, (Object) null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadImageChildStateMachine(final Asset asset, final boolean useOriginalImage, final AssetUploader uploader, UploadTaskState initialState) {
        super(initialState == null ? new UploadTaskState.Idle(asset.getIdentifier()) : initialState);
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(uploader, "uploader");
        spec(new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = UploadImageChildStateMachine._init_$lambda$0(AssetUploader.this, asset, useOriginalImage, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* compiled from: UploadImageChildStateMachine.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/common/ouro/core/plugin/localImage/UploadImageChildStateMachine$Companion;", "", "<init>", "()V", "semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final AssetUploader $uploader, final Asset $asset, final boolean $useOriginalImage, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return UploadImageChildStateMachine.lambda$0$0(AssetUploader.this, $asset, $useOriginalImage, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(UploadTaskState.Idle.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return UploadImageChildStateMachine.lambda$0$1((InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(UploadTaskState.Uploading.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return UploadImageChildStateMachine.lambda$0$2((InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(UploadTaskState.Uploading.class), block$iv3);
        Function1 block$iv4 = new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return UploadImageChildStateMachine.lambda$0$3((InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(UploadTaskState.Failure.class), block$iv4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(AssetUploader $uploader, Asset $asset, boolean $useOriginalImage, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new UploadImageChildStateMachine$1$1$1($uploader, $asset, $useOriginalImage, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new UploadImageChildStateMachine$1$2$1(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$2(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.condition(new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UploadImageChildStateMachine.lambda$0$2$0((UploadTaskState.Uploading) obj));
            }
        }, new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return UploadImageChildStateMachine.lambda$0$2$1((ConditionBuilderBlock) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean lambda$0$2$0(UploadTaskState.Uploading it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ContentSize.m2187getBytesimpl(it.getTask$core_debug().mo2151getTaskContentSizeQJZHGII()) > 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$2$1(ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$condition, new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return UploadImageChildStateMachine.lambda$0$2$1$0((UploadTaskState.Uploading) obj);
            }
        }, (ExecutionPolicy) null, new UploadImageChildStateMachine$1$3$2$2(null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Flow lambda$0$2$1$0(UploadTaskState.Uploading it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getTask$core_debug().getProgress();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$3(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new UploadImageChildStateMachine$1$4$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(UploadImageChildAction.Retry.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }
}