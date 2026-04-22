package kntr.common.share.common.ui.util;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.PixelMap;
import java.util.ArrayList;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* compiled from: ShareColorPickerUtility.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lkntr/common/share/common/ui/util/ShareColorPickerUtility;", "", "<init>", "()V", "Companion", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareColorPickerUtility {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    /* compiled from: ShareColorPickerUtility.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0017\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\b\u0015J \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u0007¨\u0006\u0019"}, d2 = {"Lkntr/common/share/common/ui/util/ShareColorPickerUtility$Companion;", "", "<init>", "()V", "rgbToHsv", "", "r", "", "g", "b", "hsvToColor", "Landroidx/compose/ui/graphics/Color;", "hsv", "hsvToColor-vNxB06k", "([F)J", "scaleImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "bitmap", "targetWidth", "targetHeight", "getDominantColor", "getDominantColor-ijrfgN4", "getColorPalette", "", "numberOfColors", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final float[] rgbToHsv(int r, int g, int b) {
            float hue;
            float rf = r / 255.0f;
            float gf = g / 255.0f;
            float bf = b / 255.0f;
            float maxVal = Math.max(rf, Math.max(gf, bf));
            float minVal = Math.min(rf, Math.min(gf, bf));
            float diff = maxVal - minVal;
            if (diff == 0.0f) {
                hue = 0.0f;
            } else {
                if (maxVal == rf) {
                    float f = 360;
                    hue = ((60 * ((gf - bf) / diff)) + f) % f;
                } else {
                    hue = (maxVal > gf ? 1 : (maxVal == gf ? 0 : -1)) == 0 ? ((60 * ((bf - rf) / diff)) + ((float) BackoffConfigKt.MAX_DELAY_SECONDS)) % 360 : ((60 * ((rf - gf) / diff)) + 240) % 360;
                }
            }
            float saturation = (maxVal > 0.0f ? 1 : (maxVal == 0.0f ? 0 : -1)) == 0 ? 0.0f : diff / maxVal;
            return new float[]{hue, saturation, maxVal};
        }

        /* renamed from: hsvToColor-vNxB06k  reason: not valid java name */
        private final long m2408hsvToColorvNxB06k(float[] hsv) {
            Triple triple;
            float h = hsv[0];
            float s = hsv[1];
            float v = hsv[2];
            float c = v * s;
            float f = 1;
            float x = (f - Math.abs(((h / 60) % 2) - f)) * c;
            float m = v - c;
            int i = (h > 60.0f ? 1 : (h == 60.0f ? 0 : -1));
            Float valueOf = Float.valueOf(0.0f);
            if (i < 0) {
                triple = new Triple(Float.valueOf(c), Float.valueOf(x), valueOf);
            } else if (h < 120.0f) {
                triple = new Triple(Float.valueOf(x), Float.valueOf(c), valueOf);
            } else if (h < 180.0f) {
                triple = new Triple(valueOf, Float.valueOf(c), Float.valueOf(x));
            } else if (h < 240.0f) {
                triple = new Triple(valueOf, Float.valueOf(x), Float.valueOf(c));
            } else {
                triple = h < 300.0f ? new Triple(Float.valueOf(x), valueOf, Float.valueOf(c)) : new Triple(Float.valueOf(c), valueOf, Float.valueOf(x));
            }
            float r1 = ((Number) triple.component1()).floatValue();
            float g1 = ((Number) triple.component2()).floatValue();
            float b1 = ((Number) triple.component3()).floatValue();
            float f2 = (float) KotlinVersion.MAX_COMPONENT_VALUE;
            int r = RangesKt.coerceIn(MathKt.roundToInt((r1 + m) * f2), 0, (int) KotlinVersion.MAX_COMPONENT_VALUE);
            int g = RangesKt.coerceIn(MathKt.roundToInt((g1 + m) * f2), 0, (int) KotlinVersion.MAX_COMPONENT_VALUE);
            int b = RangesKt.coerceIn(MathKt.roundToInt((b1 + m) * f2), 0, (int) KotlinVersion.MAX_COMPONENT_VALUE);
            return ColorKt.Color$default(r, g, b, 0, 8, (Object) null);
        }

        private final ImageBitmap scaleImageBitmap(ImageBitmap bitmap, int targetWidth, int targetHeight) {
            return bitmap;
        }

        /* renamed from: getDominantColor-ijrfgN4  reason: not valid java name */
        public final Color m2409getDominantColorijrfgN4(ImageBitmap bitmap) {
            PixelMap pixelMap;
            int i;
            int stepY;
            if (bitmap == null) {
                return null;
            }
            try {
                PixelMap pixelMap2 = ImageBitmapKt.toPixelMap$default(bitmap, 0, 0, 0, 0, (int[]) null, 0, 0, 127, (Object) null);
                int sampleWidth = Math.min(50, bitmap.getWidth());
                int sampleHeight = Math.min(50, bitmap.getHeight());
                int stepX = Math.max(1, bitmap.getWidth() / sampleWidth);
                int stepY2 = Math.max(1, bitmap.getHeight() / sampleHeight);
                long redTotal = 0;
                long greenTotal = 0;
                long blueTotal = 0;
                int pixelCount = 0;
                IntProgression step = RangesKt.step(RangesKt.until(0, bitmap.getHeight()), stepY2);
                int y = step.getFirst();
                int last = step.getLast();
                int step2 = step.getStep();
                if ((step2 > 0 && y <= last) || (step2 < 0 && last <= y)) {
                    while (true) {
                        int sampleWidth2 = sampleWidth;
                        int sampleHeight2 = sampleHeight;
                        IntProgression step3 = RangesKt.step(RangesKt.until(0, bitmap.getWidth()), stepX);
                        int x = step3.getFirst();
                        int stepX2 = stepX;
                        int stepX3 = step3.getLast();
                        int step4 = step3.getStep();
                        if ((step4 > 0 && x <= stepX3) || (step4 < 0 && stepX3 <= x)) {
                            while (true) {
                                long color = pixelMap2.get-WaAFU9c(x, y);
                                float f = Color.getRed-impl(color);
                                pixelMap = pixelMap2;
                                float f2 = (float) KotlinVersion.MAX_COMPONENT_VALUE;
                                stepY = stepY2;
                                int stepY3 = MathKt.roundToInt(f * f2);
                                i = last;
                                redTotal += stepY3;
                                greenTotal += MathKt.roundToInt(Color.getGreen-impl(color) * f2);
                                blueTotal += MathKt.roundToInt(Color.getBlue-impl(color) * f2);
                                pixelCount++;
                                if (x == stepX3) {
                                    break;
                                }
                                x += step4;
                                last = i;
                                pixelMap2 = pixelMap;
                                stepY2 = stepY;
                            }
                        } else {
                            pixelMap = pixelMap2;
                            i = last;
                            stepY = stepY2;
                        }
                        int i2 = i;
                        if (y == i2) {
                            break;
                        }
                        y += step2;
                        last = i2;
                        sampleWidth = sampleWidth2;
                        sampleHeight = sampleHeight2;
                        stepX = stepX2;
                        pixelMap2 = pixelMap;
                        stepY2 = stepY;
                    }
                }
                if (pixelCount == 0) {
                    return null;
                }
                int averageRed = (int) (redTotal / pixelCount);
                int averageGreen = (int) (greenTotal / pixelCount);
                int averageBlue = (int) (blueTotal / pixelCount);
                float[] hsv = rgbToHsv(averageRed, averageGreen, averageBlue);
                float hue = hsv[0];
                float adjustedSaturation = RangesKt.coerceIn(hsv[1], 0.1f, 0.4f);
                float adjustedBrightness = RangesKt.coerceIn(hsv[2], 0.4f, 0.6f);
                return Color.box-impl(m2408hsvToColorvNxB06k(new float[]{hue, adjustedSaturation, adjustedBrightness}));
            } catch (Exception e) {
                return null;
            }
        }

        public static /* synthetic */ List getColorPalette$default(Companion companion, ImageBitmap imageBitmap, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 5;
            }
            return companion.getColorPalette(imageBitmap, i);
        }

        public final List<Color> getColorPalette(ImageBitmap bitmap, int numberOfColors) {
            if (bitmap == null) {
                return CollectionsKt.emptyList();
            }
            try {
                PixelMap pixelMap = ImageBitmapKt.toPixelMap$default(bitmap, 0, 0, 0, 0, (int[]) null, 0, 0, 127, (Object) null);
                int sampleWidth = Math.min(100, bitmap.getWidth());
                int sampleHeight = Math.min(100, bitmap.getHeight());
                int stepX = Math.max(1, bitmap.getWidth() / sampleWidth);
                int stepY = Math.max(1, bitmap.getHeight() / sampleHeight);
                List colors = new ArrayList();
                int step = Math.max(1, (sampleWidth * sampleHeight) / numberOfColors);
                int count = 0;
                for (int i = 0; count < numberOfColors && i < sampleWidth * sampleHeight; i += step) {
                    int x = (i % sampleWidth) * stepX;
                    int y = (i / sampleWidth) * stepY;
                    if (x < bitmap.getWidth() && y < bitmap.getHeight()) {
                        long color = pixelMap.get-WaAFU9c(x, y);
                        colors.add(Color.box-impl(color));
                        count++;
                    }
                }
                return colors;
            } catch (Exception e) {
                return CollectionsKt.emptyList();
            }
        }
    }
}