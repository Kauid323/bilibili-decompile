package tv.danmaku.bili.widget;

import android.net.Uri;
import android.text.style.URLSpan;
import android.view.View;
import tv.danmaku.bili.utils.UriRouteKt;

public class UriSpan extends URLSpan {
    public UriSpan(String url) {
        super(url);
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View widget) {
        UriRouteKt.openRoute(Uri.parse(getURL()), widget.getContext(), false);
    }
}