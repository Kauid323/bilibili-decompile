package tv.danmaku.bili.widget.section.adapter;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends FragmentPagerAdapter {
    Context mContext;
    List<PageInfo> mPages;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface Page {
        boolean canScrollUp();

        Fragment getFragment();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface PageInfo {
        int getId();

        Page getPage();

        CharSequence getTitle(Context context);
    }

    public PageAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mPages = new ArrayList();
        this.mContext = context;
    }

    public PageAdapter(Context context, FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.mPages = new ArrayList();
        this.mContext = context;
    }

    public void add(int position, PageInfo page) {
        this.mPages.add(position, page);
    }

    public void add(PageInfo page) {
        add(this.mPages.size(), page);
    }

    public void remove(PageInfo page) {
        this.mPages.remove(page);
    }

    public void removeAll() {
        if (this.mPages != null) {
            this.mPages.clear();
        }
    }

    public List<PageInfo> getAllPages() {
        return this.mPages;
    }

    public Fragment getItem(int position) {
        return getPage(position).getPage().getFragment();
    }

    public PageInfo getPage(int position) {
        return this.mPages.get(position);
    }

    public int getCount() {
        return this.mPages.size();
    }

    public CharSequence getPageTitle(int position) {
        PageInfo pageInfo = getPage(position);
        if (pageInfo != null) {
            return pageInfo.getTitle(this.mContext);
        }
        return "";
    }

    public int indexOf(PageInfo info) {
        for (int i = 0; i < this.mPages.size(); i++) {
            if (getPage(i) == info) {
                return i;
            }
        }
        return -1;
    }

    public int getItemPosition(Object object) {
        Page page = (Fragment) object;
        for (int i = 0; i < this.mPages.size(); i++) {
            if (getPage(i).getPage() == page) {
                return i;
            }
        }
        return -2;
    }

    public long getItemId(int position) {
        return getPage(position).getId();
    }

    public static String getTagName(int viewId, PageInfo page) {
        return "android:switcher:" + viewId + ":" + page.getId();
    }
}