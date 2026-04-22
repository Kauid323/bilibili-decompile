package tv.danmaku.bili;

import com.bilibili.ad.adview.pegasus.di.AdHolderModule;
import com.bilibili.ad.adview.pegasus.di.AdPluginModule;
import com.bilibili.app.history.HistoryFragmentV3_GeneratedInjector;
import com.bilibili.bililive.card.LiveCardComponent;
import com.bilibili.bililive.card.LiveCardEntryPoint;
import com.bilibili.bililive.card.LiveCardScope;
import com.bilibili.bililive.room.di.RoomComponent;
import com.bilibili.bililive.room.di.RoomContainerComponent;
import com.bilibili.bililive.room.di.RoomContainerScoped;
import com.bilibili.bililive.room.di.RoomScoped;
import com.bilibili.biz.community.common.impl.editior.EditorArchivesUploadObserverModule;
import com.bilibili.bplus.followinglist.home.DynamicHomeTabFragment_GeneratedInjector;
import com.bilibili.bplus.followinglist.page.browser.di.LightBrowserModule;
import com.bilibili.bplus.followinglist.page.browser.painting.BrowserPaintingFragment_GeneratedInjector;
import com.bilibili.bplus.followinglist.page.browser.ui.LightBrowserActivityV2_GeneratedInjector;
import com.bilibili.bplus.followinglist.page.opus.BaseOpusDetailComponentsFragment_GeneratedInjector;
import com.bilibili.bplus.followinglist.page.opus.OpusDetailFragment_GeneratedInjector;
import com.bilibili.bplus.followinglist.page.opus.manga.MangaPopupViewModel_HiltModules;
import com.bilibili.bplus.followinglist.page.opus.manga.usecase.UseCaseModule;
import com.bilibili.bplus.im.badge.SessionBadgeNotifierModule;
import com.bilibili.bplus.im.communication.HuahuoModule;
import com.bilibili.bplus.im.communication.IMUIModule;
import com.bilibili.bplus.im.contacts.ContactFragment_GeneratedInjector;
import com.bilibili.bplus.im.contacts.ContactModule;
import com.bilibili.bplus.im.customer.CustomerConversationActivity_GeneratedInjector;
import com.bilibili.bplus.im.customer.CustomerConversationViewModel_HiltModules;
import com.bilibili.bplus.im.customer.di.CustomerModule;
import com.bilibili.bplus.im.customer.di.CustomerSettingFragmentModule;
import com.bilibili.bplus.im.customer.settings.CustomerSettingFragment_GeneratedInjector;
import com.bilibili.bplus.im.customer.settings.CustomerSettingViewModel_HiltModules;
import com.bilibili.bplus.im.provider.IMGameButtonModule;
import com.bilibili.bplus.im.provider.VipNameColorParserModule;
import com.bilibili.bplus.privateletter.notification.NotificationModule;
import com.bilibili.bplus.privateletter.notification.ui.NotificationPageFragment_GeneratedInjector;
import com.bilibili.bplus.privateletter.notification.ui.NotificationViewModel_HiltModules;
import com.bilibili.comm.charge.kmmsupport.ChargeEventFlowModule;
import com.bilibili.common.charge.ChargeEventEntryPoint;
import com.bilibili.common.fallbackcache.di.FallbackCacheModule;
import com.bilibili.common.paragraph.builder.ParagraphEntryPoint;
import com.bilibili.common.paragraph.builder.ParagraphModule;
import com.bilibili.compose.theme.GarbObserverEntryPoint;
import com.bilibili.compose.theme.ThemeDayNightObserverEntryPoint;
import com.bilibili.digital.card.kmmsupport.AddCustomSplashModule;
import com.bilibili.digital.card.kmmsupport.AvatarChooserModule;
import com.bilibili.digital.card.kmmsupport.AvatarUploaderModule;
import com.bilibili.digital.card.kmmsupport.DigitalSaveModule;
import com.bilibili.digital.card.kmmsupport.ReshapingModule;
import com.bilibili.digital.card.kmmsupport.ShareCardModule;
import com.bilibili.digital.card.kmmsupport.SmeltCardContentModule;
import com.bilibili.digital.card.kmmsupport.WallpaperSetting;
import com.bilibili.emoticon.EmoticonPanelEntryPoint;
import com.bilibili.emoticon.impl.EmoticonCacheEntryPoint;
import com.bilibili.emoticon.impl.EmoticonPanelModule;
import com.bilibili.gripper.container.bpush.GPushFetcher;
import com.bilibili.gripper.container.laser.GLaserFetcher;
import com.bilibili.gripper.container.network.httpdns.multiselector.SelectedHttpDnsFetcher;
import com.bilibili.gripper.container.riskcontrol.GRiskControlFetcher;
import com.bilibili.gripper.dokit.webview.WebDemoKitActivity_GeneratedInjector;
import com.bilibili.gripper.update.GUpdaterFetcher;
import com.bilibili.ktor.KtorEntryPoint;
import com.bilibili.lib.brouter.api.BRouterComponent;
import com.bilibili.lib.brouter.api.BRouterScope;
import com.bilibili.lib.brouter.core.BRouterComponentEntryPoint;
import com.bilibili.lib.gripper.core.internal.hiltlike.BootstrapModule0;
import com.bilibili.lib.gripper.core.internal.hiltlike.BootstrapModule1;
import com.bilibili.lib.gripper.core.internal.hiltlike.SettingsFetcher;
import com.bilibili.lib.ui.ComposeActivity_GeneratedInjector;
import com.bilibili.lib.ui.DialogContainerActivity_GeneratedInjector;
import com.bilibili.lib.ui.GeneralActivity_GeneratedInjector;
import com.bilibili.ogv.bpf.community.CommunityStateEntryPoint;
import com.bilibili.ogv.bpf.community.EmptyCommunityStateHelperModule;
import com.bilibili.ogv.kmm.operation.inlinevideo.InlineVideoComponentEntryPoint;
import com.bilibili.ogv.operation2.InlineVideoComponentModule;
import com.bilibili.pegasus.PegasusFragment_GeneratedInjector;
import com.bilibili.pegasus.components.interest.ui.udf.handlers.ReducerModules;
import com.bilibili.pegasus.components.interest.ui.udf.log.InterestLogModule;
import com.bilibili.pegasus.components.interest.ui.v31.page.InterestChooseV31Dialog_GeneratedInjector;
import com.bilibili.pegasus.components.interest.ui.v31.vm.InterestChooseV31PageViewModel_HiltModules;
import com.bilibili.pegasus.components.interest.ui.v32.page.InterestChooseV32Dialog_GeneratedInjector;
import com.bilibili.pegasus.components.interest.ui.v32.vm.InterestChooseV32PageViewModel_HiltModules;
import com.bilibili.pegasus.di.HolderInfoModule;
import com.bilibili.pegasus.di.PageComponentsModule;
import com.bilibili.pegasus.holders.SmallCoverV2ImagePreloaderModule;
import com.bilibili.pegasus.hot.tab.IndexHotFragment_GeneratedInjector;
import com.bilibili.pegasus.page.BasePegasusFragment_GeneratedInjector;
import com.bilibili.pegasus.test.TestPageComponentsModule;
import com.bilibili.pegasus.vm.PegasusViewModel_HiltModules;
import com.bilibili.playset.editor.PlaySetEditorFragmentV2_GeneratedInjector;
import com.bilibili.playset.editor.PlaySetEditorViewModel_HiltModules;
import com.bilibili.playset.editor.di.ServiceProvider;
import com.bilibili.playset.playlist.search2.CollectionSearchActivity_GeneratedInjector;
import com.bilibili.playset.playlist.search2.CollectionSearchResultFragment_GeneratedInjector;
import com.bilibili.playset.playlist.search2.CollectionSearchViewModel_HiltModules;
import com.bilibili.playset.playlist.search2.di.CollectionSearchModule;
import com.bilibili.ship.theseus.detail.UnitedBizDetailsActivity_GeneratedInjector;
import com.bilibili.ship.theseus.detail.di.InstallPageServiceComponent;
import com.bilibili.ship.theseus.ogv.videocard.OgvVideoCardApiServiceModule;
import com.bilibili.ship.theseus.playlist.UnitedPlaylistActivity_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.BiliEditorMainActivity_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.BiliEditorTtsFragmentV2_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.batchedit.BiliEditorCaptionEditFragmentV3_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.batchedit.BiliEditorStickerBatchEditFragmentV3_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.v4.BiliEditorCaptionAnimationListV4Fragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.v4.BiliEditorCaptionAnimationV4Fragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.v4.BiliEditorCaptionFlowerV4Fragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.v4.BiliEditorCaptionFontV4Fragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.v4.BiliEditorCaptionSettingV4Fragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.v4.BiliEditorCaptionStyleV4Fragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.v4.BiliEditorCaptionTemplateListV4Fragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.v4.BiliEditorCaptionTemplateV4Fragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.vm.BiliEditorCaptionAnimationListViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.vm.BiliEditorCaptionAnimationViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.vm.BiliEditorCaptionEditViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.vm.BiliEditorCaptionFlowerViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.vm.BiliEditorCaptionFontViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.vm.BiliEditorCaptionSettingViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.vm.BiliEditorCaptionStyleViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.vm.BiliEditorCaptionTemplateListViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.vm.BiliEditorCaptionTtsViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.caption.vm.BiliEditorStickerBatchEditViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.clip.BiliEditorClipVolumeFragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.clip.BiliEditorSpeedFragmentV3_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.clip.viewmodel.BiliEditorSpeedViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.clip.viewmodel.BiliEditorVolumeViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.filter.BiliEditorChildAdjustFragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.filter.BiliEditorChildFilterFragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.filter.BiliEditorFilterFragmentV4_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.filter.vm.BiliEditorChildAdjustViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.filter.vm.BiliEditorChildFilterViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.filter.vm.BiliEditorFilterViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.music.ui.BiliEditorMusicChangeStartFragmentV5_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.music.ui.BiliEditorMusicFadeFragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.music.ui.BiliEditorMusicLoadingFragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.music.ui.BiliEditorMusicVolumeFragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.music.viewmodel.BiliEditorMusicChangeStartViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.music.viewmodel.BiliEditorMusicFadeViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.music.viewmodel.BiliEditorMusicLoadingViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.music.viewmodel.BiliEditorMusicVolumeViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.picture.BiliEditorPictureFragmentV3_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.picture.vm.BiliEditorPictureViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.record.fragment.BiliEditorRecordVoiceFragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.record.fragment.BiliEditorRecordVolumeFragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.record.fragment.BiliMainEditorRecordFragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.record.vm.EditorRecordViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.record.vm.EditorRecordVoiceViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.record.vm.EditorRecordVolumeViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.sticker.BiliEditorStickerListFragment_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.sticker.vm.BiliEditorStickerListViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.transition.BiliEditorTransitionFragmentV2_GeneratedInjector;
import com.bilibili.studio.editor.moudle.editormain.ui.fragments.transition.BiliEditorTransitionViewModel_HiltModules;
import com.bilibili.studio.editor.moudle.editormain.viewmodel.BiliEditorMainViewModel_HiltModules;
import com.bilibili.tensorflow.service.OGVTensorFlowServiceModule;
import com.bilibili.tribe.extra.gripper.GripperDynamicRuleModule;
import com.bilibili.videoshortcut.sidecenter.HomeSideCenterModule;
import com.bilibili.videoshortcut.sidecenter.setting.HomeSideCenterSettingFragment_GeneratedInjector;
import com.bilibili.videoshortcut.sidecenter.setting.HomeSideCenterSettingViewModel_HiltModules;
import com.mall.videodetail.vd.all.MallVideoDetailActivity_GeneratedInjector;
import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Subcomponent;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.flags.FragmentGetContextFix;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_DefaultViewModelFactories_ActivityModule;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ViewModelModule;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_LifecycleModule;
import dagger.hilt.android.internal.managers.HiltWrapper_SavedStateHandleModule;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.HiltWrapper_ActivityModule;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedComponent;
import gripper.processor.internal.componentmapping.codegen.ActivityRetained_GripperMapping;
import gripper.processor.internal.componentmapping.codegen.Activity_GripperMapping;
import gripper.processor.internal.componentmapping.codegen.BRouter_GripperMapping;
import gripper.processor.internal.componentmapping.codegen.Fragment_GripperMapping;
import gripper.processor.internal.componentmapping.codegen.LiveCard_Gripper;
import gripper.processor.internal.componentmapping.codegen.RoomContainer_Gripper;
import gripper.processor.internal.componentmapping.codegen.Room_Gripper;
import gripper.processor.internal.componentmapping.codegen.Service_GripperMapping;
import gripper.processor.internal.componentmapping.codegen.Singleton_GripperMapping;
import gripper.processor.internal.componentmapping.codegen.ViewModel_GripperMapping;
import gripper.processor.internal.componentmapping.codegen.ViewWithFragment_GripperMapping;
import gripper.processor.internal.componentmapping.codegen.View_GripperMapping;
import gripper.processor.internal.modules.Root;
import gripper.processor.internal.modules.bundle.Account;
import gripper.processor.internal.modules.bundle.Adbiz;
import gripper.processor.internal.modules.bundle.Adcore;
import gripper.processor.internal.modules.bundle.Adreward;
import gripper.processor.internal.modules.bundle.Apm;
import gripper.processor.internal.modules.bundle.Bpay;
import gripper.processor.internal.modules.bundle.CoreReport;
import gripper.processor.internal.modules.bundle.Devicedecision;
import gripper.processor.internal.modules.bundle.Downloader;
import gripper.processor.internal.modules.bundle.Facialrecognitiontribetenc;
import gripper.processor.internal.modules.bundle.Image;
import gripper.processor.internal.modules.bundle.ImageDynamic;
import gripper.processor.internal.modules.bundle.Laser;
import gripper.processor.internal.modules.bundle.Liveroom;
import gripper.processor.internal.modules.bundle.Location;
import gripper.processor.internal.modules.bundle.Mod;
import gripper.processor.internal.modules.bundle.NetExt;
import gripper.processor.internal.modules.bundle.Neuron;
import gripper.processor.internal.modules.bundle.Patch;
import gripper.processor.internal.modules.bundle.Push;
import gripper.processor.internal.modules.bundle.Riskcontrol;
import gripper.processor.internal.modules.bundle.Share;
import gripper.processor.internal.modules.bundle.Updater;
import gripper.processor.internal.modules.bundle.Webview;
import im.base.EmptyIdModule;
import im.base.IMTotalUnreadBroadcastPoint;
import im.base.config.IMConfigSettingModule;
import im.base.config.IMConfigSettingProviderModule;
import im.base.model.VipNameColorEntryPoint;
import im.contact.di.IMContactEntryPoint;
import im.contact.di.IMContactModule;
import im.keywordBlocking.di.KBEntryPoint;
import im.keywordBlocking.di.KBModule;
import im.provided.DefaultModule;
import im.provided.IMProvidedUIEntryPoint;
import im.session.di.IMSessionEntryPoint;
import im.session.di.IMSessionModule;
import im.session.home.MainPopupCheckerModule;
import im.session.observer.DefaultSessionObserverModule;
import im.session.summary.IMSessionDraftServiceModule;
import im.setting.di.SettingEntryPoint;
import im.setting.di.SettingModule;
import javax.inject.Singleton;
import kntr.app.deepsearch.di.DeepSearchEntryPoint;
import kntr.app.deepsearch.di.DeepSearchModule;
import kntr.app.deepsearch.history.di.DSHistoryEntryPoint;
import kntr.app.deepsearch.history.di.DSHistoryModule;
import kntr.app.deepsearch.ui.paragraph.DeepSearchParagraphEntryPoint;
import kntr.app.deepsearch.ui.paragraph.DeepSearchParagraphModule;
import kntr.app.digital.preview.avatarchoose.AvatarChooserEntryPoint;
import kntr.app.digital.preview.card.web.SmeltCardContentEntryPoint;
import kntr.app.digital.preview.reshaping.ReshapeEntryPoint;
import kntr.app.digital.preview.save.SaveEntryPoint;
import kntr.app.digital.preview.share.SharePoint;
import kntr.app.digital.preview.splashsetting.AddCustomSplashEntryPoint;
import kntr.app.digital.preview.usage.UploadAvatarEntryPoint;
import kntr.app.digital.preview.wallpaper.SetWallpaperEntryPoint;
import kntr.app.game.base.bridge.GameRouterEntryPoint;
import kntr.app.game.base.bridge.KntrGameBookModule;
import kntr.app.game.base.bridge.KntrGameBookServiceEntryPoint;
import kntr.app.game.base.bridge.KntrGameFollowModule;
import kntr.app.game.base.bridge.KntrGameFollowServiceEntryPoint;
import kntr.app.game.base.bridge.KntrGamePayModule;
import kntr.app.game.base.bridge.KntrGamePayServiceEntryPoint;
import kntr.app.game.base.bridge.KntrGameReportModule;
import kntr.app.game.base.bridge.KntrGameReportServiceEntryPoint;
import kntr.app.game.base.bridge.KntrGameRouterModule;
import kntr.app.game.base.bridge.KntrGameTeenagerModeEntryPoint;
import kntr.app.game.base.bridge.KntrGameTeenagerModule;
import kntr.app.game.base.ui.container.GameComposableAsPageModule;
import kntr.app.game.base.ui.container.GameComposeContainerStyleEntryPoint;
import kntr.app.game.base.ui.container.GameComposeContainerStyleModule;
import kntr.app.game.downloader.KntrGameDownloaderEntryPoint;
import kntr.app.game.downloader.KntrGameDownloaderModule;
import kntr.app.game.report.BiligameReporterEntryPoint;
import kntr.app.game.report.GameKntrModule;
import kntr.app.im.chat.db.di.ChatDatabaseConfigModule;
import kntr.app.im.chat.di.AssistantChatEntryPoint;
import kntr.app.im.chat.di.PrivateChatEntryPoint;
import kntr.app.im.chat.di.module.assistant.AssistantSessionConverterModule;
import kntr.app.im.chat.di.module.personal.PersonalSessionConverterModule;
import kntr.app.im.chat.service.sender.image.LocalImageAssetAndroidModule;
import kntr.app.im.chat.service.sender.image.LocalImageAssetModule;
import kntr.app.im.chat.sticker.asset.StickerAssetAndroidModule;
import kntr.app.im.chat.sticker.asset.StickerAssetModule;
import kntr.app.im.chat.sticker.di.StickerEntryPoint;
import kntr.app.im.chat.sticker.di.StickerModule;
import kntr.app.im.chat.sticker.di.StickerServiceModule;
import kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableParagraphEntryPoint;
import kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableParagraphModule;
import kntr.app.im.chat.ui.page.assistant.AssistantChatPageModule;
import kntr.app.im.chat.ui.page.assistant.AssistantEntryPoint;
import kntr.app.im.chat.ui.page.personal.PersonalChatEntryPoint;
import kntr.app.im.chat.ui.page.personal.PersonalChatPageModule;
import kntr.app.im.chat.ui.paragraph.ImParagraphEntryPoint;
import kntr.app.im.chat.ui.paragraph.ImParagraphModule;
import kntr.app.tribee.consume.viewmodel.TribeeHomeEntryPoint;
import kntr.app.tribee.consume.viewmodel.TribeeHomeModule;
import kntr.app.tribee.invite.viewmodel.TribeeInviteEntryPoint;
import kntr.app.tribee.invite.viewmodel.TribeeInviteModule;
import kntr.app.tribee.operation.viewmodel.TribeeOperationEntryPoint;
import kntr.app.tribee.operation.viewmodel.TribeeOperationModule;
import kntr.app.tribee.publish.core.v2.di.create.TribeePublishCreateComponentEntryPoint;
import kntr.app.tribee.publish.core.v2.di.edit.TribeePublishEditComponentEntryPoint;
import kntr.app.tribee.repost.viewmodel.TribeeRepostEntryPoint;
import kntr.app.tribee.repost.viewmodel.TribeeRepostModule;
import kntr.app.tribee.steam.viewmodel.TribeeSteamEntryPoint;
import kntr.app.tribee.steam.viewmodel.TribeeSteamModule;
import kntr.base.KDownloader.KDownloader.IDownloaderEntryPoint;
import kntr.base.account.AccountEntryPoint;
import kntr.base.appinfo.AppInfoEntryPoint;
import kntr.base.appinfo.PackageInfoEntryPoint;
import kntr.base.brotli.BrotliEntryPoint;
import kntr.base.clipboard.ClipboardEntryPoint;
import kntr.base.clipboard.ClipboardModule;
import kntr.base.device.DeviceEntryPoint;
import kntr.base.moss.MossEntryPoint;
import kntr.base.neuron.NeuronEntryPoint;
import kntr.base.reachability.ReachabilityEntryPoint;
import kntr.base.router.di.RouterEntryPoint;
import kntr.base.upos.UpOSEntryPoint;
import kntr.base.utils.foundation.AppDirEntrypoint;
import kntr.base.utils.foundation.AppDirectoryModule;
import kntr.common.behavior.prediction.BehaviorPredictionEntryPoint;
import kntr.common.compose.launcher.ComposableAsPageModule;
import kntr.common.compose.launcher.ComposeContainerStyleEntryPoint;
import kntr.common.compose.launcher.ComposeContainerStyleModule;
import kntr.common.language.settings.LanguageSettingsEntryPoint;
import kntr.common.legacy.router.AndroidLegacyRouterModule;
import kntr.common.opus.card.OpusCardComposeViewProviderEntryPoint;
import kntr.common.paragraph.assetuploader.di.AssetUploaderEntryPoint;
import kntr.common.paragraph.assetuploader.di.AssetUploaderModule;
import kntr.common.photonic.aphro.core.AphroEntryPoint;
import kntr.common.photonic.aphro.core.AphroStateMachineEntryPoint;
import kntr.common.photonic.aphro.ui.preview.model.PreviewAssetModule;
import kntr.common.photonic.aphro.ui.preview.model.WebAssetModule;
import kntr.common.photonic.compressor.EmptyAssetCompressorHolderModule;
import kntr.common.photonic.di.AssetEntryPoint;
import kntr.common.photonic.finder.EmptyAssetFinderHolderModule;
import kntr.common.photonic.gallery.asset.AndroidGalleryImageAssetModule;
import kntr.common.photonic.shower.EmptyAssetShowerHolderModule;
import kntr.common.pv.EmptyModelModule;
import kntr.common.pv.EmptyTrackerModelModule;
import kntr.common.pv.PvReporterEntryPoint;
import kntr.common.pv.PvTrackerEntryPoint;
import kntr.common.restricted.RestrictedModeEntryPoint;
import kntr.common.router.GlobalRouterEntryPoint;
import kntr.common.router.GlobalRouterModule;
import kntr.common.share.common.ui.GShareEntryPoint;
import tv.danmaku.bili.appwidget.AddWidgetModule;
import tv.danmaku.bili.fullscreen.CountryCodeSelectActivity_GeneratedInjector;
import tv.danmaku.bili.fullscreen.FullscreenLoginActivity_GeneratedInjector;
import tv.danmaku.bili.fullscreen.FullscreenLoginViewModel_HiltModules;
import tv.danmaku.bili.fullscreen.service.ViewModelModule;
import tv.danmaku.bili.inner.InnerLoginFragment_GeneratedInjector;
import tv.danmaku.bili.inner.InnerLoginViewModel_HiltModules;
import tv.danmaku.bili.july2025.GrowthModule;
import tv.danmaku.bili.stepbystep.StepByStepBottomSheetLoginActivity_GeneratedInjector;
import tv.danmaku.bili.stepbystep.StepByStepLoginViewModel_HiltModules;
import tv.danmaku.bili.stepbystep.StepByStepSmsLoginActivity_GeneratedInjector;
import tv.danmaku.bili.ui.loginv2.LoginOriginalActivityV2_GeneratedInjector;
import video.interfacee.bridge.dolbyReporrt.DolbyReportEntryPoint;
import video.interfacee.bridge.freeBandwidth.FreeBandwidthEntryPoint;
import video.interfacee.bridge.history.MediaHistoryEntryPoint;
import video.interfacee.bridge.ogv.OGVBridgeEntryPoint;
import video.interfacee.bridge.settings.KDownloadSettingsEntryPoint;

public final class HiltApplication_HiltComponents {

    @Subcomponent(modules = {Activity_GripperMapping.class, FragmentCBuilderModule.class, ViewCBuilderModule.class, HiltWrapper_ActivityModule.class, HiltWrapper_DefaultViewModelFactories_ActivityModule.class, LightBrowserModule.class, Root.ActivityModule.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class ActivityC implements LightBrowserActivityV2_GeneratedInjector, CustomerConversationActivity_GeneratedInjector, WebDemoKitActivity_GeneratedInjector, ComposeActivity_GeneratedInjector, DialogContainerActivity_GeneratedInjector, GeneralActivity_GeneratedInjector, CollectionSearchActivity_GeneratedInjector, UnitedBizDetailsActivity_GeneratedInjector, UnitedPlaylistActivity_GeneratedInjector, BiliEditorMainActivity_GeneratedInjector, MallVideoDetailActivity_GeneratedInjector, ActivityComponent, DefaultViewModelFactories.ActivityEntryPoint, HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint, FragmentComponentManager.FragmentComponentBuilderEntryPoint, ViewComponentManager.ViewComponentBuilderEntryPoint, GeneratedComponent, Activity_GripperMapping.GripperFetcher, MainActivityV2_GeneratedInjector, CountryCodeSelectActivity_GeneratedInjector, FullscreenLoginActivity_GeneratedInjector, StepByStepBottomSheetLoginActivity_GeneratedInjector, StepByStepSmsLoginActivity_GeneratedInjector, LoginOriginalActivityV2_GeneratedInjector {

        @Subcomponent.Builder
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        interface Builder extends ActivityComponentBuilder {
        }
    }

    @Module(subcomponents = {ActivityC.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    interface ActivityCBuilderModule {
        @Binds
        ActivityComponentBuilder bind(ActivityC.Builder builder);
    }

    @Subcomponent(modules = {ActivityRetained_GripperMapping.class, BiliEditorCaptionAnimationListViewModel_HiltModules.KeyModule.class, BiliEditorCaptionAnimationViewModel_HiltModules.KeyModule.class, BiliEditorCaptionEditViewModel_HiltModules.KeyModule.class, BiliEditorCaptionFlowerViewModel_HiltModules.KeyModule.class, BiliEditorCaptionFontViewModel_HiltModules.KeyModule.class, BiliEditorCaptionSettingViewModel_HiltModules.KeyModule.class, BiliEditorCaptionStyleViewModel_HiltModules.KeyModule.class, BiliEditorCaptionTemplateListViewModel_HiltModules.KeyModule.class, BiliEditorCaptionTtsViewModel_HiltModules.KeyModule.class, BiliEditorChildAdjustViewModel_HiltModules.KeyModule.class, BiliEditorChildFilterViewModel_HiltModules.KeyModule.class, BiliEditorFilterViewModel_HiltModules.KeyModule.class, BiliEditorMainViewModel_HiltModules.KeyModule.class, BiliEditorMusicChangeStartViewModel_HiltModules.KeyModule.class, BiliEditorMusicFadeViewModel_HiltModules.KeyModule.class, BiliEditorMusicLoadingViewModel_HiltModules.KeyModule.class, BiliEditorMusicVolumeViewModel_HiltModules.KeyModule.class, BiliEditorPictureViewModel_HiltModules.KeyModule.class, BiliEditorSpeedViewModel_HiltModules.KeyModule.class, BiliEditorStickerBatchEditViewModel_HiltModules.KeyModule.class, BiliEditorStickerListViewModel_HiltModules.KeyModule.class, BiliEditorTransitionViewModel_HiltModules.KeyModule.class, BiliEditorVolumeViewModel_HiltModules.KeyModule.class, CollectionSearchViewModel_HiltModules.KeyModule.class, CustomerConversationViewModel_HiltModules.KeyModule.class, CustomerSettingViewModel_HiltModules.KeyModule.class, EditorRecordViewModel_HiltModules.KeyModule.class, EditorRecordVoiceViewModel_HiltModules.KeyModule.class, EditorRecordVolumeViewModel_HiltModules.KeyModule.class, FullscreenLoginViewModel_HiltModules.KeyModule.class, ActivityCBuilderModule.class, ViewModelCBuilderModule.class, HiltWrapper_ActivityRetainedComponentManager_LifecycleModule.class, HiltWrapper_SavedStateHandleModule.class, HomeSideCenterSettingViewModel_HiltModules.KeyModule.class, InnerLoginViewModel_HiltModules.KeyModule.class, InterestChooseV31PageViewModel_HiltModules.KeyModule.class, InterestChooseV32PageViewModel_HiltModules.KeyModule.class, MangaPopupViewModel_HiltModules.KeyModule.class, NotificationViewModel_HiltModules.KeyModule.class, PegasusViewModel_HiltModules.KeyModule.class, PlaySetEditorViewModel_HiltModules.KeyModule.class, Root.ActivityRetainedModule.class, StepByStepLoginViewModel_HiltModules.KeyModule.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class ActivityRetainedC implements ActivityRetainedComponent, ActivityComponentManager.ActivityComponentBuilderEntryPoint, HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint, GeneratedComponent, ActivityRetained_GripperMapping.GripperFetcher {

        @Subcomponent.Builder
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        interface Builder extends ActivityRetainedComponentBuilder {
        }
    }

    @Module(subcomponents = {ActivityRetainedC.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    interface ActivityRetainedCBuilderModule {
        @Binds
        ActivityRetainedComponentBuilder bind(ActivityRetainedC.Builder builder);
    }

    @BRouterScope
    @Subcomponent(modules = {BRouter_GripperMapping.class, Root.BRouterModule.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class BRouterC implements BRouterComponent, GeneratedComponent, BRouter_GripperMapping.GripperFetcher {

        @Subcomponent.Builder
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        interface Builder extends BRouterComponent.Builder {
        }
    }

    @Module(subcomponents = {BRouterC.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    interface BRouterCBuilderModule {
        @Binds
        BRouterComponent.Builder bind(BRouterC.Builder builder);
    }

    @Subcomponent(modules = {AdPluginModule.class, ContactModule.class, CustomerSettingFragmentModule.class, Fragment_GripperMapping.class, ViewWithFragmentCBuilderModule.class, PageComponentsModule.class, Root.FragmentModule.class, SmallCoverV2ImagePreloaderModule.class, TestPageComponentsModule.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class FragmentC implements HistoryFragmentV3_GeneratedInjector, DynamicHomeTabFragment_GeneratedInjector, BrowserPaintingFragment_GeneratedInjector, BaseOpusDetailComponentsFragment_GeneratedInjector, OpusDetailFragment_GeneratedInjector, ContactFragment_GeneratedInjector, CustomerSettingFragment_GeneratedInjector, NotificationPageFragment_GeneratedInjector, PegasusFragment_GeneratedInjector, InterestChooseV31Dialog_GeneratedInjector, InterestChooseV32Dialog_GeneratedInjector, IndexHotFragment_GeneratedInjector, BasePegasusFragment_GeneratedInjector, PlaySetEditorFragmentV2_GeneratedInjector, CollectionSearchResultFragment_GeneratedInjector, BiliEditorTtsFragmentV2_GeneratedInjector, BiliEditorCaptionEditFragmentV3_GeneratedInjector, BiliEditorStickerBatchEditFragmentV3_GeneratedInjector, BiliEditorCaptionAnimationListV4Fragment_GeneratedInjector, BiliEditorCaptionAnimationV4Fragment_GeneratedInjector, BiliEditorCaptionFlowerV4Fragment_GeneratedInjector, BiliEditorCaptionFontV4Fragment_GeneratedInjector, BiliEditorCaptionSettingV4Fragment_GeneratedInjector, BiliEditorCaptionStyleV4Fragment_GeneratedInjector, BiliEditorCaptionTemplateListV4Fragment_GeneratedInjector, BiliEditorCaptionTemplateV4Fragment_GeneratedInjector, BiliEditorClipVolumeFragment_GeneratedInjector, BiliEditorSpeedFragmentV3_GeneratedInjector, BiliEditorChildAdjustFragment_GeneratedInjector, BiliEditorChildFilterFragment_GeneratedInjector, BiliEditorFilterFragmentV4_GeneratedInjector, BiliEditorMusicChangeStartFragmentV5_GeneratedInjector, BiliEditorMusicFadeFragment_GeneratedInjector, BiliEditorMusicLoadingFragment_GeneratedInjector, BiliEditorMusicVolumeFragment_GeneratedInjector, BiliEditorPictureFragmentV3_GeneratedInjector, BiliEditorRecordVoiceFragment_GeneratedInjector, BiliEditorRecordVolumeFragment_GeneratedInjector, BiliMainEditorRecordFragment_GeneratedInjector, BiliEditorStickerListFragment_GeneratedInjector, BiliEditorTransitionFragmentV2_GeneratedInjector, HomeSideCenterSettingFragment_GeneratedInjector, FragmentComponent, DefaultViewModelFactories.FragmentEntryPoint, ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint, GeneratedComponent, Fragment_GripperMapping.GripperFetcher, InnerLoginFragment_GeneratedInjector {

        @Subcomponent.Builder
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        interface Builder extends FragmentComponentBuilder {
        }
    }

    @Module(subcomponents = {FragmentC.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    interface FragmentCBuilderModule {
        @Binds
        FragmentComponentBuilder bind(FragmentC.Builder builder);
    }

    @LiveCardScope
    @Subcomponent(modules = {LiveCard_Gripper.class, Root.LiveCardModule.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class LiveCardC implements LiveCardComponent, GeneratedComponent, LiveCard_Gripper.GripperFetcher {

        @Subcomponent.Builder
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        interface Builder extends LiveCardComponent.Builder {
        }
    }

    @Module(subcomponents = {LiveCardC.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    interface LiveCardCBuilderModule {
        @Binds
        LiveCardComponent.Builder bind(LiveCardC.Builder builder);
    }

    @Subcomponent(modules = {Liveroom.RoomModule.class, Room_Gripper.class, Root.RoomModule.class})
    @RoomScoped
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class RoomC implements RoomComponent, GeneratedComponent, Room_Gripper.GripperFetcher {

        @Subcomponent.Builder
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        interface Builder extends RoomComponent.Builder {
        }
    }

    @Module(subcomponents = {RoomC.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    interface RoomCBuilderModule {
        @Binds
        RoomComponent.Builder bind(RoomC.Builder builder);
    }

    @RoomContainerScoped
    @Subcomponent(modules = {RoomCBuilderModule.class, Liveroom.RoomContainerModule.class, RoomContainer_Gripper.class, Root.RoomContainerModule.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class RoomContainerC implements RoomContainerComponent, GeneratedComponent, RoomContainer_Gripper.GripperFetcher {

        @Subcomponent.Builder
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        interface Builder extends RoomContainerComponent.Builder {
        }
    }

    @Module(subcomponents = {RoomContainerC.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    interface RoomContainerCBuilderModule {
        @Binds
        RoomContainerComponent.Builder bind(RoomContainerC.Builder builder);
    }

    @Subcomponent(modules = {Root.ServiceModule.class, Service_GripperMapping.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class ServiceC implements ServiceComponent, GeneratedComponent, Service_GripperMapping.GripperFetcher {

        @Subcomponent.Builder
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        interface Builder extends ServiceComponentBuilder {
        }
    }

    @Module(subcomponents = {ServiceC.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    interface ServiceCBuilderModule {
        @Binds
        ServiceComponentBuilder bind(ServiceC.Builder builder);
    }

    @Component(modules = {Account.SingletonModule.class, AdHolderModule.class, Adbiz.SingletonModule.class, Adcore.SingletonModule.class, AddCustomSplashModule.class, AddWidgetModule.class, Adreward.SingletonModule.class, AndroidGalleryImageAssetModule.class, AndroidLegacyRouterModule.class, Apm.SingletonModule.class, AppDirectoryModule.class, ApplicationContextModule.class, AssetUploaderModule.class, AssistantChatPageModule.class, AssistantSessionConverterModule.class, AvatarChooserModule.class, AvatarUploaderModule.class, BootstrapModule0.class, BootstrapModule1.class, Bpay.SingletonModule.class, ChargeEventFlowModule.class, ChatDatabaseConfigModule.class, ClipboardModule.class, ComposableAsPageModule.class, ComposeContainerStyleModule.class, CoreReport.SingletonModule.class, DSHistoryModule.class, DeepSearchModule.class, DeepSearchParagraphModule.class, DefaultModule.class, DefaultSessionObserverModule.class, Devicedecision.SingletonModule.class, DigitalSaveModule.class, Downloader.SingletonModule.class, EmoticonPanelModule.class, EmptyAssetCompressorHolderModule.class, EmptyAssetFinderHolderModule.class, EmptyAssetShowerHolderModule.class, EmptyCommunityStateHelperModule.class, EmptyIdModule.class, EmptyModelModule.class, EmptyTrackerModelModule.class, ExpandableParagraphModule.class, Facialrecognitiontribetenc.SingletonModule.class, FallbackCacheModule.class, GameComposableAsPageModule.class, GameComposeContainerStyleModule.class, GameKntrModule.class, GlobalRouterModule.class, GripperDynamicRuleModule.class, GrowthModule.class, ActivityRetainedCBuilderModule.class, BRouterCBuilderModule.class, LiveCardCBuilderModule.class, RoomContainerCBuilderModule.class, ServiceCBuilderModule.class, HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule.class, HolderInfoModule.class, HuahuoModule.class, IMConfigSettingModule.class, IMConfigSettingProviderModule.class, IMContactModule.class, IMGameButtonModule.class, IMSessionDraftServiceModule.class, IMSessionModule.class, IMUIModule.class, ImParagraphModule.class, Image.SingletonModule.class, ImageDynamic.SingletonModule.class, InlineVideoComponentModule.class, InstallPageServiceComponent.class, com.bilibili.ship.theseus.playlist.di.page.InstallPageServiceComponent.class, com.mall.videodetail.vd.all.di.InstallPageServiceComponent.class, InterestLogModule.class, KBModule.class, KntrGameBookModule.class, KntrGameDownloaderModule.class, KntrGameFollowModule.class, KntrGamePayModule.class, KntrGameReportModule.class, KntrGameRouterModule.class, KntrGameTeenagerModule.class, Laser.SingletonModule.class, Liveroom.SingletonModule.class, LocalImageAssetAndroidModule.class, LocalImageAssetModule.class, Location.SingletonModule.class, Mod.SingletonModule.class, NetExt.SingletonModule.class, Neuron.SingletonModule.class, OGVTensorFlowServiceModule.class, OgvVideoCardApiServiceModule.class, ParagraphModule.class, Patch.SingletonModule.class, PersonalChatPageModule.class, PersonalSessionConverterModule.class, PreviewAssetModule.class, Push.SingletonModule.class, ReshapingModule.class, Riskcontrol.SingletonModule.class, Root.SingletonModule.class, SessionBadgeNotifierModule.class, SettingModule.class, Share.SingletonModule.class, ShareCardModule.class, Singleton_GripperMapping.class, SmallCoverV2ImagePreloaderModule.class, SmeltCardContentModule.class, StickerAssetAndroidModule.class, StickerAssetModule.class, StickerModule.class, StickerServiceModule.class, TribeeHomeModule.class, TribeeInviteModule.class, TribeeOperationModule.class, TribeeRepostModule.class, TribeeSteamModule.class, Updater.SingletonModule.class, VipNameColorParserModule.class, WallpaperSetting.class, WebAssetModule.class, Webview.SingletonModule.class})
    @Singleton
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class SingletonC implements LiveCardEntryPoint, ChargeEventEntryPoint, ParagraphEntryPoint, GarbObserverEntryPoint, ThemeDayNightObserverEntryPoint, EmoticonPanelEntryPoint, EmoticonCacheEntryPoint, GPushFetcher, GLaserFetcher, SelectedHttpDnsFetcher, GRiskControlFetcher, GUpdaterFetcher, KtorEntryPoint, BRouterComponentEntryPoint, SettingsFetcher, CommunityStateEntryPoint, InlineVideoComponentEntryPoint, FragmentGetContextFix.FragmentGetContextFixEntryPoint, HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint, ServiceComponentManager.ServiceComponentBuilderEntryPoint, SingletonComponent, GeneratedComponent, Singleton_GripperMapping.GripperFetcher, IMTotalUnreadBroadcastPoint, VipNameColorEntryPoint, IMContactEntryPoint, KBEntryPoint, IMProvidedUIEntryPoint, IMSessionEntryPoint, MainPopupCheckerModule, SettingEntryPoint, DeepSearchEntryPoint, DSHistoryEntryPoint, DeepSearchParagraphEntryPoint, AvatarChooserEntryPoint, SmeltCardContentEntryPoint, ReshapeEntryPoint, SaveEntryPoint, SharePoint, AddCustomSplashEntryPoint, UploadAvatarEntryPoint, SetWallpaperEntryPoint, GameRouterEntryPoint, KntrGameBookServiceEntryPoint, KntrGameFollowServiceEntryPoint, KntrGamePayServiceEntryPoint, KntrGameReportServiceEntryPoint, KntrGameTeenagerModeEntryPoint, GameComposeContainerStyleEntryPoint, KntrGameDownloaderEntryPoint, BiligameReporterEntryPoint, AssistantChatEntryPoint, PrivateChatEntryPoint, StickerEntryPoint, ExpandableParagraphEntryPoint, AssistantEntryPoint, PersonalChatEntryPoint, ImParagraphEntryPoint, TribeeHomeEntryPoint, TribeeInviteEntryPoint, TribeeOperationEntryPoint, TribeePublishCreateComponentEntryPoint, TribeePublishEditComponentEntryPoint, kntr.app.tribee.publish.di.create.TribeePublishCreateComponentEntryPoint, kntr.app.tribee.publish.di.edit.TribeePublishEditComponentEntryPoint, TribeeRepostEntryPoint, TribeeSteamEntryPoint, IDownloaderEntryPoint, AccountEntryPoint, AppInfoEntryPoint, PackageInfoEntryPoint, BrotliEntryPoint, ClipboardEntryPoint, DeviceEntryPoint, MossEntryPoint, NeuronEntryPoint, ReachabilityEntryPoint, RouterEntryPoint, UpOSEntryPoint, AppDirEntrypoint, BehaviorPredictionEntryPoint, ComposeContainerStyleEntryPoint, LanguageSettingsEntryPoint, OpusCardComposeViewProviderEntryPoint, AssetUploaderEntryPoint, AphroEntryPoint, AphroStateMachineEntryPoint, AssetEntryPoint, PvReporterEntryPoint, PvTrackerEntryPoint, RestrictedModeEntryPoint, GlobalRouterEntryPoint, GShareEntryPoint, HiltApplication_GeneratedInjector, DolbyReportEntryPoint, FreeBandwidthEntryPoint, MediaHistoryEntryPoint, OGVBridgeEntryPoint, KDownloadSettingsEntryPoint {
    }

    @Subcomponent(modules = {Root.ViewModule.class, View_GripperMapping.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class ViewC implements ViewComponent, GeneratedComponent, View_GripperMapping.GripperFetcher {

        @Subcomponent.Builder
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        interface Builder extends ViewComponentBuilder {
        }
    }

    @Module(subcomponents = {ViewC.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    interface ViewCBuilderModule {
        @Binds
        ViewComponentBuilder bind(ViewC.Builder builder);
    }

    @Subcomponent(modules = {BiliEditorCaptionAnimationListViewModel_HiltModules.BindsModule.class, BiliEditorCaptionAnimationViewModel_HiltModules.BindsModule.class, BiliEditorCaptionEditViewModel_HiltModules.BindsModule.class, BiliEditorCaptionFlowerViewModel_HiltModules.BindsModule.class, BiliEditorCaptionFontViewModel_HiltModules.BindsModule.class, BiliEditorCaptionSettingViewModel_HiltModules.BindsModule.class, BiliEditorCaptionStyleViewModel_HiltModules.BindsModule.class, BiliEditorCaptionTemplateListViewModel_HiltModules.BindsModule.class, BiliEditorCaptionTtsViewModel_HiltModules.BindsModule.class, BiliEditorChildAdjustViewModel_HiltModules.BindsModule.class, BiliEditorChildFilterViewModel_HiltModules.BindsModule.class, BiliEditorFilterViewModel_HiltModules.BindsModule.class, BiliEditorMainViewModel_HiltModules.BindsModule.class, BiliEditorMusicChangeStartViewModel_HiltModules.BindsModule.class, BiliEditorMusicFadeViewModel_HiltModules.BindsModule.class, BiliEditorMusicLoadingViewModel_HiltModules.BindsModule.class, BiliEditorMusicVolumeViewModel_HiltModules.BindsModule.class, BiliEditorPictureViewModel_HiltModules.BindsModule.class, BiliEditorSpeedViewModel_HiltModules.BindsModule.class, BiliEditorStickerBatchEditViewModel_HiltModules.BindsModule.class, BiliEditorStickerListViewModel_HiltModules.BindsModule.class, BiliEditorTransitionViewModel_HiltModules.BindsModule.class, BiliEditorVolumeViewModel_HiltModules.BindsModule.class, CollectionSearchModule.class, CollectionSearchViewModel_HiltModules.BindsModule.class, CustomerConversationViewModel_HiltModules.BindsModule.class, CustomerModule.class, CustomerSettingViewModel_HiltModules.BindsModule.class, EditorArchivesUploadObserverModule.class, EditorRecordViewModel_HiltModules.BindsModule.class, EditorRecordVoiceViewModel_HiltModules.BindsModule.class, EditorRecordVolumeViewModel_HiltModules.BindsModule.class, FullscreenLoginViewModel_HiltModules.BindsModule.class, HiltWrapper_HiltViewModelFactory_ViewModelModule.class, HomeSideCenterModule.class, HomeSideCenterSettingViewModel_HiltModules.BindsModule.class, InnerLoginViewModel_HiltModules.BindsModule.class, InterestChooseV31PageViewModel_HiltModules.BindsModule.class, InterestChooseV32PageViewModel_HiltModules.BindsModule.class, MangaPopupViewModel_HiltModules.BindsModule.class, NotificationModule.class, NotificationViewModel_HiltModules.BindsModule.class, PegasusViewModel_HiltModules.BindsModule.class, PlaySetEditorViewModel_HiltModules.BindsModule.class, ReducerModules.class, Root.ViewModelModule.class, ServiceProvider.class, tv.danmaku.bili.fullscreen.service.ServiceProvider.class, StepByStepLoginViewModel_HiltModules.BindsModule.class, UseCaseModule.class, ViewModelModule.class, ViewModel_GripperMapping.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class ViewModelC implements ViewModelComponent, HiltViewModelFactory.ViewModelFactoriesEntryPoint, GeneratedComponent, ViewModel_GripperMapping.GripperFetcher {

        @Subcomponent.Builder
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        interface Builder extends ViewModelComponentBuilder {
        }
    }

    @Module(subcomponents = {ViewModelC.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    interface ViewModelCBuilderModule {
        @Binds
        ViewModelComponentBuilder bind(ViewModelC.Builder builder);
    }

    @Subcomponent(modules = {Root.ViewWithFragmentModule.class, ViewWithFragment_GripperMapping.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class ViewWithFragmentC implements ViewWithFragmentComponent, GeneratedComponent, ViewWithFragment_GripperMapping.GripperFetcher {

        @Subcomponent.Builder
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        interface Builder extends ViewWithFragmentComponentBuilder {
        }
    }

    @Module(subcomponents = {ViewWithFragmentC.class})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    interface ViewWithFragmentCBuilderModule {
        @Binds
        ViewWithFragmentComponentBuilder bind(ViewWithFragmentC.Builder builder);
    }

    private HiltApplication_HiltComponents() {
    }
}