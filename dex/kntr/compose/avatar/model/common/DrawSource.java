package kntr.compose.avatar.model.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IResource.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J1\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006."}, d2 = {"Lkntr/compose/avatar/model/common/DrawSource;", "Lkntr/compose/avatar/model/common/IResource;", "drawType", "Lkntr/compose/avatar/model/common/NativeDrawType;", "fillMode", "Lkntr/compose/avatar/model/common/FillMode;", "color", "Lkntr/compose/avatar/model/common/ColorConfig;", "edgeWeight", "", "<init>", "(Lkntr/compose/avatar/model/common/NativeDrawType;Lkntr/compose/avatar/model/common/FillMode;Lkntr/compose/avatar/model/common/ColorConfig;F)V", "getDrawType", "()Lkntr/compose/avatar/model/common/NativeDrawType;", "getFillMode", "()Lkntr/compose/avatar/model/common/FillMode;", "getColor", "()Lkntr/compose/avatar/model/common/ColorConfig;", "getEdgeWeight", "()F", "type", "Lkntr/compose/avatar/model/common/SourceType;", "getType", "()Lkntr/compose/avatar/model/common/SourceType;", "placeHolder", "Lkntr/compose/avatar/model/common/LocalSourceEnum;", "getPlaceHolder", "()Lkntr/compose/avatar/model/common/LocalSourceEnum;", "isValidResource", "", "()Z", "descStr", "", "getDescStr", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DrawSource implements IResource {
    private final ColorConfig color;
    private final NativeDrawType drawType;
    private final float edgeWeight;
    private final FillMode fillMode;

    public DrawSource() {
        this(null, null, null, 0.0f, 15, null);
    }

    public static /* synthetic */ DrawSource copy$default(DrawSource drawSource, NativeDrawType nativeDrawType, FillMode fillMode, ColorConfig colorConfig, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            nativeDrawType = drawSource.drawType;
        }
        if ((i & 2) != 0) {
            fillMode = drawSource.fillMode;
        }
        if ((i & 4) != 0) {
            colorConfig = drawSource.color;
        }
        if ((i & 8) != 0) {
            f = drawSource.edgeWeight;
        }
        return drawSource.copy(nativeDrawType, fillMode, colorConfig, f);
    }

    public final NativeDrawType component1() {
        return this.drawType;
    }

    public final FillMode component2() {
        return this.fillMode;
    }

    public final ColorConfig component3() {
        return this.color;
    }

    public final float component4() {
        return this.edgeWeight;
    }

    public final DrawSource copy(NativeDrawType nativeDrawType, FillMode fillMode, ColorConfig colorConfig, float f) {
        Intrinsics.checkNotNullParameter(nativeDrawType, "drawType");
        Intrinsics.checkNotNullParameter(fillMode, "fillMode");
        Intrinsics.checkNotNullParameter(colorConfig, "color");
        return new DrawSource(nativeDrawType, fillMode, colorConfig, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DrawSource) {
            DrawSource drawSource = (DrawSource) obj;
            return this.drawType == drawSource.drawType && this.fillMode == drawSource.fillMode && Intrinsics.areEqual(this.color, drawSource.color) && Float.compare(this.edgeWeight, drawSource.edgeWeight) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.drawType.hashCode() * 31) + this.fillMode.hashCode()) * 31) + this.color.hashCode()) * 31) + Float.floatToIntBits(this.edgeWeight);
    }

    public String toString() {
        NativeDrawType nativeDrawType = this.drawType;
        FillMode fillMode = this.fillMode;
        ColorConfig colorConfig = this.color;
        return "DrawSource(drawType=" + nativeDrawType + ", fillMode=" + fillMode + ", color=" + colorConfig + ", edgeWeight=" + this.edgeWeight + ")";
    }

    public DrawSource(NativeDrawType drawType, FillMode fillMode, ColorConfig color, float edgeWeight) {
        Intrinsics.checkNotNullParameter(drawType, "drawType");
        Intrinsics.checkNotNullParameter(fillMode, "fillMode");
        Intrinsics.checkNotNullParameter(color, "color");
        this.drawType = drawType;
        this.fillMode = fillMode;
        this.color = color;
        this.edgeWeight = edgeWeight;
    }

    public /* synthetic */ DrawSource(NativeDrawType nativeDrawType, FillMode fillMode, ColorConfig colorConfig, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? NativeDrawType.Circle : nativeDrawType, (i & 2) != 0 ? FillMode.Fill : fillMode, (i & 4) != 0 ? new ColorConfig(false, null, null, 7, null) : colorConfig, (i & 8) != 0 ? 1.0f : f);
    }

    public final NativeDrawType getDrawType() {
        return this.drawType;
    }

    public final FillMode getFillMode() {
        return this.fillMode;
    }

    public final ColorConfig getColor() {
        return this.color;
    }

    public final float getEdgeWeight() {
        return this.edgeWeight;
    }

    @Override // kntr.compose.avatar.model.common.IResource
    public SourceType getType() {
        return SourceType.NativeDrawSource;
    }

    @Override // kntr.compose.avatar.model.common.IResource
    public LocalSourceEnum getPlaceHolder() {
        return LocalSourceEnum.Invalid;
    }

    @Override // kntr.compose.avatar.model.common.IResource
    public boolean isValidResource() {
        return (this.fillMode == FillMode.Invalid || this.drawType == NativeDrawType.Invalid) ? false : true;
    }

    @Override // kntr.compose.avatar.model.common.IResource
    public String getDescStr() {
        String name = this.drawType.name();
        String name2 = this.fillMode.name();
        return "Draw{" + name + ", " + name2 + ", " + this.edgeWeight + "}";
    }
}