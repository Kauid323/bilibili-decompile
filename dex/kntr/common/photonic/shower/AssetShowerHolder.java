package kntr.common.photonic.shower;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: AssetShowerHolder.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B$\b\u0007\u0012\u0019\u0010\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\f\u001a\n\u0012\u0004\u0012\u0002H\r\u0018\u00010\u0004\"\b\b\u0000\u0010\r*\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000bJ\u001d\u0010\f\u001a\n\u0012\u0004\u0012\u0002H\r\u0018\u00010\u0004\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u0005H\u0086\bJ\u0018\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0010R*\u0010\t\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/common/photonic/shower/AssetShowerHolder;", "", "showerSet", "", "Lkntr/common/photonic/shower/AssetShower;", "Lkntr/common/photonic/Asset;", "Lkotlin/jvm/JvmSuppressWildcards;", "<init>", "(Ljava/util/Set;)V", "showerMap", "", "Lkotlin/reflect/KClass;", "getShowerForAssetType", "T", "assetType", "fullQualifiedName", "", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetShowerHolder {
    public static final int $stable = 8;
    private final Map<KClass<? extends Asset>, AssetShower<? extends Asset>> showerMap;

    @Inject
    public AssetShowerHolder(Set<AssetShower<? extends Asset>> set) {
        Intrinsics.checkNotNullParameter(set, "showerSet");
        Set<AssetShower<? extends Asset>> $this$flatMap$iv = set;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            AssetShower shower = (AssetShower) element$iv$iv;
            Iterable $this$map$iv = shower.getAcceptType();
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                KClass it = (KClass) item$iv$iv;
                destination$iv$iv2.add(TuplesKt.to(it, shower));
            }
            Iterable list$iv$iv = (List) destination$iv$iv2;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        this.showerMap = MapsKt.toMap((List) destination$iv$iv);
    }

    public final <T extends Asset> AssetShower<T> getShowerForAssetType(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "assetType");
        AssetShower<? extends Asset> assetShower = this.showerMap.get(kClass);
        if (assetShower instanceof AssetShower) {
            return (AssetShower<T>) assetShower;
        }
        return null;
    }

    public final /* synthetic */ <T extends Asset> AssetShower<T> getShowerForAssetType() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return getShowerForAssetType(Reflection.getOrCreateKotlinClass(Asset.class));
    }

    public final AssetShower<? extends Asset> getShowerForAssetType(String fullQualifiedName) {
        Object element$iv;
        Intrinsics.checkNotNullParameter(fullQualifiedName, "fullQualifiedName");
        Iterable $this$firstOrNull$iv = this.showerMap.entrySet();
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                Map.Entry it2 = (Map.Entry) element$iv;
                if (Intrinsics.areEqual(((KClass) it2.getKey()).getQualifiedName(), fullQualifiedName)) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        Map.Entry entry = (Map.Entry) element$iv;
        if (entry != null) {
            return (AssetShower) entry.getValue();
        }
        return null;
    }
}