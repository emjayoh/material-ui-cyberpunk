package me.xdrop.nightowl.settings.form

import me.xdrop.nightowl.NightOwlAppearance
import me.xdrop.nightowl.settings.NightOwlSettings
import javax.swing.JButton
import javax.swing.JCheckBox
import javax.swing.JComponent
import javax.swing.JPanel

class NightOwlSettingsForm {
    private var rootPanel: JPanel? = null
    private var isAppearanceSettingsEnabledCheckBox: JCheckBox? = null
    private var isOverrideRainbowBracketsCheckBox: JCheckBox? = null
    private var setNow: JButton? = null
    private var setIndent: JButton? = null
    private var setBreadcrumbs: JButton? = null
    private var setStatus: JButton? = null
    private var setToolbar: JButton? = null
    private var setFolding: JButton? = null
    private var setNavigation: JButton? = null
    private var setVCS: JButton? = null
    private var setBack: JButton? = null

    private val settings: NightOwlSettings = NightOwlSettings.instance

    init {
        setNow?.addActionListener { NightOwlAppearance.applyIdeSettings() }
        setIndent?.addActionListener { NightOwlAppearance.resetIndentGuides() }
        setBreadcrumbs?.addActionListener { NightOwlAppearance.resetBreadcrumbs() }
        setStatus?.addActionListener { NightOwlAppearance.resetStatusBar() }
        setToolbar?.addActionListener { NightOwlAppearance.resetMainToolbar() }
        setNavigation?.addActionListener { NightOwlAppearance.resetNavBar() }
        setVCS?.addActionListener { NightOwlAppearance.resetVCS() }
        setFolding?.addActionListener { NightOwlAppearance.resetFoldingOutline() }
        setBack?.addActionListener { NightOwlAppearance.resetIdeSettings() }
        reset()
    }

    fun component(): JComponent? = rootPanel

    fun reset() {
        isAppearanceSettingsEnabledCheckBox?.isSelected = settings.isAppearanceSettingsEnabled
        isOverrideRainbowBracketsCheckBox?.isSelected = settings.isOverrideRainbowBrackets
    }

    val isAppearanceSettingsEnabled
        get() = isAppearanceSettingsEnabledCheckBox?.isSelected

    val isOverrideRainbowBrackets
        get() = isOverrideRainbowBracketsCheckBox?.isSelected

    val isModified: Boolean
        get() = isAppearanceSettingsEnabled != settings.isAppearanceSettingsEnabled
                || isOverrideRainbowBrackets != settings.isOverrideRainbowBrackets
}
