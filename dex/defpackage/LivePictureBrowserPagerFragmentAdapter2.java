package defpackage;

import LivePictureBrowserFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LivePictureBrowserPagerFragment.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u000e\u001a\u00020\u000f2\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"LLivePictureBrowserPagerFragmentAdapter2;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "listener", "LLivePictureBrowserListener;", "<init>", "(Landroidx/fragment/app/FragmentManager;LLivePictureBrowserListener;)V", "getListener", "()LLivePictureBrowserListener;", "pics", "Ljava/util/ArrayList;", "LILivePictureData;", "Lkotlin/collections/ArrayList;", "setPics", "", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "picturebrowser_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: LivePictureBrowserPagerFragmentAdapter2  reason: default package */
public final class LivePictureBrowserPagerFragmentAdapter2 extends FragmentStatePagerAdapter {
    private final LivePictureBrowserListener listener;
    private final ArrayList<ILivePictureData> pics;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePictureBrowserPagerFragmentAdapter2(FragmentManager fm, LivePictureBrowserListener listener) {
        super(fm);
        Intrinsics.checkNotNullParameter(fm, "fm");
        this.listener = listener;
        this.pics = new ArrayList<>();
    }

    public final LivePictureBrowserListener getListener() {
        return this.listener;
    }

    public final void setPics(ArrayList<ILivePictureData> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.pics.clear();
        this.pics.addAll(arrayList);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.pics.size();
    }

    public Fragment getItem(int position) {
        LivePictureBrowserFragment.Companion companion = LivePictureBrowserFragment.Companion;
        ILivePictureData iLivePictureData = this.pics.get(position);
        Intrinsics.checkNotNullExpressionValue(iLivePictureData, "get(...)");
        Fragment create = companion.create(iLivePictureData);
        create.setListener(this.listener);
        return create;
    }
}