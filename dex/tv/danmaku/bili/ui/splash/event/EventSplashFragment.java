package tv.danmaku.bili.ui.splash.event;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.fastjson.JSON;
import com.bilibili.base.viewbinding.ViewBindingProperty;
import com.bilibili.base.viewbinding.full.CreateMethod;
import com.bilibili.base.viewbinding.full.ReflectionFragmentViewBindings;
import com.bilibili.base.viewbinding.internal.UtilsKt;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.ad.page.ISplash;
import tv.danmaku.bili.ui.splash.databinding.SplashFragmentEventSplashBinding;
import tv.danmaku.bili.ui.splash.utils.SplashConfigKt;
import tv.danmaku.bili.ui.splash.utils.UiUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: EventSplashFragment.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u0014H\u0002J\u001a\u0010+\u001a\u00020\u001e2\u0010\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010.\u0018\u00010-H\u0002J\u0010\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020.H\u0002J\u0010\u00101\u001a\u00020\u001e2\u0006\u00100\u001a\u00020.H\u0002J(\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u0002052\u0006\u00108\u001a\u000205H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u00100\u001a\u00020.H\u0002J\u001a\u0010:\u001a\u00020\u001e2\u0010\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010<\u0018\u00010-H\u0002J\b\u0010=\u001a\u00020\u001eH\u0002J\b\u0010>\u001a\u00020\u001aH\u0002J$\u0010?\u001a\u00020\u001e2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020<0A2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020<0AH\u0002J\u0010\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020<H\u0002J\b\u0010E\u001a\u00020\u001eH\u0002J\b\u0010F\u001a\u00020\u001eH\u0002J\u0010\u0010G\u001a\u00020\u001e2\u0006\u0010H\u001a\u000205H\u0016J\u0018\u0010I\u001a\u00020\u001e2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u001cH\u0016J\b\u0010M\u001a\u00020\u001aH\u0016J$\u0010N\u001a\u00020\u001e2\u0006\u0010O\u001a\u0002052\b\b\u0002\u0010P\u001a\u00020\u001c2\b\b\u0002\u0010Q\u001a\u00020\u001cH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Ltv/danmaku/bili/ui/splash/event/EventSplashFragment;", "Lcom/bilibili/lib/ui/BaseFragment;", "Ltv/danmaku/bili/ui/splash/event/ElementActionCallback;", "<init>", "()V", "mBinding", "Ltv/danmaku/bili/ui/splash/databinding/SplashFragmentEventSplashBinding;", "getMBinding", "()Ltv/danmaku/bili/ui/splash/databinding/SplashFragmentEventSplashBinding;", "mBinding$delegate", "Lcom/bilibili/base/viewbinding/ViewBindingProperty;", "mTextureView", "Landroid/view/TextureView;", "mSurface", "Landroid/view/Surface;", "mPlayer", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "mElementFactory", "Ltv/danmaku/bili/ui/splash/event/ElementFactory;", "mSplashData", "Ltv/danmaku/bili/ui/splash/event/EventSplashData;", "mCountDownJob", "Lkotlinx/coroutines/Job;", "mDelayElementJob", "mTimeToVideoPosition", "Lkotlin/Pair;", "", "isActionTrigger", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "display", "eventSplash", "displayBackgroundResource", "resources", "", "Ltv/danmaku/bili/ui/splash/event/Resource;", "displayImage", "resource", "displayVideo", "generateVideoLayoutParams", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "viewWidth", "", "viewHeight", "videoWidth", "videoHeight", "displayLogo", "displayElement", "elements", "Ltv/danmaku/bili/ui/splash/event/Element;", "clearDelayElementTask", "getElementRelativePosition", "displayDelayElement", "willAddedElement", "", "willRemovedElements", "removeElementView", "element", "removeOldElement", "exit", "seekTo", "time", "onActionTrigger", "action", "Ltv/danmaku/bili/ui/splash/event/Action;", "jumped", "getVideoCurrentPosition", "startCountDown", "duration", "showCountDown", "postExec", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class EventSplashFragment extends BaseFragment implements ElementActionCallback {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(EventSplashFragment.class, "mBinding", "getMBinding()Ltv/danmaku/bili/ui/splash/databinding/SplashFragmentEventSplashBinding;", 0))};
    public static final int $stable = 8;
    private boolean isActionTrigger;
    private final ViewBindingProperty mBinding$delegate;
    private Job mCountDownJob;
    private Job mDelayElementJob;
    private ElementFactory mElementFactory;
    private IjkMediaPlayer mPlayer;
    private EventSplashData mSplashData;
    private Surface mSurface;
    private TextureView mTextureView;
    private Pair<Long, Long> mTimeToVideoPosition;

    public EventSplashFragment() {
        Fragment $this$viewBinding_u24default$iv = (Fragment) this;
        CreateMethod createMethod$iv = CreateMethod.INFLATE;
        Function1 onViewDestroyed$iv = UtilsKt.emptyVbCallback();
        this.mBinding$delegate = ReflectionFragmentViewBindings.viewBindingFragment($this$viewBinding_u24default$iv, SplashFragmentEventSplashBinding.class, createMethod$iv, onViewDestroyed$iv);
        this.mTimeToVideoPosition = new Pair<>(0L, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SplashFragmentEventSplashBinding getMBinding() {
        return (SplashFragmentEventSplashBinding) this.mBinding$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UiUtils.INSTANCE.immersive((Activity) getActivity());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view2 = getMBinding().root;
        Intrinsics.checkNotNullExpressionValue(view2, "root");
        return view2;
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onViewCreated(view2, savedInstanceState);
        view2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.event.EventSplashFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                EventSplashFragment.onViewCreated$lambda$0(view3);
            }
        });
        Bundle arguments = getArguments();
        String dataStr = arguments != null ? arguments.getString(EventSplashFragmentKt.KEY_EVENT_SPLASH_DATA) : null;
        try {
            final EventSplashData splashData = (EventSplashData) JSON.parseObject(dataStr, EventSplashData.class);
            BLog.i("[EventSplash]EventSplashFragment", "onViewCreated :" + dataStr);
            this.mSplashData = splashData;
            View view3 = getMBinding().root;
            Intrinsics.checkNotNullExpressionValue(view3, "root");
            final View $this$doOnPreDraw$iv = view3;
            OneShotPreDrawListener.add($this$doOnPreDraw$iv, new Runnable() { // from class: tv.danmaku.bili.ui.splash.event.EventSplashFragment$onViewCreated$$inlined$doOnPreDraw$1
                @Override // java.lang.Runnable
                public final void run() {
                    SplashFragmentEventSplashBinding mBinding;
                    SplashFragmentEventSplashBinding mBinding2;
                    SplashFragmentEventSplashBinding mBinding3;
                    View view4 = $this$doOnPreDraw$iv;
                    mBinding = this.getMBinding();
                    if (ViewCompat.isAttachedToWindow(mBinding.root) && this.isAdded()) {
                        mBinding2 = this.getMBinding();
                        if (mBinding2.root.getWidth() > 0) {
                            EventSplashFragment eventSplashFragment = this;
                            Intrinsics.checkNotNull(splashData);
                            EventSplashData eventSplashData = splashData;
                            mBinding3 = this.getMBinding();
                            ConstraintLayout constraintLayout = mBinding3.root;
                            Intrinsics.checkNotNullExpressionValue(constraintLayout, "root");
                            eventSplashFragment.mElementFactory = new ElementFactory(eventSplashData, constraintLayout, this);
                            EventSplashFragment eventSplashFragment2 = this;
                            Intrinsics.checkNotNull(splashData);
                            eventSplashFragment2.display(splashData);
                            return;
                        }
                    }
                    ReporterKt.reportEventSplashIllegalWidth(this);
                }
            });
            EventSplashStorage eventSplashStorage = EventSplashStorage.INSTANCE;
            Intrinsics.checkNotNull(splashData);
            eventSplashStorage.increaseEventSplashShowCount(splashData);
            ReporterKt.reportEventSplashShow(splashData);
        } catch (Exception e) {
            BLog.e("[EventSplash]EventSplashFragment", "parse splash error", e);
            exit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(View it) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void display(EventSplashData eventSplash) {
        displayBackgroundResource(eventSplash.getPhoneResource());
        displayElement(eventSplash.getElements());
        if (1 == eventSplash.getShowSkip()) {
            getMBinding().skip.setVisibility(0);
            getMBinding().skip.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.event.EventSplashFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    EventSplashFragment.display$lambda$0(EventSplashFragment.this, view2);
                }
            });
        } else {
            getMBinding().skip.setVisibility(8);
        }
        startCountDown$default(this, eventSplash.getDuration(), 1 == eventSplash.getShowCountdown(), false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void display$lambda$0(EventSplashFragment this$0, View it) {
        BLog.i("[EventSplash]EventSplashFragment", "on skip click");
        ReporterKt.reportSkipClick(this$0.mSplashData, this$0.isActionTrigger);
        this$0.exit();
    }

    private final void displayBackgroundResource(List<Resource> list) {
        Iterable resources = EnhancedUnmodifiabilityKt.unmodifiable(list);
        List list2 = (Collection) resources;
        boolean z = false;
        if (list2 == null || list2.isEmpty()) {
            exit();
            return;
        }
        Iterable $this$forEach$iv = resources;
        for (Object element$iv : $this$forEach$iv) {
            Resource res = (Resource) element$iv;
            Integer valueOf = res != null ? Integer.valueOf(res.getResourceType()) : null;
            if (valueOf != null && valueOf.intValue() == 1) {
                displayVideo(res);
            } else if (valueOf != null && valueOf.intValue() == 0) {
                displayImage(res);
            } else if (valueOf != null && valueOf.intValue() == 3) {
                displayLogo(res);
            }
        }
        EventSplashData eventSplashData = this.mSplashData;
        if (eventSplashData != null && true == eventSplashData.isLocalBirthData()) {
            z = true;
        }
        if (z) {
            getMBinding().logo.setImageResource(R.drawable.ic_logo_default);
        }
    }

    private final void displayImage(Resource resource) {
        Bitmap bitmap = BitmapFactory.decodeFile(resource.getLocalResourcePath());
        if (resource.isLocalBirthdayRes()) {
            getMBinding().backgroundImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        getMBinding().backgroundImage.setImageBitmap(bitmap);
    }

    private final void displayVideo(Resource resource) {
        if (getContext() == null || this.mTextureView != null) {
            return;
        }
        this.mTextureView = new TextureView(requireContext());
        TextureView textureView = this.mTextureView;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(new EventSplashFragment$displayVideo$1(this, resource));
        }
        int id = ViewCompat.generateViewId();
        TextureView textureView2 = this.mTextureView;
        if (textureView2 != null) {
            textureView2.setId(id);
        }
        ViewGroup.LayoutParams generateVideoLayoutParams = generateVideoLayoutParams(getMBinding().root.getWidth(), getMBinding().root.getHeight(), resource.getVideoWidth(), resource.getVideoHeight());
        TextureView textureView3 = this.mTextureView;
        if (textureView3 != null) {
            textureView3.setLayoutParams(generateVideoLayoutParams);
        }
        ElementFactory elementFactory = this.mElementFactory;
        if (elementFactory != null) {
            elementFactory.setVideoViewWidth(((ConstraintLayout.LayoutParams) generateVideoLayoutParams).width);
        }
        ElementFactory elementFactory2 = this.mElementFactory;
        if (elementFactory2 != null) {
            elementFactory2.setVideoViewHeight(((ConstraintLayout.LayoutParams) generateVideoLayoutParams).height);
        }
        getMBinding().root.addView(this.mTextureView, 0);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(getMBinding().root);
        constraintSet.connect(id, 6, 0, 6);
        constraintSet.connect(id, 3, 0, 3);
        constraintSet.connect(id, 7, 0, 7);
        constraintSet.connect(id, 4, 0, 4);
        constraintSet.applyTo(getMBinding().root);
    }

    private final ConstraintLayout.LayoutParams generateVideoLayoutParams(int viewWidth, int viewHeight, int videoWidth, int videoHeight) {
        float videoRatio = videoWidth / videoHeight;
        float viewRatio = viewWidth / viewHeight;
        int expectWidth = viewWidth;
        int expectHeight = viewHeight;
        if (videoRatio > viewRatio) {
            expectWidth = (int) (viewWidth * (videoRatio / viewRatio));
        } else {
            expectHeight = (int) (viewHeight * (viewRatio / videoRatio));
        }
        return new ConstraintLayout.LayoutParams(expectWidth, expectHeight);
    }

    private final void displayLogo(Resource resource) {
        Bitmap bitmap = BitmapFactory.decodeFile(resource.getLocalResourcePath());
        getMBinding().logo.setImageBitmap(bitmap);
    }

    private final void displayElement(List<Element> list) {
        List elements = EnhancedUnmodifiabilityKt.unmodifiable(list);
        List list2 = elements;
        if (list2 == null || list2.isEmpty()) {
            BLog.i("[EventSplash]EventSplashFragment", "element is null or empty");
            return;
        }
        List willDelayAddedElements = new ArrayList();
        List willDelayRemovedElements = new ArrayList();
        List immediateAddElements = new ArrayList();
        final long currentPosition = getElementRelativePosition();
        Sequence $this$forEach$iv = SequencesKt.filterNot(SequencesKt.filterNotNull(CollectionsKt.asSequence(elements)), new Function1() { // from class: tv.danmaku.bili.ui.splash.event.EventSplashFragment$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean displayElement$lambda$0;
                displayElement$lambda$0 = EventSplashFragment.displayElement$lambda$0(currentPosition, (Element) obj);
                return Boolean.valueOf(displayElement$lambda$0);
            }
        });
        for (Object element$iv : $this$forEach$iv) {
            Element it = (Element) element$iv;
            if (it.getShowDuration() > 0) {
                willDelayAddedElements.add(it);
            } else if (it.getHideDuration() > 0) {
                willDelayRemovedElements.add(it);
                immediateAddElements.add(it);
            } else {
                immediateAddElements.add(it);
            }
        }
        ElementFactory elementFactory = this.mElementFactory;
        if (elementFactory != null) {
            elementFactory.generateAndDisplayElements(immediateAddElements);
        }
        displayDelayElement(willDelayAddedElements, willDelayRemovedElements);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean displayElement$lambda$0(long $currentPosition, Element it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getHideDuration() != 0 && it.getHideDuration() <= $currentPosition;
    }

    private final void clearDelayElementTask() {
        Job job = this.mDelayElementJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getElementRelativePosition() {
        if (SplashConfigKt.getUseVideoRelativePosition()) {
            IjkMediaPlayer ijkMediaPlayer = this.mPlayer;
            if (ijkMediaPlayer != null) {
                return ijkMediaPlayer.getRealCurrentPosition();
            }
            return -1L;
        }
        return (System.currentTimeMillis() - ((Number) this.mTimeToVideoPosition.getFirst()).longValue()) + ((Number) this.mTimeToVideoPosition.getSecond()).longValue();
    }

    private final void displayDelayElement(List<Element> list, List<Element> list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.mDelayElementJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new EventSplashFragment$displayDelayElement$1(list, list2, this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeElementView(Element element) {
        ViewGroup viewGroup = getMBinding().root;
        Intrinsics.checkNotNullExpressionValue(viewGroup, "root");
        Sequence $this$forEach$iv = ViewGroupKt.getChildren(viewGroup);
        for (Object element$iv : $this$forEach$iv) {
            View child = (View) element$iv;
            Object tag = child.getTag(R.id.tag_splash_element_id);
            if (tag != null && Intrinsics.areEqual(tag, Long.valueOf(element.getId()))) {
                getMBinding().root.removeView(child);
                return true;
            }
        }
        return false;
    }

    private final void removeOldElement() {
        clearDelayElementTask();
        ViewGroup viewGroup = getMBinding().root;
        Intrinsics.checkNotNullExpressionValue(viewGroup, "root");
        Sequence $this$forEach$iv = SequencesKt.filter(ViewGroupKt.getChildren(viewGroup), new Function1() { // from class: tv.danmaku.bili.ui.splash.event.EventSplashFragment$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean removeOldElement$lambda$0;
                removeOldElement$lambda$0 = EventSplashFragment.removeOldElement$lambda$0((View) obj);
                return Boolean.valueOf(removeOldElement$lambda$0);
            }
        });
        for (Object element$iv : $this$forEach$iv) {
            View it = (View) element$iv;
            getMBinding().root.removeView(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeOldElement$lambda$0(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getTag(R.id.tag_splash_element_id) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void exit() {
        BLog.i("[EventSplash]EventSplashFragment", "exit, exit eventSplash");
        ISplash.SplashHost activity = getActivity();
        ISplash.SplashHost splashHost = activity instanceof ISplash.SplashHost ? activity : null;
        if (splashHost != null) {
            splashHost.exitBrandSplash();
        }
    }

    @Override // tv.danmaku.bili.ui.splash.event.ElementActionCallback
    public void seekTo(int time) {
        BLog.i("[EventSplash]EventSplashFragment", "seek to :" + time);
        IjkMediaPlayer ijkMediaPlayer = this.mPlayer;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.seekTo(time, true);
        }
        this.mTimeToVideoPosition = TuplesKt.to(Long.valueOf(System.currentTimeMillis()), Long.valueOf(time));
    }

    @Override // tv.danmaku.bili.ui.splash.event.ElementActionCallback
    public void onActionTrigger(Action action, boolean jumped) {
        Intrinsics.checkNotNullParameter(action, "action");
        BLog.i("[EventSplash]EventSplashFragment", "on action trigger jumped:" + jumped + " action:" + action);
        this.isActionTrigger = true;
        List elements = action.getElements();
        removeOldElement();
        displayElement(elements);
        startCountDown(action.getDuration(), 1 == action.getShowCountdown(), false);
        if (jumped) {
            ReporterKt.reportJumpActionClick(this.mSplashData, action);
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new EventSplashFragment$onActionTrigger$1(this, null), 3, (Object) null);
            return;
        }
        ReporterKt.reportInteractAction(this.mSplashData);
    }

    @Override // tv.danmaku.bili.ui.splash.event.ElementActionCallback
    public long getVideoCurrentPosition() {
        IjkMediaPlayer ijkMediaPlayer = this.mPlayer;
        if (ijkMediaPlayer != null) {
            return ijkMediaPlayer.getRealCurrentPosition();
        }
        return 0L;
    }

    static /* synthetic */ void startCountDown$default(EventSplashFragment eventSplashFragment, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        eventSplashFragment.startCountDown(i, z, z2);
    }

    private final void startCountDown(final int duration, final boolean showCountDown, boolean postExec) {
        BLog.i("[EventSplash]EventSplashFragment", "startCountDown duration:" + duration + " showCountDown:" + showCountDown + " postExec:" + postExec);
        Context ctx = getContext();
        if (ctx == null) {
            return;
        }
        if (duration <= 0) {
            exit();
            return;
        }
        boolean z = false;
        if (showCountDown && getMBinding().skip.getVisibility() != 0) {
            getMBinding().skip.setVisibility(0);
        } else if (!showCountDown) {
            EventSplashData eventSplashData = this.mSplashData;
            if (eventSplashData != null && 1 == eventSplashData.getShowSkip()) {
                z = true;
            }
            if (z) {
                getMBinding().skip.setText(ctx.getResources().getString(bili.resource.common.R.string.common_global_string_144));
            }
        }
        Job job = this.mCountDownJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Runnable runnable = new Runnable() { // from class: tv.danmaku.bili.ui.splash.event.EventSplashFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                EventSplashFragment.startCountDown$lambda$0(EventSplashFragment.this, duration, showCountDown);
            }
        };
        if (postExec) {
            getMBinding().root.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startCountDown$lambda$0(EventSplashFragment this$0, int $duration, boolean $showCountDown) {
        if (this$0.getView() == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = this$0.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this$0.mCountDownJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new EventSplashFragment$startCountDown$runnable$1$1($duration, this$0, $showCountDown, null), 3, (Object) null);
    }
}