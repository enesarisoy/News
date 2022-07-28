package com.ns.mvvmnews.mvvmnews.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.ns.mvvmnews.R
import com.ns.mvvmnews.databinding.ActivityNewsBinding
import com.ns.mvvmnews.mvvmnews.data.ArticleDatabase
import com.ns.mvvmnews.mvvmnews.repository.NewsRepository

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]

        binding = ActivityNewsBinding.inflate(layoutInflater)


        setContentView(binding.root)

        binding.bottomNavigationView.setupWithNavController(
            Navigation.findNavController(
                this,
                R.id.newsNavHostFragment
            )
        )


    }
}