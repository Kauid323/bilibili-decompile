package tv.danmaku.bili.auth;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.bilibili.app.auth.R;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;

/* compiled from: BiliAuthExts.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/auth/TipLinkHelper;", "", "<init>", "()V", "setLink", "", "mTx", "Landroid/widget/TextView;", "tips", "", "highlight", "listener", "Landroid/text/style/ClickableSpan;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TipLinkHelper {
    public static final TipLinkHelper INSTANCE = new TipLinkHelper();

    private TipLinkHelper() {
    }

    public final void setLink(TextView mTx, String tips, String highlight, final ClickableSpan listener) {
        Intrinsics.checkNotNullParameter(tips, "tips");
        Intrinsics.checkNotNullParameter(highlight, "highlight");
        if (mTx == null) {
            return;
        }
        SpannableString text = SpannableString.valueOf(tips);
        int startCheckHelp1 = StringsKt.indexOf$default(tips, highlight, 0, false, 6, (Object) null);
        int endCheckHelp1 = highlight.length() + startCheckHelp1;
        if (startCheckHelp1 != -1 && endCheckHelp1 > startCheckHelp1) {
            text.setSpan(new ClickableSpan() { // from class: tv.danmaku.bili.auth.TipLinkHelper$setLink$1
                @Override // android.text.style.ClickableSpan
                public void onClick(View p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    ClickableSpan clickableSpan = listener;
                    if (clickableSpan != null) {
                        clickableSpan.onClick(p0);
                    }
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.checkNotNullParameter(ds, "ds");
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                    ds.bgColor = 0;
                    ds.setColor(FoundationAlias.getFapp().getResources().getColor(R.color.text_blue_kit));
                }
            }, startCheckHelp1, endCheckHelp1, 18);
            mTx.setText(text);
            mTx.setMovementMethod(LinkMovementMethod.getInstance());
            mTx.setHighlightColor(FoundationAlias.getFapp().getResources().getColor(R.color.text_blue_kit));
        }
    }
}