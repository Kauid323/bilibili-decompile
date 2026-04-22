package kntr.common.ouro.core.model.node.renderable;

import java.lang.annotation.Annotation;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.renderable.OuroRenderable;
import kntr.common.ouro.core.utils.RandomUuidKt;
import kntr.common.photonic.Asset;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroLocalImage.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002\"#B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017¨\u0006$"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/OuroLocalImage;", "Lkntr/common/ouro/core/model/node/renderable/OuroRenderable$BuiltIn;", "asset", "Lkntr/common/photonic/Asset;", "useOriginalImage", "", "reuseIdentifier", "", "<init>", "(Lkntr/common/photonic/Asset;ZLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/common/photonic/Asset;ZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAsset", "()Lkntr/common/photonic/Asset;", "getUseOriginalImage", "()Z", "getReuseIdentifier", "()Ljava/lang/String;", "width", "getWidth", "()I", "height", "getHeight", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class OuroLocalImage implements OuroRenderable.BuiltIn {
    private final Asset asset;
    private final String reuseIdentifier;
    private final boolean useOriginalImage;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.ouro.core.model.node.renderable.OuroLocalImage$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = OuroLocalImage._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null};

    /* compiled from: OuroLocalImage.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/OuroLocalImage$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/renderable/OuroLocalImage;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OuroLocalImage> serializer() {
            return OuroLocalImage$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ OuroLocalImage(int seen0, Asset asset, boolean useOriginalImage, String reuseIdentifier, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, OuroLocalImage$$serializer.INSTANCE.getDescriptor());
        }
        this.asset = asset;
        this.useOriginalImage = useOriginalImage;
        if ((seen0 & 4) == 0) {
            this.reuseIdentifier = RandomUuidKt.randomUuid();
        } else {
            this.reuseIdentifier = reuseIdentifier;
        }
    }

    public OuroLocalImage(Asset asset, boolean useOriginalImage, String reuseIdentifier) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(reuseIdentifier, "reuseIdentifier");
        this.asset = asset;
        this.useOriginalImage = useOriginalImage;
        this.reuseIdentifier = reuseIdentifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(Asset.class), new Annotation[0]);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(OuroLocalImage self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, $childSerializers[0].getValue(), self.asset);
        output.encodeBooleanElement(serialDesc, 1, self.useOriginalImage);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.getReuseIdentifier(), RandomUuidKt.randomUuid())) {
            output.encodeStringElement(serialDesc, 2, self.getReuseIdentifier());
        }
    }

    public /* synthetic */ OuroLocalImage(Asset asset, boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(asset, z, (i & 4) != 0 ? RandomUuidKt.randomUuid() : str);
    }

    public final Asset getAsset() {
        return this.asset;
    }

    public final boolean getUseOriginalImage() {
        return this.useOriginalImage;
    }

    @Override // kntr.common.ouro.core.model.node.renderable.OuroRenderable
    public String getReuseIdentifier() {
        return this.reuseIdentifier;
    }

    public final int getWidth() {
        return this.asset.getResolution().getWidthPx();
    }

    public final int getHeight() {
        return this.asset.getResolution().getHeightPx();
    }
}