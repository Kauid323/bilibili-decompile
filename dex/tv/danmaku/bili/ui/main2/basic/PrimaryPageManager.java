package tv.danmaku.bili.ui.main2.basic;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bilibili.lib.homepage.startdust.OnPageSelectChangeListener;
import com.bilibili.lib.homepage.util.BottomTabSelectedHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import tv.danmaku.android.log.BLog;

/* JADX INFO: Access modifiers changed from: package-private */
public final class PrimaryPageManager {
    private static final String KEY_CURRENT_FRAGMENT_TAG = "home.main.current.page.fragment.tag";
    private static final String KEY_CURRENT_FRAGMENT_URL = "home.main.current.page.fragment.url";
    private static final String TAG = "home.main.page.mng";
    private static final String TAG_FORMAT = "main:primary:page:%s:%s";
    private int mContainerId;
    private String mCurPageUrl;
    private FragmentManager mFm;
    private Map<String, PrimaryPage> mPages = new HashMap();

    public PrimaryPageManager(int containerId, FragmentManager fm) {
        this.mContainerId = containerId;
        this.mFm = fm;
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.mCurPageUrl == null) {
            return;
        }
        outState.putString(KEY_CURRENT_FRAGMENT_URL, this.mCurPageUrl);
        if (this.mPages.get(this.mCurPageUrl) != null) {
            outState.putString(KEY_CURRENT_FRAGMENT_TAG, this.mPages.get(this.mCurPageUrl).mTag);
        }
    }

    public void onRestoreInstanceState(Bundle outState) {
        if (outState == null) {
            return;
        }
        String savedPageUrl = outState.getString(KEY_CURRENT_FRAGMENT_URL);
        String savedFragTag = outState.getString(KEY_CURRENT_FRAGMENT_TAG);
        if (savedPageUrl == null || savedFragTag == null) {
            return;
        }
        PrimaryPage page = this.mPages.get(savedPageUrl);
        if (page == null) {
            removePageFragment(savedFragTag);
            return;
        }
        this.mCurPageUrl = savedPageUrl;
        if (TextUtils.equals(savedFragTag, page.mTag)) {
            OnPageSelectChangeListener findPageFragment = page.findPageFragment(this.mFm);
            if (findPageFragment != null && (findPageFragment instanceof OnPageSelectChangeListener)) {
                findPageFragment.onPageSelected((Map) null);
            }
            BLog.dfmt(TAG, "restore primary page: tag(%s)", savedFragTag);
            return;
        }
        removePageFragment(savedFragTag);
        switchTo(savedPageUrl);
    }

    public void removePageFragment(String pageUrl, Class<? extends Fragment> page) {
        if (page == null) {
            return;
        }
        String fragTag = PrimaryPage.buildTag(pageUrl, page);
        removePageFragment(fragTag);
    }

    private void removePageFragment(String fragTag) {
        Fragment fragment = this.mFm.findFragmentByTag(fragTag);
        if (fragment != null) {
            this.mFm.beginTransaction().remove(fragment).commitNowAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class PrimaryPage {
        private Bundle mArgs;
        private Class<? extends Fragment> mClazz;
        private Fragment mPageFragment;
        private String mPageUrl;
        private String mTag;

        private PrimaryPage(String pageUrl, Class<? extends Fragment> clazz, Bundle args) {
            this.mPageUrl = pageUrl;
            this.mClazz = clazz;
            this.mArgs = args;
            this.mTag = getTag();
        }

        static String buildTag(String pageUrl, Class clazz) {
            return String.format(PrimaryPageManager.TAG_FORMAT, Integer.valueOf(pageUrl.hashCode()), clazz.getSimpleName());
        }

        public String getTag() {
            if (!TextUtils.isEmpty(this.mTag)) {
                return this.mTag;
            }
            if (this.mClazz == null) {
                return null;
            }
            return buildTag(this.mPageUrl, this.mClazz);
        }

        public Fragment findPageFragment(FragmentManager fm) {
            if (this.mPageFragment != null) {
                return this.mPageFragment;
            }
            Fragment fragment = fm.findFragmentByTag(this.mTag);
            if (fragment == null) {
                return null;
            }
            this.mPageFragment = fragment;
            return this.mPageFragment;
        }

        public Fragment getPageInstance(FragmentManager fm) {
            Fragment nf;
            if (this.mPageFragment != null) {
                return this.mPageFragment;
            }
            Fragment fragment = fm.findFragmentByTag(this.mTag);
            if (fragment == null) {
                BLog.dfmt(PrimaryPageManager.TAG, "create new instance of fragment. tag: %s", this.mTag);
                try {
                    nf = this.mClazz.newInstance();
                    if (!(nf instanceof Fragment)) {
                        throw new RuntimeException(String.format("IPrimaryPageFragment(%s) must be an instance of Fragment", this.mClazz.getName()));
                    }
                    nf.setArguments(this.mArgs);
                } catch (Exception e) {
                    throw new RuntimeException(String.format("Can not create IPrimaryPageFragment instance by class(%s).", this.mClazz.getName()));
                }
            } else {
                BLog.dfmt(PrimaryPageManager.TAG, "find fragment from fragmentManager: %s", this.mTag);
                nf = fragment;
            }
            this.mPageFragment = nf;
            return this.mPageFragment;
        }

        public Fragment getPageFragment() {
            return this.mPageFragment;
        }
    }

    public void addPage(String id, Class<? extends Fragment> page, Bundle args) {
        if (TextUtils.isEmpty(id)) {
            BLog.e(TAG, "the param id must be NoNull and unique");
        } else if (page == null) {
            BLog.e(TAG, "the param page must be NoNull");
        } else {
            this.mPages.put(id, new PrimaryPage(id, page, args));
        }
    }

    public void switchTo(String pageUrl) {
        switchTo(pageUrl, null);
    }

    public void switchTo(String pageUrl, Map<String, Object> extras) {
        PrimaryPage pg = this.mPages.get(pageUrl);
        if (pg == null) {
            String msg = String.format("cannot find primary page by id (%s)", pageUrl);
            BLog.e(TAG, msg);
            return;
        }
        FragmentTransaction ft = this.mFm.beginTransaction();
        ft.setCustomAnimations(0, 0, 0, 0);
        if (this.mCurPageUrl != null) {
            PrimaryPage currentPage = this.mPages.get(this.mCurPageUrl);
            if (currentPage == null) {
                return;
            }
            OnPageSelectChangeListener findPageFragment = currentPage.findPageFragment(this.mFm);
            if (findPageFragment != null) {
                if (findPageFragment instanceof OnPageSelectChangeListener) {
                    findPageFragment.onPageUnselected();
                }
                ft.hide(findPageFragment);
            }
            BLog.dfmt(TAG, "hide primary page: tag(%s)", currentPage.mTag);
        }
        OnPageSelectChangeListener pageInstance = pg.getPageInstance(this.mFm);
        if (!pageInstance.isAdded()) {
            ft.add(this.mContainerId, pageInstance, pg.getTag());
            BLog.dfmt(TAG, "add primary page: tag(%s)", pg.mTag);
        }
        ft.show(pageInstance).commitNowAllowingStateLoss();
        this.mCurPageUrl = pageUrl;
        BottomTabSelectedHelper.INSTANCE.setCurrentBottomTabUrl(this.mCurPageUrl, pg.mTag);
        if (pageInstance instanceof OnPageSelectChangeListener) {
            pageInstance.onPageSelected(extras);
            if (extras != null) {
                BLog.dfmt(TAG, "extra = %s", extras);
            }
        }
        BLog.dfmt(TAG, "show primary page: tag(%s)", pg.mTag);
    }

    public Fragment getCurIPrimaryPageFragment() {
        PrimaryPage currentPage;
        if (this.mCurPageUrl != null && (currentPage = this.mPages.get(this.mCurPageUrl)) != null) {
            return currentPage.findPageFragment(this.mFm);
        }
        return null;
    }

    public void invokePageSelectedListener(String pageUrl, Map<String, Object> extras) {
        PrimaryPage pg = this.mPages.get(pageUrl);
        if (pg == null) {
            return;
        }
        OnPageSelectChangeListener pageInstance = pg.getPageInstance(this.mFm);
        if (pageInstance instanceof OnPageSelectChangeListener) {
            pageInstance.onPageSelected(extras);
            if (extras != null) {
                BLog.dfmt(TAG, "extra = %s", extras);
            }
        }
    }

    public String idOf(Fragment f) {
        if (f == null) {
            return null;
        }
        Set<String> keys = this.mPages.keySet();
        for (String key : keys) {
            PrimaryPage pg = this.mPages.get(key);
            if (f == pg.mPageFragment) {
                return key;
            }
        }
        return null;
    }

    public PrimaryPage current() {
        return this.mPages.get(this.mCurPageUrl);
    }

    public String getCurPageUrl() {
        return this.mCurPageUrl;
    }

    public void clearAll() {
        this.mCurPageUrl = null;
        this.mPages.clear();
    }
}