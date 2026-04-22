package h;

import android.view.View;
import com.sina.weibo.sdk.web.WebActivity;

public final class b implements View.OnClickListener {
    public final /* synthetic */ WebActivity a;

    public b(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WebActivity webActivity = this.a;
        webActivity.a.setVisibility(8);
        webActivity.d.setVisibility(0);
        this.a.d.reload();
    }
}