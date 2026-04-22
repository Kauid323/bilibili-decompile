package tv.danmaku.bili.ui.main2.basic;

import android.content.Context;
import android.text.TextUtils;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.lib.homepage.widget.TabHost;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.magicasakura.utils.ThemeUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: TabHostGarbProvider.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/main2/basic/TabHostGarbProvider;", "", "<init>", "()V", "mTempTailIconList", "", "", "mTempTailSelectedList", "mGarb", "Lcom/bilibili/lib/ui/garb/Garb;", "mInterval", "", "build", "", "garb", "tabSize", "rebuild", "hasBottomGarb", "", "hasBottomIconGarb", "hasBottomColorGarb", "provide", "Lcom/bilibili/lib/homepage/widget/TabHost$TabInfo;", "context", "Landroid/content/Context;", "info", "index", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TabHostGarbProvider {
    public static final int $stable = 8;
    private Garb mGarb;
    private int mInterval;
    private final List<String> mTempTailIconList = new ArrayList();
    private final List<String> mTempTailSelectedList = new ArrayList();

    public final void build(Garb garb, int tabSize) {
        Intrinsics.checkNotNullParameter(garb, "garb");
        this.mTempTailIconList.clear();
        this.mTempTailSelectedList.clear();
        this.mGarb = garb;
        List tempTailIconList = new ArrayList();
        List tempTailSelectedList = new ArrayList();
        for (Object obj : garb.getTailIconPath()) {
            Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
            String path = (String) obj;
            if (!TextUtils.isEmpty(path)) {
                tempTailIconList.add(path);
            }
        }
        for (Object obj2 : garb.getTailIconSelectedPath()) {
            Intrinsics.checkNotNullExpressionValue(obj2, "next(...)");
            String path2 = (String) obj2;
            if (!TextUtils.isEmpty(path2)) {
                tempTailSelectedList.add(path2);
            }
        }
        this.mInterval = tempTailIconList.size() - tabSize;
        if (this.mInterval < 0) {
            this.mInterval = 0;
        }
        int middleIndex = (int) Math.floor(tempTailIconList.size() / 2.0f);
        int halfInterval = (int) Math.floor(this.mInterval / 2.0f);
        if (this.mInterval % 2 == 1) {
            List $this$forEachIndexed$iv = tempTailIconList;
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String s = (String) item$iv;
                if (index != middleIndex && (index < middleIndex - halfInterval || index > middleIndex + halfInterval)) {
                    this.mTempTailIconList.add(s);
                }
                index = index$iv;
            }
            List $this$forEachIndexed$iv2 = tempTailSelectedList;
            int index2 = 0;
            for (Object item$iv2 : $this$forEachIndexed$iv2) {
                int index$iv2 = index2 + 1;
                if (index2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String s2 = (String) item$iv2;
                if (index2 != middleIndex && (index2 < middleIndex - halfInterval || index2 > middleIndex + halfInterval)) {
                    this.mTempTailSelectedList.add(s2);
                }
                index2 = index$iv2;
            }
            return;
        }
        List $this$forEachIndexed$iv3 = tempTailIconList;
        int index3 = 0;
        for (Object item$iv3 : $this$forEachIndexed$iv3) {
            int index$iv3 = index3 + 1;
            if (index3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String s3 = (String) item$iv3;
            if (index3 == middleIndex || index3 < middleIndex - halfInterval || index3 > middleIndex + halfInterval) {
                this.mTempTailIconList.add(s3);
            }
            index3 = index$iv3;
        }
        List $this$forEachIndexed$iv4 = tempTailSelectedList;
        int index4 = 0;
        for (Object item$iv4 : $this$forEachIndexed$iv4) {
            int index$iv4 = index4 + 1;
            if (index4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String s4 = (String) item$iv4;
            if (index4 == middleIndex || index4 < middleIndex - halfInterval || index4 > middleIndex + halfInterval) {
                this.mTempTailSelectedList.add(s4);
            }
            index4 = index$iv4;
        }
    }

    public final void rebuild(Garb garb, int tabSize) {
        Intrinsics.checkNotNullParameter(garb, "garb");
        build(garb, tabSize);
    }

    public final boolean hasBottomGarb() {
        Garb it = this.mGarb;
        if (it == null || it.isPure()) {
            return false;
        }
        return hasBottomIconGarb(it) || hasBottomColorGarb(it);
    }

    private final boolean hasBottomIconGarb(Garb garb) {
        return (garb.isTailColorModel() || this.mTempTailIconList.isEmpty() || this.mTempTailSelectedList.isEmpty() || this.mTempTailIconList.size() != this.mTempTailIconList.size() || garb.getTailSelectedColor() == 0 || garb.getTailColor() == 0) ? false : true;
    }

    private final boolean hasBottomColorGarb(Garb garb) {
        return (!garb.isTailColorModel() || garb.getTailIconColor() == 0 || garb.getTailIconColorNight() == 0 || garb.getTailIconColorSelected() == 0 || garb.getTailIconColorSelectedNight() == 0) ? false : true;
    }

    public final TabHost.TabInfo provide(Context context, TabHost.TabInfo info, int index) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        boolean isNightTheme = MultipleThemeUtils.isNightTheme(context);
        boolean isExtraTheme = MultipleThemeUtils.isExtraTheme(context);
        if (!hasBottomGarb()) {
            info.garbSelectedIconUrl = "";
            info.garbIconUrl = "";
            info.garbTextColor = 0;
            info.garbTextSelectedColor = 0;
            info.hasAnimate = false;
            info.isAnimateLoop = false;
            info.publishPlusColor = -1;
            if (isExtraTheme) {
                i = ThemeUtils.getColorById(context, R.color.theme_color_secondary);
            } else {
                i = 0;
            }
            info.publishBgStartColor = i;
            if (isExtraTheme) {
                i2 = ThemeUtils.getColorById(context, R.color.theme_color_secondary);
            } else {
                i2 = 0;
            }
            info.publishBgEndColor = i2;
            info.isNightMode = isNightTheme;
            info.isGarb = false;
            info.isMultipleTheme = isExtraTheme;
            info.publishPlusUrl = "";
            info.publishPlusSelectedUrl = "";
            info.isTailColorModel = false;
            info.tailIconColor = 0;
            info.tailIconColorSelected = 0;
            return info;
        }
        if (index < this.mTempTailIconList.size()) {
            info.garbIconUrl = this.mTempTailIconList.get(index);
        }
        if (index < this.mTempTailSelectedList.size()) {
            info.garbSelectedIconUrl = this.mTempTailSelectedList.get(index);
        }
        Garb it = this.mGarb;
        if (it != null) {
            info.garbTextColor = it.getTailColor();
            info.garbTextSelectedColor = it.getTailSelectedColor();
            info.hasAnimate = it.getHasAnimate();
            info.isAnimateLoop = it.isAnimateLoop();
            info.publishPlusColor = it.getBtnIconColor();
            info.publishBgStartColor = it.getBtnBgStartColor();
            info.publishBgEndColor = it.getBtnBgEndColor();
            info.isNightMode = false;
            info.isGarb = true;
            info.isMultipleTheme = false;
            info.publishPlusUrl = it.getBtnIconPath();
            info.publishPlusSelectedUrl = it.getBtnIconSelectedPath();
            info.isTailColorModel = it.isTailColorModel();
            info.tailIconColor = isNightTheme ? it.getTailIconColorNight() : it.getTailIconColor();
            info.tailIconColorSelected = isNightTheme ? it.getTailIconColorSelectedNight() : it.getTailIconColorSelected();
        }
        return info;
    }
}