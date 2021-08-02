package com.example.common.repository.auth_repository.local;

import com.example.lib_data_source.model.AuthModel;
import com.example.lib_data_source.preference.IAppSharedPreference;
import com.example.lib_data_source.preference.SPKey;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/common/repository/auth_repository/local/AuthLocalDataSource;", "", "sharedPreference", "Lcom/example/lib_data_source/preference/IAppSharedPreference;", "(Lcom/example/lib_data_source/preference/IAppSharedPreference;)V", "clearAuthModel", "", "getAuthModel", "Lcom/example/lib_data_source/model/AuthModel;", "saveAuthModel", "authModel", "common_debug"})
public final class AuthLocalDataSource {
    private final com.example.lib_data_source.preference.IAppSharedPreference sharedPreference = null;
    
    @javax.inject.Inject()
    public AuthLocalDataSource(@org.jetbrains.annotations.NotNull()
    com.example.lib_data_source.preference.IAppSharedPreference sharedPreference) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.lib_data_source.model.AuthModel getAuthModel() {
        return null;
    }
    
    public final void saveAuthModel(@org.jetbrains.annotations.NotNull()
    com.example.lib_data_source.model.AuthModel authModel) {
    }
    
    public final void clearAuthModel() {
    }
}