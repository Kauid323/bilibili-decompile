package tv.danmaku.bili.push.innerpush.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;

/* compiled from: MockBizView.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/MockBizView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "message", "", "attr", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/util/AttributeSet;I)V", "initView", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MockBizView extends FrameLayout {
    public static final int $stable = 8;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MockBizView(Context context) {
        this(context, null, null, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MockBizView(Context context, String str) {
        this(context, str, null, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MockBizView(Context context, String str, AttributeSet attributeSet) {
        this(context, str, attributeSet, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MockBizView(Context context, String message, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout.inflate(getContext(), R.layout.bili_app_push_mock_biz_view, this);
        initView(message);
    }

    public /* synthetic */ MockBizView(Context context, String str, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : attributeSet, (i2 & 8) != 0 ? 0 : i);
    }

    private final void initView(String message) {
        TextView text = (TextView) findViewById(R.id.push_mock_textview);
        if (message != null) {
            text.setText(message);
        }
    }
}