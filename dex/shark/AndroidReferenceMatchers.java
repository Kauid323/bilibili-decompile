package shark;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.ReferencePattern;
import tv.danmaku.bili.router.MainRouteUris;

/* compiled from: AndroidReferenceMatchers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b[\b\u0086\u0001\u0018\u0000 a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H ¢\u0006\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bUj\u0002\bVj\u0002\bWj\u0002\bXj\u0002\bYj\u0002\bZj\u0002\b[j\u0002\b\\j\u0002\b]j\u0002\b^j\u0002\b_j\u0002\b`¨\u0006b"}, d2 = {"Lshark/AndroidReferenceMatchers;", "", "(Ljava/lang/String;I)V", "add", "", "references", "", "Lshark/ReferenceMatcher;", "add$shark_android", "IREQUEST_FINISH_CALLBACK", "ACTIVITY_THREAD__M_NEW_ACTIVITIES", "SPAN_CONTROLLER", "MEDIA_SESSION_LEGACY_HELPER__SINSTANCE", "TEXT_LINE__SCACHED", "BLOCKING_QUEUE", "INPUT_METHOD_MANAGER_IS_TERRIBLE", "INPUT_MANAGER__M_LATE_INIT_CONTEXT", "LAYOUT_TRANSITION", "SPELL_CHECKER_SESSION", "SPELL_CHECKER", "ACTIVITY_CHOOSE_MODEL", "MEDIA_PROJECTION_CALLBACK", "SPEECH_RECOGNIZER", "ACCOUNT_MANAGER__AMS_TASK__RESPONSE", "MEDIA_SCANNER_CONNECTION", "USER_MANAGER__SINSTANCE", "APP_WIDGET_HOST_CALLBACKS", "AUDIO_MANAGER", "EDITTEXT_BLINK_MESSAGEQUEUE", "CONNECTIVITY_MANAGER__SINSTANCE", "ACCESSIBILITY_NODE_INFO__MORIGINALTEXT", "ASSIST_STRUCTURE", "ACCESSIBILITY_ITERATORS", "BIOMETRIC_PROMPT", "MAGNIFIER", "BACKDROP_FRAME_RENDERER__MDECORVIEW", "VIEWLOCATIONHOLDER_ROOT", "ACCESSIBILITY_NODE_ID_MANAGER", "TEXT_TO_SPEECH", "CONTROLLED_INPUT_CONNECTION_WRAPPER", "TOAST_TN", "APPLICATION_PACKAGE_MANAGER__HAS_SYSTEM_FEATURE_QUERY", "COMPANION_DEVICE_SERVICE__STUB", "RENDER_NODE_ANIMATOR", "PLAYER_BASE", "WINDOW_ON_BACK_INVOKED_DISPATCHER__STUB", "CONNECTIVITY_MANAGER_CALLBACK_HANDLER", "HOST_ADPU_SERVICE_MSG_HANDLER", "APP_OPS_MANAGER__CALLBACK_STUB", "VIEW_GROUP__M_PRE_SORTED_CHILDREN", "VIEW_GROUP__M_CURRENT_DRAG_CHILD", "VIEW_TOOLTIP_CALLBACK", "ACTIVITY_TRANSITION_STATE__M_EXITING_TO_VIEW", "ANIMATION_HANDLER__ANIMATOR_REQUESTORS", "FLIPPER__APPLICATION_DESCRIPTOR", "AW_CONTENTS__A0", "AW_CONTENTS_POSTED_CALLBACK", "JOB_SERVICE", "DREAM_SERVICE", "SPEN_GESTURE_MANAGER", "CLIPBOARD_UI_MANAGER__SINSTANCE", "SEM_CLIPBOARD_MANAGER__MCONTEXT", "CLIPBOARD_EX_MANAGER", "SEM_EMERGENCY_MANAGER__MCONTEXT", "SEM_PERSONA_MANAGER", "SEM_APP_ICON_SOLUTION", "AW_RESOURCE__SRESOURCES", "TEXT_VIEW__MLAST_HOVERED_VIEW", "PERSONA_MANAGER", "RESOURCES__MCONTEXT", "VIEW_CONFIGURATION__MCONTEXT", "AUDIO_MANAGER__MCONTEXT_STATIC", "ACTIVITY_MANAGER_MCONTEXT", "STATIC_MTARGET_VIEW", "MULTI_WINDOW_DECOR_SUPPORT__MWINDOW", "IMM_CURRENT_INPUT_CONNECTION", "GESTURE_BOOST_MANAGER", "BUBBLE_POPUP_HELPER__SHELPER", "LGCONTEXT__MCONTEXT", "SMART_COVER_MANAGER", "IMM_LAST_FOCUS_VIEW", "MAPPER_CLIENT", "SYSTEM_SENSOR_MANAGER__MAPPCONTEXTIMPL", "INSTRUMENTATION_RECOMMEND_ACTIVITY", "DEVICE_POLICY_MANAGER__SETTINGS_OBSERVER", "EXTENDED_STATUS_BAR_MANAGER", "OEM_SCENE_CALL_BLOCKER", "PERF_MONITOR_LAST_CALLBACK", "RAZER_TEXT_KEY_LISTENER__MCONTEXT", "XIAMI__RESOURCES_IMPL", "REFERENCES", "FINALIZER_WATCHDOG_DAEMON", "MAIN", "LEAK_CANARY_THREAD", "LEAK_CANARY_HEAP_DUMPER", "LEAK_CANARY_INTERNAL", "EVENT_RECEIVER__MMESSAGE_QUEUE", "Companion", "shark-android"}, k = 1, mv = {1, 4, 1})
public enum AndroidReferenceMatchers {
    IREQUEST_FINISH_CALLBACK { // from class: shark.AndroidReferenceMatchers.IREQUEST_FINISH_CALLBACK
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.app.Activity$1", "this$0", "Android Q added a new android.app.IRequestFinishCallback$Stub class. android.app.Activity creates an implementation of that interface as an anonymous subclass. That anonymous subclass has a reference to the activity. Another process is keeping the android.app.IRequestFinishCallback$Stub reference alive long after Activity.onDestroyed() has been called, causing the activity to leak. Fix: You can \"fix\" this leak by overriding Activity.onBackPressed() and calling Activity.finishAfterTransition(); instead of super if the activity is task root and the fragment stack is empty. Tracked here: https://issuetracker.google.com/issues/139738913", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$IREQUEST_FINISH_CALLBACK$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() == 29;
                }
            }));
        }
    },
    ACTIVITY_THREAD__M_NEW_ACTIVITIES { // from class: shark.AndroidReferenceMatchers.ACTIVITY_THREAD__M_NEW_ACTIVITIES
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.app.ActivityThread", "mNewActivities", "New activities are leaked by ActivityThread until the main thread becomes idle.\nTracked here: https://issuetracker.google.com/issues/258390457", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$ACTIVITY_THREAD__M_NEW_ACTIVITIES$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() >= 19;
                }
            }));
        }
    },
    SPAN_CONTROLLER { // from class: shark.AndroidReferenceMatchers.SPAN_CONTROLLER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.widget.Editor$SpanController", "this$0", "Editor inserts a special span, which has a reference to the EditText. That span is a NoCopySpan, which makes sure it gets dropped when creating a new SpannableStringBuilder from a given CharSequence. TextView.onSaveInstanceState() does a copy of its mText before saving it in the bundle. Prior to KitKat, that copy was done using the SpannableString constructor, instead of SpannableStringBuilder. The SpannableString constructor does not drop NoCopySpan spans. So we end up with a saved state that holds a reference to the textview and therefore the entire view hierarchy & activity context. Fix: https://github.com/android/platform_frameworks_base/commit/af7dcdf35a37d7a7dbaad7d9869c1c91bce2272b . To fix this, you could override TextView.onSaveInstanceState(), and then use reflection to access TextView.SavedState.mText and clear the NoCopySpan spans.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$SPAN_CONTROLLER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() <= 19;
                }
            }));
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.widget.Editor$EasyEditSpanController", "this$0", "Editor inserts a special span, which has a reference to the EditText. That span is a NoCopySpan, which makes sure it gets dropped when creating a new SpannableStringBuilder from a given CharSequence. TextView.onSaveInstanceState() does a copy of its mText before saving it in the bundle. Prior to KitKat, that copy was done using the SpannableString constructor, instead of SpannableStringBuilder. The SpannableString constructor does not drop NoCopySpan spans. So we end up with a saved state that holds a reference to the textview and therefore the entire view hierarchy & activity context. Fix: https://github.com/android/platform_frameworks_base/commit/af7dcdf35a37d7a7dbaad7d9869c1c91bce2272b . To fix this, you could override TextView.onSaveInstanceState(), and then use reflection to access TextView.SavedState.mText and clear the NoCopySpan spans.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$SPAN_CONTROLLER$add$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() <= 19;
                }
            }));
        }
    },
    MEDIA_SESSION_LEGACY_HELPER__SINSTANCE { // from class: shark.AndroidReferenceMatchers.MEDIA_SESSION_LEGACY_HELPER__SINSTANCE
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.media.session.MediaSessionLegacyHelper", "sInstance", "MediaSessionLegacyHelper is a static singleton that is lazily instantiated and keeps a reference to the context it's given the first time MediaSessionLegacyHelper.getHelper() is called. This leak was introduced in android-5.0.1_r1 and fixed in Android 5.1.0_r1 by calling context.getApplicationContext(). Fix: https://github.com/android/platform_frameworks_base/commit/9b5257c9c99c4cb541d8e8e78fb04f008b1a9091 To fix this, you could call MediaSessionLegacyHelper.getHelper() early in Application.onCreate() and pass it the application context.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$MEDIA_SESSION_LEGACY_HELPER__SINSTANCE$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$staticFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$staticFieldLeak, "$receiver");
                    return $this$staticFieldLeak.getSdkInt() == 21;
                }
            }));
        }
    },
    TEXT_LINE__SCACHED { // from class: shark.AndroidReferenceMatchers.TEXT_LINE__SCACHED
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.text.TextLine", "sCached", "TextLine.sCached is a pool of 3 TextLine instances. TextLine.recycle() has had at least two bugs that created memory leaks by not correctly clearing the recycled TextLine instances. The first was fixed in android-5.1.0_r1: https://github.com/android/platform_frameworks_base/commit/893d6fe48d37f71e683f722457bea646994a10 The second was fixed, not released yet: https://github.com/android/platform_frameworks_base/commit/b3a9bc038d3a218b1dbdf7b5668e3d6c12be5e To fix this, you could access TextLine.sCached and clear the pool every now and then (e.g. on activity destroy).", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$TEXT_LINE__SCACHED$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$staticFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$staticFieldLeak, "$receiver");
                    return $this$staticFieldLeak.getSdkInt() <= 22;
                }
            }));
        }
    },
    BLOCKING_QUEUE { // from class: shark.AndroidReferenceMatchers.BLOCKING_QUEUE
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.os.Message", "obj", "A thread waiting on a blocking queue will leak the last dequeued object as a stack local reference. So when a HandlerThread becomes idle, it keeps a local reference to the last message it received. That message then gets recycled and can be used again. As long as all messages are recycled after being used, this won't be a problem, because these references are cleared when being recycled. However, dialogs create template Message instances to be copied when a message needs to be sent. These Message templates holds references to the dialog listeners, which most likely leads to holding a reference onto the activity in some way. Dialogs never recycle their template Message, assuming these Message instances will get GCed when the dialog is GCed. The combination of these two things creates a high potential for memory leaks as soon as you use dialogs. These memory leaks might be temporary, but some handler threads sleep for a long time. This leak is fixed by AndroidLeakFixes.FLUSH_HANDLER_THREADS in plumber-android. Bug report: https://issuetracker.google.com/issues/146144484 Fixed in Android 12: https://cs.android.com/android/_/android/platform/frameworks/base/+/d577e728e9bccbafc707af3060ea914caa73c14f", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$BLOCKING_QUEUE$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() < 31;
                }
            }));
        }
    },
    INPUT_METHOD_MANAGER_IS_TERRIBLE { // from class: shark.AndroidReferenceMatchers.INPUT_METHOD_MANAGER_IS_TERRIBLE
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.inputmethod.InputMethodManager", "mNextServedView", "When we detach a view that receives keyboard input, the InputMethodManager leaks a reference to it until a new view asks for keyboard input. Tracked here: https://code.google.com/p/android/issues/detail?id=171190 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    int sdkInt = $this$instanceFieldLeak.getSdkInt();
                    return 15 <= sdkInt && 33 >= sdkInt;
                }
            }));
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.inputmethod.InputMethodManager", "mServedView", "When we detach a view that receives keyboard input, the InputMethodManager leaks a reference to it until a new view asks for keyboard input. Tracked here: https://code.google.com/p/android/issues/detail?id=171190 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE$add$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    int sdkInt = $this$instanceFieldLeak.getSdkInt();
                    return 15 <= sdkInt && 28 >= sdkInt;
                }
            }));
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.inputmethod.InputMethodManager", "mServedInputConnection", "When we detach a view that receives keyboard input, the InputMethodManager leaks a reference to it until a new view asks for keyboard input. Tracked here: https://code.google.com/p/android/issues/detail?id=171190 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE$add$3
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    int sdkInt = $this$instanceFieldLeak.getSdkInt();
                    return 15 <= sdkInt && 27 >= sdkInt;
                }
            }));
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.inputmethod.InputMethodManager", "mLastSrvView", "HUAWEI added a mLastSrvView field to InputMethodManager that leaks a reference to the last served view.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE$add$4
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    int sdkInt;
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.HUAWEI) && 23 <= (sdkInt = $this$instanceFieldLeak.getSdkInt()) && 28 >= sdkInt;
                }
            }));
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.inputmethod.InputMethodManager", "mCurRootView", "The singleton InputMethodManager is holding a reference to mCurRootView long after the activity has been destroyed. Observed on ICS MR1: https://github.com/square/leakcanary/issues/1#issuecomment-100579429 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE$add$5
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    int sdkInt = $this$instanceFieldLeak.getSdkInt();
                    return 15 <= sdkInt && 28 >= sdkInt;
                }
            }));
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.inputmethod.InputMethodManager", "mImeInsetsConsumer", "InputMethodManager.mImeInsetsConsumer isn't set to null when the activity is destroyed.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$INPUT_METHOD_MANAGER_IS_TERRIBLE$add$6
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() >= 30;
                }
            }));
        }
    },
    INPUT_MANAGER__M_LATE_INIT_CONTEXT { // from class: shark.AndroidReferenceMatchers.INPUT_MANAGER__M_LATE_INIT_CONTEXT
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.hardware.input.InputManager", "mLateInitContext", "InputManager singleton leaks its init context which is an activity", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$INPUT_MANAGER__M_LATE_INIT_CONTEXT$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() == 33;
                }
            }));
        }
    },
    LAYOUT_TRANSITION { // from class: shark.AndroidReferenceMatchers.LAYOUT_TRANSITION
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.animation.LayoutTransition$1", "val$parent", "LayoutTransition leaks parent ViewGroup through ViewTreeObserver.OnPreDrawListener When triggered, this leaks stays until the window is destroyed. Tracked here: https://code.google.com/p/android/issues/detail?id=171830", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$LAYOUT_TRANSITION$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    int sdkInt = $this$instanceFieldLeak.getSdkInt();
                    return 14 <= sdkInt && 22 >= sdkInt;
                }
            }));
        }
    },
    SPELL_CHECKER_SESSION { // from class: shark.AndroidReferenceMatchers.SPELL_CHECKER_SESSION
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.textservice.SpellCheckerSession$1", "this$0", "SpellCheckerSessionListenerImpl.mHandler is leaking destroyed Activity when the SpellCheckerSession is closed before the service is connected. Tracked here: https://code.google.com/p/android/issues/detail?id=172542", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$SPELL_CHECKER_SESSION$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    int sdkInt = $this$instanceFieldLeak.getSdkInt();
                    return 16 <= sdkInt && 24 >= sdkInt;
                }
            }));
        }
    },
    SPELL_CHECKER { // from class: shark.AndroidReferenceMatchers.SPELL_CHECKER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.widget.SpellChecker$1", "this$0", "SpellChecker holds on to a detached view that points to a destroyed activity. mSpellRunnable is being enqueued, and that callback should be removed when  closeSession() is called. Maybe closeSession() wasn't called, or maybe it was  called after the view was detached.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$SPELL_CHECKER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() == 22;
                }
            }));
        }
    },
    ACTIVITY_CHOOSE_MODEL { // from class: shark.AndroidReferenceMatchers.ACTIVITY_CHOOSE_MODEL
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.support.v7.internal.widget.ActivityChooserModel", "mActivityChoserModelPolicy", "ActivityChooserModel holds a static reference to the last set ActivityChooserModelPolicy which can be an activity context. Tracked here: https://code.google.com/p/android/issues/detail?id=172659 Hack: https://gist.github.com/andaag/b05ab66ed0f06167d6e0", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$ACTIVITY_CHOOSE_MODEL$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    int sdkInt = $this$instanceFieldLeak.getSdkInt();
                    return 15 <= sdkInt && 22 >= sdkInt;
                }
            }));
            list.add(Companion.instanceFieldLeak$default(AndroidReferenceMatchers.Companion, "android.widget.ActivityChooserModel", "mActivityChoserModelPolicy", "ActivityChooserModel holds a static reference to the last set ActivityChooserModelPolicy which can be an activity context. Tracked here: https://code.google.com/p/android/issues/detail?id=172659 Hack: https://gist.github.com/andaag/b05ab66ed0f06167d6e0", null, 8, null));
        }
    },
    MEDIA_PROJECTION_CALLBACK { // from class: shark.AndroidReferenceMatchers.MEDIA_PROJECTION_CALLBACK
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.media.projection.MediaProjection$MediaProjectionCallback", "this$0", "MediaProjectionCallback is held by another process, and holds on to MediaProjection\nwhich has an activity as its context.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$MEDIA_PROJECTION_CALLBACK$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    int sdkInt = $this$instanceFieldLeak.getSdkInt();
                    return 22 <= sdkInt && 28 >= sdkInt;
                }
            }));
        }
    },
    SPEECH_RECOGNIZER { // from class: shark.AndroidReferenceMatchers.SPEECH_RECOGNIZER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.speech.SpeechRecognizer$InternalListener", "this$0", "Prior to Android 5, SpeechRecognizer.InternalListener was a non static inner class and leaked the SpeechRecognizer which leaked an activity context. Fixed in AOSP: https://github.com/android/platform_frameworks_base/commit /b37866db469e81aca534ff6186bdafd44352329b", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$SPEECH_RECOGNIZER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() < 21;
                }
            }));
        }
    },
    ACCOUNT_MANAGER__AMS_TASK__RESPONSE { // from class: shark.AndroidReferenceMatchers.ACCOUNT_MANAGER__AMS_TASK__RESPONSE
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.nativeGlobalVariableLeak("android.accounts.AccountManager$AmsTask$Response", "AccountManager.AmsTask.Response is a stub, and as all stubs it's held in memory by a\nnative ref until the calling side gets GCed, which can happen long after the stub is no\nlonger of use.\nhttps://issuetracker.google.com/issues/318303120", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$ACCOUNT_MANAGER__AMS_TASK__RESPONSE$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$nativeGlobalVariableLeak) {
                    Intrinsics.checkParameterIsNotNull($this$nativeGlobalVariableLeak, "$receiver");
                    return $this$nativeGlobalVariableLeak.getSdkInt() >= 5;
                }
            }));
        }
    },
    MEDIA_SCANNER_CONNECTION { // from class: shark.AndroidReferenceMatchers.MEDIA_SCANNER_CONNECTION
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.media.MediaScannerConnection", "mContext", "The static method MediaScannerConnection.scanFile() takes an activity context but the service might not disconnect after the activity has been destroyed. Tracked here: https://code.google.com/p/android/issues/detail?id=173788 Fix: Create an instance of MediaScannerConnection yourself and pass in the application context. Call connect() and disconnect() manually.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$MEDIA_SCANNER_CONNECTION$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() <= 22;
                }
            }));
        }
    },
    USER_MANAGER__SINSTANCE { // from class: shark.AndroidReferenceMatchers.USER_MANAGER__SINSTANCE
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.os.UserManager", "mContext", "UserManager has a static sInstance field that creates an instance and caches it the first time UserManager.get() is called. This instance is created with the outer context (which is an activity base context). Tracked here: https://code.google.com/p/android/issues/detail?id=173789 Introduced by: https://github.com/android/platform_frameworks_base/commit/27db46850b708070452c0ce49daf5f79503fbde6 Fix: trigger a call to UserManager.get() in Application.onCreate(), so that the UserManager instance gets cached with a reference to the application context.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$USER_MANAGER__SINSTANCE$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    int sdkInt = $this$instanceFieldLeak.getSdkInt();
                    return 18 <= sdkInt && 25 >= sdkInt;
                }
            }));
        }
    },
    APP_WIDGET_HOST_CALLBACKS { // from class: shark.AndroidReferenceMatchers.APP_WIDGET_HOST_CALLBACKS
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.appwidget.AppWidgetHost$Callbacks", "this$0", "android.appwidget.AppWidgetHost$Callbacks is a stub and is held in memory native code. The reference to the `mContext` was not being cleared, which caused the Callbacks instance to retain this reference Fixed in AOSP: https://github.com/android/platform_frameworks_base/commit/7a96f3c917e0001ee739b65da37b2fadec7d7765", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$APP_WIDGET_HOST_CALLBACKS$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() < 22;
                }
            }));
        }
    },
    AUDIO_MANAGER { // from class: shark.AndroidReferenceMatchers.AUDIO_MANAGER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.media.AudioManager$1", "this$0", "Prior to Android M, VideoView required audio focus from AudioManager and never abandoned it, which leaks the Activity context through the AudioManager. The root of the problem is that AudioManager uses whichever context it receives, which in the case of the VideoView example is an Activity, even though it only needs the application's context. The issue is fixed in Android M, and the AudioManager now uses the application's context. Tracked here: https://code.google.com/p/android/issues/detail?id=152173 Fix: https://gist.github.com/jankovd/891d96f476f7a9ce24e2", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$AUDIO_MANAGER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() <= 22;
                }
            }));
        }
    },
    EDITTEXT_BLINK_MESSAGEQUEUE { // from class: shark.AndroidReferenceMatchers.EDITTEXT_BLINK_MESSAGEQUEUE
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.widget.Editor$Blink", "this$0", "The EditText Blink of the Cursor is implemented using a callback and Messages, which trigger the display of the Cursor. If an AlertDialog or DialogFragment that contains a blinking cursor is detached, a message is posted with a delay after the dialog has been closed and as a result leaks the Activity. This can be fixed manually by calling TextView.setCursorVisible(false) in the dismiss() method of the dialog. Tracked here: https://code.google.com/p/android/issues/detail?id=188551 Fixed in AOSP: https://android.googlesource.com/platform/frameworks/base/+/5b734f2430e9f26c769d6af8ea5645e390fcf5af%5E%21/", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$EDITTEXT_BLINK_MESSAGEQUEUE$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() <= 23;
                }
            }));
        }
    },
    CONNECTIVITY_MANAGER__SINSTANCE { // from class: shark.AndroidReferenceMatchers.CONNECTIVITY_MANAGER__SINSTANCE
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.net.ConnectivityManager", "sInstance", "ConnectivityManager has a sInstance field that is set when the first ConnectivityManager instance is created. ConnectivityManager has a mContext field. When calling activity.getSystemService(Context.CONNECTIVITY_SERVICE) , the first ConnectivityManager instance is created with the activity context and stored in sInstance. That activity context then leaks forever. Until this is fixed, app developers can prevent this leak by making sure the ConnectivityManager is first created with an App Context. E.g. in some static init do: context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE) Tracked here: https://code.google.com/p/android/issues/detail?id=198852 Introduced here: https://github.com/android/platform_frameworks_base/commit/e0bef71662d81caaaa0d7214fb0bef5d39996a69", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$CONNECTIVITY_MANAGER__SINSTANCE$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() <= 23;
                }
            }));
        }
    },
    ACCESSIBILITY_NODE_INFO__MORIGINALTEXT { // from class: shark.AndroidReferenceMatchers.ACCESSIBILITY_NODE_INFO__MORIGINALTEXT
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.accessibility.AccessibilityNodeInfo", "mOriginalText", "AccessibilityNodeInfo has a static sPool of AccessibilityNodeInfo. When AccessibilityNodeInfo instances are released back in the pool, AccessibilityNodeInfo.clear() does not clear the mOriginalText field, which causes spans to leak which in turns causes TextView.ChangeWatcher to leak and the whole view hierarchy. Introduced here: https://android.googlesource.com/platform/frameworks/base/+/193520e3dff5248ddcf8435203bf99d2ba667219%5E%21/core/java/android/view/accessibility/AccessibilityNodeInfo.java", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$ACCESSIBILITY_NODE_INFO__MORIGINALTEXT$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    int sdkInt = $this$instanceFieldLeak.getSdkInt();
                    return 26 <= sdkInt && 27 >= sdkInt;
                }
            }));
        }
    },
    ASSIST_STRUCTURE { // from class: shark.AndroidReferenceMatchers.ASSIST_STRUCTURE
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.app.assist.AssistStructure$ViewNodeText", "mText", "AssistStructure (google assistant / autofill) holds on to text spannables on the screen. TextView.ChangeWatcher and android.widget.Editor end up in spans and typically hold on to the view hierarchy", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$ASSIST_STRUCTURE$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() >= 24;
                }
            }));
        }
    },
    ACCESSIBILITY_ITERATORS { // from class: shark.AndroidReferenceMatchers.ACCESSIBILITY_ITERATORS
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.widget.AccessibilityIterators$LineTextSegmentIterator", "mLayout", "AccessibilityIterators holds on to text layouts which can hold on to spans TextView.ChangeWatcher and android.widget.Editor end up in spans and typically hold on to the view hierarchy", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$ACCESSIBILITY_ITERATORS$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() == 27;
                }
            }));
        }
    },
    BIOMETRIC_PROMPT { // from class: shark.AndroidReferenceMatchers.BIOMETRIC_PROMPT
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.hardware.biometrics.BiometricPrompt", "mFingerprintManager", "BiometricPrompt holds on to a FingerprintManager which holds on to a destroyed activity.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$BIOMETRIC_PROMPT$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() == 28;
                }
            }));
        }
    },
    MAGNIFIER { // from class: shark.AndroidReferenceMatchers.MAGNIFIER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.widget.Magnifier$InternalPopupWindow", "mCallback", "android.widget.Magnifier.InternalPopupWindow registers a frame callback on android.view.ThreadedRenderer.SimpleRenderer which holds it as a native reference. android.widget.Editor$InsertionHandleView registers an OnOperationCompleteCallback on Magnifier.InternalPopupWindow. These references are held after the activity has been destroyed.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$MAGNIFIER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() == 28;
                }
            }));
        }
    },
    BACKDROP_FRAME_RENDERER__MDECORVIEW { // from class: shark.AndroidReferenceMatchers.BACKDROP_FRAME_RENDERER__MDECORVIEW
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("com.android.internal.policy.BackdropFrameRenderer", "mDecorView", "When BackdropFrameRenderer.releaseRenderer() is called, there's an unknown case where mRenderer becomes null but mChoreographer doesn't and the thread doesn't stop and ends up leaking mDecorView which itself holds on to a destroyed activity", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$BACKDROP_FRAME_RENDERER__MDECORVIEW$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    int sdkInt = $this$instanceFieldLeak.getSdkInt();
                    return 24 <= sdkInt && 26 >= sdkInt;
                }
            }));
        }
    },
    VIEWLOCATIONHOLDER_ROOT { // from class: shark.AndroidReferenceMatchers.VIEWLOCATIONHOLDER_ROOT
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.ViewGroup$ViewLocationHolder", "mRoot", "In Android P, ViewLocationHolder has an mRoot field that is not cleared in its clear() method. Introduced in https://github.com/aosp-mirror/platform_frameworks_base/commit/86b326012813f09d8f1de7d6d26c986a909d Bug report: https://issuetracker.google.com/issues/112792715", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$VIEWLOCATIONHOLDER_ROOT$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() == 28;
                }
            }));
        }
    },
    ACCESSIBILITY_NODE_ID_MANAGER { // from class: shark.AndroidReferenceMatchers.ACCESSIBILITY_NODE_ID_MANAGER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.accessibility.AccessibilityNodeIdManager", "mIdsToViews", "Android Q Beta added AccessibilityNodeIdManager which stores all views from their\nonAttachedToWindow() call, until detached. Unfortunately it's possible to trigger\nthe view framework to call detach before attach (by having a view removing itself\nfrom its parent in onAttach, which then causes AccessibilityNodeIdManager to keep\nchildren view forever. Future releases of Q will hold weak references.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$ACCESSIBILITY_NODE_ID_MANAGER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    int sdkInt = $this$instanceFieldLeak.getSdkInt();
                    return 28 <= sdkInt && 29 >= sdkInt;
                }
            }));
        }
    },
    TEXT_TO_SPEECH { // from class: shark.AndroidReferenceMatchers.TEXT_TO_SPEECH
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.speech.tts.TextToSpeech", "mContext", "TextToSpeech.shutdown() does not release its references to context objects. Furthermore, TextToSpeech instances cannot be garbage collected due to other process keeping the references, resulting the context objects leaked. Developers might be able to mitigate the issue by passing application context to TextToSpeech constructor. Tracked at: https://github.com/square/leakcanary/issues/1210 and https://issuetracker.google.com/issues/129250419", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$TEXT_TO_SPEECH$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() == 24;
                }
            }));
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.speech.tts.TtsEngines", "mContext", "TextToSpeech.shutdown() does not release its references to context objects. Furthermore, TextToSpeech instances cannot be garbage collected due to other process keeping the references, resulting the context objects leaked. Developers might be able to mitigate the issue by passing application context to TextToSpeech constructor. Tracked at: https://github.com/square/leakcanary/issues/1210 and https://issuetracker.google.com/issues/129250419", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$TEXT_TO_SPEECH$add$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() == 24;
                }
            }));
        }
    },
    CONTROLLED_INPUT_CONNECTION_WRAPPER { // from class: shark.AndroidReferenceMatchers.CONTROLLED_INPUT_CONNECTION_WRAPPER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(Companion.nativeGlobalVariableLeak$default(AndroidReferenceMatchers.Companion, "android.view.inputmethod.InputMethodManager$ControlledInputConnectionWrapper", "ControlledInputConnectionWrapper is held by a global variable in native code.", null, 4, null));
        }
    },
    TOAST_TN { // from class: shark.AndroidReferenceMatchers.TOAST_TN
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(Companion.nativeGlobalVariableLeak$default(AndroidReferenceMatchers.Companion, "android.widget.Toast$TN", "Toast.TN is held by a global variable in native code due to an IPC call to show the toast.", null, 4, null));
        }
    },
    APPLICATION_PACKAGE_MANAGER__HAS_SYSTEM_FEATURE_QUERY { // from class: shark.AndroidReferenceMatchers.APPLICATION_PACKAGE_MANAGER__HAS_SYSTEM_FEATURE_QUERY
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.app.ApplicationPackageManager$HasSystemFeatureQuery", "this$0", "In Android 11 DP 2 ApplicationPackageManager.HasSystemFeatureQuery was an inner class.\nIntroduced in https://cs.android.com/android/_/android/platform/frameworks/base/+/89608118192580ffca026b5dacafa637a556d578\nFixed in https://cs.android.com/android/_/android/platform/frameworks/base/+/1f771846c51148b7cb6283e6dc82a216ffaa5353\nRelated blog: https://dev.to/pyricau/beware-packagemanager-leaks-223g", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$APPLICATION_PACKAGE_MANAGER__HAS_SYSTEM_FEATURE_QUERY$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() == 29;
                }
            }));
        }
    },
    COMPANION_DEVICE_SERVICE__STUB { // from class: shark.AndroidReferenceMatchers.COMPANION_DEVICE_SERVICE__STUB
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.companion.CompanionDeviceService$Stub", "this$0", "Android 12 added android.companion.CompanionDeviceService, a bounded service extended by\napplications to which the system binds. CompanionDeviceService.Stub is an inner class\nthat holds a reference to CompanionDeviceService, which itself holds a Stub instance\nthat's not nullified after the service is destroyed.\nIntroduced in https://android.googlesource.com/platform/frameworks/base/+/df69bbaf29e41d9df105612500c27be730feedfc\nSource code: https://android.googlesource.com/platform/frameworks/base/+/master/core/java/android/companion/CompanionDeviceService.java", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$COMPANION_DEVICE_SERVICE__STUB$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() == 31;
                }
            }));
        }
    },
    RENDER_NODE_ANIMATOR { // from class: shark.AndroidReferenceMatchers.RENDER_NODE_ANIMATOR
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.nativeGlobalVariableLeak("android.graphics.animation.RenderNodeAnimator", "When a view is detached while a ripple animation is still playing on it, the native code\ndoesn't properly end the RenderNodeAnimator, i.e. it doesn't call\nRenderNodeAnimator.callOnFinished and doesn't let go of the native ref, leading to a\nleak of the detached animated view.\nTracked at: https://issuetracker.google.com/issues/229136453", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$RENDER_NODE_ANIMATOR$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$nativeGlobalVariableLeak) {
                    Intrinsics.checkParameterIsNotNull($this$nativeGlobalVariableLeak, "$receiver");
                    int sdkInt = $this$nativeGlobalVariableLeak.getSdkInt();
                    return 31 <= sdkInt && 32 >= sdkInt;
                }
            }));
        }
    },
    PLAYER_BASE { // from class: shark.AndroidReferenceMatchers.PLAYER_BASE
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.nativeGlobalVariableLeak("android.media.PlayerBase$1", "PlayerBase$1 implements IAppOpsCallback as an inner class and is held by a native\nref, preventing subclasses of PlayerBase to be GC'd.\nIntroduced in API 24: https://cs.android.com/android/_/android/platform/frameworks/base/+/3c86a343dfca1b9e2e28c240dc894f60709e392c\nFixed in API 28: https://cs.android.com/android/_/android/platform/frameworks/base/+/aee6ee94675d56e71a42d52b16b8d8e5fa6ea3ff", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$PLAYER_BASE$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$nativeGlobalVariableLeak) {
                    Intrinsics.checkParameterIsNotNull($this$nativeGlobalVariableLeak, "$receiver");
                    int sdkInt = $this$nativeGlobalVariableLeak.getSdkInt();
                    return 24 <= sdkInt && 27 >= sdkInt;
                }
            }));
        }
    },
    WINDOW_ON_BACK_INVOKED_DISPATCHER__STUB { // from class: shark.AndroidReferenceMatchers.WINDOW_ON_BACK_INVOKED_DISPATCHER__STUB
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.window.WindowOnBackInvokedDispatcher$OnBackInvokedCallbackWrapper", "mCallback", "WindowOnBackInvokedDispatcher.OnBackInvokedCallbackWrapper is an IPC stub that holds a\nreference to a callback which itself holds a view root. Another process is keeping the\nstub alive long after the view root has been detached.\nTracked here: https://issuetracker.google.com/issues/229007483", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$WINDOW_ON_BACK_INVOKED_DISPATCHER__STUB$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() == 32 && Intrinsics.areEqual($this$instanceFieldLeak.getId(), "TPP2.220218.008");
                }
            }));
        }
    },
    CONNECTIVITY_MANAGER_CALLBACK_HANDLER { // from class: shark.AndroidReferenceMatchers.CONNECTIVITY_MANAGER_CALLBACK_HANDLER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("ConnectivityManager$CallbackHandler", "this$0", "ConnectivityManager.CallbackHandler instances can be held statically and hold\na reference to ConnectivityManager instances created with a local context (e.g. activity).\nFiled: https://issuetracker.google.com/issues/258053962\nFixed in API 34.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$CONNECTIVITY_MANAGER_CALLBACK_HANDLER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() == 33;
                }
            }));
        }
    },
    HOST_ADPU_SERVICE_MSG_HANDLER { // from class: shark.AndroidReferenceMatchers.HOST_ADPU_SERVICE_MSG_HANDLER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.nfc.cardemulation.HostApduService$MsgHandler", "this$0", "Destroyed HostApduService instances are held by a handler instance that lives longer\nthan the service.\nReport: https://github.com/square/leakcanary/issues/2390", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$HOST_ADPU_SERVICE_MSG_HANDLER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    int sdkInt = $this$instanceFieldLeak.getSdkInt();
                    return 29 <= sdkInt && 33 >= sdkInt;
                }
            }));
        }
    },
    APP_OPS_MANAGER__CALLBACK_STUB { // from class: shark.AndroidReferenceMatchers.APP_OPS_MANAGER__CALLBACK_STUB
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.nativeGlobalVariableLeak("android.app.AppOpsManager$3", "Fix: Update androidx.core:core to 1.10.0-alpha01 or greater as it includes an Android 12\nfix for this leak on Android 12, see https://github.com/androidx/androidx/pull/435 .\nAppOpsManager\\$3 implements IAppOpsActiveCallback.Stub and is held by a native ref long\nuntil the calling side gets GCed, which can happen long after the stub is no longer of\nuse.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$APP_OPS_MANAGER__CALLBACK_STUB$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$nativeGlobalVariableLeak) {
                    Intrinsics.checkParameterIsNotNull($this$nativeGlobalVariableLeak, "$receiver");
                    int sdkInt = $this$nativeGlobalVariableLeak.getSdkInt();
                    return 31 <= sdkInt && 32 >= sdkInt;
                }
            }));
        }
    },
    VIEW_GROUP__M_PRE_SORTED_CHILDREN { // from class: shark.AndroidReferenceMatchers.VIEW_GROUP__M_PRE_SORTED_CHILDREN
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.ViewGroup", "mPreSortedChildren", "ViewGroup.mPreSortedChildren is used as a temporary list but not cleared after being\nused.\nReport: https://issuetracker.google.com/issues/178029590\nFix: https://cs.android.com/android/_/android/platform/frameworks/base/+/73590c7751b9185137de962ba9ad9ff5a6e11e5d", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$VIEW_GROUP__M_PRE_SORTED_CHILDREN$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() == 30;
                }
            }));
        }
    },
    VIEW_GROUP__M_CURRENT_DRAG_CHILD { // from class: shark.AndroidReferenceMatchers.VIEW_GROUP__M_CURRENT_DRAG_CHILD
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.ViewGroup", "mCurrentDragChild", "ViewGroup.mCurrentDragChild keeps a reference to a view that was dragged after that view\nhas been detached.\nReport: https://issuetracker.google.com/issues/170276524", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$VIEW_GROUP__M_CURRENT_DRAG_CHILD$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    int sdkInt = $this$instanceFieldLeak.getSdkInt();
                    return 29 <= sdkInt && 30 >= sdkInt;
                }
            }));
        }
    },
    VIEW_TOOLTIP_CALLBACK { // from class: shark.AndroidReferenceMatchers.VIEW_TOOLTIP_CALLBACK
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.View$$ExternalSyntheticLambda3", "f$0", "When a View has tooltip text set, every hover event will fire a callback\nto hide the tooltip after a 15 second timeout. Since the callback holds\na reference to the View, it will leak the View for that duration after\nthe Activity is finished or the View is removed.\nhttps://cs.android.com/android/_/android/platform/frameworks/base/+/708dbe80902b963388c412f670c56ae00953273a", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$VIEW_TOOLTIP_CALLBACK$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    int sdkInt = $this$instanceFieldLeak.getSdkInt();
                    return 26 <= sdkInt && 34 >= sdkInt;
                }
            }));
        }
    },
    ACTIVITY_TRANSITION_STATE__M_EXITING_TO_VIEW { // from class: shark.AndroidReferenceMatchers.ACTIVITY_TRANSITION_STATE__M_EXITING_TO_VIEW
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.app.ActivityTransitionState", "mExitingToView", "Shared element transition leak the view that was used in the transition.\nReport: https://issuetracker.google.com/issues/141132765", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$ACTIVITY_TRANSITION_STATE__M_EXITING_TO_VIEW$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    int sdkInt = $this$instanceFieldLeak.getSdkInt();
                    return 28 <= sdkInt && 29 >= sdkInt;
                }
            }));
        }
    },
    ANIMATION_HANDLER__ANIMATOR_REQUESTORS { // from class: shark.AndroidReferenceMatchers.ANIMATION_HANDLER__ANIMATOR_REQUESTORS
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.animation.AnimationHandler", "mAnimatorRequestors", "AnimationHandler is a singleton holding an activity ViewRootImpl requestor after the\nactivity has been destroyed.\nReport: https://issuetracker.google.com/issues/258534826", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$ANIMATION_HANDLER__ANIMATOR_REQUESTORS$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return $this$instanceFieldLeak.getSdkInt() == 33;
                }
            }));
        }
    },
    FLIPPER__APPLICATION_DESCRIPTOR { // from class: shark.AndroidReferenceMatchers.FLIPPER__APPLICATION_DESCRIPTOR
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(Companion.staticFieldLeak$default(AndroidReferenceMatchers.Companion, "com.facebook.flipper.plugins.inspector.descriptors.ApplicationDescriptor", "editedDelegates", "Flipper's ApplicationDescriptor leaks root views after they've been detached.\nhttps://github.com/facebook/flipper/issues/4270", null, 8, null));
        }
    },
    AW_CONTENTS__A0 { // from class: shark.AndroidReferenceMatchers.AW_CONTENTS__A0
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            Companion.staticFieldLeak$default(AndroidReferenceMatchers.Companion, "org.chromium.android_webview.AwContents", "A0", "WindowAndroidWrapper has a strong ref to the context key so this breaks the WeakHashMap\ncontracts and WeakHashMap is unable to perform its job of auto cleaning.\nhttps://github.com/square/leakcanary/issues/2538", null, 8, null);
        }
    },
    AW_CONTENTS_POSTED_CALLBACK { // from class: shark.AndroidReferenceMatchers.AW_CONTENTS_POSTED_CALLBACK
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            Companion.instanceFieldLeak$default(AndroidReferenceMatchers.Companion, "WV.R9", "e", "Android System WebView leak: https://bugs.chromium.org/p/chromium/issues/detail?id=1499154", null, 8, null);
            Companion.instanceFieldLeak$default(AndroidReferenceMatchers.Companion, "WV.a6", "c", "Android System WebView leak: https://bugs.chromium.org/p/chromium/issues/detail?id=1499154", null, 8, null);
            Companion.instanceFieldLeak$default(AndroidReferenceMatchers.Companion, "WV.H5", "c", "Android System WebView leak: https://bugs.chromium.org/p/chromium/issues/detail?id=1499154", null, 8, null);
            Companion.instanceFieldLeak$default(AndroidReferenceMatchers.Companion, "WV.Y9", "e", "Android System WebView leak: https://bugs.chromium.org/p/chromium/issues/detail?id=1499154", null, 8, null);
            Companion.instanceFieldLeak$default(AndroidReferenceMatchers.Companion, "WV.U4", "c", "Android System WebView leak: https://bugs.chromium.org/p/chromium/issues/detail?id=1499154", null, 8, null);
        }
    },
    JOB_SERVICE { // from class: shark.AndroidReferenceMatchers.JOB_SERVICE
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            AndroidReferenceMatchers.Companion.nativeGlobalVariableLeak("android.app.job.JobService$1", "JobService used to be leaked via a binder stub.\nFix: https://cs.android.com/android/_/android/platform/frameworks/base/+/0796e9fb3dc2dd03fa5ff2053c63f14861cffa2f", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$JOB_SERVICE$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$nativeGlobalVariableLeak) {
                    Intrinsics.checkParameterIsNotNull($this$nativeGlobalVariableLeak, "$receiver");
                    return $this$nativeGlobalVariableLeak.getSdkInt() < 24;
                }
            });
        }
    },
    DREAM_SERVICE { // from class: shark.AndroidReferenceMatchers.DREAM_SERVICE
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            AndroidReferenceMatchers.Companion.nativeGlobalVariableLeak("android.service.dreams.DreamService$1", "DreamService leaks a binder stub.\nhttps://github.com/square/leakcanary/issues/2534", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$DREAM_SERVICE$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$nativeGlobalVariableLeak) {
                    Intrinsics.checkParameterIsNotNull($this$nativeGlobalVariableLeak, "$receiver");
                    return $this$nativeGlobalVariableLeak.getSdkInt() >= 33;
                }
            });
        }
    },
    SPEN_GESTURE_MANAGER { // from class: shark.AndroidReferenceMatchers.SPEN_GESTURE_MANAGER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("com.samsung.android.smartclip.SpenGestureManager", "mContext", "SpenGestureManager has a static mContext field that leaks a reference to the activity. Yes, a STATIC mContext field.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$SPEN_GESTURE_MANAGER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$staticFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$staticFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$staticFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && $this$staticFieldLeak.getSdkInt() == 19;
                }
            }));
        }
    },
    CLIPBOARD_UI_MANAGER__SINSTANCE { // from class: shark.AndroidReferenceMatchers.CLIPBOARD_UI_MANAGER__SINSTANCE
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.sec.clipboard.ClipboardUIManager", "mContext", "ClipboardUIManager is a static singleton that leaks an activity context. Fix: trigger a call to ClipboardUIManager.getInstance() in Application.onCreate() , so that the ClipboardUIManager instance gets cached with a reference to the application context. Example: https://gist.github.com/cypressious/91c4fb1455470d803a602838dfcd5774", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$CLIPBOARD_UI_MANAGER__SINSTANCE$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    int sdkInt;
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && 19 <= (sdkInt = $this$instanceFieldLeak.getSdkInt()) && 21 >= sdkInt;
                }
            }));
        }
    },
    SEM_CLIPBOARD_MANAGER__MCONTEXT { // from class: shark.AndroidReferenceMatchers.SEM_CLIPBOARD_MANAGER__MCONTEXT
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.nativeGlobalVariableLeak("com.samsung.android.content.clipboard.SemClipboardManager$1", "SemClipboardManager inner classes are held by native references due to IPC calls", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$SEM_CLIPBOARD_MANAGER__MCONTEXT$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$nativeGlobalVariableLeak) {
                    int sdkInt;
                    Intrinsics.checkParameterIsNotNull($this$nativeGlobalVariableLeak, "$receiver");
                    return Intrinsics.areEqual($this$nativeGlobalVariableLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && 19 <= (sdkInt = $this$nativeGlobalVariableLeak.getSdkInt()) && 28 >= sdkInt;
                }
            }));
            list.add(AndroidReferenceMatchers.Companion.nativeGlobalVariableLeak("com.samsung.android.content.clipboard.SemClipboardManager$3", "SemClipboardManager inner classes are held by native references due to IPC calls", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$SEM_CLIPBOARD_MANAGER__MCONTEXT$add$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$nativeGlobalVariableLeak) {
                    int sdkInt;
                    Intrinsics.checkParameterIsNotNull($this$nativeGlobalVariableLeak, "$receiver");
                    return Intrinsics.areEqual($this$nativeGlobalVariableLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && 19 <= (sdkInt = $this$nativeGlobalVariableLeak.getSdkInt()) && 28 >= sdkInt;
                }
            }));
        }
    },
    CLIPBOARD_EX_MANAGER { // from class: shark.AndroidReferenceMatchers.CLIPBOARD_EX_MANAGER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.sec.clipboard.ClipboardExManager", "mContext", "android.sec.clipboard.ClipboardExManager$IClipboardDataPasteEventImpl$1 is a native callback that holds IClipboardDataPasteEventImpl which holds ClipboardExManager which has a destroyed activity as mContext", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$CLIPBOARD_EX_MANAGER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && $this$instanceFieldLeak.getSdkInt() == 23;
                }
            }));
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.sec.clipboard.ClipboardExManager", "mPersonaManager", "android.sec.clipboard.ClipboardExManager$IClipboardDataPasteEventImpl$1 is a native callback that holds IClipboardDataPasteEventImpl which holds ClipboardExManager which holds PersonaManager which has a destroyed activity as mContext", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$CLIPBOARD_EX_MANAGER$add$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && $this$instanceFieldLeak.getSdkInt() == 23;
                }
            }));
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.widget.TextView$IClipboardDataPasteEventImpl", "this$0", "TextView$IClipboardDataPasteEventImpl$1 is held by a native ref, and IClipboardDataPasteEventImpl ends up leaking a detached textview", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$CLIPBOARD_EX_MANAGER$add$3
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && $this$instanceFieldLeak.getSdkInt() == 22;
                }
            }));
        }
    },
    SEM_EMERGENCY_MANAGER__MCONTEXT { // from class: shark.AndroidReferenceMatchers.SEM_EMERGENCY_MANAGER__MCONTEXT
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("com.samsung.android.emergencymode.SemEmergencyManager", "mContext", "SemEmergencyManager is a static singleton that leaks a DecorContext. Fix: https://gist.github.com/jankovd/a210460b814c04d500eb12025902d60d", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$SEM_EMERGENCY_MANAGER__MCONTEXT$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    int sdkInt;
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && 19 <= (sdkInt = $this$instanceFieldLeak.getSdkInt()) && 24 >= sdkInt;
                }
            }));
        }
    },
    SEM_PERSONA_MANAGER { // from class: shark.AndroidReferenceMatchers.SEM_PERSONA_MANAGER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(Companion.instanceFieldLeak$default(AndroidReferenceMatchers.Companion, "com.samsung.android.knox.SemPersonaManager", "mContext", null, new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$SEM_PERSONA_MANAGER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && $this$instanceFieldLeak.getSdkInt() == 24;
                }
            }, 4, null));
        }
    },
    SEM_APP_ICON_SOLUTION { // from class: shark.AndroidReferenceMatchers.SEM_APP_ICON_SOLUTION
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(Companion.instanceFieldLeak$default(AndroidReferenceMatchers.Companion, "android.app.SemAppIconSolution", "mContext", null, new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$SEM_APP_ICON_SOLUTION$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    int sdkInt;
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && 28 <= (sdkInt = $this$instanceFieldLeak.getSdkInt()) && 29 >= sdkInt;
                }
            }, 4, null));
        }
    },
    AW_RESOURCE__SRESOURCES { // from class: shark.AndroidReferenceMatchers.AW_RESOURCE__SRESOURCES
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(Companion.staticFieldLeak$default(AndroidReferenceMatchers.Companion, "com.android.org.chromium.android_webview.AwResource", "sResources", null, new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$AW_RESOURCE__SRESOURCES$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$staticFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$staticFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$staticFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && $this$staticFieldLeak.getSdkInt() == 19;
                }
            }, 4, null));
        }
    },
    TEXT_VIEW__MLAST_HOVERED_VIEW { // from class: shark.AndroidReferenceMatchers.TEXT_VIEW__MLAST_HOVERED_VIEW
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.widget.TextView", "mLastHoveredView", "mLastHoveredView is a static field in TextView that leaks the last hovered view.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$TEXT_VIEW__MLAST_HOVERED_VIEW$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$staticFieldLeak) {
                    int sdkInt;
                    Intrinsics.checkParameterIsNotNull($this$staticFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$staticFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && 19 <= (sdkInt = $this$staticFieldLeak.getSdkInt()) && 31 >= sdkInt;
                }
            }));
        }
    },
    PERSONA_MANAGER { // from class: shark.AndroidReferenceMatchers.PERSONA_MANAGER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.os.PersonaManager", "mContext", "android.app.LoadedApk.mResources has a reference to android.content.res.Resources.mPersonaManager which has a reference to android.os.PersonaManager.mContext which is an activity.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$PERSONA_MANAGER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && $this$instanceFieldLeak.getSdkInt() == 19;
                }
            }));
        }
    },
    RESOURCES__MCONTEXT { // from class: shark.AndroidReferenceMatchers.RESOURCES__MCONTEXT
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.content.res.Resources", "mContext", "In AOSP the Resources class does not have a context. Here we have ZygoteInit.mResources (static field) holding on to a Resources instance that has a context that is the activity. Observed here: https://github.com/square/leakcanary/issues/1#issue-74450184", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$RESOURCES__MCONTEXT$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && $this$instanceFieldLeak.getSdkInt() == 19;
                }
            }));
        }
    },
    VIEW_CONFIGURATION__MCONTEXT { // from class: shark.AndroidReferenceMatchers.VIEW_CONFIGURATION__MCONTEXT
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.ViewConfiguration", "mContext", "In AOSP the ViewConfiguration class does not have a context. Here we have ViewConfiguration.sConfigurations (static field) holding on to a ViewConfiguration instance that has a context that is the activity. Observed here: https://github.com/square/leakcanary/issues/1#issuecomment-100324683", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$VIEW_CONFIGURATION__MCONTEXT$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && $this$instanceFieldLeak.getSdkInt() == 19;
                }
            }));
        }
    },
    AUDIO_MANAGER__MCONTEXT_STATIC { // from class: shark.AndroidReferenceMatchers.AUDIO_MANAGER__MCONTEXT_STATIC
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.media.AudioManager", "mContext_static", "Samsung added a static mContext_static field to AudioManager, holds a reference to the activity. Observed here: https://github.com/square/leakcanary/issues/32", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$AUDIO_MANAGER__MCONTEXT_STATIC$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$staticFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$staticFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$staticFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && $this$staticFieldLeak.getSdkInt() == 19;
                }
            }));
        }
    },
    ACTIVITY_MANAGER_MCONTEXT { // from class: shark.AndroidReferenceMatchers.ACTIVITY_MANAGER_MCONTEXT
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.app.ActivityManager", "mContext", "Samsung added a static mContext field to ActivityManager, holds a reference to the activity. Observed here: https://github.com/square/leakcanary/issues/177 Fix in comment: https://github.com/square/leakcanary/issues/177#issuecomment-222724283", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$ACTIVITY_MANAGER_MCONTEXT$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$staticFieldLeak) {
                    int sdkInt;
                    Intrinsics.checkParameterIsNotNull($this$staticFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$staticFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && 22 <= (sdkInt = $this$staticFieldLeak.getSdkInt()) && 23 >= sdkInt;
                }
            }));
        }
    },
    STATIC_MTARGET_VIEW { // from class: shark.AndroidReferenceMatchers.STATIC_MTARGET_VIEW
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.widget.TextView", "mTargetView", "Samsung added a static mTargetView field to TextView which holds on to detached views.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$STATIC_MTARGET_VIEW$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$staticFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$staticFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$staticFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && $this$staticFieldLeak.getSdkInt() == 27;
                }
            }));
        }
    },
    MULTI_WINDOW_DECOR_SUPPORT__MWINDOW { // from class: shark.AndroidReferenceMatchers.MULTI_WINDOW_DECOR_SUPPORT__MWINDOW
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("com.android.internal.policy.MultiWindowDecorSupport", "mWindow", "DecorView isn't leaking but its mDecorViewSupport field holds\na MultiWindowDecorSupport which has a mWindow field which holds a leaking PhoneWindow.\nDecorView.mDecorViewSupport doesn't exist in AOSP.\nFiled here: https://github.com/square/leakcanary/issues/1819", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$MULTI_WINDOW_DECOR_SUPPORT__MWINDOW$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    int sdkInt;
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && 26 <= (sdkInt = $this$instanceFieldLeak.getSdkInt()) && 29 >= sdkInt;
                }
            }));
        }
    },
    IMM_CURRENT_INPUT_CONNECTION { // from class: shark.AndroidReferenceMatchers.IMM_CURRENT_INPUT_CONNECTION
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.inputmethod.InputMethodManager", "mCurrentInputConnection", "InputMethodManager keeps its EditableInputConnection after the activity has been\ndestroyed.\nFiled here: https://github.com/square/leakcanary/issues/2300", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$IMM_CURRENT_INPUT_CONNECTION$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    int sdkInt;
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.SAMSUNG) && 28 <= (sdkInt = $this$instanceFieldLeak.getSdkInt()) && 30 >= sdkInt;
                }
            }));
        }
    },
    GESTURE_BOOST_MANAGER { // from class: shark.AndroidReferenceMatchers.GESTURE_BOOST_MANAGER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.gestureboost.GestureBoostManager", "mContext", "GestureBoostManager is a static singleton that leaks an activity context. Fix: https://github.com/square/leakcanary/issues/696#issuecomment-296420756", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$GESTURE_BOOST_MANAGER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$staticFieldLeak) {
                    int sdkInt;
                    Intrinsics.checkParameterIsNotNull($this$staticFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$staticFieldLeak.getManufacturer(), AndroidReferenceMatchers.HUAWEI) && 24 <= (sdkInt = $this$staticFieldLeak.getSdkInt()) && 25 >= sdkInt;
                }
            }));
        }
    },
    BUBBLE_POPUP_HELPER__SHELPER { // from class: shark.AndroidReferenceMatchers.BUBBLE_POPUP_HELPER__SHELPER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.widget.BubblePopupHelper", "sHelper", "A static helper for EditText bubble popups leaks a reference to the latest focused view.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$BUBBLE_POPUP_HELPER__SHELPER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$staticFieldLeak) {
                    int sdkInt;
                    Intrinsics.checkParameterIsNotNull($this$staticFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$staticFieldLeak.getManufacturer(), AndroidReferenceMatchers.LG) && 19 <= (sdkInt = $this$staticFieldLeak.getSdkInt()) && 22 >= sdkInt;
                }
            }));
        }
    },
    LGCONTEXT__MCONTEXT { // from class: shark.AndroidReferenceMatchers.LGCONTEXT__MCONTEXT
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("com.lge.systemservice.core.LGContext", "mContext", "LGContext is a static singleton that leaks an activity context.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$LGCONTEXT__MCONTEXT$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.LG) && $this$instanceFieldLeak.getSdkInt() == 21;
                }
            }));
        }
    },
    SMART_COVER_MANAGER { // from class: shark.AndroidReferenceMatchers.SMART_COVER_MANAGER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("com.lge.systemservice.core.SmartCoverManager", "mContext", "SmartCoverManager$CallbackRegister is a callback held by a native ref, and SmartCoverManager ends up leaking an activity context.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$SMART_COVER_MANAGER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.LG) && $this$instanceFieldLeak.getSdkInt() == 27;
                }
            }));
        }
    },
    IMM_LAST_FOCUS_VIEW { // from class: shark.AndroidReferenceMatchers.IMM_LAST_FOCUS_VIEW
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.view.inputmethod.InputMethodManager", "mLastFocusView", "InputMethodManager has a mLastFocusView field that doesn't get cleared when the last\nfocused view becomes detached.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$IMM_LAST_FOCUS_VIEW$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.LG) && $this$instanceFieldLeak.getSdkInt() == 29;
                }
            }));
        }
    },
    MAPPER_CLIENT { // from class: shark.AndroidReferenceMatchers.MAPPER_CLIENT
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("com.nvidia.ControllerMapper.MapperClient$ServiceClient", "this$0", "Not sure exactly what ControllerMapper is about, but there is an anonymous Handler in ControllerMapper.MapperClient.ServiceClient, which leaks ControllerMapper.MapperClient which leaks the activity context.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$MAPPER_CLIENT$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.NVIDIA) && $this$instanceFieldLeak.getSdkInt() == 19;
                }
            }));
        }
    },
    SYSTEM_SENSOR_MANAGER__MAPPCONTEXTIMPL { // from class: shark.AndroidReferenceMatchers.SYSTEM_SENSOR_MANAGER__MAPPCONTEXTIMPL
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.hardware.SystemSensorManager", "mAppContextImpl", "SystemSensorManager stores a reference to context in a static field in its constructor. Fix: use application context to get SensorManager", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$SYSTEM_SENSOR_MANAGER__MAPPCONTEXTIMPL$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$staticFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$staticFieldLeak, "$receiver");
                    return (Intrinsics.areEqual($this$staticFieldLeak.getManufacturer(), AndroidReferenceMatchers.LENOVO) && $this$staticFieldLeak.getSdkInt() == 19) || (Intrinsics.areEqual($this$staticFieldLeak.getManufacturer(), AndroidReferenceMatchers.VIVO) && $this$staticFieldLeak.getSdkInt() == 22);
                }
            }));
        }
    },
    INSTRUMENTATION_RECOMMEND_ACTIVITY { // from class: shark.AndroidReferenceMatchers.INSTRUMENTATION_RECOMMEND_ACTIVITY
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.app.Instrumentation", "mRecommendActivity", "Instrumentation would leak com.android.internal.app.RecommendActivity (in framework.jar) in Meizu FlymeOS 4.5 and above, which is based on Android 5.0 and  above", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$INSTRUMENTATION_RECOMMEND_ACTIVITY$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$staticFieldLeak) {
                    int sdkInt;
                    Intrinsics.checkParameterIsNotNull($this$staticFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$staticFieldLeak.getManufacturer(), AndroidReferenceMatchers.MEIZU) && 21 <= (sdkInt = $this$staticFieldLeak.getSdkInt()) && 22 >= sdkInt;
                }
            }));
        }
    },
    DEVICE_POLICY_MANAGER__SETTINGS_OBSERVER { // from class: shark.AndroidReferenceMatchers.DEVICE_POLICY_MANAGER__SETTINGS_OBSERVER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.app.admin.DevicePolicyManager$SettingsObserver", "this$0", "DevicePolicyManager keeps a reference to the context it has been created with instead of extracting the application context. In this Motorola build, DevicePolicyManager has an inner SettingsObserver class that is a content observer, which is held into memory by a binder transport object.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$DEVICE_POLICY_MANAGER__SETTINGS_OBSERVER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    int sdkInt;
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.MOTOROLA) && 19 <= (sdkInt = $this$instanceFieldLeak.getSdkInt()) && 22 >= sdkInt;
                }
            }));
        }
    },
    EXTENDED_STATUS_BAR_MANAGER { // from class: shark.AndroidReferenceMatchers.EXTENDED_STATUS_BAR_MANAGER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.app.ExtendedStatusBarManager", "mContext", "ExtendedStatusBarManager has a mContext field which references a decor context which\nreferences a destroyed activity.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$EXTENDED_STATUS_BAR_MANAGER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.SHARP) && $this$instanceFieldLeak.getSdkInt() >= 30;
                }
            }));
        }
    },
    OEM_SCENE_CALL_BLOCKER { // from class: shark.AndroidReferenceMatchers.OEM_SCENE_CALL_BLOCKER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("com.oneplus.util.OemSceneCallBlocker", "sContext", "OemSceneCallBlocker has a sContext static field which holds on to an activity instance.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$OEM_SCENE_CALL_BLOCKER$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$staticFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$staticFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$staticFieldLeak.getManufacturer(), AndroidReferenceMatchers.ONE_PLUS) && $this$staticFieldLeak.getSdkInt() == 28;
                }
            }));
        }
    },
    PERF_MONITOR_LAST_CALLBACK { // from class: shark.AndroidReferenceMatchers.PERF_MONITOR_LAST_CALLBACK
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.os.PerfMonitor", "mLastCallback", "PerfMonitor has a mLastCallback static field which holds on to View.PerformClick.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$PERF_MONITOR_LAST_CALLBACK$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$staticFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$staticFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$staticFieldLeak.getManufacturer(), AndroidReferenceMatchers.ONE_PLUS) && $this$staticFieldLeak.getSdkInt() == 30;
                }
            }));
        }
    },
    RAZER_TEXT_KEY_LISTENER__MCONTEXT { // from class: shark.AndroidReferenceMatchers.RAZER_TEXT_KEY_LISTENER__MCONTEXT
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.instanceFieldLeak("android.text.method.TextKeyListener", "mContext", "In AOSP, TextKeyListener instances are held in a TextKeyListener.sInstances static\narray. The Razer implementation added a mContext field, creating activity leaks.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$RAZER_TEXT_KEY_LISTENER__MCONTEXT$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$instanceFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$instanceFieldLeak, "$receiver");
                    return Intrinsics.areEqual($this$instanceFieldLeak.getManufacturer(), AndroidReferenceMatchers.RAZER) && $this$instanceFieldLeak.getSdkInt() == 28;
                }
            }));
        }
    },
    XIAMI__RESOURCES_IMPL { // from class: shark.AndroidReferenceMatchers.XIAMI__RESOURCES_IMPL
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.staticFieldLeak("android.content.res.ResourcesImpl", "mAppContext", "A fork of Android added a static mAppContext field to the ResourcesImpl class\nand that field ends up referencing lower contexts (e.g. service). Several Android\nmanufacturers seem to be using the same broken Android fork sources.", new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$XIAMI__RESOURCES_IMPL$add$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
                }

                public final boolean invoke(AndroidBuildMirror $this$staticFieldLeak) {
                    Intrinsics.checkParameterIsNotNull($this$staticFieldLeak, "$receiver");
                    return CollectionsKt.listOf(new String[]{AndroidReferenceMatchers.HMD_GLOBAL, AndroidReferenceMatchers.INFINIX, AndroidReferenceMatchers.LENOVO, AndroidReferenceMatchers.XIAOMI, AndroidReferenceMatchers.TES, AndroidReferenceMatchers.REALME}).contains($this$staticFieldLeak.getManufacturer()) && $this$staticFieldLeak.getSdkInt() >= 30;
                }
            }));
        }
    },
    REFERENCES { // from class: shark.AndroidReferenceMatchers.REFERENCES
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            Companion companion = AndroidReferenceMatchers.Companion;
            String name = WeakReference.class.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "WeakReference::class.java.name");
            list.add(companion.ignoredInstanceField(name, "referent"));
            list.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("leakcanary.KeyedWeakReference", "referent"));
            Companion companion2 = AndroidReferenceMatchers.Companion;
            String name2 = SoftReference.class.getName();
            Intrinsics.checkExpressionValueIsNotNull(name2, "SoftReference::class.java.name");
            list.add(companion2.ignoredInstanceField(name2, "referent"));
            Companion companion3 = AndroidReferenceMatchers.Companion;
            String name3 = PhantomReference.class.getName();
            Intrinsics.checkExpressionValueIsNotNull(name3, "PhantomReference::class.java.name");
            list.add(companion3.ignoredInstanceField(name3, "referent"));
            list.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("java.lang.ref.Finalizer", "prev"));
            list.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("java.lang.ref.Finalizer", "element"));
            list.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("java.lang.ref.Finalizer", "next"));
            list.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("java.lang.ref.FinalizerReference", "prev"));
            list.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("java.lang.ref.FinalizerReference", "element"));
            list.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("java.lang.ref.FinalizerReference", "next"));
            list.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("sun.misc.Cleaner", "prev"));
            list.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("sun.misc.Cleaner", "next"));
        }
    },
    FINALIZER_WATCHDOG_DAEMON { // from class: shark.AndroidReferenceMatchers.FINALIZER_WATCHDOG_DAEMON
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.ignoredJavaLocal("FinalizerWatchdogDaemon"));
        }
    },
    MAIN { // from class: shark.AndroidReferenceMatchers.MAIN
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.ignoredJavaLocal(MainRouteUris.MODULE_MAIN));
        }
    },
    LEAK_CANARY_THREAD { // from class: shark.AndroidReferenceMatchers.LEAK_CANARY_THREAD
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.ignoredJavaLocal(AndroidReferenceMatchers.LEAK_CANARY_THREAD_NAME));
        }
    },
    LEAK_CANARY_HEAP_DUMPER { // from class: shark.AndroidReferenceMatchers.LEAK_CANARY_HEAP_DUMPER
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("leakcanary.internal.InternalLeakCanary", "resumedActivity"));
        }
    },
    LEAK_CANARY_INTERNAL { // from class: shark.AndroidReferenceMatchers.LEAK_CANARY_INTERNAL
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("leakcanary.internal.InternalLeakCanary", "application"));
        }
    },
    EVENT_RECEIVER__MMESSAGE_QUEUE { // from class: shark.AndroidReferenceMatchers.EVENT_RECEIVER__MMESSAGE_QUEUE
        @Override // shark.AndroidReferenceMatchers
        public void add$shark_android(List<ReferenceMatcher> list) {
            Intrinsics.checkParameterIsNotNull(list, "references");
            list.add(AndroidReferenceMatchers.Companion.ignoredInstanceField("android.view.Choreographer$FrameDisplayEventReceiver", "mMessageQueue"));
        }
    };
    
    public static final String HMD_GLOBAL = "HMD Global";
    public static final String HUAWEI = "HUAWEI";
    public static final String INFINIX = "INFINIX";
    private static final String LEAK_CANARY_THREAD_NAME = "LeakCanary-Heap-Dump";
    public static final String LENOVO = "LENOVO";
    public static final String LG = "LGE";
    public static final String MEIZU = "Meizu";
    public static final String MOTOROLA = "motorola";
    public static final String NVIDIA = "NVIDIA";
    public static final String ONE_PLUS = "OnePlus";
    public static final String RAZER = "Razer";
    public static final String REALME = "realme";
    public static final String SAMSUNG = "samsung";
    public static final String SHARP = "SHARP";
    public static final String TES = "TES";
    public static final String VIVO = "vivo";
    public static final String XIAOMI = "Xiaomi";
    public static final Companion Companion = new Companion(null);
    private static final Function1<AndroidBuildMirror, Boolean> ALWAYS = new Function1<AndroidBuildMirror, Boolean>() { // from class: shark.AndroidReferenceMatchers$Companion$ALWAYS$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
        }

        public final boolean invoke(AndroidBuildMirror $receiver) {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            return true;
        }
    };

    @JvmStatic
    public static final List<ReferenceMatcher> buildKnownReferences(Set<? extends AndroidReferenceMatchers> set) {
        return Companion.buildKnownReferences(set);
    }

    public static final List<ReferenceMatcher> getAppDefaults() {
        return Companion.getAppDefaults();
    }

    public static final List<ReferenceMatcher> getIgnoredReferencesOnly() {
        return Companion.getIgnoredReferencesOnly();
    }

    @JvmStatic
    public static final IgnoredReferenceMatcher ignoredInstanceField(String str, String str2) {
        return Companion.ignoredInstanceField(str, str2);
    }

    @JvmStatic
    public static final IgnoredReferenceMatcher ignoredJavaLocal(String str) {
        return Companion.ignoredJavaLocal(str);
    }

    @JvmStatic
    public static final LibraryLeakReferenceMatcher instanceFieldLeak(String str, String str2, String str3, Function1<? super AndroidBuildMirror, Boolean> function1) {
        return Companion.instanceFieldLeak(str, str2, str3, function1);
    }

    @JvmStatic
    public static final LibraryLeakReferenceMatcher nativeGlobalVariableLeak(String str, String str2, Function1<? super AndroidBuildMirror, Boolean> function1) {
        return Companion.nativeGlobalVariableLeak(str, str2, function1);
    }

    @JvmStatic
    public static final LibraryLeakReferenceMatcher staticFieldLeak(String str, String str2, String str3, Function1<? super AndroidBuildMirror, Boolean> function1) {
        return Companion.staticFieldLeak(str, str2, str3, function1);
    }

    public abstract void add$shark_android(List<ReferenceMatcher> list);

    /* synthetic */ AndroidReferenceMatchers(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    /* compiled from: AndroidReferenceMatchers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0007J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0007J\u0010\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\tH\u0007J=\u0010-\u001a\u00020.2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\b\b\u0002\u0010/\u001a\u00020\t2\u0019\b\u0002\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0007J1\u00101\u001a\u00020.2\u0006\u00102\u001a\u0002032\u0006\u0010/\u001a\u00020\t2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0002J5\u00104\u001a\u00020.2\u0006\u0010)\u001a\u00020\t2\b\b\u0002\u0010/\u001a\u00020\t2\u0019\b\u0002\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0007J=\u00105\u001a\u00020.2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\b\b\u0002\u0010/\u001a\u00020\t2\u0019\b\u0002\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0007R\u001f\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0002\u001a\u0004\b\u001e\u0010\u001fR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010\u001f¨\u00066"}, d2 = {"Lshark/AndroidReferenceMatchers$Companion;", "", "()V", "ALWAYS", "Lkotlin/Function1;", "Lshark/AndroidBuildMirror;", "", "Lkotlin/ExtensionFunctionType;", "HMD_GLOBAL", "", AndroidReferenceMatchers.HUAWEI, AndroidReferenceMatchers.INFINIX, "LEAK_CANARY_THREAD_NAME", AndroidReferenceMatchers.LENOVO, "LG", "MEIZU", "MOTOROLA", AndroidReferenceMatchers.NVIDIA, "ONE_PLUS", "RAZER", "REALME", "SAMSUNG", AndroidReferenceMatchers.SHARP, AndroidReferenceMatchers.TES, "VIVO", "XIAOMI", "appDefaults", "", "Lshark/ReferenceMatcher;", "getAppDefaults$annotations", "getAppDefaults", "()Ljava/util/List;", "ignoredReferencesOnly", "getIgnoredReferencesOnly$annotations", "getIgnoredReferencesOnly", "buildKnownReferences", "referenceMatchers", "", "Lshark/AndroidReferenceMatchers;", "ignoredInstanceField", "Lshark/IgnoredReferenceMatcher;", "className", "fieldName", "ignoredJavaLocal", "threadName", "instanceFieldLeak", "Lshark/LibraryLeakReferenceMatcher;", "description", "patternApplies", "libraryLeak", "referencePattern", "Lshark/ReferencePattern;", "nativeGlobalVariableLeak", "staticFieldLeak", "shark-android"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        @JvmStatic
        public static /* synthetic */ void getAppDefaults$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getIgnoredReferencesOnly$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final List<ReferenceMatcher> getIgnoredReferencesOnly() {
            Companion companion = AndroidReferenceMatchers.Companion;
            EnumSet of = EnumSet.of(AndroidReferenceMatchers.REFERENCES, AndroidReferenceMatchers.FINALIZER_WATCHDOG_DAEMON, AndroidReferenceMatchers.MAIN, AndroidReferenceMatchers.LEAK_CANARY_THREAD, AndroidReferenceMatchers.EVENT_RECEIVER__MMESSAGE_QUEUE);
            Intrinsics.checkExpressionValueIsNotNull(of, "EnumSet.of(\n          RE…_MMESSAGE_QUEUE\n        )");
            return companion.buildKnownReferences(of);
        }

        public final List<ReferenceMatcher> getAppDefaults() {
            Companion companion = AndroidReferenceMatchers.Companion;
            EnumSet allOf = EnumSet.allOf(AndroidReferenceMatchers.class);
            Intrinsics.checkExpressionValueIsNotNull(allOf, "EnumSet.allOf(AndroidRef…enceMatchers::class.java)");
            return companion.buildKnownReferences(allOf);
        }

        @JvmStatic
        public final List<ReferenceMatcher> buildKnownReferences(Set<? extends AndroidReferenceMatchers> set) {
            Intrinsics.checkParameterIsNotNull(set, "referenceMatchers");
            List resultSet = new ArrayList();
            Set<? extends AndroidReferenceMatchers> $this$forEach$iv = set;
            for (Object element$iv : $this$forEach$iv) {
                AndroidReferenceMatchers it = (AndroidReferenceMatchers) element$iv;
                it.add$shark_android(resultSet);
            }
            return resultSet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LibraryLeakReferenceMatcher staticFieldLeak$default(Companion companion, String str, String str2, String str3, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = "";
            }
            if ((i & 8) != 0) {
                function1 = AndroidReferenceMatchers.ALWAYS;
            }
            return companion.staticFieldLeak(str, str2, str3, function1);
        }

        @JvmStatic
        public final LibraryLeakReferenceMatcher staticFieldLeak(String className, String fieldName, String description, Function1<? super AndroidBuildMirror, Boolean> function1) {
            Intrinsics.checkParameterIsNotNull(className, "className");
            Intrinsics.checkParameterIsNotNull(fieldName, "fieldName");
            Intrinsics.checkParameterIsNotNull(description, "description");
            Intrinsics.checkParameterIsNotNull(function1, "patternApplies");
            return libraryLeak(new ReferencePattern.StaticFieldPattern(className, fieldName), description, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LibraryLeakReferenceMatcher instanceFieldLeak$default(Companion companion, String str, String str2, String str3, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = "";
            }
            if ((i & 8) != 0) {
                function1 = AndroidReferenceMatchers.ALWAYS;
            }
            return companion.instanceFieldLeak(str, str2, str3, function1);
        }

        @JvmStatic
        public final LibraryLeakReferenceMatcher instanceFieldLeak(String className, String fieldName, String description, Function1<? super AndroidBuildMirror, Boolean> function1) {
            Intrinsics.checkParameterIsNotNull(className, "className");
            Intrinsics.checkParameterIsNotNull(fieldName, "fieldName");
            Intrinsics.checkParameterIsNotNull(description, "description");
            Intrinsics.checkParameterIsNotNull(function1, "patternApplies");
            return libraryLeak(new ReferencePattern.InstanceFieldPattern(className, fieldName), description, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LibraryLeakReferenceMatcher nativeGlobalVariableLeak$default(Companion companion, String str, String str2, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "";
            }
            if ((i & 4) != 0) {
                function1 = AndroidReferenceMatchers.ALWAYS;
            }
            return companion.nativeGlobalVariableLeak(str, str2, function1);
        }

        @JvmStatic
        public final LibraryLeakReferenceMatcher nativeGlobalVariableLeak(String className, String description, Function1<? super AndroidBuildMirror, Boolean> function1) {
            Intrinsics.checkParameterIsNotNull(className, "className");
            Intrinsics.checkParameterIsNotNull(description, "description");
            Intrinsics.checkParameterIsNotNull(function1, "patternApplies");
            return libraryLeak(new ReferencePattern.NativeGlobalVariablePattern(className), description, function1);
        }

        private final LibraryLeakReferenceMatcher libraryLeak(ReferencePattern referencePattern, String description, final Function1<? super AndroidBuildMirror, Boolean> function1) {
            return new LibraryLeakReferenceMatcher(referencePattern, description, new Function1<HeapGraph, Boolean>() { // from class: shark.AndroidReferenceMatchers$Companion$libraryLeak$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((HeapGraph) obj));
                }

                public final boolean invoke(HeapGraph graph) {
                    Intrinsics.checkParameterIsNotNull(graph, "graph");
                    return ((Boolean) function1.invoke(AndroidBuildMirror.Companion.fromHeapGraph(graph))).booleanValue();
                }
            });
        }

        @JvmStatic
        public final IgnoredReferenceMatcher ignoredInstanceField(String className, String fieldName) {
            Intrinsics.checkParameterIsNotNull(className, "className");
            Intrinsics.checkParameterIsNotNull(fieldName, "fieldName");
            return new IgnoredReferenceMatcher(new ReferencePattern.InstanceFieldPattern(className, fieldName));
        }

        @JvmStatic
        public final IgnoredReferenceMatcher ignoredJavaLocal(String threadName) {
            Intrinsics.checkParameterIsNotNull(threadName, "threadName");
            return new IgnoredReferenceMatcher(new ReferencePattern.JavaLocalPattern(threadName));
        }
    }
}