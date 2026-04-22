package tv.danmaku.bili.ui.main2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.lib.ui.BaseFragment;

public abstract class MainPagerFragmentV2 extends BaseFragment implements Toolbar.OnMenuItemClickListener {
    protected abstract Toolbar getBar();

    protected int getTitleId() {
        return 0;
    }

    protected boolean enableNavigationIcon() {
        return true;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toolbar toolbar = getBar();
        if (getTitleId() == 0) {
            toolbar.setTitle((CharSequence) null);
        } else {
            toolbar.setTitle(getTitleId());
        }
        if (enableNavigationIcon()) {
            toolbar.setNavigationIcon(R.drawable.ic_navigation_drawer);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.MainPagerFragmentV2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    FragmentActivity activity = MainPagerFragmentV2.this.getActivity();
                    if (activity != null) {
                        activity.onBackPressed();
                    }
                }
            });
            return;
        }
        toolbar.setNavigationIcon((Drawable) null);
    }
}