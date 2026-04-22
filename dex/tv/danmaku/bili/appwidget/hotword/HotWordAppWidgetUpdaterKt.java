package tv.danmaku.bili.appwidget.hotword;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotword.data.WidgetButtonData;

/* compiled from: HotWordAppWidgetUpdater.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0002\u001a$\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"FROM_WIDGET", "", "WIDGET_MODULE_TITLE", "REQUEST_CODE_AVATAR", "", "REQUEST_CODE_SEARCH", "REQUEST_CODE_APP", "REQUEST_CODE_ENTRANCE", "REQUEST_CODE_AUTO_ADD", "URL_SEARCH", "URL_ME", "isValid", "", "Ltv/danmaku/bili/appwidget/hotword/data/WidgetButtonData;", "getBitmapFromFile", "Landroid/graphics/Bitmap;", "file", "Ljava/io/File;", "desiredWidth", "desiredHeight", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HotWordAppWidgetUpdaterKt {
    public static final String FROM_WIDGET = "from_widget";
    private static final int REQUEST_CODE_APP = 3335;
    public static final int REQUEST_CODE_AUTO_ADD = 3337;
    private static final int REQUEST_CODE_AVATAR = 3333;
    private static final int REQUEST_CODE_ENTRANCE = 3340;
    private static final int REQUEST_CODE_SEARCH = 3334;
    private static final String URL_ME = "bilibili://root?bottom_tab_id=我的Bottom";
    private static final String URL_SEARCH = "bilibili://search";
    public static final String WIDGET_MODULE_TITLE = "widget_moudle_title";

    public static final /* synthetic */ Bitmap access$getBitmapFromFile(File file, int desiredWidth, int desiredHeight) {
        return getBitmapFromFile(file, desiredWidth, desiredHeight);
    }

    public static final boolean isValid(WidgetButtonData $this$isValid) {
        String str = $this$isValid.text;
        if (str != null && (StringsKt.isBlank(str) ^ true)) {
            String str2 = $this$isValid.icon;
            if (str2 != null && (StringsKt.isBlank(str2) ^ true)) {
                String str3 = $this$isValid.url;
                return str3 != null && (StringsKt.isBlank(str3) ^ true);
            }
            return false;
        }
        return false;
    }

    public static final Bitmap getBitmapFromFile(File file, int desiredWidth, int desiredHeight) {
        if (file == null || file.length() <= 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getPath(), options);
        if (options.outHeight == 0 || options.outWidth == 0) {
            return null;
        }
        options.inSampleSize = BitmapLoadUtils.calculateInSampleSize(options, desiredWidth, desiredHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(file.getPath(), options);
    }
}