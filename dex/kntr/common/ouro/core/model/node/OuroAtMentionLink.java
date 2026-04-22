package kntr.common.ouro.core.model.node;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.OuroLink;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroLink.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ%\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0002\b\u0014R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroAtMentionLink;", "Lkntr/common/ouro/core/model/node/OuroLink;", "Lkntr/common/ouro/core/model/node/AtMentionUser;", "meta", "<init>", "(Lkntr/common/ouro/core/model/node/AtMentionUser;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/common/ouro/core/model/node/AtMentionUser;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMeta", "()Lkntr/common/ouro/core/model/node/AtMentionUser;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class OuroAtMentionLink implements OuroLink<AtMentionUser> {
    public static final Companion Companion = new Companion(null);
    private final AtMentionUser meta;

    /* compiled from: OuroLink.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroAtMentionLink$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/OuroAtMentionLink;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OuroAtMentionLink> serializer() {
            return OuroAtMentionLink$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ OuroAtMentionLink(int seen0, AtMentionUser meta, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, OuroAtMentionLink$$serializer.INSTANCE.getDescriptor());
        }
        this.meta = meta;
    }

    public OuroAtMentionLink(AtMentionUser meta) {
        Intrinsics.checkNotNullParameter(meta, "meta");
        this.meta = meta;
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

    @Override // kntr.common.ouro.core.model.node.OuroNode.Element
    public AtMentionUser getMeta() {
        return this.meta;
    }
}