package tv.danmaku.bili.push.pushsetting.ui.adapter;

import android.graphics.Paint;
import android.widget.TextView;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: PushSettingOptionAdapter.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"getTagWidth", "", "Landroid/widget/TextView;", "getPreWidth", "CHECK_STATE_CHANGED_PAYLOAD", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PushSettingOptionAdapterKt {
    private static final String CHECK_STATE_CHANGED_PAYLOAD = "check_state_changed_payload";

    public static final /* synthetic */ int access$getPreWidth(TextView $receiver) {
        return getPreWidth($receiver);
    }

    public static final /* synthetic */ int access$getTagWidth(TextView $receiver) {
        return getTagWidth($receiver);
    }

    public static final int getTagWidth(TextView $this$getTagWidth) {
        if ($this$getTagWidth.getText().toString().length() > 4) {
            $this$getTagWidth.setText($this$getTagWidth.getText().subSequence(0, 4));
        }
        CharSequence text = $this$getTagWidth.getText();
        if (text == null || text.length() == 0) {
            return 0;
        }
        return getPreWidth($this$getTagWidth) + ListExtentionsKt.toPx(4);
    }

    public static final int getPreWidth(TextView $this$getPreWidth) {
        Paint paint = new Paint();
        paint.setTextSize($this$getPreWidth.getTextSize());
        paint.setTypeface($this$getPreWidth.getTypeface());
        String text = $this$getPreWidth.getText().toString();
        return ((int) paint.measureText(text)) + $this$getPreWidth.getPaddingStart() + $this$getPreWidth.getPaddingEnd();
    }
}