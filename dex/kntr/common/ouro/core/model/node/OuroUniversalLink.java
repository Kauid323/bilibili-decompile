package kntr.common.ouro.core.model.node;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.OuroLink;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Metadata;
import kotlin.Pair;
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

/* compiled from: OuroLink.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ%\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0002\b\u0018R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroUniversalLink;", "Lkntr/common/ouro/core/model/node/OuroLink;", "", "meta", "encodedData", "", "<init>", "(Ljava/lang/String;[B)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;[BLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMeta", "()Ljava/lang/String;", "getEncodedData", "()[B", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class OuroUniversalLink implements OuroLink<String> {
    public static final Companion Companion = new Companion(null);
    private final byte[] encodedData;
    private final String meta;

    /* compiled from: OuroLink.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroUniversalLink$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/OuroUniversalLink;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OuroUniversalLink> serializer() {
            return OuroUniversalLink$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ OuroUniversalLink(int seen0, String meta, byte[] encodedData, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, OuroUniversalLink$$serializer.INSTANCE.getDescriptor());
        }
        this.meta = meta;
        if ((seen0 & 2) == 0) {
            this.encodedData = null;
        } else {
            this.encodedData = encodedData;
        }
    }

    public OuroUniversalLink(String meta, byte[] encodedData) {
        Intrinsics.checkNotNullParameter(meta, "meta");
        this.meta = meta;
        this.encodedData = encodedData;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(OuroUniversalLink self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.getMeta());
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.encodedData != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, ByteArraySerializer.INSTANCE, self.encodedData);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public /* bridge */ OuroLinkChild castChild(OuroNode other) {
        return (OuroLinkChild) OuroNode.Parent.CC.$default$castChild(this, other);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public /* bridge */ OuroLinkChild castChildOrNull(OuroNode other) {
        return OuroLink.CC.$default$castChildOrNull((OuroLink) this, other);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public /* bridge */ boolean isValidParentOf(OuroNode other) {
        return OuroNode.Parent.CC.$default$isValidParentOf(this, other);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public /* bridge */ Pair<OuroNode.Parent<OuroLinkChild>, OuroNode.Parent<OuroLinkChild>> tryDivide() {
        return OuroNode.Parent.CC.$default$tryDivide(this);
    }

    public /* synthetic */ OuroUniversalLink(String str, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : bArr);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Element
    public String getMeta() {
        return this.meta;
    }

    public final byte[] getEncodedData() {
        return this.encodedData;
    }
}