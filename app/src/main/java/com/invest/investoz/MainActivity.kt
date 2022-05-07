package com.invest.investoz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.invest.investoz.home.AboutUsFragment
import com.invest.investoz.home.HomeFragment
import com.invest.investoz.home.InvestmentsFragment
import com.invest.investoz.home.PendingInvestmentFragment
import com.invest.investoz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val investmentFragment = InvestmentsFragment()
        val pendingInvestmentFragment = PendingInvestmentFragment()
        val aboutUsFragment = AboutUsFragment()

        setCurrentFragment(homeFragment)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(homeFragment)
                R.id.investments->setCurrentFragment(investmentFragment)
                R.id.pending->setCurrentFragment(pendingInvestmentFragment)
                R.id.about_us->setCurrentFragment(aboutUsFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,fragment)
            commit()
        }

}