package tv.danmaku.bili.ui.main2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.app.comm.list.common.api.IDefaultKeywordResult;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.MapByteBuffer;
import com.bilibili.lib.homepage.startdust.INavigationUserInfoSolution;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BuildConfig;
import tv.danmaku.bili.rating.AbsMarket;
import tv.danmaku.bili.rating.DirectRatingGuide;
import tv.danmaku.bili.rating.MarketHelper;
import tv.danmaku.bili.rating.RatingDialogDirectGuide;
import tv.danmaku.bili.rating.RatingDialogRating;
import tv.danmaku.bili.rating.RatingEventRegisterKt;
import tv.danmaku.bili.rating.RatingThenGuide;
import tv.danmaku.bili.report.startup.v2.BootTagHolder;
import tv.danmaku.bili.report.startup.v2.BootTracer;
import tv.danmaku.bili.report.startup.v2.StartShowRecorder;
import tv.danmaku.bili.report.startup.v3.BootTracerV2;
import tv.danmaku.bili.ui.main2.MainFragment;
import tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment;
import tv.danmaku.bili.ui.main2.main.ToolbarNavigationBadgeSolution;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;
import tv.danmaku.bili.ui.main2.resource.PrimaryPage;

public class MainFragment extends BaseMainFrameFragment implements INavigationBarWatcher {
    @Override // tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            return;
        }
        BootTracerV2.INSTANCE.recordTime(BootTracerV2.ENTRY_FRAGMENT_CREATED_START);
        BootTracer.endSession(BootTagHolder.TAG_MAIN_FRAME_INIT);
        BootTracer.setSession(BootTagHolder.TAG_START_SHOW, StartShowRecorder.INSTANCE.getStartTime(), StartShowRecorder.getDuration());
        BootTracer.setSession(BootTagHolder.TAG_REAL_START_SHOW, StartShowRecorder.INSTANCE.getStartTime(), StartShowRecorder.getDuration() - StartShowRecorder.getBrandSplashDuration());
        Context context = getContext();
        if (context != null) {
            RatingEventRegisterKt.registerRatingEvent(getViewLifecycleOwner(), new AnonymousClass1(context));
        }
    }

    /* renamed from: tv.danmaku.bili.ui.main2.MainFragment$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    class AnonymousClass1 implements Function3<DirectRatingGuide, RatingThenGuide, String, Unit> {
        final /* synthetic */ Context val$context;

        AnonymousClass1(Context context) {
            this.val$context = context;
        }

        public Unit invoke(final DirectRatingGuide directRatingGuide, final RatingThenGuide ratingThenGuide, final String count) {
            final Context context = this.val$context;
            MainDialogManager.IDialogInterface block = new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.main2.MainFragment$1$$ExternalSyntheticLambda4
                public final void onShow() {
                    MainFragment.AnonymousClass1.lambda$invoke$6(DirectRatingGuide.this, context, count, ratingThenGuide);
                }
            };
            MainDialogManager.DialogManagerInfo dialogInfo = new MainDialogManager.DialogManagerInfo("main_rating", block, 2120);
            dialogInfo.setRepeat(true);
            MainDialogManager.addDialog(dialogInfo, this.val$context);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$invoke$6(DirectRatingGuide directRatingGuide, final Context context, String count, RatingThenGuide ratingThenGuide) {
            if (directRatingGuide != null) {
                BLog.i("RatingGuide", "显示直接引导弹窗directRatingGuide  " + directRatingGuide);
                RatingDialogDirectGuide dialog = new RatingDialogDirectGuide(context, directRatingGuide, count, 0, new Function0() { // from class: tv.danmaku.bili.ui.main2.MainFragment$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return MainFragment.AnonymousClass1.lambda$invoke$1(context);
                    }
                });
                dialog.show();
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tv.danmaku.bili.ui.main2.MainFragment$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        MainDialogManager.showNextDialog("main_rating", false);
                    }
                });
            } else if (ratingThenGuide != null) {
                BLog.i("RatingGuide", "显示打分弹窗ratingThenGuide  " + ratingThenGuide);
                Map<String, String> extra = new HashMap<>(2);
                extra.put("appear_times", count);
                extra.put("type", "1");
                Neurons.reportExposure(false, "main.score-popup.0.0.show", extra);
                RatingDialogRating dialog2 = new RatingDialogRating(context, ratingThenGuide, count, 0, new Function0() { // from class: tv.danmaku.bili.ui.main2.MainFragment$1$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        return MainFragment.AnonymousClass1.lambda$invoke$4(context);
                    }
                });
                dialog2.show();
                dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tv.danmaku.bili.ui.main2.MainFragment$1$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        MainDialogManager.showNextDialog("main_rating", false);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$invoke$1(Context context) {
            AbsMarket market = MarketHelper.INSTANCE.getSystemMarket();
            MarketHelper.INSTANCE.launchAppDetail(context, BuildConfig.LIBRARY_PACKAGE_NAME, market, new Function1() { // from class: tv.danmaku.bili.ui.main2.MainFragment$1$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    return MainFragment.AnonymousClass1.lambda$invoke$0((Intent) obj);
                }
            });
            BLKV.getKvs(BiliContext.application(), RatingEventRegisterKt.RATING_DIALOG_COUNT_FILE_NAME, false, MapByteBuffer.Companion.getPAGE_SIZE()).putInt(RatingEventRegisterKt.RATING_DIALOG_COUNT_KEY, 5);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$invoke$0(Intent intent) {
            intent.setFlags(268435456);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$invoke$4(Context context) {
            AbsMarket market = MarketHelper.INSTANCE.getSystemMarket();
            MarketHelper.INSTANCE.launchAppDetail(context, BuildConfig.LIBRARY_PACKAGE_NAME, market, new Function1() { // from class: tv.danmaku.bili.ui.main2.MainFragment$1$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    return MainFragment.AnonymousClass1.lambda$invoke$3((Intent) obj);
                }
            });
            BLKV.getKvs(BiliContext.application(), RatingEventRegisterKt.RATING_DIALOG_COUNT_FILE_NAME, false, MapByteBuffer.Companion.getPAGE_SIZE()).putInt(RatingEventRegisterKt.RATING_DIALOG_COUNT_KEY, 5);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$invoke$3(Intent intent) {
            intent.setFlags(268435456);
            return null;
        }
    }

    @Override // tv.danmaku.bili.ui.main2.INavigationBarWatcher
    public void updateSearchText(IDefaultKeywordResult word) {
        updateExpandSearchWord(word);
    }

    @Override // tv.danmaku.bili.ui.main2.INavigationBarWatcher
    public void updateZeroCardDefaultWord(IDefaultKeywordResult word) {
        this.mZeroCardSearchDefaultWord = word;
    }

    @Override // tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment
    protected BaseMainFrameFragment.IBottomTabDataProvider onCreateBottomDataProvider() {
        return new BaseMainFrameFragment.IBottomTabDataProvider() { // from class: tv.danmaku.bili.ui.main2.MainFragment.2
            @Override // tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.IBottomTabDataProvider
            public List<BaseMainFrameFragment.NavigationInfo> getNavigationInfo() {
                FragmentActivity activity = MainFragment.this.getActivity();
                List<PrimaryPage> pages = MainResourceManager.getInstance().getPrimaryPages();
                List<BaseMainFrameFragment.NavigationInfo> infos = new ArrayList<>();
                for (PrimaryPage page : pages) {
                    BaseMainFrameFragment.NavigationInfo nav = new BaseMainFrameFragment.NavigationInfo(activity, page);
                    if (nav.checkParams()) {
                        infos.add(nav);
                    }
                }
                if (infos.size() == 0) {
                    List<PrimaryPage> defaultPages = MainResourceManager.getInstance().getDefaultPrimaryPages();
                    for (PrimaryPage page2 : defaultPages) {
                        BaseMainFrameFragment.NavigationInfo nav2 = new BaseMainFrameFragment.NavigationInfo(activity, page2);
                        if (nav2.checkParams()) {
                            infos.add(nav2);
                        }
                    }
                }
                return infos;
            }

            @Override // tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment.IBottomTabDataProvider
            public boolean isNavigationDataChange() {
                return MainResourceManager.getInstance().isBottomChange();
            }
        };
    }

    @Override // tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment
    protected INavigationUserInfoSolution onCreateNavigationBadgeSolution() {
        return new ToolbarNavigationBadgeSolution(this);
    }

    @Override // tv.danmaku.bili.ui.main2.MainPagerFragmentV2
    protected boolean enableNavigationIcon() {
        return false;
    }

    @Override // tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override // tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment, tv.danmaku.bili.ui.main2.MainPagerFragmentV2
    public Toolbar getBar() {
        return super.getBar();
    }

    @Override // tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment
    public void dismissHomeFloatView() {
        super.dismissHomeFloatView();
    }

    @Override // tv.danmaku.bili.ui.main2.basic.BaseMainFrameFragment
    public boolean isHomeFloatViewShowing() {
        return super.isHomeFloatViewShowing();
    }
}