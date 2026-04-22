package tv.danmaku.bili.ui.main2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.bilibili.lib.basecomponent.R;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.lib.ui.RouteConstKt;
import com.bilibili.lib.ui.Target;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class WatchLaterActivity extends BaseToolbarActivity {
    Drawable mBackDrawable;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_app_activity_with_toolbar);
        Toolbar toolbar = findViewById(tv.danmaku.bili.R.id.nav_top_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.mBackDrawable = toolbar.getNavigationIcon().mutate();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setSupportActionBar(null);
        ((ViewGroup) findViewById(R.id.activity_root)).removeViewAt(0);
        if (savedInstanceState == null) {
            RouteRequest request = new RouteRequest.Builder(Uri.parse("bilibili://main/playset/watch-later/")).extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.WatchLaterActivity$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return WatchLaterActivity.lambda$onCreate$0((MutableBundleLike) obj);
                }
            }).build();
            Target target = RouteConstKt.findRoute(BLRouter.INSTANCE, request);
            if (target != null) {
                Fragment fragment = Fragment.instantiate(this, target.getClazz().getName(), target.getArgs());
                getSupportFragmentManager().beginTransaction().add(tv.danmaku.bili.R.id.content_layout, fragment).commit();
                return;
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$onCreate$0(MutableBundleLike bundleLike) {
        bundleLike.put("activity_base_toolbar", String.valueOf(true));
        return null;
    }

    public Drawable getBackDrawable() {
        return this.mBackDrawable;
    }

    public void onBackPressed() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null && fragments.size() > 0) {
            for (Fragment fragment : fragments) {
                if (fragment instanceof WatchLaterFragmentV2) {
                    boolean handler = ((WatchLaterFragmentV2) fragment).onBackPress();
                    if (!handler) {
                        super.onBackPressed();
                        return;
                    }
                    return;
                }
            }
        }
        super.onBackPressed();
    }
}