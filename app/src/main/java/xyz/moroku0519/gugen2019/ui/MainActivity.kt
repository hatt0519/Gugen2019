package xyz.moroku0519.gugen2019.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import xyz.moroku0519.gugen2019.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewModelProviders.of(this).get(PlantStatusViewModelImpl::class.java)
    }
}
