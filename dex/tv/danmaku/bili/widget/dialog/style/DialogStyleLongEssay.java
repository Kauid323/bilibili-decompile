package tv.danmaku.bili.widget.dialog.style;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.bilibili.lib.theme.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DialogStyles.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/widget/dialog/style/DialogStyleLongEssay;", "Ltv/danmaku/bili/widget/dialog/style/BaseDialogContentStyle;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DialogStyleLongEssay extends BaseDialogContentStyle {
    public DialogStyleLongEssay(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        setContentColor(ContextCompat.getColor(context, R.color.Ga10));
        setContentTextMarginTop(8);
        setContentMarginTop(8);
        setContentTextSize(13.0f);
        setContentTextLineHeight(19);
        setContentGravity(3);
    }
}