package kntr.base.imageloader;

import java.util.ArrayList;
import java.util.Iterator;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.screen.adjust.KScreenAdjustUtilsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: SizeController.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002\"\u001e\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"DEFAULT_SIZE_STAGE", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "DEFAULT_RATIO_LEVEL", "", "DEFAULT_AUTO_ZOOM", "getStageSize", "Lkntr/base/imageloader/Size;", "width", "Lkntr/base/imageloader/Pixel;", "height", "getStageSize-Ic4ZqO0", "(II)Lkntr/base/imageloader/Size;", "Size", "imageloader_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SizeControllerKt {
    private static final int DEFAULT_AUTO_ZOOM = 3;
    private static final ArrayList<Integer> DEFAULT_SIZE_STAGE = CollectionsKt.arrayListOf(new Integer[]{2160, 1800, 1440, 1260, 1080, 900, Integer.valueOf((int) KScreenAdjustUtilsKt.CONTAINER_CONTENT_MAX_WIDTH), 630, 540, 450, 360, 270, 180, 135, 90, 69, 48});
    private static final ArrayList<Float> DEFAULT_RATIO_LEVEL = CollectionsKt.arrayListOf(new Float[]{Float.valueOf(1.333f), Float.valueOf(1.6f), Float.valueOf(1.777f)});

    /* renamed from: getStageSize-Ic4ZqO0  reason: not valid java name */
    public static final Size m1578getStageSizeIc4ZqO0(int i, int i2) {
        Object minElem$iv;
        Object minElem$iv2 = null;
        if (Pixel.m1519equalsimpl0(i, Pixel.Companion.m1523getUNSETuhUG8m8()) || Pixel.m1519equalsimpl0(i2, Pixel.Companion.m1523getUNSETuhUG8m8())) {
            return new Size(i, i2, null);
        }
        Iterable $this$minByOrNull$iv = DEFAULT_SIZE_STAGE;
        Iterator iterator$iv = $this$minByOrNull$iv.iterator();
        if (iterator$iv.hasNext()) {
            minElem$iv = iterator$iv.next();
            if (iterator$iv.hasNext()) {
                int it = ((Number) minElem$iv).intValue();
                int minValue$iv = Math.abs(it - i);
                do {
                    Object e$iv = iterator$iv.next();
                    int it2 = ((Number) e$iv).intValue();
                    int v$iv = Math.abs(it2 - i);
                    if (minValue$iv > v$iv) {
                        minElem$iv = e$iv;
                        minValue$iv = v$iv;
                    }
                } while (iterator$iv.hasNext());
            }
        } else {
            minElem$iv = null;
        }
        Integer num = (Integer) minElem$iv;
        int targetWidth = num != null ? num.intValue() : i;
        float targetHeight = (targetWidth / i) * i2;
        Iterable ratioLevels = DEFAULT_RATIO_LEVEL;
        float tempRatio = i / i2;
        Iterable $this$minByOrNull$iv2 = ratioLevels;
        Iterator iterator$iv2 = $this$minByOrNull$iv2.iterator();
        if (iterator$iv2.hasNext()) {
            minElem$iv2 = iterator$iv2.next();
            if (iterator$iv2.hasNext()) {
                float it3 = ((Number) minElem$iv2).floatValue();
                float minValue$iv2 = Math.abs(it3 - tempRatio);
                do {
                    Object e$iv2 = iterator$iv2.next();
                    float it4 = ((Number) e$iv2).floatValue();
                    float v$iv2 = Math.abs(it4 - tempRatio);
                    if (Float.compare(minValue$iv2, v$iv2) > 0) {
                        minElem$iv2 = e$iv2;
                        minValue$iv2 = v$iv2;
                    }
                } while (iterator$iv2.hasNext());
            }
        }
        Float f = (Float) minElem$iv2;
        float finalRatio = f != null ? f.floatValue() : tempRatio;
        if (Math.abs(finalRatio - tempRatio) * 100 <= 3.0f) {
            targetHeight = targetWidth / finalRatio;
        }
        return Size(targetWidth, (int) targetHeight);
    }

    public static final Size Size(int width, int height) {
        return new Size(Pixel.m1517constructorimpl(width), Pixel.m1517constructorimpl(height), null);
    }
}