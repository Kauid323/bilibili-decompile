package tv.danmaku.bili.videopage.common.widget.span;

import android.text.style.URLSpan;
import android.view.View;
import tv.danmaku.bili.videopage.common.helper.UriRouteHelper;

public class UriSpan extends URLSpan {
    public UriSpan(String url) {
        super(url);
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View widget) {
        UriRouteHelper.goToUri(widget.getContext(), getURL());
    }
}