package kntr.compose.avatar.parser.protobuf;

import com.bapis.bilibili.dagw.component.avatar.common.KBasicRenderSpec;
import com.bapis.bilibili.dagw.component.avatar.common.KLayerGeneralSpec;
import com.bapis.bilibili.dagw.component.avatar.common.KPositionSpec;
import com.bapis.bilibili.dagw.component.avatar.common.KSizeSpec;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.model.common.BasicRenderSpec;
import kntr.compose.avatar.model.common.Coordinate;
import kntr.compose.avatar.model.common.LayerGeneralSpec;
import kntr.compose.avatar.model.common.PositionSpec;
import kntr.compose.avatar.model.common.SizeSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Coordinate.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b\u001a\n\u0010\f\u001a\u00020\r*\u00020\u000e¨\u0006\u000f"}, d2 = {"toSizeSpec", "Lkntr/compose/avatar/model/common/SizeSpec;", "Lcom/bapis/bilibili/dagw/component/avatar/common/KSizeSpec;", "toPositionSpec", "Lkntr/compose/avatar/model/common/PositionSpec;", "Lcom/bapis/bilibili/dagw/component/avatar/common/KPositionSpec;", "toBasicRenderSpec", "Lkntr/compose/avatar/model/common/BasicRenderSpec;", "Lcom/bapis/bilibili/dagw/component/avatar/common/KBasicRenderSpec;", "toLayerGeneralSpec", "Lkntr/compose/avatar/model/common/LayerGeneralSpec;", "Lcom/bapis/bilibili/dagw/component/avatar/common/KLayerGeneralSpec;", "toCoordinate", "Lkntr/compose/avatar/model/common/Coordinate;", "Lcom/bapis/bilibili/dagw/component/avatar/common/KPositionSpec$KCoordinatePos;", "parser_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CoordinateKt {
    public static final SizeSpec toSizeSpec(KSizeSpec $this$toSizeSpec) {
        Intrinsics.checkNotNullParameter($this$toSizeSpec, "<this>");
        return new SizeSpec((float) $this$toSizeSpec.getWidth(), (float) $this$toSizeSpec.getHeight());
    }

    public static final PositionSpec toPositionSpec(KPositionSpec $this$toPositionSpec) {
        Intrinsics.checkNotNullParameter($this$toPositionSpec, "<this>");
        return new PositionSpec((float) $this$toPositionSpec.getAxisX(), (float) $this$toPositionSpec.getAxisY(), toCoordinate($this$toPositionSpec.getCoordinatePos()));
    }

    public static final BasicRenderSpec toBasicRenderSpec(KBasicRenderSpec $this$toBasicRenderSpec) {
        Intrinsics.checkNotNullParameter($this$toBasicRenderSpec, "<this>");
        return new BasicRenderSpec((float) $this$toBasicRenderSpec.getOpacity());
    }

    public static final LayerGeneralSpec toLayerGeneralSpec(KLayerGeneralSpec $this$toLayerGeneralSpec) {
        SizeSpec sizeSpec;
        PositionSpec positionSpec;
        BasicRenderSpec basicRenderSpec;
        Intrinsics.checkNotNullParameter($this$toLayerGeneralSpec, "<this>");
        KSizeSpec sizeSpec2 = $this$toLayerGeneralSpec.getSizeSpec();
        if (sizeSpec2 == null || (sizeSpec = toSizeSpec(sizeSpec2)) == null) {
            sizeSpec = new SizeSpec(0.0f, 0.0f, 3, null);
        }
        KPositionSpec posSpec = $this$toLayerGeneralSpec.getPosSpec();
        if (posSpec == null || (positionSpec = toPositionSpec(posSpec)) == null) {
            positionSpec = new PositionSpec(0.0f, 0.0f, null, 7, null);
        }
        KBasicRenderSpec renderSpec = $this$toLayerGeneralSpec.getRenderSpec();
        if (renderSpec == null || (basicRenderSpec = toBasicRenderSpec(renderSpec)) == null) {
            basicRenderSpec = new BasicRenderSpec(0.0f, 1, null);
        }
        return new LayerGeneralSpec(sizeSpec, positionSpec, basicRenderSpec);
    }

    public static final Coordinate toCoordinate(KPositionSpec.KCoordinatePos $this$toCoordinate) {
        Intrinsics.checkNotNullParameter($this$toCoordinate, "<this>");
        return Intrinsics.areEqual($this$toCoordinate, KPositionSpec.KCoordinatePos.DEFAULT_COORDINATE.INSTANCE) ? Coordinate.Default : Intrinsics.areEqual($this$toCoordinate, KPositionSpec.KCoordinatePos.CENTRAL_COORDINATE.INSTANCE) ? Coordinate.Central : Coordinate.Default;
    }
}