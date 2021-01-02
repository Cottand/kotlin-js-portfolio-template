package components

import com.ccfraser.muirwik.components.MTypographyAlign.center
import com.ccfraser.muirwik.components.MTypographyVariant.body1
import com.ccfraser.muirwik.components.MTypographyVariant.body2
import com.ccfraser.muirwik.components.mContainer
import com.ccfraser.muirwik.components.mCssBaseline
import com.ccfraser.muirwik.components.mLink
import com.ccfraser.muirwik.components.mTypography
import com.ccfraser.muirwik.components.themeContext
import kotlinx.css.Color
import kotlinx.css.Display.flex
import kotlinx.css.FlexDirection.column
import kotlinx.css.LinearDimension
import kotlinx.css.backgroundColor
import kotlinx.css.display
import kotlinx.css.flexDirection
import kotlinx.css.marginTop
import kotlinx.css.minHeight
import kotlinx.css.vh
import react.RProps
import styled.StyleSheet
import styled.css
import util.component

val footer by component<RProps> {
    mCssBaseline()
    mContainer {
        css {
            themeContext.Consumer { theme ->
                backgroundColor = Color(theme.palette.background.paper)
                console.log("palette is ${theme.palette.type}")
            }
            marginTop = LinearDimension.auto
        }
        mTypography("This website was made with Kotlin/JS + React", align = center, gutterBottom = true, variant = body1)
        mTypography("You can find the repo ", align = center, variant = body2) {
            mLink("here", hRef = "https://github.com/Cottand/kotlin-js-portfolio-template/")
        }
    }
}

object FooterStyles : StyleSheet("Footer") {
    val root by css {
        display = flex
        flexDirection = column
        minHeight = 100.vh
    }
}
