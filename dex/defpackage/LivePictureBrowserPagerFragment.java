package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bilibili.bililive.infra.picturebrowser.R;
import com.bilibili.lib.spy.generated.androidx_fragment_app_Fragment;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LivePictureBrowserPagerFragment.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"LLivePictureBrowserPagerFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "listener", "LLivePictureBrowserListener;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setPictureBrowserListener", "Companion", "picturebrowser_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: LivePictureBrowserPagerFragment  reason: default package */
public final class LivePictureBrowserPagerFragment extends androidx_fragment_app_Fragment {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_PICS = "pics";
    private static final String KEY_POSITION = "position";
    private LivePictureBrowserListener listener;
    private ViewPager viewPager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.live_pictures_browser_pager_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        PagerAdapter adapter;
        Intrinsics.checkNotNullParameter(view, "view");
        this.viewPager = view.findViewById(R.id.view_pager_pics);
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            PagerAdapter livePictureBrowserPagerFragmentAdapter2 = new LivePictureBrowserPagerFragmentAdapter2(childFragmentManager, this.listener);
            Bundle arguments = getArguments();
            livePictureBrowserPagerFragmentAdapter2.setPics(arguments != null ? arguments.getParcelableArrayList(KEY_PICS) : null);
            viewPager.setAdapter(livePictureBrowserPagerFragmentAdapter2);
        }
        Bundle arguments2 = getArguments();
        int i = 0;
        int showPosition = arguments2 != null ? arguments2.getInt(KEY_POSITION) : 0;
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            if (showPosition >= 0) {
                ViewPager viewPager3 = this.viewPager;
                if (showPosition <= ((viewPager3 == null || (adapter = viewPager3.getAdapter()) == null) ? 0 : adapter.getCount()) - 1) {
                    i = showPosition;
                }
            }
            viewPager2.setCurrentItem(i);
        }
    }

    public final void setPictureBrowserListener(LivePictureBrowserListener listener) {
        this.listener = listener;
    }

    /* compiled from: LivePictureBrowserPagerFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"LLivePictureBrowserPagerFragment$Companion;", "", "<init>", "()V", "create", "LLivePictureBrowserPagerFragment;", LivePictureBrowserPagerFragment.KEY_PICS, "Ljava/util/ArrayList;", "LILivePictureData;", "Lkotlin/collections/ArrayList;", LivePictureBrowserPagerFragment.KEY_POSITION, "", "KEY_PICS", "", "KEY_POSITION", "picturebrowser_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: LivePictureBrowserPagerFragment$Companion */
    /* loaded from: /data/np/file-convert/2026022807222197de6f91-6104-46cc-91cf-b90bdc19816e/2026022807222197de6f91-6104-46cc-91cf-b90bdc19816e.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ LivePictureBrowserPagerFragment create$default(Companion companion, ArrayList arrayList, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.create(arrayList, i);
        }

        public final LivePictureBrowserPagerFragment create(ArrayList<ILivePictureData> arrayList, int position) {
            Intrinsics.checkNotNullParameter(arrayList, LivePictureBrowserPagerFragment.KEY_PICS);
            LivePictureBrowserPagerFragment $this$create_u24lambda_u240 = new LivePictureBrowserPagerFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(LivePictureBrowserPagerFragment.KEY_PICS, arrayList);
            bundle.putInt(LivePictureBrowserPagerFragment.KEY_POSITION, position);
            $this$create_u24lambda_u240.setArguments(bundle);
            return $this$create_u24lambda_u240;
        }
    }
}