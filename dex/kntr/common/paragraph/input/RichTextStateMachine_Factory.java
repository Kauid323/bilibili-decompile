package kntr.common.paragraph.input;

import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.assetuploader.stateMachine.AssetUploaderStateMachineFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RichTextStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/common/paragraph/input/RichTextStateMachine_Factory;", "", "startAssetStateMachineFactoryProvider", "Ljavax/inject/Provider;", "Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachineFactory;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Lkntr/common/paragraph/input/RichTextStateMachine;", "init", "Lkntr/common/paragraph/input/RichTextContent;", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RichTextStateMachine_Factory {
    public static final Companion Companion = new Companion(null);
    private final Provider<AssetUploaderStateMachineFactory> startAssetStateMachineFactoryProvider;

    public RichTextStateMachine_Factory(Provider<AssetUploaderStateMachineFactory> provider) {
        Intrinsics.checkNotNullParameter(provider, "startAssetStateMachineFactoryProvider");
        this.startAssetStateMachineFactoryProvider = provider;
    }

    public final RichTextStateMachine get(RichTextContent init) {
        Intrinsics.checkNotNullParameter(init, "init");
        Companion companion = Companion;
        Object obj = this.startAssetStateMachineFactoryProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.newInstance(init, (AssetUploaderStateMachineFactory) obj);
    }

    /* compiled from: RichTextStateMachine_Factory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0007¨\u0006\u000e"}, d2 = {"Lkntr/common/paragraph/input/RichTextStateMachine_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/common/paragraph/input/RichTextStateMachine_Factory;", "startAssetStateMachineFactoryProvider", "Ljavax/inject/Provider;", "Lkntr/common/paragraph/assetuploader/stateMachine/AssetUploaderStateMachineFactory;", "newInstance", "Lkntr/common/paragraph/input/RichTextStateMachine;", "init", "Lkntr/common/paragraph/input/RichTextContent;", "startAssetStateMachineFactory", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final RichTextStateMachine_Factory create(Provider<AssetUploaderStateMachineFactory> provider) {
            Intrinsics.checkNotNullParameter(provider, "startAssetStateMachineFactoryProvider");
            return new RichTextStateMachine_Factory(provider);
        }

        @JvmStatic
        public final RichTextStateMachine newInstance(RichTextContent init, AssetUploaderStateMachineFactory startAssetStateMachineFactory) {
            Intrinsics.checkNotNullParameter(init, "init");
            Intrinsics.checkNotNullParameter(startAssetStateMachineFactory, "startAssetStateMachineFactory");
            return new RichTextStateMachine(init, startAssetStateMachineFactory);
        }
    }

    @JvmStatic
    public static final RichTextStateMachine_Factory create(Provider<AssetUploaderStateMachineFactory> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final RichTextStateMachine newInstance(RichTextContent init, AssetUploaderStateMachineFactory startAssetStateMachineFactory) {
        return Companion.newInstance(init, startAssetStateMachineFactory);
    }
}