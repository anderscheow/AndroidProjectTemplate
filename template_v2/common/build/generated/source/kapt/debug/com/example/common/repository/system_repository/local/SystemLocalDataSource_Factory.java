// Generated by Dagger (https://dagger.dev).
package com.example.common.repository.system_repository.local;

import com.example.lib_data_source.preference.IAppSharedPreference;
import com.example.lib_data_source.room.AppDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SystemLocalDataSource_Factory implements Factory<SystemLocalDataSource> {
  private final Provider<AppDatabase> appDatabaseProvider;

  private final Provider<IAppSharedPreference> sharedPreferenceProvider;

  public SystemLocalDataSource_Factory(Provider<AppDatabase> appDatabaseProvider,
      Provider<IAppSharedPreference> sharedPreferenceProvider) {
    this.appDatabaseProvider = appDatabaseProvider;
    this.sharedPreferenceProvider = sharedPreferenceProvider;
  }

  @Override
  public SystemLocalDataSource get() {
    return newInstance(appDatabaseProvider.get(), sharedPreferenceProvider.get());
  }

  public static SystemLocalDataSource_Factory create(Provider<AppDatabase> appDatabaseProvider,
      Provider<IAppSharedPreference> sharedPreferenceProvider) {
    return new SystemLocalDataSource_Factory(appDatabaseProvider, sharedPreferenceProvider);
  }

  public static SystemLocalDataSource newInstance(AppDatabase appDatabase,
      IAppSharedPreference sharedPreference) {
    return new SystemLocalDataSource(appDatabase, sharedPreference);
  }
}