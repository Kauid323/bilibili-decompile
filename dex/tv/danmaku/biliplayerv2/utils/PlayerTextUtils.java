package tv.danmaku.biliplayerv2.utils;

import android.app.Application;
import android.text.TextUtils;
import com.bilibili.base.BiliContext;
import com.bilibili.base.R;
import com.bilibili.droid.StringFormatter;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import tv.danmaku.bili.ui.personinfo.PersonInfoLoadFragment;
import tv.danmaku.bili.ui.rank.view.ViewHolderBase;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterReporterKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: PlayerTextUtils.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/PlayerTextUtils;", "", "<init>", "()V", "TEN_THOUSAND", "", "HUNDRED_MILLION", "getShortDesc", "", "desc", IjkMediaMeta.IJKM_KEY_FORMAT, WatchLaterReporterKt.KEY_NUM, "", "defValue", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerTextUtils {
    public static final PlayerTextUtils INSTANCE = new PlayerTextUtils();
    private static final int TEN_THOUSAND = PersonInfoLoadFragment.ERROR_CODE_MODIFY_FORBIDDEN;
    private static final int HUNDRED_MILLION = ViewHolderBase.HUNDRED_MILLION;

    private PlayerTextUtils() {
    }

    public final String getShortDesc(String desc) {
        Collection emptyList;
        boolean z;
        Intrinsics.checkNotNullParameter(desc, "desc");
        if (TextUtils.isEmpty(desc)) {
            return desc;
        }
        List $this$dropLastWhile$iv = new Regex(" ").split(desc, 0);
        if (!$this$dropLastWhile$iv.isEmpty()) {
            ListIterator iterator$iv = $this$dropLastWhile$iv.listIterator($this$dropLastWhile$iv.size());
            while (iterator$iv.hasPrevious()) {
                if (((String) iterator$iv.previous()).length() == 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    emptyList = CollectionsKt.take($this$dropLastWhile$iv, iterator$iv.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt.emptyList();
        Collection $this$toTypedArray$iv = emptyList;
        CharSequence[] array = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
        if (array.length > 1) {
            CharSequence $this$trim$iv = array[1];
            CharSequence $this$trim$iv$iv = $this$trim$iv;
            int startIndex$iv$iv = 0;
            int endIndex$iv$iv = $this$trim$iv$iv.length() - 1;
            boolean startFound$iv$iv = false;
            while (startIndex$iv$iv <= endIndex$iv$iv) {
                int index$iv$iv = !startFound$iv$iv ? startIndex$iv$iv : endIndex$iv$iv;
                char it = Intrinsics.compare($this$trim$iv$iv.charAt(index$iv$iv), 32) <= 0 ? (char) 1 : (char) 0;
                if (startFound$iv$iv) {
                    if (it == 0) {
                        break;
                    }
                    endIndex$iv$iv--;
                } else if (it == 0) {
                    startFound$iv$iv = true;
                } else {
                    startIndex$iv$iv++;
                }
            }
            String $this$trim$iv2 = $this$trim$iv$iv.subSequence(startIndex$iv$iv, endIndex$iv$iv + 1).toString();
            if (TextUtils.isEmpty($this$trim$iv2)) {
                return desc;
            }
            String shotDesc = array[1];
            return shotDesc;
        }
        return desc;
    }

    public final String format(long num, String defValue) {
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        String unitTenThousand = application.getString(R.string.player_number_unit_ten_thousand);
        Intrinsics.checkNotNullExpressionValue(unitTenThousand, "getString(...)");
        Application application2 = BiliContext.application();
        Intrinsics.checkNotNull(application2);
        String unitAhundredMillion = application2.getString(R.string.player_number_unit_a_hundred_million);
        Intrinsics.checkNotNullExpressionValue(unitAhundredMillion, "getString(...)");
        if (num >= HUNDRED_MILLION) {
            float n = ((float) num) / HUNDRED_MILLION;
            float remainder = n % 1;
            if (remainder >= 0.95d || remainder <= 0.049d) {
                String format = StringFormatter.format(Locale.CHINA, "%.0f" + unitAhundredMillion, new Object[]{Float.valueOf(n)});
                Intrinsics.checkNotNull(format);
                return format;
            }
            String format2 = StringFormatter.format(Locale.CHINA, "%.1f" + unitAhundredMillion, new Object[]{Float.valueOf(n)});
            Intrinsics.checkNotNull(format2);
            return format2;
        } else if (num >= 99999500) {
            return "1" + unitAhundredMillion;
        } else {
            if (num >= TEN_THOUSAND) {
                float n2 = ((float) num) / TEN_THOUSAND;
                float remainder2 = n2 % 1;
                if (remainder2 >= 0.95d || remainder2 <= 0.049d) {
                    String format3 = StringFormatter.format(Locale.CHINA, "%.0f" + unitTenThousand, new Object[]{Float.valueOf(n2)});
                    Intrinsics.checkNotNull(format3);
                    return format3;
                }
                String format4 = StringFormatter.format(Locale.CHINA, "%.1f" + unitTenThousand, new Object[]{Float.valueOf(n2)});
                Intrinsics.checkNotNull(format4);
                return format4;
            } else if (num > 0) {
                return String.valueOf(num);
            } else {
                return defValue;
            }
        }
    }
}