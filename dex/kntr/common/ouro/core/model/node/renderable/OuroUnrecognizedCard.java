package kntr.common.ouro.core.model.node.renderable;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.renderable.OuroRenderable;
import kntr.common.ouro.core.utils.RandomUuidKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ByteArraySerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroUnrecognizedCard.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u001a\u001bB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\b\u0019R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/OuroUnrecognizedCard;", "Lkntr/common/ouro/core/model/node/renderable/OuroRenderable$BuiltIn;", "Lkntr/common/ouro/core/model/node/OuroNode$Element;", "", "meta", "reuseIdentifier", "", "<init>", "([BLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(I[BLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMeta", "()[B", "getReuseIdentifier", "()Ljava/lang/String;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class OuroUnrecognizedCard implements OuroRenderable.BuiltIn, OuroNode.Element<byte[]> {
    public static final Companion Companion = new Companion(null);
    private final byte[] meta;
    private final String reuseIdentifier;

    /* compiled from: OuroUnrecognizedCard.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/OuroUnrecognizedCard$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/renderable/OuroUnrecognizedCard;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OuroUnrecognizedCard> serializer() {
            return OuroUnrecognizedCard$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ OuroUnrecognizedCard(int seen0, byte[] meta, String reuseIdentifier, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, OuroUnrecognizedCard$$serializer.INSTANCE.getDescriptor());
        }
        this.meta = meta;
        if ((seen0 & 2) == 0) {
            this.reuseIdentifier = RandomUuidKt.randomUuid();
        } else {
            this.reuseIdentifier = reuseIdentifier;
        }
    }

    public OuroUnrecognizedCard(byte[] meta, String reuseIdentifier) {
        Intrinsics.checkNotNullParameter(meta, "meta");
        Intrinsics.checkNotNullParameter(reuseIdentifier, "reuseIdentifier");
        this.meta = meta;
        this.reuseIdentifier = reuseIdentifier;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(OuroUnrecognizedCard self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, ByteArraySerializer.INSTANCE, self.getMeta());
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.getReuseIdentifier(), RandomUuidKt.randomUuid())) {
            output.encodeStringElement(serialDesc, 1, self.getReuseIdentifier());
        }
    }

    public /* synthetic */ OuroUnrecognizedCard(byte[] bArr, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i & 2) != 0 ? RandomUuidKt.randomUuid() : str);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Element
    public byte[] getMeta() {
        return this.meta;
    }

    @Override // kntr.common.ouro.core.model.node.renderable.OuroRenderable
    public String getReuseIdentifier() {
        return this.reuseIdentifier;
    }
}