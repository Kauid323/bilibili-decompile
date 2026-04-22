package tv.danmaku.bili.videopage.common.widget.view;

import android.content.Context;
import android.text.TextDirectionHeuristic;
import android.util.AttributeSet;
import com.bilibili.magicasakura.widgets.TintTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LTRTextView.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/LTRTextView;", "Lcom/bilibili/magicasakura/widgets/TintTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getTextDirectionHeuristic", "Landroid/text/TextDirectionHeuristic;", "Companion", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class LTRTextView extends TintTextView {
    public static final Companion Companion = new Companion(null);
    private static final TextDirectionHeuristic FORCE_LTR = new TextDirectionHeuristic() { // from class: tv.danmaku.bili.videopage.common.widget.view.LTRTextView$Companion$FORCE_LTR$1
        @Override // android.text.TextDirectionHeuristic
        public boolean isRtl(char[] array, int start, int count) {
            Intrinsics.checkNotNullParameter(array, "array");
            return false;
        }

        @Override // android.text.TextDirectionHeuristic
        public boolean isRtl(CharSequence cs, int start, int count) {
            Intrinsics.checkNotNullParameter(cs, "cs");
            return false;
        }
    };

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LTRTextView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LTRTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LTRTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public TextDirectionHeuristic getTextDirectionHeuristic() {
        return FORCE_LTR;
    }

    /* compiled from: LTRTextView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/LTRTextView$Companion;", "", "<init>", "()V", "FORCE_LTR", "Landroid/text/TextDirectionHeuristic;", "getFORCE_LTR", "()Landroid/text/TextDirectionHeuristic;", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TextDirectionHeuristic getFORCE_LTR() {
            return LTRTextView.FORCE_LTR;
        }
    }
}