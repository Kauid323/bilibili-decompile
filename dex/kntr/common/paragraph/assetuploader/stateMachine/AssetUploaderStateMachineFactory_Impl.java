package kntr.common.paragraph.assetuploader.stateMachine;

import dagger.internal.InstanceFactory;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.base.OriginAssetUploadState;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetUploaderStateMachineFactory_Impl.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachineFactory_Impl;", "Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachineFactory;", "delegateFactory", "Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachine_Factory;", "<init>", "(Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachine_Factory;)V", "create", "Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachine;", "originAssetUploadState", "Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;", "Companion", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetUploaderStateMachineFactory_Impl implements AssetUploaderStateMachineFactory {
    public static final Companion Companion = new Companion(null);
    private final AssetUploaderStateMachine_Factory delegateFactory;

    public AssetUploaderStateMachineFactory_Impl(AssetUploaderStateMachine_Factory delegateFactory) {
        Intrinsics.checkNotNullParameter(delegateFactory, "delegateFactory");
        this.delegateFactory = delegateFactory;
    }

    @Override // kntr.common.paragraph.assetuploader.stateMachine.AssetUploaderStateMachineFactory
    public AssetUploaderStateMachine create(OriginAssetUploadState originAssetUploadState) {
        Intrinsics.checkNotNullParameter(originAssetUploadState, "originAssetUploadState");
        return this.delegateFactory.get(originAssetUploadState);
    }

    /* compiled from: AssetUploaderStateMachineFactory_Impl.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachineFactory_Impl$Companion;", "", "<init>", "()V", "create", "Ljavax/inject/Provider;", "Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachineFactory;", "delegateFactory", "Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachine_Factory;", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Provider<AssetUploaderStateMachineFactory> create(AssetUploaderStateMachine_Factory delegateFactory) {
            Intrinsics.checkNotNullParameter(delegateFactory, "delegateFactory");
            Provider<AssetUploaderStateMachineFactory> create = InstanceFactory.create(new AssetUploaderStateMachineFactory_Impl(delegateFactory));
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return create;
        }
    }

    @JvmStatic
    public static final Provider<AssetUploaderStateMachineFactory> create(AssetUploaderStateMachine_Factory delegateFactory) {
        return Companion.create(delegateFactory);
    }
}