package kntr.common.paragraph.assetuploader;

import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.base.AssetUploadState;
import kntr.common.paragraph.assetuploader.base.OriginAssetUploadState;
import kntr.common.paragraph.assetuploader.di.AssetUploaderCoroutineScope;
import kntr.common.paragraph.assetuploader.stateMachine.AssetUploaderStateMachine;
import kntr.common.paragraph.assetuploader.stateMachine.AssetUploaderStateMachineFactory;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: AssetUploaderViewModel.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lkntr/common/paragraph/assetuploader/AssetUploaderViewModel;", "", "asset", "Lkntr/common/photonic/Asset;", "useOrigin", "", "stateMachineFactory", "Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachineFactory;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkntr/common/photonic/Asset;ZLkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachineFactory;Lkotlinx/coroutines/CoroutineScope;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "init", "Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;", "stateMachine", "Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachine;", "data", "Lkotlinx/coroutines/flow/StateFlow;", "Lkntr/common/paragraph/assetuploader/base/AssetUploadState;", "getData$annotations", "()V", "getData", "()Lkotlinx/coroutines/flow/StateFlow;", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetUploaderViewModel {
    private final StateFlow<AssetUploadState> data;
    private final OriginAssetUploadState init;
    private final CoroutineScope scope;
    private final AssetUploaderStateMachine stateMachine;

    public static /* synthetic */ void getData$annotations() {
    }

    @AssistedInject
    public AssetUploaderViewModel(@Assisted("") Asset asset, @Assisted("") boolean useOrigin, AssetUploaderStateMachineFactory stateMachineFactory, @AssetUploaderCoroutineScope CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(stateMachineFactory, "stateMachineFactory");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.init = new OriginAssetUploadState(asset, useOrigin);
        this.stateMachine = stateMachineFactory.create(this.init);
        this.data = FlowKt.stateIn(this.stateMachine.getState(), this.scope, SharingStarted.Companion.getLazily(), this.init);
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final StateFlow<AssetUploadState> getData() {
        return this.data;
    }
}