package kntr.common.paragraph.assetuploader.stateMachine;

import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kntr.common.paragraph.assetuploader.base.OriginAssetUploadState;
import kntr.common.paragraph.watermark.WaterMarkConfigProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetUploaderStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachine_Factory;", "", "uploaderProvider", "Ljavax/inject/Provider;", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "paramProvider", "Lkntr/common/paragraph/watermark/WaterMarkConfigProvider;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachine;", "originAssetUploadState", "Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;", "Companion", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetUploaderStateMachine_Factory {
    public static final Companion Companion = new Companion(null);
    private final Provider<WaterMarkConfigProvider> paramProvider;
    private final Provider<AssetUploader> uploaderProvider;

    public AssetUploaderStateMachine_Factory(Provider<AssetUploader> provider, Provider<WaterMarkConfigProvider> provider2) {
        Intrinsics.checkNotNullParameter(provider, "uploaderProvider");
        Intrinsics.checkNotNullParameter(provider2, "paramProvider");
        this.uploaderProvider = provider;
        this.paramProvider = provider2;
    }

    public final AssetUploaderStateMachine get(OriginAssetUploadState originAssetUploadState) {
        Intrinsics.checkNotNullParameter(originAssetUploadState, "originAssetUploadState");
        Companion companion = Companion;
        Object obj = this.uploaderProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.paramProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        return companion.newInstance(originAssetUploadState, (AssetUploader) obj, (WaterMarkConfigProvider) obj2);
    }

    /* compiled from: AssetUploaderStateMachine_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u0010"}, d2 = {"Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachine_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachine_Factory;", "uploaderProvider", "Ljavax/inject/Provider;", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "paramProvider", "Lkntr/common/paragraph/watermark/WaterMarkConfigProvider;", "newInstance", "Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachine;", "originAssetUploadState", "Lkntr/common/paragraph/assetuploader/base/OriginAssetUploadState;", "uploader", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AssetUploaderStateMachine_Factory create(Provider<AssetUploader> provider, Provider<WaterMarkConfigProvider> provider2) {
            Intrinsics.checkNotNullParameter(provider, "uploaderProvider");
            Intrinsics.checkNotNullParameter(provider2, "paramProvider");
            return new AssetUploaderStateMachine_Factory(provider, provider2);
        }

        @JvmStatic
        public final AssetUploaderStateMachine newInstance(OriginAssetUploadState originAssetUploadState, AssetUploader uploader, WaterMarkConfigProvider paramProvider) {
            Intrinsics.checkNotNullParameter(originAssetUploadState, "originAssetUploadState");
            Intrinsics.checkNotNullParameter(uploader, "uploader");
            Intrinsics.checkNotNullParameter(paramProvider, "paramProvider");
            return new AssetUploaderStateMachine(originAssetUploadState, uploader, paramProvider);
        }
    }

    @JvmStatic
    public static final AssetUploaderStateMachine_Factory create(Provider<AssetUploader> provider, Provider<WaterMarkConfigProvider> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final AssetUploaderStateMachine newInstance(OriginAssetUploadState originAssetUploadState, AssetUploader uploader, WaterMarkConfigProvider paramProvider) {
        return Companion.newInstance(originAssetUploadState, uploader, paramProvider);
    }
}