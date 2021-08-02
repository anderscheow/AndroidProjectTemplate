// Generated by Dagger (https://dagger.dev).
package com.example.common.repository.system_repository.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SystemRemoteDataSource_Factory implements Factory<SystemRemoteDataSource> {
  private final Provider<SystemApi> systemApiProvider;

  public SystemRemoteDataSource_Factory(Provider<SystemApi> systemApiProvider) {
    this.systemApiProvider = systemApiProvider;
  }

  @Override
  public SystemRemoteDataSource get() {
    return newInstance(systemApiProvider.get());
  }

  public static SystemRemoteDataSource_Factory create(Provider<SystemApi> systemApiProvider) {
    return new SystemRemoteDataSource_Factory(systemApiProvider);
  }

  public static SystemRemoteDataSource newInstance(SystemApi systemApi) {
    return new SystemRemoteDataSource(systemApi);
  }
}
