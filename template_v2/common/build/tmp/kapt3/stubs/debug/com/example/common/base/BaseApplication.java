package com.example.common.base;

import android.app.Application;
import androidx.work.WorkManager;
import com.alibaba.android.arouter.launcher.ARouter;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.example.common.BuildConfig;
import dagger.Lazy;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/example/common/base/BaseApplication;", "Landroid/app/Application;", "()V", "workManager", "Ldagger/Lazy;", "Landroidx/work/WorkManager;", "getWorkManager", "()Ldagger/Lazy;", "setWorkManager", "(Ldagger/Lazy;)V", "initLogger", "", "initRouter", "onCreate", "onTerminate", "pruneWorkManagerRequest", "common_debug"})
public abstract class BaseApplication extends android.app.Application {
    @javax.inject.Inject()
    public dagger.Lazy<androidx.work.WorkManager> workManager;
    
    public BaseApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dagger.Lazy<androidx.work.WorkManager> getWorkManager() {
        return null;
    }
    
    public final void setWorkManager(@org.jetbrains.annotations.NotNull()
    dagger.Lazy<androidx.work.WorkManager> p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public void onTerminate() {
    }
    
    private final void initRouter() {
    }
    
    private final void initLogger() {
    }
    
    private final void pruneWorkManagerRequest() {
    }
}