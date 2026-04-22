package kntr.common.ouro.core.dsl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroNodeMutableStorage;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.drawable.OuroInlineContent;
import kntr.common.ouro.core.model.node.renderable.OuroRemoteImage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroNodeDSL.kt */
@OuroNodeDslMarker
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rR\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkntr/common/ouro/core/dsl/InlineContentBuilder;", "", "builder", "Lkntr/common/ouro/core/model/OuroNodeMutableStorage;", "inlineContent", "Lkntr/common/ouro/core/model/node/drawable/OuroInlineContent;", "<init>", "(Lkntr/common/ouro/core/model/OuroNodeMutableStorage;Lkntr/common/ouro/core/model/node/drawable/OuroInlineContent;)V", "Image", "", "url", "", "width", "", "height", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InlineContentBuilder {
    private final OuroNodeMutableStorage<?> builder;
    private final OuroInlineContent inlineContent;

    public InlineContentBuilder(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroInlineContent inlineContent) {
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "builder");
        Intrinsics.checkNotNullParameter(inlineContent, "inlineContent");
        this.builder = ouroNodeMutableStorage;
        this.inlineContent = inlineContent;
    }

    public final void Image(String url, int width, int height) {
        Intrinsics.checkNotNullParameter(url, "url");
        OuroRemoteImage.Image image = new OuroRemoteImage.Image(url, width, height, 0, 8, (DefaultConstructorMarker) null);
        OuroNodeMutableStorage $this$Image_u24lambda_u240 = this.builder;
        $this$Image_u24lambda_u240.addChild((OuroNode.Parent<OuroInlineContent>) this.inlineContent, (OuroInlineContent) image);
    }
}