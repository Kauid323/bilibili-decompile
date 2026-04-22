package tv.danmaku.bili;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.ui.login.LoginReporterV2;

public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);

    public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
        int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
        if (localizedLayoutId > 0) {
            Object tag = view.getTag();
            if (tag == null) {
                throw new RuntimeException("view must have a tag");
            }
            return null;
        }
        return null;
    }

    public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
        if (views == null || views.length == 0) {
            return null;
        }
        int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
        if (localizedLayoutId > 0) {
            Object tag = views[0].getTag();
            if (tag == null) {
                throw new RuntimeException("view must have a tag");
            }
        }
        return null;
    }

    public int getLayoutId(String tag) {
        Integer tmpVal;
        if (tag == null || (tmpVal = InnerLayoutIdLookup.sKeys.get(tag)) == null) {
            return 0;
        }
        return tmpVal.intValue();
    }

    public String convertBrIdToString(int localId) {
        String tmpVal = InnerBrLookup.sKeys.get(localId);
        return tmpVal;
    }

    public List<DataBinderMapper> collectDependencies() {
        ArrayList<DataBinderMapper> result = new ArrayList<>(8);
        result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        result.add(new com.bilibili.app.comment2.DataBinderMapperImpl());
        result.add(new com.bilibili.app.gemini.base.DataBinderMapperImpl());
        result.add(new com.bilibili.app.gemini.ui.DataBinderMapperImpl());
        result.add(new com.bilibili.lib.bilipay.DataBinderMapperImpl());
        result.add(new com.bilibili.ogv.glue.DataBinderMapperImpl());
        result.add(new com.bilibili.video.story.DataBinderMapperImpl());
        result.add(new com.bilibili.video.videodetail.DataBinderMapperImpl());
        return result;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static class InnerBrLookup {
        static final SparseArray<String> sKeys = new SparseArray<>(76);

        private InnerBrLookup() {
        }

        static {
            sKeys.put(0, "_all");
            sKeys.put(1, "allTagDataList");
            sKeys.put(2, "animSurpriseEvent");
            sKeys.put(3, "animSurpriseState");
            sKeys.put(4, "announcementContent");
            sKeys.put(5, "announcementTitle");
            sKeys.put(6, BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND);
            sKeys.put(7, "chatHint");
            sKeys.put(8, "chatPlayerInputHint");
            sKeys.put(9, "constellationAndAge");
            sKeys.put(10, "content");
            sKeys.put(11, "coverUrl");
            sKeys.put(12, "dataList");
            sKeys.put(13, "descName");
            sKeys.put(14, "disable");
            sKeys.put(15, "disableTagTextColor");
            sKeys.put(16, "emotionBadgeVisible");
            sKeys.put(17, "emptyType");
            sKeys.put(18, "endContent");
            sKeys.put(19, "errorTip");
            sKeys.put(20, "followButtonConfig");
            sKeys.put(21, "hasAddView");
            sKeys.put(22, "hasAnnouncement");
            sKeys.put(23, "hasPendant");
            sKeys.put(24, "hasPinMsg");
            sKeys.put(25, "highPrivilegedUser");
            sKeys.put(26, "imageDrawableId");
            sKeys.put(27, "imageUrl");
            sKeys.put(28, "inputBarEnable");
            sKeys.put(29, "inputText");
            sKeys.put(30, "levelDrawableId");
            sKeys.put(31, "master");
            sKeys.put(32, LoginReporterV2.Click.SIGNUP_KEY_MODE);
            sKeys.put(33, "msgContent");
            sKeys.put(34, "myCard");
            sKeys.put(35, "needShowEndContainer");
            sKeys.put(36, "newMsgText");
            sKeys.put(37, "newPlayerMsgText");
            sKeys.put(38, "nickTextColor");
            sKeys.put(39, "nickTvColor");
            sKeys.put(40, "nickname");
            sKeys.put(41, "onPositiveClick");
            sKeys.put(42, "ownerState");
            sKeys.put(43, "params");
            sKeys.put(44, "playerContainer");
            sKeys.put(45, "playerNickTextColor");
            sKeys.put(46, "positiveBtnText");
            sKeys.put(47, "quickMsgsVisible");
            sKeys.put(48, "roleTitle");
            sKeys.put(49, "roleType");
            sKeys.put(50, "roomMode");
            sKeys.put(51, "select");
            sKeys.put(52, "selectDataList");
            sKeys.put(53, "selectTagBackground");
            sKeys.put(54, "selectTagTextColor");
            sKeys.put(55, "selectTitle");
            sKeys.put(56, "sexDrawableId");
            sKeys.put(57, "shieldState");
            sKeys.put(58, "tagLineData");
            sKeys.put(59, "tagText");
            sKeys.put(60, "tagTitle");
            sKeys.put(61, "tagTitleColor");
            sKeys.put(62, "time");
            sKeys.put(63, "timeVisible");
            sKeys.put(64, ReportUtilKt.POS_TITLE);
            sKeys.put(65, "topContainerShow");
            sKeys.put(66, "unselectedTagBackground");
            sKeys.put(67, "unselectedTagTextColor");
            sKeys.put(68, "updateAttention");
            sKeys.put(69, "updateGuestAttention");
            sKeys.put(70, "value");
            sKeys.put(71, "viewModel");
            sKeys.put(72, "viewModelInner");
            sKeys.put(73, "vm");
            sKeys.put(74, "vvmAdapter");
            sKeys.put(75, "vvmAdapterInner");
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys = new HashMap<>(0);

        private InnerLayoutIdLookup() {
        }
    }
}