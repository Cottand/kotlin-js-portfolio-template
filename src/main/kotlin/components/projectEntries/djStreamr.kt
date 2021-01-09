package components.projectEntries

import com.ccfraser.muirwik.components.spacingUnits
import components.imgWithCaption
import external.markdown
import kotlinx.css.LinearDimension
import kotlinx.css.height
import kotlinx.css.pct
import kotlinx.css.px
import kotlinx.css.width
import react.RBuilder
import react.dom.a
import react.dom.br
import react.dom.div
import styled.css
import styled.styledImg

fun RBuilder.djStreamrEntry() {
    div {
        a(href = "https://djstreamr.com") {
            styledImg(src = "/djstreamrLogoWhite.png") {
                css {
                    height = 6.spacingUnits
                    width = LinearDimension.auto
                }
            }
        }
    }
    br {}
    markdown {
        "DJStreamr"["https://djstreamr.com"]
        +" is a collaborative platform for simultaneous, real-time DJing."
        +"""|The frontend uses **VueJS** and is written in **Kotlin/JS** and **Typescript**, while 
            |the backend is fully written in **Kotlin/JVM** and is distributed between **AWS Lambda** 
            |functions and a server.""".trimMargin()
    }
    imgWithCaption("/djstreamrScreenshot.png", "DJStreamr's online interface") {
        width = min(90.pct, 920.px)
    }
    markdown {
        +"""|DJStreamr abstracts away latency between to simultaneous performers by using the 
            |metadata from audio files and the commands DJs emit to a central server. This allows for a
            |seamless experience for the audience. We hook the performance to popular streaming
            |platforms like Twitch or YouTube for ease of use.
            |""".trimMargin()
    }
}