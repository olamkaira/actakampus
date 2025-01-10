package com.example.actakampus;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private static final int NOTIFICATION_PERMISSION_CODE = 123;
    private static final String PREF_NIGHT_MODE = "night_mode";
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Tema ayarını yükle
        preferences = getPreferences(MODE_PRIVATE);
        int nightMode = preferences.getInt(PREF_NIGHT_MODE, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        AppCompatDelegate.setDefaultNightMode(nightMode);
        
        super.onCreate(savedInstanceState);
        
        // Edge-to-edge için
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        
        setContentView(R.layout.activity_main);

        // Toolbar ayarları
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        // Bildirim kanalını oluştur
        NotificationHelper.createNotificationChannel(this);
        
        // Bildirim izni kontrolü
        checkNotificationPermission();

        // Alt navigasyon ayarları
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            
            if (itemId == R.id.navigation_home) {
                loadFragment(new HomeFragment(), false);
                return true;
            } else if (itemId == R.id.navigation_categories) {
                loadFragment(new CategoriesFragment(), true);
                return true;
            } else if (itemId == R.id.navigation_calendar) {
                loadFragment(new CalendarFragment(), true);
                return true;
            } else if (itemId == R.id.navigation_important) {
                loadFragment(new ImportantDatesFragment(), true);
                return true;
            } else if (itemId == R.id.navigation_food_menu) {
                loadFragment(new FoodMenuFragment(), true);
                return true;
            }
            return false;
        });

        // Kaydedilmiş seçili fragment'ı yükle
        int selectedItemId = preferences.getInt("selected_item_id", R.id.navigation_home);
        bottomNavigationView.setSelectedItemId(selectedItemId);

        // Edge-to-edge tasarım için
        setupEdgeToEdge();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        updateThemeIcon(menu.findItem(R.id.action_theme));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_theme) {
            toggleTheme(item);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggleTheme(MenuItem item) {
        int currentNightMode = AppCompatDelegate.getDefaultNightMode();
        int newNightMode;
        
        if (currentNightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            newNightMode = AppCompatDelegate.MODE_NIGHT_NO;
        } else {
            newNightMode = AppCompatDelegate.MODE_NIGHT_YES;
        }
        
        // Tema ayarını kaydet
        preferences.edit().putInt(PREF_NIGHT_MODE, newNightMode).apply();
        
        // Mevcut seçili fragment'ı kaydet
        preferences.edit().putInt("selected_item_id", bottomNavigationView.getSelectedItemId()).apply();
        
        // Temayı uygula ve activity'yi yeniden başlat
        AppCompatDelegate.setDefaultNightMode(newNightMode);
        recreate();
    }

    private void updateThemeIcon(MenuItem item) {
        if (item != null) {
            int currentNightMode = AppCompatDelegate.getDefaultNightMode();
            item.setIcon(currentNightMode == AppCompatDelegate.MODE_NIGHT_YES ? 
                R.drawable.ic_light_mode : R.drawable.ic_dark_mode);
        }
    }

    private void loadFragment(Fragment fragment, boolean animate) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        
        if (animate) {
            transaction.setCustomAnimations(
                android.R.anim.fade_in,
                android.R.anim.fade_out,
                android.R.anim.fade_in,
                android.R.anim.fade_out
            );
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        }
        
        transaction.replace(R.id.frame_container, fragment);
        transaction.setReorderingAllowed(true);
        transaction.commitNow();
    }

    private void checkNotificationPermission() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.POST_NOTIFICATIONS},
                        NOTIFICATION_PERMISSION_CODE);
            }
        }
    }

    private void sendSampleNotification() {
        NotificationHelper.showNotification(
            this,
            "Yeni Duyuru",
            "Amasya Üniversitesi'nden yeni duyuruları kaçırmamak için bildirimleri açık tutun!",
            "Genel"
        );
    }

    private void setupEdgeToEdge() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, windowInsets) -> {
            int bottom = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
            bottomNavigationView.setPadding(0, 0, 0, bottom);
            return windowInsets;
        });
    }

    private Fragment loadFragment(int itemId) {
        Fragment fragment = null;
        if (itemId == R.id.navigation_home) {
            fragment = new HomeFragment();
        } else if (itemId == R.id.navigation_categories) {
            fragment = new CategoriesFragment();
        } else if (itemId == R.id.navigation_calendar) {
            fragment = new CalendarFragment();
        } else if (itemId == R.id.navigation_important) {
            fragment = new ImportantDatesFragment();
        } else if (itemId == R.id.navigation_food_menu) {
            fragment = new FoodMenuFragment();
        }
        
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .commit();
        }
        
        return fragment;
    }
}