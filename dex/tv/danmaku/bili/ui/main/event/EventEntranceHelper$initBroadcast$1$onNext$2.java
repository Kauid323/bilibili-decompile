package tv.danmaku.bili.ui.main.event;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import com.airbnb.lottie.LottieComposition;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.homepage.util.LottieResourceManager;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.ui.main.event.EventEntranceHelper$initBroadcast$1$onNext$2;
import tv.danmaku.bili.ui.main.event.model.EventEntranceModel;
import tv.danmaku.bili.ui.main2.MainFragment;

/* compiled from: EventEntranceHelper.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
final class EventEntranceHelper$initBroadcast$1$onNext$2<T> implements Consumer {
    final /* synthetic */ Application $context;
    final /* synthetic */ EventEntranceModel $data;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventEntranceHelper$initBroadcast$1$onNext$2(EventEntranceModel eventEntranceModel, Application application) {
        this.$data = eventEntranceModel;
        this.$context = application;
    }

    public final void accept(String localpath) {
        EventEntranceModel eventEntranceModel = this.$data;
        if (eventEntranceModel != null) {
            eventEntranceModel.setIconLocalPath(localpath);
        }
        final Application application = this.$context;
        final EventEntranceModel eventEntranceModel2 = this.$data;
        Observable.create(new ObservableOnSubscribe() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper$initBroadcast$1$onNext$2$$ExternalSyntheticLambda0
            public final void subscribe(ObservableEmitter observableEmitter) {
                EventEntranceHelper$initBroadcast$1$onNext$2.accept$lambda$0(application, eventEntranceModel2, observableEmitter);
            }
        }).doOnNext(new AnonymousClass2(this.$context, this.$data)).subscribe(new Consumer() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper$initBroadcast$1$onNext$2.3
            public final void accept(Object it) {
            }
        }, new Consumer() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper$initBroadcast$1$onNext$2.4
            public final void accept(Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                BLog.i("EventEntranceHelper", it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accept$lambda$0(Application $context, EventEntranceModel $data, final ObservableEmitter it) {
        boolean checkAnim;
        EventEntranceModel.Online online;
        EventEntranceModel.Animate animate;
        EventEntranceModel.Online online2;
        EventEntranceModel.Animate animate2;
        Intrinsics.checkNotNullParameter(it, "it");
        if (EventEntranceHelper.isChanged) {
            checkAnim = EventEntranceHelper.INSTANCE.checkAnim($context);
            if (checkAnim) {
                String str = null;
                if (!TextUtils.isEmpty(($data == null || (online2 = $data.getOnline()) == null || (animate2 = online2.getAnimate()) == null) ? null : animate2.getSvg())) {
                    SVGAParser sVGAParser = new SVGAParser($context);
                    if ($data != null && (online = $data.getOnline()) != null && (animate = online.getAnimate()) != null) {
                        str = animate.getSvg();
                    }
                    sVGAParser.parseOnlyCache(new URL(str), new SVGAParser.ParseCompletion() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper$initBroadcast$1$onNext$2$1$1
                        public void onComplete(SVGAVideoEntity videoItem) {
                            Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                            BLog.i("EventEntranceHelper", "preload svge success");
                            it.onNext("");
                            it.onComplete();
                        }

                        public void onError() {
                            BLog.i("EventEntranceHelper", "preload svge error");
                            it.onNext("");
                            it.onComplete();
                        }

                        public void onCacheExist() {
                            BLog.i("EventEntranceHelper", "svge onCacheExist");
                            it.onNext("");
                            it.onComplete();
                        }
                    });
                    return;
                }
            }
        }
        it.onNext("");
        it.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventEntranceHelper.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* renamed from: tv.danmaku.bili.ui.main.event.EventEntranceHelper$initBroadcast$1$onNext$2$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass2<T> implements Consumer {
        final /* synthetic */ Application $context;
        final /* synthetic */ EventEntranceModel $data;

        AnonymousClass2(Application application, EventEntranceModel eventEntranceModel) {
            this.$context = application;
            this.$data = eventEntranceModel;
        }

        public final void accept(Object it) {
            final Application application = this.$context;
            final EventEntranceModel eventEntranceModel = this.$data;
            Observable observeOn = Observable.create(new ObservableOnSubscribe() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper$initBroadcast$1$onNext$2$2$$ExternalSyntheticLambda0
                public final void subscribe(ObservableEmitter observableEmitter) {
                    EventEntranceHelper$initBroadcast$1$onNext$2.AnonymousClass2.accept$lambda$0(application, eventEntranceModel, observableEmitter);
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            final EventEntranceModel eventEntranceModel2 = this.$data;
            observeOn.subscribe(new Consumer() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper.initBroadcast.1.onNext.2.2.2
                public final void accept(Object it2) {
                    boolean isMain;
                    EventEntranceModel.Online online;
                    EventEntranceModel eventEntranceModel3 = EventEntranceModel.this;
                    Long l = null;
                    if (eventEntranceModel3 != null) {
                        eventEntranceModel3.setLottieAnim(it2 instanceof LottieComposition ? (LottieComposition) it2 : null);
                    }
                    EventEntranceHelper eventEntranceHelper = EventEntranceHelper.INSTANCE;
                    EventEntranceHelper.entranceInfo = EventEntranceModel.this;
                    EventEntranceHelper eventEntranceHelper2 = EventEntranceHelper.INSTANCE;
                    EventEntranceModel eventEntranceModel4 = EventEntranceHelper.entranceInfo;
                    if (eventEntranceModel4 != null && (online = eventEntranceModel4.getOnline()) != null) {
                        l = online.getInterval();
                    }
                    EventEntranceHelper.mLastLoopInterval = l;
                    EventEntranceHelper.INSTANCE.saveCache();
                    isMain = EventEntranceHelper.INSTANCE.isMain();
                    if (isMain) {
                        Activity activity = BiliContext.topActivitiy();
                        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type tv.danmaku.bili.MainActivityV2");
                        MainActivityV2 activityV2 = (MainActivityV2) activity;
                        if (EventEntranceHelper.hasEntrance()) {
                            MainFragment mainFragment = activityV2.getMainFragment();
                            if (mainFragment != null) {
                                mainFragment.updateEntranceMenu(0);
                            }
                        } else {
                            MainFragment mainFragment2 = activityV2.getMainFragment();
                            if (mainFragment2 != null) {
                                mainFragment2.tryUpdateCurrentTopMenu(0);
                            }
                        }
                    } else {
                        EventEntranceHelper eventEntranceHelper3 = EventEntranceHelper.INSTANCE;
                        EventEntranceHelper.needUpdate = true;
                    }
                    EventEntranceHelper.INSTANCE.loop();
                }
            }, new Consumer() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper.initBroadcast.1.onNext.2.2.3
                public final void accept(Throwable it2) {
                    Intrinsics.checkNotNullParameter(it2, "it");
                    BLog.i("EventEntranceHelper", it2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void accept$lambda$0(Application $context, EventEntranceModel $data, ObservableEmitter it) {
            boolean checkAnim;
            EventEntranceModel.Online online;
            EventEntranceModel.Animate animate;
            EventEntranceModel.Online online2;
            EventEntranceModel.Animate animate2;
            Intrinsics.checkNotNullParameter(it, "it");
            LottieComposition lottieComposition = null;
            checkAnim = EventEntranceHelper.INSTANCE.checkAnim($context);
            if (checkAnim) {
                String str = null;
                if (!TextUtils.isEmpty(($data == null || (online2 = $data.getOnline()) == null || (animate2 = online2.getAnimate()) == null) ? null : animate2.getJson())) {
                    LottieResourceManager lottieResourceManager = LottieResourceManager.getInstance($context);
                    if ($data != null && (online = $data.getOnline()) != null && (animate = online.getAnimate()) != null) {
                        str = animate.getJson();
                    }
                    Intrinsics.checkNotNull(str);
                    lottieComposition = lottieResourceManager.loadLottieResource(str, "activity_entrance_menu_anim");
                }
            }
            it.onNext(lottieComposition == null ? new Object() : lottieComposition);
            it.onComplete();
        }
    }
}