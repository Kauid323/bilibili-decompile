package tv.danmaku.bili.ui.floatvideo;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.BiliImageLoaderHelper;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.live.LivePlayerOutService;
import com.bilibili.playerbizcommon.R;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.bili.ui.floatvideo.SectionedSeekBar;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

public class FloatWindowSizeActivity extends BaseToolbarActivity {
    public static final int DEFAULT_SIZE_SECTION = 1;
    public static final String PREF_KEY_FLOAT_WINDOW_SIZE = "float_window_size";
    public static final String[] WINDOW_SIZE = BiliContext.application().getResources().getStringArray(R.array.mini_player_window_size_array);
    public static final String[] WINDOW_SIZE_TEXT = BiliContext.application().getResources().getStringArray(com.bilibili.app.preferences.R.array.FloatWindowSize);
    private int[] mHeightSizes;
    private int mLastSection;
    private BiliGlobalPreferenceHelper mPreferencesHelper;
    private BiliImageView mPreviewView;
    private SectionedSeekBar mSeekBar;
    private int[] mWidthSizes;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, FloatWindowSizeActivity.class);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tv.danmaku.bili.R.layout.bili_app_activity_float_window_size);
        ensureToolbar();
        showBackButton();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(bili.resource.settings.R.string.settings_global_string_172);
        }
        this.mToolbar.setElevation(0.0f);
        this.mPreviewView = findViewById(tv.danmaku.bili.R.id.preview_view);
        this.mSeekBar = (SectionedSeekBar) findViewById(tv.danmaku.bili.R.id.seekbar);
        LivePlayerOutService service = getLivePlayerService();
        if (service != null) {
            service.stopFloatLiveWindow();
        }
        generateHeightAndWidth();
        initPreview();
        setUpSeekbar();
    }

    private void setUpSeekbar() {
        this.mSeekBar.setSelectedSection(this.mLastSection);
        this.mSeekBar.setOnSectionChangedListener(new SectionedSeekBar.SectionChangedListener() { // from class: tv.danmaku.bili.ui.floatvideo.FloatWindowSizeActivity.1
            @Override // tv.danmaku.bili.ui.floatvideo.SectionedSeekBar.SectionChangedListener
            public void onSectionedChanged(int section) {
                if (section == FloatWindowSizeActivity.this.mLastSection) {
                    return;
                }
                FloatWindowSizeActivity.this.mPreferencesHelper.setInteger(FloatWindowSizeActivity.PREF_KEY_FLOAT_WINDOW_SIZE, section);
                LivePlayerOutService service = FloatWindowSizeActivity.this.getLivePlayerService();
                if (service != null) {
                    service.updateWindowSize();
                }
                FloatWindowSizeActivity.this.createAnimation(section).start();
                FloatWindowSizeActivity.this.mLastSection = section;
                Map<String, String> params = new HashMap<>(2);
                params.put("type", String.valueOf(section + 1));
                Neurons.reportClick(true, "player.player.smallpalyer-size.0.click", params);
                Neurons.reportClick(true, "main.play-setting.miniplayer-size.0.click", params);
            }
        });
        this.mSeekBar.setAdapter(new SectionedSeekBar.Adapter() { // from class: tv.danmaku.bili.ui.floatvideo.FloatWindowSizeActivity.2
            @Override // tv.danmaku.bili.ui.floatvideo.SectionedSeekBar.Adapter
            public String getText(int position) {
                return String.valueOf(FloatWindowSizeActivity.WINDOW_SIZE_TEXT[position]);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LivePlayerOutService getLivePlayerService() {
        return (LivePlayerOutService) BLRouter.INSTANCE.get(LivePlayerOutService.class, MineReporter.MINE_ICON_TYPE_DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatorSet createAnimation(int section) {
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator transWidth = ValueAnimator.ofInt(this.mWidthSizes[this.mLastSection], this.mWidthSizes[section]);
        ValueAnimator transHeight = ValueAnimator.ofInt(this.mHeightSizes[this.mLastSection], this.mHeightSizes[section]);
        transWidth.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.floatvideo.FloatWindowSizeActivity.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                int width = ((Integer) animation.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = FloatWindowSizeActivity.this.mPreviewView.getLayoutParams();
                layoutParams.width = width;
                FloatWindowSizeActivity.this.mPreviewView.setLayoutParams(layoutParams);
            }
        });
        transHeight.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.floatvideo.FloatWindowSizeActivity.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                int height = ((Integer) animation.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = FloatWindowSizeActivity.this.mPreviewView.getLayoutParams();
                layoutParams.height = height;
                FloatWindowSizeActivity.this.mPreviewView.setLayoutParams(layoutParams);
            }
        });
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(300L);
        animatorSet.play(transHeight).with(transWidth);
        animatorSet.start();
        return animatorSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initPreview() {
        this.mPreferencesHelper = BiliGlobalPreferenceHelper.getInstance(this);
        this.mLastSection = this.mPreferencesHelper.optInteger(PREF_KEY_FLOAT_WINDOW_SIZE, 1);
        this.mPreviewView.post(new Runnable() { // from class: tv.danmaku.bili.ui.floatvideo.FloatWindowSizeActivity.5
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams = FloatWindowSizeActivity.this.mPreviewView.getLayoutParams();
                layoutParams.height = FloatWindowSizeActivity.this.mHeightSizes[FloatWindowSizeActivity.this.mLastSection];
                layoutParams.width = FloatWindowSizeActivity.this.mWidthSizes[FloatWindowSizeActivity.this.mLastSection];
                FloatWindowSizeActivity.this.mPreviewView.setLayoutParams(layoutParams);
                String url = BiliImageLoaderHelper.resourceToUri(tv.danmaku.bili.R.drawable.ic_preview_float_window);
                BiliImageLoader.INSTANCE.with(FloatWindowSizeActivity.this).url(url).into(FloatWindowSizeActivity.this.mPreviewView);
            }
        });
    }

    private void generateHeightAndWidth() {
        this.mWidthSizes = new int[WINDOW_SIZE.length];
        this.mHeightSizes = new int[WINDOW_SIZE.length];
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        for (int i = 0; i < WINDOW_SIZE.length; i++) {
            this.mWidthSizes[i] = (int) (displayMetrics.widthPixels * Float.valueOf(WINDOW_SIZE[i]).floatValue());
            this.mHeightSizes[i] = ((int) ((this.mWidthSizes[i] / 16.0d) * 9.0d)) + 1;
        }
    }
}