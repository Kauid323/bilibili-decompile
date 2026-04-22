package tv.danmaku.bili.ui.main.event;

import android.app.Application;
import android.text.TextUtils;
import com.airbnb.lottie.LottieComposition;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main.event.EventEntranceHelper$checkActivityEntrance$1$onDataSuccess$1$2;
import tv.danmaku.bili.ui.main.event.model.EventEntranceModel;

/* compiled from: EventEntranceHelper.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
final class EventEntranceHelper$checkActivityEntrance$1$onDataSuccess$1$2<T> implements Consumer {
    final /* synthetic */ Application $context;
    final /* synthetic */ EventEntranceModel $data;
    final /* synthetic */ Function0<Unit> $listener;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventEntranceHelper$checkActivityEntrance$1$onDataSuccess$1$2(EventEntranceModel eventEntranceModel, Application application, Function0<Unit> function0) {
        this.$data = eventEntranceModel;
        this.$context = application;
        this.$listener = function0;
    }

    public final void accept(String localPath) {
        this.$data.setIconLocalPath(localPath);
        final Application application = this.$context;
        final EventEntranceModel eventEntranceModel = this.$data;
        Observable.create(new ObservableOnSubscribe() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper$checkActivityEntrance$1$onDataSuccess$1$2$$ExternalSyntheticLambda0
            public final void subscribe(ObservableEmitter observableEmitter) {
                EventEntranceHelper$checkActivityEntrance$1$onDataSuccess$1$2.accept$lambda$0(application, eventEntranceModel, observableEmitter);
            }
        }).subscribe(new AnonymousClass2(this.$context, this.$data, this.$listener), new Consumer() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper$checkActivityEntrance$1$onDataSuccess$1$2.3
            public final void accept(Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                BLog.i("EventEntranceHelper", it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accept$lambda$0(Application $context, EventEntranceModel $data, final ObservableEmitter it) {
        boolean checkAnim;
        EventEntranceModel.Animate animate;
        EventEntranceModel.Animate animate2;
        Intrinsics.checkNotNullParameter(it, "it");
        if (EventEntranceHelper.isChanged) {
            checkAnim = EventEntranceHelper.INSTANCE.checkAnim($context);
            if (checkAnim) {
                EventEntranceModel.Online online = $data.getOnline();
                String str = null;
                if (!TextUtils.isEmpty((online == null || (animate2 = online.getAnimate()) == null) ? null : animate2.getSvg())) {
                    SVGAParser sVGAParser = new SVGAParser($context);
                    EventEntranceModel.Online online2 = $data.getOnline();
                    if (online2 != null && (animate = online2.getAnimate()) != null) {
                        str = animate.getSvg();
                    }
                    sVGAParser.parseOnlyCache(new URL(str), new SVGAParser.ParseCompletion() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper$checkActivityEntrance$1$onDataSuccess$1$2$1$1
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
    /* renamed from: tv.danmaku.bili.ui.main.event.EventEntranceHelper$checkActivityEntrance$1$onDataSuccess$1$2$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass2<T> implements Consumer {
        final /* synthetic */ Application $context;
        final /* synthetic */ EventEntranceModel $data;
        final /* synthetic */ Function0<Unit> $listener;

        AnonymousClass2(Application application, EventEntranceModel eventEntranceModel, Function0<Unit> function0) {
            this.$context = application;
            this.$data = eventEntranceModel;
            this.$listener = function0;
        }

        public final void accept(String it) {
            final Application application = this.$context;
            final EventEntranceModel eventEntranceModel = this.$data;
            Observable observeOn = Observable.create(new ObservableOnSubscribe() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper$checkActivityEntrance$1$onDataSuccess$1$2$2$$ExternalSyntheticLambda0
                public final void subscribe(ObservableEmitter observableEmitter) {
                    EventEntranceHelper$checkActivityEntrance$1$onDataSuccess$1$2.AnonymousClass2.accept$lambda$0(application, eventEntranceModel, observableEmitter);
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            final EventEntranceModel eventEntranceModel2 = this.$data;
            final Function0<Unit> function0 = this.$listener;
            observeOn.subscribe(new Consumer() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper.checkActivityEntrance.1.onDataSuccess.1.2.2.2
                public final void accept(Object it2) {
                    Function0 function02;
                    EventEntranceModel.Online online;
                    if (EventEntranceHelper.isChanged) {
                        EventEntranceHelper eventEntranceHelper = EventEntranceHelper.INSTANCE;
                        EventEntranceHelper.entranceInfo = EventEntranceModel.this;
                        EventEntranceHelper.INSTANCE.saveCache();
                        EventEntranceHelper eventEntranceHelper2 = EventEntranceHelper.INSTANCE;
                        EventEntranceModel eventEntranceModel3 = EventEntranceHelper.entranceInfo;
                        EventEntranceHelper.mLastLoopInterval = (eventEntranceModel3 == null || (online = eventEntranceModel3.getOnline()) == null) ? null : online.getInterval();
                        EventEntranceModel eventEntranceModel4 = EventEntranceHelper.entranceInfo;
                        if (eventEntranceModel4 != null) {
                            eventEntranceModel4.setLottieAnim(it2 instanceof LottieComposition ? (LottieComposition) it2 : null);
                        }
                    }
                    function02 = EventEntranceHelper.mListener;
                    if (function02 != null) {
                        function02.invoke();
                    }
                    Function0<Unit> function03 = function0;
                    if (function03 != null) {
                        function03.invoke();
                    }
                    EventEntranceHelper.INSTANCE.loop();
                    EventEntranceHelper eventEntranceHelper3 = EventEntranceHelper.INSTANCE;
                    EventEntranceHelper.isChecked = true;
                }
            }, new Consumer() { // from class: tv.danmaku.bili.ui.main.event.EventEntranceHelper.checkActivityEntrance.1.onDataSuccess.1.2.2.3
                public final void accept(Throwable it2) {
                    Intrinsics.checkNotNullParameter(it2, "it");
                    BLog.i("EventEntranceHelper", it2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void accept$lambda$0(Application $context, EventEntranceModel $data, ObservableEmitter it) {
            boolean checkAnim;
            EventEntranceModel.Animate animate;
            EventEntranceModel.Animate animate2;
            Intrinsics.checkNotNullParameter(it, "it");
            LottieComposition lottieComposition = null;
            if (EventEntranceHelper.isChanged) {
                checkAnim = EventEntranceHelper.INSTANCE.checkAnim($context);
                if (checkAnim) {
                    EventEntranceModel.Online online = $data.getOnline();
                    String str = null;
                    if (!TextUtils.isEmpty((online == null || (animate2 = online.getAnimate()) == null) ? null : animate2.getJson())) {
                        LottieResourceManager lottieResourceManager = LottieResourceManager.getInstance($context);
                        EventEntranceModel.Online online2 = $data.getOnline();
                        if (online2 != null && (animate = online2.getAnimate()) != null) {
                            str = animate.getJson();
                        }
                        Intrinsics.checkNotNull(str);
                        lottieComposition = lottieResourceManager.loadLottieResource(str, "activity_entrance_menu_anim");
                    }
                }
            }
            it.onNext(lottieComposition == null ? new Object() : lottieComposition);
            it.onComplete();
        }
    }
}