package kntr.app.im.chat.service.sender.image;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.im.chat.core.service.NetworkSendMessageService;
import kntr.app.im.chat.network.MsgModuleTransformers;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageMessageSender_Factory.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/im/chat/service/sender/image/ImageMessageSender_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/service/sender/image/ImageMessageSender;", "assetUploaderProvider", "Ljavax/inject/Provider;", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "transformersProvider", "Lkntr/app/im/chat/network/MsgModuleTransformers;", "copierProvider", "Lkntr/app/im/chat/service/sender/image/AssetCopier;", "networkSendMessageServiceProvider", "Lkntr/app/im/chat/core/service/NetworkSendMessageService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageMessageSender_Factory implements Factory<ImageMessageSender> {
    private final Provider<AssetUploader> assetUploaderProvider;
    private final Provider<AssetCopier> copierProvider;
    private final Provider<NetworkSendMessageService> networkSendMessageServiceProvider;
    private final Provider<MsgModuleTransformers> transformersProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ImageMessageSender_Factory(Provider<AssetUploader> provider, Provider<MsgModuleTransformers> provider2, Provider<AssetCopier> provider3, Provider<NetworkSendMessageService> provider4) {
        Intrinsics.checkNotNullParameter(provider, "assetUploaderProvider");
        Intrinsics.checkNotNullParameter(provider2, "transformersProvider");
        Intrinsics.checkNotNullParameter(provider3, "copierProvider");
        Intrinsics.checkNotNullParameter(provider4, "networkSendMessageServiceProvider");
        this.assetUploaderProvider = provider;
        this.transformersProvider = provider2;
        this.copierProvider = provider3;
        this.networkSendMessageServiceProvider = provider4;
    }

    public ImageMessageSender get() {
        Companion companion = Companion;
        AssetUploader assetUploader = this.assetUploaderProvider.get();
        Intrinsics.checkNotNullExpressionValue(assetUploader, "get(...)");
        MsgModuleTransformers msgModuleTransformers = this.transformersProvider.get();
        Intrinsics.checkNotNullExpressionValue(msgModuleTransformers, "get(...)");
        AssetCopier assetCopier = this.copierProvider.get();
        Intrinsics.checkNotNullExpressionValue(assetCopier, "get(...)");
        NetworkSendMessageService networkSendMessageService = this.networkSendMessageServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(networkSendMessageService, "get(...)");
        return companion.newInstance(assetUploader, msgModuleTransformers, assetCopier, networkSendMessageService);
    }

    /* compiled from: ImageMessageSender_Factory.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0007J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0007¨\u0006\u0015"}, d2 = {"Lkntr/app/im/chat/service/sender/image/ImageMessageSender_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/service/sender/image/ImageMessageSender_Factory;", "assetUploaderProvider", "Ljavax/inject/Provider;", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "transformersProvider", "Lkntr/app/im/chat/network/MsgModuleTransformers;", "copierProvider", "Lkntr/app/im/chat/service/sender/image/AssetCopier;", "networkSendMessageServiceProvider", "Lkntr/app/im/chat/core/service/NetworkSendMessageService;", "newInstance", "Lkntr/app/im/chat/service/sender/image/ImageMessageSender;", "assetUploader", "transformers", "copier", "networkSendMessageService", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ImageMessageSender_Factory create(Provider<AssetUploader> provider, Provider<MsgModuleTransformers> provider2, Provider<AssetCopier> provider3, Provider<NetworkSendMessageService> provider4) {
            Intrinsics.checkNotNullParameter(provider, "assetUploaderProvider");
            Intrinsics.checkNotNullParameter(provider2, "transformersProvider");
            Intrinsics.checkNotNullParameter(provider3, "copierProvider");
            Intrinsics.checkNotNullParameter(provider4, "networkSendMessageServiceProvider");
            return new ImageMessageSender_Factory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final ImageMessageSender newInstance(AssetUploader assetUploader, MsgModuleTransformers transformers, AssetCopier copier, NetworkSendMessageService networkSendMessageService) {
            Intrinsics.checkNotNullParameter(assetUploader, "assetUploader");
            Intrinsics.checkNotNullParameter(transformers, "transformers");
            Intrinsics.checkNotNullParameter(copier, "copier");
            Intrinsics.checkNotNullParameter(networkSendMessageService, "networkSendMessageService");
            return new ImageMessageSender(assetUploader, transformers, copier, networkSendMessageService);
        }
    }

    @JvmStatic
    public static final ImageMessageSender_Factory create(Provider<AssetUploader> provider, Provider<MsgModuleTransformers> provider2, Provider<AssetCopier> provider3, Provider<NetworkSendMessageService> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final ImageMessageSender newInstance(AssetUploader assetUploader, MsgModuleTransformers transformers, AssetCopier copier, NetworkSendMessageService networkSendMessageService) {
        return Companion.newInstance(assetUploader, transformers, copier, networkSendMessageService);
    }
}