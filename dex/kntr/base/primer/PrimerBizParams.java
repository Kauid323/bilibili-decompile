package kntr.base.primer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.primer.HitType;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GPrimer.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0015\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0015\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003Jq\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006-"}, d2 = {"Lkntr/base/primer/PrimerBizParams;", "", "path", "Lkntr/base/primer/PrimerPath;", "params", "", "", "headers", "type", "byteArray", "", "hitType", "Lkntr/base/primer/HitType;", "blockScene", "", "Lkntr/base/primer/BlockScene;", "<init>", "(Lkntr/base/primer/PrimerPath;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;[BLkntr/base/primer/HitType;Ljava/util/List;)V", "getPath", "()Lkntr/base/primer/PrimerPath;", "getParams", "()Ljava/util/Map;", "getHeaders", "getType", "()Ljava/lang/String;", "getByteArray", "()[B", "getHitType", "()Lkntr/base/primer/HitType;", "getBlockScene", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "primer_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PrimerBizParams {
    private final List<BlockScene> blockScene;
    private final byte[] byteArray;
    private final Map<String, String> headers;
    private final HitType hitType;
    private final Map<String, String> params;
    private final PrimerPath path;
    private final String type;

    public static /* synthetic */ PrimerBizParams copy$default(PrimerBizParams primerBizParams, PrimerPath primerPath, Map map, Map map2, String str, byte[] bArr, HitType hitType, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            primerPath = primerBizParams.path;
        }
        Map<String, String> map3 = map;
        if ((i & 2) != 0) {
            map3 = primerBizParams.params;
        }
        Map map4 = map3;
        Map<String, String> map5 = map2;
        if ((i & 4) != 0) {
            map5 = primerBizParams.headers;
        }
        Map map6 = map5;
        if ((i & 8) != 0) {
            str = primerBizParams.type;
        }
        String str2 = str;
        if ((i & 16) != 0) {
            bArr = primerBizParams.byteArray;
        }
        byte[] bArr2 = bArr;
        if ((i & 32) != 0) {
            hitType = primerBizParams.hitType;
        }
        HitType hitType2 = hitType;
        List<BlockScene> list2 = list;
        if ((i & 64) != 0) {
            list2 = primerBizParams.blockScene;
        }
        return primerBizParams.copy(primerPath, map4, map6, str2, bArr2, hitType2, list2);
    }

    public final PrimerPath component1() {
        return this.path;
    }

    public final Map<String, String> component2() {
        return this.params;
    }

    public final Map<String, String> component3() {
        return this.headers;
    }

    public final String component4() {
        return this.type;
    }

    public final byte[] component5() {
        return this.byteArray;
    }

    public final HitType component6() {
        return this.hitType;
    }

    public final List<BlockScene> component7() {
        return this.blockScene;
    }

    public final PrimerBizParams copy(PrimerPath primerPath, Map<String, String> map, Map<String, String> map2, String str, byte[] bArr, HitType hitType, List<? extends BlockScene> list) {
        Intrinsics.checkNotNullParameter(primerPath, "path");
        Intrinsics.checkNotNullParameter(map, "params");
        Intrinsics.checkNotNullParameter(map2, "headers");
        Intrinsics.checkNotNullParameter(hitType, "hitType");
        Intrinsics.checkNotNullParameter(list, "blockScene");
        return new PrimerBizParams(primerPath, map, map2, str, bArr, hitType, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PrimerBizParams) {
            PrimerBizParams primerBizParams = (PrimerBizParams) obj;
            return this.path == primerBizParams.path && Intrinsics.areEqual(this.params, primerBizParams.params) && Intrinsics.areEqual(this.headers, primerBizParams.headers) && Intrinsics.areEqual(this.type, primerBizParams.type) && Intrinsics.areEqual(this.byteArray, primerBizParams.byteArray) && Intrinsics.areEqual(this.hitType, primerBizParams.hitType) && Intrinsics.areEqual(this.blockScene, primerBizParams.blockScene);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.path.hashCode() * 31) + this.params.hashCode()) * 31) + this.headers.hashCode()) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.byteArray != null ? Arrays.hashCode(this.byteArray) : 0)) * 31) + this.hitType.hashCode()) * 31) + this.blockScene.hashCode();
    }

    public String toString() {
        PrimerPath primerPath = this.path;
        Map<String, String> map = this.params;
        Map<String, String> map2 = this.headers;
        String str = this.type;
        String arrays = Arrays.toString(this.byteArray);
        HitType hitType = this.hitType;
        return "PrimerBizParams(path=" + primerPath + ", params=" + map + ", headers=" + map2 + ", type=" + str + ", byteArray=" + arrays + ", hitType=" + hitType + ", blockScene=" + this.blockScene + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PrimerBizParams(PrimerPath path, Map<String, String> map, Map<String, String> map2, String type, byte[] byteArray, HitType hitType, List<? extends BlockScene> list) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(map, "params");
        Intrinsics.checkNotNullParameter(map2, "headers");
        Intrinsics.checkNotNullParameter(hitType, "hitType");
        Intrinsics.checkNotNullParameter(list, "blockScene");
        this.path = path;
        this.params = map;
        this.headers = map2;
        this.type = type;
        this.byteArray = byteArray;
        this.hitType = hitType;
        this.blockScene = list;
    }

    public /* synthetic */ PrimerBizParams(PrimerPath primerPath, Map map, Map map2, String str, byte[] bArr, HitType hitType, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(primerPath, map, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? HitType.Repeat.INSTANCE : hitType, (i & 64) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final PrimerPath getPath() {
        return this.path;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getType() {
        return this.type;
    }

    public final byte[] getByteArray() {
        return this.byteArray;
    }

    public final HitType getHitType() {
        return this.hitType;
    }

    public final List<BlockScene> getBlockScene() {
        return this.blockScene;
    }
}