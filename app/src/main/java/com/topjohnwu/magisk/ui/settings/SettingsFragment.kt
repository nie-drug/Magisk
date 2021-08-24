package com.topjohnwu.magisk.ui.settings

import android.os.Bundle
import android.view.View
import com.topjohnwu.magisk.R
import com.topjohnwu.magisk.arch.BaseUIFragment
import com.topjohnwu.magisk.databinding.FragmentSettingsMd2Binding
import com.topjohnwu.magisk.di.viewModel
import com.topjohnwu.magisk.ktx.addSimpleItemDecoration
import com.topjohnwu.magisk.ktx.addVerticalPadding
import com.topjohnwu.magisk.ktx.fixEdgeEffect
import com.topjohnwu.magisk.ktx.setOnViewReadyListener

class SettingsFragment : BaseUIFragment<SettingsViewModel, FragmentSettingsMd2Binding>() {

    override val layoutRes = R.layout.fragment_settings_md2
    override val viewModel by viewModel<SettingsViewModel>()
    fun navigateUp() {
        navController.navigateUp()
    }
    val navController: NavController
        get() = NavHostFragment.findNavController(this)
    override fun onStart() {
        super.onStart()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity.setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        binding.toolbar.setNavigationIcon(R.drawable.quantum_gm_ic_arrow_back_vd_theme_24)
        binding.toolbar.setTitle(R.string.settings)
        binding.settingsList.setOnViewReadyListener {
            binding.settingsList.scrollToPosition(0)
        }
        binding.settingsList.fixEdgeEffect()
    }
    override fun onResume() {
        super.onResume()
        viewModel.items.forEach { it.refresh() }
    }

}
