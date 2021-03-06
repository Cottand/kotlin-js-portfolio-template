package util

import com.ccfraser.muirwik.components.styles.Spacing
import com.ccfraser.muirwik.components.styles.Theme
import com.ccfraser.muirwik.components.themeContext
import kotlinx.css.Image
import kotlinx.css.px
import react.FunctionalComponent
import react.RBuilder
import react.RProps
import react.functionalComponent
import kotlin.properties.ReadOnlyProperty

fun Image.Companion.path(str: String) = Image("url($str)")

fun <P : RProps> component(builder: RBuilder.(P) -> Unit) =
    ReadOnlyProperty<Any?, FunctionalComponent<P>> { _, property ->
        functionalComponent(displayName = property.name, builder)
    }

fun RBuilder.withTheme(block: Theme.() -> Unit) {
    themeContext.Consumer { theme -> theme.block() }
}

operator fun Spacing.times(i: Int) = invoke(i).px
operator fun Int.times(spacing: Spacing) = spacing.invoke(this).px
