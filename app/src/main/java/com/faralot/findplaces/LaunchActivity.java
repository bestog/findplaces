package com.faralot.findplaces;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.view.Menu;

import com.faralot.core.App;
import com.faralot.core.ui.activities.LoginActivity;

public class LaunchActivity extends Activity {

  // Eigene Einstellungen - nur hier etwas aendern!!
  private void settings() {
    App app = (App) this.getApplication();
    // Rest-Client konfigurieren
    app.setRest("findplaces");
  }

  /**
   * Applikation starten
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    settings();
    startActivity(new Intent(this, LoginActivity.class)
        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    finish();
  }

  /**
   * Android kann nicht ueber 65k Funktionen handlen, diese Methode verhindert, dass das
   * Kompilieren abgebrochen wird.
   */
  @Override
  protected final void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    MultiDex.install(this);
  }

  /**
   * Menu erstellen
   *
   * @param menu Menu
   * @return boolean
   */
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    return true;
  }

}
