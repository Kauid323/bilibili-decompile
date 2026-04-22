package tv.danmaku.bili.ui.theme.configswitchcolor;

import android.content.Context;
import android.util.SparseArray;
import androidx.core.content.ContextCompat;
import com.bilibili.magicasakura.utils.ThemeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ConfigSwitchColor.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001J \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J'\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0014¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u001f\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000bH\u0014¢\u0006\u0002\u0010\u0018R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/theme/configswitchcolor/ConfigSwitchColor;", "Lcom/bilibili/magicasakura/utils/ThemeUtils$SwitchColor;", "<init>", "()V", "colorConfig", "Ltv/danmaku/bili/ui/theme/configswitchcolor/ConfigSwitchColor$ColorConfig;", "defaultSwitchColor", "initConfig", "", "colorIdMap", "Landroid/util/SparseArray;", "", "colorMap", "config", "replaceColorById", "context", "Landroid/content/Context;", "colorId", "viewThemeId", "particularColorReplaceById", "(Landroid/content/Context;II)Ljava/lang/Integer;", "replaceColor", "color", "particularColorReplace", "(Landroid/content/Context;I)Ljava/lang/Integer;", "ColorConfig", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class ConfigSwitchColor implements ThemeUtils.SwitchColor {
    private ColorConfig colorConfig;
    private ThemeUtils.SwitchColor defaultSwitchColor;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void initConfig$default(ConfigSwitchColor configSwitchColor, SparseArray sparseArray, SparseArray sparseArray2, ThemeUtils.SwitchColor switchColor, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initConfig");
        }
        if ((i & 2) != 0) {
            sparseArray2 = null;
        }
        if ((i & 4) != 0) {
            switchColor = null;
        }
        configSwitchColor.initConfig(sparseArray, sparseArray2, switchColor);
    }

    public final void initConfig(SparseArray<Integer> sparseArray, SparseArray<Integer> sparseArray2, ThemeUtils.SwitchColor defaultSwitchColor) {
        Intrinsics.checkNotNullParameter(sparseArray, "colorIdMap");
        ColorConfig config = new ColorConfig(sparseArray, sparseArray2);
        this.colorConfig = config;
        this.defaultSwitchColor = defaultSwitchColor;
    }

    public static /* synthetic */ void initConfig$default(ConfigSwitchColor configSwitchColor, ColorConfig colorConfig, ThemeUtils.SwitchColor switchColor, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initConfig");
        }
        if ((i & 2) != 0) {
            switchColor = null;
        }
        configSwitchColor.initConfig(colorConfig, switchColor);
    }

    public final void initConfig(ColorConfig config, ThemeUtils.SwitchColor defaultSwitchColor) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.colorConfig = config;
        this.defaultSwitchColor = defaultSwitchColor;
    }

    public int replaceColorById(Context context, int colorId, int viewThemeId) {
        SparseArray<Integer> colorIdMap;
        Intrinsics.checkNotNullParameter(context, "context");
        if (colorId == -1) {
            return 0;
        }
        ColorConfig colorConfig = this.colorConfig;
        Integer replaceColor = (colorConfig == null || (colorIdMap = colorConfig.getColorIdMap()) == null) ? null : colorIdMap.get(colorId);
        if (replaceColor == null) {
            replaceColor = particularColorReplaceById(context, colorId, viewThemeId);
        }
        if (replaceColor == null) {
            ThemeUtils.SwitchColor switchColor = this.defaultSwitchColor;
            replaceColor = switchColor != null ? Integer.valueOf(switchColor.replaceColorById(context, colorId, viewThemeId)) : null;
        }
        return replaceColor != null ? replaceColor.intValue() : ContextCompat.getColor(context, colorId);
    }

    protected Integer particularColorReplaceById(Context context, int colorId, int viewThemeId) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    public int replaceColor(Context context, int color) {
        SparseArray<Integer> colorMap;
        Intrinsics.checkNotNullParameter(context, "context");
        ColorConfig colorConfig = this.colorConfig;
        Integer replaceColor = (colorConfig == null || (colorMap = colorConfig.getColorMap()) == null) ? null : colorMap.get(color);
        if (replaceColor == null) {
            replaceColor = particularColorReplace(context, color);
        }
        if (replaceColor == null) {
            ThemeUtils.SwitchColor switchColor = this.defaultSwitchColor;
            replaceColor = switchColor != null ? Integer.valueOf(switchColor.replaceColor(context, color)) : null;
        }
        return replaceColor != null ? replaceColor.intValue() : color;
    }

    protected Integer particularColorReplace(Context context, int color) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    /* compiled from: ConfigSwitchColor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/theme/configswitchcolor/ConfigSwitchColor$ColorConfig;", "", "colorIdMap", "Landroid/util/SparseArray;", "", "colorMap", "<init>", "(Landroid/util/SparseArray;Landroid/util/SparseArray;)V", "getColorIdMap", "()Landroid/util/SparseArray;", "getColorMap", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ColorConfig {
        private final SparseArray<Integer> colorIdMap;
        private final SparseArray<Integer> colorMap;

        public ColorConfig(SparseArray<Integer> sparseArray, SparseArray<Integer> sparseArray2) {
            Intrinsics.checkNotNullParameter(sparseArray, "colorIdMap");
            this.colorIdMap = sparseArray;
            this.colorMap = sparseArray2;
        }

        public final SparseArray<Integer> getColorIdMap() {
            return this.colorIdMap;
        }

        public final SparseArray<Integer> getColorMap() {
            return this.colorMap;
        }
    }
}