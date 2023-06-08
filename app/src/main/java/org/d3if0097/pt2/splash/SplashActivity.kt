package org.d3if0097.pt2.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0097.pt2.BerandaActivity
import org.d3if0097.pt2.MainActivity
import org.d3if0097.pt2.databinding.ActivitySplashBinding
import org.d3if0097.pt2.network.ApiClient

class SplashActivity : AppCompatActivity() {


private val binding : ActivitySplashBinding by lazy {
    ActivitySplashBinding.inflate(layoutInflater)
}

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)
    setupStatusBar()
    moveMainActivity()
    CoroutineScope(Dispatchers.Main).launch {
        startService(Intent(this@SplashActivity, MainActivity::class.java))
    }
}
    private fun setupStatusBar() {
        with(window) {
            setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }

    private fun moveMainActivity() {
        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, BerandaActivity::class.java))
            finish()
        }, 3000)
    }
}